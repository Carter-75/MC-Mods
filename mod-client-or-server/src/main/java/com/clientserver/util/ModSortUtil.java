package com.clientserver.util;

import com.clientserver.ModClientOrServer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModEnvironment;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fabricmc.loader.api.metadata.ModOrigin;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Groups installed mods by environment and exports each category as a zip archive.
 */
public final class ModSortUtil {

    private ModSortUtil() {
    }

    private static final DateTimeFormatter FILE_TIMESTAMP = DateTimeFormatter
        .ofPattern("yyyyMMdd-HHmmss")
        .withZone(ZoneId.systemDefault());
    private static final String OUTPUT_DIRECTORY_NAME = "mod-client-or-server";

    public enum SideCategory {
        CLIENT_ONLY("client"),
        SERVER_ONLY("server"),
        UNIVERSAL("both");

        private final String fileSegment;

        SideCategory(String fileSegment) {
            this.fileSegment = fileSegment;
        }

        public String fileSegment() {
            return fileSegment;
        }
    }

    public record ModDescriptor(String id, String name, String version, Path sourcePath, SideCategory category) {
        public String displayName() {
            Path fileName = sourcePath.getFileName();
            if (fileName != null) {
                String value = fileName.toString();
                if (!value.isBlank()) {
                    return value;
                }
            }
            return id;
        }
    }

    public record SortResult(Map<SideCategory, List<ModDescriptor>> modsByCategory,
                             Map<SideCategory, Path> zipPaths,
                             Path outputDirectory,
                             Instant timestamp,
                             List<SkippedMod> skippedMods,
                             Path leftoverZip,
                             List<Path> leftoverPaths) {
        public int totalMods() {
            return modsByCategory.values().stream().mapToInt(List::size).sum();
        }

        public int count(SideCategory category) {
            return modsByCategory.getOrDefault(category, List.of()).size();
        }

        public int leftoverCount() {
            return leftoverPaths != null ? leftoverPaths.size() : 0;
        }
    }

    public static SortResult sortModsIntoZips() throws IOException {
        FabricLoader loader = FabricLoader.getInstance();
        Path modsDir = loader.getGameDir().resolve("mods").normalize();
        if (!Files.isDirectory(modsDir)) {
            throw new IOException("Mods directory not found: " + modsDir);
        }
        modsDir = canonicalPath(modsDir);

        CollectionResult collection = collectModDescriptors(loader, modsDir);
        Map<SideCategory, List<ModDescriptor>> grouped = groupByCategory(collection.descriptors());
        Path outputDir = prepareOutputDirectory(modsDir);
        Instant now = Instant.now();

        Map<SideCategory, Path> zipPaths = new EnumMap<>(SideCategory.class);
        for (SideCategory category : SideCategory.values()) {
            Path base = outputDir.resolve(category.fileSegment() + "-mods-" + FILE_TIMESTAMP.format(now) + ".zip");
            Path target = ensureUnique(base);
            writeZip(target, grouped.getOrDefault(category, List.of()));
            zipPaths.put(category, target);
        }

        LeftoverResult leftovers = computeLeftovers(modsDir, collection.descriptors(), outputDir, now);

        Map<SideCategory, List<ModDescriptor>> immutableGrouped = new EnumMap<>(SideCategory.class);
        for (Map.Entry<SideCategory, List<ModDescriptor>> entry : grouped.entrySet()) {
            immutableGrouped.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }

        return new SortResult(
            Collections.unmodifiableMap(immutableGrouped),
            Collections.unmodifiableMap(zipPaths),
            outputDir,
            now,
            List.copyOf(collection.skippedMods()),
            leftovers.zipPath(),
            List.copyOf(leftovers.leftoverPaths())
        );
    }

