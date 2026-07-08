/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.Registry
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.tag.TagKey
 */
package backported.updates.foundation.common.data;

import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;

public class TagRegistry<T> {
    protected final RegistryKey<? extends Registry<T>> registry;
    protected final String modId;

    protected TagRegistry(RegistryKey<? extends Registry<T>> registry, String modId) {
        this.registry = registry;
        this.modId = modId;
    }

    public static <T> TagRegistry<T> create(RegistryKey<? extends Registry<T>> registry, String modId) {
        return new TagRegistry<T>(registry, modId);
    }

    public TagKey<T> register(String key) {
        return TagKey.of(this.registry, Identifier.of((String)this.modId, (String)key));
    }

    public void register() {
    }
}

