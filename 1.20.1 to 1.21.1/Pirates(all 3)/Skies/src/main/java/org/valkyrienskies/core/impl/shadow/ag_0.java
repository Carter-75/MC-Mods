/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.ab_0;
import org.valkyrienskies.core.impl.shadow.ac_0;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ag
 */
@Deprecated
public final class ag_0<T extends ac_0<T>> {
    private final Random a;
    private final int b;

    private ag_0(Random random) {
        this(random, org.valkyrienskies.core.impl.shadow.Ag$a.LARGEST_VARIANCE$338d5e9a);
    }

    private ag_0(Random random, int n2) {
        this.a = random;
        this.b = n2;
    }

    private List<ab_0<T>> a(Collection<T> collection, int n2, int n3, int n4) {
        Object object = null;
        double d2 = Double.POSITIVE_INFINITY;
        for (int i2 = 0; i2 < n3; ++i2) {
            Object object2;
            Object object3;
            Object object4;
            double d3;
            int n5;
            int n6 = n4;
            int n7 = n2;
            Collection<T> collection2 = collection;
            Object object5 = this;
            ci_0.a(collection2);
            if (collection2.size() < n7) {
                throw new pn_0(collection2.size(), (Number)n7, false);
            }
            Random random = ((ag_0)object5).a;
            int n8 = n7;
            Object object6 = collection2;
            Object object7 = Collections.unmodifiableList(new ArrayList<T>(object6));
            int n9 = object7.size();
            Object object8 = new boolean[n9];
            Object object9 = new ArrayList<ab_0<T>>();
            int n10 = random.nextInt(n9);
            Object object10 = (ac_0)object7.get(n10);
            object9.add(new ab_0<ac_0>((ac_0)object10));
            object8[n10] = true;
            Object object11 = new double[n9];
            for (n5 = 0; n5 < n9; ++n5) {
                if (n5 == n10) continue;
                double d4 = d3 = object10.a(object7.get(n5));
                object11[n5] = d4 * d4;
            }
            while (object9.size() < n8) {
                int n11;
                double d5 = 0.0;
                for (int i3 = 0; i3 < n9; ++i3) {
                    if (object8[i3]) continue;
                    d5 += object11[i3];
                }
                double d6 = random.nextDouble() * d5;
                n7 = -1;
                double d7 = 0.0;
                for (n11 = 0; n11 < n9; ++n11) {
                    double d8;
                    if (object8[n11]) continue;
                    d7 += object11[n11];
                    if (!(d8 >= d6)) continue;
                    n7 = n11;
                    break;
                }
                if (n7 == -1) {
                    for (n11 = n9 - 1; n11 >= 0; --n11) {
                        if (object8[n11]) continue;
                        n7 = n11;
                        break;
                    }
                }
                if (n7 < 0) break;
                object4 = (ac_0)object7.get(n7);
                object9.add(new ab_0<int[]>((int[])object4));
                object8[n7] = true;
                if (object9.size() >= n8) continue;
                for (n7 = 0; n7 < n9; ++n7) {
                    double d9;
                    if (object8[n7]) continue;
                    double d10 = object4.a(object7.get(n7));
                    double d11 = d10 * d10;
                    if (!(d9 < object11[n7])) continue;
                    object11[n7] = d11;
                }
            }
            ArrayList<ab_0<T>> arrayList = object9;
            object4 = new int[collection2.size()];
            ag_0.a(arrayList, collection2, (int[])object4);
            n6 = n6 < 0 ? Integer.MAX_VALUE : n6;
            for (int i4 = 0; i4 < n6; ++i4) {
                boolean bl = false;
                object3 = new ArrayList<ab_0<T>>();
                Iterator iterator2 = arrayList.iterator();
                while (iterator2.hasNext()) {
                    Object object12;
                    object2 = object12 = (ab_0)iterator2.next();
                    if (((ab_0)object12).a.isEmpty()) {
                        switch (1.a[((ag_0)object5).b - 1]) {
                            case 1: {
                                object12 = arrayList;
                                Object object13 = object5;
                                double d12 = Double.NEGATIVE_INFINITY;
                                Object object14 = null;
                                object8 = object12.iterator();
                                while (object8.hasNext()) {
                                    double d13;
                                    object2 = object9 = (ab_0)object8.next();
                                    if (((ab_0)object9).a.isEmpty()) continue;
                                    object2 = object9;
                                    Object t = ((ab_0)object2).b;
                                    object10 = new AM();
                                    object2 = object9;
                                    for (ac_0 ac_02 : ((ab_0)object2).a) {
                                        ((an_0)object10).a(ac_02.a(t));
                                    }
                                    double d14 = ((an_0)object10).c();
                                    if (!(d13 > d12)) continue;
                                    d12 = d14;
                                    object14 = object9;
                                }
                                if (object14 == null) {
                                    throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                                }
                                object2 = object14;
                                object8 = ((ab_0)object2).a;
                                object12 = (ac_0)object8.remove(((ag_0)object13).a.nextInt(object8.size()));
                                break;
                            }
                            case 2: {
                                object12 = arrayList;
                                Object object13 = object5;
                                int n12 = 0;
                                object7 = null;
                                Object object14 = object12.iterator();
                                while (object14.hasNext()) {
                                    object2 = object8 = (ab_0)object14.next();
                                    int n13 = ((ab_0)object8).a.size();
                                    if (n13 <= n12) continue;
                                    n12 = n13;
                                    object7 = object8;
                                }
                                if (object7 == null) {
                                    throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                                }
                                object2 = object7;
                                object14 = ((ab_0)object2).a;
                                object12 = (ac_0)object14.remove(((ag_0)object13).a.nextInt(object14.size()));
                                break;
                            }
                            case 3: {
                                Object object13 = arrayList;
                                double d15 = Double.NEGATIVE_INFINITY;
                                Object object14 = null;
                                int n14 = -1;
                                object9 = object13.iterator();
                                while (object9.hasNext()) {
                                    ab_0 ab_02 = (ab_0)object9.next();
                                    object2 = ab_02;
                                    object10 = ab_02.b;
                                    object2 = ab_02;
                                    object11 = ((ab_0)object2).a;
                                    for (n5 = 0; n5 < object11.size(); ++n5) {
                                        double d16;
                                        d3 = ((ac_0)object11.get(n5)).a(object10);
                                        if (!(d16 > d15)) continue;
                                        d15 = d3;
                                        object14 = ab_02;
                                        n14 = n5;
                                    }
                                }
                                if (object14 == null) {
                                    throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                                }
                                object2 = object14;
                                object12 = (ac_0)((ab_0)object2).a.remove(n14);
                                break;
                            }
                            default: {
                                throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                            }
                        }
                        bl = true;
                    } else {
                        ab_0 ab_03 = object12;
                        object2 = ab_03;
                        object2 = object12;
                        object12 = (ac_0)ab_03.b.a(((ab_0)object2).a);
                    }
                    object3.add(new ab_0<Object>(object12));
                }
                int n15 = ag_0.a(object3, collection2, (int[])object4);
                arrayList = object3;
                if (n15 == 0 && !bl) break;
            }
            object5 = arrayList;
            double d17 = 0.0;
            Iterator iterator3 = object5.iterator();
            while (iterator3.hasNext()) {
                object4 = (ab_0)iterator3.next();
                if (((ab_0)object2).a.isEmpty()) continue;
                object2 = object4;
                Object t = ((ab_0)object4).b;
                object6 = new AM();
                object2 = object4;
                object4 = ((ab_0)object4).a.iterator();
                while (object4.hasNext()) {
                    object3 = (ac_0)object4.next();
                    ((an_0)object6).a(object3.a(t));
                }
                d17 += ((an_0)object6).c();
            }
            if (!(d17 <= d2)) continue;
            object = object5;
            d2 = d17;
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private List<ab_0<T>> a(Collection<T> collection, int n2, int n3) {
        ci_0.a(collection);
        if (collection.size() < n2) {
            throw new pn_0(collection.size(), (Number)n2, false);
        }
        List<ab_0<T>> list = ag_0.a(collection, n2, this.a);
        int[] nArray = new int[collection.size()];
        ag_0.a(list, collection, nArray);
        n3 = n3 < 0 ? Integer.MAX_VALUE : n3;
        for (int i2 = 0; i2 < n3; ++i2) {
            boolean bl = false;
            ArrayList<ab_0<T>> arrayList = new ArrayList<ab_0<T>>();
            Iterator<ab_0<T>> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                void object;
                ab_0<T> ab_02;
                ab_0<T> ab_03 = ab_02 = iterator2.next();
                if (ab_02.a.isEmpty()) {
                    switch (1.a[this.b - 1]) {
                        case 1: {
                            T t = this.a(list);
                            break;
                        }
                        case 2: {
                            T t = this.b(list);
                            break;
                        }
                        case 3: {
                            T t = ag_0.c(list);
                            break;
                        }
                        default: {
                            throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                        }
                    }
                    bl = true;
                } else {
                    ab_0<T> ab_04 = ab_02;
                    ab_03 = ab_04;
                    ab_03 = ab_02;
                    ac_0 ac_02 = (ac_0)ab_04.b.a(ab_03.a);
                }
                arrayList.add(new ab_0<void>(object));
            }
            int n4 = ag_0.a(arrayList, collection, nArray);
            list = arrayList;
            if (n4 != 0 || bl) continue;
            return list;
        }
        return list;
    }

    private static <T extends ac_0<T>> int a(List<ab_0<T>> list, Collection<T> object, int[] nArray) {
        int n2 = 0;
        int n3 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            ac_0 ac_02 = (ac_0)object.next();
            int n4 = ag_0.a(list, ac_02);
            if (n4 != nArray[n3]) {
                ++n2;
            }
            ab_0<ac_0> ab_02 = list.get(n4);
            ab_02.a(ac_02);
            nArray[n3++] = n4;
        }
        return n2;
    }

