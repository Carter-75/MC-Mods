/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.ChainBlock
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.block.Oxidizable
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.util.ItemActionResult
 */
package backported.updates.copper.block;

import backported.updates.copper.registry.ModBlocks;
import java.util.Optional;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ChainBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;

public class WeatheringCopperChainBlock
extends ChainBlock
implements Oxidizable {
    private final Oxidizable.OxidationLevel weatherState;

    public WeatheringCopperChainBlock(Oxidizable.OxidationLevel weatherState, AbstractBlock.Settings properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    public Oxidizable.OxidationLevel getAge() {
        return this.weatherState;
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.weatherState;
    }

    public Optional<Block> getNextBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Optional.of((Block)ModBlocks.EXPOSED_COPPER_CHAIN.get());
            case Oxidizable.OxidationLevel.EXPOSED -> Optional.of((Block)ModBlocks.WEATHERED_COPPER_CHAIN.get());
            case Oxidizable.OxidationLevel.WEATHERED -> Optional.of((Block)ModBlocks.OXIDIZED_COPPER_CHAIN.get());
            case Oxidizable.OxidationLevel.OXIDIZED -> Optional.empty();
        };
    }

    public Optional<Block> getPreviousBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Optional.empty();
            case Oxidizable.OxidationLevel.EXPOSED -> Optional.of((Block)ModBlocks.COPPER_CHAIN.get());
            case Oxidizable.OxidationLevel.WEATHERED -> Optional.of((Block)ModBlocks.EXPOSED_COPPER_CHAIN.get());
            case Oxidizable.OxidationLevel.OXIDIZED -> Optional.of((Block)ModBlocks.WEATHERED_COPPER_CHAIN.get());
        };
    }

    public Optional<Block> getWaxedBlock() {
        return switch (this.weatherState) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Optional.of((Block)ModBlocks.WAXED_COPPER_CHAIN.get());
            case Oxidizable.OxidationLevel.EXPOSED -> Optional.of((Block)ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get());
            case Oxidizable.OxidationLevel.WEATHERED -> Optional.of((Block)ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get());
            case Oxidizable.OxidationLevel.OXIDIZED -> Optional.of((Block)ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get());
        };
    }

    protected void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        this.tickDegradation(state, level, pos, random);
    }

    public Optional<BlockState> getDegradationResult(BlockState state) {
        return this.getNextBlock().map(block -> (block.getDefaultState().with(AXIS, ((Direction.Axis)state.get(AXIS)))).with(WATERLOGGED, ((Boolean)state.get(WATERLOGGED))));
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        Optional<Block> previous;
        Optional<Block> waxed;
        if (stack.isOf(Items.HONEYCOMB) && (waxed = this.getWaxedBlock()).isPresent()) {
            BlockState newState = (waxed.get().getDefaultState().with(AXIS, ((Direction.Axis)state.get(AXIS)))).with(WATERLOGGED, ((Boolean)state.get(WATERLOGGED)));
            level.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3003, pos, 0);
            if (!level.isClient) {
                level.setBlockState(pos, newState, 11);
                if (!player.isCreative()) {
                    stack.decrement(1);
                }
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        if (stack.isIn(ItemTags.AXES) && (previous = this.getPreviousBlock()).isPresent()) {
            BlockState newState = (previous.get().getDefaultState().with(AXIS, ((Direction.Axis)state.get(AXIS)))).with(WATERLOGGED, ((Boolean)state.get(WATERLOGGED)));
            level.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3005, pos, 0);
            if (!level.isClient) {
                level.setBlockState(pos, newState, 11);
                if (!player.isCreative()) {
                    stack.damage(1, (LivingEntity)player, player.getPreferredEquipmentSlot(stack));
                }
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        return super.onUseWithItem(stack, state, level, pos, player, hand, hitResult);
    }
}

