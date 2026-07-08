/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.fc_1;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fe_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fj_1;
import org.valkyrienskies.core.impl.shadow.fk_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gx_1;
import org.valkyrienskies.core.impl.shadow.hc_1;
import org.valkyrienskies.core.impl.shadow.hs_1;
import org.valkyrienskies.core.impl.shadow.ht_1;
import org.valkyrienskies.core.impl.shadow.hu_1;
import org.valkyrienskies.core.impl.shadow.hv_1;
import org.valkyrienskies.core.impl.shadow.hw_1;
import org.valkyrienskies.core.impl.shadow.hx_1;
import org.valkyrienskies.core.impl.shadow.hy_1;
import org.valkyrienskies.core.impl.shadow.hz_1;
import org.valkyrienskies.core.impl.shadow.ia_1;
import org.valkyrienskies.core.impl.shadow.ia_2;
import org.valkyrienskies.core.impl.shadow.ib_1;
import org.valkyrienskies.core.impl.shadow.ic_2;
import org.valkyrienskies.core.impl.shadow.id_1;
import org.valkyrienskies.core.impl.shadow.id_2;
import org.valkyrienskies.core.impl.shadow.ie_2;
import org.valkyrienskies.core.impl.shadow.if_2;
import org.valkyrienskies.core.impl.shadow.ig_2;
import org.valkyrienskies.core.impl.shadow.ih_2;
import org.valkyrienskies.core.impl.shadow.ij_2;
import org.valkyrienskies.core.impl.shadow.ik_2;
import org.valkyrienskies.core.impl.shadow.il_2;
import org.valkyrienskies.core.impl.shadow.im_2;
import org.valkyrienskies.core.impl.shadow.in_2;
import org.valkyrienskies.core.impl.shadow.io_2;
import org.valkyrienskies.core.impl.shadow.ip_2;
import org.valkyrienskies.core.impl.shadow.iq_1;
import org.valkyrienskies.core.impl.shadow.is_1;
import org.valkyrienskies.core.impl.shadow.iu_1;
import org.valkyrienskies.core.impl.shadow.iv_1;
import org.valkyrienskies.core.impl.shadow.iw_1;
import org.valkyrienskies.core.impl.shadow.ix_1;
import org.valkyrienskies.core.impl.shadow.iz_1;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fq
 */
public final class fq_2 {
    public static final fj_1 a = hw_1.a;
    private static fk_1 b;
    private static fc_1 c;
    private static fu_2 d;
    private static fe_1 e;
    private static final String f = "[";
    private static final String g = "]";
    private static final String h = ", ";

    private fq_2() {
    }

    public static <E> fj_1<E> a() {
        return hw_1.a();
    }

    private static <E> fk_1<E> b() {
        return hx_1.a();
    }

    private static <E> fc_1<E> c() {
        return hz_1.a();
    }

    private static <K, V> fu_2<K, V> d() {
        return hy_1.d();
    }

    private static <K, V> fe_1<K, V> e() {
        return ia_2.d();
    }

    private static <E> fj_1<E> a(E e2) {
        return new iu_1<E>(e2);
    }

    private static <E> ListIterator<E> b(E e2) {
        return new iv_1<E>(e2);
    }

    private static <E> fj_1<E> a(E ... EArray) {
        return new in_2<E>(EArray);
    }

    private static <E> fj_1<E> c(Object object) {
        return new hs_1(object);
    }

    private static <E> fj_1<E> a(E[] EArray, int n2) {
        return new in_2<E>(EArray, n2);
    }

    private static <E> fj_1<E> a(Object object, int n2) {
        return new hs_1(object, n2);
    }

    private static <E> fj_1<E> a(E[] EArray, int n2, int n3) {
        return new in_2<E>(EArray, n2, n3);
    }

    private static <E> fj_1<E> a(Object object, int n2, int n3) {
        return new hs_1(object, n2, n3);
    }

    private static <E> fk_1<E> b(E ... EArray) {
        return new io_2<E>(EArray);
    }

