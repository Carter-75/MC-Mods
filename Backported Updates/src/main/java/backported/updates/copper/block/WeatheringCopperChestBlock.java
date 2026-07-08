/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.collection.DefaultedList
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.enums.ChestType
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.block.Oxidizable
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.util.ItemActionResult
 */
package backported.updates.copper.block;

import backported.updates.copper.block.CopperChestBlock;
import backported.updates.copper.block.entity.CopperChestBlockEntity;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.util.WeatheringHelper;
import com.mojang.serialization.MapCodec;
import java.util.Optional;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.ChestType;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;

public class WeatheringCopperChestBlock
extends CopperChestBlock
implements Oxidizable {
    public WeatheringCopperChestBlock(Oxidizable.OxidationLevel weatheringState, AbstractBlock.Settings properties) {
        super(weatheringState, properties);
    }

    public MapCodec<? extends WeatheringCopperChestBlock> getCodec() {
        return null;
    }

    public static Optional<Block> getNextBlock(Block block) {
        if (block == ModBlocks.COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.OXIDIZED_COPPER_CHEST.get());
        }
        return Oxidizable.getIncreasedOxidationBlock((Block)block);
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.getState();
    }

    public static Optional<Block> getPreviousBlock(Block block) {
        if (block == ModBlocks.OXIDIZED_COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.COPPER_CHEST.get());
        }
        return Optional.empty();
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (stack.isIn(ItemTags.AXES)) {
            CopperChestBlockEntity chestEntity;
            BlockEntity class_25862 = level.getBlockEntity(pos);
            if (class_25862 instanceof CopperChestBlockEntity && (chestEntity = (CopperChestBlockEntity)class_25862).isChestOpen()) {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
            Optional<Block> previousBlock = WeatheringCopperChestBlock.getPreviousBlock(state.getBlock());
            if (previousBlock.isPresent()) {
                ChestType chestType = (ChestType)state.get(CHEST_TYPE);
                Block newBlock = previousBlock.get();
                if (chestType != ChestType.SINGLE) {
                    Direction connectedDir = ChestBlock.getFacing(state);
                    BlockPos connectedPos = pos.offset(connectedDir);
                    BlockState connectedState = level.getBlockState(connectedPos);
                    if (connectedState.getBlock() == state.getBlock()) {
                        level.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        level.syncWorldEvent(player, 3005, pos, 0);
                        level.playSound(player, connectedPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        level.syncWorldEvent(player, 3005, connectedPos, 0);
                    } else {
                        level.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        level.syncWorldEvent(player, 3005, pos, 0);
                    }
                } else {
                    level.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    level.syncWorldEvent(player, 3005, pos, 0);
                }
                if (!level.isClient) {
                    DefaultedList<ItemStack> currentItems = WeatheringCopperChestBlock.copyInventoryAndClear(level, pos);
                    DefaultedList<ItemStack> connectedItems = DefaultedList.of();
                    BlockState newState = newBlock.getStateWithProperties(state);
                    if (chestType != ChestType.SINGLE) {
                        Direction connectedDir = ChestBlock.getFacing(state);
                        BlockPos connectedPos = pos.offset(connectedDir);
                        BlockState connectedState = level.getBlockState(connectedPos);
                        if (connectedState.getBlock() == state.getBlock()) {
                            BlockState connectedNewState = newBlock.getStateWithProperties(connectedState);
                            connectedItems = WeatheringCopperChestBlock.copyInventoryAndClear(level, connectedPos);
                            level.setBlockState(pos, newState, 2);
                            level.setBlockState(connectedPos, connectedNewState, 2);
                            level.updateNeighbors(pos, newBlock);
                            level.updateNeighbors(connectedPos, newBlock);
                            WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                            WeatheringCopperChestBlock.restoreInventory(level, connectedPos, connectedItems);
                            stack.damage(2, (LivingEntity)player, LivingEntity.getSlotForHand((Hand)hand));
                        } else {
                            level.setBlockState(pos, newState);
                            WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                            stack.damage(1, (LivingEntity)player, LivingEntity.getSlotForHand((Hand)hand));
                        }
                    } else {
                        level.setBlockState(pos, newState);
                        WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                        stack.damage(1, (LivingEntity)player, LivingEntity.getSlotForHand((Hand)hand));
                    }
                }
                return ItemActionResult.SUCCESS;
            }
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        if (stack.isOf(Items.HONEYCOMB)) {
            CopperChestBlockEntity chestEntity;
            BlockEntity chestBlockEntity = level.getBlockEntity(pos);
            if (chestBlockEntity instanceof CopperChestBlockEntity && (chestEntity = (CopperChestBlockEntity)chestBlockEntity).isChestOpen()) {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
            Block waxedBlock = null;
            if (this == ModBlocks.COPPER_CHEST.get()) {
                waxedBlock = (Block)ModBlocks.WAXED_COPPER_CHEST.get();
            } else if (this == ModBlocks.EXPOSED_COPPER_CHEST.get()) {
                waxedBlock = (Block)ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get();
            } else if (this == ModBlocks.WEATHERED_COPPER_CHEST.get()) {
                waxedBlock = (Block)ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get();
            } else if (this == ModBlocks.OXIDIZED_COPPER_CHEST.get()) {
                waxedBlock = (Block)ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get();
            }
            if (waxedBlock != null) {
                ChestType chestType = (ChestType)state.get(CHEST_TYPE);
                if (chestType != ChestType.SINGLE) {
                    Direction connectedDir = ChestBlock.getFacing(state);
                    BlockPos connectedPos = pos.offset(connectedDir);
                    BlockState connectedState = level.getBlockState(connectedPos);
                    if (connectedState.getBlock() == state.getBlock()) {
                        level.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        level.syncWorldEvent(player, 3003, pos, 0);
                        level.playSound(player, connectedPos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        level.syncWorldEvent(player, 3003, connectedPos, 0);
                    } else {
                        level.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        level.syncWorldEvent(player, 3003, pos, 0);
                    }
                } else {
                    level.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    level.syncWorldEvent(player, 3003, pos, 0);
                }
                if (!level.isClient) {
                    DefaultedList<ItemStack> currentItems = WeatheringCopperChestBlock.copyInventoryAndClear(level, pos);
                    DefaultedList<ItemStack> connectedItems = DefaultedList.of();
                    BlockState waxedState = waxedBlock.getStateWithProperties(state);
                    if (chestType != ChestType.SINGLE) {
                        Direction connectedDir = ChestBlock.getFacing(state);
                        BlockPos connectedPos = pos.offset(connectedDir);
                        BlockState connectedState = level.getBlockState(connectedPos);
                        if (connectedState.getBlock() == state.getBlock()) {
                            BlockState connectedWaxedState = waxedBlock.getStateWithProperties(connectedState);
                            connectedItems = WeatheringCopperChestBlock.copyInventoryAndClear(level, connectedPos);
                            level.setBlockState(pos, waxedState, 2);
                            level.setBlockState(connectedPos, connectedWaxedState, 2);
                            level.updateNeighbors(pos, waxedBlock);
                            level.updateNeighbors(connectedPos, waxedBlock);
                            WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                            WeatheringCopperChestBlock.restoreInventory(level, connectedPos, connectedItems);
                        } else {
                            level.setBlockState(pos, waxedState);
                            WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                        }
                    } else {
                        level.setBlockState(pos, waxedState);
                        WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                    }
                    stack.decrementUnlessCreative(1, (LivingEntity)player);
                }
                return ItemActionResult.SUCCESS;
            }
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        return super.onUseWithItem(stack, state, level, pos, player, hand, hitResult);
    }

    protected void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        Direction connectedDir;
        BlockPos otherPos;
        BlockState otherState;
        CopperChestBlockEntity chestEntity;
        ChestType chestType = (ChestType)state.get(CHEST_TYPE);
        if (chestType.equals(ChestType.RIGHT)) {
            return;
        }
        BlockEntity class_25862 = level.getBlockEntity(pos);
        if (class_25862 instanceof CopperChestBlockEntity && (chestEntity = (CopperChestBlockEntity)class_25862).isChestOpen()) {
            return;
        }
        Optional<Block> nextBlock = WeatheringCopperChestBlock.getNextBlock(state.getBlock());
        if (!nextBlock.isPresent() || random.nextFloat() >= 0.05688889f) {
            return;
        }
        Block newBlock = nextBlock.get();
        if (chestType != ChestType.SINGLE && (otherState = level.getBlockState(otherPos = pos.offset(connectedDir = ChestBlock.getFacing(state)))).getBlock() == state.getBlock()) {
            CopperChestBlockEntity otherChest;
            BlockEntity class_25863 = level.getBlockEntity(otherPos);
            if (class_25863 instanceof CopperChestBlockEntity && (otherChest = (CopperChestBlockEntity)class_25863).isChestOpen()) {
                return;
            }
            DefaultedList<ItemStack> thisItems = WeatheringCopperChestBlock.copyInventoryAndClear((World)level, pos);
            DefaultedList<ItemStack> otherItems = WeatheringCopperChestBlock.copyInventoryAndClear((World)level, otherPos);
            BlockState newState = newBlock.getStateWithProperties(state);
            BlockState newOtherState = newBlock.getStateWithProperties(otherState);
            level.setBlockState(pos, newState, 2);
            level.setBlockState(otherPos, newOtherState, 2);
            level.updateNeighbors(pos, newBlock);
            level.updateNeighbors(otherPos, newBlock);
            WeatheringCopperChestBlock.restoreInventory((World)level, pos, thisItems);
            WeatheringCopperChestBlock.restoreInventory((World)level, otherPos, otherItems);
            return;
        }
        DefaultedList<ItemStack> currentItems = WeatheringCopperChestBlock.copyInventoryAndClear((World)level, pos);
        BlockState newState = newBlock.getStateWithProperties(state);
        level.setBlockState(pos, newState, 2);
        WeatheringCopperChestBlock.restoreInventory((World)level, pos, currentItems);
        level.updateNeighbors(pos, newBlock);
    }

    protected boolean hasRandomTicks(BlockState state) {
        return WeatheringHelper.canWeather(state, WeatheringCopperChestBlock::getNextBlock);
    }

    public Oxidizable.OxidationLevel getAge() {
        return this.getState();
    }

    protected static DefaultedList<ItemStack> copyInventoryAndClear(World level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof Inventory) {
            Inventory container = (Inventory)blockEntity;
            DefaultedList items = DefaultedList.ofSize((int)container.size(), ItemStack.EMPTY);
            for (int i = 0; i < container.size(); ++i) {
                items.set(i, container.getStack(i).copy());
            }
            container.clear();
            if (blockEntity instanceof CopperChestBlockEntity) {
                CopperChestBlockEntity chestEntity = (CopperChestBlockEntity)blockEntity;
                chestEntity.markDirty();
            }
            return items;
        }
        return DefaultedList.of();
    }

    protected static void restoreInventory(World level, BlockPos pos, DefaultedList<ItemStack> items) {
        if (items.isEmpty()) {
            return;
        }
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof Inventory) {
            Inventory container = (Inventory)blockEntity;
            for (int i = 0; i < Math.min(container.size(), items.size()); ++i) {
                container.setStack(i, (ItemStack)items.get(i));
            }
            if (blockEntity instanceof CopperChestBlockEntity) {
                CopperChestBlockEntity chestEntity = (CopperChestBlockEntity)blockEntity;
                chestEntity.markDirty();
            }
        }
    }
}

