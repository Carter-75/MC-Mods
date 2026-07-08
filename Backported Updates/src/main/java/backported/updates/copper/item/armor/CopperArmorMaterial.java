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
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registries
 */
package backported.updates.copper.item.armor;

import backported.updates.copper.Constants;
import backported.updates.copper.ModSounds;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.util.Util;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registries;

public class CopperArmorMaterial {
    private static final EnumMap<ArmorItem.Type, Integer> DEFENSE = (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 1);
        map.put(ArmorItem.Type.LEGGINGS, 3);
        map.put(ArmorItem.Type.CHESTPLATE, 4);
        map.put(ArmorItem.Type.HELMET, 2);
        map.put(ArmorItem.Type.BODY, 4);
    });
    public static Supplier<RegistryEntry<ArmorMaterial>> COPPER;

    private static RegistryEntry<ArmorMaterial> createCopper() {
        Identifier location = Identifier.ofVanilla((String)"copper");
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enummap.put(type, DEFENSE.get(type));
        }
        RegistryEntry equipSound = RegistryEntry.of(ModSounds.ARMOR_EQUIP_COPPER.get());
        return Registry.registerReference((Registry)Registries.ARMOR_MATERIAL, location, new ArmorMaterial(enummap, 8, equipSound, () -> Ingredient.ofItems((ItemConvertible[])new ItemConvertible[]{Items.COPPER_INGOT}), layers, 0.0f, 0.0f));
    }

    public static void init() {
        Constants.LOG.info("Registering Copper Armor Material for {}", "Copper-Age-Backport");
        COPPER = () -> CopperArmorMaterial.createCopper();
    }
}

