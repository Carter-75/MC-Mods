/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.at_2;
import org.valkyrienskies.core.impl.shadow.av_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.au
 */
@Deprecated
public interface au_2
extends av_2 {
    public at_2 a();

    @Override
    default public at_2 a(ResolvedType resolvedType, ai_1 ai_12) {
        ai_12.b();
        return this.a();
    }
}

