/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.SortedSet;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTasks;

public final class CW
implements VsiChunkWatchTasks {
    private final SortedSet<VsiChunkWatchTask> a;
    private final SortedSet<VsiChunkUnwatchTask> b;

    public CW(SortedSet<VsiChunkWatchTask> sortedSet, SortedSet<VsiChunkUnwatchTask> sortedSet2) {
        Intrinsics.checkNotNullParameter(sortedSet, (String)"");
        Intrinsics.checkNotNullParameter(sortedSet2, (String)"");
        this.a = sortedSet;
        this.b = sortedSet2;
    }

    @Override
    public final SortedSet<VsiChunkWatchTask> getWatchTasks() {
        return this.a;
    }

    @Override
    public final SortedSet<VsiChunkUnwatchTask> getUnwatchTasks() {
        return this.b;
    }

    @Override
    public final SortedSet<VsiChunkWatchTask> component1() {
        return this.a;
    }

    @Override
    public final SortedSet<VsiChunkUnwatchTask> component2() {
        return this.b;
    }

    private static CW a(SortedSet<VsiChunkWatchTask> sortedSet, SortedSet<VsiChunkUnwatchTask> sortedSet2) {
        Intrinsics.checkNotNullParameter(sortedSet, (String)"");
        Intrinsics.checkNotNullParameter(sortedSet2, (String)"");
        return new CW(sortedSet, sortedSet2);
    }

    private static /* synthetic */ CW a(CW object, SortedSet sortedSet, SortedSet sortedSet2, int n2) {
        if ((n2 & 1) != 0) {
            sortedSet = ((CW)object).a;
        }
        if ((n2 & 2) != 0) {
            sortedSet2 = ((CW)object).b;
        }
        SortedSet<VsiChunkWatchTask> sortedSet3 = sortedSet;
        sortedSet = sortedSet2;
        object = sortedSet3;
        Intrinsics.checkNotNullParameter(sortedSet3, (String)"");
        Intrinsics.checkNotNullParameter(sortedSet, (String)"");
        return new CW((SortedSet<VsiChunkWatchTask>)object, sortedSet);
    }

    public final String toString() {
        return "ChunkWatchTasksImpl(watchTasks=" + this.a + ", unwatchTasks=" + this.b + ")";
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        CW cW;
        if (this == other) {
            return true;
        }
        if (!(other instanceof CW)) {
            return false;
        }
        cW = cW;
        if (!Intrinsics.areEqual(this.a, cW.a)) {
            return false;
        }
        return Intrinsics.areEqual(this.b, cW.b);
    }
}

