/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.program;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.BoxesBlockShapeImpl_BuilderImpl_Factory;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.LiquidStateImpl_BuilderImpl_Factory;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.SolidStateImpl;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.SolidStateImpl_BuilderImpl_Factory;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.game.ChunkAllocator;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.game.ships.ShipData_Factory_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.ChainUpdater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.ShipInertiaConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.ShipInertiaConverter_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0UpdaterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV1UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV1UpdaterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2UpdaterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV3UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV3UpdaterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.ShipTransformConverterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.ShipTransformConverterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineChainUpdaterModule;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineChainUpdaterModule_UpdaterFactory;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineDataConverterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineDataConverterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineSerializer;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineSerializer_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV1UpdaterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV2UpdaterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV3UpdaterImpl_Factory;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.dto.VSPipelineDataV4;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.program.VSCoreImpl;
import org.valkyrienskies.core.impl.program.VSCoreImpl_Factory;
import org.valkyrienskies.core.impl.program.VSCoreModule;
import org.valkyrienskies.core.impl.program.VSCoreModule_GetConfiguratorFactory;
import org.valkyrienskies.core.impl.program.VSCoreModule_GetHooksFactory;
import org.valkyrienskies.core.impl.program.VSCoreModule_GetPhysicsThreadCheckerFactory;
import org.valkyrienskies.core.impl.program.VSCoreModule_ServerConfigFactory;
import org.valkyrienskies.core.impl.program.VSCoreServerFactory;
import org.valkyrienskies.core.impl.program.VSCoreServerImpl;
import org.valkyrienskies.core.impl.shadow.CA;
import org.valkyrienskies.core.impl.shadow.CC;
import org.valkyrienskies.core.impl.shadow.CH;
import org.valkyrienskies.core.impl.shadow.CJ;
import org.valkyrienskies.core.impl.shadow.CN;
import org.valkyrienskies.core.impl.shadow.CO;
import org.valkyrienskies.core.impl.shadow.CQ;
import org.valkyrienskies.core.impl.shadow.CY;
import org.valkyrienskies.core.impl.shadow.CZ;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.DO;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.DQ;
import org.valkyrienskies.core.impl.shadow.DR;
import org.valkyrienskies.core.impl.shadow.DW;
import org.valkyrienskies.core.impl.shadow.DX;
import org.valkyrienskies.core.impl.shadow.EA;
import org.valkyrienskies.core.impl.shadow.EG;
import org.valkyrienskies.core.impl.shadow.EH;
import org.valkyrienskies.core.impl.shadow.EI;
import org.valkyrienskies.core.impl.shadow.EJ;
import org.valkyrienskies.core.impl.shadow.EK;
import org.valkyrienskies.core.impl.shadow.EO;
import org.valkyrienskies.core.impl.shadow.EP;
import org.valkyrienskies.core.impl.shadow.EU;
import org.valkyrienskies.core.impl.shadow.EW;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.FD;
import org.valkyrienskies.core.impl.shadow.FE;
import org.valkyrienskies.core.impl.shadow.FF;
import org.valkyrienskies.core.impl.shadow.FG;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.FK;
import org.valkyrienskies.core.impl.shadow.FL;
import org.valkyrienskies.core.impl.shadow.FM;
import org.valkyrienskies.core.impl.shadow.FN;
import org.valkyrienskies.core.impl.shadow.FR;
import org.valkyrienskies.core.impl.shadow.GG;
import org.valkyrienskies.core.impl.shadow.GI;
import org.valkyrienskies.core.impl.shadow.GK;
import org.valkyrienskies.core.impl.shadow.cy_0;
import org.valkyrienskies.core.impl.shadow.cz_0;
import org.valkyrienskies.core.impl.shadow.do_0;
import org.valkyrienskies.core.impl.shadow.dp_0;
import org.valkyrienskies.core.impl.shadow.ea_0;
import org.valkyrienskies.core.impl.shadow.ed_1;
import org.valkyrienskies.core.impl.shadow.ei_2;
import org.valkyrienskies.core.impl.shadow.ej_2;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.es_0;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.ez_0;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.fc_0;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.impl.shadow.fj_0;
import org.valkyrienskies.core.impl.shadow.fk_0;
import org.valkyrienskies.core.impl.shadow.fl_0;
import org.valkyrienskies.core.impl.shadow.fm_0;
import org.valkyrienskies.core.impl.shadow.fr_0;
import org.valkyrienskies.core.impl.shadow.fs_0;
import org.valkyrienskies.core.impl.shadow.fv_0;
import org.valkyrienskies.core.impl.shadow.fw_0;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooksOut;
import org.valkyrienskies.core.internal.ships.VsiMutableQueryableShipData;

