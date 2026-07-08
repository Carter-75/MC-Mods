/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.collection.LongObjectMap
 *  net.minecraft.class_2818
 */
package org.valkyrienskies.mod.mixinducks.client.world;

import io.netty.util.collection.LongObjectMap;
import net.minecraft.class_2818;
import org.valkyrienskies.core.api.ships.ClientShip;

public interface ClientChunkCacheDuck {
    public LongObjectMap<class_2818> vs$getShipChunks();

    public void vs$removeShip(ClientShip var1);
}

