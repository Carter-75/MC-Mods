/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dh_1;
import org.valkyrienskies.core.impl.shadow.dj_2;
import org.valkyrienskies.core.impl.shadow.do_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cn
 */
public class cn_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cn_2.class);
    private static final String i = "additionalItems";
    private final cp_2 j;
    private final List<cp_2> k = new ArrayList<cp_2>();
    private boolean l = true;
    private final cp_2 m;
    private do_1 n;

    public cn_2(String string, JsonNode object, cp_2 cp_22, df_2 df_22) {
        super(string, (JsonNode)object, cp_22, dj_2.ITEMS, df_22);
        cp_2 cp_23 = null;
        cp_2 cp_24 = null;
        if (((JsonNode)object).isObject() || ((JsonNode)object).isBoolean()) {
            cp_23 = new cp_2(df_22, string, cp_22.i(), (JsonNode)object, cp_22);
        } else {
            object = ((JsonNode)object).iterator();
            while (object.hasNext()) {
                JsonNode jsonNode = (JsonNode)object.next();
                this.k.add(new cp_2(df_22, string, cp_22.i(), jsonNode, cp_22));
            }
            object = this.d().c().get(i);
            if (object != null) {
                if (((JsonNode)object).isBoolean()) {
                    this.l = ((JsonNode)object).asBoolean();
                } else if (((JsonNode)object).isObject()) {
                    cp_24 = new cp_2(df_22, "#", cp_22.i(), (JsonNode)object, cp_22);
                }
            }
        }
        this.n = new dh_1(df_22.d().j());
        this.d = df_22;
        cn_2 cn_22 = this;
        cn_22.a(cn_22.e().d());
        this.j = cp_23;
        this.m = cp_24;
    }

    @Override
    public Set<dg_2> a(JsonNode object, JsonNode jsonNode, String string) {
        this.a(g, (JsonNode)object, jsonNode, string);
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        if (!((JsonNode)object).isArray() && !this.d.d().a()) {
            return linkedHashSet;
        }
        if (((JsonNode)object).isArray()) {
            int n2 = 0;
            object = ((JsonNode)object).iterator();
            while (object.hasNext()) {
                JsonNode jsonNode2 = (JsonNode)object.next();
                this.a(linkedHashSet, n2, jsonNode2, jsonNode, string);
                ++n2;
            }
        } else {
            this.a(linkedHashSet, 0, (JsonNode)object, jsonNode, string);
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private void a(Set<dg_2> set, int n2, JsonNode jsonNode, JsonNode jsonNode2, String string) {
        if (this.j != null) {
            set.addAll(this.j.a(jsonNode, jsonNode2, string + "[" + n2 + "]"));
        }
        if (this.k != null) {
            if (n2 < this.k.size()) {
                set.addAll(this.k.get(n2).a(jsonNode, jsonNode2, string + "[" + n2 + "]"));
                return;
            }
            if (this.m != null) {
                set.addAll(this.m.a(jsonNode, jsonNode2, string + "[" + n2 + "]"));
                return;
            }
            if (!this.l) {
                set.add(this.a(string, "" + n2));
            }
        }
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        if (jsonNode instanceof ArrayNode) {
            jsonNode = (ArrayNode)jsonNode;
            JsonNode jsonNode3 = null;
            if (this.f.c() && this.j != null) {
                jsonNode3 = this.j.c().get("default");
            }
            int n2 = 0;
            for (JsonNode jsonNode4 : jsonNode) {
                if (jsonNode4.isNull() && jsonNode3 != null) {
                    ((ArrayNode)jsonNode).set(n2, jsonNode3);
                    jsonNode4 = jsonNode3;
                }
                this.a(linkedHashSet, n2, jsonNode4, jsonNode2, string, bl);
                ++n2;
            }
        } else {
            this.a(linkedHashSet, 0, jsonNode, jsonNode2, string, bl);
        }
        return linkedHashSet;
    }

    private void a(HashSet<dg_2> hashSet, int n2, JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        if (this.j != null) {
            cn_2 cn_22 = this;
            cn_22.a(cn_22.j, jsonNode, jsonNode2, string + "[" + n2 + "]", bl, hashSet);
        }
        if (this.k != null) {
            if (n2 < this.k.size()) {
                cn_2 cn_23 = this;
                cn_23.a(cn_23.k.get(n2), jsonNode, jsonNode2, string + "[" + n2 + "]", bl, hashSet);
                return;
            }
            if (this.m != null) {
                cn_2 cn_24 = this;
                cn_24.a(cn_24.m, jsonNode, jsonNode2, string + "[" + n2 + "]", bl, hashSet);
            }
        }
    }

    private void a(cp_2 cp_22, JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl, Set<dg_2> set) {
        boolean bl2 = this.n.b(dj_2.ITEMS.a(), jsonNode, jsonNode2, string, cp_22.b(), cp_22.c(), cp_22.d(), this.d, this.d.c());
        if (bl2) {
            set.addAll(((bt_1)cp_22).a(jsonNode, jsonNode2, string, bl));
        }
        this.n.a(dj_2.ITEMS.a(), jsonNode, jsonNode2, string, cp_22.b(), cp_22.c(), cp_22.d(), this.d, this.d.c(), set);
    }

    public List<cp_2> h() {
        return this.k;
    }

    public cp_2 i() {
        return this.j;
    }

    @Override
    public void a_() {
        if (this.j != null) {
            this.j.o();
        }
        cn_2 cn_22 = this;
        cn_22.a(cn_22.k);
        if (this.m != null) {
            this.m.o();
        }
    }
}

