/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.EU;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooksOut;

public final class EW
implements ek_2<EU> {
    private final Provider<VsiCoreHooksOut> a;
    private final Provider<EY> b;

    private EW(Provider<VsiCoreHooksOut> provider, Provider<EY> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    private EU a() {
        EY eY = this.b.get();
        VsiCoreHooksOut vsiCoreHooksOut = this.a.get();
        return new EU(vsiCoreHooksOut, eY);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static EW a(ew_2 ew_22, ew_2 ew_23) {
        return new EW(ew_22, ew_23);
    }

    private static EU a(VsiCoreHooksOut vsiCoreHooksOut, EY eY) {
        return new EU(vsiCoreHooksOut, eY);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        EY eY = ((EW)object).b.get();
        object = ((EW)object).a.get();
        return new EU((VsiCoreHooksOut)object, eY);
    }
}

