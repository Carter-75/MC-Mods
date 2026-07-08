/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.impl.shadow.FB;
import org.valkyrienskies.core.impl.shadow.fy_0;
import org.valkyrienskies.core.impl.shadow.fz_0;
import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.internal.joints.VSJointAndId;
import org.valkyrienskies.core.internal.world.VsiPlayerState;
import org.valkyrienskies.core.util.datastructures.BlockPos2ObjectOpenHashMap;

public final class FC {
    final List<fz_0> a;
    final List<Long> b;
    final Long2ObjectMap<? extends FB> c;
    final Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>> d;
    final List<VSJointAndId> e;
    private final List<VSJointAndId> k;
    private final List<Integer> l;
    final List<VsiPlayerState> f;
    final List<fy_0> g;
    final List<fy_0> h;
    final Map<String, Vector3dc> i;
    final Map<String, LevelYRange> j;

    public FC(List<fz_0> list, List<Long> list2, Long2ObjectMap<? extends FB> long2ObjectMap, Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>> long2ObjectMap2, List<VSJointAndId> list3, List<VSJointAndId> list4, List<Integer> list5, List<VsiPlayerState> list6, List<fy_0> list7, List<fy_0> list8, Map<String, ? extends Vector3dc> map2, Map<String, LevelYRange> map3) {
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter(list2, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectMap, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectMap2, (String)"");
        Intrinsics.checkNotNullParameter(list3, (String)"");
        Intrinsics.checkNotNullParameter(list4, (String)"");
        Intrinsics.checkNotNullParameter(list5, (String)"");
        Intrinsics.checkNotNullParameter(list6, (String)"");
        Intrinsics.checkNotNullParameter(list7, (String)"");
        Intrinsics.checkNotNullParameter(list8, (String)"");
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter(map3, (String)"");
        this.a = list;
        this.b = list2;
        this.c = long2ObjectMap;
        this.d = long2ObjectMap2;
        this.e = list3;
        this.k = list4;
        this.l = list5;
        this.f = list6;
        this.g = list7;
        this.h = list8;
        this.i = map2;
        this.j = map3;
    }

    public final List<fz_0> a() {
        return this.a;
    }

    public final List<Long> b() {
        return this.b;
    }

    public final Long2ObjectMap<? extends FB> c() {
        return this.c;
    }

    public final Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>> d() {
        return this.d;
    }

    public final List<VSJointAndId> e() {
        return this.e;
    }

    private List<VSJointAndId> k() {
        return this.k;
    }

    private List<Integer> l() {
        return this.l;
    }

    public final List<VsiPlayerState> f() {
        return this.f;
    }

    public final List<fy_0> g() {
        return this.g;
    }

    public final List<fy_0> h() {
        return this.h;
    }

    public final Map<String, Vector3dc> i() {
        return this.i;
    }

    public final Map<String, LevelYRange> j() {
        return this.j;
    }

    private List<fz_0> m() {
        return this.a;
    }

    private List<Long> n() {
        return this.b;
    }

    private Long2ObjectMap<? extends FB> o() {
        return this.c;
    }

    private Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>> p() {
        return this.d;
    }

    private List<VSJointAndId> q() {
        return this.e;
    }

    private List<VSJointAndId> r() {
        return this.k;
    }

    private List<Integer> s() {
        return this.l;
    }

    private List<VsiPlayerState> t() {
        return this.f;
    }

    private List<fy_0> u() {
        return this.g;
    }

    private List<fy_0> v() {
        return this.h;
    }

    private Map<String, Vector3dc> w() {
        return this.i;
    }

    private Map<String, LevelYRange> x() {
        return this.j;
    }

    private static FC a(List<fz_0> list, List<Long> list2, Long2ObjectMap<? extends FB> long2ObjectMap, Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>> long2ObjectMap2, List<VSJointAndId> list3, List<VSJointAndId> list4, List<Integer> list5, List<VsiPlayerState> list6, List<fy_0> list7, List<fy_0> list8, Map<String, ? extends Vector3dc> map2, Map<String, LevelYRange> map3) {
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter(list2, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectMap, (String)"");
        Intrinsics.checkNotNullParameter(long2ObjectMap2, (String)"");
        Intrinsics.checkNotNullParameter(list3, (String)"");
        Intrinsics.checkNotNullParameter(list4, (String)"");
        Intrinsics.checkNotNullParameter(list5, (String)"");
        Intrinsics.checkNotNullParameter(list6, (String)"");
        Intrinsics.checkNotNullParameter(list7, (String)"");
        Intrinsics.checkNotNullParameter(list8, (String)"");
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter(map3, (String)"");
        return new FC(list, list2, long2ObjectMap, long2ObjectMap2, list3, list4, list5, list6, list7, list8, map2, map3);
    }

