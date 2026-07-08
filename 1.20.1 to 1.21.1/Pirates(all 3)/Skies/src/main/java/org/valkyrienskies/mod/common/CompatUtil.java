/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 */
package org.valkyrienskies.mod.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\t\u0010\nJ)\u0010\t\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\t\u0010\fJ'\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\u000eJ'\u0010\t\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\t\u0010\u000fJ'\u0010\t\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0010\u00a2\u0006\u0004\b\t\u0010\u0011J7\u0010\t\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\t\u0010\u0016J7\u0010\t\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0010\u00a2\u0006\u0004\b\t\u0010\u0017\u00a8\u0006\u001a"}, d2={"Lorg/valkyrienskies/mod/common/CompatUtil;", "", "Lnet/minecraft/class_1937;", "level", "Lorg/joml/Vector3dc;", "position", "Lorg/valkyrienskies/core/api/ships/Ship;", "targetShip", "Lorg/joml/Vector3d;", "toSameSpaceAs", "(Lnet/minecraft/class_1937;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/api/ships/Ship;)Lorg/joml/Vector3d;", "Lnet/minecraft/class_243;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_243;Lorg/valkyrienskies/core/api/ships/Ship;)Lnet/minecraft/class_243;", "target", "(Lnet/minecraft/class_1937;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/joml/Vector3d;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_243;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "Lnet/minecraft/class_2338;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_243;Lnet/minecraft/class_2338;)Lnet/minecraft/class_243;", "", "px", "py", "pz", "(Lnet/minecraft/class_1937;DDDLnet/minecraft/class_243;)Lnet/minecraft/class_243;", "(Lnet/minecraft/class_1937;DDDLnet/minecraft/class_2338;)Lnet/minecraft/class_243;", "<init>", "()V", "valkyrienskies-120"})
public final class CompatUtil {
    @NotNull
    public static final CompatUtil INSTANCE = new CompatUtil();

    private CompatUtil() {
    }

    @NotNull
    public final Vector3d toSameSpaceAs(@Nullable class_1937 level, @NotNull Vector3dc position, @Nullable Ship targetShip) {
        Vector3d result2;
        block2: {
            Object object;
            Ship ship;
            Intrinsics.checkNotNullParameter((Object)position, (String)"position");
            result2 = new Vector3d(position);
            class_1937 class_19372 = level;
            Ship ship2 = ship = class_19372 != null ? VSGameUtilsKt.getShipManagingPos(class_19372, (Vector3dc)result2) : null;
            if (Intrinsics.areEqual((Object)ship, (Object)targetShip)) break block2;
            Object object2 = ship;
            if (object2 != null && (object2 = object2.getShipToWorld()) != null) {
                object2.transformPosition(result2);
            }
            if ((object = targetShip) != null && (object = object.getWorldToShip()) != null) {
                object.transformPosition(result2);
            }
        }
        return result2;
    }

    @NotNull
    public final class_243 toSameSpaceAs(@Nullable class_1937 level, @NotNull class_243 position, @Nullable Ship targetShip) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        return VectorConversionsMCKt.toMinecraft(this.toSameSpaceAs(level, (Vector3dc)VectorConversionsMCKt.toJOML(position), targetShip));
    }

    @NotNull
    public final Vector3d toSameSpaceAs(@Nullable class_1937 level, @NotNull Vector3dc position, @NotNull Vector3dc target) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return this.toSameSpaceAs(level, position, VSGameUtilsKt.getShipManagingPos(level, target));
    }

    @NotNull
    public final class_243 toSameSpaceAs(@Nullable class_1937 level, @NotNull class_243 position, @NotNull class_243 target) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return VectorConversionsMCKt.toMinecraft(this.toSameSpaceAs(level, (Vector3dc)VectorConversionsMCKt.toJOML(position), VSGameUtilsKt.getShipManagingPos(level, (class_2374)target)));
    }

    @NotNull
    public final class_243 toSameSpaceAs(@Nullable class_1937 level, @NotNull class_243 position, @NotNull class_2338 target) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return VectorConversionsMCKt.toMinecraft(this.toSameSpaceAs(level, (Vector3dc)VectorConversionsMCKt.toJOML(position), VSGameUtilsKt.getShipManagingPos(level, target)));
    }

    @NotNull
    public final class_243 toSameSpaceAs(@Nullable class_1937 level, double px, double py, double pz, @NotNull class_243 target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return VectorConversionsMCKt.toMinecraft(this.toSameSpaceAs(level, (Vector3dc)new Vector3d(px, py, pz), VectorConversionsMCKt.toJOML(target)));
    }

    @NotNull
    public final class_243 toSameSpaceAs(@Nullable class_1937 level, double px, double py, double pz, @NotNull class_2338 target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return VectorConversionsMCKt.toMinecraft(this.toSameSpaceAs(level, (Vector3dc)new Vector3d(px, py, pz), VSGameUtilsKt.getShipManagingPos(level, target)));
    }
}

