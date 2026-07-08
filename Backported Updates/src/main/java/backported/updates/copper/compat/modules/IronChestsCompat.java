/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.compat.modules;

import backported.updates.copper.compat.IContainerCompat;
import backported.updates.copper.compat.IModCompatModule;
import net.minecraft.inventory.Inventory;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import org.jetbrains.annotations.Nullable;

public class IronChestsCompat
implements IModCompatModule,
IContainerCompat {
    public static final String MOD_ID = "ironchest";
    private Class<?> abstractIronChestBlockClass;
    private Class<?> abstractTrappedIronChestBlockClass;
    private Class<?> abstractIronChestBlockEntityClass;

    @Override
    public String getModId() {
        return MOD_ID;
    }

    @Override
    public void init() {
        try {
            this.abstractIronChestBlockClass = Class.forName("com.progwml6.ironchest.common.block.regular.AbstractIronChestBlock");
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        try {
            this.abstractTrappedIronChestBlockClass = Class.forName("com.progwml6.ironchest.common.block.trapped.AbstractTrappedIronChestBlock");
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        try {
            this.abstractIronChestBlockEntityClass = Class.forName("com.progwml6.ironchest.common.block.regular.entity.AbstractIronChestBlockEntity");
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
    }

    @Override
    public boolean isValidContainer(BlockState state) {
        Block block = state.getBlock();
        if (this.abstractIronChestBlockClass != null && this.abstractIronChestBlockClass.isInstance(block)) {
            return true;
        }
        return this.abstractTrappedIronChestBlockClass != null && this.abstractTrappedIronChestBlockClass.isInstance(block);
    }

    @Override
    public boolean canHandle(BlockState state) {
        return this.isValidContainer(state);
    }

    @Override
    public void setOpen(World level, BlockPos pos, BlockState state, boolean open) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity == null) {
            return;
        }
        if (this.abstractIronChestBlockEntityClass != null && this.abstractIronChestBlockEntityClass.isInstance(blockEntity)) {
            level.addSyncedBlockEvent(pos, state.getBlock(), 1, open ? 1 : 0);
            if (open) {
                level.playSound(null, pos, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
            } else {
                level.playSound(null, pos, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
            }
        }
    }

    @Override
    @Nullable
    public Inventory getContainer(BlockEntity blockEntity, World level, BlockPos pos) {
        if (this.abstractIronChestBlockEntityClass != null && this.abstractIronChestBlockEntityClass.isInstance(blockEntity) && blockEntity instanceof Inventory) {
            Inventory container = (Inventory)blockEntity;
            return container;
        }
        return null;
    }
}

