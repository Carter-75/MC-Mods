import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.commons.ClassRemapper;
import jdk.internal.org.objectweb.asm.commons.Remapper;

public final class PackageRelocator {
    private static final LinkedHashMap<String, String> INTERNAL_PREFIXES = new LinkedHashMap<>();
    private static final LinkedHashMap<String, String> TEXT_REPLACEMENTS = new LinkedHashMap<>();

    static {
        // Specific mixin package mappings first so the consolidated mixin config resolves.
        INTERNAL_PREFIXES.put("com/blackgear/vanillabackport/core/mixin/", "backported_updates/mixin/");
        INTERNAL_PREFIXES.put("com/github/smallinger/copperagebackport/mixin/", "backported_updates/mixin/copper/");
        INTERNAL_PREFIXES.put("com/blackgear/platform/core/mixin/", "backported_updates/mixin/platform/");
        INTERNAL_PREFIXES.put("rs/onako2/iwie/mixin/", "backported_updates/mixin/garden/");

        INTERNAL_PREFIXES.put("com/blackgear/platform/", "backported/updates/platform/");
        INTERNAL_PREFIXES.put("com/blackgear/vanillabackport/", "backported/updates/content/");
        INTERNAL_PREFIXES.put("com/github/smallinger/copperagebackport/", "backported/updates/copper/");
        INTERNAL_PREFIXES.put("rs/onako2/iwie/", "backported/updates/garden/");

        for (Map.Entry<String, String> entry : INTERNAL_PREFIXES.entrySet()) {
            TEXT_REPLACEMENTS.put(entry.getKey().replace('/', '.').replaceAll("\\.$", ""), entry.getValue().replace('/', '.').replaceAll("\\.$", ""));
        }

        TEXT_REPLACEMENTS.put(
            "com.blackgear.vanillabackport.core.fabric.emissive.EmissiveModelHandler",
            "backported.updates.content.core.fabric.emissive.EmissiveModelHandler"
        );
        TEXT_REPLACEMENTS.put(
            "com.github.smallinger.copperagebackport.fabric.client.CopperAgeBackportFabricClient",
            "backported.updates.copper.fabric.client.CopperAgeBackportFabricClient"
        );
        TEXT_REPLACEMENTS.put(
            "rs.onako2.iwie.ClientInit",
            "backported.updates.garden.ClientInit"
        );
        TEXT_REPLACEMENTS.put(
            "com.blackgear.vanillabackport.core.fabric.VanillaBackportFabric",
            "backported.updates.content.core.fabric.VanillaBackportFabric"
        );
        TEXT_REPLACEMENTS.put(
            "com.github.smallinger.copperagebackport.fabric.CopperAgeBackportFabric",
            "backported.updates.copper.fabric.CopperAgeBackportFabric"
        );
        TEXT_REPLACEMENTS.put(
            "rs.onako2.iwie.Init",
            "backported.updates.garden.Init"
        );
        TEXT_REPLACEMENTS.put(
            "com.blackgear.platform.fabric.PlatformFabric",
            "backported.updates.platform.fabric.PlatformFabric"
        );
        TEXT_REPLACEMENTS.put(
            "com.blackgear.vanillabackport.data.DataGenerator",
            "backported.updates.content.data.DataGenerator"
        );
        TEXT_REPLACEMENTS.put(
            "com.blackgear.vanillabackport.core.fabric.VanillaBackportTerrablender",
            "backported.updates.content.core.fabric.VanillaBackportTerrablender"
        );
        TEXT_REPLACEMENTS.put(
            "com.github.smallinger.copperagebackport.fabric.client.ModMenuIntegration",
            "backported.updates.copper.fabric.client.ModMenuIntegration"
        );
    }

    private PackageRelocator() {
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: PackageRelocator <resources-root>");
        }

        Path resourcesRoot = Paths.get(args[0]).toAbsolutePath().normalize();
        if (!Files.isDirectory(resourcesRoot)) {
            throw new IllegalArgumentException("Resources root not found: " + resourcesRoot);
        }

        Path tempRoot = resourcesRoot.resolveSibling(resourcesRoot.getFileName() + "-relocated-temp");
        deleteIfExists(tempRoot);
        Files.createDirectories(tempRoot);

        List<Path> classFiles = collectClassFiles(resourcesRoot);
        PrefixRemapper remapper = new PrefixRemapper(INTERNAL_PREFIXES);

