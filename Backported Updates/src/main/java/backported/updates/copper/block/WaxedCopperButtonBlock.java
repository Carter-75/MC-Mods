/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.util.ActionResult
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraft.block.ButtonBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.enums.BlockFace
 *  net.minecraft.Property
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.block.BlockSetType
 *  net.minecraft.util.ItemActionResult
 */
package backported.updates.copper.block;

import backported.updates.copper.block.CopperButtonBlock;
import java.util.function.Supplier;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.ButtonBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.state.property.Property;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.BlockSetType;
import net.minecraft.util.ItemActionResult;

public class WaxedCopperButtonBlock
extends ButtonBlock {
    private final Oxidizable.OxidationLevel weatherState;
    private final Supplier<CopperButtonBlock> unwaxedButton;

    public WaxedCopperButtonBlock(Oxidizable.OxidationLevel weatherState, Supplier<CopperButtonBlock> unwaxedButton, AbstractBlock.Settings properties) {
        super(BlockSetType.COPPER, 15, properties);
        this.weatherState = weatherState;
        this.unwaxedButton = unwaxedButton;
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (stack.isIn(ItemTags.AXES)) {
            level.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3004, pos, 0);
            if (!level.isClient) {
                BlockState unwaxedState = ((this.unwaxedButton.get().getDefaultState().with(FACING, ((Direction)state.get(FACING)))).with(POWERED, ((Boolean)state.get(POWERED)))).with(FACE, ((BlockFace)state.get(FACE)));
                level.setBlockState(pos, unwaxedState, 11);
                if (!player.isCreative()) {
                    stack.damage(1, (LivingEntity)player, EquipmentSlot.MAINHAND);
                }
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, BlockHitResult hitResult) {
        return super.onUse(state, level, pos, player, hitResult);
    }

    protected boolean hasRandomTicks(BlockState state) {
        return false;
    }
}

