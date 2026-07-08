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

import backported.updates.foundation.core.fabric.RegistryBuilderImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;

public abstract class RegistryBuilder {
    protected final String modId;

    protected RegistryBuilder(String modId) {
        this.modId = modId;
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static RegistryBuilder create(String modId) {
        return RegistryBuilderImpl.create(modId);
    }

    public <T> RegistryKey<Registry<T>> resource(String name) {
        return RegistryKey.ofRegistry(Identifier.of((String)this.modId, (String)name));
    }

    public abstract <T> Supplier<Registry<T>> registry(RegistryKey<Registry<T>> var1);

    public <T> RegistryReference<T> reference(String name) {
        Objects.requireNonNull(name, "Registry name cannot be null");
        RegistryKey<Registry<T>> resource = this.resource(name);
        return new RegistryReference<T>(resource, this.registry(resource));
    }

    public static void bootstrap() {
    }

    public record RegistryReference<T>(RegistryKey<Registry<T>> resource, Supplier<Registry<T>> registry) {
        public Identifier location() {
            return this.resource.getValue();
        }
    }
}

