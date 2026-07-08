/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 */
package backported.updates.content.core.data.tags;

import backported.updates.foundation.common.data.TagRegistry;
import net.minecraft.class_1299;
import net.minecraft.class_6862;
import net.minecraft.class_7924;

public class ModEntityTypeTags {
    public static final TagRegistry<class_1299<?>> TAGS = TagRegistry.create(class_7924.field_41266, "minecraft");
    public static final class_6862<class_1299<?>> FOLLOWABLE_FRIENDLY_MOBS = TAGS.register("followable_friendly_mobs");
}

