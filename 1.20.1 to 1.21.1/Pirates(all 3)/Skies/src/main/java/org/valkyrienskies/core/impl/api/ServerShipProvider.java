/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.api;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.valkyrienskies.core.api.ships.ServerShip;

@Deprecated(message="sus")
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/api/ServerShipProvider;", "", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "getShip", "()Lorg/valkyrienskies/core/api/ships/ServerShip;", "ship"})
public interface ServerShipProvider {
    @JvmName(name="getShip")
    public ServerShip getShip();
}

