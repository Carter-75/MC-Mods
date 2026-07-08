/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1088
 *  net.minecraft.class_1088$class_7777
 *  net.minecraft.class_1091
 *  net.minecraft.class_2960
 *  net.minecraft.class_324
 *  net.minecraft.class_3695
 *  net.minecraft.class_793
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net._void.civilizations.mixin;

import java.util.List;
import java.util.Map;
import net.minecraft.class_1088;
import net.minecraft.class_1091;
import net.minecraft.class_2960;
import net.minecraft.class_324;
import net.minecraft.class_3695;
import net.minecraft.class_793;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1088.class})
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void method_4727(class_1091 var1);

    @Inject(method={"<init>"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal=3, shift=At.Shift.AFTER)})
    public void addRubyStaff(class_324 blockColors, class_3695 profiler, Map<class_2960, class_793> jsonUnbakedModels, Map<class_2960, List<class_1088.class_7777>> blockStates, CallbackInfo ci) {
        this.method_4727(new class_1091("civilizations", "egypt_crook_3d", "inventory"));
        this.method_4727(new class_1091("civilizations", "wukong_sword_3d", "inventory"));
    }
}

