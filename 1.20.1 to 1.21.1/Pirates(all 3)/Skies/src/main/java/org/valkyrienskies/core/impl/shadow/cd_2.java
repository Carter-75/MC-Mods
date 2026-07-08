/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cz_1;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cd
 */
public class cd_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cd_2.class);
    private final Set<JsonNode> i;
    private final String j;

    public cd_2(String charSequence, JsonNode object, cp_2 cp_22, df_2 df_22) {
        super((String)charSequence, (JsonNode)object, cp_22, dj_2.ENUM, df_22);
        this.d = df_22;
        if (object != null && ((JsonNode)object).isArray()) {
            this.i = new HashSet<JsonNode>();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append('[');
            String string = "";
            object = ((JsonNode)object).iterator();
            while (object.hasNext()) {
                JsonNode jsonNode = (JsonNode)object.next();
                if (jsonNode.isNumber()) {
                    this.i.add(DecimalNode.valueOf(jsonNode.decimalValue()));
                } else {
                    this.i.add(jsonNode);
                }
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append(jsonNode.asText());
                string = ", ";
            }
            if (df_22.d().e() && (object = cp_22.c().get("nullable")) != null && ((JsonNode)object).asBoolean()) {
                this.i.add(NullNode.getInstance());
                string = ", ";
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append("null");
            }
            ((StringBuilder)charSequence).append(']');
            this.j = ((StringBuilder)charSequence).toString();
        } else {
            this.i = Collections.emptySet();
            this.j = "[none]";
        }
        cd_2 cd_22 = this;
        cd_22.a(cd_22.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        this.a(g, jsonNode, (JsonNode)iterable, string);
        iterable = new LinkedHashSet();
        if (jsonNode.isNumber()) {
            jsonNode = DecimalNode.valueOf(jsonNode.decimalValue());
        }
        if (!(this.i.contains(jsonNode) || this.d.d().a() && this.b(jsonNode))) {
            iterable.add(this.a(string, this.j));
        }
        return Collections.unmodifiableSet(iterable);
    }

    private boolean b(JsonNode object) {
        if (cz_1.a((JsonNode)object, this.d.d()) == cu_2.STRING) {
            object = ((JsonNode)object).textValue();
            for (JsonNode jsonNode : this.i) {
                String object2 = jsonNode.asText();
                if (object2 == null || !object2.equals(object)) continue;
                return true;
            }
        }
        return false;
    }
}

