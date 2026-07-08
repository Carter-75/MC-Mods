/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1314
 *  net.minecraft.class_1338
 *  net.minecraft.class_1453
 *  net.minecraft.class_1935
 *  net.minecraft.class_2347
 *  net.minecraft.class_2357
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_3302
 *  net.minecraft.class_3853$class_1652
 *  net.minecraft.class_3853$class_4165
 *  net.minecraft.class_9169
 */
package backported.updates.content.common;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.LootIntegrations;
import backported.updates.content.common.api.leash.LeashIntegration;
import backported.updates.content.common.api.wolf.WolfSoundVariantReloadListener;
import backported.updates.content.common.level.dispenser.PaleOakBoatDispenseBehavior;
import backported.updates.content.common.level.entities.creaking.Creaking;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.common.resource.CatVariantReloadListener;
import backported.updates.content.common.resource.ChickenVariantReloadListener;
import backported.updates.content.common.resource.CowVariantReloadListener;
import backported.updates.content.common.resource.FrogVariantReloadListener;
import backported.updates.content.common.resource.PigVariantReloadListener;
import backported.updates.content.common.resource.WolfVariantReloadListener;
import backported.updates.content.common.worldgen.BiomeGeneration;
import backported.updates.content.common.worldgen.WorldGeneration;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.foundation.common.data.LootModifier;
import backported.updates.foundation.common.integration.BlockIntegration;
import backported.updates.foundation.common.integration.MobIntegration;
import backported.updates.foundation.common.integration.TradeIntegration;
import backported.updates.foundation.common.worldgen.modifier.BiomeManager;
import backported.updates.foundation.common.worldgen.placement.BiomePlacement;
import backported.updates.foundation.core.ParallelDispatch;
import backported.updates.foundation.core.events.ResourceReloadManager;
import net.minecraft.class_1299;
import net.minecraft.class_1314;
import net.minecraft.class_1338;
import net.minecraft.class_1453;
import net.minecraft.class_1935;
import net.minecraft.class_2347;
import net.minecraft.class_2357;
import net.minecraft.class_2902;
import net.minecraft.class_3302;
import net.minecraft.class_3853;
import net.minecraft.class_9169;

public class CommonSetup {
    public static void setup() {
        ResourceReloadManager.registerServer(event -> {
            event.register(VanillaBackport.resource("wolf_sound_variants"), (class_3302)WolfSoundVariantReloadListener.INSTANCE);
            event.register(VanillaBackport.resource("cow_variants"), (class_3302)new CowVariantReloadListener());
            event.register(VanillaBackport.resource("chicken_variants"), (class_3302)new ChickenVariantReloadListener());
            event.register(VanillaBackport.resource("pig_variants"), (class_3302)new PigVariantReloadListener());
            event.register(VanillaBackport.resource("wolf_variants"), (class_3302)new WolfVariantReloadListener());
            event.register(VanillaBackport.resource("frog_variants"), (class_3302)new FrogVariantReloadListener());
            event.register(VanillaBackport.resource("cat_variants"), (class_3302)new CatVariantReloadListener());
        });
        MobIntegration.registerIntegrations(CommonSetup::mobIntegrations);
    }

    public static void asyncSetup(ParallelDispatch dispatch) {
        dispatch.enqueueWork(() -> {
            BiomeManager.add(WorldGeneration::bootstrap);
            BiomePlacement.registerBiomePlacements(BiomeGeneration::bootstrap);
            BlockIntegration.registerIntegrations(CommonSetup::blockIntegrations);
            TradeIntegration.registerVillagerTrades(CommonSetup::tradeIntegrations);
            class_1453.field_6822.put(ModEntities.CREAKING.get(), ModSoundEvents.PARROT_IMITATE_CREAKING.get());
        });
        LootModifier.modify(new LootIntegrations());
    }

