package com.packsmod;

import com.packsmod.config.PacksModConfig;
import com.packsmod.packs.PackCategory;
import com.packsmod.packs.PackDefinition;
import com.packsmod.packs.PackRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProfile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PacksModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Sync config when client starts
		ClientLifecycleEvents.CLIENT_STARTED.register(PacksModClient::syncConfig);
	}

	public static void syncConfig(MinecraftClient client) {
		if (client == null || client.getResourcePackManager() == null)
			return;

		PacksModConfig config = PacksModConfig.load(); // Reload config to be fresh
		ResourcePackManager manager = client.getResourcePackManager();
		boolean changed = false;

		// Get currently enabled profiles
		Collection<String> enabledIds = new ArrayList<>();
		for (ResourcePackProfile profile : manager.getEnabledProfiles()) {
			enabledIds.add(profile.getId());
		}

		// 1. Sync Standard Resource Packs
		for (Map.Entry<String, Boolean> entry : config.packToggles.entrySet()) {
			String key = entry.getKey();
			String fullId = "packsmod:" + key;
			boolean shouldBeEnabled = entry.getValue();

			boolean isEnabled = enabledIds.contains(fullId);

			if (shouldBeEnabled && !isEnabled) {
				if (manager.getProfile(fullId) != null) {
					enabledIds.add(fullId);
					changed = true;
				}
			} else if (!shouldBeEnabled && isEnabled) {
				enabledIds.remove(fullId);
				changed = true;
			}
		}

		// 2. Sync Armor Packs
		// Disable ALL armor packs first
		for (PackDefinition pack : PackRegistry.packs()) {
			if (pack.category() == PackCategory.ARMOR) {
				String fullId = "packsmod:" + pack.key();
				if (enabledIds.contains(fullId)) {
					enabledIds.remove(fullId);
					changed = true;
				}
			}
		}
		// Enable selected armor pack
		if (config.armorSelection != PacksModConfig.ArmorSelection.OFF) {
			PackDefinition selected = PackRegistry.resolveArmor(config.armorSelection);
			if (selected != null) {
				String fullId = "packsmod:" + selected.key();
				if (manager.getProfile(fullId) != null && !enabledIds.contains(fullId)) {
					enabledIds.add(fullId);
					changed = true;
				}
			}
		}

		// 3. Sync Font Packs
		// Disable ALL font packs first
		for (PackDefinition pack : PackRegistry.packs()) {
			if (pack.category() == PackCategory.FONT) {
				String fullId = "packsmod:" + pack.key();
				if (enabledIds.contains(fullId)) {
					enabledIds.remove(fullId);
					changed = true;
				}
			}
		}
		// Enable selected font pack
		if (config.fontSelection != PacksModConfig.FontSelection.OFF) {
			PackDefinition selected = PackRegistry.resolveFont(config.fontSelection);
			if (selected != null) {
				String fullId = "packsmod:" + selected.key();
				if (manager.getProfile(fullId) != null && !enabledIds.contains(fullId)) {
					enabledIds.add(fullId);
					changed = true;
				}
			}
		}

		if (changed) {
			manager.setEnabledProfiles(enabledIds);
			client.reloadResources();
		}
	}
}
