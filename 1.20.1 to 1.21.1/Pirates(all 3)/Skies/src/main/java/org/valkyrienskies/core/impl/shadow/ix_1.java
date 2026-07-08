/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ix
 */
public final class ix_1<I, O>
implements Iterator<O> {
    private Iterator<? extends I> a;
    private fq_1<? super I, ? extends O> b;

    public ix_1() {
    }

    private ix_1(Iterator<? extends I> iterator2) {
        this.a = iterator2;
    }

    public ix_1(Iterator<? extends I> iterator2, fq_1<? super I, ? extends O> fq_12) {
        this.a = iterator2;
        this.b = fq_12;
    }

    @Override
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public final O next() {
        ix_1 ix_12 = this;
        I i2 = ix_12.a.next();
        ix_1 ix_13 = ix_12;
        return ix_12.b.a(i2);
    }

    @Override
    public final void remove() {
        this.a.remove();
    }

    private Iterator<? extends I> a() {
        return this.a;
    }

    private void a(Iterator<? extends I> iterator2) {
        this.a = iterator2;
    }

    private fq_1<? super I, ? extends O> b() {
        return this.b;
    }

    private void a(fq_1<? super I, ? extends O> fq_12) {
        this.b = fq_12;
    }

    private O a(I i2) {
        return this.b.a(i2);
    }
}

