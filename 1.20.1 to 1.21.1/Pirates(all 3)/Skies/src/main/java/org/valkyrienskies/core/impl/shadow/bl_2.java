/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.function.Predicate;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.al_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bl
 */
public final class bl_2
implements ad_1 {
    private final Predicate<ac_1> a;

    public static bl_2 a() {
        return new bl_2(ac_1::b);
    }

    public static bl_2 b() {
        return new bl_2(ac_1::d);
    }

    public static bl_2 c() {
        return new bl_2(ac_12 -> {
            ac_1 ac_13 = ac_12;
            return !ac_13.a.isStatic() && !ac_12.b() && !ac_12.d();
        });
    }

    private bl_2(Predicate<ac_1> predicate) {
        this.a = predicate;
    }

    @Override
    public final void a(al_1 al_12) {
        al_12.d.a(this.a);
    }
}

