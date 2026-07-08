/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.program;

import org.valkyrienskies.core.impl.program.VSCoreModule;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.impl.shadow.fj_0;

public final class VSCoreModule_GetConfiguratorFactory
implements ek_2<fj_0> {
    private final VSCoreModule module;

    /*
     * WARNING - void declaration
     */
    public VSCoreModule_GetConfiguratorFactory(VSCoreModule module) {
        void var1_1;
        this.module = var1_1;
    }

    @Override
    public final fj_0 get() {
        return VSCoreModule_GetConfiguratorFactory.getConfigurator(this.module);
    }

    public static VSCoreModule_GetConfiguratorFactory create(VSCoreModule module) {
        VSCoreModule vSCoreModule;
        return new VSCoreModule_GetConfiguratorFactory(vSCoreModule);
    }

    public static fj_0 getConfigurator(VSCoreModule instance) {
        return ev_2.b(instance.getConfigurator());
    }
}