    private static CollectionResult collectModDescriptors(FabricLoader loader, Path modsDir) {
        List<ModDescriptor> descriptors = new ArrayList<>();
        List<SkippedMod> skippedMods = new ArrayList<>();
        for (ModContainer container : loader.getAllMods()) {
            ModMetadata metadata = container.getMetadata();
            if (ModClientOrServer.MOD_ID.equals(metadata.getId())) {
                continue; // Skip this mod
            }

            Optional<Path> origin = resolveOriginPaths(container, skippedMods).stream()
                .map(ModSortUtil::canonicalPath)
                .filter(path -> isInsideModsDirectory(path, modsDir))
                .findFirst();

            if (origin.isEmpty()) {
                continue; // Built-in or outside mods directory
            }

            Path sourcePath = origin.get();
            if (!Files.exists(sourcePath)) {
                continue;
            }

            SideCategory category = mapEnvironment(metadata.getEnvironment());
            String name = metadata.getName();
            if (name == null || name.isBlank()) {
                name = metadata.getId();
            }

            descriptors.add(new ModDescriptor(
                metadata.getId(),
                name,
                metadata.getVersion().getFriendlyString(),
                sourcePath,
                category
            ));
        }

        descriptors.sort((a, b) -> a.id().compareToIgnoreCase(b.id()));
        return new CollectionResult(List.copyOf(descriptors), List.copyOf(skippedMods));
    }

    private static SideCategory mapEnvironment(ModEnvironment environment) {
        if (environment == null) {
            return SideCategory.UNIVERSAL;
        }
        if (environment == ModEnvironment.CLIENT) {
            return SideCategory.CLIENT_ONLY;
        }
        if (environment == ModEnvironment.SERVER) {
            return SideCategory.SERVER_ONLY;
        }
        return SideCategory.UNIVERSAL;
    }

    private static Map<SideCategory, List<ModDescriptor>> groupByCategory(List<ModDescriptor> descriptors) {
        Map<SideCategory, List<ModDescriptor>> map = new EnumMap<>(SideCategory.class);
        for (SideCategory category : SideCategory.values()) {
            map.put(category, new ArrayList<>());
        }
        for (ModDescriptor descriptor : descriptors) {
            map.get(descriptor.category()).add(descriptor);
        }
        return map;
    }

    private static List<Path> listTopLevelModEntries(Path modsDir) throws IOException {
        List<Path> entries = new ArrayList<>();
        try (Stream<Path> stream = Files.list(modsDir)) {
            stream.forEach(path -> {
                Path fileName = path.getFileName();
                String name = fileName != null ? fileName.toString() : path.toString();
                if (name.equals(OUTPUT_DIRECTORY_NAME)) {
                    return;
                }
                if (name.contains(ModClientOrServer.MOD_ID) && name.endsWith(".jar")) {
                    return;
                }
                if (Files.isDirectory(path) || name.endsWith(".jar")) {
                    entries.add(path);
                }
            });
        }
        return entries;
    }

    private static LeftoverResult computeLeftovers(Path modsDir, List<ModDescriptor> descriptors, Path outputDir, Instant timestamp) throws IOException {
        List<Path> allEntries = listTopLevelModEntries(modsDir);
        Map<Path, Path> canonicalToOriginal = new HashMap<>();
        for (Path entry : allEntries) {
            Path canonical = canonicalPath(entry);
            canonicalToOriginal.putIfAbsent(canonical, entry);
        }

        Set<Path> assigned = descriptors.stream()
            .map(ModDescriptor::sourcePath)
            .map(ModSortUtil::canonicalPath)
            .collect(Collectors.toCollection(HashSet::new));

        List<Path> leftovers = new ArrayList<>();
        for (Map.Entry<Path, Path> entry : canonicalToOriginal.entrySet()) {
            if (!assigned.contains(entry.getKey())) {
                leftovers.add(entry.getValue());
            }
        }

        Path zipPath = null;
        if (!leftovers.isEmpty()) {
            Path base = outputDir.resolve("unassigned-mods-" + FILE_TIMESTAMP.format(timestamp) + ".zip");
            Path target = ensureUnique(base);
            writeZipFromPaths(target, leftovers);
            zipPath = target;
        }

        return new LeftoverResult(zipPath, List.copyOf(leftovers));
    }

