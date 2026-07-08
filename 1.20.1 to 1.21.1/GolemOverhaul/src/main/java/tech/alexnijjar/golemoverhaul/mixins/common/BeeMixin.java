/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.v2.WrapWithCondition
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1314
 *  net.minecraft.class_1320
 *  net.minecraft.class_1352
 *  net.minecraft.class_1937
 *  net.minecraft.class_2487
 *  net.minecraft.class_3218
 *  net.minecraft.class_4466
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package tech.alexnijjar.golemoverhaul.mixins.common;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.UUID;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1314;
import net.minecraft.class_1320;
import net.minecraft.class_1352;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_3218;
import net.minecraft.class_4466;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tech.alexnijjar.golemoverhaul.common.entities.AdditionalBeeData;
import tech.alexnijjar.golemoverhaul.common.entities.goals.GoToHoneyGolemHiveGoal;
import tech.alexnijjar.golemoverhaul.common.entities.goals.LocateHoneyGolemHiveGoal;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HoneyGolem;

@Mixin(value={class_4466.class})
public abstract class BeeMixin
extends class_1314
implements AdditionalBeeData {
    @Unique
    @Nullable
    private UUID golemoverhaul$owner;

    protected BeeMixin(class_1299<? extends class_1314> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Inject(method={"registerGoals"}, at={@At(value="TAIL")})
    private void golemoverhaul$registerGoals(CallbackInfo ci) {
        class_4466 bee = (class_4466)this;
        this.field_6201.method_6277(5, (class_1352)new LocateHoneyGolemHiveGoal(bee));
        this.field_6201.method_6277(6, (class_1352)new GoToHoneyGolemHiveGoal(bee));
    }

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void golemoverhaul$tick(CallbackInfo ci) {
        class_1937 class_19372;
        if (this.field_6012 + this.method_5628() % 40 == 0 && this.method_5968() == null && (class_19372 = this.method_37908()) instanceof class_3218) {
            HoneyGolem golem;
            class_1297 class_12972;
            class_3218 level = (class_3218)class_19372;
            if (this.golemoverhaul$owner != null && (class_12972 = level.method_14190(this.golemoverhaul$owner)) instanceof HoneyGolem && (golem = (HoneyGolem)class_12972).method_5968() != null) {
                this.method_5980(golem.method_5968());
            }
        }
    }

    @Inject(method={"setHasStung"}, at={@At(value="HEAD")}, cancellable=true)
    private void golemoverhaul$setHasStung(boolean hasStung, CallbackInfo ci) {
        if (hasStung && this.golemoverhaul$owner != null) {
            ci.cancel();
        }
    }

    @WrapWithCondition(method={"doHurtTarget"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/animal/Bee;stopBeingAngry()V")})
    private boolean golemoverhaul$doHurtTarget(class_4466 instance) {
        return this.golemoverhaul$owner == null;
    }

    @WrapOperation(method={"doHurtTarget"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/animal/Bee;getAttributeValue(Lnet/minecraft/world/entity/ai/attributes/Attribute;)D")})
    private double golemoverhaul$doHurtTarget2(class_4466 instance, class_1320 attribute, Operation<Double> original) {
        return (Double)original.call(new Object[]{instance, attribute}) * (double)(this.golemoverhaul$owner != null ? 6 : 1);
    }

    @Override
    @Nullable
    public UUID golemoverhaul$getOwner() {
        return this.golemoverhaul$owner;
    }

    @Override
    public void golemoverhaul$setOwner(UUID owner) {
        this.golemoverhaul$owner = owner;
    }

    @Override
    public boolean golemoverhaul$hasGolemHive() {
        return this.golemoverhaul$owner != null;
    }

    @Inject(method={"addAdditionalSaveData"}, at={@At(value="TAIL")})
    private void golemoverhaul$addAdditionalSaveData(class_2487 compound, CallbackInfo ci) {
        if (this.golemoverhaul$owner != null) {
            compound.method_25927("HoneyGolemOwner", this.golemoverhaul$owner);
        }
    }

    @Inject(method={"readAdditionalSaveData"}, at={@At(value="TAIL")})
    private void golemoverhaul$readAdditionalSaveData(class_2487 compound, CallbackInfo ci) {
        if (compound.method_10545("HoneyGolemOwner")) {
            this.golemoverhaul$owner = compound.method_25926("HoneyGolemOwner");
        }
    }

    @Inject(method={"wantsToEnterHive"}, at={@At(value="HEAD")}, cancellable=true)
    private void golemoverhaul$wantsToEnterHive(CallbackInfoReturnable<Boolean> cir) {
        class_3218 level;
        class_1297 class_12972;
        class_1937 class_19372;
        if (this.golemoverhaul$owner != null && (class_19372 = this.method_37908()) instanceof class_3218 && (class_12972 = (level = (class_3218)class_19372).method_14190(this.golemoverhaul$owner)) instanceof HoneyGolem) {
            HoneyGolem golem = (HoneyGolem)class_12972;
            if (golem.method_5968() != null) {
                cir.setReturnValue((Object)false);
                return;
            }
            if (level.method_23886()) {
                cir.setReturnValue((Object)true);
            }
        }
    }
}

