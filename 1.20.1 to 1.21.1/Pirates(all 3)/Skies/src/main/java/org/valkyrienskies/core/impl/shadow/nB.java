/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cc_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.la_0;
import org.valkyrienskies.core.impl.shadow.nr_0;
import org.valkyrienskies.core.impl.shadow.nw_0;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pe_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.vk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class nB<T extends kO<T>>
implements nw_0<T> {
    private static final int a = 2;
    private final kM<T> b;
    private final int c;
    private final T d;
    private final T e;
    private final T f;
    private cc_0.a g;

    public nB(T t, T t2, T t3, int n2) {
        if (n2 < 2) {
            throw new pn_0(n2, (Number)2, true);
        }
        this.b = t.c();
        this.c = n2;
        this.e = t2;
        this.f = t;
        this.d = t3;
        this.g = cc_0.a.a();
    }

    private int f() {
        return this.c;
    }

    @Override
    public final int a() {
        cc_0.a a2 = this.g;
        return a2.b;
    }

    @Override
    public final int b() {
        cc_0.a a2 = this.g;
        return a2.e;
    }

    @Override
    public T c() {
        return this.e;
    }

    @Override
    public T d() {
        return this.f;
    }

    @Override
    public T e() {
        return this.d;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final kO a(int n2, vk_0.1 var2_2, kO kO2, kO kO3, int n3) {
        return this.a(n2, var2_2, kO2, kO3, (kO)kO2.a(kO3).d(2.0), n3);
    }

    @Override
    public final T a(int n2, la_0<T> la_02, T t, T t2, T object, int n3) {
        int n4;
        int n5;
        ci_0.a(la_02);
        this.g = this.g.b(n2).a(0);
        kO kO2 = (kO)this.b.a();
        kO kO3 = (kO)kO2.a(Double.NaN);
        kO[] kOArray = (kO[])ch_0.a(this.b, this.c + 1);
        kO[] kOArray2 = (kO[])ch_0.a(this.b, this.c + 1);
        kOArray[0] = t;
        kOArray[1] = object;
        kOArray[2] = t2;
        Object object2 = this.g;
        ((cc_0.a)object2).d(1);
        kOArray2[1] = la_02.a(kOArray[1]);
        if (cq_0.b(kOArray2[1].d(), 0.0, 1)) {
            return (T)kOArray[1];
        }
        object2 = this.g;
        ((cc_0.a)object2).d(1);
        kOArray2[0] = la_02.a(kOArray[0]);
        if (cq_0.b(kOArray2[0].d(), 0.0, 1)) {
            return (T)kOArray[0];
        }
        if (kOArray2[0].c(kOArray2[1]).d() < 0.0) {
            n5 = 2;
            n4 = 1;
        } else {
            object2 = this.g;
            ((cc_0.a)object2).d(1);
            kOArray2[2] = la_02.a(kOArray[2]);
            if (cq_0.b(kOArray2[2].d(), 0.0, 1)) {
                return (T)kOArray[2];
            }
            if (kOArray2[1].c(kOArray2[2]).d() < 0.0) {
                n5 = 3;
                n4 = 2;
            } else {
                throw new pe_0(kOArray[0].d(), kOArray[2].d(), kOArray2[0].d(), kOArray2[2].d());
            }
        }
        object = (kO[])ch_0.a(this.b, kOArray.length);
        kO kO4 = kOArray[n4 - 1];
        Object object3 = kOArray2[n4 - 1];
        kO kO5 = (kO)kO4.e();
        kO kO6 = (kO)object3.e();
        int n6 = 0;
        kO kO7 = kOArray[n4];
        Object object4 = kOArray2[n4];
        kO kO8 = (kO)kO7.e();
        kO kO9 = (kO)object4.e();
        int n7 = 0;
        while (true) {
            object2 = kO5.b(kO8).d() < 0.0 ? kO8 : kO5;
            kO kO10 = kO6.b(kO9).d() < 0.0 ? kO9 : kO6;
            object2 = (kO)this.e.a((Object)this.f.c((Object)object2));
            if (((kO)kO7.b(kO4).b(object2)).d() <= 0.0 || ((kO)kO10.b(this.d)).d() < 0.0) {
                switch (1.a[n3 - 1]) {
                    case 1: {
                        if (kO6.b(kO9).d() < 0.0) {
                            return (T)kO4;
                        }
                        return (T)kO7;
                    }
                    case 2: {
                        return (T)kO4;
                    }
                    case 3: {
                        return (T)kO7;
                    }
                    case 4: {
                        if (object3.d() <= 0.0) {
                            return (T)kO4;
                        }
                        return (T)kO7;
                    }
                    case 5: {
                        if (object3.d() < 0.0) {
                            return (T)kO7;
                        }
                        return (T)kO4;
                    }
                }
                throw new oY(null);
            }
            object2 = n6 >= 2 ? (kO)((kO)object4.d(16.0)).a() : (n7 >= 2 ? (kO)((kO)object3.d(16.0)).a() : kO2);
            int n8 = 0;
            int n9 = n5;
            do {
                kO kO11;
                System.arraycopy(kOArray, n8, object, n8, n9 - n8);
                kO10 = this.a((kO)object2, (kO[])object, kOArray2, n8, n9);
                if (kO11.b(kO4).d() > 0.0 && kO10.b(kO7).d() < 0.0) continue;
                if (n4 - n8 >= n9 - n4) {
                    ++n8;
                } else {
                    --n9;
                }
                kO10 = kO3;
            } while (Double.isNaN(kO10.d()) && n9 - n8 > 1);
            if (Double.isNaN(kO10.d())) {
                kO10 = (kO)kO4.a(kO7.b(kO4).d(2.0));
                n8 = n4 - 1;
                n9 = n4;
            }
            object2 = this.g;
            ((cc_0.a)object2).d(1);
            object2 = la_02.a(kO10);
            if (cq_0.b(object2.d(), 0.0, 1)) {
                return (T)kO10;
            }
            if (n5 > 2 && n9 - n8 != n5) {
                n5 = n9 - n8;
                System.arraycopy(kOArray, n8, kOArray, 0, n5);
                System.arraycopy(kOArray2, n8, kOArray2, 0, n5);
                n4 -= n8;
            } else if (n5 == kOArray.length) {
                --n5;
                if (n4 >= (kOArray.length + 1) / 2) {
                    System.arraycopy(kOArray, 1, kOArray, 0, n5);
                    System.arraycopy(kOArray2, 1, kOArray2, 0, n5);
                    --n4;
                }
            }
            System.arraycopy(kOArray, n4, kOArray, n4 + 1, n5 - n4);
            kOArray[n4] = kO10;
            System.arraycopy(kOArray2, n4, kOArray2, n4 + 1, n5 - n4);
            kOArray2[n4] = object2;
            ++n5;
            if (object2.c(object3).d() <= 0.0) {
                kO7 = kO10;
                object4 = object2;
                kO9 = (kO)object4.e();
                ++n6;
                n7 = 0;
                continue;
            }
            kO4 = kO10;
            object3 = object2;
            kO6 = (kO)object3.e();
            n6 = 0;
            ++n7;
            ++n4;
        }
    }

    private T a(T t, T[] TArray, T[] TArray2, int n2, int n3) {
        int n4;
        for (int i2 = n2; i2 < n3 - 1; ++i2) {
            n4 = i2 + 1 - n2;
            for (int i3 = n3 - 1; i3 > i2; --i3) {
                TArray[i3] = (kO)((kO)TArray[i3].b(TArray[i3 - 1])).d(TArray2[i3].b(TArray2[i3 - n4]));
            }
        }
        kO kO2 = (kO)this.b.a();
        for (n4 = n3 - 1; n4 >= n2; --n4) {
            kO2 = (kO)TArray[n4].a(kO2.c(t.b(TArray2[n4])));
        }
        return (T)kO2;
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[nr_0.values$267468cd().length];
            try {
                1.a[nr_0.ANY_SIDE$37d0779 - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nr_0.LEFT_SIDE$37d0779 - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nr_0.RIGHT_SIDE$37d0779 - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nr_0.BELOW_SIDE$37d0779 - 1] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[nr_0.ABOVE_SIDE$37d0779 - 1] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }
}

