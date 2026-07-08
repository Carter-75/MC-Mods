/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.trains.track.BezierConnection
 *  com.simibubi.create.content.trains.track.BezierConnection$SegmentAngles
 *  dev.engine_room.flywheel.lib.instance.TransformedInstance
 *  net.minecraft.class_1920
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_310
 *  net.minecraft.class_761
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.trains.track.BezierConnection;
import dev.engine_room.flywheel.lib.instance.TransformedInstance;
import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_310;
import net.minecraft.class_761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;

@Mixin(targets={"com.simibubi.create.content.trains.track.TrackVisual$BezierTrackVisual"})
public class MixinBezierTrackVisual {
    @WrapOperation(method={"<init>"}, at={@At(value="INVOKE", target="Ldev/engine_room/flywheel/lib/instance/TransformedInstance;setChanged()V")})
    private static void stackToShip(TransformedInstance instance, Operation<Void> original, @Local(argsOnly=true) BezierConnection bc, @Local BezierConnection.SegmentAngles sa, @Local(name={"i"}) int i2) {
        ClientShip ship = VSClientGameUtils.getClientShip(((class_2338)bc.bePositions.getFirst()).method_10263(), ((class_2338)bc.bePositions.getFirst()).method_10264(), ((class_2338)bc.bePositions.getFirst()).method_10260());
        if (ship != null) {
            instance = (TransformedInstance)instance.light(class_761.method_23794((class_1920)class_310.method_1551().field_1687, (class_2338)sa.lightPosition[i2].method_10081((class_2382)bc.bePositions.getFirst())));
        }
        original.call(new Object[]{instance});
    }
}

