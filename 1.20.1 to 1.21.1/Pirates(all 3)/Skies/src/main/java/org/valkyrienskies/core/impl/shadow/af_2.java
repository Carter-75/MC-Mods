/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.EnumSet;
import org.valkyrienskies.core.impl.shadow.aa_2;
import org.valkyrienskies.core.impl.shadow.ak_2;
import org.valkyrienskies.core.impl.shadow.al_2;
import org.valkyrienskies.core.impl.shadow.am_2;
import org.valkyrienskies.core.impl.shadow.aq_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.af
 */
class af_2
implements al_2 {
    JsonNode a;
    private EnumSet<aa_2> b;

    private af_2(JsonNode jsonNode) {
        this(jsonNode, aa_2.a());
    }

    af_2(JsonNode jsonNode, EnumSet<aa_2> enumSet) {
        this.a = jsonNode;
        this.b = enumSet;
    }

    public final JsonNode a() {
        return this.a;
    }

    @Override
    public final void a(am_2 am_22, am_2 am_23) {
        JsonNode jsonNode = am_22.a(this.a);
        this.a(am_22);
        this.a(am_23, jsonNode, aq_2.MOVE);
    }

    @Override
    public final void b(am_2 object, am_2 am_22) {
        object = (object = object.a(this.a)) != null ? ((JsonNode)object).deepCopy() : null;
        this.a(am_22, (JsonNode)object, aq_2.COPY);
    }

    private static String a(JsonNode jsonNode) {
        if (jsonNode == null || jsonNode.isNull()) {
            return "null";
        }
        if (jsonNode.isArray()) {
            return "array";
        }
        if (jsonNode.isObject()) {
            return "object";
        }
        return "value " + jsonNode.toString();
    }

    @Override
    public final void a(am_2 am_22, JsonNode jsonNode) {
        JsonNode jsonNode2 = am_22.a(this.a);
        if (!jsonNode2.equals(jsonNode)) {
            throw new ak_2("Expected " + af_2.a(jsonNode) + " but found " + af_2.a(jsonNode2), aq_2.TEST, am_22);
        }
    }

    @Override
    public final void b(am_2 am_22, JsonNode jsonNode) {
        this.a(am_22, jsonNode, aq_2.ADD);
    }

    @Override
    public final void c(am_2 am_22, JsonNode jsonNode) {
        if (am_22.a()) {
            this.a = jsonNode;
            return;
        }
        JsonNode jsonNode2 = am_22.e().a(this.a);
        am_2.a a2 = am_22.d();
        if (jsonNode2.isObject()) {
            am_2.a a3;
            if (!this.b.contains((Object)aa_2.ALLOW_MISSING_TARGET_OBJECT_ON_REPLACE)) {
                a3 = a2;
                if (!jsonNode2.has(a3.a)) {
                    a3 = a2;
                    throw new ak_2("Missing field \"" + a3.a + "\"", aq_2.REPLACE, am_22.e());
                }
            }
            a3 = a2;
            ((ObjectNode)jsonNode2).replace(a3.a, jsonNode);
            return;
        }
        if (jsonNode2.isArray()) {
            if (a2.b() >= jsonNode2.size()) {
                throw new ak_2("Array index " + a2.b() + " out of bounds", aq_2.REPLACE, am_22.e());
            }
            ((ArrayNode)jsonNode2).set(a2.b(), jsonNode);
            return;
        }
        throw new ak_2("Can't reference past scalar value", aq_2.REPLACE, am_22.e());
    }

    @Override
    public final void a(am_2 object) {
        if (object.a()) {
            throw new ak_2("Cannot remove document root", aq_2.REMOVE, (am_2)object);
        }
        JsonNode jsonNode = object.e().a(this.a);
        am_2.a a2 = object.d();
        if (jsonNode.isObject()) {
            object = a2;
            ((ObjectNode)jsonNode).remove(((am_2.a)object).a);
            return;
        }
        if (jsonNode.isArray()) {
            if (!this.b.contains((Object)aa_2.REMOVE_NONE_EXISTING_ARRAY_ELEMENT) && a2.b() >= jsonNode.size()) {
                throw new ak_2("Array index " + a2.b() + " out of bounds", aq_2.REPLACE, object.e());
            }
            ((ArrayNode)jsonNode).remove(a2.b());
            return;
        }
        throw new ak_2("Cannot reference past scalar value", aq_2.REPLACE, object.e());
    }

    private void a(am_2 am_22, JsonNode jsonNode, aq_2 aq_22) {
        if (am_22.a()) {
            this.a = jsonNode;
            return;
        }
        JsonNode jsonNode2 = am_22.e().a(this.a);
        if (!jsonNode2.isContainerNode()) {
            throw new ak_2("Cannot reference past scalar value", aq_22, am_22.e());
        }
        if (jsonNode2.isArray()) {
            af_2.b(am_22, jsonNode, jsonNode2);
            return;
        }
        af_2.a(am_22, jsonNode2, jsonNode);
    }

    private static void a(am_2 object, JsonNode jsonNode, JsonNode jsonNode2) {
        jsonNode = (ObjectNode)jsonNode;
        object = object.d();
        object = ((am_2.a)object).a;
        ((ObjectNode)jsonNode).set((String)object, jsonNode2);
    }

    private static void b(am_2 am_22, JsonNode jsonNode, JsonNode jsonNode2) {
        jsonNode2 = (ArrayNode)jsonNode2;
        int n2 = am_22.d().b();
        if (n2 == Integer.MIN_VALUE) {
            ((ArrayNode)jsonNode2).add(jsonNode);
            return;
        }
        if (n2 > jsonNode2.size()) {
            throw new ak_2("Array index " + n2 + " out of bounds", aq_2.ADD, am_22.e());
        }
        ((ArrayNode)jsonNode2).insert(n2, jsonNode);
    }
}

