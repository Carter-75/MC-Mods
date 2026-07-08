/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.valkyrienskies.core.impl.shadow.BR;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pm_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.lf
 */
public final class lf_0 {
    private static AtomicReference<lf_0[][]> c = new AtomicReference<Object>(null);
    public final int a;
    public final int b;
    private final int[][] d;
    private final int[][] e;
    private final int[] f;
    private final int[][][] g;
    private final int[][][] h;

    private lf_0(int n2, int n3, lf_0 object, lf_0 lf_02) {
        int[][][] nArrayArray;
        int[] nArray;
        int n4;
        ArrayList<int[]> arrayList;
        ArrayList<Object> arrayList2;
        int[][][] nArrayArray2;
        Object object2;
        int n5;
        Object object3;
        int n6;
        int[][] nArray2;
        int n7;
        this.a = n2;
        this.b = n3;
        Object object4 = object;
        int n8 = n3;
        int n9 = n2;
        Object object5 = new int[n9 + 1][n8 + 1];
        if (n9 == 0) {
            Arrays.fill(object5[0], 1);
        } else {
            System.arraycopy(((lf_0)object4).d, 0, object5, 0, n9);
            object5[n9][0] = 1;
            for (n7 = 0; n7 < n8; ++n7) {
                object5[n9][n7 + 1] = object5[n9][n7] + object5[n9 - 1][n7 + 1];
            }
        }
        this.d = object5;
        object5 = lf_02;
        object4 = object;
        n8 = n3;
        n9 = n2;
        if (n9 == 0 || n8 == 0) {
            nArray2 = new int[1][n9];
        } else {
            n7 = ((lf_0)object4).e.length;
            n6 = object5.e.length;
            object3 = new int[n7 + n6][n9];
            for (n5 = 0; n5 < n7; ++n5) {
                System.arraycopy(((lf_0)object4).e[n5], 0, object3[n5], 0, n9 - 1);
            }
            for (n5 = 0; n5 < n6; ++n5) {
                System.arraycopy(object5.e[n5], 0, object3[n7 + n5], 0, n9);
                int[] nArray3 = object3[n7 + n5];
                int n10 = n9 - 1;
                nArray3[n10] = nArray3[n10] + 1;
            }
            nArray2 = object3;
        }
        this.e = nArray2;
        object5 = lf_02;
        object4 = object;
        n8 = n3;
        n9 = n2;
        if (n9 == 0 || n8 <= 1) {
            int[] nArray4 = new int[1];
            object2 = nArray4;
            nArray4[0] = 0;
        } else {
            n7 = ((lf_0)object4).f.length;
            n6 = object5.f.length;
            object3 = new int[n7 + n6];
            System.arraycopy(((lf_0)object4).f, 0, object3, 0, n7);
            for (n5 = 0; n5 < n6; ++n5) {
                object3[n7 + n5] = (int[])(((lf_0)object4).c() + object5.f[n5]);
            }
            object2 = object3;
        }
        Object object6 = this.f = object2;
        object5 = lf_02;
        object4 = object;
        n8 = n3;
        n9 = n2;
        if (n9 == 0 || n8 == 0) {
            int[][][] nArrayArray3 = new int[1][][];
            nArrayArray2 = nArrayArray3;
            nArrayArray3[0] = new int[][]{{1, 0, 0}};
        } else {
            n6 = ((lf_0)object4).g.length;
            int n11 = object5.g.length;
            int[][][] nArrayArray4 = new int[n6 + n11][][];
            System.arraycopy(((lf_0)object4).g, 0, nArrayArray4, 0, n6);
            for (int i2 = 0; i2 < n11; ++i2) {
                object4 = object5.g[i2];
                arrayList2 = new ArrayList<Object>(((Object)object4).length << 1);
                for (int i3 = 0; i3 < ((Object)object4).length; ++i3) {
                    arrayList2.add(new int[]{(int)object4[i3][0], object6[object4[i3][1]], n6 + object4[i3][2]});
                    arrayList2.add(new int[]{(int)object4[i3][0], n6 + object4[i3][1], object6[object4[i3][2]]});
                }
                arrayList = new ArrayList<int[]>(arrayList2.size());
                for (n4 = 0; n4 < arrayList2.size(); ++n4) {
                    int[] nArray5 = (int[])arrayList2.get(n4);
                    if (nArray5[0] <= 0) continue;
                    for (int i4 = n4 + 1; i4 < arrayList2.size(); ++i4) {
                        nArray = (int[])arrayList2.get(i4);
                        if (nArray5[1] != nArray[1] || nArray5[2] != nArray[2]) continue;
                        nArray5[0] = nArray5[0] + nArray[0];
                        nArray[0] = 0;
                    }
                    arrayList.add(nArray5);
                }
                ArrayList<int[]> arrayList3 = arrayList;
                nArrayArray4[n6 + i2] = (int[][])arrayList3.toArray((T[])new int[arrayList3.size()][]);
            }
            nArrayArray2 = nArrayArray4;
        }
        this.g = nArrayArray2;
        int[][] nArray6 = this.e;
        object6 = this.d;
        object5 = lf_02;
        object4 = object;
        n8 = n3;
        n9 = n2;
        if (n9 == 0 || n8 == 0) {
            int[][][] nArrayArray5 = new int[1][][];
            nArrayArray = nArrayArray5;
            nArrayArray5[0] = new int[][]{{1, 0}};
        } else {
            int n12 = ((lf_0)object4).h.length;
            int n13 = object5.h.length;
            int[][][] nArrayArray6 = new int[n12 + n13][][];
            System.arraycopy(((lf_0)object4).h, 0, nArrayArray6, 0, n12);
            for (int i5 = 0; i5 < n13; ++i5) {
                arrayList2 = new ArrayList();
                int[][] nArray7 = object5.h[i5];
                arrayList = (ArrayList<int[]>)nArray7;
                n4 = nArray7.length;
                for (int i6 = 0; i6 < n4; ++i6) {
                    Object object7 = arrayList[i6];
                    int[] nArray8 = new int[((Object)object7).length + 1];
                    nArray = nArray8;
                    nArray8[0] = (int)object7[0];
                    nArray[1] = (int)(object7[1] + true);
                    int[] nArray9 = new int[n9];
                    int[] nArray10 = nArray9;
                    nArray9[n9 - 1] = 1;
                    nArray[((Object)object7).length] = lf_0.a(n9, n8, (int[][])object6, nArray10);
                    for (n3 = 2; n3 < ((Object)object7).length; ++n3) {
                        nArray[n3] = lf_0.a((int)object7[n3], n9, object5.e, n9, n8, (int[][])object6);
                    }
                    Arrays.sort(nArray, 2, nArray.length);
                    arrayList2.add(nArray);
                    for (n3 = 2; n3 < ((Object)object7).length; ++n3) {
                        int[] nArray11 = new int[((Object)object7).length];
                        object = nArray11;
                        nArray11[0] = (int)object7[0];
                        object[1] = object7[1];
                        for (int i7 = 2; i7 < ((Object)object7).length; ++i7) {
                            object[i7] = lf_0.a((int)object7[i7], n9, object5.e, n9, n8, (int[][])object6);
                            if (i7 != n3) continue;
                            System.arraycopy(nArray6[object[i7]], 0, nArray10, 0, n9);
                            int n14 = n9 - 1;
                            nArray10[n14] = nArray10[n14] + 1;
                            object[i7] = lf_0.a(n9, n8, (int[][])object6, nArray10);
                        }
                        Arrays.sort((int[])object, 2, ((Object)object).length);
                        arrayList2.add(object);
                    }
                }
                arrayList = new ArrayList<int[]>(arrayList2.size());
                for (n4 = 0; n4 < arrayList2.size(); ++n4) {
                    int[] nArray12 = (int[])arrayList2.get(n4);
                    if (nArray12[0] <= 0) continue;
                    for (int i8 = n4 + 1; i8 < arrayList2.size(); ++i8) {
                        nArray = (int[])arrayList2.get(i8);
                        n2 = nArray12.length == nArray.length ? 1 : 0;
                        for (n3 = 1; n2 != 0 && n3 < nArray12.length; n2 &= nArray12[n3] == nArray[n3] ? 1 : 0, ++n3) {
                        }
                        if (n2 == 0) continue;
                        nArray12[0] = nArray12[0] + nArray[0];
                        nArray[0] = 0;
                    }
                    arrayList.add(nArray12);
                }
                ArrayList<int[]> arrayList4 = arrayList;
                nArrayArray6[n12 + i5] = (int[][])arrayList4.toArray((T[])new int[arrayList4.size()][]);
            }
            nArrayArray = nArrayArray6;
        }
        this.h = nArrayArray;
    }

