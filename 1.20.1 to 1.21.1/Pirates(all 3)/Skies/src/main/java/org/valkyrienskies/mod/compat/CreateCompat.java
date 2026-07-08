/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 */
package org.valkyrienskies.mod.compat;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2={"Lorg/valkyrienskies/mod/compat/CreateCompat;", "", "Lnet/minecraft/class_1297;", "entity", "", "isContraption", "(Lnet/minecraft/class_1297;)Z", "Lnet/minecraft/class_2382;", "pos", "Lnet/minecraft/class_243;", "getCenterOf", "(Lnet/minecraft/class_2382;)Lnet/minecraft/class_243;", "vec", "", "deg", "Lnet/minecraft/class_2350$class_2351;", "axis", "rotate", "(Lnet/minecraft/class_243;DLnet/minecraft/class_2350$class_2351;)Lnet/minecraft/class_243;", "", "p", "from", "to", "lerp", "(FLnet/minecraft/class_243;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "Ljava/lang/Class;", "contraptionClass", "Ljava/lang/Class;", "<init>", "()V", "valkyrienskies-120"})
public final class CreateCompat {
    @NotNull
    public static final CreateCompat INSTANCE;
    @Nullable
    private static final Class<?> contraptionClass;

    private CreateCompat() {
    }

    @JvmStatic
    public static final boolean isContraption(@NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Class<?> clazz = contraptionClass;
        return clazz != null ? clazz.isInstance(entity) : false;
    }

    @JvmStatic
    @NotNull
    public static final class_243 getCenterOf(@NotNull class_2382 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (Intrinsics.areEqual((Object)pos, (Object)class_2382.field_11176)) {
            return new class_243(0.5, 0.5, 0.5);
        }
        class_243 class_2432 = class_243.method_24954((class_2382)pos).method_1031(0.5, 0.5, 0.5);
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"add(...)");
        return class_2432;
    }

    @JvmStatic
    @NotNull
    public static final class_243 rotate(@NotNull class_243 vec, double deg, @NotNull class_2350.class_2351 axis) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        Intrinsics.checkNotNullParameter((Object)axis, (String)"axis");
        if (deg == 0.0) {
            return vec;
        }
        if (Intrinsics.areEqual((Object)vec, (Object)class_243.field_1353)) {
            return vec;
        }
        double angle = deg / (double)180.0f * Math.PI;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        double x = vec.field_1352;
        double y = vec.field_1351;
        double z = vec.field_1350;
        if (axis == class_2350.class_2351.field_11048) {
            return new class_243(x, y * cos - z * sin, z * cos + y * sin);
        }
        if (axis == class_2350.class_2351.field_11052) {
            return new class_243(x * cos + z * sin, y, z * cos - x * sin);
        }
        if (axis == class_2350.class_2351.field_11051) {
            return new class_243(x * cos - y * sin, y * cos + x * sin, z);
        }
        return vec;
    }

    @JvmStatic
    @NotNull
    public static final class_243 lerp(float p, @NotNull class_243 from, @NotNull class_243 to2) {
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to2, (String)"to");
        class_243 class_2432 = from.method_1019(to2.method_1020(from).method_1021((double)p));
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"add(...)");
        return class_2432;
    }

    static {
        Object object;
        INSTANCE = new CreateCompat();
        Object object2 = INSTANCE;
        try {
            CreateCompat $this$contraptionClass_u24lambda_u240 = object2;
            boolean bl = false;
            object = Result.constructor-impl(Class.forName("com.simibubi.create.content.contraptions.AbstractContraptionEntity"));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        contraptionClass = (Class)(Result.isFailure-impl((Object)object2) ? null : object2);
    }
}

