/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.dp_1;
import org.valkyrienskies.core.impl.shadow.dw_1;
import org.valkyrienskies.core.impl.shadow.dx_1;
import org.valkyrienskies.core.impl.shadow.em_0;
import org.valkyrienskies.core.internal.ships.VsiMutableQueryableShipData;

@dw_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB!\u0012\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aR!\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00048\u0007\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0007\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000e8G\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R'\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u00158G\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0013\u00a8\u0006\u001d"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/modules/ShipWorldModule;", "", "Lorg/valkyrienskies/core/internal/ships/VsiMutableQueryableShipData;", "Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "Lorg/valkyrienskies/core/impl/game/ships/MutableQueryableShipDataServer;", "allShips", "Lorg/valkyrienskies/core/internal/ships/VsiMutableQueryableShipData;", "getAllShips", "()Lorg/valkyrienskies/core/internal/ships/VsiMutableQueryableShipData;", "Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "chunkAllocator", "Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "getChunkAllocator", "()Lorg/valkyrienskies/core/impl/game/ChunkAllocator;", "", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "Lorg/valkyrienskies/core/impl/game/DimensionInfo;", "getDimensionInfo", "()Ljava/util/Map;", "dimensionInfo", "", "mutableDimensionInfo", "Ljava/util/Map;", "getMutableDimensionInfo", "<init>", "(Lorg/valkyrienskies/core/internal/ships/VsiMutableQueryableShipData;Lorg/valkyrienskies/core/impl/game/ChunkAllocator;)V", "Companion", "Declarations", "impl"})
public final class EG {
    public static final a a = new a(null);
    final VsiMutableQueryableShipData<ShipData> b;
    final ChunkAllocator c;
    final Map<String, DP> d;

    public EG(VsiMutableQueryableShipData<ShipData> vsiMutableQueryableShipData, ChunkAllocator chunkAllocator) {
        Intrinsics.checkNotNullParameter(vsiMutableQueryableShipData, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkAllocator, (String)"");
        this.b = vsiMutableQueryableShipData;
        this.c = chunkAllocator;
        this.d = new LinkedHashMap();
    }

    @dx_1
    @JvmName(name="a")
    public final VsiMutableQueryableShipData<ShipData> a() {
        return this.b;
    }

    @dx_1
    @Named(value="primary")
    @JvmName(name="b")
    public final ChunkAllocator b() {
        return this.c;
    }

    @dx_1
    @Named(value="mutableDimensionInfo")
    @JvmName(name="c")
    public final Map<String, DP> c() {
        return this.d;
    }

    @dx_1
    @Named(value="dimensionInfo")
    @JvmName(name="d")
    public final Map<String, DP> d() {
        return this.d;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EG$a;", "", "Lorg/valkyrienskies/core/impl/shadow/EG;", "a", "()Lorg/valkyrienskies/core/impl/shadow/EG;", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        public static EG a() {
            return new EG(new em_0(null, 1, null), ChunkAllocator.Companion.create());
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @dw_1
    public static interface b {
        @dp_1
        public ChunkAllocatorProvider a();
    }
}

