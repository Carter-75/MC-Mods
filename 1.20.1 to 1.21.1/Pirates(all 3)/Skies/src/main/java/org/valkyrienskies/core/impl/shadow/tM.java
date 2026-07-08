/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.tK;
import org.valkyrienskies.core.impl.shadow.tL;
import org.valkyrienskies.core.impl.shadow.tW;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class tM<T extends tL> {
    private tW a;

    protected tM(tW tW2) {
        this.a = tW2;
    }

    public abstract List<? extends tK<T>> a(Collection<T> var1);

    public final tW a() {
        return this.a;
    }

    protected final double a(tL tL2, tL tL3) {
        return this.a.a(tL2.a(), tL3.a());
    }
}

