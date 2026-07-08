/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fL$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.valkyrienskies.core.impl.shadow.fL;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fl_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fq_2;
import org.valkyrienskies.core.impl.shadow.kA;
import org.valkyrienskies.core.impl.shadow.kB;
import org.valkyrienskies.core.impl.shadow.kC;
import org.valkyrienskies.core.impl.shadow.kD;
import org.valkyrienskies.core.impl.shadow.kt_0;
import org.valkyrienskies.core.impl.shadow.kv_0;
import org.valkyrienskies.core.impl.shadow.kw_0;
import org.valkyrienskies.core.impl.shadow.kx_0;
import org.valkyrienskies.core.impl.shadow.ky_0;
import org.valkyrienskies.core.impl.shadow.kz_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fL
 */
public final class fl_1 {
    private static SortedSet a = kD.a(new TreeSet());

    private static <E> Set<E> a() {
        return Collections.emptySet();
    }

    private static <E> SortedSet<E> b() {
        return a;
    }

    private fl_1() {
    }

    public static <T> Set<T> a(Set<T> set) {
        if (set == null) {
            return Collections.emptySet();
        }
        return set;
    }

    public static boolean a(Collection<?> collection, Collection<?> collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        return collection.containsAll(collection2);
    }

    public static <T> int a(Collection<T> object) {
        if (object == null) {
            return 0;
        }
        int n2 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (e2 == null) continue;
            n2 += e2.hashCode();
        }
        return n2;
    }

    private static <E> Set<E> c() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    private static <E> Set<E> b(Set<E> set) {
        return Collections.synchronizedSet(set);
    }

    private static <E> Set<E> c(Set<? extends E> set) {
        return kC.a(set);
    }

    private static <E> Set<E> a(Set<E> set, ff_1<? super E> ff_12) {
        return kw_0.a(set, ff_12);
    }

    private static <E> Set<E> a(Set<E> set, fq_1<? super E, ? extends E> fq_12) {
        return kz_0.a(set, fq_12);
    }

    private static <E> Set<E> d(Set<E> set) {
        return kt_0.a(set);
    }

    private static <E> SortedSet<E> a(SortedSet<E> sortedSet) {
        return Collections.synchronizedSortedSet(sortedSet);
    }

    private static <E> SortedSet<E> b(SortedSet<E> sortedSet) {
        return kD.a(sortedSet);
    }

    private static <E> SortedSet<E> a(SortedSet<E> sortedSet, ff_1<? super E> ff_12) {
        return kx_0.a(sortedSet, ff_12);
    }

    private static <E> SortedSet<E> a(SortedSet<E> sortedSet, fq_1<? super E, ? extends E> fq_12) {
        return kA.a(sortedSet, fq_12);
    }

    private static <E> SortedSet<E> a(NavigableSet<E> navigableSet) {
        return kB.a(navigableSet);
    }

    private static <E> SortedSet<E> a(NavigableSet<E> navigableSet, ff_1<? super E> ff_12) {
        return kv_0.a(navigableSet, ff_12);
    }

    private static <E> SortedSet<E> a(NavigableSet<E> navigableSet, fq_1<? super E, ? extends E> fq_12) {
        return ky_0.a(navigableSet, fq_12);
    }

    private static <E> fl_2.a_0<E> a(Set<? extends E> set, Set<? extends E> set2) {
        if (set == null || set2 == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        3 var2_2 = fl_1.b(set2, set);
        return new fL.a(set, set2, (fl_2.a_0)((Object)var2_2)){
            private /* synthetic */ Set a;
            private /* synthetic */ Set b;
            private /* synthetic */ fl_2.a_0 c;
            {
                this.a = set;
                this.b = set2;
                this.c = a_02;
            }

            /*
             * WARNING - void declaration
             */
            public final boolean contains(Object o) {
                void var1_1;
                return this.a.contains(o) || this.b.contains(var1_1);
            }

            public final Iterator<E> a() {
                return fq_2.a(this.a.iterator(), (Iterator)this.c.iterator());
            }

            public final boolean isEmpty() {
                return this.a.isEmpty() && this.b.isEmpty();
            }

            public final int size() {
                return this.a.size() + this.c.size();
            }
        };
    }

    private static <E> fl_2.a_0<E> b(Set<? extends E> set, Set<? extends E> set2) {
        if (set == null || set2 == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        ff_1 ff_12 = new ff_1<E>(set2){
            private /* synthetic */ Set a;
            {
                this.a = set;
            }

            @Override
            public final boolean a(E e2) {
                return !this.a.contains(e2);
            }
        };
        return new fL.a(set, set2, ff_12){
            private /* synthetic */ Set a;
            private /* synthetic */ Set b;
            private /* synthetic */ ff_1 c;
            {
                this.a = set;
                this.b = set2;
                this.c = var3_3;
            }

            /*
             * WARNING - void declaration
             */
            public final boolean contains(Object o) {
                void var1_1;
                return this.a.contains(o) && !this.b.contains(var1_1);
            }

            public final Iterator<E> a() {
                return fq_2.a(this.a.iterator(), (ff_1)this.c);
            }
        };
    }

    private static <E> fl_2.a_0<E> c(Set<? extends E> set, Set<? extends E> set2) {
        if (set == null || set2 == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        ff_1 ff_12 = new ff_1<E>(set2){
            private /* synthetic */ Set a;
            {
                this.a = set;
            }

            @Override
            public final boolean a(E e2) {
                return this.a.contains(e2);
            }
        };
        return new fL.a(set, set2, ff_12){
            private /* synthetic */ Set a;
            private /* synthetic */ Set b;
            private /* synthetic */ ff_1 c;
            {
                this.a = set;
                this.b = set2;
                this.c = var3_3;
            }

            /*
             * WARNING - void declaration
             */
            public final boolean contains(Object o) {
                void var1_1;
                return this.a.contains(o) && this.b.contains(var1_1);
            }

            public final Iterator<E> a() {
                return fq_2.a(this.a.iterator(), (ff_1)this.c);
            }
        };
    }

    private static <E> fl_2.a_0<E> d(Set<? extends E> set, Set<? extends E> set2) {
        if (set == null || set2 == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        3 var2_2 = fl_1.b(set, set2);
        3 var3_3 = fl_1.b(set2, set);
        return new fL.a(set, set2, (fl_2.a_0)((Object)var2_2), (fl_2.a_0)((Object)var3_3)){
            private /* synthetic */ Set a;
            private /* synthetic */ Set b;
            private /* synthetic */ fl_2.a_0 c;
            private /* synthetic */ fl_2.a_0 d;
            {
                this.a = set;
                this.b = set2;
                this.c = a_02;
                this.d = a_03;
            }

            /*
             * WARNING - void declaration
             */
            public final boolean contains(Object o) {
                void var1_1;
                return this.a.contains(o) ^ this.b.contains(var1_1);
            }

            public final Iterator<E> a() {
                return fq_2.a((Iterator)this.c.iterator(), (Iterator)this.d.iterator());
            }

            public final boolean isEmpty() {
                return this.c.isEmpty() && this.d.isEmpty();
            }

            public final int size() {
                return this.c.size() + this.d.size();
            }
        };
    }
}

