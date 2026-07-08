/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1923
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 */
package org.valkyrienskies.mod.common.util;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Matrix4fc;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.Vector4f;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0006\u001a\u0019\u0010\u0003\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\b\u001a\u0019\u0010\u0003\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\t\u00a2\u0006\u0004\b\u0003\u0010\n\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\u0001\u00a2\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u0003\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0003\u0010\u0010\u001a\u0011\u0010\u0013\u001a\u00020\u0012*\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\u0011\u0010\u0016\u001a\u00020\u000b*\u00020\u0015\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u0019\u0010\u001b\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u0016\u001a\u00020\u000f*\u00020\u001d\u00a2\u0006\u0004\b\u0016\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u00020\u000e*\u00020\u000f\u00a2\u0006\u0004\b\u001f\u0010 \u001a\u0011\u0010\u0016\u001a\u00020\"*\u00020!\u00a2\u0006\u0004\b\u0016\u0010#\u001a\u0011\u0010\u001f\u001a\u00020$*\u00020\"\u00a2\u0006\u0004\b\u001f\u0010%\u001a\u0011\u0010\u001f\u001a\u00020\u0005*\u00020\u000b\u00a2\u0006\u0004\b\u001f\u0010&\u001a\u0019\u0010\u0003\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0003\u0010'\u001a\u0019\u0010\u0003\u001a\u00020$*\u00020$2\u0006\u0010(\u001a\u00020\"\u00a2\u0006\u0004\b\u0003\u0010)\u001a-\u0010-\u001a\n ,*\u0004\u0018\u00010\u00050\u0005*\u00020*2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010+\u001a\u00020\u0005H\u0007\u00a2\u0006\u0004\b-\u0010.\u001a-\u0010-\u001a\n ,*\u0004\u0018\u00010\u00050\u0005*\u00020*2\u0006\u00100\u001a\u00020/2\b\b\u0002\u0010+\u001a\u00020\u0005H\u0007\u00a2\u0006\u0004\b-\u00101\u001a\u0019\u00103\u001a\u000202*\u00020*2\u0006\u0010\u0002\u001a\u000202\u00a2\u0006\u0004\b3\u00104\u001a\u0019\u00105\u001a\u00020\u000b*\u00020*2\u0006\u0010\u0002\u001a\u00020\u000b\u00a2\u0006\u0004\b5\u00106\u001a!\u0010;\u001a\u000207*\u0002072\u0006\u00108\u001a\u00020*2\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<\u001a\u0019\u0010;\u001a\u000207*\u0002072\u0006\u00108\u001a\u00020*\u00a2\u0006\u0004\b;\u0010=\u001a\u0011\u0010\u001f\u001a\u00020\u0000*\u00020\u0001\u00a2\u0006\u0004\b\u001f\u0010>\u001a\u0011\u0010?\u001a\u00020\u0005*\u00020\u0001\u00a2\u0006\u0004\b?\u0010@\u001a\u0011\u0010A\u001a\u00020\u0007*\u00020\u0001\u00a2\u0006\u0004\bA\u0010B\u001a\u0011\u0010\u001f\u001a\u00020\u0005*\u00020\t\u00a2\u0006\u0004\b\u001f\u0010C\u001a\u0011\u0010E\u001a\u00020D*\u000209\u00a2\u0006\u0004\bE\u0010F\u00a8\u0006G"}, d2={"Lorg/joml/Vector3i;", "Lnet/minecraft/class_2382;", "v", "set", "(Lorg/joml/Vector3i;Lnet/minecraft/class_2382;)Lorg/joml/Vector3i;", "Lorg/joml/Vector3d;", "(Lorg/joml/Vector3d;Lnet/minecraft/class_2382;)Lorg/joml/Vector3d;", "Lorg/joml/Vector3f;", "(Lorg/joml/Vector3f;Lnet/minecraft/class_2382;)Lorg/joml/Vector3f;", "Lnet/minecraft/class_2374;", "(Lorg/joml/Vector3d;Lnet/minecraft/class_2374;)Lorg/joml/Vector3d;", "Lnet/minecraft/class_243;", "toDoubles", "(Lnet/minecraft/class_2382;)Lnet/minecraft/class_243;", "Lorg/joml/primitives/AABBd;", "Lnet/minecraft/class_238;", "(Lorg/joml/primitives/AABBd;Lnet/minecraft/class_238;)Lorg/joml/primitives/AABBd;", "Lorg/joml/Vector3ic;", "Lnet/minecraft/class_2338;", "toBlockPos", "(Lorg/joml/Vector3ic;)Lnet/minecraft/class_2338;", "Lorg/joml/Vector3dc;", "toMinecraft", "(Lorg/joml/Vector3dc;)Lnet/minecraft/class_243;", "Lorg/joml/Matrix4d;", "Lorg/joml/Matrix4fc;", "m", "mul", "(Lorg/joml/Matrix4d;Lorg/joml/Matrix4fc;)Lorg/joml/Matrix4d;", "Lorg/joml/primitives/AABBdc;", "(Lorg/joml/primitives/AABBdc;)Lnet/minecraft/class_238;", "toJOML", "(Lnet/minecraft/class_238;)Lorg/joml/primitives/AABBd;", "Lorg/joml/Vector2ic;", "Lnet/minecraft/class_1923;", "(Lorg/joml/Vector2ic;)Lnet/minecraft/class_1923;", "Lorg/joml/Vector2i;", "(Lnet/minecraft/class_1923;)Lorg/joml/Vector2i;", "(Lnet/minecraft/class_243;)Lorg/joml/Vector3d;", "(Lorg/joml/Vector3d;Lnet/minecraft/class_243;)Lorg/joml/Vector3d;", "pos", "(Lorg/joml/Vector2i;Lnet/minecraft/class_1923;)Lorg/joml/Vector2i;", "Lorg/joml/Matrix4dc;", "dest", "kotlin.jvm.PlatformType", "transformDirection", "(Lorg/joml/Matrix4dc;Lnet/minecraft/class_2382;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "Lnet/minecraft/class_2350;", "dir", "(Lorg/joml/Matrix4dc;Lnet/minecraft/class_2350;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "Lorg/joml/Vector4f;", "transform", "(Lorg/joml/Matrix4dc;Lorg/joml/Vector4f;)Lorg/joml/Vector4f;", "transformPosition", "(Lorg/joml/Matrix4dc;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "Lnet/minecraft/class_4587;", "modelTransform", "Lorg/joml/Quaterniondc;", "normalTransform", "multiply", "(Lnet/minecraft/class_4587;Lorg/joml/Matrix4dc;Lorg/joml/Quaterniondc;)Lnet/minecraft/class_4587;", "(Lnet/minecraft/class_4587;Lorg/joml/Matrix4dc;)Lnet/minecraft/class_4587;", "(Lnet/minecraft/class_2382;)Lorg/joml/Vector3i;", "toJOMLD", "(Lnet/minecraft/class_2382;)Lorg/joml/Vector3d;", "toJOMLF", "(Lnet/minecraft/class_2382;)Lorg/joml/Vector3f;", "(Lnet/minecraft/class_2374;)Lorg/joml/Vector3d;", "Lorg/joml/Quaternionf;", "toFloat", "(Lorg/joml/Quaterniondc;)Lorg/joml/Quaternionf;", "valkyrienskies-120"})
public final class VectorConversionsMCKt {
    @NotNull
    public static final Vector3i set(@NotNull Vector3i $this$set, @NotNull class_2382 v) {
        Vector3i vector3i;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3i it = vector3i = $this$set;
        boolean bl = false;
        $this$set.x = v.method_10263();
        $this$set.y = v.method_10264();
        $this$set.z = v.method_10260();
        return vector3i;
    }

    @NotNull
    public static final Vector3d set(@NotNull Vector3d $this$set, @NotNull class_2382 v) {
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3d it = vector3d = $this$set;
        boolean bl = false;
        $this$set.x = v.method_10263();
        $this$set.y = v.method_10264();
        $this$set.z = v.method_10260();
        return vector3d;
    }

    @NotNull
    public static final Vector3f set(@NotNull Vector3f $this$set, @NotNull class_2382 v) {
        Vector3f vector3f;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3f it = vector3f = $this$set;
        boolean bl = false;
        $this$set.x = v.method_10263();
        $this$set.y = v.method_10264();
        $this$set.z = v.method_10260();
        return vector3f;
    }

    @NotNull
    public static final Vector3d set(@NotNull Vector3d $this$set, @NotNull class_2374 v) {
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3d it = vector3d = $this$set;
        boolean bl = false;
        $this$set.x = v.method_10216();
        $this$set.y = v.method_10214();
        $this$set.z = v.method_10215();
        return vector3d;
    }

    @NotNull
    public static final class_243 toDoubles(@NotNull class_2382 $this$toDoubles) {
        Intrinsics.checkNotNullParameter((Object)$this$toDoubles, (String)"<this>");
        return new class_243((double)$this$toDoubles.method_10263(), (double)$this$toDoubles.method_10264(), (double)$this$toDoubles.method_10260());
    }

    @NotNull
    public static final AABBd set(@NotNull AABBd $this$set, @NotNull class_238 v) {
        AABBd aABBd;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        AABBd it = aABBd = $this$set;
        boolean bl = false;
        $this$set.minX = v.field_1323;
        $this$set.minY = v.field_1322;
        $this$set.minZ = v.field_1321;
        $this$set.maxX = v.field_1320;
        $this$set.maxY = v.field_1325;
        $this$set.maxZ = v.field_1324;
        return aABBd;
    }

    @NotNull
    public static final class_2338 toBlockPos(@NotNull Vector3ic $this$toBlockPos) {
        Intrinsics.checkNotNullParameter((Object)$this$toBlockPos, (String)"<this>");
        return new class_2338($this$toBlockPos.x(), $this$toBlockPos.y(), $this$toBlockPos.z());
    }

    @NotNull
    public static final class_243 toMinecraft(@NotNull Vector3dc $this$toMinecraft) {
        Intrinsics.checkNotNullParameter((Object)$this$toMinecraft, (String)"<this>");
        return new class_243($this$toMinecraft.x(), $this$toMinecraft.y(), $this$toMinecraft.z());
    }

    @NotNull
    public static final Matrix4d mul(@NotNull Matrix4d $this$mul, @NotNull Matrix4fc m2) {
        Intrinsics.checkNotNullParameter((Object)$this$mul, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)m2, (String)"m");
        Matrix4d matrix4d = $this$mul.mul(m2, $this$mul);
        Intrinsics.checkNotNullExpressionValue((Object)matrix4d, (String)"mul(...)");
        return matrix4d;
    }

    @NotNull
    public static final class_238 toMinecraft(@NotNull AABBdc $this$toMinecraft) {
        Intrinsics.checkNotNullParameter((Object)$this$toMinecraft, (String)"<this>");
        return new class_238($this$toMinecraft.minX(), $this$toMinecraft.minY(), $this$toMinecraft.minZ(), $this$toMinecraft.maxX(), $this$toMinecraft.maxY(), $this$toMinecraft.maxZ());
    }

    @NotNull
    public static final AABBd toJOML(@NotNull class_238 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return VectorConversionsMCKt.set(new AABBd(), $this$toJOML);
    }

    @NotNull
    public static final class_1923 toMinecraft(@NotNull Vector2ic $this$toMinecraft) {
        Intrinsics.checkNotNullParameter((Object)$this$toMinecraft, (String)"<this>");
        return new class_1923($this$toMinecraft.x(), $this$toMinecraft.y());
    }

    @NotNull
    public static final Vector2i toJOML(@NotNull class_1923 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return VectorConversionsMCKt.set(new Vector2i(), $this$toJOML);
    }

    @NotNull
    public static final Vector3d toJOML(@NotNull class_243 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return VectorConversionsMCKt.set(new Vector3d(), $this$toJOML);
    }

    @NotNull
    public static final Vector3d set(@NotNull Vector3d $this$set, @NotNull class_243 v) {
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3d it = vector3d = $this$set;
        boolean bl = false;
        $this$set.x = v.field_1352;
        $this$set.y = v.field_1351;
        $this$set.z = v.field_1350;
        return vector3d;
    }

    @NotNull
    public static final Vector2i set(@NotNull Vector2i $this$set, @NotNull class_1923 pos) {
        Vector2i vector2i;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Vector2i it = vector2i = $this$set;
        boolean bl = false;
        $this$set.x = pos.field_9181;
        $this$set.y = pos.field_9180;
        return vector2i;
    }

    @JvmOverloads
    public static final Vector3d transformDirection(@NotNull Matrix4dc $this$transformDirection, @NotNull class_2382 v, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)$this$transformDirection, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        return $this$transformDirection.transformDirection(dest.set(v.method_10263(), v.method_10264(), v.method_10260()));
    }

    public static /* synthetic */ Vector3d transformDirection$default(Matrix4dc matrix4dc, class_2382 class_23822, Vector3d vector3d, int n2, Object object) {
        if ((n2 & 2) != 0) {
            vector3d = new Vector3d();
        }
        return VectorConversionsMCKt.transformDirection(matrix4dc, class_23822, vector3d);
    }

    @JvmOverloads
    public static final Vector3d transformDirection(@NotNull Matrix4dc $this$transformDirection, @NotNull class_2350 dir, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)$this$transformDirection, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        class_2382 class_23822 = dir.method_10163();
        Intrinsics.checkNotNullExpressionValue((Object)class_23822, (String)"getNormal(...)");
        return VectorConversionsMCKt.transformDirection($this$transformDirection, class_23822, dest);
    }

    public static /* synthetic */ Vector3d transformDirection$default(Matrix4dc matrix4dc, class_2350 class_23502, Vector3d vector3d, int n2, Object object) {
        if ((n2 & 2) != 0) {
            vector3d = new Vector3d();
        }
        return VectorConversionsMCKt.transformDirection(matrix4dc, class_23502, vector3d);
    }

    @NotNull
    public static final Vector4f transform(@NotNull Matrix4dc $this$transform, @NotNull Vector4f v) {
        Vector4f vector4f;
        Intrinsics.checkNotNullParameter((Object)$this$transform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector4f it = vector4f = v;
        boolean bl = false;
        it.set((float)($this$transform.m00() * (double)v.x() + $this$transform.m01() * (double)v.y() + $this$transform.m02() * (double)v.z() + $this$transform.m03() * (double)v.w()), (float)($this$transform.m10() * (double)v.x() + $this$transform.m11() * (double)v.y() + $this$transform.m12() * (double)v.z() + $this$transform.m13() * (double)v.w()), (float)($this$transform.m20() * (double)v.x() + $this$transform.m21() * (double)v.y() + $this$transform.m22() * (double)v.z() + $this$transform.m23() * (double)v.w()), (float)($this$transform.m30() * (double)v.x() + $this$transform.m31() * (double)v.y() + $this$transform.m32() * (double)v.z() + $this$transform.m33() * (double)v.w()));
        return vector4f;
    }

    @NotNull
    public static final class_243 transformPosition(@NotNull Matrix4dc $this$transformPosition, @NotNull class_243 v) {
        Intrinsics.checkNotNullParameter((Object)$this$transformPosition, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Vector3d vector3d = $this$transformPosition.transformPosition(VectorConversionsMCKt.toJOML(v));
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformPosition(...)");
        return VectorConversionsMCKt.toMinecraft(vector3d);
    }

    @NotNull
    public static final class_4587 multiply(@NotNull class_4587 $this$multiply, @NotNull Matrix4dc modelTransform, @NotNull Quaterniondc normalTransform) {
        class_4587 class_45872;
        Intrinsics.checkNotNullParameter((Object)$this$multiply, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)modelTransform, (String)"modelTransform");
        Intrinsics.checkNotNullParameter((Object)normalTransform, (String)"normalTransform");
        class_4587 it = class_45872 = $this$multiply;
        boolean bl = false;
        class_4587.class_4665 last2 = $this$multiply.method_23760();
        Matrix4d newPose = new Matrix4d().set(last2.method_23761()).mul(modelTransform);
        Matrix3f newNormal = last2.method_23762().mul(new Matrix3f().set(normalTransform));
        last2.method_23761().set(newPose);
        last2.method_23762().set(newNormal);
        return class_45872;
    }

    @NotNull
    public static final class_4587 multiply(@NotNull class_4587 $this$multiply, @NotNull Matrix4dc modelTransform) {
        class_4587 class_45872;
        Intrinsics.checkNotNullParameter((Object)$this$multiply, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)modelTransform, (String)"modelTransform");
        class_4587 it = class_45872 = $this$multiply;
        boolean bl = false;
        class_4587.class_4665 last2 = $this$multiply.method_23760();
        Matrix4d newPose = new Matrix4d().set(last2.method_23761()).mul(modelTransform);
        last2.method_23761().set(newPose);
        return class_45872;
    }

    @NotNull
    public static final Vector3i toJOML(@NotNull class_2382 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return VectorConversionsMCKt.set(new Vector3i(), $this$toJOML);
    }

    @NotNull
    public static final Vector3d toJOMLD(@NotNull class_2382 $this$toJOMLD) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOMLD, (String)"<this>");
        return VectorConversionsMCKt.set(new Vector3d(), $this$toJOMLD);
    }

    @NotNull
    public static final Vector3f toJOMLF(@NotNull class_2382 $this$toJOMLF) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOMLF, (String)"<this>");
        return VectorConversionsMCKt.set(new Vector3f(), $this$toJOMLF);
    }

    @NotNull
    public static final Vector3d toJOML(@NotNull class_2374 $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        return VectorConversionsMCKt.set(new Vector3d(), $this$toJOML);
    }

    @NotNull
    public static final Quaternionf toFloat(@NotNull Quaterniondc $this$toFloat) {
        Intrinsics.checkNotNullParameter((Object)$this$toFloat, (String)"<this>");
        return new Quaternionf($this$toFloat.x(), $this$toFloat.y(), $this$toFloat.z(), $this$toFloat.w());
    }

    @JvmOverloads
    public static final Vector3d transformDirection(@NotNull Matrix4dc $this$transformDirection, @NotNull class_2382 v) {
        Intrinsics.checkNotNullParameter((Object)$this$transformDirection, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        return VectorConversionsMCKt.transformDirection$default($this$transformDirection, v, null, 2, null);
    }

    @JvmOverloads
    public static final Vector3d transformDirection(@NotNull Matrix4dc $this$transformDirection, @NotNull class_2350 dir) {
        Intrinsics.checkNotNullParameter((Object)$this$transformDirection, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        return VectorConversionsMCKt.transformDirection$default($this$transformDirection, dir, null, 2, null);
    }
}

