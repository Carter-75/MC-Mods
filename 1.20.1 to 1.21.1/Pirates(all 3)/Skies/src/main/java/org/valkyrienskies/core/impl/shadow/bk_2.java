/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayDeque;
import java.util.Deque;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.at_2;
import org.valkyrienskies.core.impl.shadow.au_1;
import org.valkyrienskies.core.impl.shadow.av_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bk
 */
public final class bk_2
implements ad_1,
av_2 {
    private final ThreadLocal<Deque<ResolvedType>> a = ThreadLocal.withInitial(ArrayDeque::new);

    @Override
    public final void a(al_1 al_12) {
        al_12.b.a(this);
    }

    @Override
    public final at_2 a(ResolvedType object, ai_1 ai_12) {
        Deque<ResolvedType> deque = this.a.get();
        if (deque.contains(object)) {
            throw new IllegalArgumentException("Option.INLINE_ALL_SCHEMAS cannot be fulfilled due to a circular reference to " + ai_12.b().f((ResolvedType)object));
        }
        ai_12.b();
        if (au_1.c(object)) {
            return null;
        }
        deque.addLast((ResolvedType)object);
        object = ai_12.a((ResolvedType)object, this);
        deque.removeLast();
        return new at_2((ObjectNode)object, true);
    }
}

