/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.la_0;
import org.valkyrienskies.core.impl.shadow.nB;
import org.valkyrienskies.core.impl.shadow.nX;
import org.valkyrienskies.core.impl.shadow.ob_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class nW
extends nB<nX> {
    private nW(nX nX2, nX nX3, nX nX4, int n2) {
        super(nX2, nX3, nX4, n2);
    }

    private nX f() {
        return (nX)super.c();
    }

    private nX g() {
        return (nX)super.d();
    }

    private nX h() {
        return (nX)super.e();
    }

    private nX a(int n2, ob_0 ob_02, nX object, nX nX2, int n3) {
        int n4 = n3;
        nX nX3 = ((nX)object).f(nX2).j(2);
        nX nX4 = nX2;
        nX2 = object;
        object = ob_02;
        int n5 = n2;
        nW nW2 = this;
        ci_0.a(object);
        object = new la_0<nX>(nW2, (ob_0)object){
            private /* synthetic */ ob_0 a;
            private /* synthetic */ nW b;
            {
                this.b = nW2;
                this.a = ob_02;
            }

            @Override
            private nX a(nX nX2) {
                return this.a.a();
            }
        };
        return nW2.a(n5, object, nX2, nX4, nX3, n4);
    }

    private nX a(int n2, ob_0 object, nX nX2, nX nX3, nX nX4, int n3) {
        ci_0.a(object);
        object = new /* invalid duplicate definition of identical inner class */;
        return this.a(n2, object, nX2, nX3, nX4, n3);
    }
}

