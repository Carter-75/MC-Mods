/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.EnumSet;
import org.valkyrienskies.core.impl.shadow.aa_2;
import org.valkyrienskies.core.impl.shadow.ac_2;
import org.valkyrienskies.core.impl.shadow.af_2;
import org.valkyrienskies.core.impl.shadow.ah_2;
import org.valkyrienskies.core.impl.shadow.ak_2;
import org.valkyrienskies.core.impl.shadow.al_2;
import org.valkyrienskies.core.impl.shadow.am_2;
import org.valkyrienskies.core.impl.shadow.an_2;
import org.valkyrienskies.core.impl.shadow.ap_2;
import org.valkyrienskies.core.impl.shadow.aq_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aj
 */
public final class aj_2 {
    private aj_2() {
    }

    private static JsonNode a(JsonNode jsonNode, String string) {
        if ((jsonNode = jsonNode.get(string)) == null) {
            throw new ah_2("Invalid JSON Patch payload (missing '" + string + "' field)");
        }
        return jsonNode;
    }

    private static JsonNode a(JsonNode jsonNode, String string, NullNode nullNode) {
        if ((jsonNode = jsonNode.get(string)) == null) {
            return nullNode;
        }
        return jsonNode;
    }

    private static void a(JsonNode object, al_2 al_22, EnumSet<aa_2> enumSet) {
        if (!((JsonNode)object).isArray()) {
            throw new ah_2("Invalid JSON Patch payload (not an array)");
        }
        object = ((JsonNode)object).iterator();
        block10: while (object.hasNext()) {
            Object object2 = (JsonNode)object.next();
            if (!((JsonNode)object2).isObject()) {
                throw new ah_2("Invalid JSON Patch payload (not an object)");
            }
            aq_2 aq_22 = aq_2.a(aj_2.a((JsonNode)object2, "op").textValue());
            am_2 am_22 = am_2.a(aj_2.a((JsonNode)object2, "path").textValue());
            try {
                switch (aq_22) {
                    case REMOVE: {
                        al_22.a(am_22);
                        continue block10;
                    }
                    case ADD: {
                        object2 = !enumSet.contains((Object)aa_2.MISSING_VALUES_AS_NULLS) ? aj_2.a((JsonNode)object2, "value") : aj_2.a((JsonNode)object2, "value", NullNode.getInstance());
                        al_22.b(am_22, (JsonNode)((JsonNode)object2).deepCopy());
                        continue block10;
                    }
                    case REPLACE: {
                        object2 = !enumSet.contains((Object)aa_2.MISSING_VALUES_AS_NULLS) ? aj_2.a((JsonNode)object2, "value") : aj_2.a((JsonNode)object2, "value", NullNode.getInstance());
                        al_22.c(am_22, (JsonNode)((JsonNode)object2).deepCopy());
                        continue block10;
                    }
                    case MOVE: {
                        object2 = am_2.a(aj_2.a((JsonNode)object2, "from").textValue());
                        al_22.a((am_2)object2, am_22);
                        continue block10;
                    }
                    case COPY: {
                        object2 = am_2.a(aj_2.a((JsonNode)object2, "from").textValue());
                        al_22.b((am_2)object2, am_22);
                        continue block10;
                    }
                    case TEST: {
                        object2 = !enumSet.contains((Object)aa_2.MISSING_VALUES_AS_NULLS) ? aj_2.a((JsonNode)object2, "value") : aj_2.a((JsonNode)object2, "value", NullNode.getInstance());
                        al_22.a(am_22, (JsonNode)((JsonNode)object2).deepCopy());
                    }
                }
            }
            catch (an_2 an_22) {
                object = an_22;
                throw new ak_2(an_22.getMessage(), aq_22, ((an_2)object).a);
            }
        }
    }

    private static void a(JsonNode jsonNode, EnumSet<aa_2> enumSet) {
        aj_2.a(jsonNode, ap_2.a, enumSet);
    }

    private static void a(JsonNode jsonNode) {
        EnumSet<aa_2> enumSet = aa_2.a();
        aj_2.a(jsonNode, ap_2.a, enumSet);
    }

    public static JsonNode a(JsonNode object, JsonNode object2, EnumSet<aa_2> enumSet) {
        object2 = new ac_2((JsonNode)object2, enumSet);
        aj_2.a((JsonNode)object, (al_2)object2, enumSet);
        object = object2;
        return ((af_2)object).a;
    }

    public static JsonNode a(JsonNode jsonNode, JsonNode jsonNode2) {
        return aj_2.a(jsonNode, jsonNode2, aa_2.a());
    }

    private static void b(JsonNode jsonNode, JsonNode object) {
        EnumSet<aa_2> enumSet = aa_2.a();
        object = new af_2((JsonNode)object, enumSet);
        aj_2.a(jsonNode, (al_2)object, enumSet);
    }

    private static void b(JsonNode jsonNode, JsonNode object, EnumSet<aa_2> enumSet) {
        object = new af_2((JsonNode)object, enumSet);
        aj_2.a(jsonNode, (al_2)object, enumSet);
    }
}

