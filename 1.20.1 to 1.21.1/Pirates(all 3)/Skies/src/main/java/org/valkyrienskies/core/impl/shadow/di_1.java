/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cr_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_1;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dk_1;
import org.valkyrienskies.core.impl.shadow.dm_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dI
 */
public class di_1
extends dg_1 {
    private Map<String, List<dk_1>> a;

    public di_1(Map<String, List<dk_1>> map2) {
        this.a = map2;
    }

    protected String a(String string) {
        String string2 = string;
        return string2.substring(string2.lastIndexOf(47) + 1);
    }

    @Override
    public boolean b(String object, JsonNode object2, JsonNode iterable, String string, String string2, JsonNode jsonNode, cp_2 cp_22, df_2 df_22, cr_2 cr_22) {
        object = this.a((String)object);
        object2 = this.a((String)object, (JsonNode)object2, (JsonNode)iterable, string, string2, jsonNode, cp_22, df_22, cr_22);
        boolean bl = this.a((List<dk_1>)(object = this.a.get(object)), (dm_1)object2);
        if (bl) {
            iterable = this.a.get("com.networknt.AllKeywordWalkListener");
            this.a((List<dk_1>)iterable, (dm_1)object2);
        }
        return bl;
    }

    @Override
    public void a(String list, JsonNode object, JsonNode jsonNode, String string, String string2, JsonNode jsonNode2, cp_2 cp_22, df_2 df_22, cr_2 cr_22, Set<dg_2> set) {
        list = this.a((String)((Object)list));
        object = this.a((String)((Object)list), (JsonNode)object, jsonNode, string, string2, jsonNode2, cp_22, df_22, cr_22);
        list = this.a.get(list);
        this.a(list, (dm_1)object, set);
        list = this.a.get("com.networknt.AllKeywordWalkListener");
        this.a(list, (dm_1)object, set);
    }
}

