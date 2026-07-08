/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2818
 *  net.minecraft.class_3218
 *  net.minecraft.class_4076
 *  net.minecraft.class_5712
 *  net.minecraft.class_5712$class_7397
 *  net.minecraft.class_5712$class_7447
 *  net.minecraft.class_5713$class_7721
 *  net.minecraft.class_5714$class_7720
 *  net.minecraft.class_7719
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package org.valkyrienskies.mod.mixin.feature.sculk;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2818;
import net.minecraft.class_3218;
import net.minecraft.class_4076;
import net.minecraft.class_5712;
import net.minecraft.class_5713;
import net.minecraft.class_5714;
import net.minecraft.class_7719;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_7719.class})
public abstract class MixinGameEventDispatcher {
    @Shadow
    class_3218 field_40352;

    @Shadow
    abstract void method_45491(List<class_5712.class_7447> var1);

    @WrapMethod(method={"post"})
    private void visitShipListeners(class_5712 gameEvent, class_243 vec3, class_5712.class_7397 context, Operation original) {
        int i2 = gameEvent.method_32941();
        Ship sourceShip = VSGameUtilsKt.getShipManagingPos((class_1937)this.field_40352, (class_2374)vec3);
        if (sourceShip != null) {
            vec3 = VSGameUtilsKt.toWorldCoordinates(sourceShip, vec3);
        }
        class_243 finalVec = vec3;
        original.call(new Object[]{gameEvent, finalVec, context});
        class_2338 blockPos = class_2338.method_49638((class_2374)vec3);
        AABBd sourceAABB = new AABBd(blockPos.method_10263() - i2, blockPos.method_10264() - i2, blockPos.method_10260() - i2, blockPos.method_10263() + i2, blockPos.method_10264() + i2, blockPos.method_10260() + i2);
        VSGameUtilsKt.getAllShips((class_1937)this.field_40352).stream().filter(ship -> ship.getWorldAABB().intersectsSphere(finalVec.field_1352, finalVec.field_1351, finalVec.field_1350, Math.pow(i2, 2.0))).forEach(ship -> {
            AABBic temp = ship.getShipAABB();
            if (temp == null) {
                return;
            }
            AABBd shipAABB = new AABBd(temp.minX(), temp.minY(), temp.minZ(), temp.maxX(), temp.maxY(), temp.maxZ());
            AABBd intersection = shipAABB.intersection(sourceAABB.transform(ship.getWorldToShip(), new AABBd()), new AABBd());
            class_2338 minB = class_2338.method_49637((double)intersection.minX, (double)intersection.minY, (double)intersection.minZ);
            class_2338 maxB = class_2338.method_49637((double)intersection.maxX, (double)intersection.maxY, (double)intersection.maxZ);
            int j2 = class_4076.method_18675((int)minB.method_10263());
            int k2 = class_4076.method_18675((int)minB.method_10264());
            int l2 = class_4076.method_18675((int)minB.method_10260());
            int m2 = class_4076.method_18675((int)maxB.method_10263());
            int n2 = class_4076.method_18675((int)maxB.method_10264());
            int o = class_4076.method_18675((int)maxB.method_10260());
            ArrayList<class_5712.class_7447> list = new ArrayList<class_5712.class_7447>();
            class_5713.class_7721 listenerVisitor = (gameEventListener, vec32) -> {
                if (gameEventListener.method_45472() == class_5714.class_7720.field_40354) {
                    list.add(new class_5712.class_7447(gameEvent, finalVec, context, gameEventListener, vec32));
                } else {
                    gameEventListener.method_32947(this.field_40352, gameEvent, context, finalVec);
                }
            };
            boolean bl = false;
            for (int p = j2; p <= m2; ++p) {
                for (int q = l2; q <= o; ++q) {
                    class_2818 chunkAccess = this.field_40352.method_14178().method_21730(p, q);
                    if (chunkAccess == null) continue;
                    for (int r = k2; r <= n2; ++r) {
                        bl |= chunkAccess.method_32914(r).method_32943(gameEvent, finalVec, context, listenerVisitor);
                    }
                }
            }
            if (!list.isEmpty()) {
                this.method_45491(list);
            }
        });
    }
}

