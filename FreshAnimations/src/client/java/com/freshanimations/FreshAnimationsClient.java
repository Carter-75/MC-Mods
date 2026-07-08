package com.freshanimations;

import com.freshanimations.config.FreshAnimationsConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourcePackManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FreshAnimationsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Sync config when client starts
		ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
			syncConfig(client);
		});
	}

	public static void syncConfig(MinecraftClient client) {
		if (client == null || client.getResourcePackManager() == null)
			return;

		ResourcePackManager manager = client.getResourcePackManager();
		boolean changed = false;

		// Get currently enabled profiles (modifiable list)
		Collection<String> enabledIds = new ArrayList<>();
		for (var profile : manager.getEnabledProfiles()) {
			enabledIds.add(profile.getId());
		}

		boolean isBaseEnabled = FreshAnimationsConfig.PACK_TOGGLES.getOrDefault("freshanimations_v1_10_3", true);

		for (Map.Entry<String, Boolean> entry : FreshAnimationsConfig.PACK_TOGGLES.entrySet()) {
			String key = entry.getKey();
			String fullId = "freshanimations:" + key;

			// Dependency Logic:
			// If Base Pack is OFF, then ALL other FA addons should be OFF (except external
			// overrides like Human Era).
			// We check if this is an FA addon (starts with 'fa_' usually or is part of the
			// mod)
			// But NOT if it's the base pack itself.
			boolean isAddon = !key.equals("freshanimations_v1_10_3") && !key.contains("humaneravillagers");

			boolean shouldBeEnabled = entry.getValue();

			if (isAddon && !isBaseEnabled) {
				shouldBeEnabled = false; // Force disable if base is off
				// Also update the config so the UI reflects this change
				if (entry.getValue()) {
					FreshAnimationsConfig.PACK_TOGGLES.put(key, false);
					changed = true; // Mark as changed to trigger save/reload logic
				}
			}

			boolean isEnabled = enabledIds.contains(fullId);

			if (shouldBeEnabled && !isEnabled) {
				// Enable it
				if (manager.getProfile(fullId) != null) {
					enabledIds.add(fullId);
					changed = true;
				}
			} else if (!shouldBeEnabled && isEnabled) {
				// Disable it
				enabledIds.remove(fullId);
				changed = true;
			}
		}

		if (changed) {
			FreshAnimationsConfig.save(); // Save the updated toggles to disk
			// Enforce Load Order:
			// 1. freshanimations_v1_10_3 (Base) -> MUST be early
			// 2. Addons (details, emissive)
			// 3. Overrides (Human Era) -> MUST be late

			List<String> sortedIds = new ArrayList<>(enabledIds);
			sortedIds.sort((id1, id2) -> {
				boolean p1Base = id1.contains("freshanimations_v1_10_3");
				boolean p2Base = id2.contains("freshanimations_v1_10_3");

				if (p1Base && !p2Base)
					return -1; // Base comes first (lower priority)
				if (!p1Base && p2Base)
					return 1;

				// Keep existing relative order for everything else to avoid breaking other mods
				// (This is a simplified assumption. Ideally we'd only reorder OUR packs)
				// But strictly speaking, if we just bubble the Base to the top of our group, it
				// works.

				// Better approach: Don't sort EVERYTHING. Just ensuring Base < Addons.
				// But since we are dealing with a flat list, let's just use the index.
				return 0;
			});

			// Actually, a safer way that doesn't mess up vanilla/fabric order:
			// 1. Remove all 'freshanimations' related packs from the list.
			// 2. Re-insert them at the end, but in the CORRECT internal order.

			List<String> standardMods = new ArrayList<>();
			List<String> faPacks = new ArrayList<>();

			for (String id : enabledIds) {
				if (id.contains("freshanimations") || id.contains("humaneravillagers")) {
					faPacks.add(id);
				} else {
					standardMods.add(id);
				}
			}

			// Sort the FA specific packs
			faPacks.sort((id1, id2) -> {
				// Base pack first
				if (id1.contains("freshanimations_v1_10_3"))
					return -1;
				if (id2.contains("freshanimations_v1_10_3"))
					return 1;

				// Human/Overrides last (highest priority)
				boolean h1 = id1.contains("humaneravillagers");
				boolean h2 = id2.contains("humaneravillagers");
				if (h1 && !h2)
					return 1;
				if (!h1 && h2)
					return -1;

				return id1.compareTo(id2);
			});

			// Reassemble: Standard Mods + FA Packs
			List<String> finalOrder = new ArrayList<>(standardMods);
			finalOrder.addAll(faPacks);

			manager.setEnabledProfiles(finalOrder);
			client.reloadResources(); // Reload immediately if changed
		}
	}
}