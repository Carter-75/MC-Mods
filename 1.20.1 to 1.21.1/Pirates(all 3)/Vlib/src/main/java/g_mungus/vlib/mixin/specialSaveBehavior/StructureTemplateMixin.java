/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  net.minecraft.class_3499
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.valkyrienskies.core.api.ships.LoadedShip
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 */
package g_mungus.vlib.mixin.specialSaveBehavior;

import g_mungus.vlib.v2.api.experimental.HasSpecialSaveBehavior;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import net.minecraft.class_3499;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_3499.class})
public abstract class StructureTemplateMixin {
    @Redirect(method={"fillFromWorld(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Vec3i;ZLnet/minecraft/world/level/block/Block;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;getBlockEntity(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/entity/BlockEntity;"))
    private class_2586 redirectGetBlockEntity(class_1937 level, class_2338 pos) {
        class_2586 blockEntity = level.method_8321(pos);
        LoadedShip ship = VSGameUtilsKt.getShipObjectManagingPos((class_1937)level, (class_2382)pos);
        if (ship != null && blockEntity instanceof HasSpecialSaveBehavior) {
            HasSpecialSaveBehavior it = (HasSpecialSaveBehavior)blockEntity;
            it.executeWhenSavingShip();
        }
        return blockEntity;
    }
}

