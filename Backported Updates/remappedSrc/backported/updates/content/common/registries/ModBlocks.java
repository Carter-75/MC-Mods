/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1822
 *  net.minecraft.class_2248
 *  net.minecraft.class_2269
 *  net.minecraft.class_2323
 *  net.minecraft.class_2349
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2354
 *  net.minecraft.class_2362
 *  net.minecraft.class_2394
 *  net.minecraft.class_2440
 *  net.minecraft.class_2465
 *  net.minecraft.class_2473
 *  net.minecraft.class_2482
 *  net.minecraft.class_2498
 *  net.minecraft.class_2508
 *  net.minecraft.class_2510
 *  net.minecraft.class_2533
 *  net.minecraft.class_2544
 *  net.minecraft.class_2551
 *  net.minecraft.class_2766
 *  net.minecraft.class_2769
 *  net.minecraft.class_3619
 *  net.minecraft.class_3620
 *  net.minecraft.class_4719
 *  net.minecraft.class_4970$class_2250
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_7707
 *  net.minecraft.class_7713
 *  net.minecraft.class_7715
 *  net.minecraft.class_8169
 *  net.minecraft.class_8813
 */
package backported.updates.content.common.registries;

import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.client.registries.ModSoundTypes;
import backported.updates.content.common.level.blocks.ActualBushBlock;
import backported.updates.content.common.level.blocks.CactusFlowerBlock;
import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.DriedGhastBlock;
import backported.updates.content.common.level.blocks.EyeblossomBlock;
import backported.updates.content.common.level.blocks.EyeblossomFlowerPotBlock;
import backported.updates.content.common.level.blocks.FireflyBushBlock;
import backported.updates.content.common.level.blocks.HangingMossBlock;
import backported.updates.content.common.level.blocks.LeafLitterBlock;
import backported.updates.content.common.level.blocks.MossyCarpetBlock;
import backported.updates.content.common.level.blocks.PaleMossBlock;
import backported.updates.content.common.level.blocks.ParticleLeavesBlock;
import backported.updates.content.common.level.blocks.ResinClumpBlock;
import backported.updates.content.common.level.blocks.ShortDryGrassBlock;
import backported.updates.content.common.level.blocks.TallDryGrassBlock;
import backported.updates.content.common.registries.ModBlockSetTypes;
import backported.updates.content.common.registries.ModWoodTypes;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import backported.updates.content.core.FeatureFlag;
import backported.updates.foundation.core.helper.BlockRegistry;
import com.mojang.datafixers.util.Pair;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.class_1792;
import net.minecraft.class_1822;
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2323;
import net.minecraft.class_2349;
import net.minecraft.class_2350;
import net.minecraft.class_2354;
import net.minecraft.class_2362;
import net.minecraft.class_2394;
import net.minecraft.class_2440;
import net.minecraft.class_2465;
import net.minecraft.class_2473;
import net.minecraft.class_2482;
import net.minecraft.class_2498;
import net.minecraft.class_2508;
import net.minecraft.class_2510;
import net.minecraft.class_2533;
import net.minecraft.class_2544;
import net.minecraft.class_2551;
import net.minecraft.class_2766;
import net.minecraft.class_2769;
import net.minecraft.class_3619;
import net.minecraft.class_3620;
import net.minecraft.class_4719;
import net.minecraft.class_4970;
import net.minecraft.class_7707;
import net.minecraft.class_7713;
import net.minecraft.class_7715;
import net.minecraft.class_8169;
import net.minecraft.class_8813;

