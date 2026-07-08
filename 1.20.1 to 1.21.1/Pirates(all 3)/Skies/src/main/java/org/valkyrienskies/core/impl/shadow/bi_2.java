/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Optional;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.bj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bi
 */
public final class bi_2
extends bj_2<Optional> {
    public bi_2() {
        super(Optional.class);
    }

    @Override
    public final void a(al_1 al_12) {
        super.a(al_12);
        al_1 al_13 = al_12;
        al_13.c.a((M ay_22) -> {
            if (this.a((ab_1<?, ?>)ay_22)) {
                return Boolean.TRUE;
            }
            return null;
        });
        al_13 = al_12;
        al_13.d.a((M ac_12) -> {
            if (this.a((ab_1<?, ?>)ac_12)) {
                return Boolean.TRUE;
            }
            return null;
        });
    }
}

