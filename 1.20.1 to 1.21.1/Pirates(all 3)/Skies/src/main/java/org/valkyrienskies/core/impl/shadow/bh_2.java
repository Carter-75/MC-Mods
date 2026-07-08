/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.function.Predicate;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.ay_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bh
 */
public final class bh_2
implements ad_1 {
    private final Predicate<ay_2> a;

    public static bh_2 a() {
        return new bh_2(ay_22 -> {
            ay_2 ay_23 = ay_22;
            if (ay_23.a.isPublic()) {
                ay_23 = ay_22;
                if (!ay_23.a.isStatic()) {
                    return true;
                }
            }
            return false;
        });
    }

    public static bh_2 b() {
        return new bh_2(ay_22 -> {
            ay_2 ay_23 = ay_22;
            if (!ay_23.a.isPublic()) {
                ay_23 = ay_22;
                if (!ay_23.a.isStatic() && ay_22.d()) {
                    return true;
                }
            }
            return false;
        });
    }

    public static bh_2 c() {
        return new bh_2(ay_22 -> {
            ay_2 ay_23 = ay_22;
            if (!ay_23.a.isPublic()) {
                ay_23 = ay_22;
                if (!ay_23.a.isStatic() && !ay_22.d()) {
                    return true;
                }
            }
            return false;
        });
    }

    public static bh_2 d() {
        return new bh_2(ay_2::b);
    }

    private bh_2(Predicate<ay_2> predicate) {
        this.a = predicate;
    }

    @Override
    public final void a(al_1 al_12) {
        al_12.c.a(this.a);
    }
}

