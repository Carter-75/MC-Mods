/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qA;
import org.valkyrienskies.core.impl.shadow.qF;
import org.valkyrienskies.core.impl.shadow.qI;
import org.valkyrienskies.core.impl.shadow.qJ;
import org.valkyrienskies.core.impl.shadow.qq_0;
import org.valkyrienskies.core.impl.shadow.qr_0;
import org.valkyrienskies.core.impl.shadow.qt_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zy_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.qx
 */
public final class qx_0 {
    private static zF a = new zy_0();
    private final qr_0 b;
    private final double c;
    private final qA d;
    private final double e;
    private final qI f;
    private int g = 0;

    private qx_0(qr_0 qr_02, double d2, qA qA2, double d3, qI qI2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(px_0.CROSSOVER_RATE, (Number)d2, 0, 1);
        }
        if (d3 < 0.0 || d3 > 1.0) {
            throw new po_0(px_0.MUTATION_RATE, (Number)d3, 0, 1);
        }
        this.b = qr_02;
        this.c = d2;
        this.d = qA2;
        this.e = d3;
        this.f = qI2;
    }

    private static synchronized void a(zF zF2) {
        a = zF2;
    }

    public static synchronized zF a() {
        return a;
    }

    private qF a(qF object, qJ qJ2) {
        this.g = 0;
        while (!qJ2.a()) {
            qF qF2 = object;
            object = this;
            qt_0 qt_02 = qF2.a();
            zF zF2 = qx_0.a();
            while (qt_02.f() < qt_02.e()) {
                Object object2;
                Object object3;
                Object object4 = object;
                qq_0 qq_02 = ((qx_0)object4).f.a(qF2);
                object4 = object;
                if (zF2.nextDouble() < ((qx_0)object3).c) {
                    Object object5 = object;
                    object4 = object5;
                    qq_0 qq_03 = qq_02;
                    object4 = qq_03;
                    object4 = qq_02;
                    qq_02 = ((qx_0)object5).b.a(qq_03.a, ((qq_0)object4).b);
                }
                object4 = object;
                if (zF2.nextDouble() < ((qx_0)object2).e) {
                    Object object6 = object;
                    object4 = object6;
                    qq_0 qq_04 = qq_02;
                    object4 = qq_04;
                    Object object7 = object;
                    object4 = object7;
                    object4 = qq_02;
                    qq_02 = new qq_0(((qx_0)object6).d.a(qq_04.a), ((qx_0)object7).d.a(((qq_0)object4).b));
                }
                object4 = qq_02;
                qt_02.a(((qq_0)object4).a);
                if (qt_02.f() >= qt_02.e()) continue;
                object4 = qq_02;
                qt_02.a(((qq_0)object4).b);
            }
            object = qt_02;
            ++this.g;
        }
        return object;
    }

    private qF a(qF qF2) {
        qt_0 qt_02 = qF2.a();
        zF zF2 = qx_0.a();
        while (qt_02.f() < qt_02.e()) {
            qx_0 qx_02;
            qx_0 qx_03;
            Object object = this;
            qq_0 qq_02 = ((qx_0)object).f.a(qF2);
            object = this;
            if (zF2.nextDouble() < qx_03.c) {
                qx_0 qx_04 = this;
                object = qx_04;
                qq_0 qq_03 = qq_02;
                object = qq_03;
                object = qq_02;
                qq_02 = qx_04.b.a(qq_03.a, ((qq_0)object).b);
            }
            object = this;
            if (zF2.nextDouble() < qx_02.e) {
                qx_0 qx_05 = this;
                object = qx_05;
                qq_0 qq_04 = qq_02;
                object = qq_04;
                qx_0 qx_06 = this;
                object = qx_06;
                object = qq_02;
                qq_02 = new qq_0(qx_05.d.a(qq_04.a), qx_06.d.a(((qq_0)object).b));
            }
            object = qq_02;
            qt_02.a(((qq_0)object).a);
            if (qt_02.f() >= qt_02.e()) continue;
            object = qq_02;
            qt_02.a(((qq_0)object).b);
        }
        return qt_02;
    }

    private qr_0 b() {
        return this.b;
    }

    private double c() {
        return this.c;
    }

    private qA d() {
        return this.d;
    }

    private double e() {
        return this.e;
    }

    private qI f() {
        return this.f;
    }

    private int g() {
        return this.g;
    }
}

