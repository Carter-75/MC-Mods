/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineDataConverterImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class VSPipelineDataConverterImpl_Factory
implements ek_2<VSPipelineDataConverterImpl> {
    private final Provider<ServerShipDataConverter> converterProvider;

    /*
     * WARNING - void declaration
     */
    public VSPipelineDataConverterImpl_Factory(Provider<ServerShipDataConverter> converterProvider) {
        void var1_1;
        this.converterProvider = var1_1;
    }

    @Override
    public final VSPipelineDataConverterImpl get() {
        return VSPipelineDataConverterImpl_Factory.newInstance(this.converterProvider.get());
    }

    public static VSPipelineDataConverterImpl_Factory create(Provider<ServerShipDataConverter> converterProvider) {
        Provider<ServerShipDataConverter> provider;
        return new VSPipelineDataConverterImpl_Factory(provider);
    }

    public static VSPipelineDataConverterImpl newInstance(ServerShipDataConverter converter) {
        ServerShipDataConverter serverShipDataConverter;
        return new VSPipelineDataConverterImpl(serverShipDataConverter);
    }
}

