/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.Registry
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registries
 */
package backported.updates.foundation.core.fabric;

import backported.updates.foundation.core.CoreRegistry;
import backported.updates.foundation.core.RegistryHolder;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registries;

public class CoreRegistryImpl<T>
extends CoreRegistry<T> {
    public static final Set<RegistryKey<?>> REGISTERED_KEYS = ConcurrentHashMap.newKeySet();
    private final Registry<T> registry;

    protected CoreRegistryImpl(Registry<T> registry, String modId) {
        super(modId);
        this.registry = registry;
    }

    public static <T> CoreRegistry<T> create(RegistryKey<? extends Registry<T>> key, String modId) {
        Registry registry = (Registry)Registries.REGISTRIES.get(key.getValue());
        if (registry == null) {
            throw new IllegalArgumentException("Unknown registry: " + String.valueOf(key.getValue()));
        }
        return new CoreRegistryImpl<T>(registry, modId);
    }

    public static <T> CoreRegistry<T> create(Registry<T> registry, String modId) {
        return new CoreRegistryImpl<T>(registry, modId);
    }

    @Override
    public <E extends T> Supplier<E> register(String name, Supplier<E> entry) {
        Identifier location = Identifier.of((String)this.modId, (String)name);
        RegistryKey<T> resourceKey = RegistryKey.of(this.registry.getKey(), location);
        REGISTERED_KEYS.add(resourceKey);
        E value = (E)Registry.register(this.registry, location, entry.get());
        this.entries.add(() -> value);
        return () -> value;
    }

    @Override
    public <E extends T> RegistryHolder<E> registerHolder(String name, Supplier<E> entry) {
        final Identifier value = Identifier.of((String)this.modId, (String)name);
        final E registered = (E)Registry.register(this.registry, value, entry.get());
        this.entries.add(() -> registered);
        return new RegistryHolder<E>(){
            final RegistryKey<E> key;
            {
                this.key = (RegistryKey<E>)RegistryKey.of(CoreRegistryImpl.this.registry.getKey(), value);
            }

            @Override
            public E get() {
                return registered;
            }

            @Override
            public Optional<RegistryEntry<E>> getHolder() {
                RegistryEntry<E> holder = (RegistryEntry<E>)CoreRegistryImpl.this.registry.getEntry((RegistryKey)this.key).orElse(null);
                return Optional.ofNullable(holder);
            }

            @Override
            public boolean isPresent() {
                return CoreRegistryImpl.this.registry.containsId(value);
            }

            @Override
            public Identifier getId() {
                return value;
            }

            @Override
            public RegistryKey<E> getKey() {
                return this.key;
            }
        };
    }

    @Override
    public RegistryKey<? extends Registry<T>> key() {
        return this.registry.getKey();
    }

    @Override
    public Registry<T> registry() {
        return this.registry;
    }

    @Override
    protected void bootstrap() {
    }
}