    private static <T extends ac_0<T>> List<ab_0<T>> a(Collection<T> collection, int n2, Random random) {
        collection = Collections.unmodifiableList(new ArrayList<T>(collection));
        int n3 = collection.size();
        boolean[] blArray = new boolean[n3];
        ArrayList<ab_0<T>> arrayList = new ArrayList<ab_0<T>>();
        int n4 = random.nextInt(n3);
        ac_0 ac_02 = (ac_0)collection.get(n4);
        arrayList.add(new ab_0<ac_0>(ac_02));
        blArray[n4] = true;
        double[] dArray = new double[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            double d2;
            if (i2 == n4) continue;
            double d3 = d2 = ac_02.a(collection.get(i2));
            dArray[i2] = d3 * d3;
        }
        while (arrayList.size() < n2) {
            int n5;
            double d4 = 0.0;
            for (int i3 = 0; i3 < n3; ++i3) {
                if (blArray[i3]) continue;
                d4 += dArray[i3];
            }
            double d5 = random.nextDouble() * d4;
            n4 = -1;
            double d6 = 0.0;
            for (n5 = 0; n5 < n3; ++n5) {
                double d7;
                if (blArray[n5]) continue;
                d6 += dArray[n5];
                if (!(d7 >= d5)) continue;
                n4 = n5;
                break;
            }
            if (n4 == -1) {
                for (n5 = n3 - 1; n5 >= 0; --n5) {
                    if (blArray[n5]) continue;
                    n4 = n5;
                    break;
                }
            }
            if (n4 < 0) break;
            ac_02 = (ac_0)collection.get(n4);
            arrayList.add(new ab_0<ac_0>(ac_02));
            blArray[n4] = true;
            if (arrayList.size() >= n2) continue;
            for (n4 = 0; n4 < n3; ++n4) {
                double d8;
                if (blArray[n4]) continue;
                double d9 = ac_02.a(collection.get(n4));
                double d10 = d9 * d9;
                if (!(d8 < dArray[n4])) continue;
                dArray[n4] = d10;
            }
        }
        return arrayList;
    }

