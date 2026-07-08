/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.hn_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iw
 */
public final class iw_1<E>
extends hn_1<E> {
    private final long a;
    private long b;

    public iw_1(Iterator<E> iw_12, long l2) {
        super(iw_12);
        if (l2 < 0L) {
            throw new IllegalArgumentException("Offset parameter must not be negative.");
        }
        this.a = l2;
        this.b = 0L;
        iw_12 = this;
        while (iw_12.b < iw_12.a && iw_12.hasNext()) {
            ((hn_1)iw_12).next();
        }
    }

    private void b() {
        while (this.b < this.a && this.hasNext()) {
            ((hn_1)this).next();
        }
    }

    @Override
    public final E next() {
        Object e2 = super.next();
        ++this.b;
        return e2;
    }

    @Override
    public final void remove() {
        if (this.b <= this.a) {
            throw new IllegalStateException("remove() can not be called before calling next()");
        }
        super.remove();
    }
}

