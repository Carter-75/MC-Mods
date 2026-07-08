/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fj_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.in
 */
public class in_2<E>
implements fj_1<E> {
    final E[] a;
    final int b;
    private int d;
    int c = 0;

    public in_2(E ... EArray) {
        this(EArray, 0, EArray.length);
    }

    public in_2(E[] EArray, int n2) {
        this(EArray, n2, EArray.length);
    }

    public in_2(E[] EArray, int n2, int n3) {
        if (n2 < 0) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
        }
        if (n3 > EArray.length) {
            throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
        }
        if (n2 > EArray.length) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
        }
        if (n3 < n2) {
            throw new IllegalArgumentException("End index must not be less than start index");
        }
        this.a = EArray;
        this.b = n2;
        this.d = n3;
        this.c = n2;
    }

    @Override
    public boolean hasNext() {
        return this.c < this.d;
    }

    @Override
    public E next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.a[this.c++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
    }

    private E[] b() {
        return this.a;
    }

    public final int a() {
        return this.b;
    }

    private int d() {
        return this.d;
    }

    @Override
    public void c() {
        this.c = this.b;
    }
}

