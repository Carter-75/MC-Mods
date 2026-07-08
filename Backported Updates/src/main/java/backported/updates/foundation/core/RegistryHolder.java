/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryEntry
 */
package backported.updates.foundation.core;

import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

public interface RegistryHolder<T>
extends Supplier<T> {
    @Override
    public T get();

    default public Optional<T> asOptional() {
        return this.isPresent() ? Optional.ofNullable(this.get()) : Optional.empty();
    }

    public Optional<RegistryEntry<T>> getHolder();

    public boolean isPresent();

    public Identifier getId();

    public RegistryKey<T> getKey();
}

