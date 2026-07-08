/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.DB;
import org.valkyrienskies.core.impl.shadow.DC;
import org.valkyrienskies.core.impl.shadow.DD;
import org.valkyrienskies.core.impl.shadow.DE;
import org.valkyrienskies.core.impl.shadow.DF;
import org.valkyrienskies.core.impl.shadow.DG;
import org.valkyrienskies.core.impl.shadow.DH;
import org.valkyrienskies.core.impl.shadow.dy_0;
import org.valkyrienskies.core.impl.shadow.dz_0;

public final class DA {
    private static final int b = 2;
    private static final int c = 0x40000000;
    private final dy_0 d;
    private DF e;
    public Map<DB, DG> a = new HashMap<DB, DG>();
    private int f;
    private int g;

    public DA() {
        this.d = null;
        this.e = null;
    }

    private DA(dy_0 dy_02) {
        this.d = dy_02;
        this.e = null;
    }

    private DA(DF dF) {
        this.d = null;
        this.e = dF;
    }

    public DA(dy_0 dy_02, DF dF) {
        this.d = dy_02;
        this.e = dF;
    }

    private void a() {
        if (this.d == null) {
            throw new RuntimeException("You may only call augmentation-related methods on ConnGraph if the graph is augmented, i.e. if an Augmentation was passed to the constructor");
        }
    }

    private DG e(DB dB) {
        DD dD;
        Object object = this.a.get(dB);
        if (object != null) {
            return object;
        }
        if (this.a.size() == 0x40000000) {
            throw new RuntimeException("Sorry, ConnGraph has too many vertices to perform this operation. ConnGraph does not support storing more than ~2^30 vertices at a time.");
        }
        object = new DE();
        ((DE)object).c = dD = new DD((DE)object, this.d);
        dD.j = DD.a;
        dD.k = DD.a;
        ((DH)dD).b();
        object = new DG((DE)object);
        this.a.put(dB, (DG)object);
        if (this.a.size() > 1 << this.f) {
            ++this.f;
        }
        this.g = Math.max(this.g, this.a.size());
        return object;
    }

    private void f(DB dB) {
        this.a.remove(dB);
        if (4 * this.a.size() <= this.g && this.g > 12) {
            this.a = new HashMap<DB, DG>(this.a);
            this.g = this.a.size();
        }
        if (this.a.size() << 2 <= 1 << this.f) {
            this.b();
        }
    }

    private static dz_0 a(dz_0 dz_02, dz_0 dz_03, DE dE, DE dE2) {
        if (dz_03 == null) {
            return dz_02;
        }
        dz_0 dz_04 = null;
        dz_0 dz_05 = dz_03;
        while (dz_05 != null) {
            dz_04 = dz_05;
            if (dz_05.a == dE2) {
                dz_05.a = dE;
                dz_05 = dz_05.e;
                continue;
            }
            dz_05.b = dE;
            dz_05 = dz_05.g;
        }
        if (dz_04.a == dE) {
            dz_04.e = dz_02;
        } else {
            dz_04.g = dz_02;
        }
        if (dz_02 != null) {
            if (dz_02.a == dE) {
                dz_02.d = dz_04;
            } else {
                dz_02.f = dz_04;
            }
        }
        return dz_03;
    }

    private static void a(DD dD) {
        while (dD != null && ((DH)dD).b()) {
            dD = (DD)dD.i;
        }
    }

    private static void b(DD dD) {
        while (dD != null && dD.a()) {
            dD = (DD)dD.i;
        }
    }

    private void b() {
        if (this.a.isEmpty()) {
            this.f = 0;
            return;
        }
        int n2 = 0;
        while (2 * this.a.size() <= 1 << this.f) {
            --this.f;
            ++n2;
        }
        if (n2 == 0) {
            return;
        }
        for (DG dG : this.a.values()) {
            DE object;
            DE dE = object = dG.a;
            for (int i2 = 0; i2 < n2 && (dE = dE.a) != null; ++i2) {
                object.d = DA.a(object.d, dE.d, object, dE);
                if (dE.e == null) continue;
                dz_0 dz_02 = dE.e;
                while (dz_02 != null) {
                    if (dz_02.a == dE) {
                        dz_02 = dz_02.e;
                        continue;
                    }
                    DC dC = dz_02.c.c;
                    for (int i3 = 0; i3 < i2; ++i3) {
                        dC = dC.c;
                    }
                    dz_02.c = dC;
                    dz_02 = dz_02.g;
                }
                object.e = DA.a(object.e, dE.e, object, dE);
            }
            if (dE != null) {
                dE = dE.a;
            }
            object.a = dE;
            if (dE != null) {
                dE.b = object;
            }
            DA.b(object.c);
        }
    }

