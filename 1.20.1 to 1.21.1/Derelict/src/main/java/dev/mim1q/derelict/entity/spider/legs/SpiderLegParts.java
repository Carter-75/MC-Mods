/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.class_630
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.spider.legs;

import dev.mim1q.derelict.entity.spider.legs.SpiderLegIKSolver;
import dev.mim1q.derelict.util.MathUtilsKt;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.class_630;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ%\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017\u00a8\u0006\u0019"}, d2={"Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "", "Lnet/minecraft/class_630;", "joint", "upper", "lower", "", "right", "<init>", "(Lnet/minecraft/class_630;Lnet/minecraft/class_630;Lnet/minecraft/class_630;Z)V", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegIKSolver;", "ik", "", "yaw", "deltaTime", "", "applyIk", "(Ldev/mim1q/derelict/entity/spider/legs/SpiderLegIKSolver;FF)V", "Lnet/minecraft/class_630;", "getJoint", "()Lnet/minecraft/class_630;", "getUpper", "getLower", "Z", "Companion", "derelict"})
public final class SpiderLegParts {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final class_630 joint;
    @NotNull
    private final class_630 upper;
    @NotNull
    private final class_630 lower;
    private final boolean right;

    public SpiderLegParts(@NotNull class_630 joint, @NotNull class_630 upper, @NotNull class_630 lower, boolean right) {
        Intrinsics.checkNotNullParameter((Object)joint, (String)"joint");
        Intrinsics.checkNotNullParameter((Object)upper, (String)"upper");
        Intrinsics.checkNotNullParameter((Object)lower, (String)"lower");
        this.joint = joint;
        this.upper = upper;
        this.lower = lower;
        this.right = right;
    }

    @NotNull
    public final class_630 getJoint() {
        return this.joint;
    }

    @NotNull
    public final class_630 getUpper() {
        return this.upper;
    }

    @NotNull
    public final class_630 getLower() {
        return this.lower;
    }

    public final void applyIk(@NotNull SpiderLegIKSolver ik, float yaw, float deltaTime) {
        Intrinsics.checkNotNullParameter((Object)ik, (String)"ik");
        if (this.right) {
            this.joint.field_3675 = RangesKt.coerceIn((float)MathUtilsKt.wrapRadians(ik.getYaw(deltaTime) - MathExtensionsKt.radians(yaw) + (float)Math.PI), (float)MathExtensionsKt.radians(-80.0f), (float)MathExtensionsKt.radians(80.0f));
            this.upper.field_3674 = ik.getUpperRoll(deltaTime);
            this.lower.field_3674 = ik.getLowerRoll(deltaTime);
        } else {
            this.joint.field_3675 = RangesKt.coerceIn((float)MathUtilsKt.wrapRadians(ik.getYaw(deltaTime) - MathExtensionsKt.radians(yaw)), (float)MathExtensionsKt.radians(-80.0f), (float)MathExtensionsKt.radians(80.0f));
            this.upper.field_3674 = -ik.getUpperRoll(deltaTime);
            this.lower.field_3674 = -ik.getLowerRoll(deltaTime);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_630;", "root", "", "index", "", "right", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "create", "(Lnet/minecraft/class_630;IZ)Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "", "createArray", "(Lnet/minecraft/class_630;)[Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SpiderLegParts create(@NotNull class_630 root, int index, boolean right) {
            Intrinsics.checkNotNullParameter((Object)root, (String)"root");
            String side = right ? "right" : "left";
            class_630 joint = root.method_32086(side + "_leg_joint" + index);
            class_630 upper = joint.method_32086(side + "_leg" + index);
            class_630 lower = upper.method_32086(side + "_leg_front" + index);
            Intrinsics.checkNotNull((Object)joint);
            Intrinsics.checkNotNull((Object)upper);
            Intrinsics.checkNotNull((Object)lower);
            return new SpiderLegParts(joint, upper, lower, right);
        }

        @NotNull
        public final SpiderLegParts[] createArray(@NotNull class_630 root) {
            Intrinsics.checkNotNullParameter((Object)root, (String)"root");
            SpiderLegParts[] spiderLegPartsArray = new SpiderLegParts[]{this.create(root, 0, false), this.create(root, 1, false), this.create(root, 2, false), this.create(root, 3, false), this.create(root, 0, true), this.create(root, 1, true), this.create(root, 2, true), this.create(root, 3, true)};
            return spiderLegPartsArray;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

