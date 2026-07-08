/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorPackage
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorVisual
 *  dev.engine_room.flywheel.lib.instance.TransformedInstance
 *  dev.engine_room.flywheel.lib.transform.Rotate
 *  net.minecraft.class_3532
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorBlockEntity;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorPackage;
import com.simibubi.create.content.kinetics.chainConveyor.ChainConveyorVisual;
import dev.engine_room.flywheel.lib.instance.TransformedInstance;
import dev.engine_room.flywheel.lib.transform.Rotate;
import net.minecraft.class_3532;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;

@Mixin(value={ChainConveyorVisual.class}, remap=false)
public abstract class MixinChainConveyorVisual {
    @Unique
    private ClientShip vs$ship;

    @Inject(method={"setupBoxVisual"}, at={@At(value="HEAD")})
    private void getShipPrevBoxVisual(ChainConveyorBlockEntity be, ChainConveyorPackage box, float partialTicks, CallbackInfo ci) {
        this.vs$ship = VSClientGameUtils.getClientShip(be.method_11016().method_10263(), be.method_11016().method_10264(), be.method_11016().method_10260());
    }

    @WrapOperation(method={"setupBoxVisual"}, at={@At(value="INVOKE", target="Ldev/engine_room/flywheel/lib/instance/TransformedInstance;translate(FFF)Ldev/engine_room/flywheel/lib/instance/TransformedInstance;", ordinal=0)})
    private TransformedInstance wrapTranslateDown(TransformedInstance instance, float x, float y, float z, Operation<TransformedInstance> original, ChainConveyorBlockEntity be) {
        TransformedInstance result2 = (TransformedInstance)original.call(new Object[]{instance, Float.valueOf(x), Float.valueOf(y), Float.valueOf(z)});
        if (this.vs$ship != null) {
            return result2.rotate((Quaternionfc)this.vs$ship.getRenderTransform().getWorldToShip().getNormalizedRotation(new Quaternionf()));
        }
        return result2;
    }

    @WrapOperation(method={"setupBoxVisual"}, at={@At(value="INVOKE", target="Lnet/minecraft/util/Mth;clamp(FFF)F", remap=true)})
    private float disableClampIfOnShip(float f2, float g2, float h2, Operation<Float> original) {
        if (this.vs$ship != null) {
            return ((Float)original.call(new Object[]{Float.valueOf(f2), Float.valueOf(-180.0f), Float.valueOf(180.0f)})).floatValue();
        }
        return ((Float)original.call(new Object[]{Float.valueOf(f2), Float.valueOf(g2), Float.valueOf(h2)})).floatValue();
    }

    @WrapOperation(method={"setupBoxVisual"}, at={@At(value="INVOKE", target="Ldev/engine_room/flywheel/lib/instance/TransformedInstance;rotateYDegrees(F)Ldev/engine_room/flywheel/lib/transform/Rotate;", ordinal=0)})
    private Rotate wrapRotateYaw(TransformedInstance instance, float yaw, Operation<Rotate> original) {
        if (this.vs$ship != null) {
            Vector3d heading = new Vector3d(class_3532.method_15374((float)(yaw * ((float)Math.PI / 180))), 0.0, class_3532.method_15362((float)(yaw * ((float)Math.PI / 180))));
            this.vs$ship.getRenderTransform().getShipToWorld().transformDirection(heading);
            float yawInShip = (float)class_3532.method_15349((double)heading.x, (double)heading.z) * 57.295776f;
            float offset = (float)this.vs$ship.getRenderTransform().getShipToWorld().transformDirection((Vector3d)new Vector3d((double)0.0, (double)1.0, (double)0.0)).y;
            float newYaw = yawInShip + (class_3532.method_15363((float)offset, (float)-0.1f, (float)0.1f) - 0.1f) * -900.0f;
            return (Rotate)original.call(new Object[]{instance, Float.valueOf(newYaw)});
        }
        return (Rotate)original.call(new Object[]{instance, Float.valueOf(yaw)});
    }
}

