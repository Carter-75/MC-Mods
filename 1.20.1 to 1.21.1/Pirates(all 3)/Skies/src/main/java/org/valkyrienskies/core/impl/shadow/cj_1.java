/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.ce_2;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cr_1;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.di_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cJ
 */
public class cj_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cj_1.class);
    private final List<a> i = new ArrayList<a>();

    public cj_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.ONE_OF, df_22);
        int n2 = jsonNode.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            JsonNode jsonNode2 = jsonNode.get(i2);
            cp_2 cp_23 = new cp_2(df_22, this.e().a(), cp_22.i(), jsonNode2, cp_22);
            this.i.add(new a(jsonNode2, cp_22, df_22, cp_23));
        }
        cj_1 cj_12 = this;
        cj_12.a(cj_12.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        Set<dg_2> set;
        block17: {
            Object object;
            block16: {
                Collection<dg_2> collection;
                LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
                object = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
                try {
                    this.a(g, jsonNode, (JsonNode)iterable, string);
                    di_2 di_22 = (di_2)bv_1.a().a("com.networknt.schema.ValidatorState");
                    di_22.b(true);
                    int n2 = 0;
                    LinkedHashSet<dg_2> set2 = new LinkedHashSet();
                    for (a a2 : this.i) {
                        di_22.a(true);
                        cp_2 set3 = a2.a;
                        collection = !di_22.c() ? set3.a(jsonNode, (JsonNode)iterable, string) : ((bt_1)set3).a(jsonNode, (JsonNode)iterable, string, di_22.d());
                        if (collection.isEmpty()) {
                            if (!di_22.a()) continue;
                            ++n2;
                        }
                        if (n2 > 1) {
                            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
                            break;
                        }
                        set2.addAll(collection);
                    }
                    Set set4 = set2.stream().filter(dg_22 -> !dj_2.REQUIRED.a().equals(dg_22.g())).collect(Collectors.toSet());
                    if (n2 > 1) {
                        dg_2 dg_24 = this.b(string);
                        if (this.e) {
                            throw new cq_2(dg_24);
                        }
                        linkedHashSet.add(dg_24);
                    } else if (n2 <= 0) {
                        if (!set4.isEmpty()) {
                            set2 = set4;
                        }
                        if (!set2.isEmpty()) {
                            LinkedHashSet<dg_2> linkedHashSet2;
                            if (set2.size() > 1 && (linkedHashSet2 = new LinkedHashSet<dg_2>(set2.stream().filter(dg_22 -> !dj_2.ADDITIONAL_PROPERTIES.a().equals(dg_22.g())).sorted((dg_22, dg_23) -> cj_1.a(dg_22, dg_23)).collect(Collectors.toList()))).size() > 0) {
                                set2 = linkedHashSet2;
                            }
                            linkedHashSet.addAll(set2);
                        }
                        if (this.e) {
                            throw new cq_2(((Object)linkedHashSet).toString());
                        }
                    }
                    if (linkedHashSet.isEmpty()) {
                        di_22.a(true);
                    }
                    this.i();
                    set = Collections.unmodifiableSet(linkedHashSet);
                    if (!linkedHashSet.isEmpty()) break block16;
                    collection = object == null ? new ArrayList() : (List)object;
                }
                catch (Throwable throwable) {
                    if (linkedHashSet.isEmpty()) {
                        iterable = object == null ? new ArrayList() : (List)object;
                        iterable.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable);
                    } else {
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
                    }
                    throw throwable;
                }
                collection.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", collection);
                break block17;
            }
            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
        }
        return set;
    }

    private static int a(dg_2 dg_22, dg_2 dg_23) {
        List<String> list = Arrays.asList(dj_2.TYPE.a(), dj_2.DATETIME.a(), dj_2.UUID.a(), dj_2.ID.a(), dj_2.EXCLUSIVE_MAXIMUM.a(), dj_2.EXCLUSIVE_MINIMUM.a(), dj_2.TRUE.a(), dj_2.FALSE.a(), dj_2.CONST.a(), dj_2.CONTAINS.a(), dj_2.PROPERTYNAMES.a());
        int n2 = list.indexOf(dg_22.g());
        int n3 = list.indexOf(dg_23.g());
        if (n2 >= 0) {
            if (n3 >= 0) {
                return Integer.compare(n2, n3);
            }
            return -1;
        }
        if (n3 >= 0) {
            return 1;
        }
        return dg_22.a().compareTo(dg_23.a());
    }

    private void i() {
        di_2 di_22 = (di_2)bv_1.a().a("com.networknt.schema.ValidatorState");
        di_22.b(false);
        di_22.a(true);
    }

    public List<cp_2> h() {
        ArrayList<cp_2> arrayList = new ArrayList<cp_2>();
        for (a a2 : this.i) {
            arrayList.add(a2.a());
        }
        return arrayList;
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        if (bl) {
            linkedHashSet.addAll(this.a(jsonNode, jsonNode2, string));
        } else {
            for (a a2 : this.i) {
                ((bt_1)a2.a).a(jsonNode, jsonNode2, string, bl);
            }
        }
        return linkedHashSet;
    }

    private dg_2 b(String string) {
        String string2 = "";
        for (a a2 : this.i) {
            String object = a2.a().c().toString();
            string2 = string2.concat(object);
        }
        return dg_2.a(this.e().a(), (ce_2)dj_2.ONE_OF, string, this.a, string2);
    }

    @Override
    public void a_() {
        for (a a2 : this.i) {
            a2.a().o();
        }
    }

    static class a {
        private final cp_2 a;
        private final Map<String, String> b;

        a(JsonNode jsonNode, cp_2 cp_22, df_2 df_22, cp_2 cp_23) {
            JsonNode jsonNode2 = jsonNode.get(dj_2.REF.a());
            cp_22 = jsonNode2 != null && jsonNode2.isTextual() ? cr_1.a(cp_22, df_22, jsonNode2.textValue()).a() : null;
            this.b = this.a(jsonNode, cp_22);
            this.a = cp_23;
        }

        private Map<String, String> a(JsonNode object, cp_2 object2) {
            object2 = object2 != null ? this.b(((bt_1)object2).c()) : Collections.emptyMap();
            object = this.b((JsonNode)object);
            if (object2.isEmpty()) {
                return object;
            }
            if (object.isEmpty()) {
                return object2;
            }
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.putAll((Map<String, String>)object);
            hashMap.putAll((Map<String, String>)object2);
            return hashMap;
        }

        private Map<String, String> b(JsonNode jsonNode) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            if (!jsonNode.isObject()) {
                return hashMap;
            }
            if ((jsonNode = jsonNode.get("properties")) == null || !jsonNode.isObject()) {
                return hashMap;
            }
            Iterator<String> iterator2 = jsonNode.fieldNames();
            while (iterator2.hasNext()) {
                String string = iterator2.next();
                Object object = jsonNode.get(string);
                if ((object = this.c((JsonNode)object)) == null || ((String)object).isEmpty()) continue;
                hashMap.put(string, (String)object);
            }
            return hashMap;
        }

        private String c(JsonNode jsonNode) {
            if (jsonNode == null || !jsonNode.isObject() || !jsonNode.has("enum")) {
                return null;
            }
            if ((jsonNode = jsonNode.get("enum")) == null || !jsonNode.isArray()) {
                return null;
            }
            if (jsonNode.size() != 1) {
                return null;
            }
            if ((jsonNode = jsonNode.get(0)) == null || !jsonNode.isTextual()) {
                return null;
            }
            return jsonNode.textValue();
        }

        public boolean a(JsonNode jsonNode) {
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                boolean bl;
                JsonNode jsonNode2 = jsonNode.get(entry.getKey());
                if (jsonNode2 == null || !jsonNode2.isTextual() || (bl = entry.getValue().equals(jsonNode2.textValue()))) continue;
                return false;
            }
            return true;
        }

        private cp_2 a() {
            return this.a;
        }
    }
}

