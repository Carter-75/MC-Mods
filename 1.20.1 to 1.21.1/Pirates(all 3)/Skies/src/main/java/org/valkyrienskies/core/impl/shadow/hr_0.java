/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3f;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.HW;
import org.valkyrienskies.core.impl.shadow.HX;
import org.valkyrienskies.core.impl.shadow.HZ;
import org.valkyrienskies.core.impl.shadow.hi_0;
import org.valkyrienskies.core.impl.shadow.ia_0;
import org.valkyrienskies.core.impl.shadow.id_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hr
 */
public final class hr_0
implements GU {
    private final HZ e;
    private final HX f;
    private final HW g;
    private boolean h;

    public hr_0() {
        Object object = id_0.a;
        this.e = new HZ(new ia_0(id_0.a.a(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.listOf((Object)id_0.a.a((byte)0, (byte)0, (byte)0, (byte)15, (byte)15, (byte)15))), 1.0f, 1.0f, 1.0f, 0);
        this.f = new HX(id_0.a.a(), 0.0f, 0.0f, new Vector3f(), 0);
        hr_0 hr_02 = this;
        object = hr_02;
        object = this;
        this.g = new HW(hr_02.e, ((hr_0)object).f, 0);
    }

    @Override
    public final HZ b() {
        return this.e;
    }

    @Override
    public final HX c() {
        return this.f;
    }

    @Override
    public final HW d() {
        return this.g;
    }

    @Override
    public final void a(HZ hZ, hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hZ, (String)"");
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
    }

    @Override
    public final void a(HX hX, hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hX, (String)"");
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
    }

    @Override
    public final HW a(int n2, int n3, int n4) {
        hr_0 hr_02 = this;
        return hr_02.g;
    }

    @Override
    public final HZ a(int n2, hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
        return null;
    }

    @Override
    public final Map<Integer, HZ> a(hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
        return MapsKt.emptyMap();
    }

    @Override
    public final HX b(int n2, hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
        return null;
    }

    @Override
    public final Map<Integer, HZ> b(hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
        return MapsKt.emptyMap();
    }

    @Override
    public final HW c(int n2, hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
        return null;
    }

    @Override
    public final Map<Integer, HW> c(hi_0 hi_02) {
        Intrinsics.checkNotNullParameter((Object)hi_02, (String)"");
        return MapsKt.emptyMap();
    }

    @Override
    public final boolean a() {
        return this.h;
    }

    @Override
    public final void close() {
        this.h = true;
    }
}

