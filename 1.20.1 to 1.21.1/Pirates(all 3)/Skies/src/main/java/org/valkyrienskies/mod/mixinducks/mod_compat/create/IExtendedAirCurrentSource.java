/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.kinetics.fan.IAirCurrentSource
 */
package org.valkyrienskies.mod.mixinducks.mod_compat.create;

import com.simibubi.create.content.kinetics.fan.IAirCurrentSource;
import org.valkyrienskies.core.api.ships.Ship;

public interface IExtendedAirCurrentSource
extends IAirCurrentSource {
    public Ship getShip();
}

