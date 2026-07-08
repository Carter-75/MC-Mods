/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.registry.Registries
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import backported.updates.foundation.core.helper.BlockEntityTypeBuilder;
import java.util.function.Supplier;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;

public class BlockEntityRegistry {
    private final CoreRegistry<BlockEntityType<?>> registry;

    private BlockEntityRegistry(String modId) {
        this.registry = CoreRegistry.create(Registries.BLOCK_ENTITY_TYPE, modId);
    }

    public static BlockEntityRegistry create(String modId) {
        return new BlockEntityRegistry(modId);
    }

    public <T extends BlockEntity> Supplier<BlockEntityType<T>> register(String name, BlockEntityTypeBuilder<T> builder) {
        return this.registry.register(name, builder::build);
    }

    public void register() {
        this.registry.register();
    }

    public CoreRegistry<BlockEntityType<?>> registry() {
        return this.registry;
    }
}