    private static void a(dz_0 dz_02) {
        dz_02.d = null;
        dz_02.e = dz_02.a.d;
        if (dz_02.e != null) {
            if (dz_02.e.a == dz_02.a) {
                dz_02.e.d = dz_02;
            } else {
                dz_02.e.f = dz_02;
            }
        }
        dz_02.a.d = dz_02;
    }

    private static void b(dz_0 dz_02) {
        dz_02.f = null;
        dz_02.g = dz_02.b.d;
        if (dz_02.g != null) {
            if (dz_02.g.a == dz_02.b) {
                dz_02.g.d = dz_02;
            } else {
                dz_02.g.f = dz_02;
            }
        }
        dz_02.b.d = dz_02;
    }

    private void c(dz_0 dz_02) {
        DA.a(dz_02);
        DA.b(dz_02);
    }

    private static void d(dz_0 dz_02) {
        dz_02.d = null;
        dz_02.e = dz_02.a.e;
        if (dz_02.e != null) {
            if (dz_02.e.a == dz_02.a) {
                dz_02.e.d = dz_02;
            } else {
                dz_02.e.f = dz_02;
            }
        }
        dz_02.a.e = dz_02;
        dz_02.f = null;
        dz_02.g = dz_02.b.e;
        if (dz_02.g != null) {
            if (dz_02.g.a == dz_02.b) {
                dz_02.g.d = dz_02;
            } else {
                dz_02.g.f = dz_02;
            }
        }
        dz_02.b.e = dz_02;
    }

    private static void e(dz_0 dz_02) {
        if (dz_02.d != null) {
            if (dz_02.d.a == dz_02.a) {
                dz_02.d.e = dz_02.e;
            } else {
                dz_02.d.g = dz_02.e;
            }
        } else {
            dz_0 dz_03 = dz_02;
            if (dz_03 == dz_03.a.d) {
                dz_02.a.d = dz_02.e;
            } else {
                dz_02.a.e = dz_02.e;
            }
        }
        if (dz_02.e != null) {
            if (dz_02.e.a == dz_02.a) {
                dz_02.e.d = dz_02.d;
                return;
            }
            dz_02.e.f = dz_02.d;
        }
    }

    private static void f(dz_0 dz_02) {
        if (dz_02.f != null) {
            if (dz_02.f.a == dz_02.b) {
                dz_02.f.e = dz_02.g;
            } else {
                dz_02.f.g = dz_02.g;
            }
        } else {
            dz_0 dz_03 = dz_02;
            if (dz_03 == dz_03.b.d) {
                dz_02.b.d = dz_02.g;
            } else {
                dz_02.b.e = dz_02.g;
            }
        }
        if (dz_02.g != null) {
            if (dz_02.g.a == dz_02.b) {
                dz_02.g.d = dz_02.f;
                return;
            }
            dz_02.g.f = dz_02.f;
        }
    }

    private void g(dz_0 dz_02) {
        DA.e(dz_02);
        DA.f(dz_02);
    }

    private DC a(DE object, DE object2) {
        Object object3;
        DD dD = (DD)((DE)object2).c.e();
        Object object4 = (DD)dD.g();
        if (((DD)object4).b != object2) {
            dD = (DD)((DH)object4).l();
            if (((DD)object4).b.c == object4) {
                ((DD)object4).b.c = object3 = (DD)dD.f();
                DA.a((DD)object3);
            }
            object3 = (DD[])dD.a(((DE)object2).c);
            dD = object3[1].a(object3[0]);
            object2 = new DD((DE)object2, dD.f);
            v0.j = DD.a;
            ((DH)object2).k = DD.a;
            ((DH)object2).l = true;
            object3 = (DD)dD.g();
            ((DD)dD.g()).k = object2;
            ((DH)object2).i = object3;
            dD = (DD)((DH)object2).j();
            object4 = object2;
        }
        object3 = (DD[])((DD)((DE)object).c.e()).a(((DE)object).c);
        object2 = object3[0];
        object3 = object3[1];
        object = new DD((DE)object, dD.f);
        ((DD)((DH)object2).a(dD, object)).a(object3);
        return new DC((DD)object, (DD)object4);
    }

