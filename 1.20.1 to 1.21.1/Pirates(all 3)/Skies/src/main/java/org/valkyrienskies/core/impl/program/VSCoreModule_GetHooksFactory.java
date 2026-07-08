/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.program;

import org.valkyrienskies.core.impl.program.VSCoreModule;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooksOut;

public final class VSCoreModule_GetHooksFactory
implements ek_2<VsiCoreHooksOut> {
    private final VSCoreModule module;

    /*
     * WARNING - void declaration
     */
    public VSCoreModule_GetHooksFactory(VSCoreModule module) {
        void var1_1;
        this.module = var1_1;
    }

    @Override
    public final VsiCoreHooksOut get() {
        return VSCoreModule_GetHooksFactory.getHooks(this.module);
    }

    public static VSCoreModule_GetHooksFactory create(VSCoreModule module) {
        VSCoreModule vSCoreModule;
        return new VSCoreModule_GetHooksFactory(vSCoreModule);
    }

    public static VsiCoreHooksOut getHooks(VSCoreModule instance) {
        return ev_2.b(instance.getHooks());
    }
}

