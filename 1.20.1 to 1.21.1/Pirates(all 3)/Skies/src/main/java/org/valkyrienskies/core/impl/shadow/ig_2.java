/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Enumeration;
import java.util.Iterator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ig
 */
public final class ig_2<E>
implements Enumeration<E> {
    private Iterator<? extends E> a;

    public ig_2() {
    }

    public ig_2(Iterator<? extends E> iterator2) {
        this.a = iterator2;
    }

    @Override
    public final boolean hasMoreElements() {
        return this.a.hasNext();
    }

    @Override
    public final E nextElement() {
        return this.a.next();
    }

    private Iterator<? extends E> a() {
        return this.a;
    }

    private void a(Iterator<? extends E> iterator2) {
        this.a = iterator2;
    }
}

