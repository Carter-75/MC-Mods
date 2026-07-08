/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.core.data.tags;

import backported.updates.foundation.common.data.TagRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryKeys;

public class ModEntityTypeTags {
    public static final TagRegistry<EntityType<?>> TAGS = TagRegistry.create(RegistryKeys.ENTITY_TYPE, "backported_updates");
    public static final TagKey<EntityType<?>> FOLLOWABLE_FRIENDLY_MOBS = TAGS.register("followable_friendly_mobs");
}

