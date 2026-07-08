/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_2597
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package tech.alexnijjar.golemoverhaul.mixins.common;

import com.llamalad7.mixinextras.sugar.Local;
import java.util.List;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_2597;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import tech.alexnijjar.golemoverhaul.common.entities.golems.KelpGolem;

@Mixin(value={class_2597.class})
public abstract class ConduitBlockEntityMixin {
    @Inject(method={"applyEffects"}, at={@At(value="TAIL")}, locals=LocalCapture.CAPTURE_FAILSOFT)
    private static void golemoverhaul$applyEffects(class_1937 level, class_2338 pos, List<class_2338> positions, CallbackInfo ci, @Local class_238 aabb, @Local(ordinal=1) int distance) {
        if (pos == null) {
            return;
        }
        level.method_18467(KelpGolem.class, aabb).forEach(entity -> {
            if (pos.method_19771((class_2382)entity.method_24515(), (double)distance) && entity.method_5721()) {
                entity.method_6092(new class_1293(class_1294.field_5927, 260, 0, true, true));
            }
        });
    }
}

