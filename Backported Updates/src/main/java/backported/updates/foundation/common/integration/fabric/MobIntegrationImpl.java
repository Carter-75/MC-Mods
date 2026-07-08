/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.player.UseEntityCallback
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SpawnRestriction
 *  net.minecraft.entity.SpawnRestriction$Entry
 *  net.minecraft.entity.SpawnRestriction$SpawnPredicate
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.entity.attribute.DefaultAttributeContainer$Builder
 *  net.minecraft.entity.SpawnLocation
 */
package backported.updates.foundation.common.integration.fabric;

import backported.updates.foundation.common.integration.MobIntegration;
import backported.updates.foundation.common.integration.MobInteraction;
import backported_updates.mixin.foundation.access.SpawnPlacementsAccessor;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.SpawnLocation;

public class MobIntegrationImpl {
    public static void registerIntegrations(Consumer<MobIntegration.Event> listener) {
        listener.accept(new MobIntegration.Event(){

            @Override
            public void registerMobInteraction(MobInteraction interaction) {
                UseEntityCallback.EVENT.register((player, level, hand, entity, hit) -> interaction.onInteract(player, entity, hand));
            }

            @Override
            public void registerAttributes(Supplier<? extends EntityType<? extends LivingEntity>> type, Supplier<DefaultAttributeContainer.Builder> builder) {
                FabricDefaultAttributeRegistry.register(type.get(), (DefaultAttributeContainer.Builder)builder.get());
            }

            @Override
            public <T extends MobEntity> void registerPlacement(Supplier<EntityType<T>> entity, SpawnLocation spawnPlacement, Heightmap.Type heightmap, SpawnRestriction.SpawnPredicate<T> spawnPredicate) {
                if (SpawnPlacementsAccessor.getRESTRICTIONS().get(entity.get()) == null) {
                    SpawnRestriction.register(entity.get(), (SpawnLocation)spawnPlacement, (Heightmap.Type)heightmap, spawnPredicate);
                }
            }
        });
    }
}

