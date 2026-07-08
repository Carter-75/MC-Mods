/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_3532
 *  net.minecraft.class_5707
 *  net.minecraft.class_5716
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyArgs
 *  org.spongepowered.asm.mixin.injection.invoke.arg.Args
 */
package org.valkyrienskies.mod.mixin.mod_compat.echochest;

import com.llamalad7.mixinextras.sugar.Local;
import java.util.Optional;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_3532;
import net.minecraft.class_5707;
import net.minecraft.class_5716;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Pseudo
@Mixin(targets={"fuzs.echochest.world.level.block.entity.EchoChestListener"}, remap=false)
public abstract class MixinEchoChestListener {
    @ModifyArgs(method={"handleGameEvent"}, at=@At(value="INVOKE", target="net/minecraft/core/particles/VibrationParticleOption.<init>(Lnet/minecraft/world/level/gameevent/PositionSource;I)V"))
    public void destSourcePos(Args args, @Local(argsOnly=true) class_3218 level, @Local(argsOnly=true) class_243 pos) {
        Optional optPos;
        class_5716 trueSource = (class_5716)args.get(0);
        if (level != null && (optPos = trueSource.method_32956((class_1937)level)).isPresent()) {
            class_243 worldPos = VSGameUtilsKt.toWorldCoordinates((class_1937)level, (class_243)optPos.get());
            args.set(0, (Object)new class_5707(class_2338.method_49638((class_2374)worldPos)));
            args.set(1, (Object)class_3532.method_15357((double)pos.method_1022(worldPos)));
        }
    }
}

