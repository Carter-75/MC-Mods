/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.hw_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ii
 */
public abstract class ii_2<E>
implements Iterator<E> {
    private int a = 0;
    private boolean b = false;
    private Iterator<? extends E> c = null;
    private Iterator<? extends E> d = null;

    protected abstract Iterator<? extends E> a(int var1);

    private void a() {
        if (this.a == 0) {
            this.c = this.a(++this.a);
            if (this.c == null) {
                this.c = hw_1.b();
                this.b = true;
            }
            this.d = this.c;
        }
        while (!this.c.hasNext() && !this.b) {
            Iterator<E> iterator2;
            ii_2 ii_22 = this;
            if ((iterator2 = ii_22.a(++ii_22.a)) != null) {
                this.c = iterator2;
                continue;
            }
            this.b = true;
        }
    }

    @Override
    public boolean hasNext() {
        this.a();
        this.d = this.c;
        return this.c.hasNext();
    }

    @Override
    public E next() {
        this.a();
        this.d = this.c;
        return this.c.next();
    }

    @Override
    public void remove() {
        if (this.c == null) {
            this.a();
        }
        this.d.remove();
    }
}

