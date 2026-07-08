/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cP
 */
public class cp_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cp_1.class);
    private final cp_2 i;

    public cp_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.PROPERTYNAMES, df_22);
        this.i = new cp_2(df_22, string, cp_22.i(), jsonNode, cp_22);
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        this.a(g, jsonNode, (JsonNode)iterable, string);
        iterable = new LinkedHashSet();
        Iterator<String> iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            Iterator<dg_2> iterator3 = iterator2.next();
            Object object = TextNode.valueOf((String)((Object)iterator3));
            iterator3 = this.i.a((JsonNode)object, jsonNode, string + "." + (String)((Object)iterator3));
            iterator3 = iterator3.iterator();
            while (iterator3.hasNext()) {
                object = iterator3.next();
                String string2 = ((dg_2)object).b();
                String string3 = ((dg_2)object).f();
                if (string3.startsWith(string2)) {
                    string3 = string3.substring(string2.length()).replaceFirst("^:\\s*", "");
                }
                iterable.add(this.a(((dg_2)object).b(), string3));
            }
        }
        return Collections.unmodifiableSet(iterable);
    }

    @Override
    public void a_() {
        this.i.o();
    }
}

