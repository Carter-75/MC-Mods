/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 */
package backported.updates.copper.compat;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

public interface IChestHandler {
    public boolean canHandle(BlockState var1);

    public void setOpen(World var1, BlockPos var2, BlockState var3, boolean var4);

    default public boolean isOpen(World level, BlockPos pos, BlockState state) {
        return false;
    }
}

