/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.math.MathKt
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2318
 *  net.minecraft.class_2338
 *  net.minecraft.class_2343
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2498
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3726
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 */
package org.valkyrienskies.mod.common.block;

import java.util.Optional;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2498;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.AxisAngle4d;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.internal.joints.VSJointPose;
import org.valkyrienskies.core.internal.joints.VSRevoluteJoint;
import org.valkyrienskies.core.internal.ships.VsiShip;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.api.VsApi;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.blockentity.TestHingeBlockEntity;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0014\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ5\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0017\u00a2\u0006\u0004\b\u0016\u0010\u0017J?\u0010 \u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0017\u00a2\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b%\u0010&J?\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+\"\n\b\u0000\u0010(*\u0004\u0018\u00010'2\u0006\u0010\u0010\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0016\u00a2\u0006\u0004\b,\u0010-R\u001c\u0010/\u001a\n .*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00101\u001a\n .*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00100R\u001c\u00102\u001a\n .*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u001c\u00103\u001a\n .*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00100R\u001c\u00104\u001a\n .*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00100R\u001c\u00105\u001a\n .*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00100\u00a8\u00068"}, d2={"Lorg/valkyrienskies/mod/common/block/TestHingeBlock;", "Lnet/minecraft/class_2318;", "Lnet/minecraft/class_2343;", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2680;", "builder", "", "createBlockStateDefinition", "(Lnet/minecraft/class_2689$class_2690;)V", "Lnet/minecraft/class_1750;", "ctx", "getStateForPlacement", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_1922;", "level", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_3726;", "context", "Lnet/minecraft/class_265;", "getShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;", "Lnet/minecraft/class_1937;", "Lnet/minecraft/class_1657;", "player", "Lnet/minecraft/class_1268;", "hand", "Lnet/minecraft/class_3965;", "blockHitResult", "Lnet/minecraft/class_1269;", "use", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_1657;Lnet/minecraft/class_1268;Lnet/minecraft/class_3965;)Lnet/minecraft/class_1269;", "blockPos", "blockState", "Lorg/valkyrienskies/mod/common/blockentity/TestHingeBlockEntity;", "newBlockEntity", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)Lorg/valkyrienskies/mod/common/blockentity/TestHingeBlockEntity;", "Lnet/minecraft/class_2586;", "T", "Lnet/minecraft/class_2591;", "type", "Lnet/minecraft/class_5558;", "getTicker", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2680;Lnet/minecraft/class_2591;)Lnet/minecraft/class_5558;", "kotlin.jvm.PlatformType", "EAST_AABB", "Lnet/minecraft/class_265;", "WEST_AABB", "SOUTH_AABB", "NORTH_AABB", "UP_AABB", "DOWN_AABB", "<init>", "()V", "valkyrienskies-120"})
public final class TestHingeBlock
extends class_2318
implements class_2343 {
    @NotNull
    public static final TestHingeBlock INSTANCE = new TestHingeBlock();
    private static final class_265 EAST_AABB = class_2318.method_9541((double)0.0, (double)0.0, (double)0.0, (double)8.0, (double)16.0, (double)16.0);
    private static final class_265 WEST_AABB = class_2318.method_9541((double)8.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
    private static final class_265 SOUTH_AABB = class_2318.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)8.0);
    private static final class_265 NORTH_AABB = class_2318.method_9541((double)0.0, (double)0.0, (double)8.0, (double)16.0, (double)16.0, (double)16.0);
    private static final class_265 UP_AABB = class_2318.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)8.0, (double)16.0);
    private static final class_265 DOWN_AABB = class_2318.method_9541((double)0.0, (double)8.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);

    private TestHingeBlock() {
        super(class_4970.class_2251.method_9637().method_9629(10.0f, 1200.0f).method_9626(class_2498.field_11533));
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        class_2769[] class_2769Array = new class_2769[]{class_2318.field_10927};
        builder.method_11667(class_2769Array);
    }

    @NotNull
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Object object = this.method_9564().method_11657((class_2769)class_2318.field_10927, (Comparable)ctx.method_7715().method_10153());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
        return (class_2680)object;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_265 method_9530(@NotNull class_2680 state, @Nullable class_1922 level, @Nullable class_2338 pos, @Nullable class_3726 context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        class_2350 class_23502 = (class_2350)state.method_11654((class_2769)class_2318.field_10927);
        switch (class_23502 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[class_23502.ordinal()]) {
            case 1: {
                class_265 class_2652 = DOWN_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"DOWN_AABB");
                return class_2652;
            }
            case 2: {
                class_265 class_2653 = NORTH_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2653, (String)"NORTH_AABB");
                return class_2653;
            }
            case 3: {
                class_265 class_2654 = SOUTH_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2654, (String)"SOUTH_AABB");
                return class_2654;
            }
            case 4: {
                class_265 class_2655 = WEST_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2655, (String)"WEST_AABB");
                return class_2655;
            }
            case 5: {
                class_265 class_2656 = EAST_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2656, (String)"EAST_AABB");
                return class_2656;
            }
            case 6: {
                class_265 class_2657 = UP_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2657, (String)"UP_AABB");
                return class_2657;
            }
        }
        class_265 class_2658 = UP_AABB;
        Intrinsics.checkNotNullExpressionValue((Object)class_2658, (String)"UP_AABB");
        return class_2658;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_1269 method_9534(@NotNull class_2680 state, @NotNull class_1937 level, @NotNull class_2338 pos, @NotNull class_1657 player, @NotNull class_1268 hand, @NotNull class_3965 blockHitResult) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)blockHitResult, (String)"blockHitResult");
        if (level.field_9236) {
            return class_1269.field_5812;
        }
        Optional blockEntity = level.method_35230(pos, ValkyrienSkiesMod.INSTANCE.getTEST_HINGE_BLOCK_ENTITY_TYPE());
        if (blockEntity.isPresent() && ((TestHingeBlockEntity)((Object)blockEntity.get())).getOtherHingePos() == null) {
            Ship shipThisIsIn = VSGameUtilsKt.getShipManagingPos(level, pos);
            VsiServerShipWorld vsiServerShipWorld = VSGameUtilsKt.getShipObjectWorld((class_3218)level);
            class_2338 class_23382 = pos.method_10069(0, 1, 0);
            Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"offset(...)");
            ServerShip ship = vsiServerShipWorld.createNewShipAtBlock(VectorConversionsMCKt.toJOML((class_2382)class_23382), false, 1.0, VSGameUtilsKt.getDimensionId(level));
            class_2338 shipCenterPos = new class_2338(MathKt.roundToInt((double)(ship.getTransform().getPositionInShip().x() - 0.5)), MathKt.roundToInt((double)(ship.getTransform().getPositionInShip().y() - 0.5)), MathKt.roundToInt((double)(ship.getTransform().getPositionInShip().z() - 0.5)));
            double extraHeight = 0.0;
            Quaterniondc rotationQuaternion = null;
            class_2350 class_23502 = (class_2350)state.method_11654((class_2769)class_2318.field_10927);
            switch (class_23502 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[class_23502.ordinal()]) {
                case 1: {
                    rotationQuaternion = new Quaterniond(new AxisAngle4d(Math.PI, new Vector3d(1.0, 0.0, 0.0)));
                    break;
                }
                case 2: {
                    rotationQuaternion = new Quaterniond(new AxisAngle4d(Math.PI, new Vector3d(0.0, 1.0, 0.0))).mul(new Quaterniond(new AxisAngle4d(1.5707963267948966, new Vector3d(1.0, 0.0, 0.0)))).normalize();
                    break;
                }
                case 5: {
                    rotationQuaternion = new Quaterniond(new AxisAngle4d(1.5707963267948966, new Vector3d(0.0, 1.0, 0.0))).mul(new Quaterniond(new AxisAngle4d(1.5707963267948966, new Vector3d(1.0, 0.0, 0.0)))).normalize();
                    break;
                }
                case 3: {
                    rotationQuaternion = new Quaterniond(new AxisAngle4d(1.5707963267948966, new Vector3d(1.0, 0.0, 0.0))).normalize();
                    break;
                }
                case 4: {
                    rotationQuaternion = new Quaterniond(new AxisAngle4d(4.71238898038469, new Vector3d(0.0, 1.0, 0.0))).mul(new Quaterniond(new AxisAngle4d(1.5707963267948966, new Vector3d(1.0, 0.0, 0.0)))).normalize();
                    break;
                }
                case 6: {
                    rotationQuaternion = new Quaterniond();
                    break;
                }
                default: {
                    rotationQuaternion = new Quaterniond();
                }
            }
            Vector3d vector3d = ((Quaterniond)rotationQuaternion).transform(new Vector3d(0.0, 0.5 + extraHeight, 0.0));
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transform(...)");
            Vector3dc attachmentOffset0 = vector3d;
            Vector3d vector3d2 = ((Quaterniond)rotationQuaternion).transform(new Vector3d(0.0, -0.5, 0.0));
            Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"transform(...)");
            Vector3dc attachmentOffset1 = vector3d2;
            Vector3d vector3d3 = new Vector3d((double)pos.method_10263() + 0.5, (double)pos.method_10264() + 0.5, (double)pos.method_10260() + 0.5).add(attachmentOffset0);
            Intrinsics.checkNotNullExpressionValue((Object)vector3d3, (String)"add(...)");
            Vector3dc attachmentLocalPos0 = vector3d3;
            Vector3d vector3d4 = new Vector3d((double)shipCenterPos.method_10263() + 0.5, (double)shipCenterPos.method_10264() + 0.5, (double)shipCenterPos.method_10260() + 0.5).add(attachmentOffset1);
            Intrinsics.checkNotNullExpressionValue((Object)vector3d4, (String)"add(...)");
            Vector3dc attachmentLocalPos1 = vector3d4;
            if (shipThisIsIn != null) {
                newPos = shipThisIsIn.getTransform().getShipToWorld().transformPosition(attachmentLocalPos0, new Vector3d());
                newPos.sub(shipThisIsIn.getTransform().getShipToWorldRotation().transform(attachmentOffset1, new Vector3d()));
                VsApi vsApi = ValkyrienSkies.api();
                Vector3dc vector3dc = shipThisIsIn.getVelocity();
                Vector3dc vector3dc2 = shipThisIsIn.getAngularVelocity();
                Intrinsics.checkNotNull((Object)newPos);
                newKinematics = vsApi.newBodyKinematics(vector3dc, vector3dc2, newPos, shipThisIsIn.getTransform().getShipToWorldRotation(), ship.getTransform().getShipToWorldScaling(), ship.getTransform().getPositionInShip());
                Intrinsics.checkNotNull((Object)ship, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.ships.VsiShip");
                ((VsiShip)((Object)ship)).unsafeSetKinematics(newKinematics);
            } else {
                newPos = new Vector3d(attachmentLocalPos0);
                newPos.sub(attachmentOffset1);
                newKinematics = ValkyrienSkies.api().newBodyKinematics(ship.getVelocity(), ship.getAngularVelocity(), newPos, ship.getTransform().getShipToWorldRotation(), ship.getTransform().getShipToWorldScaling(), ship.getTransform().getPositionInShip());
                Intrinsics.checkNotNull((Object)ship, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.ships.VsiShip");
                ((VsiShip)((Object)ship)).unsafeSetKinematics(newKinematics);
            }
            level.method_8501(shipCenterPos, class_2246.field_10085.method_9564());
            ((TestHingeBlockEntity)((Object)blockEntity.get())).setOtherHingePos(shipCenterPos);
            Ship ship2 = shipThisIsIn;
            Long shipId0 = ship2 != null ? Long.valueOf(ship2.getId()) : null;
            long shipId1 = ship.getId();
            Quaterniond hingeOrientation = ((Quaterniond)rotationQuaternion).mul(new Quaterniond(new AxisAngle4d(Math.toRadians(90.0), 0.0, 0.0, 1.0)), new Quaterniond()).normalize();
            double compliance = 1.0E-10;
            Intrinsics.checkNotNull((Object)hingeOrientation);
            VSRevoluteJoint hingeConstraint = new VSRevoluteJoint(shipId0, new VSJointPose(attachmentLocalPos0, hingeOrientation), shipId1, new VSJointPose(attachmentLocalPos1, hingeOrientation), null, compliance, null, null, null, null, true, 960, null);
            ValkyrienSkiesMod.getOrCreateGTPA(VSGameUtilsKt.getDimensionId(level)).addJoint(hingeConstraint, 4, arg_0 -> TestHingeBlock.use$lambda$0(blockEntity, arg_0));
        }
        return class_1269.field_21466;
    }

    @NotNull
    public TestHingeBlockEntity newBlockEntity(@NotNull class_2338 blockPos, @NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        return new TestHingeBlockEntity(blockPos, blockState);
    }

    @NotNull
    public <T extends class_2586> class_5558<T> method_31645(@NotNull class_1937 level, @NotNull class_2680 state, @NotNull class_2591<T> type) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        return (arg_0, arg_1, arg_2, arg_3) -> TestHingeBlock.getTicker$lambda$1(level, arg_0, arg_1, arg_2, arg_3);
    }

    private static final void use$lambda$0(Optional $blockEntity, Integer t) {
        Intrinsics.checkNotNullParameter((Object)t, (String)"t");
        ((TestHingeBlockEntity)((Object)$blockEntity.get())).setConstraintId(t);
    }

    private static final void getTicker$lambda$1(class_1937 $level, class_1937 class_19372, class_2338 class_23382, class_2680 class_26802, class_2586 blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$level, (String)"$level");
        if ($level.field_9236) {
            return;
        }
        if (blockEntity instanceof TestHingeBlockEntity) {
            ((TestHingeBlockEntity)blockEntity).tick();
        }
    }

    static {
        INSTANCE.method_9590((class_2680)((class_2680)TestHingeBlock.INSTANCE.field_10647.method_11664()).method_11657((class_2769)class_2318.field_10927, (Comparable)class_2350.field_11036));
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[class_2350.values().length];
            try {
                nArray[class_2350.field_11033.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11043.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11035.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11039.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11034.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11036.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