    public static lf_0 a(int n2, int n3) {
        lf_0[][] lf_0Array = c.get();
        if (lf_0Array != null && lf_0Array.length > n2 && lf_0Array[n2].length > n3 && lf_0Array[n2][n3] != null) {
            return lf_0Array[n2][n3];
        }
        int n4 = BY.b(n2, lf_0Array == null ? 0 : lf_0Array.length);
        int n5 = BY.b(n3, lf_0Array == null ? 0 : lf_0Array[0].length);
        lf_0[][] lf_0Array2 = new lf_0[n4 + 1][n5 + 1];
        if (lf_0Array != null) {
            for (n5 = 0; n5 < lf_0Array.length; ++n5) {
                System.arraycopy(lf_0Array[n5], 0, lf_0Array2[n5], 0, lf_0Array[n5].length);
            }
        }
        for (n5 = 0; n5 <= n2 + n3; ++n5) {
            for (int i2 = BY.b(0, n5 - n2); i2 <= BY.a(n3, n5); ++i2) {
                int n6 = n5 - i2;
                if (lf_0Array2[n6][i2] != null) continue;
                lf_0 lf_02 = n6 == 0 ? null : lf_0Array2[n6 - 1][i2];
                lf_0 lf_03 = i2 == 0 ? null : lf_0Array2[n6][i2 - 1];
                lf_0Array2[n6][i2] = new lf_0(n6, i2, lf_02, lf_03);
            }
        }
        c.compareAndSet(lf_0Array, lf_0Array2);
        return lf_0Array2[n2][n3];
    }

