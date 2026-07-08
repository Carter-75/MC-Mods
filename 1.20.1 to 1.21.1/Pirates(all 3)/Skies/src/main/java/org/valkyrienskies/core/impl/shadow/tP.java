/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.tJ;
import org.valkyrienskies.core.impl.shadow.tL;
import org.valkyrienskies.core.impl.shadow.tM;
import org.valkyrienskies.core.impl.shadow.tO;
import org.valkyrienskies.core.impl.shadow.tW;
import org.valkyrienskies.core.impl.shadow.tY;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zy_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class tP<T extends tL>
extends tM<T> {
    private static final double a = 0.001;
    private final int b;
    private final int c;
    private final double d;
    private final double e;
    private final zF f;
    private double[][] g;
    private List<T> h;
    private List<tJ<T>> i;

    private tP(int n2, double d2) {
        this(n2, d2, -1, new tY());
    }

    private tP(int n2, double d2, int n3, tY tY2) {
        this(n2, d2, -1, tY2, 0.001, new zy_0());
    }

    private tP(int n2, double d2, int n3, tW tW2, double d3, zy_0 zy_02) {
        super(tW2);
        if (d2 <= 1.0) {
            throw new pn_0(d2, (Number)1.0, false);
        }
        this.b = n2;
        this.d = d2;
        this.c = n3;
        this.e = 0.001;
        this.f = zy_02;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    private int b() {
        return this.b;
    }

    private double c() {
        return this.d;
    }

    private int d() {
        return this.c;
    }

    private double e() {
        return this.e;
    }

    private zF f() {
        return this.f;
    }

    private tq_0 g() {
        if (this.g == null) {
            throw new oX();
        }
        return td_0.a(this.g);
    }

    private List<T> h() {
        return this.h;
    }

    private List<tJ<T>> i() {
        return this.i;
    }

    private double j() {
        if (this.h == null || this.i == null) {
            throw new oX();
        }
        int n2 = 0;
        double d2 = 0.0;
        for (tL tL2 : this.h) {
            int n3 = 0;
            for (tJ<T> tJ2 : this.i) {
                double d3;
                double d4 = d3 = this.a(tL2, tJ2.a);
                d2 += d4 * d4 * BY.a(this.g[n2][n3], this.d);
                ++n3;
            }
            ++n2;
        }
        return d2;
    }

    @Override
    public final List<tJ<T>> a(Collection<T> object) {
        double d2;
        int n2;
        ci_0.a(object);
        int n3 = object.size();
        if (n3 < this.b) {
            throw new pn_0(n3, (Number)this.b, false);
        }
        this.h = Collections.unmodifiableList(new ArrayList<T>(object));
        this.i = new ArrayList<tJ<T>>();
        this.g = new double[n3][this.b];
        object = new double[n3][this.b];
        if (n3 == 0) {
            return this.i;
        }
        tP tP2 = this;
        for (int i2 = 0; i2 < tP2.h.size(); ++i2) {
            for (int i3 = 0; i3 < tP2.b; ++i3) {
                tP2.g[i2][i3] = tP2.f.nextDouble();
            }
            tP2.g[i2] = ch_0.a(tP2.g[i2], 1.0);
        }
        n3 = ((tL)this.h.get(0)).a().length;
        for (n2 = 0; n2 < this.b; ++n2) {
            this.i.add(new tJ(new tO(new double[n3])));
        }
        n2 = 0;
        n3 = this.c < 0 ? Integer.MAX_VALUE : this.c;
        do {
            int n4;
            tJ<T> tJ2;
            Object object2 = object;
            tP2 = this;
            for (int i4 = 0; i4 < tP2.h.size(); ++i4) {
                System.arraycopy(tP2.g[i4], 0, object2[i4], 0, tP2.i.size());
            }
            tP2 = this;
            int n5 = 0;
            Object object3 = new ArrayList<tJ<T>>(tP2.b);
            Iterator<tJ<T>> iterator2 = tP2.i.iterator();
            while (iterator2.hasNext()) {
                tJ<T> tJ3;
                tJ2 = tJ3 = iterator2.next();
                tL tL2 = tJ3.a;
                n4 = 0;
                double[] dArray = new double[tL2.a().length];
                double d3 = 0.0;
                for (tL tL3 : tP2.h) {
                    double d4 = BY.a(tP2.g[n4][n5], tP2.d);
                    double[] dArray2 = tL3.a();
                    for (int i5 = 0; i5 < dArray.length; ++i5) {
                        int n6 = i5;
                        dArray[n6] = dArray[n6] + d4 * dArray2[i5];
                    }
                    d3 += d4;
                    ++n4;
                }
                ch_0.a(1.0 / d3, dArray);
                object3.add(new tJ(new tO(dArray)));
                ++n5;
            }
            tP2.i.clear();
            tP2.i = object3;
            tP2 = this;
            for (n5 = 0; n5 < tP2.h.size(); ++n5) {
                object3 = (tL)tP2.h.get(n5);
                double d5 = Double.MIN_VALUE;
                int n7 = -1;
                for (n4 = 0; n4 < tP2.i.size(); ++n4) {
                    double d6 = 0.0;
                    tJ2 = tP2.i.get(n4);
                    double d7 = BY.w(tP2.a((tL)object3, tJ2.a));
                    if (d7 != 0.0) {
                        Iterator<tJ<T>> iterator3 = tP2.i.iterator();
                        while (iterator3.hasNext()) {
                            tJ<T> tJ4;
                            tJ2 = tJ4 = iterator3.next();
                            double d8 = BY.w(tP2.a((tL)object3, tJ2.a));
                            if (d8 == 0.0) {
                                d6 = Double.POSITIVE_INFINITY;
                                break;
                            }
                            d6 += BY.a(d7 / d8, 2.0 / (tP2.d - 1.0));
                        }
                    }
                    double d9 = d6 == 0.0 ? 1.0 : (d6 == Double.POSITIVE_INFINITY ? 0.0 : 1.0 / d6);
                    tP2.g[n5][n4] = d9;
                    if (!(tP2.g[n5][n4] > d5)) continue;
                    d5 = tP2.g[n5][n4];
                    n7 = n4;
                }
                tP2.i.get(n7).a(object3);
            }
            Object object4 = object;
            tP2 = this;
            double d10 = 0.0;
            for (int i6 = 0; i6 < tP2.h.size(); ++i6) {
                for (int i7 = 0; i7 < tP2.i.size(); ++i7) {
                    double d11 = BY.w(tP2.g[i6][i7] - object4[i6][i7]);
                    d10 = BY.e(d11, d10);
                }
            }
            double d12 = d10;
        } while (d2 > this.e && ++n2 < n3);
        return this.i;
    }

    private void k() {
        int n2 = 0;
        ArrayList<tJ<T>> arrayList = new ArrayList<tJ<T>>(this.b);
        for (tJ<T> tJ2 : this.i) {
            Object object = tJ2;
            object = tJ2;
            object = tJ2.a;
            int n3 = 0;
            object = new double[object.a().length];
            double d2 = 0.0;
            for (Object object2 : this.h) {
                double d3 = BY.a(this.g[n3][n2], this.d);
                object2 = object2.a();
                for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
                    Object object3 = object;
                    int n4 = i2;
                    object3[n4] = object3[n4] + d3 * object2[i2];
                }
                d2 += d3;
                ++n3;
            }
            ch_0.a(1.0 / d2, (double[])object);
            arrayList.add(new tJ(new tO((double[])object)));
            ++n2;
        }
        this.i.clear();
        this.i = arrayList;
    }

    private void l() {
        for (int i2 = 0; i2 < this.h.size(); ++i2) {
            tL tL2 = (tL)this.h.get(i2);
            double d2 = Double.MIN_VALUE;
            int n2 = -1;
            for (int i3 = 0; i3 < this.i.size(); ++i3) {
                double d3 = 0.0;
                tJ<T> tJ22 = this.i.get(i3);
                double d4 = BY.w(this.a(tL2, tJ22.a));
                if (d4 != 0.0) {
                    for (tJ<T> tJ22 : this.i) {
                        double d5 = BY.w(this.a(tL2, tJ22.a));
                        if (d5 == 0.0) {
                            d3 = Double.POSITIVE_INFINITY;
                            break;
                        }
                        d3 += BY.a(d4 / d5, 2.0 / (this.d - 1.0));
                    }
                }
                double d6 = d3 == 0.0 ? 1.0 : (d3 == Double.POSITIVE_INFINITY ? 0.0 : 1.0 / d3);
                this.g[i2][i3] = d6;
                if (!(this.g[i2][i3] > d2)) continue;
                d2 = this.g[i2][i3];
                n2 = i3;
            }
            this.i.get(n2).a(tL2);
        }
    }

    private void m() {
        for (int i2 = 0; i2 < this.h.size(); ++i2) {
            for (int i3 = 0; i3 < this.b; ++i3) {
                this.g[i2][i3] = this.f.nextDouble();
            }
            this.g[i2] = ch_0.a(this.g[i2], 1.0);
        }
    }

    private double a(double[][] dArray) {
        double d2 = 0.0;
        for (int i2 = 0; i2 < this.h.size(); ++i2) {
            for (int i3 = 0; i3 < this.i.size(); ++i3) {
                double d3 = BY.w(this.g[i2][i3] - dArray[i2][i3]);
                d2 = BY.e(d3, d2);
            }
        }
        return d2;
    }

    private void b(double[][] dArray) {
        for (int i2 = 0; i2 < this.h.size(); ++i2) {
            System.arraycopy(this.g[i2], 0, dArray[i2], 0, this.i.size());
        }
    }
}

