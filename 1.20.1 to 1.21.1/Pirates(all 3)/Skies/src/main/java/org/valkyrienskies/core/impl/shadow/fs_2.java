/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fs$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fs;
import org.valkyrienskies.core.impl.shadow.fw_1;
import org.valkyrienskies.core.impl.shadow.ga_2;
import org.valkyrienskies.core.impl.shadow.gw_1;
import org.valkyrienskies.core.impl.shadow.iq_0;
import org.valkyrienskies.core.impl.shadow.is_0;
import org.valkyrienskies.core.impl.shadow.iu_0;
import org.valkyrienskies.core.impl.shadow.iv_0;
import org.valkyrienskies.core.impl.shadow.iw_0;
import org.valkyrienskies.core.impl.shadow.iy_0;
import org.valkyrienskies.core.impl.shadow.kf_0;
import org.valkyrienskies.core.impl.shadow.kh_0;
import org.valkyrienskies.core.impl.shadow.ki_0;
import org.valkyrienskies.core.impl.shadow.kn_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fs
 */
public final class fs_2 {
    private fs_2() {
    }

    public static <T> List<T> a(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    private static <T> List<T> b(List<T> list, List<T> list2) {
        if (list == null) {
            return list2;
        }
        return list;
    }

    private static <E> List<E> c(List<? extends E> collection, List<? extends E> object) {
        ArrayList<List<E>> arrayList = new ArrayList<List<E>>();
        List<E> list3 = collection;
        List<E> list2 = object;
        if (collection.size() > object.size()) {
            list3 = object;
            list2 = collection;
        }
        collection = new HashSet<E>(list3);
        for (List<E> list3 : list2) {
            if (!((HashSet)collection).contains(list3)) continue;
            arrayList.add(list3);
            ((HashSet)collection).remove(list3);
        }
        return arrayList;
    }

    private static <E> List<E> d(List<E> object, List<? extends E> collection) {
        ArrayList arrayList = new ArrayList();
        collection = new ga_2<E>(collection);
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (((fw_1)collection).b(e2, 1)) continue;
            arrayList.add(e2);
        }
        return arrayList;
    }

    private static <E> List<E> e(List<? extends E> ga_22, List<? extends E> object) {
        List<E> list = object;
        Collection<Object> collection2 = ga_22;
        ArrayList<Object> arrayList = new ArrayList<E>(collection2.size() + list.size());
        arrayList.addAll(collection2);
        arrayList.addAll(list);
        ArrayList<E> arrayList2 = arrayList;
        list = object;
        collection2 = ga_22;
        arrayList = new ArrayList();
        ga_22 = collection2;
        object = list;
        if (collection2.size() > list.size()) {
            ga_22 = list;
            object = collection2;
        }
        collection2 = new HashSet<E>(ga_22);
        ga_22 = object.iterator();
        while (ga_22.hasNext()) {
            object = ga_22.next();
            if (!((HashSet)collection2).contains(object)) continue;
            arrayList.add(object);
            ((HashSet)collection2).remove(object);
        }
        list = arrayList;
        collection2 = arrayList2;
        arrayList = new ArrayList();
        ga_22 = new ga_2<E>(list);
        for (Collection<Object> collection2 : collection2) {
            if (ga_22.b(collection2, 1)) continue;
            arrayList.add(collection2);
        }
        return arrayList;
    }

