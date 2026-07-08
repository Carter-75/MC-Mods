/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rM;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class rX<S extends qN>
implements Iterable<rM<S>> {
    private List<rM<S>> a = new ArrayList<rM<S>>();

    public final void a(rM<S> rM2) {
        for (rM<S> rM3 : this.a) {
            if (rM2 != rM3) continue;
            return;
        }
        this.a.add(rM2);
    }

    public final void a(Iterable<rM<S>> object) {
        object = object.iterator();
        while (object.hasNext()) {
            rM rM2 = (rM)object.next();
            this.a(rM2);
        }
    }

    @Override
    public final Iterator<rM<S>> iterator() {
        return this.a.iterator();
    }
}

