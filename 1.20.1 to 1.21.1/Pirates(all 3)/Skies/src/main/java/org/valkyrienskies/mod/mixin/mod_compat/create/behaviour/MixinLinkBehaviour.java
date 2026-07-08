/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.redstone.link.LinkBehaviour
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.behaviour;

import com.simibubi.create.content.redstone.link.LinkBehaviour;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={LinkBehaviour.class})
public class MixinLinkBehaviour {
    @Redirect(method={"testHit"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;subtract(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;"))
    public class_243 redirectSubtract(class_243 instance, class_243 vec) {
        class_1937 level = ((LinkBehaviour)this).getWorld();
        class_243 pos1 = instance;
        class_243 pos2 = vec;
        if (level != null) {
            Ship ship1 = VSGameUtilsKt.getShipManagingPos(level, pos1.field_1352, pos1.field_1351, pos1.field_1350);
            Ship ship2 = VSGameUtilsKt.getShipManagingPos(level, pos2.field_1352, pos2.field_1351, pos2.field_1350);
            if (ship1 != null && ship2 == null) {
                ShipTransform shipTransform;
                if (ship1 instanceof ClientShip) {
                    ClientShip cs = (ClientShip)ship1;
                    shipTransform = cs.getRenderTransform();
                } else {
                    shipTransform = ship1.getTransform();
                }
                ShipTransform transform2 = shipTransform;
                pos2 = VectorConversionsMCKt.toMinecraft(transform2.getToModel().transformPosition(VectorConversionsMCKt.toJOML(pos2)));
            } else if (ship1 == null && ship2 != null) {
                ShipTransform shipTransform;
                if (ship2 instanceof ClientShip) {
                    ClientShip cs = (ClientShip)ship2;
                    shipTransform = cs.getRenderTransform();
                } else {
                    shipTransform = ship2.getTransform();
                }
                ShipTransform transform3 = shipTransform;
                pos1 = VectorConversionsMCKt.toMinecraft(transform3.getToModel().transformPosition(VectorConversionsMCKt.toJOML(pos1)));
            }
        }
        return pos1.method_1020(pos2);
    }
}

