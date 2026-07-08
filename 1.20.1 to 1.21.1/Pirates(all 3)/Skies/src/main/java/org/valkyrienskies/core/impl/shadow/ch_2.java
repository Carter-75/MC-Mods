/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
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
 * Renamed from org.valkyrienskies.core.impl.shadow.ch
 */
public class ch_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(ch_2.class);

    public ch_2(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.FALSE, df_22);
    }

    @Override
    public Set<dg_2> a(JsonNode iterable, JsonNode jsonNode, String string) {
        this.a(g, (JsonNode)iterable, jsonNode, string);
        iterable = new LinkedHashSet<dg_2>();
        iterable.add(this.a(string, new String[0]));
        return Collections.unmodifiableSet(iterable);
    }
}

