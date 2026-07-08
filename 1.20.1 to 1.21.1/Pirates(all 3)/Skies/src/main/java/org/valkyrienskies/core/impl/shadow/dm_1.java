/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.dM
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.net.URI;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cr_2;
import org.valkyrienskies.core.impl.shadow.ct_1;
import org.valkyrienskies.core.impl.shadow.dM;
import org.valkyrienskies.core.impl.shadow.df_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dM
 */
public class dm_1 {
    private String a;
    private JsonNode b;
    private cp_2 c;
    private String d;
    private JsonNode e;
    private JsonNode f;
    private String g;
    private cr_2 h;
    private df_2 i;

    public String a() {
        return this.a;
    }

    public JsonNode b() {
        return this.b;
    }

    public cp_2 c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public JsonNode e() {
        return this.e;
    }

    public JsonNode f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public cp_2 a(URI uRI) {
        return this.h.a(uRI, this.i.d());
    }

    public cp_2 a(URI uRI, ct_1 ct_12) {
        if (ct_12 != null) {
            return this.h.a(uRI, ct_12);
        }
        return this.a(uRI);
    }

    public cr_2 h() {
        return this.h;
    }

    public static a i() {
        return new a();
    }

    static /* synthetic */ String a(dm_1 dm_12, String string) {
        dm_12.a = string;
        return dm_12.a;
    }

    static /* synthetic */ JsonNode a(dm_1 dm_12, JsonNode jsonNode) {
        dm_12.b = jsonNode;
        return dm_12.b;
    }

    static /* synthetic */ cp_2 a(dm_1 dm_12, cp_2 cp_22) {
        dm_12.c = cp_22;
        return dm_12.c;
    }

    static /* synthetic */ String b(dm_1 dm_12, String string) {
        dm_12.d = string;
        return dm_12.d;
    }

    static /* synthetic */ JsonNode b(dm_1 dm_12, JsonNode jsonNode) {
        dm_12.e = jsonNode;
        return dm_12.e;
    }

    static /* synthetic */ JsonNode c(dm_1 dm_12, JsonNode jsonNode) {
        dm_12.f = jsonNode;
        return dm_12.f;
    }

    static /* synthetic */ String c(dm_1 dm_12, String string) {
        dm_12.g = string;
        return dm_12.g;
    }

    static /* synthetic */ cr_2 a(dm_1 dm_12, cr_2 cr_22) {
        dm_12.h = cr_22;
        return dm_12.h;
    }

    static /* synthetic */ df_2 a(dm_1 dm_12, df_2 df_22) {
        dm_12.i = df_22;
        return dm_12.i;
    }

    static class a {
        private dm_1 a = new dM();

        a() {
        }

        public a a(String string) {
            dM.a((dm_1)this.a, (String)string);
            return this;
        }

        public a a(JsonNode jsonNode) {
            dM.a((dm_1)this.a, (JsonNode)jsonNode);
            return this;
        }

        public a a(cp_2 cp_22) {
            dM.a((dm_1)this.a, (cp_2)cp_22);
            return this;
        }

        public a b(String string) {
            dM.b((dm_1)this.a, (String)string);
            return this;
        }

        public a b(JsonNode jsonNode) {
            dM.b((dm_1)this.a, (JsonNode)jsonNode);
            return this;
        }

        public a c(JsonNode jsonNode) {
            dM.c((dm_1)this.a, (JsonNode)jsonNode);
            return this;
        }

        public a c(String string) {
            dM.c((dm_1)this.a, (String)string);
            return this;
        }

        public a a(cr_2 cr_22) {
            dM.a((dm_1)this.a, (cr_2)cr_22);
            return this;
        }

        public a a(df_2 df_22) {
            dM.a((dm_1)this.a, (df_2)df_22);
            return this;
        }

        public dm_1 a() {
            return this.a;
        }
    }
}

