/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.block.entity.BlockEntityType$Builder
 */
package backported.updates.copper.fabric.platform;

import backported.updates.copper.platform.services.IBlockEntityHelper;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

public class FabricBlockEntityHelper
implements IBlockEntityHelper {
    @Override
    public <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(IBlockEntityHelper.BlockEntityFactory<T> factory, Block ... blocks) {
        return BlockEntityType.Builder.create(factory::create, (Block[])blocks).build(null);
    }
}

