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
import org.valkyrienskies.core.impl.shadow.ab_0;
import org.valkyrienskies.core.impl.shadow.ac_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.pj_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ad
 */
@Deprecated
public final class ad_0<T extends ac_0<T>> {
    private final double a;
    private final int b;

    private ad_0(double d2, int n2) {
        if (d2 < 0.0) {
            throw new pj_0(d2);
        }
        if (n2 < 0) {
            throw new pj_0(n2);
        }
        this.a = d2;
        this.b = n2;
    }

    private double a() {
        return this.a;
    }

    private int b() {
        return this.b;
    }

    private List<ab_0<T>> a(Collection<T> collection) {
        ci_0.a(collection);
        ArrayList<ab_0<T>> arrayList = new ArrayList<ab_0<T>>();
        HashMap<Object, a> hashMap = new HashMap<Object, a>();
        for (Object object : collection) {
            if (hashMap.get(object) != null) continue;
            List<ac_0> list = this.a(object, collection);
            if (list.size() >= this.b) {
                ArrayList<ac_0> arrayList2 = new ab_0<Object>(null);
                ab_0<Object> ab_02 = arrayList2;
                HashMap<Object, a> hashMap2 = hashMap;
                Collection<T> collection2 = collection;
                List<ac_0> list2 = list;
                arrayList2 = object;
                list = ab_02;
                object = this;
                ((ab_0)((Object)list)).a(arrayList2);
                hashMap2.put(arrayList2, org.valkyrienskies.core.impl.shadow.Ad$a.PART_OF_CLUSTER);
                arrayList2 = new ArrayList<ac_0>(list2);
                for (int i2 = 0; i2 < arrayList2.size(); ++i2) {
                    Object object2;
                    ac_0 ac_02 = (ac_0)arrayList2.get(i2);
                    a a2 = (a)((Object)hashMap2.get(ac_02));
                    if (a2 == null && (object2 = super.a(ac_02, collection2)).size() >= ((ad_0)object).b) {
                        HashSet<ac_0> hashSet = new HashSet<ac_0>(arrayList2);
                        object2 = object2.iterator();
                        while (object2.hasNext()) {
                            ac_0 ac_03 = (ac_0)object2.next();
                            if (hashSet.contains(ac_03)) continue;
                            arrayList2.add(ac_03);
                        }
                    }
                    if (a2 == org.valkyrienskies.core.impl.shadow.Ad$a.PART_OF_CLUSTER) continue;
                    hashMap2.put(ac_02, org.valkyrienskies.core.impl.shadow.Ad$a.PART_OF_CLUSTER);
                    ((ab_0)((Object)list)).a(ac_02);
                }
                arrayList.add((ab_0<T>)((Object)list));
                continue;
            }
            hashMap.put(object, org.valkyrienskies.core.impl.shadow.Ad$a.NOISE);
        }
        return arrayList;
    }

    private ab_0<T> a(ab_0<T> ab_02, T object, List<T> list, Collection<T> collection, Map<ac_0<T>, a> map2) {
        ab_02.a((ac_0)object);
        map2.put((ac_0<T>)object, org.valkyrienskies.core.impl.shadow.Ad$a.PART_OF_CLUSTER);
        object = new ArrayList<T>(list);
        for (int i2 = 0; i2 < object.size(); ++i2) {
            List<ac_0> list2;
            ac_0 ac_02 = (ac_0)object.get(i2);
            a a2 = map2.get(ac_02);
            if (a2 == null && (list2 = this.a(ac_02, collection)).size() >= this.b) {
                object = ad_0.a(object, list2);
            }
            if (a2 == org.valkyrienskies.core.impl.shadow.Ad$a.PART_OF_CLUSTER) continue;
            map2.put(ac_02, org.valkyrienskies.core.impl.shadow.Ad$a.PART_OF_CLUSTER);
            ab_02.a(ac_02);
        }
        return ab_02;
    }

    private List<T> a(T t, Collection<T> object) {
        ArrayList<ac_0> arrayList = new ArrayList<ac_0>();
        object = object.iterator();
        while (object.hasNext()) {
            ac_0 ac_02 = (ac_0)object.next();
            if (t == ac_02 || !(ac_02.a(t) <= this.a)) continue;
            arrayList.add(ac_02);
        }
        return arrayList;
    }

    private static List<T> a(List<T> list, List<T> object) {
        HashSet hashSet = new HashSet(list);
        object = object.iterator();
        while (object.hasNext()) {
            ac_0 ac_02 = (ac_0)object.next();
            if (hashSet.contains(ac_02)) continue;
            list.add(ac_02);
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

