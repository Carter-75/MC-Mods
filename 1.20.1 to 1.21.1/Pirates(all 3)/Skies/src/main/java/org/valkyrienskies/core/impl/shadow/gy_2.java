/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fy_2;
import org.valkyrienskies.core.impl.shadow.ga_2;
import org.valkyrienskies.core.impl.shadow.gb_2;
import org.valkyrienskies.core.impl.shadow.gv_2;
import org.valkyrienskies.core.impl.shadow.hr_2;
import org.valkyrienskies.core.impl.shadow.iu_0;
import org.valkyrienskies.core.impl.shadow.jU;
import org.valkyrienskies.core.impl.shadow.jV;
import org.valkyrienskies.core.impl.shadow.kb_0;
import org.valkyrienskies.core.impl.shadow.kw_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gy
 */
public class gy_2<E>
extends gv_2<E> {
    private static final long b = -5259182142076705162L;
    protected final ff_1<? super E> a;

    private static <E> a<E> a(ff_1<? super E> ff_12) {
        return new a<E>(ff_12);
    }

    private static <E> a<E> a() {
        return new a(hr_2.a());
    }

    public static <T> gy_2<T> a(Collection<T> collection, ff_1<? super T> ff_12) {
        return new gy_2<T>(collection, ff_12);
    }

    public gy_2(Collection<E> object, ff_1<? super E> ff_12) {
        super(object);
        if (ff_12 == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        this.a = ff_12;
        object = object.iterator();
        while (object.hasNext()) {
            ff_12 = object.next();
            this.b(ff_12);
        }
    }

    public final void b(E e2) {
        if (!this.a.a(e2)) {
            throw new IllegalArgumentException("Cannot add Object '" + e2 + "' - Predicate '" + this.a + "' rejected it");
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean add(E object) {
        void var1_1;
        this.b(object);
        return this.f().add(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean addAll(Collection<? extends E> coll) {
        void var1_1;
        for (E e2 : coll) {
            this.b(e2);
        }
        return this.f().addAll(var1_1);
    }

    public static final class a<E> {
        private final ff_1<? super E> a;
        private final List<E> b = new ArrayList();
        private final List<E> c = new ArrayList();

        public a(ff_1<? super E> ff_12) {
            if (ff_12 == null) {
                throw new NullPointerException("Predicate must not be null");
            }
            this.a = ff_12;
        }

        private a<E> a(E e2) {
            if (this.a.a(e2)) {
                this.b.add(e2);
            } else {
                this.c.add(e2);
            }
            return this;
        }

        private a<E> a(Collection<? extends E> object) {
            if (object != null) {
                object = object.iterator();
                while (object.hasNext()) {
                    Object object2;
                    Object e2 = object2 = object.next();
                    object2 = this;
                    if (((a)object2).a.a(e2)) {
                        ((a)object2).b.add(e2);
                        continue;
                    }
                    ((a)object2).c.add(e2);
                }
            }
            return this;
        }

        private List<E> a() {
            List list = new ArrayList();
            a a2 = this;
            list = iu_0.a(list, a2.a);
            list.addAll(a2.b);
            return list;
        }

        private List<E> a(List<E> list) {
            list = iu_0.a(list, this.a);
            list.addAll(this.b);
            return list;
        }

        private Set<E> b() {
            Set set = new HashSet();
            a a2 = this;
            set = kw_0.a(set, a2.a);
            ((gv_2)((Object)set)).addAll(a2.b);
            return set;
        }

        private Set<E> a(Set<E> set) {
            set = kw_0.a(set, this.a);
            ((gv_2)((Object)set)).addAll(this.b);
            return set;
        }

        private fy_2<E> c() {
            fy_2 fy_22 = new jU();
            a a2 = this;
            fy_22 = jV.a(fy_22, a2.a);
            ((gv_2)((Object)fy_22)).addAll(a2.b);
            return fy_22;
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        private jV a(jU fy_22) {
            fy_22 = jV.a(fy_22, this.a);
            ((gv_2)((Object)fy_22)).addAll(this.b);
            return fy_22;
        }

        private ew_1<E> d() {
            ew_1 ew_12 = new ga_2();
            a a2 = this;
            ew_12 = gb_2.a(ew_12, a2.a);
            ((gv_2)((Object)ew_12)).addAll(a2.b);
            return ew_12;
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        private gb_2 a(ga_2 ew_12) {
            ew_12 = gb_2.a(ew_12, this.a);
            ((gv_2)((Object)ew_12)).addAll(this.b);
            return ew_12;
        }

        private Queue<E> e() {
            Serializable serializable = new LinkedList();
            a a2 = this;
            serializable = kb_0.a(serializable, a2.a);
            ((gv_2)serializable).addAll(a2.b);
            return serializable;
        }

        private Queue<E> a(Queue<E> queue) {
            queue = kb_0.a(queue, this.a);
            ((gv_2)((Object)queue)).addAll(this.b);
            return queue;
        }

        private Collection<E> f() {
            return Collections.unmodifiableCollection(this.c);
        }
    }
}

