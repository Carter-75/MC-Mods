/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.tK;
import org.valkyrienskies.core.impl.shadow.tL;
import org.valkyrienskies.core.impl.shadow.tM;
import org.valkyrienskies.core.impl.shadow.tY;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class tN<T extends tL>
extends tM<T> {
    private final double a;
    private final int b;

    private tN(double d2, int n2) {
        this(d2, n2, new tY());
    }

    private tN(double d2, int n2, tY tY2) {
        super(tY2);
        if (d2 < 0.0) {
            throw new pj_0(d2);
        }
        if (n2 < 0) {
            throw new pj_0(n2);
        }
        this.a = d2;
        this.b = n2;
    }

    private double b() {
        return this.a;
    }

    private int c() {
        return this.b;
    }

    @Override
    public final List<tK<T>> a(Collection<T> collection) {
        ci_0.a(collection);
        ArrayList<tK<T>> arrayList = new ArrayList<tK<T>>();
        HashMap<Object, a> hashMap = new HashMap<Object, a>();
        for (Object object : collection) {
            if (hashMap.get(object) != null) continue;
            List<tL> list = this.a(object, collection);
            if (list.size() >= this.b) {
                ArrayList<tL> arrayList2 = new tK();
                tK tK2 = arrayList2;
                HashMap<Object, a> hashMap2 = hashMap;
                Collection<T> collection2 = collection;
                List<tL> list2 = list;
                arrayList2 = object;
                list = tK2;
                object = this;
                ((tK)((Object)list)).a(arrayList2);
                hashMap2.put(arrayList2, org.valkyrienskies.core.impl.shadow.tN$a.PART_OF_CLUSTER);
                arrayList2 = new ArrayList<tL>(list2);
                for (int i2 = 0; i2 < arrayList2.size(); ++i2) {
                    Object object2;
                    tL tL2 = (tL)arrayList2.get(i2);
                    a a2 = (a)((Object)hashMap2.get(tL2));
                    if (a2 == null && (object2 = super.a(tL2, collection2)).size() >= ((tN)object).b) {
                        HashSet<tL> hashSet = new HashSet<tL>(arrayList2);
                        object2 = object2.iterator();
                        while (object2.hasNext()) {
                            tL tL3 = (tL)object2.next();
                            if (hashSet.contains(tL3)) continue;
                            arrayList2.add(tL3);
                        }
                    }
                    if (a2 == org.valkyrienskies.core.impl.shadow.tN$a.PART_OF_CLUSTER) continue;
                    hashMap2.put(tL2, org.valkyrienskies.core.impl.shadow.tN$a.PART_OF_CLUSTER);
                    ((tK)((Object)list)).a(tL2);
                }
                arrayList.add((tK<T>)((Object)list));
                continue;
            }
            hashMap.put(object, org.valkyrienskies.core.impl.shadow.tN$a.NOISE);
        }
        return arrayList;
    }

    private tK<T> a(tK<T> tK2, T object, List<T> list, Collection<T> collection, Map<tL, a> map2) {
        tK2.a((tL)object);
        map2.put((tL)object, org.valkyrienskies.core.impl.shadow.tN$a.PART_OF_CLUSTER);
        object = new ArrayList<T>(list);
        for (int i2 = 0; i2 < object.size(); ++i2) {
            List<tL> list2;
            tL tL2 = (tL)object.get(i2);
            a a2 = map2.get(tL2);
            if (a2 == null && (list2 = this.a(tL2, collection)).size() >= this.b) {
                object = tN.a(object, list2);
            }
            if (a2 == org.valkyrienskies.core.impl.shadow.tN$a.PART_OF_CLUSTER) continue;
            map2.put(tL2, org.valkyrienskies.core.impl.shadow.tN$a.PART_OF_CLUSTER);
            tK2.a(tL2);
        }
        return tK2;
    }

    private List<T> a(T t, Collection<T> object) {
        ArrayList<tL> arrayList = new ArrayList<tL>();
        object = object.iterator();
        while (object.hasNext()) {
            tL tL2 = (tL)object.next();
            if (t == tL2 || !(this.a(tL2, (tL)t) <= this.a)) continue;
            arrayList.add(tL2);
        }
        return arrayList;
    }

    private static List<T> a(List<T> list, List<T> object) {
        HashSet hashSet = new HashSet(list);
        object = object.iterator();
        while (object.hasNext()) {
            tL tL2 = (tL)object.next();
            if (hashSet.contains(tL2)) continue;
            list.add(tL2);
        }
        return list;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static enum a {
        NOISE,
        PART_OF_CLUSTER;

    }
}