public final class DaggerVSCoreServerFactory {
    private DaggerVSCoreServerFactory() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private VSCoreModule vSCoreModule;
        private GG vSJacksonModule;
        private VSPipelineChainUpdaterModule vSPipelineChainUpdaterModule;

        Builder() {
        }

        /*
         * WARNING - void declaration
         */
        public final Builder vSCoreModule(VSCoreModule vSCoreModule) {
            void var1_1;
            this.vSCoreModule = (VSCoreModule)ev_2.a(var1_1);
            return this;
        }

        /*
         * WARNING - void declaration
         */
        public final Builder vSJacksonModule(GG vSJacksonModule) {
            void var1_1;
            this.vSJacksonModule = (GG)ev_2.a(var1_1);
            return this;
        }

        /*
         * WARNING - void declaration
         */
        public final Builder vSPipelineChainUpdaterModule(VSPipelineChainUpdaterModule vSPipelineChainUpdaterModule) {
            void var1_1;
            this.vSPipelineChainUpdaterModule = (VSPipelineChainUpdaterModule)ev_2.a(var1_1);
            return this;
        }

        public final VSCoreServerFactory build() {
            ev_2.a(this.vSCoreModule, VSCoreModule.class);
            if (this.vSJacksonModule == null) {
                this.vSJacksonModule = new GG();
            }
            if (this.vSPipelineChainUpdaterModule == null) {
                this.vSPipelineChainUpdaterModule = new VSPipelineChainUpdaterModule();
            }
            return new VSCoreServerFactoryImpl(this.vSCoreModule, this.vSJacksonModule, this.vSPipelineChainUpdaterModule);
        }
    }

    static final class VSCoreServerFactoryImpl
    implements VSCoreServerFactory {
        final VSCoreModule vSCoreModule;
        final VSCoreServerFactoryImpl vSCoreServerFactoryImpl = this;
        private ew_2<VsiCoreHooksOut> getHooksProvider;
        ew_2<EU> coreHooksImplProvider;
        ew_2<EY> tcpProvider;
        ew_2<EY> udpProvider;
        private ew_2<fr_0> simplePacketNetworkingImplProvider;
        ew_2<SimplePacketNetworking> simplePacketNetworkingProvider;
        ew_2<fb_0> packetsProvider;
        ew_2<fi_0> vSNetworkingProvider;
        private ew_2<fj_0> getConfiguratorProvider;
        private ew_2<FL.a> vSPipelineComponentFactoryProvider;
        private ew_2<ObjectMapper> dtoMapperProvider;
        private ew_2<ShipInertiaConverter> shipInertiaConverterProvider;
        private ew_2<ShipTransformConverterImpl> shipTransformConverterImplProvider;
        private ew_2<ObjectMapper> defaultMapperProvider;
        private ew_2<CN> jacksonAttachmentSerializerInternalProvider;
        private ew_2<CH> attachmentRegistryProvider;
        private ew_2<CA> attachmentHolderImplProvider;
        ew_2<cy_0> attachmentHolderFactoryProvider;
        private ew_2<ServerShipDataConverterImpl> serverShipDataConverterImplProvider;
        private ew_2<ServerShipDataV1UpdaterImpl> serverShipDataV1UpdaterImplProvider;
        private ew_2<VSPipelineDataV1UpdaterImpl> vSPipelineDataV1UpdaterImplProvider;
        private ew_2<ServerShipDataV2UpdaterImpl> serverShipDataV2UpdaterImplProvider;
        private ew_2<VSPipelineDataV2UpdaterImpl> vSPipelineDataV2UpdaterImplProvider;
        private ew_2<ServerShipDataV3UpdaterImpl> serverShipDataV3UpdaterImplProvider;
        private ew_2<VSPipelineDataV3UpdaterImpl> vSPipelineDataV3UpdaterImplProvider;
        private ew_2<ChainUpdater<VSPipelineDataV4>> updaterProvider;
        private ew_2<ServerShipDataV0UpdaterImpl> serverShipDataV0UpdaterImplProvider;
        private ew_2<VSPipelineDataConverterImpl> vSPipelineDataConverterImplProvider;
        private ew_2<VSPipelineSerializer> vSPipelineSerializerProvider;
        private ew_2<SolidStateImpl.BuilderImpl> builderImplProvider;
        ew_2<DN> blockTypesImplProvider;
        ew_2<VSCoreImpl> vSCoreImplProvider;
        private ew_2<do_0> solidShapeUtilsImplProvider;
        ew_2<VSCoreConfig.Server> serverConfigProvider;
        ew_2<FR> getPhysicsThreadCheckerProvider;

        /*
         * WARNING - void declaration
         */
        VSCoreServerFactoryImpl(VSCoreModule vSCoreModuleParam, GG vSJacksonModuleParam, VSPipelineChainUpdaterModule vSPipelineChainUpdaterModuleParam) {
            void var3_3;
            void var2_2;
            void var1_1;
            this.vSCoreModule = vSCoreModuleParam;
            this.initialize(vSCoreModuleParam, vSJacksonModuleParam, vSPipelineChainUpdaterModuleParam);
            this.initialize2((VSCoreModule)var1_1, (GG)var2_2, (VSPipelineChainUpdaterModule)var3_3);
        }

        /*
         * WARNING - void declaration
         */
        private void initialize(VSCoreModule vSCoreModuleParam, GG vSJacksonModuleParam, VSPipelineChainUpdaterModule vSPipelineChainUpdaterModuleParam) {
            void var2_2;
            void var1_1;
            this.getHooksProvider = VSCoreModule_GetHooksFactory.create(vSCoreModuleParam);
            this.coreHooksImplProvider = new ei_2<EU>();
            this.tcpProvider = ej_2.a(fl_0.a(this.coreHooksImplProvider));
            ei_2.a(this.coreHooksImplProvider, EW.a(this.getHooksProvider, this.tcpProvider));
            this.udpProvider = ej_2.a(fm_0.a(this.coreHooksImplProvider));
            this.simplePacketNetworkingImplProvider = fs_0.a(this.tcpProvider);
            this.simplePacketNetworkingProvider = ej_2.a(this.simplePacketNetworkingImplProvider);
            this.packetsProvider = ej_2.a(fc_0.a(this.tcpProvider, this.udpProvider, this.simplePacketNetworkingProvider));
            this.vSNetworkingProvider = ej_2.a(fk_0.a(this.udpProvider, this.tcpProvider, this.packetsProvider, this.simplePacketNetworkingProvider));
            this.getConfiguratorProvider = VSCoreModule_GetConfiguratorFactory.create((VSCoreModule)var1_1);
            this.vSPipelineComponentFactoryProvider = new ew_2<FL.a>(this){
                final /* synthetic */ VSCoreServerFactoryImpl this$0;
                {
                    void var1_1;
                    this.this$0 = var1_1;
                }

                @Override
                public FL.a get() {
                    return new VSPipelineComponentFactory(this.this$0.vSCoreServerFactoryImpl);
                }
            };
            this.dtoMapperProvider = GK.a(vSJacksonModuleParam);
            this.shipInertiaConverterProvider = ed_1.a(ShipInertiaConverter_Factory.create());
            this.shipTransformConverterImplProvider = ed_1.a(ShipTransformConverterImpl_Factory.create());
            this.defaultMapperProvider = GI.a((GG)var2_2);
            this.jacksonAttachmentSerializerInternalProvider = CO.a(this.defaultMapperProvider);
            this.attachmentRegistryProvider = ej_2.a(CJ.a(this.jacksonAttachmentSerializerInternalProvider));
            this.attachmentHolderImplProvider = CC.a(this.attachmentRegistryProvider, this.defaultMapperProvider);
            this.attachmentHolderFactoryProvider = ed_1.a(cz_0.a(this.attachmentHolderImplProvider));
            this.serverShipDataConverterImplProvider = ed_1.a(ServerShipDataConverterImpl_Factory.create(this.shipInertiaConverterProvider, this.shipTransformConverterImplProvider, this.attachmentHolderFactoryProvider));
            this.serverShipDataV1UpdaterImplProvider = ed_1.a(ServerShipDataV1UpdaterImpl_Factory.create());
            this.vSPipelineDataV1UpdaterImplProvider = ed_1.a(VSPipelineDataV1UpdaterImpl_Factory.create(this.serverShipDataV1UpdaterImplProvider));
            this.serverShipDataV2UpdaterImplProvider = ed_1.a(ServerShipDataV2UpdaterImpl_Factory.create());
            this.vSPipelineDataV2UpdaterImplProvider = ed_1.a(VSPipelineDataV2UpdaterImpl_Factory.create(this.serverShipDataV2UpdaterImplProvider));
            this.serverShipDataV3UpdaterImplProvider = ed_1.a(ServerShipDataV3UpdaterImpl_Factory.create());
        }

        /*
         * WARNING - void declaration
         */
        private void initialize2(VSCoreModule vSCoreModuleParam, GG vSJacksonModuleParam, VSPipelineChainUpdaterModule vSPipelineChainUpdaterModuleParam) {
            void var1_1;
            void var3_3;
            this.vSPipelineDataV3UpdaterImplProvider = ed_1.a(VSPipelineDataV3UpdaterImpl_Factory.create(this.serverShipDataV3UpdaterImplProvider));
            this.updaterProvider = VSPipelineChainUpdaterModule_UpdaterFactory.create((VSPipelineChainUpdaterModule)var3_3, this.vSPipelineDataV1UpdaterImplProvider, this.vSPipelineDataV2UpdaterImplProvider, this.vSPipelineDataV3UpdaterImplProvider);
            this.serverShipDataV0UpdaterImplProvider = ed_1.a(ServerShipDataV0UpdaterImpl_Factory.create());
            this.vSPipelineDataConverterImplProvider = ed_1.a(VSPipelineDataConverterImpl_Factory.create(this.serverShipDataConverterImplProvider));
            this.vSPipelineSerializerProvider = VSPipelineSerializer_Factory.create(this.dtoMapperProvider, this.serverShipDataConverterImplProvider, this.updaterProvider, this.serverShipDataV0UpdaterImplProvider, this.vSPipelineDataConverterImplProvider);
            this.builderImplProvider = SolidStateImpl_BuilderImpl_Factory.create(BoxesBlockShapeImpl_BuilderImpl_Factory.create());
            this.blockTypesImplProvider = ej_2.a(DO.a(CQ.a(), LiquidStateImpl_BuilderImpl_Factory.create(), this.builderImplProvider, BoxesBlockShapeImpl_BuilderImpl_Factory.create()));
            this.vSCoreImplProvider = new ei_2<VSCoreImpl>();
            this.solidShapeUtilsImplProvider = ed_1.a(dp_0.a(this.vSCoreImplProvider));
            ei_2.a(this.vSCoreImplProvider, ej_2.a(VSCoreImpl_Factory.create(this.vSNetworkingProvider, this.coreHooksImplProvider, this.getConfiguratorProvider, this.tcpProvider, this.vSPipelineComponentFactoryProvider, this.vSPipelineSerializerProvider, this.blockTypesImplProvider, this.simplePacketNetworkingProvider, this.solidShapeUtilsImplProvider, LiquidStateImpl_BuilderImpl_Factory.create(), this.builderImplProvider, BoxesBlockShapeImpl_BuilderImpl_Factory.create(), this.attachmentRegistryProvider)));
            this.serverConfigProvider = ej_2.a(VSCoreModule_ServerConfigFactory.create(vSCoreModuleParam));
            this.getPhysicsThreadCheckerProvider = VSCoreModule_GetPhysicsThreadCheckerFactory.create((VSCoreModule)var1_1);
        }

        @Override
        public final VSCoreServerImpl server() {
            return new VSCoreServerImpl((VSCoreImpl)this.vSCoreImplProvider.get());
        }
    }

    static final class VSPipelineComponentImpl
    implements FL {
        private final VSCoreServerFactoryImpl vSCoreServerFactoryImpl;
        private final VSPipelineComponentImpl vSPipelineComponentImpl = this;
        private ew_2<VsiMutableQueryableShipData<ShipData>> getAllShipsProvider;
        private ew_2<ChunkAllocator> getChunkAllocatorProvider;
        private ew_2<DQ> singletonChunkAllocatorProviderImplProvider;
        private ew_2<er_0> shipObjectServerWorldProvider;
        private ew_2<EO> shipObjectNetworkManagerServerProvider;
        private ew_2<Map<String, DP>> getDimensionInfoProvider;
        private ew_2<CY> shipObjectServerWorldChunkTrackerProvider;
        private ew_2<fv_0> shipObjectServerWorldPhysEntityTrackerProvider;
        private ew_2<ez_0> shipLoadManagerServerProvider;
        private ew_2<Map<String, DP>> getMutableDimensionInfoProvider;
        private ew_2<DW> connectivityHandlerProvider;
        private ew_2<ShipData.Factory> factoryProvider;
        private ew_2<FD> vSGamePipelineStageProvider;
        private ew_2<FJ> vSPhysicsPipelineStageProvider;
        private ew_2<FF> vSNetworkPipelineStageProvider;
        private ew_2<FM> vsiPipelineImplProvider;

        /*
         * WARNING - void declaration
         */
        VSPipelineComponentImpl(VSCoreServerFactoryImpl vSCoreServerFactoryImpl, EG shipWorldModuleParam) {
            void var2_2;
            void var1_1;
            this.vSCoreServerFactoryImpl = var1_1;
            this.initialize((EG)var2_2);
        }

        /*
         * WARNING - void declaration
         */
        private void initialize(EG shipWorldModuleParam) {
            void var1_1;
            this.getAllShipsProvider = ej_2.a(EH.a(shipWorldModuleParam));
            this.getChunkAllocatorProvider = ej_2.a(EI.a(shipWorldModuleParam));
            this.singletonChunkAllocatorProviderImplProvider = DR.a(this.getChunkAllocatorProvider);
            this.shipObjectServerWorldProvider = new ei_2<er_0>();
            this.shipObjectNetworkManagerServerProvider = EP.a(this.shipObjectServerWorldProvider, this.vSCoreServerFactoryImpl.tcpProvider, this.vSCoreServerFactoryImpl.udpProvider, this.vSCoreServerFactoryImpl.simplePacketNetworkingProvider, this.vSCoreServerFactoryImpl.packetsProvider);
            this.getDimensionInfoProvider = ej_2.a(EJ.a(shipWorldModuleParam));
            this.shipObjectServerWorldChunkTrackerProvider = CZ.a(this.vSCoreServerFactoryImpl.serverConfigProvider, this.getDimensionInfoProvider);
            this.shipObjectServerWorldPhysEntityTrackerProvider = fw_0.a(this.vSCoreServerFactoryImpl.serverConfigProvider);
            this.shipLoadManagerServerProvider = EA.a(this.shipObjectNetworkManagerServerProvider, this.shipObjectServerWorldChunkTrackerProvider, this.singletonChunkAllocatorProviderImplProvider, this.shipObjectServerWorldPhysEntityTrackerProvider);
            this.getMutableDimensionInfoProvider = ej_2.a(EK.a((EG)var1_1));
            this.connectivityHandlerProvider = DX.a(this.getDimensionInfoProvider, ea_0.a(), this.singletonChunkAllocatorProviderImplProvider);
            this.factoryProvider = ShipData_Factory_Factory.create(this.vSCoreServerFactoryImpl.attachmentHolderFactoryProvider);
            ei_2.a(this.shipObjectServerWorldProvider, ej_2.a(es_0.a(this.getAllShipsProvider, this.singletonChunkAllocatorProviderImplProvider, this.shipLoadManagerServerProvider, this.vSCoreServerFactoryImpl.vSNetworkingProvider, this.vSCoreServerFactoryImpl.blockTypesImplProvider, this.getMutableDimensionInfoProvider, this.connectivityHandlerProvider, this.factoryProvider, this.vSCoreServerFactoryImpl.vSCoreImplProvider)));
            this.vSGamePipelineStageProvider = FE.a(this.shipObjectServerWorldProvider, this.vSCoreServerFactoryImpl.vSCoreImplProvider);
            this.vSPhysicsPipelineStageProvider = FK.a(this.vSCoreServerFactoryImpl.blockTypesImplProvider, this.vSCoreServerFactoryImpl.getPhysicsThreadCheckerProvider, this.shipObjectServerWorldProvider, this.vSCoreServerFactoryImpl.vSCoreImplProvider);
            this.vSNetworkPipelineStageProvider = FG.a(this.shipObjectServerWorldProvider, this.vSCoreServerFactoryImpl.vSNetworkingProvider, this.vSCoreServerFactoryImpl.packetsProvider);
            this.vsiPipelineImplProvider = ej_2.a(FN.a(this.shipObjectServerWorldProvider, this.vSGamePipelineStageProvider, this.vSPhysicsPipelineStageProvider, this.vSNetworkPipelineStageProvider, this.vSCoreServerFactoryImpl.coreHooksImplProvider));
        }

        @Override
        public final FM newPipeline() {
            return (FM)this.vsiPipelineImplProvider.get();
        }

        @Override
        public final FJ newPhysicsStage() {
            return new FJ((DN)this.vSCoreServerFactoryImpl.blockTypesImplProvider.get(), VSCoreModule_GetPhysicsThreadCheckerFactory.getPhysicsThreadChecker(this.vSCoreServerFactoryImpl.vSCoreModule), (er_0)this.shipObjectServerWorldProvider.get(), this.vSCoreServerFactoryImpl.vSCoreImplProvider);
        }
    }

    static final class VSPipelineComponentFactory
    implements FL.a {
        private final VSCoreServerFactoryImpl vSCoreServerFactoryImpl;

        /*
         * WARNING - void declaration
         */
        VSPipelineComponentFactory(VSCoreServerFactoryImpl vSCoreServerFactoryImpl) {
            void var1_1;
            this.vSCoreServerFactoryImpl = var1_1;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final FL newPipelineComponent(EG module) {
            void var1_1;
            ev_2.a(module);
            return new VSPipelineComponentImpl(this.vSCoreServerFactoryImpl, (EG)var1_1);
        }
    }
}

