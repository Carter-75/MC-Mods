/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.glue.SuperGlueRemovalPacket
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_3222
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.packets;

import com.simibubi.create.content.contraptions.glue.SuperGlueRemovalPacket;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_3222;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={SuperGlueRemovalPacket.class})
public abstract class MixinSuperGlueRemovalPacket {
    @Redirect(method={"lambda$handle$0"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerPlayer;distanceToSqr(Lnet/minecraft/world/phys/Vec3;)D"))
    private double redirectPlayerDistanceToSqr(class_3222 instance, class_243 vec3) {
        Ship ship;
        class_243 newVec3 = vec3;
        if (VSGameUtilsKt.isBlockInShipyard(instance.method_37908(), class_2338.method_49637((double)vec3.field_1352, (double)vec3.field_1351, (double)vec3.field_1350)) && (ship = VSGameUtilsKt.getShipManagingPos(instance.method_37908(), (class_2374)vec3)) != null) {
            newVec3 = VectorConversionsMCKt.toMinecraft(ship.getShipToWorld().transformPosition(new Vector3d(vec3.field_1352, vec3.field_1351, vec3.field_1350)));
        }
        return instance.method_5707(newVec3);
    }
}

