/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 *  net.minecraft.class_3218$class_5526
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.physics_entities;

import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.api.EntityPhysicsListener;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;

@Mixin(value={class_3218.class_5526.class})
public class MixinServerLevel {
    @Inject(method={"onTickingStart(Lnet/minecraft/world/entity/Entity;)V"}, at={@At(value="TAIL")})
    private void postAddEntity(class_1297 entity, CallbackInfo ci) {
        if (entity instanceof EntityPhysicsListener) {
            EntityPhysicsListener listener = (EntityPhysicsListener)entity;
            String dimid = VSGameUtilsKt.getDimensionId((class_1937)((class_3218)this));
            ValkyrienSkiesMod.INSTANCE.addEntityPhysTicker(dimid, entity);
        }
    }

    @Inject(method={"onTickingEnd(Lnet/minecraft/world/entity/Entity;)V"}, at={@At(value="TAIL")})
    private void postRemoveEntity(class_1297 entity, CallbackInfo ci) {
        if (entity instanceof EntityPhysicsListener) {
            EntityPhysicsListener listener = (EntityPhysicsListener)entity;
            String dimid = VSGameUtilsKt.getDimensionId((class_1937)((class_3218)this));
            ValkyrienSkiesMod.INSTANCE.removeEntityPhysTicker(entity, dimid);
        }
    }
}

