/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.al_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bn
 */
public final class bn_2
implements ad_1 {
    private static String[] a = new String[]{"get", "orElse", "isPresent"};
    private final List<String> b;

    public bn_2(String ... stringArray) {
        int cfr_ignored_0 = stringArray.length;
        this.b = Arrays.asList(a);
    }

    @Override
    public final void a(al_1 al_12) {
        al_1 al_13 = al_12;
        al_13.c.a((M ay_22) -> bn_2.a(ay_22.a.getDeclaringType()));
        al_13 = al_12;
        al_13.d.a((M ac_12) -> {
            ac_1 ac_13 = ac_12;
            return bn_2.a(ac_13.a.getDeclaringType()) && !this.b.contains(ac_12.m());
        });
    }

    private static boolean a(ResolvedType resolvedType) {
        return resolvedType.getErasedType() == Optional.class;
    }
}

