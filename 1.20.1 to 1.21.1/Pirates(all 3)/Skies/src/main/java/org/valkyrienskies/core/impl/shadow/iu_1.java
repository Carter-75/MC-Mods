/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.fj_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iu
 */
public final class iu_1<E>
implements fj_1<E> {
    private final boolean a;
    private boolean b = true;
    private boolean c = false;
    private E d;

    public iu_1(E e2) {
        this(e2, true);
    }

    public iu_1(E e2, boolean bl) {
        this.d = e2;
        this.a = bl;
    }

    @Override
    public final boolean hasNext() {
        return this.b && !this.c;
    }

    @Override
    public final E next() {
        if (!this.b || this.c) {
            throw new NoSuchElementException();
        }
        this.b = false;
        return this.d;
    }

    @Override
    public final void remove() {
        if (this.a) {
            if (this.c || this.b) {
                throw new IllegalStateException();
            }
            this.d = null;
            this.c = true;
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public final void c() {
        this.b = true;
    }
}