    private static /* synthetic */ FC a(FC object, List list, List list2, Long2ObjectMap object2, Long2ObjectMap object3, List list3, List list4, List list5, List list6, List list7, List object4, Map map2, Map map3, int n2) {
        if ((n2 & 1) != 0) {
            list = ((FC)object).a;
        }
        if ((n2 & 2) != 0) {
            list2 = ((FC)object).b;
        }
        if ((n2 & 4) != 0) {
            object2 = ((FC)object).c;
        }
        if ((n2 & 8) != 0) {
            object3 = ((FC)object).d;
        }
        if ((n2 & 0x10) != 0) {
            list3 = ((FC)object).e;
        }
        if ((n2 & 0x20) != 0) {
            list4 = ((FC)object).k;
        }
        if ((n2 & 0x40) != 0) {
            list5 = ((FC)object).l;
        }
        if ((n2 & 0x80) != 0) {
            list6 = ((FC)object).f;
        }
        if ((n2 & 0x100) != 0) {
            list7 = ((FC)object).g;
        }
        if ((n2 & 0x200) != 0) {
            object4 = ((FC)object).h;
        }
        if ((n2 & 0x400) != 0) {
            map2 = ((FC)object).i;
        }
        if ((n2 & 0x800) != 0) {
            map3 = ((FC)object).j;
        }
        List<fz_0> list8 = list;
        List<Long> list9 = list2;
        Long2ObjectMap<? extends FB> long2ObjectMap = object2;
        Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>> long2ObjectMap2 = object3;
        List<VSJointAndId> list10 = list3;
        List<VSJointAndId> list11 = list4;
        List<Integer> list12 = list5;
        List<VsiPlayerState> list13 = list6;
        List<fy_0> list14 = list7;
        List<fy_0> list15 = object4;
        Map<String, Vector3dc> map4 = map2;
        map2 = map3;
        object4 = map4;
        list7 = list15;
        list6 = list14;
        list5 = list13;
        list4 = list12;
        list3 = list11;
        object3 = list10;
        object2 = long2ObjectMap2;
        list2 = long2ObjectMap;
        list = list9;
        object = list8;
        Intrinsics.checkNotNullParameter(list8, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter(list2, (String)"");
        Intrinsics.checkNotNullParameter(object2, (String)"");
        Intrinsics.checkNotNullParameter(object3, (String)"");
        Intrinsics.checkNotNullParameter(list3, (String)"");
        Intrinsics.checkNotNullParameter(list4, (String)"");
        Intrinsics.checkNotNullParameter(list5, (String)"");
        Intrinsics.checkNotNullParameter(list6, (String)"");
        Intrinsics.checkNotNullParameter(list7, (String)"");
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        Intrinsics.checkNotNullParameter(map2, (String)"");
        return new FC((List<fz_0>)object, (List<Long>)list, (Long2ObjectMap<? extends FB>)list2, (Long2ObjectMap<? extends BlockPos2ObjectOpenHashMap<il_0>>)object2, (List<VSJointAndId>)object3, list3, (List<Integer>)list4, (List<VsiPlayerState>)list5, (List<fy_0>)list6, list7, (Map<String, ? extends Vector3dc>)object4, (Map<String, LevelYRange>)map2);
    }

    public final String toString() {
        return "VSGameFrame(newShips=" + this.a + ", deletedShips=" + this.b + ", updatedShips=" + this.c + ", voxelUpdatesMap=" + this.d + ", constraintsCreatedThisTick=" + this.e + ", constraintsUpdatedThisTick=" + this.k + ", constraintsDeletedThisTick=" + this.l + ", playerStates=" + this.f + ", disabledCollisionPairsThisTick=" + this.g + ", enabledCollisionPairsThisTick=" + this.h + ", dimensionGravity=" + this.i + ", dimensionYRange=" + this.j + ")";
    }

    public final int hashCode() {
        int n2 = ((Object)this.a).hashCode();
        n2 = n2 * 31 + ((Object)this.b).hashCode();
        n2 = n2 * 31 + this.c.hashCode();
        n2 = n2 * 31 + this.d.hashCode();
        n2 = n2 * 31 + ((Object)this.e).hashCode();
        n2 = n2 * 31 + ((Object)this.k).hashCode();
        n2 = n2 * 31 + ((Object)this.l).hashCode();
        n2 = n2 * 31 + ((Object)this.f).hashCode();
        n2 = n2 * 31 + ((Object)this.g).hashCode();
        n2 = n2 * 31 + ((Object)this.h).hashCode();
        n2 = n2 * 31 + ((Object)this.i).hashCode();
        n2 = n2 * 31 + ((Object)this.j).hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        FC fC;
        if (this == other) {
            return true;
        }
        if (!(other instanceof FC)) {
            return false;
        }
        fC = fC;
        if (!Intrinsics.areEqual(this.a, fC.a)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.b, fC.b)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.c, fC.c)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.d, fC.d)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.e, fC.e)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.k, fC.k)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.l, fC.l)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.f, fC.f)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.g, fC.g)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.h, fC.h)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.i, fC.i)) {
            return false;
        }
        return Intrinsics.areEqual(this.j, fC.j);
    }
}