        int relocatedCount = 0;
        for (Path classFile : classFiles) {
            byte[] originalBytes = Files.readAllBytes(classFile);
            ClassReader reader = new ClassReader(originalBytes);
            ClassWriter writer = new ClassWriter(0);
            ClassVisitor visitor = new ClassRemapper(writer, remapper);
            reader.accept(visitor, 0);

            String relocatedInternalName = remapper.map(reader.getClassName());
            if (relocatedInternalName == null || relocatedInternalName.isEmpty()) {
                throw new IllegalStateException("Unable to relocate class: " + classFile);
            }

            Path outputPath = tempRoot.resolve(relocatedInternalName + ".class");
            Files.createDirectories(outputPath.getParent());
            Files.write(outputPath, writer.toByteArray());
            relocatedCount++;
        }

        replaceTree(resourcesRoot.resolve("com"), tempRoot.resolve("backported"));
        replaceTree(resourcesRoot.resolve("rs"), tempRoot.resolve("backported"));
        replaceTree(resourcesRoot.resolve("backported_updates"), tempRoot.resolve("backported_updates"));

        updateTextFile(resourcesRoot.resolve("fabric.mod.json"));
        updateMixinConfig(resourcesRoot.resolve("backported_updates.mixins.json"));
        relocateServiceFiles(resourcesRoot.resolve("META-INF/services"));

        deleteIfExists(tempRoot);
        System.out.println("Relocated class files: " + relocatedCount);
    }

    private static List<Path> collectClassFiles(Path resourcesRoot) throws IOException {
        List<Path> classFiles = new ArrayList<>();
        for (String rootName : List.of("com", "rs")) {
            Path root = resourcesRoot.resolve(rootName);
            if (!Files.exists(root)) {
                continue;
            }

            try (Stream<Path> stream = Files.walk(root)) {
                stream.filter(path -> Files.isRegularFile(path) && path.toString().endsWith(".class"))
                    .forEach(classFiles::add);
            }
        }
        return classFiles;
    }

    private static void replaceTree(Path oldRoot, Path newRoot) throws IOException {
        deleteIfExists(oldRoot);
        if (!Files.exists(newRoot)) {
            return;
        }

        Path targetRoot = oldRoot.getParent().resolve(newRoot.getFileName());
        if (!Files.exists(targetRoot)) {
            Files.move(newRoot, targetRoot, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private static void relocateServiceFiles(Path servicesDir) throws IOException {
        if (!Files.isDirectory(servicesDir)) {
            return;
        }

        List<Path> serviceFiles;
        try (Stream<Path> stream = Files.list(servicesDir)) {
            serviceFiles = stream.filter(Files::isRegularFile).toList();
        }

        for (Path serviceFile : serviceFiles) {
            String originalName = serviceFile.getFileName().toString();
            String relocatedName = replaceAllText(originalName);
            String content = Files.readString(serviceFile, StandardCharsets.UTF_8);
            String relocatedContent = replaceAllText(content);

            Path destination = servicesDir.resolve(relocatedName);
            Files.writeString(destination, relocatedContent, StandardCharsets.UTF_8);
            if (!destination.equals(serviceFile)) {
                Files.deleteIfExists(serviceFile);
            }
        }
    }

    private static void updateTextFile(Path file) throws IOException {
        String content = Files.readString(file, StandardCharsets.UTF_8);
        Files.writeString(file, replaceAllText(content), StandardCharsets.UTF_8);
    }

    private static void updateMixinConfig(Path file) throws IOException {
        String content = Files.readString(file, StandardCharsets.UTF_8);
        content = content.replace("\"access.CopperBrushedAccessor\",\r\n", "");
        content = content.replace("\"access.CopperBrushedAccessor\",\n", "");
        Files.writeString(file, content, StandardCharsets.UTF_8);
    }

    private static String replaceAllText(String input) {
        String output = input;
        for (Map.Entry<String, String> entry : TEXT_REPLACEMENTS.entrySet()) {
            output = output.replace(entry.getKey(), entry.getValue());
        }
        return output;
    }

    private static void deleteIfExists(Path path) throws IOException {
        if (!Files.exists(path)) {
            return;
        }

        try (Stream<Path> stream = Files.walk(path)) {
            stream.sorted(Comparator.reverseOrder()).forEach(current -> {
                try {
                    Files.deleteIfExists(current);
                } catch (IOException exception) {
                    throw new RuntimeException(exception);
                }
            });
        } catch (RuntimeException exception) {
            if (exception.getCause() instanceof IOException ioException) {
                throw ioException;
            }
            throw exception;
        }
    }

    private static final class PrefixRemapper extends Remapper {
        private final List<Map.Entry<String, String>> prefixes;

        private PrefixRemapper(LinkedHashMap<String, String> prefixes) {
            this.prefixes = new ArrayList<>(prefixes.entrySet());
        }

        @Override
        public String map(String internalName) {
            if (internalName == null) {
                return null;
            }

            for (Map.Entry<String, String> entry : prefixes) {
                if (internalName.startsWith(entry.getKey())) {
                    return entry.getValue() + internalName.substring(entry.getKey().length());
                }
            }
            return internalName;
        }
    }
}