/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.bodies.shape;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.bodies.shape.VoxelType;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\nR\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/shape/VoxelUpdate;", "", "", "getChunkX", "()I", "chunkX", "getChunkY", "chunkY", "getChunkZ", "chunkZ", "Builder", "api"})
public interface VoxelUpdate {
    public int getChunkX();

    public int getChunkY();

    public int getChunkZ();

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&\u00a2\u0006\u0004\b\f\u0010\r\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000e\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/shape/VoxelUpdate$Builder;", "", "", "x", "y", "z", "Lorg/valkyrienskies/core/api/bodies/shape/VoxelType;", "block", "", "addBlock", "(IIILorg/valkyrienskies/core/api/bodies/shape/VoxelType;)V", "Lorg/valkyrienskies/core/api/bodies/shape/VoxelUpdate;", "build", "()Lorg/valkyrienskies/core/api/bodies/shape/VoxelUpdate;", "api"})
    public static interface Builder {
        public void addBlock(int var1, int var2, int var3, @NotNull VoxelType var4);

        @NotNull
        public VoxelUpdate build();
    }
}

