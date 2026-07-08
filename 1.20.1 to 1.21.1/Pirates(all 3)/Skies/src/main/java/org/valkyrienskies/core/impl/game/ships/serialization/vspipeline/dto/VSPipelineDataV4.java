/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV4;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineData;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007\u00a2\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV4;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineData;", "Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "component1", "()Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV4;", "component2", "()Ljava/util/List;", "chunkAllocator", "ships", "copy", "(Lorg/valkyrienskies/core/impl/game/ChunkAllocator;Ljava/util/List;)Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/dto/VSPipelineDataV4;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "getChunkAllocator", "Ljava/util/List;", "getShips", "<init>", "(Lorg/valkyrienskies/core/impl/game/ChunkAllocator;Ljava/util/List;)V"})
public final class VSPipelineDataV4
implements VSPipelineData {
    private final ChunkAllocator chunkAllocator;
    private final List<ServerShipDataV4> ships;

    /*
     * WARNING - void declaration
     */
    public VSPipelineDataV4(ChunkAllocator chunkAllocator, List<ServerShipDataV4> ships) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)chunkAllocator, (String)"");
        Intrinsics.checkNotNullParameter(ships, (String)"");
        this.chunkAllocator = var1_1;
        this.ships = var2_2;
    }

    @JvmName(name="getChunkAllocator")
    public final ChunkAllocator getChunkAllocator() {
        return this.chunkAllocator;
    }

    @JvmName(name="getShips")
    public final List<ServerShipDataV4> getShips() {
        return this.ships;
    }

    public final ChunkAllocator component1() {
        return this.chunkAllocator;
    }

    public final List<ServerShipDataV4> component2() {
        return this.ships;
    }

    /*
     * WARNING - void declaration
     */
    public final VSPipelineDataV4 copy(ChunkAllocator chunkAllocator, List<ServerShipDataV4> ships) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)chunkAllocator, (String)"");
        Intrinsics.checkNotNullParameter(ships, (String)"");
        return new VSPipelineDataV4((ChunkAllocator)var1_1, (List<ServerShipDataV4>)var2_2);
    }

    public static /* synthetic */ VSPipelineDataV4 copy$default(VSPipelineDataV4 vSPipelineDataV4, ChunkAllocator chunkAllocator, List list, int n2, Object object) {
        if ((n2 & 1) != 0) {
            chunkAllocator = vSPipelineDataV4.chunkAllocator;
        }
        if ((n2 & 2) != 0) {
            list = vSPipelineDataV4.ships;
        }
        return vSPipelineDataV4.copy(chunkAllocator, list);
    }

    public final String toString() {
        return "VSPipelineDataV4(chunkAllocator=" + this.chunkAllocator + ", ships=" + this.ships + ")";
    }

    public final int hashCode() {
        int n2 = this.chunkAllocator.hashCode();
        n2 = n2 * 31 + ((Object)this.ships).hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        VSPipelineDataV4 vSPipelineDataV4;
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSPipelineDataV4)) {
            return false;
        }
        vSPipelineDataV4 = vSPipelineDataV4;
        if (!Intrinsics.areEqual((Object)this.chunkAllocator, (Object)vSPipelineDataV4.chunkAllocator)) {
            return false;
        }
        return Intrinsics.areEqual(this.ships, vSPipelineDataV4.ships);
    }
}

