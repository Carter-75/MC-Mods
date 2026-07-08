/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.util.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.util.datastructures.SparseVoxelPosition;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000`\u0004B\u0007\u00a2\u0006\u0004\b=\u0010>J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\n\u0010\u000eJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000f\u00a2\u0006\u0004\b\n\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0011\u0010\u000bJ\u0015\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0016\u0010\u0019J'\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001cJ'\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010 J\u0017\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u001d\u0010!J\u0017\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001d\u0010\"J\u001a\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u001d\u0010#J3\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030(2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000f\u00a2\u0006\u0004\b)\u0010*J+\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030(2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005\u00a2\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0004\b-\u0010#J/\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u0000\u00a2\u0006\u0004\b/\u00100J\u001f\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010.\u001a\u00028\u0000\u00a2\u0006\u0004\b/\u00101J\u001f\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000f2\u0006\u0010.\u001a\u00028\u0000\u00a2\u0006\u0004\b/\u00102J!\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010.\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b/\u00103J\u001f\u00104\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010.\u001a\u00028\u0000\u00a2\u0006\u0004\b4\u00103J'\u00105\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b5\u0010\u001eJ\u0017\u00105\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b5\u0010!J\u0017\u00105\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000f\u00a2\u0006\u0004\b5\u0010\"J\u0019\u00105\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b5\u0010#J\u0017\u00106\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0004\b6\u0010#RS\u00109\u001a>\u0012\u0004\u0012\u00020\u000f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000307j\b\u0012\u0004\u0012\u00020\u0003`80\u0002j\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000307j\b\u0012\u0004\u0012\u00020\u0003`8`\u00048\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006?"}, d2={"Lorg/valkyrienskies/core/util/datastructures/SparseVoxelOpenHashMap;", "T", "Ljava/util/HashMap;", "Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;", "Lkotlin/collections/HashMap;", "", "x", "y", "z", "", "contains", "(III)Z", "Lorg/joml/Vector3i;", "vec", "(Lorg/joml/Vector3i;)Z", "Lorg/joml/Vector3ic;", "(Lorg/joml/Vector3ic;)Z", "containsKey", "key", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;)Z", "containsKeyCertain", "voxel", "containsNodesToFill", "", "extraVolume", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;J)Z", "findContainingVoxel", "(III)Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;)Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;", "get", "(III)Ljava/lang/Object;", "extent", "(IIIJ)Ljava/lang/Object;", "(Lorg/joml/Vector3i;)Ljava/lang/Object;", "(Lorg/joml/Vector3ic;)Ljava/lang/Object;", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;)Ljava/lang/Object;", "chunkX", "chunkY", "chunkZ", "dir", "", "getBorderingDirection", "(IIILorg/joml/Vector3ic;)Ljava/util/Set;", "getBorderingSides", "(III)Ljava/util/Set;", "getCertain", "value", "put", "(IIILjava/lang/Object;)Ljava/lang/Object;", "(Lorg/joml/Vector3i;Ljava/lang/Object;)Ljava/lang/Object;", "(Lorg/joml/Vector3ic;Ljava/lang/Object;)Ljava/lang/Object;", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;Ljava/lang/Object;)Ljava/lang/Object;", "putCertain", "remove", "removeCertain", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "chunkIndex", "Ljava/util/HashMap;", "getChunkIndex", "()Ljava/util/HashMap;", "<init>", "()V", "util"})
public final class SparseVoxelOpenHashMap<T>
extends HashMap<SparseVoxelPosition, T> {
    @NotNull
    private final HashMap<Vector3ic, HashSet<SparseVoxelPosition>> chunkIndex = new HashMap();

    @NotNull
    public final HashMap<Vector3ic, HashSet<SparseVoxelPosition>> getChunkIndex() {
        return this.chunkIndex;
    }

    @Nullable
    public final T get(int x, int y, int z) {
        SparseVoxelPosition containingVoxel;
        SparseVoxelPosition key = new SparseVoxelPosition(x, y, z, 0L, 8, null);
        Object value = super.get(key);
        if (value == null && (containingVoxel = this.findContainingVoxel(x, y, z)) != null) {
            return (T)super.get(containingVoxel);
        }
        return (T)value;
    }

    @Nullable
    public final T get(int x, int y, int z, long extent) {
        SparseVoxelPosition containingVoxel;
        SparseVoxelPosition key = new SparseVoxelPosition(x, y, z, extent);
        Object value = super.get(key);
        if (value == null && (containingVoxel = this.findContainingVoxel(new SparseVoxelPosition(x, y, z, extent))) != null) {
            return (T)super.get(containingVoxel);
        }
        return (T)value;
    }

    @Nullable
    public final T get(@NotNull Vector3ic vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.get(vec.x(), vec.y(), vec.z());
    }

    @Nullable
    public final T get(@NotNull Vector3i vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.get(vec.x, vec.y, vec.z);
    }

    @Nullable
    public T get(@NotNull SparseVoxelPosition key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Object v = super.get(key);
        if (v == null) {
            return this.get(key.x, key.y, key.z, key.getExtent());
        }
        Object value = v;
        return (T)value;
    }

    @Nullable
    public final T getCertain(@NotNull SparseVoxelPosition key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return (T)super.get(key);
    }

    @Nullable
    public final T put(int x, int y, int z, T value) {
        if (this.findContainingVoxel(x, y, z) != null) {
            SparseVoxelPosition sparseVoxelPosition = this.findContainingVoxel(x, y, z);
            Intrinsics.checkNotNull((Object)sparseVoxelPosition);
            return super.put(sparseVoxelPosition, value);
        }
        HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(x >> 4, y >> 4, z >> 4));
        if (hashSet != null) {
            v2 = Boolean.valueOf(hashSet.add(new SparseVoxelPosition(x, y, z, 0L, 8, null)));
        } else {
            Object[] objectArray = new SparseVoxelPosition[]{new SparseVoxelPosition(x, y, z, 0L, 8, null)};
            v2 = this.chunkIndex.put(new Vector3i(x >> 4, y >> 4, z >> 4), SetsKt.hashSetOf((Object[])objectArray));
        }
        return super.put(new SparseVoxelPosition(x, y, z, 0L, 8, null), value);
    }

    @Override
    @Nullable
    public final T put(@NotNull Vector3ic vec, T value) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.put(vec.x(), vec.y(), vec.z(), value);
    }

    @Override
    @Nullable
    public final T put(@NotNull Vector3i vec, T value) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.put(vec.x, vec.y, vec.z, value);
    }

    @Override
    @Nullable
    public T put(@NotNull SparseVoxelPosition key, T value) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        SparseVoxelPosition containingVoxel = this.findContainingVoxel(key);
        if (containingVoxel != null) {
            if (containingVoxel.getExtent() < key.getExtent()) {
                containingVoxel.modExtent(key.getExtent());
            }
            return super.put(containingVoxel, value);
        }
        HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4));
        if (hashSet != null) {
            v1 = Boolean.valueOf(hashSet.add(key));
        } else {
            Object[] objectArray = new SparseVoxelPosition[]{key};
            v1 = this.chunkIndex.put(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4), SetsKt.hashSetOf((Object[])objectArray));
        }
        return super.put(key, value);
    }

    @Nullable
    public final T putCertain(@NotNull SparseVoxelPosition key, T value) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4));
        if (hashSet != null) {
            v1 = Boolean.valueOf(hashSet.add(key));
        } else {
            Object[] objectArray = new SparseVoxelPosition[]{key};
            v1 = this.chunkIndex.put(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4), SetsKt.hashSetOf((Object[])objectArray));
        }
        return super.put(key, value);
    }

    public final boolean containsKey(int x, int y, int z) {
        return this.findContainingVoxel(x, y, z) != null;
    }

    public final boolean containsKey(@NotNull Vector3ic vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.containsKey(vec.x(), vec.y(), vec.z());
    }

    public final boolean containsKey(@NotNull Vector3i vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.containsKey(vec.x, vec.y, vec.z);
    }

    public boolean containsKey(@NotNull SparseVoxelPosition key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return super.containsKey(key) || this.findContainingVoxel(key) != null;
    }

    public final boolean containsKeyCertain(@NotNull SparseVoxelPosition key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return super.containsKey(key);
    }

    public final boolean contains(int x, int y, int z) {
        return this.get(x, y, z) != null;
    }

    public final boolean contains(@NotNull Vector3ic vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.contains(vec.x(), vec.y(), vec.z());
    }

    public final boolean contains(@NotNull Vector3i vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.contains(vec.x, vec.y, vec.z);
    }

    @Nullable
    public final T remove(int x, int y, int z) {
        SparseVoxelPosition containingVoxel;
        SparseVoxelPosition key = new SparseVoxelPosition(x, y, z, 0L, 8, null);
        Object value = super.remove(key);
        if (value != null && this.chunkIndex.containsKey(new Vector3i(x >> 4, y >> 4, z >> 4))) {
            HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(x >> 4, y >> 4, z >> 4));
            if (hashSet != null) {
                hashSet.remove(key);
            }
        }
        if (value == null && (containingVoxel = this.findContainingVoxel(x, y, z)) != null) {
            if (this.chunkIndex.containsKey(new Vector3i(containingVoxel.x >> 4, containingVoxel.y >> 4, containingVoxel.z >> 4))) {
                HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(containingVoxel.x >> 4, containingVoxel.y >> 4, containingVoxel.z >> 4));
                if (hashSet != null) {
                    hashSet.remove(containingVoxel);
                }
            }
            return (T)super.remove(containingVoxel);
        }
        return (T)value;
    }

    @Nullable
    public final T remove(@NotNull Vector3ic vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.remove(vec.x(), vec.y(), vec.z());
    }

    @Nullable
    public final T remove(@NotNull Vector3i vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.remove(vec.x, vec.y, vec.z);
    }

    @Nullable
    public T remove(@NotNull SparseVoxelPosition key) {
        SparseVoxelPosition containingVoxel;
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Object value = super.remove(key);
        if (value != null && this.chunkIndex.containsKey(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4))) {
            HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4));
            if (hashSet != null) {
                hashSet.remove(key);
            }
        }
        if (value == null && (containingVoxel = this.findContainingVoxel(key)) != null) {
            if (this.chunkIndex.containsKey(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4))) {
                HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4));
                if (hashSet != null) {
                    hashSet.remove(key);
                }
            }
            return (T)super.remove(containingVoxel);
        }
        return (T)value;
    }

    @Nullable
    public final T removeCertain(@NotNull SparseVoxelPosition key) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)key, (String)"key");
            if (!this.chunkIndex.containsKey(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4))) break block1;
            HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(key.x >> 4, key.y >> 4, key.z >> 4));
            if (hashSet != null) {
                hashSet.remove(key);
            }
        }
        return (T)super.remove(key);
    }

    @Nullable
    public final SparseVoxelPosition findContainingVoxel(int x, int y, int z) {
        Object v1;
        if (this.chunkIndex.containsKey(new Vector3i(x >> 4, y >> 4, z >> 4))) {
            HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(x >> 4, y >> 4, z >> 4));
            Intrinsics.checkNotNull(hashSet);
            HashSet<SparseVoxelPosition> voxels = hashSet;
            SparseVoxelPosition returnVoxel = new SparseVoxelPosition(x, y, z, 0L, 8, null);
            if (voxels.contains(new SparseVoxelPosition(x, y, z, 0L, 8, null))) {
                return returnVoxel;
            }
            long currentExtent = 1L;
            do {
                SparseVoxelPosition higherVoxel;
                if (!voxels.contains(higherVoxel = SparseVoxelPosition.getHigherLevelVoxel$default(returnVoxel, 0, 0, 0, currentExtent, 7, null)) || !higherVoxel.contains(x, y, z)) continue;
                return higherVoxel;
            } while ((currentExtent *= 2L) <= 8L);
            v1 = null;
        } else {
            v1 = null;
        }
        return v1;
    }

    @Nullable
    public final SparseVoxelPosition findContainingVoxel(@NotNull SparseVoxelPosition voxel) {
        Object v1;
        Intrinsics.checkNotNullParameter((Object)voxel, (String)"voxel");
        if (this.chunkIndex.containsKey(new Vector3i(voxel.x >> 4, voxel.y >> 4, voxel.z >> 4))) {
            HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(voxel.x >> 4, voxel.y >> 4, voxel.z >> 4));
            Intrinsics.checkNotNull(hashSet);
            HashSet<SparseVoxelPosition> voxels = hashSet;
            if (voxels.contains(voxel)) {
                return voxel;
            }
            long currentExtent = 1L;
            do {
                SparseVoxelPosition higherVoxel;
                if (!voxels.contains(higherVoxel = SparseVoxelPosition.getHigherLevelVoxel$default(voxel, 0, 0, 0, currentExtent, 7, null)) || !higherVoxel.contains(voxel)) continue;
                return higherVoxel;
            } while ((currentExtent *= 2L) <= 8L);
            v1 = null;
        } else {
            v1 = null;
        }
        return v1;
    }

    @NotNull
    public final Set<SparseVoxelPosition> getBorderingSides(int chunkX, int chunkY, int chunkZ) {
        HashSet returnSet = new HashSet();
        if (this.chunkIndex.containsKey(new Vector3i(chunkX, chunkY, chunkZ))) {
            returnSet.addAll(this.getBorderingDirection(chunkX, chunkY, chunkZ, new Vector3i(1, 0, 0)));
            returnSet.addAll(this.getBorderingDirection(chunkX, chunkY, chunkZ, new Vector3i(-1, 0, 0)));
            returnSet.addAll(this.getBorderingDirection(chunkX, chunkY, chunkZ, new Vector3i(0, 1, 0)));
            returnSet.addAll(this.getBorderingDirection(chunkX, chunkY, chunkZ, new Vector3i(0, -1, 0)));
            returnSet.addAll(this.getBorderingDirection(chunkX, chunkY, chunkZ, new Vector3i(0, 0, 1)));
            returnSet.addAll(this.getBorderingDirection(chunkX, chunkY, chunkZ, new Vector3i(0, 0, -1)));
        }
        return returnSet;
    }

    @NotNull
    public final Set<SparseVoxelPosition> getBorderingDirection(int chunkX, int chunkY, int chunkZ, @NotNull Vector3ic dir) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        HashSet<SparseVoxelPosition> returnSet = new HashSet<SparseVoxelPosition>();
        if (this.chunkIndex.containsKey(new Vector3i(chunkX, chunkY, chunkZ))) {
            HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(chunkX, chunkY, chunkZ));
            Intrinsics.checkNotNull(hashSet);
            HashSet<SparseVoxelPosition> voxels = hashSet;
            SparseVoxelPosition checkerVoxel = new SparseVoxelPosition((chunkX << 4) + dir.x(), (chunkY << 4) + dir.y(), (chunkZ << 4) + dir.z(), 16L);
            for (SparseVoxelPosition voxel : voxels) {
                if (!checkerVoxel.contains(voxel.relativeTo(dir))) continue;
                returnSet.add(voxel);
            }
        }
        return returnSet;
    }

    public final boolean containsNodesToFill(@NotNull SparseVoxelPosition voxel) {
        Intrinsics.checkNotNullParameter((Object)voxel, (String)"voxel");
        long required = voxel.getVolume();
        long filled = 0L;
        if (this.chunkIndex.containsKey(new Vector3i(voxel.x >> 4, voxel.y >> 4, voxel.z >> 4))) {
            HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(voxel.x >> 4, voxel.y >> 4, voxel.z >> 4));
            Intrinsics.checkNotNull(hashSet);
            for (SparseVoxelPosition key : hashSet) {
                if (key.contains(voxel)) {
                    filled += key.getVolume();
                    continue;
                }
                Intrinsics.checkNotNullExpressionValue((Object)key, (String)"key");
                if (!voxel.contains(key)) continue;
                filled += key.getVolume();
            }
        }
        return filled >= required;
    }

    public final boolean containsNodesToFill(@NotNull SparseVoxelPosition voxel, long extraVolume) {
        Intrinsics.checkNotNullParameter((Object)voxel, (String)"voxel");
        long required = voxel.getVolume();
        long filled = extraVolume;
        if (this.chunkIndex.containsKey(new Vector3i(voxel.x >> 4, voxel.y >> 4, voxel.z >> 4))) {
            HashSet<SparseVoxelPosition> hashSet = this.chunkIndex.get(new Vector3i(voxel.x >> 4, voxel.y >> 4, voxel.z >> 4));
            Intrinsics.checkNotNull(hashSet);
            for (SparseVoxelPosition key : hashSet) {
                if (key.contains(voxel)) {
                    filled += key.getVolume();
                    continue;
                }
                Intrinsics.checkNotNullExpressionValue((Object)key, (String)"key");
                if (!voxel.contains(key)) continue;
                filled += key.getVolume();
            }
        }
        return filled >= required;
    }
}

