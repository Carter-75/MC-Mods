/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_3730
 *  net.minecraft.class_5425
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.mim1q.derelict.mixin.entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.mim1q.derelict.config.DerelictConfigs;
import dev.mim1q.derelict.entity.SpiderlingEntity;
import dev.mim1q.derelict.init.ModEntities;
import dev.mim1q.derelict.init.ModStatusEffects;
import dev.mim1q.derelict.init.component.ModCardinalComponents;
import dev.mim1q.derelict.tag.ModEntityTags;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_3730;
import net.minecraft.class_5425;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1309.class})
public abstract class LivingEntityMixin
extends class_1297 {
    public LivingEntityMixin(class_1299<?> type, class_1937 world) {
        super(type, world);
    }

    @Inject(method={"onDeath"}, at={@At(value="HEAD")})
    private void derelict$onDeath(class_1282 source, CallbackInfo ci) {
        if (this.method_5864().method_20210(ModEntityTags.INSTANCE.getSPAWNS_SPIDERLINGS_ON_DEATH()) && !this.method_37908().field_9236 && this.field_5974.method_43057() < DerelictConfigs.CONFIG.spiderlingSpawnChance() / 100.0f) {
            SpiderlingEntity spiderling = (SpiderlingEntity)ModEntities.INSTANCE.getSPIDERLING().method_5883(this.method_37908());
            if (spiderling == null) {
                return;
            }
            spiderling.method_5808(this.method_23317(), this.method_23318(), this.method_23321(), this.field_5974.method_43057() * 360.0f, 0.0f);
            spiderling.method_5943((class_5425)this.method_37908(), this.method_37908().method_8404(this.method_24515()), class_3730.field_16467, null, null);
            this.method_37908().method_8649((class_1297)spiderling);
        }
    }

    @WrapOperation(method={"applyMovementInput"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V")})
    private void derelict$cancelMovement(class_1309 instance, float v, class_243 movementInput, Operation<Void> original) {
        if (ModCardinalComponents.INSTANCE.hasClientSyncedEffect((class_1309)this, ModStatusEffects.INSTANCE.getCOBWEBBED())) {
            original.call(new Object[]{instance, Float.valueOf(v), new class_243(0.0, Math.min(0.0, movementInput.field_1351), 0.0)});
            return;
        }
        original.call(new Object[]{instance, Float.valueOf(v), movementInput});
    }
}

