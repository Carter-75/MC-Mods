package mod.universalmobwar.system;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.config.ModConfig;
import mod.universalmobwar.mixin.PersistentProjectileEntityAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * Periodic cleanup of high-volume entities that can accumulate and cause lag.
 *
 * Currently targets non-player-owned ground projectiles (e.g., arrows/tridents)
 * that have come to rest.
 */
public final class EntityCleanupSystem {
	private EntityCleanupSystem() {
	}

	public static int cleanupNonPlayerGroundProjectiles(MinecraftServer server) {
		ModConfig config = ModConfig.getInstance();
		if (!config.modEnabled || !config.cleanupNonPlayerGroundProjectiles) {
			return 0;
		}

		final int minAgeTicks = Math.max(0, config.cleanupNonPlayerGroundProjectilesMinAgeTicks);
		final int maxPerWorld = Math.max(0, config.cleanupNonPlayerGroundProjectilesMaxPerWorldPerRun);

		int removedTotal = 0;
		for (ServerLevel world : server.getAllLevels()) {
			int removedThisWorld = 0;
			List<AbstractArrow> candidates = new ArrayList<>();
			try {
				for (Entity entity : world.getAllEntities()) {
					if (maxPerWorld > 0 && candidates.size() >= maxPerWorld) {
						break;
					}

					if (!(entity instanceof AbstractArrow projectile)) {
						continue;
					}

					if (projectile.isRemoved()) {
						continue;
					}

					// Keep any player-shot/thrown projectiles.
					Entity owner = projectile.getOwner();
					if (owner instanceof Player) {
						continue;
					}

					if (projectile.tickCount < minAgeTicks) {
						continue;
					}

					// Only delete when the projectile is resting (in-ground). This avoids impacting combat.
					boolean inGround;
					try {
						inGround = ((PersistentProjectileEntityAccessor) projectile).universalmobwar$isInGround();
					} catch (Throwable t) {
						// If mappings ever change and the accessor fails, fall back to a conservative check.
						inGround = projectile.onGround();
					}

					if (!inGround) {
						continue;
					}

					candidates.add(projectile);
				}
			} catch (RuntimeException ex) {
				UniversalMobWarMod.LOGGER.warn("Entity cleanup skipped in world {} due to iterator failure", world.dimension().location(), ex);
				continue;
			}

			for (AbstractArrow projectile : candidates) {
				if (maxPerWorld > 0 && removedThisWorld >= maxPerWorld) {
					break;
				}

				if (projectile.isRemoved()) {
					continue;
				}

				projectile.discard();
				removedThisWorld++;
			}

			removedTotal += removedThisWorld;
		}

		if (removedTotal > 0 && ModConfig.getInstance().debugLogging) {
			UniversalMobWarMod.LOGGER.info("Entity cleanup removed {} non-player ground projectiles", removedTotal);
		}

		return removedTotal;
	}
}
