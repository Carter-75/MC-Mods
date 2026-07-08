/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.shadow.cy_0;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class ShipData_Factory_Factory
implements ek_2<ShipData.Factory> {
    private final Provider<cy_0> attachmentHolderFactoryProvider;

    /*
     * WARNING - void declaration
     */
    public ShipData_Factory_Factory(Provider<cy_0> attachmentHolderFactoryProvider) {
        void var1_1;
        this.attachmentHolderFactoryProvider = var1_1;
    }

    @Override
    public final ShipData.Factory get() {
        return ShipData_Factory_Factory.newInstance(this.attachmentHolderFactoryProvider.get());
    }

    public static ShipData_Factory_Factory create(Provider<cy_0> attachmentHolderFactoryProvider) {
        Provider<cy_0> provider;
        return new ShipData_Factory_Factory(provider);
    }

    public static ShipData.Factory newInstance(cy_0 attachmentHolderFactory) {
        cy_0 cy_02;
        return new ShipData.Factory(cy_02);
    }
}

