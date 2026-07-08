/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 */
package backported.updates.content.core.data.tags.create;

import backported.updates.foundation.common.data.TagRegistry;
import net.minecraft.class_1792;
import net.minecraft.class_6862;
import net.minecraft.class_7924;

public class CreateItemTags {
    public static final TagRegistry<class_1792> TAGS = TagRegistry.create(class_7924.field_41197, "create");
    public static final class_6862<class_1792> MODDED_STRIPPED_LOGS = TAGS.register("modded_stripped_logs");
    public static final class_6862<class_1792> MODDED_STRIPPED_WOOD = TAGS.register("modded_stripped_wood");
}