    private static int[][] a(int n2, int n3, lf_0 lf_02) {
        int[][] nArray = new int[n2 + 1][n3 + 1];
        if (n2 == 0) {
            Arrays.fill(nArray[0], 1);
        } else {
            System.arraycopy(lf_02.d, 0, nArray, 0, n2);
            nArray[n2][0] = 1;
            for (int i2 = 0; i2 < n3; ++i2) {
                nArray[n2][i2 + 1] = nArray[n2][i2] + nArray[n2 - 1][i2 + 1];
            }
        }
        return nArray;
    }

    private static int[][] a(int n2, int n3, lf_0 lf_02, lf_0 lf_03) {
        int n4;
        if (n2 == 0 || n3 == 0) {
            return new int[1][n2];
        }
        n3 = lf_02.e.length;
        int n5 = lf_03.e.length;
        int[][] nArray = new int[n3 + n5][n2];
        for (n4 = 0; n4 < n3; ++n4) {
            System.arraycopy(lf_02.e[n4], 0, nArray[n4], 0, n2 - 1);
        }
        for (n4 = 0; n4 < n5; ++n4) {
            System.arraycopy(lf_03.e[n4], 0, nArray[n3 + n4], 0, n2);
            int[] nArray2 = nArray[n3 + n4];
            int n6 = n2 - 1;
            nArray2[n6] = nArray2[n6] + 1;
        }
        return nArray;
    }

    private static int[] b(int n2, int n3, lf_0 lf_02, lf_0 lf_03) {
        if (n2 == 0 || n3 <= 1) {
            return new int[]{0};
        }
        n2 = lf_02.f.length;
        n3 = lf_03.f.length;
        int[] nArray = new int[n2 + n3];
        System.arraycopy(lf_02.f, 0, nArray, 0, n2);
        for (int i2 = 0; i2 < n3; ++i2) {
            nArray[n2 + i2] = lf_02.c() + lf_03.f[i2];
        }
        return nArray;
    }

    private static int[][][] a(int n2, int n3, lf_0 lf_02, lf_0 lf_03, int[] nArray) {
        if (n2 == 0 || n3 == 0) {
            return new int[][][]{new int[][]{{1, 0, 0}}};
        }
        n2 = lf_02.g.length;
        n3 = lf_03.g.length;
        int[][][] nArrayArray = new int[n2 + n3][][];
        System.arraycopy(lf_02.g, 0, nArrayArray, 0, n2);
        for (int i2 = 0; i2 < n3; ++i2) {
            int[][] nArray2 = lf_03.g[i2];
            ArrayList<int[]> arrayList = new ArrayList<int[]>(nArray2.length << 1);
            for (int i3 = 0; i3 < nArray2.length; ++i3) {
                arrayList.add(new int[]{nArray2[i3][0], nArray[nArray2[i3][1]], n2 + nArray2[i3][2]});
                arrayList.add(new int[]{nArray2[i3][0], n2 + nArray2[i3][1], nArray[nArray2[i3][2]]});
            }
            ArrayList<int[]> arrayList2 = new ArrayList<int[]>(arrayList.size());
            for (int i4 = 0; i4 < arrayList.size(); ++i4) {
                int[] nArray3 = (int[])arrayList.get(i4);
                if (nArray3[0] <= 0) continue;
                for (int i5 = i4 + 1; i5 < arrayList.size(); ++i5) {
                    int[] nArray4 = (int[])arrayList.get(i5);
                    if (nArray3[1] != nArray4[1] || nArray3[2] != nArray4[2]) continue;
                    nArray3[0] = nArray3[0] + nArray4[0];
                    nArray4[0] = 0;
                }
                arrayList2.add(nArray3);
            }
            ArrayList<int[]> arrayList3 = arrayList2;
            nArrayArray[n2 + i2] = (int[][])arrayList3.toArray((T[])new int[arrayList3.size()][]);
        }
        return nArrayArray;
    }

