/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.PathAwareEntity
 *  net.minecraft.entity.ai.goal.FleeEntityGoal
 *  net.minecraft.entity.ai.goal.Goal
 *  net.minecraft.entity.mob.IllagerEntity
 *  net.minecraft.world.World
 *  net.minecraft.entity.raid.RaiderEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.garden;

import backported.updates.garden.entity.CreakingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.world.World;
import net.minecraft.entity.raid.RaiderEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={IllagerEntity.class})
public abstract class IllagerEntityMixin
extends RaiderEntity {
    protected IllagerEntityMixin(EntityType<? extends RaiderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method={"initGoals"}, at={@At(value="TAIL")})
    public void initGoals(CallbackInfo ci) {
        this.goalSelector.add(3, (Goal)new FleeEntityGoal((PathAwareEntity)this, CreakingEntity.class, 8.0f, 1.0, 1.2));
    }
}

