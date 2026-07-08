/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.EnumSet;
import java.util.Set;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cU
 */
public class cu_1 {
    public EnumSet<a> a(long l2) {
        EnumSet<a> enumSet = EnumSet.noneOf(a.class);
        for (a a2 : a.values()) {
            long l3 = a2.versionFlagValue;
            if ((l3 & l2) != l3) continue;
            enumSet.add(a2);
        }
        return enumSet;
    }

    public long a(Set<a> object) {
        long l2 = 0L;
        object = object.iterator();
        while (object.hasNext()) {
            a a2 = (a)((Object)object.next());
            l2 |= a2.versionFlagValue;
        }
        return l2;
    }

    public static enum a {
        V4(1L),
        V6(2L),
        V7(4L),
        V201909(8L),
        V202012(16L);

        private final long versionFlagValue;

        private a(long l2) {
            this.versionFlagValue = l2;
        }

        public final long a() {
            return this.versionFlagValue;
        }
    }
}

