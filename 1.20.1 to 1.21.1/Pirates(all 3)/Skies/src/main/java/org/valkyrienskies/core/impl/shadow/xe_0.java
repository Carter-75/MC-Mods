/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.wZ;
import org.valkyrienskies.core.impl.shadow.xa_0;
import org.valkyrienskies.core.impl.shadow.xc_0;
import org.valkyrienskies.core.impl.shadow.xf_0;
import org.valkyrienskies.core.impl.shadow.xg_0;
import org.valkyrienskies.core.impl.shadow.xh_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.xe
 */
public final class xe_0
extends wZ {
    private static int b = 10;
    private static double c = 1.0E-10;
    private static final double d = 1.0E-6;
    private final double e;
    private final int f;
    private final double g;
    private xc_0 h;
    private xg_0 i;

    public xe_0() {
        this(1.0E-6, 10, 1.0E-10);
    }

    private xe_0(double d2) {
        this(d2, 10, 1.0E-10);
    }

    private xe_0(double d2, int n2) {
        this(d2, n2, 1.0E-10);
    }

    private xe_0(double d2, int n2, double d3) {
        this.e = d2;
        this.f = n2;
        this.g = 1.0E-10;
        this.h = xc_0.DANTZIG;
    }

    public final wQ c(wO ... wOArray) {
        return super.c(wOArray);
    }

    public final void b(wO ... wOArray) {
        super.b(wOArray);
        this.i = null;
        for (wO wO2 : wOArray) {
            if (wO2 instanceof xg_0) {
                this.i = (xg_0)wO2;
                continue;
            }
            if (!(wO2 instanceof xc_0)) continue;
            this.h = (xc_0)wO2;
        }
    }

    private Integer a(xf_0 xf_02) {
        double d2 = 0.0;
        Integer n2 = null;
        int n3 = xf_02.a();
        while (true) {
            double d3;
            xf_0 xf_03 = xf_02;
            if (n3 >= ((tp_0)xf_03.a).g() - 1) break;
            double d4 = xf_02.b(0, n3);
            if (d3 < d2) {
                d2 = d4;
                n2 = n3;
                if (this.h == xc_0.BLAND) {
                    boolean bl;
                    block5: {
                        int n4 = n3;
                        xf_0 xf_04 = xf_02;
                        xe_0 xe_02 = this;
                        int n5 = xf_04.a();
                        while (true) {
                            xf_03 = xf_04;
                            if (n5 >= ((tp_0)xf_03.a).f()) break;
                            double d5 = xf_04.b(n5, n4);
                            if (cq_0.a(d5, 0.0, xe_02.g) > 0) {
                                bl = true;
                                break block5;
                            }
                            ++n5;
                        }
                        bl = false;
                    }
                    if (bl) break;
                }
            }
            ++n3;
        }
        return n2;
    }

    private boolean a(xf_0 xf_02, int n2) {
        int n3 = xf_02.a();
        while (true) {
            xf_0 xf_03 = xf_02;
            if (n3 >= ((tp_0)xf_03.a).f()) break;
            double d2 = xf_02.b(n3, n2);
            if (cq_0.a(d2, 0.0, this.g) > 0) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    private Integer b(xf_0 xf_02, int n2) {
        xf_0 xf_03;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        double d2 = Double.MAX_VALUE;
        int n3 = xf_02.a();
        while (true) {
            xf_03 = xf_02;
            if (n3 >= ((tp_0)xf_03.a).f()) break;
            xf_03 = xf_02;
            double d3 = xf_02.b(n3, ((tp_0)xf_03.a).g() - 1);
            double d4 = xf_02.b(n3, n2);
            if (cq_0.a(d4, 0.0, this.g) > 0) {
                double d5 = BY.w(d3 / d4);
                int n4 = Double.compare(d5, d2);
                if (n4 == 0) {
                    arrayList.add(n3);
                } else if (n4 < 0) {
                    d2 = d5;
                    arrayList.clear();
                    arrayList.add(n3);
                }
            }
            ++n3;
        }
        if (arrayList.size() == 0) {
            return null;
        }
        if (arrayList.size() > 1) {
            xf_03 = xf_02;
            if (xf_03.b > 0) {
                block1: for (Integer n5 : arrayList) {
                    int n6 = 0;
                    while (true) {
                        xf_03 = xf_02;
                        if (n6 >= xf_03.b) continue block1;
                        int n7 = n6 + xf_02.g();
                        double d6 = xf_02.b(n5, n7);
                        if (cq_0.b(d6, 1.0, this.f) && n5.equals(xf_02.a(n7))) {
                            return n5;
                        }
                        ++n6;
                    }
                }
            }
            Integer n8 = null;
            xf_03 = xf_02;
            int n9 = ((tp_0)xf_03.a).g();
            for (Integer n10 : arrayList) {
                n2 = n10;
                xf_03 = xf_02;
                int n11 = xf_03.c[n2];
                if (n11 >= n9) continue;
                n9 = n11;
                n8 = n10;
            }
            return n8;
        }
        return (Integer)arrayList.get(0);
    }

    private void b(xf_0 xf_02) {
        Object object;
        Integer n2;
        xe_0 xe_02;
        block21: {
            int n3;
            xf_0 xf_03;
            this.l();
            xf_0 xf_04 = xf_02;
            xe_02 = this;
            double d2 = 0.0;
            Integer n4 = null;
            int n5 = xf_04.a();
            while (true) {
                double d3;
                xf_03 = xf_04;
                if (n5 >= ((tp_0)xf_03.a).g() - 1) break;
                double d4 = xf_04.b(0, n5);
                if (d3 < d2) {
                    d2 = d4;
                    n4 = n5;
                    if (xe_02.h == xc_0.BLAND) {
                        boolean bl;
                        block20: {
                            n3 = n5;
                            xf_0 serializable2 = xf_04;
                            xe_0 xe_03 = xe_02;
                            int n6 = serializable2.a();
                            while (true) {
                                xf_03 = serializable2;
                                if (n6 >= ((tp_0)xf_03.a).f()) break;
                                double d5 = serializable2.b(n6, n3);
                                if (cq_0.a(d5, 0.0, xe_03.g) > 0) {
                                    bl = true;
                                    break block20;
                                }
                                ++n6;
                            }
                            bl = false;
                        }
                        if (bl) break;
                    }
                }
                ++n5;
            }
            n2 = n4;
            int n7 = n2;
            xf_04 = xf_02;
            xe_02 = this;
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            double d6 = Double.MAX_VALUE;
            int n8 = xf_04.a();
            while (true) {
                xf_03 = xf_04;
                if (n8 >= ((tp_0)xf_03.a).f()) break;
                xf_03 = xf_04;
                double n13 = xf_04.b(n8, ((tp_0)xf_03.a).g() - 1);
                double d8 = xf_04.b(n8, n7);
                if (cq_0.a(d8, 0.0, xe_02.g) > 0) {
                    double d7 = BY.w(n13 / d8);
                    int n9 = Double.compare(d7, d6);
                    if (n9 == 0) {
                        arrayList.add(n8);
                    } else if (n9 < 0) {
                        d6 = d7;
                        arrayList.clear();
                        arrayList.add(n8);
                    }
                }
                ++n8;
            }
            if (arrayList.size() == 0) {
                object = null;
            } else if (arrayList.size() > 1) {
                xf_03 = xf_04;
                if (xf_03.b > 0) {
                    block3: for (Integer n10 : arrayList) {
                        int n11 = 0;
                        while (true) {
                            xf_03 = xf_04;
                            if (n11 >= xf_03.b) continue block3;
                            int n12 = n11 + xf_04.g();
                            double d8 = xf_04.b(n10, n12);
                            if (cq_0.b(d8, 1.0, xe_02.f) && n10.equals(xf_04.a(n12))) {
                                object = n10;
                                break block21;
                            }
                            ++n11;
                        }
                    }
                }
                Integer serializable = null;
                xf_03 = xf_04;
                int n11 = ((tp_0)xf_03.a).g();
                for (Integer n12 : arrayList) {
                    int n14 = n12;
                    xf_03 = xf_04;
                    n3 = xf_03.c[n14];
                    if (n3 >= n11) continue;
                    n11 = n3;
                    serializable = n12;
                }
                object = serializable;
            } else {
                object = xe_02 = (Integer)arrayList.get(0);
            }
        }
        if (object == null) {
            throw new xh_0();
        }
        xf_02.a((int)n2, (Integer)((Object)xe_02));
    }

    private void c(xf_0 xf_02) {
        xf_0 xf_03 = xf_02;
        if (xf_03.b == 0) {
            return;
        }
        while (!xf_02.c()) {
            this.b(xf_02);
        }
        if (!cq_0.b(xf_02.b(0, xf_02.h()), 0.0, this.e)) {
            throw new xa_0();
        }
    }

    private wQ o() {
        Object object;
        Object object2;
        if (this.i != null) {
            object2 = null;
            object = this.i;
            this.i.a = object2;
        }
        Serializable serializable = new xf_0(this.d(), this.m(), this.n(), this.b(), this.e, this.f);
        xf_0 xf_02 = serializable;
        object2 = this;
        object = xf_02;
        if (((xf_0)object).b != 0) {
            while (!xf_02.c()) {
                ((xe_0)object2).b(xf_02);
            }
            if (!cq_0.b(xf_02.b(0, xf_02.h()), 0.0, ((xe_0)object2).e)) {
                throw new xa_0();
            }
        }
        ((xf_0)serializable).b();
        if (this.i != null) {
            object2 = serializable;
            object = this.i;
            this.i.a = object2;
        }
        while (!((xf_0)serializable).c()) {
            this.b((xf_0)serializable);
        }
        serializable = ((xf_0)serializable).d();
        if (this.b()) {
            object2 = ((wQ)serializable).a();
            for (int i2 = 0; i2 < ((Object)object2).length; ++i2) {
                if (cq_0.a((double)object2[i2], 0.0, this.e) >= 0) continue;
                throw new xa_0();
            }
        }
        return serializable;
    }

    public final /* synthetic */ Object a(wO[] object) {
        wO[] wOArray = object;
        object = this;
        return super.c(wOArray);
    }

    public final /* synthetic */ Object c() {
        Object object;
        Object object2;
        xe_0 xe_02 = this;
        if (xe_02.i != null) {
            object2 = null;
            object = xe_02.i;
            xe_02.i.a = object2;
        }
        Serializable serializable = new xf_0(xe_02.d(), xe_02.m(), xe_02.n(), xe_02.b(), xe_02.e, xe_02.f);
        xf_0 xf_02 = serializable;
        object2 = xe_02;
        object = xf_02;
        if (((xf_0)object).b != 0) {
            while (!xf_02.c()) {
                ((xe_0)object2).b(xf_02);
            }
            if (!cq_0.b(xf_02.b(0, xf_02.h()), 0.0, ((xe_0)object2).e)) {
                throw new xa_0();
            }
        }
        ((xf_0)serializable).b();
        if (xe_02.i != null) {
            object2 = serializable;
            object = xe_02.i;
            xe_02.i.a = object2;
        }
        while (!((xf_0)serializable).c()) {
            xe_02.b((xf_0)serializable);
        }
        serializable = ((xf_0)serializable).d();
        if (xe_02.b()) {
            object2 = ((wQ)serializable).a();
            for (int i2 = 0; i2 < ((Object)object2).length; ++i2) {
                if (cq_0.a((double)object2[i2], 0.0, xe_02.e) >= 0) continue;
                throw new xa_0();
            }
        }
        return serializable;
    }
}

