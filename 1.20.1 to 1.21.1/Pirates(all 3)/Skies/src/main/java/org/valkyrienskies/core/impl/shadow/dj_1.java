/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cr_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_1;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dk_1;
import org.valkyrienskies.core.impl.shadow.dm_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dJ
 */
public class dj_1
extends dg_1 {
    private List<dk_1> a;

    public dj_1(List<dk_1> list) {
        this.a = list;
    }

    @Override
    public boolean b(String object, JsonNode jsonNode, JsonNode jsonNode2, String string, String string2, JsonNode jsonNode3, cp_2 cp_22, df_2 df_22, cr_2 cr_22) {
        object = this.a((String)object, jsonNode, jsonNode2, string, string2, jsonNode3, cp_22, df_22, cr_22);
        dj_1 dj_12 = this;
        return dj_12.a(dj_12.a, (dm_1)object);
    }

    @Override
    public void a(String object, JsonNode jsonNode, JsonNode jsonNode2, String string, String string2, JsonNode jsonNode3, cp_2 cp_22, df_2 df_22, cr_2 cr_22, Set<dg_2> set) {
        object = this.a((String)object, jsonNode, jsonNode2, string, string2, jsonNode3, cp_22, df_22, cr_22);
        dj_1 dj_12 = this;
        dj_12.a(dj_12.a, (dm_1)object, set);
    }
}

