package com.freshanimations;

import com.freshanimations.config.FreshAnimationsConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class FreshAnimations implements ModInitializer {
	public static final String MOD_ID = "freshanimations";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing FreshAnimations...");

		// Load config
		FreshAnimationsConfig.load();

		// Register built-in resource packs
		Optional<ModContainer> container = FabricLoader.getInstance().getModContainer(MOD_ID);
		if (container.isPresent()) {
			registerPacks(container.get());
		} else {
			LOGGER.warn("Could not find ModContainer for " + MOD_ID);
		}
	}

	private void registerPacks(ModContainer container) {
		Path resourcePacksDir = container.findPath("resourcepacks").orElse(null);
		if (resourcePacksDir == null || !Files.exists(resourcePacksDir)) {
			// In dev env, it might be in src/main/resources/resourcepacks
			// But FabricLoader findPath checks classpath, so it should find it if it's
			// there.
			LOGGER.info("No resourcepacks directory found in mod.");
			return;
		}

		try {
			// List packs and sort: 'freshanimations' packs first (lower priority), others
			// last (higher priority)
			// This ensures addons or overrides like 'humaneravillagers' win conflicts.
			Stream<Path> paths = Files.list(resourcePacksDir)
					.filter(Files::isDirectory) // Filter directories only
					.sorted((p1, p2) -> {
						String n1 = p1.getFileName().toString().toLowerCase();
						String n2 = p2.getFileName().toString().toLowerCase();
						boolean fa1 = n1.contains("freshanimations");
						boolean fa2 = n2.contains("freshanimations");

						// If both are FA or neither are FA, sort alphabetically
						if (fa1 == fa2)
							return n1.compareTo(n2);
						// If n1 is FA, it comes first (return -1)
						if (fa1)
							return -1;
						// If n2 is FA, it comes first (so n1 is > n2, return 1)
						return 1;
					});

			paths.forEach(path -> {
				String folderName = path.getFileName().toString();
				String packId = folderName.toLowerCase().replaceAll("[^a-z0-9/._-]", "_"); // Sanitize ID

				LOGGER.info("Found built-in pack: " + folderName + " (ID: " + packId + ")");

				// Register in Config
				FreshAnimationsConfig.registerPack(packId);

				// Register with Fabric API
				FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
					ResourceManagerHelper.registerBuiltinResourcePack(
							Identifier.of(MOD_ID, packId),
							modContainer,
							"resourcepacks/" + folderName,
							ResourcePackActivationType.DEFAULT_ENABLED);
				});
			});
			paths.close();
		} catch (IOException e) {
			LOGGER.error("Error listing resource packs", e);
		}
	}
}