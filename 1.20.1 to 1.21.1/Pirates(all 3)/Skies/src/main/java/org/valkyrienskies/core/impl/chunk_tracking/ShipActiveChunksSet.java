/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongIterator
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.chunk_tracking;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.util.functions.IntBinaryConsumer;

@JsonIncludeProperties(value={"chunkClaimSet"})
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b&\u0010'J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u00c2\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\r\u0010\u0007J\u001a\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\nH\u00c6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001d\u001a\u00020\u00172\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u001cH\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001f\u0010\u0007J\u0010\u0010!\u001a\u00020 H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\"R\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010#R\u0014\u0010%\u001a\u00020\u00028WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u001b"}, d2={"Lorg/valkyrienskies/core/impl/chunk_tracking/ShipActiveChunksSet;", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "", "chunkX", "chunkZ", "", "add", "(II)Z", "clone", "()Lorg/valkyrienskies/core/impl/chunk_tracking/ShipActiveChunksSet;", "Lit/unimi/dsi/fastutil/longs/LongOpenHashSet;", "component1", "()Lit/unimi/dsi/fastutil/longs/LongOpenHashSet;", "contains", "chunkClaimSet", "copy", "(Lit/unimi/dsi/fastutil/longs/LongOpenHashSet;)Lorg/valkyrienskies/core/impl/chunk_tracking/ShipActiveChunksSet;", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lorg/valkyrienskies/core/api/util/functions/IntBinaryConsumer;", "func", "", "forEach", "(Lorg/valkyrienskies/core/api/util/functions/IntBinaryConsumer;)V", "hashCode", "()I", "Lkotlin/Function2;", "iterateChunkPos", "(Lkotlin/jvm/functions/Function2;)V", "remove", "", "toString", "()Ljava/lang/String;", "Lit/unimi/dsi/fastutil/longs/LongOpenHashSet;", "getSize", "size", "<init>", "(Lit/unimi/dsi/fastutil/longs/LongOpenHashSet;)V", "Companion"})
public final class ShipActiveChunksSet
implements IShipActiveChunksSet {
    public static final Companion Companion = new Companion(null);
    private final LongOpenHashSet chunkClaimSet;

    /*
     * WARNING - void declaration
     */
    public ShipActiveChunksSet(LongOpenHashSet chunkClaimSet) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)chunkClaimSet, (String)"");
        this.chunkClaimSet = var1_1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        return this.chunkClaimSet.add(IShipActiveChunksSet.Companion.chunkPosToLong((int)var1_1, (int)var2_2));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean remove(int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        return this.chunkClaimSet.remove(IShipActiveChunksSet.Companion.chunkPosToLong((int)var1_1, (int)var2_2));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean contains(int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        return this.chunkClaimSet.contains(IShipActiveChunksSet.Companion.chunkPosToLong((int)var1_1, (int)var2_2));
    }

    @Override
    @Deprecated(message="Uses boxed integers as parameters and requires Unit return type, bad for performance and Java interop", replaceWith=@ReplaceWith(expression="forEach(func)", imports={}))
    public final void iterateChunkPos(Function2<? super Integer, ? super Integer, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"");
        LongIterator longIterator = this.chunkClaimSet.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)longIterator, (String)"");
        LongIterator longIterator2 = longIterator;
        while (longIterator2.hasNext()) {
            long l2 = longIterator2.nextLong();
            int n2 = IShipActiveChunksSet.Companion.longToChunkX(l2);
            int n3 = IShipActiveChunksSet.Companion.longToChunkZ(l2);
            func.invoke((Object)n2, (Object)n3);
        }
    }

    @Override
    public final void forEach(IntBinaryConsumer func) {
        Intrinsics.checkNotNullParameter((Object)func, (String)"");
        LongIterator longIterator = this.chunkClaimSet.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)longIterator, (String)"");
        LongIterator longIterator2 = longIterator;
        while (longIterator2.hasNext()) {
            long l2 = longIterator2.nextLong();
            int n2 = IShipActiveChunksSet.Companion.longToChunkX(l2);
            int n3 = IShipActiveChunksSet.Companion.longToChunkZ(l2);
            func.accept(n2, n3);
        }
    }

    @Override
    @JvmName(name="getSize")
    public final int getSize() {
        return this.chunkClaimSet.size();
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object other) {
        if (super.equals(other)) {
            return true;
        }
        if (other instanceof ShipActiveChunksSet) {
            void var1_1;
            return Intrinsics.areEqual((Object)this.chunkClaimSet, (Object)((ShipActiveChunksSet)var1_1).chunkClaimSet);
        }
        return false;
    }

    public final int hashCode() {
        return this.chunkClaimSet.hashCode();
    }

    public final ShipActiveChunksSet clone() {
        LongOpenHashSet longOpenHashSet = this.chunkClaimSet.clone();
        Intrinsics.checkNotNullExpressionValue((Object)longOpenHashSet, (String)"");
        return new ShipActiveChunksSet(longOpenHashSet);
    }

    private final LongOpenHashSet component1() {
        return this.chunkClaimSet;
    }

    /*
     * WARNING - void declaration
     */
    public final ShipActiveChunksSet copy(LongOpenHashSet chunkClaimSet) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)chunkClaimSet, (String)"");
        return new ShipActiveChunksSet((LongOpenHashSet)var1_1);
    }

    public static /* synthetic */ ShipActiveChunksSet copy$default(ShipActiveChunksSet shipActiveChunksSet, LongOpenHashSet longOpenHashSet, int n2, Object object) {
        if ((n2 & 1) != 0) {
            longOpenHashSet = shipActiveChunksSet.chunkClaimSet;
        }
        return shipActiveChunksSet.copy(longOpenHashSet);
    }

    public final String toString() {
        return "ShipActiveChunksSet(chunkClaimSet=" + this.chunkClaimSet + ")";
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/chunk_tracking/ShipActiveChunksSet$Companion;", "", "Lorg/valkyrienskies/core/impl/chunk_tracking/ShipActiveChunksSet;", "create", "()Lorg/valkyrienskies/core/impl/chunk_tracking/ShipActiveChunksSet;", "<init>", "()V"})
    public static final class Companion {
        private Companion() {
        }

        public final ShipActiveChunksSet create() {
            return new ShipActiveChunksSet(new LongOpenHashSet());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

