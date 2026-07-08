/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.gl_1;
import org.valkyrienskies.core.impl.shadow.gm_1;
import org.valkyrienskies.core.impl.shadow.gn_1;
import org.valkyrienskies.core.impl.shadow.gx_1;
import org.valkyrienskies.core.impl.shadow.ha_2;
import org.valkyrienskies.core.impl.shadow.hd_2;
import org.valkyrienskies.core.impl.shadow.hf_1;
import org.valkyrienskies.core.impl.shadow.hg_2;
import org.valkyrienskies.core.impl.shadow.hh_1;
import org.valkyrienskies.core.impl.shadow.hi_1;
import org.valkyrienskies.core.impl.shadow.hj_1;
import org.valkyrienskies.core.impl.shadow.hj_2;
import org.valkyrienskies.core.impl.shadow.hm_2;
import org.valkyrienskies.core.impl.shadow.hq_2;
import org.valkyrienskies.core.impl.shadow.hr_2;
import org.valkyrienskies.core.impl.shadow.hs_2;
import org.valkyrienskies.core.impl.shadow.ht_2;
import org.valkyrienskies.core.impl.shadow.hu_2;
import org.valkyrienskies.core.impl.shadow.hv_2;
import org.valkyrienskies.core.impl.shadow.hw_2;
import org.valkyrienskies.core.impl.shadow.hx_2;
import org.valkyrienskies.core.impl.shadow.hy_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fG
 */
public final class fg_1 {
    private fg_1() {
    }

    private static <T> ff_1<T> a() {
        return ha_2.a();
    }

    private static <T> ff_1<T> b() {
        return hi_1.a();
    }

    private static <T> ff_1<T> c() {
        return hd_2.a();
    }

    private static <T> ff_1<T> d() {
        return hw_2.a();
    }

    private static <T> ff_1<T> e() {
        return hr_2.a();
    }

    public static <T> ff_1<T> a(T t) {
        return gx_1.b(t);
    }

    private static <T> ff_1<T> b(T t) {
        return hg_2.b(t);
    }

    private static ff_1<Object> a(Class<?> clazz) {
        return hj_2.a(clazz);
    }

    private static <T> ff_1<T> f() {
        return hj_1.a();
    }

    private static <T> ff_1<T> a(String string) {
        string = hm_2.a(string);
        return hh_1.a(string);
    }

    private static <T> ff_1<T> a(String object, Class<?>[] classArray, Object[] objectArray) {
        object = hm_2.a((String)object, (Class[])classArray, (Object[])objectArray);
        return hh_1.a((fq_1)object);
    }

    private static <T> ff_1<T> a(ff_1<? super T> ff_12, ff_1<? super T> ff_13) {
        return gm_1.a(ff_12, ff_13);
    }

    private static <T> ff_1<T> a(ff_1<? super T> ... ff_1Array) {
        return gl_1.a(ff_1Array);
    }

    private static <T> ff_1<T> a(Collection<? extends ff_1<? super T>> collection) {
        return gl_1.a(collection);
    }

    private static <T> ff_1<T> b(ff_1<? super T> ff_12, ff_1<? super T> ff_13) {
        return hy_2.a(ff_12, ff_13);
    }

    private static <T> ff_1<T> b(ff_1<? super T> ... ff_1Array) {
        return gn_1.a(ff_1Array);
    }

    private static <T> ff_1<T> b(Collection<? extends ff_1<? super T>> collection) {
        return gn_1.a(collection);
    }

    private static <T> ff_1<T> c(ff_1<? super T> object, ff_1<? super T> ff_12) {
        object = new ff_1[]{object, ff_12};
        object = hx_2.a(object);
        return object;
    }

    private static <T> ff_1<T> c(ff_1<? super T> ... ff_1Array) {
        return hx_2.a(ff_1Array);
    }

    private static <T> ff_1<T> c(Collection<? extends ff_1<? super T>> collection) {
        return hx_2.a(collection);
    }

    private static <T> ff_1<T> d(ff_1<? super T> object, ff_1<? super T> ff_12) {
        object = new ff_1[]{object, ff_12};
        object = hq_2.a(object);
        return object;
    }

    private static <T> ff_1<T> d(ff_1<? super T> ... ff_1Array) {
        return hq_2.a(ff_1Array);
    }

    private static <T> ff_1<T> d(Collection<? extends ff_1<? super T>> collection) {
        return hq_2.a(collection);
    }

    public static <T> ff_1<T> a(ff_1<? super T> ff_12) {
        return hs_2.a(ff_12);
    }

    private static <T> ff_1<T> a(fq_1<? super T, Boolean> fq_12) {
        return hh_1.a(fq_12);
    }

    private static <T> ff_1<T> b(ff_1<? super T> ff_12) {
        return ht_2.a(ff_12);
    }

    private static <T> ff_1<T> c(ff_1<? super T> ff_12) {
        return hu_2.a(ff_12);
    }

    private static <T> ff_1<T> d(ff_1<? super T> ff_12) {
        return hv_2.a(ff_12);
    }

    private static <T> ff_1<T> a(fq_1<? super T, ? extends T> fq_12, ff_1<? super T> ff_12) {
        return hf_1.a(fq_12, ff_12);
    }
}

