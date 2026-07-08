/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.ShipInertiaConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.ShipTransformConverter;
import org.valkyrienskies.core.impl.shadow.cy_0;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class ServerShipDataConverterImpl_Factory
implements ek_2<ServerShipDataConverterImpl> {
    private final Provider<ShipInertiaConverter> inertiaConverterProvider;
    private final Provider<ShipTransformConverter> transformConverterProvider;
    private final Provider<cy_0> attachmentHolderFactoryProvider;

    /*
     * WARNING - void declaration
     */
    public ServerShipDataConverterImpl_Factory(Provider<ShipInertiaConverter> inertiaConverterProvider, Provider<ShipTransformConverter> transformConverterProvider, Provider<cy_0> attachmentHolderFactoryProvider) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.inertiaConverterProvider = var1_1;
        this.transformConverterProvider = var2_2;
        this.attachmentHolderFactoryProvider = var3_3;
    }

    @Override
    public final ServerShipDataConverterImpl get() {
        return ServerShipDataConverterImpl_Factory.newInstance(this.inertiaConverterProvider.get(), this.transformConverterProvider.get(), this.attachmentHolderFactoryProvider.get());
    }

    /*
     * WARNING - void declaration
     */
    public static ServerShipDataConverterImpl_Factory create(Provider<ShipInertiaConverter> inertiaConverterProvider, Provider<ShipTransformConverter> transformConverterProvider, Provider<cy_0> attachmentHolderFactoryProvider) {
        void var2_2;
        void var1_1;
        Provider<ShipInertiaConverter> provider;
        return new ServerShipDataConverterImpl_Factory(provider, (Provider<ShipTransformConverter>)var1_1, (Provider<cy_0>)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    public static ServerShipDataConverterImpl newInstance(ShipInertiaConverter inertiaConverter, ShipTransformConverter transformConverter, cy_0 attachmentHolderFactory) {
        void var2_2;
        void var1_1;
        ShipInertiaConverter shipInertiaConverter;
        return new ServerShipDataConverterImpl(shipInertiaConverter, (ShipTransformConverter)var1_1, (cy_0)var2_2);
    }
}

