/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  at.petrak.hexcasting.common.casting.actions.raycast.OpEntityRaycast
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.hexcasting;

import at.petrak.hexcasting.common.casting.actions.raycast.OpEntityRaycast;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.Optional;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.api.ValkyrienSkies;

@Pseudo
@Mixin(value={OpEntityRaycast.class})
public class MixinOpEntityRaycast {
    @WrapOperation(method={"getEntityHitResult"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/AABB;clip(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)Ljava/util/Optional;")})
    private Optional<class_243> valkyrienskies$wrapEntityClip(class_238 instance, class_243 vec3, class_243 vec32, Operation<Optional<class_243>> original, @Local(argsOnly=true) class_1937 level) {
        return (Optional)original.call(new Object[]{ValkyrienSkies.toWorld(level, instance), vec3, vec32});
    }
}

