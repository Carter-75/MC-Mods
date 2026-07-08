/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fp$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.fb_2;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fg_2;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.fj_2;
import org.valkyrienskies.core.impl.shadow.fp;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fq_2;
import org.valkyrienskies.core.impl.shadow.gx_1;
import org.valkyrienskies.core.impl.shadow.hk_2;
import org.valkyrienskies.core.impl.shadow.ii_2;
import org.valkyrienskies.core.impl.shadow.it_1;
import org.valkyrienskies.core.impl.shadow.iy_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fp
 */
public final class fp_2 {
    static final 1_0 a = new fj_2<Object>(){

        @Override
        public final Iterator<Object> iterator() {
            return fq_2.a();
        }
    };

    private static <E> Iterable<E> a() {
        return a;
    }

    public static <E> Iterable<E> a(Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        return fp_2.a((Iterable[])new Iterable[]{iterable, iterable2});
    }

    private static <E> Iterable<E> a(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3) {
        return fp_2.a((Iterable[])new Iterable[]{iterable, iterable2, iterable3});
    }

    private static <E> Iterable<E> a(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3, Iterable<? extends E> iterable4) {
        return fp_2.a((Iterable[])new Iterable[]{iterable, iterable2, iterable3, iterable4});
    }

    private static <E> Iterable<E> a(final Iterable<? extends E> ... iterableArray) {
        fp_2.b(iterableArray);
        return new fj_2<E>(){

            @Override
            public final Iterator<E> iterator() {
                return new ii_2<E>(this){
                    private /* synthetic */ 6 a;
                    {
                        this.a = var1_1;
                    }

                    @Override
                    public final Iterator<? extends E> a(int n2) {
                        if (n2 > this.a.iterableArray.length) {
                            return null;
                        }
                        return this.a.iterableArray[n2 - 1].iterator();
                    }
                };
            }
        };
    }

    public static <E> Iterable<E> b(Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        fp_2.b(new Iterable[]{iterable, iterable2});
        return new fj_2<E>(iterable, iterable2){
            private /* synthetic */ Iterable b;
            private /* synthetic */ Iterable c;
            {
                this.b = iterable;
                this.c = iterable2;
            }

            @Override
            public final Iterator<E> iterator() {
                return fq_2.a(null, this.b.iterator(), this.c.iterator());
            }
        };
    }

    public static <E> Iterable<E> a(Comparator<? super E> comparator, Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        fp_2.b(new Iterable[]{iterable, iterable2});
        return new fj_2<E>(comparator, iterable, iterable2){
            private /* synthetic */ Comparator b;
            private /* synthetic */ Iterable c;
            private /* synthetic */ Iterable d;
            {
                this.b = comparator;
                this.c = iterable;
                this.d = iterable2;
            }

            @Override
            public final Iterator<E> iterator() {
                return fq_2.a((Comparator)this.b, this.c.iterator(), this.d.iterator());
            }
        };
    }

    public static <E> Iterable<E> a(Iterable<E> iterable, ff_1<? super E> ff_12) {
        fp_2.i(iterable);
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        return new fj_2<E>(iterable, ff_12){
            private /* synthetic */ Iterable b;
            private /* synthetic */ ff_1 c;
            {
                this.b = iterable;
                this.c = ff_12;
            }

            @Override
            public final Iterator<E> iterator() {
                return fq_2.a((Iterator)fp_2.m(this.b), (ff_1)this.c);
            }
        };
    }

    public static <E> Iterable<E> a(Iterable<E> iterable, long l2) {
        fp_2.i(iterable);
        if (l2 < 0L) {
            throw new IllegalArgumentException("MaxSize parameter must not be negative.");
        }
        return new fj_2<E>(iterable, l2){
            private /* synthetic */ Iterable b;
            private /* synthetic */ long c;
            {
                this.b = iterable;
                this.c = l2;
            }

            @Override
            public final Iterator<E> iterator() {
                return fq_2.a(this.b.iterator(), this.c);
            }
        };
    }

    public static <E> Iterable<E> a(final Iterable<E> iterable) {
        fp_2.i(iterable);
        return new fj_2<E>(){

            @Override
            public final Iterator<E> iterator() {
                return new ii_2<E>(this){
                    private /* synthetic */ 11 a;
                    {
                        this.a = var1_1;
                    }

                    @Override
                    public final Iterator<? extends E> a(int n2) {
                        if (fp_2.e(this.a.iterable)) {
                            return null;
                        }
                        return this.a.iterable.iterator();
                    }
                };
            }
        };
    }

