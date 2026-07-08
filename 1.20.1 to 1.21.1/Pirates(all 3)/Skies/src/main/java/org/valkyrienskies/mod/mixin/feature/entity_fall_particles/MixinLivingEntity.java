/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Share
 *  com.llamalad7.mixinextras.sugar.ref.LocalRef
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.entity_fall_particles;

import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixin.accessors.entity.EntityAccessor;

@Mixin(value={class_1309.class})
public abstract class MixinLivingEntity
extends class_1297 {
    public MixinLivingEntity(class_1299<?> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Inject(method={"checkFallDamage"}, at={@At(value="HEAD")})
    private void toShip(double d2, boolean bl, class_2680 blockState, class_2338 blockPos, CallbackInfo ci, @Share(value="originalPos") LocalRef<class_243> originalPos) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.method_37908(), blockPos);
        if (ship != null) {
            originalPos.set((Object)this.method_19538());
            Vector3d posInShip = ship.getTransform().getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(this.method_19538()));
            ((EntityAccessor)((Object)this)).setPosNoUpdates(VectorConversionsMCKt.toMinecraft(posInShip));
        }
    }

    @Inject(method={"checkFallDamage"}, at={@At(value="RETURN")})
    private void toWorld(double d2, boolean bl, class_2680 blockState, class_2338 blockPos, CallbackInfo ci, @Share(value="originalPos") LocalRef<class_243> originalPos) {
        if (originalPos.get() != null) {
            ((EntityAccessor)((Object)this)).setPosNoUpdates((class_243)originalPos.get());
        }
    }
}

