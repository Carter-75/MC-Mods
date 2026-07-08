/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.color.world.BiomeColors
 *  net.minecraft.world.BlockRenderView
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.world.biome.GrassColors
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.client.render.entity.model.BoatEntityModel
 *  net.minecraft.client.model.Dilation
 *  net.minecraft.client.render.entity.model.ChestBoatEntityModel
 */
package backported.updates.content.client;

import backported.updates.content.client.api.color.LeafColors;
import backported.updates.content.client.level.entities.model.CreakingModel;
import backported.updates.content.client.level.entities.model.HappyGhastHarnessModel;
import backported.updates.content.client.level.entities.model.HappyGhastModel;
import backported.updates.content.client.level.entities.model.chicken.ColdChickenModel;
import backported.updates.content.client.level.entities.model.cow.ColdCowModel;
import backported.updates.content.client.level.entities.model.cow.WarmCowModel;
import backported.updates.content.client.level.entities.model.pig.ColdPigModel;
import backported.updates.content.client.level.entities.renderer.CreakingRenderer;
import backported.updates.content.client.level.entities.renderer.HappyGhastRenderer;
import backported.updates.content.client.level.entities.renderer.PaleOakBoatRenderer;
import backported.updates.content.client.level.item.BundleRenderer;
import backported.updates.content.client.level.item.SpawnEggRenderer;
import backported.updates.content.client.level.particles.FallingLeavesParticle;
import backported.updates.content.client.level.particles.FireflyParticle;
import backported.updates.content.client.level.particles.TrailParticle;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.foundation.client.GameRendering;
import backported.updates.foundation.client.v2.render.DynamicItemRenderer;
import backported.updates.foundation.client.v2.render.ItemRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.world.BlockRenderView;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.biome.GrassColors;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.model.ChestBoatEntityModel;

@Environment(value=EnvType.CLIENT)
public class Rendering {
    public static void particleFactories(GameRendering.ParticleFactoryEvent event) {
        event.register(ModParticles.PALE_OAK_LEAVES, FallingLeavesParticle.PaleOakProvider::new);
        event.register(ModParticles.TRAIL, TrailParticle.Provider::new);
        event.register(ModParticles.FIREFLY, FireflyParticle.Provider::new);
        event.register(ModParticles.TINTED_LEAVES, FallingLeavesParticle.TintedLeavesProvider::new);
        event.register(ModParticles.TINTED_NEEDLES, FallingLeavesParticle.TintedLeavesProvider::new);
    }

    public static void entityRendering(GameRendering.EntityRendererEvent event) {
        event.register(ModEntities.CREAKING.get(), CreakingRenderer::new);
        event.register(ModEntities.HAPPY_GHAST.get(), HappyGhastRenderer::new);
        event.register(ModEntities.PALE_OAK_BOAT.get(), context -> new PaleOakBoatRenderer(context, false));
        event.register(ModEntities.PALE_OAK_CHEST_BOAT.get(), context -> new PaleOakBoatRenderer(context, true));
    }

    public static void modelLayers(GameRendering.ModelLayerEvent event) {
        event.register(ModModelLayers.CREAKING, CreakingModel::createBodyLayer);
        event.register(ModModelLayers.PALE_OAK_BOAT, BoatEntityModel::getTexturedModelData);
        event.register(ModModelLayers.PALE_OAK_CHEST_BOAT, ChestBoatEntityModel::getTexturedModelData);
        event.register(ModModelLayers.HAPPY_GHAST, () -> HappyGhastModel.createBodyLayer(Dilation.NONE));
        event.register(ModModelLayers.HAPPY_GHAST_HARNESS, HappyGhastHarnessModel::createHarnessLayer);
        event.register(ModModelLayers.HAPPY_GHAST_ROPES, () -> HappyGhastModel.createBodyLayer(new Dilation(0.2f)));
        event.register(ModModelLayers.COLD_PIG, ColdPigModel::createBodyLayer);
        event.register(ModModelLayers.COLD_CHICKEN, ColdChickenModel::createBodyLayer);
        event.register(ModModelLayers.COLD_COW, ColdCowModel::createBodyLayer);
        event.register(ModModelLayers.WARM_COW, WarmCowModel::createBodyLayer);
    }

    public static void specialModels(GameRendering.SpecialModelEvent event) {
        BundleRenderer.BUNDLES.forEach(item -> ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).register((ItemConvertible)item, new BundleRenderer()));
        SpawnEggRenderer.SPAWN_EGGS.forEach(item -> ((DynamicItemRenderer)DynamicItemRenderer.INSTANCE.get()).register((ItemConvertible)item, new SpawnEggRenderer()));
    }

    public static void blockRendering(GameRendering.BlockRendererEvent event) {
        event.register(RenderLayer.getCutoutMipped(), ModBlocks.PALE_OAK_LEAVES.get());
        event.register(RenderLayer.getCutout(), ModBlocks.PALE_MOSS_CARPET.get(), ModBlocks.PALE_HANGING_MOSS.get(), ModBlocks.OPEN_EYEBLOSSOM.get(), ModBlocks.CLOSED_EYEBLOSSOM.get(), ModBlocks.POTTED_OPEN_EYEBLOSSOM.get(), ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get(), ModBlocks.PALE_OAK_SAPLING.get(), ModBlocks.POTTED_PALE_OAK_SAPLING.get(), ModBlocks.RESIN_CLUMP.get(), ModBlocks.BUSH.get(), ModBlocks.FIREFLY_BUSH.get(), ModBlocks.WILDFLOWERS.get(), ModBlocks.LEAF_LITTER.get(), ModBlocks.CACTUS_FLOWER.get(), ModBlocks.SHORT_DRY_GRASS.get(), ModBlocks.TALL_DRY_GRASS.get(), ModBlocks.PALE_OAK_DOOR.get(), ModBlocks.PALE_OAK_TRAPDOOR.get());
    }

    public static void blockColors(GameRendering.BlockColorEvent event) {
        event.register((state, level, pos, tint) -> level != null && pos != null ? LeafColors.getAverageDryFoliageColor(pos) : -10732494, ModBlocks.LEAF_LITTER.get());
        event.register((state, level, pos, tint) -> level != null && pos != null ? BiomeColors.getGrassColor((BlockRenderView)level, (BlockPos)pos) : GrassColors.getDefaultColor(), ModBlocks.BUSH.get());
        event.register((state, level, pos, tint) -> {
            if (tint != 0) {
                return level != null && pos != null ? BiomeColors.getGrassColor((BlockRenderView)level, (BlockPos)pos) : GrassColors.getDefaultColor();
            }
            return -1;
        }, ModBlocks.WILDFLOWERS.get());
    }

    public static void itemColors(GameRendering.ItemColorEvent event) {
        event.register(event::getColor, (ItemConvertible)ModBlocks.BUSH.get());
    }
}

