/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.util.datastructures;

import java.text.NumberFormat;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3i;
import org.joml.Vector3ic;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010#\u001a\u00020\u001b\u00a2\u0006\u0004\b4\u00105J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0001\u00a2\u0006\u0004\b\r\u0010\u0010J\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u0011J\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0000\u00a2\u0006\u0004\b\r\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0014H\u0096\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u000eJ\u0015\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0013J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005\u00a2\u0006\u0004\b\u001a\u0010\u0019J5\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u001b\u00a2\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0000\u00a2\u0006\u0004\b&\u0010\u0013J\u0015\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006\u00a2\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016\u00a2\u0006\u0004\b+\u0010,J\u0017\u0010+\u001a\u00020*2\u0006\u0010.\u001a\u00020-H\u0016\u00a2\u0006\u0004\b+\u0010/R\"\u0010#\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u00100\u001a\u0004\b1\u0010 \"\u0004\b2\u00103\u00a8\u00066"}, d2={"Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;", "Lorg/joml/Vector3i;", "", "includeCorners", "includeEdges", "", "Lorg/joml/Vector3ic;", "allRelativeTo", "(ZZ)Ljava/util/Set;", "", "x", "y", "z", "contains", "(III)Z", "vec", "(Lorg/joml/Vector3i;)Z", "(Lorg/joml/Vector3ic;)Z", "other", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;)Z", "", "equals", "(Ljava/lang/Object;)Z", "equalsCertain", "getContaining", "()Ljava/util/Set;", "getContainingAsVoxel", "", "currentExtent", "getHigherLevelVoxel", "(IIIJ)Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;", "getVolume", "()J", "hashCode", "()I", "extent", "modExtent", "(J)Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;", "overlaps", "dir", "relativeTo", "(Lorg/joml/Vector3ic;)Lorg/joml/Vector3ic;", "", "toString", "()Ljava/lang/String;", "Ljava/text/NumberFormat;", "formatter", "(Ljava/text/NumberFormat;)Ljava/lang/String;", "J", "getExtent", "setExtent", "(J)V", "<init>", "(IIIJ)V", "util"})
public final class SparseVoxelPosition
extends Vector3i {
    private long extent;

    public SparseVoxelPosition(int x, int y, int z, long extent) {
        super(x, y, z);
        this.extent = extent;
    }

    public /* synthetic */ SparseVoxelPosition(int n2, int n3, int n4, long l2, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 8) != 0) {
            l2 = 1L;
        }
        this(n2, n3, n4, l2);
    }

    public final long getExtent() {
        return this.extent;
    }

    public final void setExtent(long l2) {
        this.extent = l2;
    }

    @Override
    @NotNull
    public String toString() {
        return super.toString() + " with extent: " + this.extent;
    }

    @Override
    @NotNull
    public String toString(@NotNull NumberFormat formatter) {
        Intrinsics.checkNotNullParameter((Object)formatter, (String)"formatter");
        return super.toString(formatter) + " with extent: " + formatter.format(this.extent);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other instanceof SparseVoxelPosition) {
            return ((SparseVoxelPosition)other).x == this.x && ((SparseVoxelPosition)other).y == this.y && ((SparseVoxelPosition)other).z == this.z && ((SparseVoxelPosition)other).extent == this.extent;
        }
        if (other instanceof Vector3i) {
            return ((Vector3i)other).x >= this.x && ((Vector3i)other).x < this.x + (int)this.extent && ((Vector3i)other).y >= this.y && ((Vector3i)other).y < this.y + (int)this.extent && ((Vector3i)other).z >= this.z && ((Vector3i)other).z < this.z + (int)this.extent;
        }
        return super.equals(other);
    }

    public final boolean equalsCertain(@NotNull SparseVoxelPosition other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return this.x == other.x && this.y == other.y && this.z == other.z && this.extent == other.extent;
    }

    @Override
    public boolean equals(int x, int y, int z) {
        if (this.extent == 1L) {
            return super.equals(x, y, z);
        }
        return x >= this.x && x <= this.x + (int)this.extent - 1 && y >= this.y && y <= this.y + (int)this.extent - 1 && z >= this.z && z <= this.z + (int)this.extent - 1;
    }

    public final boolean contains(int x, int y, int z) {
        return x >= this.x && x <= this.x + (int)this.extent - 1 && y >= this.y && y <= this.y + (int)this.extent - 1 && z >= this.z && z <= this.z + (int)this.extent - 1;
    }

    public final boolean contains(@NotNull SparseVoxelPosition other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return other.x >= this.x && other.x + (int)other.extent - 1 <= this.x + (int)this.extent - 1 && other.y >= this.y && other.y + (int)other.extent - 1 <= this.y + (int)this.extent - 1 && other.z >= this.z && other.z + (int)other.extent - 1 <= this.z + (int)this.extent - 1;
    }

    public final boolean contains(@NotNull Vector3i vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.contains(vec.x, vec.y, vec.z);
    }

    public final boolean contains(@NotNull Vector3ic vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.contains(vec.x(), vec.y(), vec.z());
    }

    public final long getVolume() {
        return this.extent * this.extent * this.extent;
    }

    @NotNull
    public final SparseVoxelPosition modExtent(long extent) {
        this.extent = extent;
        return this;
    }

    public final boolean overlaps(@NotNull SparseVoxelPosition other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return this.x <= other.x + (int)other.extent - 1 && this.x + (int)this.extent - 1 >= other.x && this.y <= other.y + (int)other.extent - 1 && this.y + (int)this.extent - 1 >= other.y && this.z <= other.z + (int)other.extent - 1 && this.z + (int)this.extent - 1 >= other.z;
    }

    @NotNull
    public final Set<Vector3i> getContaining() {
        Set set = new LinkedHashSet();
        int n2 = this.x + (int)this.extent;
        for (int i2 = this.x; i2 < n2; ++i2) {
            int n3 = this.y + (int)this.extent;
            for (int j2 = this.y; j2 < n3; ++j2) {
                int n4 = this.z + (int)this.extent;
                for (int k2 = this.z; k2 < n4; ++k2) {
                    set.add(new Vector3i(i2, j2, k2));
                }
            }
        }
        return set;
    }

    @NotNull
    public final Set<SparseVoxelPosition> getContainingAsVoxel() {
        Set set = new LinkedHashSet();
        int n2 = this.x + (int)this.extent;
        for (int i2 = this.x; i2 < n2; ++i2) {
            int n3 = this.y + (int)this.extent;
            for (int j2 = this.y; j2 < n3; ++j2) {
                int n4 = this.z + (int)this.extent;
                for (int k2 = this.z; k2 < n4; ++k2) {
                    set.add(new SparseVoxelPosition(i2, j2, k2, 0L, 8, null));
                }
            }
        }
        return set;
    }

    @NotNull
    public final SparseVoxelPosition getHigherLevelVoxel(int x, int y, int z, long currentExtent) {
        long targetExtent = currentExtent * 2L;
        int chunkX = x >> 4;
        int chunkY = y >> 4;
        int chunkZ = z >> 4;
        int cornerX = chunkX << 4;
        int cornerY = chunkY << 4;
        int cornerZ = chunkZ << 4;
        SparseVoxelPosition voxel = new SparseVoxelPosition(cornerX, cornerY, cornerZ, 16L);
        int xInChunk = x - cornerX;
        int yInChunk = y - cornerY;
        int zInChunk = z - cornerZ;
        if (targetExtent == 16L) {
            return voxel;
        }
        long loopExtent = 8L;
        do {
            boolean voxelUpper = yInChunk / (int)loopExtent != 0;
            boolean voxelSouth = zInChunk / (int)loopExtent != 0;
            boolean voxelEast = xInChunk / (int)loopExtent != 0;
            int voxelX = voxel.x + (voxelEast ? (int)loopExtent : 0);
            int voxelY = voxel.y + (voxelUpper ? (int)loopExtent : 0);
            int voxelZ = voxel.z + (voxelSouth ? (int)loopExtent : 0);
            voxel = new SparseVoxelPosition(voxelX, voxelY, voxelZ, loopExtent);
            xInChunk = voxelEast ? xInChunk - (int)loopExtent : xInChunk;
            yInChunk = voxelUpper ? yInChunk - (int)loopExtent : yInChunk;
            int n2 = zInChunk = voxelSouth ? zInChunk - (int)loopExtent : zInChunk;
        } while ((loopExtent /= 2L) >= targetExtent);
        return voxel.modExtent(targetExtent);
    }

    public static /* synthetic */ SparseVoxelPosition getHigherLevelVoxel$default(SparseVoxelPosition sparseVoxelPosition, int n2, int n3, int n4, long l2, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n2 = sparseVoxelPosition.x;
        }
        if ((n5 & 2) != 0) {
            n3 = sparseVoxelPosition.y;
        }
        if ((n5 & 4) != 0) {
            n4 = sparseVoxelPosition.z;
        }
        if ((n5 & 8) != 0) {
            l2 = sparseVoxelPosition.extent;
        }
        return sparseVoxelPosition.getHigherLevelVoxel(n2, n3, n4, l2);
    }

    @NotNull
    public final Vector3ic relativeTo(@NotNull Vector3ic dir) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        int relativeX = (dir.x() > 0 ? this.x + (int)this.extent - 1 : this.x) + dir.x();
        int relativeY = (dir.y() > 0 ? this.y + (int)this.extent - 1 : this.y) + dir.y();
        int relativeZ = (dir.z() > 0 ? this.z + (int)this.extent - 1 : this.z) + dir.z();
        return new SparseVoxelPosition(relativeX, relativeY, relativeZ, this.extent);
    }

    @NotNull
    public final Set<Vector3ic> allRelativeTo(boolean includeCorners, boolean includeEdges) {
        Set neighbors = new LinkedHashSet();
        for (int i2 = -1; i2 < 2; ++i2) {
            for (int j2 = -1; j2 < 2; ++j2) {
                for (int k2 = -1; k2 < 2; ++k2) {
                    if (i2 == 0 && j2 == 0 && k2 == 0 || !includeCorners && i2 != 0 && j2 != 0 && k2 != 0 || !includeEdges && (i2 != 0 && j2 != 0 || i2 != 0 && k2 != 0 || j2 != 0 && k2 != 0)) continue;
                    int xModifier = i2 < 0 ? i2 : i2 * (int)this.extent;
                    int yModifier = j2 < 0 ? j2 : j2 * (int)this.extent;
                    int zModifier = k2 < 0 ? k2 : k2 * (int)this.extent;
                    neighbors.add(new Vector3i(this.x + xModifier, this.y + yModifier, this.z + zModifier));
                }
            }
        }
        return neighbors;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + (int)this.extent;
    }
}

