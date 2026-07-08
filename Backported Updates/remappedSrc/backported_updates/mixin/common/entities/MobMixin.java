/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1315
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2487
 *  net.minecraft.class_2945$class_9222
 *  net.minecraft.class_3730
 *  net.minecraft.class_5425
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.common.entities;

import net.minecraft.class_1266;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1315;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2945;
import net.minecraft.class_3730;
import net.minecraft.class_5425;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1308.class})
public abstract class MobMixin
extends class_1309 {
    @Shadow
    public abstract class_1269 method_5688(class_1657 var1, class_1268 var2);

    @Shadow
    protected abstract void method_5693(class_2945.class_9222 var1);

    protected MobMixin(class_1299<? extends class_1309> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Inject(method={"defineSynchedData"}, at={@At(value="TAIL")})
    protected void vb$defineSynchedData(class_2945.class_9222 builder, CallbackInfo ci) {
    }

    @Inject(method={"addAdditionalSaveData"}, at={@At(value="RETURN")})
    protected void vb$addAdditionalSaveData(class_2487 tag, CallbackInfo ci) {
    }

    @Inject(method={"readAdditionalSaveData"}, at={@At(value="RETURN")})
    protected void vb$readAdditionalSaveData(class_2487 tag, CallbackInfo ci) {
    }

    @Inject(method={"finalizeSpawn"}, at={@At(value="RETURN")})
    protected void vb$finalizeSpawn(class_5425 level, class_1266 difficulty, class_3730 reason, class_1315 spawnData, CallbackInfoReturnable<class_1315> cir) {
    }

    @Inject(method={"tick"}, at={@At(value="RETURN")})
    protected void vb$tick(CallbackInfo ci) {
    }
}

