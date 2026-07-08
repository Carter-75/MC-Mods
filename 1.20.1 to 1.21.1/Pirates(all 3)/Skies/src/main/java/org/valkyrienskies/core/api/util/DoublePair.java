/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004\u00a8\u0006\u0019"}, d2={"Lorg/valkyrienskies/core/api/util/DoublePair;", "", "", "component1", "()D", "component2", "first", "second", "copy", "(DD)Lorg/valkyrienskies/core/api/util/DoublePair;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getFirst", "getSecond", "<init>", "(DD)V", "api"})
public final class DoublePair {
    private final double first;
    private final double second;

    public DoublePair(double first2, double second2) {
        this.first = first2;
        this.second = second2;
    }

    public final double getFirst() {
        return this.first;
    }

    public final double getSecond() {
        return this.second;
    }

    public final double component1() {
        return this.first;
    }

    public final double component2() {
        return this.second;
    }

    @NotNull
    public final DoublePair copy(double first2, double second2) {
        return new DoublePair(first2, second2);
    }

    public static /* synthetic */ DoublePair copy$default(DoublePair doublePair, double d2, double d3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = doublePair.first;
        }
        if ((n2 & 2) != 0) {
            d3 = doublePair.second;
        }
        return doublePair.copy(d2, d3);
    }

    @NotNull
    public String toString() {
        return "DoublePair(first=" + this.first + ", second=" + this.second + ")";
    }

    public int hashCode() {
        int result2 = Double.hashCode(this.first);
        result2 = result2 * 31 + Double.hashCode(this.second);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DoublePair)) {
            return false;
        }
        DoublePair doublePair = (DoublePair)other;
        if (Double.compare(this.first, doublePair.first) != 0) {
            return false;
        }
        return Double.compare(this.second, doublePair.second) == 0;
    }
}

