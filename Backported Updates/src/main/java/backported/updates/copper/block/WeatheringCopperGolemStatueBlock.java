/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.block.Oxidizable
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.util.ItemActionResult
 */
package backported.updates.copper.block;

import backported.updates.copper.ModSounds;
import backported.updates.copper.block.CopperGolemStatueBlock;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.util.WeatheringHelper;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.world.event.GameEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Oxidizable;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.ItemActionResult;

public class WeatheringCopperGolemStatueBlock
extends CopperGolemStatueBlock
implements Oxidizable {
    public static final MapCodec<WeatheringCopperGolemStatueBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Oxidizable.OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(CopperGolemStatueBlock::getWeatheringState), WeatheringCopperGolemStatueBlock.createSettingsCodec()).apply(instance, WeatheringCopperGolemStatueBlock::new));

    public WeatheringCopperGolemStatueBlock(Oxidizable.OxidationLevel weatheringState, AbstractBlock.Settings properties) {
        super(weatheringState, properties);
    }

    protected MapCodec<? extends WeatheringCopperGolemStatueBlock> getCodec() {
        return CODEC;
    }

    public static Optional<Block> getNextBlock(Block block) {
        if (block == ModBlocks.COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get());
        }
        return Oxidizable.getIncreasedOxidationBlock((Block)block);
    }

    public static Optional<Block> getPreviousBlock(Block block) {
        if (block == ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.COPPER_GOLEM_STATUE.get());
        }
        return Optional.empty();
    }

    public static Optional<Block> getWaxedBlock(Block block) {
        if (block == ModBlocks.COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.WAXED_COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.WAXED_EXPOSED_COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.WAXED_WEATHERED_COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((Block)ModBlocks.WAXED_OXIDIZED_COPPER_GOLEM_STATUE.get());
        }
        return Optional.empty();
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        Optional<Block> waxedBlock;
        if (stack.isEmpty()) {
            if (!level.isClient()) {
                CopperGolemStatueBlock.Pose currentPose = (CopperGolemStatueBlock.Pose)(state.get(POSE));
                CopperGolemStatueBlock.Pose nextPose = currentPose.getNextPose();
                level.setBlockState(pos, state.with(POSE, (nextPose)), 3);
                level.playSound(null, pos, ModSounds.COPPER_STATUE_HIT.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
                level.emitGameEvent((Entity)player, (RegistryEntry)GameEvent.BLOCK_CHANGE, pos);
            }
            return ItemActionResult.SUCCESS;
        }
        if (stack.isOf(Items.HONEYCOMB) && (waxedBlock = WeatheringCopperGolemStatueBlock.getWaxedBlock(state.getBlock())).isPresent()) {
            level.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3003, pos, 0);
            if (!level.isClient) {
                BlockState waxedState = ((waxedBlock.get().getDefaultState().with(FACING, ((Direction)state.get(FACING)))).with(POSE, (((CopperGolemStatueBlock.Pose)(state.get(POSE)))))).with(WATERLOGGED, ((Boolean)state.get(WATERLOGGED)));
                level.setBlockState(pos, waxedState, 3);
                if (!player.isCreative()) {
                    stack.decrement(1);
                }
            }
            return ItemActionResult.SUCCESS;
        }
        if (stack.isIn(ItemTags.AXES)) {
            Optional<Block> previousBlock = WeatheringCopperGolemStatueBlock.getPreviousBlock(state.getBlock());
            if (previousBlock.isPresent()) {
                level.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                level.syncWorldEvent(player, 3005, pos, 0);
                if (!level.isClient) {
                    BlockState newState = ((previousBlock.get().getDefaultState().with(FACING, ((Direction)state.get(FACING)))).with(POSE, (((CopperGolemStatueBlock.Pose)(state.get(POSE)))))).with(WATERLOGGED, ((Boolean)state.get(WATERLOGGED)));
                    level.setBlockState(pos, newState, 3);
                    if (!player.isCreative()) {
                        stack.damage(1, (LivingEntity)player, player.getPreferredEquipmentSlot(stack));
                    }
                }
                return ItemActionResult.SUCCESS;
            }
            if (!level.isClient()) {
                CopperGolemStatueBlockEntity statueEntity;
                CopperGolemEntity golem;
                ServerWorld serverLevel = (ServerWorld)level;
                BlockEntity class_25862 = level.getBlockEntity(pos);
                if (class_25862 instanceof CopperGolemStatueBlockEntity && (golem = (statueEntity = (CopperGolemStatueBlockEntity)class_25862).removeStatue(state, serverLevel)) != null) {
                    level.removeBlock(pos, false);
                    serverLevel.spawnEntity((Entity)golem);
                    level.playSound(null, pos, ModSounds.COPPER_STATUE_BREAK.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
                    level.syncWorldEvent(null, 3005, pos, 0);
                    level.emitGameEvent((Entity)player, (RegistryEntry)GameEvent.BLOCK_DESTROY, pos);
                    stack.damage(1, (LivingEntity)player, player.getPreferredEquipmentSlot(stack));
                    return ItemActionResult.SUCCESS;
                }
            }
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        WeatheringHelper.tryWeather(state, level, pos, random, WeatheringCopperGolemStatueBlock::getNextBlock);
    }

    protected boolean hasRandomTicks(BlockState state) {
        return WeatheringHelper.canWeather(state, WeatheringCopperGolemStatueBlock::getNextBlock);
    }

    public Oxidizable.OxidationLevel getAge() {
        return this.getWeatheringState();
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.getWeatheringState();
    }
}

