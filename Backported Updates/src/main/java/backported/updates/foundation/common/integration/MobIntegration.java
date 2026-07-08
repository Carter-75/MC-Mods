/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SpawnRestriction$SpawnPredicate
 *  net.minecraft.entity.ai.goal.Goal
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.entity.attribute.DefaultAttributeContainer$Builder
 *  net.minecraft.entity.SpawnLocation
 */
package backported.updates.foundation.common.integration;

import backported.updates.foundation.common.events.EntityEvents;
import backported.updates.foundation.common.integration.MobInteraction;
import backported.updates.foundation.common.integration.fabric.MobIntegrationImpl;
import backported.updates.foundation.core.util.event.CancellableResult;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.Heightmap;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.SpawnLocation;

public class MobIntegration {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerIntegrations(Consumer<Event> listener) {
        MobIntegrationImpl.registerIntegrations(listener);
    }

    public static interface Event {
        public void registerMobInteraction(MobInteraction var1);

        public void registerAttributes(Supplier<? extends EntityType<? extends LivingEntity>> var1, Supplier<DefaultAttributeContainer.Builder> var2);

        public <T extends MobEntity> void registerPlacement(Supplier<EntityType<T>> var1, SpawnLocation var2, Heightmap.Type var3, SpawnRestriction.SpawnPredicate<T> var4);

        default public void registerGoal(Predicate<MobEntity> predicate, int priority, Function<MobEntity, Goal> factory) {
            EntityEvents.ON_SPAWN.register((entity, level) -> {
                MobEntity mob;
                if (entity instanceof MobEntity && predicate.test(mob = (MobEntity)entity)) {
                    mob.goalSelector.add(priority, (Goal)factory.apply(mob));
                }
                return CancellableResult.PASS;
            });
        }

        default public void registerGoal(EntityType<?> entity, int priority, Function<MobEntity, Goal> factory) {
            this.registerGoal((MobEntity mob) -> mob.getType() == entity, priority, factory);
        }

        default public void registerTarget(Predicate<MobEntity> predicate, int priority, Function<MobEntity, Goal> factory) {
            EntityEvents.ON_SPAWN.register((entity, level) -> {
                MobEntity mob;
                if (entity instanceof MobEntity && predicate.test(mob = (MobEntity)entity)) {
                    mob.targetSelector.add(priority, (Goal)factory.apply(mob));
                }
                return CancellableResult.PASS;
            });
        }

        default public void registerTarget(EntityType<? extends Entity> entity, int priority, Function<MobEntity, Goal> factory) {
            this.registerTarget((MobEntity mob) -> mob.getType() == entity, priority, factory);
        }
    }
}

