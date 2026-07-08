/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.core.data.tags.create;

import backported.updates.foundation.common.data.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryKeys;

public class CreateItemTags {
    public static final TagRegistry<Item> TAGS = TagRegistry.create(RegistryKeys.ITEM, "create");
    public static final TagKey<Item> MODDED_STRIPPED_LOGS = TAGS.register("modded_stripped_logs");
    public static final TagKey<Item> MODDED_STRIPPED_WOOD = TAGS.register("modded_stripped_wood");
}