    private void a(DC dDArray) {
        DD[] dDArray2;
        DD dD;
        if (dDArray.a.b(dDArray.b) < 0) {
            dD = dDArray.a;
            dDArray = dDArray.b;
        } else {
            dD = dDArray.b;
            dDArray = dDArray.a;
        }
        dDArray = (DD)dDArray.i();
        if (dD.b.c == dD) {
            dDArray2 = dDArray;
            dD.b.c = dDArray2;
            DA.a(dD);
            DA.a((DD)dDArray2);
        }
        dDArray2 = (DD)dD.e();
        dDArray2 = (DD[])dDArray2.a(dD);
        DD dD2 = dDArray2[0];
        dDArray = dDArray2[1].a(dDArray);
        dD2.a(dDArray[1]);
        dD.k();
    }

    private static void a(dz_0 dz_02, DG dG, DB dB) {
        dG.b.put(dB, dz_02);
        if (dG.b.size() > dG.c) {
            dG.c = dG.b.size();
        }
    }

    public final boolean a(DB dB, DB dB2) {
        if (dB == dB2) {
            throw new IllegalArgumentException("Self-loops are not allowed");
        }
        if (this.a.size() >= 0x3FFFFFFF) {
            throw new RuntimeException("Sorry, ConnGraph has too many vertices to perform this operation. ConnGraph does not support storing more than ~2^30 vertices at a time.");
        }
        DG dG = this.e(dB);
        if (dG.b.containsKey(dB2)) {
            return false;
        }
        DG dG2 = this.e(dB2);
        boolean bl = false;
        DD dD = (DD)dG.a.c.e();
        DD dD2 = (DD)dG2.a.c.e();
        DE dE = dG.a;
        DE dE2 = dG2.a;
        if (this.e != null) {
            this.e.a(dB, dB2, dD, dD2);
        }
        dz_0 dz_02 = new dz_0(dE, dE2);
        if (dE.c.e() == dE2.c.e()) {
            this.c(dz_02);
            DA.b(dE.c);
            DA.b(dE2.c);
        } else {
            DA.d(dz_02);
            DA.b(dE.c);
            DA.b(dE2.c);
            dz_02.c = this.a(dE, dE2);
            bl = true;
        }
        DA.a(dz_02, dG, dB2);
        DA.a(dz_02, dG2, dB);
        if (bl && this.e != null) {
            this.e.a(dB, dB2, dD, dD2, (DD)dG.a.c.e());
        }
        return true;
    }

    private static DE a(DE dE) {
        DE dE2 = dE.a;
        if (dE2 == null) {
            DD dD;
            dE2 = new DE();
            dE2.c = dD = new DD(dE2, null);
            dE.a = dE2;
            dE2.b = dE;
            dD.j = DD.a;
            dD.k = DD.a;
            ((DH)dD).b();
        }
        return dE2;
    }

    private void c(DD dD) {
        if (!dD.e || dD.c == 1) {
            return;
        }
        while (((DD)dD.j).e) {
            dD = (DD)dD.j;
        }
        while (dD != null) {
            DE dE = dD.b;
            dz_0 dz_02 = dE.e;
            if (dz_02 != null) {
                DE dE2 = DA.a(dE);
                Object object = null;
                while (dz_02 != null) {
                    if (dz_02.b == dE || dz_02.b == dE2) {
                        object = dz_02;
                        dz_02 = dz_02.g;
                        continue;
                    }
                    dz_02.a = dE2;
                    dz_02.b = DA.a(dz_02.b);
                    object = this.a(dz_02.a, dz_02.b);
                    this.a(dz_02.a, dz_02.b).c = dz_02.c;
                    dz_02.c = object;
                    object = dz_02;
                    dz_02 = dz_02.e;
                }
                if (((dz_0)object).a == dE2) {
                    ((dz_0)object).e = dE2.e;
                } else {
                    ((dz_0)object).g = dE2.e;
                }
                if (dE2.e != null) {
                    if (dE2.e.a == dE2) {
                        dE2.e.d = object;
                    } else {
                        dE2.e.f = object;
                    }
                }
                dE2.e = dE.e;
                dE.e = null;
                DA.b(dE2.c);
            }
            if (((DD)dD.k).e) {
                dD = (DD)dD.k;
                while (((DD)dD.j).e) {
                    dD = (DD)dD.j;
                }
                continue;
            }
            while (true) {
                dD.e = false;
                if (dD.i == null || ((DD)dD.i).k != dD) break;
                dD = (DD)dD.i;
            }
            dD = (DD)dD.i;
        }
    }

