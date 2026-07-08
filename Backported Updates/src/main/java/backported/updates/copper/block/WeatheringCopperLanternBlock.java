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
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
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

import backported.updates.copper.block.CopperLanternBlock;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.util.WeatheringHelper;
import java.util.Optional;
import net.minecraft.util.Hand;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;

public class WeatheringCopperLanternBlock
extends CopperLanternBlock
implements Oxidizable {
    public WeatheringCopperLanternBlock(Oxidizable.OxidationLevel weatheringState, AbstractBlock.Settings properties) {
        super(weatheringState, properties);
    }

    public static Optional<Block> getNextBlock(Block block) {
        if (block == ModBlocks.COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.OXIDIZED_COPPER_LANTERN.get());
        }
        return Optional.empty();
    }

    public static Optional<Block> getPreviousBlock(Block block) {
        if (block == ModBlocks.EXPOSED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.OXIDIZED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_LANTERN.get());
        }
        return Optional.empty();
    }

    public static Optional<Block> getWaxedBlock(Block block) {
        if (block == ModBlocks.COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.WAXED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.OXIDIZED_COPPER_LANTERN.get()) {
            return Optional.of((Block)ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get());
        }
        return Optional.empty();
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Optional<Block> previousBlock;
        Optional<Block> waxedBlock;
        if (stack.isOf(Items.HONEYCOMB) && (waxedBlock = WeatheringCopperLanternBlock.getWaxedBlock(state.getBlock())).isPresent()) {
            level.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3003, pos, 0);
            if (!level.isClient) {
                BlockState newState = waxedBlock.get().getStateWithProperties(state);
                level.setBlockState(pos, newState);
                if (!player.isCreative()) {
                    stack.decrement(1);
                }
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        if (stack.isIn(ItemTags.AXES) && (previousBlock = WeatheringCopperLanternBlock.getPreviousBlock(state.getBlock())).isPresent()) {
            level.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3005, pos, 0);
            if (!level.isClient) {
                BlockState newState = previousBlock.get().getStateWithProperties(state);
                level.setBlockState(pos, newState);
                stack.damage(1, (LivingEntity)player, hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        WeatheringHelper.tryWeather(state, level, pos, random, WeatheringCopperLanternBlock::getNextBlock);
    }

    protected boolean hasRandomTicks(BlockState state) {
        return WeatheringHelper.canWeather(state, WeatheringCopperLanternBlock::getNextBlock);
    }

    public Oxidizable.OxidationLevel getAge() {
        return this.getWeatheringState();
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.getWeatheringState();
    }
}