    public static void blockIntegrations(BlockIntegration.Event event) {
        event.registerFuelItem((class_1935)ModBlocks.SHORT_DRY_GRASS.get(), 100);
        event.registerFuelItem((class_1935)ModBlocks.TALL_DRY_GRASS.get(), 100);
        event.registerFuelItem((class_1935)ModBlocks.LEAF_LITTER.get(), 100);
        event.registerFlammableBlock(ModBlocks.PALE_OAK_PLANKS.get(), 5, 20);
        event.registerFlammableBlock(ModBlocks.PALE_OAK_SLAB.get(), 5, 20);
        event.registerFlammableBlock(ModBlocks.PALE_OAK_FENCE_GATE.get(), 5, 20);
        event.registerFlammableBlock(ModBlocks.PALE_OAK_FENCE.get(), 5, 20);
        event.registerFlammableBlock(ModBlocks.PALE_OAK_STAIRS.get(), 5, 20);
        event.registerFlammableBlock(ModBlocks.PALE_OAK_LOG.get(), 5, 5);
        event.registerFlammableBlock(ModBlocks.STRIPPED_PALE_OAK_LOG.get(), 5, 5);
        event.registerFlammableBlock(ModBlocks.STRIPPED_PALE_OAK_WOOD.get(), 5, 5);
        event.registerFlammableBlock(ModBlocks.PALE_OAK_WOOD.get(), 5, 5);
        event.registerFlammableBlock(ModBlocks.PALE_OAK_LEAVES.get(), 30, 60);
        event.registerFlammableBlock(ModBlocks.PALE_MOSS_BLOCK.get(), 5, 100);
        event.registerFlammableBlock(ModBlocks.PALE_MOSS_CARPET.get(), 5, 100);
        event.registerFlammableBlock(ModBlocks.PALE_HANGING_MOSS.get(), 5, 100);
        event.registerFlammableBlock(ModBlocks.OPEN_EYEBLOSSOM.get(), 60, 100);
        event.registerFlammableBlock(ModBlocks.CLOSED_EYEBLOSSOM.get(), 60, 100);
        event.registerFlammableBlock(ModBlocks.BUSH.get(), 60, 100);
        event.registerFlammableBlock(ModBlocks.FIREFLY_BUSH.get(), 60, 100);
        event.registerFlammableBlock(ModBlocks.WILDFLOWERS.get(), 60, 100);
        event.registerFlammableBlock(ModBlocks.CACTUS_FLOWER.get(), 60, 100);
        event.registerFlammableBlock(ModBlocks.SHORT_DRY_GRASS.get(), 60, 100);
        event.registerFlammableBlock(ModBlocks.TALL_DRY_GRASS.get(), 60, 100);
        event.registerFlammableBlock(ModBlocks.LEAF_LITTER.get(), 60, 100);
        event.registerCompostableItem((class_1935)ModBlocks.PALE_OAK_LEAVES.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.PALE_OAK_SAPLING.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.PALE_MOSS_CARPET.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.PALE_HANGING_MOSS.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.PALE_MOSS_BLOCK.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.BUSH.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.LEAF_LITTER.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.FIREFLY_BUSH.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.WILDFLOWERS.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.CACTUS_FLOWER.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.SHORT_DRY_GRASS.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.TALL_DRY_GRASS.get(), 0.3f);
        event.registerCompostableItem((class_1935)ModBlocks.OPEN_EYEBLOSSOM.get(), 0.65f);
        event.registerCompostableItem((class_1935)ModBlocks.CLOSED_EYEBLOSSOM.get(), 0.65f);
        event.registerStrippableBlock(ModBlocks.PALE_OAK_LOG.get(), ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        event.registerStrippableBlock(ModBlocks.PALE_OAK_WOOD.get(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        event.registerDispenserBehavior((class_1935)ModItems.PALE_OAK_BOAT.get(), (class_2357)new PaleOakBoatDispenseBehavior());
        event.registerDispenserBehavior((class_1935)ModItems.PALE_OAK_CHEST_BOAT.get(), (class_2357)new PaleOakBoatDispenseBehavior(true));
        event.registerDispenserBehavior((class_1935)ModItems.BLUE_EGG.get(), (class_2357)new class_2347());
        event.registerDispenserBehavior((class_1935)ModItems.BROWN_EGG.get(), (class_2357)new class_2347());
    }

    public static void tradeIntegrations(TradeIntegration.Event event) {
        if (VanillaBackport.COMMON_CONFIG.hasPaleTrades.get().booleanValue()) {
            event.registerWandererTrade(false, new class_3853.class_1652[]{new class_3853.class_4165(ModBlocks.PALE_OAK_LOG.get(), 1, 8, 4, 1)});
            event.registerWandererTrade(true, new class_3853.class_1652[]{new class_3853.class_4165(ModBlocks.OPEN_EYEBLOSSOM.get(), 1, 1, 7, 1), new class_3853.class_4165(ModBlocks.PALE_OAK_SAPLING.get(), 5, 1, 8, 1), new class_3853.class_4165(ModBlocks.PALE_HANGING_MOSS.get(), 1, 3, 4, 1), new class_3853.class_4165(ModBlocks.PALE_MOSS_BLOCK.get(), 1, 2, 5, 1)});
        }
        if (VanillaBackport.COMMON_CONFIG.hasSpringTrades.get().booleanValue()) {
            event.registerWandererTrade(true, new class_3853.class_1652[]{new class_3853.class_4165(ModBlocks.WILDFLOWERS.get(), 1, 1, 12, 1), new class_3853.class_4165(ModBlocks.TALL_DRY_GRASS.get(), 1, 1, 12, 1), new class_3853.class_4165(ModBlocks.FIREFLY_BUSH.get(), 3, 1, 12, 1)});
        }
    }

    public static void mobIntegrations(MobIntegration.Event event) {
        event.registerMobInteraction(new LeashIntegration());
        event.registerPlacement(() -> class_1299.field_40116, class_9169.field_48745, class_2902.class_2903.field_13203, (type, level, reason, pos, random) -> level.method_8320(pos.method_10074()).method_26164(ModBlockTags.CAMELS_SPAWNABLE_ON) && level.method_22335(pos, 0) > 8);
        event.registerAttributes(ModEntities.CREAKING, Creaking::createAttributes);
        event.registerAttributes(ModEntities.HAPPY_GHAST, HappyGhast::createAttributes);
        event.registerGoal(class_1299.field_6117, 1, mob -> new class_1338((class_1314)mob, Creaking.class, 8.0f, 0.6, 1.2));
        event.registerGoal(class_1299.field_6105, 1, mob -> new class_1338((class_1314)mob, Creaking.class, 8.0f, 0.6, 1.2));
        event.registerGoal(class_1299.field_6065, 3, mob -> new class_1338((class_1314)mob, Creaking.class, 8.0f, 0.6, 1.2));
        event.registerGoal(class_1299.field_6090, 3, mob -> new class_1338((class_1314)mob, Creaking.class, 8.0f, 0.6, 1.2));
    }
}

