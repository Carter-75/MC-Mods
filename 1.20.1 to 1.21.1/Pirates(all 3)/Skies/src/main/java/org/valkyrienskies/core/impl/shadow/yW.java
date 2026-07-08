/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Collections;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.yX;
import org.valkyrienskies.core.impl.shadow.yY;
import org.valkyrienskies.core.impl.shadow.yZ;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class yW
implements yZ {
    private static int a = 100;
    private yY b;
    private Collection<yX> c;
    private yf_0 d;
    private boolean e;
    private int f;
    private int g;

    protected yW() {
        int n2 = 100;
        yW yW2 = this;
        this.f = 100;
    }

    protected final boolean a() {
        return this.e;
    }

    protected final yf_0 b() {
        return this.d;
    }

    protected final yY c() {
        return this.b;
    }

    protected final Collection<yX> d() {
        return Collections.unmodifiableCollection(this.c);
    }

    @Override
    public final void a(int n2) {
        this.f = 100;
    }

    @Override
    public final int e() {
        return this.f;
    }

    @Override
    public final int f() {
        return this.g;
    }

    protected final void g() {
        if (++this.g > this.f) {
            throw new pc_0(this.f);
        }
    }

    @Override
    public final yp_0 a(yY yY2, Collection<yX> collection, yf_0 yf_02, boolean bl) {
        this.b = yY2;
        this.c = collection;
        this.d = yf_02;
        this.e = bl;
        this.g = 0;
        return this.h();
    }

    protected abstract yp_0 h();
}

