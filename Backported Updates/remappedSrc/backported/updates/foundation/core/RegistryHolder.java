/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 */
package backported.updates.foundation.core;

import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6880;

public interface RegistryHolder<T>
extends Supplier<T> {
    @Override
    public T get();

    default public Optional<T> asOptional() {
        return this.isPresent() ? Optional.ofNullable(this.get()) : Optional.empty();
    }

    public Optional<class_6880<T>> getHolder();

    public boolean isPresent();

    public class_2960 getId();

    public class_5321<T> getKey();
}

