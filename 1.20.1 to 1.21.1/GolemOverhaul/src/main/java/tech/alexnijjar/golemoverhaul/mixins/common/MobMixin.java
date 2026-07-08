/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1439
 *  net.minecraft.class_1473
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package tech.alexnijjar.golemoverhaul.mixins.common;

import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1439;
import net.minecraft.class_1473;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;

@Mixin(value={class_1308.class})
public abstract class MobMixin {
    @Inject(method={"setTarget"}, at={@At(value="HEAD")}, cancellable=true)
    private void golemoverhaul$setTarget(class_1309 target, CallbackInfo ci) {
        class_1308 mob = (class_1308)this;
        if ((mob instanceof class_1439 || mob instanceof class_1473) && target instanceof BaseGolem) {
            ci.cancel();
        }
    }
}

