/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.ChainBlock
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
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ChainBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;

public class CopperChainBlock
extends ChainBlock {
    private final Oxidizable.OxidationLevel weatheringState;

    public CopperChainBlock(Oxidizable.OxidationLevel weatheringState, AbstractBlock.Settings properties) {
        super(properties);
        this.weatheringState = weatheringState;
    }

    public Oxidizable.OxidationLevel getWeatheringState() {
        return this.weatheringState;
    }

    public Optional<BlockState> getUnwaxedBlock() {
        return switch (this.weatheringState) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Optional.of((ModBlocks.COPPER_CHAIN.get().getDefaultState().with(AXIS, ((Direction.Axis)this.getDefaultState().get(AXIS)))).with(WATERLOGGED, ((Boolean)this.getDefaultState().get(WATERLOGGED))));
            case Oxidizable.OxidationLevel.EXPOSED -> Optional.of((ModBlocks.EXPOSED_COPPER_CHAIN.get().getDefaultState().with(AXIS, ((Direction.Axis)this.getDefaultState().get(AXIS)))).with(WATERLOGGED, ((Boolean)this.getDefaultState().get(WATERLOGGED))));
            case Oxidizable.OxidationLevel.WEATHERED -> Optional.of((ModBlocks.WEATHERED_COPPER_CHAIN.get().getDefaultState().with(AXIS, ((Direction.Axis)this.getDefaultState().get(AXIS)))).with(WATERLOGGED, ((Boolean)this.getDefaultState().get(WATERLOGGED))));
            case Oxidizable.OxidationLevel.OXIDIZED -> Optional.of((ModBlocks.OXIDIZED_COPPER_CHAIN.get().getDefaultState().with(AXIS, ((Direction.Axis)this.getDefaultState().get(AXIS)))).with(WATERLOGGED, ((Boolean)this.getDefaultState().get(WATERLOGGED))));
        };
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        Optional<BlockState> unwaxed;
        if (stack.isIn(ItemTags.AXES) && (unwaxed = this.getUnwaxedBlock()).isPresent()) {
            BlockState newState = (unwaxed.get().with(AXIS, ((Direction.Axis)state.get(AXIS)))).with(WATERLOGGED, ((Boolean)state.get(WATERLOGGED)));
            level.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3004, pos, 0);
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

