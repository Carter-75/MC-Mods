/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.schematics.client.SchematicTransformation
 *  com.simibubi.create.content.schematics.client.tools.SchematicToolBase
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3965
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.schematics.client.SchematicTransformation;
import com.simibubi.create.content.schematics.client.tools.SchematicToolBase;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={SchematicToolBase.class})
public abstract class MixinSchematicToolBase {
    @Redirect(method={"updateTargetPos()V"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/BlockHitResult;getLocation()Lnet/minecraft/world/phys/Vec3;", ordinal=0))
    public class_243 redirectGetLocation(class_3965 instance) {
        class_2338 b2 = instance.method_17777();
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos(class_310.method_1551().field_1687, (class_2382)b2);
        if (ship != null) {
            return class_243.method_24954((class_2382)b2);
        }
        return instance.method_17784();
    }

    @WrapOperation(method={"updateTargetPos"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/schematics/client/SchematicTransformation;toLocalSpace(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;")})
    public class_243 wrapLocalSpaceToShip(SchematicTransformation transformation, class_243 vec, Operation<class_243> original) {
        ClientShip ship = VSGameUtilsKt.getLoadedShipManagingPos(class_310.method_1551().field_1687, (class_2382)transformation.getAnchor());
        if (ship != null) {
            return (class_243)original.call(new Object[]{transformation, VectorConversionsMCKt.toMinecraft(ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(vec)))});
        }
        return (class_243)original.call(new Object[]{transformation, vec});
    }
}

