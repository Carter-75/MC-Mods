/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.CA;
import org.valkyrienskies.core.impl.shadow.cy_0;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cz
 */
public final class cz_0
implements ek_2<cy_0> {
    private final Provider<CA> a;

    private cz_0(Provider<CA> provider) {
        this.a = provider;
    }

    private cy_0 a() {
        Provider<CA> provider = this.a;
        return new cy_0(provider);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static cz_0 a(ew_2 ew_22) {
        return new cz_0(ew_22);
    }

    private static cy_0 a(Provider<CA> provider) {
        return new cy_0(provider);
    }

    @Override
    public final /* synthetic */ Object get() {
        Provider<cy_0> provider = this;
        provider = provider.a;
        return new cy_0(provider);
    }
}

