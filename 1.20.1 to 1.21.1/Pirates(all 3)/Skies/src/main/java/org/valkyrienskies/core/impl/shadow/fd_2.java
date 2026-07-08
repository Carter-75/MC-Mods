/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fd
 *  org.valkyrienskies.core.impl.shadow.fd$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ez_1;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.fd;
import org.valkyrienskies.core.impl.shadow.fe_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fg_2;
import org.valkyrienskies.core.impl.shadow.fp_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fq_2;
import org.valkyrienskies.core.impl.shadow.ga_1;
import org.valkyrienskies.core.impl.shadow.ga_2;
import org.valkyrienskies.core.impl.shadow.gb_1;
import org.valkyrienskies.core.impl.shadow.gc_1;
import org.valkyrienskies.core.impl.shadow.gy_2;
import org.valkyrienskies.core.impl.shadow.gz_2;
import org.valkyrienskies.core.impl.shadow.hi_1;
import org.valkyrienskies.core.impl.shadow.hs_2;
import org.valkyrienskies.core.impl.shadow.hv_1;
import org.valkyrienskies.core.impl.shadow.ir_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fd
 */
public final class fd_2 {
    public static final Collection a = Collections.emptyList();

    private fd_2() {
    }

    private static <T> Collection<T> a() {
        return a;
    }

    public static <T> Collection<T> a(Collection<T> collection) {
        if (collection == null) {
            return a;
        }
        return collection;
    }

    private static <O> Collection<O> b(Iterable<? extends O> c2, Iterable<? extends O> object) {
        c2 = new c(c2, object);
        for (Object e2 : c2) {
            c2.a(e2, c2.a(e2));
        }
        return c2.c;
    }

    public static <O> Collection<O> a(Iterable<? extends O> c2, Iterable<? extends O> object) {
        c2 = new c(c2, object);
        for (Object e2 : c2) {
            c2.a(e2, c2.b(e2));
        }
        return c2.c;
    }

    private static <O> Collection<O> c(Iterable<? extends O> c2, Iterable<? extends O> object) {
        c2 = new c(c2, object);
        for (Object e2 : c2) {
            c2.a(e2, c2.a(e2) - c2.b(e2));
        }
        return c2.c;
    }

    private static <O> Collection<O> d(Iterable<? extends O> iterable, Iterable<? extends O> iterator2) {
        ff_1 ff_12 = hi_1.a();
        ArrayList arrayList = new ArrayList();
        ga_2 ga_22 = new ga_2();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            if (!ff_12.a(object)) continue;
            ga_22.add(object);
        }
        for (Object object : iterable) {
            if (ga_22.b(object, 1)) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    private static <O> Collection<O> a(Iterable<? extends O> iterable, Iterable<? extends O> iterator2, ff_1<O> ff_12) {
        ArrayList arrayList = new ArrayList();
        ga_2 ga_22 = new ga_2();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            if (!ff_12.a(object)) continue;
            ga_22.add(object);
        }
        for (Object object : iterable) {
            if (ga_22.b(object, 1)) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    private static boolean d(Collection<?> object, Collection<?> object2) {
        if (object2.isEmpty()) {
            return true;
        }
        object = object.iterator();
        HashSet hashSet = new HashSet();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object e2 = object2.next();
            if (hashSet.contains(e2)) continue;
            boolean bl = false;
            while (object.hasNext()) {
                Object e3 = object.next();
                hashSet.add(e3);
                if (!(e2 == null ? e3 == null : e2.equals(e3))) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            return false;
        }
        return true;
    }

    private static <T> boolean a(Collection<?> TArray, T ... TArray2) {
        if (TArray.size() < TArray2.length) {
            for (Object obj : TArray) {
                int n2;
                block9: {
                    T[] TArray3 = TArray = TArray2;
                    TArray = TArray3;
                    boolean bl = false;
                    TArray = TArray3;
                    if (TArray3 != null) {
                        int n3;
                        if (obj == null) {
                            for (n3 = 0; n3 < TArray.length; ++n3) {
                                if (TArray[n3] != null) continue;
                                n2 = n3;
                                break block9;
                            }
                        } else {
                            for (n3 = 0; n3 < TArray.length; ++n3) {
                                if (!obj.equals(TArray[n3])) continue;
                                n2 = n3;
                                break block9;
                            }
                        }
                    }
                    n2 = -1;
                }
                if (!(n2 != -1)) continue;
                return true;
            }
        } else {
            T[] TArray4 = TArray2;
            int n4 = TArray2.length;
            for (int i2 = 0; i2 < n4; ++i2) {
                T t = TArray4[i2];
                if (!TArray.contains(t)) continue;
                return true;
            }
        }
        return false;
    }

    private static boolean e(Collection<?> collection, Collection<?> collection2) {
        if (collection.size() < collection2.size()) {
            for (Object obj : collection) {
                if (!collection2.contains(obj)) continue;
                return true;
            }
        } else {
            for (Object obj : collection2) {
                if (!collection.contains(obj)) continue;
                return true;
            }
        }
        return false;
    }

    public static <O> Map<O, Integer> a(Iterable<? extends O> object) {
        HashMap hashMap = new HashMap();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            Integer n2 = (Integer)hashMap.get(e2);
            if (n2 == null) {
                hashMap.put(e2, 1);
                continue;
            }
            hashMap.put(e2, n2 + 1);
        }
        return hashMap;
    }

    public static boolean a(Collection<?> object, Collection<?> a2) {
        a2 = new fd.a(object, a2);
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (a2.c(e2) <= a2.d(e2)) continue;
            return false;
        }
        return true;
    }

