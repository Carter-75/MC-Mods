/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  org.joml.Vector3dc
 *  org.valkyrienskies.core.api.ships.LoadedServerShip
 *  org.valkyrienskies.eureka.ship.EurekaShipControl
 *  org.valkyrienskies.mod.api.SeatedControllingPlayer
 */
package ace.actually.pirates.util;

import ace.actually.pirates.blocks.entity.MotionInvokingBlockEntity;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.eureka.ship.EurekaShipControl;
import org.valkyrienskies.mod.api.SeatedControllingPlayer;

public class EurekaCompat {
    private static int flipflop = 1;

    public static void moveTowards(MotionInvokingBlockEntity be, SeatedControllingPlayer power, LoadedServerShip ship) {
        if (power == null) {
            return;
        }
        if (be.getTarget().length != 3) {
            return;
        }
        if (be.getTarget()[0] == 0 && be.getTarget()[1] == 0 && be.getTarget()[2] == 0) {
            power.setForwardImpulse(1.0f);
            power.setLeftImpulse(1.0f);
            return;
        }
        power.setForwardImpulse(1.0f);
        Vector3dc v3d = ship.getTransform().getPositionInWorld();
        EurekaShipControl shipControl = (EurekaShipControl)ship.getAttachment(EurekaShipControl.class);
        if (shipControl != null && shipControl.getBalloons() > 0) {
            if ((double)be.getTarget()[1] > v3d.y() - 1.0) {
                power.setUpImpulse(1.0f);
            } else if ((double)be.getTarget()[1] < v3d.y() + 1.0) {
                power.setUpImpulse(-1.0f);
            } else {
                power.setUpImpulse(0.0f);
            }
        }
        if (be.getLdx() == -1.0) {
            be.setLdx(EurekaCompat.vdis(be.getTarget()[0], v3d.x()));
            be.setLdz(EurekaCompat.vdis(be.getTarget()[2], v3d.z()));
        } else {
            double cdx = EurekaCompat.vdis(be.getTarget()[0], v3d.x());
            double cdz = EurekaCompat.vdis(be.getTarget()[2], v3d.z());
            if (cdx >= be.getLdx() || cdz >= be.getLdz()) {
                power.setLeftImpulse((float)flipflop);
            } else {
                power.setLeftImpulse(0.0f);
                flipflop = -flipflop;
            }
            be.setLdx(cdx);
            be.setLdz(cdz);
        }
    }

    public static void stopMotion(LoadedServerShip ship) {
        SeatedControllingPlayer seatedControllingPlayer = (SeatedControllingPlayer)ship.getAttachment(SeatedControllingPlayer.class);
        if (seatedControllingPlayer == null) {
            return;
        }
        seatedControllingPlayer.setLeftImpulse(0.0f);
        seatedControllingPlayer.setForwardImpulse(0.0f);
        seatedControllingPlayer.setCruise(false);
        seatedControllingPlayer.setUpImpulse(0.0f);
        ship.setAttachment(SeatedControllingPlayer.class, (Object)seatedControllingPlayer);
    }

    private static double vdis(double x, double xto) {
        return Math.abs(x - xto);
    }

    public static boolean checkHelm(class_1937 world, class_2338 pos) {
        return world.method_8320(pos.method_10084()).method_26204().method_9539().contains("helm");
    }
}

