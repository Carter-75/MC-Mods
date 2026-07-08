/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_7923
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import backported.updates.foundation.core.helper.BlockEntityTypeBuilder;
import java.util.function.Supplier;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_7923;

public class BlockEntityRegistry {
    private final CoreRegistry<class_2591<?>> registry;

    private BlockEntityRegistry(String modId) {
        this.registry = CoreRegistry.create(class_7923.field_41181, modId);
    }

    public static BlockEntityRegistry create(String modId) {
        return new BlockEntityRegistry(modId);
    }

    public <T extends class_2586> Supplier<class_2591<T>> register(String name, BlockEntityTypeBuilder<T> builder) {
        return this.registry.register(name, builder::build);
    }

    public void register() {
        this.registry.register();
    }

    public CoreRegistry<class_2591<?>> registry() {
        return this.registry;
    }
}

