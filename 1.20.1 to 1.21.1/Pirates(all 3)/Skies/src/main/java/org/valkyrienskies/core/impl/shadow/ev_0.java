/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.valkyrienskies.core.api.ships.PositionedWing;
import org.valkyrienskies.core.api.ships.Wing;
import org.valkyrienskies.core.api.ships.WingGroupChanges;
import org.valkyrienskies.core.util.datastructures.BlockPos2ObjectOpenHashMap;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ev
 */
public final class ev_0 {
    final BlockPos2ObjectOpenHashMap<Wing> a = new BlockPos2ObjectOpenHashMap(0, 0.0f, 3, null);
    List<PositionedWing> b;
    Matrix4dc c = new Matrix4d();
    boolean d = true;
    boolean e;

    public final Matrix4dc a() {
        return this.c;
    }

    public final boolean b() {
        return this.e;
    }

    public final void a(boolean bl) {
        this.e = bl;
    }

    public final boolean a(int n2, int n3, int n4, Wing wing, boolean bl) {
        if (bl) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            List<PositionedWing> list = this.b;
            Intrinsics.checkNotNull(list);
            list.add(new PositionedWing(n2, n3, n4, wing));
        }
        if (wing != null) {
            return this.a.put(n2, n3, n4, wing) != null;
        }
        return this.a.remove(n2, n3, n4) != null;
    }

    public static /* synthetic */ boolean a(ev_0 ev_02, int n2, int n3, int n4, Wing wing, boolean bl, int n5) {
        return ev_02.a(n2, n3, n4, wing, true);
    }

    public final Wing a(int n2, int n3, int n4) {
        return this.a.get(n2, n3, n4);
    }

    public final WingGroupChanges c() {
        if (this.b == null && !this.d) {
            return null;
        }
        return new WingGroupChanges(this.b, this.d ? this.c : null);
    }

    public final void d() {
        this.b = null;
        this.d = false;
    }

    public final void a(Matrix4dc matrix4dc) {
        Intrinsics.checkNotNullParameter((Object)matrix4dc, (String)"");
        this.c = matrix4dc;
        this.d = true;
    }

    public final void a(WingGroupChanges iterator2) {
        Intrinsics.checkNotNullParameter((Object)iterator2, (String)"");
        if (((WingGroupChanges)((Object)iterator2)).getChangedTransform() != null) {
            Matrix4dc matrix4dc = ((WingGroupChanges)((Object)iterator2)).getChangedTransform();
            Intrinsics.checkNotNull((Object)matrix4dc);
            this.c = matrix4dc;
        }
        List<PositionedWing> list = ((WingGroupChanges)((Object)iterator2)).getChangedWings();
        if (list != null) {
            iterator2 = list;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (PositionedWing)object;
                this.a(((PositionedWing)object).getPosX(), ((PositionedWing)object).getPosY(), ((PositionedWing)object).getPosZ(), ((PositionedWing)object).getWing(), false);
            }
            return;
        }
    }

    private void a(Function4<? super Integer, ? super Integer, ? super Integer, ? super Wing, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, (String)"");
        Object object = this;
        object = ((ev_0)object).a;
        if (((BlockPos2ObjectOpenHashMap)object).getContainsNullKey()) {
            function4.invoke((Object)((BlockPos2ObjectOpenHashMap)object).getKeys()[((BlockPos2ObjectOpenHashMap)object).getN() * 3], (Object)((BlockPos2ObjectOpenHashMap)object).getKeys()[((BlockPos2ObjectOpenHashMap)object).getN() * 3 + 1], (Object)((BlockPos2ObjectOpenHashMap)object).getKeys()[((BlockPos2ObjectOpenHashMap)object).getN() * 3 + 2], ((BlockPos2ObjectOpenHashMap)object).getValues()[((BlockPos2ObjectOpenHashMap)object).getN()]);
        }
        for (int i2 = ((BlockPos2ObjectOpenHashMap)object).getN(); i2 >= 0; --i2) {
            if (((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3] == 0 && ((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3 + 1] == 0 && ((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3 + 2] == 0) continue;
            function4.invoke((Object)((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3], (Object)((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3 + 1], (Object)((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3 + 2], ((BlockPos2ObjectOpenHashMap)object).getValues()[i2]);
        }
    }

    public static final /* synthetic */ BlockPos2ObjectOpenHashMap a(ev_0 ev_02) {
        return ev_02.a;
    }
}

