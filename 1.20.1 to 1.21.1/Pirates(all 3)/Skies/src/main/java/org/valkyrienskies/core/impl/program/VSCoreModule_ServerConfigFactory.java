/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.program;

import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.program.VSCoreModule;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class VSCoreModule_ServerConfigFactory
implements ek_2<VSCoreConfig.Server> {
    private final VSCoreModule module;

    /*
     * WARNING - void declaration
     */
    public VSCoreModule_ServerConfigFactory(VSCoreModule module) {
        void var1_1;
        this.module = var1_1;
    }

    @Override
    public final VSCoreConfig.Server get() {
        return VSCoreModule_ServerConfigFactory.serverConfig(this.module);
    }

    public static VSCoreModule_ServerConfigFactory create(VSCoreModule module) {
        VSCoreModule vSCoreModule;
        return new VSCoreModule_ServerConfigFactory(vSCoreModule);
    }

    public static VSCoreConfig.Server serverConfig(VSCoreModule instance) {
        return ev_2.b(instance.serverConfig());
    }
}

