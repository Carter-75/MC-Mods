/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.vh
 */
public interface vh_0 {
    public void a(double var1, double[] var3, double var4);

    public double a(double var1, double[] var3);

    public int b(double var1, double[] var3);

    public void c(double var1, double[] var3);

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a
    extends Enum<a> {
        public static final int STOP$534a8113 = 1;
        public static final int RESET_STATE$534a8113 = 2;
        public static final int RESET_DERIVATIVES$534a8113 = 3;
        public static final int CONTINUE$534a8113 = 4;
        private static final /* synthetic */ int[] $VALUES$6b91b918;

        public static int[] values$9474ad9() {
            return (int[])$VALUES$6b91b918.clone();
        }

        private a() {
        }

        static {
            $VALUES$6b91b918 = new int[]{STOP$534a8113, RESET_STATE$534a8113, RESET_DERIVATIVES$534a8113, CONTINUE$534a8113};
        }
    }
}

