/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.program;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.ShipObjectClientWorldComponent;
import org.valkyrienskies.core.impl.program.VSCoreClientImpl;
import org.valkyrienskies.core.impl.program.VSCoreImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class VSCoreClientImpl_Factory
implements ek_2<VSCoreClientImpl> {
    private final Provider<VSCoreImpl> baseProvider;
    private final Provider<ShipObjectClientWorldComponent.Factory> shipWorldComponentFactoryProvider;

    /*
     * WARNING - void declaration
     */
    public VSCoreClientImpl_Factory(Provider<VSCoreImpl> baseProvider, Provider<ShipObjectClientWorldComponent.Factory> shipWorldComponentFactoryProvider) {
        void var2_2;
        void var1_1;
        this.baseProvider = var1_1;
        this.shipWorldComponentFactoryProvider = var2_2;
    }

    @Override
    public final VSCoreClientImpl get() {
        return VSCoreClientImpl_Factory.newInstance(this.baseProvider.get(), this.shipWorldComponentFactoryProvider.get());
    }

    /*
     * WARNING - void declaration
     */
    public static VSCoreClientImpl_Factory create(Provider<VSCoreImpl> baseProvider, Provider<ShipObjectClientWorldComponent.Factory> shipWorldComponentFactoryProvider) {
        void var1_1;
        Provider<VSCoreImpl> provider;
        return new VSCoreClientImpl_Factory(provider, (Provider<ShipObjectClientWorldComponent.Factory>)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    public static VSCoreClientImpl newInstance(VSCoreImpl base, ShipObjectClientWorldComponent.Factory shipWorldComponentFactory) {
        void var1_1;
        VSCoreImpl vSCoreImpl;
        return new VSCoreClientImpl(vSCoreImpl, (ShipObjectClientWorldComponent.Factory)var1_1);
    }
}

