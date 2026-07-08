/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.entity.ai.brain.sensor.Sensor
 *  net.minecraft.entity.ai.brain.LivingTargetCache
 */
package backported.updates.content.common.level.entities.sensortypes;

import backported.updates.content.core.data.tags.ModEntityTypeTags;
import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import java.util.Set;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.LivingTargetCache;

public class AdultSensorAnyType
extends Sensor<PassiveEntity> {
    public Set<MemoryModuleType<?>> getOutputMemoryModules() {
        return ImmutableSet.of(MemoryModuleType.NEAREST_VISIBLE_ADULT, MemoryModuleType.VISIBLE_MOBS);
    }

    protected void sense(ServerWorld level, PassiveEntity entity) {
        entity.getBrain().getOptionalRegisteredMemory(MemoryModuleType.VISIBLE_MOBS).ifPresent(entities -> this.setNearestVisibleAdult(entity, (LivingTargetCache)entities));
    }

    private void setNearestVisibleAdult(PassiveEntity mob, LivingTargetCache entities) {
        Optional<PassiveEntity> adult = entities.findFirst(entity -> entity.getType().isIn(ModEntityTypeTags.FOLLOWABLE_FRIENDLY_MOBS) && !entity.isBaby()).map(PassiveEntity.class::cast);
        mob.getBrain().remember(MemoryModuleType.NEAREST_VISIBLE_ADULT, adult);
    }
}

