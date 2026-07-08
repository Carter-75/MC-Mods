/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ir
 */
public final class ir_1<E>
implements Iterator<List<E>> {
    private final int[] a;
    private final Map<Integer, E> b;
    private final boolean[] c;
    private List<E> d;

    public ir_1(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        this.a = new int[collection.size()];
        this.c = new boolean[collection.size()];
        Arrays.fill(this.c, false);
        int n2 = 1;
        this.b = new HashMap<Integer, E>();
        for (E e2 : collection) {
            this.b.put(n2, e2);
            this.a[n2 - 1] = n2;
            ++n2;
        }
        this.d = new ArrayList<E>(collection);
    }

    @Override
    public final boolean hasNext() {
        return this.d != null;
    }

    public final List<E> a() {
        int n2;
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int n3 = -1;
        int n4 = -1;
        for (n2 = 0; n2 < this.a.length; ++n2) {
            if ((!this.c[n2] || n2 >= this.a.length - 1 || this.a[n2] <= this.a[n2 + 1]) && (this.c[n2] || n2 <= 0 || this.a[n2] <= this.a[n2 - 1]) || this.a[n2] <= n4) continue;
            n4 = this.a[n2];
            n3 = n2;
        }
        if (n4 == -1) {
            List<E> list = this.d;
            this.d = null;
            return list;
        }
        n2 = this.c[n3] ? 1 : -1;
        int n5 = this.a[n3];
        this.a[n3] = this.a[n3 + n2];
        this.a[n3 + n2] = n5;
        n5 = this.c[n3];
        this.c[n3] = this.c[n3 + n2];
        this.c[n3 + n2] = n5;
        ArrayList<E> arrayList = new ArrayList<E>();
        for (n2 = 0; n2 < this.a.length; ++n2) {
            if (this.a[n2] > n4) {
                this.c[n2] = !this.c[n2];
            }
            arrayList.add(this.b.get(this.a[n2]));
        }
        List<E> list = this.d;
        this.d = arrayList;
        return list;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override
    public final /* synthetic */ Object next() {
        return this.a();
    }
}

