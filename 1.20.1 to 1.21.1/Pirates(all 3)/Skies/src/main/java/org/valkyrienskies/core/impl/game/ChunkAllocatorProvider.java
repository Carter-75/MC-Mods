/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.game;

import kotlin.Metadata;
import org.valkyrienskies.core.impl.game.ChunkAllocator;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ChunkAllocatorProvider;", "", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "forDimension", "(Ljava/lang/String;)Lorg/valkyrienskies/core/impl/game/ChunkAllocator;"})
public interface ChunkAllocatorProvider {
    public ChunkAllocator forDimension(String var1);
}