    private dz_0 d(DD dD) {
        if (!dD.d) {
            return null;
        }
        DD dD2 = dD;
        while (((DD)dD2.j).d) {
            dD2 = (DD)dD2.j;
        }
        while (dD2 != null) {
            DE dE = dD2.b;
            dz_0 dz_02 = dE.d;
            if (dz_02 != null) {
                DE dE2;
                dz_0 dz_03 = null;
                dz_0 dz_04 = null;
                while (dz_02 != null) {
                    dz_0 dz_05;
                    if (dz_02.a == dE) {
                        dE2 = dz_02.b;
                        dz_05 = dz_02.e;
                    } else {
                        dE2 = dz_02.a;
                        dz_05 = dz_02.g;
                    }
                    if (dE2.c.e() != dD) {
                        dz_03 = dz_02;
                        break;
                    }
                    if (dz_02.a == dE2) {
                        DA.e(dz_02);
                    } else {
                        DA.f(dz_02);
                    }
                    DA.b(dE2.c);
                    dz_02.a = DA.a(dz_02.a);
                    dz_02.b = DA.a(dz_02.b);
                    if (dz_02.a != dE.a) {
                        DA.a(dz_02);
                    } else {
                        DA.b(dz_02);
                    }
                    DA.b(dE2.a.c);
                    dz_04 = dz_02;
                    dz_02 = dz_05;
                }
                if (dz_04 != null) {
                    dE2 = dE.a;
                    if (dz_04.a == dE2) {
                        dz_04.e = dE2.d;
                    } else {
                        dz_04.g = dE2.d;
                    }
                    if (dE2.d != null) {
                        if (dE2.d.a == dE2) {
                            dE2.d.d = dz_04;
                        } else {
                            dE2.d.f = dz_04;
                        }
                    }
                    dE2.d = dE.d;
                    DA.b(dE2.c);
                }
                dE.d = dz_02;
                if (dz_02 == null) {
                    DA.b(dE.c);
                } else if (dz_02.a == dE) {
                    dz_02.d = null;
                } else {
                    dz_02.f = null;
                }
                if (dz_03 != null) {
                    return dz_03;
                }
            }
            if (((DD)dD2.k).d) {
                dD2 = (DD)dD2.k;
                while (((DD)dD2.j).d) {
                    dD2 = (DD)dD2.j;
                }
                continue;
            }
            while (!(dD2.i == null || ((DD)dD2.i).k != dD2 && ((DD)dD2.i).d)) {
                dD2 = (DD)dD2.i;
            }
            dD2 = (DD)dD2.i;
        }
        return null;
    }

    private static dz_0 a(DG dG, DB object) {
        if ((object = dG.b.remove(object)) != null && 4 * dG.b.size() <= dG.c && dG.c > 6) {
            dG.b = new HashMap<DB, dz_0>(dG.b);
            dG.c = dG.b.size();
        }
        return object;
    }

