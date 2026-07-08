/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.HT;
import org.valkyrienskies.core.impl.shadow.ib_0;
import org.valkyrienskies.core.impl.shadow.ic_0;
import org.valkyrienskies.core.impl.shadow.id_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ia
 */
public final class ia_0
implements ib_0 {
    public final id_0 a;
    public final List<HT> b;
    public final List<id_0> c;
    public final List<id_0> d;

    public ia_0(id_0 id_02, List<HT> list, List<id_0> list2, List<id_0> list3) {
        Intrinsics.checkNotNullParameter((Object)id_02, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter(list2, (String)"");
        Intrinsics.checkNotNullParameter(list3, (String)"");
        this.a = id_02;
        this.b = list;
        this.c = list2;
        this.d = list3;
    }

    @Override
    public final id_0 a() {
        return this.a;
    }

    @Override
    public final List<HT> b() {
        return this.b;
    }

    public final List<id_0> c() {
        return this.c;
    }

    public final List<id_0> d() {
        return this.d;
    }

    @Override
    public final ic_0 f() {
        return ic_0.SOLID_BOXES;
    }

    private id_0 e() {
        ia_0 ia_02 = this;
        return ia_02.a;
    }

    private List<HT> g() {
        ia_0 ia_02 = this;
        return ia_02.b;
    }

    private List<id_0> h() {
        return this.c;
    }

    private List<id_0> i() {
        return this.d;
    }

    private static ia_0 a(id_0 id_02, List<HT> list, List<id_0> list2, List<id_0> list3) {
        Intrinsics.checkNotNullParameter((Object)id_02, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter(list2, (String)"");
        Intrinsics.checkNotNullParameter(list3, (String)"");
        return new ia_0(id_02, list, list2, list3);
    }

    private static /* synthetic */ ia_0 a(ia_0 object, id_0 object2, List list, List list2, List list3, int n2) {
        ia_0 ia_02;
        if ((n2 & 1) != 0) {
            ia_02 = object;
            object2 = ia_02.a;
        }
        if ((n2 & 2) != 0) {
            ia_02 = object;
            list = ia_02.b;
        }
        if ((n2 & 4) != 0) {
            list2 = ((ia_0)object).c;
        }
        if ((n2 & 8) != 0) {
            list3 = ((ia_0)object).d;
        }
        id_0 id_02 = object2;
        List<HT> list4 = list;
        List<id_0> list5 = list2;
        list2 = list3;
        list = list5;
        object2 = list4;
        object = id_02;
        Intrinsics.checkNotNullParameter((Object)id_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter(list2, (String)"");
        return new ia_0((id_0)object, (List<HT>)object2, list, list2);
    }

    public final String toString() {
        ia_0 ia_02 = this;
        ia_0 ia_03 = ia_02;
        ia_03 = this;
        return "Lod1SolidBoxesCollisionShape(overallBoundingBox=" + ia_02.a + ", collisionPoints=" + ia_03.b + ", solidBoxes=" + this.c + ", negativeBoxes=" + this.d + ')';
    }

    public final int hashCode() {
        ia_0 ia_02 = this;
        int n2 = ia_02.a.hashCode();
        ia_0 ia_03 = this;
        int n3 = n2 * 31 + ((Object)ia_03.b).hashCode();
        n3 = n3 * 31 + ((Object)this.c).hashCode();
        n3 = n3 * 31 + ((Object)this.d).hashCode();
        return n3;
    }

    public final boolean equals(Object other) {
        ia_0 ia_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ia_0)) {
            return false;
        }
        ia_02 = ia_02;
        ia_0 ia_03 = this;
        ia_0 ia_04 = ia_03;
        ia_04 = ia_02;
        if (!Intrinsics.areEqual((Object)ia_03.a, (Object)ia_04.a)) {
            return false;
        }
        ia_0 ia_05 = this;
        ia_04 = ia_05;
        ia_04 = ia_02;
        if (!Intrinsics.areEqual(ia_05.b, ia_04.b)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.c, ia_02.c)) {
            return false;
        }
        return Intrinsics.areEqual(this.d, ia_02.d);
    }
}

