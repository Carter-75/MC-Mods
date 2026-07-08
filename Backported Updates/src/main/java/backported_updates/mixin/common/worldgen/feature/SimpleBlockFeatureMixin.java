/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.gen.feature.SimpleBlockFeature
 *  net.minecraft.world.gen.feature.SimpleBlockFeatureConfig
 *  net.minecraft.world.WorldView
 *  net.minecraft.world.StructureWorldAccess
 *  net.minecraft.world.gen.feature.util.FeatureContext
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.common.worldgen.feature;

import backported.updates.content.common.level.blocks.EyeblossomBlock;
import backported.updates.content.common.level.blocks.MossyCarpetBlock;
import net.minecraft.world.WorldAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.SimpleBlockFeature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.WorldView;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={SimpleBlockFeature.class})
public class SimpleBlockFeatureMixin {
    @Inject(method={"generate"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPlace(FeatureContext<SimpleBlockFeatureConfig> context, CallbackInfoReturnable<Boolean> cir) {
        SimpleBlockFeatureConfig config = (SimpleBlockFeatureConfig)context.getConfig();
        StructureWorldAccess level = context.getWorld();
        BlockPos origin = context.getOrigin();
        BlockState state = config.toPlace().get(context.getRandom(), origin);
        if (state.canPlaceAt((WorldView)level, origin)) {
            if (state.getBlock() instanceof MossyCarpetBlock) {
                MossyCarpetBlock.placeAt((WorldAccess)level, origin, level.getRandom(), 2);
                cir.setReturnValue(true);
            }
            if (state.getBlock() instanceof EyeblossomBlock) {
                level.scheduleBlockTick(origin, level.getBlockState(origin).getBlock(), 1);
                level.setBlockState(origin, state, 2);
                cir.setReturnValue(true);
            }
        }
    }
}

