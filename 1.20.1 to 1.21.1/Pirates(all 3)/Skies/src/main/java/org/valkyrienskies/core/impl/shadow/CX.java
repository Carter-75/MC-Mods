/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.SortedSet;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.CW;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;

public final class CX {
    public static final CW a(SortedSet<VsiChunkWatchTask> sortedSet, SortedSet<VsiChunkUnwatchTask> sortedSet2) {
        Intrinsics.checkNotNullParameter(sortedSet, (String)"");
        Intrinsics.checkNotNullParameter(sortedSet2, (String)"");
        return new CW(sortedSet, sortedSet2);
    }
}

