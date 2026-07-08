/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.RodBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.Degradable
 *  net.minecraft.block.LightningRodBlock
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.block.Oxidizable
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.util.ItemActionResult
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package backported_updates.mixin.copper;

import backported.updates.copper.registry.ModBlocks;
import java.util.Optional;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.RodBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Degradable;
import net.minecraft.block.LightningRodBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Oxidizable;
import net.minecraft.util.ItemActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={LightningRodBlock.class})
public abstract class LightningRodBlockMixin
extends RodBlock
implements Oxidizable,
Degradable<Oxidizable.OxidationLevel> {
    public LightningRodBlockMixin(AbstractBlock.Settings properties) {
        super(properties);
    }

    public Oxidizable.OxidationLevel getAge() {
        return Oxidizable.OxidationLevel.UNAFFECTED;
    }

    @Unique
    private Optional<Block> copperagebackport$getNextBlock() {
        return Optional.of((Block)ModBlocks.EXPOSED_LIGHTNING_ROD.get());
    }

    @Unique
    private Optional<Block> copperagebackport$getWaxedBlock() {
        return Optional.of((Block)ModBlocks.WAXED_LIGHTNING_ROD.get());
    }

    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    protected void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        float f = 0.05688889f;
        if (random.nextFloat() < f) {
            this.copperagebackport$tryOxidize(state, level, pos, random);
        }
    }

    @Unique
    private void copperagebackport$tryOxidize(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        Optional<Block> nextBlock = this.copperagebackport$getNextBlock();
        if (nextBlock.isPresent()) {
            float chance = 1.0f * this.getDegradationChanceMultiplier();
            if (random.nextFloat() < chance) {
                level.setBlockState(pos, nextBlock.get().getStateWithProperties(state));
            }
        }
    }

    public Optional<BlockState> getDegradationResult(BlockState state) {
        return this.copperagebackport$getNextBlock().map(block -> block.getStateWithProperties(state));
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        Optional<Block> waxedBlock;
        if (stack.isOf(Items.HONEYCOMB) && (waxedBlock = this.copperagebackport$getWaxedBlock()).isPresent()) {
            level.playSound(player, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0f, 1.0f);
            level.syncWorldEvent(player, 3003, pos, 0);
            if (!level.isClient) {
                level.setBlockState(pos, waxedBlock.get().getStateWithProperties(state), 11);
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
            }
            return ItemActionResult.success((boolean)level.isClient);
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public float getDegradationChanceMultiplier() {
        return 1.0f;
    }
}

