/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Bq$1
 *  org.valkyrienskies.core.impl.shadow.Bq$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.Bq;
import org.valkyrienskies.core.impl.shadow.bp_0;
import org.valkyrienskies.core.impl.shadow.bq_2;
import org.valkyrienskies.core.impl.shadow.br_0;
import org.valkyrienskies.core.impl.shadow.bs_0;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.ph_0;
import org.valkyrienskies.core.impl.shadow.zD;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Bq
 */
public final class bq_0
implements br_0 {
    private static bp_0 b = bp_0.FAILED;
    private static int c = bs_0.AVERAGE$139d6b26;
    public final bp_0 a;
    private final int d;
    private final zD e;

    public bq_0() {
        this.d = c;
        this.a = b;
        this.e = null;
    }

    private bq_0(int n2) {
        this.d = n2;
        this.a = b;
        this.e = new zD();
    }

    private bq_0(bp_0 bp_02) {
        this.a = bp_02;
        this.d = c;
        this.e = null;
    }

    public bq_0(bp_0 bp_02, int n2) {
        this.a = bp_02;
        this.d = n2;
        this.e = new zD();
    }

    private bq_0(zF zF2) {
        this.d = bs_0.RANDOM$139d6b26;
        this.a = b;
        this.e = new zD(zF2);
    }

    private bq_0(bp_0 bp_02, zF zF2) {
        this.a = bp_02;
        this.d = bs_0.RANDOM$139d6b26;
        this.e = new zD(zF2);
    }

    public final bp_0 a() {
        return this.a;
    }

    private int b() {
        return this.d;
    }

    @Override
    public final double[] a(double[] dArray) {
        Object[] objectArray = new Bq.a[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            objectArray[i2] = new Bq.a(dArray[i2], i2);
        }
        List<Integer> list = null;
        switch (Bq.1.a[this.a.ordinal()]) {
            case 1: {
                bq_0.a((bq_2.a_0[])objectArray, Double.POSITIVE_INFINITY);
                break;
            }
            case 2: {
                bq_0.a((bq_2.a_0[])objectArray, Double.NEGATIVE_INFINITY);
                break;
            }
            case 3: {
                objectArray = this.a((bq_2.a_0[])objectArray);
                break;
            }
            case 4: {
                list = bq_0.c((bq_2.a_0[])objectArray);
                break;
            }
            case 5: {
                list = bq_0.c((bq_2.a_0[])objectArray);
                if (list.size() <= 0) break;
                throw new ph_0();
            }
            default: {
                throw new oY();
            }
        }
        Arrays.sort(objectArray);
        dArray = new double[objectArray.length];
        int n2 = 1;
        Object object = objectArray[0];
        dArray[((Bq.a)object).b] = 1.0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        object = objectArray[0];
        arrayList.add(((Bq.a)object).b);
        for (int i3 = 1; i3 < objectArray.length; ++i3) {
            Object object2 = objectArray[i3];
            object = object2;
            object = objectArray[i3 - 1];
            if (Double.compare(((Bq.a)object2).a, ((Bq.a)object).a) > 0) {
                n2 = i3 + 1;
                if (arrayList.size() > 1) {
                    this.a(dArray, arrayList);
                }
                arrayList = new ArrayList<Integer>();
                object = objectArray[i3];
                arrayList.add(((Bq.a)object).b);
            } else {
                object = objectArray[i3];
                arrayList.add(((Bq.a)object).b);
            }
            object = objectArray[i3];
            dArray[((Bq.a)object).b] = n2;
        }
        if (arrayList.size() > 1) {
            this.a(dArray, arrayList);
        }
        if (this.a == bp_0.FIXED) {
            bq_0.b(dArray, list);
        }
        return dArray;
    }

    private bq_2.a_0[] a(bq_2.a_0[] a_0Array) {
        if (!bq_0.b(a_0Array)) {
            return a_0Array;
        }
        Bq.a[] aArray = new Bq.a[a_0Array.length];
        int n2 = 0;
        for (int i2 = 0; i2 < a_0Array.length; ++i2) {
            bq_2.a_0 a_02 = a_0Array[i2];
            if (Double.isNaN(((Bq.a)a_02).a)) {
                for (int i3 = i2 + 1; i3 < a_0Array.length; ++i3) {
                    bq_2.a_0 a_03 = a_0Array[i3];
                    a_02 = a_03;
                    a_02 = a_0Array[i3];
                    a_0Array[i3] = new Bq.a(((Bq.a)a_03).a, ((Bq.a)a_02).b - 1);
                }
                continue;
            }
            bq_2.a_0 a_04 = a_0Array[i2];
            a_02 = a_04;
            a_02 = a_0Array[i2];
            aArray[n2] = new Bq.a(((Bq.a)a_04).a, ((Bq.a)a_02).b);
            ++n2;
        }
        Bq.a[] aArray2 = new Bq.a[n2];
        System.arraycopy(aArray, 0, aArray2, 0, n2);
        return aArray2;
    }

    private static void a(bq_2.a_0[] a_0Array, double d2) {
        for (int i2 = 0; i2 < a_0Array.length; ++i2) {
            bq_2.a_0 a_02 = a_0Array[i2];
            if (!Double.isNaN(((Bq.a)a_02).a)) continue;
            a_02 = a_0Array[i2];
            a_0Array[i2] = new Bq.a(d2, ((Bq.a)a_02).b);
        }
    }

    private static boolean b(bq_2.a_0[] a_0Array) {
        for (int i2 = 0; i2 < a_0Array.length; ++i2) {
            bq_2.a_0 a_02 = a_0Array[i2];
            if (!Double.isNaN(((Bq.a)a_02).a)) continue;
            return true;
        }
        return false;
    }

    private void a(double[] dArray, List<Integer> iterator2) {
        double d2 = dArray[iterator2.get(0)];
        int n2 = iterator2.size();
        switch (Bq.1.b[this.d - 1]) {
            case 1: {
                bq_0.a(dArray, iterator2, (d2 * 2.0 + (double)n2 - 1.0) / 2.0);
                return;
            }
            case 2: {
                bq_0.a(dArray, iterator2, d2 + (double)n2 - 1.0);
                return;
            }
            case 3: {
                bq_0.a(dArray, iterator2, d2);
                return;
            }
            case 4: {
                iterator2 = iterator2.iterator();
                long l2 = BY.B(d2);
                while (iterator2.hasNext()) {
                    long l3 = l2;
                    dArray[iterator2.next().intValue()] = this.e.a(l3, l3 + (long)n2 - 1L);
                }
                break;
            }
            case 5: {
                iterator2 = iterator2.iterator();
                long l4 = BY.B(d2);
                int n3 = 0;
                while (iterator2.hasNext()) {
                    dArray[iterator2.next().intValue()] = l4 + (long)n3++;
                }
                break;
            }
            default: {
                throw new oY();
            }
        }
    }

    private static void a(double[] dArray, List<Integer> object, double d2) {
        object = object.iterator();
        while (object.hasNext()) {
            dArray[((Integer)object.next()).intValue()] = d2;
        }
    }

    private static void b(double[] dArray, List<Integer> object) {
        if (object.size() == 0) {
            return;
        }
        object = object.iterator();
        while (object.hasNext()) {
            dArray[((Integer)object.next()).intValue()] = Double.NaN;
        }
    }

    private static List<Integer> c(bq_2.a_0[] a_0Array) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i2 = 0; i2 < a_0Array.length; ++i2) {
            bq_2.a_0 a_02 = a_0Array[i2];
            if (!Double.isNaN(((Bq.a)a_02).a)) continue;
            arrayList.add(i2);
        }
        return arrayList;
    }
}

