/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.fa_1;
import org.valkyrienskies.core.impl.shadow.fm_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.ft_2;
import org.valkyrienskies.core.impl.shadow.ga_2;
import org.valkyrienskies.core.impl.shadow.jN;
import org.valkyrienskies.core.impl.shadow.jO;
import org.valkyrienskies.core.impl.shadow.jP;
import org.valkyrienskies.core.impl.shadow.jQ;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fx
 */
public final class fx_2 {
    private static jQ a = jQ.b(new jN(0, 0));

    private fx_2() {
    }

    private static <K, V> fa_1<K, V> a() {
        return a;
    }

    private static <K, V> fa_1<K, V> a(fa_1<K, V> fa_12) {
        if (fa_12 == null) {
            return a;
        }
        return fa_12;
    }

    private static boolean b(fa_1<?, ?> fa_12) {
        return fa_12 == null || fa_12.b();
    }

    private static <K, V> Collection<V> a(fa_1<K, V> fa_12, K k2) {
        if (fa_12 != null) {
            return fa_12.e(k2);
        }
        return null;
    }

    private static <K, V> List<V> b(fa_1<K, V> object, K k2) {
        if (object != null) {
            if ((object = object.e(k2)) instanceof List) {
                return (List)object;
            }
            return new ArrayList(object);
        }
        return null;
    }

    private static <K, V> Set<V> c(fa_1<K, V> object, K k2) {
        if (object != null) {
            if ((object = object.e(k2)) instanceof Set) {
                return (Set)object;
            }
            return new HashSet(object);
        }
        return null;
    }

    private static <K, V> ew_1<V> d(fa_1<K, V> object, K k2) {
        if (object != null) {
            if ((object = object.e(k2)) instanceof ew_1) {
                return (ew_1)object;
            }
            return new ga_2(object);
        }
        return null;
    }

    private static <K, V> ft_2<K, V> b() {
        return new jN();
    }

    private static <K, V> fm_1<K, V> c() {
        return new jO();
    }

    private static <K, V> fa_1<K, V> c(fa_1<? extends K, ? extends V> fa_12) {
        return jQ.b(fa_12);
    }

    private static <K, V> fa_1<K, V> a(fa_1<K, V> fa_12, fq_1<? super K, ? extends K> fq_12, fq_1<? super V, ? extends V> fq_13) {
        return jP.a(fa_12, fq_12, fq_13);
    }
}

