/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2UpdaterImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class VSPipelineDataV2UpdaterImpl_Factory
implements ek_2<VSPipelineDataV2UpdaterImpl> {
    private final Provider<ServerShipDataV2Updater> updaterProvider;

    /*
     * WARNING - void declaration
     */
    public VSPipelineDataV2UpdaterImpl_Factory(Provider<ServerShipDataV2Updater> updaterProvider) {
        void var1_1;
        this.updaterProvider = var1_1;
    }

    @Override
    public final VSPipelineDataV2UpdaterImpl get() {
        return VSPipelineDataV2UpdaterImpl_Factory.newInstance(this.updaterProvider.get());
    }

    public static VSPipelineDataV2UpdaterImpl_Factory create(Provider<ServerShipDataV2Updater> updaterProvider) {
        Provider<ServerShipDataV2Updater> provider;
        return new VSPipelineDataV2UpdaterImpl_Factory(provider);
    }

    public static VSPipelineDataV2UpdaterImpl newInstance(ServerShipDataV2Updater updater) {
        ServerShipDataV2Updater serverShipDataV2Updater;
        return new VSPipelineDataV2UpdaterImpl(serverShipDataV2Updater);
    }
}

