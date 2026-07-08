/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import org.valkyrienskies.core.impl.shadow.am_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.an
 */
public final class an_2
extends Exception {
    final am_2 a;
    private final JsonNode b;

    public an_2(String string, am_2 am_22, JsonNode jsonNode) {
        super(string);
        this.a = am_22;
        this.b = jsonNode;
    }

    public final am_2 a() {
        return this.a;
    }

    private JsonNode b() {
        return this.b;
    }
}

