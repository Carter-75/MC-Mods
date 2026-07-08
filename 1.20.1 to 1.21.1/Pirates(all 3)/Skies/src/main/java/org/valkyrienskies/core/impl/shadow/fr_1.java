/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.gq_1;
import org.valkyrienskies.core.impl.shadow.gr_1;
import org.valkyrienskies.core.impl.shadow.gs_1;
import org.valkyrienskies.core.impl.shadow.gv_1;
import org.valkyrienskies.core.impl.shadow.gx_1;
import org.valkyrienskies.core.impl.shadow.ha_1;
import org.valkyrienskies.core.impl.shadow.hb_2;
import org.valkyrienskies.core.impl.shadow.hc_1;
import org.valkyrienskies.core.impl.shadow.hc_2;
import org.valkyrienskies.core.impl.shadow.he_1;
import org.valkyrienskies.core.impl.shadow.hi_2;
import org.valkyrienskies.core.impl.shadow.hl_2;
import org.valkyrienskies.core.impl.shadow.hm_2;
import org.valkyrienskies.core.impl.shadow.hn_2;
import org.valkyrienskies.core.impl.shadow.hp_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fR
 */
public final class fr_1 {
    private fr_1() {
    }

    private static <I, O> fq_1<I, O> c() {
        return hb_2.a();
    }

    private static <I, O> fq_1<I, O> d() {
        return gv_1.a();
    }

    public static <T> fq_1<T, T> a() {
        return hp_2.a();
    }

    private static <T> fq_1<T, T> e() {
        return gr_1.a();
    }

    private static <I, O> fq_1<I, O> a(O o) {
        return gv_1.b(o);
    }

    private static <T> fq_1<T, T> a(fb_2<? super T> fb_22) {
        return gs_1.a(fb_22);
    }

    private static <T> fq_1<T, Boolean> a(ff_1<? super T> ff_12) {
        return ha_1.a(ff_12);
    }

    private static <I, O> fq_1<I, O> a(fh_2<? extends O> fh_22) {
        return hc_2.a(fh_22);
    }

    private static <T> fq_1<T, T> a(fq_1<? super T, ? extends T> ... fq_1Array) {
        return gq_1.a(fq_1Array);
    }

    private static <T> fq_1<T, T> a(Collection<? extends fq_1<? super T, ? extends T>> collection) {
        return gq_1.a(collection);
    }

    private static <T> fq_1<T, T> a(ff_1<? super T> ff_12, fq_1<? super T, ? extends T> fq_12) {
        return hi_2.a(ff_12, fq_12);
    }

    private static <I, O> fq_1<I, O> a(ff_1<? super I> ff_12, fq_1<? super I, ? extends O> fq_12, fq_1<? super I, ? extends O> fq_13) {
        return hi_2.a(ff_12, fq_12, fq_13);
    }

    @Deprecated
    private static <I, O> fq_1<I, O> b(ff_1<? super I> ff_12, fq_1<? super I, ? extends O> fq_12, fq_1<? super I, ? extends O> fq_13) {
        return he_1.a(new ff_1[]{ff_12}, new fq_1[]{fq_12}, fq_13);
    }

    private static <I, O> fq_1<I, O> a(ff_1<? super I>[] ff_1Array, fq_1<? super I, ? extends O>[] fq_1Array) {
        return he_1.a(ff_1Array, fq_1Array, null);
    }

    private static <I, O> fq_1<I, O> a(ff_1<? super I>[] ff_1Array, fq_1<? super I, ? extends O>[] fq_1Array, fq_1<? super I, ? extends O> fq_12) {
        return he_1.a(ff_1Array, fq_1Array, fq_12);
    }

    private static <I, O> fq_1<I, O> a(Map<ff_1<I>, fq_1<I, O>> map2) {
        return he_1.a(map2);
    }

    private static <I, O> fq_1<I, O> b(Map<I, fq_1<I, O>> ff_1Array) {
        if (ff_1Array == null) {
            throw new NullPointerException("The object and transformer map must not be null");
        }
        fq_1[] fq_1Array = (fq_1[])ff_1Array.remove(null);
        int n2 = ff_1Array.size();
        fq_1[] fq_1Array2 = new fq_1[n2];
        Object[] objectArray = new ff_1[n2];
        int n3 = 0;
        for (Map.Entry entry : ff_1Array.entrySet()) {
            objectArray[n3] = gx_1.b(entry.getKey());
            fq_1Array2[n3++] = (fq_1)entry.getValue();
        }
        ff_1[] ff_1Array2 = objectArray;
        objectArray = fq_1Array;
        fq_1Array = fq_1Array2;
        ff_1Array = ff_1Array2;
        return he_1.a(ff_1Array2, fq_1Array, objectArray);
    }

    private static <T> fq_1<Class<? extends T>, T> f() {
        return hl_2.a();
    }

    private static <T> fq_1<Class<? extends T>, T> a(Class<?>[] classArray, Object[] objectArray) {
        return hl_2.a((Class[])classArray, (Object[])objectArray);
    }

    private static <I, O> fq_1<I, O> c(Map<? super I, ? extends O> map2) {
        return hn_2.a(map2);
    }

    private static <I, O> fq_1<I, O> a(String string) {
        return hm_2.a((String)string, null, null);
    }

    private static <I, O> fq_1<I, O> a(String string, Class<?>[] classArray, Object[] objectArray) {
        return hm_2.a((String)string, (Class[])classArray, (Object[])objectArray);
    }

    public static <T> fq_1<T, String> b() {
        return hc_1.a();
    }
}