    public static <E> Iterable<E> b(Iterable<E> iterable) {
        fp_2.i(iterable);
        return new fj_2<E>(iterable){
            private /* synthetic */ Iterable b;
            {
                this.b = iterable;
            }

            @Override
            public final Iterator<E> iterator() {
                List list = this.b instanceof List ? (List)this.b : fq_2.c(this.b.iterator());
                return new it_1(list);
            }
        };
    }

    public static <E> Iterable<E> b(Iterable<E> iterable, long l2) {
        fp_2.i(iterable);
        if (l2 < 0L) {
            throw new IllegalArgumentException("ElementsToSkip parameter must not be negative.");
        }
        return new fj_2<E>(iterable, l2){
            private /* synthetic */ Iterable b;
            private /* synthetic */ long c;
            {
                this.b = iterable;
                this.c = l2;
            }

            @Override
            public final Iterator<E> iterator() {
                return fq_2.b(this.b.iterator(), this.c);
            }
        };
    }

    public static <I, O> Iterable<O> a(Iterable<I> iterable, fq_1<? super I, ? extends O> fq_12) {
        fp_2.i(iterable);
        if (fq_12 == null) {
            throw new NullPointerException("Transformer must not be null.");
        }
        return new fj_2<O>(iterable, fq_12){
            private /* synthetic */ Iterable b;
            private /* synthetic */ fq_1 c;
            {
                this.b = iterable;
                this.c = fq_12;
            }

            @Override
            public final Iterator<O> iterator() {
                return fq_2.a(this.b.iterator(), (fq_1)this.c);
            }
        };
    }

    public static <E> Iterable<E> c(Iterable<E> iterable) {
        fp_2.i(iterable);
        return new fj_2<E>(iterable){
            private /* synthetic */ Iterable b;
            {
                this.b = iterable;
            }

            @Override
            public final Iterator<E> iterator() {
                return new iy_1(this.b.iterator());
            }
        };
    }

    public static <E> Iterable<E> d(Iterable<E> iterable) {
        fp_2.i(iterable);
        if (iterable instanceof fp.a) {
            return iterable;
        }
        return new fp.a(iterable);
    }

    public static <E> Iterable<E> c(Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        fp_2.i(iterable);
        fp_2.i(iterable2);
        return new fj_2<E>(iterable, iterable2){
            private /* synthetic */ Iterable b;
            private /* synthetic */ Iterable c;
            {
                this.b = iterable;
                this.c = iterable2;
            }

            @Override
            public final Iterator<E> iterator() {
                return fq_2.b(this.b.iterator(), this.c.iterator());
            }
        };
    }

    public static <E> Iterable<E> a(Iterable<? extends E> iterable, Iterable<? extends E> ... iterableArray) {
        fp_2.i(iterable);
        fp_2.b(iterableArray);
        return new fj_2<E>(iterableArray, iterable){
            private /* synthetic */ Iterable[] b;
            private /* synthetic */ Iterable c;
            {
                this.b = iterableArray;
                this.c = iterable;
            }

            @Override
            public final Iterator<E> iterator() {
                Iterator[] iteratorArray = new Iterator[this.b.length + 1];
                Iterator[] iteratorArray2 = iteratorArray;
                iteratorArray[0] = this.c.iterator();
                for (int i2 = 0; i2 < this.b.length; ++i2) {
                    iteratorArray2[i2 + 1] = this.b[i2].iterator();
                }
                return fq_2.a(iteratorArray2);
            }
        };
    }

    private static <E> Iterable<E> k(Iterable<E> iterable) {
        if (iterable == null) {
            return a;
        }
        return iterable;
    }

    public static <E> void a(Iterable<E> iterable, fb_2<? super E> fb_22) {
        fq_2.a(fp_2.m(iterable), fb_22);
    }

    public static <E> E b(Iterable<E> iterable, fb_2<? super E> fb_22) {
        return fq_2.b(fp_2.m(iterable), fb_22);
    }

    public static <E> E b(Iterable<E> iterable, ff_1<? super E> ff_12) {
        return fq_2.b(fp_2.m(iterable), ff_12);
    }

    public static <E> int c(Iterable<E> iterable, ff_1<? super E> ff_12) {
        return fq_2.c(fp_2.m(iterable), ff_12);
    }

    public static <E> boolean d(Iterable<E> iterable, ff_1<? super E> ff_12) {
        return fq_2.e(fp_2.m(iterable), ff_12);
    }

    public static <E> boolean e(Iterable<E> iterable, ff_1<? super E> ff_12) {
        return fq_2.d(fp_2.m(iterable), ff_12);
    }

    public static <E> long f(Iterable<E> iterable, ff_1<? super E> ff_12) {
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        return fp_2.f(fp_2.a(fp_2.k(iterable), ff_12));
    }

