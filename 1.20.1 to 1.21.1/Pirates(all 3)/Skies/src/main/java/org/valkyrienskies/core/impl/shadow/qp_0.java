/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qF;
import org.valkyrienskies.core.impl.shadow.qu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.qp
 */
public abstract class qp_0
implements Comparable<qp_0>,
qu_0 {
    private static final double a = Double.NEGATIVE_INFINITY;
    private double b = Double.NEGATIVE_INFINITY;

    public final double d() {
        if (this.b == Double.NEGATIVE_INFINITY) {
            this.b = this.e();
        }
        return this.b;
    }

    public final int b(qp_0 qp_02) {
        return Double.compare(this.d(), qp_02.d());
    }

    protected boolean a(qp_0 qp_02) {
        return false;
    }

    private qp_0 a(qF object) {
        object = object.iterator();
        while (object.hasNext()) {
            qp_0 qp_02 = (qp_0)object.next();
            if (!this.a(qp_02)) continue;
            return qp_02;
        }
        return null;
    }

    private void b(qF object) {
        Object object2;
        block2: {
            Object object3 = object;
            object = this;
            object3 = object3.iterator();
            while (object3.hasNext()) {
                qp_0 qp_02 = (qp_0)object3.next();
                if (!((qp_0)object).a(qp_02)) continue;
                object2 = qp_02;
                break block2;
            }
            object2 = object = null;
        }
        if (object2 != null) {
            this.b = ((qp_0)object).d();
        }
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.b((qp_0)object);
    }
}

