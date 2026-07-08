/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import org.valkyrienskies.core.impl.shadow.co_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cr_2;
import org.valkyrienskies.core.impl.shadow.cu_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cV
 */
public class cv_1 {
    private static final String a = "$schema";

    public static cu_1.a a(JsonNode object) {
        if (!((JsonNode)object).has(a)) {
            throw new cq_2("Schema tag not present");
        }
        if (((String)(object = cr_2.a(((JsonNode)object).get(a).asText(), true, true))).equals(co_2.a().e())) {
            return cu_1.a.V4;
        }
        if (((String)object).equals(co_2.b().e())) {
            return cu_1.a.V6;
        }
        if (((String)object).equals(co_2.c().e())) {
            return cu_1.a.V7;
        }
        if (((String)object).equals(co_2.d().e())) {
            return cu_1.a.V201909;
        }
        throw new cq_2("Unrecognizable schema");
    }
}

