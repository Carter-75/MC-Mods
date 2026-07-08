/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.CactusBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.property.IntProperty
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.blocks;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.VanillaBackport;
import net.minecraft.block.Block;
import net.minecraft.block.CactusBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={CactusBlock.class})
public abstract class CactusBlockMixin
extends Block {
    @Shadow
    @Final
    public static IntProperty AGE;

    @Shadow
    protected abstract boolean canPlaceAt(BlockState var1, WorldView var2, BlockPos var3);

    public CactusBlockMixin(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Inject(method={"randomTick"}, at={@At(value="HEAD")})
    private void vb$growCactusFlower(BlockState state, ServerWorld level, BlockPos pos, Random random, CallbackInfo ci) {
        BlockPos above = pos.up();
        if (VanillaBackport.COMMON_CONFIG.hasCactusFlowers.get().booleanValue() && level.isAir(above)) {
            int height = 1;
            int age = (Integer)state.get(AGE);
            while (level.getBlockState(pos.down(height)).isOf((Block)CactusBlock.class.cast(this))) {
                if (height++ != 3 || age != 15) continue;
                return;
            }
            if (age == 8 && this.canPlaceAt(this.getDefaultState(), (WorldView)level, above)) {
                double flowerChance;
                double d = flowerChance = height >= 3 ? 0.25 : 0.1;
                if (random.nextDouble() <= flowerChance) {
                    level.setBlockState(above, ModBlocks.CACTUS_FLOWER.get().getDefaultState());
                }
            }
        }
    }
}

