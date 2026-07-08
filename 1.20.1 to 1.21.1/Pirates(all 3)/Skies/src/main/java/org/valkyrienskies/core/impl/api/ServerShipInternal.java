/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.api;

import kotlin.Metadata;
import org.valkyrienskies.core.impl.api.ShipInternal;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.internal.ships.VsiServerShip;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&\u00a2\u0006\u0004\b\u000f\u0010\u000eJ/\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/api/ServerShipInternal;", "Lorg/valkyrienskies/core/internal/ships/VsiServerShip;", "Lorg/valkyrienskies/core/impl/api/ShipInternal;", "", "areVoxelsFullyLoaded", "()Z", "Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "asShipDataCommon", "()Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "", "chunkX", "chunkZ", "", "onLoadChunk", "(II)V", "onUnloadChunk", "posX", "posY", "posZ", "set", "updateShipAABBGenerator", "(IIIZ)V"})
public interface ServerShipInternal
extends ShipInternal,
VsiServerShip {
    public ShipDataCommon asShipDataCommon();

    public void updateShipAABBGenerator(int var1, int var2, int var3, boolean var4);

    public void onLoadChunk(int var1, int var2);

    public void onUnloadChunk(int var1, int var2);

    public boolean areVoxelsFullyLoaded();
}

