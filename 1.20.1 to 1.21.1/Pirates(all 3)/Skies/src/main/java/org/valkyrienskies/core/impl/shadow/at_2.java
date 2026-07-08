/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.at$a
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.valkyrienskies.core.impl.shadow.at;
import org.valkyrienskies.core.impl.shadow.at_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.at
 */
public class at_2 {
    private static b b;
    private static a_0 c;
    private static a_0 d;
    public final ObjectNode a;
    private final b e;
    private final a_0 f;

    public at_2(ObjectNode objectNode) {
        this(objectNode, org.valkyrienskies.core.impl.shadow.at$b.STANDARD, at.a.YES);
    }

    public at_2(ObjectNode objectNode, boolean bl) {
        this(objectNode, org.valkyrienskies.core.impl.shadow.at$b.INLINE, at.a.YES);
    }

    public at_2(ObjectNode objectNode, b b2, a_0 a_02) {
        this.a = objectNode;
        this.e = b2;
        this.f = a_02;
    }

    public final ObjectNode a() {
        return this.a;
    }

    private b d() {
        return this.e;
    }

    public final boolean b() {
        return this.e == org.valkyrienskies.core.impl.shadow.at$b.INLINE;
    }

    private a_0 e() {
        return this.f;
    }

    public final boolean c() {
        return this.f == at.a.YES;
    }

    public static enum b {
        INLINE,
        STANDARD;

    }
}

