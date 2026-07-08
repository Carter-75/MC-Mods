/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.qW;
import org.valkyrienskies.core.impl.shadow.qZ;
import org.valkyrienskies.core.impl.shadow.rA;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rZ;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;
import org.valkyrienskies.core.impl.shadow.ry_0;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.rx
 */
final class rx_0 {
    private rB[] a;
    private List<rx_0> b;
    private rY<rv_0> c;
    private boolean d;
    private final double e;

    private rx_0(double d2) {
        this.b = new ArrayList<rx_0>();
        this.e = d2;
    }

    private rx_0(rB[] rBArray, double d2) {
        if (rBArray[0] == null) {
            throw new oV(px_0.OUTLINE_BOUNDARY_LOOP_OPEN, new Object[0]);
        }
        this.a = rBArray;
        this.b = new ArrayList<rx_0>();
        this.e = d2;
        ArrayList<sb_0<rv_0>> arrayList = new ArrayList<sb_0<rv_0>>();
        rB rB2 = rBArray[rBArray.length - 1];
        for (int i2 = 0; i2 < rBArray.length; ++i2) {
            Object object = rB2;
            rB2 = rBArray[i2];
            rw_0 rw_02 = new rw_0((rB)object, rB2, d2);
            qZ qZ2 = rw_02.e((qM<rv_0>)object);
            object = qZ2;
            object = rw_02.e((qM<rv_0>)rB2);
            object = new qW(qZ2.d, ((qZ)object).d, d2);
            arrayList.add(new rA(rw_02, (rY<qU>)object));
        }
        this.c = new ry_0((Collection<sb_0<rv_0>>)arrayList, d2);
        if (Double.isInfinite(this.c.g())) {
            this.c = new rZ<rv_0>().a(this.c);
            this.d = false;
            return;
        }
        this.d = true;
    }

    private void a(rB[] rBArray) {
        this.a(new rx_0(rBArray, this.e));
    }

    private void a(rx_0 rx_02) {
        rx_0 rx_03;
        block0: while (true) {
            for (rx_0 object2 : rx_03.b) {
                if (!object2.c.a(rx_02.c)) continue;
                rx_03 = object2;
                continue block0;
            }
            break;
        }
        Object object = rx_03.b.iterator();
        while (object.hasNext()) {
            rx_0 rx_04 = object.next();
            if (!rx_02.c.a(rx_04.c)) continue;
            rx_02.b.add(rx_04);
            object.remove();
        }
        object = new rZ();
        for (rx_0 rx_05 : rx_03.b) {
            if (((rZ)object).b(rx_02.c, rx_05.c).d()) continue;
            throw new oV(px_0.CROSSING_BOUNDARY_LOOPS, new Object[0]);
        }
        rx_03.b.add(rx_02);
    }

    private void a() {
        for (rx_0 rx_02 : this.b) {
            rx_02.a(true);
        }
    }

    private void a(boolean bl) {
        if (this.d ^ bl) {
            int n2 = -1;
            int n3 = this.a.length;
            while (++n2 < --n3) {
                rB rB2 = this.a[n2];
                this.a[n2] = this.a[n3];
                this.a[n3] = rB2;
            }
        }
        for (rx_0 rx_02 : this.b) {
            rx_02.a(!bl);
        }
    }
}

