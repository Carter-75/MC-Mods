/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 */
package org.valkyrienskies.mod.mixinducks.world.entity;

import net.minecraft.class_243;
import org.valkyrienskies.mod.common.util.MinecraftPlayer;

public interface PlayerDuck {
    public MinecraftPlayer vs_getPlayer();

    public class_243 vs_getQueuedPositionUpdate();

    public void vs_setQueuedPositionUpdate(class_243 var1);

    public boolean vs_handledMovePacket();

    public void vs_setHandledMovePacket(boolean var1);
}

