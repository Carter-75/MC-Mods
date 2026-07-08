package com.packsmod.packs;

import com.packsmod.PacksMod;
import com.packsmod.config.PacksModConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class PackApplier {
	private PackApplier() {
	}

	public static void applyConfiguredPacks(MinecraftClient client, PacksModConfig config) {
		if (client == null || config == null) {
			return;
		}

		ResourcePackManager manager = client.getResourcePackManager();
		manager.scanPacks();
		client.options.addResourcePackProfilesToManager(manager);

		Set<String> requestedKeys = resolveRequestedKeys(config);
		Map<String, String> resolvedIds = resolvePackIds(manager);

		List<String> enabledOrder = new ArrayList<>(manager.getEnabledIds());
		enabledOrder.removeIf(resolvedIds::containsValue);

		for (String key : PackRegistry.orderedKeys()) {
			if (!requestedKeys.contains(key)) {
				continue;
			}

			String id = resolvedIds.get(key);
			if (id != null && !enabledOrder.contains(id)) {
				enabledOrder.add(id);
			}
		}

		manager.setEnabledProfiles(enabledOrder);
		client.options.refreshResourcePacks(manager);

		if (config.reloadAfterApplying) {
			client.reloadResources().whenComplete((ignored, throwable) -> {
				if (throwable != null) {
					PacksMod.LOGGER.error("Failed to reload resources after applying packs", throwable);
				} else {
					PacksMod.LOGGER.info("Applied {} packs via configuration", requestedKeys.size());
				}
			});
		} else {
			PacksMod.LOGGER.info("Applied {} packs via configuration", requestedKeys.size());
		}
	}

	private static Set<String> resolveRequestedKeys(PacksModConfig config) {
		Set<String> requested = new LinkedHashSet<>();

		for (Map.Entry<String, Boolean> entry : config.packToggles.entrySet()) {
			PackDefinition pack = PackRegistry.byKey().get(entry.getKey());
			if (pack == null || !pack.isResourcePack()) {
				continue;
			}

			if (Boolean.TRUE.equals(entry.getValue())) {
				requested.add(pack.key());
			}
		}

		PackDefinition font = PackRegistry.resolveFont(config.fontSelection);
		if (font != null) {
			requested.add(font.key());
		}

		PackDefinition armor = PackRegistry.resolveArmor(config.armorSelection);
		if (armor != null) {
			requested.add(armor.key());
		}

		return requested;
	}

	private static Map<String, String> resolvePackIds(ResourcePackManager manager) {
		Map<String, String> resolved = new HashMap<>();
		for (PackDefinition pack : PackRegistry.packs()) {
			if (!pack.isResourcePack()) {
				continue;
			}

			String id = findProfileId(manager, pack);
			if (id != null) {
				resolved.put(pack.key(), id);
			}
		}
		return resolved;
	}

	private static String findProfileId(ResourcePackManager manager, PackDefinition pack) {
		String displayName = pack.displayName();
		String normalizedDisplayName = normalize(displayName);
		String normalizedKey = normalize(pack.key());
		String normalizedFolder = normalize(pack.folderName());
		String expectedId = "packsmod:" + pack.key();

		for (ResourcePackProfile profile : manager.getProfiles()) {
			String id = profile.getId();
			String profileDisplayName = extractName(profile.getDisplayName());
			String normalizedId = normalize(id);
			String normalizedDisplay = normalize(profileDisplayName);

			if (id.equalsIgnoreCase(expectedId)) {
				return id;
			}
			if (normalizedId.contains(normalizedFolder)) {
				return id;
			}
			if (normalizedDisplay.equals(normalizedDisplayName) || normalizedDisplay.contains(normalizedDisplayName)) {
				return id;
			}
			if (normalizedId.contains(normalizedKey) || normalizedDisplay.contains(normalizedKey)) {
				return id;
			}
		}

		return null;
	}

	private static String extractName(Text text) {
		if (text == null) {
			return "";
		}
		return text.getString();
	}

	private static String normalize(String value) {
		if (value == null) {
			return "";
		}
		return value.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]+", "");
	}
}
