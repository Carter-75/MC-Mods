/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.am
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ad_2;
import org.valkyrienskies.core.impl.shadow.ae_2;
import org.valkyrienskies.core.impl.shadow.ag_2;
import org.valkyrienskies.core.impl.shadow.am;
import org.valkyrienskies.core.impl.shadow.am_2;
import org.valkyrienskies.core.impl.shadow.ao_2;
import org.valkyrienskies.core.impl.shadow.aq_2;
import org.valkyrienskies.core.impl.shadow.fs_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ai
 */
public final class ai_2 {
    public final List<ad_2> a = new ArrayList<ad_2>();
    public final EnumSet<ae_2> b;

    public ai_2(EnumSet<ae_2> enumSet) {
        this.b = enumSet.clone();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static JsonNode a(JsonNode var0, JsonNode var1_1) {
        block28: {
            block30: {
                block29: {
                    var2_2 = ae_2.a();
                    var3_3 = new ai_2(var2_2);
                    if (var0 == null && var1_1 != null) {
                        var3_3.a.add(ad_2.a(aq_2.ADD, am.b, (JsonNode)var1_1));
                    }
                    if (var0 != null && var1_1 == null) {
                        var3_3.a.add(ad_2.a(aq_2.REMOVE, am.b, (JsonNode)var0));
                    }
                    if (var0 == null || var1_1 == null) break block28;
                    var3_3.a(am.b, (JsonNode)var0, (JsonNode)var1_1);
                    if (var2_2.contains((Object)ae_2.OMIT_MOVE_OPERATION)) break block29;
                    var4_4 = var3_3;
                    block6: for (var5_5 = 0; var5_5 < var4_4.a.size(); ++var5_5) {
                        var13_21 = var6_10 = var4_4.a.get(var5_5);
                        if (aq_2.REMOVE != var13_21.a) {
                            var13_21 = var6_10;
                            if (aq_2.ADD != var13_21.a) continue;
                        }
                        for (var7_11 = var5_5 + 1; var7_11 < var4_4.a.size(); ++var7_11) {
                            var8_16 = var4_4.a.get(var7_11);
                            var13_21 = var6_10;
                            var13_21 = var8_16;
                            if (!v0.c.equals(var13_21.c)) continue;
                            var9_19 = null;
                            var13_21 = var6_10;
                            if (aq_2.REMOVE != var13_21.a) ** GOTO lbl-1000
                            var13_21 = var8_16;
                            if (aq_2.ADD == var13_21.a) {
                                var13_21 = var8_16;
                                var10_20 = ai_2.a(var13_21.b, var5_5 + 1, var7_11 - 1, var4_4.a);
                                var13_21 = var6_10;
                                var9_19 = new ad_2(aq_2.MOVE, var13_21.b, (am_2)var10_20);
                            } else lbl-1000:
                            // 2 sources

                            {
                                var13_21 = var6_10;
                                if (aq_2.ADD == var13_21.a) {
                                    var13_21 = var8_16;
                                    if (aq_2.REMOVE == var13_21.a) {
                                        var13_21 = var8_16;
                                        var10_20 = ai_2.a(var13_21.b, var5_5, var7_11 - 1, var4_4.a);
                                        var13_21 = var6_10;
                                        var9_19 = new ad_2(aq_2.MOVE, (am_2)var10_20, var13_21.b);
                                    }
                                }
                            }
                            if (var9_19 == null) continue;
                            var4_4.a.remove(var7_11);
                            var4_4.a.set(var5_5, (ad_2)var9_19);
                            continue block6;
                        }
                    }
                }
                if (var2_2.contains((Object)ae_2.OMIT_COPY_OPERATION)) break block30;
                var6_10 = var1_1;
                var5_6 = var0;
                var4_4 = var3_3;
                var1_1 = var6_10;
                var0 = var5_6;
                var11_22 = new HashMap<JsonNode, am_2>();
                ai_2.a(var11_22, am.b, (JsonNode)var0, (JsonNode)var1_1);
                var7_12 = var11_22;
                for (var8_17 = 0; var8_17 < var4_4.a.size(); ++var8_17) {
                    var13_21 = var9_19 = var4_4.a.get(var8_17);
                    if (aq_2.ADD != var13_21.a) continue;
                    var13_21 = var9_19;
                    var0 = var7_12;
                    var1_1 = var13_21.c;
                    var10_20 = (am)var0.get(var1_1);
                    if (var10_20 == null) continue;
                    var13_21 = var9_19;
                    var1_1 = var13_21.b;
                    var0 = var10_20;
                    var11_23 = var0.equals(var1_1);
                    var12_24 = 0;
                    var5_7 = 0;
                    while (true) {
                        var13_21 = var0;
                        if (var12_24 >= var13_21.a.length) break;
                        var13_21 = var1_1;
                        if (var5_7 >= var13_21.a.length) break;
                        var6_10 = var0.b(var12_24);
                        var13_21 = var1_1.b(var5_7);
                        var6_10 = var6_10.toString();
                        var13_21 = var13_21.toString();
                        if (!ai_2.a((String)var6_10) || !ai_2.a((String)var13_21) || var6_10.compareTo((String)var13_21) <= 0) {
                            ++var12_24;
                            ++var5_7;
                            continue;
                        }
                        ** GOTO lbl-1000
                        break;
                    }
                    if (!var11_23) {
                        v1 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        v1 = false;
                    }
                    if (!v1) continue;
                    if (var4_4.b.contains((Object)ae_2.EMIT_TEST_OPERATIONS)) {
                        var13_21 = var9_19;
                        var4_4.a.add(var8_17, new ad_2(aq_2.TEST, (am_2)var10_20, var13_21.c));
                        ++var8_17;
                    }
                    var13_21 = var9_19;
                    var4_4.a.set(var8_17, new ad_2(aq_2.COPY, (am_2)var10_20, var13_21.b));
                }
            }
            if (!var2_2.contains((Object)ae_2.ADD_EXPLICIT_REMOVE_ADD_ON_REPLACE)) break block28;
            var4_4 = var3_3;
            var5_8 = new ArrayList<ad_2>();
            for (ad_2 var7_14 : var4_4.a) {
                block32: {
                    block31: {
                        var13_21 = var7_14;
                        if (!var7_14.a.equals((Object)aq_2.REPLACE)) break block31;
                        var13_21 = var7_14;
                        if (var13_21.e != null) break block32;
                    }
                    var5_8.add(var7_14);
                    continue;
                }
                v2 = var7_14;
                var13_21 = v2;
                var13_21 = var7_14;
                var5_8.add(new ad_2(aq_2.REMOVE, v2.b, var13_21.e));
                v3 = var7_14;
                var13_21 = v3;
                var13_21 = var7_14;
                var5_8.add(new ad_2(aq_2.ADD, v3.b, var13_21.c));
            }
            var4_4.a.clear();
            var4_4.a.addAll(var5_8);
        }
        var4_4 = var3_3;
        var5_9 = JsonNodeFactory.instance;
        var6_10 = var5_9.arrayNode();
        for (ad_2 var8_18 : var4_4.a) {
            var1_1 = var4_4.b;
            var0 = var8_18;
            var10_20 = var5_9;
            var11_22 = var10_20.objectNode();
            var13_21 = var0;
            var12_26 /* !! */  = var13_21.a;
            var11_22.put("op", var12_26 /* !! */ .rfcName);
            var13_21 = var0;
            switch (1_0.b[var13_21.a.ordinal()]) {
                case 1: 
                case 2: {
                    var13_21 = var0;
                    var11_22.put("from", var13_21.b.toString());
                    var12_26 /* !! */  = var0;
                    var11_22.put("path", var12_26 /* !! */ .d.toString());
                    break;
                }
                case 3: {
                    var13_21 = var0;
                    var11_22.put("path", var13_21.b.toString());
                    if (var1_1.contains((Object)ae_2.OMIT_VALUE_ON_REMOVE)) break;
                    var13_21 = var0;
                    var11_22.set("value", var13_21.c);
                    break;
                }
                case 4: {
                    if (var1_1.contains((Object)ae_2.ADD_ORIGINAL_VALUE_ON_REPLACE)) {
                        var13_21 = var0;
                        var11_22.set("fromValue", var13_21.e);
                    }
                }
                case 5: 
                case 6: {
                    var13_21 = var0;
                    var11_22.put("path", var13_21.b.toString());
                    var13_21 = var0;
                    var11_22.set("value", var13_21.c);
                    break;
                }
                default: {
                    var13_21 = var0;
                    throw new IllegalArgumentException("Unknown operation specified:" + (Object)var13_21.a);
                }
            }
            var9_19 = var11_22;
            var6_10.add((JsonNode)var9_19);
        }
        return var6_10;
    }

    private static JsonNode a(JsonNode jsonNode, JsonNode jsonNode2, EnumSet<ae_2> enumSet) {
        ai_2 ai_22 = new ai_2(enumSet);
        if (jsonNode == null && jsonNode2 != null) {
            ai_22.a.add(ad_2.a(aq_2.ADD, am.b, jsonNode2));
        }
        if (jsonNode != null && jsonNode2 == null) {
            ai_22.a.add(ad_2.a(aq_2.REMOVE, am.b, jsonNode));
        }
        if (jsonNode != null && jsonNode2 != null) {
            ai_22.a(am.b, jsonNode, jsonNode2);
            if (!enumSet.contains((Object)ae_2.OMIT_MOVE_OPERATION)) {
                ai_22.a();
            }
            if (!enumSet.contains((Object)ae_2.OMIT_COPY_OPERATION)) {
                ai_22.b(jsonNode, jsonNode2);
            }
            if (enumSet.contains((Object)ae_2.ADD_EXPLICIT_REMOVE_ADD_ON_REPLACE)) {
                ai_22.b();
            }
        }
        return ai_22.c();
    }

    private static am_2 a(Map<JsonNode, am_2> map2, JsonNode jsonNode) {
        return (am)map2.get(jsonNode);
    }

    private void b(JsonNode object, JsonNode jsonNode) {
        object = ai_2.c((JsonNode)object, jsonNode);
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            ad_2 ad_22;
            ad_2 ad_23 = ad_22 = this.a.get(i2);
            if (aq_2.ADD != ad_23.a) continue;
            ad_23 = ad_22;
            am_2 am_22 = ai_2.a((Map<JsonNode, am_2>)object, ad_23.c);
            if (am_22 == null) continue;
            ad_23 = ad_22;
            if (!ai_2.a(am_22, ad_23.b)) continue;
            if (this.b.contains((Object)ae_2.EMIT_TEST_OPERATIONS)) {
                ad_23 = ad_22;
                this.a.add(i2, new ad_2(aq_2.TEST, am_22, ad_23.c));
                ++i2;
            }
            ad_23 = ad_22;
            this.a.set(i2, new ad_2(aq_2.COPY, am_22, ad_23.b));
        }
    }

