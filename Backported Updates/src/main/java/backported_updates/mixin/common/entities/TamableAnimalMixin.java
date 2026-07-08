/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.TameableEntity
 *  net.minecraft.world.World
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package backported_updates.mixin.common.entities;

import backported_updates.mixin.common.entities.MobMixin;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={TameableEntity.class})
public abstract class TamableAnimalMixin
extends MobMixin {
    @Shadow
    public abstract boolean isTamed();

    protected TamableAnimalMixin(EntityType<? extends LivingEntity> entityType, World level) {
        super(entityType, level);
    }
}

