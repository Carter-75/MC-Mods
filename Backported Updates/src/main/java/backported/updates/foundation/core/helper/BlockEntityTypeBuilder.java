/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.types.Type
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.block.entity.BlockEntityType$Builder
 *  net.minecraft.block.BlockState
 */
package backported.updates.foundation.core.helper;

import com.mojang.datafixers.types.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.BlockState;

public record BlockEntityTypeBuilder<T extends BlockEntity>(Factory<? extends T> factory, List<Supplier<Block>> blocks) {
    public static <T extends BlockEntity> BlockEntityTypeBuilder<T> create(Factory<? extends T> factory, List<Supplier<Block>> blocks) {
        return new BlockEntityTypeBuilder<T>(factory, blocks);
    }

    @SafeVarargs
    public static <T extends BlockEntity> BlockEntityTypeBuilder<T> create(Factory<? extends T> factory, Supplier<Block> ... blocks) {
        ArrayList<Supplier<Block>> entries = new ArrayList<Supplier<Block>>(blocks.length);
        Collections.addAll(entries, blocks);
        return new BlockEntityTypeBuilder<T>(factory, entries);
    }

    public BlockEntityTypeBuilder<T> add(Supplier<Block> block) {
        this.blocks.add(block);
        return this;
    }

    @SafeVarargs
    public final BlockEntityTypeBuilder<T> add(Supplier<Block> ... block) {
        Collections.addAll(this.blocks, block);
        return this;
    }

    public BlockEntityType<T> build() {
        return this.build(null);
    }

    public BlockEntityType<T> build(Type<?> type) {
        @SuppressWarnings("unchecked") BlockEntityType<T> built = (BlockEntityType<T>)BlockEntityType.Builder.create(this.factory::create, (Block[])((Block[])this.blocks.stream().map(Supplier::get).toArray(Block[]::new))).build(type);
        return built;
    }

    public static interface Factory<T extends BlockEntity> {
        public T create(BlockPos var1, BlockState var2);
    }
}