    private static <E> fk_1<E> d(Object object) {
        return new ht_1(object);
    }

    private static <E> fk_1<E> b(E[] EArray, int n2) {
        return new io_2<E>(EArray, n2);
    }

    private static <E> fk_1<E> b(Object object, int n2) {
        return new ht_1(object, n2);
    }

    private static <E> fk_1<E> b(E[] EArray, int n2, int n3) {
        return new io_2<E>(EArray, n2, n3);
    }

    private static <E> fk_1<E> b(Object object, int n2, int n3) {
        return new ht_1(object, n2, n3);
    }

    public static <E> hu_1<E> a(Iterator<? extends E> iterator2, long l2) {
        long l3 = l2;
        long l4 = 0L;
        return new hu_1<E>(iterator2, 0L, l3);
    }

    private static <E> hu_1<E> a(Iterator<? extends E> iterator2, long l2, long l3) {
        return new hu_1<E>(iterator2, 0L, l3);
    }

    public static <E> Iterator<E> a(Iterator<E> iterator2) {
        return iz_1.a(iterator2);
    }

    private static <E> ListIterator<E> a(ListIterator<E> listIterator) {
        return ia_1.a(listIterator);
    }

    private static <K, V> fu_2<K, V> a(fu_2<K, V> fu_22) {
        return ib_1.a(fu_22);
    }

    public static <E> Iterator<E> a(Iterator<? extends E> iterator2, Iterator<? extends E> iterator3) {
        return new if_2<E>(iterator2, iterator3);
    }

    private static <E> Iterator<E> b(Iterator<? extends E> ... iteratorArray) {
        return new if_2<E>(iteratorArray);
    }

    private static <E> Iterator<E> a(Collection<Iterator<? extends E>> collection) {
        return new if_2<E>(collection);
    }

    public static <E> Iterator<E> a(Comparator<? super E> comparator, Iterator<? extends E> iterator2, Iterator<? extends E> iterator3) {
        comparator = comparator == null ? fe_2.a : comparator;
        return new hv_1<E>(comparator, iterator2, iterator3);
    }

    private static <E> Iterator<E> a(Comparator<? super E> comparator, Iterator<? extends E> ... iteratorArray) {
        comparator = comparator == null ? fe_2.a : comparator;
        return new hv_1<E>(comparator, iteratorArray);
    }

    private static <E> Iterator<E> a(Comparator<? super E> comparator, Collection<Iterator<? extends E>> collection) {
        comparator = comparator == null ? fe_2.a : comparator;
        return new hv_1<E>(comparator, collection);
    }

    private static <E> Iterator<E> a(E e2, fq_1<? super E, ? extends E> fq_12) {
        return new ip_2<E>(e2, fq_12);
    }

    public static <I, O> Iterator<O> a(Iterator<? extends I> iterator2, fq_1<? super I, ? extends O> fq_12) {
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (fq_12 == null) {
            throw new NullPointerException("Transformer must not be null");
        }
        return new ix_1<I, O>(iterator2, fq_12);
    }

    public static <E> Iterator<E> a(Iterator<? extends E> iterator2, ff_1<? super E> ff_12) {
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        return new id_2<E>(iterator2, ff_12);
    }

    private static <E> ListIterator<E> a(ListIterator<? extends E> listIterator, ff_1<? super E> ff_12) {
        if (listIterator == null) {
            throw new NullPointerException("ListIterator must not be null");
        }
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        return new ie_2<E>(listIterator, ff_12);
    }

