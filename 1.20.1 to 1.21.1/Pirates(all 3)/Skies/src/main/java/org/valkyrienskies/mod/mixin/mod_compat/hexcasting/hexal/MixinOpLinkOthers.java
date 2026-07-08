/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironment
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1937
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  ram.talia.hexal.api.linkable.ILinkable
 *  ram.talia.hexal.common.casting.actions.spells.link.OpLinkOthers
 */
package org.valkyrienskies.mod.mixin.mod_compat.hexcasting.hexal;

import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1937;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import ram.talia.hexal.api.linkable.ILinkable;
import ram.talia.hexal.common.casting.actions.spells.link.OpLinkOthers;

@Pseudo
@Mixin(value={OpLinkOthers.class})
public class MixinOpLinkOthers {
    @Redirect(method={"execute"}, at=@At(value="INVOKE", target="Lram/talia/hexal/api/linkable/ILinkable;isInRange(Lram/talia/hexal/api/linkable/ILinkable;)Z"), remap=false, require=0)
    private boolean valkyrienskies$isInRange(ILinkable instance, ILinkable iLinkable, @Local(argsOnly=true) CastingEnvironment env) {
        class_243 second2;
        class_3218 level = env.getWorld();
        double maxDistance = 2.0 * (Math.sqrt(instance.maxSqrLinkRange()) + Math.sqrt(iLinkable.maxSqrLinkRange()));
        class_243 first2 = instance.getPosition();
        return ValkyrienSkies.distance((class_1937)level, (class_2374)first2, (class_2374)(second2 = iLinkable.getPosition())) <= maxDistance;
    }
}

