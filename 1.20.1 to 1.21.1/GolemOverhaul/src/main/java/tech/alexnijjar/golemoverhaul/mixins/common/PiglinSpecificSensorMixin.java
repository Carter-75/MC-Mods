/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_3218
 *  net.minecraft.class_4140
 *  net.minecraft.class_4834
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package tech.alexnijjar.golemoverhaul.mixins.common;

import net.minecraft.class_1309;
import net.minecraft.class_3218;
import net.minecraft.class_4140;
import net.minecraft.class_4834;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.alexnijjar.golemoverhaul.common.entities.golems.NetheriteGolem;

@Mixin(value={class_4834.class})
public abstract class PiglinSpecificSensorMixin {
    @Inject(method={"doTick"}, at={@At(value="TAIL")})
    private void golemoverhaul$doTick(class_3218 level, class_1309 entity, CallbackInfo ci) {
        entity.method_18868().method_18904(class_4140.field_18442).ifPresent(entities -> entities.method_38978(e -> {
            NetheriteGolem g;
            return e instanceof NetheriteGolem && !(g = (NetheriteGolem)e).isGilded();
        }).forEach(e -> entity.method_18868().method_18878(class_4140.field_22333, (Object)e.method_5667())));
    }
}

