/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Util
 *  net.minecraft.item.ArmorItem$Type
 *  net.minecraft.item.ArmorMaterial
 *  net.minecraft.item.ArmorMaterial$Layer
 *  net.minecraft.item.Items
 *  net.minecraft.recipe.Ingredient
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.registry.Registry
 *  net.minecraft.util.Identifier
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registries
 */
package backported.updates.content.common.registries;

import backported.updates.content.core.FeatureFlag;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.util.Util;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registries;

public class ModArmorMaterials {
    public static final Optional<RegistryEntry<ArmorMaterial>> COPPER = ModArmorMaterials.register("copper", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), attributes -> {
        attributes.put(ArmorItem.Type.BOOTS, 1);
        attributes.put(ArmorItem.Type.LEGGINGS, 3);
        attributes.put(ArmorItem.Type.CHESTPLATE, 4);
        attributes.put(ArmorItem.Type.HELMET, 2);
        attributes.put(ArmorItem.Type.BODY, 4);
    }), 8, (RegistryEntry<SoundEvent>)SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems((ItemConvertible[])new ItemConvertible[]{Items.COPPER_INGOT}), FeatureFlag.COPPER_AGE);

    public static Optional<RegistryEntry<ArmorMaterial>> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, FeatureFlag flag) {
        if (flag.isEnabled()) {
            List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(Identifier.ofVanilla((String)name)));
            return ModArmorMaterials.register(name, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, layers, flag);
        }
        return Optional.empty();
    }

    private static Optional<RegistryEntry<ArmorMaterial>> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers, FeatureFlag flag) {
        if (flag.isEnabled()) {
            return Optional.of(Registry.registerReference((Registry)Registries.ARMOR_MATERIAL, Identifier.ofVanilla((String)name), new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, layers, toughness, knockbackResistance)));
        }
        return Optional.empty();
    }
}

