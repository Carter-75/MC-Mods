/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.fi_2;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooks;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fm
 */
public final class fm_0
implements ek_2<EY> {
    private final Provider<VsiCoreHooks> a;

    private fm_0(Provider<VsiCoreHooks> provider) {
        this.a = provider;
    }

    private EY a() {
        Provider<VsiCoreHooks> provider = this.a;
        return ev_2.b(fi_2.a_0.a.b(provider));
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static fm_0 a(ew_2 ew_22) {
        return new fm_0(ew_22);
    }

    private static EY a(Provider<VsiCoreHooks> provider) {
        return ev_2.b(fi_2.a_0.a.b(provider));
    }

    @Override
    public final /* synthetic */ Object get() {
        Provider<EY> provider = this;
        provider = provider.a;
        return ev_2.b(fi_2.a_0.a.b(provider));
    }
}

