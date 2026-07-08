/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.ay_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bf
 */
public final class bf_2
implements ad_1 {
    private static List<?> a(ay_2 object) {
        ay_2 ay_22 = object;
        if (ay_22.a.isStatic()) {
            ay_22 = object;
            if (ay_22.a.isFinal()) {
                ay_22 = object;
                if (!((Field)ay_22.a.getRawMember()).isEnumConstant()) {
                    ay_22 = object;
                    if (!ay_22.c) {
                        ay_22 = object;
                        object = (Field)ay_22.a.getRawMember();
                        try {
                            return Collections.singletonList(((Field)object).get(null));
                        }
                        catch (IllegalAccessException illegalAccessException) {
                            try {
                                ((Field)object).setAccessible(true);
                                return Collections.singletonList(((Field)object).get(null));
                            }
                            catch (IllegalAccessException | SecurityException exception) {}
                        }
                    }
                }
            }
        }
        return null;
    }

    private static Boolean b(ay_2 object) {
        if ((object = bf_2.a((ay_2)object)) == null) {
            return null;
        }
        return object.get(0) == null;
    }

    @Override
    public final void a(al_1 al_12) {
        al_12.c.g(bf_2::a).a(bf_2::b);
    }
}

