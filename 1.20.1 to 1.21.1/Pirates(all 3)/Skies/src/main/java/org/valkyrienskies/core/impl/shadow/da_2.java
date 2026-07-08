/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.ct_1;
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cz_1;
import org.valkyrienskies.core.impl.shadow.dd_2;
import org.valkyrienskies.core.impl.shadow.de_1;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.di_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.da
 */
public class da_2
extends bt_1
implements cv_2 {
    private static final String g = "type";
    private static final String i = "enum";
    private static final String j = "$ref";
    private static final Logger k = LoggerFactory.getLogger(da_2.class);
    private cu_2 l;
    private cp_2 m;
    private dd_2 n;
    private static final char o = '0';
    private static final char p = '1';
    private static final char q = '9';
    private static final char r = '-';
    private static final char s = '+';
    private static final char t = '.';
    private static final char u = 'E';
    private static final char v = 'e';

    public da_2(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.TYPE, df_22);
        this.l = cz_1.a(jsonNode);
        this.m = cp_22;
        this.d = df_22;
        if (this.l == cu_2.UNION) {
            this.n = new dd_2(string, jsonNode, cp_22, df_22);
        }
        da_2 da_22 = this;
        da_22.a(da_22.e().d());
    }

    public cu_2 h() {
        return this.l;
    }

    public boolean b(JsonNode jsonNode) {
        cu_2 cu_22 = cz_1.a(jsonNode, this.d.d());
        if (cu_22 != this.l) {
            if (this.l == cu_2.ANY) {
                return true;
            }
            if (this.l == cu_2.NUMBER && cu_22 == cu_2.INTEGER) {
                return true;
            }
            di_2 di_22 = (di_2)bv_1.a().a("com.networknt.schema.ValidatorState");
            if (cu_2.NULL.equals((Object)cu_22) && (di_22.b() && de_1.a(this.m.d().c(), this.d.d()) || de_1.a(this.d().c()))) {
                return true;
            }
            if (da_2.a(this.m)) {
                return true;
            }
            if (this.d.d().a()) {
                if (this.l == cu_2.ARRAY) {
                    return true;
                }
                if (cu_22 == cu_2.STRING && (this.l == cu_2.INTEGER ? da_2.b(jsonNode.textValue()) : (this.l == cu_2.BOOLEAN ? da_2.c(jsonNode.textValue()) : this.l == cu_2.NUMBER && da_2.d(jsonNode.textValue())))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public Set<dg_2> a(JsonNode object, JsonNode jsonNode, String string) {
        this.a(k, (JsonNode)object, jsonNode, string);
        if (this.l == cu_2.UNION) {
            return this.n.a((JsonNode)object, jsonNode, string);
        }
        if (!de_1.a((JsonNode)object, this.l, this.m, this.d.d())) {
            object = cz_1.a((JsonNode)object, this.d.d());
            return Collections.singleton(this.a(string, ((cu_2)((Object)object)).toString(), this.l.toString()));
        }
        if (this.a.endsWith("/type")) {
            this.e(string);
        }
        return Collections.emptySet();
    }

    private void e(String string) {
        ArrayList<String> arrayList = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
        if (arrayList == null) {
            arrayList = new ArrayList<String>();
            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", arrayList);
        } else {
            arrayList = arrayList;
        }
        arrayList.add(string);
    }

    public static boolean b(String string) {
        if (string == null || string.equals("")) {
            return false;
        }
        int n2 = 0;
        if (string.charAt(0) == '-' || string.charAt(0) == '+') {
            if (string.length() == 1) {
                return false;
            }
            n2 = 1;
        }
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (c2 < '0' || c2 > '9') {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static boolean c(String string) {
        return "true".equals(string) || "false".equals(string);
    }

    /*
     * Handled impossible loop by adding 'first' condition
     * Enabled aggressive block sorting
     */
    public static boolean d(String string) {
        char c2;
        if (string == null || string.equals("")) {
            return false;
        }
        int n2 = 0;
        int n3 = string.length();
        if (string.charAt(0) == '-' || string.charAt(0) == '+') {
            if (string.length() == 1) {
                return false;
            }
            n2 = 1;
        }
        if ((c2 = string.charAt(n2++)) == '0') {
            if (n2 < n3 && (c2 = string.charAt(n2++)) != '.' && c2 != 'E' && c2 != 'e') {
                return false;
            }
        } else if ('1' <= c2 && c2 <= '9') {
            while (n2 < n3 && '0' <= c2 && c2 <= '9') {
                c2 = string.charAt(n2++);
            }
        } else {
            return false;
        }
        if (c2 == '.') {
            if (n2 >= n3) {
                return false;
            }
            do {
                c2 = string.charAt(n2++);
            } while (n2 < n3 && '0' <= c2 && c2 <= '9');
        }
        if (c2 == 'E' || c2 == 'e') {
            if (n2 >= n3) {
                return false;
            }
            boolean bl = true;
            do {
                if (bl && !(bl = false)) {
                    if ((c2 = string.charAt(n2++)) != '+' && c2 != '-') continue;
                    if (n2 >= n3) {
                        return false;
                    }
                }
                c2 = string.charAt(n2++);
            } while (n2 < n3 && '0' <= c2 && c2 <= '9');
        }
        return n2 >= n3 && '0' <= c2 && c2 <= '9';
    }

    public static boolean a(JsonNode jsonNode, ct_1 ct_12) {
        if (jsonNode.isNumber()) {
            return true;
        }
        if (ct_12.a() && cz_1.a(jsonNode, ct_12) == cu_2.STRING) {
            return da_2.d(jsonNode.textValue());
        }
        return false;
    }

    private static boolean a(cp_2 cp_22) {
        JsonNode jsonNode = null;
        JsonNode jsonNode2 = null;
        JsonNode jsonNode3 = null;
        if (cp_22 != null) {
            if (cp_22.c() != null) {
                jsonNode = cp_22.c().get(g);
                jsonNode2 = cp_22.c().get(i);
            }
            if (cp_22.d() != null && cp_22.d().c() != null) {
                jsonNode3 = cp_22.d().c().get(j);
            }
        }
        if (jsonNode != null && jsonNode2 != null && jsonNode3 != null) {
            return cz_1.a(jsonNode) == cu_2.OBJECT && jsonNode2.isArray();
        }
        return false;
    }
}

