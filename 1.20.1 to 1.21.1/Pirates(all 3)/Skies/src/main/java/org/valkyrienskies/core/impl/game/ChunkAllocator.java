/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector2i;
import org.joml.Vector3dc;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.impl.game.ChunkClaimImpl;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00012B\u001f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\u0004\b0\u00101J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c2\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u00c2\u0003\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005H\u00c2\u0003\u00a2\u0006\u0004\b\f\u0010\u0007J.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bH\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\nJ%\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\u0015\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b\u001b\u0010 J\u0015\u0010\u001b\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b\u001b\u0010#J\u001d\u0010&\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b\u00a2\u0006\u0004\b&\u0010'J\u0015\u0010&\u001a\u00020\u00132\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b&\u0010*J\u0010\u0010,\u001a\u00020+H\u00d6\u0001\u00a2\u0006\u0004\b,\u0010-R\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010.R\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010.R\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010/"}, d2={"Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "allocateNewChunkClaim", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "", "allocateShipId", "()J", "", "component1", "()I", "component2", "component3", "nextClaimX", "nextClaimZ", "nextShipId", "copy", "(IIJ)Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "posX", "posY", "posZ", "isBlockInShipyard", "(DDD)Z", "(III)Z", "Lorg/joml/Vector3dc;", "pos", "(Lorg/joml/Vector3dc;)Z", "Lorg/joml/Vector3ic;", "blockPos", "(Lorg/joml/Vector3ic;)Z", "chunkX", "chunkZ", "isChunkInShipyard", "(II)Z", "Lorg/joml/Vector2i;", "chunkPos", "(Lorg/joml/Vector2i;)Z", "", "toString", "()Ljava/lang/String;", "I", "J", "<init>", "(IIJ)V", "Companion"})
public final class ChunkAllocator {
    public static final Companion Companion = new Companion(null);
    private int nextClaimX;
    private int nextClaimZ;
    private long nextShipId;
    public static final int X_INDEX_START = -7000;
    public static final int X_INDEX_END = 7000;
    public static final int Z_INDEX_START = 3000;
    public static final int Z_INDEX_END = 7000;
    public static final long SHIP_ID_START = 0L;

    /*
     * WARNING - void declaration
     */
    public ChunkAllocator(int nextClaimX, int nextClaimZ, long nextShipId) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.nextClaimX = var1_1;
        this.nextClaimZ = var2_2;
        this.nextShipId = var3_3;
    }

    public final boolean isChunkInShipyard(int chunkX, int chunkZ) {
        int n2;
        int n3;
        n3 = ChunkClaim.Companion.getClaimXIndex(n3);
        n2 = ChunkClaim.Companion.getClaimZIndex(n2);
        return (-7000 <= n3 ? n3 < 7001 : false) & (3000 <= n2 ? n2 < 7001 : false);
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isChunkInShipyard(Vector2i chunkPos) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"");
        return this.isChunkInShipyard(chunkPos.x, var1_1.y);
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isBlockInShipyard(int posX, int posY, int posZ) {
        void var3_3;
        void var1_1;
        return this.isChunkInShipyard((int)(var1_1 >> 4), (int)(var3_3 >> 4));
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isBlockInShipyard(double posX, double posY, double posZ) {
        void var1_1;
        return this.isChunkInShipyard((int)var1_1 >> 4, (int)posZ >> 4);
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isBlockInShipyard(Vector3ic blockPos) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"");
        return this.isBlockInShipyard(blockPos.x(), blockPos.y(), var1_1.z());
    }

    /*
     * WARNING - void declaration
     */
    public final boolean isBlockInShipyard(Vector3dc pos) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)pos, (String)"");
        return this.isBlockInShipyard(pos.x(), pos.y(), var1_1.z());
    }

    public final long allocateShipId() {
        long l2 = this.nextShipId;
        this.nextShipId = l2 + 1L;
        return l2;
    }

    public final ChunkClaim allocateNewChunkClaim() {
        ChunkClaimImpl chunkClaimImpl = new ChunkClaimImpl(this.nextClaimX, this.nextClaimZ);
        int n2 = this.nextClaimX;
        this.nextClaimX = n2 + 1;
        if (this.nextClaimX > 7000) {
            this.nextClaimX = -7000;
            n2 = this.nextClaimZ;
            this.nextClaimZ = n2 + 1;
        }
        if (!(3000 <= (n2 = this.nextClaimZ) ? n2 < 7001 : false)) {
            throw new IllegalStateException("We ran out of chunk claims to allocate!");
        }
        return chunkClaimImpl;
    }

    private final int component1() {
        return this.nextClaimX;
    }

    private final int component2() {
        return this.nextClaimZ;
    }

    private final long component3() {
        return this.nextShipId;
    }

    /*
     * WARNING - void declaration
     */
    public final ChunkAllocator copy(int nextClaimX, int nextClaimZ, long nextShipId) {
        void var3_3;
        void var2_2;
        void var1_1;
        return new ChunkAllocator((int)var1_1, (int)var2_2, (long)var3_3);
    }

    public static /* synthetic */ ChunkAllocator copy$default(ChunkAllocator chunkAllocator, int n2, int n3, long l2, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n2 = chunkAllocator.nextClaimX;
        }
        if ((n4 & 2) != 0) {
            n3 = chunkAllocator.nextClaimZ;
        }
        if ((n4 & 4) != 0) {
            l2 = chunkAllocator.nextShipId;
        }
        return chunkAllocator.copy(n2, n3, l2);
    }

    public final String toString() {
        return "ChunkAllocator(nextClaimX=" + this.nextClaimX + ", nextClaimZ=" + this.nextClaimZ + ", nextShipId=" + this.nextShipId + ")";
    }

    public final int hashCode() {
        int n2 = Integer.hashCode(this.nextClaimX);
        n2 = n2 * 31 + Integer.hashCode(this.nextClaimZ);
        n2 = n2 * 31 + Long.hashCode(this.nextShipId);
        return n2;
    }

    public final boolean equals(Object other) {
        ChunkAllocator chunkAllocator;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChunkAllocator)) {
            return false;
        }
        chunkAllocator = chunkAllocator;
        if (this.nextClaimX != chunkAllocator.nextClaimX) {
            return false;
        }
        if (this.nextClaimZ != chunkAllocator.nextClaimZ) {
            return false;
        }
        return this.nextShipId == chunkAllocator.nextShipId;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n"}, d2={"Lorg/valkyrienskies/core/impl/game/ChunkAllocator$Companion;", "", "Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "create", "()Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "", "SHIP_ID_START", "J", "", "X_INDEX_END", "I", "X_INDEX_START", "Z_INDEX_END", "Z_INDEX_START", "<init>", "()V"})
    public static final class Companion {
        private Companion() {
        }

        public final ChunkAllocator create() {
            return new ChunkAllocator(-7000, 3000, 0L);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

