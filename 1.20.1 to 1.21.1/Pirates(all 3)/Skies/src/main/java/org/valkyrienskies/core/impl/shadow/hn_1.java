/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.hr_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hN
 */
public abstract class hn_1<E>
extends hr_1<E, E> {
    public hn_1(Iterator<E> iterator2) {
        super(iterator2);
    }

    @Override
    public E next() {
        return (E)this.a().next();
    }
}

