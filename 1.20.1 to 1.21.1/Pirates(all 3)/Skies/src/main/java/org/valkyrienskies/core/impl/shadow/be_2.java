/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Type;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.as_2;
import org.valkyrienskies.core.impl.shadow.av_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.be
 */
public final class be_2
implements ad_1 {
    private final as_2<av_1, Type> a;

    public static be_2 a() {
        return new be_2(av_12 -> {
            av_1 av_13 = av_12;
            if (av_13.d.isInstanceOf(Map.class)) {
                return av_12.a(Map.class, 1);
            }
            return null;
        });
    }

    public static be_2 b() {
        return new be_2(av_12 -> {
            if (av_12.v()) {
                return null;
            }
            return Void.class;
        });
    }

    private be_2(as_2<av_1, Type> as_22) {
        this.a = as_22;
    }

    @Override
    public final void a(al_1 al_12) {
        al_12.b.b(this.a);
    }
}

