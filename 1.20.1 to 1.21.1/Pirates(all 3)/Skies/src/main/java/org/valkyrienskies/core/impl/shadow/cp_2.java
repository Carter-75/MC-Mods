/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.ce_2;
import org.valkyrienskies.core.impl.shadow.co_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.ct_1;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cw_1;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dh_2;
import org.valkyrienskies.core.impl.shadow.di_1;
import org.valkyrienskies.core.impl.shadow.di_2;
import org.valkyrienskies.core.impl.shadow.dj_2;
import org.valkyrienskies.core.impl.shadow.dl_1;
import org.valkyrienskies.core.impl.shadow.do_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cp
 */
public class cp_2
extends bt_1 {
    private static final Pattern i = Pattern.compile("^[0-9]+$");
    private Map<String, cv_2> j;
    private final co_2 k;
    private boolean l = false;
    private final URI m;
    private cv_2 n = null;
    private cv_2 o = null;
    do_1 g = null;
    private static Comparator<String> p = (string, string2) -> {
        if (string.equals(string2)) {
            return 0;
        }
        if (string.endsWith("/properties")) {
            return -1;
        }
        if (string2.endsWith("/properties")) {
            return 1;
        }
        return string.compareTo((String)string2);
    };

    public cp_2(df_2 df_22, URI uRI, JsonNode jsonNode) {
        this(df_22, "#", uRI, jsonNode, null);
    }

    public cp_2(df_2 df_22, String string, URI uRI, JsonNode jsonNode, cp_2 cp_22) {
        this(df_22, string, uRI, jsonNode, cp_22, false);
    }

    public cp_2(df_2 df_22, URI uRI, JsonNode jsonNode, boolean bl) {
        this(df_22, "#", uRI, jsonNode, null, bl);
    }

    private cp_2(df_2 df_22, String string, URI serializable, JsonNode jsonNode, cp_2 cp_22, boolean bl) {
        super(string, jsonNode, cp_22, null, bl, df_22.d() != null && df_22.d().b(), df_22.d() != null ? df_22.d().c() : null);
        this.d = df_22;
        this.k = df_22.f();
        this.m = this.a((URI)serializable, jsonNode);
        if (df_22.d() != null) {
            this.g = new di_1(this.d.d().i());
            if (df_22.d().m() && (serializable = (ObjectNode)jsonNode.get("discriminator")) != null && null != df_22.e()) {
                df_22.e().a(string, (ObjectNode)serializable);
            }
        }
    }

    df_2 h() {
        return this.d;
    }

    private URI a(URI uRI, JsonNode object) {
        if ((object = this.d.a((JsonNode)object)) == null) {
            return uRI;
        }
        if (this.a(uRI, (String)object)) {
            return null;
        }
        try {
            return this.d.a().a(uRI, (String)object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new cq_2(dg_2.a(dj_2.ID.a(), (ce_2)dj_2.ID, (String)object, this.a, uRI == null ? "null" : uRI.toString()));
        }
    }

    private boolean a(URI uRI, String string) {
        return string.startsWith("#") && uRI == null;
    }

    public URI i() {
        return this.m;
    }

    public JsonNode b(String string) {
        cp_2 cp_22 = this.j();
        JsonNode jsonNode = cp_22.c();
        if (string.startsWith("#/")) {
            String[] stringArray = string.substring(2).split("/");
            String[] stringArray2 = stringArray;
            stringArray2 = stringArray;
            int n2 = stringArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                String string2 = stringArray2[i2];
                try {
                    string2 = URLDecoder.decode(string2, "utf-8");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {}
                Matcher matcher = i.matcher(string2);
                jsonNode = matcher.matches() ? jsonNode.get(Integer.parseInt(string2)) : jsonNode.get(string2);
                if (jsonNode == null) {
                    jsonNode = this.a(string, cp_22);
                }
                if (jsonNode != null) {
                    continue;
                }
                break;
            }
        } else if (string.startsWith("#") && string.length() > 1 && (jsonNode = this.k.a(string, jsonNode)) == null) {
            jsonNode = this.a(string, cp_22);
        }
        return jsonNode;
    }

    public cp_2 j() {
        cp_2 cp_22 = this;
        if (this.d() != null) {
            cp_22 = this.d().j();
        }
        return cp_22;
    }

    private JsonNode a(String string, cp_2 cp_22) {
        if ((cp_22 = cp_22.a(this.d)) != null) {
            return cp_22.b(string);
        }
        return null;
    }

    private Map<String, cv_2> c(JsonNode jsonNode) {
        TreeMap<String, cv_2> treeMap = new TreeMap<String, cv_2>(p);
        if (jsonNode.isBoolean()) {
            if (jsonNode.booleanValue()) {
                String string = this.a(jsonNode, "true");
                cv_2 cv_22 = this.d.a(this.b(), "true", jsonNode, this, string);
                treeMap.put(this.b() + "/true", cv_22);
            } else {
                String string = this.a(jsonNode, "false");
                cv_2 cv_23 = this.d.a(this.b(), "false", jsonNode, this, string);
                treeMap.put(this.b() + "/false", cv_23);
            }
        } else {
            Iterator<String> iterator2 = jsonNode.fieldNames();
            while (iterator2.hasNext()) {
                String string = iterator2.next();
                Object object = string.equals("if") ? jsonNode : jsonNode.get(string);
                String string2 = this.a(jsonNode, string);
                object = this.d.a(this.b(), string, (JsonNode)object, this, string2);
                if (dj_2.UNEVALUATED_PROPERTIES.a().equals(string)) {
                    this.o = object;
                }
                if (object == null || dj_2.UNEVALUATED_PROPERTIES.a().equals(string)) continue;
                treeMap.put(this.b() + "/" + string, (cv_2)object);
                if (!string.equals("required")) continue;
                this.n = object;
            }
        }
        return treeMap;
    }

    private String a(JsonNode jsonNode, String string) {
        cp_2 cp_22 = this.d();
        if ((jsonNode = this.a(jsonNode, cp_22)) != null && jsonNode.get(string) != null) {
            return jsonNode.get(string).asText();
        }
        return null;
    }

    private JsonNode a(JsonNode jsonNode, cp_2 cp_22) {
        if (cp_22 != null) {
            jsonNode = cp_22.b;
        }
        return jsonNode.get("message");
    }

    @Override
    public Set<dg_2> a(JsonNode iterable) {
        try {
            JsonNode jsonNode = iterable;
            iterable = this.a(jsonNode, jsonNode, "$");
            return iterable;
        }
        finally {
            if (this.d.d().o()) {
                bv_1.a().c();
            }
        }
    }

    @Override
    public Set<dg_2> a(JsonNode object, JsonNode object2, String string) {
        Object object3;
        ct_1 ct_12 = this.d.d();
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        this.k();
        this.a(false, true);
        Object object4 = this.n().values().iterator();
        while (object4.hasNext()) {
            object3 = object4.next();
            linkedHashSet.addAll(object3.a((JsonNode)object, (JsonNode)object2, string));
        }
        linkedHashSet.addAll(this.a((JsonNode)object, (JsonNode)object2, string, true, true));
        if (ct_12 != null && ct_12.m() && (object4 = (ObjectNode)this.b.get("discriminator")) != null && (object3 = this.d.e()) != null) {
            object2 = ((df_2.a)object3).a(this.a);
            if (object2 == null) {
                ((df_2.a)object3).a(this.a, (ObjectNode)object4);
                object2 = object4;
            }
            string = ((JsonNode)object2).get("propertyName").asText();
            object = ((JsonNode)object).get(string);
            object = object == null ? null : ((JsonNode)object).asText();
            cp_2.a((df_2.a)object3, (ObjectNode)object2, (String)object, this);
        }
        return linkedHashSet;
    }

    public dh_2 b(JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode;
        return this.b(jsonNode2, jsonNode2, "$");
    }

    private dh_2 b(JsonNode object, JsonNode jsonNode, String string) {
        try {
            ct_1 ct_12 = this.d.d();
            bv_1 bv_12 = this.k();
            this.a(false, true);
            object = this.a((JsonNode)object, jsonNode, string);
            if (ct_12.n()) {
                bv_12.d();
            }
            object = new dh_2((Set<dg_2>)object, bv_12);
            return object;
        }
        finally {
            if (this.d.d().o()) {
                bv_1.a().c();
            }
        }
    }

    public dh_2 a(JsonNode object, boolean bl) {
        try {
            ct_1 ct_12 = this.d.d();
            bv_1 bv_12 = this.k();
            this.a(true, bl);
            JsonNode jsonNode = object;
            Set<dg_2> set = ((bt_1)this).a(jsonNode, jsonNode, "$", bl);
            if (ct_12.n()) {
                bv_12.d();
            }
            JsonNode jsonNode2 = object;
            set.addAll(this.a(jsonNode2, jsonNode2, "$", bl, false));
            object = new dh_2(set, bv_12);
            return object;
        }
        finally {
            if (this.d.d().o()) {
                bv_1.a().c();
            }
        }
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        for (Map.Entry<String, cv_2> entry : this.n().entrySet()) {
            dl_1 dl_12 = entry.getValue();
            String object = entry.getKey();
            try {
                if (!this.g.b(object, jsonNode, jsonNode2, string, this.a, this.b, this.c, this.d, this.d.c())) continue;
                linkedHashSet.addAll(dl_12.a(jsonNode, jsonNode2, string, bl));
            }
            finally {
                this.g.a(object, jsonNode, jsonNode2, string, this.a, this.b, this.c, this.d, this.d.c(), linkedHashSet);
            }
        }
        if (bl) {
            linkedHashSet.addAll(this.a(jsonNode, jsonNode2, string, true, true));
        }
        return linkedHashSet;
    }

    private void a(boolean bl, boolean bl2) {
        Object object = bv_1.a().a("com.networknt.schema.ValidatorState");
        if (object == null) {
            object = new di_2();
            ((di_2)object).c(bl);
            ((di_2)object).d(bl2);
            bv_1.a().a("com.networknt.schema.ValidatorState", object);
        }
    }

    public bv_1 k() {
        ct_1 ct_12 = this.d.d();
        bv_1 bv_12 = (bv_1)cw_1.a("com.networknt.schema.CollectorKey");
        if (bv_12 == null) {
            bv_12 = ct_12 != null && ct_12.k() != null ? ct_12.k() : new bv_1();
            cw_1.a("com.networknt.schema.CollectorKey", bv_12);
        }
        return bv_12;
    }

    public String toString() {
        return "\"" + this.b() + "\" : " + this.c().toString();
    }

    public boolean l() {
        return this.n != null;
    }

    public cv_2 m() {
        return this.n;
    }

    public Map<String, cv_2> n() {
        if (this.j == null) {
            this.j = Collections.unmodifiableMap(this.c(this.c()));
        }
        return this.j;
    }

    public void o() {
        if (!this.l) {
            this.l = true;
            for (cv_2 cv_22 : this.n().values()) {
                cv_22.a_();
            }
        }
    }

    private Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl, boolean bl2) {
        if (this.o == null) {
            return Collections.emptySet();
        }
        if (!bl2) {
            Set<dg_2> set = new HashSet<dg_2>();
            try {
                if (this.g.b(this.b() + "/" + dj_2.UNEVALUATED_PROPERTIES.a(), jsonNode, jsonNode2, string, this.a, this.b, this.c, this.d, this.d.c())) {
                    set = this.o.a(jsonNode, jsonNode2, string, bl);
                }
            }
            finally {
                this.g.a(this.b() + "/" + dj_2.UNEVALUATED_PROPERTIES.a(), jsonNode, jsonNode2, string, this.a, this.b, this.c, this.d, this.d.c(), set);
            }
            return set;
        }
        return this.o.a(jsonNode, jsonNode2, string, bl);
    }
}

