/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eV
 */
final class ev_1 {
    private static int a = -1;

    ev_1() {
    }

    static boolean a(Object[] objectArray, Object object) {
        int n2;
        block5: {
            Object[] objectArray2 = objectArray;
            boolean bl = false;
            Object[] objectArray3 = objectArray2;
            if (objectArray2 != null) {
                if (object == null) {
                    for (int i2 = 0; i2 < objectArray3.length; ++i2) {
                        if (objectArray3[i2] != null) continue;
                        n2 = i2;
                        break block5;
                    }
                } else {
                    for (int i3 = 0; i3 < objectArray3.length; ++i3) {
                        if (!object.equals(objectArray3[i3])) continue;
                        n2 = i3;
                        break block5;
                    }
                }
            }
            n2 = -1;
        }
        return n2 != -1;
    }

    private static <T> int b(T[] TArray, Object object) {
        return ev_1.a(TArray, object, 0);
    }

    private static int a(Object[] objectArray, Object object, int n2) {
        if (objectArray == null) {
            return -1;
        }
        if (object == null) {
            for (n2 = 0; n2 < objectArray.length; ++n2) {
                if (objectArray[n2] != null) continue;
                return n2;
            }
        } else {
            for (n2 = 0; n2 < objectArray.length; ++n2) {
                if (!object.equals(objectArray[n2])) continue;
                return n2;
            }
        }
        return -1;
    }
}

