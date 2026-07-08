/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2276
 *  net.minecraft.class_2338
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package tech.alexnijjar.golemoverhaul.mixins.common;

import net.minecraft.class_1937;
import net.minecraft.class_2276;
import net.minecraft.class_2338;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HayGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.NetheriteGolem;

@Mixin(value={class_2276.class})
public abstract class CarvedPumpkinBlockMixin {
    @Inject(method={"trySpawnGolem"}, at={@At(value="TAIL")})
    private void golemoverhaul$trySpawnGolem(class_1937 level, class_2338 pos, CallbackInfo ci) {
        HayGolem.trySpawnGolem(level, pos);
        NetheriteGolem.trySpawnGolem(level, pos);
    }
}

