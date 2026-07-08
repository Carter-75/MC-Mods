package com.packsmod.packs;

import com.packsmod.PacksMod;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class ConflictDetector {

    public static boolean checkConflict(PackDefinition p1, PackDefinition p2) {
        // If categories are totally different types (Shader vs Resource), assume no
        // conflict?
        // Or check anyways.
        if (p1.isShaderPack() != p2.isShaderPack()) {
            return false;
        }

        Set<String> files1 = getRelativeFilePaths(p1);
        Set<String> files2 = getRelativeFilePaths(p2);

        // Check intersection
        for (String f : files1) {
            if (files2.contains(f)) {
                PacksMod.LOGGER.info("Conflict found between {} and {} on file {}", p1.key(), p2.key(), f);
                return true;
            }
        }
        return false;
    }

    private static Set<String> getRelativeFilePaths(PackDefinition pack) {
        Set<String> paths = new HashSet<>();

        Optional<ModContainer> container = FabricLoader.getInstance().getModContainer(PacksMod.MOD_ID);
        if (container.isEmpty())
            return paths;

        // Path logic needs to match PackInstaller/PacksMod
        // Resource packs: "resourcepacks/" + folderName
        // Shader packs: "shaderpacks/" + folderName

        String rootPrefix = pack.isShaderPack() ? "shaderpacks/" : "resourcepacks/";
        Path packRoot = container.get().findPath(rootPrefix + pack.folderName()).orElse(null);

        if (packRoot != null && Files.exists(packRoot)) {
            try (Stream<Path> stream = Files.walk(packRoot)) {
                stream.filter(Files::isRegularFile).forEach(p -> {
                    String rel = packRoot.relativize(p).toString();
                    // Normalize slashes for comparison
                    rel = rel.replace("\\", "/");
                    // Exclude metadata files
                    if (!rel.equals("pack.mcmeta") && !rel.equals("pack.png")) {
                        paths.add(rel);
                    }
                });
            } catch (IOException e) {
                PacksMod.LOGGER.error("Failed to walk path for conflict detection: {}", pack.key(), e);
            }
        }

        return paths;
    }
}