    private T a(Collection<ab_0<T>> list) {
        ab_0 ab_02;
        double d2 = Double.NEGATIVE_INFINITY;
        ab_0 ab_03 = null;
        list = list.iterator();
        while (list.hasNext()) {
            double d3;
            ab_0 ab_04;
            ab_02 = ab_04 = (ab_0)list.next();
            if (ab_04.a.isEmpty()) continue;
            ab_02 = ab_04;
            Object t = ab_02.b;
            AM aM = new AM();
            ab_02 = ab_04;
            for (ac_0 ac_02 : ab_02.a) {
                ((an_0)aM).a(ac_02.a(t));
            }
            double d4 = ((an_0)aM).c();
            if (!(d3 > d2)) continue;
            d2 = d4;
            ab_03 = ab_04;
        }
        if (ab_03 == null) {
            throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        ab_02 = ab_03;
        list = ab_02.a;
        return (T)((ac_0)list.remove(this.a.nextInt(list.size())));
    }

    private T b(Collection<ab_0<T>> list) {
        int n2 = 0;
        ab_0 ab_02 = null;
        list = list.iterator();
        while (list.hasNext()) {
            ab_0 ab_03;
            ab_0 ab_04 = ab_03 = (ab_0)list.next();
            int n3 = ab_03.a.size();
            if (n3 <= n2) continue;
            n2 = n3;
            ab_02 = ab_03;
        }
        if (ab_02 == null) {
            throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        ab_0 ab_05 = ab_02;
        list = ab_05.a;
        return (T)((ac_0)list.remove(this.a.nextInt(list.size())));
    }

    private static T c(Collection<ab_0<T>> object) {
        Object object2;
        double d2 = Double.NEGATIVE_INFINITY;
        ab_0 ab_02 = null;
        int n2 = -1;
        object = object.iterator();
        while (object.hasNext()) {
            ab_0 ab_03 = (ab_0)object.next();
            object2 = ab_03;
            Object t = ab_03.b;
            object2 = ab_03;
            object2 = ((ab_0)object2).a;
            for (int i2 = 0; i2 < object2.size(); ++i2) {
                double d3;
                double d4 = ((ac_0)object2.get(i2)).a(t);
                if (!(d3 > d2)) continue;
                d2 = d4;
                ab_02 = ab_03;
                n2 = i2;
            }
        }
        if (ab_02 == null) {
            throw new oR(px_0.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        object2 = ab_02;
        return (ac_0)((ab_0)object2).a.remove(n2);
    }

    private static <T extends ac_0<T>> int a(Collection<ab_0<T>> object, T object2) {
        double d2 = Double.MAX_VALUE;
        int n2 = 0;
        int n3 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            double d3;
            ab_0 ab_02 = (ab_0)object.next();
            double d4 = object2.a(ab_02.b);
            if (d3 < d2) {
                d2 = d4;
                n3 = n2;
            }
            ++n2;
        }
        return n3;
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[org.valkyrienskies.core.impl.shadow.Ag$a.values$2d4b7354().length];
            try {
                1.a[org.valkyrienskies.core.impl.shadow.Ag$a.LARGEST_VARIANCE$338d5e9a - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[org.valkyrienskies.core.impl.shadow.Ag$a.LARGEST_POINTS_NUMBER$338d5e9a - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[org.valkyrienskies.core.impl.shadow.Ag$a.FARTHEST_POINT$338d5e9a - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a
    extends Enum<a> {
        public static final int LARGEST_VARIANCE$338d5e9a = 1;
        public static final int LARGEST_POINTS_NUMBER$338d5e9a = 2;
        public static final int FARTHEST_POINT$338d5e9a = 3;
        public static final int ERROR$338d5e9a = 4;
        private static final /* synthetic */ int[] $VALUES$3d2c3d55;

        public static int[] values$2d4b7354() {
            return (int[])$VALUES$3d2c3d55.clone();
        }

        private a() {
        }

        static {
            $VALUES$3d2c3d55 = new int[]{LARGEST_VARIANCE$338d5e9a, LARGEST_POINTS_NUMBER$338d5e9a, FARTHEST_POINT$338d5e9a, ERROR$338d5e9a};
        }
    }
}

