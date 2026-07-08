package com.packsmod;

import com.packsmod.config.PacksModConfig;
import com.packsmod.packs.PackCategory;
import com.packsmod.packs.PackDefinition;
import com.packsmod.packs.PackInstaller;
import com.packsmod.packs.PackRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class PacksMod implements ModInitializer {
	public static final String MOD_ID = "packsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("PacksMod initialized");

		PacksModConfig config = PacksModConfig.load();
		PackInstaller.syncPacks(config);

		// Register Internal Resource Packs
		Optional<ModContainer> container = FabricLoader.getInstance().getModContainer(MOD_ID);
		if (container.isPresent()) {
			for (PackDefinition pack : PackRegistry.packs()) {
				// Only register RESOURCE category (and maybe ARMOR/FONT if they are implemented
				// as packs)
				// Shaders are handled by PackInstaller copying them.
				if (pack.category() == PackCategory.RESOURCE || pack.category() == PackCategory.ARMOR
						|| pack.category() == PackCategory.FONT) {
					registerPack(container.get(), pack);
				}
			}
		}
	}

	private void registerPack(ModContainer container, PackDefinition pack) {
		String subPath = "resourcepacks/" + pack.folderName();

		// Determine activation type based on config?
		// We explicitly register as NORMAL. Enabling is handled by PacksModClient on
		// startup.
		ResourceManagerHelper.registerBuiltinResourcePack(
				Identifier.of(MOD_ID, pack.key()),
				container,
				subPath,
				ResourcePackActivationType.NORMAL);
	}
}
