/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.internal.world.VsiPlayer;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fu
 */
public final class fu_0 {
    public final Map<VsiPlayer, Set<Long>> a;
    private final Long2ObjectOpenHashMap<Set<VsiPlayer>> d;
    public final Map<VsiPlayer, Set<Long>> b;
    public final Map<VsiPlayer, Set<Long>> c;

    public fu_0(Map<VsiPlayer, ? extends Set<Long>> map2, Long2ObjectOpenHashMap<Set<VsiPlayer>> long2ObjectOpenHashMap, Map<VsiPlayer, ? extends Set<Long>> map3, Map<VsiPlayer, ? extends Set<Long>> map4) {
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectOpenHashMap, (String)"");
        Intrinsics.checkNotNullParameter(map3, (String)"");
        Intrinsics.checkNotNullParameter(map4, (String)"");
        this.a = map2;
        this.d = long2ObjectOpenHashMap;
        this.b = map3;
        this.c = map4;
    }

    public final Map<VsiPlayer, Set<Long>> a() {
        return this.a;
    }

    private Long2ObjectOpenHashMap<Set<VsiPlayer>> d() {
        return this.d;
    }

    public final Map<VsiPlayer, Set<Long>> b() {
        return this.b;
    }

    public final Map<VsiPlayer, Set<Long>> c() {
        return this.c;
    }

    private Map<VsiPlayer, Set<Long>> e() {
        return this.a;
    }

    private Long2ObjectOpenHashMap<Set<VsiPlayer>> f() {
        return this.d;
    }

    private Map<VsiPlayer, Set<Long>> g() {
        return this.b;
    }

    private Map<VsiPlayer, Set<Long>> h() {
        return this.c;
    }

    private static fu_0 a(Map<VsiPlayer, ? extends Set<Long>> map2, Long2ObjectOpenHashMap<Set<VsiPlayer>> long2ObjectOpenHashMap, Map<VsiPlayer, ? extends Set<Long>> map3, Map<VsiPlayer, ? extends Set<Long>> map4) {
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectOpenHashMap, (String)"");
        Intrinsics.checkNotNullParameter(map3, (String)"");
        Intrinsics.checkNotNullParameter(map4, (String)"");
        return new fu_0(map2, long2ObjectOpenHashMap, map3, map4);
    }

    private static /* synthetic */ fu_0 a(fu_0 object, Map map2, Long2ObjectOpenHashMap object2, Map map3, Map map4, int n2) {
        if ((n2 & 1) != 0) {
            map2 = ((fu_0)object).a;
        }
        if ((n2 & 2) != 0) {
            object2 = ((fu_0)object).d;
        }
        if ((n2 & 4) != 0) {
            map3 = ((fu_0)object).b;
        }
        if ((n2 & 8) != 0) {
            map4 = ((fu_0)object).c;
        }
        Map<VsiPlayer, Set<Long>> map5 = map2;
        Long2ObjectOpenHashMap<Set<VsiPlayer>> long2ObjectOpenHashMap = object2;
        Map<VsiPlayer, Set<Long>> map6 = map3;
        map3 = map4;
        object2 = map6;
        map2 = long2ObjectOpenHashMap;
        object = map5;
        Intrinsics.checkNotNullParameter(map5, (String)"");
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter(object2, (String)"");
        Intrinsics.checkNotNullParameter(map3, (String)"");
        return new fu_0((Map<VsiPlayer, ? extends Set<Long>>)object, (Long2ObjectOpenHashMap<Set<VsiPlayer>>)map2, (Map<VsiPlayer, ? extends Set<Long>>)object2, (Map<VsiPlayer, ? extends Set<Long>>)map3);
    }

    public final String toString() {
        return "PhysEntityTrackingInfo(playersToPhysEntitiesWatchingMap=" + this.a + ", physEntitiesToPlayersWatchingMap=" + this.d + ", playersToPhysEntitiesNewlyWatchingMap=" + this.b + ", playersToPhysEntitiesNoLongerWatchingMap=" + this.c + ")";
    }

    public final int hashCode() {
        int n2 = ((Object)this.a).hashCode();
        n2 = n2 * 31 + this.d.hashCode();
        n2 = n2 * 31 + ((Object)this.b).hashCode();
        n2 = n2 * 31 + ((Object)this.c).hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        fu_0 fu_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof fu_0)) {
            return false;
        }
        fu_02 = fu_02;
        if (!Intrinsics.areEqual(this.a, fu_02.a)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.d, fu_02.d)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.b, fu_02.b)) {
            return false;
        }
        return Intrinsics.areEqual(this.c, fu_02.c);
    }
}

