/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.core.data.tags;

import backported.updates.foundation.common.data.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryKeys;

public class ModItemTags {
    public static final TagRegistry<Item> TAGS = TagRegistry.create(RegistryKeys.ITEM, "backported_updates");
    public static final TagKey<Item> PALE_OAK_LOGS = TAGS.register("pale_oak_logs");
    public static final TagKey<Item> HAPPY_GHAST_TEMPT_ITEMS = TAGS.register("happy_ghast_tempt_items");
    public static final TagKey<Item> HAPPY_GHAST_FOOD = TAGS.register("happy_ghast_food");
    public static final TagKey<Item> HARNESSES = TAGS.register("harnesses");
    public static final TagKey<Item> BUNDLES = TAGS.register("bundles");
    public static final TagKey<Item> EGGS = TAGS.register("eggs");
}

