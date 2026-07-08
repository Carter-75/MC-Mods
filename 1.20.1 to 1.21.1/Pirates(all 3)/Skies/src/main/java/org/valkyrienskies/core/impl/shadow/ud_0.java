/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.ud
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.ud;
import org.valkyrienskies.core.impl.shadow.ue_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ud
 */
public final class ud_0
implements Serializable,
Iterable<ue_0> {
    private static final long a = 20130207L;
    private final ConcurrentHashMap<Long, ue_0> b = new ConcurrentHashMap();
    private final AtomicLong c;
    private final int d;
    private final ConcurrentHashMap<Long, Set<Long>> e = new ConcurrentHashMap();

    ud_0(long l2, int n2, ue_0[] ue_0Array, long[][] lArray) {
        Object object;
        int n3;
        int n4 = ue_0Array.length;
        if (n4 != lArray.length) {
            throw new oX();
        }
        for (n3 = 0; n3 < n4; ++n3) {
            object = ue_0Array[n3];
            ue_0 ue_02 = object;
            long l3 = ((ue_0)object).a;
            if (l3 >= l2) {
                throw new oX();
            }
            this.b.put(l3, (ue_0)object);
            this.e.put(l3, new HashSet());
        }
        for (n3 = 0; n3 < n4; ++n3) {
            ue_0 ue_03 = ue_0Array[n3];
            long l4 = ue_03.a;
            Set<Long> set = this.e.get(l4);
            long[] lArray2 = lArray[n3];
            object = lArray2;
            int n5 = lArray2.length;
            for (int i2 = 0; i2 < n5; ++i2) {
                Long l5 = (long)object[i2];
                if (this.b.get(l5) == null) {
                    throw new oX();
                }
                ud_0.a(set, l5);
            }
        }
        this.c = new AtomicLong(l2);
        this.d = n2;
    }

    public ud_0(long l2, int n2) {
        this.c = new AtomicLong(l2);
        this.d = n2;
    }

    public final synchronized ud_0 a() {
        ud_0 ud_02 = new ud_0(this.c.get(), this.d);
        for (Map.Entry<Long, ue_0> entry : this.b.entrySet()) {
            ud_02.b.put(entry.getKey(), entry.getValue().a());
        }
        for (Map.Entry<Long, Object> entry : this.e.entrySet()) {
            ud_02.e.put(entry.getKey(), new HashSet((Collection)entry.getValue()));
        }
        return ud_02;
    }

    @Override
    public final Iterator<ue_0> iterator() {
        return this.b.values().iterator();
    }

    private Collection<ue_0> a(Comparator<ue_0> comparator) {
        ArrayList<ue_0> arrayList = new ArrayList<ue_0>();
        arrayList.addAll(this.b.values());
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public final long a(double[] dArray) {
        if (dArray.length != this.d) {
            throw new oS(dArray.length, this.d);
        }
        ud_0 ud_02 = this;
        long l2 = ud_02.c.getAndIncrement();
        this.b.put(l2, new ue_0(l2, dArray));
        this.e.put(l2, new HashSet());
        return l2;
    }

    private void b(ue_0 ue_02) {
        Iterator<ue_0> iterator2 = ue_02;
        Serializable serializable = this;
        iterator2 = serializable.a((ue_0)((Object)iterator2), null);
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            ue_0 ue_03 = ue_02;
            ue_0 ue_04 = object;
            object = this;
            serializable = ue_04;
            long l2 = ((ue_0)serializable).a;
            serializable = ue_03;
            long l3 = ((ue_0)serializable).a;
            if (ue_04 != ((ud_0)object).a(l2)) {
                throw new NoSuchElementException(Long.toString(l2));
            }
            if (ue_03 != ((ud_0)object).a(l3)) {
                throw new NoSuchElementException(Long.toString(l3));
            }
            long l4 = l3;
            object = ((ud_0)object).e.get(l2);
            object.remove(l4);
        }
        serializable = ue_02;
        this.b.remove(((ue_0)serializable).a);
    }

    private int b() {
        return this.d;
    }

    public final void a(ue_0 ue_02, ue_0 ue_03) {
        ue_0 ue_04 = ue_02;
        long l2 = ue_04.a;
        ue_04 = ue_03;
        long l3 = ue_04.a;
        if (ue_02 != this.a(l2)) {
            throw new NoSuchElementException(Long.toString(l2));
        }
        if (ue_03 != this.a(l3)) {
            throw new NoSuchElementException(Long.toString(l3));
        }
        ud_0.a(this.e.get(l2), l3);
    }

    private static void a(Set<Long> set, long l2) {
        set.add(l2);
    }

    private void b(ue_0 ue_02, ue_0 ue_03) {
        ue_0 ue_04 = ue_02;
        long l2 = ue_04.a;
        ue_04 = ue_03;
        long l3 = ue_04.a;
        if (ue_02 != this.a(l2)) {
            throw new NoSuchElementException(Long.toString(l2));
        }
        if (ue_03 != this.a(l3)) {
            throw new NoSuchElementException(Long.toString(l3));
        }
        ud_0.b(this.e.get(l2), l3);
    }

    private static void b(Set<Long> set, long l2) {
        set.remove(l2);
    }

    public final ue_0 a(long l2) {
        ue_0 ue_02 = this.b.get(l2);
        if (ue_02 == null) {
            throw new NoSuchElementException(Long.toString(l2));
        }
        return ue_02;
    }

    private Collection<ue_0> a(Iterable<ue_0> iterable) {
        return this.a(iterable, null);
    }

    public final Collection<ue_0> a(Iterable<ue_0> object, Iterable<ue_0> object22) {
        Object object3;
        HashSet hashSet = new HashSet();
        object = object.iterator();
        while (object.hasNext()) {
            object3 = (ue_0)object.next();
            hashSet.addAll(this.e.get(((ue_0)object3).a));
        }
        if (object22 != null) {
            object = object22.iterator();
            while (object.hasNext()) {
                object3 = (ue_0)object.next();
                hashSet.remove(((ue_0)object3).a);
            }
        }
        object = new ArrayList();
        for (Object object22 : hashSet) {
            object.add(this.a((Long)object22));
        }
        return object;
    }

    public final Collection<ue_0> a(ue_0 ue_02) {
        return this.a(ue_02, (Iterable<ue_0>)null);
    }

    public final Collection<ue_0> a(ue_0 iterator2, Iterable<ue_0> iterable) {
        iterator2 = this.e.get(((ue_0)((Object)iterator2)).a);
        iterable = new ArrayList<ue_0>();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Long l2 = (Long)iterator2.next();
            iterable.add((ue_0)this.a(l2));
        }
        return iterable;
    }

    private Long c() {
        return this.c.getAndIncrement();
    }

    private static void d() {
        throw new IllegalStateException();
    }

    private b e() {
        ue_0[] ue_0Array = this.b.values().toArray(new ue_0[0]);
        long[][] lArrayArray = new long[ue_0Array.length][];
        for (int i2 = 0; i2 < ue_0Array.length; ++i2) {
            Iterator iterator2 = ue_0Array[i2];
            Serializable serializable = this;
            iterator2 = serializable.a((ue_0)((Object)iterator2), null);
            long[] lArray = new long[iterator2.size()];
            int n2 = 0;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                serializable = (ue_0)iterator2.next();
                lArray[n2] = ((ue_0)serializable).a;
                ++n2;
            }
            lArrayArray[i2] = lArray;
        }
        return new b(this.c.get(), this.d, ue_0Array, lArrayArray);
    }

    static final class b
    implements Serializable {
        private static final long a = 20130207L;
        private final long b;
        private final int c;
        private final ue_0[] d;
        private final long[][] e;

        b(long l2, int n2, ue_0[] ue_0Array, long[][] lArray) {
            this.b = l2;
            this.c = n2;
            this.d = ue_0Array;
            this.e = lArray;
        }

        private ud_0 a() {
            return new ud(this.b, this.c, this.d, this.e);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a
    implements Serializable,
    Comparator<ue_0> {
        private static final long a = 20130207L;

        private static int a(ue_0 ue_02, ue_0 ue_03) {
            long l2 = ue_02.a;
            ue_02 = ue_03;
            long l3 = ue_02.a;
            if (l2 < l3) {
                return -1;
            }
            if (l2 > l3) {
                return 1;
            }
            return 0;
        }
    }
}

