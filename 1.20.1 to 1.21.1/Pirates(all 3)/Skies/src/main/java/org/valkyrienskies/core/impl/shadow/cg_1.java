/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.bn_1;
import org.valkyrienskies.core.impl.shadow.bo_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cG
 */
public class cg_1
extends bo_1 {
    public cg_1(String string) {
        super(string);
    }

    @Override
    public cv_2 a(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        return new a(this.a());
    }

    static final class a
    extends bn_1 {
        private a(String string) {
            super(string);
        }

        @Override
        public final Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
            return Collections.emptySet();
        }
    }
}

