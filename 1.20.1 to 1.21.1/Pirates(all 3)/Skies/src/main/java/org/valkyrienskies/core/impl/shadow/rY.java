/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rQ;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface rY<S extends qN> {
    public rY<S> b(rM<S> var1);

    public rY<S> i();

    public boolean d();

    public boolean c(rM<S> var1);

    public boolean e();

    public boolean d(rM<S> var1);

    public boolean a(rY<S> var1);

    public int b(qM<S> var1);

    public rQ<S> a(qM<S> var1);

    public rM<S> a(boolean var1);

    public double f();

    public double g();

    public qM<S> h();

    @Deprecated
    public int a(rV<S> var1);

    public sb_0<S> a(sb_0<S> var1);

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a
    extends Enum<a> {
        public static final int INSIDE$3ad793e5 = 1;
        public static final int OUTSIDE$3ad793e5 = 2;
        public static final int BOUNDARY$3ad793e5 = 3;
        private static final /* synthetic */ int[] $VALUES$2218c3c0;

        public static int[] values$35bf5f5f() {
            return (int[])$VALUES$2218c3c0.clone();
        }

        private a() {
        }

        static {
            $VALUES$2218c3c0 = new int[]{INSIDE$3ad793e5, OUTSIDE$3ad793e5, BOUNDARY$3ad793e5};
        }
    }
}

