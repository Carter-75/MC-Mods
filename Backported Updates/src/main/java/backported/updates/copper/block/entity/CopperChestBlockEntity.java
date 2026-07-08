/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.DoubleInventory
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.screen.GenericContainerScreenHandler
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.ChestBlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.block.entity.ViewerCountManager
 */
package backported.updates.copper.block.entity;

import backported.updates.copper.ModSounds;
import backported.updates.copper.registry.ModBlockEntities;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.block.entity.ViewerCountManager;

public class CopperChestBlockEntity
extends ChestBlockEntity {
    private final ViewerCountManager openersCounter = new ViewerCountManager(){

        protected void onContainerOpen(World level, BlockPos blockPos, BlockState blockState) {
        }

        protected void onContainerClose(World level, BlockPos blockPos, BlockState blockState) {
        }

        protected void onViewerCountUpdate(World level, BlockPos pos, BlockState state, int oldCount, int newCount) {
            if (oldCount == 0 && newCount > 0) {
                level.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, ModSounds.COPPER_CHEST_OPEN.get(), SoundCategory.BLOCKS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
            } else if (newCount == 0 && oldCount > 0) {
                level.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, ModSounds.COPPER_CHEST_CLOSE.get(), SoundCategory.BLOCKS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
            }
            level.addSyncedBlockEvent(pos, state.getBlock(), 1, newCount);
        }

        protected boolean isPlayerViewing(PlayerEntity player) {
            if (!(player.currentScreenHandler instanceof GenericContainerScreenHandler)) {
                return false;
            }
            Inventory container = ((GenericContainerScreenHandler)player.currentScreenHandler).getInventory();
            return container == CopperChestBlockEntity.this || container instanceof DoubleInventory && ((DoubleInventory)container).isPart((Inventory)CopperChestBlockEntity.this);
        }
    };

    public CopperChestBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COPPER_CHEST_BLOCK_ENTITY.get(), pos, state);
    }

    public void onOpen(PlayerEntity player) {
        if (!this.removed && !player.isSpectator() && this.getWorld() != null) {
            this.openersCounter.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    public void onClose(PlayerEntity player) {
        if (!this.removed && !player.isSpectator() && this.getWorld() != null) {
            this.openersCounter.closeContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    public void onScheduledTick() {
        if (!this.removed && this.getWorld() != null) {
            this.openersCounter.updateViewerCount(this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    public boolean isChestOpen() {
        return this.openersCounter.getViewerCount() > 0;
    }
}

