/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.program;

import javax.inject.Provider;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineSerializer;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.program.VSCoreImpl;
import org.valkyrienskies.core.impl.shadow.CH;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.EU;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.FL;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.impl.shadow.fj_0;
import org.valkyrienskies.core.internal.collision.VsiSolidShapeUtils;

public final class VSCoreImpl_Factory
implements ek_2<VSCoreImpl> {
    private final Provider<fi_0> networkingProvider;
    private final Provider<EU> hooksProvider;
    private final Provider<fj_0> configuratorProvider;
    private final Provider<EY> tcpProvider;
    private final Provider<FL.a> pipelineComponentFactoryProvider;
    private final Provider<VSPipelineSerializer> pipelineSerializerProvider;
    private final Provider<DN> blockTypesProvider;
    private final Provider<SimplePacketNetworking> simplePacketNetworkingProvider;
    private final Provider<VsiSolidShapeUtils> solidShapeUtilsProvider;
    private final Provider<LiquidState.Builder> newLiquidStateBuilderProvider;
    private final Provider<SolidState.Builder> newSolidStateBuilderProvider;
    private final Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilderProvider;
    private final Provider<CH> attachmentRegistryProvider;

    /*
     * WARNING - void declaration
     */
    public VSCoreImpl_Factory(Provider<fi_0> networkingProvider, Provider<EU> hooksProvider, Provider<fj_0> configuratorProvider, Provider<EY> tcpProvider, Provider<FL.a> pipelineComponentFactoryProvider, Provider<VSPipelineSerializer> pipelineSerializerProvider, Provider<DN> blockTypesProvider, Provider<SimplePacketNetworking> simplePacketNetworkingProvider, Provider<VsiSolidShapeUtils> solidShapeUtilsProvider, Provider<LiquidState.Builder> newLiquidStateBuilderProvider, Provider<SolidState.Builder> newSolidStateBuilderProvider, Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilderProvider, Provider<CH> attachmentRegistryProvider) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.networkingProvider = var1_1;
        this.hooksProvider = var2_2;
        this.configuratorProvider = var3_3;
        this.tcpProvider = tcpProvider;
        this.pipelineComponentFactoryProvider = pipelineComponentFactoryProvider;
        this.pipelineSerializerProvider = pipelineSerializerProvider;
        this.blockTypesProvider = blockTypesProvider;
        this.simplePacketNetworkingProvider = simplePacketNetworkingProvider;
        this.solidShapeUtilsProvider = solidShapeUtilsProvider;
        this.newLiquidStateBuilderProvider = newLiquidStateBuilderProvider;
        this.newSolidStateBuilderProvider = newSolidStateBuilderProvider;
        this.newBoxesBlockShapeBuilderProvider = newBoxesBlockShapeBuilderProvider;
        this.attachmentRegistryProvider = attachmentRegistryProvider;
    }

    @Override
    public final VSCoreImpl get() {
        return VSCoreImpl_Factory.newInstance(this.networkingProvider.get(), this.hooksProvider.get(), this.configuratorProvider.get(), this.tcpProvider.get(), this.pipelineComponentFactoryProvider.get(), this.pipelineSerializerProvider.get(), this.blockTypesProvider.get(), this.simplePacketNetworkingProvider.get(), this.solidShapeUtilsProvider.get(), this.newLiquidStateBuilderProvider, this.newSolidStateBuilderProvider, this.newBoxesBlockShapeBuilderProvider, this.attachmentRegistryProvider.get());
    }

    /*
     * WARNING - void declaration
     */
    public static VSCoreImpl_Factory create(Provider<fi_0> networkingProvider, Provider<EU> hooksProvider, Provider<fj_0> configuratorProvider, Provider<EY> tcpProvider, Provider<FL.a> pipelineComponentFactoryProvider, Provider<VSPipelineSerializer> pipelineSerializerProvider, Provider<DN> blockTypesProvider, Provider<SimplePacketNetworking> simplePacketNetworkingProvider, Provider<VsiSolidShapeUtils> solidShapeUtilsProvider, Provider<LiquidState.Builder> newLiquidStateBuilderProvider, Provider<SolidState.Builder> newSolidStateBuilderProvider, Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilderProvider, Provider<CH> attachmentRegistryProvider) {
        void var3_3;
        void var2_2;
        void var1_1;
        Provider<fi_0> provider;
        return new VSCoreImpl_Factory(provider, (Provider<EU>)var1_1, (Provider<fj_0>)var2_2, (Provider<EY>)var3_3, pipelineComponentFactoryProvider, pipelineSerializerProvider, blockTypesProvider, simplePacketNetworkingProvider, solidShapeUtilsProvider, newLiquidStateBuilderProvider, newSolidStateBuilderProvider, newBoxesBlockShapeBuilderProvider, attachmentRegistryProvider);
    }

    /*
     * WARNING - void declaration
     */
    public static VSCoreImpl newInstance(fi_0 networking, EU hooks, fj_0 configurator2, EY tcp, FL.a pipelineComponentFactory, VSPipelineSerializer pipelineSerializer, DN blockTypes, SimplePacketNetworking simplePacketNetworking, VsiSolidShapeUtils solidShapeUtils, Provider<LiquidState.Builder> newLiquidStateBuilder, Provider<SolidState.Builder> newSolidStateBuilder, Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilder, CH attachmentRegistry) {
        void var3_3;
        void var2_2;
        void var1_1;
        fi_0 fi_02;
        return new VSCoreImpl(fi_02, (EU)var1_1, (fj_0)var2_2, (EY)var3_3, pipelineComponentFactory, pipelineSerializer, blockTypes, simplePacketNetworking, solidShapeUtils, newLiquidStateBuilder, newSolidStateBuilder, newBoxesBlockShapeBuilder, attachmentRegistry);
    }
}

