/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.module.SimpleModule;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsImpl;
import org.valkyrienskies.core.impl.bodies.properties.BodyTransformImpl;
import org.valkyrienskies.core.impl.chunk_tracking.ShipActiveChunksSet;
import org.valkyrienskies.core.impl.game.ChunkClaimImpl;

public final class GN
extends SimpleModule {
    public GN() {
        SimpleModule simpleModule = this;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(IShipActiveChunksSet.class, ShipActiveChunksSet.class), (String)"");
        simpleModule = this;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(ChunkClaim.class, ChunkClaimImpl.class), (String)"");
        simpleModule = this;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(ShipTransform.class, BodyTransformImpl.class), (String)"");
        simpleModule = this;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(BodyTransform.class, BodyTransformImpl.class), (String)"");
        simpleModule = this;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(BodyKinematics.class, BodyKinematicsImpl.class), (String)"");
    }
}

