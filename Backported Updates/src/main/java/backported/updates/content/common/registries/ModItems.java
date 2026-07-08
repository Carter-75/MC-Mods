/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.attribute.EntityAttributeModifier
 *  net.minecraft.entity.attribute.EntityAttributeModifier$Operation
 *  net.minecraft.item.ArmorItem
 *  net.minecraft.item.ArmorItem$Type
 *  net.minecraft.item.ArmorMaterials
 *  net.minecraft.item.ArmorMaterial
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.EggItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.HoeItem
 *  net.minecraft.item.PickaxeItem
 *  net.minecraft.util.Rarity
 *  net.minecraft.item.ShovelItem
 *  net.minecraft.item.SwordItem
 *  net.minecraft.item.ToolMaterial
 *  net.minecraft.util.Identifier
 *  net.minecraft.item.AnimalArmorItem
 *  net.minecraft.item.AnimalArmorItem$Type
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.item.BundleItem
 *  net.minecraft.component.type.AttributeModifierSlot
 *  net.minecraft.component.type.BundleContentsComponent
 *  net.minecraft.component.type.AttributeModifiersComponent
 *  net.minecraft.component.type.AttributeModifiersComponent$Builder
 *  net.minecraft.component.DataComponentTypes
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
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.AxeItem;
import net.minecraft.item.EggItem;
import net.minecraft.item.Item;
import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.item.AnimalArmorItem;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.BundleItem;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.DataComponentTypes;

