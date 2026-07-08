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
import java.util.regex.PatternSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.ci_2;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cz_1;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ck
 */
public class ck_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(ck_2.class);
    private final ci_2 i;

    public ck_2(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22, ci_2 ci_22) {
        super(string, jsonNode, cp_22, dj_2.FORMAT, df_22);
        this.i = ci_22;
        this.d = df_22;
        ck_2 ck_22 = this;
        ck_22.a(ck_22.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        this.a(g, jsonNode, (JsonNode)iterable, string);
        iterable = new LinkedHashSet();
        cu_2 cu_22 = cz_1.a(jsonNode, this.d.d());
        if (cu_22 != cu_2.STRING) {
            return iterable;
        }
        if (this.i != null) {
            if (this.i.a().equals("ipv6")) {
                if (!jsonNode.textValue().trim().equals(jsonNode.textValue())) {
                    iterable.add(this.a(string, this.i.a(), this.i.b()));
                } else if (jsonNode.textValue().contains("%")) {
                    iterable.add((dg_2)this.a(string, this.i.a(), this.i.b()));
                }
            }
            try {
                if (!this.i.a(jsonNode.textValue())) {
                    iterable.add((dg_2)this.a(string, this.i.a(), this.i.b()));
                }
            }
            catch (PatternSyntaxException patternSyntaxException) {
                g.error("Failed to apply pattern on " + string + ": Invalid RE syntax [" + this.i.a() + "]", (Throwable)patternSyntaxException);
            }
        }
        return Collections.unmodifiableSet(iterable);
    }
}

