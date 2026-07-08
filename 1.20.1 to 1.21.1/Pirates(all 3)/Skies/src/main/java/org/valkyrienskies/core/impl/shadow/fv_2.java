/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import org.valkyrienskies.core.impl.shadow.fd_1;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fn_2;
import org.valkyrienskies.core.impl.shadow.fo_2;
import org.valkyrienskies.core.impl.shadow.fp_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fr_2;
import org.valkyrienskies.core.impl.shadow.fw_2;
import org.valkyrienskies.core.impl.shadow.gx_1;
import org.valkyrienskies.core.impl.shadow.hp_2;
import org.valkyrienskies.core.impl.shadow.jD;
import org.valkyrienskies.core.impl.shadow.jE;
import org.valkyrienskies.core.impl.shadow.jG;
import org.valkyrienskies.core.impl.shadow.jI;
import org.valkyrienskies.core.impl.shadow.jd_0;
import org.valkyrienskies.core.impl.shadow.jg_0;
import org.valkyrienskies.core.impl.shadow.jl_0;
import org.valkyrienskies.core.impl.shadow.jm_0;
import org.valkyrienskies.core.impl.shadow.jq_0;
import org.valkyrienskies.core.impl.shadow.jr_0;
import org.valkyrienskies.core.impl.shadow.jt_0;
import org.valkyrienskies.core.impl.shadow.jv_0;
import org.valkyrienskies.core.impl.shadow.jx_0;
import org.valkyrienskies.core.impl.shadow.jy_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fv
 */
public final class fv_2 {
    private static SortedMap a;
    private static final String b = "    ";

    private fv_2() {
    }

    private static <K, V> V a(Map<? super K, V> map2, K k2) {
        if (map2 != null) {
            return map2.get(k2);
        }
        return null;
    }

    private static <K> String b(Map<? super K, ?> map2, K k2) {
        if (map2 != null && (map2 = map2.get(k2)) != null) {
            return map2.toString();
        }
        return null;
    }

