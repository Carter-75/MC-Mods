/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1163
 *  net.minecraft.class_1920
 *  net.minecraft.class_1921
 *  net.minecraft.class_1933
 *  net.minecraft.class_1935
 *  net.minecraft.class_2338
 *  net.minecraft.class_554
 *  net.minecraft.class_5605
 *  net.minecraft.class_7752
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
import net.minecraft.class_1163;
import net.minecraft.class_1920;
import net.minecraft.class_1921;
import net.minecraft.class_1933;
import net.minecraft.class_1935;
import net.minecraft.class_2338;
import net.minecraft.class_554;
import net.minecraft.class_5605;
import net.minecraft.class_7752;

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
        event.register(ModModelLayers.PALE_OAK_BOAT, class_554::method_31985);
        event.register(ModModelLayers.PALE_OAK_CHEST_BOAT, class_7752::method_45708);
        event.register(ModModelLayers.HAPPY_GHAST, () -> HappyGhastModel.createBodyLayer(class_5605.field_27715));
        event.register(ModModelLayers.HAPPY_GHAST_HARNESS, HappyGhastHarnessModel::createHarnessLayer);
        event.register(ModModelLayers.HAPPY_GHAST_ROPES, () -> HappyGhastModel.createBodyLayer(new class_5605(0.2f)));
        event.register(ModModelLayers.COLD_PIG, ColdPigModel::createBodyLayer);
        event.register(ModModelLayers.COLD_CHICKEN, ColdChickenModel::createBodyLayer);
        event.register(ModModelLayers.COLD_COW, ColdCowModel::createBodyLayer);
        event.register(ModModelLayers.WARM_COW, WarmCowModel::createBodyLayer);
    }

    public static void specialModels(GameRendering.SpecialModelEvent event) {
        BundleRenderer.BUNDLES.forEach(item -> ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).register((class_1935)item, new BundleRenderer()));
        SpawnEggRenderer.SPAWN_EGGS.forEach(item -> ((DynamicItemRenderer)DynamicItemRenderer.INSTANCE.get()).register((class_1935)item, new SpawnEggRenderer()));
    }

    public static void blockRendering(GameRendering.BlockRendererEvent event) {
        event.register(class_1921.method_23579(), ModBlocks.PALE_OAK_LEAVES.get());
        event.register(class_1921.method_23581(), ModBlocks.PALE_MOSS_CARPET.get(), ModBlocks.PALE_HANGING_MOSS.get(), ModBlocks.OPEN_EYEBLOSSOM.get(), ModBlocks.CLOSED_EYEBLOSSOM.get(), ModBlocks.POTTED_OPEN_EYEBLOSSOM.get(), ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get(), ModBlocks.PALE_OAK_SAPLING.get(), ModBlocks.POTTED_PALE_OAK_SAPLING.get(), ModBlocks.RESIN_CLUMP.get(), ModBlocks.BUSH.get(), ModBlocks.FIREFLY_BUSH.get(), ModBlocks.WILDFLOWERS.get(), ModBlocks.LEAF_LITTER.get(), ModBlocks.CACTUS_FLOWER.get(), ModBlocks.SHORT_DRY_GRASS.get(), ModBlocks.TALL_DRY_GRASS.get(), ModBlocks.PALE_OAK_DOOR.get(), ModBlocks.PALE_OAK_TRAPDOOR.get());
    }

    public static void blockColors(GameRendering.BlockColorEvent event) {
        event.register((state, level, pos, tint) -> level != null && pos != null ? LeafColors.getAverageDryFoliageColor(pos) : -10732494, ModBlocks.LEAF_LITTER.get());
        event.register((state, level, pos, tint) -> level != null && pos != null ? class_1163.method_4962((class_1920)level, (class_2338)pos) : class_1933.method_49724(), ModBlocks.BUSH.get());
        event.register((state, level, pos, tint) -> {
            if (tint != 0) {
                return level != null && pos != null ? class_1163.method_4962((class_1920)level, (class_2338)pos) : class_1933.method_49724();
            }
            return -1;
        }, ModBlocks.WILDFLOWERS.get());
    }

    public static void itemColors(GameRendering.ItemColorEvent event) {
        event.register(event::getColor, (class_1935)ModBlocks.BUSH.get());
    }
}

