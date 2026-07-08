/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.uM;
import org.valkyrienskies.core.impl.shadow.uZ;
import org.valkyrienskies.core.impl.shadow.ve_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.va
 */
final class va_0
implements uZ {
    private final uM a;

    private va_0(uM uM2) {
        this.a = uM2;
    }

    private int c() {
        return this.a.a();
    }

    private void a(double d2, double[] dArray, double[] dArray2) {
        this.a.a(d2, dArray, dArray2);
    }

    @Override
    public final Collection<String> a() {
        return new ArrayList<String>();
    }

    @Override
    public final boolean a(String string) {
        return false;
    }

    @Override
    public final double b(String string) {
        Object object = string;
        object = this;
        throw new ve_0(string);
    }

    @Override
    public final void b() {
    }
}