    public static boolean b(Collection<?> collection, Collection<?> collection2) {
        return collection.size() < collection2.size() && fd_2.a(collection, collection2);
    }

    public static boolean c(Collection<?> a2, Collection<?> object) {
        if (a2.size() != object.size()) {
            return false;
        }
        a2 = new fd.a(a2, object);
        if (a2.a.size() != a2.b.size()) {
            return false;
        }
        for (Object e2 : a2.a.keySet()) {
            if (a2.c(e2) == a2.d(e2)) continue;
            return false;
        }
        return true;
    }

    private static <E> boolean a(Collection<? extends E> collection, Collection<? extends E> collection2, fg_2<? super E> object) {
        if (object == null) {
            throw new NullPointerException("Equator must not be null.");
        }
        if (collection.size() != collection2.size()) {
            return false;
        }
        object = new fq_1((fg_2)object){
            private /* synthetic */ fg_2 a;
            {
                this.a = fg_22;
            }

            private b<?> b(Object object) {
                return new b<Object>(this.a, object);
            }

            public final /* synthetic */ Object a(Object object) {
                Object object2 = object;
                object = this;
                return new b<Object>(object.a, object2);
            }
        };
        return fd_2.c(fd_2.a(collection, object), fd_2.a(collection2, object));
    }

    @Deprecated
    private static <O> int a(O o, Iterable<? super O> iterable) {
        if (iterable == null) {
            throw new NullPointerException("coll must not be null.");
        }
        return fp_2.b(iterable, o);
    }

    @Deprecated
    private static <T> T b(Iterable<T> iterable, ff_1<? super T> ff_12) {
        if (ff_12 != null) {
            return fp_2.b(iterable, ff_12);
        }
        return null;
    }

    @Deprecated
    private static <T, C extends fb_2<? super T>> C a(Iterable<T> iterable, C c2) {
        if (c2 != null) {
            fp_2.a(iterable, c2);
        }
        return c2;
    }

    @Deprecated
    private static <T, C extends fb_2<? super T>> C a(Iterator<T> iterator2, C c2) {
        if (c2 != null) {
            fq_2.a(iterator2, c2);
        }
        return c2;
    }

