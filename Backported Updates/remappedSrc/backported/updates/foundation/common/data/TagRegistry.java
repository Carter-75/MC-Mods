/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 */
package backported.updates.foundation.common.data;

import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;

public class TagRegistry<T> {
    protected final class_5321<? extends class_2378<T>> registry;
    protected final String modId;

    protected TagRegistry(class_5321<? extends class_2378<T>> registry, String modId) {
        this.registry = registry;
        this.modId = modId;
    }

    public static <T> TagRegistry<T> create(class_5321<? extends class_2378<T>> registry, String modId) {
        return new TagRegistry<T>(registry, modId);
    }

    public class_6862<T> register(String key) {
        return class_6862.method_40092(this.registry, (class_2960)class_2960.method_60655((String)this.modId, (String)key));
    }

    public void register() {
    }
}

