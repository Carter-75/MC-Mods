/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ev_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eB
 */
public final class eb_1<T> {
    private static final String a = "Set contributions cannot be null";
    private final List<T> b;

    private eb_1(int estimatedSize) {
        this.b = new ArrayList<T>(estimatedSize);
    }

    private static <T> eb_1<T> a(int estimatedSize) {
        return new eb_1<T>(estimatedSize);
    }

    private eb_1<T> a(T t) {
        this.b.add(ev_2.a(t, a));
        return this;
    }

    private eb_1<T> a(Collection<? extends T> collection) {
        for (T t : collection) {
            ev_2.a(t, a);
        }
        this.b.addAll(collection);
        return this;
    }

    private Set<T> a() {
        if (this.b.isEmpty()) {
            return Collections.emptySet();
        }
        if (this.b.size() == 1) {
            return Collections.singleton(this.b.get(0));
        }
        return Collections.unmodifiableSet(new HashSet<T>(this.b));
    }
}

