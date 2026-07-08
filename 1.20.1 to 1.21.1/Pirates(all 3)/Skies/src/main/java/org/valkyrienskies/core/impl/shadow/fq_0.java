/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufInputStream
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.aa_2;
import org.valkyrienskies.core.impl.shadow.ad_2;
import org.valkyrienskies.core.impl.shadow.ae_2;
import org.valkyrienskies.core.impl.shadow.ai_2;
import org.valkyrienskies.core.impl.shadow.aj_2;
import org.valkyrienskies.core.impl.shadow.am_2;
import org.valkyrienskies.core.impl.shadow.aq_2;
import org.valkyrienskies.core.impl.shadow.fn_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fq
 */
public final class fq_0
implements fn_0<JsonNode> {
    private final ObjectMapper a;

    public fq_0(ObjectMapper objectMapper) {
        Intrinsics.checkNotNullParameter((Object)objectMapper, (String)"");
        this.a = objectMapper;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    private ByteBuf a(JsonNode var1_1, JsonNode var2_2, ByteBuf var3_3) {
        block28: {
            block30: {
                block29: {
                    Intrinsics.checkNotNullParameter((Object)var1_1, (String)"");
                    Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
                    Intrinsics.checkNotNullParameter((Object)var3_3, (String)"");
                    var4_4 = ae_2.a();
                    var5_5 = new ai_2(var4_4);
                    if (var1_1 == null && var2_2 != null) {
                        var5_5.a.add(ad_2.a(aq_2.ADD, am_2.b, (JsonNode)var2_2));
                    }
                    if (var1_1 != null && var2_2 == null) {
                        var5_5.a.add(ad_2.a(aq_2.REMOVE, am_2.b, (JsonNode)var1_1));
                    }
                    if (var1_1 == null || var2_2 == null) break block28;
                    var5_5.a(am_2.b, (JsonNode)var1_1, (JsonNode)var2_2);
                    if (var4_4.contains((Object)ae_2.OMIT_MOVE_OPERATION)) break block29;
                    var6_6 = var5_5;
                    block6: for (var7_7 = 0; var7_7 < var6_6.a.size(); ++var7_7) {
                        var15_23 = var8_12 = var6_6.a.get(var7_7);
                        if (aq_2.REMOVE != var15_23.a) {
                            var15_23 = var8_12;
                            if (aq_2.ADD != var15_23.a) continue;
                        }
                        for (var9_13 = var7_7 + 1; var9_13 < var6_6.a.size(); ++var9_13) {
                            var10_18 = var6_6.a.get(var9_13);
                            var15_23 = var8_12;
                            var15_23 = var10_18;
                            if (!v0.c.equals(var15_23.c)) continue;
                            var11_21 = null;
                            var15_23 = var8_12;
                            if (aq_2.REMOVE != var15_23.a) ** GOTO lbl-1000
                            var15_23 = var10_18;
                            if (aq_2.ADD == var15_23.a) {
                                var15_23 = var10_18;
                                var12_22 = ai_2.a(var15_23.b, var7_7 + 1, var9_13 - 1, var6_6.a);
                                var15_23 = var8_12;
                                var11_21 = new ad_2(aq_2.MOVE, var15_23.b, (am_2)var12_22);
                            } else lbl-1000:
                            // 2 sources

                            {
                                var15_23 = var8_12;
                                if (aq_2.ADD == var15_23.a) {
                                    var15_23 = var10_18;
                                    if (aq_2.REMOVE == var15_23.a) {
                                        var15_23 = var10_18;
                                        var12_22 = ai_2.a(var15_23.b, var7_7, var9_13 - 1, var6_6.a);
                                        var15_23 = var8_12;
                                        var11_21 = new ad_2(aq_2.MOVE, (am_2)var12_22, var15_23.b);
                                    }
                                }
                            }
                            if (var11_21 == null) continue;
                            var6_6.a.remove(var9_13);
                            var6_6.a.set(var7_7, (ad_2)var11_21);
                            continue block6;
                        }
                    }
                }
                if (var4_4.contains((Object)ae_2.OMIT_COPY_OPERATION)) break block30;
                var8_12 = var2_2;
                var7_8 = var1_1;
                var6_6 = var5_5;
                var2_2 = var8_12;
                var1_1 = var7_8;
                var13_24 = new HashMap<JsonNode, am_2>();
                ai_2.a(var13_24, am_2.b, (JsonNode)var1_1, (JsonNode)var2_2);
                var9_14 = var13_24;
                for (var10_19 = 0; var10_19 < var6_6.a.size(); ++var10_19) {
                    var15_23 = var11_21 = var6_6.a.get(var10_19);
                    if (aq_2.ADD != var15_23.a) continue;
                    var15_23 = var11_21;
                    var1_1 = var9_14;
                    var2_2 = var15_23.c;
                    var12_22 = (am_2)var1_1.get(var2_2);
                    if (var12_22 == null) continue;
                    var15_23 = var11_21;
                    var2_2 = var15_23.b;
                    var1_1 = var12_22;
                    var13_25 = var1_1.equals(var2_2);
                    var14_26 = 0;
                    var7_9 = 0;
                    while (true) {
                        var15_23 = var1_1;
                        if (var14_26 >= var15_23.a.length) break;
                        var15_23 = var2_2;
                        if (var7_9 >= var15_23.a.length) break;
                        var8_12 = var1_1.b(var14_26);
                        var15_23 = var2_2.b(var7_9);
                        var8_12 = var8_12.toString();
                        var15_23 = var15_23.toString();
                        if (!ai_2.a((String)var8_12) || !ai_2.a((String)var15_23) || var8_12.compareTo((String)var15_23) <= 0) {
                            ++var14_26;
                            ++var7_9;
                            continue;
                        }
                        ** GOTO lbl-1000
                        break;
                    }
                    if (!var13_25) {
                        v1 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        v1 = false;
                    }
                    if (!v1) continue;
                    if (var6_6.b.contains((Object)ae_2.EMIT_TEST_OPERATIONS)) {
                        var15_23 = var11_21;
                        var6_6.a.add(var10_19, new ad_2(aq_2.TEST, (am_2)var12_22, var15_23.c));
                        ++var10_19;
                    }
                    var15_23 = var11_21;
                    var6_6.a.set(var10_19, new ad_2(aq_2.COPY, (am_2)var12_22, var15_23.b));
                }
            }
            if (!var4_4.contains((Object)ae_2.ADD_EXPLICIT_REMOVE_ADD_ON_REPLACE)) break block28;
            var6_6 = var5_5;
            var7_10 = new ArrayList<ad_2>();
            for (ad_2 var9_16 : var6_6.a) {
                block32: {
                    block31: {
                        var15_23 = var9_16;
                        if (!var9_16.a.equals((Object)aq_2.REPLACE)) break block31;
                        var15_23 = var9_16;
                        if (var15_23.e != null) break block32;
                    }
                    var7_10.add(var9_16);
                    continue;
                }
                v2 = var9_16;
                var15_23 = v2;
                var15_23 = var9_16;
                var7_10.add(new ad_2(aq_2.REMOVE, v2.b, var15_23.e));
                v3 = var9_16;
                var15_23 = v3;
                var15_23 = var9_16;
                var7_10.add(new ad_2(aq_2.ADD, v3.b, var15_23.c));
            }
            var6_6.a.clear();
            var6_6.a.addAll(var7_10);
        }
        var6_6 = var5_5;
        var7_11 = JsonNodeFactory.instance;
        var8_12 = var7_11.arrayNode();
        for (ad_2 var10_20 : var6_6.a) {
            var2_2 = var6_6.b;
            var1_1 = var10_20;
            var12_22 = var7_11;
            var13_24 = var12_22.objectNode();
            var15_23 = var1_1;
            var14_28 /* !! */  = var15_23.a;
            var13_24.put("op", var14_28 /* !! */ .rfcName);
            var15_23 = var1_1;
            switch (ai_2.1_0.b[var15_23.a.ordinal()]) {
                case 1: 
                case 2: {
                    var15_23 = var1_1;
                    var13_24.put("from", var15_23.b.toString());
                    var14_28 /* !! */  = var1_1;
                    var13_24.put("path", var14_28 /* !! */ .d.toString());
                    break;
                }
                case 3: {
                    var15_23 = var1_1;
                    var13_24.put("path", var15_23.b.toString());
                    if (var2_2.contains((Object)ae_2.OMIT_VALUE_ON_REMOVE)) break;
                    var15_23 = var1_1;
                    var13_24.set("value", var15_23.c);
                    break;
                }
                case 4: {
                    if (var2_2.contains((Object)ae_2.ADD_ORIGINAL_VALUE_ON_REPLACE)) {
                        var15_23 = var1_1;
                        var13_24.set("fromValue", var15_23.e);
                    }
                }
                case 5: 
                case 6: {
                    var15_23 = var1_1;
                    var13_24.put("path", var15_23.b.toString());
                    var15_23 = var1_1;
                    var13_24.set("value", var15_23.c);
                    break;
                }
                default: {
                    var15_23 = var1_1;
                    throw new IllegalArgumentException("Unknown operation specified:" + (Object)var15_23.a);
                }
            }
            var11_21 = var13_24;
            var8_12.add((JsonNode)var11_21);
        }
        var1_1 = var8_12;
        var1_1 = this.a.writeValueAsBytes(var1_1);
        var3_3.writeInt(((Object)var1_1).length);
        var3_3.writeBytes((byte[])var1_1);
        return var3_3;
    }

    @Override
    private JsonNode a(JsonNode jsonNode, ByteBuf object) {
        Intrinsics.checkNotNullParameter((Object)jsonNode, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        int n2 = object.readInt();
        JsonNode jsonNode2 = this.a.readTree((InputStream)new ByteBufInputStream(object, n2));
        object = jsonNode2;
        object = jsonNode;
        jsonNode = jsonNode2;
        JsonNode jsonNode3 = aj_2.a(jsonNode2, (JsonNode)object, aa_2.a());
        Intrinsics.checkNotNullExpressionValue((Object)jsonNode3, (String)"");
        return jsonNode3;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public final /* synthetic */ ByteBuf a(Object var1_1, Object var2_2, ByteBuf var3_3) {
        block28: {
            block30: {
                block29: {
                    var4_4 = var3_3;
                    var3_3 = (JsonNode)var2_2;
                    var2_2 = (JsonNode)var1_1;
                    var1_1 = this;
                    Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
                    Intrinsics.checkNotNullParameter((Object)var3_3, (String)"");
                    Intrinsics.checkNotNullParameter((Object)var4_4, (String)"");
                    var5_5 = ae_2.a();
                    var6_6 = new ai_2(var5_5);
                    if (var2_2 == null && var3_3 != null) {
                        var6_6.a.add(ad_2.a(aq_2.ADD, am_2.b, (JsonNode)var3_3));
                    }
                    if (var2_2 != null && var3_3 == null) {
                        var6_6.a.add(ad_2.a(aq_2.REMOVE, am_2.b, (JsonNode)var2_2));
                    }
                    if (var2_2 == null || var3_3 == null) break block28;
                    var6_6.a(am_2.b, (JsonNode)var2_2, (JsonNode)var3_3);
                    if (var5_5.contains((Object)ae_2.OMIT_MOVE_OPERATION)) break block29;
                    var7_7 = var6_6;
                    block6: for (var8_8 = 0; var8_8 < var7_7.a.size(); ++var8_8) {
                        var16_24 = var9_13 = var7_7.a.get(var8_8);
                        if (aq_2.REMOVE != var16_24.a) {
                            var16_24 = var9_13;
                            if (aq_2.ADD != var16_24.a) continue;
                        }
                        for (var10_14 = var8_8 + 1; var10_14 < var7_7.a.size(); ++var10_14) {
                            var11_19 = var7_7.a.get(var10_14);
                            var16_24 = var9_13;
                            var16_24 = var11_19;
                            if (!v0.c.equals(var16_24.c)) continue;
                            var12_22 = null;
                            var16_24 = var9_13;
                            if (aq_2.REMOVE != var16_24.a) ** GOTO lbl-1000
                            var16_24 = var11_19;
                            if (aq_2.ADD == var16_24.a) {
                                var16_24 = var11_19;
                                var13_23 = ai_2.a(var16_24.b, var8_8 + 1, var10_14 - 1, var7_7.a);
                                var16_24 = var9_13;
                                var12_22 = new ad_2(aq_2.MOVE, var16_24.b, (am_2)var13_23);
                            } else lbl-1000:
                            // 2 sources

                            {
                                var16_24 = var9_13;
                                if (aq_2.ADD == var16_24.a) {
                                    var16_24 = var11_19;
                                    if (aq_2.REMOVE == var16_24.a) {
                                        var16_24 = var11_19;
                                        var13_23 = ai_2.a(var16_24.b, var8_8, var10_14 - 1, var7_7.a);
                                        var16_24 = var9_13;
                                        var12_22 = new ad_2(aq_2.MOVE, (am_2)var13_23, var16_24.b);
                                    }
                                }
                            }
                            if (var12_22 == null) continue;
                            var7_7.a.remove(var10_14);
                            var7_7.a.set(var8_8, (ad_2)var12_22);
                            continue block6;
                        }
                    }
                }
                if (var5_5.contains((Object)ae_2.OMIT_COPY_OPERATION)) break block30;
                var9_13 = var3_3;
                var8_9 = var2_2;
                var7_7 = var6_6;
                var3_3 = var9_13;
                var2_2 = var8_9;
                var14_25 = new HashMap<JsonNode, am_2>();
                ai_2.a(var14_25, am_2.b, (JsonNode)var2_2, (JsonNode)var3_3);
                var10_15 = var14_25;
                for (var11_20 = 0; var11_20 < var7_7.a.size(); ++var11_20) {
                    var16_24 = var12_22 = var7_7.a.get(var11_20);
                    if (aq_2.ADD != var16_24.a) continue;
                    var16_24 = var12_22;
                    var2_2 = var10_15;
                    var3_3 = var16_24.c;
                    var13_23 = (am_2)var2_2.get(var3_3);
                    if (var13_23 == null) continue;
                    var16_24 = var12_22;
                    var3_3 = var16_24.b;
                    var2_2 = var13_23;
                    var14_26 = var2_2.equals(var3_3);
                    var15_27 = 0;
                    var8_10 = 0;
                    while (true) {
                        var16_24 = var2_2;
                        if (var15_27 >= var16_24.a.length) break;
                        var16_24 = var3_3;
                        if (var8_10 >= var16_24.a.length) break;
                        var9_13 = var2_2.b(var15_27);
                        var16_24 = var3_3.b(var8_10);
                        var9_13 = var9_13.toString();
                        var16_24 = var16_24.toString();
                        if (!ai_2.a((String)var9_13) || !ai_2.a((String)var16_24) || var9_13.compareTo((String)var16_24) <= 0) {
                            ++var15_27;
                            ++var8_10;
                            continue;
                        }
                        ** GOTO lbl-1000
                        break;
                    }
                    if (!var14_26) {
                        v1 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        v1 = false;
                    }
                    if (!v1) continue;
                    if (var7_7.b.contains((Object)ae_2.EMIT_TEST_OPERATIONS)) {
                        var16_24 = var12_22;
                        var7_7.a.add(var11_20, new ad_2(aq_2.TEST, (am_2)var13_23, var16_24.c));
                        ++var11_20;
                    }
                    var16_24 = var12_22;
                    var7_7.a.set(var11_20, new ad_2(aq_2.COPY, (am_2)var13_23, var16_24.b));
                }
            }
            if (!var5_5.contains((Object)ae_2.ADD_EXPLICIT_REMOVE_ADD_ON_REPLACE)) break block28;
            var7_7 = var6_6;
            var8_11 = new ArrayList<ad_2>();
            for (ad_2 var10_17 : var7_7.a) {
                block32: {
                    block31: {
                        var16_24 = var10_17;
                        if (!var10_17.a.equals((Object)aq_2.REPLACE)) break block31;
                        var16_24 = var10_17;
                        if (var16_24.e != null) break block32;
                    }
                    var8_11.add(var10_17);
                    continue;
                }
                v2 = var10_17;
                var16_24 = v2;
                var16_24 = var10_17;
                var8_11.add(new ad_2(aq_2.REMOVE, v2.b, var16_24.e));
                v3 = var10_17;
                var16_24 = v3;
                var16_24 = var10_17;
                var8_11.add(new ad_2(aq_2.ADD, v3.b, var16_24.c));
            }
            var7_7.a.clear();
            var7_7.a.addAll(var8_11);
        }
        var7_7 = var6_6;
        var8_12 = JsonNodeFactory.instance;
        var9_13 = var8_12.arrayNode();
        for (ad_2 var11_21 : var7_7.a) {
            var3_3 = var7_7.b;
            var2_2 = var11_21;
            var13_23 = var8_12;
            var14_25 = var13_23.objectNode();
            var16_24 = var2_2;
            var15_29 /* !! */  = var16_24.a;
            var14_25.put("op", var15_29 /* !! */ .rfcName);
            var16_24 = var2_2;
            switch (ai_2.1_0.b[var16_24.a.ordinal()]) {
                case 1: 
                case 2: {
                    var16_24 = var2_2;
                    var14_25.put("from", var16_24.b.toString());
                    var15_29 /* !! */  = var2_2;
                    var14_25.put("path", var15_29 /* !! */ .d.toString());
                    break;
                }
                case 3: {
                    var16_24 = var2_2;
                    var14_25.put("path", var16_24.b.toString());
                    if (var3_3.contains((Object)ae_2.OMIT_VALUE_ON_REMOVE)) break;
                    var16_24 = var2_2;
                    var14_25.set("value", var16_24.c);
                    break;
                }
                case 4: {
                    if (var3_3.contains((Object)ae_2.ADD_ORIGINAL_VALUE_ON_REPLACE)) {
                        var16_24 = var2_2;
                        var14_25.set("fromValue", var16_24.e);
                    }
                }
                case 5: 
                case 6: {
                    var16_24 = var2_2;
                    var14_25.put("path", var16_24.b.toString());
                    var16_24 = var2_2;
                    var14_25.set("value", var16_24.c);
                    break;
                }
                default: {
                    var16_24 = var2_2;
                    throw new IllegalArgumentException("Unknown operation specified:" + (Object)var16_24.a);
                }
            }
            var12_22 = var14_25;
            var9_13.add((JsonNode)var12_22);
        }
        var2_2 = var9_13;
        var1_1 = var1_1.a.writeValueAsBytes(var2_2);
        var4_4.writeInt(((Object)var1_1).length);
        var4_4.writeBytes((byte[])var1_1);
        return var4_4;
    }

    @Override
    public final /* synthetic */ JsonNode a(Object object, ByteBuf object2) {
        ByteBuf byteBuf = object2;
        object2 = (JsonNode)object;
        object = this;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        int n2 = byteBuf.readInt();
        JsonNode jsonNode = ((fq_0)object).a.readTree((InputStream)new ByteBufInputStream(byteBuf, n2));
        object = jsonNode;
        object = jsonNode;
        JsonNode jsonNode2 = aj_2.a(jsonNode, (JsonNode)object2, aa_2.a());
        Intrinsics.checkNotNullExpressionValue((Object)jsonNode2, (String)"");
        return jsonNode2;
    }
}

