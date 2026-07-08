/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 */
package org.valkyrienskies.core.api.ships.properties;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3i;
import org.valkyrienskies.core.api.util.functions.IntBinaryConsumer;
import org.valkyrienskies.core.api.world.LevelYRange;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000  2\u00020\u0001:\u0001 J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\t\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001a\u001a\u00020\r2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0019H'\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u001c\u0010\u0007J\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001f\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006!\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "", "", "chunkX", "chunkZ", "", "add", "(II)Z", "addChunkPos", "contains", "containsChunkPos", "Lorg/valkyrienskies/core/api/util/functions/IntBinaryConsumer;", "func", "", "forEach", "(Lorg/valkyrienskies/core/api/util/functions/IntBinaryConsumer;)V", "Lorg/joml/Vector3i;", "minWorldPos", "maxWorldPos", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "yRange", "getMinMaxWorldPos", "(Lorg/joml/Vector3i;Lorg/joml/Vector3i;Lorg/valkyrienskies/core/api/world/LevelYRange;)V", "getTotalChunks", "()I", "Lkotlin/Function2;", "iterateChunkPos", "(Lkotlin/jvm/functions/Function2;)V", "remove", "removeChunkPos", "getSize", "size", "Companion", "api"})
public interface IShipActiveChunksSet {
    @NotNull
    public static final Companion Companion = org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet$Companion.$$INSTANCE;

    public int getSize();

    public boolean add(int var1, int var2);

    public boolean remove(int var1, int var2);

    public boolean contains(int var1, int var2);

    public void forEach(@NotNull IntBinaryConsumer var1);

    default public void getMinMaxWorldPos(@NotNull Vector3i minWorldPos, @NotNull Vector3i maxWorldPos, @NotNull LevelYRange yRange) {
        Intrinsics.checkNotNullParameter((Object)minWorldPos, (String)"minWorldPos");
        Intrinsics.checkNotNullParameter((Object)maxWorldPos, (String)"maxWorldPos");
        Intrinsics.checkNotNullParameter((Object)yRange, (String)"yRange");
        if (this.getSize() == 0) {
            minWorldPos.set(Integer.MAX_VALUE);
            maxWorldPos.set(Integer.MIN_VALUE);
        }
        Ref.IntRef minChunkX = new Ref.IntRef();
        minChunkX.element = Integer.MAX_VALUE;
        Ref.IntRef minChunkZ = new Ref.IntRef();
        minChunkZ.element = Integer.MAX_VALUE;
        Ref.IntRef maxChunkX = new Ref.IntRef();
        maxChunkX.element = Integer.MIN_VALUE;
        Ref.IntRef maxChunkZ = new Ref.IntRef();
        maxChunkZ.element = Integer.MIN_VALUE;
        this.forEach((arg_0, arg_1) -> IShipActiveChunksSet.getMinMaxWorldPos$lambda$0(minChunkX, minChunkZ, maxChunkX, maxChunkZ, arg_0, arg_1));
        minWorldPos.set(minChunkX.element << 4, yRange.getMinY(), minChunkZ.element << 4);
        maxWorldPos.set((maxChunkX.element << 4) + 15, yRange.getMaxY(), (maxChunkZ.element << 4) + 15);
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="remove(chunkX, chunkZ)", imports={}))
    default public boolean removeChunkPos(int chunkX, int chunkZ) {
        return this.remove(chunkX, chunkZ);
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="size", imports={}))
    default public int getTotalChunks() {
        return this.getSize();
    }

    @Deprecated(message="Uses boxed integers as parameters and requires Unit return type, bad for performance and Java interop", replaceWith=@ReplaceWith(expression="forEach(func)", imports={}))
    public void iterateChunkPos(@NotNull Function2<? super Integer, ? super Integer, Unit> var1);

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="contains(chunkX, chunkZ)", imports={}))
    default public boolean containsChunkPos(int chunkX, int chunkZ) {
        return this.contains(chunkX, chunkZ);
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="add(chunkX, chunkZ)", imports={}))
    default public boolean addChunkPos(int chunkX, int chunkZ) {
        return this.add(chunkX, chunkZ);
    }

    private static void getMinMaxWorldPos$lambda$0(Ref.IntRef $minChunkX, Ref.IntRef $minChunkZ, Ref.IntRef $maxChunkX, Ref.IntRef $maxChunkZ, int chunkX, int chunkZ) {
        $minChunkX.element = Math.min($minChunkX.element, chunkX);
        $minChunkZ.element = Math.min($minChunkZ.element, chunkZ);
        $maxChunkX.element = Math.max($maxChunkX.element, chunkX);
        $maxChunkZ.element = Math.max($maxChunkZ.element, chunkZ);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2={"Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet$Companion;", "", "", "chunkX", "chunkZ", "", "chunkPosToLong", "(II)J", "chunkLong", "longToChunkX", "(J)I", "longToChunkZ", "<init>", "()V", "api"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        public final long chunkPosToLong(int chunkX, int chunkZ) {
            return (long)chunkX << 32 | (long)chunkZ;
        }

        public final int longToChunkX(long chunkLong) {
            return (int)(chunkLong >> 32);
        }

        public final int longToChunkZ(long chunkLong) {
            return (int)(chunkLong & 0xFFFFFFFFL);
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

