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
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cm
 */
public class cm_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cm_2.class);
    private static final ArrayList<String> i = new ArrayList<String>(Arrays.asList("if", "then", "else"));
    private final cp_2 j;
    private final cp_2 k;
    private final cp_2 l;

    public cm_2(String object, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super((String)object, jsonNode, cp_22, dj_2.IF_THEN_ELSE, df_22);
        object = null;
        cp_2 cp_23 = null;
        cp_2 cp_24 = null;
        for (String string : i) {
            JsonNode jsonNode2 = jsonNode.get(string);
            if (string.equals("if")) {
                object = new cp_2(df_22, this.e().a(), cp_22.i(), jsonNode2, cp_22);
                continue;
            }
            if (string.equals("then") && jsonNode2 != null) {
                cp_23 = new cp_2(df_22, this.e().a(), cp_22.i(), jsonNode2, cp_22);
                continue;
            }
            if (!string.equals("else") || jsonNode2 == null) continue;
            cp_24 = new cp_2(df_22, this.e().a(), cp_22.i(), jsonNode2, cp_22);
        }
        this.j = object;
        this.k = cp_23;
        this.l = cp_24;
    }

    @Override
    public Set<dg_2> a(JsonNode iterable, JsonNode iterable2, String string) {
        LinkedHashSet<dg_2> linkedHashSet;
        block15: {
            Object object;
            block14: {
                this.a(g, (JsonNode)iterable, (JsonNode)iterable2, string);
                object = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
                Object object2 = null;
                Object object3 = null;
                Object object4 = null;
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
                linkedHashSet = new LinkedHashSet<dg_2>();
                boolean bl = false;
                try {
                    try {
                        bl = this.j.a((JsonNode)iterable, (JsonNode)iterable2, string).isEmpty();
                    }
                    catch (cq_2 cq_22) {
                        bl = false;
                    }
                    object2 = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
                    if (bl && this.k != null) {
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
                        linkedHashSet.addAll(this.k.a((JsonNode)iterable, (JsonNode)iterable2, string));
                        object3 = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
                    } else if (!bl && this.l != null) {
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
                        linkedHashSet.addAll(this.l.a((JsonNode)iterable, (JsonNode)iterable2, string));
                        object4 = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
                    }
                    if (!linkedHashSet.isEmpty()) break block14;
                    Iterable iterable3 = iterable = object == null ? new ArrayList() : (List)object;
                }
                catch (Throwable throwable) {
                    if (linkedHashSet.isEmpty()) {
                        Iterable iterable4 = iterable2 = object == null ? new ArrayList() : (List)object;
                        if (object2 != null && bl) {
                            iterable2.addAll((List)object2);
                        }
                        if (object3 != null) {
                            iterable2.addAll((List)object3);
                        }
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable2);
                    } else {
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
                    }
                    throw throwable;
                }
                if (object2 != null && bl) {
                    iterable.addAll((List)object2);
                }
                if (object3 != null) {
                    iterable.addAll((List)object3);
                }
                if (object4 != null) {
                    iterable.addAll((List)object4);
                }
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable);
                break block15;
            }
            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Override
    public void a_() {
        if (this.j != null) {
            this.j.o();
        }
        if (this.k != null) {
            this.k.o();
        }
        if (this.l != null) {
            this.l.o();
        }
    }
}

