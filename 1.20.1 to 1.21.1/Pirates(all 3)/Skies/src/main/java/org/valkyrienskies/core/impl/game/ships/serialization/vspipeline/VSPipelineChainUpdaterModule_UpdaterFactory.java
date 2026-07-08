/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.vspipeline;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ships.serialization.ChainUpdater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineChainUpdaterModule;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV4;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;

public final class VSPipelineChainUpdaterModule_UpdaterFactory
implements ek_2<ChainUpdater<VSPipelineDataV4>> {
    private final VSPipelineChainUpdaterModule module;
    private final Provider<VSPipelineDataV1Updater> v1Provider;
    private final Provider<VSPipelineDataV2Updater> v2Provider;
    private final Provider<VSPipelineDataV3Updater> v3Provider;

    /*
     * WARNING - void declaration
     */
    public VSPipelineChainUpdaterModule_UpdaterFactory(VSPipelineChainUpdaterModule module, Provider<VSPipelineDataV1Updater> v1Provider, Provider<VSPipelineDataV2Updater> v2Provider, Provider<VSPipelineDataV3Updater> v3Provider) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.module = var1_1;
        this.v1Provider = var2_2;
        this.v2Provider = var3_3;
        this.v3Provider = v3Provider;
    }

    @Override
    public final ChainUpdater<VSPipelineDataV4> get() {
        return VSPipelineChainUpdaterModule_UpdaterFactory.updater(this.module, this.v1Provider.get(), this.v2Provider.get(), this.v3Provider.get());
    }

    /*
     * WARNING - void declaration
     */
    public static VSPipelineChainUpdaterModule_UpdaterFactory create(VSPipelineChainUpdaterModule module, Provider<VSPipelineDataV1Updater> v1Provider, Provider<VSPipelineDataV2Updater> v2Provider, Provider<VSPipelineDataV3Updater> v3Provider) {
        void var3_3;
        void var2_2;
        void var1_1;
        VSPipelineChainUpdaterModule vSPipelineChainUpdaterModule;
        return new VSPipelineChainUpdaterModule_UpdaterFactory(vSPipelineChainUpdaterModule, (Provider<VSPipelineDataV1Updater>)var1_1, (Provider<VSPipelineDataV2Updater>)var2_2, (Provider<VSPipelineDataV3Updater>)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    public static ChainUpdater<VSPipelineDataV4> updater(VSPipelineChainUpdaterModule instance, VSPipelineDataV1Updater v1, VSPipelineDataV2Updater v2, VSPipelineDataV3Updater v3) {
        void var3_3;
        void var2_2;
        void var1_1;
        return ev_2.b(instance.updater((VSPipelineDataV1Updater)var1_1, (VSPipelineDataV2Updater)var2_2, (VSPipelineDataV3Updater)var3_3));
    }
}

