/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.rB;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class rE {
    private rE() {
    }

    private static Collection<rB> a(Collection<rB> object) {
        Object object2;
        int n2 = 0;
        Object object3 = null;
        Object object4 = null;
        Object object5 = null;
        Object object6 = null;
        Object object7 = object.iterator();
        while (object7.hasNext()) {
            block34: {
                block33: {
                    rB[] rBArray;
                    block32: {
                        block31: {
                            block30: {
                                block29: {
                                    block28: {
                                        block27: {
                                            object2 = object7.next();
                                            if (object3 == null) break block27;
                                            rBArray = object2;
                                            rBArray = object3;
                                            if (!(((rB)object2).c < ((rB)object3).c)) break block28;
                                        }
                                        object3 = object2;
                                    }
                                    if (object4 == null) break block29;
                                    rBArray = object2;
                                    rBArray = object4;
                                    if (!(((rB)object2).c > ((rB)object4).c)) break block30;
                                }
                                object4 = object2;
                            }
                            if (object5 == null) break block31;
                            rBArray = object2;
                            rBArray = object5;
                            if (!(((rB)object2).d < object5.d)) break block32;
                        }
                        object5 = object2;
                    }
                    if (object6 == null) break block33;
                    rBArray = object2;
                    rBArray = object6;
                    if (!(((rB)object2).d > object6.d)) break block34;
                }
                object6 = object2;
            }
            ++n2;
        }
        if (n2 < 4) {
            return object;
        }
        object3 = new rB[]{object5, object4, object6, object3};
        object4 = new ArrayList();
        object5 = object3;
        int cfr_ignored_0 = ((rB[])object3).length;
        for (int i2 = 0; i2 < 4; ++i2) {
            rB rB2 = object5[i2];
            if (object4.contains(rB2)) continue;
            object4.add(rB2);
        }
        object7 = object4;
        if (object7.size() < 3) {
            return object;
        }
        object2 = new ArrayList(object7);
        object = object.iterator();
        while (object.hasNext()) {
            boolean bl;
            rB rB3;
            block26: {
                rB3 = (rB)object.next();
                object4 = object7;
                object3 = rB3;
                object5 = (rB)object4.get(0);
                object6 = (rB)object4.get(1);
                if (((rB)object3).equals(object5) || ((rB)object3).equals(object6)) {
                    bl = true;
                } else {
                    double d2 = ((rB)object3).b((rB)object5, (rB)object6);
                    int n3 = object4.size();
                    for (int i3 = 1; i3 < n3; ++i3) {
                        object5 = object6;
                        object6 = (rB)object4.get(i3 + 1 == n3 ? 0 : i3 + 1);
                        if (((rB)object3).equals(object5) || ((rB)object3).equals(object6)) {
                            bl = true;
                        } else {
                            if (!(d2 * ((rB)object3).b((rB)object5, (rB)object6) < 0.0)) continue;
                            bl = false;
                        }
                        break block26;
                    }
                    bl = true;
                }
            }
            if (bl) continue;
            object2.add(rB3);
        }
        return object2;
    }

    private static List<rB> a(rB ... rBArray) {
        ArrayList<rB> arrayList = new ArrayList<rB>();
        int cfr_ignored_0 = rBArray.length;
        for (int i2 = 0; i2 < 4; ++i2) {
            rB rB2 = rBArray[i2];
            if (arrayList.contains(rB2)) continue;
            arrayList.add(rB2);
        }
        return arrayList;
    }

    private static boolean a(rB rB2, List<rB> list) {
        rB rB3 = list.get(0);
        rB rB4 = list.get(1);
        if (rB2.equals(rB3) || rB2.equals(rB4)) {
            return true;
        }
        double d2 = rB2.b(rB3, rB4);
        int n2 = list.size();
        for (int i2 = 1; i2 < n2; ++i2) {
            rB3 = rB4;
            rB4 = list.get(i2 + 1 == n2 ? 0 : i2 + 1);
            if (rB2.equals(rB3) || rB2.equals(rB4)) {
                return true;
            }
            if (!(d2 * rB2.b(rB3, rB4) < 0.0)) continue;
            return false;
        }
        return true;
    }
}

