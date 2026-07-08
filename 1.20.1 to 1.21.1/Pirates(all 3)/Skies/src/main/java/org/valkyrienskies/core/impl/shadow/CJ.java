/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.CH;
import org.valkyrienskies.core.impl.shadow.CN;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class CJ
implements ek_2<CH> {
    private final Provider<CN> a;

    private CJ(Provider<CN> provider) {
        this.a = provider;
    }

    private CH a() {
        CN cN = this.a.get();
        return new CH(cN);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static CJ a(ew_2 ew_22) {
        return new CJ(ew_22);
    }

    private static CH a(CN cN) {
        return new CH(cN);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        object = ((CJ)object).a.get();
        return new CH((CN)object);
    }
}

