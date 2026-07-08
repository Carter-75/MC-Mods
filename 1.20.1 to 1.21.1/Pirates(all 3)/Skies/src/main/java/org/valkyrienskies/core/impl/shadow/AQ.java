/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AT;
import org.valkyrienskies.core.impl.shadow.bp_0;
import org.valkyrienskies.core.impl.shadow.cg_0;

public final class AQ
extends AT
implements Serializable {
    private static final long a = -3961477041290915687L;
    private static final double b = 50.0;

    public AQ() {
        super(50.0);
    }

    private AQ(AQ aQ) {
        super(aQ);
    }

    private AQ(AT.a a2, bp_0 bp_02, cg_0 cg_02) {
        super(50.0, a2, bp_02, cg_02);
    }

    private AQ b(AT.a a2) {
        return new AQ(a2, this.b(), this.c());
    }

    private AQ b(bp_0 bp_02) {
        return new AQ(this.a(), bp_02, this.c());
    }

    private AQ b(cg_0 cg_02) {
        return new AQ(this.a(), this.b(), cg_02);
    }

    public final /* synthetic */ AT a(cg_0 serializable) {
        cg_0 cg_02 = serializable;
        serializable = this;
        return new AQ(((AT)serializable).a(), ((AT)serializable).b(), cg_02);
    }

    public final /* synthetic */ AT a(bp_0 object) {
        bp_0 bp_02 = object;
        object = this;
        return new AQ(((AT)object).a(), bp_02, ((AT)object).c());
    }

    public final /* synthetic */ AT a(AT.a object) {
        AT.a a2 = object;
        object = this;
        return new AQ(a2, ((AT)object).b(), ((AT)object).c());
    }
}

