/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.AbstractPlantBlock
 *  net.minecraft.block.AbstractPlantStemBlock
 *  net.minecraft.block.WeepingVinesPlantBlock
 *  net.minecraft.block.AbstractBlock$Settings
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.WeepingVinesPlantBlock;
import net.minecraft.block.AbstractBlock;

public class PaleHangingMossPlantBlock
extends AbstractPlantBlock {
    public static final MapCodec<WeepingVinesPlantBlock> CODEC = PaleHangingMossPlantBlock.createCodec(WeepingVinesPlantBlock::new);
    public static final VoxelShape SHAPE = Block.createCuboidShape((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)16.0, (double)15.0);

    public PaleHangingMossPlantBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false);
    }

    public MapCodec<WeepingVinesPlantBlock> getCodec() {
        return CODEC;
    }

    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock)Init.PALE_HANGING_MOSS;
    }
}

