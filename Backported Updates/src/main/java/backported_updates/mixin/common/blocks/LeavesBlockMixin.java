/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.LeavesBlock
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.math.random.Random
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.blocks;

import backported.updates.content.common.api.FallingLeavesModule;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LeavesBlock.class})
@Environment(value=EnvType.CLIENT)
public class LeavesBlockMixin {
    @Unique
    private final FallingLeavesModule module = new FallingLeavesModule();

    @Inject(method={"randomDisplayTick"}, at={@At(value="HEAD")})
    public void vb$animateTick(BlockState state, World level, BlockPos pos, Random random, CallbackInfo ci) {
        this.module.makeFallingLeavesParticles(level, pos, random, level.getBlockState(pos.down()), pos.down());
    }
}

