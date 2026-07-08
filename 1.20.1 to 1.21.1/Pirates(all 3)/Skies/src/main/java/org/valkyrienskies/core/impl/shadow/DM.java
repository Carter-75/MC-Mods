/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.ReplaceWith
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;

public final class DM
implements VsiBlockType {
    public final int a;

    public DM(int n2) {
        this.a = n2;
    }

    public final int a() {
        return this.a;
    }

    @Override
    @Deprecated(message="Internal detail, toInt() should be removed from the API", replaceWith=@ReplaceWith(expression="state", imports={}))
    public final int toInt() {
        return this.a;
    }

    private int b() {
        return this.a;
    }

    private static DM a(int n2) {
        return new DM(n2);
    }

    private static /* synthetic */ DM a(DM dM, int n2, int n3) {
        if ((n3 & 1) != 0) {
            n2 = dM.a;
        }
        int n4 = n2;
        return new DM(n4);
    }

    public final String toString() {
        return "BlockTypeImpl(state=" + this.a + ")";
    }

    public final int hashCode() {
        return Integer.hashCode(this.a);
    }

    public final boolean equals(Object other) {
        DM dM;
        if (this == other) {
            return true;
        }
        if (!(other instanceof DM)) {
            return false;
        }
        dM = dM;
        return this.a == dM.a;
    }
}

