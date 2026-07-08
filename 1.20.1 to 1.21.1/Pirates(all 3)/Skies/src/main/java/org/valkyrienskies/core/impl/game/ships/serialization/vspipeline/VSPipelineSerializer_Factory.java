/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.serialization.ChainUpdater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineSerializer;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV4;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class VSPipelineSerializer_Factory
implements ek_2<VSPipelineSerializer> {
    private final Provider<ObjectMapper> objectMapperProvider;
    private final Provider<ServerShipDataConverter> shipDataMapperProvider;
    private final Provider<ChainUpdater<VSPipelineDataV4>> updaterProvider;
    private final Provider<ServerShipDataV0Updater> v0UpdaterProvider;
    private final Provider<VSPipelineDataConverter> pipelineDataConverterProvider;

    /*
     * WARNING - void declaration
     */
    public VSPipelineSerializer_Factory(Provider<ObjectMapper> objectMapperProvider, Provider<ServerShipDataConverter> shipDataMapperProvider, Provider<ChainUpdater<VSPipelineDataV4>> updaterProvider, Provider<ServerShipDataV0Updater> v0UpdaterProvider, Provider<VSPipelineDataConverter> pipelineDataConverterProvider) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.objectMapperProvider = var1_1;
        this.shipDataMapperProvider = var2_2;
        this.updaterProvider = var3_3;
        this.v0UpdaterProvider = v0UpdaterProvider;
        this.pipelineDataConverterProvider = pipelineDataConverterProvider;
    }

    @Override
    public final VSPipelineSerializer get() {
        return VSPipelineSerializer_Factory.newInstance(this.objectMapperProvider.get(), this.shipDataMapperProvider.get(), this.updaterProvider.get(), this.v0UpdaterProvider.get(), this.pipelineDataConverterProvider.get());
    }

    /*
     * WARNING - void declaration
     */
    public static VSPipelineSerializer_Factory create(Provider<ObjectMapper> objectMapperProvider, Provider<ServerShipDataConverter> shipDataMapperProvider, Provider<ChainUpdater<VSPipelineDataV4>> updaterProvider, Provider<ServerShipDataV0Updater> v0UpdaterProvider, Provider<VSPipelineDataConverter> pipelineDataConverterProvider) {
        void var3_3;
        void var2_2;
        void var1_1;
        Provider<ObjectMapper> provider;
        return new VSPipelineSerializer_Factory(provider, (Provider<ServerShipDataConverter>)var1_1, (Provider<ChainUpdater<VSPipelineDataV4>>)var2_2, (Provider<ServerShipDataV0Updater>)var3_3, pipelineDataConverterProvider);
    }

    /*
     * WARNING - void declaration
     */
    public static VSPipelineSerializer newInstance(ObjectMapper objectMapper, ServerShipDataConverter shipDataMapper, ChainUpdater<VSPipelineDataV4> updater, ServerShipDataV0Updater v0Updater, VSPipelineDataConverter pipelineDataConverter) {
        void var3_3;
        void var2_2;
        void var1_1;
        ObjectMapper objectMapper2;
        return new VSPipelineSerializer(objectMapper2, (ServerShipDataConverter)var1_1, (ChainUpdater<VSPipelineDataV4>)var2_2, (ServerShipDataV0Updater)var3_3, pipelineDataConverter);
    }
}

