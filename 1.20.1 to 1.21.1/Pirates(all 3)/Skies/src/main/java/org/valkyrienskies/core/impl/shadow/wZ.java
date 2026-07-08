/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Collections;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.wW;
import org.valkyrienskies.core.impl.shadow.wX;
import org.valkyrienskies.core.impl.shadow.wY;
import org.valkyrienskies.core.impl.shadow.xb_0;
import org.valkyrienskies.core.impl.shadow.xp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class wZ
extends xp_0 {
    private wY b;
    private Collection<wW> c;
    private boolean d;

    protected wZ() {
        super((wK<wQ>)null);
    }

    protected final boolean b() {
        return this.d;
    }

    protected final wY d() {
        return this.b;
    }

    protected final Collection<wW> m() {
        return Collections.unmodifiableCollection(this.c);
    }

    @Override
    public wQ c(wO ... wOArray) {
        return super.c(wOArray);
    }

    @Override
    public void b(wO ... wOArray) {
        super.b(wOArray);
        for (wO wO2 : wOArray) {
            if (wO2 instanceof wY) {
                this.b = (wY)wO2;
                continue;
            }
            if (wO2 instanceof wX) {
                wO2 = (wX)wO2;
                this.c = Collections.unmodifiableSet(((wX)wO2).a);
                continue;
            }
            if (!(wO2 instanceof xb_0)) continue;
            wO2 = (xb_0)wO2;
            this.d = ((xb_0)wO2).a;
        }
    }

    @Override
    public /* synthetic */ Object a(wO[] wOArray) {
        return ((xp_0)this).c(wOArray);
    }
}

