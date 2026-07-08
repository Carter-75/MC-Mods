/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vm
 */
enum vm_0 {
    UNINITIALIZED{

        protected final double a(double d2) {
            return 0.0;
        }
    }
    ,
    PLUS{

        protected final double a(double d2) {
            return d2;
        }
    }
    ,
    MINUS{

        protected final double a(double d2) {
            return -d2;
        }
    }
    ,
    MIN{

        protected final double a(double d2) {
            return BY.d(-cq_0.b, BY.d(-d2, d2));
        }
    }
    ,
    MAX{

        protected final double a(double d2) {
            return BY.e(cq_0.b, BY.e(-d2, d2));
        }
    };


    private vm_0() {
    }

    protected abstract double a(double var1);

    /* synthetic */ vm_0(String string, int n2, byte by) {
        this();
    }
}

