/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ce_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.dg_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bN
 */
public abstract class bn_1
implements cv_2 {
    private final String a;

    protected bn_1(String string) {
        this.a = string;
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode;
        return this.a(jsonNode2, jsonNode2, "$");
    }

    protected dg_2 a(ce_2 ce_22, String string, String ... stringArray) {
        return dg_2.a(this.a, ce_22, string, null, stringArray);
    }

    protected dg_2 a(ce_2 ce_22, String string, Map<String, Object> map2) {
        return dg_2.a(this.a, ce_22, string, null, map2);
    }

    protected Set<dg_2> a() {
        return Collections.emptySet();
    }

    protected Set<dg_2> b(ce_2 ce_22, String string, Map<String, Object> map2) {
        return Collections.singleton(this.a(ce_22, string, map2));
    }

    protected Set<dg_2> b(ce_2 ce_22, String string, String ... stringArray) {
        return Collections.singleton(this.a(ce_22, string, stringArray));
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        Set<dg_2> set = Collections.emptySet();
        if (bl) {
            set = this.a(jsonNode, jsonNode2, string);
        }
        return set;
    }
}

