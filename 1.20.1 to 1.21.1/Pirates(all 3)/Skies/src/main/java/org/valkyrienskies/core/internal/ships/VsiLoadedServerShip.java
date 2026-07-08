/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.ships;

import kotlin.Metadata;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.internal.ships.VsiLoadedShip;
import org.valkyrienskies.core.internal.ships.VsiServerShip;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH&\u00a2\u0006\u0004\b\t\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/ships/VsiLoadedServerShip;", "Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "Lorg/valkyrienskies/core/internal/ships/VsiServerShip;", "Lorg/valkyrienskies/core/internal/ships/VsiLoadedShip;", "", "decayPortalCoolDown", "()V", "handleInsidePortal", "", "isOnPortalCoolDown", "()Z", "internal"})
public interface VsiLoadedServerShip
extends LoadedServerShip,
VsiServerShip,
VsiLoadedShip {
    public boolean isOnPortalCoolDown();

    public void handleInsidePortal();

    public void decayPortalCoolDown();
}

