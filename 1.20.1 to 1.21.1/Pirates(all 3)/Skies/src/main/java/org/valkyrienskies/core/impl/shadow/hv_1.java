/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.iy_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hV
 */
public final class hv_1<E>
implements Iterator<E> {
    private Comparator<? super E> a = null;
    private List<Iterator<? extends E>> b = null;
    private List<E> c = null;
    private BitSet d = null;
    private int e = -1;

    public hv_1() {
        this(null, 2);
    }

    private hv_1(Comparator<? super E> comparator) {
        this(comparator, 2);
    }

    private hv_1(Comparator<? super E> object, int n2) {
        this.b = new ArrayList<Iterator<? extends E>>(n2);
        Comparator<E> comparator = object;
        object = this;
        ((hv_1)object).e();
        ((hv_1)object).a = comparator;
    }

    public hv_1(Comparator<? super E> comparator, Iterator<? extends E> iterator2, Iterator<? extends E> iterator3) {
        this(comparator, 2);
        this.a(iterator2);
        this.a(iterator3);
    }

    public hv_1(Comparator<? super E> iteratorArray, Iterator<? extends E>[] iteratorArray2) {
        this((Comparator<? extends E>)iteratorArray, iteratorArray2.length);
        iteratorArray = iteratorArray2;
        int n2 = iteratorArray2.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Iterator<? extends E> iterator2 = iteratorArray[i2];
            this.a(iterator2);
        }
    }

    public hv_1(Comparator<? super E> object, Collection<Iterator<? extends E>> object2) {
        this((Comparator<E>)object, object2.size());
        object = object2.iterator();
        while (object.hasNext()) {
            object2 = (Iterator)object.next();
            this.a((Iterator<E>)object2);
        }
    }

    private void a(Iterator<? extends E> iterator2) {
        this.e();
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.b.add(iterator2);
    }

    private void a(int n2, Iterator<? extends E> iterator2) {
        this.e();
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.b.set(n2, iterator2);
    }

    private List<Iterator<? extends E>> a() {
        return iy_0.a(this.b);
    }

    private Comparator<? super E> b() {
        return this.a;
    }

    private void a(Comparator<? super E> comparator) {
        this.e();
        this.a = comparator;
    }

    @Override
    public final boolean hasNext() {
        block10: {
            block9: {
                boolean bl;
                block8: {
                    boolean bl2;
                    Iterator<E> iterator2;
                    block7: {
                        int n2;
                        iterator2 = this;
                        if (((hv_1)iterator2).c == null) {
                            ((hv_1)iterator2).c = new ArrayList(((hv_1)iterator2).b.size());
                            ((hv_1)iterator2).d = new BitSet(((hv_1)iterator2).b.size());
                            for (n2 = 0; n2 < ((hv_1)iterator2).b.size(); ++n2) {
                                ((hv_1)iterator2).c.add(null);
                                ((hv_1)iterator2).d.clear(n2);
                            }
                        }
                        iterator2 = this.d;
                        for (n2 = 0; n2 < ((BitSet)((Object)iterator2)).size(); ++n2) {
                            if (!((BitSet)((Object)iterator2)).get(n2)) continue;
                            bl2 = true;
                            break block7;
                        }
                        bl2 = false;
                    }
                    if (bl2) break block9;
                    iterator2 = this.b;
                    Iterator<Iterator<E>> iterator3 = iterator2.iterator();
                    while (iterator3.hasNext()) {
                        iterator2 = iterator3.next();
                        if (!iterator2.hasNext()) continue;
                        bl = true;
                        break block8;
                    }
                    bl = false;
                }
                if (!bl) break block10;
            }
            return true;
        }
        return false;
    }

    @Override
    public final E next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        hv_1 hv_12 = this;
        int n2 = -1;
        hv_1<E> hv_13 = null;
        for (int i2 = 0; i2 < hv_12.c.size(); ++i2) {
            hv_1<E> hv_14;
            if (!hv_12.d.get(i2)) {
                boolean bl;
                int n3 = i2;
                hv_14 = hv_12;
                Iterator<E> iterator2 = hv_14.b.get(n3);
                if (iterator2.hasNext()) {
                    hv_14.c.set(n3, iterator2.next());
                    hv_14.d.set(n3);
                    bl = true;
                } else {
                    hv_14.c.set(n3, null);
                    hv_14.d.clear(n3);
                    bl = false;
                }
            }
            if (!hv_12.d.get(i2)) continue;
            if (n2 == -1) {
                n2 = i2;
                hv_13 = (hv_1<E>)hv_12.c.get(i2);
                continue;
            }
            hv_14 = hv_12.c.get(i2);
            if (hv_12.a == null) {
                throw new NullPointerException("You must invoke setComparator() to set a comparator first.");
            }
            if (hv_12.a.compare(hv_14, hv_13) >= 0) continue;
            hv_13 = hv_14;
            n2 = i2;
        }
        int n4 = n2;
        if (n4 == -1) {
            throw new NoSuchElementException();
        }
        E e2 = this.c.get(n4);
        n2 = n4;
        hv_12 = this;
        hv_12.c.set(n2, null);
        hv_12.d.clear(n2);
        this.e = n4;
        return e2;
    }

    @Override
    public final void remove() {
        if (this.e == -1) {
            throw new IllegalStateException("No value can be removed at present");
        }
        this.b.get(this.e).remove();
    }

    private int c() {
        if (this.e == -1) {
            throw new IllegalStateException("No value has been returned yet");
        }
        return this.e;
    }

    private void d() {
        if (this.c == null) {
            this.c = new ArrayList(this.b.size());
            this.d = new BitSet(this.b.size());
            for (int i2 = 0; i2 < this.b.size(); ++i2) {
                this.c.add(null);
                this.d.clear(i2);
            }
        }
    }

    private boolean a(int n2) {
        Iterator<E> iterator2 = this.b.get(n2);
        if (iterator2.hasNext()) {
            this.c.set(n2, iterator2.next());
            this.d.set(n2);
            return true;
        }
        this.c.set(n2, null);
        this.d.clear(n2);
        return false;
    }

    private void b(int n2) {
        this.c.set(n2, null);
        this.d.clear(n2);
    }

    private void e() {
        if (this.c != null) {
            throw new IllegalStateException("Can't do that after next or hasNext has been called.");
        }
    }

    private int f() {
        int n2 = -1;
        Object t = null;
        for (int i2 = 0; i2 < this.c.size(); ++i2) {
            if (!this.d.get(i2)) {
                this.a(i2);
            }
            if (!this.d.get(i2)) continue;
            if (n2 == -1) {
                n2 = i2;
                t = this.c.get(i2);
                continue;
            }
            E e2 = this.c.get(i2);
            if (this.a == null) {
                throw new NullPointerException("You must invoke setComparator() to set a comparator first.");
            }
            if (this.a.compare(e2, t) >= 0) continue;
            t = e2;
            n2 = i2;
        }
        return n2;
    }

    private static boolean a(BitSet bitSet) {
        for (int i2 = 0; i2 < bitSet.size(); ++i2) {
            if (!bitSet.get(i2)) continue;
            return true;
        }
        return false;
    }

    private static boolean a(List<Iterator<? extends E>> object) {
        object = object.iterator();
        while (object.hasNext()) {
            Iterator iterator2 = (Iterator)object.next();
            if (!iterator2.hasNext()) continue;
            return true;
        }
        return false;
    }
}

