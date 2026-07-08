/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1838
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_3965
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.block_placement;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1838;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_3965;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.PlayerUtil;

@Mixin(value={class_1750.class})
public abstract class MixinBlockPlaceContext
extends class_1838 {
    public MixinBlockPlaceContext(class_1657 player, class_1268 interactionHand, class_3965 blockHitResult) {
        super(player, interactionHand, blockHitResult);
        throw new AssertionError();
    }

    @Shadow
    public abstract class_2338 method_8037();

    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/core/Direction;orderedByNearest(Lnet/minecraft/world/entity/Entity;)[Lnet/minecraft/core/Direction;")}, method={"getNearestLookingDirections"})
    private class_2350[] transformPlayerBeforeGettingNearest(class_1297 entity, Operation<class_2350[]> orderedByNearest) {
        if (entity instanceof class_1657) {
            return (class_2350[])PlayerUtil.transformPlayerTemporarily((class_1657)entity, this.method_8045(), this.method_8037(), () -> (class_2350[])orderedByNearest.call(new Object[]{entity}));
        }
        return (class_2350[])orderedByNearest.call(new Object[]{entity});
    }
}

