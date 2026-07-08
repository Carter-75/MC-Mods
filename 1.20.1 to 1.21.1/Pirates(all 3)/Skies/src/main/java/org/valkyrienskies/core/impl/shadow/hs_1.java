/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fj_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hS
 */
public class hs_1<E>
implements fj_1<E> {
    final Object a;
    final int b;
    private int d;
    int c = 0;

    public hs_1(Object object) {
        this(object, 0);
    }

    public hs_1(Object object, int n2) {
        this(object, n2, Array.getLength(object));
    }

    public hs_1(Object object, int n2, int n3) {
        this.a = object;
        this.b = n2;
        this.d = n3;
        this.c = n2;
        int n4 = Array.getLength(object);
        hs_1.a(n2, n4, "start");
        hs_1.a(n3, n4, "end");
        if (n3 < n2) {
            throw new IllegalArgumentException("End index must not be less than start index.");
        }
    }

    private static void a(int n2, int n3, String string) {
        if (n2 > n3) {
            throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + string + "s beyond the end of the array. ");
        }
        if (n2 < 0) {
            throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + string + "s before the start of the array. ");
        }
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
        return (E)Array.get(this.a, this.c++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    private Object a() {
        return this.a;
    }

    private int b() {
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

