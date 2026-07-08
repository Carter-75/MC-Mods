/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rF;
import org.valkyrienskies.core.impl.shadow.rG;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
abstract class rD
implements rG {
    private static final double a = 1.0E-10;
    private final double b;
    private final boolean c;

    protected rD(boolean bl) {
        this(bl, 1.0E-10);
    }

    protected rD(boolean bl, double d2) {
        this.c = bl;
        this.b = d2;
    }

    public double a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    @Override
    public rF a(Collection<rB> collection) {
        ci_0.a(collection);
        if (collection.size() >= 2) {
            collection = this.b(collection);
        }
        try {
            Collection<rB> collection2 = collection;
            return new rF(collection2.toArray(new rB[collection2.size()]), this.b);
        }
        catch (oV oV2) {
            throw new oR();
        }
    }

    protected abstract Collection<rB> b(Collection<rB> var1);

    public final /* synthetic */ rF c(Collection collection) {
        return this.a(collection);
    }
}

