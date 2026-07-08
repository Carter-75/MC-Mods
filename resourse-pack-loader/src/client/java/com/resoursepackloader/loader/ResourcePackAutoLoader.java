package com.resoursepackloader.loader;

import com.resoursepackloader.ResoursePackLoader;
import com.resoursepackloader.config.AutoPackConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ResourcePackAutoLoader {
	private static final AtomicBoolean APPLIED = new AtomicBoolean(false);

	private ResourcePackAutoLoader() {
	}

	public static void init() {
		ClientLifecycleEvents.CLIENT_STARTED.register(ResourcePackAutoLoader::onClientStarted);
	}

	private static void onClientStarted(MinecraftClient client) {
		if (!APPLIED.compareAndSet(false, true)) {
			return;
		}

		AutoPackConfig config = AutoPackConfig.load();
		applyConfiguredPacks(client, config);
	}

	private static void applyConfiguredPacks(MinecraftClient client, AutoPackConfig config) {
		ResourcePackManager manager = client.getResourcePackManager();
		manager.scanPacks();
		client.options.addResourcePackProfilesToManager(manager);

		List<ResourcePackProfile> desiredProfiles = new ArrayList<>();
		if (config.enableAllAvailable()) {
			desiredProfiles.addAll(collectAllUserPacks(manager));
			if (desiredProfiles.isEmpty()) {
				ResoursePackLoader.LOGGER.info("No user-managed resource packs were found to auto-enable.");
			}
		} else if (!config.packsToEnable().isEmpty()) {
			desiredProfiles.addAll(collectConfiguredProfiles(manager, config.packsToEnable()));
			if (desiredProfiles.isEmpty()) {
				ResoursePackLoader.LOGGER.warn("None of the resource packs listed in {} were found. Existing selections will be used instead.", config.path());
			}
		}

		boolean appliedChanges = !desiredProfiles.isEmpty() && enableRequestedProfiles(manager, desiredProfiles);
		boolean orderJiggled = jiggleEnabledOrder(manager);
		if (appliedChanges) {
			ResoursePackLoader.LOGGER.info("Enabled {} resource packs that were requested via configuration.", desiredProfiles.size());
		} else {
			ResoursePackLoader.LOGGER.info("No additional resource packs needed to be enabled; relying on current selection.");
		}
		if (orderJiggled) {
			ResoursePackLoader.LOGGER.info("Temporarily reordered enabled packs to mimic UI interaction and trigger reload.");
		}

		client.options.refreshResourcePacks(manager);

		if (config.reloadAfterApplying()) {
			int activeCount = manager.getEnabledProfiles().size();
			reloadResources(client, () -> ResoursePackLoader.LOGGER.info("Force reloaded {} resource packs at launch.", activeCount));
		} else if (appliedChanges) {
			ResoursePackLoader.LOGGER.info("Reload skipped per configuration after enabling resource packs.");
		}
	}

	private static boolean enableRequestedProfiles(ResourcePackManager manager, List<ResourcePackProfile> desiredProfiles) {
		List<String> enabledOrder = new ArrayList<>(manager.getEnabledIds());
		Set<String> seen = new LinkedHashSet<>(enabledOrder);
		boolean changed = false;

		for (ResourcePackProfile profile : desiredProfiles) {
			String id = profile.getId();
			if (seen.add(id)) {
				enabledOrder.add(id);
				changed = true;
			}
		}

		if (!changed) {
			ResoursePackLoader.LOGGER.info("All requested resource packs are already enabled.");
			return false;
		}

		manager.setEnabledProfiles(enabledOrder);
		return true;
	}

	private static boolean jiggleEnabledOrder(ResourcePackManager manager) {
		List<String> enabledOrder = new ArrayList<>(manager.getEnabledIds());
		if (enabledOrder.size() < 1) {
			return false;
		}

		String first = enabledOrder.remove(0);
		enabledOrder.add(first);
		manager.setEnabledProfiles(enabledOrder);

		enabledOrder.remove(enabledOrder.size() - 1);
		enabledOrder.add(0, first);
		manager.setEnabledProfiles(enabledOrder);
		return true;
	}

	private static void reloadResources(MinecraftClient client, Runnable onSuccess) {
		client.reloadResources().whenComplete((ignored, throwable) -> {
			if (throwable != null) {
				ResoursePackLoader.LOGGER.error("Failed to reload resources after applying resource packs", throwable);
			} else {
				onSuccess.run();
			}
		});
	}

	private static List<ResourcePackProfile> collectConfiguredProfiles(ResourcePackManager manager, List<String> requestedIds) {
		List<ResourcePackProfile> resolved = new ArrayList<>();
		Set<String> missing = new LinkedHashSet<>();

		for (String id : requestedIds) {
			ResourcePackProfile profile = findProfile(manager, id);
			if (profile != null) {
				resolved.add(profile);
			} else {
				missing.add(id);
			}
		}

		if (!missing.isEmpty()) {
			missing.forEach(name -> ResoursePackLoader.LOGGER.warn("Configured resource pack '{}' was not found.", name));
		}

		return resolved;
	}

	private static List<ResourcePackProfile> collectAllUserPacks(ResourcePackManager manager) {
		List<ResourcePackProfile> result = new ArrayList<>();
		for (ResourcePackProfile profile : manager.getProfiles()) {
			if (isUserManagedPack(profile)) {
				result.add(profile);
			}
		}
		return result;
	}

	private static boolean isUserManagedPack(ResourcePackProfile profile) {
		String id = profile.getId();
		return id != null && (id.startsWith("file/") || id.startsWith("folder/"));
	}

	private static ResourcePackProfile findProfile(ResourcePackManager manager, String target) {
		if (target == null || target.isBlank()) {
			return null;
		}

		String trimmed = target.trim();
		ResourcePackProfile direct = manager.getProfile(trimmed);
		if (direct != null) {
			return direct;
		}

		String normalized = trimmed.toLowerCase(Locale.ROOT);
		Collection<ResourcePackProfile> profiles = manager.getProfiles();
		for (ResourcePackProfile profile : profiles) {
			if (profile.getId().equalsIgnoreCase(trimmed)) {
				return profile;
			}

			Text displayName = profile.getDisplayName();
			if (displayName != null && displayName.getString().toLowerCase(Locale.ROOT).equals(normalized)) {
				return profile;
			}
		}

		return null;
	}
}
