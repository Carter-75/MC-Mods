/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.valkyrienskies.core.impl.shadow.cM
 *  org.valkyrienskies.core.impl.shadow.cM$a
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cM;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cz_1;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cM
 */
public class cm_1
implements cv_2 {
    private final cv_2 a;
    private final df_2 b;

    public cm_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        this.b = df_22;
        if (df_22.d() != null && df_22.d().f()) {
            this.a = new cM.a(string, jsonNode, cp_22, df_22);
            return;
        }
        this.a = new b(string, jsonNode, cp_22, df_22);
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode) {
        return this.a.a(jsonNode);
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        return this.a.a(jsonNode, jsonNode2, string);
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        return this.a.a(jsonNode, jsonNode2, string, bl);
    }

    static class b
    extends bt_1
    implements cv_2 {
        private static final Logger g = LoggerFactory.getLogger(cM.class);
        private String i = "";
        private Pattern j;

        public b(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
            super(string, jsonNode, cp_22, dj_2.PATTERN, df_22);
            if (jsonNode != null && jsonNode.isTextual()) {
                this.i = jsonNode.textValue();
                try {
                    this.j = Pattern.compile(this.i);
                }
                catch (PatternSyntaxException patternSyntaxException) {
                    g.error("Failed to compile pattern : Invalid syntax [" + this.i + "]", (Throwable)patternSyntaxException);
                    throw patternSyntaxException;
                }
            }
            this.d = df_22;
            b b2 = this;
            b2.a(b2.e().d());
        }

        private boolean b(String string) {
            return this.j == null || this.j.matcher(string).find();
        }

        @Override
        public Set<dg_2> a(JsonNode jsonNode, JsonNode object, String string) {
            this.a(g, jsonNode, (JsonNode)object, string);
            object = cz_1.a(jsonNode, this.d.d());
            if (object != cu_2.STRING) {
                return Collections.emptySet();
            }
            try {
                if (!this.b(jsonNode.asText())) {
                    return Collections.singleton(this.a(string, this.i));
                }
            }
            catch (PatternSyntaxException patternSyntaxException) {
                g.error("Failed to apply pattern on " + string + ": Invalid syntax [" + this.i + "]", (Throwable)patternSyntaxException);
            }
            return Collections.emptySet();
        }
    }
}

