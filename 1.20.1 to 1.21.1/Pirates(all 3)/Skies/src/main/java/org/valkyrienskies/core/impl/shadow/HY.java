/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3fc;
import org.valkyrienskies.core.impl.shadow.HT;
import org.valkyrienskies.core.impl.shadow.HV;
import org.valkyrienskies.core.impl.shadow.ib_0;
import org.valkyrienskies.core.impl.shadow.ic_0;
import org.valkyrienskies.core.impl.shadow.id_0;

public final class HY
implements ib_0 {
    public final id_0 a;
    public final List<HT> b;
    public final id_0 c;
    public final HV d;
    public final Vector3fc e;

    public HY(id_0 id_02, List<HT> list, id_0 id_03, HV hV, Vector3fc vector3fc) {
        Intrinsics.checkNotNullParameter((Object)id_02, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter((Object)id_03, (String)"");
        Intrinsics.checkNotNullParameter((Object)((Object)hV), (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3fc, (String)"");
        this.a = id_02;
        this.b = list;
        this.c = id_03;
        this.d = hV;
        this.e = vector3fc;
    }

    @Override
    public final id_0 a() {
        return this.a;
    }

    @Override
    public final List<HT> b() {
        return this.b;
    }

    public final id_0 c() {
        return this.c;
    }

    public final HV d() {
        return this.d;
    }

    public final Vector3fc e() {
        return this.e;
    }

    @Override
    public final ic_0 f() {
        return ic_0.BELT;
    }

    private id_0 g() {
        HY hY = this;
        return hY.a;
    }

    private List<HT> h() {
        HY hY = this;
        return hY.b;
    }

    private id_0 i() {
        return this.c;
    }

    private HV j() {
        return this.d;
    }

    private Vector3fc k() {
        return this.e;
    }

    private static HY a(id_0 id_02, List<HT> list, id_0 id_03, HV hV, Vector3fc vector3fc) {
        Intrinsics.checkNotNullParameter((Object)id_02, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter((Object)id_03, (String)"");
        Intrinsics.checkNotNullParameter((Object)((Object)hV), (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3fc, (String)"");
        return new HY(id_02, list, id_03, hV, vector3fc);
    }

    private static /* synthetic */ HY a(HY object, id_0 object2, List object3, id_0 object4, HV object5, Vector3fc vector3fc, int n2) {
        HY hY;
        if ((n2 & 1) != 0) {
            hY = object;
            object2 = hY.a;
        }
        if ((n2 & 2) != 0) {
            hY = object;
            object3 = hY.b;
        }
        if ((n2 & 4) != 0) {
            object4 = ((HY)object).c;
        }
        if ((n2 & 8) != 0) {
            object5 = ((HY)object).d;
        }
        if ((n2 & 0x10) != 0) {
            vector3fc = ((HY)object).e;
        }
        id_0 id_02 = object2;
        List<HT> list = object3;
        id_0 id_03 = object4;
        HV hV = object5;
        object5 = vector3fc;
        object4 = hV;
        object3 = id_03;
        object2 = list;
        object = id_02;
        Intrinsics.checkNotNullParameter((Object)id_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object3, (String)"");
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        Intrinsics.checkNotNullParameter((Object)object5, (String)"");
        return new HY((id_0)object, (List<HT>)object2, (id_0)object3, (HV)((Object)object4), (Vector3fc)object5);
    }

    public final String toString() {
        HY hY = this;
        HY hY2 = hY;
        hY2 = this;
        return "Lod1SolidBeltCollisionShape(overallBoundingBox=" + hY.a + ", collisionPoints=" + hY2.b + ", localBoundingBox=" + this.c + ", beltType=" + (Object)((Object)this.d) + ", topVel=" + this.e + ')';
    }

    public final int hashCode() {
        HY hY = this;
        int n2 = hY.a.hashCode();
        HY hY2 = this;
        int n3 = n2 * 31 + ((Object)hY2.b).hashCode();
        n3 = n3 * 31 + this.c.hashCode();
        n3 = n3 * 31 + this.d.hashCode();
        n3 = n3 * 31 + this.e.hashCode();
        return n3;
    }

    public final boolean equals(Object other) {
        HY hY;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HY)) {
            return false;
        }
        hY = hY;
        HY hY2 = this;
        HY hY3 = hY2;
        hY3 = hY;
        if (!Intrinsics.areEqual((Object)hY2.a, (Object)hY3.a)) {
            return false;
        }
        HY hY4 = this;
        hY3 = hY4;
        hY3 = hY;
        if (!Intrinsics.areEqual(hY4.b, hY3.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)hY.c)) {
            return false;
        }
        if (this.d != hY.d) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.e, (Object)hY.e);
    }
}

