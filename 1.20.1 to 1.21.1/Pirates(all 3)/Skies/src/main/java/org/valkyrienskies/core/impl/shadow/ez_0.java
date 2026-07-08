/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableSet
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KMutableProperty0
 */
package org.valkyrienskies.core.impl.shadow;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty0;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.shadow.CR;
import org.valkyrienskies.core.impl.shadow.CY;
import org.valkyrienskies.core.impl.shadow.EO;
import org.valkyrienskies.core.impl.shadow.fu_0;
import org.valkyrienskies.core.impl.shadow.fv_0;
import org.valkyrienskies.core.impl.shadow.ge_0;
import org.valkyrienskies.core.impl.shadow.gh_0;
import org.valkyrienskies.core.internal.physics.PhysicsEntityServer;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTasks;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ez
 */
public final class ez_0 {
    public final EO a;
    public final CY b;
    public final ChunkAllocatorProvider c;
    public final fv_0 d;
    public final ge_0<a> e;
    public Iterable<? extends VsiChunkWatchTask> f;
    public Iterable<? extends VsiChunkUnwatchTask> g;
    public VsiChunkWatchTasks h;
    public fu_0 i;

    @Inject
    public ez_0(EO eO, CY cY, ChunkAllocatorProvider chunkAllocatorProvider, fv_0 fv_02) {
        Intrinsics.checkNotNullParameter((Object)eO, (String)"");
        Intrinsics.checkNotNullParameter((Object)cY, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkAllocatorProvider, (String)"");
        Intrinsics.checkNotNullParameter((Object)fv_02, (String)"");
        this.a = eO;
        this.b = cY;
        this.c = chunkAllocatorProvider;
        this.d = fv_02;
        this.e = gh_0.a(org.valkyrienskies.core.impl.shadow.Ez$a.PRE_TICK, 1.a);
    }

    public final ImmutableMap<VsiPlayer, ImmutableSet<ServerShipInternal>> a() {
        EO eO = this.a;
        return eO.g;
    }

    private static KMutableProperty0 a(ez_0 ez_02) {
        return Reflection.mutableProperty0((MutablePropertyReference0)((MutablePropertyReference0)new MutablePropertyReference0Impl((Object)ez_02.a, EO.class, "playersToTrackedShips", "getPlayersToTrackedShips()Lcom/google/common/collect/ImmutableMap;", 0)));
    }

    public final ImmutableMap<VsiPlayer, ImmutableSet<PhysicsEntityServer>> b() {
        EO eO = this.a;
        return eO.h;
    }

    private static KMutableProperty0 b(ez_0 ez_02) {
        return Reflection.mutableProperty0((MutablePropertyReference0)((MutablePropertyReference0)new MutablePropertyReference0Impl((Object)ez_02.a, EO.class, "playersToTrackedPhysicsEntities", "getPlayersToTrackedPhysicsEntities()Lcom/google/common/collect/ImmutableMap;", 0)));
    }

    public final VsiChunkWatchTasks c() {
        VsiChunkWatchTasks vsiChunkWatchTasks = this.h;
        if (vsiChunkWatchTasks != null) {
            return vsiChunkWatchTasks;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    public final void a(Set<? extends VsiPlayer> set, Set<? extends VsiPlayer> set2, Iterable<ShipData> iterable, Iterable<ShipData> iterable2) {
        Intrinsics.checkNotNullParameter(set, (String)"");
        Intrinsics.checkNotNullParameter(set2, (String)"");
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        Intrinsics.checkNotNullParameter(iterable2, (String)"");
        this.e.a(org.valkyrienskies.core.impl.shadow.Ez$a.PRE_TICK);
        this.h = this.b.a(set, set2, iterable, iterable2);
    }

    public final void b(Set<? extends VsiPlayer> set, Set<? extends VsiPlayer> object, Iterable<PhysicsEntityServer> iterable, Iterable<Long> iterable2) {
        Iterable<? extends VsiChunkUnwatchTask> iterable3;
        Intrinsics.checkNotNullParameter(set, (String)"");
        Intrinsics.checkNotNullParameter(object, (String)"");
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        Intrinsics.checkNotNullParameter(iterable2, (String)"");
        this.e.a(org.valkyrienskies.core.impl.shadow.Ez$a.POST_TICK);
        this.i = this.d.a(set, (Set<? extends VsiPlayer>)object, iterable, iterable2);
        Iterable<? extends VsiChunkWatchTask> iterable4 = this.f;
        if (iterable4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable4 = null;
        }
        if ((iterable3 = this.g) == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            iterable3 = null;
        }
        object = this.b.a(iterable4, iterable3);
        Iterable iterable5 = set;
        fu_0 fu_02 = this.i;
        if (fu_02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            fu_02 = null;
        }
        this.a.a(iterable5, (CR)object, fu_02);
    }

    public final void a(Iterable<? extends VsiChunkWatchTask> iterable, Iterable<? extends VsiChunkUnwatchTask> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        Intrinsics.checkNotNullParameter(iterable2, (String)"");
        this.e.a(org.valkyrienskies.core.impl.shadow.Ez$a.SET_EXECUTED);
        this.f = iterable;
        this.g = iterable2;
    }

    public final Iterator<VsiPlayer> a(int n2, int n3, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        if (this.c.forDimension(string).isChunkInShipyard(n2, n3)) {
            return this.b.a(n2, n3, string).iterator();
        }
        Iterator<VsiPlayer> iterator2 = Collections.emptyIterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"");
        return iterator2;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ez$a;", "", "<init>", "(Ljava/lang/String;I)V", "PRE_TICK", "SET_EXECUTED", "POST_TICK"})
    public static final class a
    extends Enum<a> {
        public static final /* enum */ a PRE_TICK = new a();
        public static final /* enum */ a SET_EXECUTED = new a();
        public static final /* enum */ a POST_TICK = new a();
        private static final /* synthetic */ a[] $VALUES;

        public static a[] values() {
            return (a[])$VALUES.clone();
        }

        public static a valueOf(String value) {
            String string;
            return Enum.valueOf(a.class, string);
        }

        private static final /* synthetic */ a[] a() {
            a[] aArray = new a[3];
            a[] aArray2 = aArray;
            aArray[0] = PRE_TICK;
            aArray2[1] = SET_EXECUTED;
            aArray2[2] = POST_TICK;
            return aArray2;
        }

        static {
            a[] aArray = new a[3];
            a[] aArray2 = aArray;
            aArray[0] = PRE_TICK;
            aArray2[1] = SET_EXECUTED;
            aArray2[2] = POST_TICK;
            $VALUES = aArray2;
        }
    }
}

