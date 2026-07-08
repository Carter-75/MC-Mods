/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.actors.trainControls.ControlsInputPacket
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3222
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.packets;

import com.simibubi.create.content.contraptions.actors.trainControls.ControlsInputPacket;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3222;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={ControlsInputPacket.class})
public abstract class MixinControlsInputPacket {
    @Unique
    private class_1937 level;

    @Redirect(method={"lambda$handle$0"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;closerThan(Lnet/minecraft/core/Position;D)Z"))
    private boolean redirectCloserThan(class_243 instance, class_2374 arg, double d2) {
        class_243 newVec3 = instance;
        if (VSGameUtilsKt.isBlockInShipyard(this.level, class_2338.method_49637((double)instance.field_1352, (double)instance.field_1351, (double)instance.field_1350))) {
            Ship ship = VSGameUtilsKt.getShipManagingPos(this.level, (class_2374)instance);
            newVec3 = VSGameUtilsKt.toWorldCoordinates(ship, instance);
        }
        return newVec3.method_24802(arg, d2);
    }

    @Redirect(method={"lambda$handle$0"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerPlayer;getCommandSenderWorld()Lnet/minecraft/world/level/Level;"))
    private class_1937 stealLevel(class_3222 player) {
        this.level = player.method_5770();
        return this.level;
    }
}