    public static boolean a(String string) {
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (Character.isDigit(string.charAt(i2))) continue;
            return false;
        }
        return n2 > 0;
    }

    private static boolean a(am_2 am_22, am_2 am_23) {
        boolean bl = am_22.equals(am_23);
        int n2 = 0;
        int n3 = 0;
        while (true) {
            Object object = am_22;
            if (n2 >= ((am)object).a.length) break;
            object = am_23;
            if (n3 >= ((am)object).a.length) break;
            object = am_22.b(n2);
            Object object2 = am_23.b(n3);
            object = ((am_2.a)object).toString();
            object2 = ((am_2.a)object2).toString();
            if (ai_2.a((String)object) && ai_2.a((String)object2) && ((String)object).compareTo((String)object2) > 0) {
                return false;
            }
            ++n2;
            ++n3;
        }
        return !bl;
    }

    private static Map<JsonNode, am_2> c(JsonNode jsonNode, JsonNode jsonNode2) {
        HashMap<JsonNode, am_2> hashMap = new HashMap<JsonNode, am_2>();
        ai_2.a(hashMap, am.b, jsonNode, jsonNode2);
        return hashMap;
    }

    public static void a(Map<JsonNode, am_2> map2, am_2 am_22, JsonNode jsonNode, JsonNode jsonNode2) {
        ao_2 ao_22;
        if (jsonNode.equals(jsonNode2)) {
            if (!map2.containsKey(jsonNode2)) {
                map2.put(jsonNode2, am_22);
            }
            return;
        }
        ao_2 ao_23 = ao_2.a(jsonNode);
        if (ao_23 == (ao_22 = ao_2.a(jsonNode2))) {
            switch (ao_23) {
                case OBJECT: {
                    ai_2.c(map2, am_22, jsonNode, jsonNode2);
                    return;
                }
                case ARRAY: {
                    ai_2.b(map2, am_22, jsonNode, jsonNode2);
                }
            }
        }
    }

    private static void b(Map<JsonNode, am_2> map2, am_2 am_22, JsonNode jsonNode, JsonNode jsonNode2) {
        int n2 = Math.min(jsonNode.size(), jsonNode2.size());
        for (int i2 = 0; i2 < n2; ++i2) {
            am_2 am_23 = am_22.a(i2);
            ai_2.a(map2, am_23, jsonNode.get(i2), jsonNode2.get(i2));
        }
    }

    private static void c(Map<JsonNode, am_2> map2, am_2 am_22, JsonNode jsonNode, JsonNode jsonNode2) {
        Iterator<String> iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            String string = iterator2.next();
            if (!jsonNode2.has(string)) continue;
            am_2 am_23 = am_22.b(string);
            ai_2.a(map2, am_23, jsonNode.get(string), jsonNode2.get(string));
        }
    }

    /*
     * Unable to fully structure code
     */
    private void a() {
        block0: for (var1_1 = 0; var1_1 < this.a.size(); ++var1_1) {
            var6_6 = var2_2 = this.a.get(var1_1);
            if (aq_2.REMOVE != var6_6.a) {
                var6_6 = var2_2;
                if (aq_2.ADD != var6_6.a) continue;
            }
            for (var3_3 = var1_1 + 1; var3_3 < this.a.size(); ++var3_3) {
                var4_4 = this.a.get(var3_3);
                var6_6 = var2_2;
                var6_6 = var4_4;
                if (!v0.c.equals(var6_6.c)) continue;
                var5_5 = null;
                var6_6 = var2_2;
                if (aq_2.REMOVE != var6_6.a) ** GOTO lbl-1000
                var6_6 = var4_4;
                if (aq_2.ADD == var6_6.a) {
                    var6_6 = var4_4;
                    var4_4 = ai_2.a(var6_6.b, var1_1 + 1, var3_3 - 1, this.a);
                    var6_6 = var2_2;
                    var5_5 = new ad_2(aq_2.MOVE, var6_6.b, (am_2)var4_4);
                } else lbl-1000:
                // 2 sources

                {
                    var6_6 = var2_2;
                    if (aq_2.ADD == var6_6.a) {
                        var6_6 = var4_4;
                        if (aq_2.REMOVE == var6_6.a) {
                            var6_6 = var4_4;
                            var4_4 = ai_2.a(var6_6.b, var1_1, var3_3 - 1, this.a);
                            var6_6 = var2_2;
                            var5_5 = new ad_2(aq_2.MOVE, (am_2)var4_4, var6_6.b);
                        }
                    }
                }
                if (var5_5 == null) continue;
                this.a.remove(var3_3);
                this.a.set(var1_1, var5_5);
                continue block0;
            }
        }
    }

    private void b() {
        ArrayList<ad_2> arrayList = new ArrayList<ad_2>();
        Iterator<ad_2> iterator2 = this.a.iterator();
        while (iterator2.hasNext()) {
            ad_2 ad_22;
            ad_2 ad_23;
            block4: {
                block3: {
                    ad_22 = ad_23 = iterator2.next();
                    if (!ad_23.a.equals((Object)aq_2.REPLACE)) break block3;
                    ad_22 = ad_23;
                    if (ad_22.e != null) break block4;
                }
                arrayList.add(ad_23);
                continue;
            }
            ad_2 ad_24 = ad_23;
            ad_22 = ad_24;
            ad_22 = ad_23;
            arrayList.add(new ad_2(aq_2.REMOVE, ad_24.b, ad_22.e));
            ad_2 ad_25 = ad_23;
            ad_22 = ad_25;
            ad_22 = ad_23;
            arrayList.add(new ad_2(aq_2.ADD, ad_25.b, ad_22.c));
        }
        this.a.clear();
        this.a.addAll(arrayList);
    }

    public static am_2 a(am_2 am_22, int n2, int n3, List<ad_2> list) {
        Object object = am_22;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(((am)object).a.length);
        int n4 = 0;
        while (true) {
            object = am_22;
            if (n4 >= ((am)object).a.length) break;
            arrayList.add(0);
            ++n4;
        }
        for (n4 = n2; n4 <= n3; ++n4) {
            ad_2 ad_22 = list.get(n4);
            object = ad_22;
            if (aq_2.ADD != ((ad_2)object).a) {
                object = ad_22;
                if (aq_2.REMOVE != ((ad_2)object).a) continue;
            }
            ai_2.a(am_22, ad_22, arrayList);
        }
        return ai_2.a(arrayList, am_22);
    }

    private static am_2 a(List<Integer> list, am_2 object) {
        object = object.c();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            int n2 = list.get(i2);
            if (n2 == 0) continue;
            int n3 = ((am_2.a)object.get(i2)).b();
            object.set(i2, new am_2.a(Integer.toString(n3 + n2)));
        }
        return new am((List)object);
    }

    private static void a(am_2 am_22, ad_2 ad_22, List<Integer> list) {
        Object object = ad_22;
        am_2 am_23 = ((ad_2)object).b;
        object = am_23;
        object = am_22;
        if (((am)am_23).a.length <= ((am)object).a.length) {
            int n2 = -1;
            int n3 = 0;
            while (true) {
                object = ad_22;
                object = ((ad_2)object).b;
                if (n3 >= ((am)object).a.length - 1) break;
                object = ad_22;
                if (!((ad_2)object).b.b(n3).equals(am_22.b(n3))) break;
                n2 = n3++;
            }
            object = ad_22;
            object = ((ad_2)object).b;
            if (n2 == ((am)object).a.length - 2) {
                ad_2 ad_23;
                object = ad_22;
                object = ad_22;
                object = ((ad_2)object).b;
                if (ad_23.b.b(((am)object).a.length - 1).a()) {
                    ad_2 ad_24 = ad_22;
                    object = ad_24;
                    object = ad_24.b;
                    ai_2.a(ad_24, ((am)object).a.length - 1, list);
                }
            }
        }
    }

    private static void a(ad_2 ad_22, int n2, List<Integer> list) {
        ad_2 ad_23 = ad_22;
        if (aq_2.ADD == ad_23.a) {
            list.set(n2, list.get(n2) - 1);
            return;
        }
        ad_23 = ad_22;
        if (aq_2.REMOVE == ad_23.a) {
            list.set(n2, list.get(n2) + 1);
        }
    }

    private ArrayNode c() {
        JsonNodeFactory jsonNodeFactory = JsonNodeFactory.instance;
        ArrayNode arrayNode = jsonNodeFactory.arrayNode();
        for (ad_2 ad_22 : this.a) {
            ObjectNode object = ai_2.a(jsonNodeFactory, ad_22, this.b);
            arrayNode.add(object);
        }
        return arrayNode;
    }

    private static ObjectNode a(JsonNodeFactory jsonNodeCreator, ad_2 ad_22, EnumSet<ae_2> enumSet) {
        jsonNodeCreator = ((JsonNodeFactory)jsonNodeCreator).objectNode();
        Object object = ad_22;
        object = object.a;
        ((ObjectNode)jsonNodeCreator).put("op", ((aq_2)((Object)object)).rfcName);
        object = ad_22;
        switch (object.a) {
            case MOVE: 
            case COPY: {
                object = ad_22;
                ((ObjectNode)jsonNodeCreator).put("from", object.b.toString());
                object = ad_22;
                ((ObjectNode)jsonNodeCreator).put("path", object.d.toString());
                break;
            }
            case REMOVE: {
                object = ad_22;
                ((ObjectNode)jsonNodeCreator).put("path", object.b.toString());
                if (enumSet.contains((Object)ae_2.OMIT_VALUE_ON_REMOVE)) break;
                object = ad_22;
                ((ObjectNode)jsonNodeCreator).set("value", object.c);
                break;
            }
            case REPLACE: {
                if (enumSet.contains((Object)ae_2.ADD_ORIGINAL_VALUE_ON_REPLACE)) {
                    object = ad_22;
                    ((ObjectNode)jsonNodeCreator).set("fromValue", object.e);
                }
            }
            case ADD: 
            case TEST: {
                object = ad_22;
                ((ObjectNode)jsonNodeCreator).put("path", object.b.toString());
                object = ad_22;
                ((ObjectNode)jsonNodeCreator).set("value", object.c);
                break;
            }
            default: {
                object = ad_22;
                throw new IllegalArgumentException("Unknown operation specified:" + (Object)((Object)object.a));
            }
        }
        return jsonNodeCreator;
    }

    public void a(am_2 am_22, JsonNode jsonNode, JsonNode jsonNode2) {
        if (!jsonNode.equals(jsonNode2)) {
            ao_2 ao_22 = ao_2.a(jsonNode);
            ao_2 ao_23 = ao_2.a(jsonNode2);
            if (ao_22 == ao_2.ARRAY && ao_23 == ao_2.ARRAY) {
                this.b(am_22, jsonNode, jsonNode2);
                return;
            }
            if (ao_22 == ao_2.OBJECT && ao_23 == ao_2.OBJECT) {
                this.c(am_22, jsonNode, jsonNode2);
                return;
            }
            if (this.b.contains((Object)ae_2.EMIT_TEST_OPERATIONS)) {
                this.a.add(new ad_2(aq_2.TEST, am_22, jsonNode));
            }
            this.a.add(ad_2.a(aq_2.REPLACE, am_22, jsonNode, jsonNode2));
        }
    }

    private void b(am_2 am_22, JsonNode jsonNode, JsonNode jsonNode2) {
        Object object;
        JsonNode jsonNode3;
        Object object2;
        List<JsonNode> list = ai_2.d(jsonNode, jsonNode2);
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = jsonNode.size();
        int n6 = jsonNode2.size();
        int n7 = list.size();
        int n8 = 0;
        while (n4 < n7) {
            object2 = list.get(n4);
            jsonNode3 = jsonNode.get(n2);
            object = jsonNode2.get(n3);
            if (((JsonNode)object2).equals(jsonNode3) && ((JsonNode)object2).equals(object)) {
                ++n2;
                ++n3;
                ++n4;
                ++n8;
                continue;
            }
            if (((JsonNode)object2).equals(jsonNode3)) {
                object2 = am_22.a(n8);
                this.a.add(ad_2.a(aq_2.ADD, (am_2)object2, (JsonNode)object));
                ++n8;
                ++n3;
                continue;
            }
            if (((JsonNode)object2).equals(object)) {
                object2 = am_22.a(n8);
                if (this.b.contains((Object)ae_2.EMIT_TEST_OPERATIONS)) {
                    this.a.add(new ad_2(aq_2.TEST, (am_2)object2, jsonNode3));
                }
                this.a.add(ad_2.a(aq_2.REMOVE, (am_2)object2, jsonNode3));
                ++n2;
                continue;
            }
            object2 = am_22.a(n8);
            this.a((am_2)object2, jsonNode3, (JsonNode)object);
            ++n2;
            ++n3;
            ++n8;
        }
        while (n2 < n5 && n3 < n6) {
            object2 = jsonNode.get(n2);
            jsonNode3 = jsonNode2.get(n3);
            object = am_22.a(n8);
            this.a((am_2)object, (JsonNode)object2, jsonNode3);
            ++n2;
            ++n3;
            ++n8;
        }
        n8 = this.a(am_22, jsonNode2, n8, n3, n6);
        this.a(am_22, n8, n2, n5, jsonNode);
    }

    private void a(am_2 am_22, int n2, int n3, int n4, JsonNode jsonNode) {
        while (n3 < n4) {
            am_2 am_23 = am_22.a(n2);
            if (this.b.contains((Object)ae_2.EMIT_TEST_OPERATIONS)) {
                this.a.add(new ad_2(aq_2.TEST, am_23, jsonNode.get(n3)));
            }
            this.a.add(ad_2.a(aq_2.REMOVE, am_23, jsonNode.get(n3)));
            ++n3;
        }
    }

    private int a(am_2 am_22, JsonNode jsonNode, int n2, int n3, int n4) {
        while (n3 < n4) {
            JsonNode jsonNode2 = jsonNode.get(n3);
            am_2 am_23 = am_22.a(n2);
            this.a.add(ad_2.a(aq_2.ADD, am_23, jsonNode2.deepCopy()));
            ++n2;
            ++n3;
        }
        return n2;
    }

    private void c(am_2 am_22, JsonNode jsonNode, JsonNode jsonNode2) {
        Object object;
        Object object2;
        Object object3 = jsonNode.fieldNames();
        while (object3.hasNext()) {
            object2 = object3.next();
            if (!jsonNode2.has((String)object2)) {
                object = am_22.b((String)object2);
                if (this.b.contains((Object)ae_2.EMIT_TEST_OPERATIONS)) {
                    this.a.add(new ad_2(aq_2.TEST, (am_2)object, jsonNode.get((String)object2)));
                }
                this.a.add(ad_2.a(aq_2.REMOVE, (am_2)object, jsonNode.get((String)object2)));
                continue;
            }
            object = am_22.b((String)object2);
            this.a((am_2)object, jsonNode.get((String)object2), jsonNode2.get((String)object2));
        }
        object2 = jsonNode2.fieldNames();
        while (object2.hasNext()) {
            object = (String)object2.next();
            if (jsonNode.has((String)object)) continue;
            object3 = am_22.b((String)object);
            this.a.add(ad_2.a(aq_2.ADD, (am_2)object3, jsonNode2.get((String)object)));
        }
    }

    private static List<JsonNode> d(JsonNode jsonNode, JsonNode jsonNode2) {
        return fs_2.a(ag_2.a((ArrayNode)jsonNode), ag_2.a((ArrayNode)jsonNode2));
    }
}

