/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.ladders;

import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixin.accessors.entity.EntityAccessor;

@Mixin(value={class_1309.class})
public abstract class MixinLivingEntity
extends class_1297 {
    @Unique
    private boolean isModifyingClimbable = false;

    @Shadow
    public abstract boolean method_6101();

    public MixinLivingEntity(class_1299<?> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Inject(at={@At(value="TAIL")}, method={"onClimbable"}, cancellable=true)
    private void onClimbableMixin(CallbackInfoReturnable<Boolean> cir) {
        if (!((Boolean)cir.getReturnValue()).booleanValue()) {
            if (this.isModifyingClimbable) {
                return;
            }
            this.isModifyingClimbable = true;
            class_243 pos = this.method_19538();
            double origX = pos.field_1352;
            double origY = pos.field_1351;
            double origZ = pos.field_1350;
            EntityAccessor thisAsAccessor = (EntityAccessor)((Object)this);
            class_2338 originalBlockPosition = thisAsAccessor.getBlockPosition();
            VSGameUtilsKt.transformToNearbyShipsAndWorld(this.method_37908(), origX, origY, origZ, 1.0, (x, y, z) -> {
                if (cir.getReturnValue() != Boolean.TRUE) {
                    thisAsAccessor.setBlockPosition(class_2338.method_49637((double)class_3532.method_15357((double)x), (double)class_3532.method_15357((double)y), (double)class_3532.method_15357((double)z)));
                    thisAsAccessor.setFeetBlockState(null);
                    if (this.method_6101()) {
                        cir.setReturnValue((Object)true);
                    }
                }
            });
            thisAsAccessor.setBlockPosition(originalBlockPosition);
            thisAsAccessor.setFeetBlockState(null);
            this.isModifyingClimbable = false;
        }
    }
}

