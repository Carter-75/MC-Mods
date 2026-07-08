/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.dg_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cs
 */
public class cs_2 {
    private final cp_2 a;

    public cs_2(cp_2 cp_22) {
        this.a = cp_22;
    }

    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        return this.a.a(jsonNode, jsonNode2, string);
    }

    public cp_2 a() {
        return this.a;
    }

    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        return ((bt_1)this.a).a(jsonNode, jsonNode2, string, bl);
    }
}

