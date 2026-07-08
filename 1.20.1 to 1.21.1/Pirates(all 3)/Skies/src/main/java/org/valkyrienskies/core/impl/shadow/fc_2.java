/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.gp_1;
import org.valkyrienskies.core.impl.shadow.gx_1;
import org.valkyrienskies.core.impl.shadow.gy_1;
import org.valkyrienskies.core.impl.shadow.hd_1;
import org.valkyrienskies.core.impl.shadow.he_2;
import org.valkyrienskies.core.impl.shadow.hg_1;
import org.valkyrienskies.core.impl.shadow.hh_2;
import org.valkyrienskies.core.impl.shadow.hk_1;
import org.valkyrienskies.core.impl.shadow.hm_2;
import org.valkyrienskies.core.impl.shadow.ho_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fc
 */
public final class fc_2 {
    private fc_2() {
    }

    private static <E> fb_2<E> a() {
        return gy_1.a();
    }

    private static <E> fb_2<E> b() {
        return ho_2.a();
    }

    private static <E> fb_2<E> a(fq_1<? super E, ?> fq_12) {
        return hg_1.a(fq_12);
    }

    private static <E> fb_2<E> a(int n2, fb_2<? super E> fb_22) {
        if (n2 <= 0 || fb_22 == null) {
            return ho_2.a();
        }
        if (n2 == 1) {
            return fb_22;
        }
        return new he_2<E>(n2, fb_22);
    }

    private static <E> fb_2<E> a(ff_1<? super E> ff_12, fb_2<? super E> fb_22) {
        return hk_1.a(ff_12, fb_22, (boolean)false);
    }

    private static <E> fb_2<E> a(fb_2<? super E> fb_22, ff_1<? super E> ff_12) {
        return hk_1.a(ff_12, fb_22, (boolean)true);
    }

    private static <E> fb_2<E> a(String string) {
        string = hm_2.a(string);
        return hg_1.a(string);
    }

    private static <E> fb_2<E> a(String object, Class<?>[] classArray, Object[] objectArray) {
        object = hm_2.a((String)object, (Class[])classArray, (Object[])objectArray);
        return hg_1.a(object);
    }

    private static <E> fb_2<E> a(fb_2<? super E> ... fb_2Array) {
        return gp_1.a(fb_2Array);
    }

    private static <E> fb_2<E> a(Collection<? extends fb_2<? super E>> collection) {
        return gp_1.a(collection);
    }

    private static <E> fb_2<E> b(ff_1<? super E> ff_12, fb_2<? super E> fb_22) {
        return hh_2.a(ff_12, fb_22);
    }

    private static <E> fb_2<E> a(ff_1<? super E> ff_12, fb_2<? super E> fb_22, fb_2<? super E> fb_23) {
        return hh_2.a(ff_12, fb_22, fb_23);
    }

    private static <E> fb_2<E> a(ff_1<? super E>[] ff_1Array, fb_2<? super E>[] fb_2Array) {
        return hd_1.a(ff_1Array, fb_2Array, null);
    }

    private static <E> fb_2<E> a(ff_1<? super E>[] ff_1Array, fb_2<? super E>[] fb_2Array, fb_2<? super E> fb_22) {
        return hd_1.a(ff_1Array, fb_2Array, fb_22);
    }

    private static <E> fb_2<E> a(Map<ff_1<E>, fb_2<E>> map2) {
        return hd_1.a(map2);
    }

    private static <E> fb_2<E> b(Map<? extends E, fb_2<E>> ff_1Array) {
        if (ff_1Array == null) {
            throw new NullPointerException("The object and closure map must not be null");
        }
        fb_2[] fb_2Array = (fb_2[])ff_1Array.remove(null);
        int n2 = ff_1Array.size();
        fb_2[] fb_2Array2 = new fb_2[n2];
        Object[] objectArray = new ff_1[n2];
        int n3 = 0;
        for (Map.Entry entry : ff_1Array.entrySet()) {
            objectArray[n3] = gx_1.b(entry.getKey());
            fb_2Array2[n3] = (fb_2)entry.getValue();
            ++n3;
        }
        ff_1[] ff_1Array2 = objectArray;
        objectArray = fb_2Array;
        fb_2Array = fb_2Array2;
        ff_1Array = ff_1Array2;
        return hd_1.a(ff_1Array2, fb_2Array, objectArray);
    }
}

