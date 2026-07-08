/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.AllBlocks
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  com.simibubi.create.content.redstone.contact.RedstoneContactBlock
 *  com.simibubi.create.foundation.block.WrenchableDirectionalBlock
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3499$class_3501
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.redstone.contact.RedstoneContactBlock;
import com.simibubi.create.foundation.block.WrenchableDirectionalBlock;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3499;
import net.minecraft.class_5819;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={RedstoneContactBlock.class})
public abstract class MixinRedstoneContactBlock
extends WrenchableDirectionalBlock {
    @Shadow
    @Final
    public static class_2746 POWERED;
    @Unique
    private static final double CHECK_BOUND = 0.125;
    @Unique
    private static final double INTERSECT_BOUND = 0.225;

    protected MixinRedstoneContactBlock() {
        super(null);
    }

    public void method_9615(class_2680 state, class_1937 world, class_2338 pos, class_2680 oldState, boolean isMoving) {
        super.method_9615(state, world, pos, oldState, isMoving);
        world.method_39279(pos, (class_2248)this, 2);
    }

    @Inject(method={"tick"}, at={@At(value="RETURN")})
    private void injectTick(class_2680 state, class_3218 world, class_2338 pos, class_5819 random, CallbackInfo ci) {
        if (!world.method_14196().method_8674(pos, (Object)this)) {
            world.method_39279(pos, (class_2248)this, 2);
        }
    }

    @Unique
    private static boolean hasContact(class_1936 world, class_2338 selfPos, class_2350 selfDir, Ship ship, class_2338 targetPos, Ship targetShip) {
        Vector3d checkPoint;
        int n2;
        int n3;
        Vector3d[] vector3dArray;
        Matrix4dc shipMat;
        class_2680 blockState = world.method_8320(targetPos);
        if (!MixinRedstoneContactBlock.isContact(blockState)) {
            return false;
        }
        class_2350 targetDir = (class_2350)blockState.method_11654((class_2769)field_10927);
        Vector3d[] checkPoints = MixinRedstoneContactBlock.makeCheckPoints(targetPos.method_10093(targetDir).method_46558(), targetDir);
        if (targetShip != null) {
            shipMat = targetShip.getShipToWorld();
            vector3dArray = checkPoints;
            n3 = vector3dArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                checkPoint = vector3dArray[n2];
                shipMat.transformPosition(checkPoint);
            }
        }
        if (ship != null) {
            shipMat = ship.getWorldToShip();
            vector3dArray = checkPoints;
            n3 = vector3dArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                checkPoint = vector3dArray[n2];
                shipMat.transformPosition(checkPoint);
            }
        }
        for (Vector3d checkPoint2 : checkPoints) {
            if (!selfPos.equals((Object)class_2338.method_49637((double)checkPoint2.x, (double)checkPoint2.y, (double)checkPoint2.z))) continue;
            return true;
        }
        return false;
    }

    @Inject(method={"hasValidContact"}, at={@At(value="RETURN")}, cancellable=true)
    private static void injectHasValidContact(class_1936 world, class_2338 pos, class_2350 direction, CallbackInfoReturnable<Boolean> cir) {
        class_2680 targetState;
        if (cir.getReturnValueZ()) {
            return;
        }
        class_1937 level = (class_1937)world;
        class_2338 detectPos = pos.method_10093(direction);
        class_2680 facingState = world.method_8320(detectPos);
        if (MixinRedstoneContactBlock.isContact(facingState)) {
            cir.setReturnValue((Object)(facingState.method_11654((class_2769)field_10927) == direction.method_10153() ? 1 : 0));
            return;
        }
        if (world.method_8320(pos).method_27852((class_2248)AllBlocks.ELEVATOR_CONTACT.get())) {
            return;
        }
        class_243 point = detectPos.method_46558();
        Vector3d[] checkPoints = MixinRedstoneContactBlock.makeCheckPoints(point, direction);
        Ship ship = VSGameUtilsKt.getShipManagingPos(level, pos);
        if (ship != null) {
            Matrix4dc shipMat = ship.getShipToWorld();
            for (Vector3d checkPoint : checkPoints) {
                shipMat.transformPosition(checkPoint);
            }
        }
        class_238 searchAABB = VSGameUtilsKt.transformAabbToWorld(level, new class_238(point.field_1352 - 0.225, point.field_1351 - 0.225, point.field_1350 - 0.225, point.field_1352 + 0.225, point.field_1351 + 0.225, point.field_1350 + 0.225));
        class_2338 foundBlock = null;
        boolean found = false;
        for (Vector3d checkPoint : checkPoints) {
            foundBlock = class_2338.method_49637((double)checkPoint.x, (double)checkPoint.y, (double)checkPoint.z);
            if (MixinRedstoneContactBlock.hasContact(world, pos, direction, ship, foundBlock, null)) {
                found = true;
                break;
            }
            class_243 checkPos = new class_243(checkPoint.x, checkPoint.y, checkPoint.z);
            for (AbstractContraptionEntity contraption : world.method_18467(AbstractContraptionEntity.class, searchAABB)) {
                class_243 localPos = contraption.toLocalVector(checkPos, 1.0f);
                class_3499.class_3501 info = (class_3499.class_3501)contraption.getContraption().getBlocks().get(class_2338.method_49638((class_2374)localPos));
                if (info == null || !MixinRedstoneContactBlock.isContact(info.comp_1342())) continue;
                class_2350 dir = (class_2350)info.comp_1342().method_11654((class_2769)field_10927);
                class_243 checkVec = contraption.toGlobalVector(localPos.method_43206(dir, 0.65), 1.0f);
                Vector3d checkP = new Vector3d(checkVec.field_1352, checkVec.field_1351, checkVec.field_1350);
                if (ship != null) {
                    ship.getWorldToShip().transformPosition(checkP);
                }
                if (!pos.equals((Object)class_2338.method_49637((double)checkP.x, (double)checkP.y, (double)checkP.z))) continue;
                foundBlock = null;
                found = true;
                break;
            }
            if (found) break;
        }
        if (!found) {
            Vector3d foundPos = new Vector3d();
            for (Ship targetShip : VSGameUtilsKt.getShipsIntersecting(level, searchAABB)) {
                for (Vector3d checkPoint : checkPoints) {
                    targetShip.getWorldToShip().transformPosition(checkPoint, foundPos);
                    if (targetShip != ship && MixinRedstoneContactBlock.hasContact(world, pos, direction, ship, foundBlock = class_2338.method_49637((double)foundPos.x, (double)foundPos.y, (double)foundPos.z), targetShip)) {
                        found = true;
                        break;
                    }
                    class_243 checkPos = new class_243(foundPos.x, foundPos.y, foundPos.z);
                    class_238 searchAABB2 = VectorConversionsMCKt.toMinecraft(VectorConversionsMCKt.toJOML(searchAABB).transform(targetShip.getWorldToShip()));
                    for (AbstractContraptionEntity contraption : world.method_18467(AbstractContraptionEntity.class, searchAABB2)) {
                        class_243 localPos = contraption.toLocalVector(checkPos, 1.0f);
                        class_3499.class_3501 info = (class_3499.class_3501)contraption.getContraption().getBlocks().get(class_2338.method_49638((class_2374)localPos));
                        if (info == null || !MixinRedstoneContactBlock.isContact(info.comp_1342())) continue;
                        class_2350 dir = (class_2350)info.comp_1342().method_11654((class_2769)field_10927);
                        class_243 checkVec = contraption.toGlobalVector(localPos.method_43206(dir, 0.65), 1.0f);
                        Vector3d checkP = new Vector3d(checkVec.field_1352, checkVec.field_1351, checkVec.field_1350);
                        if (targetShip != ship) {
                            targetShip.getShipToWorld().transformPosition(checkP);
                            if (ship != null) {
                                ship.getWorldToShip().transformPosition(checkP);
                            }
                        }
                        if (!pos.equals((Object)class_2338.method_49637((double)checkP.x, (double)checkP.y, (double)checkP.z))) continue;
                        foundBlock = null;
                        found = true;
                        break;
                    }
                    if (found) break;
                }
                if (!found) continue;
                break;
            }
        }
        if (!found) {
            return;
        }
        if (foundBlock != null && !((Boolean)(targetState = world.method_8320(foundBlock)).method_11654((class_2769)POWERED)).booleanValue()) {
            level.method_8501(foundBlock, (class_2680)targetState.method_11657((class_2769)POWERED, (Comparable)Boolean.valueOf(true)));
        }
        cir.setReturnValue((Object)true);
    }

    @Unique
    private static boolean isContact(class_2680 state) {
        return state.method_27852((class_2248)AllBlocks.REDSTONE_CONTACT.get()) || state.method_27852((class_2248)AllBlocks.ELEVATOR_CONTACT.get());
    }

    @Unique
    private static Vector3d[] makeCheckPoints(class_243 point, class_2350 direction) {
        Vector3d[] vector3dArray;
        switch (direction.method_10166()) {
            default: {
                throw new IncompatibleClassChangeError();
            }
            case field_11048: {
                Vector3d[] vector3dArray2 = new Vector3d[4];
                vector3dArray2[0] = new Vector3d(point.field_1352, point.field_1351 - 0.125, point.field_1350 - 0.125);
                vector3dArray2[1] = new Vector3d(point.field_1352, point.field_1351 - 0.125, point.field_1350 + 0.125);
                vector3dArray2[2] = new Vector3d(point.field_1352, point.field_1351 + 0.125, point.field_1350 - 0.125);
                vector3dArray = vector3dArray2;
                vector3dArray2[3] = new Vector3d(point.field_1352, point.field_1351 + 0.125, point.field_1350 + 0.125);
                break;
            }
            case field_11052: {
                Vector3d[] vector3dArray3 = new Vector3d[4];
                vector3dArray3[0] = new Vector3d(point.field_1352 - 0.125, point.field_1351, point.field_1350 - 0.125);
                vector3dArray3[1] = new Vector3d(point.field_1352 - 0.125, point.field_1351, point.field_1350 + 0.125);
                vector3dArray3[2] = new Vector3d(point.field_1352 + 0.125, point.field_1351, point.field_1350 - 0.125);
                vector3dArray = vector3dArray3;
                vector3dArray3[3] = new Vector3d(point.field_1352 + 0.125, point.field_1351, point.field_1350 + 0.125);
                break;
            }
            case field_11051: {
                Vector3d[] vector3dArray4 = new Vector3d[4];
                vector3dArray4[0] = new Vector3d(point.field_1352 - 0.125, point.field_1351 - 0.125, point.field_1350);
                vector3dArray4[1] = new Vector3d(point.field_1352 - 0.125, point.field_1351 + 0.125, point.field_1350);
                vector3dArray4[2] = new Vector3d(point.field_1352 + 0.125, point.field_1351 - 0.125, point.field_1350);
                vector3dArray = vector3dArray4;
                vector3dArray4[3] = new Vector3d(point.field_1352 + 0.125, point.field_1351 + 0.125, point.field_1350);
            }
        }
        return vector3dArray;
    }
}

