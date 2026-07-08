/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.sa_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sb
 */
public interface sb_0<S extends qN> {
    public sb_0<S> e();

    public rV<S> c();

    public boolean b();

    public double a();

    @Deprecated
    public int b(rV<S> var1);

    public a<S> a(rV<S> var1);

    public sb_0<S> a(sb_0<S> var1);

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a<U extends qN> {
        public final sb_0<U> a;
        public final sb_0<U> b;

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        public a(rL rL2, rL rL3) {
            this.a = rL2;
            this.b = rL3;
        }

        public final sb_0<U> a() {
            return this.a;
        }

        public final sb_0<U> b() {
            return this.b;
        }

        public final int c() {
            if (this.a != null && !this.a.b()) {
                if (this.b != null && !this.b.b()) {
                    return sa_0.BOTH$7c70dd6b;
                }
                return sa_0.PLUS$7c70dd6b;
            }
            if (this.b != null && !this.b.b()) {
                return sa_0.MINUS$7c70dd6b;
            }
            return sa_0.HYPER$7c70dd6b;
        }
    }
}

