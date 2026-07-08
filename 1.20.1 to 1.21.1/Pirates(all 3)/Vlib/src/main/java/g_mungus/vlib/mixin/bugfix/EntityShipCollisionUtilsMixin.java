/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.valkyrienskies.core.internal.collision.VsiEntityPolygonCollider
 *  org.valkyrienskies.mod.common.util.EntityShipCollisionUtils
 */
package g_mungus.vlib.mixin.bugfix;

import g_mungus.vlib.util.EntityCollisionUtilsKt;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.internal.collision.VsiEntityPolygonCollider;
import org.valkyrienskies.mod.common.util.EntityShipCollisionUtils;

@Mixin(value={EntityShipCollisionUtils.class})
public class EntityShipCollisionUtilsMixin {
    @Final
    @Shadow(remap=false)
    private static VsiEntityPolygonCollider collider;

    @Inject(method={"adjustEntityMovementForShipCollisions"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    private void adjustEntityMovementForShipCollisionsMixin(class_1297 entity, class_243 movement, class_238 entityBoundingBox, class_1937 world, CallbackInfoReturnable<class_243> cir) {
        cir.setReturnValue((Object)EntityCollisionUtilsKt.adjustEntityMovementForShipCollisions(entity, movement, entityBoundingBox, world, collider));
    }
}