public class ModItems {
    public static final ItemRegistry ITEMS = ItemRegistry.create("backported_updates");
    public static final Supplier<Item> RESIN_BRICK = ITEMS.register("resin_brick");
    public static final Supplier<Item> PALE_OAK_BOAT = ITEMS.register("pale_oak_boat", () -> new PaleOakBoatItem(false, new Item.Settings().maxCount(1)));
    public static final Supplier<Item> PALE_OAK_CHEST_BOAT = ITEMS.register("pale_oak_chest_boat", () -> new PaleOakBoatItem(true, new Item.Settings().maxCount(1)));
    public static final Supplier<Item> CREAKING_SPAWN_EGG = ITEMS.spawnEgg("creaking_spawn_egg", ModEntities.CREAKING, 0x5F5F5F, 16545810, new Item.Settings());
    public static final Supplier<Item> HAPPY_GHAST_SPAWN_EGG = ITEMS.spawnEgg("happy_ghast_spawn_egg", ModEntities.HAPPY_GHAST, 0xF9F9F9, 0xBCBCBC, new Item.Settings());
    public static final Supplier<Item> WHITE_HARNESS = ITEMS.register("white_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> ORANGE_HARNESS = ITEMS.register("orange_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> MAGENTA_HARNESS = ITEMS.register("magenta_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> LIGHT_BLUE_HARNESS = ITEMS.register("light_blue_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> YELLOW_HARNESS = ITEMS.register("yellow_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> LIME_HARNESS = ITEMS.register("lime_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> PINK_HARNESS = ITEMS.register("pink_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> GRAY_HARNESS = ITEMS.register("gray_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> LIGHT_GRAY_HARNESS = ITEMS.register("light_gray_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> CYAN_HARNESS = ITEMS.register("cyan_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> PURPLE_HARNESS = ITEMS.register("purple_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> BLUE_HARNESS = ITEMS.register("blue_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> BROWN_HARNESS = ITEMS.register("brown_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> GREEN_HARNESS = ITEMS.register("green_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> RED_HARNESS = ITEMS.register("red_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> BLACK_HARNESS = ITEMS.register("black_harness", HarnessItem::new, new Item.Settings().maxCount(1));
    public static final Supplier<Item> MUSIC_DISC_TEARS = ITEMS.register("music_disc_tears", new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.TEARS));
    public static final Supplier<Item> MUSIC_DISC_LAVA_CHICKEN = ITEMS.register("music_disc_lava_chicken", new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.LAVA_CHICKEN));
    public static final Supplier<Item> WHITE_BUNDLE = ITEMS.register("white_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> ORANGE_BUNDLE = ITEMS.register("orange_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> MAGENTA_BUNDLE = ITEMS.register("magenta_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> LIGHT_BLUE_BUNDLE = ITEMS.register("light_blue_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> YELLOW_BUNDLE = ITEMS.register("yellow_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> LIME_BUNDLE = ITEMS.register("lime_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> PINK_BUNDLE = ITEMS.register("pink_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> GRAY_BUNDLE = ITEMS.register("gray_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> LIGHT_GRAY_BUNDLE = ITEMS.register("light_gray_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> CYAN_BUNDLE = ITEMS.register("cyan_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> PURPLE_BUNDLE = ITEMS.register("purple_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> BLUE_BUNDLE = ITEMS.register("blue_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> BROWN_BUNDLE = ITEMS.register("brown_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> GREEN_BUNDLE = ITEMS.register("green_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> RED_BUNDLE = ITEMS.register("red_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> BLACK_BUNDLE = ITEMS.register("black_bundle", BundleItem::new, new Item.Settings().maxCount(1).component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT));
    public static final Supplier<Item> BLUE_EGG = ITEMS.register("blue_egg", () -> new EggItem(new Item.Settings().maxCount(16).component(ModDataComponents.CHICKEN_VARIANT.get(), ChickenVariants.COLD)));
    public static final Supplier<Item> BROWN_EGG = ITEMS.register("brown_egg", () -> new EggItem(new Item.Settings().maxCount(16).component(ModDataComponents.CHICKEN_VARIANT.get(), ChickenVariants.WARM)));
    public static final Optional<Supplier<Item>> COPPER_NUGGET = ModItems.conditional("copper_nugget", FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_SWORD = ModItems.conditional("copper_sword", properties -> new SwordItem((ToolMaterial)ToolMaterials.COPPER, properties), new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers((ToolMaterial)ToolMaterials.COPPER, (int)3, (float)-2.4f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_SHOVEL = ModItems.conditional("copper_shovel", properties -> new ShovelItem((ToolMaterial)ToolMaterials.COPPER, properties), new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers((ToolMaterial)ToolMaterials.COPPER, (float)1.5f, (float)-3.0f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_PICKAXE = ModItems.conditional("copper_pickaxe", properties -> new PickaxeItem((ToolMaterial)ToolMaterials.COPPER, properties), new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers((ToolMaterial)ToolMaterials.COPPER, (float)1.0f, (float)-2.8f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_AXE = ModItems.conditional("copper_axe", properties -> new AxeItem((ToolMaterial)ToolMaterials.COPPER, properties), new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers((ToolMaterial)ToolMaterials.COPPER, (float)7.0f, (float)-3.2f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_HOE = ModItems.conditional("copper_hoe", properties -> new HoeItem((ToolMaterial)ToolMaterials.COPPER, properties), new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers((ToolMaterial)ToolMaterials.COPPER, (float)-1.0f, (float)-2.0f)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_HELMET = ModItems.conditional("copper_helmet", properties -> new ArmorItem(ModArmorMaterials.COPPER.orElseThrow(), ArmorItem.Type.HELMET, properties), new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(5)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_CHESTPLATE = ModItems.conditional("copper_chestplate", properties -> new ArmorItem(ModArmorMaterials.COPPER.orElseThrow(), ArmorItem.Type.CHESTPLATE, properties), new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(5)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_LEGGINGS = ModItems.conditional("copper_leggings", properties -> new ArmorItem(ModArmorMaterials.COPPER.orElseThrow(), ArmorItem.Type.LEGGINGS, properties), new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(5)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_BOOTS = ModItems.conditional("copper_boots", properties -> new ArmorItem(ModArmorMaterials.COPPER.orElseThrow(), ArmorItem.Type.BOOTS, properties), new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(5)), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> COPPER_HORSE_ARMOR = ModItems.conditional("copper_horse_armor", properties -> new AnimalArmorItem(ModArmorMaterials.COPPER.orElseThrow(), AnimalArmorItem.Type.EQUESTRIAN, false, properties), new Item.Settings().maxCount(1), FeatureFlag.COPPER_AGE);
    public static final Optional<Supplier<Item>> NETHERITE_HORSE_ARMOR = ModItems.conditional("netherite_horse_armor", properties -> new AnimalArmorItem(ArmorMaterials.NETHERITE, AnimalArmorItem.Type.EQUESTRIAN, false, (Item.Settings)properties){

        public AttributeModifiersComponent getAttributeModifiers() {
            return (AttributeModifiersComponent)Suppliers.memoize(() -> {
                AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
                AttributeModifierSlot slot = AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.BODY);
                Identifier location = Identifier.ofVanilla((String)"armor.equestrian");
                builder.add(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(location, 19.0, EntityAttributeModifier.Operation.ADD_VALUE), slot);
                builder.add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(location, 3.0, EntityAttributeModifier.Operation.ADD_VALUE), slot);
                float knockbackResistance = 0.1f;
                if (knockbackResistance > 0.0f) {
                    builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(location, (double)knockbackResistance, EntityAttributeModifier.Operation.ADD_VALUE), slot);
                }
                return builder.build();
            }).get();
        }
    }, new Item.Settings().maxCount(1).fireproof(), FeatureFlag.MOUNTS_OF_MAYHEM);

    public static Optional<Supplier<Item>> conditional(String name, FeatureFlag flag) {
        return ModItems.conditional(name, Item::new, new Item.Settings(), flag);
    }

    public static Optional<Supplier<Item>> conditional(String name, Item.Settings properties, FeatureFlag flag) {
        return ModItems.conditional(name, Item::new, properties, flag);
    }

    public static Optional<Supplier<Item>> conditional(String name, Function<Item.Settings, Item> function, FeatureFlag flag) {
        return ModItems.conditional(name, function, new Item.Settings(), flag);
    }

    private static Optional<Supplier<Item>> conditional(String name, Function<Item.Settings, Item> factory, Item.Settings properties, FeatureFlag flag) {
        return flag.isEnabled() ? Optional.of(ITEMS.register(name, factory, properties)) : Optional.empty();
    }
}

