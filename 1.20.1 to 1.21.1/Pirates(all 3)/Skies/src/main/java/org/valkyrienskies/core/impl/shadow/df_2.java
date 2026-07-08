/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.valkyrienskies.core.impl.shadow.co_2;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cr_2;
import org.valkyrienskies.core.impl.shadow.cs_2;
import org.valkyrienskies.core.impl.shadow.ct_1;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.dd_1;
import org.valkyrienskies.core.impl.shadow.dx_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.df
 */
public class df_2 {
    private final dx_2 a;
    private final dd_1 b;
    private final co_2 c;
    private final cr_2 d;
    private ct_1 e;
    private final Map<String, cs_2> f = new HashMap<String, cs_2>();
    private final Stack<a> g = new Stack();

    public df_2(dx_2 dx_22, dd_1 dd_12, co_2 co_22, cr_2 cr_22, ct_1 ct_12) {
        if (dx_22 == null) {
            throw new IllegalArgumentException("URIFactory must not be null");
        }
        if (co_22 == null) {
            throw new IllegalArgumentException("JsonMetaSchema must not be null");
        }
        if (cr_22 == null) {
            throw new IllegalArgumentException("JsonSchemaFactory must not be null");
        }
        this.a = dx_22;
        this.b = dd_12;
        this.c = co_22;
        this.d = cr_22;
        this.e = ct_12;
    }

    public cv_2 a(String string, String string2, JsonNode jsonNode, cp_2 cp_22, String string3) {
        return this.c.a(this, string, string2, jsonNode, cp_22, string3);
    }

    public String a(JsonNode jsonNode) {
        return this.c.a(jsonNode);
    }

    public dx_2 a() {
        return this.a;
    }

    public dd_1 b() {
        return this.b;
    }

    public cr_2 c() {
        return this.d;
    }

    public ct_1 d() {
        if (this.e == null) {
            this.e = new ct_1();
        }
        return this.e;
    }

    public void a(ct_1 ct_12) {
        this.e = ct_12;
    }

    public void a(String string, cs_2 cs_22) {
        this.f.put(string, cs_22);
    }

    public cs_2 a(String string) {
        return this.f.get(string);
    }

    public a e() {
        if (!this.g.empty()) {
            return this.g.peek();
        }
        return null;
    }

    public void a(a a2, String string) {
        this.g.push(a2);
    }

    public void b(String string) {
        this.g.pop();
    }

    protected co_2 f() {
        return this.c;
    }

    public static class a {
        private final Map<String, ObjectNode> a = new HashMap<String, ObjectNode>();
        private boolean b = false;

        public void a(String string, ObjectNode objectNode) {
            this.a.put(string, objectNode);
        }

        public ObjectNode a(String string) {
            return this.a.get(string);
        }

        public void a() {
            this.b = true;
        }

        public boolean b() {
            return this.b;
        }

        public boolean c() {
            return !this.a.isEmpty();
        }
    }
}

