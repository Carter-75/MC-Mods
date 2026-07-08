/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3i;
import org.joml.primitives.AABBi;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.world.LevelYRange;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
@JsonIncludeProperties(value={"xIndex", "zIndex"})
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0087\b\u0018\u0000 72\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u001eH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!H\u00d6\u0001\u00a2\u0006\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004R\u001a\u0010'\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b)\u0010\u0004R\u001a\u0010*\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010\u0004R\u001a\u0010,\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010\u0004R\u001a\u0010.\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b0\u0010\u0004R\u001a\u00101\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b2\u0010\u0004R\u001a\u00103\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b3\u0010%\u001a\u0004\b4\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/game/ChunkClaimImpl;", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "", "component1", "()I", "component2", "x", "z", "", "contains", "(II)Z", "xIndex", "zIndex", "copy", "(II)Lorg/valkyrienskies/core/impl/game/ChunkClaimImpl;", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "yRange", "Lorg/joml/Vector3i;", "destination", "getBlockSize", "(Lorg/valkyrienskies/core/api/world/LevelYRange;Lorg/joml/Vector3i;)Lorg/joml/Vector3i;", "getCenterBlockCoordinates", "Lorg/joml/primitives/AABBi;", "getTotalVoxelRegion", "(Lorg/valkyrienskies/core/api/world/LevelYRange;Lorg/joml/primitives/AABBi;)Lorg/joml/primitives/AABBi;", "hashCode", "", "toLong", "()J", "", "toString", "()Ljava/lang/String;", "size", "I", "getSize", "xEnd", "getXEnd", "getXIndex", "xMiddle", "getXMiddle", "xStart", "getXStart", "zEnd", "getZEnd", "getZIndex", "zMiddle", "getZMiddle", "zStart", "getZStart", "<init>", "(II)V", "Companion"})
public final class ChunkClaimImpl
implements ChunkClaim {
    public static final Companion Companion = new Companion(null);
    private final int xIndex;
    private final int zIndex;
    private final int xStart;
    private final int xEnd;
    private final int zStart;
    private final int zEnd;
    private final int xMiddle;
    private final int zMiddle;
    private final int size;

    /*
     * WARNING - void declaration
     */
    public ChunkClaimImpl(int xIndex, int zIndex) {
        void var2_2;
        void var1_1;
        this.xIndex = var1_1;
        this.zIndex = var2_2;
        this.xStart = this.getXIndex() << 8;
        this.xEnd = (this.getXIndex() << 8) + 256 - 1;
        this.zStart = this.getZIndex() << 8;
        this.zEnd = (this.getZIndex() << 8) + 256 - 1;
        this.xMiddle = this.getXStart() + 128;
        this.zMiddle = this.getZStart() + 128;
        this.size = (this.getXEnd() - this.getXStart() + 1) * (this.getZEnd() - this.getZStart() + 1);
    }

    @Override
    @JvmName(name="getXIndex")
    public final int getXIndex() {
        return this.xIndex;
    }

    @Override
    @JvmName(name="getZIndex")
    public final int getZIndex() {
        return this.zIndex;
    }

    @Override
    @JvmName(name="getXStart")
    public final int getXStart() {
        return this.xStart;
    }

    @Override
    @JvmName(name="getXEnd")
    public final int getXEnd() {
        return this.xEnd;
    }

    @Override
    @JvmName(name="getZStart")
    public final int getZStart() {
        return this.zStart;
    }

    @Override
    @JvmName(name="getZEnd")
    public final int getZEnd() {
        return this.zEnd;
    }

    @Override
    @JvmName(name="getXMiddle")
    public final int getXMiddle() {
        return this.xMiddle;
    }

    @Override
    @JvmName(name="getZMiddle")
    public final int getZMiddle() {
        return this.zMiddle;
    }

    @Override
    @JvmName(name="getSize")
    public final int getSize() {
        return this.size;
    }

    @Override
    public final long toLong() {
        return ChunkClaim.Companion.claimToLong(this.getXIndex(), this.getZIndex());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean contains(int x, int z) {
        void var2_2;
        void var1_1;
        int n2 = this.getXStart();
        boolean bl = x <= this.getXEnd() ? n2 <= var1_1 : false;
        n2 = this.getZStart();
        return bl & (z <= this.getZEnd() ? n2 <= var2_2 : false);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Vector3i getCenterBlockCoordinates(LevelYRange yRange, Vector3i destination) {
        void var2_3;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)yRange, (String)"");
        Intrinsics.checkNotNullParameter((Object)destination, (String)"");
        int n2 = this.getXStart() << 4;
        int n3 = (this.getXEnd() << 4) + 15;
        int n4 = this.getZStart() << 4;
        int n5 = (this.getZEnd() << 4) + 15;
        n2 = (n2 + n3) / 2;
        int n6 = var1_1.getCenter();
        n3 = (n4 + n5) / 2;
        Vector3i vector3i = var2_3.set(n2, n6, n3);
        Intrinsics.checkNotNullExpressionValue((Object)vector3i, (String)"");
        return vector3i;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Vector3i getBlockSize(LevelYRange yRange, Vector3i destination) {
        void var2_3;
        Intrinsics.checkNotNullParameter((Object)yRange, (String)"");
        Intrinsics.checkNotNullParameter((Object)destination, (String)"");
        int n2 = this.getXEnd() - this.getXStart() + 1 << 4;
        int n3 = this.getZEnd() - this.getZStart() + 1 << 4;
        Vector3i vector3i = var2_3.set(n2, 256, n3);
        Intrinsics.checkNotNullExpressionValue((Object)vector3i, (String)"");
        return vector3i;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final AABBi getTotalVoxelRegion(LevelYRange yRange, AABBi destination) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)yRange, (String)"");
        Intrinsics.checkNotNullParameter((Object)destination, (String)"");
        destination.minX = this.getXStart() << 4;
        destination.minY = yRange.getMinY();
        destination.minZ = this.getZStart() << 4;
        destination.maxX = (this.getXEnd() << 4) + 15;
        destination.maxY = var1_1.getMaxY();
        destination.maxZ = (this.getZEnd() << 4) + 15;
        return var2_2;
    }

    public final int component1() {
        return this.xIndex;
    }

    public final int component2() {
        return this.zIndex;
    }

    /*
     * WARNING - void declaration
     */
    public final ChunkClaimImpl copy(int xIndex, int zIndex) {
        void var2_2;
        void var1_1;
        return new ChunkClaimImpl((int)var1_1, (int)var2_2);
    }

    public static /* synthetic */ ChunkClaimImpl copy$default(ChunkClaimImpl chunkClaimImpl, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n2 = chunkClaimImpl.xIndex;
        }
        if ((n4 & 2) != 0) {
            n3 = chunkClaimImpl.zIndex;
        }
        return chunkClaimImpl.copy(n2, n3);
    }

    public final String toString() {
        return "ChunkClaimImpl(xIndex=" + this.xIndex + ", zIndex=" + this.zIndex + ")";
    }

    public final int hashCode() {
        int n2 = Integer.hashCode(this.xIndex);
        n2 = n2 * 31 + Integer.hashCode(this.zIndex);
        return n2;
    }

    public final boolean equals(Object other) {
        ChunkClaimImpl chunkClaimImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChunkClaimImpl)) {
            return false;
        }
        chunkClaimImpl = chunkClaimImpl;
        if (this.xIndex != chunkClaimImpl.xIndex) {
            return false;
        }
        return this.zIndex == chunkClaimImpl.zIndex;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2={"Lorg/valkyrienskies/core/impl/game/ChunkClaimImpl$Companion;", "", "", "chunkX", "chunkZ", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getClaim", "(II)Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "<init>", "()V"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        public final ChunkClaim getClaim(int chunkX, int chunkZ) {
            void var2_2;
            void var1_1;
            return new ChunkClaimImpl(ChunkClaim.Companion.getClaimXIndex((int)var1_1), ChunkClaim.Companion.getClaimZIndex((int)var2_2));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

