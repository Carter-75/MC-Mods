/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.GP;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hn
 */
public final class hn_0
implements GP {
    private Vector3dc a;

    public hn_0(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.a = vector3dc;
    }

    @Override
    public final Vector3dc a() {
        return this.a;
    }

    @Override
    public final void a(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.a = vector3dc;
    }

    @Override
    public final void close() {
    }

    private Vector3dc b() {
        hn_0 hn_02 = this;
        return hn_02.a;
    }

    private static hn_0 b(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        return new hn_0(vector3dc);
    }

    private static /* synthetic */ hn_0 a(hn_0 object, Vector3dc vector3dc, int n2) {
        if ((n2 & 1) != 0) {
            vector3dc = ((hn_0)object).a;
        }
        object = vector3dc;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        return new hn_0((Vector3dc)object);
    }

    public final String toString() {
        hn_0 hn_02 = this;
        return "DummyBoxShapeReference(lengths=" + hn_02.a + ')';
    }

    public final int hashCode() {
        hn_0 hn_02 = this;
        return hn_02.a.hashCode();
    }

    public final boolean equals(Object other) {
        hn_0 hn_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof hn_0)) {
            return false;
        }
        hn_02 = hn_02;
        hn_0 hn_03 = this;
        hn_0 hn_04 = hn_03;
        hn_04 = hn_02;
        return Intrinsics.areEqual((Object)hn_03.a, (Object)hn_04.a);
    }
}

