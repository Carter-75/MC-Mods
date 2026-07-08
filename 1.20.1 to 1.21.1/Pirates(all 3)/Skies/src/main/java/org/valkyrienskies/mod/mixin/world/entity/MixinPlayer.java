/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package org.valkyrienskies.mod.mixin.world.entity;

import net.minecraft.class_1657;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.valkyrienskies.mod.common.util.MinecraftPlayer;
import org.valkyrienskies.mod.mixinducks.world.entity.PlayerDuck;

@Mixin(value={class_1657.class})
public class MixinPlayer
implements PlayerDuck {
    @Unique
    private final MinecraftPlayer vsPlayer = new MinecraftPlayer((class_1657)class_1657.class.cast(this));
    @Unique
    private class_243 queuedPositionUpdate = null;
    @Unique
    private boolean handledMovePacket = false;

    @Override
    public MinecraftPlayer vs_getPlayer() {
        return this.vsPlayer;
    }

    @Override
    public class_243 vs_getQueuedPositionUpdate() {
        return this.queuedPositionUpdate;
    }

    @Override
    public void vs_setQueuedPositionUpdate(class_243 queuedPositionUpdate) {
        this.queuedPositionUpdate = queuedPositionUpdate;
    }

    @Override
    public boolean vs_handledMovePacket() {
        return this.handledMovePacket;
    }

    @Override
    public void vs_setHandledMovePacket(boolean handledMovePacket) {
        this.handledMovePacket = handledMovePacket;
    }
}