    public final boolean b(DB dB, DB dB2) {
        if (dB == dB2) {
            throw new IllegalArgumentException("Self-loops are not allowed");
        }
        DG dG = this.a.get(dB);
        if (dG == null) {
            return false;
        }
        Object object = (DD)dG.a.c.e();
        if (this.e != null) {
            this.e.a(dB, dB2, (DD)object);
        }
        int cfr_ignored_0 = ((DD)object).c;
        Object object2 = DA.a(dG, dB2);
        if (object2 == null) {
            return false;
        }
        DG dG2 = this.a.get(dB2);
        DA.a(dG2, dB);
        this.g((dz_0)object2);
        DA.b(((dz_0)object2).a.c);
        DA.b(((dz_0)object2).b.c);
        if (((dz_0)object2).c != null) {
            Object object3;
            Object object4;
            Object object5;
            Object object6;
            DD[] dDArray;
            Object object7;
            Object object8;
            Object object9;
            Object object10;
            DA dA;
            DD[] dDArray2;
            DC dC = ((dz_0)object2).c;
            while (dC != null) {
                dDArray2 = dC;
                dA = this;
                if (dDArray2.a.b(dDArray2.b) < 0) {
                    object10 = dDArray2.a;
                    object9 = dDArray2.b;
                } else {
                    object10 = dDArray2.b;
                    object9 = dDArray2.a;
                }
                object8 = (DD)((DH)object9).i();
                if (object10.b.c == object10) {
                    object7 = object8;
                    object10.b.c = object7;
                    DA.a((DD)object10);
                    DA.a((DD)object7);
                }
                object7 = (DD)object10.e();
                dDArray = ((DH)object7).a(object10);
                object6 = dDArray[0];
                object5 = (DD[])dDArray[1].a(object8);
                ((DH)object6).a(object5[1]);
                object10.k();
                dC = dC.c;
            }
            ((dz_0)object2).c = null;
            dC = null;
            DE dE = ((dz_0)object2).a;
            object2 = ((dz_0)object2).b;
            while (dE != null) {
                object4 = (DD)dE.c.e();
                object3 = (DD)((DE)object2).c.e();
                if (object4.d && ((DD)object3).d) {
                    Object object11;
                    block61: {
                        object5 = object4.c < ((DD)object3).c ? object4 : object3;
                        dDArray2 = object5;
                        dA = this;
                        if (dDArray2.e && dDArray2.c != 1) {
                            object10 = dDArray2;
                            while (((DD)object10.j).e) {
                                object10 = (DD)object10.j;
                            }
                            while (object10 != null) {
                                object9 = object10.b;
                                object8 = ((DE)object9).e;
                                if (object8 != null) {
                                    object7 = DA.a((DE)object9);
                                    dDArray = null;
                                    while (object8 != null) {
                                        if (object8.b == object9 || object8.b == object7) {
                                            dDArray = object8;
                                            object8 = object8.g;
                                            continue;
                                        }
                                        object8.a = object7;
                                        object8.b = DA.a(object8.b);
                                        object6 = dA.a(object8.a, object8.b);
                                        dA.a(object8.a, object8.b).c = object8.c;
                                        object8.c = object6;
                                        dDArray = object8;
                                        object8 = object8.e;
                                    }
                                    if (dDArray.a == object7) {
                                        dDArray.e = ((DE)object7).e;
                                    } else {
                                        dDArray.g = ((DE)object7).e;
                                    }
                                    if (((DE)object7).e != null) {
                                        if (((DE)object7).e.a == object7) {
                                            ((DE)object7).e.d = dDArray;
                                        } else {
                                            ((DE)object7).e.f = dDArray;
                                        }
                                    }
                                    ((DE)object7).e = ((DE)object9).e;
                                    ((DE)object9).e = null;
                                    DA.b(((DE)object7).c);
                                }
                                if (((DD)object10.k).e) {
                                    object10 = (DD)object10.k;
                                    while (((DD)object10.j).e) {
                                        object10 = (DD)object10.j;
                                    }
                                    continue;
                                }
                                while (true) {
                                    object10.e = false;
                                    if (object10.i == null || ((DD)object10.i).k != object10) break;
                                    object10 = (DD)object10.i;
                                }
                                object10 = (DD)object10.i;
                            }
                        }
                        dDArray2 = object5;
                        dA = this;
                        if (dDArray2.d) {
                            object10 = dDArray2;
                            while (((DD)object10.j).d) {
                                object10 = (DD)object10.j;
                            }
                            while (object10 != null) {
                                object9 = object10.b;
                                object8 = ((DE)object9).d;
                                if (object8 != null) {
                                    object7 = null;
                                    dDArray = null;
                                    while (object8 != null) {
                                        if (object8.a == object9) {
                                            object6 = object8.b;
                                            object5 = object8.e;
                                        } else {
                                            object6 = object8.a;
                                            object5 = object8.g;
                                        }
                                        if (((DE)object6).c.e() != dDArray2) {
                                            object7 = object8;
                                            break;
                                        }
                                        if (object8.a == object6) {
                                            DA.e((dz_0)object8);
                                        } else {
                                            DA.f((dz_0)object8);
                                        }
                                        DA.b(((DE)object6).c);
                                        object8.a = DA.a(object8.a);
                                        object8.b = DA.a(object8.b);
                                        if (object8.a != ((DE)object9).a) {
                                            DA.a((dz_0)object8);
                                        } else {
                                            DA.b((dz_0)object8);
                                        }
                                        DA.b(((DE)object6).a.c);
                                        dDArray = object8;
                                        object8 = object5;
                                    }
                                    if (dDArray != null) {
                                        object6 = ((DE)object9).a;
                                        if (dDArray.a == object6) {
                                            dDArray.e = ((DE)object6).d;
                                        } else {
                                            dDArray.g = ((DE)object6).d;
                                        }
                                        if (((DE)object6).d != null) {
                                            if (((DE)object6).d.a == object6) {
                                                ((DE)object6).d.d = dDArray;
                                            } else {
                                                ((DE)object6).d.f = dDArray;
                                            }
                                        }
                                        ((DE)object6).d = ((DE)object9).d;
                                        DA.b(((DE)object6).c);
                                    }
                                    ((DE)object9).d = object8;
                                    if (object8 == null) {
                                        DA.b(((DE)object9).c);
                                    } else if (object8.a == object9) {
                                        object8.d = null;
                                    } else {
                                        object8.f = null;
                                    }
                                    if (object7 != null) {
                                        object11 = object7;
                                        break block61;
                                    }
                                }
                                if (((DD)object10.k).d) {
                                    object10 = (DD)object10.k;
                                    while (((DD)object10.j).d) {
                                        object10 = (DD)object10.j;
                                    }
                                    continue;
                                }
                                while (!(object10.i == null || ((DD)object10.i).k != object10 && ((DD)object10.i).d)) {
                                    object10 = (DD)object10.i;
                                }
                                object10 = (DD)object10.i;
                            }
                        }
                        object11 = dC = null;
                    }
                    if (object11 != null) break;
                }
                if (object4.c == 1 && dE.b != null) {
                    dE.b.a = null;
                }
                if (((DD)object3).c == 1 && ((DE)object2).b != null) {
                    ((DE)object2).b.a = null;
                }
                dE = dE.b;
                object2 = ((DE)object2).b;
            }
            if (dC != null) {
                this.g((dz_0)((Object)dC));
                DA.d((dz_0)((Object)dC));
                object4 = ((dz_0)((Object)dC)).a;
                object3 = ((dz_0)((Object)dC)).b;
                DA.b(object4.c);
                DA.b(((DE)object3).c);
                object5 = null;
                while (object4 != null) {
                    object = this.a((DE)object4, (DE)object3);
                    if (object5 == null) {
                        ((dz_0)((Object)dC)).c = object;
                    } else {
                        object5.c = object;
                    }
                    object5 = object;
                    object4 = object4.b;
                    object3 = ((DE)object3).b;
                }
            } else if (this.e != null && object != null) {
                this.e.b(dB, dB2, (DD)dG.a.c.e(), (DD)dG2.a.c.e(), (DD)object);
            }
        }
        if (dG.b.isEmpty() && !dG.a.g) {
            this.f(dB);
        }
        if (dG2.b.isEmpty() && !dG2.a.g) {
            this.f(dB2);
        }
        return true;
    }

