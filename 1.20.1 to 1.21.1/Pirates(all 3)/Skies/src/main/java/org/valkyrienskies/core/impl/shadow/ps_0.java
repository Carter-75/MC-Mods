/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ps
 */
public final class ps_0 {
    private ps_0() {
    }

    public static Object[] a(Object[] objectArray) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (objectArray != null) {
            for (Object object : objectArray) {
                if (object instanceof Object[]) {
                    for (Object object2 : ps_0.a((Object[])object)) {
                        arrayList.add(object2);
                    }
                    continue;
                }
                arrayList.add(object);
            }
        }
        return arrayList.toArray();
    }
}

