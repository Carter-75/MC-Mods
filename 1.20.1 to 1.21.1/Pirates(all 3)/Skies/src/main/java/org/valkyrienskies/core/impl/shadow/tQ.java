/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.tJ;
import org.valkyrienskies.core.impl.shadow.tK;
import org.valkyrienskies.core.impl.shadow.tL;
import org.valkyrienskies.core.impl.shadow.tM;
import org.valkyrienskies.core.impl.shadow.tO;
import org.valkyrienskies.core.impl.shadow.tW;
import org.valkyrienskies.core.impl.shadow.tY;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zy_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class tQ<T extends tL>
extends tM<T> {
    private final int a;
    private final int b;
    private final zF c;
    private final int d;

    private tQ(int n2) {
        this(n2, -1);
    }

    private tQ(int n2, int n3) {
        this(n2, -1, new tY());
    }

    private tQ(int n2, int n3, tY tY2) {
        this(n2, n3, tY2, new zy_0());
    }

    private tQ(int n2, int n3, tW tW2, zy_0 zy_02) {
        this(n2, n3, tW2, zy_02, org.valkyrienskies.core.impl.shadow.tQ$a.LARGEST_VARIANCE$5922d8c5);
    }

    private tQ(int n2, int n3, tW tW2, zF zF2, int n4) {
        super(tW2);
        this.a = n2;
        this.b = n3;
        this.c = zF2;
        this.d = n4;
    }

    private int b() {
        return this.a;
    }

    private int c() {
        return this.b;
    }

    private zF d() {
        return this.c;
    }

    private int e() {
        return this.d;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final List<tJ<T>> a(Collection<T> collection) {
        double d2;
        ci_0.a(collection);
        if (collection.size() < this.a) {
            throw new pn_0(collection.size(), (Number)this.a, false);
        }
        Collection<T> collection2 = collection;
        tQ object4 = this;
        List<T> list = Collections.unmodifiableList(new ArrayList<T>(collection2));
        int n2 = list.size();
        Object object = new boolean[n2];
        List list2 = new ArrayList<tJ<T>>();
        int n3 = object4.c.nextInt(n2);
        Object object2 = (tL)list.get(n3);
        list2.add(new tJ((tL)object2));
        object[n3] = true;
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            double d3;
            if (i2 == n3) continue;
            double d4 = d3 = object4.a((tL)object2, (tL)list.get(i2));
            dArray[i2] = d4 * d4;
        }
        while (list2.size() < object4.a) {
            int n4;
            double d5 = 0.0;
            for (int i3 = 0; i3 < n2; ++i3) {
                if (object[i3]) continue;
                d5 += dArray[i3];
            }
            d2 = object4.c.nextDouble() * d5;
            int n5 = -1;
            double d6 = 0.0;
            for (n4 = 0; n4 < n2; ++n4) {
                double d7;
                if (object[n4]) continue;
                d6 += dArray[n4];
                if (!(d7 >= d2)) continue;
                n5 = n4;
                break;
            }
            if (n5 == -1) {
                for (n4 = n2 - 1; n4 >= 0; --n4) {
                    if (object[n4]) continue;
                    n5 = n4;
                    break;
                }
            }
            if (n5 < 0) break;
            tL tL2 = (tL)list.get(n5);
            list2.add(new tJ(tL2));
            object[n5] = true;
            if (list2.size() >= object4.a) continue;
            for (n5 = 0; n5 < n2; ++n5) {
                double d8;
                if (object[n5]) continue;
                double d9 = object4.a(tL2, (tL)list.get(n5));
                double d10 = d9 * d9;
                if (!(d8 < dArray[n5])) continue;
                dArray[n5] = d10;
            }
        }
        ArrayList<tJ<T>> arrayList = list2;
        int[] nArray = new int[collection.size()];
        this.a(arrayList, collection, nArray);
        int n6 = this.b < 0 ? Integer.MAX_VALUE : this.b;
        for (int i4 = 0; i4 < n6; ++i4) {
            boolean bl = false;
            ArrayList<tJ<T>> arrayList2 = new ArrayList<tJ<T>>();
            for (tJ tJ2 : arrayList) {
                void var9_22;
                Serializable serializable = tJ2;
                if (tJ2.b.isEmpty()) {
                    switch (1.a[this.d - 1]) {
                        case 1: {
                            Serializable serializable2 = arrayList;
                            tQ tQ2 = this;
                            double d11 = Double.NEGATIVE_INFINITY;
                            object = null;
                            list2 = serializable2.iterator();
                            while (list2.hasNext()) {
                                double d12;
                                serializable = serializable2 = (tJ)list2.next();
                                if (((tK)serializable2).b.isEmpty()) continue;
                                serializable = serializable2;
                                object2 = ((tJ)serializable).a;
                                AM aM = new AM();
                                serializable = serializable2;
                                for (tL tL3 : ((tK)serializable).b) {
                                    ((an_0)aM).a(tQ2.a(tL3, (tL)object2));
                                }
                                double d13 = ((an_0)aM).c();
                                if (!(d12 > d11)) continue;
                                d11 = d13;
                                object = serializable2;
                            }
                            if (object == null) {
                                throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                            }
                            serializable = object;
                            list2 = ((tK)serializable).b;
                            tL tL4 = (tL)list2.remove(tQ2.c.nextInt(list2.size()));
                            break;
                        }
                        case 2: {
                            ArrayList<tJ<T>> arrayList3 = arrayList;
                            tQ tQ3 = this;
                            int n7 = 0;
                            List list3 = null;
                            object = arrayList3.iterator();
                            while (object.hasNext()) {
                                list2 = (tK)object.next();
                                serializable = list2;
                                int n8 = ((tK)((Object)list2)).b.size();
                                if (n8 <= n7) continue;
                                n7 = n8;
                                list3 = list2;
                            }
                            if (list3 == null) {
                                throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                            }
                            serializable = list3;
                            object = ((tK)serializable).b;
                            tL tL5 = (tL)object.remove(tQ3.c.nextInt(object.size()));
                            break;
                        }
                        case 3: {
                            Object object5 = arrayList;
                            tQ tQ4 = this;
                            double d14 = Double.NEGATIVE_INFINITY;
                            object = null;
                            int n8 = -1;
                            object5 = object5.iterator();
                            while (object5.hasNext()) {
                                object2 = (tJ)object5.next();
                                serializable = object2;
                                tL tL6 = ((tJ)object2).a;
                                serializable = object2;
                                List list4 = ((tK)serializable).b;
                                for (int i5 = 0; i5 < list4.size(); ++i5) {
                                    double d15;
                                    d2 = tQ4.a((tL)list4.get(i5), tL6);
                                    if (!(d15 > d14)) continue;
                                    d14 = d2;
                                    object = object2;
                                    n8 = i5;
                                }
                            }
                            if (object == null) {
                                throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                            }
                            serializable = object;
                            tL tL7 = (tL)((tK)serializable).b.remove(n8);
                            break;
                        }
                        default: {
                            throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                        }
                    }
                    bl = true;
                } else {
                    tJ tJ3 = tJ2;
                    serializable = tJ3;
                    serializable = tJ2;
                    int n10 = ((tJ)serializable).a.a().length;
                    List list5 = tJ3.b;
                    double[] dArray2 = new double[n10];
                    object = list5.iterator();
                    while (object.hasNext()) {
                        list2 = (tL)object.next();
                        double[] dArray3 = list2.a();
                        for (int i6 = 0; i6 < dArray2.length; ++i6) {
                            int n9 = i6;
                            dArray2[n9] = dArray2[n9] + dArray3[i6];
                        }
                    }
                    int n11 = 0;
                    while (n11 < dArray2.length) {
                        int n12 = n11++;
                        dArray2[n12] = dArray2[n12] / (double)list5.size();
                    }
                    tO tO2 = new tO(dArray2);
                }
                arrayList2.add(new tJ((tL)var9_22));
            }
            int n13 = this.a(arrayList2, collection, nArray);
            arrayList = arrayList2;
            if (n13 != 0 || bl) continue;
            return arrayList;
        }
        return arrayList;
    }

    private int a(List<tJ<T>> list, Collection<T> object, int[] nArray) {
        int n2 = 0;
        int n3 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            tL tL2 = (tL)object.next();
            int n4 = this.a(list, tL2);
            if (n4 != nArray[n3]) {
                ++n2;
            }
            tJ<tL> tJ2 = list.get(n4);
            tJ2.a(tL2);
            nArray[n3++] = n4;
        }
        return n2;
    }

    private List<tJ<T>> b(Collection<T> collection) {
        collection = Collections.unmodifiableList(new ArrayList<T>(collection));
        int n2 = collection.size();
        boolean[] blArray = new boolean[n2];
        ArrayList<tJ<T>> arrayList = new ArrayList<tJ<T>>();
        int n3 = this.c.nextInt(n2);
        tL tL2 = (tL)collection.get(n3);
        arrayList.add(new tJ(tL2));
        blArray[n3] = true;
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2;
            if (i2 == n3) continue;
            double d3 = d2 = this.a(tL2, (tL)collection.get(i2));
            dArray[i2] = d3 * d3;
        }
        while (arrayList.size() < this.a) {
            int n4;
            double d4 = 0.0;
            for (int i3 = 0; i3 < n2; ++i3) {
                if (blArray[i3]) continue;
                d4 += dArray[i3];
            }
            double d5 = this.c.nextDouble() * d4;
            n3 = -1;
            double d6 = 0.0;
            for (n4 = 0; n4 < n2; ++n4) {
                double d7;
                if (blArray[n4]) continue;
                d6 += dArray[n4];
                if (!(d7 >= d5)) continue;
                n3 = n4;
                break;
            }
            if (n3 == -1) {
                for (n4 = n2 - 1; n4 >= 0; --n4) {
                    if (blArray[n4]) continue;
                    n3 = n4;
                    break;
                }
            }
            if (n3 < 0) break;
            tL2 = (tL)collection.get(n3);
            arrayList.add(new tJ(tL2));
            blArray[n3] = true;
            if (arrayList.size() >= this.a) continue;
            for (n3 = 0; n3 < n2; ++n3) {
                double d8;
                if (blArray[n3]) continue;
                double d9 = this.a(tL2, (tL)collection.get(n3));
                double d10 = d9 * d9;
                if (!(d8 < dArray[n3])) continue;
                dArray[n3] = d10;
            }
        }
        return arrayList;
    }

    private T c(Collection<tJ<T>> list) {
        tJ tJ2;
        double d2 = Double.NEGATIVE_INFINITY;
        tJ tJ3 = null;
        list = list.iterator();
        while (list.hasNext()) {
            double d3;
            tJ tJ4;
            tJ2 = tJ4 = (tJ)list.next();
            if (tJ4.b.isEmpty()) continue;
            tJ2 = tJ4;
            tL tL2 = tJ2.a;
            AM aM = new AM();
            tJ2 = tJ4;
            for (tL tL3 : tJ2.b) {
                ((an_0)aM).a(this.a(tL3, tL2));
            }
            double d4 = ((an_0)aM).c();
            if (!(d3 > d2)) continue;
            d2 = d4;
            tJ3 = tJ4;
        }
        if (tJ3 == null) {
            throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        tJ2 = tJ3;
        list = tJ2.b;
        return (T)((tL)list.remove(this.c.nextInt(list.size())));
    }

    private T d(Collection<? extends tK<T>> list) {
        int n2 = 0;
        tK tK2 = null;
        list = list.iterator();
        while (list.hasNext()) {
            tK tK3;
            tK tK4 = tK3 = (tK)list.next();
            int n3 = tK3.b.size();
            if (n3 <= n2) continue;
            n2 = n3;
            tK2 = tK3;
        }
        if (tK2 == null) {
            throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        tK tK5 = tK2;
        list = tK5.b;
        return (T)((tL)list.remove(this.c.nextInt(list.size())));
    }

    private T e(Collection<tJ<T>> object) {
        Object object2;
        double d2 = Double.NEGATIVE_INFINITY;
        tJ tJ2 = null;
        int n2 = -1;
        object = object.iterator();
        while (object.hasNext()) {
            tJ tJ3 = (tJ)object.next();
            object2 = tJ3;
            tL tL2 = tJ3.a;
            object2 = tJ3;
            object2 = ((tK)object2).b;
            for (int i2 = 0; i2 < object2.size(); ++i2) {
                double d3;
                double d4 = this.a((tL)object2.get(i2), tL2);
                if (!(d3 > d2)) continue;
                d2 = d4;
                tJ2 = tJ3;
                n2 = i2;
            }
        }
        if (tJ2 == null) {
            throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        object2 = tJ2;
        return (T)((tL)((tK)object2).b.remove(n2));
    }

    private int a(Collection<tJ<T>> object, T t) {
        double d2 = Double.MAX_VALUE;
        int n2 = 0;
        int n3 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            double d3;
            tJ tJ2 = (tJ)object.next();
            double d4 = this.a((tL)t, tJ2.a);
            if (d3 < d2) {
                d2 = d4;
                n3 = n2;
            }
            ++n2;
        }
        return n3;
    }

    private static tL a(Collection<T> collection, int n2) {
        double[] dArray = new double[n2];
        for (Object object : collection) {
            object = object.a();
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                int n3 = i2;
                dArray[n3] = dArray[n3] + object[i2];
            }
        }
        int n4 = 0;
        while (n4 < dArray.length) {
            int n5 = n4++;
            dArray[n5] = dArray[n5] / (double)collection.size();
        }
        return new tO(dArray);
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[org.valkyrienskies.core.impl.shadow.tQ$a.values$790d2c01().length];
            try {
                1.a[org.valkyrienskies.core.impl.shadow.tQ$a.LARGEST_VARIANCE$5922d8c5 - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[org.valkyrienskies.core.impl.shadow.tQ$a.LARGEST_POINTS_NUMBER$5922d8c5 - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[org.valkyrienskies.core.impl.shadow.tQ$a.FARTHEST_POINT$5922d8c5 - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a
    extends Enum<a> {
        public static final int LARGEST_VARIANCE$5922d8c5 = 1;
        public static final int LARGEST_POINTS_NUMBER$5922d8c5 = 2;
        public static final int FARTHEST_POINT$5922d8c5 = 3;
        public static final int ERROR$5922d8c5 = 4;
        private static final /* synthetic */ int[] $VALUES$672fd5c0;

        public static int[] values$790d2c01() {
            return (int[])$VALUES$672fd5c0.clone();
        }

        private a() {
        }

        static {
            $VALUES$672fd5c0 = new int[]{LARGEST_VARIANCE$5922d8c5, LARGEST_POINTS_NUMBER$5922d8c5, FARTHEST_POINT$5922d8c5, ERROR$5922d8c5};
        }
    }
}

