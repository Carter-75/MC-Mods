/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Share
 *  com.llamalad7.mixinextras.sugar.ref.LocalRef
 *  com.simibubi.create.content.fluids.drain.ItemDrainBlock
 *  com.simibubi.create.content.kinetics.millstone.MillstoneBlock
 *  com.simibubi.create.content.logistics.chute.AbstractChuteBlock
 *  com.simibubi.create.content.processing.basin.BasinBlock
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_4970$class_2251
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.simibubi.create.content.fluids.drain.ItemDrainBlock;
import com.simibubi.create.content.kinetics.millstone.MillstoneBlock;
import com.simibubi.create.content.logistics.chute.AbstractChuteBlock;
import com.simibubi.create.content.processing.basin.BasinBlock;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_4970;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={MillstoneBlock.class, BasinBlock.class, AbstractChuteBlock.class, ItemDrainBlock.class})
public class MixinItemFallOnBlocks
extends class_2248 {
    public MixinItemFallOnBlocks(class_4970.class_2251 properties) {
        super(properties);
    }

    @Inject(method={"updateEntityAfterFallOn"}, at={@At(value="HEAD")})
    protected void findIfOnShip(class_1922 worldIn, class_1297 entity, CallbackInfo ci, @Share(value="ship") LocalRef<Ship> ship) {
        List<Vector3d> possiblePositions = VSGameUtilsKt.transformToNearbyShipsAndWorld(entity.method_37908(), entity.method_23317(), entity.method_23318(), entity.method_23321(), entity.method_5829().method_995());
        for (Vector3d tempPos : possiblePositions) {
            class_2338 tempBlockPos = class_2338.method_49637((double)tempPos.x, (double)tempPos.y, (double)tempPos.z);
            if (!worldIn.method_8320(tempBlockPos).method_27852((class_2248)((Object)((Object)this)).getClass().cast((Object)this)) && !worldIn.method_8320(tempBlockPos.method_10074()).method_27852((class_2248)((Object)((Object)this)).getClass().cast((Object)this))) continue;
            ship.set((Object)VSGameUtilsKt.getShipManagingPos(entity.method_37908(), (Vector3dc)tempPos));
            break;
        }
    }

    @Redirect(method={"updateEntityAfterFallOn"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;blockPosition()Lnet/minecraft/core/BlockPos;"), require=0)
    protected class_2338 redirectBlockPosition(class_1297 entity, @Share(value="ship") LocalRef<Ship> ship) {
        if (ship.get() != null) {
            Vector3d posInShip = ((Ship)ship.get()).getTransform().getWorldToShip().transformPosition(entity.method_23317(), entity.method_23318(), entity.method_23321(), new Vector3d());
            return class_2338.method_49637((double)posInShip.x, (double)posInShip.y, (double)posInShip.z);
        }
        return entity.method_24515();
    }

    @Redirect(method={"updateEntityAfterFallOn"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;position()Lnet/minecraft/world/phys/Vec3;"), require=0)
    private class_243 redirectPosition(class_1297 entity, @Share(value="ship") LocalRef<Ship> ship) {
        if (ship.get() != null) {
            Vector3d posInShip = ((Ship)ship.get()).getTransform().getWorldToShip().transformPosition(entity.method_23317(), entity.method_23318(), entity.method_23321(), new Vector3d());
            return VectorConversionsMCKt.toMinecraft(posInShip);
        }
        return entity.method_19538();
    }

    @Redirect(method={"updateEntityAfterFallOn"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getDeltaMovement()Lnet/minecraft/world/phys/Vec3;"), require=0)
    private class_243 redirectDeltaMovement(class_1297 entity, @Share(value="ship") LocalRef<Ship> ship) {
        if (ship.get() != null) {
            Vector3d deltaInShip = VectorConversionsMCKt.toJOML(entity.method_18798());
            ((Ship)ship.get()).getTransform().getWorldToShip().transformDirection(deltaInShip);
            return VectorConversionsMCKt.toMinecraft(deltaInShip);
        }
        return entity.method_18798();
    }
}

