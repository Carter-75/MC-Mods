/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rM;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface rN<S extends qN> {
    public int a(rM<S> var1);

    public void b(rM<S> var1);

    public void c(rM<S> var1);

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a
    extends Enum<a> {
        public static final int PLUS_MINUS_SUB$672d2271 = 1;
        public static final int PLUS_SUB_MINUS$672d2271 = 2;
        public static final int MINUS_PLUS_SUB$672d2271 = 3;
        public static final int MINUS_SUB_PLUS$672d2271 = 4;
        public static final int SUB_PLUS_MINUS$672d2271 = 5;
        public static final int SUB_MINUS_PLUS$672d2271 = 6;
        private static final /* synthetic */ int[] $VALUES$6110850a;

        public static int[] values$5c9b7337() {
            return (int[])$VALUES$6110850a.clone();
        }

        private a() {
        }

        static {
            $VALUES$6110850a = new int[]{PLUS_MINUS_SUB$672d2271, PLUS_SUB_MINUS$672d2271, MINUS_PLUS_SUB$672d2271, MINUS_SUB_PLUS$672d2271, SUB_PLUS_MINUS$672d2271, SUB_MINUS_PLUS$672d2271};
        }
    }
}

