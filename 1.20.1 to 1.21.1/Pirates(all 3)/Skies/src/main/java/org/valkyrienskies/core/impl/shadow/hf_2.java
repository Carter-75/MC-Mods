/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hf
 */
final class hf_2 {
    private hf_2() {
    }

    static <T> ff_1<T>[] a(ff_1<? super T> ... ff_1Array) {
        if (ff_1Array == null) {
            return null;
        }
        return (ff_1[])ff_1Array.clone();
    }

    static <T> ff_1<T> a(ff_1<? super T> ff_12) {
        return ff_12;
    }

    static void b(ff_1<?> ... ff_1Array) {
        if (ff_1Array == null) {
            throw new NullPointerException("The predicate array must not be null");
        }
        for (int i2 = 0; i2 < ff_1Array.length; ++i2) {
            if (ff_1Array[i2] != null) continue;
            throw new NullPointerException("The predicate array must not contain a null predicate, index " + i2 + " was null");
        }
    }

    static <T> ff_1<? super T>[] a(Collection<? extends ff_1<? super T>> object) {
        if (object == null) {
            throw new NullPointerException("The predicate collection must not be null");
        }
        ff_1[] ff_1Array = new ff_1[object.size()];
        int n2 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            ff_1 ff_12;
            ff_1Array[n2] = ff_12 = (ff_1)object.next();
            if (ff_1Array[n2] == null) {
                throw new NullPointerException("The predicate collection must not contain a null predicate, index " + n2 + " was null");
            }
            ++n2;
        }
        return ff_1Array;
    }

    static <E> fb_2<E>[] a(fb_2<? super E> ... fb_2Array) {
        if (fb_2Array == null) {
            return null;
        }
        return (fb_2[])fb_2Array.clone();
    }

    static void b(fb_2<?> ... fb_2Array) {
        if (fb_2Array == null) {
            throw new NullPointerException("The closure array must not be null");
        }
        for (int i2 = 0; i2 < fb_2Array.length; ++i2) {
            if (fb_2Array[i2] != null) continue;
            throw new NullPointerException("The closure array must not contain a null closure, index " + i2 + " was null");
        }
    }

    private static <T> fb_2<T> a(fb_2<? super T> fb_22) {
        return fb_22;
    }

    static <I, O> fq_1<I, O>[] a(fq_1<? super I, ? extends O> ... fq_1Array) {
        if (fq_1Array == null) {
            return null;
        }
        return (fq_1[])fq_1Array.clone();
    }

    static void b(fq_1<?, ?> ... fq_1Array) {
        if (fq_1Array == null) {
            throw new NullPointerException("The transformer array must not be null");
        }
        for (int i2 = 0; i2 < fq_1Array.length; ++i2) {
            if (fq_1Array[i2] != null) continue;
            throw new NullPointerException("The transformer array must not contain a null transformer, index " + i2 + " was null");
        }
    }

    private static <I, O> fq_1<I, O> a(fq_1<? super I, ? extends O> fq_12) {
        return fq_12;
    }
}

