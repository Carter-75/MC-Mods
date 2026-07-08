/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.program;

import org.valkyrienskies.core.impl.program.VSCoreModule;
import org.valkyrienskies.core.impl.shadow.FR;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class VSCoreModule_GetPhysicsThreadCheckerFactory
implements ek_2<FR> {
    private final VSCoreModule module;

    /*
     * WARNING - void declaration
     */
    public VSCoreModule_GetPhysicsThreadCheckerFactory(VSCoreModule module) {
        void var1_1;
        this.module = var1_1;
    }

    @Override
    public final FR get() {
        return VSCoreModule_GetPhysicsThreadCheckerFactory.getPhysicsThreadChecker(this.module);
    }

    public static VSCoreModule_GetPhysicsThreadCheckerFactory create(VSCoreModule module) {
        VSCoreModule vSCoreModule;
        return new VSCoreModule_GetPhysicsThreadCheckerFactory(vSCoreModule);
    }

    public static FR getPhysicsThreadChecker(VSCoreModule instance) {
        return ev_2.b(instance.getPhysicsThreadChecker());
    }
}