    private static int[][][] a(int n2, int n3, lf_0 lf_02, lf_0 lf_03, int[][] nArray, int[][] nArray2) {
        if (n2 == 0 || n3 == 0) {
            return new int[][][]{new int[][]{{1, 0}}};
        }
        int n4 = lf_02.h.length;
        int n5 = lf_03.h.length;
        int[][][] nArrayArray = new int[n4 + n5][][];
        System.arraycopy(lf_02.h, 0, nArrayArray, 0, n4);
        for (int i2 = 0; i2 < n5; ++i2) {
            int n6;
            int[] nArray3;
            ArrayList<int[]> arrayList = new ArrayList<int[]>();
            for (int[] nArray4 : lf_03.h[i2]) {
                int[] nArray5 = new int[nArray4.length + 1];
                nArray3 = nArray5;
                nArray5[0] = nArray4[0];
                nArray3[1] = nArray4[1] + 1;
                int[] nArray6 = new int[n2];
                int[] nArray7 = nArray6;
                nArray6[n2 - 1] = 1;
                nArray3[nArray4.length] = lf_0.a(n2, n3, nArray, nArray7);
                for (n6 = 2; n6 < nArray4.length; ++n6) {
                    nArray3[n6] = lf_0.a(nArray4[n6], n2, lf_03.e, n2, n3, nArray);
                }
                Arrays.sort(nArray3, 2, nArray3.length);
                arrayList.add(nArray3);
                for (n6 = 2; n6 < nArray4.length; ++n6) {
                    int[] nArray8 = new int[nArray4.length];
                    nArray3 = nArray8;
                    nArray8[0] = nArray4[0];
                    nArray3[1] = nArray4[1];
                    for (int i3 = 2; i3 < nArray4.length; ++i3) {
                        nArray3[i3] = lf_0.a(nArray4[i3], n2, lf_03.e, n2, n3, nArray);
                        if (i3 != n6) continue;
                        System.arraycopy(nArray2[nArray3[i3]], 0, nArray7, 0, n2);
                        int n7 = n2 - 1;
                        nArray7[n7] = nArray7[n7] + 1;
                        nArray3[i3] = lf_0.a(n2, n3, nArray, nArray7);
                    }
                    Arrays.sort(nArray3, 2, nArray3.length);
                    arrayList.add(nArray3);
                }
            }
            Object object = new ArrayList(arrayList.size());
            for (int i4 = 0; i4 < arrayList.size(); ++i4) {
                int[] nArray9 = (int[])arrayList.get(i4);
                if (nArray9[0] <= 0) continue;
                for (int i5 = i4 + 1; i5 < arrayList.size(); ++i5) {
                    nArray3 = (int[])arrayList.get(i5);
                    boolean bl = nArray9.length == nArray3.length;
                    for (n6 = 1; bl && n6 < nArray9.length; bl &= nArray9[n6] == nArray3[n6], ++n6) {
                    }
                    if (!bl) continue;
                    nArray9[0] = nArray9[0] + nArray3[0];
                    nArray3[0] = 0;
                }
                object.add(nArray9);
            }
            Object object2 = object;
            nArrayArray[n4 + i2] = (int[][])object2.toArray((T[])new int[object2.size()][]);
        }
        return nArrayArray;
    }

    public final int a(int ... nArray) {
        lf_0 lf_02 = this;
        if (nArray.length != lf_02.a) {
            lf_02 = this;
            throw new oS(nArray.length, lf_02.a);
        }
        return lf_0.a(this.a, this.b, this.d, nArray);
    }

    private static int a(int n2, int n3, int[][] nArray, int ... nArray2) {
        int n4 = 0;
        int n5 = n3;
        int n6 = 0;
        --n2;
        while (n2 >= 0) {
            int n7 = nArray2[n2];
            if ((n6 += n7) > n3) {
                throw new pm_0(n6, (Number)n3, true);
            }
            while (n7-- > 0) {
                n4 += nArray[n2][n5--];
            }
            --n2;
        }
        return n4;
    }

