/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.PathAwareEntity
 *  net.minecraft.entity.ai.goal.FleeEntityGoal
 *  net.minecraft.entity.passive.ParrotEntity
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.dispenser.ItemDispenserBehavior
 *  net.minecraft.block.dispenser.DispenserBehavior
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.resource.ResourceReloader
 *  net.minecraft.village.TradeOffers$Factory
 *  net.minecraft.village.TradeOffers$SellItemFactory
 *  net.minecraft.entity.SpawnLocationTypes
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
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.world.Heightmap;
import net.minecraft.resource.ResourceReloader;
import net.minecraft.village.TradeOffers;
import net.minecraft.entity.SpawnLocationTypes;

public class CommonSetup {
    public static void setup() {
        ResourceReloadManager.registerServer(event -> {
            event.register(VanillaBackport.resource("wolf_sound_variants"), (ResourceReloader)WolfSoundVariantReloadListener.INSTANCE);
            event.register(VanillaBackport.resource("cow_variants"), (ResourceReloader)new CowVariantReloadListener());
            event.register(VanillaBackport.resource("chicken_variants"), (ResourceReloader)new ChickenVariantReloadListener());
            event.register(VanillaBackport.resource("pig_variants"), (ResourceReloader)new PigVariantReloadListener());
            event.register(VanillaBackport.resource("wolf_variants"), (ResourceReloader)new WolfVariantReloadListener());
            event.register(VanillaBackport.resource("frog_variants"), (ResourceReloader)new FrogVariantReloadListener());
            event.register(VanillaBackport.resource("cat_variants"), (ResourceReloader)new CatVariantReloadListener());
        });
        MobIntegration.registerIntegrations(CommonSetup::mobIntegrations);
    }

    public static void asyncSetup(ParallelDispatch dispatch) {
        dispatch.enqueueWork(() -> {
            BiomeManager.add(WorldGeneration::bootstrap);
            BiomePlacement.registerBiomePlacements(BiomeGeneration::bootstrap);
            BlockIntegration.registerIntegrations(CommonSetup::blockIntegrations);
            TradeIntegration.registerVillagerTrades(CommonSetup::tradeIntegrations);
            ParrotEntity.MOB_SOUNDS.put(ModEntities.CREAKING.get(), ModSoundEvents.PARROT_IMITATE_CREAKING.get());
        });
        LootModifier.modify(new LootIntegrations());
    }

    public static void blockIntegrations(BlockIntegration.Event event) {
        event.registerFuelItem((ItemConvertible)ModBlocks.SHORT_DRY_GRASS.get(), 100);
        event.registerFuelItem((ItemConvertible)ModBlocks.TALL_DRY_GRASS.get(), 100);
        event.registerFuelItem((ItemConvertible)ModBlocks.LEAF_LITTER.get(), 100);
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
        event.registerCompostableItem((ItemConvertible)ModBlocks.PALE_OAK_LEAVES.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.PALE_OAK_SAPLING.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.PALE_MOSS_CARPET.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.PALE_HANGING_MOSS.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.PALE_MOSS_BLOCK.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.BUSH.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.LEAF_LITTER.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.FIREFLY_BUSH.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.WILDFLOWERS.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.CACTUS_FLOWER.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.SHORT_DRY_GRASS.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.TALL_DRY_GRASS.get(), 0.3f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.OPEN_EYEBLOSSOM.get(), 0.65f);
        event.registerCompostableItem((ItemConvertible)ModBlocks.CLOSED_EYEBLOSSOM.get(), 0.65f);
        event.registerStrippableBlock(ModBlocks.PALE_OAK_LOG.get(), ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        event.registerStrippableBlock(ModBlocks.PALE_OAK_WOOD.get(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        event.registerDispenserBehavior((ItemConvertible)ModItems.PALE_OAK_BOAT.get(), (DispenserBehavior)new PaleOakBoatDispenseBehavior());
        event.registerDispenserBehavior((ItemConvertible)ModItems.PALE_OAK_CHEST_BOAT.get(), (DispenserBehavior)new PaleOakBoatDispenseBehavior(true));
        event.registerDispenserBehavior((ItemConvertible)ModItems.BLUE_EGG.get(), (DispenserBehavior)new ItemDispenserBehavior());
        event.registerDispenserBehavior((ItemConvertible)ModItems.BROWN_EGG.get(), (DispenserBehavior)new ItemDispenserBehavior());
    }

    public static void tradeIntegrations(TradeIntegration.Event event) {
        if (VanillaBackport.COMMON_CONFIG.hasPaleTrades.get().booleanValue()) {
            event.registerWandererTrade(false, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(ModBlocks.PALE_OAK_LOG.get(), 1, 8, 4, 1)});
            event.registerWandererTrade(true, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(ModBlocks.OPEN_EYEBLOSSOM.get(), 1, 1, 7, 1), new TradeOffers.SellItemFactory(ModBlocks.PALE_OAK_SAPLING.get(), 5, 1, 8, 1), new TradeOffers.SellItemFactory(ModBlocks.PALE_HANGING_MOSS.get(), 1, 3, 4, 1), new TradeOffers.SellItemFactory(ModBlocks.PALE_MOSS_BLOCK.get(), 1, 2, 5, 1)});
        }
        if (VanillaBackport.COMMON_CONFIG.hasSpringTrades.get().booleanValue()) {
            event.registerWandererTrade(true, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(ModBlocks.WILDFLOWERS.get(), 1, 1, 12, 1), new TradeOffers.SellItemFactory(ModBlocks.TALL_DRY_GRASS.get(), 1, 1, 12, 1), new TradeOffers.SellItemFactory(ModBlocks.FIREFLY_BUSH.get(), 3, 1, 12, 1)});
        }
    }

    public static void mobIntegrations(MobIntegration.Event event) {
        event.registerMobInteraction(new LeashIntegration());
        event.registerPlacement(() -> EntityType.CAMEL, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (type, level, reason, pos, random) -> level.getBlockState(pos.down()).isIn(ModBlockTags.CAMELS_SPAWNABLE_ON) && level.getBaseLightLevel(pos, 0) > 8);
        event.registerAttributes(ModEntities.CREAKING, Creaking::createAttributes);
        event.registerAttributes(ModEntities.HAPPY_GHAST, HappyGhast::createAttributes);
        event.registerGoal(EntityType.VINDICATOR, 1, mob -> new FleeEntityGoal((PathAwareEntity)mob, Creaking.class, 8.0f, 0.6, 1.2));
        event.registerGoal(EntityType.PILLAGER, 1, mob -> new FleeEntityGoal((PathAwareEntity)mob, Creaking.class, 8.0f, 0.6, 1.2));
        event.registerGoal(EntityType.ILLUSIONER, 3, mob -> new FleeEntityGoal((PathAwareEntity)mob, Creaking.class, 8.0f, 0.6, 1.2));
        event.registerGoal(EntityType.EVOKER, 3, mob -> new FleeEntityGoal((PathAwareEntity)mob, Creaking.class, 8.0f, 0.6, 1.2));
    }
}

