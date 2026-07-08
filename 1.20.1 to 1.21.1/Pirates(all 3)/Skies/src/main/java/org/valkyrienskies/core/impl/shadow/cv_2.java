/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dl_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cv
 */
public interface cv_2
extends dl_1 {
    public static final String h = "$";

    public Set<dg_2> a(JsonNode var1);

    public Set<dg_2> a(JsonNode var1, JsonNode var2, String var3);

    default public void a_() {
    }
}