    public static boolean e(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection)iterable).isEmpty();
        }
        return fq_2.d(fp_2.m(iterable));
    }

    public static <E> boolean a(Iterable<E> iterable, Object object) {
        if (iterable instanceof Collection) {
            return ((Collection)iterable).contains(object);
        }
        return fq_2.a(fp_2.m(iterable), object);
    }

    private static <E> boolean a(Iterable<? extends E> iterable, E e2, fg_2<? super E> fg_22) {
        if (fg_22 == null) {
            throw new NullPointerException("Equator must not be null.");
        }
        return fp_2.e(iterable, gx_1.a(e2, fg_22));
    }

    public static <E, T extends E> int b(Iterable<E> iterable, T t) {
        if (iterable instanceof Set) {
            if (((Set)iterable).contains(t)) {
                return 1;
            }
            return 0;
        }
        if (iterable instanceof ew_1) {
            return ((ew_1)iterable).a(t);
        }
        return fp_2.f(fp_2.a(fp_2.k(iterable), gx_1.b(t)));
    }

    public static <T> T a(Iterable<T> iterable, int n2) {
        fd_2.a(n2);
        if (iterable instanceof List) {
            return (T)((List)iterable).get(n2);
        }
        return fq_2.b(fp_2.m(iterable), n2);
    }

    private static <T> T l(Iterable<T> iterable) {
        return fp_2.a(iterable, 0);
    }

    public static int f(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection)iterable).size();
        }
        return fq_2.e(fp_2.m(iterable));
    }

    private static <O> List<List<O>> g(Iterable<? extends O> iterable, ff_1<? super O> ff_1Array) {
        if (ff_1Array == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        Object object = ArrayList.class;
        object = hk_2.a(ArrayList.class, null, null);
        ff_1Array = new ff_1[]{ff_1Array};
        return fp_2.a(iterable, object, ff_1Array);
    }

    private static <O> List<List<O>> a(Iterable<? extends O> iterable, ff_1<? super O> ... ff_1Array) {
        Object object = ArrayList.class;
        object = hk_2.a(ArrayList.class, null, null);
        return fp_2.a(iterable, object, ff_1Array);
    }

    /*
     * WARNING - void declaration
     */
    private static <O, R extends Collection<O>> List<R> a(Iterable<? extends O> object3, fh_2<R> fh_22, ff_1<? super O> ... ff_1Array) {
        void var1_5;
        void var2_7;
        Iterable<Object> iterable;
        void var0_1;
        while (var0_1 == null) {
            1_0 _0 = iterable = a;
        }
        if (var2_7 == null) {
            throw new NullPointerException("Predicates must not be null.");
        }
        for (1_0 _0 : var2_7) {
            if (_0 != null) continue;
            throw new NullPointerException("Predicate must not be null.");
        }
        if (((void)var2_7).length <= 0) {
            iterable = (Collection)var1_5.a();
            fd_2.a(iterable, var0_1);
            return Collections.singletonList(iterable);
        }
        int n2 = ((void)var2_7).length;
        int n3 = n2 + 1;
        ArrayList arrayList = new ArrayList(n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            arrayList.add(var1_5.a());
        }
        for (Object t : var0_1) {
            boolean bl = false;
            for (n3 = 0; n3 < n2; ++n3) {
                if (!var2_7[n3].a(t)) continue;
                ((Collection)arrayList.get(n3)).add(t);
                bl = true;
                break;
            }
            if (bl) continue;
            ((Collection)arrayList.get(n2)).add(t);
        }
        return arrayList;
    }

    public static <E> List<E> g(Iterable<E> iterable) {
        return fq_2.c(fp_2.m(iterable));
    }

    public static <E> String h(Iterable<E> iterable) {
        return fq_2.f(fp_2.m(iterable));
    }

    private static <E> String b(Iterable<E> iterable, fq_1<? super E, String> fq_12) {
        if (fq_12 == null) {
            throw new NullPointerException("Transformer must not be null.");
        }
        return fq_2.b(fp_2.m(iterable), fq_12);
    }

    private static <E> String a(Iterable<E> iterable, fq_1<? super E, String> fq_12, String string, String string2, String string3) {
        return fq_2.a(fp_2.m(iterable), fq_12, string, string2, string3);
    }

    static void i(Iterable<?> iterable) {
        if (iterable == null) {
            throw new NullPointerException("Iterable must not be null.");
        }
    }

    private static void b(Iterable<?> ... iterableArray) {
        if (iterableArray == null) {
            throw new NullPointerException("Iterables must not be null.");
        }
        for (Iterable<?> iterable : iterableArray) {
            fp_2.i(iterable);
        }
    }

    private static <E> Iterator<E> m(Iterable<E> iterable) {
        if (iterable != null) {
            return iterable.iterator();
        }
        return fq_2.a();
    }
}

