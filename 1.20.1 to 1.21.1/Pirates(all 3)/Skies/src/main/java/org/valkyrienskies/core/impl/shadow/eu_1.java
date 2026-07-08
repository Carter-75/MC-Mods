/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.EmptyStackException;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eU
 */
@Deprecated
public final class eu_1<E>
extends ArrayList<E> {
    private static final long a = 2130079159931574599L;

    public eu_1() {
    }

    private eu_1(int n2) {
        super(n2);
    }

    private boolean a() {
        return this.isEmpty();
    }

    private E b() {
        int n2 = this.size();
        if (n2 <= 0) {
            throw new EmptyStackException();
        }
        return this.get(n2 - 1);
    }

    private E a(int n2) {
        n2 = this.size() - n2 - 1;
        if (n2 < 0) {
            throw new EmptyStackException();
        }
        return this.get(n2);
    }

    private E c() {
        int n2 = this.size();
        if (n2 <= 0) {
            throw new EmptyStackException();
        }
        return this.remove(n2 - 1);
    }

    private E a(E e2) {
        this.add(e2);
        return e2;
    }

    private int b(Object object) {
        int n2 = this.size() - 1;
        int n3 = 1;
        while (n2 >= 0) {
            Object e2 = this.get(n2);
            if (object == null && e2 == null || object != null && object.equals(e2)) {
                return n3;
            }
            --n2;
            ++n3;
        }
        return -1;
    }
}

