/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.ButtonBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.enums.BlockFace
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
 *  net.minecraft.block.BlockSetType
 *  net.minecraft.util.ItemActionResult
 */
package backported.updates.copper.block;

import backported.updates.copper.block.WaxedCopperButtonBlock;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.util.WeatheringHelper;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.util.Hand;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.ButtonBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.BlockSetType;
import net.minecraft.util.ItemActionResult;

public class CopperButtonBlock
extends ButtonBlock
implements Oxidizable {
    private final Oxidizable.OxidationLevel weatherState;
    private Supplier<WaxedCopperButtonBlock> waxedButton;

    public CopperButtonBlock(Oxidizable.OxidationLevel weatherState, AbstractBlock.Settings properties) {
        super(BlockSetType.COPPER, 15, properties);
        this.weatherState = weatherState;
    }

    public void setWaxedButton(Supplier<WaxedCopperButtonBlock> waxedButton) {
        this.waxedButton = waxedButton;
    }

    public Oxidizable.OxidationLevel getAge() {
        return this.weatherState;
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.weatherState;
    }

    public static Optional<Block> getNextBlock(Block block) {
        if (block == ModBlocks.COPPER_BUTTON.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_BUTTON.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_BUTTON.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_BUTTON.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_BUTTON.get()) {
            return Optional.of((Block)ModBlocks.OXIDIZED_COPPER_BUTTON.get());
        }
        return Oxidizable.getIncreasedOxidationBlock((Block)block);
    }

    public static Optional<Block> getPreviousBlock(Block block) {
        if (block == ModBlocks.OXIDIZED_COPPER_BUTTON.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_BUTTON.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_BUTTON.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_BUTTON.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_BUTTON.get()) {
            return Optional.of((Block)ModBlocks.COPPER_BUTTON.get());
        }
        return Optional.empty();
    }

    private Optional<Block> getWaxedBlock(Block block) {
        if (this.waxedButton == null) {
            return Optional.empty();
        }
        return Optional.of((Block)this.waxedButton.get());
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (stack.isOf(Items.HONEYCOMB) && this.waxedButton != null) {
            level.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3003, pos, 0);
            if (!level.isClient) {
                BlockState waxedState = ((this.waxedButton.get().getDefaultState().with(FACING, ((Direction)state.get(FACING)))).with(POWERED, ((Boolean)state.get(POWERED)))).with(FACE, ((BlockFace)state.get(FACE)));
                level.setBlockState(pos, waxedState, 11);
                if (!player.isCreative()) {
                    stack.decrement(1);
                }
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        if (stack.isIn(ItemTags.AXES)) {
            Block previousBlock = null;
            if (this == ModBlocks.OXIDIZED_COPPER_BUTTON.get()) {
                previousBlock = (Block)ModBlocks.WEATHERED_COPPER_BUTTON.get();
            } else if (this == ModBlocks.WEATHERED_COPPER_BUTTON.get()) {
                previousBlock = (Block)ModBlocks.EXPOSED_COPPER_BUTTON.get();
            } else if (this == ModBlocks.EXPOSED_COPPER_BUTTON.get()) {
                previousBlock = (Block)ModBlocks.COPPER_BUTTON.get();
            }
            if (previousBlock != null) {
                level.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                level.syncWorldEvent(player, 3005, pos, 0);
                if (!level.isClient) {
                    BlockState newState = ((previousBlock.getDefaultState().with(FACING, ((Direction)state.get(FACING)))).with(POWERED, ((Boolean)state.get(POWERED)))).with(FACE, ((BlockFace)state.get(FACE)));
                    level.setBlockState(pos, newState, 11);
                    if (!player.isCreative()) {
                        stack.damage(1, (LivingEntity)player, EquipmentSlot.MAINHAND);
                    }
                }
                return ItemActionResult.success((boolean)level.isClient);
            }
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (((Boolean)state.get(POWERED)).booleanValue()) {
            return;
        }
        WeatheringHelper.tryWeather(state, level, pos, random, CopperButtonBlock::getNextBlock);
    }

    protected boolean hasRandomTicks(BlockState state) {
        if (((Boolean)state.get(POWERED)).booleanValue()) {
            return false;
        }
        return WeatheringHelper.canWeather(state, CopperButtonBlock::getNextBlock);
    }
}

