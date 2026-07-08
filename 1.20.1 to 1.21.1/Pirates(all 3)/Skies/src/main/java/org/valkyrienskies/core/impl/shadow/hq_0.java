/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GT;
import org.valkyrienskies.core.impl.shadow.GW;
import org.valkyrienskies.core.impl.shadow.hc_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hq
 */
public final class hq_0
implements GT {
    private final Map<Integer, GT.a> a = new HashMap();

    @Override
    public final Map<Integer, GT.a> a() {
        return this.a;
    }

    @Override
    public final GT.a a(int n2, GS object, hc_0 map2, double d2, Vector3dc vector3dc, GW gW) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)map2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        object = new a((GS)object, (hc_0)((Object)map2), d2, vector3dc, gW);
        map2 = this;
        map2 = ((hq_0)((Object)map2)).a;
        Integer n3 = n2;
        map2.put(n3, (GT.a)object);
        return (GT.a)object;
    }

    @Override
    public final boolean a(int n2) {
        hq_0 hq_02 = this;
        return hq_02.a.remove(n2) != null;
    }

    @Override
    public final void close() {
    }

    static final class a
    implements GT.a {
        private GS a;
        private hc_0 b;
        private double c;
        private Vector3dc d;
        private GW e;

        public a(GS gS, hc_0 hc_02, double d2, Vector3dc vector3dc, GW gW) {
            Intrinsics.checkNotNullParameter((Object)gS, (String)"");
            Intrinsics.checkNotNullParameter((Object)hc_02, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
            this.a = gS;
            this.b = hc_02;
            this.c = d2;
            this.d = vector3dc;
            this.e = gW;
        }

        @Override
        public final GS a() {
            return this.a;
        }

        @Override
        public final void a(GS gS) {
            Intrinsics.checkNotNullParameter((Object)gS, (String)"");
            this.a = gS;
        }

        @Override
        public final hc_0 b() {
            return this.b;
        }

        @Override
        public final void a(hc_0 hc_02) {
            Intrinsics.checkNotNullParameter((Object)hc_02, (String)"");
            this.b = hc_02;
        }

        @Override
        public final double c() {
            return this.c;
        }

        @Override
        public final void a(double d2) {
            this.c = d2;
        }

        @Override
        public final Vector3dc d() {
            return this.d;
        }

        @Override
        public final void a(Vector3dc vector3dc) {
            Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
            this.d = vector3dc;
        }

        @Override
        public final GW e() {
            return this.e;
        }

        @Override
        public final void a(GW gW) {
            this.e = gW;
        }

        private GS f() {
            a a2 = this;
            return a2.a;
        }

        private hc_0 g() {
            a a2 = this;
            return a2.b;
        }

        private double h() {
            a a2 = this;
            return a2.c;
        }

        private Vector3dc i() {
            a a2 = this;
            return a2.d;
        }

        private GW j() {
            a a2 = this;
            return a2.e;
        }

        private static a a(GS gS, hc_0 hc_02, double d2, Vector3dc vector3dc, GW gW) {
            Intrinsics.checkNotNullParameter((Object)gS, (String)"");
            Intrinsics.checkNotNullParameter((Object)hc_02, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
            return new a(gS, hc_02, d2, vector3dc, gW);
        }

        private static /* synthetic */ a a(a object, GS object2, hc_0 object3, double d2, Vector3dc vector3dc, GW gW, int n2) {
            a a2;
            if ((n2 & 1) != 0) {
                a2 = object;
                object2 = a2.a;
            }
            if ((n2 & 2) != 0) {
                a2 = object;
                object3 = a2.b;
            }
            if ((n2 & 4) != 0) {
                a2 = object;
                d2 = a2.c;
            }
            if ((n2 & 8) != 0) {
                a2 = object;
                vector3dc = a2.d;
            }
            if ((n2 & 0x10) != 0) {
                a2 = object;
                gW = a2.e;
            }
            GS gS = object2;
            hc_0 hc_02 = object3;
            GW gW2 = gW;
            object3 = vector3dc;
            double d3 = d2;
            object2 = hc_02;
            object = gS;
            Intrinsics.checkNotNullParameter((Object)gS, (String)"");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"");
            Intrinsics.checkNotNullParameter((Object)object3, (String)"");
            return new a((GS)object, (hc_0)object2, d3, (Vector3dc)object3, gW2);
        }

        public final String toString() {
            a a2 = this;
            a a3 = a2;
            a a4 = this;
            a3 = a4;
            a a5 = this;
            a3 = a5;
            a a6 = this;
            a3 = a6;
            a3 = this;
            return "DummyCompoundShapeSegmentReference(collisionShape=" + a2.a + ", poseVel=" + a4.b + ", collisionShapeScaling=" + a5.c + ", collisionShapeOffset=" + a6.d + ", nextPoseVelFunction=" + a3.e + ')';
        }

        public final int hashCode() {
            int n2;
            a a2 = this;
            int n3 = a2.a.hashCode();
            a a3 = this;
            int n4 = n3 * 31 + a3.b.hashCode();
            a a4 = this;
            int n5 = n4 * 31 + Double.hashCode(a4.c);
            a a5 = this;
            int n6 = n5 * 31 + a5.d.hashCode();
            a a6 = this;
            if (a6.e == null) {
                n2 = 0;
            } else {
                a6 = this;
                n2 = a6.e.hashCode();
            }
            int n7 = n6 * 31 + n2;
            return n7;
        }

        public final boolean equals(Object other) {
            a a2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a2 = a2;
            a a3 = this;
            a a4 = a3;
            a4 = a2;
            if (!Intrinsics.areEqual((Object)a3.a, (Object)a4.a)) {
                return false;
            }
            a a5 = this;
            a4 = a5;
            a4 = a2;
            if (!Intrinsics.areEqual((Object)a5.b, (Object)a4.b)) {
                return false;
            }
            a a6 = this;
            a4 = a6;
            a4 = a2;
            if (!Intrinsics.areEqual((Object)a6.c, (Object)a4.c)) {
                return false;
            }
            a a7 = this;
            a4 = a7;
            a4 = a2;
            if (!Intrinsics.areEqual((Object)a7.d, (Object)a4.d)) {
                return false;
            }
            a a8 = this;
            a4 = a8;
            a4 = a2;
            return Intrinsics.areEqual((Object)a8.e, (Object)a4.e);
        }
    }
}

