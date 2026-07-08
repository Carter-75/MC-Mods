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
 * Renamed from org.valkyrienskies.core.impl.shadow.cy
 */
public class cy_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cy_2.class);
    private int i = Integer.MAX_VALUE;

    public cy_2(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.MAX_LENGTH, df_22);
        if (jsonNode != null && jsonNode.canConvertToExactIntegral()) {
            this.i = jsonNode.intValue();
        }
        this.d = df_22;
        cy_2 cy_22 = this;
        cy_22.a(cy_22.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode object, String string) {
        this.a(g, jsonNode, (JsonNode)object, string);
        object = cz_1.a(jsonNode, this.d.d());
        if (object != cu_2.STRING) {
            return Collections.emptySet();
        }
        if (jsonNode.textValue().codePointCount(0, jsonNode.textValue().length()) > this.i) {
            return Collections.singleton(this.a(string, "" + this.i));
        }
        return Collections.emptySet();
    }
}

