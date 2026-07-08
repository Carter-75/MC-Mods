/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.ax_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bq
 */
public interface bq_2 {
    public String a(ax_1 var1, ai_1 var2);

    default public void a(Map<ax_1, String> object, ai_1 ai_12) {
        int n2 = 1;
        for (Map.Entry entry : object.entrySet()) {
            entry.setValue((String)entry.getValue() + "-" + n2);
            ++n2;
        }
    }

    default public String a(ax_1 ax_12, String string, ai_1 ai_12) {
        return string + "-nullable";
    }
}

