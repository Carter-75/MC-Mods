/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  ram.talia.hexal.api.linkable.ILinkable
 *  ram.talia.hexal.api.linkable.ServerLinkableHolder
 */
package org.valkyrienskies.mod.mixin.mod_compat.hexcasting.hexal;

import net.minecraft.class_1937;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import ram.talia.hexal.api.linkable.ILinkable;
import ram.talia.hexal.api.linkable.ServerLinkableHolder;

@Pseudo
@Mixin(value={ServerLinkableHolder.class})
public class MixinServerLinkableHolder {
    @Final
    @Shadow
    private class_3218 level;

    @Redirect(method={"checkLinks"}, at=@At(value="INVOKE", target="Lram/talia/hexal/api/linkable/ILinkable;isInRange(Lram/talia/hexal/api/linkable/ILinkable;)Z"), remap=false)
    private boolean valkyrienskies$isInRange(ILinkable instance, ILinkable iLinkable) {
        class_243 second2;
        double maxDistance = 2.0 * (Math.sqrt(instance.maxSqrLinkRange()) + Math.sqrt(iLinkable.maxSqrLinkRange()));
        class_243 first2 = instance.getPosition();
        return Math.sqrt(ValkyrienSkies.distance((class_1937)this.level, (class_2374)first2, (class_2374)(second2 = iLinkable.getPosition()))) <= maxDistance;
    }
}

