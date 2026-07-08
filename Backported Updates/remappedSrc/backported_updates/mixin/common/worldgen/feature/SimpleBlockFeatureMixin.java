/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3173
 *  net.minecraft.class_3175
 *  net.minecraft.class_4538
 *  net.minecraft.class_5281
 *  net.minecraft.class_5821
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.common.worldgen.feature;

import backported.updates.content.common.level.blocks.EyeblossomBlock;
import backported.updates.content.common.level.blocks.MossyCarpetBlock;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3173;
import net.minecraft.class_3175;
import net.minecraft.class_4538;
import net.minecraft.class_5281;
import net.minecraft.class_5821;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_3173.class})
public class SimpleBlockFeatureMixin {
    @Inject(method={"place"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPlace(class_5821<class_3175> context, CallbackInfoReturnable<Boolean> cir) {
        class_3175 config = (class_3175)context.method_33656();
        class_5281 level = context.method_33652();
        class_2338 origin = context.method_33655();
        class_2680 state = config.comp_156().method_23455(context.method_33654(), origin);
        if (state.method_26184((class_4538)level, origin)) {
            if (state.method_26204() instanceof MossyCarpetBlock) {
                MossyCarpetBlock.placeAt((class_1936)level, origin, level.method_8409(), 2);
                cir.setReturnValue((Object)true);
            }
            if (state.method_26204() instanceof EyeblossomBlock) {
                level.method_39279(origin, level.method_8320(origin).method_26204(), 1);
                level.method_8652(origin, state, 2);
                cir.setReturnValue((Object)true);
            }
        }
    }
}

