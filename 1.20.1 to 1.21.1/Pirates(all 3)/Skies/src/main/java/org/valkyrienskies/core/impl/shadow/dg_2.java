/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang3.StringUtils
 *  org.valkyrienskies.core.impl.shadow.dg
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.valkyrienskies.core.impl.shadow.ce_2;
import org.valkyrienskies.core.impl.shadow.dg;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dg
 */
public class dg_2 {
    private String a;
    private String b;
    private String c;
    private String d;
    private String[] e;
    private Map<String, Object> f;
    private String g;

    dg_2() {
    }

    public String a() {
        return this.b;
    }

    void a(String string) {
        this.b = string;
    }

    public String b() {
        return this.c;
    }

    void b(String string) {
        this.c = string;
    }

    public String c() {
        return this.d;
    }

    public void c(String string) {
        this.d = string;
    }

    public String[] d() {
        return this.e;
    }

    void a(String[] stringArray) {
        this.e = stringArray;
    }

    void a(Map<String, Object> map2) {
        this.f = map2;
    }

    public Map<String, Object> e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    void d(String string) {
        this.g = string;
    }

    public String toString() {
        return this.g;
    }

    public boolean equals(Object o) {
        dg_2 dg_22;
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        dg_22 = dg_22;
        if (this.a != null ? !this.a.equals(dg_22.a) : dg_22.a != null) {
            return false;
        }
        if (this.b != null ? !this.b.equals(dg_22.b) : dg_22.b != null) {
            return false;
        }
        if (this.c != null ? !this.c.equals(dg_22.c) : dg_22.c != null) {
            return false;
        }
        if (this.d != null ? !this.d.equals(dg_22.d) : dg_22.d != null) {
            return false;
        }
        if (this.f != null ? !this.f.equals(dg_22.f) : dg_22.f != null) {
            return false;
        }
        if (!Arrays.equals(this.e, dg_22.e)) {
            return false;
        }
        return !(this.g == null ? dg_22.g != null : !this.g.equals(dg_22.g));
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        n2 = n2 * 31 + (this.b != null ? this.b.hashCode() : 0);
        n2 = n2 * 31 + (this.c != null ? this.c.hashCode() : 0);
        n2 = n2 * 31 + (this.d != null ? this.d.hashCode() : 0);
        n2 = n2 * 31 + (this.f != null ? this.f.hashCode() : 0);
        n2 = n2 * 31 + (this.e != null ? Arrays.hashCode(this.e) : 0);
        n2 = n2 * 31 + (this.g != null ? this.g.hashCode() : 0);
        return n2;
    }

    public String g() {
        return this.a;
    }

    public void e(String string) {
        this.a = string;
    }

    public static dg_2 a(String string, ce_2 ce_22, String string2, String string3, String ... stringArray) {
        a a2 = new a();
        a2.b(ce_22.b_()).c(string2).d(string3).a(stringArray).a(ce_22.b()).a(string).e(ce_22.c());
        return a2.a();
    }

    public static dg_2 a(String string, ce_2 ce_22, String string2, String string3, Map<String, Object> map2) {
        a a2 = new a();
        a2.b(ce_22.b_()).c(string2).d(string3).a(map2).a(ce_22.b()).a(string);
        return a2.a();
    }

    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private String[] e;
        private Map<String, Object> f;
        private MessageFormat g;
        private String h;

        public a a(String string) {
            this.a = string;
            return this;
        }

        public a b(String string) {
            this.b = string;
            return this;
        }

        public a c(String string) {
            this.c = string;
            return this;
        }

        public a d(String string) {
            this.d = string;
            return this;
        }

        public a a(String ... stringArray) {
            this.e = stringArray;
            return this;
        }

        public a a(Map<String, Object> map2) {
            this.f = map2;
            return this;
        }

        public a a(MessageFormat messageFormat) {
            this.g = messageFormat;
            return this;
        }

        public a e(String string) {
            this.h = string;
            return this;
        }

        public dg_2 a() {
            dg dg2 = new dg();
            dg2.e(this.a);
            dg2.a(this.b);
            dg2.b(this.c);
            dg2.c(this.d);
            dg2.a(this.e);
            dg2.a(this.f);
            if (this.g != null) {
                String[] stringArray = new String[(this.e == null ? 0 : this.e.length) + 1];
                String[] stringArray2 = stringArray;
                stringArray[0] = this.c;
                if (this.e != null) {
                    for (int i2 = 1; i2 < stringArray2.length; ++i2) {
                        stringArray2[i2] = this.e[i2 - 1];
                    }
                }
                if (StringUtils.isNotBlank((CharSequence)this.h)) {
                    dg2.d(this.h);
                } else {
                    dg2.d(this.g.format(stringArray2));
                }
            }
            return dg2;
        }
    }
}

