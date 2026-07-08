/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.ChickenEntity
 *  net.minecraft.entity.projectile.thrown.EggEntity
 *  net.minecraft.world.World
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.entity.projectile.thrown.ThrownItemEntity
 *  net.minecraft.registry.RegistryKey
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported.updates.content.common.api.variant.VariantUtils;
import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.common.registries.ModDataComponents;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.Optional;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.world.World;
import net.minecraft.util.hit.HitResult;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EggEntity.class})
public abstract class ThrownEggMixin
extends ThrownItemEntity {
    public ThrownEggMixin(EntityType<? extends ThrownItemEntity> entityType, World level) {
        super(entityType, level);
    }

    @Inject(method={"onEntityHit"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/passive/ChickenEntity;refreshPositionAndAngles(DDDFF)V", shift=At.Shift.AFTER)})
    private void setChickenVariant(HitResult result, CallbackInfo ci, @Local ChickenEntity chicken) {
        Optional.ofNullable(this.getStack().get(ModDataComponents.CHICKEN_VARIANT.get())).map(key -> VariantUtils.getDefault(ModBuiltinRegistries.CHICKEN_VARIANTS, key)).ifPresent(variant -> VariantDataHolder.getHolder((LivingEntity)chicken).setVariantData((ChickenVariant)variant));
    }
}