    private static <E> fj_1<E> b(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null");
        }
        return new ik_2<E>(collection);
    }

    private static <E> fk_1<E> a(List<E> list) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        return new il_2<E>(list);
    }

    private static im_2 a(NodeList nodeList) {
        if (nodeList == null) {
            throw new NullPointerException("NodeList must not be null");
        }
        return new im_2(nodeList);
    }

    private static im_2 a(Node node) {
        if (node == null) {
            throw new NullPointerException("Node must not be null");
        }
        return new im_2(node);
    }

    private static <E> Iterator<E> g(Iterator<? extends E> iterator2) {
        return iq_1.a(iterator2);
    }

    private static <E> Iterator<E> h(Iterator<? extends E> iterator2) {
        return is_1.a(iterator2);
    }

    public static <E> iw_1<E> b(Iterator<E> iterator2, long l2) {
        return new iw_1<E>(iterator2, l2);
    }

    public static <E> id_1<E> b(Iterator<? extends E> iterator2, Iterator<? extends E> iterator3) {
        return new id_1<E>(iterator2, iterator3);
    }

    private static <E> id_1<E> a(Iterator<? extends E> iterator2, Iterator<? extends E> iterator3, Iterator<? extends E> iterator4) {
        return new id_1<E>(iterator2, iterator3, iterator4);
    }

    public static <E> id_1<E> a(Iterator<? extends E> ... iteratorArray) {
        return new id_1<E>(iteratorArray);
    }

    private static <E> Iterator<E> a(Enumeration<? extends E> enumeration) {
        if (enumeration == null) {
            throw new NullPointerException("Enumeration must not be null");
        }
        return new ic_2<E>(enumeration);
    }

    private static <E> Iterator<E> a(Enumeration<? extends E> enumeration, Collection<? super E> collection) {
        if (enumeration == null) {
            throw new NullPointerException("Enumeration must not be null");
        }
        if (collection == null) {
            throw new NullPointerException("Collection must not be null");
        }
        return new ic_2<E>(enumeration, collection);
    }

    public static <E> Enumeration<E> b(Iterator<? extends E> iterator2) {
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        return new ig_2<E>(iterator2);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static ih_2 a(iu_1 iu_12) {
        return new ih_2(iu_12, false);
    }

    private static <E> Iterable<E> i(Iterator<? extends E> iterator2) {
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        return new ih_2<E>(iterator2, true);
    }

    private static <E> ListIterator<E> j(Iterator<? extends E> iterator2) {
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        return new ij_2<E>(iterator2);
    }

    private static Object[] k(Iterator<?> object) {
        if (object == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        object = fq_2.a(object, 100);
        return object.toArray();
    }

    public static <E> E[] a(Iterator<? extends E> object, Class<E> objectArray) {
        if (object == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (objectArray == null) {
            throw new NullPointerException("Array class must not be null");
        }
        object = fq_2.a(object, 100);
        objectArray = (Object[])Array.newInstance(objectArray, object.size());
        return object.toArray(objectArray);
    }

    public static <E> List<E> c(Iterator<? extends E> iterator2) {
        return fq_2.a(iterator2, 10);
    }

    public static <E> List<E> a(Iterator<? extends E> iterator2, int n2) {
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException("Estimated size must be greater than 0");
        }
        ArrayList<E> arrayList = new ArrayList<E>(n2);
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next());
        }
        return arrayList;
    }

    private static Iterator<?> e(Object object) {
        if (object == null) {
            return hw_1.a();
        }
        if (object instanceof Iterator) {
            return (Iterator)object;
        }
        if (object instanceof Iterable) {
            return ((Iterable)object).iterator();
        }
        if (object instanceof Object[]) {
            return new in_2<Object>((Object[])object);
        }
        if (object instanceof Enumeration) {
            return new ic_2((Enumeration)object);
        }
        if (object instanceof Map) {
            return ((Map)object).values().iterator();
        }
        if (object instanceof NodeList) {
            return new im_2((NodeList)object);
        }
        if (object instanceof Node) {
            return new im_2((Node)object);
        }
        if (object instanceof Dictionary) {
            return new ic_2(((Dictionary)object).elements());
        }
        if (object.getClass().isArray()) {
            return new hs_1(object);
        }
        try {
            Object object2 = object.getClass().getMethod("iterator", null);
            if (Iterator.class.isAssignableFrom(((Method)object2).getReturnType()) && (object2 = (Iterator)((Method)object2).invoke(object, null)) != null) {
                return object2;
            }
        }
        catch (RuntimeException runtimeException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InvocationTargetException invocationTargetException) {}
        return new iu_1<Object>(object);
    }

    public static <E> void a(Iterator<E> iterator2, fb_2<? super E> fb_22) {
        if (fb_22 == null) {
            throw new NullPointerException("Closure must not be null");
        }
        if (iterator2 != null) {
            while (iterator2.hasNext()) {
                E e2 = iterator2.next();
                fb_22.a(e2);
            }
        }
    }

    public static <E> E b(Iterator<E> iterator2, fb_2<? super E> fb_22) {
        if (fb_22 == null) {
            throw new NullPointerException("Closure must not be null.");
        }
        if (iterator2 != null) {
            while (iterator2.hasNext()) {
                E e2 = iterator2.next();
                if (iterator2.hasNext()) {
                    fb_22.a(e2);
                    continue;
                }
                return e2;
            }
        }
        return null;
    }

    public static <E> E b(Iterator<E> iterator2, ff_1<? super E> ff_12) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (iterator2 != null) {
            while (iterator2.hasNext()) {
                E e2 = iterator2.next();
                if (!ff_12.a(e2)) continue;
                return e2;
            }
        }
        return null;
    }

    public static <E> int c(Iterator<E> iterator2, ff_1<? super E> ff_12) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (iterator2 != null) {
            int n2 = 0;
            while (iterator2.hasNext()) {
                E e2 = iterator2.next();
                if (ff_12.a(e2)) {
                    return n2;
                }
                ++n2;
            }
        }
        return -1;
    }

    public static <E> boolean d(Iterator<E> iterator2, ff_1<? super E> ff_12) {
        return fq_2.c(iterator2, ff_12) != -1;
    }

    public static <E> boolean e(Iterator<E> iterator2, ff_1<? super E> ff_12) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        if (iterator2 != null) {
            while (iterator2.hasNext()) {
                E e2 = iterator2.next();
                if (ff_12.a(e2)) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean d(Iterator<?> iterator2) {
        return iterator2 == null || !iterator2.hasNext();
    }

    public static <E> boolean a(Iterator<E> iterator2, Object object) {
        return fq_2.d(iterator2, gx_1.b(object));
    }

    public static <E> E b(Iterator<E> iterator2, int n2) {
        fd_2.a(n2);
        while (iterator2.hasNext()) {
            if (--n2 == -1) {
                return iterator2.next();
            }
            iterator2.next();
        }
        throw new IndexOutOfBoundsException("Entry does not exist: " + n2);
    }

    private static <E> E l(Iterator<E> iterator2) {
        return fq_2.b(iterator2, 0);
    }

    public static int e(Iterator<?> iterator2) {
        int n2 = 0;
        if (iterator2 != null) {
            while (iterator2.hasNext()) {
                iterator2.next();
                ++n2;
            }
        }
        return n2;
    }

    public static <E> String f(Iterator<E> iterator2) {
        return fq_2.a(iterator2, hc_1.a(), h, f, g);
    }

    public static <E> String b(Iterator<E> iterator2, fq_1<? super E, String> fq_12) {
        return fq_2.a(iterator2, fq_12, h, f, g);
    }

    public static <E> String a(Iterator<E> iterator2, fq_1<? super E, String> fq_12, String string, String string2, String string3) {
        if (fq_12 == null) {
            throw new NullPointerException("transformer may not be null");
        }
        if (string == null) {
            throw new NullPointerException("delimiter may not be null");
        }
        if (string2 == null) {
            throw new NullPointerException("prefix may not be null");
        }
        if (string3 == null) {
            throw new NullPointerException("suffix may not be null");
        }
        StringBuilder stringBuilder = new StringBuilder(string2);
        if (iterator2 != null) {
            while (iterator2.hasNext()) {
                E e2 = iterator2.next();
                stringBuilder.append(fq_12.a(e2));
                stringBuilder.append(string);
            }
            if (stringBuilder.length() > string2.length()) {
                StringBuilder stringBuilder2 = stringBuilder;
                stringBuilder2.setLength(stringBuilder2.length() - string.length());
            }
        }
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

