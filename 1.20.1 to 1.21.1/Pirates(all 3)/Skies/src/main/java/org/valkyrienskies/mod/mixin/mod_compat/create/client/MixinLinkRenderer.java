/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.redstone.link.LinkRenderer
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.simibubi.create.content.redstone.link.LinkRenderer;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={LinkRenderer.class})
public class MixinLinkRenderer {
    @Redirect(method={"renderOnBlockEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D"))
    private static double redirectDistanceToSqr(class_243 instance, class_243 vec) {
        class_243 result2 = VSGameUtilsKt.toShipRenderCoordinates(class_310.method_1551().field_1687, vec, instance);
        return result2.method_1025(vec);
    }
}

