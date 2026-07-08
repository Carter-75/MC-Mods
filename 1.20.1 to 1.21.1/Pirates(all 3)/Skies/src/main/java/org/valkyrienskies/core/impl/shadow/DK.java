/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.DH;

public final class DK<T>
extends DH<DK<T>> {
    public T a;
    public int b;

    public DK(T t) {
        this.a = t;
    }

    @Override
    public final boolean b() {
        int n2 = ((DK)this.j).b + ((DK)this.k).b + 1;
        if (n2 == this.b) {
            return false;
        }
        this.b = n2;
        return true;
    }

    @Override
    public final void c() {
        int n2 = this.d() ? 0 : ((DK)this.j).b + ((DK)this.k).b + 1;
        if (this.b != n2) {
            throw new RuntimeException("The node's size does not match that of the children");
        }
    }
}

