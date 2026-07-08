/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV1Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1UpdaterImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class VSPipelineDataV1UpdaterImpl_Factory
implements ek_2<VSPipelineDataV1UpdaterImpl> {
    private final Provider<ServerShipDataV1Updater> updaterProvider;

    /*
     * WARNING - void declaration
     */
    public VSPipelineDataV1UpdaterImpl_Factory(Provider<ServerShipDataV1Updater> updaterProvider) {
        void var1_1;
        this.updaterProvider = var1_1;
    }

    @Override
    public final VSPipelineDataV1UpdaterImpl get() {
        return VSPipelineDataV1UpdaterImpl_Factory.newInstance(this.updaterProvider.get());
    }

    public static VSPipelineDataV1UpdaterImpl_Factory create(Provider<ServerShipDataV1Updater> updaterProvider) {
        Provider<ServerShipDataV1Updater> provider;
        return new VSPipelineDataV1UpdaterImpl_Factory(provider);
    }

    public static VSPipelineDataV1UpdaterImpl newInstance(ServerShipDataV1Updater updater) {
        ServerShipDataV1Updater serverShipDataV1Updater;
        return new VSPipelineDataV1UpdaterImpl(serverShipDataV1Updater);
    }
}

