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
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cD
 */
public class cd_1
extends bt_1
implements cv_2 {
    private static final Logger i = LoggerFactory.getLogger(cd_1.class);
    protected int g;

    public cd_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.MIN_PROPERTIES, df_22);
        if (jsonNode.canConvertToExactIntegral()) {
            this.g = jsonNode.intValue();
        }
        cd_1 cd_12 = this;
        cd_12.a(cd_12.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(i, jsonNode, jsonNode2, string);
        if (jsonNode.isObject() && jsonNode.size() < this.g) {
            return Collections.singleton(this.a(string, "" + this.g));
        }
        return Collections.emptySet();
    }
}

