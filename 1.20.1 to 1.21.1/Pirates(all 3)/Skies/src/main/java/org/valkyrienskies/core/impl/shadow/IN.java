/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.HQ;
import org.valkyrienskies.core.impl.shadow.HS;

public final class IN
implements HS {
    public final int a;
    public final int b;
    public final List<HQ> c;

    public IN(int n2, int n3, List<HQ> list) {
        Intrinsics.checkNotNullParameter(list, (String)"");
        this.a = n2;
        this.b = n3;
        this.c = list;
    }

    @Override
    public final int a() {
        return this.a;
    }

    @Override
    public final int b() {
        return this.b;
    }

    @Override
    public final List<HQ> c() {
        return this.c;
    }
}

