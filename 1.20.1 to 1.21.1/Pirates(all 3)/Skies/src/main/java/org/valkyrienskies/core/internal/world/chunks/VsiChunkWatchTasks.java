/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.world.chunks;

import java.util.SortedSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0005R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0005\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\f\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkWatchTasks;", "", "Ljava/util/SortedSet;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkWatchTask;", "component1", "()Ljava/util/SortedSet;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkUnwatchTask;", "component2", "getUnwatchTasks", "unwatchTasks", "getWatchTasks", "watchTasks", "internal"})
public interface VsiChunkWatchTasks {
    @NotNull
    public SortedSet<VsiChunkWatchTask> getWatchTasks();

    @NotNull
    public SortedSet<VsiChunkUnwatchTask> getUnwatchTasks();

    default public /* synthetic */ SortedSet component1() {
        return this.getWatchTasks();
    }

    default public /* synthetic */ SortedSet component2() {
        return this.getUnwatchTasks();
    }
}

