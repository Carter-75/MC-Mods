/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collections;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qp_0;
import org.valkyrienskies.core.impl.shadow.qz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.qt
 */
public final class qt_0
extends qz_0 {
    private double b = 0.9;

    private qt_0(List<qp_0> list, int n2, double d2) {
        super(list, n2);
        this.a(d2);
    }

    private qt_0(int n2, double d2) {
        super(n2);
        this.a(d2);
    }

    @Override
    public final qt_0 a() {
        qt_0 qt_02 = this;
        qt_0 qt_03 = new qt_0(this.e(), qt_02.b);
        List<qp_0> list = this.c();
        Collections.sort(list);
        qt_02 = this;
        int n2 = (int)BY.z((1.0 - qt_02.b) * (double)list.size());
        while (n2 < list.size()) {
            qt_03.a(list.get(n2));
            ++n2;
        }
        return qt_03;
    }

    private void a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(px_0.ELITISM_RATE, (Number)d2, 0, 1);
        }
        this.b = d2;
    }

    private double g() {
        return this.b;
    }
}

