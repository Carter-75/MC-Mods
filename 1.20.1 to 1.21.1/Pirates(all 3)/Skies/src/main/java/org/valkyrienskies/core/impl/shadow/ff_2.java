/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.fq_2;
import org.valkyrienskies.core.impl.shadow.ic_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ff
 */
public final class ff_2 {
    private ff_2() {
    }

    public static <T> T a(Enumeration<T> enumeration, int n2) {
        fd_2.a(n2);
        while (enumeration.hasMoreElements()) {
            if (--n2 == -1) {
                return enumeration.nextElement();
            }
            enumeration.nextElement();
        }
        throw new IndexOutOfBoundsException("Entry does not exist: " + n2);
    }

    private static <E> List<E> a(Enumeration<? extends E> enumeration) {
        return fq_2.c(new ic_2<E>(enumeration));
    }

    private static List<String> a(StringTokenizer stringTokenizer) {
        ArrayList<String> arrayList = new ArrayList<String>(stringTokenizer.countTokens());
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }
}

