/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ships.ShipData;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ey
 */
public final class ey_0 {
    private final Collection<ShipData> a;
    private final Collection<ShipData> b;

    private ey_0(Collection<ShipData> collection, Collection<ShipData> collection2) {
        Intrinsics.checkNotNullParameter(collection, (String)"");
        Intrinsics.checkNotNullParameter(collection2, (String)"");
        this.a = collection;
        this.b = collection2;
    }

    private Collection<ShipData> a() {
        return this.a;
    }

    private Collection<ShipData> b() {
        return this.b;
    }

    private Collection<ShipData> c() {
        return this.a;
    }

    private Collection<ShipData> d() {
        return this.b;
    }

    private static ey_0 a(Collection<ShipData> collection, Collection<ShipData> collection2) {
        Intrinsics.checkNotNullParameter(collection, (String)"");
        Intrinsics.checkNotNullParameter(collection2, (String)"");
        return new ey_0(collection, collection2);
    }

    private static /* synthetic */ ey_0 a(ey_0 object, Collection collection, Collection collection2, int n2) {
        if ((n2 & 1) != 0) {
            collection = ((ey_0)object).a;
        }
        if ((n2 & 2) != 0) {
            collection2 = ((ey_0)object).b;
        }
        Collection<ShipData> collection3 = collection;
        collection = collection2;
        object = collection3;
        Intrinsics.checkNotNullParameter(collection3, (String)"");
        Intrinsics.checkNotNullParameter(collection, (String)"");
        return new ey_0((Collection<ShipData>)object, collection);
    }

    public final String toString() {
        return "ShipLoadInfo(shipsToLoad=" + this.a + ", shipsToUnload=" + this.b + ")";
    }

    public final int hashCode() {
        int n2 = ((Object)this.a).hashCode();
        n2 = n2 * 31 + ((Object)this.b).hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        ey_0 ey_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ey_0)) {
            return false;
        }
        ey_02 = ey_02;
        if (!Intrinsics.areEqual(this.a, ey_02.a)) {
            return false;
        }
        return Intrinsics.areEqual(this.b, ey_02.b);
    }
}

