/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  net.minecraft.class_1304
 *  net.minecraft.class_1322
 *  net.minecraft.class_1322$class_1323
 *  net.minecraft.class_1738
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1740
 *  net.minecraft.class_1741
 *  net.minecraft.class_1743
 *  net.minecraft.class_1771
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1794
 *  net.minecraft.class_1810
 *  net.minecraft.class_1814
 *  net.minecraft.class_1821
 *  net.minecraft.class_1829
 *  net.minecraft.class_1832
 *  net.minecraft.class_2960
 *  net.minecraft.class_4059
 *  net.minecraft.class_4059$class_9076
 *  net.minecraft.class_5134
 *  net.minecraft.class_5537
 *  net.minecraft.class_9274
 *  net.minecraft.class_9276
 *  net.minecraft.class_9285
 *  net.minecraft.class_9285$class_9286
 *  net.minecraft.class_9334
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.entities.animal.ChickenVariants;
import backported.updates.content.common.level.items.HarnessItem;
import backported.updates.content.common.level.items.PaleOakBoatItem;
import backported.updates.content.common.registries.ModArmorMaterials;
import backported.updates.content.common.registries.ModDataComponents;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.common.registries.ModJukeboxSongs;
import backported.updates.content.common.registries.ToolMaterials;
import backported.updates.content.core.FeatureFlag;
import backported.updates.foundation.core.helper.ItemRegistry;
import com.google.common.base.Suppliers;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.class_1304;
import net.minecraft.class_1322;
import net.minecraft.class_1738;
import net.minecraft.class_1740;
import net.minecraft.class_1741;
import net.minecraft.class_1743;
import net.minecraft.class_1771;
import net.minecraft.class_1792;
import net.minecraft.class_1794;
import net.minecraft.class_1810;
import net.minecraft.class_1814;
import net.minecraft.class_1821;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_2960;
import net.minecraft.class_4059;
import net.minecraft.class_5134;
import net.minecraft.class_5537;
import net.minecraft.class_9274;
import net.minecraft.class_9276;
import net.minecraft.class_9285;
import net.minecraft.class_9334;

