/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  org.valkyrienskies.core.impl.shadow.Et
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.apache.logging.log4j.Logger;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.impl.api.ShipInternal;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.shadow.Et;
import org.valkyrienskies.core.impl.shadow.FW;
import org.valkyrienskies.core.impl.shadow.eo_0;
import org.valkyrienskies.core.impl.shadow.gu_0;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.VsiShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockTypes;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Et
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 N*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001NB\u0017\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010/\u001a\u00020.\u00a2\u0006\u0004\bL\u0010MJ\u000f\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\b\u001a\u00020\u0007H\u0017\u00a2\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019JS\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016\u00a2\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b%\u0010\u0006R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)8'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0017\u00105\u001a\u0002048\u0007\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010:\u001a\u0002098\u0007\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000)8'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010,R*\u0010F\u001a\u0012\u0012\b\u0012\u00060Aj\u0002`B\u0012\u0004\u0012\u00028\u00000@8GX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bE\u0010\u0006\u001a\u0004\bC\u0010DR$\u0010H\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f8\u0007@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Et;", "Lorg/valkyrienskies/core/impl/shadow/Eo;", "ShipObjectType", "Lorg/valkyrienskies/core/internal/world/VsiShipWorld;", "", "destroyWorld", "()V", "Lorg/joml/primitives/AABBdc;", "aabb", "", "getShipObjectsIntersecting", "(Lorg/joml/primitives/AABBdc;)Ljava/util/List;", "", "blockX", "blockY", "blockZ", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "", "isBlockInShipyard", "(IIILjava/lang/String;)Z", "chunkX", "chunkZ", "isChunkInShipyard", "(IILjava/lang/String;)Z", "posX", "posY", "posZ", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "oldBlockType", "newBlockType", "", "oldBlockMass", "newBlockMass", "onSetBlock", "(IIILjava/lang/String;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;DD)V", "preTick", "Lorg/valkyrienskies/core/impl/shadow/Gu;", "_dispatcher", "Lorg/valkyrienskies/core/impl/shadow/Gu;", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "Lorg/valkyrienskies/core/impl/api/ShipInternal;", "getAllShips", "()Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "allShips", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "blockTypes", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "Lorg/valkyrienskies/core/impl/game/ChunkAllocatorProvider;", "chunkAllocators", "Lorg/valkyrienskies/core/impl/game/ChunkAllocatorProvider;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getLoadedShips", "loadedShips", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getShipObjects", "()Ljava/util/Map;", "getShipObjects$annotations", "shipObjects", "p0", "tickNumber", "I", "getTickNumber", "()I", "<init>", "(Lorg/valkyrienskies/core/impl/game/ChunkAllocatorProvider;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;)V", "Companion"})
public abstract class et_0<ShipObjectType extends eo_0>
implements VsiShipWorld {
    public static final Companion Companion = new Companion(null);
    private final ChunkAllocatorProvider chunkAllocators;
    private final VsiBlockTypes blockTypes;
    private final gu_0 _dispatcher;
    private final CoroutineDispatcher dispatcher;
    private final CoroutineScope coroutineScope;
    private int tickNumber;
    private static final Logger logger$delegate = FW.a(Companion, org.valkyrienskies.core.impl.shadow.Et$Companion.a[0]);

    public et_0(ChunkAllocatorProvider chunkAllocatorProvider, VsiBlockTypes vsiBlockTypes) {
        Intrinsics.checkNotNullParameter((Object)chunkAllocatorProvider, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiBlockTypes, (String)"");
        this.chunkAllocators = chunkAllocatorProvider;
        this.blockTypes = vsiBlockTypes;
        this._dispatcher = new gu_0();
        this.dispatcher = this._dispatcher;
        this.coroutineScope = CoroutineScopeKt.plus(CoroutineScopeKt.MainScope(), (CoroutineContext)this._dispatcher);
    }

    @JvmName(name="getAllShips")
    public abstract VsiQueryableShipData<ShipInternal> getAllShips();

    @JvmName(name="getLoadedShips")
    public abstract VsiQueryableShipData<ShipObjectType> getLoadedShips();

    @JvmName(name="getShipObjects")
    public final Map<Long, ShipObjectType> getShipObjects() {
        return this.getLoadedShips().getIdToShipData();
    }

    @Deprecated(message="use loadedShips", replaceWith=@ReplaceWith(expression="loadedShips", imports={}))
    public static /* synthetic */ void getShipObjects$annotations() {
    }

    @JvmName(name="getDispatcher")
    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @JvmName(name="getCoroutineScope")
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @JvmName(name="getTickNumber")
    public final int getTickNumber() {
        return this.tickNumber;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean isChunkInShipyard(int chunkX, int chunkZ, String dimensionId) {
        void var2_2;
        void var1_1;
        void var3_3;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        return this.chunkAllocators.forDimension((String)var3_3).isChunkInShipyard((int)var1_1, (int)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean isBlockInShipyard(int blockX, int blockY, int blockZ, String dimensionId) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        return this.chunkAllocators.forDimension(dimensionId).isBlockInShipyard((int)var1_1, (int)var2_2, (int)var3_3);
    }

    public void preTick() {
        try {
            gu_0 gu_02 = this._dispatcher;
            CollectionsKt.removeAll((Iterable)gu_02.a, (Function1)gu_0.1.a);
        }
        catch (Exception exception) {
            et_0.Companion.getLogger().error("Error while ticking ships", (Throwable)exception);
        }
        int n2 = this.tickNumber;
        this.tickNumber = n2 + 1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onSetBlock(int posX, int posY, int posZ, String dimensionId, VsiBlockType oldBlockType, VsiBlockType newBlockType, double oldBlockMass, double newBlockMass) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)oldBlockType, (String)"");
        Intrinsics.checkNotNullParameter((Object)newBlockType, (String)"");
        ShipInternal shipInternal = (ShipInternal)this.getAllShips().getByChunkPos(posX >> 4, posZ >> 4, dimensionId);
        if (shipInternal != null) {
            void var3_3;
            void var2_2;
            void var1_1;
            shipInternal.onSetBlock((int)var1_1, (int)var2_2, (int)var3_3, Intrinsics.areEqual((Object)newBlockType, (Object)this.blockTypes.getAir()), oldBlockMass, newBlockMass, this instanceof ServerShipWorld);
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Deprecated(message="redundant", replaceWith=@ReplaceWith(expression="loadedShips.getShipDataIntersecting(aabb)", imports={}))
    public List<ShipObjectType> getShipObjectsIntersecting(AABBdc aabb) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"");
        return CollectionsKt.toList(this.getLoadedShips().getIntersecting((AABBdc)var1_1));
    }

    public abstract void destroyWorld();

    public static final /* synthetic */ Logger access$getLogger$delegate$cp() {
        return logger$delegate;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Et$Companion;", "", "Lorg/apache/logging/log4j/Logger;", "logger$delegate", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "logger", "<init>", "()V"})
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] a;

        private Companion() {
        }

        @JvmName(name="getLogger")
        private final Logger getLogger() {
            KProperty<Object> kProperty = a[0];
            Logger logger = Et.access$getLogger$delegate$cp();
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static {
            KProperty[] kPropertyArray = new KProperty[1];
            KProperty[] kPropertyArray2 = kPropertyArray;
            kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(Companion.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)));
            a = kPropertyArray2;
        }
    }
}

