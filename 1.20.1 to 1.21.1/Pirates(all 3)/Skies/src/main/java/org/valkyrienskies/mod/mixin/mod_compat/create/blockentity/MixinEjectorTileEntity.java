/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.logistics.depot.EjectorBlockEntity
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.logistics.depot.EjectorBlockEntity;
import java.util.Collection;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={EjectorBlockEntity.class})
public abstract class MixinEjectorTileEntity {
    @WrapOperation(method={"activateDeferred", "nudgeEntities"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;)Ljava/util/List;")})
    private List<class_1297> redirectGetEntitiesOfClass(class_1937 instance, Class aClass, class_238 aabb, Operation<List<class_1297>> original) {
        List entities = (List)original.call(new Object[]{instance, aClass, aabb});
        Ship ship = VSGameUtilsKt.getShipManagingPos(instance, ((EjectorBlockEntity)this).method_11016());
        if (ship != null) {
            class_238 worldAABB = VectorConversionsMCKt.toMinecraft(VectorConversionsMCKt.toJOML(aabb).transform(ship.getShipToWorld())).method_1009(0.0, 0.2, 0.0);
            entities.addAll((Collection)original.call(new Object[]{instance, aClass, worldAABB}));
        }
        return entities;
    }

    @Redirect(method={"activateDeferred"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setPos(DDD)V"))
    private void redirectSetPos(class_1297 instance, double x, double y, double z) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(instance.method_37908(), ((EjectorBlockEntity)this).method_11016());
        if (ship != null) {
            class_2338 temp = ((EjectorBlockEntity)this).method_11016();
            Vector3d tempVec = new Vector3d((double)temp.method_10263() + 0.5, temp.method_10264() + 1, (double)temp.method_10260() + 0.5);
            ship.getTransform().getShipToWorld().transformPosition(tempVec, tempVec);
            instance.method_5814(tempVec.x, tempVec.y, tempVec.z);
        } else {
            instance.method_5814(x, y, z);
        }
    }
}

