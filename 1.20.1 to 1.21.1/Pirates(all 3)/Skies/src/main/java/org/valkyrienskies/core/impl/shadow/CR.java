/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.internal.world.VsiPlayer;

public final class CR {
    public final Map<VsiPlayer, Map<ServerShipInternal, LongSet>> a;
    private final Long2ObjectMap<Set<VsiPlayer>> f;
    public final Map<VsiPlayer, Set<ServerShipInternal>> b;
    public final Map<VsiPlayer, Set<ServerShipInternal>> c;
    private final Set<ServerShipInternal> g;
    public final Set<ServerShipInternal> d;
    public final Set<VsiPlayer> e;

    public CR(Map<VsiPlayer, ? extends Map<ServerShipInternal, ? extends LongSet>> map2, Long2ObjectMap<Set<VsiPlayer>> long2ObjectMap, Map<VsiPlayer, ? extends Set<? extends ServerShipInternal>> map3, Map<VsiPlayer, ? extends Set<? extends ServerShipInternal>> map4, Set<? extends ServerShipInternal> set, Set<? extends ServerShipInternal> set2, Set<? extends VsiPlayer> set3) {
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectMap, (String)"");
        Intrinsics.checkNotNullParameter(map3, (String)"");
        Intrinsics.checkNotNullParameter(map4, (String)"");
        Intrinsics.checkNotNullParameter(set, (String)"");
        Intrinsics.checkNotNullParameter(set2, (String)"");
        Intrinsics.checkNotNullParameter(set3, (String)"");
        this.a = map2;
        this.f = long2ObjectMap;
        this.b = map3;
        this.c = map4;
        this.g = set;
        this.d = set2;
        this.e = set3;
    }

    public final Map<VsiPlayer, Map<ServerShipInternal, LongSet>> a() {
        return this.a;
    }

    private Long2ObjectMap<Set<VsiPlayer>> f() {
        return this.f;
    }

    public final Map<VsiPlayer, Set<ServerShipInternal>> b() {
        return this.b;
    }

    public final Map<VsiPlayer, Set<ServerShipInternal>> c() {
        return this.c;
    }

    private Set<ServerShipInternal> g() {
        return this.g;
    }

    public final Set<ServerShipInternal> d() {
        return this.d;
    }

    public final Set<VsiPlayer> e() {
        return this.e;
    }

    public final Iterable<ServerShipInternal> a(VsiPlayer vsiPlayer) {
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        Map map2 = this.a.get(vsiPlayer);
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        return map2.keySet();
    }

    private Map<VsiPlayer, Map<ServerShipInternal, LongSet>> h() {
        return this.a;
    }

    private Long2ObjectMap<Set<VsiPlayer>> i() {
        return this.f;
    }

    private Map<VsiPlayer, Set<ServerShipInternal>> j() {
        return this.b;
    }

    private Map<VsiPlayer, Set<ServerShipInternal>> k() {
        return this.c;
    }

    private Set<ServerShipInternal> l() {
        return this.g;
    }

    private Set<ServerShipInternal> m() {
        return this.d;
    }

    private Set<VsiPlayer> n() {
        return this.e;
    }

    private static CR a(Map<VsiPlayer, ? extends Map<ServerShipInternal, ? extends LongSet>> map2, Long2ObjectMap<Set<VsiPlayer>> long2ObjectMap, Map<VsiPlayer, ? extends Set<? extends ServerShipInternal>> map3, Map<VsiPlayer, ? extends Set<? extends ServerShipInternal>> map4, Set<? extends ServerShipInternal> set, Set<? extends ServerShipInternal> set2, Set<? extends VsiPlayer> set3) {
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectMap, (String)"");
        Intrinsics.checkNotNullParameter(map3, (String)"");
        Intrinsics.checkNotNullParameter(map4, (String)"");
        Intrinsics.checkNotNullParameter(set, (String)"");
        Intrinsics.checkNotNullParameter(set2, (String)"");
        Intrinsics.checkNotNullParameter(set3, (String)"");
        return new CR(map2, long2ObjectMap, map3, map4, set, set2, set3);
    }

    private static /* synthetic */ CR a(CR object, Map map2, Long2ObjectMap object2, Map map3, Map object3, Set set, Set set2, Set set3, int n2) {
        if ((n2 & 1) != 0) {
            map2 = ((CR)object).a;
        }
        if ((n2 & 2) != 0) {
            object2 = ((CR)object).f;
        }
        if ((n2 & 4) != 0) {
            map3 = ((CR)object).b;
        }
        if ((n2 & 8) != 0) {
            object3 = ((CR)object).c;
        }
        if ((n2 & 0x10) != 0) {
            set = ((CR)object).g;
        }
        if ((n2 & 0x20) != 0) {
            set2 = ((CR)object).d;
        }
        if ((n2 & 0x40) != 0) {
            set3 = ((CR)object).e;
        }
        Map<VsiPlayer, Map<ServerShipInternal, LongSet>> map4 = map2;
        Long2ObjectMap<Set<VsiPlayer>> long2ObjectMap = object2;
        Map<VsiPlayer, Set<ServerShipInternal>> map5 = map3;
        Map<VsiPlayer, Set<ServerShipInternal>> map6 = object3;
        Set<ServerShipInternal> set4 = set;
        Set<ServerShipInternal> set5 = set2;
        set2 = set3;
        set = set5;
        object3 = set4;
        map3 = map6;
        object2 = map5;
        map2 = long2ObjectMap;
        object = map4;
        Intrinsics.checkNotNullParameter(map4, (String)"");
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter(object2, (String)"");
        Intrinsics.checkNotNullParameter(map3, (String)"");
        Intrinsics.checkNotNullParameter((Object)object3, (String)"");
        Intrinsics.checkNotNullParameter(set, (String)"");
        Intrinsics.checkNotNullParameter(set2, (String)"");
        return new CR((Map<VsiPlayer, ? extends Map<ServerShipInternal, ? extends LongSet>>)object, (Long2ObjectMap<Set<VsiPlayer>>)map2, (Map<VsiPlayer, ? extends Set<? extends ServerShipInternal>>)object2, (Map<VsiPlayer, ? extends Set<? extends ServerShipInternal>>)map3, (Set<? extends ServerShipInternal>)object3, (Set<? extends ServerShipInternal>)set, (Set<? extends VsiPlayer>)set2);
    }

    public final String toString() {
        return "ChunkTrackingInfo(playersToShipsWatchingMap=" + this.a + ", shipsToPlayersWatchingMap=" + this.f + ", playersToShipsNewlyWatchingMap=" + this.b + ", playersToShipsNoLongerWatchingMap=" + this.c + ", shipsToLoad=" + this.g + ", shipsToUnload=" + this.d + ", newPlayers=" + this.e + ")";
    }

    public final int hashCode() {
        int n2 = ((Object)this.a).hashCode();
        n2 = n2 * 31 + this.f.hashCode();
        n2 = n2 * 31 + ((Object)this.b).hashCode();
        n2 = n2 * 31 + ((Object)this.c).hashCode();
        n2 = n2 * 31 + ((Object)this.g).hashCode();
        n2 = n2 * 31 + ((Object)this.d).hashCode();
        n2 = n2 * 31 + ((Object)this.e).hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        CR cR;
        if (this == other) {
            return true;
        }
        if (!(other instanceof CR)) {
            return false;
        }
        cR = cR;
        if (!Intrinsics.areEqual(this.a, cR.a)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.f, cR.f)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.b, cR.b)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.c, cR.c)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.g, cR.g)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.d, cR.d)) {
            return false;
        }
        return Intrinsics.areEqual(this.e, cR.e);
    }
}

