/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironment
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.beholderface.ephemera.casting.patterns.link.OpNetworkTeleport
 *  net.minecraft.class_1937
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.hexcasting.ephemera;

import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import com.llamalad7.mixinextras.sugar.Local;
import net.beholderface.ephemera.casting.patterns.link.OpNetworkTeleport;
import net.minecraft.class_1937;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.api.ValkyrienSkies;

@Pseudo
@Mixin(value={OpNetworkTeleport.class})
public class MixinOpNetworkTeleport {
    @Redirect(method={"execute"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;distanceTo(Lnet/minecraft/world/phys/Vec3;)D", ordinal=0), require=0)
    private double valkyrienskies$transformTargetDistance(class_243 instance, class_243 d2, @Local(argsOnly=true) CastingEnvironment env) {
        return ValkyrienSkies.distance((class_1937)env.getWorld(), (class_2374)instance, (class_2374)d2);
    }

    @Redirect(method={"execute"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;distanceTo(Lnet/minecraft/world/phys/Vec3;)D", ordinal=1), require=0)
    private double valkyrienskies$transformDistance(class_243 instance, class_243 d2, @Local(argsOnly=true) CastingEnvironment env) {
        return Math.pow(ValkyrienSkies.distance((class_1937)env.getWorld(), (class_2374)instance, (class_2374)d2), 2.0);
    }
}

