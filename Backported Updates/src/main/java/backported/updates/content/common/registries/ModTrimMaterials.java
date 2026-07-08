/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Util
 *  net.minecraft.item.ArmorMaterial
 *  net.minecraft.item.Item
 *  net.minecraft.text.Text
 *  net.minecraft.text.Style
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registerable
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.item.trim.ArmorTrimMaterial
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.registries.ModItems;
import java.util.Map;
import net.minecraft.util.Util;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.item.trim.ArmorTrimMaterial;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> RESIN = ModTrimMaterials.registryKey("resin");

    public static void bootstrap(Registerable<ArmorTrimMaterial> context) {
        ModTrimMaterials.register(context, RESIN, ModItems.RESIN_BRICK.get(), Style.EMPTY.withColor(16545810), 0.5f);
    }

    private static void register(Registerable<ArmorTrimMaterial> context, RegistryKey<ArmorTrimMaterial> materialKey, Item ingredient, Style style, float itemModelIndex) {
        ModTrimMaterials.register(context, materialKey, ingredient, style, itemModelIndex, Map.of());
    }

    private static void register(Registerable<ArmorTrimMaterial> context, RegistryKey<ArmorTrimMaterial> materialKey, Item ingredient, Style style, float itemModelIndex, Map<RegistryEntry<ArmorMaterial>, String> overrideArmorMaterials) {
        ArmorTrimMaterial trimMaterial = ArmorTrimMaterial.of((String)materialKey.getValue().getPath(), (Item)ingredient, (float)itemModelIndex, (Text)Text.translatable((String)Util.createTranslationKey((String)"trim_material", materialKey.getValue())).fillStyle(style), overrideArmorMaterials);
        context.register(materialKey, trimMaterial);
    }

    private static RegistryKey<ArmorTrimMaterial> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.ofVanilla((String)name));
    }
}

