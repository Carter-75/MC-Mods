/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.mod.common.command;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c2\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c2\u0003\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019\u00a8\u0006\u001c"}, d2={"Lorg/valkyrienskies/mod/common/command/RelativeValue;", "", "", "sourceAngleDegrees", "getRelativeValue", "(D)D", "component1", "()D", "", "component2", "()Z", "angleDegrees", "isRelative", "copy", "(DZ)Lorg/valkyrienskies/mod/common/command/RelativeValue;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "Z", "<init>", "(DZ)V", "valkyrienskies-120"})
public final class RelativeValue {
    private final double angleDegrees;
    private final boolean isRelative;

    public RelativeValue(double angleDegrees, boolean isRelative) {
        this.angleDegrees = angleDegrees;
        this.isRelative = isRelative;
    }

    public final double getRelativeValue(double sourceAngleDegrees) {
        return this.isRelative ? sourceAngleDegrees + this.angleDegrees : this.angleDegrees;
    }

    private final double component1() {
        return this.angleDegrees;
    }

    private final boolean component2() {
        return this.isRelative;
    }

    @NotNull
    public final RelativeValue copy(double angleDegrees, boolean isRelative) {
        return new RelativeValue(angleDegrees, isRelative);
    }

    public static /* synthetic */ RelativeValue copy$default(RelativeValue relativeValue, double d2, boolean bl, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = relativeValue.angleDegrees;
        }
        if ((n2 & 2) != 0) {
            bl = relativeValue.isRelative;
        }
        return relativeValue.copy(d2, bl);
    }

    @NotNull
    public String toString() {
        return "RelativeValue(angleDegrees=" + this.angleDegrees + ", isRelative=" + this.isRelative + ")";
    }

    public int hashCode() {
        int result2 = Double.hashCode(this.angleDegrees);
        result2 = result2 * 31 + Boolean.hashCode(this.isRelative);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RelativeValue)) {
            return false;
        }
        RelativeValue relativeValue = (RelativeValue)other;
        if (Double.compare(this.angleDegrees, relativeValue.angleDegrees) != 0) {
            return false;
        }
        return this.isRelative == relativeValue.isRelative;
    }
}

