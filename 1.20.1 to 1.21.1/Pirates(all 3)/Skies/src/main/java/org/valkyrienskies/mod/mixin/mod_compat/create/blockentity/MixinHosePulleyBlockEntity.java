/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.fluids.hosePulley.HosePulleyBlockEntity
 *  com.simibubi.create.content.kinetics.base.KineticBlockEntity
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.simibubi.create.content.fluids.hosePulley.HosePulleyBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import java.util.Iterator;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={HosePulleyBlockEntity.class})
public class MixinHosePulleyBlockEntity
extends KineticBlockEntity {
    @Redirect(method={"lambda$new$0"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;below(I)Lnet/minecraft/core/BlockPos;"))
    private class_2338 lambdaBelow(class_2338 blockPos, int i2) {
        return this.valkyrienskies$worldAwareBelow(blockPos, i2);
    }

    @Redirect(method={"onSpeedChanged"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;below(I)Lnet/minecraft/core/BlockPos;"))
    private class_2338 onSpeedChangedBelow(class_2338 instance, int i2) {
        return this.valkyrienskies$worldAwareBelow(instance, i2);
    }

    @Redirect(method={"tick"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;below(I)Lnet/minecraft/core/BlockPos;"))
    private class_2338 tickBelow(class_2338 blockPos, int i2) {
        return this.valkyrienskies$worldAwareBelow(blockPos, i2);
    }

    @Redirect(method={"lazyTick"}, at=@At(value="INVOKE", target="Lnet/minecraft/core/BlockPos;below(I)Lnet/minecraft/core/BlockPos;"))
    private class_2338 lazyTickBelow(class_2338 blockPos, int i2) {
        return this.valkyrienskies$worldAwareBelow(blockPos, i2);
    }

    @Unique
    private class_2338 valkyrienskies$worldAwareBelow(class_2338 blockPos, int i2) {
        Ship fluidShip;
        class_2338 truePosition = blockPos.method_10087(i2);
        class_238 targetAABB = new class_238(truePosition);
        Ship hoseShip = VSGameUtilsKt.getShipManagingPos(this.field_11863, this.field_11867);
        if (hoseShip != null) {
            targetAABB = VSGameUtilsKt.transformAabbToWorld(this.field_11863, targetAABB);
        }
        Iterable<Ship> ships = VSGameUtilsKt.getShipsIntersecting(this.field_11863, targetAABB);
        boolean foundShipPos = false;
        Iterator<Ship> shipIt = ships.iterator();
        if (shipIt.hasNext() && (fluidShip = shipIt.next()) != null && fluidShip != hoseShip) {
            foundShipPos = true;
            targetAABB = VectorConversionsMCKt.toMinecraft(VectorConversionsMCKt.toJOML(targetAABB).transform(fluidShip.getWorldToShip()));
        }
        if (!(foundShipPos || this.field_11863.method_8320(truePosition).method_45474() && this.field_11863.method_8320(truePosition.method_10087(1)).method_45474())) {
            return truePosition;
        }
        return class_2338.method_49638((class_2374)targetAABB.method_1005());
    }

    public MixinHosePulleyBlockEntity(class_2591<?> typeIn, class_2338 pos, class_2680 state) {
        super(typeIn, pos, state);
    }
}