    private static int a(int n2, int n3, int[][] nArray, int n4, int n5, int[][] nArray2) {
        int[] nArray3 = new int[n4];
        System.arraycopy(nArray[n2], 0, nArray3, 0, BY.a(n3, n4));
        return lf_0.a(n4, n5, nArray2, nArray3);
    }

    private int[] a(int n2) {
        return this.e[n2];
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.d[this.a][this.b];
    }

    public final void a(double d2, double[] dArray, int n2, double d3, double[] dArray2, int n3, double[] dArray3, int n4) {
        for (n2 = 0; n2 < this.c(); ++n2) {
            dArray3[n2 + 0] = ch_0.a(d2, dArray[n2 + 0], d3, dArray2[n2 + 0]);
        }
    }

    public final void a(double d2, double[] dArray, int n2, double d3, double[] dArray2, int n3, double d4, double[] dArray3, int n4, double[] dArray4, int n5) {
        for (n2 = 0; n2 < this.c(); ++n2) {
            dArray4[n2 + 0] = ch_0.a(d2, dArray[n2 + 0], d3, dArray2[n2 + 0], d4, dArray3[n2 + 0]);
        }
    }

    public final void a(double d2, double[] dArray, int n2, double d3, double[] dArray2, int n3, double d4, double[] dArray3, int n4, double d5, double[] dArray4, int n5, double[] dArray5, int n6) {
        for (n2 = 0; n2 < this.c(); ++n2) {
            dArray5[n2 + 0] = ch_0.a(d2, dArray[n2 + 0], d3, dArray2[n2 + 0], d4, dArray3[n2 + 0], d5, dArray4[n2 + 0]);
        }
    }

    public final void a(double[] dArray, int n2, double[] dArray2, int n3, double[] dArray3, int n4) {
        for (n2 = 0; n2 < this.c(); ++n2) {
            dArray3[n2 + 0] = dArray[n2 + 0] + dArray2[n3 + n2];
        }
    }

    public final void b(double[] dArray, int n2, double[] dArray2, int n3, double[] dArray3, int n4) {
        for (n2 = 0; n2 < this.c(); ++n2) {
            dArray3[n2 + 0] = dArray[n2 + 0] - dArray2[n3 + n2];
        }
    }

