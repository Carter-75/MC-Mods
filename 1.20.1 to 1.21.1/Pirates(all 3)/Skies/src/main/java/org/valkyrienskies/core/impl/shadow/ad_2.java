/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import org.valkyrienskies.core.impl.shadow.am_2;
import org.valkyrienskies.core.impl.shadow.aq_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ad
 */
public final class ad_2 {
    public final aq_2 a;
    public final am_2 b;
    public final JsonNode c;
    public am_2 d;
    public final JsonNode e;

    public ad_2(aq_2 aq_22, am_2 am_22, JsonNode jsonNode) {
        this.a = aq_22;
        this.b = am_22;
        this.c = jsonNode;
        this.e = null;
    }

    public ad_2(aq_2 aq_22, am_2 am_22, am_2 am_23) {
        this.a = aq_22;
        this.b = am_22;
        this.d = am_23;
        this.c = null;
        this.e = null;
    }

    private ad_2(aq_2 aq_22, am_2 am_22, JsonNode jsonNode, JsonNode jsonNode2) {
        this.a = aq_22;
        this.b = am_22;
        this.c = jsonNode2;
        this.e = jsonNode;
    }

    public final aq_2 a() {
        return this.a;
    }

    public final am_2 b() {
        return this.b;
    }

    public final JsonNode c() {
        return this.c;
    }

    public static ad_2 a(aq_2 aq_22, am_2 am_22, JsonNode jsonNode) {
        return new ad_2(aq_22, am_22, jsonNode);
    }

    public static ad_2 a(aq_2 aq_22, am_2 am_22, JsonNode jsonNode, JsonNode jsonNode2) {
        return new ad_2(aq_22, am_22, jsonNode, jsonNode2);
    }

    final am_2 d() {
        return this.d;
    }

    public final JsonNode e() {
        return this.e;
    }
}