public class ModBlocks {
    public static final BlockRegistry BLOCKS = BlockRegistry.create("minecraft");
    public static final Supplier<class_2248> PALE_OAK_LEAVES = BLOCKS.register("pale_oak_leaves", properties -> new ParticleLeavesBlock(50, (Supplier<? extends class_2394>)ModParticles.PALE_OAK_LEAVES, (class_4970.class_2251)properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_16028).method_9632(0.2f).method_9640().method_9626(class_2498.field_11535).method_22488().method_26235(BLOCKS::ocelotOrParrot).method_26243(BLOCKS::never).method_26245(BLOCKS::never).method_50013().method_50012(class_3619.field_15971).method_26236(BLOCKS::never));
    public static final Supplier<class_2248> PALE_OAK_PLANKS = BLOCKS.register("pale_oak_planks", class_4970.class_2251.method_9637().method_31710(class_3620.field_16025).method_51368(class_2766.field_12651).method_9629(2.0f, 3.0f).method_9626(class_2498.field_11547).method_50013());
    public static final Supplier<class_2248> PALE_OAK_STAIRS = BLOCKS.register("pale_oak_stairs", properties -> new class_2510(PALE_OAK_PLANKS.get().method_9564(), properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_16025).method_51368(class_2766.field_12651).method_9629(2.0f, 3.0f).method_9626(class_2498.field_11547).method_50013());
    public static final Supplier<class_2248> PALE_OAK_SLAB = BLOCKS.register("pale_oak_slab", class_2482::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16025).method_51368(class_2766.field_12651).method_9629(2.0f, 3.0f).method_9626(class_2498.field_11547).method_50013());
    public static final Supplier<class_2248> PALE_OAK_FENCE = BLOCKS.register("pale_oak_fence", class_2354::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16025).method_51368(class_2766.field_12651).method_9629(2.0f, 3.0f).method_9626(class_2498.field_11547).method_50013());
    public static final Supplier<class_2248> PALE_OAK_FENCE_GATE = BLOCKS.register("pale_oak_fence_gate", properties -> new class_2349(ModWoodTypes.PALE_OAK, properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_16025).method_51369().method_51368(class_2766.field_12651).method_9629(2.0f, 3.0f).method_50013());
    public static final Supplier<class_2248> PALE_OAK_DOOR = BLOCKS.register("pale_oak_door", properties -> new class_2323(ModBlockSetTypes.PALE_OAK, properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_16025).method_51368(class_2766.field_12651).method_9632(3.0f).method_22488().method_50013().method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> PALE_OAK_WOOD = BLOCKS.register("pale_oak_wood", class_2465::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16023).method_51368(class_2766.field_12651).method_9632(2.0f).method_9626(class_2498.field_11547).method_50013());
    public static final Supplier<class_2248> PALE_OAK_LOG = BLOCKS.register("pale_oak_log", class_2465::new, ModBlocks.logProperties(class_3620.field_16025, class_3620.field_16023, class_2498.field_11547));
    public static final Supplier<class_2248> STRIPPED_PALE_OAK_WOOD = BLOCKS.register("stripped_pale_oak_wood", class_2465::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16025).method_51368(class_2766.field_12651).method_9632(2.0f).method_9626(class_2498.field_11547).method_50013());
    public static final Supplier<class_2248> STRIPPED_PALE_OAK_LOG = BLOCKS.register("stripped_pale_oak_log", class_2465::new, ModBlocks.logProperties(class_3620.field_16025, class_3620.field_16025, class_2498.field_11547));
    public static final Supplier<class_2248> PALE_MOSS_BLOCK = BLOCKS.register("pale_moss_block", PaleMossBlock::new, class_4970.class_2251.method_9637().method_50013().method_31710(class_3620.field_15993).method_9632(0.1f).method_9626(class_2498.field_28697).method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> PALE_MOSS_CARPET = BLOCKS.register("pale_moss_carpet", MossyCarpetBlock::new, class_4970.class_2251.method_9637().method_50013().method_31710(class_3620.field_15993).method_9632(0.1f).method_9626(class_2498.field_28697).method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> PALE_HANGING_MOSS = BLOCKS.register("pale_hanging_moss", HangingMossBlock::new, class_4970.class_2251.method_9637().method_50013().method_31710(class_3620.field_15993).method_9634().method_9626(class_2498.field_28696).method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> OPEN_EYEBLOSSOM = BLOCKS.register("open_eyeblossom", properties -> new EyeblossomBlock(EyeblossomBlock.Type.OPEN, (class_4970.class_2251)properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_15987).method_9634().method_9618().method_9626(class_2498.field_11535).method_49229(class_4970.class_2250.field_10657).method_50012(class_3619.field_15971).method_9640());
    public static final Supplier<class_2248> CLOSED_EYEBLOSSOM = BLOCKS.register("closed_eyeblossom", properties -> new EyeblossomBlock(EyeblossomBlock.Type.CLOSED, (class_4970.class_2251)properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_15993).method_9634().method_9618().method_9626(class_2498.field_11535).method_49229(class_4970.class_2250.field_10657).method_50012(class_3619.field_15971).method_9640());
    public static final Supplier<class_2248> PALE_OAK_SAPLING = BLOCKS.register("pale_oak_sapling", properties -> new class_2473(new class_8813("pale_oak", Optional.of(TheGardenAwakensFeatures.PALE_OAK_BONEMEAL), Optional.empty(), Optional.empty()), properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_15993).method_9634().method_9640().method_9618().method_9626(class_2498.field_11535).method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> POTTED_OPEN_EYEBLOSSOM = BLOCKS.registerNoItem("potted_open_eyeblossom", properties -> new EyeblossomFlowerPotBlock(OPEN_EYEBLOSSOM.get(), (class_4970.class_2251)properties), ModBlocks.flowerPotProperties().method_9640());
    public static final Supplier<class_2248> POTTED_CLOSED_EYEBLOSSOM = BLOCKS.registerNoItem("potted_closed_eyeblossom", properties -> new EyeblossomFlowerPotBlock(CLOSED_EYEBLOSSOM.get(), (class_4970.class_2251)properties), ModBlocks.flowerPotProperties().method_9640());
    public static final Supplier<class_2248> POTTED_PALE_OAK_SAPLING = BLOCKS.registerNoItem("potted_pale_oak_sapling", properties -> new class_2362(PALE_OAK_SAPLING.get(), properties), ModBlocks.flowerPotProperties());
    public static final Supplier<class_2248> CREAKING_HEART = BLOCKS.register("creaking_heart", CreakingHeartBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_15987).method_51368(class_2766.field_12653).method_9632(10.0f).method_9626(ModSoundTypes.CREAKING_HEART));
    public static final Pair<Supplier<class_2248>, Supplier<class_2248>> PALE_OAK_SIGN = ModBlocks.sign("pale_oak", ModWoodTypes.PALE_OAK, class_3620.field_16025);
    public static final Pair<Supplier<class_2248>, Supplier<class_2248>> PALE_OAK_HANGING_SIGN = ModBlocks.hangingSign("pale_oak", ModWoodTypes.PALE_OAK, class_3620.field_16025);
    public static final Supplier<class_2248> PALE_OAK_PRESSURE_PLATE = BLOCKS.register("pale_oak_pressure_plate", properties -> new class_2440(ModBlockSetTypes.PALE_OAK, properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_16025).method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(0.5f).method_50013().method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> PALE_OAK_TRAPDOOR = BLOCKS.register("pale_oak_trapdoor", properties -> new class_2533(ModBlockSetTypes.PALE_OAK, properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_16025).method_51368(class_2766.field_12651).method_9632(3.0f).method_22488().method_26235(BLOCKS::never).method_50013());
    public static final Supplier<class_2248> PALE_OAK_BUTTON = BLOCKS.register("pale_oak_button", properties -> new class_2269(ModBlockSetTypes.PALE_OAK, 30, properties), ModBlocks.buttonProperties());
    public static final Supplier<class_2248> RESIN_CLUMP = BLOCKS.register("resin_clump", ResinClumpBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_15981).method_51371().method_9634().method_9626(ModSoundTypes.RESIN).method_50013().method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> RESIN_BLOCK = BLOCKS.register("resin_block", class_4970.class_2251.method_9637().method_31710(class_3620.field_15981).method_51368(class_2766.field_12653).method_9626(ModSoundTypes.RESIN));
    public static final Supplier<class_2248> RESIN_BRICKS = BLOCKS.register("resin_bricks", class_4970.class_2251.method_9637().method_31710(class_3620.field_15981).method_51368(class_2766.field_12653).method_29292().method_9626(ModSoundTypes.RESIN_BRICKS).method_9629(1.5f, 6.0f));
    public static final Supplier<class_2248> RESIN_BRICK_STAIRS = BLOCKS.register("resin_brick_stairs", properties -> new class_2510(RESIN_BRICKS.get().method_9564(), properties), class_4970.class_2251.method_9637().method_31710(class_3620.field_15981).method_51368(class_2766.field_12653).method_29292().method_9626(ModSoundTypes.RESIN_BRICKS).method_9629(1.5f, 6.0f));
    public static final Supplier<class_2248> RESIN_BRICK_SLAB = BLOCKS.register("resin_brick_slab", class_2482::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_15981).method_51368(class_2766.field_12653).method_29292().method_9626(ModSoundTypes.RESIN_BRICKS).method_9629(1.5f, 6.0f));
    public static final Supplier<class_2248> RESIN_BRICK_WALL = BLOCKS.register("resin_brick_wall", class_2544::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_15981).method_51368(class_2766.field_12653).method_29292().method_9626(ModSoundTypes.RESIN_BRICKS).method_9629(1.5f, 6.0f));
    public static final Supplier<class_2248> CHISELED_RESIN_BRICKS = BLOCKS.register("chiseled_resin_bricks", class_4970.class_2251.method_9637().method_31710(class_3620.field_15981).method_51368(class_2766.field_12653).method_29292().method_9626(ModSoundTypes.RESIN_BRICKS).method_9629(1.5f, 6.0f));
    public static final Supplier<class_2248> DRIED_GHAST = BLOCKS.register("dried_ghast", DriedGhastBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_15978).method_9618().method_9626(ModSoundTypes.DRIED_GHAST).method_22488().method_9640());
    public static final Supplier<class_2248> BUSH = BLOCKS.register("bush", ActualBushBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16004).method_51371().method_9634().method_9618().method_9626(class_2498.field_11535).method_50013().method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> FIREFLY_BUSH = BLOCKS.register("firefly_bush", FireflyBushBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16004).method_50013().method_9631(state -> 2).method_9634().method_9618().method_9626(class_2498.field_17579).method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> WILDFLOWERS = BLOCKS.register("wildflowers", class_8169::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16004).method_9634().method_9626(class_2498.field_42772).method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> LEAF_LITTER = BLOCKS.register("leaf_litter", LeafLitterBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_15977).method_51371().method_9634().method_9626(ModSoundTypes.LEAF_LITTER).method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> CACTUS_FLOWER = BLOCKS.register("cactus_flower", CactusFlowerBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16030).method_9634().method_9618().method_50013().method_9626(ModSoundTypes.CACTUS_FLOWER).method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> SHORT_DRY_GRASS = BLOCKS.register("short_dry_grass", ShortDryGrassBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16010).method_51371().method_9634().method_9618().method_9626(class_2498.field_11535).method_50013().method_49229(class_4970.class_2250.field_10655).method_50012(class_3619.field_15971));
    public static final Supplier<class_2248> TALL_DRY_GRASS = BLOCKS.register("tall_dry_grass", TallDryGrassBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16010).method_51371().method_9634().method_9618().method_9626(class_2498.field_11535).method_50013().method_49229(class_4970.class_2250.field_10655).method_50012(class_3619.field_15971));

    private static Optional<Supplier<class_2248>> conditional(String name, Function<class_4970.class_2251, class_2248> factory, class_4970.class_2251 properties, FeatureFlag flag) {
        if (flag.isEnabled()) {
            return Optional.of(BLOCKS.register(name, factory, properties));
        }
        return Optional.empty();
    }

    private static class_4970.class_2251 logProperties(class_3620 topColor, class_3620 sideColor, class_2498 sound) {
        return class_4970.class_2251.method_9637().method_51520(state -> state.method_11654((class_2769)class_2465.field_11459) == class_2350.class_2351.field_11052 ? topColor : sideColor).method_51368(class_2766.field_12651).method_9632(2.0f).method_9626(sound).method_50013();
    }

    private static class_4970.class_2251 buttonProperties() {
        return class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_50012(class_3619.field_15971);
    }

    private static class_4970.class_2251 flowerPotProperties() {
        return class_4970.class_2251.method_9637().method_9618().method_22488().method_50012(class_3619.field_15971);
    }

    public static Pair<Supplier<class_2248>, Supplier<class_2248>> sign(String name, class_4719 woodType, class_3620 color) {
        class_4970.class_2251 properties = class_4970.class_2251.method_9637().method_31710(color).method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(1.0f).method_50013();
        Supplier<class_2248> standing = BLOCKS.registerNoItem(name + "_sign", () -> new class_2508(woodType, properties));
        Supplier<class_2248> wall = BLOCKS.registerNoItem(name + "_wall_sign", () -> new class_2551(woodType, properties.method_16228((class_2248)standing.get())));
        BLOCKS.registerItem(name + "_sign", () -> new class_1822(new class_1792.class_1793().method_7889(16), (class_2248)standing.get(), (class_2248)wall.get()));
        return new Pair(standing, wall);
    }

    public static Pair<Supplier<class_2248>, Supplier<class_2248>> hangingSign(String name, class_4719 woodType, class_3620 color) {
        class_4970.class_2251 properties = class_4970.class_2251.method_9637().method_31710(color).method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(1.0f).method_50013();
        Supplier<class_2248> ceiling = BLOCKS.registerNoItem(name + "_hanging_sign", () -> new class_7713(woodType, properties));
        Supplier<class_2248> wall = BLOCKS.registerNoItem(name + "_wall_hanging_sign", () -> new class_7715(woodType, properties.method_16228((class_2248)ceiling.get())));
        BLOCKS.registerItem(name + "_hanging_sign", () -> new class_7707((class_2248)ceiling.get(), (class_2248)wall.get(), new class_1792.class_1793().method_7889(16)));
        return new Pair(ceiling, wall);
    }
}

