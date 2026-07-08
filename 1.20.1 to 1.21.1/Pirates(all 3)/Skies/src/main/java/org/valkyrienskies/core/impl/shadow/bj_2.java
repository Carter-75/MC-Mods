/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import java.util.Collections;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.au_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bj
 */
public class bj_2<W>
implements ad_1 {
    private final Class<W> a;

    public bj_2(Class<W> clazz) {
        this.a = clazz;
    }

    private boolean a(ResolvedType resolvedType) {
        return this.a.isAssignableFrom(resolvedType.getErasedType());
    }

    protected final boolean a(ab_1<?, ?> ab_12) {
        ab_1<?, ?> ab_13 = ab_12;
        ResolvedType resolvedType = ab_13.a.getType();
        ab_13 = ab_12;
        if (ab_13.c) {
            ab_13 = ab_12;
            au_1 cfr_ignored_0 = ab_13.e;
            if (au_1.c(resolvedType)) {
                ab_13 = ab_12;
                resolvedType = ab_13.e.d(resolvedType);
            }
        }
        return this.a(resolvedType);
    }

    private List<ResolvedType> b(ab_1<?, ?> ab_12) {
        ab_1<?, ?> ab_13 = ab_12;
        if (this.a(ab_13.d)) {
            return Collections.singletonList(ab_12.a(this.a, 0));
        }
        return null;
    }

    @Override
    public void a(al_1 al_12) {
        al_1 al_13 = al_12;
        al_13.c.b(this::b);
        al_13 = al_12;
        al_13.d.b(this::b);
    }
}

