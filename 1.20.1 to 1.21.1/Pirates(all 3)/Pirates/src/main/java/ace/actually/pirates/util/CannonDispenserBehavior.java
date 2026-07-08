/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1676
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2315
 *  net.minecraft.class_2338
 *  net.minecraft.class_2342
 *  net.minecraft.class_2347
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3419
 *  org.joml.Vector3dc
 *  org.valkyrienskies.core.api.ships.ServerShip
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 *  org.valkyrienskies.mod.common.util.VectorConversionsMCKt
 */
package ace.actually.pirates.util;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.sound.ModSounds;
import net.minecraft.class_1297;
import net.minecraft.class_1676;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2315;
import net.minecraft.class_2338;
import net.minecraft.class_2342;
import net.minecraft.class_2347;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3419;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

public abstract class CannonDispenserBehavior
extends class_2347 {
    public class_1799 method_10135(class_2342 pointer, class_1799 stack) {
        class_3218 world = pointer.method_10207();
        class_2374 position = class_2315.method_10010((class_2342)pointer);
        class_2350 direction = (class_2350)pointer.method_10120().method_11654((class_2769)class_2315.field_10918);
        class_1676 projectileEntity = this.createProjectile((class_1937)world, position, stack);
        projectileEntity.method_7485((double)direction.method_10148(), (double)((float)direction.method_10164() + 0.15f), (double)direction.method_10165(), this.getForce(), this.getVariation() / 2.0f);
        world.method_8649((class_1297)projectileEntity);
        ServerShip ship = VSGameUtilsKt.getShipManagingPos((class_3218)world, (class_2338)pointer.method_10122());
        if (ship != null) {
            projectileEntity.method_45319(VectorConversionsMCKt.toMinecraft((Vector3dc)ship.getVelocity()).method_1021(0.016666666666666666));
        }
        if (!world.field_9236) {
            int xmod = 0;
            int ymod = 0;
            int zmod = 0;
            switch (direction) {
                case field_11043: {
                    zmod = -1;
                    break;
                }
                case field_11034: {
                    xmod = 1;
                    break;
                }
                case field_11035: {
                    zmod = 1;
                    break;
                }
                case field_11039: {
                    xmod = -1;
                    break;
                }
                case field_11036: {
                    ymod = 1;
                    break;
                }
                case field_11033: {
                    ymod = -1;
                }
            }
            for (int i = 0; i < 40; ++i) {
                world.method_14199((class_2394)class_2398.field_11204, position.method_10216() + (double)xmod + 2.0 * world.field_9229.method_43058() - 1.0, position.method_10214() + (double)ymod + 2.0 * world.field_9229.method_43058() - 0.8, position.method_10215() + (double)zmod + 2.0 * world.field_9229.method_43058() - 1.0, 1, 0.0, 0.0, 0.0, 0.005);
            }
        }
        stack.method_7934(1);
        return stack;
    }

    protected void method_10136(class_2342 pointer) {
        pointer.method_10207().method_43128(null, (double)pointer.method_10122().method_10263(), (double)pointer.method_10122().method_10264(), (double)pointer.method_10122().method_10260(), ModSounds.CANNONBALL_SHOT, class_3419.field_15245, 1.0f, 1.0f);
    }

    protected abstract class_1676 createProjectile(class_1937 var1, class_2374 var2, class_1799 var3);

    protected float getVariation() {
        return 6.0f;
    }

    protected float getForce() {
        return Pirates.cannonRange;
    }
}

