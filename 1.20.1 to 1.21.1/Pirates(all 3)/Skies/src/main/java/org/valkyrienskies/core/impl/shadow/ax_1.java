/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import org.valkyrienskies.core.impl.shadow.av_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aX
 */
public final class ax_1 {
    public final ResolvedType a;
    private final av_2 b;

    protected ax_1(ResolvedType resolvedType, av_2 av_22) {
        this.a = resolvedType;
        this.b = av_22;
    }

    public final ResolvedType a() {
        return this.a;
    }

    private av_2 b() {
        return this.b;
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b == null ? 0 : this.b.hashCode());
    }

    public final boolean equals(Object other) {
        ax_1 ax_12;
        if (other == this) {
            return true;
        }
        if (!(other instanceof ax_1)) {
            return false;
        }
        ax_1 ax_13 = ax_12 = (ax_1)ax_12;
        return this.a.equals((Object)ax_13.a) && this.b == ax_12.b;
    }
}

