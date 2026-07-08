/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.av_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.An
 */
public abstract class an_0
extends ao_0
implements av_0 {
    public double a(double[] dArray) {
        if (dArray == null) {
            throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
        }
        return ((ao_0)this).a(dArray, 0, dArray.length);
    }

    public double a(double[] dArray, int n2, int n3) {
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        if (ch_0.a(dArray, n5, n4, false)) {
            this.b();
            this.b(dArray, n2, n3);
        }
        return this.c();
    }

    public abstract an_0 a();

    public abstract void b();

    public abstract double c();

    public abstract void a(double var1);

    public final void b(double[] dArray) {
        if (dArray == null) {
            throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
        }
        this.b(dArray, 0, dArray.length);
    }

    public final void b(double[] dArray, int n2, int n3) {
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        if (ch_0.a(dArray, n5, n4, false)) {
            n3 = n2 + n3;
            while (n2 < n3) {
                this.a(dArray[n2]);
                ++n2;
            }
        }
    }

    public boolean equals(Object object) {
        an_0 an_02;
        if (object == this) {
            return true;
        }
        if (!(object instanceof an_0)) {
            return false;
        }
        return cq_0.b((an_02 = (an_0)an_02).c(), this.c()) && cq_0.b(an_02.g_(), this.g_());
    }

    public int hashCode() {
        return 31 * (31 + ci_0.a(this.c())) + ci_0.a(this.g_());
    }

    public /* synthetic */ AA d() {
        return this.a();
    }
}

