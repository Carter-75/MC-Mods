/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.SheepEntity
 *  net.minecraft.util.DyeColor
 *  net.minecraft.world.World
 *  net.minecraft.util.math.random.Random
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.level.entities.animal.SheepColorSpawnRules;
import backported_updates.mixin.common.entities.MobMixin;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.world.World;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={SheepEntity.class})
public abstract class SheepMixin
extends MobMixin {
    protected SheepMixin(EntityType<? extends LivingEntity> entityType, World level) {
        super(entityType, level);
    }

    @Redirect(method={"initialize"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/passive/SheepEntity;generateDefaultColor(Lnet/minecraft/util/math/random/Random;)Lnet/minecraft/util/DyeColor;"))
    private DyeColor vb$updateColors(Random random) {
        DyeColor originalColor = SheepEntity.generateDefaultColor(random);
        return SheepColorSpawnRules.getRandomSheepColor(originalColor, this.getWorld(), this.getBlockPos(), random);
    }
}

