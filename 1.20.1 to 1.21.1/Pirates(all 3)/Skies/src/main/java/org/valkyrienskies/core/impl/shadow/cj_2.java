/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.bz_1;
import org.valkyrienskies.core.impl.shadow.ci_2;
import org.valkyrienskies.core.impl.shadow.ck_2;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cw_2;
import org.valkyrienskies.core.impl.shadow.db_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dj_2;
import org.valkyrienskies.core.impl.shadow.dr_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cj
 */
public class cj_2
implements cw_2 {
    private final dj_2 a;
    private final Map<String, ci_2> b;
    private final String c = "date";
    private final String d = "date-time";
    private final String e = "uuid";
    private final String f = "email";

    public cj_2(dj_2 dj_22, Map<String, ci_2> map2) {
        this.a = dj_22;
        this.b = map2;
    }

    Collection<ci_2> b() {
        return Collections.unmodifiableCollection(this.b.values());
    }

    @Override
    public cv_2 a(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        ci_2 ci_22 = null;
        if (jsonNode != null && jsonNode.isTextual()) {
            String string2 = jsonNode.textValue();
            ci_22 = this.b.get(string2);
            if (ci_22 != null) {
                return new ck_2(string, jsonNode, cp_22, df_22, ci_22);
            }
            if (string2.equals("date") || string2.equals("date-time")) {
                return new bz_1(string, jsonNode, cp_22, df_22, string2);
            }
            if (string2.equals("uuid")) {
                return new db_2(string, jsonNode, cp_22, df_22, string2);
            }
            if (string2.equals("email")) {
                return new dr_2(string, jsonNode, cp_22, df_22, string2);
            }
        }
        return new ck_2(string, jsonNode, cp_22, df_22, ci_22);
    }

    @Override
    public String a() {
        return this.a.a();
    }

    @Override
    public void a(String string) {
        this.a.a(string);
    }
}

