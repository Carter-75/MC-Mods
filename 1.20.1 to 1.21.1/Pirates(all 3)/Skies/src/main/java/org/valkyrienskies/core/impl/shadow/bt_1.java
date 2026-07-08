/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang3.StringUtils
 *  org.slf4j.Logger
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.valkyrienskies.core.impl.shadow.bs_1;
import org.valkyrienskies.core.impl.shadow.by_1;
import org.valkyrienskies.core.impl.shadow.ce_2;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bT
 */
public abstract class bt_1
implements cv_2 {
    protected String a;
    protected JsonNode b;
    protected cp_2 c;
    private boolean g;
    private dj_2 i;
    private ce_2 j;
    protected df_2 d;
    protected final boolean e;
    protected final bs_1 f;

    public bt_1(String string, JsonNode jsonNode, cp_2 cp_22, dj_2 dj_22, df_2 df_22) {
        this(string, jsonNode, cp_22, dj_22, false, df_22.d() != null && df_22.d().b(), df_22.d() != null ? df_22.d().c() : null);
    }

    @Deprecated
    public bt_1(String string, JsonNode jsonNode, cp_2 cp_22, dj_2 dj_22, boolean bl, boolean bl2) {
        this(string, jsonNode, cp_22, dj_22, false, bl2, null);
    }

    public bt_1(String string, JsonNode jsonNode, cp_2 cp_22, dj_2 dj_22, boolean bl, boolean bl2, bs_1 bs_12) {
        this.j = dj_22;
        this.a = string;
        this.b = jsonNode;
        this.c = cp_22;
        this.i = dj_22;
        this.g = bl;
        this.e = bl2;
        this.f = bs_12 != null ? bs_12 : bs_1.a;
    }

    public String b() {
        return this.a;
    }

    public JsonNode c() {
        return this.b;
    }

    public cp_2 d() {
        return this.c;
    }

    protected cp_2 a(df_2 df_22) {
        if (this.g) {
            return null;
        }
        return bt_1.a(this.b, df_22);
    }

    private static cp_2 a(JsonNode object, df_2 df_22) {
        JsonNode jsonNode = ((JsonNode)object).get("id");
        if (jsonNode == null) {
            return null;
        }
        if (jsonNode.equals(((JsonNode)object).get("$schema"))) {
            return null;
        }
        object = jsonNode.textValue();
        if (object == null) {
            return null;
        }
        try {
            object = df_22.a().a(jsonNode.textValue());
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
        return df_22.c().a((URI)object, df_22.d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode;
        return this.a(jsonNode2, jsonNode2, "$");
    }

    protected boolean a(double d2, double d3) {
        return Math.abs(d2 - d3) < 1.0E-12;
    }

    protected boolean b(double d2, double d3) {
        return d2 - d3 > 1.0E-12;
    }

    protected boolean c(double d2, double d3) {
        return d2 - d3 < -1.0E-12;
    }

    protected void a(String object) {
        object = this.d().c().get((String)object);
        if (object != null && ((JsonNode)object).isTextual() && StringUtils.isNotBlank((CharSequence)(object = ((JsonNode)object).asText()))) {
            this.j = by_1.a((String)object);
        }
    }

    protected dg_2 a(String object, String ... stringArray) {
        object = dg_2.a(this.e().a(), this.j, (String)object, this.a, stringArray);
        if (this.e && !this.g()) {
            throw new cq_2((dg_2)object);
        }
        return object;
    }

    protected void a(Logger logger, JsonNode jsonNode, JsonNode jsonNode2, String string) {
        if (logger.isDebugEnabled()) {
            logger.debug("validate( " + jsonNode + ", " + jsonNode2 + ", " + string + ")");
        }
    }

    protected dj_2 e() {
        return this.i;
    }

    protected String f() {
        JsonNode jsonNode = this.d().c().get("type");
        if (jsonNode != null) {
            return jsonNode.asText();
        }
        return null;
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        Set<dg_2> set = new LinkedHashSet<dg_2>();
        if (bl) {
            set = this.a(jsonNode, jsonNode2, string);
        }
        return set;
    }

    protected void a(Collection<cp_2> object) {
        object = object.iterator();
        while (object.hasNext()) {
            cp_2 cp_22 = (cp_2)object.next();
            cp_22.o();
        }
    }

    protected boolean g() {
        return this.c.a.equals(dj_2.ONE_OF.a());
    }

    protected static void a(df_2.a a2, ObjectNode jsonNode, String string, cp_2 cp_22) {
        if (string == null) {
            a2.a();
            return;
        }
        if ((jsonNode = ((JsonNode)jsonNode).get("mapping")) == null) {
            bt_1.a(a2, string, cp_22);
            return;
        }
        bt_1.a(a2, string, jsonNode, cp_22);
        if (!a2.b() && bt_1.a(jsonNode, cp_22)) {
            bt_1.a(a2, string, cp_22);
        }
    }

    protected static void a(df_2.a a2, ObjectNode objectNode, cp_2 cp_22, String string) {
        Object object = cp_22.b.get("discriminator");
        if (object != null && null != a2.a(cp_22.a)) {
            JsonNode jsonNode = ((JsonNode)object).get("propertyName");
            if (jsonNode != null) {
                throw new cq_2(string + " schema " + cp_22 + " attempts redefining the discriminator property");
            }
            jsonNode = (ObjectNode)((JsonNode)objectNode).get("mapping");
            Object object2 = (ObjectNode)((JsonNode)object).get("mapping");
            if (jsonNode == null && object2 != null) {
                objectNode.set("mapping", (JsonNode)object);
            } else if (jsonNode != null && object2 != null) {
                object = ((JsonNode)object2).fields();
                while (object.hasNext()) {
                    object2 = (Map.Entry)object.next();
                    String string2 = (String)object2.getKey();
                    object2 = (JsonNode)object2.getValue();
                    JsonNode jsonNode2 = jsonNode.get(string2);
                    if (jsonNode2 != null && jsonNode2 != object2) {
                        throw new cq_2(string + "discriminator mapping redefinition from " + string2 + "/" + jsonNode2 + " to " + object2);
                    }
                    if (jsonNode2 != null) continue;
                    ((ObjectNode)jsonNode).set(string2, (JsonNode)object2);
                }
            }
        }
        a2.a(cp_22.a, objectNode);
    }

    private static void a(df_2.a a2, String string, cp_2 cp_22) {
        if (cp_22.a.endsWith("/" + string)) {
            a2.a();
        }
    }

    private static void a(df_2.a a2, String string, JsonNode object, cp_2 cp_22) {
        object = ((JsonNode)object).fields();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            if (!((String)entry.getKey()).equals(string) || !cp_22.a.equals(((JsonNode)entry.getValue()).asText())) continue;
            a2.a();
            return;
        }
    }

    private static boolean a(JsonNode object, cp_2 cp_22) {
        object = ((JsonNode)object).fields();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            if (!((JsonNode)entry.getValue()).asText().equals(cp_22.a)) continue;
            return false;
        }
        return true;
    }
}

