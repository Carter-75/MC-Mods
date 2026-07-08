/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.block.DeadBushBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.math.random.Random
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.blocks;

import backported.updates.content.client.level.sound.AmbientDesertBlockSoundsPlayer;
import backported_updates.mixin.common.blocks.BlockMixin;
import net.minecraft.world.World;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={DeadBushBlock.class})
public class DeadBushBlockMixin
extends BlockMixin {
    @Override
    public void vb$onAnimateTick(BlockState state, World level, BlockPos pos, Random random, CallbackInfo ci) {
        AmbientDesertBlockSoundsPlayer.playAmbientDeadBushSounds(level, pos, random);
    }
}

