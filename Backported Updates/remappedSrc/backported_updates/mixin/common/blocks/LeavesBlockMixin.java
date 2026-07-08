/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2397
 *  net.minecraft.class_2680
 *  net.minecraft.class_5819
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
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2397;
import net.minecraft.class_2680;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2397.class})
@Environment(value=EnvType.CLIENT)
public class LeavesBlockMixin {
    @Unique
    private final FallingLeavesModule module = new FallingLeavesModule();

    @Inject(method={"animateTick"}, at={@At(value="HEAD")})
    public void vb$animateTick(class_2680 state, class_1937 level, class_2338 pos, class_5819 random, CallbackInfo ci) {
        this.module.makeFallingLeavesParticles(level, pos, random, level.method_8320(pos.method_10074()), pos.method_10074());
    }
}

