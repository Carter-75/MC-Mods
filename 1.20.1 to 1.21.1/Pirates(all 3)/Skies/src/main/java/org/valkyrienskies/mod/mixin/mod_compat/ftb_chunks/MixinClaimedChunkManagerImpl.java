/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package org.valkyrienskies.mod.mixin.mod_compat.ftb_chunks;

import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Pseudo
@Mixin(targets={"dev.ftb.mods.ftbchunks.data.ClaimedChunkManagerImpl"})
public abstract class MixinClaimedChunkManagerImpl {
    @Unique
    private class_1297 entity = null;

    @ModifyVariable(method={"shouldPreventInteraction"}, at=@At(value="HEAD"), name={"actor"}, remap=false)
    private class_1297 ValkyrienSkies$entity(class_1297 entity) {
        this.entity = entity;
        return entity;
    }

    @ModifyArg(method={"shouldPreventInteraction"}, at=@At(value="INVOKE", target="Ldev/ftb/mods/ftblibrary/math/ChunkDimPos;<init>(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V"))
    private class_2338 ValkyrienSkies$newChunkDimPos(class_2338 pos) {
        if (this.entity == null || !VSGameConfig.SERVER.getFTBChunks().getShipsProtectedByClaims()) {
            return pos;
        }
        class_1937 level = this.entity.method_37908();
        Ship ship = VSGameUtilsKt.getShipManagingPos(level, pos);
        if (ship == null) {
            return pos;
        }
        Vector3d vec = ship.getShipToWorld().transformPosition(new Vector3d(pos.method_10263(), pos.method_10264(), pos.method_10260()));
        class_2338 newPos = class_2338.method_49638((class_2374)VectorConversionsMCKt.toMinecraft(vec));
        if (!(newPos.method_10264() <= level.method_31600() && newPos.method_10264() >= level.method_31607() || VSGameConfig.SERVER.getFTBChunks().getShipsProtectionOutOfBuildHeight())) {
            return pos;
        }
        return newPos;
    }
}

