/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import javax.inject.Provider;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.shadow.CY;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class CZ
implements ek_2<CY> {
    private final Provider<VSCoreConfig.Server> a;
    private final Provider<Map<String, DP>> b;

    private CZ(Provider<VSCoreConfig.Server> provider, Provider<Map<String, DP>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    private CY a() {
        Map<String, DP> map2 = this.b.get();
        VSCoreConfig.Server server = this.a.get();
        return new CY(server, map2);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static CZ a(ew_2 ew_22, ew_2 ew_23) {
        return new CZ(ew_22, ew_23);
    }

    private static CY a(VSCoreConfig.Server server, Map<String, DP> map2) {
        return new CY(server, map2);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        Map<String, DP> map2 = ((CZ)object).b.get();
        object = ((CZ)object).a.get();
        return new CY((VSCoreConfig.Server)object, map2);
    }
}

