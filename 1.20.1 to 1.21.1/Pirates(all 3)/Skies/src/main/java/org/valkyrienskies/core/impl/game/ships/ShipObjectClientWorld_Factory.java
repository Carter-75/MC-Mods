/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships;

import java.util.Map;
import javax.inject.Provider;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.game.ships.ShipObjectClientWorld;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.DW;
import org.valkyrienskies.core.impl.shadow.EL;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockTypes;

public final class ShipObjectClientWorld_Factory
implements ek_2<ShipObjectClientWorld> {
    private final Provider<EL.b> networkManagerFactoryProvider;
    private final Provider<ChunkAllocatorProvider> chunkAllocatorsProvider;
    private final Provider<VsiBlockTypes> blockTypesProvider;
    private final Provider<DW> connectivityHandlerProvider;
    private final Provider<Map<String, DP>> dimensionInfoProvider;

    /*
     * WARNING - void declaration
     */
    public ShipObjectClientWorld_Factory(Provider<EL.b> networkManagerFactoryProvider, Provider<ChunkAllocatorProvider> chunkAllocatorsProvider, Provider<VsiBlockTypes> blockTypesProvider, Provider<DW> connectivityHandlerProvider, Provider<Map<String, DP>> dimensionInfoProvider) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.networkManagerFactoryProvider = var1_1;
        this.chunkAllocatorsProvider = var2_2;
        this.blockTypesProvider = var3_3;
        this.connectivityHandlerProvider = connectivityHandlerProvider;
        this.dimensionInfoProvider = dimensionInfoProvider;
    }

    @Override
    public final ShipObjectClientWorld get() {
        return ShipObjectClientWorld_Factory.newInstance(this.networkManagerFactoryProvider.get(), this.chunkAllocatorsProvider.get(), this.blockTypesProvider.get(), this.connectivityHandlerProvider.get(), this.dimensionInfoProvider.get());
    }

    /*
     * WARNING - void declaration
     */
    public static ShipObjectClientWorld_Factory create(Provider<EL.b> networkManagerFactoryProvider, Provider<ChunkAllocatorProvider> chunkAllocatorsProvider, Provider<VsiBlockTypes> blockTypesProvider, Provider<DW> connectivityHandlerProvider, Provider<Map<String, DP>> dimensionInfoProvider) {
        void var3_3;
        void var2_2;
        void var1_1;
        Provider<EL.b> provider;
        return new ShipObjectClientWorld_Factory(provider, (Provider<ChunkAllocatorProvider>)var1_1, (Provider<VsiBlockTypes>)var2_2, (Provider<DW>)var3_3, dimensionInfoProvider);
    }

    /*
     * WARNING - void declaration
     */
    public static ShipObjectClientWorld newInstance(EL.b networkManagerFactory, ChunkAllocatorProvider chunkAllocators, VsiBlockTypes blockTypes, DW connectivityHandler, Map<String, DP> dimensionInfo) {
        void var3_3;
        void var2_2;
        void var1_1;
        EL.b b2;
        return new ShipObjectClientWorld(b2, (ChunkAllocatorProvider)var1_1, (VsiBlockTypes)var2_2, (DW)var3_3, dimensionInfo);
    }
}

