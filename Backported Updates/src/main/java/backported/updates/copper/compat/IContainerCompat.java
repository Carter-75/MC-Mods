/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.compat;

import backported.updates.copper.compat.IChestHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import org.jetbrains.annotations.Nullable;

public interface IContainerCompat
extends IChestHandler {
    public boolean isValidContainer(BlockState var1);

    @Nullable
    default public Inventory getContainer(BlockEntity blockEntity, World level, BlockPos pos) {
        if (blockEntity instanceof Inventory) {
            Inventory container = (Inventory)blockEntity;
            return container;
        }
        return null;
    }
}

