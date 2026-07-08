/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 */
package backported.updates.foundation.core.fabric;

import backported.updates.foundation.core.CoreRegistry;
import backported.updates.foundation.core.RegistryHolder;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_7923;

public class CoreRegistryImpl<T>
extends CoreRegistry<T> {
    public static final Set<class_5321<?>> REGISTERED_KEYS = ConcurrentHashMap.newKeySet();
    private final class_2378<T> registry;

    protected CoreRegistryImpl(class_2378<T> registry, String modId) {
        super(modId);
        this.registry = registry;
    }

    public static <T> CoreRegistry<T> create(class_5321<? extends class_2378<T>> key, String modId) {
        class_2378 registry = (class_2378)class_7923.field_41167.method_10223(key.method_29177());
        if (registry == null) {
            throw new IllegalArgumentException("Unknown registry: " + String.valueOf(key.method_29177()));
        }
        return new CoreRegistryImpl<T>(registry, modId);
    }

    public static <T> CoreRegistry<T> create(class_2378<T> registry, String modId) {
        return new CoreRegistryImpl<T>(registry, modId);
    }

    @Override
    public <E extends T> Supplier<E> register(String name, Supplier<E> entry) {
        class_2960 location = class_2960.method_60655((String)this.modId, (String)name);
        class_5321 resourceKey = class_5321.method_29179((class_5321)this.registry.method_30517(), (class_2960)location);
        REGISTERED_KEYS.add(resourceKey);
        Object value = class_2378.method_10230(this.registry, (class_2960)location, entry.get());
        this.entries.add(() -> value);
        return () -> value;
    }

    @Override
    public <E extends T> RegistryHolder<E> registerHolder(String name, Supplier<E> entry) {
        final class_2960 value = class_2960.method_60655((String)this.modId, (String)name);
        final Object registered = class_2378.method_10230(this.registry, (class_2960)value, entry.get());
        this.entries.add(() -> registered);
        return new RegistryHolder<E>(){
            final class_5321<E> key;
            {
                this.key = class_5321.method_29179((class_5321)CoreRegistryImpl.this.registry.method_30517(), (class_2960)value);
            }

            @Override
            public E get() {
                return registered;
            }

            @Override
            public Optional<class_6880<E>> getHolder() {
                class_6880 holder = CoreRegistryImpl.this.registry.method_40264(this.key).orElse(null);
                return Optional.ofNullable(holder);
            }

            @Override
            public boolean isPresent() {
                return CoreRegistryImpl.this.registry.method_10250(value);
            }

            @Override
            public class_2960 getId() {
                return value;
            }

            @Override
            public class_5321<E> getKey() {
                return this.key;
            }
        };
    }

    @Override
    public class_5321<? extends class_2378<T>> key() {
        return this.registry.method_30517();
    }

    @Override
    public class_2378<T> registry() {
        return this.registry;
    }

    @Override
    protected void bootstrap() {
    }
}

