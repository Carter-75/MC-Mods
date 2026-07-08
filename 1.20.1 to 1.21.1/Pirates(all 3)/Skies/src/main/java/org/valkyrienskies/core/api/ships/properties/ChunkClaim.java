/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.ships.properties;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3i;
import org.joml.primitives.AABBi;
import org.valkyrienskies.core.api.world.LevelYRange;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\bf\u0018\u0000 (2\u00020\u0001:\u0001(J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&\u00a2\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&\u00a2\u0006\u0004\b\u000e\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u000fH&\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010!\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0016R\u0014\u0010#\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0016R\u0014\u0010%\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u0016R\u0014\u0010'\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0016\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006)\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "", "", "x", "z", "", "contains", "(II)Z", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "yRange", "Lorg/joml/Vector3i;", "destination", "getBlockSize", "(Lorg/valkyrienskies/core/api/world/LevelYRange;Lorg/joml/Vector3i;)Lorg/joml/Vector3i;", "getCenterBlockCoordinates", "Lorg/joml/primitives/AABBi;", "getTotalVoxelRegion", "(Lorg/valkyrienskies/core/api/world/LevelYRange;Lorg/joml/primitives/AABBi;)Lorg/joml/primitives/AABBi;", "", "toLong", "()J", "getSize", "()I", "size", "getXEnd", "xEnd", "getXIndex", "xIndex", "getXMiddle", "xMiddle", "getXStart", "xStart", "getZEnd", "zEnd", "getZIndex", "zIndex", "getZMiddle", "zMiddle", "getZStart", "zStart", "Companion", "api"})
public interface ChunkClaim {
    @NotNull
    public static final Companion Companion = org.valkyrienskies.core.api.ships.properties.ChunkClaim$Companion.$$INSTANCE;
    public static final int DIAMETER = 256;

    public int getXIndex();

    public int getZIndex();

    public int getXStart();

    public int getXEnd();

    public int getZStart();

    public int getZEnd();

    public int getXMiddle();

    public int getZMiddle();

    public int getSize();

    public long toLong();

    public boolean contains(int var1, int var2);

    @NotNull
    public Vector3i getCenterBlockCoordinates(@NotNull LevelYRange var1, @NotNull Vector3i var2);

    public static /* synthetic */ Vector3i getCenterBlockCoordinates$default(ChunkClaim chunkClaim, LevelYRange levelYRange, Vector3i vector3i, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCenterBlockCoordinates");
        }
        if ((n2 & 2) != 0) {
            vector3i = new Vector3i();
        }
        return chunkClaim.getCenterBlockCoordinates(levelYRange, vector3i);
    }

    @NotNull
    public Vector3i getBlockSize(@NotNull LevelYRange var1, @NotNull Vector3i var2);

    public static /* synthetic */ Vector3i getBlockSize$default(ChunkClaim chunkClaim, LevelYRange levelYRange, Vector3i vector3i, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBlockSize");
        }
        if ((n2 & 2) != 0) {
            vector3i = new Vector3i();
        }
        return chunkClaim.getBlockSize(levelYRange, vector3i);
    }

    @NotNull
    public AABBi getTotalVoxelRegion(@NotNull LevelYRange var1, @NotNull AABBi var2);

    public static /* synthetic */ AABBi getTotalVoxelRegion$default(ChunkClaim chunkClaim, LevelYRange levelYRange, AABBi aABBi, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTotalVoxelRegion");
        }
        if ((n2 & 2) != 0) {
            aABBi = new AABBi();
        }
        return chunkClaim.getTotalVoxelRegion(levelYRange, aABBi);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2={"Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim$Companion;", "", "", "claimXIndex", "claimZIndex", "", "claimToLong", "(II)J", "chunkX", "chunkZ", "getClaimThenToLong", "getClaimXIndex", "(I)I", "getClaimZIndex", "BOTTOM_32_BITS_MASK", "J", "DIAMETER", "I", "<init>", "()V", "api"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        public static final int DIAMETER = 256;
        private static final long BOTTOM_32_BITS_MASK = 0xFFFFFFFFL;

        private Companion() {
        }

        public final int getClaimXIndex(int chunkX) {
            return Math.floorDiv(chunkX, 256);
        }

        public final int getClaimZIndex(int chunkZ) {
            return Math.floorDiv(chunkZ, 256);
        }

        public final long claimToLong(int claimXIndex, int claimZIndex) {
            return (long)claimXIndex << 32 | (long)claimZIndex & 0xFFFFFFFFL;
        }

        public final long getClaimThenToLong(int chunkX, int chunkZ) {
            int claimXIndex = this.getClaimXIndex(chunkX);
            int claimZIndex = this.getClaimZIndex(chunkZ);
            return this.claimToLong(claimXIndex, claimZIndex);
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

