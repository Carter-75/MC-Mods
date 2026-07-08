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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import org.valkyrienskies.core.impl.shadow.dq_2;
import org.valkyrienskies.core.impl.shadow.ds_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dr
 */
public class dr_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(dr_2.class);
    private static final String i = "\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]";
    private static final String j = "(\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]";
    private static final String k = "(\"(\\\\\"|[^\"])*\")";
    private static final String l = "(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\"))";
    private static final String m = "^\\s*?(.+)@(.+?)\\s*$";
    private static final String n = "^\\[(.*)\\]$";
    private static final String o = "^\\s*(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\"))(\\.(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\")))*$";
    private static final Pattern p = Pattern.compile("^\\s*?(.+)@(.+?)\\s*$");
    private static final Pattern q = Pattern.compile("^\\[(.*)\\]$");
    private static final Pattern r = Pattern.compile("^\\s*(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\"))(\\.(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\")))*$");
    private static final int s = 64;
    private final boolean t = false;
    private final boolean u = false;
    private final String v;

    public boolean b(String object) {
        if (object == null) {
            return false;
        }
        if (((String)object).endsWith(".")) {
            return false;
        }
        if (!((Matcher)(object = p.matcher((CharSequence)object))).matches()) {
            return false;
        }
        if (!this.d(((Matcher)object).group(1))) {
            return false;
        }
        return this.c(((Matcher)object).group(2));
    }

    protected boolean c(String string) {
        Matcher matcher = q.matcher(string);
        if (matcher.matches()) {
            ds_2 ds_22 = ds_2.a();
            return ds_22.a(matcher.group(1));
        }
        dq_2 dq_22 = dq_2.a(false);
        return dq_22.a(string);
    }

    protected boolean d(String string) {
        if (string == null || string.length() > 64) {
            return false;
        }
        return r.matcher(string).matches();
    }

    public dr_2(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22, String string2) {
        super(string, jsonNode, cp_22, dj_2.FORMAT, df_22);
        this.v = string2;
        this.d = df_22;
        dr_2 dr_22 = this;
        dr_22.a(dr_22.e().d());
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
            iterable.add(this.a(string, jsonNode.textValue(), this.v));
        }
        return Collections.unmodifiableSet(iterable);
    }
}

