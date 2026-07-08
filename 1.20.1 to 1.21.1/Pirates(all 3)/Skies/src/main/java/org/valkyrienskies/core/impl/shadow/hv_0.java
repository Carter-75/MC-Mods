/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix3d;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GX;
import org.valkyrienskies.core.impl.shadow.GY;
import org.valkyrienskies.core.impl.shadow.HI;
import org.valkyrienskies.core.impl.shadow.HS;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.core.impl.shadow.hc_0;
import org.valkyrienskies.core.impl.shadow.hd_0;
import org.valkyrienskies.core.impl.shadow.he_0;
import org.valkyrienskies.core.impl.shadow.ht_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hv
 */
public final class hv_0
implements ha_0 {
    private final Map<Integer, ht_0<?>> b = new HashMap();
    private int c;
    private boolean d;

    @Override
    public final List<ha_0.b> a(Vector3dc vector3dc, double d2) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        return CollectionsKt.emptyList();
    }

    @Override
    public final void h() {
    }

    @Override
    public final <T extends GS> GY<T> a(T object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        int n2 = this.c;
        this.c = n2 + 1;
        int n3 = n2;
        ht_0<T> ht_02 = new ht_0<T>(n3, this, hc_0.a.a(), new GX(0.0, new Matrix3d()), true, 1.0, 1.0, 1.0, 1.0, new Vector3d(), 1.0, true, 0, object, null);
        object = this.b;
        Integer n4 = n3;
        object.put((Integer)n4, ht_02);
        return ht_02;
    }

    @Override
    public final boolean a(int n2) {
        ht_0<?> ht_02 = this.b.remove(n2);
        if (ht_02 != null) {
            boolean bl = true;
            ht_0<?> ht_03 = ht_02;
            ht_02.a = true;
            return true;
        }
        return false;
    }

    @Override
    public final void b() {
        Map<Integer, ht_0<?>> map2 = this.b;
        for (Map.Entry entry : map2.entrySet()) {
            Object object = entry;
            object = entry;
            ht_0 ht_02 = (ht_0)entry.getValue();
            object = ht_02;
            boolean bl = true;
            object = ht_02;
            ht_02.a = true;
        }
        this.b.clear();
        this.d = true;
    }

    @Override
    public final boolean g() {
        return this.d;
    }

    @Override
    public final boolean a(HI hI) {
        Intrinsics.checkNotNullParameter((Object)hI, (String)"");
        return false;
    }

    @Override
    public final boolean b(HI hI) {
        Intrinsics.checkNotNullParameter((Object)hI, (String)"");
        return false;
    }

    @Override
    public final boolean b(int n2) {
        return false;
    }

    @Override
    public final List<HI> d() {
        return CollectionsKt.emptyList();
    }

    @Override
    public final List<HI> e() {
        return CollectionsKt.emptyList();
    }

    @Override
    public final List<HI> f() {
        return CollectionsKt.emptyList();
    }

    @Override
    public final void a(int n2, int n3) {
    }

    @Override
    public final void b(int n2, int n3) {
    }

    @Override
    public final hd_0 a(Vector3dc vector3dc, Vector3dc vector3dc2, double d2, int ... nArray) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"");
        return null;
    }

    @Override
    public final he_0 b(Vector3dc vector3dc, Vector3dc vector3dc2, double d2, int ... nArray) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"");
        return null;
    }

    @Override
    public final void a(Integer n2) {
    }

    @Override
    public final List<HS> c() {
        return CollectionsKt.emptyList();
    }
}

