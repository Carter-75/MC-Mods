/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.c_0;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cz_1;
import org.valkyrienskies.core.impl.shadow.d_0;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bZ
 */
public class bz_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(bz_1.class);
    private final String i;
    private final String j = "date";
    private final String k = "date-time";

    public bz_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22, String string2) {
        super(string, jsonNode, cp_22, dj_2.DATETIME, df_22);
        this.i = string2;
        this.d = df_22;
        bz_1 bz_12 = this;
        bz_12.a(bz_12.e().d());
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
            iterable.add(this.a(string, jsonNode.textValue(), this.i));
        }
        return Collections.unmodifiableSet(iterable);
    }

    private boolean b(String string) {
        if (this.i.equals("date")) {
            return this.a(() -> LocalDate.parse(string));
        }
        if (this.i.equals("date-time")) {
            return this.a(() -> {
                try {
                    c_0.a(string);
                    return;
                }
                catch (d_0 d_02) {
                    string = d_02;
                    d_0 d_03 = d_02;
                    if (!d_02.a) {
                        throw string;
                    }
                    return;
                }
            });
        }
        throw new IllegalStateException("Unknown format: " + this.i);
    }

    private boolean a(Runnable runnable) {
        try {
            runnable.run();
            return true;
        }
        catch (Exception exception) {
            g.error("Invalid " + this.i + ": " + exception.getMessage());
            return false;
        }
    }
}

