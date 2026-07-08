/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3f;
import org.valkyrienskies.core.impl.shadow.id_0;

public final class HX {
    public final id_0 a;
    public final float b;
    public final float c;
    public final Vector3f d;
    public final int e;

    public HX(id_0 id_02, float f2, float f3, Vector3f vector3f, int n2) {
        Intrinsics.checkNotNullParameter((Object)id_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"");
        this.a = id_02;
        this.b = f2;
        this.c = f3;
        this.d = vector3f;
        this.e = n2;
    }

    public final id_0 a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public final float c() {
        return this.c;
    }

    public final Vector3f d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    private id_0 f() {
        return this.a;
    }

    private float g() {
        return this.b;
    }

    private float h() {
        return this.c;
    }

    private Vector3f i() {
        return this.d;
    }

    private int j() {
        return this.e;
    }

    private static HX a(id_0 id_02, float f2, float f3, Vector3f vector3f, int n2) {
        Intrinsics.checkNotNullParameter((Object)id_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3f, (String)"");
        return new HX(id_02, f2, f3, vector3f, n2);
    }

    private static /* synthetic */ HX a(HX object, id_0 id_02, float f2, float f3, Vector3f vector3f, int n2, int n3) {
        if ((n3 & 1) != 0) {
            id_02 = ((HX)object).a;
        }
        if ((n3 & 2) != 0) {
            f2 = ((HX)object).b;
        }
        if ((n3 & 4) != 0) {
            f3 = ((HX)object).c;
        }
        if ((n3 & 8) != 0) {
            vector3f = ((HX)object).d;
        }
        if ((n3 & 0x10) != 0) {
            n2 = ((HX)object).e;
        }
        float f4 = f2;
        int n4 = n2;
        Vector3f vector3f2 = vector3f;
        f2 = f3;
        float f5 = f4;
        object = id_02;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3f2, (String)"");
        return new HX((id_0)object, f5, f2, vector3f2, n4);
    }

    public final String toString() {
        return "Lod1LiquidBlockState(boundingBox=" + this.a + ", density=" + this.b + ", dragCoefficient=" + this.c + ", fluidVel=" + this.d + ", lod1LiquidBlockStateId=" + this.e + ')';
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + Float.hashCode(this.b);
        n2 = n2 * 31 + Float.hashCode(this.c);
        n2 = n2 * 31 + this.d.hashCode();
        n2 = n2 * 31 + Integer.hashCode(this.e);
        return n2;
    }

    public final boolean equals(Object other) {
        HX hX;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HX)) {
            return false;
        }
        hX = hX;
        if (!Intrinsics.areEqual((Object)this.a, (Object)hX.a)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)Float.valueOf(this.b), (Object)Float.valueOf(hX.b))) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)Float.valueOf(this.c), (Object)Float.valueOf(hX.c))) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.d, (Object)hX.d)) {
            return false;
        }
        return this.e == hX.e;
    }
}

