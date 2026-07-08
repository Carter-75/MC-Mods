/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.PaneBlock
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
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
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;

public class CopperBarsBlock
extends PaneBlock {
    private final Oxidizable.OxidationLevel weatheringState;

    public CopperBarsBlock(Oxidizable.OxidationLevel weatheringState, AbstractBlock.Settings properties) {
        super(properties);
        this.weatheringState = weatheringState;
    }

    public Oxidizable.OxidationLevel getWeatheringState() {
        return this.weatheringState;
    }

    public Optional<Block> getUnwaxedBlock() {
        return switch (this.weatheringState) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Optional.of((Block)ModBlocks.COPPER_BARS.get());
            case Oxidizable.OxidationLevel.EXPOSED -> Optional.of((Block)ModBlocks.EXPOSED_COPPER_BARS.get());
            case Oxidizable.OxidationLevel.WEATHERED -> Optional.of((Block)ModBlocks.WEATHERED_COPPER_BARS.get());
            case Oxidizable.OxidationLevel.OXIDIZED -> Optional.of((Block)ModBlocks.OXIDIZED_COPPER_BARS.get());
        };
    }

    private BlockState copyBarsState(BlockState from, BlockState to) {
        return ((((to.with(NORTH, ((Boolean)from.get(NORTH)))).with(SOUTH, ((Boolean)from.get(SOUTH)))).with(EAST, ((Boolean)from.get(EAST)))).with(WEST, ((Boolean)from.get(WEST)))).with(WATERLOGGED, ((Boolean)from.get(WATERLOGGED)));
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        Optional<Block> unwaxed;
        if (stack.isIn(ItemTags.AXES) && (unwaxed = this.getUnwaxedBlock()).isPresent()) {
            BlockState newState = this.copyBarsState(state, unwaxed.get().getDefaultState());
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

