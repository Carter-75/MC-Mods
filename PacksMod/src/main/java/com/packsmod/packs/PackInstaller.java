package com.packsmod.packs;

import com.packsmod.PacksMod;
import com.packsmod.config.PacksModConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

public final class PackInstaller {
	private PackInstaller() {
	}

	public static void syncPacks(PacksModConfig config) {
		if (config == null || !config.installMissingPacks) {
			return;
		}

		Optional<ModContainer> container = FabricLoader.getInstance().getModContainer(PacksMod.MOD_ID);
		if (container.isEmpty()) {
			PacksMod.LOGGER.warn("Unable to locate mod container for {}", PacksMod.MOD_ID);
			return;
		}

		Path gameDir = FabricLoader.getInstance().getGameDir();
		Path shaderPacksDir = gameDir.resolve("shaderpacks");

		for (PackDefinition pack : PackRegistry.packs()) {
			if (!pack.isShaderPack()) {
				continue;
			}

			Boolean enabled = config.packToggles.get(pack.key());
			if (enabled != null && !enabled) {
				continue;
			}

			copyShaderPack(container.get(), pack, shaderPacksDir, config.replaceExistingPacks);
		}
	}

	private static void copyShaderPack(ModContainer container, PackDefinition pack, Path targetDir, boolean replaceExisting) {
		try {
			Files.createDirectories(targetDir);
			Path targetPath = targetDir.resolve(pack.folderName());
			if (Files.exists(targetPath) && !replaceExisting) {
				return;
			}

			Optional<Path> source = container.findPath("shaderpacks/" + pack.folderName());
			if (source.isEmpty()) {
				PacksMod.LOGGER.warn("Shader pack source missing for {}", pack.displayName());
				return;
			}

			if (Files.exists(targetPath)) {
				if (replaceExisting) {
					deleteDirectory(targetPath);
				} else {
					return;
				}
			}

			copyDirectory(source.get(), targetPath);
		} catch (IOException ex) {
			PacksMod.LOGGER.error("Failed to copy shader pack {}", pack.displayName(), ex);
		}
	}

	private static void copyDirectory(Path source, Path target) throws IOException {
		try (var paths = Files.walk(source)) {
			paths.forEach(path -> {
				try {
					Path relative = source.relativize(path);
					Path destination = target.resolve(relative.toString());
					if (Files.isDirectory(path)) {
						Files.createDirectories(destination);
					} else {
						Files.createDirectories(destination.getParent());
						Files.copy(path, destination, StandardCopyOption.REPLACE_EXISTING);
					}
				} catch (IOException ex) {
					throw new IllegalStateException(ex);
				}
			});
		}
	}

	private static void deleteDirectory(Path path) throws IOException {
		if (!Files.exists(path)) {
			return;
		}
		try (var paths = Files.walk(path)) {
			paths.sorted((a, b) -> b.getNameCount() - a.getNameCount())
				.forEach(p -> {
					try {
						Files.deleteIfExists(p);
					} catch (IOException ex) {
						throw new IllegalStateException(ex);
					}
				});
		}
	}
}
