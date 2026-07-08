package com.farmechoshards;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FarmEchoShards implements ModInitializer {
	public static final String MOD_ID = "farmechoshards";
	private static final float WARDEN_ECHO_SHARD_DROP_CHANCE = 0.7f;

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing FarmEchoShards");

		// Grant players an extra chance to gain echo shards from Warden kills.
		ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
			if (entity.getType() != EntityType.WARDEN) {
				return;
			}
			if (!(entity.getWorld() instanceof ServerWorld serverWorld)) {
				return;
			}
			if (damageSource == null || !(damageSource.getAttacker() instanceof PlayerEntity)) {
				return;
			}
			if (serverWorld.getRandom().nextFloat() > WARDEN_ECHO_SHARD_DROP_CHANCE) {
				return;
			}

			ItemEntity shardDrop = new ItemEntity(
					serverWorld,
					entity.getX(),
					entity.getY(),
					entity.getZ(),
					new ItemStack(Items.ECHO_SHARD)
			);
			shardDrop.setToDefaultPickupDelay();
			serverWorld.spawnEntity(shardDrop);
		});
	}
}