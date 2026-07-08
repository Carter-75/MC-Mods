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
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cz_1;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.db
 */
public class db_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(db_2.class);
    private final String i;
    private static final String j = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    public db_2(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22, String string2) {
        super(string, jsonNode, cp_22, dj_2.UUID, df_22);
        this.i = string2;
        db_2 db_22 = this;
        db_22.a(db_22.e().d());
        this.d = df_22;
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        this.a(g, jsonNode, (JsonNode)iterable, string);
        iterable = new LinkedHashSet();
        cu_2 cu_22 = cz_1.a(jsonNode, this.d.d());
        if (cu_22 != cu_2.STRING) {
            return iterable;
        }
        if (!this.b(jsonNode.textValue())) {
            iterable.add(this.a(string, jsonNode.textValue(), this.i));
        }
        return Collections.unmodifiableSet(iterable);
    }

    public boolean b(String string) {
        return string.matches(j);
    }
}

