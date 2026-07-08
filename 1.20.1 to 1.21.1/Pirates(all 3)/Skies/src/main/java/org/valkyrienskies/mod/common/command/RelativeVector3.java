/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.common.command;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.valkyrienskies.mod.common.command.RelativeValue;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u00a2\u0006\u0004\b+\u0010,J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013H\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0013H\u00c6\u0003\u00a2\u0006\u0004\b\u0017\u0010\u0015J.\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0013H\u00c6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!H\u00d6\u0001\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$H\u00d6\u0001\u00a2\u0006\u0004\b%\u0010&R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b)\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b*\u0010\u0015\u00a8\u0006-"}, d2={"Lorg/valkyrienskies/mod/common/command/RelativeVector3;", "", "", "sourcePitchDegrees", "sourceYawDegrees", "sourceRollDegrees", "Lorg/joml/Quaterniond;", "toEulerRotation", "(DDD)Lorg/joml/Quaterniond;", "mcEntityPitch", "mcEntityYaw", "toEulerRotationFromMCEntity", "(DD)Lorg/joml/Quaterniond;", "sourceX", "sourceY", "sourceZ", "Lorg/joml/Vector3d;", "toVector3d", "(DDD)Lorg/joml/Vector3d;", "Lorg/valkyrienskies/mod/common/command/RelativeValue;", "component1", "()Lorg/valkyrienskies/mod/common/command/RelativeValue;", "component2", "component3", "x", "y", "z", "copy", "(Lorg/valkyrienskies/mod/common/command/RelativeValue;Lorg/valkyrienskies/mod/common/command/RelativeValue;Lorg/valkyrienskies/mod/common/command/RelativeValue;)Lorg/valkyrienskies/mod/common/command/RelativeVector3;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/mod/common/command/RelativeValue;", "getX", "getY", "getZ", "<init>", "(Lorg/valkyrienskies/mod/common/command/RelativeValue;Lorg/valkyrienskies/mod/common/command/RelativeValue;Lorg/valkyrienskies/mod/common/command/RelativeValue;)V", "valkyrienskies-120"})
public final class RelativeVector3 {
    @NotNull
    private final RelativeValue x;
    @NotNull
    private final RelativeValue y;
    @NotNull
    private final RelativeValue z;

    public RelativeVector3(@NotNull RelativeValue x, @NotNull RelativeValue y, @NotNull RelativeValue z) {
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)z, (String)"z");
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @NotNull
    public final RelativeValue getX() {
        return this.x;
    }

    @NotNull
    public final RelativeValue getY() {
        return this.y;
    }

    @NotNull
    public final RelativeValue getZ() {
        return this.z;
    }

    @NotNull
    public final Quaterniond toEulerRotation(double sourcePitchDegrees, double sourceYawDegrees, double sourceRollDegrees) {
        Quaterniond quaterniond = new Quaterniond().rotateZYX(Math.toRadians(this.z.getRelativeValue(sourceRollDegrees)), Math.toRadians(this.y.getRelativeValue(sourceYawDegrees)), Math.toRadians(this.x.getRelativeValue(sourcePitchDegrees)));
        Intrinsics.checkNotNullExpressionValue((Object)quaterniond, (String)"rotateZYX(...)");
        return quaterniond;
    }

    @NotNull
    public final Quaterniond toEulerRotationFromMCEntity(double mcEntityPitch, double mcEntityYaw) {
        return this.toEulerRotation(mcEntityPitch, -mcEntityYaw, 0.0);
    }

    @NotNull
    public final Vector3d toVector3d(double sourceX, double sourceY, double sourceZ) {
        return new Vector3d(this.x.getRelativeValue(sourceX), this.y.getRelativeValue(sourceY), this.z.getRelativeValue(sourceZ));
    }

    @NotNull
    public final RelativeValue component1() {
        return this.x;
    }

    @NotNull
    public final RelativeValue component2() {
        return this.y;
    }

    @NotNull
    public final RelativeValue component3() {
        return this.z;
    }

    @NotNull
    public final RelativeVector3 copy(@NotNull RelativeValue x, @NotNull RelativeValue y, @NotNull RelativeValue z) {
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)z, (String)"z");
        return new RelativeVector3(x, y, z);
    }

    public static /* synthetic */ RelativeVector3 copy$default(RelativeVector3 relativeVector3, RelativeValue relativeValue, RelativeValue relativeValue2, RelativeValue relativeValue3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            relativeValue = relativeVector3.x;
        }
        if ((n2 & 2) != 0) {
            relativeValue2 = relativeVector3.y;
        }
        if ((n2 & 4) != 0) {
            relativeValue3 = relativeVector3.z;
        }
        return relativeVector3.copy(relativeValue, relativeValue2, relativeValue3);
    }

    @NotNull
    public String toString() {
        return "RelativeVector3(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
    }

    public int hashCode() {
        int result2 = this.x.hashCode();
        result2 = result2 * 31 + this.y.hashCode();
        result2 = result2 * 31 + this.z.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RelativeVector3)) {
            return false;
        }
        RelativeVector3 relativeVector3 = (RelativeVector3)other;
        if (!Intrinsics.areEqual((Object)this.x, (Object)relativeVector3.x)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.y, (Object)relativeVector3.y)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.z, (Object)relativeVector3.z);
    }
}

