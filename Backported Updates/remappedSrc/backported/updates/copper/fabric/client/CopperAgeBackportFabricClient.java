/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
 *  net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry$DynamicItemRenderer
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.minecraft.class_1921
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2396
 *  net.minecraft.class_5601
 *  net.minecraft.class_5616
 *  net.minecraft.class_687$class_688
 */
package backported.updates.copper.fabric.client;

import backported.updates.copper.client.model.CopperGolemModel;
import backported.updates.copper.client.renderer.CopperChestRenderer;
import backported.updates.copper.client.renderer.CopperGolemRenderer;
import backported.updates.copper.client.renderer.CopperGolemStatueRenderer;
import backported.updates.copper.client.renderer.CopperItemRenderer;
import backported.updates.copper.client.renderer.ShelfRenderer;
import backported.updates.copper.registry.ModBlockEntities;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.registry.ModEntities;
import backported.updates.copper.registry.ModItems;
import backported.updates.copper.registry.ModParticles;
import backported.updates.copper.registry.RegistryHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.class_1921;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2396;
import net.minecraft.class_5601;
import net.minecraft.class_5616;
import net.minecraft.class_687;

public class CopperAgeBackportFabricClient
implements ClientModInitializer {
    public void onInitializeClient() {
        this.registerParticles();
        this.registerModelLayers();
        this.registerRenderers();
        this.register3DItemRenderers();
        this.registerBlockRenderLayers();
        this.hookRegistryRestoration();
    }

    private void registerParticles() {
        ParticleFactoryRegistry.getInstance().register((class_2396)ModParticles.COPPER_FIRE_FLAME.get(), class_687.class_688::new);
    }

    private void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer((class_5601)CopperGolemModel.LAYER_LOCATION, CopperGolemModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer((class_5601)CopperGolemModel.STATUE_STANDING, CopperGolemModel::createStandingStatueBodyLayer);
        EntityModelLayerRegistry.registerModelLayer((class_5601)CopperGolemModel.STATUE_RUNNING, CopperGolemModel::createRunningPoseBodyLayer);
        EntityModelLayerRegistry.registerModelLayer((class_5601)CopperGolemModel.STATUE_SITTING, CopperGolemModel::createSittingPoseBodyLayer);
        EntityModelLayerRegistry.registerModelLayer((class_5601)CopperGolemModel.STATUE_STAR, CopperGolemModel::createStarPoseBodyLayer);
    }

    private void registerRenderers() {
        EntityRendererRegistry.register(ModEntities.COPPER_GOLEM.get(), CopperGolemRenderer::new);
        class_5616.method_32144(ModBlockEntities.COPPER_CHEST_BLOCK_ENTITY.get(), CopperChestRenderer::new);
        class_5616.method_32144(ModBlockEntities.COPPER_GOLEM_STATUE_BLOCK_ENTITY.get(), CopperGolemStatueRenderer::new);
        class_5616.method_32144(ModBlockEntities.SHELF_BLOCK_ENTITY.get(), ShelfRenderer::new);
    }

    private void register3DItemRenderers() {
        CopperItemRenderer renderer = new CopperItemRenderer();
        BuiltinItemRendererRegistry.DynamicItemRenderer dynamicRenderer = renderer::method_3166;
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.EXPOSED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WEATHERED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.OXIDIZED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WAXED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WAXED_EXPOSED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WAXED_WEATHERED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WAXED_OXIDIZED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.EXPOSED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WEATHERED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WAXED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((class_1935)ModItems.WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
    }

    private void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(class_1921.method_23581(), new class_2248[]{(class_2248)ModBlocks.COPPER_TORCH.get(), (class_2248)ModBlocks.COPPER_WALL_TORCH.get(), (class_2248)ModBlocks.COPPER_LANTERN.get(), (class_2248)ModBlocks.EXPOSED_COPPER_LANTERN.get(), (class_2248)ModBlocks.WEATHERED_COPPER_LANTERN.get(), (class_2248)ModBlocks.OXIDIZED_COPPER_LANTERN.get(), (class_2248)ModBlocks.WAXED_COPPER_LANTERN.get(), (class_2248)ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get(), (class_2248)ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get(), (class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get(), (class_2248)ModBlocks.COPPER_CHAIN.get(), (class_2248)ModBlocks.EXPOSED_COPPER_CHAIN.get(), (class_2248)ModBlocks.WEATHERED_COPPER_CHAIN.get(), (class_2248)ModBlocks.OXIDIZED_COPPER_CHAIN.get(), (class_2248)ModBlocks.WAXED_COPPER_CHAIN.get(), (class_2248)ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(), (class_2248)ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(), (class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(), (class_2248)ModBlocks.COPPER_BARS.get(), (class_2248)ModBlocks.EXPOSED_COPPER_BARS.get(), (class_2248)ModBlocks.WEATHERED_COPPER_BARS.get(), (class_2248)ModBlocks.OXIDIZED_COPPER_BARS.get(), (class_2248)ModBlocks.WAXED_COPPER_BARS.get(), (class_2248)ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), (class_2248)ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), (class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get()});
    }

    private void hookRegistryRestoration() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> CopperAgeBackportFabricClient.restoreMinecraftEntries());
        ClientLifecycleEvents.CLIENT_STOPPING.register(client -> CopperAgeBackportFabricClient.restoreMinecraftEntries());
    }

    private static void restoreMinecraftEntries() {
        RegistryHelper.getInstance().restoreVanillaNamespaceEntries();
    }
}