    @Deprecated
    private static <T, C extends fb_2<? super T>> T b(Iterable<T> iterable, C c2) {
        if (c2 != null) {
            return fp_2.b(iterable, c2);
        }
        return null;
    }

    @Deprecated
    private static <T, C extends fb_2<? super T>> T b(Iterator<T> iterator2, C c2) {
        if (c2 != null) {
            return fq_2.b(iterator2, c2);
        }
        return null;
    }

    public static <T> boolean a(Iterable<T> object, ff_1<? super T> ff_12) {
        boolean bl = false;
        if (object != null && ff_12 != null) {
            object = object.iterator();
            while (object.hasNext()) {
                if (ff_12.a(object.next())) continue;
                object.remove();
                bl = true;
            }
        }
        return bl;
    }

    private static <T> boolean c(Iterable<T> object, ff_1<? super T> ff_12) {
        hs_2 hs_22;
        if (ff_12 == null) {
            hs_22 = null;
        } else {
            object = ff_12;
            hs_22 = hs_2.a(object);
        }
        return fd_2.a(object, hs_22);
    }

    private static <C> void a(Collection<C> object, fq_1<? super C, ? extends C> fq_12) {
        if (object != null && fq_12 != null) {
            if (object instanceof List) {
                List list = (List)object;
                object = list.listIterator();
                while (object.hasNext()) {
                    object.set(fq_12.a(object.next()));
                }
                return;
            }
            Collection<? extends C> collection = fd_2.a(object, fq_12);
            object.clear();
            object.addAll(collection);
        }
    }

    @Deprecated
    private static <C> int d(Iterable<C> iterable, ff_1<? super C> ff_12) {
        if (ff_12 == null) {
            return 0;
        }
        return (int)fp_2.f(iterable, ff_12);
    }

    @Deprecated
    private static <C> boolean e(Iterable<C> iterable, ff_1<? super C> ff_12) {
        return ff_12 != null && fp_2.e(iterable, ff_12);
    }

    @Deprecated
    private static <C> boolean f(Iterable<C> iterable, ff_1<? super C> ff_12) {
        return ff_12 != null && fp_2.d(iterable, ff_12);
    }

    private static <O> Collection<O> g(Iterable<? extends O> iterable, ff_1<? super O> ff_12) {
        ArrayList arrayList = iterable instanceof Collection ? new ArrayList(((Collection)iterable).size()) : new ArrayList();
        return fd_2.a(iterable, ff_12, arrayList);
    }

    public static <O, R extends Collection<? super O>> R a(Iterable<? extends O> object, ff_1<? super O> ff_12, R r) {
        if (object != null && ff_12 != null) {
            object = object.iterator();
            while (object.hasNext()) {
                Object e2 = object.next();
                if (!ff_12.a(e2)) continue;
                r.add(e2);
            }
        }
        return r;
    }

    private static <O, R extends Collection<? super O>> R a(Iterable<? extends O> object, ff_1<? super O> ff_12, R r, R r2) {
        if (object != null && ff_12 != null) {
            object = object.iterator();
            while (object.hasNext()) {
                Object e2 = object.next();
                if (ff_12.a(e2)) {
                    r.add(e2);
                    continue;
                }
                r2.add(e2);
            }
        }
        return r;
    }

    private static <O> Collection<O> h(Iterable<? extends O> iterable, ff_1<? super O> ff_12) {
        ArrayList arrayList = iterable instanceof Collection ? new ArrayList(((Collection)iterable).size()) : new ArrayList();
        return fd_2.b(iterable, ff_12, arrayList);
    }

    public static <O, R extends Collection<? super O>> R b(Iterable<? extends O> object, ff_1<? super O> ff_12, R r) {
        if (object != null && ff_12 != null) {
            object = object.iterator();
            while (object.hasNext()) {
                Object e2 = object.next();
                if (ff_12.a(e2)) continue;
                r.add(e2);
            }
        }
        return r;
    }

