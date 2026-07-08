/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV3Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3UpdaterImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class VSPipelineDataV3UpdaterImpl_Factory
implements ek_2<VSPipelineDataV3UpdaterImpl> {
    private final Provider<ServerShipDataV3Updater> updaterProvider;

    /*
     * WARNING - void declaration
     */
    public VSPipelineDataV3UpdaterImpl_Factory(Provider<ServerShipDataV3Updater> updaterProvider) {
        void var1_1;
        this.updaterProvider = var1_1;
    }

    @Override
    public final VSPipelineDataV3UpdaterImpl get() {
        return VSPipelineDataV3UpdaterImpl_Factory.newInstance(this.updaterProvider.get());
    }

    public static VSPipelineDataV3UpdaterImpl_Factory create(Provider<ServerShipDataV3Updater> updaterProvider) {
        Provider<ServerShipDataV3Updater> provider;
        return new VSPipelineDataV3UpdaterImpl_Factory(provider);
    }

    public static VSPipelineDataV3UpdaterImpl newInstance(ServerShipDataV3Updater updater) {
        ServerShipDataV3Updater serverShipDataV3Updater;
        return new VSPipelineDataV3UpdaterImpl(serverShipDataV3Updater);
    }
}

