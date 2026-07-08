/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.valkyrienskies.core.impl.shadow.BD;
import org.valkyrienskies.core.impl.shadow.BK;
import org.valkyrienskies.core.impl.shadow.BL;
import org.valkyrienskies.core.impl.shadow.BM;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nQ;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.px_0;

public class BG
implements Serializable {
    private static long a = 20120210L;
    private static final double[] b = new double[]{1.0, -1.0, 6.123233995736766E-17, 0.7071067811865476, 0.9238795325112867, 0.9807852804032304, 0.9951847266721969, 0.9987954562051724, 0.9996988186962042, 0.9999247018391445, 0.9999811752826011, 0.9999952938095762, 0.9999988234517019, 0.9999997058628822, 0.9999999264657179, 0.9999999816164293, 0.9999999954041073, 0.9999999988510269, 0.9999999997127567, 0.9999999999281892, 0.9999999999820472, 0.9999999999955118, 0.999999999998878, 0.9999999999997194, 0.9999999999999298, 0.9999999999999825, 0.9999999999999957, 0.9999999999999989, 0.9999999999999998, 0.9999999999999999, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
    private static final double[] c = new double[]{2.4492935982947064E-16, -1.2246467991473532E-16, -1.0, -0.7071067811865475, -0.3826834323650898, -0.19509032201612825, -0.0980171403295606, -0.049067674327418015, -0.024541228522912288, -0.012271538285719925, -0.006135884649154475, -0.003067956762965976, -0.0015339801862847655, -7.669903187427045E-4, -3.8349518757139556E-4, -1.917475973107033E-4, -9.587379909597734E-5, -4.793689960306688E-5, -2.396844980841822E-5, -1.1984224905069705E-5, -5.9921124526424275E-6, -2.996056226334661E-6, -1.4980281131690111E-6, -7.490140565847157E-7, -3.7450702829238413E-7, -1.8725351414619535E-7, -9.362675707309808E-8, -4.681337853654909E-8, -2.340668926827455E-8, -1.1703344634137277E-8, -5.8516723170686385E-9, -2.9258361585343192E-9, -1.4629180792671596E-9, -7.314590396335798E-10, -3.657295198167899E-10, -1.8286475990839495E-10, -9.143237995419748E-11, -4.571618997709874E-11, -2.285809498854937E-11, -1.1429047494274685E-11, -5.714523747137342E-12, -2.857261873568671E-12, -1.4286309367843356E-12, -7.143154683921678E-13, -3.571577341960839E-13, -1.7857886709804195E-13, -8.928943354902097E-14, -4.4644716774510487E-14, -2.2322358387255243E-14, -1.1161179193627622E-14, -5.580589596813811E-15, -2.7902947984069054E-15, -1.3951473992034527E-15, -6.975736996017264E-16, -3.487868498008632E-16, -1.743934249004316E-16, -8.71967124502158E-17, -4.35983562251079E-17, -2.179917811255395E-17, -1.0899589056276974E-17, -5.449794528138487E-18, -2.7248972640692436E-18, -1.3624486320346218E-18};
    private final int d;

    public BG(int n2) {
        this.d = n2;
    }

    private static void a(double[] dArray, double[] dArray2) {
        int n2 = dArray.length;
        assert (dArray2.length == n2);
        int n3 = n2 >> 1;
        int n4 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5;
            if (i2 < n4) {
                double d2 = dArray[i2];
                dArray[i2] = dArray[n4];
                dArray[n4] = d2;
                d2 = dArray2[i2];
                dArray2[i2] = dArray2[n4];
                dArray2[n4] = d2;
            }
            for (n5 = n3; n5 <= n4 && n5 > 0; n4 -= n5, n5 >>= 1) {
            }
            n4 += n5;
        }
    }

    private static void a(double[][] object, int n2, int n3) {
        double[] dArray = object[0];
        object = object[1];
        int n4 = dArray.length;
        assert (((double[][])object).length == n4);
        switch (1.a[n2 - 1]) {
            case 1: {
                if (n3 != BK.INVERSE$4b20d4ed) break;
                double d2 = 1.0 / (double)n4;
                n2 = 0;
                while (n2 < n4) {
                    int n5 = n2;
                    dArray[n5] = dArray[n5] * d2;
                    int n6 = n2++;
                    object[n6] = object[n6] * d2;
                }
                return;
            }
            case 2: {
                double d3 = 1.0 / BY.a((double)n4);
                n2 = 0;
                while (n2 < n4) {
                    int n7 = n2;
                    dArray[n7] = dArray[n7] * d3;
                    int n8 = n2++;
                    object[n8] = object[n8] * d3;
                }
                return;
            }
            default: {
                throw new oX();
            }
        }
    }

    private static void b(double[][] dArray, int n2, int n3) {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        int n4;
        if (dArray.length != 2) {
            throw new oS(dArray.length, 2);
        }
        double[] dArray2 = dArray[0];
        double[] dArray3 = dArray[1];
        if (dArray2.length != dArray3.length) {
            throw new oS(dArray3.length, dArray2.length);
        }
        int n5 = dArray2.length;
        if (!BM.a((long)n5)) {
            throw new oV(px_0.NOT_POWER_OF_TWO_CONSIDER_PADDING, n5);
        }
        if (n5 == 1) {
            return;
        }
        if (n5 == 2) {
            double d9 = dArray2[0];
            double d10 = dArray3[0];
            double d11 = dArray2[1];
            double d12 = dArray3[1];
            dArray2[0] = d9 + d11;
            dArray3[0] = d10 + d12;
            dArray2[1] = d9 - d11;
            dArray3[1] = d10 - d12;
            BG.a(dArray, n2, n3);
            return;
        }
        double[] dArray4 = dArray3;
        double[] dArray5 = dArray2;
        int n6 = dArray2.length;
        assert (dArray4.length == n6);
        int n7 = n6 >> 1;
        int n8 = 0;
        for (int i2 = 0; i2 < n6; ++i2) {
            int n9;
            if (i2 < n8) {
                double d13 = dArray5[i2];
                dArray5[i2] = dArray5[n8];
                dArray5[n8] = d13;
                d13 = dArray4[i2];
                dArray4[i2] = dArray4[n8];
                dArray4[n8] = d13;
            }
            for (n9 = n7; n9 <= n8 && n9 > 0; n8 -= n9, n9 >>= 1) {
            }
            n8 += n9;
        }
        if (n3 == BK.INVERSE$4b20d4ed) {
            for (n4 = 0; n4 < n5; n4 += 4) {
                int n10 = n4 + 1;
                n6 = n4 + 2;
                n7 = n4 + 3;
                double d14 = dArray2[n4];
                d8 = dArray3[n4];
                d7 = dArray2[n6];
                d6 = dArray3[n6];
                d5 = dArray2[n10];
                d4 = dArray3[n10];
                d3 = dArray2[n7];
                d2 = dArray3[n7];
                dArray2[n4] = d14 + d7 + d5 + d3;
                dArray3[n4] = d8 + d6 + d4 + d2;
                dArray2[n10] = d14 - d5 + (d2 - d6);
                dArray3[n10] = d8 - d4 + (d7 - d3);
                dArray2[n6] = d14 - d7 + d5 - d3;
                dArray3[n6] = d8 - d6 + d4 - d2;
                dArray2[n7] = d14 - d5 + (d6 - d2);
                dArray3[n7] = d8 - d4 + (d3 - d7);
            }
        } else {
            for (n4 = 0; n4 < n5; n4 += 4) {
                int n11 = n4 + 1;
                n6 = n4 + 2;
                n7 = n4 + 3;
                double d15 = dArray2[n4];
                d8 = dArray3[n4];
                d7 = dArray2[n6];
                d6 = dArray3[n6];
                d5 = dArray2[n11];
                d4 = dArray3[n11];
                d3 = dArray2[n7];
                d2 = dArray3[n7];
                dArray2[n4] = d15 + d7 + d5 + d3;
                dArray3[n4] = d8 + d6 + d4 + d2;
                dArray2[n11] = d15 - d5 + (d6 - d2);
                dArray3[n11] = d8 - d4 + (d3 - d7);
                dArray2[n6] = d15 - d7 + d5 - d3;
                dArray3[n6] = d8 - d6 + d4 - d2;
                dArray2[n7] = d15 - d5 + (d2 - d6);
                dArray3[n7] = d8 - d4 + (d7 - d3);
            }
        }
        n4 = 4;
        int n12 = 2;
        while (n4 < n5) {
            n6 = n4 << 1;
            n7 = n12 + 1;
            double d16 = b[n7];
            d8 = c[n7];
            if (n3 == BK.INVERSE$4b20d4ed) {
                d8 = -d8;
            }
            for (int i3 = 0; i3 < n5; i3 += n6) {
                int n13 = i3 + n4;
                d6 = 1.0;
                d5 = 0.0;
                for (int i4 = 0; i4 < n4; ++i4) {
                    double d17 = dArray2[i3 + i4];
                    double d18 = dArray3[i3 + i4];
                    double d19 = dArray2[n13 + i4];
                    double d20 = dArray3[n13 + i4];
                    dArray2[i3 + i4] = d17 + d6 * d19 - d5 * d20;
                    dArray3[i3 + i4] = d18 + d6 * d20 + d5 * d19;
                    dArray2[n13 + i4] = d17 - (d6 * d19 - d5 * d20);
                    dArray3[n13 + i4] = d18 - (d6 * d20 + d5 * d19);
                    double d21 = d6 * d16 - d5 * d8;
                    double d22 = d6 * d8 + d5 * d16;
                    d6 = d21;
                    d5 = d22;
                }
            }
            n4 = n6;
            n12 = n7;
        }
        BG.a(dArray, n2, n3);
    }

    public final nQ[] a(double[] object, int n2) {
        double[][] dArrayArray = new double[][]{ch_0.a(object, ((double[])object).length), new double[((double[])object).length]};
        object = dArrayArray;
        BG.b(dArrayArray, this.d, n2);
        return BL.a((double[][])object);
    }

    private nQ[] a(lc_0 object, double d2, double d3, int n2, int n3) {
        object = kV.a((lc_0)object, d2, d3, n2);
        return this.a((double[])object, n3);
    }

    private nQ[] a(nQ[] object, int n2) {
        double[][] dArray = BL.a(object);
        object = dArray;
        BG.b(dArray, this.d, n2);
        return BL.a((double[][])object);
    }

    @Deprecated
    private Object a(Object object, int n2) {
        object = (a)new a(object).clone();
        int[] nArray = ((a)object).a();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.a((a)object, n2, i2, new int[0]);
        }
        return ((a)object).b();
    }

    @Deprecated
    private void a(a a2, int n2, int n3, int[] nArray) {
        int[] nArray2 = a2.a();
        if (nArray.length == nArray2.length) {
            int n4;
            nQ[] nQArray = new nQ[nArray2[n3]];
            for (n4 = 0; n4 < nArray2[n3]; ++n4) {
                nArray[n3] = n4;
                nQArray[n4] = a2.a(nArray);
            }
            nQArray = this.a(nQArray, n2);
            for (n4 = 0; n4 < nArray2[n3]; ++n4) {
                nArray[n3] = n4;
                a2.a(nQArray[n4], nArray);
            }
            return;
        }
        int[] nArray3 = new int[nArray.length + 1];
        System.arraycopy(nArray, 0, nArray3, 0, nArray.length);
        if (nArray.length == n3) {
            nArray3[n3] = 0;
            this.a(a2, n2, n3, nArray3);
            return;
        }
        int n5 = 0;
        while (n5 < nArray2[nArray.length]) {
            nArray3[nArray.length] = n5++;
            this.a(a2, n2, n3, nArray3);
        }
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[BD.values$86c13e2().length];
            try {
                1.a[BD.STANDARD$1f30b0a8 - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[BD.UNITARY$1f30b0a8 - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    @Deprecated
    static final class a
    implements Cloneable {
        private int[] a;
        private Object b;

        a(Object objectArray) {
            this.b = objectArray;
            int n2 = 0;
            Object object = objectArray;
            while (object instanceof Object[]) {
                object = object;
                ++n2;
                object = object[0];
            }
            this.a = new int[n2];
            n2 = 0;
            object = objectArray;
            while (object instanceof Object[]) {
                this.a[n2++] = ((Object[])object).length;
                object = object[0];
            }
        }

        public final nQ a(int ... nArray) {
            if (nArray == null) {
                if (this.a.length > 0) {
                    throw new oS(0, this.a.length);
                }
                return null;
            }
            if (nArray.length != this.a.length) {
                throw new oS(nArray.length, this.a.length);
            }
            Object object = this.b;
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                object = ((Object[])object)[nArray[i2]];
            }
            return (nQ)object;
        }

        public final nQ a(nQ nQ2, int ... nArray) {
            if (nArray == null) {
                if (this.a.length > 0) {
                    throw new oS(0, this.a.length);
                }
                return null;
            }
            if (nArray.length != this.a.length) {
                throw new oS(nArray.length, this.a.length);
            }
            Object[] objectArray = (Object[])this.b;
            for (int i2 = 0; i2 < this.a.length - 1; ++i2) {
                objectArray = (Object[])objectArray[nArray[i2]];
            }
            nQ nQ3 = (nQ)objectArray[nArray[this.a.length - 1]];
            objectArray[nArray[this.a.length - 1]] = nQ2;
            return nQ3;
        }

        public final int[] a() {
            return (int[])this.a.clone();
        }

        public final Object b() {
            return this.b;
        }

        public final Object clone() {
            int n2;
            int[][] nArray;
            a a2;
            a a3 = a2 = new a(Array.newInstance(nQ.class, this.a));
            a a4 = this;
            int[] nArray2 = new int[a4.a.length];
            int n3 = 1;
            for (int i2 = 0; i2 < a4.a.length; ++i2) {
                n3 *= a4.a[i2];
            }
            int[][] nArray3 = nArray = new int[n3][a4.a.length];
            int n4 = nArray.length;
            block1: for (n2 = 0; n2 < n4; ++n2) {
                int[] nArray4 = nArray3[n2];
                System.arraycopy(nArray2, 0, nArray4, 0, a4.a.length);
                for (int i3 = 0; i3 < a4.a.length; ++i3) {
                    int n5 = i3;
                    nArray2[n5] = nArray2[n5] + 1;
                    if (nArray2[i3] < a4.a[i3]) continue block1;
                    nArray2[i3] = 0;
                }
            }
            nArray3 = nArray;
            n4 = nArray.length;
            for (n2 = 0; n2 < n4; ++n2) {
                int[] nArray5 = nArray3[n2];
                a3.a(a4.a(nArray5), nArray5);
            }
            return a2;
        }

        private void a(a a2) {
            int n2;
            int[][] nArray;
            int[] nArray2 = new int[this.a.length];
            int n3 = 1;
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                n3 *= this.a[i2];
            }
            int[][] nArray3 = nArray = new int[n3][this.a.length];
            int n4 = nArray.length;
            block1: for (n2 = 0; n2 < n4; ++n2) {
                int[] nArray4 = nArray3[n2];
                System.arraycopy(nArray2, 0, nArray4, 0, this.a.length);
                for (int i3 = 0; i3 < this.a.length; ++i3) {
                    int n5 = i3;
                    nArray2[n5] = nArray2[n5] + 1;
                    if (nArray2[i3] < this.a[i3]) continue block1;
                    nArray2[i3] = 0;
                }
            }
            nArray3 = nArray;
            n4 = nArray.length;
            for (n2 = 0; n2 < n4; ++n2) {
                int[] nArray5 = nArray3[n2];
                a2.a(this.a(nArray5), nArray5);
            }
        }
    }
}

