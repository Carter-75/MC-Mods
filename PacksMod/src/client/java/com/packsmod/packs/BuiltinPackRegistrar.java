package com.packsmod.packs;

import com.packsmod.PacksMod;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public final class BuiltinPackRegistrar {
	private BuiltinPackRegistrar() {
	}

	public static void registerBuiltinPacks() {
		Optional<ModContainer> container = FabricLoader.getInstance().getModContainer(PacksMod.MOD_ID);
		if (container.isEmpty()) {
			PacksMod.LOGGER.warn("Unable to locate mod container for {}", PacksMod.MOD_ID);
			return;
		}

		for (PackDefinition pack : PackRegistry.packs()) {
			if (!pack.isResourcePack()) {
				continue;
			}

			Identifier id = Identifier.of(PacksMod.MOD_ID, pack.key());
			ResourceManagerHelper.registerBuiltinResourcePack(
				id,
				container.get(),
				Text.literal(pack.displayName()),
				ResourcePackActivationType.NORMAL
			);
		}
	}
}
