/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1400
 *  net.minecraft.class_1405
 *  net.minecraft.class_1439
 *  net.minecraft.class_238
 *  net.minecraft.class_4051
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package tech.alexnijjar.golemoverhaul.mixins.common;

import net.minecraft.class_1297;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1400;
import net.minecraft.class_1405;
import net.minecraft.class_1439;
import net.minecraft.class_238;
import net.minecraft.class_4051;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;

@Mixin(value={class_1400.class})
public abstract class NearestAttackableTargetGoalMixin<T extends class_1309>
extends class_1405 {
    @Shadow
    @Final
    protected Class<T> field_6643;
    @Shadow
    @Nullable
    protected class_1309 field_6644;
    @Shadow
    protected class_4051 field_6642;

    @Shadow
    protected abstract class_238 method_6321(double var1);

    private NearestAttackableTargetGoalMixin(class_1308 mob, boolean mustSee) {
        super(mob, mustSee);
    }

    @Inject(method={"findTarget"}, at={@At(value="TAIL")})
    private void golemoverhaul$findTarget(CallbackInfo ci) {
        if (this.field_6643 == class_1439.class && this.field_6644 == null) {
            this.field_6644 = this.field_6660.method_37908().method_18468(this.field_6660.method_37908().method_8333((class_1297)this.field_6660, this.method_6321(this.method_6326()), entity -> {
                BaseGolem golem;
                return entity instanceof BaseGolem && (golem = (BaseGolem)((Object)entity)).canTarget();
            }).stream().map(e -> (class_1309)e).toList(), this.field_6642, (class_1309)this.field_6660, this.field_6660.method_23317(), this.field_6660.method_23320(), this.field_6660.method_23321());
        }
    }
}

