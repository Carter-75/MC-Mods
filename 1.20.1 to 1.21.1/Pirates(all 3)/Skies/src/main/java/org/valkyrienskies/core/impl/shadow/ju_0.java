/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iZ
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.iZ;
import org.valkyrienskies.core.impl.shadow.ij_1;
import org.valkyrienskies.core.impl.shadow.iz_0;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.jo_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ju
 */
public final class ju_0<K, V>
extends jd_0<ij_1<? extends K>, V>
implements Serializable,
Cloneable {
    private static final long b = -1788199231038721040L;

    private static <K, V> ju_0<K, V> a(iz_0<ij_1<? extends K>, V> iz_02) {
        if (iz_02 == null) {
            throw new NullPointerException("Map must not be null");
        }
        if (iz_02.size() > 0) {
            throw new IllegalArgumentException("Map must be empty");
        }
        return new ju_0<K, V>(iz_02);
    }

    public ju_0() {
        this(new jo_0());
    }

    private ju_0(iz_0<ij_1<? extends K>, V> iz_02) {
        super(iz_02);
        this.a = iz_02;
    }

    private V a(Object object, Object object2) {
        int n2 = ju_0.d(object, object2);
        ju_0 ju_02 = this;
        iz_0.c c2 = ju_02;
        c2 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        c2 = this;
        c2 = ((iZ)super.i()).d[iZ.a((int)n2, (int)((iZ)super.i()).d.length)];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2)) {
                return c2.getValue();
            }
            c2 = c2.a;
        }
        return null;
    }

    private boolean b(Object object, Object object2) {
        int n2 = ju_0.d(object, object2);
        ju_0 ju_02 = this;
        iz_0.c c2 = ju_02;
        c2 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        c2 = this;
        c2 = ((iZ)super.i()).d[iZ.a((int)n2, (int)((iZ)super.i()).d.length)];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2)) {
                return true;
            }
            c2 = c2.a;
        }
        return false;
    }

    private V a(K object, K k2, V v) {
        int n2 = ju_0.d(object, k2);
        ju_0 ju_02 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        ju_02 = this;
        int n3 = iZ.a((int)n2, (int)((iZ)super.i()).d.length);
        ju_02 = this;
        iz_0.c c2 = ((iZ)super.i()).d[n3];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, k2)) {
                object = c2.getValue();
                ju_02 = this;
                ((iZ)super.i()).a(c2, v);
                return (V)object;
            }
            c2 = c2.a;
        }
        ju_02 = this;
        ((iZ)super.i()).a(n3, n2, new ij_1<K>(object, k2), v);
        return null;
    }

    private V c(Object object, Object object2) {
        int n2 = ju_0.d(object, object2);
        ju_0 ju_02 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        ju_02 = this;
        int n3 = iZ.a((int)n2, (int)((iZ)super.i()).d.length);
        ju_02 = this;
        iz_0.c c2 = ((iZ)super.i()).d[n3];
        iz_0.c c3 = null;
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2)) {
                object = c2.getValue();
                ju_02 = this;
                ((iZ)super.i()).a(c2, n3, c3);
                return (V)object;
            }
            c3 = c2;
            c2 = c2.a;
        }
        return null;
    }

    private static int d(Object object, Object object2) {
        int n2 = 0;
        if (object != null) {
            n2 = 0 ^ object.hashCode();
        }
        if (object2 != null) {
            n2 ^= object2.hashCode();
        }
        int n3 = n2;
        n2 = n3 + ~(n3 << 9);
        n2 ^= n2 >>> 14;
        n2 += n2 << 4;
        n2 ^= n2 >>> 10;
        return n2;
    }

    private static boolean a(iz_0.c<ij_1<? extends K>, V> object, Object object2, Object object3) {
        block2: {
            block4: {
                int n2;
                Object object4;
                block3: {
                    object4 = object = ((iz_0.c)object).getKey();
                    if (((ij_1)object).a.length != 2) break block2;
                    n2 = 0;
                    object4 = object;
                    if (object2 == ((ij_1)object4).a[n2]) break block3;
                    if (object2 == null) break block2;
                    n2 = 0;
                    object4 = object;
                    if (!object2.equals(((ij_1)object4).a[n2])) break block2;
                }
                n2 = 1;
                object4 = object;
                if (object3 == ((ij_1)object4).a[n2]) break block4;
                if (object3 == null) break block2;
                n2 = 1;
                object4 = object;
                if (!object3.equals(((ij_1)object4).a[n2])) break block2;
            }
            return true;
        }
        return false;
    }

    private V b(Object object, Object object2, Object object3) {
        int n2 = ju_0.e(object, object2, object3);
        ju_0 ju_02 = this;
        iz_0.c c2 = ju_02;
        c2 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        c2 = this;
        c2 = ((iZ)super.i()).d[iZ.a((int)n2, (int)((iZ)super.i()).d.length)];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2, object3)) {
                return c2.getValue();
            }
            c2 = c2.a;
        }
        return null;
    }

    private boolean c(Object object, Object object2, Object object3) {
        int n2 = ju_0.e(object, object2, object3);
        ju_0 ju_02 = this;
        iz_0.c c2 = ju_02;
        c2 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        c2 = this;
        c2 = ((iZ)super.i()).d[iZ.a((int)n2, (int)((iZ)super.i()).d.length)];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2, object3)) {
                return true;
            }
            c2 = c2.a;
        }
        return false;
    }

    private V a(K object, K k2, K k3, V v) {
        int n2 = ju_0.e(object, k2, k3);
        ju_0 ju_02 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        ju_02 = this;
        int n3 = iZ.a((int)n2, (int)((iZ)super.i()).d.length);
        ju_02 = this;
        iz_0.c c2 = ((iZ)super.i()).d[n3];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, k2, k3)) {
                object = c2.getValue();
                ju_02 = this;
                ((iZ)super.i()).a(c2, v);
                return (V)object;
            }
            c2 = c2.a;
        }
        ju_02 = this;
        ((iZ)super.i()).a(n3, n2, new ij_1<K>(object, k2, k3), v);
        return null;
    }

    private V d(Object object, Object object2, Object object3) {
        int n2 = ju_0.e(object, object2, object3);
        ju_0 ju_02 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        ju_02 = this;
        int n3 = iZ.a((int)n2, (int)((iZ)super.i()).d.length);
        ju_02 = this;
        iz_0.c c2 = ((iZ)super.i()).d[n3];
        iz_0.c c3 = null;
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2, object3)) {
                object = c2.getValue();
                ju_02 = this;
                ((iZ)super.i()).a(c2, n3, c3);
                return (V)object;
            }
            c3 = c2;
            c2 = c2.a;
        }
        return null;
    }

    private static int e(Object object, Object object2, Object object3) {
        int n2 = 0;
        if (object != null) {
            n2 = 0 ^ object.hashCode();
        }
        if (object2 != null) {
            n2 ^= object2.hashCode();
        }
        if (object3 != null) {
            n2 ^= object3.hashCode();
        }
        int n3 = n2;
        n2 = n3 + ~(n3 << 9);
        n2 ^= n2 >>> 14;
        n2 += n2 << 4;
        n2 ^= n2 >>> 10;
        return n2;
    }

    private static boolean a(iz_0.c<ij_1<? extends K>, V> object, Object object2, Object object3, Object object4) {
        block2: {
            block5: {
                int n2;
                Object object5;
                block4: {
                    block3: {
                        object5 = object = ((iz_0.c)object).getKey();
                        if (((ij_1)object).a.length != 3) break block2;
                        n2 = 0;
                        object5 = object;
                        if (object2 == ((ij_1)object5).a[n2]) break block3;
                        if (object2 == null) break block2;
                        n2 = 0;
                        object5 = object;
                        if (!object2.equals(((ij_1)object5).a[n2])) break block2;
                    }
                    n2 = 1;
                    object5 = object;
                    if (object3 == ((ij_1)object5).a[n2]) break block4;
                    if (object3 == null) break block2;
                    n2 = 1;
                    object5 = object;
                    if (!object3.equals(((ij_1)object5).a[n2])) break block2;
                }
                n2 = 2;
                object5 = object;
                if (object4 == ((ij_1)object5).a[n2]) break block5;
                if (object4 == null) break block2;
                n2 = 2;
                object5 = object;
                if (!object4.equals(((ij_1)object5).a[n2])) break block2;
            }
            return true;
        }
        return false;
    }

    private V b(Object object, Object object2, Object object3, Object object4) {
        int n2 = ju_0.e(object, object2, object3, object4);
        ju_0 ju_02 = this;
        iz_0.c c2 = ju_02;
        c2 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        c2 = this;
        c2 = ((iZ)super.i()).d[iZ.a((int)n2, (int)((iZ)super.i()).d.length)];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2, object3, object4)) {
                return c2.getValue();
            }
            c2 = c2.a;
        }
        return null;
    }

    private boolean c(Object object, Object object2, Object object3, Object object4) {
        int n2 = ju_0.e(object, object2, object3, object4);
        ju_0 ju_02 = this;
        iz_0.c c2 = ju_02;
        c2 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        c2 = this;
        c2 = ((iZ)super.i()).d[iZ.a((int)n2, (int)((iZ)super.i()).d.length)];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2, object3, object4)) {
                return true;
            }
            c2 = c2.a;
        }
        return false;
    }

    private V a(K object, K k2, K k3, K k4, V v) {
        int n2 = ju_0.e(object, k2, k3, k4);
        ju_0 ju_02 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        ju_02 = this;
        int n3 = iZ.a((int)n2, (int)((iZ)super.i()).d.length);
        ju_02 = this;
        iz_0.c c2 = ((iZ)super.i()).d[n3];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, k2, k3, k4)) {
                object = c2.getValue();
                ju_02 = this;
                ((iZ)super.i()).a(c2, v);
                return (V)object;
            }
            c2 = c2.a;
        }
        ju_02 = this;
        ((iZ)super.i()).a(n3, n2, new ij_1<K>(object, k2, k3, k4), v);
        return null;
    }

    private V d(Object object, Object object2, Object object3, Object object4) {
        int n2 = ju_0.e(object, object2, object3, object4);
        ju_0 ju_02 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        ju_02 = this;
        int n3 = iZ.a((int)n2, (int)((iZ)super.i()).d.length);
        ju_02 = this;
        iz_0.c c2 = ((iZ)super.i()).d[n3];
        iz_0.c c3 = null;
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2, object3, object4)) {
                object = c2.getValue();
                ju_02 = this;
                ((iZ)super.i()).a(c2, n3, c3);
                return (V)object;
            }
            c3 = c2;
            c2 = c2.a;
        }
        return null;
    }

    private static int e(Object object, Object object2, Object object3, Object object4) {
        int n2 = 0;
        if (object != null) {
            n2 = 0 ^ object.hashCode();
        }
        if (object2 != null) {
            n2 ^= object2.hashCode();
        }
        if (object3 != null) {
            n2 ^= object3.hashCode();
        }
        if (object4 != null) {
            n2 ^= object4.hashCode();
        }
        int n3 = n2;
        n2 = n3 + ~(n3 << 9);
        n2 ^= n2 >>> 14;
        n2 += n2 << 4;
        n2 ^= n2 >>> 10;
        return n2;
    }

    private static boolean a(iz_0.c<ij_1<? extends K>, V> object, Object object2, Object object3, Object object4, Object object5) {
        block2: {
            block6: {
                int n2;
                Object object6;
                block5: {
                    block4: {
                        block3: {
                            object6 = object = ((iz_0.c)object).getKey();
                            if (((ij_1)object).a.length != 4) break block2;
                            n2 = 0;
                            object6 = object;
                            if (object2 == ((ij_1)object6).a[n2]) break block3;
                            if (object2 == null) break block2;
                            n2 = 0;
                            object6 = object;
                            if (!object2.equals(((ij_1)object6).a[n2])) break block2;
                        }
                        n2 = 1;
                        object6 = object;
                        if (object3 == ((ij_1)object6).a[n2]) break block4;
                        if (object3 == null) break block2;
                        n2 = 1;
                        object6 = object;
                        if (!object3.equals(((ij_1)object6).a[n2])) break block2;
                    }
                    n2 = 2;
                    object6 = object;
                    if (object4 == ((ij_1)object6).a[n2]) break block5;
                    if (object4 == null) break block2;
                    n2 = 2;
                    object6 = object;
                    if (!object4.equals(((ij_1)object6).a[n2])) break block2;
                }
                n2 = 3;
                object6 = object;
                if (object5 == ((ij_1)object6).a[n2]) break block6;
                if (object5 == null) break block2;
                n2 = 3;
                object6 = object;
                if (!object5.equals(((ij_1)object6).a[n2])) break block2;
            }
            return true;
        }
        return false;
    }

    private V b(Object object, Object object2, Object object3, Object object4, Object object5) {
        int n2 = ju_0.e(object, object2, object3, object4, object5);
        ju_0 ju_02 = this;
        iz_0.c c2 = ju_02;
        c2 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        c2 = this;
        c2 = ((iZ)super.i()).d[iZ.a((int)n2, (int)((iZ)super.i()).d.length)];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2, object3, object4, object5)) {
                return c2.getValue();
            }
            c2 = c2.a;
        }
        return null;
    }

    private boolean c(Object object, Object object2, Object object3, Object object4, Object object5) {
        int n2 = ju_0.e(object, object2, object3, object4, object5);
        ju_0 ju_02 = this;
        iz_0.c c2 = ju_02;
        c2 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        c2 = this;
        c2 = ((iZ)super.i()).d[iZ.a((int)n2, (int)((iZ)super.i()).d.length)];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2, object3, object4, object5)) {
                return true;
            }
            c2 = c2.a;
        }
        return false;
    }

    private V a(K object, K k2, K k3, K k4, K k5, V v) {
        int n2 = ju_0.e(object, k2, k3, k4, k5);
        ju_0 ju_02 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        ju_02 = this;
        int n3 = iZ.a((int)n2, (int)((iZ)super.i()).d.length);
        ju_02 = this;
        iz_0.c c2 = ((iZ)super.i()).d[n3];
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, k2, k3, k4, k5)) {
                object = c2.getValue();
                ju_02 = this;
                ((iZ)super.i()).a(c2, v);
                return (V)object;
            }
            c2 = c2.a;
        }
        ju_02 = this;
        ((iZ)super.i()).a(n3, n2, new ij_1<K>(object, k2, k3, k4, k5), v);
        return null;
    }

    private V d(Object object, Object object2, Object object3, Object object4, Object object5) {
        int n2 = ju_0.e(object, object2, object3, object4, object5);
        ju_0 ju_02 = this;
        iZ cfr_ignored_0 = (iZ)super.i();
        ju_02 = this;
        int n3 = iZ.a((int)n2, (int)((iZ)super.i()).d.length);
        ju_02 = this;
        iz_0.c c2 = ((iZ)super.i()).d[n3];
        iz_0.c c3 = null;
        while (c2 != null) {
            if (c2.b == n2 && ju_0.a(c2, object, object2, object3, object4, object5)) {
                object = c2.getValue();
                ju_02 = this;
                ((iZ)super.i()).a(c2, n3, c3);
                return (V)object;
            }
            c3 = c2;
            c2 = c2.a;
        }
        return null;
    }

    private static int e(Object object, Object object2, Object object3, Object object4, Object object5) {
        int n2 = 0;
        if (object != null) {
            n2 = 0 ^ object.hashCode();
        }
        if (object2 != null) {
            n2 ^= object2.hashCode();
        }
        if (object3 != null) {
            n2 ^= object3.hashCode();
        }
        if (object4 != null) {
            n2 ^= object4.hashCode();
        }
        if (object5 != null) {
            n2 ^= object5.hashCode();
        }
        int n3 = n2;
        n2 = n3 + ~(n3 << 9);
        n2 ^= n2 >>> 14;
        n2 += n2 << 4;
        n2 ^= n2 >>> 10;
        return n2;
    }

    private static boolean a(iz_0.c<ij_1<? extends K>, V> object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        block2: {
            block7: {
                int n2;
                Object object7;
                block6: {
                    block5: {
                        block4: {
                            block3: {
                                object7 = object = ((iz_0.c)object).getKey();
                                if (((ij_1)object).a.length != 5) break block2;
                                n2 = 0;
                                object7 = object;
                                if (object2 == ((ij_1)object7).a[n2]) break block3;
                                if (object2 == null) break block2;
                                n2 = 0;
                                object7 = object;
                                if (!object2.equals(((ij_1)object7).a[n2])) break block2;
                            }
                            n2 = 1;
                            object7 = object;
                            if (object3 == ((ij_1)object7).a[n2]) break block4;
                            if (object3 == null) break block2;
                            n2 = 1;
                            object7 = object;
                            if (!object3.equals(((ij_1)object7).a[n2])) break block2;
                        }
                        n2 = 2;
                        object7 = object;
                        if (object4 == ((ij_1)object7).a[n2]) break block5;
                        if (object4 == null) break block2;
                        n2 = 2;
                        object7 = object;
                        if (!object4.equals(((ij_1)object7).a[n2])) break block2;
                    }
                    n2 = 3;
                    object7 = object;
                    if (object5 == ((ij_1)object7).a[n2]) break block6;
                    if (object5 == null) break block2;
                    n2 = 3;
                    object7 = object;
                    if (!object5.equals(((ij_1)object7).a[n2])) break block2;
                }
                n2 = 4;
                object7 = object;
                if (object6 == ((ij_1)object7).a[n2]) break block7;
                if (object6 == null) break block2;
                n2 = 4;
                object7 = object;
                if (!object6.equals(((ij_1)object7).a[n2])) break block2;
            }
            return true;
        }
        return false;
    }

    private boolean a(Object object) {
        Serializable serializable;
        boolean bl = false;
        Serializable serializable2 = serializable = this;
        fu_2 fu_22 = ((iZ)super.i()).c();
        while (fu_22.hasNext()) {
            int n2;
            serializable = serializable2 = (ij_1)fu_22.next();
            if (((ij_1)serializable2).a.length <= 0) continue;
            if (object == null) {
                n2 = 0;
                serializable = serializable2;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 0;
                serializable = serializable2;
                if (!object.equals(((ij_1)serializable).a[n2])) continue;
            }
            fu_22.remove();
            bl = true;
        }
        return bl;
    }

    private boolean e(Object object, Object object2) {
        Serializable serializable;
        boolean bl = false;
        ju_0 ju_02 = serializable = this;
        fu_2 fu_22 = ((iZ)super.i()).c();
        while (fu_22.hasNext()) {
            int n2;
            ij_1 ij_12 = (ij_1)fu_22.next();
            serializable = ij_12;
            if (ij_12.a.length < 2) continue;
            if (object == null) {
                n2 = 0;
                serializable = ij_12;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 0;
                serializable = ij_12;
                if (!object.equals(((ij_1)serializable).a[n2])) continue;
            }
            if (object2 == null) {
                n2 = 1;
                serializable = ij_12;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 1;
                serializable = ij_12;
                if (!object2.equals(((ij_1)serializable).a[n2])) continue;
            }
            fu_22.remove();
            bl = true;
        }
        return bl;
    }

    private boolean f(Object object, Object object2, Object object3) {
        Serializable serializable;
        boolean bl = false;
        ju_0 ju_02 = serializable = this;
        fu_2 fu_22 = ((iZ)super.i()).c();
        while (fu_22.hasNext()) {
            int n2;
            ij_1 ij_12 = (ij_1)fu_22.next();
            serializable = ij_12;
            if (ij_12.a.length < 3) continue;
            if (object == null) {
                n2 = 0;
                serializable = ij_12;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 0;
                serializable = ij_12;
                if (!object.equals(((ij_1)serializable).a[n2])) continue;
            }
            if (object2 == null) {
                n2 = 1;
                serializable = ij_12;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 1;
                serializable = ij_12;
                if (!object2.equals(((ij_1)serializable).a[n2])) continue;
            }
            if (object3 == null) {
                n2 = 2;
                serializable = ij_12;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 2;
                serializable = ij_12;
                if (!object3.equals(((ij_1)serializable).a[n2])) continue;
            }
            fu_22.remove();
            bl = true;
        }
        return bl;
    }

    private boolean f(Object object, Object object2, Object object3, Object object4) {
        Serializable serializable;
        boolean bl = false;
        ju_0 ju_02 = serializable = this;
        fu_2 fu_22 = ((iZ)super.i()).c();
        while (fu_22.hasNext()) {
            int n2;
            ij_1 ij_12 = (ij_1)fu_22.next();
            serializable = ij_12;
            if (ij_12.a.length < 4) continue;
            if (object == null) {
                n2 = 0;
                serializable = ij_12;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 0;
                serializable = ij_12;
                if (!object.equals(((ij_1)serializable).a[n2])) continue;
            }
            if (object2 == null) {
                n2 = 1;
                serializable = ij_12;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 1;
                serializable = ij_12;
                if (!object2.equals(((ij_1)serializable).a[n2])) continue;
            }
            if (object3 == null) {
                n2 = 2;
                serializable = ij_12;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 2;
                serializable = ij_12;
                if (!object3.equals(((ij_1)serializable).a[n2])) continue;
            }
            if (object4 == null) {
                n2 = 3;
                serializable = ij_12;
                if (((ij_1)serializable).a[n2] != null) continue;
            } else {
                n2 = 3;
                serializable = ij_12;
                if (!object4.equals(((ij_1)serializable).a[n2])) continue;
            }
            fu_22.remove();
            bl = true;
        }
        return bl;
    }

    private static void a(ij_1<?> ij_12) {
        if (ij_12 == null) {
            throw new NullPointerException("Key must not be null");
        }
    }

    private ju_0<K, V> a() {
        try {
            return (ju_0)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    private V a(ij_1<? extends K> ij_12, V v) {
        ju_0.a(ij_12);
        return super.put(ij_12, v);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void putAll(Map<? extends ij_1<? extends K>, ? extends V> mapToCopy) {
        void var1_1;
        for (ij_1<K> ij_12 : mapToCopy.keySet()) {
            ju_0.a(ij_12);
        }
        super.putAll(var1_1);
    }

    @Override
    public final fu_2<ij_1<? extends K>, V> c() {
        ju_0 ju_02 = this;
        return ((iZ)super.i()).c();
    }

    private iz_0<ij_1<? extends K>, V> b() {
        return (iZ)super.i();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = (Map)objectInputStream.readObject();
    }

    @Override
    public final /* synthetic */ Object put(Object object, Object object2) {
        Object object3 = object2;
        object2 = (ij_1)object;
        object = this;
        ju_0.a(object2);
        return super.put(object2, object3);
    }

    public final /* synthetic */ Object clone() {
        return this.a();
    }
}

