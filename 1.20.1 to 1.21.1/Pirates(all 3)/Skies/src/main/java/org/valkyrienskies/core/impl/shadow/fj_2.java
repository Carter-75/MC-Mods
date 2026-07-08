/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fp_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fq_2;
import org.valkyrienskies.core.impl.shadow.iu_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fj
 */
public class fj_2<E>
implements Iterable<E> {
    public final Iterable<E> a;

    private static <T> fj_2<T> b() {
        return fp_2.a;
    }

    private static <T> fj_2<T> a(T t) {
        return fj_2.a(fq_2.a(new iu_1<T>(t, false)));
    }

    private static <T> fj_2<T> a(T ... TArray) {
        return fj_2.a(Arrays.asList(TArray));
    }

    public static <T> fj_2<T> a(Iterable<T> iterable) {
        fp_2.i(iterable);
        if (iterable instanceof fj_2) {
            return (fj_2)iterable;
        }
        return new fj_2<T>(iterable);
    }

    fj_2() {
        this.a = this;
    }

    private fj_2(Iterable<E> iterable) {
        this.a = iterable;
    }

    private fj_2<E> b(E ... object) {
        List<E> list = Arrays.asList(object);
        object = this;
        return fj_2.a(fp_2.a(object.a, list));
    }

    private fj_2<E> b(Iterable<? extends E> iterable) {
        return fj_2.a(fp_2.a(this.a, iterable));
    }

    private fj_2<E> c(Iterable<? extends E> iterable) {
        return fj_2.a(fp_2.b(this.a, iterable));
    }

    private fj_2<E> a(Iterable<? extends E> iterable, Comparator<? super E> comparator) {
        return fj_2.a(fp_2.a(comparator, this.a, iterable));
    }

    private fj_2<E> c() {
        fj_2 fj_22 = this;
        return fj_2.a(fp_2.g(fj_22.a));
    }

    private fj_2<E> a(ff_1<? super E> ff_12) {
        return fj_2.a(fp_2.a(this.a, ff_12));
    }

    private fj_2<E> a(long l2) {
        return fj_2.a(fp_2.a(this.a, (long)l2));
    }

    public final fj_2<E> a() {
        return fj_2.a(fp_2.a(this.a));
    }

    private fj_2<E> d() {
        return fj_2.a(fp_2.b(this.a));
    }

    private fj_2<E> b(long l2) {
        return fj_2.a(fp_2.b(this.a, (long)l2));
    }

    public final <O> fj_2<O> a(fq_1<? super E, ? extends O> fq_12) {
        return fj_2.a(fp_2.a(this.a, fq_12));
    }

    private fj_2<E> e() {
        return fj_2.a(fp_2.c(this.a));
    }

    private fj_2<E> f() {
        return fj_2.a(fp_2.d(this.a));
    }

    private fj_2<E> d(Iterable<? extends E> iterable) {
        return fj_2.a(fp_2.c(this.a, iterable));
    }

    private fj_2<E> a(Iterable<? extends E> ... iterableArray) {
        return fj_2.a(fp_2.a(this.a, (Iterable[])iterableArray));
    }

    @Override
    public Iterator<E> iterator() {
        return this.a.iterator();
    }

    private Enumeration<E> g() {
        return fq_2.b(this.iterator());
    }

    private boolean b(ff_1<? super E> ff_12) {
        return fp_2.d(this.a, ff_12);
    }

    private boolean c(ff_1<? super E> ff_12) {
        return fp_2.e(this.a, ff_12);
    }

    private boolean h() {
        return fp_2.e(this.a);
    }

    private boolean b(Object object) {
        return fp_2.a(this.a, object);
    }

    private void a(fb_2<? super E> fb_22) {
        fp_2.a(this.a, fb_22);
    }

    private E a(int n2) {
        return fp_2.a(this.a, n2);
    }

    private int i() {
        return fp_2.f(this.a);
    }

    private void a(Collection<? super E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null");
        }
        fd_2.a(collection, this.a);
    }

    private E[] a(Class<E> clazz) {
        return fq_2.a(this.iterator(), clazz);
    }

    private List<E> j() {
        return fp_2.g(this.a);
    }

    public String toString() {
        return fp_2.h(this.a);
    }
}