    public final boolean c(DB object, DB object2) {
        if (object == object2) {
            return true;
        }
        if ((object = this.a.get(object)) == null) {
            return false;
        }
        return (object2 = this.a.get(object2)) != null && ((DG)object).a.c.e() == ((DG)object2).a.c.e();
    }

    public final Collection<DB> a(DB object) {
        if ((object = this.a.get(object)) != null) {
            return new ArrayList<DB>(((DG)object).b.keySet());
        }
        return Collections.emptyList();
    }

    public final Object a(DB object, Object object2) {
        this.a();
        object = this.e((DB)object).a;
        Object object3 = ((DE)object).f;
        if (!((DE)object).g || (object2 != null ? !object2.equals(object3) : object3 != null)) {
            ((DE)object).f = object2;
            ((DE)object).g = true;
            object = ((DE)object).c;
            while (object != null && ((DH)object).b()) {
                object = (DD)((DH)object).i;
            }
        }
        return object3;
    }

    public final Object b(DB object) {
        this.a();
        DG dG = this.a.get(object);
        if (dG == null) {
            return null;
        }
        DE dE = dG.a;
        Object object2 = dE.f;
        if (dG.b.isEmpty()) {
            this.f((DB)object);
        } else if (dE.g) {
            dE.f = null;
            dE.g = false;
            object = dE.c;
            while (object != null && ((DH)object).b()) {
                object = (DD)((DH)object).i;
            }
        }
        return object2;
    }

