/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.world.BlockView
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.registry.Registries
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.CoreRegistry;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.BlockView;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.registry.Registries;

public class BlockRegistry {
    private final CoreRegistry<Block> blocks;
    private final CoreRegistry<Item> items;

    private BlockRegistry(String modid) {
        this.blocks = CoreRegistry.create(Registries.BLOCK, modid);
        this.items = CoreRegistry.create(Registries.ITEM, modid);
    }

    public static BlockRegistry create(String modid) {
        return new BlockRegistry(modid);
    }

    public Supplier<Block> register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings blockProperties, BiFunction<Block, Item.Settings, Item> itemFactory, Item.Settings itemProperties) {
        return this.register(name, blockFactory, blockProperties, name, itemFactory, itemProperties);
    }

    public Supplier<Block> register(String blockName, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings blockProperties, String itemName, BiFunction<Block, Item.Settings, Item> itemFactory, Item.Settings itemProperties) {
        Supplier<Block> block = this.registerNoItem(blockName, blockFactory, blockProperties);
        this.items.register(itemName, () -> (Item)itemFactory.apply((Block)block.get(), itemProperties));
        return block;
    }

    public Supplier<Block> register(String blockName, Supplier<Block> block, String itemName, Function<Supplier<Block>, Item> item) {
        Supplier<Block> entry = this.registerNoItem(blockName, block);
        this.items.register(itemName, () -> (Item)item.apply(entry));
        return entry;
    }

    public Supplier<Block> register(String name, Supplier<Block> block, Function<Supplier<Block>, Item> item) {
        Supplier<Block> entry = this.registerNoItem(name, block);
        this.items.register(name, () -> (Item)item.apply(entry));
        return entry;
    }

    public Supplier<Block> register(String name, AbstractBlock.Settings properties) {
        return this.register(name, () -> new Block(properties));
    }

    public Supplier<Block> register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings properties) {
        return this.register(name, () -> (Block)factory.apply(properties));
    }

    public Supplier<Block> register(String name, Supplier<Block> block) {
        return this.register(name, block, (Supplier<Block> entry) -> new BlockItem((Block)entry.get(), new Item.Settings()));
    }

    public Supplier<Block> registerNoItem(String name, AbstractBlock.Settings properties) {
        return this.registerNoItem(name, () -> new Block(properties));
    }

    public Supplier<Block> registerNoItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings properties) {
        return this.registerNoItem(name, () -> (Block)factory.apply(properties));
    }

    public Supplier<Block> registerNoItem(String name, Supplier<Block> block) {
        return this.blocks.register(name, block);
    }

    public void register() {
        this.blocks.register();
        this.items.register();
    }

    public CoreRegistry<Block> blocks() {
        return this.blocks;
    }

    public CoreRegistry<Item> items() {
        return this.items;
    }

    public Supplier<Item> registerItem(String name, Supplier<Item> item) {
        return this.items.register(name, item);
    }

    public boolean never(BlockState state, BlockView level, BlockPos pos, EntityType<?> entity) {
        return false;
    }

    public boolean always(BlockState state, BlockView level, BlockPos pos, EntityType<?> entity) {
        return true;
    }

    public boolean ocelotOrParrot(BlockState state, BlockView level, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

    public boolean always(BlockState state, BlockView level, BlockPos pos) {
        return true;
    }

    public boolean never(BlockState state, BlockView level, BlockPos pos) {
        return false;
    }
}

