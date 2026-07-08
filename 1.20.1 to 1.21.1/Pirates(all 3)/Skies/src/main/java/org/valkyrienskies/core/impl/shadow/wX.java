/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wW;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class wX
implements wO {
    final Set<wW> a = new LinkedHashSet<wW>();

    private wX(wW ... wWArray) {
        for (wW wW2 : wWArray) {
            this.a.add(wW2);
        }
    }

    private wX(Collection<wW> collection) {
        this.a.addAll(collection);
    }

    public final Collection<wW> a() {
        return Collections.unmodifiableSet(this.a);
    }
}

