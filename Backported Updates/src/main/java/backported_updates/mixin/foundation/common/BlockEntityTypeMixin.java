/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.AbstractSignBlock
 *  net.minecraft.block.WallSignBlock
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.HangingSignBlock
 *  net.minecraft.block.WallHangingSignBlock
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.common;

import net.minecraft.block.AbstractSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.WallHangingSignBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockEntityType.class})
public class BlockEntityTypeMixin {
    @Inject(method={"supports"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$isValid(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (BlockEntityType.SIGN.equals(this) && (state.getBlock() instanceof AbstractSignBlock || state.getBlock() instanceof WallSignBlock)) {
            cir.setReturnValue(true);
        }
        if (BlockEntityType.HANGING_SIGN.equals(this) && (state.getBlock() instanceof HangingSignBlock || state.getBlock() instanceof WallHangingSignBlock)) {
            cir.setReturnValue(true);
        }
    }
}

