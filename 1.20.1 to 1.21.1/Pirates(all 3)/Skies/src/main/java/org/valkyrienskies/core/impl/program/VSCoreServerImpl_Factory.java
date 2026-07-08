/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.program;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.program.VSCoreImpl;
import org.valkyrienskies.core.impl.program.VSCoreServerImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class VSCoreServerImpl_Factory
implements ek_2<VSCoreServerImpl> {
    private final Provider<VSCoreImpl> baseProvider;

    /*
     * WARNING - void declaration
     */
    public VSCoreServerImpl_Factory(Provider<VSCoreImpl> baseProvider) {
        void var1_1;
        this.baseProvider = var1_1;
    }

    @Override
    public final VSCoreServerImpl get() {
        return VSCoreServerImpl_Factory.newInstance(this.baseProvider.get());
    }

    public static VSCoreServerImpl_Factory create(Provider<VSCoreImpl> baseProvider) {
        Provider<VSCoreImpl> provider;
        return new VSCoreServerImpl_Factory(provider);
    }

    public static VSCoreServerImpl newInstance(VSCoreImpl base) {
        VSCoreImpl vSCoreImpl;
        return new VSCoreServerImpl(vSCoreImpl);
    }
}

