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
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Block
 *  net.minecraft.particle.ParticleType
 *  net.minecraft.client.render.entity.model.EntityModelLayer
 *  net.minecraft.client.render.block.entity.BlockEntityRendererFactories
 *  net.minecraft.client.particle.FlameParticle$Factory
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
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Block;
import net.minecraft.particle.ParticleType;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.particle.FlameParticle;

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
        ParticleFactoryRegistry.getInstance().register((ParticleType)ModParticles.COPPER_FIRE_FLAME.get(), FlameParticle.Factory::new);
    }

    private void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer((EntityModelLayer)CopperGolemModel.LAYER_LOCATION, CopperGolemModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer((EntityModelLayer)CopperGolemModel.STATUE_STANDING, CopperGolemModel::createStandingStatueBodyLayer);
        EntityModelLayerRegistry.registerModelLayer((EntityModelLayer)CopperGolemModel.STATUE_RUNNING, CopperGolemModel::createRunningPoseBodyLayer);
        EntityModelLayerRegistry.registerModelLayer((EntityModelLayer)CopperGolemModel.STATUE_SITTING, CopperGolemModel::createSittingPoseBodyLayer);
        EntityModelLayerRegistry.registerModelLayer((EntityModelLayer)CopperGolemModel.STATUE_STAR, CopperGolemModel::createStarPoseBodyLayer);
    }

    private void registerRenderers() {
        EntityRendererRegistry.register(ModEntities.COPPER_GOLEM.get(), CopperGolemRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.COPPER_CHEST_BLOCK_ENTITY.get(), CopperChestRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.COPPER_GOLEM_STATUE_BLOCK_ENTITY.get(), CopperGolemStatueRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.SHELF_BLOCK_ENTITY.get(), ShelfRenderer::new);
    }

    private void register3DItemRenderers() {
        CopperItemRenderer renderer = new CopperItemRenderer();
        BuiltinItemRendererRegistry.DynamicItemRenderer dynamicRenderer = renderer::render;
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.EXPOSED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WEATHERED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.OXIDIZED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WAXED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WAXED_EXPOSED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WAXED_WEATHERED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WAXED_OXIDIZED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.EXPOSED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WEATHERED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WAXED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register((ItemConvertible)ModItems.WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
    }

    private void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), new Block[]{(Block)ModBlocks.COPPER_TORCH.get(), (Block)ModBlocks.COPPER_WALL_TORCH.get(), (Block)ModBlocks.COPPER_LANTERN.get(), (Block)ModBlocks.EXPOSED_COPPER_LANTERN.get(), (Block)ModBlocks.WEATHERED_COPPER_LANTERN.get(), (Block)ModBlocks.OXIDIZED_COPPER_LANTERN.get(), (Block)ModBlocks.WAXED_COPPER_LANTERN.get(), (Block)ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get(), (Block)ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get(), (Block)ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get(), (Block)ModBlocks.COPPER_CHAIN.get(), (Block)ModBlocks.EXPOSED_COPPER_CHAIN.get(), (Block)ModBlocks.WEATHERED_COPPER_CHAIN.get(), (Block)ModBlocks.OXIDIZED_COPPER_CHAIN.get(), (Block)ModBlocks.WAXED_COPPER_CHAIN.get(), (Block)ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(), (Block)ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(), (Block)ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(), (Block)ModBlocks.COPPER_BARS.get(), (Block)ModBlocks.EXPOSED_COPPER_BARS.get(), (Block)ModBlocks.WEATHERED_COPPER_BARS.get(), (Block)ModBlocks.OXIDIZED_COPPER_BARS.get(), (Block)ModBlocks.WAXED_COPPER_BARS.get(), (Block)ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), (Block)ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), (Block)ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get()});
    }

    private void hookRegistryRestoration() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> CopperAgeBackportFabricClient.restoreMinecraftEntries());
        ClientLifecycleEvents.CLIENT_STOPPING.register(client -> CopperAgeBackportFabricClient.restoreMinecraftEntries());
    }

    private static void restoreMinecraftEntries() {
        RegistryHelper.getInstance().restoreVanillaNamespaceEntries();
    }
}