    public final void c(double[] dArray, int n2, double[] dArray2, int n3, double[] dArray3, int n4) {
        for (int i2 = 0; i2 < this.g.length; ++i2) {
            int[][] nArray = this.g[i2];
            double d2 = 0.0;
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                d2 += (double)nArray[i3][0] * dArray[n2 + nArray[i3][1]] * dArray2[n3 + nArray[i3][2]];
            }
            dArray3[n4 + i2] = d2;
        }
    }

    public final void a(double[] dArray, int n2, double[] dArray2, double[] dArray3, int n3) {
        double[] dArray4 = new double[this.c()];
        this.a(dArray2, n2, -1, dArray4, 0);
        this.c(dArray, n2, dArray4, 0, dArray3, 0);
    }

    public final void d(double[] dArray, int n2, double[] dArray2, int n3, double[] dArray3, int n4) {
        double d2 = BY.g(dArray[0], dArray2[0]);
        double d3 = BY.A((dArray[0] - d2) / dArray2[0]);
        dArray3[0] = d2;
        for (n2 = 1; n2 < this.c(); ++n2) {
            dArray3[n2 + 0] = dArray[n2 + 0] - d3 * dArray2[n2 + 0];
        }
    }

    public final void a(double d2, double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        if (d2 == 0.0) {
            if (dArray[0] == 0.0) {
                dArray3[0] = 1.0;
                double d3 = Double.POSITIVE_INFINITY;
                for (int i2 = 1; i2 < dArray3.length; ++i2) {
                    dArray3[i2] = d3 = -d3;
                }
            } else if (dArray[0] < 0.0) {
                Arrays.fill(dArray3, Double.NaN);
            }
        } else {
            dArray3[0] = BY.a(d2, dArray[0]);
            double d4 = BY.k(d2);
            for (int i3 = 1; i3 < dArray3.length; ++i3) {
                dArray3[i3] = d4 * dArray3[i3 - 1];
            }
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void a(double[] dArray, int n2, double d2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double d3 = BY.a(dArray[0], d2 - (double)this.b);
        for (int i2 = this.b; i2 > 0; --i2) {
            dArray3[i2] = d3;
            d3 *= dArray[0];
        }
        dArray3[0] = d3;
        double d4 = d2;
        for (n3 = 1; n3 <= this.b; ++n3) {
            int n4 = n3;
            dArray3[n4] = dArray3[n4] * d4;
            d4 *= d2 - (double)n3;
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void a(double[] dArray, int n2, int n3, double[] dArray2, int n4) {
        if (n3 == 0) {
            dArray2[0] = 1.0;
            Arrays.fill(dArray2, 1, 0 + this.c(), 0.0);
            return;
        }
        double[] dArray3 = new double[1 + this.b];
        if (n3 > 0) {
            int n5 = BY.a(this.b, n3);
            double d2 = BY.a(dArray[n2], n3 - n5);
            for (int i2 = n5; i2 > 0; --i2) {
                dArray3[i2] = d2;
                d2 *= dArray[n2];
            }
            dArray3[0] = d2;
        } else {
            double d3 = 1.0 / dArray[n2];
            double d4 = BY.a(d3, -n3);
            for (int i3 = 0; i3 <= this.b; ++i3) {
                dArray3[i3] = d4;
                d4 *= d3;
            }
        }
        double d5 = n3;
        for (int i4 = 1; i4 <= this.b; ++i4) {
            int n6 = i4;
            dArray3[n6] = dArray3[n6] * d5;
            d5 *= (double)(n3 - i4);
        }
        this.b(dArray, n2, dArray3, dArray2, 0);
    }

    public final void e(double[] dArray, int n2, double[] dArray2, int n3, double[] dArray3, int n4) {
        double[] dArray4 = new double[this.c()];
        this.c(dArray, 0, dArray4, 0);
        dArray = new double[this.c()];
        this.c(dArray4, 0, dArray2, 0, dArray, 0);
        this.a(dArray, 0, dArray3, 0);
    }

    public final void b(double[] dArray, int n2, int n3, double[] dArray2, int n4) {
        double d2;
        double[] dArray3 = new double[1 + this.b];
        if (n3 == 2) {
            dArray3[0] = BY.a(dArray[0]);
            d2 = 0.5 / dArray3[0];
        } else if (n3 == 3) {
            dArray3[0] = BY.t(dArray[0]);
            d2 = 1.0 / (3.0 * dArray3[0] * dArray3[0]);
        } else {
            dArray3[0] = BY.a(dArray[0], 1.0 / (double)n3);
            d2 = 1.0 / ((double)n3 * BY.a(dArray3[0], n3 - 1));
        }
        double d3 = 1.0 / (double)n3;
        double d4 = 1.0 / dArray[0];
        for (n3 = 1; n3 <= this.b; ++n3) {
            dArray3[n3] = d2;
            d2 *= d4 * (d3 - (double)n3);
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void a(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        Arrays.fill(dArray3, BY.i(dArray[0]));
        this.b(dArray, 0, dArray3, dArray2, n3);
    }

    public final void b(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.j(dArray[0]);
        Arrays.fill(dArray4, 1, 1 + this.b, BY.i(dArray[0]));
        this.b(dArray, 0, dArray4, dArray2, 0);
    }

    public final void c(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.k(dArray[n2]);
        if (this.b > 0) {
            double d2;
            double d3 = d2 = 1.0 / dArray[n2];
            for (int i2 = 1; i2 <= this.b; ++i2) {
                dArray4[i2] = d3;
                d3 *= (double)(-i2) * d2;
            }
        }
        this.b(dArray, n2, dArray4, dArray2, 0);
    }

    public final void d(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.l(dArray[0]);
        if (this.b > 0) {
            double d2;
            double d3 = d2 = 1.0 / (1.0 + dArray[0]);
            for (n3 = 1; n3 <= this.b; ++n3) {
                dArray4[n3] = d3;
                d3 *= (double)(-n3) * d2;
            }
        }
        this.b(dArray, 0, dArray4, dArray2, 0);
    }

    public final void e(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.m(dArray[0]);
        if (this.b > 0) {
            double d2 = 1.0 / dArray[0];
            double d3 = d2 / BY.k(10.0);
            for (n3 = 1; n3 <= this.b; ++n3) {
                dArray4[n3] = d3;
                d3 *= (double)(-n3) * d2;
            }
        }
        this.b(dArray, 0, dArray4, dArray2, 0);
    }

    public final void f(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.o(dArray[0]);
        if (this.b > 0) {
            dArray4[1] = -BY.n(dArray[0]);
            for (n3 = 2; n3 <= this.b; ++n3) {
                dArray4[n3] = -dArray4[n3 - 2];
            }
        }
        this.b(dArray, 0, dArray4, dArray2, 0);
    }

    public final void g(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.n(dArray[0]);
        if (this.b > 0) {
            dArray4[1] = BY.o(dArray[0]);
            for (n3 = 2; n3 <= this.b; ++n3) {
                dArray4[n3] = -dArray4[n3 - 2];
            }
        }
        this.b(dArray, 0, dArray4, dArray2, 0);
    }

    public final void h(double[] dArray, int n2, double[] dArray2, int n3) {
        double d2;
        double[] dArray3 = new double[1 + this.b];
        dArray3[0] = d2 = BY.p(dArray[0]);
        if (this.b > 0) {
            double[] dArray4 = new double[this.b + 2];
            double[] dArray5 = dArray4;
            dArray4[1] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            for (int i2 = 1; i2 <= this.b; ++i2) {
                double d5 = 0.0;
                dArray5[i2 + 1] = (double)i2 * dArray5[i2];
                for (int i3 = i2 + 1; i3 >= 0; i3 -= 2) {
                    d5 = d5 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(i3 - 3) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d5 *= d2;
                }
                dArray3[i2] = d5;
            }
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void i(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double d2 = dArray[0];
        dArray3[0] = BY.s(d2);
        if (this.b > 0) {
            double[] dArray4 = new double[this.b];
            double[] dArray5 = dArray4;
            dArray4[0] = -1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            double d5 = 1.0 / (1.0 - d4);
            double d6 = BY.a(d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= this.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)(i2 - 1) * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(2 * i2 - i3) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d5) * d7;
            }
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void j(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double d2 = dArray[0];
        dArray3[0] = BY.r(d2);
        if (this.b > 0) {
            double[] dArray4 = new double[this.b];
            double[] dArray5 = dArray4;
            dArray4[0] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            double d5 = 1.0 / (1.0 - d4);
            double d6 = BY.a(d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= this.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)(i2 - 1) * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(2 * i2 - i3) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d5) * d7;
            }
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void k(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double d2 = dArray[0];
        dArray3[0] = BY.q(d2);
        if (this.b > 0) {
            double d3;
            double[] dArray4 = new double[this.b];
            double[] dArray5 = dArray4;
            dArray4[0] = 1.0;
            double d4 = d2;
            double d5 = d4 * d4;
            double d6 = d3 = 1.0 / (d5 + 1.0);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= this.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)(-i2) * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d5 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(i3 - 1 - 2 * i2) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d3) * d7;
            }
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void f(double[] dArray, int n2, double[] dArray2, int n3, double[] dArray3, int n4) {
        double[] dArray4 = new double[this.c()];
        this.c(dArray2, 0, dArray2, 0, dArray4, 0);
        double[] dArray5 = new double[this.c()];
        this.c(dArray, 0, dArray, 0, dArray5, 0);
        this.a(dArray4, 0, dArray5, 0, dArray5, 0);
        this.b(dArray5, 0, 2, dArray4, 0);
        if (dArray2[0] >= 0.0) {
            this.a(dArray4, 0, dArray2, 0, dArray5, 0);
            this.a(dArray, 0, dArray5, dArray4, 0);
            this.k(dArray4, 0, dArray5, 0);
            for (int i2 = 0; i2 < dArray5.length; ++i2) {
                dArray3[i2 + 0] = 2.0 * dArray5[i2];
            }
        } else {
            this.b(dArray4, 0, dArray2, 0, dArray5, 0);
            this.a(dArray, 0, dArray5, dArray4, 0);
            this.k(dArray4, 0, dArray5, 0);
            dArray3[0] = (dArray5[0] <= 0.0 ? -Math.PI : Math.PI) - 2.0 * dArray5[0];
            for (int i3 = 1; i3 < dArray5.length; ++i3) {
                dArray3[i3 + 0] = -2.0 * dArray5[i3];
            }
        }
        dArray3[0] = BY.b(dArray[0], dArray2[0]);
    }

    public final void l(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.b(dArray[0]);
        if (this.b > 0) {
            dArray4[1] = BY.c(dArray[0]);
            for (n3 = 2; n3 <= this.b; ++n3) {
                dArray4[n3] = dArray4[n3 - 2];
            }
        }
        this.b(dArray, 0, dArray4, dArray2, 0);
    }

    public final void m(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double[] dArray4 = dArray3;
        dArray3[0] = BY.c(dArray[0]);
        if (this.b > 0) {
            dArray4[1] = BY.b(dArray[0]);
            for (n3 = 2; n3 <= this.b; ++n3) {
                dArray4[n3] = dArray4[n3 - 2];
            }
        }
        this.b(dArray, 0, dArray4, dArray2, 0);
    }

    public final void n(double[] dArray, int n2, double[] dArray2, int n3) {
        double d2;
        double[] dArray3 = new double[1 + this.b];
        dArray3[0] = d2 = BY.d(dArray[0]);
        if (this.b > 0) {
            double[] dArray4 = new double[this.b + 2];
            double[] dArray5 = dArray4;
            dArray4[1] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            for (int i2 = 1; i2 <= this.b; ++i2) {
                double d5 = 0.0;
                dArray5[i2 + 1] = (double)(-i2) * dArray5[i2];
                for (int i3 = i2 + 1; i3 >= 0; i3 -= 2) {
                    d5 = d5 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] - (double)(i3 - 3) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d5 *= d2;
                }
                dArray3[i2] = d5;
            }
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void o(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double d2 = dArray[0];
        dArray3[0] = BY.e(d2);
        if (this.b > 0) {
            double[] dArray4 = new double[this.b];
            double[] dArray5 = dArray4;
            dArray4[0] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            double d5 = 1.0 / (d4 - 1.0);
            double d6 = BY.a(d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= this.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)(1 - i2) * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(1 - i3) * dArray5[i3 - 1] + (double)(i3 - 2 * i2) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = -dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d5) * d7;
            }
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void p(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double d2 = dArray[0];
        dArray3[0] = BY.f(d2);
        if (this.b > 0) {
            double[] dArray4 = new double[this.b];
            double[] dArray5 = dArray4;
            dArray4[0] = 1.0;
            double d3 = d2;
            double d4 = d3 * d3;
            double d5 = 1.0 / (d4 + 1.0);
            double d6 = BY.a(d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= this.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)(1 - i2) * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d4 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(i3 - 2 * i2) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d5) * d7;
            }
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void q(double[] dArray, int n2, double[] dArray2, int n3) {
        double[] dArray3 = new double[1 + this.b];
        double d2 = dArray[0];
        dArray3[0] = BY.g(d2);
        if (this.b > 0) {
            double d3;
            double[] dArray4 = new double[this.b];
            double[] dArray5 = dArray4;
            dArray4[0] = 1.0;
            double d4 = d2;
            double d5 = d4 * d4;
            double d6 = d3 = 1.0 / (1.0 - d5);
            dArray3[1] = d6 * dArray5[0];
            for (int i2 = 2; i2 <= this.b; ++i2) {
                double d7 = 0.0;
                dArray5[i2 - 1] = (double)i2 * dArray5[i2 - 2];
                for (int i3 = i2 - 1; i3 >= 0; i3 -= 2) {
                    d7 = d7 * d5 + dArray5[i3];
                    if (i3 > 2) {
                        dArray5[i3 - 2] = (double)(i3 - 1) * dArray5[i3 - 1] + (double)(2 * i2 - i3 + 1) * dArray5[i3 - 3];
                        continue;
                    }
                    if (i3 != 2) continue;
                    dArray5[0] = dArray5[1];
                }
                if ((i2 & 1) == 0) {
                    d7 *= d2;
                }
                dArray3[i2] = (d6 *= d3) * d7;
            }
        }
        this.b(dArray, 0, dArray3, dArray2, 0);
    }

    public final void b(double[] dArray, int n2, double[] dArray2, double[] dArray3, int n3) {
        for (int i2 = 0; i2 < this.h.length; ++i2) {
            int[][] nArray = this.h[i2];
            double d2 = 0.0;
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                int[] nArray2 = nArray[i3];
                double d3 = (double)nArray2[0] * dArray2[nArray2[1]];
                for (int i4 = 2; i4 < nArray2.length; ++i4) {
                    d3 *= dArray[n2 + nArray2[i4]];
                }
                d2 += d3;
            }
            dArray3[n3 + i2] = d2;
        }
    }

    public final double a(double[] dArray, int n2, double ... dArray2) {
        double d2 = 0.0;
        for (n2 = this.c() - 1; n2 >= 0; --n2) {
            int n3 = n2;
            Object object = this;
            object = ((lf_0)object).e[n3];
            double d3 = dArray[n2 + 0];
            for (n3 = 0; n3 < ((Object)object).length; ++n3) {
                if (object[n3] <= 0) continue;
                try {
                    d3 *= BY.a(dArray2[n3], (int)object[n3]) / (double)BR.a((int)object[n3]);
                    continue;
                }
                catch (pj_0 pj_02) {
                    throw new oY(pj_02);
                }
            }
            d2 += d3;
        }
        return d2;
    }

    public final void a(lf_0 lf_02) {
        if (this.a != lf_02.a) {
            throw new oS(this.a, lf_02.a);
        }
        if (this.b != lf_02.b) {
            throw new oS(this.b, lf_02.b);
        }
    }
}

