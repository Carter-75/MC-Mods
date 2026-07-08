/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.fv_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fw
 */
public final class fw_0
implements ek_2<fv_0> {
    private final Provider<VSCoreConfig.Server> a;

    private fw_0(Provider<VSCoreConfig.Server> provider) {
        this.a = provider;
    }

    private fv_0 a() {
        VSCoreConfig.Server server = this.a.get();
        return new fv_0(server);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static fw_0 a(ew_2 ew_22) {
        return new fw_0(ew_22);
    }

    private static fv_0 a(VSCoreConfig.Server server) {
        return new fv_0(server);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        object = ((fw_0)object).a.get();
        return new fv_0((VSCoreConfig.Server)object);
    }
}

