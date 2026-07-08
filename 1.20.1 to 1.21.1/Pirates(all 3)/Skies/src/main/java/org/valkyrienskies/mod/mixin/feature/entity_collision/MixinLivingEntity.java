/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.entity_collision;

import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.EntityLerper;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;

@Mixin(value={class_1309.class})
public abstract class MixinLivingEntity
extends class_1297 {
    public MixinLivingEntity(class_1299<?> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Inject(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/LivingEntity;aiStep()V", shift=At.Shift.BEFORE)})
    private void preAiStep(CallbackInfo ci) {
        if (this.method_37908() != null && this.method_37908().method_8608() && !this.field_5953) {
            Object ship;
            class_1657 player;
            MixinLivingEntity mixinLivingEntity;
            if (this.method_5787() || (mixinLivingEntity = this) instanceof class_1657 && (player = (class_1657)mixinLivingEntity).method_7340()) {
                return;
            }
            EntityDraggingInformation dragInfo = ((IEntityDraggingInformationProvider)((Object)this)).getDraggingInformation();
            if (dragInfo != null && dragInfo.getLastShipStoodOn() != null && (ship = VSGameUtilsKt.getShipObjectWorld(this.method_37908()).getAllShips().getById(dragInfo.getLastShipStoodOn())) != null) {
                EntityLerper.INSTANCE.lerpStep(dragInfo, (Ship)ship, (class_1297)((class_1309)this));
                EntityLerper.INSTANCE.lerpHeadStep(dragInfo, (Ship)ship, (class_1297)((class_1309)this));
            }
        }
    }
}

