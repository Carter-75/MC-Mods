/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.block.ColoredFallingBlock
 *  org.spongepowered.asm.mixin.Mixin
 */
package backported_updates.mixin.common.blocks;

import backported.updates.content.client.level.sound.AmbientDesertBlockSoundsPlayer;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.ColoredFallingBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={ColoredFallingBlock.class})
public class ColoringFallingBlockMixin
extends Block {
    public ColoringFallingBlockMixin(AbstractBlock.Settings properties) {
        super(properties);
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        AmbientDesertBlockSoundsPlayer.playAmbientSandSounds(level, pos, random);
        super.randomDisplayTick(state, level, pos, random);
    }
}

