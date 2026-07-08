/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1937
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  ram.talia.hexal.api.linkable.ILinkable$IRenderCentre
 *  ram.talia.hexal.client.RenderHelperKt
 */
package org.valkyrienskies.mod.mixin.mod_compat.hexcasting.hexal;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1937;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import ram.talia.hexal.api.linkable.ILinkable;
import ram.talia.hexal.client.RenderHelperKt;

@Pseudo
@Mixin(value={RenderHelperKt.class})
public class MixinRenderHelper {
    @WrapOperation(method={"playLinkParticles"}, at={@At(value="INVOKE", target="Lram/talia/hexal/api/linkable/ILinkable$IRenderCentre$DefaultImpls;renderCentre$default(Lram/talia/hexal/api/linkable/ILinkable$IRenderCentre;Lram/talia/hexal/api/linkable/ILinkable$IRenderCentre;ZILjava/lang/Object;)Lnet/minecraft/world/phys/Vec3;", ordinal=0)})
    private static class_243 valkyrienskies$transformSource(ILinkable.IRenderCentre source, ILinkable.IRenderCentre sink, boolean b2, int i2, Object o, Operation<class_243> original, @Local(argsOnly=true) class_1937 level) {
        class_243 sourceCenter = (class_243)original.call(new Object[]{source, sink, b2, i2, o});
        Ship ship = ValkyrienSkies.getShipManagingBlock(level, (class_2374)sourceCenter);
        if (ship instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            sourceCenter = ValkyrienSkies.positionToWorld((Ship)ship2, sourceCenter);
        }
        return sourceCenter;
    }

    @ModifyVariable(method={"playLinkParticles"}, at=@At(value="STORE"), name={"delta"})
    private static class_243 valkyrienskies$swapDelta(class_243 value, @Local(name={"sourceCentre"}) class_243 sourceCenter, @Local(name={"source"}) ILinkable.IRenderCentre source, @Local(name={"sink"}) ILinkable.IRenderCentre sink, @Local(argsOnly=true) class_1937 level) {
        class_243 sinkCenter = sink.renderCentre(source, true);
        Ship ship = ValkyrienSkies.getShipManagingBlock(level, (class_2374)sinkCenter);
        if (ship instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            sinkCenter = ValkyrienSkies.positionToWorld((Ship)ship2, sinkCenter);
        }
        return sinkCenter.method_1020(sourceCenter);
    }
}

