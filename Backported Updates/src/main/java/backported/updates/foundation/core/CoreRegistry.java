/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.registry.Registry
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 */
package backported.updates.foundation.core;

import backported.updates.foundation.core.RegistryHolder;
import backported.updates.foundation.core.fabric.CoreRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;

public abstract class CoreRegistry<T> {
    protected final String modId;
    protected boolean isPresent = false;
    protected final Set<Supplier<T>> entries = new HashSet<Supplier<T>>();

    protected CoreRegistry(String modId) {
        this.modId = modId;
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> CoreRegistry<T> create(RegistryKey<? extends Registry<T>> key, String modId) {
        return CoreRegistryImpl.create(key, modId);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> CoreRegistry<T> create(Registry<T> registry, String modId) {
        return CoreRegistryImpl.create(registry, modId);
    }

    public abstract <E extends T> Supplier<E> register(String var1, Supplier<E> var2);

    public abstract <E extends T> RegistryHolder<E> registerHolder(String var1, Supplier<E> var2);

    public <E extends T> RegistryKey<T> resource(String name, Supplier<E> entry) {
        this.register(name, entry);
        return RegistryKey.of(this.key(), Identifier.of((String)this.modId, (String)name));
    }

    public Collection<Supplier<T>> entries() {
        return Collections.unmodifiableSet(this.entries);
    }

    public abstract RegistryKey<? extends Registry<T>> key();

    public abstract Registry<T> registry();

    public String modId() {
        return this.modId;
    }

    public void register() {
        if (this.isPresent) {
            throw new IllegalArgumentException("Duplication of Registry: " + String.valueOf(this.key()));
        }
        this.isPresent = true;
        this.bootstrap();
    }

    protected abstract void bootstrap();
}

