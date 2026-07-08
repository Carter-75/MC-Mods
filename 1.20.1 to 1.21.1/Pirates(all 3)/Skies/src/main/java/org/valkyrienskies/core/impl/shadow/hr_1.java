/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hR
 */
public abstract class hr_1<I, O>
implements Iterator<O> {
    private final Iterator<I> a;

    public hr_1(Iterator<I> iterator2) {
        if (iterator2 == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.a = iterator2;
    }

    protected final Iterator<I> a() {
        return this.a;
    }

    @Override
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public void remove() {
        this.a.remove();
    }
}

