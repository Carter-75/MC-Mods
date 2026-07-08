/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.uF;
import org.valkyrienskies.core.impl.shadow.uM;
import org.valkyrienskies.core.impl.shadow.uR;
import org.valkyrienskies.core.impl.shadow.uV;
import org.valkyrienskies.core.impl.shadow.uW;
import org.valkyrienskies.core.impl.shadow.uX;
import org.valkyrienskies.core.impl.shadow.uZ;
import org.valkyrienskies.core.impl.shadow.vd_0;
import org.valkyrienskies.core.impl.shadow.ve_0;

public final class uQ {
    private uF h = null;
    private int i = -1;
    uR a;
    uZ b;
    int c;
    uV[] d;
    List<uW> e;
    int f;
    boolean g;
    private double[] j;

    private uQ(uM uM2, double[] dArray, String ... stringArray) {
        this(new b(uM2, dArray), stringArray);
    }

    private uQ(b b2, String ... stringArray) {
        this.a = b2;
        this.b = null;
        this.c = b2.a();
        if (stringArray == null) {
            this.d = null;
            this.f = 0;
        } else {
            this.d = new uV[stringArray.length];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.d[i2] = new uV(stringArray[i2], Double.NaN);
            }
            this.f = stringArray.length;
        }
        this.g = false;
        this.e = new ArrayList<uW>();
        this.j = new double[(this.c + this.f) * this.c];
        for (int i3 = 0; i3 < this.c; ++i3) {
            this.j[i3 * (this.c + 1)] = 1.0;
        }
    }

    private void a(uF object) {
        int n2;
        uM uM2;
        Object object2;
        if (this.a instanceof b) {
            object2 = (b)this.a;
            uM2 = ((b)object2).a;
        } else {
            uM2 = this.a;
        }
        Object object3 = uM2;
        object2 = object;
        if (((uF)object2).a != object3) {
            throw new c();
        }
        this.h = object;
        object = new a(this, 0);
        object2 = this.h;
        if (((uF)object2).e.isEmpty()) {
            ((uF)object2).e = new ArrayList<uF.a>();
            n2 = ((uF)object2).a.a();
        } else {
            Object object4 = object3 = ((uF)object2).e.get(((uF)object2).e.size() - 1);
            uE uE2 = ((uF.a)object3).b;
            object4 = uE2;
            object4 = object3;
            object4 = ((uF.a)object4).b;
            n2 = uE2.a + ((uE)object4).b;
        }
        ((uF)object2).e.add(new uF.a((vd_0)object, n2));
        this.i = ((uF)object2).e.size() - 1;
        this.h.a(this.i, this.j);
    }

    private void a(uW uW2) {
        this.e.add(uW2);
    }

    private void a(uZ uZ2) {
        this.b = uZ2;
        this.g = true;
    }

    private void a(String object, double d2) {
        uV[] uVArray = this.d;
        int n2 = this.d.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            uV uV2;
            uV uV3 = uV2 = uVArray[i2];
            if (!((String)object).equals(uV3.a)) continue;
            double d3 = d2;
            object = uV2;
            uV2.b = d3;
            this.g = true;
            return;
        }
        throw new ve_0((String)object);
    }

    private void a(double[][] dArray) {
        uQ.a(this.c, dArray);
        uQ.a(this.c, dArray[0]);
        int n2 = 0;
        for (double[] dArray2 : dArray) {
            System.arraycopy(dArray2, 0, this.j, n2, this.c);
            n2 += this.c;
        }
        if (this.h != null) {
            this.h.a(this.i, this.j);
        }
    }

    private void a(String string, double[] dArray) {
        uQ.a(this.c, dArray);
        int n2 = this.c * this.c;
        uV[] uVArray = this.d;
        int n3 = this.d.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            uV uV2 = uVArray[i2];
            if (string.equals(uV2.a)) {
                System.arraycopy(dArray, 0, this.j, n2, this.c);
                if (this.h != null) {
                    this.h.a(this.i, this.j);
                }
                return;
            }
            n2 += this.c;
        }
        throw new ve_0(string);
    }

    private void b(double[][] dArray) {
        double[] dArray2 = this.h.a(this.i);
        int n2 = 0;
        for (int i2 = 0; i2 < this.c; ++i2) {
            System.arraycopy(dArray2, n2, dArray[i2], 0, this.c);
            n2 += this.c;
        }
    }

    private void b(String string, double[] dArray) {
        double[] dArray2 = this.h.a(this.i);
        int n2 = this.c * this.c;
        uV[] uVArray = this.d;
        int n3 = this.d.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            uV uV2;
            uV uV3 = uVArray[i2];
            uV3 = uV3;
            if (uV2.a.equals(string)) {
                System.arraycopy(dArray2, n2, dArray, 0, this.c);
                return;
            }
            n2 += this.c;
        }
    }

    private static void a(int n2, Object object) {
        int n3 = object == null ? 0 : Array.getLength(object);
        if (n3 != n2) {
            throw new oS(n3, n2);
        }
    }

    static /* synthetic */ int a(uQ uQ2) {
        return uQ2.c;
    }

    static /* synthetic */ int b(uQ uQ2) {
        return uQ2.f;
    }

    static /* synthetic */ boolean c(uQ uQ2) {
        return uQ2.g;
    }

    static /* synthetic */ uR d(uQ uQ2) {
        return uQ2.a;
    }

    static /* synthetic */ uZ e(uQ uQ2) {
        return uQ2.b;
    }

    static /* synthetic */ uV[] f(uQ uQ2) {
        return uQ2.d;
    }

    static /* synthetic */ List g(uQ uQ2) {
        return uQ2.e;
    }

    static /* synthetic */ boolean a(uQ uQ2, boolean bl) {
        uQ2.g = false;
        return false;
    }

    static final class 1 {
    }

    public static final class c
    extends oV {
        private static final long b = 20120902L;

        public c() {
            super(px_0.UNMATCHED_ODE_IN_EXPANDED_SET, new Object[0]);
        }
    }

    static final class b
    implements uR {
        final uM a;
        private final double[] b;

        b(uM uM2, double[] dArray) {
            this.a = uM2;
            this.b = (double[])dArray.clone();
            if (dArray.length != uM2.a()) {
                throw new oS(uM2.a(), dArray.length);
            }
        }

        public final int a() {
            return this.a.a();
        }

        public final void a(double d2, double[] dArray, double[] dArray2) {
            this.a.a(d2, dArray, dArray2);
        }

        public final void a(double d2, double[] dArray, double[] dArray2, double[][] dArray3) {
            int n2 = this.a.a();
            double[] dArray4 = new double[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                double d3 = dArray[i2];
                int n3 = i2;
                dArray[n3] = dArray[n3] + this.b[i2];
                this.a.a(d2, dArray, dArray4);
                for (int i3 = 0; i3 < n2; ++i3) {
                    dArray3[i3][i2] = (dArray4[i3] - dArray2[i3]) / this.b[i2];
                }
                dArray[i2] = d3;
            }
        }

        static /* synthetic */ uM a(b b2) {
            return b2.a;
        }
    }

    final class a
    implements vd_0 {
        private /* synthetic */ uQ a;

        private a(uQ uQ2) {
            this.a = uQ2;
        }

        public final int a() {
            uQ uQ2 = this.a;
            uQ uQ3 = uQ2;
            uQ uQ4 = this.a;
            uQ3 = uQ4;
            uQ3 = this.a;
            return uQ2.c * (uQ4.c + uQ3.f);
        }

        public final void a(double d2, double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4) {
            int n2;
            int n3;
            Object object;
            Object object2 = this.a;
            if (((uQ)object2).g) {
                object = this.a;
                if (((uQ)object).f != 0) {
                    uQ uQ2 = this.a;
                    object = uQ2;
                    uQ uQ3 = this.a;
                    object = uQ3;
                    object2 = this.a;
                    object = this.a;
                    uQ2.e.add(new uX(uQ3.a, ((uQ)object2).b, ((uQ)object).d));
                    boolean bl = false;
                    object2 = this.a;
                    this.a.g = false;
                }
            }
            uQ uQ4 = this.a;
            object = uQ4;
            object = this.a;
            object2 = new double[uQ4.c][((uQ)object).c];
            object = this.a;
            ((uQ)object).a.a(d2, dArray, dArray2, (double[][])object2);
            int n4 = 0;
            while (true) {
                object = this.a;
                if (n4 >= ((uQ)object).c) break;
                Object object3 = object2[n4];
                int n5 = 0;
                while (true) {
                    int n6;
                    object = this.a;
                    if (n5 >= ((uQ)object).c) break;
                    double d3 = 0.0;
                    n3 = n6 = n5;
                    n2 = 0;
                    while (true) {
                        object = this.a;
                        if (n2 >= ((uQ)object).c) break;
                        d3 += object3[n2] * dArray3[n3];
                        object = this.a;
                        n3 += ((uQ)object).c;
                        ++n2;
                    }
                    object = this.a;
                    dArray4[n6 + n4 * ((uQ)object).c] = d3;
                    ++n5;
                }
                ++n4;
            }
            object = this.a;
            if (((uQ)object).f != 0) {
                object = this.a;
                double[] dArray5 = new double[((uQ)object).c];
                uQ uQ5 = this.a;
                object = uQ5;
                object = this.a;
                int n7 = uQ5.c * ((uQ)object).c;
                object = this.a;
                uV[] uVArray = ((uQ)object).d;
                int n8 = ((uQ)object).d.length;
                for (int i2 = 0; i2 < n8; ++i2) {
                    uV uV2 = uVArray[i2];
                    n3 = 0;
                    n2 = 0;
                    while (n3 == 0) {
                        object = this.a;
                        if (n2 >= ((uQ)object).e.size()) break;
                        object = this.a;
                        Object object4 = ((uQ)object).e.get(n2);
                        object = uV2;
                        if (object4.a(((uV)object).a)) {
                            object = uV2;
                            object4.a(d2, dArray, dArray2, ((uV)object).a, dArray5);
                            n3 = 0;
                            while (true) {
                                object = this.a;
                                if (n3 >= ((uQ)object).c) break;
                                object4 = object2[n3];
                                int n9 = n7;
                                double d4 = dArray5[n3];
                                int n10 = 0;
                                while (true) {
                                    object = this.a;
                                    if (n10 >= ((uQ)object).c) break;
                                    d4 += object4[n10] * dArray3[n9];
                                    ++n9;
                                    ++n10;
                                }
                                dArray4[n7 + n3] = d4;
                                ++n3;
                            }
                            n3 = 1;
                        }
                        ++n2;
                    }
                    if (n3 == 0) {
                        int n11 = n7;
                        object = this.a;
                        Arrays.fill(dArray4, n11, n11 + ((uQ)object).c, 0.0);
                    }
                    object = this.a;
                    n7 += ((uQ)object).c;
                }
            }
        }

        /* synthetic */ a(uQ uQ2, byte by) {
            this(uQ2);
        }
    }
}