    private static Path prepareOutputDirectory(Path modsDir) throws IOException {
        Path outputDir = modsDir.resolve(OUTPUT_DIRECTORY_NAME);
        if (Files.exists(outputDir)) {
            try (Stream<Path> stream = Files.walk(outputDir)) {
                stream.sorted(Comparator.reverseOrder())
                    .filter(path -> !path.equals(outputDir))
                    .forEach(path -> {
                        try {
                            Files.deleteIfExists(path);
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
            } catch (UncheckedIOException e) {
                throw e.getCause();
            }
        }
        Files.createDirectories(outputDir);
        return outputDir;
    }

    private static Path ensureUnique(Path base) throws IOException {
        Path candidate = base;
        int index = 1;
        while (Files.exists(candidate)) {
            String fileName = base.getFileName().toString();
            int dot = fileName.lastIndexOf('.');
            String prefix = dot >= 0 ? fileName.substring(0, dot) : fileName;
            String suffix = dot >= 0 ? fileName.substring(dot) : "";
            candidate = base.getParent().resolve(prefix + "-" + index + suffix);
            index++;
        }
        return candidate;
    }

    private static void writeZip(Path zipPath, List<ModDescriptor> descriptors) throws IOException {
        try (ZipOutputStream zipOutput = new ZipOutputStream(Files.newOutputStream(zipPath))) {
            byte[] buffer = new byte[8192];
            for (ModDescriptor descriptor : descriptors) {
                addPathToZip(descriptor.sourcePath(), descriptor.sourcePath().getFileName().toString(), zipOutput, buffer);
            }
        }
    }

    private static void writeZipFromPaths(Path zipPath, List<Path> sources) throws IOException {
        try (ZipOutputStream zipOutput = new ZipOutputStream(Files.newOutputStream(zipPath))) {
            byte[] buffer = new byte[8192];
            for (Path source : sources) {
                String baseName = source.getFileName() != null ? source.getFileName().toString() : source.toString();
                addPathToZip(source, baseName, zipOutput, buffer);
            }
        }
    }

    private static void addPathToZip(Path inputPath, String baseEntryName, ZipOutputStream zipOutput, byte[] buffer) throws IOException {
        if (Files.isDirectory(inputPath)) {
            try (Stream<Path> stream = Files.walk(inputPath)) {
                stream.filter(Files::isRegularFile).forEach(path -> {
                    Path relative = inputPath.relativize(path);
                    String entryName = baseEntryName + "/" + relative.toString().replace('\\', '/');
                    try {
                        zipOutput.putNextEntry(new ZipEntry(entryName));
                        copyFile(path, zipOutput, buffer);
                        zipOutput.closeEntry();
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                });
            } catch (UncheckedIOException e) {
                throw e.getCause();
            }
        } else {
            zipOutput.putNextEntry(new ZipEntry(baseEntryName));
            copyFile(inputPath, zipOutput, buffer);
            zipOutput.closeEntry();
        }
    }

    private static void copyFile(Path source, ZipOutputStream zipOutput, byte[] buffer) throws IOException {
        try (InputStream in = Files.newInputStream(source)) {
            int read;
            while ((read = in.read(buffer)) != -1) {
                zipOutput.write(buffer, 0, read);
            }
        }
    }

    private static List<Path> resolveOriginPaths(ModContainer container, List<SkippedMod> skippedMods) {
        ModOrigin origin = container.getOrigin();
        Set<ModOrigin> visited = Collections.newSetFromMap(new IdentityHashMap<>());
        String jarName = null;

        while (origin != null && visited.add(origin)) {
            if (origin.getKind() == ModOrigin.Kind.NESTED) {
                Optional<ModOrigin> parent = getParentOrigin(origin);
                if (parent.isPresent()) {
                    origin = parent.get();
                    continue;
                }
            }

            try {
                List<Path> paths = origin.getPaths();
                if (jarName == null) {
                    jarName = deriveJarName(paths);
                }
                return paths;
            } catch (RuntimeException ex) {
                if (jarName == null) {
                    jarName = deriveJarName(origin);
                }
                Optional<ModOrigin> parent = getParentOrigin(origin);
                if (parent.isPresent()) {
                    origin = parent.get();
                    continue;
                }

                String modId = container.getMetadata().getId();
                String reason = ex.getMessage() != null ? ex.getMessage() : ex.getClass().getSimpleName();
                ModClientOrServer.LOGGER.warn("Skipping mod {}: {}", modId, reason);
                skippedMods.add(new SkippedMod(modId, jarName, reason));
                return List.of();
            }
        }

        if (origin != null) {
            if (jarName == null) {
                jarName = deriveJarName(origin);
            }
            String modId = container.getMetadata().getId();
            ModClientOrServer.LOGGER.warn("Skipping mod {}: unable to resolve origin path (cyclic origin)", modId);
            skippedMods.add(new SkippedMod(modId, jarName, "cyclic origin"));
        }

        return List.of();
    }

    private static Optional<ModOrigin> getParentOrigin(ModOrigin origin) {
        try {
            MethodHandle handle = ParentAccessor.HANDLE;
            if (handle == null) {
                return Optional.empty();
            }
            Object result = handle.invoke(origin);
            if (result instanceof Optional<?> optional) {
                Object value = optional.orElse(null);
                return value instanceof ModOrigin modOrigin ? Optional.of(modOrigin) : Optional.empty();
            }
            if (result instanceof ModOrigin modOrigin) {
                return Optional.of(modOrigin);
            }
        } catch (Throwable ignored) {
            // Fall through to empty
        }
        return Optional.empty();
    }

    private static String deriveJarName(List<Path> paths) {
        if (paths == null || paths.isEmpty()) {
            return null;
        }
        return deriveJarName(paths.get(0));
    }

    private static String deriveJarName(ModOrigin origin) {
        try {
            List<Path> paths = origin.getPaths();
            return deriveJarName(paths);
        } catch (RuntimeException ignored) {
            return origin.toString();
        }
    }

    private static String deriveJarName(Path path) {
        if (path == null) {
            return null;
        }
        Path fileName = path.getFileName();
        return fileName != null ? fileName.toString() : path.toString();
    }

    private static final class ParentAccessor {
        private static final MethodHandle HANDLE = locate();

        private static MethodHandle locate() {
            try {
                MethodHandles.Lookup lookup = MethodHandles.lookup();
                return lookup.findVirtual(ModOrigin.class, "getParent", MethodType.methodType(Optional.class));
            } catch (NoSuchMethodException | IllegalAccessException e) {
                ModClientOrServer.LOGGER.debug("ModOrigin#getParent not available: {}", e.toString());
                return null;
            }
        }
    }

    private static Path canonicalPath(Path path) {
        try {
            return path.toRealPath(LinkOption.NOFOLLOW_LINKS);
        } catch (IOException e) {
            return path.toAbsolutePath().normalize();
        }
    }

    private static boolean isInsideModsDirectory(Path path, Path modsDir) {
        Path normalizedPath = path.toAbsolutePath().normalize();
        Path normalizedModsDir = modsDir.toAbsolutePath().normalize();
        return normalizedPath.equals(normalizedModsDir) || normalizedPath.startsWith(normalizedModsDir);
    }

    public record SkippedMod(String id, String jarName, String reason) {
        public String displayName() {
            if (jarName != null && !jarName.isBlank()) {
                if (jarName.equals(id)) {
                    return jarName;
                }
                return jarName + " (" + id + ")";
            }
            return id;
        }

        public String displayLine() {
            String base = displayName();
            if (reason != null && !reason.isBlank()) {
                return base + " – " + reason;
            }
            return base + " – no filesystem origin";
        }
    }

    private record CollectionResult(List<ModDescriptor> descriptors, List<SkippedMod> skippedMods) {
    }

    private record LeftoverResult(Path zipPath, List<Path> leftoverPaths) {
    }
}
