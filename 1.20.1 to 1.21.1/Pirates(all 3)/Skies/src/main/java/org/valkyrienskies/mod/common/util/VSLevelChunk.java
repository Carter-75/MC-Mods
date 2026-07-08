/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.mod.common.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\b\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/common/util/VSLevelChunk;", "", "", "clearChunk", "()V", "srcChunk", "copyChunkFromOtherDimension", "(Lorg/valkyrienskies/mod/common/util/VSLevelChunk;)V", "valkyrienskies-120"})
public interface VSLevelChunk {
    public void clearChunk();

    public void copyChunkFromOtherDimension(@NotNull VSLevelChunk var1);
}

