/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  dev.engine_room.flywheel.api.event.ReloadLevelRendererCallback
 *  fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry
 *  fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
 *  net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents
 *  net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
 *  net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
 *  net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener
 *  net.fabricmc.fabric.api.resource.ResourceManagerHelper
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_1300
 *  net.minecraft.class_1311
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1935
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170$class_5364
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2591
 *  net.minecraft.class_2960
 *  net.minecraft.class_304
 *  net.minecraft.class_3264
 *  net.minecraft.class_3300
 *  net.minecraft.class_3302$class_4045
 *  net.minecraft.class_3695
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5321
 *  net.minecraft.class_5455
 *  net.minecraft.class_5601
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_638
 *  net.minecraft.class_7157
 *  net.minecraft.class_7706
 *  net.minecraft.class_7923
 *  net.minecraft.class_897
 *  net.minecraftforge.fml.config.IConfigSpec
 *  net.minecraftforge.fml.config.ModConfig$Type
 */
package org.valkyrienskies.mod.fabric.common;

import com.mojang.brigadier.CommandDispatcher;
import dev.engine_room.flywheel.api.event.ReloadLevelRendererCallback;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1935;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_304;
import net.minecraft.class_3264;
import net.minecraft.class_3300;
import net.minecraft.class_3302;
import net.minecraft.class_3695;
import net.minecraft.class_5132;
import net.minecraft.class_5321;
import net.minecraft.class_5455;
import net.minecraft.class_5601;
import net.minecraft.class_5617;
import net.minecraft.class_638;
import net.minecraft.class_7157;
import net.minecraft.class_7706;
import net.minecraft.class_7923;
import net.minecraft.class_897;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.client.EmptyRenderer;
import org.valkyrienskies.mod.client.VSPhysicsEntityModel;
import org.valkyrienskies.mod.client.VSPhysicsEntityRenderer;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.block.TestAntigravBlock;
import org.valkyrienskies.mod.common.block.TestChairBlock;
import org.valkyrienskies.mod.common.block.TestFlapBlock;
import org.valkyrienskies.mod.common.block.TestHingeBlock;
import org.valkyrienskies.mod.common.block.TestThrusterBlock;
import org.valkyrienskies.mod.common.block.TestWingBlock;
import org.valkyrienskies.mod.common.blockentity.TestAntigravBlockEntity;
import org.valkyrienskies.mod.common.blockentity.TestHingeBlockEntity;
import org.valkyrienskies.mod.common.blockentity.TestThrusterBlockEntity;
import org.valkyrienskies.mod.common.command.VSCommands;
import org.valkyrienskies.mod.common.config.DimensionParametersResolver;
import org.valkyrienskies.mod.common.config.MassDatapackResolver;
import org.valkyrienskies.mod.common.config.VSConfigUpdater;
import org.valkyrienskies.mod.common.config.VSEntityHandlerDataLoader;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.config.VSKeyBindings;
import org.valkyrienskies.mod.common.entity.ShipMountingEntity;
import org.valkyrienskies.mod.common.entity.VSPhysicsEntity;
import org.valkyrienskies.mod.common.entity.handling.VSEntityManager;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;
import org.valkyrienskies.mod.common.item.AreaAssemblerItem;
import org.valkyrienskies.mod.common.item.ConnectionCheckerItem;
import org.valkyrienskies.mod.common.item.PhysicsEntityCreatorItem;
import org.valkyrienskies.mod.common.item.ShipAssemblerItem;
import org.valkyrienskies.mod.common.item.ShipCreatorItem;
import org.valkyrienskies.mod.compat.LoadedMods;
import org.valkyrienskies.mod.compat.flywheel.FlywheelCompat;
import org.valkyrienskies.mod.compat.flywheel.ShipEmbeddingManager;
import org.valkyrienskies.mod.compat.hexcasting.HexcastingCompat;
import org.valkyrienskies.mod.fabric.common.ContraptionShipyardEntityHandlerFabric;
import org.valkyrienskies.mod.fabric.common.ValkyrienSkiesModFabric;
import org.valkyrienskies.mod.fabric.compat.dynmap.FabricDynmapHandler;
import org.valkyrienskies.mod.fabric.compat.hexcasting.FabricShipAmbit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lorg/valkyrienskies/mod/fabric/common/ValkyrienSkiesModFabric;", "Lnet/fabricmc/api/ModInitializer;", "", "onInitialize", "()V", "onInitializeClient", "", "registryName", "Lnet/minecraft/class_2248;", "block", "Lnet/minecraft/class_1792;", "registerBlockAndItem", "(Ljava/lang/String;Lnet/minecraft/class_2248;)Lnet/minecraft/class_1792;", "<init>", "Companion", "valkyrienskies-120"})
public final class ValkyrienSkiesModFabric
implements ModInitializer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final AtomicBoolean hasInitialized = new AtomicBoolean(false);

    public void onInitialize() {
        class_2248[] class_2248Array;
        if (hasInitialized.getAndSet(true)) {
            return;
        }
        class_2248[] $this$onInitialize_u24lambda_u240 = class_2248Array = ForgeConfigRegistry.INSTANCE;
        boolean bl = false;
        $this$onInitialize_u24lambda_u240.register("valkyrienskies", ModConfig.Type.SERVER, (IConfigSpec)VSConfigUpdater.INSTANCE.getCORE_SERVER_SPEC(), "valkyrienskies/vs-core-server.toml");
        $this$onInitialize_u24lambda_u240.register("valkyrienskies", ModConfig.Type.SERVER, (IConfigSpec)VSConfigUpdater.INSTANCE.getSERVER_SPEC(), "valkyrienskies/valkyrienskies-server.toml");
        $this$onInitialize_u24lambda_u240.register("valkyrienskies", ModConfig.Type.COMMON, (IConfigSpec)VSConfigUpdater.INSTANCE.getCOMMON_SPEC(), "valkyrienskies/valkyrienskies-common.toml");
        $this$onInitialize_u24lambda_u240.register("valkyrienskies", ModConfig.Type.CLIENT, (IConfigSpec)VSConfigUpdater.INSTANCE.getCLIENT_SPEC(), "valkyrienskies/valkyrienskies-client.toml");
        ModConfigEvents.reloading((String)"valkyrienskies").register(VSConfigUpdater.INSTANCE::update);
        ModConfigEvents.loading((String)"valkyrienskies").register(VSConfigUpdater.INSTANCE::update);
        ValkyrienSkiesMod.INSTANCE.setTEST_CHAIR((class_2248)TestChairBlock.INSTANCE);
        ValkyrienSkiesMod.INSTANCE.setTEST_HINGE((class_2248)TestHingeBlock.INSTANCE);
        ValkyrienSkiesMod.INSTANCE.setTEST_FLAP((class_2248)TestFlapBlock.INSTANCE);
        ValkyrienSkiesMod.INSTANCE.setTEST_WING((class_2248)TestWingBlock.INSTANCE);
        ValkyrienSkiesMod.INSTANCE.setTEST_THRUSTER((class_2248)TestThrusterBlock.INSTANCE);
        ValkyrienSkiesMod.INSTANCE.setTEST_ANTIGRAV(TestAntigravBlock.INSTANCE);
        ValkyrienSkiesMod.INSTANCE.setCONNECTION_CHECKER_ITEM(new ConnectionCheckerItem(new class_1792.class_1793(), ValkyrienSkiesModFabric::onInitialize$lambda$1, ValkyrienSkiesModFabric::onInitialize$lambda$2));
        ValkyrienSkiesMod.INSTANCE.setSHIP_CREATOR_ITEM(new ShipCreatorItem(new class_1792.class_1793(), ValkyrienSkiesModFabric::onInitialize$lambda$3, ValkyrienSkiesModFabric::onInitialize$lambda$4));
        ValkyrienSkiesMod.INSTANCE.setSHIP_ASSEMBLER_ITEM(new ShipAssemblerItem(new class_1792.class_1793()));
        ValkyrienSkiesMod.INSTANCE.setAREA_ASSEMBLER_ITEM(new AreaAssemblerItem(new class_1792.class_1793(), ValkyrienSkiesModFabric::onInitialize$lambda$5, ValkyrienSkiesModFabric::onInitialize$lambda$6));
        ValkyrienSkiesMod.INSTANCE.setSHIP_CREATOR_ITEM_SMALLER(new ShipCreatorItem(new class_1792.class_1793(), ValkyrienSkiesModFabric::onInitialize$lambda$7, ValkyrienSkiesModFabric::onInitialize$lambda$8));
        ValkyrienSkiesMod.INSTANCE.setPHYSICS_ENTITY_CREATOR_ITEM(new PhysicsEntityCreatorItem(new class_1792.class_1793()));
        ValkyrienSkiesMod.INSTANCE.setSHIP_MOUNTING_ENTITY_TYPE((class_1299<ShipMountingEntity>)class_1299.class_1300.method_5903(ShipMountingEntity::new, (class_1311)class_1311.field_17715).method_17687(0.3f, 0.3f).method_5905(new class_2960("valkyrienskies", "ship_mounting_entity").toString()));
        ValkyrienSkiesMod.INSTANCE.setPHYSICS_ENTITY_TYPE((class_1299<VSPhysicsEntity>)class_1299.class_1300.method_5903(VSPhysicsEntity::new, (class_1311)class_1311.field_17715).method_17687(1.0f, 1.0f).method_27300(1).method_27299(10).method_5905(new class_2960("valkyrienskies", "vs_physics_entity").toString()));
        class_2248Array = new class_2248[]{ValkyrienSkiesMod.INSTANCE.getTEST_HINGE()};
        ValkyrienSkiesMod.INSTANCE.setTEST_HINGE_BLOCK_ENTITY_TYPE((class_2591<TestHingeBlockEntity>)FabricBlockEntityTypeBuilder.create(TestHingeBlockEntity::new, (class_2248[])class_2248Array).build());
        class_2248Array = new class_2248[]{ValkyrienSkiesMod.INSTANCE.getTEST_THRUSTER()};
        ValkyrienSkiesMod.INSTANCE.setTEST_THRUSTER_BLOCK_ENTITY_TYPE((class_2591<TestThrusterBlockEntity>)FabricBlockEntityTypeBuilder.create(TestThrusterBlockEntity::new, (class_2248[])class_2248Array).build());
        class_2248Array = new class_2248[]{ValkyrienSkiesMod.INSTANCE.getTEST_ANTIGRAV()};
        ValkyrienSkiesMod.INSTANCE.setTEST_ANTIGRAV_BLOCK_ENTITY_TYPE((class_2591<TestAntigravBlockEntity>)FabricBlockEntityTypeBuilder.create(TestAntigravBlockEntity::new, (class_2248[])class_2248Array).build());
        boolean isClient = FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
        ValkyrienSkiesMod.INSTANCE.init();
        if (isClient) {
            this.onInitializeClient();
        }
        VSEntityManager.INSTANCE.registerContraptionHandler(ContraptionShipyardEntityHandlerFabric.INSTANCE);
        this.registerBlockAndItem("test_chair", ValkyrienSkiesMod.INSTANCE.getTEST_CHAIR());
        this.registerBlockAndItem("test_hinge", ValkyrienSkiesMod.INSTANCE.getTEST_HINGE());
        this.registerBlockAndItem("test_flap", ValkyrienSkiesMod.INSTANCE.getTEST_FLAP());
        this.registerBlockAndItem("test_wing", ValkyrienSkiesMod.INSTANCE.getTEST_WING());
        this.registerBlockAndItem("test_thruster", ValkyrienSkiesMod.INSTANCE.getTEST_THRUSTER());
        this.registerBlockAndItem("test_antigrav", ValkyrienSkiesMod.INSTANCE.getTEST_ANTIGRAV());
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41178), (class_2960)new class_2960("valkyrienskies", "connection_checker"), (Object)ValkyrienSkiesMod.INSTANCE.getCONNECTION_CHECKER_ITEM());
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41178), (class_2960)new class_2960("valkyrienskies", "area_assembler"), (Object)ValkyrienSkiesMod.INSTANCE.getAREA_ASSEMBLER_ITEM());
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41178), (class_2960)new class_2960("valkyrienskies", "ship_assembler"), (Object)ValkyrienSkiesMod.INSTANCE.getSHIP_ASSEMBLER_ITEM());
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41178), (class_2960)new class_2960("valkyrienskies", "ship_creator"), (Object)ValkyrienSkiesMod.INSTANCE.getSHIP_CREATOR_ITEM());
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41178), (class_2960)new class_2960("valkyrienskies", "ship_creator_smaller"), (Object)ValkyrienSkiesMod.INSTANCE.getSHIP_CREATOR_ITEM_SMALLER());
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41178), (class_2960)new class_2960("valkyrienskies", "physics_entity_creator"), (Object)ValkyrienSkiesMod.INSTANCE.getPHYSICS_ENTITY_CREATOR_ITEM());
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41177), (class_2960)new class_2960("valkyrienskies", "ship_mounting_entity"), ValkyrienSkiesMod.INSTANCE.getSHIP_MOUNTING_ENTITY_TYPE());
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41177), (class_2960)new class_2960("valkyrienskies", "vs_physics_entity"), ValkyrienSkiesMod.INSTANCE.getPHYSICS_ENTITY_TYPE());
        FabricDefaultAttributeRegistry.register(ValkyrienSkiesMod.INSTANCE.getPHYSICS_ENTITY_TYPE(), (class_5132.class_5133)VSPhysicsEntity.Companion.createAttributes());
        class_2378.method_10230((class_2378)class_7923.field_41181, (class_2960)new class_2960("valkyrienskies", "test_hinge_block_entity"), ValkyrienSkiesMod.INSTANCE.getTEST_HINGE_BLOCK_ENTITY_TYPE());
        class_2378.method_10230((class_2378)class_7923.field_41181, (class_2960)new class_2960("valkyrienskies", "test_thruster_block_entity"), ValkyrienSkiesMod.INSTANCE.getTEST_THRUSTER_BLOCK_ENTITY_TYPE());
        class_2378.method_10230((class_2378)class_7923.field_41181, (class_2960)new class_2960("valkyrienskies", "test_antigrav_block_entity"), ValkyrienSkiesMod.INSTANCE.getTEST_ANTIGRAV_BLOCK_ENTITY_TYPE());
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_41063).register(ValkyrienSkiesModFabric::onInitialize$lambda$9);
        CommandRegistrationCallback.EVENT.register(ValkyrienSkiesModFabric::onInitialize$lambda$10);
        MassDatapackResolver.VSMassDataLoader loader1 = MassDatapackResolver.INSTANCE.getLoader();
        VSEntityHandlerDataLoader loader2 = VSEntityHandlerDataLoader.INSTANCE;
        DimensionParametersResolver loader3 = DimensionParametersResolver.INSTANCE;
        ResourceManagerHelper.get((class_3264)class_3264.field_14190).registerReloadListener(new IdentifiableResourceReloadListener(loader1, loader2){
            final /* synthetic */ MassDatapackResolver.VSMassDataLoader $loader1;
            final /* synthetic */ VSEntityHandlerDataLoader $loader2;
            {
                this.$loader1 = $loader1;
                this.$loader2 = $loader2;
            }

            public class_2960 getFabricId() {
                return new class_2960("valkyrienskies", "vs_mass");
            }

            public CompletableFuture<Void> method_25931(class_3302.class_4045 stage, class_3300 resourceManager, class_3695 preparationsProfiler, class_3695 reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                Intrinsics.checkNotNullParameter((Object)stage, (String)"stage");
                Intrinsics.checkNotNullParameter((Object)resourceManager, (String)"resourceManager");
                Intrinsics.checkNotNullParameter((Object)preparationsProfiler, (String)"preparationsProfiler");
                Intrinsics.checkNotNullParameter((Object)reloadProfiler, (String)"reloadProfiler");
                Intrinsics.checkNotNullParameter((Object)backgroundExecutor, (String)"backgroundExecutor");
                Intrinsics.checkNotNullParameter((Object)gameExecutor, (String)"gameExecutor");
                CompletionStage completionStage = this.$loader1.method_25931(stage, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor).thenAcceptBoth((CompletionStage)this.$loader2.method_25931(stage, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor), (arg_0, arg_1) -> onInitialize.19.reload$lambda$1(onInitialize.19::reload$lambda$0, arg_0, arg_1));
                Intrinsics.checkNotNullExpressionValue((Object)completionStage, (String)"thenAcceptBoth(...)");
                return completionStage;
            }

            private static final Unit reload$lambda$0(Void void_, Void void_2) {
                return Unit.INSTANCE;
            }

            private static final void reload$lambda$1(Function2 $tmp0, Object p0, Object p1) {
                Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
                $tmp0.invoke(p0, p1);
            }
        });
        ResourceManagerHelper.get((class_3264)class_3264.field_14190).registerReloadListener(new IdentifiableResourceReloadListener(loader3){
            final /* synthetic */ DimensionParametersResolver $loader3;
            {
                this.$loader3 = $loader3;
            }

            public class_2960 getFabricId() {
                return new class_2960("valkyrienskies", "vs_dimension_parameters");
            }

            public CompletableFuture<Void> method_25931(class_3302.class_4045 stage, class_3300 resourceManager, class_3695 preparationsProfiler, class_3695 reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                Intrinsics.checkNotNullParameter((Object)stage, (String)"stage");
                Intrinsics.checkNotNullParameter((Object)resourceManager, (String)"resourceManager");
                Intrinsics.checkNotNullParameter((Object)preparationsProfiler, (String)"preparationsProfiler");
                Intrinsics.checkNotNullParameter((Object)reloadProfiler, (String)"reloadProfiler");
                Intrinsics.checkNotNullParameter((Object)backgroundExecutor, (String)"backgroundExecutor");
                Intrinsics.checkNotNullParameter((Object)gameExecutor, (String)"gameExecutor");
                CompletableFuture completableFuture = this.$loader3.method_25931(stage, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor);
                Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"reload(...)");
                return completableFuture;
            }
        });
        CommonLifecycleEvents.TAGS_LOADED.register(ValkyrienSkiesModFabric::onInitialize$lambda$11);
        if (FabricLoader.getInstance().isModLoaded("dynmap")) {
            new FabricDynmapHandler().register();
        }
        if (FabricLoader.getInstance().isModLoaded("hexcasting")) {
            HexcastingCompat.INSTANCE.register(FabricShipAmbit.class);
        }
    }

    private final void onInitializeClient() {
        EntityRendererRegistry.register(ValkyrienSkiesMod.INSTANCE.getSHIP_MOUNTING_ENTITY_TYPE(), ValkyrienSkiesModFabric::onInitializeClient$lambda$12);
        EntityRendererRegistry.register(ValkyrienSkiesMod.INSTANCE.getPHYSICS_ENTITY_TYPE(), ValkyrienSkiesModFabric::onInitializeClient$lambda$13);
        EntityModelLayerRegistry.registerModelLayer((class_5601)VSPhysicsEntityModel.Companion.getLAYER_LOCATION(), VSPhysicsEntityModel.Companion::createBodyLayer);
        VSKeyBindings.INSTANCE.clientSetup(ValkyrienSkiesModFabric::onInitializeClient$lambda$14);
        if (LoadedMods.getFlywheel() == LoadedMods.FlywheelVersion.V1) {
            FlywheelCompat.INSTANCE.initClient();
        }
        if (FabricLoader.getInstance().isModLoaded("flywheel")) {
            ReloadLevelRendererCallback.EVENT.register(ValkyrienSkiesModFabric::onInitializeClient$lambda$15);
        }
    }

    private final class_1792 registerBlockAndItem(String registryName, class_2248 block) {
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41175), (class_2960)new class_2960("valkyrienskies", registryName), (Object)block);
        class_1747 item = new class_1747(block, new class_1792.class_1793());
        class_2378.method_10230((class_2378)((class_2378)class_7923.field_41178), (class_2960)new class_2960("valkyrienskies", registryName), (Object)item);
        return (class_1792)item;
    }

    private static final double onInitialize$lambda$1() {
        return 1.0;
    }

    private static final double onInitialize$lambda$2() {
        return VSGameConfig.SERVER.getMinScaling();
    }

    private static final double onInitialize$lambda$3() {
        return 1.0;
    }

    private static final double onInitialize$lambda$4() {
        return VSGameConfig.SERVER.getMinScaling();
    }

    private static final double onInitialize$lambda$5() {
        return 1.0;
    }

    private static final double onInitialize$lambda$6() {
        return VSGameConfig.SERVER.getMinScaling();
    }

    private static final double onInitialize$lambda$7() {
        return VSGameConfig.SERVER.getMiniShipSize();
    }

    private static final double onInitialize$lambda$8() {
        return VSGameConfig.SERVER.getMinScaling();
    }

    private static final void onInitialize$lambda$9(FabricItemGroupEntries event) {
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getTEST_CHAIR().method_8389());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getTEST_HINGE().method_8389());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getTEST_FLAP().method_8389());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getTEST_WING().method_8389());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getTEST_THRUSTER().method_8389());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getTEST_ANTIGRAV().method_8389());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getCONNECTION_CHECKER_ITEM());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getSHIP_CREATOR_ITEM());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getSHIP_ASSEMBLER_ITEM());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getSHIP_CREATOR_ITEM_SMALLER());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getAREA_ASSEMBLER_ITEM());
        event.method_45421((class_1935)ValkyrienSkiesMod.INSTANCE.getPHYSICS_ENTITY_CREATOR_ITEM());
    }

    private static final void onInitialize$lambda$10(CommandDispatcher dispatcher, class_7157 d2, class_2170.class_5364 class_53642) {
        Intrinsics.checkNotNull((Object)dispatcher);
        VSCommands.INSTANCE.registerServerCommands((CommandDispatcher<class_2168>)dispatcher);
    }

    private static final void onInitialize$lambda$11(class_5455 class_54552, boolean bl) {
        VSGameEvents.INSTANCE.getTagsAreLoaded().emit(Unit.INSTANCE);
    }

    private static final class_897 onInitializeClient$lambda$12(class_5617.class_5618 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return new EmptyRenderer(context);
    }

    private static final class_897 onInitializeClient$lambda$13(class_5617.class_5618 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return (class_897)new VSPhysicsEntityRenderer(context);
    }

    private static final void onInitializeClient$lambda$14(class_304 it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        KeyBindingHelper.registerKeyBinding((class_304)it);
    }

    private static final void onInitializeClient$lambda$15(class_638 event) {
        ShipEmbeddingManager.INSTANCE.unloadAllShip();
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/mod/fabric/common/ValkyrienSkiesModFabric$Companion;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "valkyrienskies-120"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

