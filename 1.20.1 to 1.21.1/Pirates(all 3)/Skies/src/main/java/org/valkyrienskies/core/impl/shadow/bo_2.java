/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import java.util.function.Function;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.ax_1;
import org.valkyrienskies.core.impl.shadow.bq_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bo
 */
public final class bo_2
implements bq_2 {
    private final bq_2 a;
    private final Function<String, String> b;

    public bo_2(bq_2 bq_22, Function<String, String> function) {
        this.a = bq_22;
        this.b = function;
    }

    @Override
    public final String a(ax_1 object, ai_1 ai_12) {
        object = this.a.a((ax_1)object, ai_12);
        return this.b.apply((String)object);
    }

    @Override
    public final void a(Map<ax_1, String> map2, ai_1 ai_12) {
        this.a.a(map2, ai_12);
        map2.entrySet().forEach(entry -> entry.setValue(this.b.apply((String)entry.getValue())));
    }

    @Override
    public final String a(ax_1 object, String string, ai_1 ai_12) {
        object = this.a.a((ax_1)object, string, ai_12);
        return this.b.apply((String)object);
    }
}