    public final Object c(DB object) {
        this.a();
        object = this.a.get(object);
        if (object != null) {
            return ((DG)object).a.f;
        }
        return null;
    }

    public final Object d(DB object) {
        this.a();
        object = this.a.get(object);
        if (object != null) {
            return ((DD)((DG)object).a.c.e()).g;
        }
        return null;
    }

    private boolean g(DB object) {
        this.a();
        object = this.a.get(object);
        if (object != null) {
            return ((DG)object).a.g;
        }
        return false;
    }

    private boolean h(DB object) {
        this.a();
        object = this.a.get(object);
        if (object != null) {
            return ((DD)((DG)object).a.c.e()).h;
        }
        return false;
    }

    private void c() {
        this.a = new HashMap<DB, DG>();
        this.f = 0;
        this.g = 0;
    }

    /*
     * WARNING - void declaration
     */
    private void d() {
        for (DG dG : this.a.values()) {
            void object;
            void var2_5;
            int n2 = this.f;
            DE dE = dG.a;
            while (var2_5.a != null) {
                --n2;
                DE dE2 = var2_5.a;
            }
            while (object != null) {
                DD dD = object.c;
                dz_0 dz_02 = object.e;
                while (dz_02 != null) {
                    if (object == dz_02.b) {
                        dz_02 = dz_02.g;
                        continue;
                    }
                    dz_0 dz_03 = dz_02.e;
                    DE dE3 = object;
                    DE dE4 = dz_02.b;
                    for (int i2 = n2 - 1; i2 > 0; --i2) {
                        int n3 = 1;
                        n3 = dE3.a != null ? 1 + ((DD)dE3.a.c.e()).c : ++n3;
                        n3 = dE4.a != null ? (n3 += ((DD)dE4.a.c.e()).c) : ++n3;
                        if (n3 > 2 * (1 << i2) - 1) break;
                        dE3 = DA.a(dE3);
                        dE4 = DA.a(dE4);
                        DC dC = this.a(dE3, dE4);
                        this.a(dE3, dE4).c = dz_02.c;
                        dz_02.c = dC;
                    }
                    if (dE3 != object) {
                        this.g(dz_02);
                        DA.b(dD);
                        DA.b(dz_02.b.c);
                        dz_02.a = dE3;
                        dz_02.b = dE4;
                        DA.d(dz_02);
                        DA.b(dE3.c);
                        DA.b(dE4.c);
                    }
                    dz_02 = dz_03;
                }
                DE dE5 = object.b;
                ++n2;
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private void e() {
        for (DG dG : this.a.values()) {
            void object;
            void var2_5;
            DE dE = dG.a;
            while (var2_5.a != null) {
                DE dE2 = var2_5.a;
            }
            while (object != null) {
                DD dD = object.c;
                dz_0 dz_02 = object.d;
                while (dz_02 != null) {
                    if (object == dz_02.b) {
                        dz_02 = dz_02.g;
                        continue;
                    }
                    dz_0 dz_03 = dz_02.e;
                    int n2 = 0;
                    DE dE3 = object.a;
                    DE dE4 = dz_02.b.a;
                    while (dE3 != null && dE4 != null) {
                        ++n2;
                        dE3 = dE3.a;
                        dE4 = dE4.a;
                    }
                    DE dE5 = object;
                    DE dE6 = dz_02.b;
                    while (n2 > 0) {
                        int n3 = (n2 + 1) / 2;
                        dE3 = dE5;
                        dE4 = dE6;
                        for (int i2 = 0; i2 < n3; ++i2) {
                            dE3 = dE3.a;
                            dE4 = dE4.a;
                        }
                        if (dE3.c.e() != dE4.c.e()) {
                            n2 = n3 - 1;
                            continue;
                        }
                        dE5 = dE3;
                        dE6 = dE4;
                        n2 -= n3;
                    }
                    if (dE5 != object) {
                        this.g(dz_02);
                        DA.b(dD);
                        DA.b(dz_02.b.c);
                        dz_02.a = dE5;
                        dz_02.b = dE6;
                        this.c(dz_02);
                        DA.b(dE5.c);
                        DA.b(dE6.c);
                    }
                    dz_02 = dz_03;
                }
                DE dE7 = object.b;
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private void f() {
        DE dE;
        DE dE2;
        dz_0 dz_02;
        Object object;
        this.b();
        DA dA = this;
        for (DG dG : dA.a.values()) {
            void object3;
            void var3_6;
            int n2 = dA.f;
            DE dE3 = dG.a;
            while (var3_6.a != null) {
                --n2;
                DE dE4 = var3_6.a;
            }
            while (object3 != null) {
                object = object3.c;
                dz_02 = object3.e;
                while (dz_02 != null) {
                    if (object3 == dz_02.b) {
                        dz_02 = dz_02.g;
                        continue;
                    }
                    dz_0 dz_03 = dz_02.e;
                    dE2 = object3;
                    dE = dz_02.b;
                    for (int i2 = n2 - 1; i2 > 0; --i2) {
                        int n3 = 1;
                        n3 = dE2.a != null ? 1 + ((DD)dE2.a.c.e()).c : ++n3;
                        n3 = dE.a != null ? (n3 += ((DD)dE.a.c.e()).c) : ++n3;
                        if (n3 > 2 * (1 << i2) - 1) break;
                        dE2 = DA.a(dE2);
                        dE = DA.a(dE);
                        DC dC = dA.a(dE2, dE);
                        dA.a(dE2, dE).c = dz_02.c;
                        dz_02.c = dC;
                    }
                    if (dE2 != object3) {
                        dA.g(dz_02);
                        DA.b((DD)object);
                        DA.b(dz_02.b.c);
                        dz_02.a = dE2;
                        dz_02.b = dE;
                        DA.d(dz_02);
                        DA.b(dE2.c);
                        DA.b(dE.c);
                    }
                    dz_02 = dz_03;
                }
                DE dE5 = object3.b;
                ++n2;
            }
        }
        dA = this;
        for (DG dG : dA.a.values()) {
            DE dE6 = dG.a;
            while (dE6.a != null) {
                dE6 = dE6.a;
            }
            while (dE6 != null) {
                DD dD = dE6.c;
                object = dE6.d;
                while (object != null) {
                    if (dE6 == ((dz_0)object).b) {
                        object = ((dz_0)object).g;
                        continue;
                    }
                    dz_02 = ((dz_0)object).e;
                    int n4 = 0;
                    dE2 = dE6.a;
                    dE = ((dz_0)object).b.a;
                    while (dE2 != null && dE != null) {
                        ++n4;
                        dE2 = dE2.a;
                        dE = dE.a;
                    }
                    DE dE7 = dE6;
                    DE dE8 = ((dz_0)object).b;
                    while (n4 > 0) {
                        int n5 = (n4 + 1) / 2;
                        dE2 = dE7;
                        dE = dE8;
                        for (int i3 = 0; i3 < n5; ++i3) {
                            dE2 = dE2.a;
                            dE = dE.a;
                        }
                        if (dE2.c.e() != dE.c.e()) {
                            n4 = n5 - 1;
                            continue;
                        }
                        dE7 = dE2;
                        dE8 = dE;
                        n4 -= n5;
                    }
                    if (dE7 != dE6) {
                        dA.g((dz_0)object);
                        DA.b(dD);
                        DA.b(((dz_0)object).b.c);
                        ((dz_0)object).a = dE7;
                        ((dz_0)object).b = dE8;
                        dA.c((dz_0)object);
                        DA.b(dE7.c);
                        DA.b(dE8.c);
                    }
                    object = dz_02;
                }
                dE6 = dE6.b;
            }
        }
    }
}

