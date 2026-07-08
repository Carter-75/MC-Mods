/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.rs_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.rm
 */
public final class rm_0 {
    public static final rm_0 a = new rm_0("XYZ", rs_0.b, rs_0.d, rs_0.f);
    public static final rm_0 b = new rm_0("XZY", rs_0.b, rs_0.f, rs_0.d);
    public static final rm_0 c = new rm_0("YXZ", rs_0.d, rs_0.b, rs_0.f);
    public static final rm_0 d = new rm_0("YZX", rs_0.d, rs_0.f, rs_0.b);
    public static final rm_0 e = new rm_0("ZXY", rs_0.f, rs_0.b, rs_0.d);
    public static final rm_0 f = new rm_0("ZYX", rs_0.f, rs_0.d, rs_0.b);
    public static final rm_0 g = new rm_0("XYX", rs_0.b, rs_0.d, rs_0.b);
    public static final rm_0 h = new rm_0("XZX", rs_0.b, rs_0.f, rs_0.b);
    public static final rm_0 i = new rm_0("YXY", rs_0.d, rs_0.b, rs_0.d);
    public static final rm_0 j = new rm_0("YZY", rs_0.d, rs_0.f, rs_0.d);
    public static final rm_0 k = new rm_0("ZXZ", rs_0.f, rs_0.b, rs_0.f);
    private static rm_0 o;
    private final String p;
    final rs_0 l;
    final rs_0 m;
    final rs_0 n;

    private rm_0(String string, rs_0 rs_02, rs_0 rs_03, rs_0 rs_04) {
        this.p = string;
        this.l = rs_02;
        this.m = rs_03;
        this.n = rs_04;
    }

    public final String toString() {
        return this.p;
    }

    public final rs_0 a() {
        return this.l;
    }

    public final rs_0 b() {
        return this.m;
    }

    public final rs_0 c() {
        return this.n;
    }

    static {
        new rm_0("ZYZ", rs_0.f, rs_0.d, rs_0.f);
    }
}

