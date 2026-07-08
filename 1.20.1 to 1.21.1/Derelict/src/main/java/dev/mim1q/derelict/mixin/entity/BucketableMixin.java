/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1268
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_5761
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package dev.mim1q.derelict.mixin.entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.mim1q.derelict.entity.SpiderlingEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_5761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={class_5761.class})
public interface BucketableMixin {
    @WrapOperation(method={"tryBucket"}, at={@At(value="INVOKE", target="Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;", ordinal=0)})
    private static <T extends class_1309> class_1792 derelict$modifyItemInTryBucket(class_1799 instance, Operation<class_1792> original, class_1657 playerEntity, class_1268 hand, T entity) {
        if (entity instanceof SpiderlingEntity.Enemy) {
            if (instance.method_31574(class_1802.field_8705)) {
                return class_1802.field_8162;
            }
            if (instance.method_31574(class_1802.field_8550)) {
                return class_1802.field_8705;
            }
        }
        return (class_1792)original.call(new Object[]{instance});
    }
}

