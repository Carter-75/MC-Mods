/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Deprecated(message="ShipForcesInducer is deprecated, use ShipPhysicsListener instead.", replaceWith=@ReplaceWith(expression="ShipPhysicsListener", imports={"org.valkyrienskies.core.api.ships.ShipPhysicsListener"}), level=DeprecationLevel.ERROR)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0002\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/ShipForcesInducer;", "", "api"})
public interface ShipForcesInducer {
}

