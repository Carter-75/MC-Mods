/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1936
 *  net.minecraft.class_1948
 *  net.minecraft.class_2338
 *  net.minecraft.class_3218
 *  net.minecraft.class_3730
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.mim1q.derelict.mixin.entity;

import dev.mim1q.derelict.init.ModEntities;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1936;
import net.minecraft.class_1948;
import net.minecraft.class_2338;
import net.minecraft.class_3218;
import net.minecraft.class_3730;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1948.class})
public abstract class SpawnHelperMixin {
    @Inject(method={"isValidSpawn"}, at={@At(value="RETURN")}, cancellable=true)
    private static void derelict$isValidSpawn(class_3218 world, class_1308 entity, double squaredDistance, CallbackInfoReturnable<Boolean> cir) {
        if (ModEntities.INSTANCE.getSPAWN_ON_GROUND().contains(entity.method_5864())) {
            cir.setReturnValue((Object)((Boolean)cir.getReturnValue() != false && class_1308.method_20636((class_1299)entity.method_5864(), (class_1936)world, (class_3730)class_3730.field_16459, (class_2338)entity.method_24515(), (class_5819)world.field_9229) ? 1 : 0));
        }
    }
}