    private static <K> Boolean c(Map<? super K, ?> object, K k2) {
        if (object != null && (object = object.get(k2)) != null) {
            if (object instanceof Boolean) {
                return (Boolean)object;
            }
            if (object instanceof String) {
                return Boolean.valueOf((String)object);
            }
            if (object instanceof Number) {
                if (((Number)(object = (Number)object)).intValue() != 0) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        }
        return null;
    }

    private static <K> Number d(Map<? super K, ?> object, K k2) {
        if (object != null && (object = object.get(k2)) != null) {
            if (object instanceof Number) {
                return (Number)object;
            }
            if (object instanceof String) {
                try {
                    object = (String)object;
                    return NumberFormat.getInstance().parse((String)object);
                }
                catch (ParseException parseException) {}
            }
        }
        return null;
    }

    private static <K> Byte e(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.d(object, k2)) == null) {
            return null;
        }
        if (object instanceof Byte) {
            return (Byte)object;
        }
        return ((Number)object).byteValue();
    }

    private static <K> Short f(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.d(object, k2)) == null) {
            return null;
        }
        if (object instanceof Short) {
            return (Short)object;
        }
        return ((Number)object).shortValue();
    }

    private static <K> Integer g(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.d(object, k2)) == null) {
            return null;
        }
        if (object instanceof Integer) {
            return (Integer)object;
        }
        return ((Number)object).intValue();
    }

    private static <K> Long h(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.d(object, k2)) == null) {
            return null;
        }
        if (object instanceof Long) {
            return (Long)object;
        }
        return ((Number)object).longValue();
    }

    private static <K> Float i(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.d(object, k2)) == null) {
            return null;
        }
        if (object instanceof Float) {
            return (Float)object;
        }
        return Float.valueOf(((Number)object).floatValue());
    }

    private static <K> Double j(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.d(object, k2)) == null) {
            return null;
        }
        if (object instanceof Double) {
            return (Double)object;
        }
        return ((Number)object).doubleValue();
    }

    private static <K> Map<?, ?> k(Map<? super K, ?> map2, K k2) {
        if (map2 != null && (map2 = map2.get(k2)) != null && map2 instanceof Map) {
            return map2;
        }
        return null;
    }

    private static <K, V> V a(Map<K, V> map2, K k2, V v) {
        if (map2 != null && (map2 = map2.get(k2)) != null) {
            return (V)map2;
        }
        return v;
    }

    private static <K> String a(Map<? super K, ?> object, K k2, String string) {
        if ((object = object != null && (object = object.get(k2)) != null ? object.toString() : null) == null) {
            object = string;
        }
        return object;
    }

    private static <K> Boolean a(Map<? super K, ?> object, K k2, Boolean bl) {
        if ((object = fv_2.c(object, k2)) == null) {
            object = bl;
        }
        return object;
    }

    private static <K> Number a(Map<? super K, ?> object, K k2, Number number) {
        if ((object = fv_2.d(object, k2)) == null) {
            object = number;
        }
        return object;
    }

    private static <K> Byte a(Map<? super K, ?> object, K k2, Byte by) {
        if ((object = fv_2.e(object, k2)) == null) {
            object = by;
        }
        return object;
    }

    private static <K> Short a(Map<? super K, ?> object, K k2, Short s) {
        if ((object = fv_2.f(object, k2)) == null) {
            object = s;
        }
        return object;
    }

    private static <K> Integer a(Map<? super K, ?> object, K k2, Integer n2) {
        if ((object = fv_2.g(object, k2)) == null) {
            object = n2;
        }
        return object;
    }

    private static <K> Long a(Map<? super K, ?> object, K k2, Long l2) {
        if ((object = fv_2.h(object, k2)) == null) {
            object = l2;
        }
        return object;
    }

    private static <K> Float a(Map<? super K, ?> object, K k2, Float f2) {
        if ((object = fv_2.i(object, k2)) == null) {
            object = f2;
        }
        return object;
    }

    private static <K> Double a(Map<? super K, ?> object, K k2, Double d2) {
        if ((object = fv_2.j(object, k2)) == null) {
            object = d2;
        }
        return object;
    }

    private static <K> Map<?, ?> a(Map<? super K, ?> map2, K k2, Map<?, ?> map3) {
        if ((map2 = map2 != null && (map2 = map2.get(k2)) != null && map2 instanceof Map ? map2 : null) == null) {
            map2 = map3;
        }
        return map2;
    }

    private static <K> boolean l(Map<? super K, ?> map2, K k2) {
        return Boolean.TRUE.equals(fv_2.c(map2, k2));
    }

    private static <K> byte m(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.e(object, k2)) == null) {
            return 0;
        }
        return (Byte)object;
    }

    private static <K> short n(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.f(object, k2)) == null) {
            return 0;
        }
        return (Short)object;
    }

    private static <K> int o(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.g(object, k2)) == null) {
            return 0;
        }
        return (Integer)object;
    }

    private static <K> long p(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.h(object, k2)) == null) {
            return 0L;
        }
        return (Long)object;
    }

    private static <K> float q(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.i(object, k2)) == null) {
            return 0.0f;
        }
        return ((Float)object).floatValue();
    }

    private static <K> double r(Map<? super K, ?> object, K k2) {
        if ((object = fv_2.j(object, k2)) == null) {
            return 0.0;
        }
        return (Double)object;
    }

    private static <K> boolean a(Map<? super K, ?> object, K k2, boolean bl) {
        if ((object = fv_2.c(object, k2)) == null) {
            return bl;
        }
        return (Boolean)object;
    }

    private static <K> byte a(Map<? super K, ?> object, K k2, byte by) {
        if ((object = fv_2.e(object, k2)) == null) {
            return by;
        }
        return (Byte)object;
    }

    private static <K> short a(Map<? super K, ?> object, K k2, short s) {
        if ((object = fv_2.f(object, k2)) == null) {
            return s;
        }
        return (Short)object;
    }

    private static <K> int a(Map<? super K, ?> object, K k2, int n2) {
        if ((object = fv_2.g(object, k2)) == null) {
            return n2;
        }
        return (Integer)object;
    }

    private static <K> long a(Map<? super K, ?> object, K k2, long l2) {
        if ((object = fv_2.h(object, k2)) == null) {
            return l2;
        }
        return (Long)object;
    }

    private static <K> float a(Map<? super K, ?> object, K k2, float f2) {
        if ((object = fv_2.i(object, k2)) == null) {
            return f2;
        }
        return ((Float)object).floatValue();
    }

    private static <K> double a(Map<? super K, ?> object, K k2, double d2) {
        if ((object = fv_2.j(object, k2)) == null) {
            return d2;
        }
        return (Double)object;
    }

    private static <K, V> Properties b(Map<K, V> object) {
        Properties properties = new Properties();
        if (object != null) {
            for (Map.Entry entry : object.entrySet()) {
                Map.Entry entry2 = entry;
                entry2 = entry;
                Object k2 = entry.getKey();
                entry2 = entry2.getValue();
                properties.put(k2, entry2);
            }
        }
        return properties;
    }

    private static Map<String, Object> a(ResourceBundle resourceBundle) {
        Enumeration<String> enumeration = resourceBundle.getKeys();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        while (enumeration.hasMoreElements()) {
            String string = enumeration.nextElement();
            Object object = resourceBundle.getObject(string);
            hashMap.put(string, object);
        }
        return hashMap;
    }

    private static void a(PrintStream printStream, Object object, Map<?, ?> map2) {
        fv_2.a(printStream, object, map2, new ArrayDeque(), false);
    }

    private static void b(PrintStream printStream, Object object, Map<?, ?> map2) {
        fv_2.a(printStream, object, map2, new ArrayDeque(), true);
    }

    private static void a(PrintStream printStream, Object iterator2, Map<?, ?> map2, Deque<Map<?, ?>> deque, boolean bl) {
        fv_2.a(printStream, deque.size());
        if (map2 == null) {
            if (iterator2 != null) {
                printStream.print(iterator2);
                printStream.print(" = ");
            }
            printStream.println("null");
            return;
        }
        if (iterator2 != null) {
            printStream.print(iterator2);
            printStream.println(" = ");
        }
        fv_2.a(printStream, deque.size());
        printStream.println("{");
        deque.addLast(map2);
        for (Map.Entry<?, ?> entry : map2.entrySet()) {
            Object n2 = entry.getKey();
            Object entry2 = entry.getValue();
            if (entry2 instanceof Map && !deque.contains(entry2)) {
                fv_2.a(printStream, n2 == null ? "null" : n2, (Map)entry2, deque, bl);
                continue;
            }
            fv_2.a(printStream, deque.size());
            printStream.print(n2);
            printStream.print(" = ");
            n2 = entry2;
            int n3 = fp_2.c(deque, gx_1.b(n2));
            if (n3 == -1) {
                printStream.print(entry2);
            } else if (deque.size() - 1 == n3) {
                printStream.print("(this Map)");
            } else {
                printStream.print("(ancestor[" + (deque.size() - 1 - n3 - 1) + "] Map)");
            }
            if (bl && entry2 != null) {
                printStream.print(' ');
                printStream.println(entry2.getClass().getName());
                continue;
            }
            printStream.println();
        }
        deque.removeLast();
        fv_2.a(printStream, deque.size());
        printStream.println(bl ? "} " + map2.getClass().getName() : "}");
    }

    private static void a(PrintStream printStream, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            printStream.print(b);
        }
    }

    private static <K, V> Map<V, K> c(Map<K, V> object) {
        HashMap hashMap = new HashMap(object.size());
        for (Map.Entry entry : object.entrySet()) {
            hashMap.put(entry.getValue(), entry.getKey());
        }
        return hashMap;
    }

    private static <K> void b(Map<? super K, Object> map2, K k2, Object object) {
        map2.put(k2, object == null ? "" : object);
    }

    private static <K, V> Map<K, V> a(Map<K, V> map2, Object[] objectArray) {
        if (map2 == null) {
            throw new NullPointerException("The map must not be null");
        }
        if (objectArray == null || objectArray.length == 0) {
            return map2;
        }
        Object[] objectArray2 = objectArray[0];
        if (objectArray2 instanceof Map.Entry) {
            objectArray2 = objectArray;
            int n2 = objectArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray2[i2];
                object = (Map.Entry)object;
                map2.put(object.getKey(), object.getValue());
            }
        } else if (objectArray2 instanceof fr_2) {
            objectArray2 = objectArray;
            int n3 = objectArray.length;
            for (int i3 = 0; i3 < n3; ++i3) {
                Object object = objectArray2[i3];
                object = (fr_2)object;
                map2.put(object.getKey(), object.getValue());
            }
        } else if (objectArray2 instanceof Object[]) {
            for (int i4 = 0; i4 < objectArray.length; ++i4) {
                Object[] objectArray3 = (Object[])objectArray[i4];
                if (objectArray3 == null || objectArray3.length < 2) {
                    throw new IllegalArgumentException("Invalid array element: " + i4);
                }
                map2.put(objectArray3[0], objectArray3[1]);
            }
        } else {
            int n4 = 0;
            while (n4 < objectArray.length - 1) {
                map2.put(objectArray[n4++], objectArray[n4++]);
            }
        }
        return map2;
    }

    private static <K, V> Map<K, V> d(Map<K, V> map2) {
        if (map2 == null) {
            return Collections.emptyMap();
        }
        return map2;
    }

    private static boolean e(Map<?, ?> map2) {
        return map2 == null || map2.isEmpty();
    }

    private static boolean f(Map<?, ?> map2) {
        return !(map2 == null || map2.isEmpty());
    }

    private static <K, V> Map<K, V> g(Map<K, V> map2) {
        return Collections.synchronizedMap(map2);
    }

    private static <K, V> Map<K, V> h(Map<? extends K, ? extends V> map2) {
        return jG.a(map2);
    }

    private static <K, V> fn_2<K, V> a(Map<K, V> map2, ff_1<? super K> ff_12, ff_1<? super V> ff_13) {
        return jx_0.a(map2, ff_12, ff_13);
    }

    private static <K, V> fn_2<K, V> a(Map<K, V> map2, fq_1<? super K, ? extends K> fq_12, fq_1<? super V, ? extends V> fq_13) {
        return jD.a(map2, fq_12, fq_13);
    }

    private static <K, V> fn_2<K, V> i(Map<K, V> map2) {
        return jl_0.a(map2);
    }

    private static <K, V> fn_2<K, V> a(Map<K, V> map2, fh_2<? extends V> fh_22) {
        return jq_0.a(map2, fh_22);
    }

    private static <K, V> fn_2<K, V> a(Map<K, V> map2, fq_1<? super K, ? extends V> fq_12) {
        return jq_0.a(map2, fq_12);
    }

    private static <K, V> fd_1<K, V> j(Map<K, V> map2) {
        return jt_0.a(map2);
    }

    @Deprecated
    private static <K, V> jv_0<K, V> k(Map<K, ? super Collection<V>> map2) {
        return jv_0.a(map2);
    }

    @Deprecated
    private static <K, V, C extends Collection<V>> jv_0<K, V> a(Map<K, C> map2, Class<C> clazz) {
        return jv_0.a(map2, clazz);
    }

    @Deprecated
    private static <K, V, C extends Collection<V>> jv_0<K, V> b(Map<K, C> map2, fh_2<C> fh_22) {
        return jv_0.a(map2, fh_22);
    }

    private static <K, V> SortedMap<K, V> a(SortedMap<K, V> sortedMap) {
        return Collections.synchronizedSortedMap(sortedMap);
    }

    private static <K, V> SortedMap<K, V> b(SortedMap<K, ? extends V> sortedMap) {
        return jI.a(sortedMap);
    }

    private static <K, V> SortedMap<K, V> a(SortedMap<K, V> sortedMap, ff_1<? super K> ff_12, ff_1<? super V> ff_13) {
        return jy_0.a(sortedMap, ff_12, ff_13);
    }

    private static <K, V> SortedMap<K, V> a(SortedMap<K, V> sortedMap, fq_1<? super K, ? extends K> fq_12, fq_1<? super V, ? extends V> fq_13) {
        return jE.a(sortedMap, fq_12, fq_13);
    }

    private static <K, V> SortedMap<K, V> c(SortedMap<K, V> sortedMap) {
        return jm_0.a(sortedMap);
    }

    private static <K, V> SortedMap<K, V> a(SortedMap<K, V> sortedMap, fh_2<? extends V> fh_22) {
        return jr_0.a(sortedMap, fh_22);
    }

    private static <K, V> SortedMap<K, V> a(SortedMap<K, V> sortedMap, fq_1<? super K, ? extends V> fq_12) {
        return jr_0.a(sortedMap, fq_12);
    }

    private static <K, V> void a(Map<K, V> map2, Iterable<? extends V> object, fq_1<V, K> fq_12) {
        fq_1 fq_13 = hp_2.a();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            map2.put(fq_12.a(e2), fq_13.a(e2));
        }
    }

    private static <K, V, E> void a(Map<K, V> map2, Iterable<? extends E> object, fq_1<E, K> fq_12, fq_1<E, V> fq_13) {
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            map2.put(fq_12.a(e2), fq_13.a(e2));
        }
    }

    private static <K, V> void a(fw_2<K, V> fw_22, Iterable<? extends V> object, fq_1<V, K> fq_12) {
        fq_1 fq_13 = hp_2.a();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            fw_22.put(fq_12.a(e2), fq_13.a(e2));
        }
    }

    private static <K, V, E> void a(fw_2<K, V> fw_22, Iterable<? extends E> object, fq_1<E, K> fq_12, fq_1<E, V> fq_13) {
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            fw_22.put(fq_12.a(e2), (Object)fq_13.a(e2));
        }
    }

    public static <K, V> fn_2<K, V> a(Map<K, V> map2) {
        if (map2 == null) {
            throw new NullPointerException("Map must not be null");
        }
        if (map2 instanceof fn_2) {
            return (fn_2)map2;
        }
        return new jd_0<K, V>((Map)map2){};
    }

    private static <K, V> fo_2<K, V> d(SortedMap<K, V> sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException("Map must not be null");
        }
        if (sortedMap instanceof fo_2) {
            return (fo_2)sortedMap;
        }
        return new jg_0<K, V>((SortedMap)sortedMap){};
    }

    private static int l(Map<?, ?> map2) {
        if (map2 == null) {
            return 0;
        }
        return map2.size();
    }

    static {
        jI.a(new TreeMap());
    }
}

