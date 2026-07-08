/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 */
package backported.updates.foundation.core;

import backported.updates.foundation.core.fabric.RegistryBuilderImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;

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

    public <T> class_5321<class_2378<T>> resource(String name) {
        return class_5321.method_29180((class_2960)class_2960.method_60655((String)this.modId, (String)name));
    }

    public abstract <T> Supplier<class_2378<T>> registry(class_5321<class_2378<T>> var1);

    public <T> RegistryReference<T> reference(String name) {
        Objects.requireNonNull(name, "Registry name cannot be null");
        class_5321<class_2378<T>> resource = this.resource(name);
        return new RegistryReference<T>(resource, this.registry(resource));
    }

    public static void bootstrap() {
    }

    public record RegistryReference<T>(class_5321<class_2378<T>> resource, Supplier<class_2378<T>> registry) {
        public class_2960 location() {
            return this.resource.method_29177();
        }
    }
}