public class ModItems {
    public static final ItemRegistry ITEMS = ItemRegistry.create("minecraft");
    public static final Supplier<class_1792> RESIN_BRICK = ITEMS.register("resin_brick");
    public static final Supplier<class_1792> PALE_OAK_BOAT = ITEMS.register("pale_oak_boat", () -> new PaleOakBoatItem(false, new class_1792.class_1793().method_7889(1)));
    public static final Supplier<class_1792> PALE_OAK_CHEST_BOAT = ITEMS.register("pale_oak_chest_boat", () -> new PaleOakBoatItem(true, new class_1792.class_1793().method_7889(1)));
    public static final Supplier<class_1792> CREAKING_SPAWN_EGG = ITEMS.spawnEgg("creaking_spawn_egg", ModEntities.CREAKING, 0x5F5F5F, 16545810, new class_1792.class_1793());
    public static final Supplier<class_1792> HAPPY_GHAST_SPAWN_EGG = ITEMS.spawnEgg("happy_ghast_spawn_egg", ModEntities.HAPPY_GHAST, 0xF9F9F9, 0xBCBCBC, new class_1792.class_1793());
    public static final Supplier<class_1792> WHITE_HARNESS = ITEMS.register("white_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> ORANGE_HARNESS = ITEMS.register("orange_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> MAGENTA_HARNESS = ITEMS.register("magenta_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> LIGHT_BLUE_HARNESS = ITEMS.register("light_blue_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> YELLOW_HARNESS = ITEMS.register("yellow_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> LIME_HARNESS = ITEMS.register("lime_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> PINK_HARNESS = ITEMS.register("pink_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> GRAY_HARNESS = ITEMS.register("gray_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> LIGHT_GRAY_HARNESS = ITEMS.register("light_gray_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> CYAN_HARNESS = ITEMS.register("cyan_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> PURPLE_HARNESS = ITEMS.register("purple_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> BLUE_HARNESS = ITEMS.register("blue_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> BROWN_HARNESS = ITEMS.register("brown_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> GREEN_HARNESS = ITEMS.register("green_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> RED_HARNESS = ITEMS.register("red_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> BLACK_HARNESS = ITEMS.register("black_harness", HarnessItem::new, new class_1792.class_1793().method_7889(1));
    public static final Supplier<class_1792> MUSIC_DISC_TEARS = ITEMS.register("music_disc_tears", new class_1792.class_1793().method_7889(1).method_7894(class_1814.field_8907).method_60745(ModJukeboxSongs.TEARS));
    public static final Supplier<class_1792> MUSIC_DISC_LAVA_CHICKEN = ITEMS.register("music_disc_lava_chicken", new class_1792.class_1793().method_7889(1).method_7894(class_1814.field_8903).method_60745(ModJukeboxSongs.LAVA_CHICKEN));
    public static final Supplier<class_1792> WHITE_BUNDLE = ITEMS.register("white_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> ORANGE_BUNDLE = ITEMS.register("orange_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> MAGENTA_BUNDLE = ITEMS.register("magenta_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> LIGHT_BLUE_BUNDLE = ITEMS.register("light_blue_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> YELLOW_BUNDLE = ITEMS.register("yellow_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> LIME_BUNDLE = ITEMS.register("lime_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> PINK_BUNDLE = ITEMS.register("pink_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> GRAY_BUNDLE = ITEMS.register("gray_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> LIGHT_GRAY_BUNDLE = ITEMS.register("light_gray_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> CYAN_BUNDLE = ITEMS.register("cyan_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> PURPLE_BUNDLE = ITEMS.register("purple_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> BLUE_BUNDLE = ITEMS.register("blue_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> BROWN_BUNDLE = ITEMS.register("brown_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> GREEN_BUNDLE = ITEMS.register("green_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> RED_BUNDLE = ITEMS.register("red_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> BLACK_BUNDLE = ITEMS.register("black_bundle", class_5537::new, new class_1792.class_1793().method_7889(1).method_57349(class_9334.field_49650, (Object)class_9276.field_49289));
    public static final Supplier<class_1792> BLUE_EGG = ITEMS.register("blue_egg", () -> new class_1771(new class_1792.class_1793().method_7889(16).method_57349(ModDataComponents.CHICKEN_VARIANT.get(), ChickenVariants.COLD)));
    public static final Supplier<class_1792> BROWN_EGG = ITEMS.register("brown_egg", () -> new class_1771(new class_1792.class_1793().method_7889(16).method_57349(ModDataComponents.CHICKEN_VARIANT.get(), ChickenVariants.WARM)));
    public static final Optional<Supplier<class_1792>> COPPER_NUGGET = ModItems.conditional("copper_nugget", FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_SWORD = ModItems.conditional("copper_sword", properties -> new class_1829((class_1832)ToolMaterials.COPPER, properties), new class_1792.class_1793().method_57348(class_1829.method_57394((class_1832)ToolMaterials.COPPER, (int)3, (float)-2.4f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_SHOVEL = ModItems.conditional("copper_shovel", properties -> new class_1821((class_1832)ToolMaterials.COPPER, properties), new class_1792.class_1793().method_57348(class_1821.method_57346((class_1832)ToolMaterials.COPPER, (float)1.5f, (float)-3.0f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_PICKAXE = ModItems.conditional("copper_pickaxe", properties -> new class_1810((class_1832)ToolMaterials.COPPER, properties), new class_1792.class_1793().method_57348(class_1810.method_57346((class_1832)ToolMaterials.COPPER, (float)1.0f, (float)-2.8f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_AXE = ModItems.conditional("copper_axe", properties -> new class_1743((class_1832)ToolMaterials.COPPER, properties), new class_1792.class_1793().method_57348(class_1743.method_57346((class_1832)ToolMaterials.COPPER, (float)7.0f, (float)-3.2f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_HOE = ModItems.conditional("copper_hoe", properties -> new class_1794((class_1832)ToolMaterials.COPPER, properties), new class_1792.class_1793().method_57348(class_1794.method_57346((class_1832)ToolMaterials.COPPER, (float)-1.0f, (float)-2.0f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_HELMET = ModItems.conditional("copper_helmet", properties -> new class_1738(ModArmorMaterials.COPPER.orElseThrow(), class_1738.class_8051.field_41934, properties), new class_1792.class_1793().method_7895(class_1738.class_8051.field_41934.method_56690(5)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_CHESTPLATE = ModItems.conditional("copper_chestplate", properties -> new class_1738(ModArmorMaterials.COPPER.orElseThrow(), class_1738.class_8051.field_41935, properties), new class_1792.class_1793().method_7895(class_1738.class_8051.field_41935.method_56690(5)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_LEGGINGS = ModItems.conditional("copper_leggings", properties -> new class_1738(ModArmorMaterials.COPPER.orElseThrow(), class_1738.class_8051.field_41936, properties), new class_1792.class_1793().method_7895(class_1738.class_8051.field_41936.method_56690(5)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_BOOTS = ModItems.conditional("copper_boots", properties -> new class_1738(ModArmorMaterials.COPPER.orElseThrow(), class_1738.class_8051.field_41937, properties), new class_1792.class_1793().method_7895(class_1738.class_8051.field_41937.method_56690(5)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> COPPER_HORSE_ARMOR = ModItems.conditional("copper_horse_armor", properties -> new class_4059(ModArmorMaterials.COPPER.orElseThrow(), class_4059.class_9076.field_47825, false, properties), new class_1792.class_1793().method_7889(1), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<class_1792>> NETHERITE_HORSE_ARMOR = ModItems.conditional("netherite_horse_armor", properties -> new class_4059(class_1740.field_21977, class_4059.class_9076.field_47825, false, (class_1792.class_1793)properties){

        public class_9285 method_7844() {
            return (class_9285)Suppliers.memoize(() -> {
                class_9285.class_9286 builder = class_9285.method_57480();
                class_9274 slot = class_9274.method_59524((class_1304)this.field_41933.method_48399());
                class_2960 location = class_2960.method_60656((String)("armor." + this.field_41933.method_48400()));
                builder.method_57487(class_5134.field_23724, new class_1322(location, 19.0, class_1322.class_1323.field_6328), slot);
                builder.method_57487(class_5134.field_23725, new class_1322(location, (double)((class_1741)this.field_7881.comp_349()).comp_2303(), class_1322.class_1323.field_6328), slot);
                float knockbackResistance = ((class_1741)this.field_7881.comp_349()).comp_2304();
                if (knockbackResistance > 0.0f) {
                    builder.method_57487(class_5134.field_23718, new class_1322(location, (double)knockbackResistance, class_1322.class_1323.field_6328), slot);
                }
                return builder.method_57486();
            }).get();
        }
    }, new class_1792.class_1793().method_7889(1).method_24359(), FeatureFlag.MOUNTS_OF_MAYHEM);

    public static Optional<Supplier<class_1792>> conditional(String name, FeatureFlag flag) {
        return ModItems.conditional(name, class_1792::new, new class_1792.class_1793(), flag);
    }

    public static Optional<Supplier<class_1792>> conditional(String name, class_1792.class_1793 properties, FeatureFlag flag) {
        return ModItems.conditional(name, class_1792::new, properties, flag);
    }

    public static Optional<Supplier<class_1792>> conditional(String name, Function<class_1792.class_1793, class_1792> function, FeatureFlag flag) {
        return ModItems.conditional(name, function, new class_1792.class_1793(), flag);
    }

    private static Optional<Supplier<class_1792>> conditional(String name, Function<class_1792.class_1793, class_1792> factory, class_1792.class_1793 properties, FeatureFlag flag) {
        return flag.isEnabled() ? Optional.of(ITEMS.register(name, factory, properties)) : Optional.empty();
    }
}

