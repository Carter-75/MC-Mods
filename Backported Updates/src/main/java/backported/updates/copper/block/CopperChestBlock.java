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
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.collection.DefaultedList
 *  net.minecraft.block.BlockRenderType
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.enums.ChestType
 *  net.minecraft.Property
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.entity.BlockEntityTicker
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.util.ItemActionResult
 */
package backported.updates.copper.block;

import backported.updates.copper.ModSounds;
import backported.updates.copper.block.entity.CopperChestBlockEntity;
import backported.updates.copper.platform.Services;
import backported.updates.copper.registry.ModBlockEntities;
import backported.updates.copper.registry.ModBlocks;
import com.mojang.serialization.MapCodec;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.ChestType;
import net.minecraft.state.property.Property;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;

public class CopperChestBlock
extends ChestBlock {
    private static final Map<Block, Supplier<Block>> COPPER_TO_COPPER_CHEST_MAPPING = Map.of(Blocks.COPPER_BLOCK, () -> (Block)ModBlocks.COPPER_CHEST.get(), Blocks.EXPOSED_COPPER, () -> (Block)ModBlocks.EXPOSED_COPPER_CHEST.get(), Blocks.WEATHERED_COPPER, () -> (Block)ModBlocks.WEATHERED_COPPER_CHEST.get(), Blocks.OXIDIZED_COPPER, () -> (Block)ModBlocks.OXIDIZED_COPPER_CHEST.get(), Blocks.WAXED_COPPER_BLOCK, () -> (Block)ModBlocks.COPPER_CHEST.get(), Blocks.WAXED_EXPOSED_COPPER, () -> (Block)ModBlocks.EXPOSED_COPPER_CHEST.get(), Blocks.WAXED_WEATHERED_COPPER, () -> (Block)ModBlocks.WEATHERED_COPPER_CHEST.get(), Blocks.WAXED_OXIDIZED_COPPER, () -> (Block)ModBlocks.OXIDIZED_COPPER_CHEST.get());
    protected final Oxidizable.OxidationLevel weatherState;
    private final SoundEvent openSound;
    private final SoundEvent closeSound;

    public CopperChestBlock(Oxidizable.OxidationLevel weatherState, AbstractBlock.Settings properties) {
        super(properties, () -> ModBlockEntities.COPPER_CHEST_BLOCK_ENTITY.get());
        this.weatherState = weatherState;
        this.openSound = ModSounds.COPPER_CHEST_OPEN.get();
        this.closeSound = ModSounds.COPPER_CHEST_CLOSE.get();
    }

    public MapCodec<? extends ChestBlock> getCodec() {
        return null;
    }

    public Oxidizable.OxidationLevel getState() {
        return this.weatherState;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)14.0, (double)15.0);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)14.0, (double)15.0);
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CopperChestBlockEntity(pos, state);
    }

    public BlockRenderType getRenderType(BlockState state) {
        if (Services.PLATFORM.isFastChestSimplifiedEnabled()) {
            return BlockRenderType.MODEL;
        }
        return super.getRenderType(state);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState state, BlockEntityType<T> type) {
        if (Services.PLATFORM.isFastChestSimplifiedEnabled()) {
            return null;
        }
        return super.getTicker(level, state, type);
    }

    public static BlockState getFromCopperBlock(Block block, Direction direction, World level, BlockPos pos) {
        Block chestBlock = COPPER_TO_COPPER_CHEST_MAPPING.getOrDefault(block, () -> (Block)ModBlocks.COPPER_CHEST.get()).get();
        return chestBlock.getDefaultState().with(FACING, direction);
    }

    public static Optional<Block> getUnwaxedBlock(Block block) {
        if (block == ModBlocks.WAXED_COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.COPPER_CHEST.get());
        }
        if (block == ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get()) {
            return Optional.of((Block)ModBlocks.OXIDIZED_COPPER_CHEST.get());
        }
        return Optional.empty();
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (stack.isIn(ItemTags.AXES)) {
            CopperChestBlockEntity chestEntity;
            BlockEntity class_25862 = level.getBlockEntity(pos);
            if (class_25862 instanceof CopperChestBlockEntity && (chestEntity = (CopperChestBlockEntity)class_25862).isChestOpen()) {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
            Optional<Block> unwaxedBlock = CopperChestBlock.getUnwaxedBlock(state.getBlock());
            if (unwaxedBlock.isPresent()) {
                ChestType chestType = (ChestType)state.get(CHEST_TYPE);
                Block newBlock = unwaxedBlock.get();
                if (chestType != ChestType.SINGLE) {
                    Direction connectedDir = ChestBlock.getFacing(state);
                    BlockPos connectedPos = pos.offset(connectedDir);
                    BlockState connectedState = level.getBlockState(connectedPos);
                    if (connectedState.getBlock() == state.getBlock()) {
                        level.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        level.syncWorldEvent(player, 3004, pos, 0);
                        level.playSound(player, connectedPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        level.syncWorldEvent(player, 3004, connectedPos, 0);
                    } else {
                        level.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        level.syncWorldEvent(player, 3004, pos, 0);
                    }
                } else {
                    level.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    level.syncWorldEvent(player, 3004, pos, 0);
                }
                if (!level.isClient) {
                    DefaultedList<ItemStack> currentItems = CopperChestBlock.copyInventoryAndClear(level, pos);
                    DefaultedList<ItemStack> connectedItems = DefaultedList.of();
                    BlockState newState = newBlock.getStateWithProperties(state);
                    if (chestType != ChestType.SINGLE) {
                        Direction connectedDir = ChestBlock.getFacing(state);
                        BlockPos connectedPos = pos.offset(connectedDir);
                        BlockState connectedState = level.getBlockState(connectedPos);
                        if (connectedState.getBlock() == state.getBlock()) {
                            BlockState connectedNewState = newBlock.getStateWithProperties(connectedState);
                            connectedItems = CopperChestBlock.copyInventoryAndClear(level, connectedPos);
                            level.setBlockState(pos, newState, 2);
                            level.setBlockState(connectedPos, connectedNewState, 2);
                            level.updateNeighbors(pos, newBlock);
                            level.updateNeighbors(connectedPos, newBlock);
                            CopperChestBlock.restoreInventory(level, pos, currentItems);
                            CopperChestBlock.restoreInventory(level, connectedPos, connectedItems);
                        } else {
                            level.setBlockState(pos, newState);
                            CopperChestBlock.restoreInventory(level, pos, currentItems);
                        }
                    } else {
                        level.setBlockState(pos, newState);
                        CopperChestBlock.restoreInventory(level, pos, currentItems);
                    }
                    stack.damage(1, (LivingEntity)player, LivingEntity.getSlotForHand((Hand)hand));
                }
                return ItemActionResult.SUCCESS;
            }
            return ItemActionResult.SUCCESS;
        }
        return super.onUseWithItem(stack, state, level, pos, player, hand, hitResult);
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

