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
import org.valkyrienskies.core.impl.api.ServerShipProvider;

@Deprecated(message="sus")
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028'@'X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/api/ServerShipUser;", "Lorg/valkyrienskies/core/impl/api/ServerShipProvider;", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "getShip", "()Lorg/valkyrienskies/core/api/ships/ServerShip;", "setShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;)V", "ship"})
public interface ServerShipUser
extends ServerShipProvider {
    @Override
    @JvmName(name="getShip")
    public ServerShip getShip();

    @JvmName(name="setShip")
    public void setShip(ServerShip var1);
}