    private static <I, O> Collection<O> a(Iterable<I> iterable, fq_1<? super I, ? extends O> fq_12) {
        ArrayList arrayList = iterable instanceof Collection ? new ArrayList(((Collection)iterable).size()) : new ArrayList();
        return fd_2.a(iterable, fq_12, arrayList);
    }

    private static <I, O> Collection<O> a(Iterator<I> iterator2, fq_1<? super I, ? extends O> fq_12) {
        return fd_2.a(iterator2, fq_12, new ArrayList());
    }

    private static <I, O, R extends Collection<? super O>> R a(Iterable<? extends I> iterable, fq_1<? super I, ? extends O> fq_12, R r) {
        if (iterable != null) {
            return fd_2.a(iterable.iterator(), fq_12, r);
        }
        return r;
    }

    private static <I, O, R extends Collection<? super O>> R a(Iterator<? extends I> iterator2, fq_1<? super I, ? extends O> fq_12, R r) {
        if (iterator2 != null && fq_12 != null) {
            while (iterator2.hasNext()) {
                Object object = iterator2.next();
                object = fq_12.a(object);
                r.add(object);
            }
        }
        return r;
    }

    private static <T> boolean a(Collection<T> collection, T t) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        return t != null && collection.add(t);
    }

    public static <C> boolean a(Collection<C> collection, Iterable<? extends C> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection)iterable);
        }
        return fd_2.a(collection, iterable.iterator());
    }

    public static <C> boolean a(Collection<C> collection, Iterator<? extends C> iterator2) {
        boolean bl = false;
        while (iterator2.hasNext()) {
            bl |= collection.add(iterator2.next());
        }
        return bl;
    }

    private static <C> boolean a(Collection<C> collection, Enumeration<? extends C> enumeration) {
        boolean bl = false;
        while (enumeration.hasMoreElements()) {
            bl |= collection.add(enumeration.nextElement());
        }
        return bl;
    }

    private static <C> boolean b(Collection<C> collection, C ... CArray) {
        boolean bl = false;
        for (C c2 : CArray) {
            bl |= collection.add(c2);
        }
        return bl;
    }

    @Deprecated
    private static <T> T a(Iterator<T> iterator2, int n2) {
        return fq_2.b(iterator2, n2);
    }

    static void a(int n2) {
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + n2);
        }
    }

    @Deprecated
    private static <T> T a(Iterable<T> iterable, int n2) {
        return fp_2.a(iterable, n2);
    }

    private static Object a(Object object, int n2) {
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + n2);
        }
        if (object instanceof Map) {
            object = (Map)object;
            object = object.entrySet().iterator();
            return fq_2.b(object, n2);
        }
        if (object instanceof Object[]) {
            return ((Object[])object)[n2];
        }
        if (object instanceof Iterator) {
            return fq_2.b(object, n2);
        }
        if (object instanceof Iterable) {
            object = (Iterable)object;
            return fp_2.a(object, n2);
        }
        if (object instanceof Enumeration) {
            object = (Enumeration)object;
            fd_2.a(n2);
            while (object.hasMoreElements()) {
                if (--n2 == -1) {
                    return object.nextElement();
                }
                object.nextElement();
            }
            throw new IndexOutOfBoundsException("Entry does not exist: " + n2);
        }
        if (object == null) {
            throw new IllegalArgumentException("Unsupported object type: null");
        }
        try {
            return Array.get(object, n2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Unsupported object type: " + object.getClass().getName());
        }
    }

    private static <K, V> Map.Entry<K, V> a(Map<K, V> object, int n2) {
        fd_2.a(n2);
        object = object.entrySet();
        return fp_2.a(object, n2);
    }

    public static int a(Object object) {
        if (object == null) {
            return 0;
        }
        int n2 = 0;
        if (object instanceof Map) {
            n2 = ((Map)object).size();
        } else if (object instanceof Collection) {
            n2 = ((Collection)object).size();
        } else if (object instanceof Iterable) {
            n2 = fp_2.f((Iterable)object);
        } else if (object instanceof Object[]) {
            n2 = ((Object[])object).length;
        } else if (object instanceof Iterator) {
            n2 = fq_2.e((Iterator)object);
        } else if (object instanceof Enumeration) {
            object = (Enumeration)object;
            while (object.hasMoreElements()) {
                ++n2;
                object.nextElement();
            }
        } else {
            try {
                n2 = Array.getLength(object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new IllegalArgumentException("Unsupported object type: " + object.getClass().getName());
            }
        }
        return n2;
    }

    private static boolean b(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof Collection) {
            return ((Collection)object).isEmpty();
        }
        if (object instanceof Iterable) {
            return fp_2.e((Iterable)object);
        }
        if (object instanceof Map) {
            return ((Map)object).isEmpty();
        }
        if (object instanceof Object[]) {
            return ((Object[])object).length == 0;
        }
        if (object instanceof Iterator) {
            return !((Iterator)object).hasNext();
        }
        if (object instanceof Enumeration) {
            return !((Enumeration)object).hasMoreElements();
        }
        try {
            return Array.getLength(object) == 0;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Unsupported object type: " + object.getClass().getName());
        }
    }

    private static boolean b(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    private static boolean c(Collection<?> collection) {
        return !(collection == null || collection.isEmpty());
    }

    private static void a(Object[] objectArray) {
        int n2 = 0;
        for (int i2 = objectArray.length - 1; i2 > n2; --i2, ++n2) {
            Object object = objectArray[i2];
            objectArray[i2] = objectArray[n2];
            objectArray[n2] = object;
        }
    }

    private static boolean d(Collection<? extends Object> gb_12) {
        if (gb_12 == null) {
            throw new NullPointerException("The collection must not be null");
        }
        if (gb_12 instanceof ez_1) {
            return ((ez_1)gb_12).a();
        }
        try {
            gb_12 = gb_1.b(gb_12);
            return gb_12.a();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }

    private static int e(Collection<? extends Object> gb_12) {
        if (gb_12 == null) {
            throw new NullPointerException("The collection must not be null");
        }
        if (gb_12 instanceof ez_1) {
            return ((ez_1)gb_12).b();
        }
        try {
            gb_12 = gb_1.b(gb_12);
            return gb_12.b();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return -1;
        }
    }

    private static <O extends Comparable<? super O>> List<O> e(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        return fd_2.a(iterable, iterable2, fe_2.a(), true);
    }

    private static <O extends Comparable<? super O>> List<O> a(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, boolean bl) {
        return fd_2.a(iterable, iterable2, fe_2.a(), bl);
    }

    private static <O> List<O> a(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Comparator<? super O> comparator) {
        return fd_2.a(iterable, iterable2, comparator, true);
    }

    private static <O> List<O> a(Iterable<? extends O> object, Iterable<? extends O> iterable, Comparator<? super O> comparator, boolean bl) {
        if (object == null || iterable == null) {
            throw new NullPointerException("The collections must not be null");
        }
        if (comparator == null) {
            throw new NullPointerException("The comparator must not be null");
        }
        int n2 = object instanceof Collection && iterable instanceof Collection ? Math.max(1, ((Collection)object).size() + ((Collection)iterable).size()) : 10;
        object = new hv_1<O>(comparator, object.iterator(), iterable.iterator());
        if (bl) {
            return fq_2.a(object, n2);
        }
        iterable = new ArrayList<O>(n2);
        comparator = null;
        while (object.hasNext()) {
            Object e2 = object.next();
            if (comparator == null || !((Object)comparator).equals(e2)) {
                ((ArrayList)iterable).add(e2);
            }
            comparator = e2;
        }
        ((ArrayList)iterable).trimToSize();
        return iterable;
    }

    private static <E> Collection<List<E>> f(Collection<E> object) {
        object = new ir_1<E>(object);
        ArrayList arrayList = new ArrayList();
        while (((ir_1)object).hasNext()) {
            arrayList.add(((ir_1)object).a());
        }
        return arrayList;
    }

    private static <C> Collection<C> f(Collection<C> object, Collection<?> collection) {
        ArrayList arrayList = new ArrayList(Math.min(object.size(), collection.size()));
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!collection.contains(e2)) continue;
            arrayList.add(e2);
        }
        return arrayList;
    }

    private static <E> Collection<E> a(Iterable<E> object, Iterable<? extends E> set, fg_2<? super E> fg_22) {
        Object object2 = new fq_1<E, b<E>>(fg_22){
            private /* synthetic */ fg_2 a;
            {
                this.a = fg_22;
            }

            private b<E> b(E e2) {
                return new b(this.a, e2);
            }

            @Override
            public final /* synthetic */ Object a(Object object) {
                Object object2 = object;
                object = this;
                return new b<Object>(object.a, object2);
            }
        };
        set = fd_2.a(set, object2, new HashSet());
        object2 = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!set.contains(new b<E>(fg_22, e2))) continue;
            object2.add(e2);
        }
        return object2;
    }

    private static <E> Collection<E> g(Collection<E> object, Collection<?> collection) {
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (collection.contains(e2)) continue;
            arrayList.add(e2);
        }
        return arrayList;
    }

    private static <E> Collection<E> b(Iterable<E> object, Iterable<? extends E> set, fg_2<? super E> fg_22) {
        Object object2 = new fq_1<E, b<E>>(fg_22){
            private /* synthetic */ fg_2 a;
            {
                this.a = fg_22;
            }

            private b<E> b(E e2) {
                return new b(this.a, e2);
            }

            @Override
            public final /* synthetic */ Object a(Object object) {
                Object object2 = object;
                object = this;
                return new b<Object>(object.a, object2);
            }
        };
        set = fd_2.a(set, object2, new HashSet());
        object2 = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (set.contains(new b<E>(fg_22, e2))) continue;
            object2.add(e2);
        }
        return object2;
    }

    @Deprecated
    private static <C> Collection<C> g(Collection<C> collection) {
        return gz_2.a(collection);
    }

    @Deprecated
    private static <C> Collection<C> h(Collection<? extends C> collection) {
        return gc_1.b(collection);
    }

    private static <C> Collection<C> a(Collection<C> collection, ff_1<? super C> ff_12) {
        return gy_2.a(collection, ff_12);
    }

    private static <E> Collection<E> b(Collection<E> collection, fq_1<? super E, ? extends E> fq_12) {
        return ga_1.a(collection, fq_12);
    }

    private static <E> E i(Collection<E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        if (collection.size() != 1) {
            throw new IllegalArgumentException("Can extract singleton only when collection size == 1");
        }
        return collection.iterator().next();
    }

    static final class b<O> {
        private final fg_2<? super O> a;
        private final O b;

        public b(fg_2<? super O> fg_22, O o) {
            this.a = fg_22;
            this.b = o;
        }

        private O a() {
            return this.b;
        }

        public final boolean equals(Object obj) {
            b b2;
            if (!(obj instanceof b)) {
                return false;
            }
            b2 = b2;
            return this.a.a(this.b, b2.b);
        }

        public final int hashCode() {
            return this.a.a(this.b);
        }
    }

    /*
     * Signature claims super is org.valkyrienskies.core.impl.shadow.fd$a_0<O>, not org.valkyrienskies.core.impl.shadow.fd$a - discarding signature.
     */
    static final class c
    extends fd.a
    implements Iterable {
        private final Set<O> d = new HashSet();
        final List<O> c;

        public c(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
            super(iterable, iterable2);
            fd.a(this.d, iterable);
            fd.a(this.d, iterable2);
            this.c = new ArrayList(this.d.size());
        }

        public final Iterator<O> iterator() {
            return this.d.iterator();
        }

        public final void a(O o, int n2) {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.c.add(o);
            }
        }

        public final Collection<O> a() {
            return this.c;
        }
    }
}