    private static <E> List<E> f(List<? extends E> list, List<? extends E> list2) {
        ArrayList<E> arrayList = new ArrayList<E>(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    private static <E> List<E> a(Collection<? extends E> collection, ff_1<? super E> ff_12) {
        return fd_2.a(collection, ff_12, new ArrayList(collection.size()));
    }

    private static <E> List<E> b(Collection<? extends E> collection, ff_1<? super E> ff_12) {
        return fd_2.b(collection, ff_12, new ArrayList(collection.size()));
    }

    public static boolean a(Collection<?> object, Collection<?> object2) {
        if (object == object2) {
            return true;
        }
        if (object == null || object2 == null || object.size() != object2.size()) {
            return false;
        }
        object = object.iterator();
        object2 = object2.iterator();
        while (object.hasNext() && object2.hasNext()) {
            Object e2 = object.next();
            Object e3 = object2.next();
            if (e2 != null ? e2.equals(e3) : e3 == null) continue;
            return false;
        }
        return !object.hasNext() && !object2.hasNext();
    }

    public static int a(Collection<?> object) {
        if (object == null) {
            return 0;
        }
        int n2 = 1;
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            n2 = n2 * 31 + (e2 == null ? 0 : e2.hashCode());
        }
        return n2;
    }

    public static <E> List<E> b(Collection<E> object, Collection<?> collection) {
        ArrayList arrayList = new ArrayList(Math.min(object.size(), collection.size()));
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!collection.contains(e2)) continue;
            arrayList.add(e2);
        }
        return arrayList;
    }

    public static <E> List<E> c(Collection<E> object, Collection<?> collection) {
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (collection.contains(e2)) continue;
            arrayList.add(e2);
        }
        return arrayList;
    }

    private static <E> List<E> b(List<E> list) {
        return Collections.synchronizedList(list);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static List a(iv_0 iv_02) {
        return iy_0.a(iv_02);
    }

    private static <E> List<E> a(List<E> list, ff_1<E> ff_12) {
        return iu_0.a(list, ff_12);
    }

    private static <E> List<E> a(List<E> list, fq_1<? super E, ? extends E> fq_12) {
        return iw_0.a(list, fq_12);
    }

    private static <E> List<E> a(List<E> list, fh_2<? extends E> fh_22) {
        return is_0.a(list, fh_22);
    }

    private static <E> List<E> c(List<E> list) {
        return iq_0.a(list);
    }

    private static <E> int b(List<E> list, ff_1<E> ff_12) {
        if (list != null && ff_12 != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                E e2 = list.get(i2);
                if (!ff_12.a(e2)) continue;
                return i2;
            }
        }
        return -1;
    }

    public static <E> List<E> a(List<E> object, List<E> object2) {
        Object object3 = gw_1.a();
        if (object == null || object2 == null) {
            throw new NullPointerException("List must not be null");
        }
        if (object3 == null) {
            throw new NullPointerException("Equator must not be null");
        }
        object = new kn_0<E>(object, object2, object3);
        object3 = new ki_0();
        ((kn_0)object).a(0, ((kn_0)object).a.size(), 0, ((kn_0)object).b.size(), object3);
        object = object3;
        object3 = object2 = new b();
        for (kh_0 kh_02 : ((ki_0)object).a) {
            kh_02.a(object3);
        }
        object = object2;
        return ((b)object).a;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private static List a(List object, List object2, gw_1 gw_12) {
        if (object == null || object2 == null) {
            throw new NullPointerException("List must not be null");
        }
        if (gw_12 == null) {
            throw new NullPointerException("Equator must not be null");
        }
        object = new kn_0(object, object2, gw_12);
        object = ((kn_0)object).a();
        object2 = new b();
        ((ki_0)object).a((b)object2);
        object = object2;
        return ((b)object).a;
    }

    private static String a(CharSequence iterator2, CharSequence charSequence) {
        if (iterator2 == null || charSequence == null) {
            throw new NullPointerException("CharSequence must not be null");
        }
        iterator2 = fs_2.a(new fs.a((CharSequence)((Object)iterator2)), new fs.a(charSequence));
        charSequence = new StringBuilder();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Character c2 = (Character)iterator2.next();
            ((StringBuilder)charSequence).append(c2);
        }
        return ((StringBuilder)charSequence).toString();
    }

    private static <T> List<List<T>> a(List<T> list, int n2) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        return new c(list, n2, 0);
    }

    static final class c<T>
    extends AbstractList<List<T>> {
        private final List<T> a;
        private final int b;

        private c(List<T> list, int n2) {
            this.a = list;
            this.b = n2;
        }

        private List<T> a(int n2) {
            int n3 = this.size();
            if (n2 < 0) {
                throw new IndexOutOfBoundsException("Index " + n2 + " must not be negative");
            }
            if (n2 >= n3) {
                throw new IndexOutOfBoundsException("Index " + n2 + " must be less than size " + n3);
            }
            n3 = Math.min((n2 *= this.b) + this.b, this.a.size());
            return this.a.subList(n2, n3);
        }

        @Override
        public final int size() {
            return (int)Math.ceil((double)this.a.size() / (double)this.b);
        }

        @Override
        public final boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override
        public final /* synthetic */ Object get(int n2) {
            int n3 = n2;
            c c2 = this;
            int n4 = c2.size();
            if (n3 < 0) {
                throw new IndexOutOfBoundsException("Index " + n3 + " must not be negative");
            }
            if (n3 >= n4) {
                throw new IndexOutOfBoundsException("Index " + n3 + " must be less than size " + n4);
            }
            n4 = Math.min((n3 *= c2.b) + c2.b, c2.a.size());
            return c2.a.subList(n3, n4);
        }

        /* synthetic */ c(List list, int n2, byte by) {
            this(list, n2);
        }
    }

    public static final class b<E>
    implements kf_0<E> {
        final ArrayList<E> a = new ArrayList();

        @Override
        public final void a(E e2) {
        }

        @Override
        public final void b(E e2) {
        }

        @Override
        public final void c(E e2) {
            this.a.add(e2);
        }

        public final List<E> a() {
            return this.a;
        }
    }
}

