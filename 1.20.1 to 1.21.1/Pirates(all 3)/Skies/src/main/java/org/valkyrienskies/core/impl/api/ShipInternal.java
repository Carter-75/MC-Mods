/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.api;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.valkyrienskies.core.internal.ships.VsiShip;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JG\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\r\u0010\u000eR \u0010\u0015\u001a\u00060\u000fj\u0002`\u00108'@'X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/api/ShipInternal;", "Lorg/valkyrienskies/core/internal/ships/VsiShip;", "", "posX", "posY", "posZ", "", "newBlockIsAir", "", "oldBlockMass", "newBlockMass", "isRunningOnServer", "", "onSetBlock", "(IIIZDDZ)V", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getChunkClaimDimension", "()Ljava/lang/String;", "setChunkClaimDimension", "(Ljava/lang/String;)V", "chunkClaimDimension"})
public interface ShipInternal
extends VsiShip {
    @Override
    @JvmName(name="getChunkClaimDimension")
    public String getChunkClaimDimension();

    @JvmName(name="setChunkClaimDimension")
    public void setChunkClaimDimension(String var1);

    public void onSetBlock(int var1, int var2, int var3, boolean var4, double var5, double var7, boolean var9);
}

