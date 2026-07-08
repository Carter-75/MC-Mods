/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rD;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class rH
extends rD {
    public rH() {
        this(false);
    }

    private rH(boolean bl) {
        super(false);
    }

    private rH(boolean bl, double d2) {
        super(bl, d2);
    }

    @Override
    public final Collection<rB> b(Collection<rB> collection) {
        int n2;
        collection = new ArrayList<rB>(collection);
        Collections.sort(collection, new Comparator<rB>(this){
            private /* synthetic */ rH a;
            {
                this.a = rH2;
            }

            private int a(rB rB2, rB rB3) {
                double d2 = this.a.a();
                rB rB4 = rB2;
                rB rB5 = rB4;
                rB5 = rB3;
                int n2 = cq_0.a(rB4.c, rB5.c, d2);
                if (n2 == 0) {
                    rB rB6 = rB2;
                    rB rB7 = rB6;
                    rB7 = rB3;
                    return cq_0.a(rB6.d, rB7.d, d2);
                }
                return n2;
            }

            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                rB rB2 = (rB)object2;
                object2 = (rB)object;
                object = this;
                double d2 = object.a.a();
                Object object3 = object2;
                object = object3;
                object = rB2;
                int n2 = cq_0.a(((rB)object3).c, ((rB)object).c, d2);
                if (n2 == 0) {
                    Object object4 = object2;
                    Object object5 = object4;
                    object5 = rB2;
                    return cq_0.a(((rB)object4).d, ((rB)object5).d, d2);
                }
                return n2;
            }
        });
        ArrayList<rB> arrayList = new ArrayList<rB>();
        for (rB rB2 : collection) {
            this.a(rB2, arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = collection.size() - 1; i2 >= 0; --i2) {
            rB rB3 = (rB)collection.get(i2);
            this.a(rB3, arrayList2);
        }
        ArrayList<rB> arrayList3 = new ArrayList<rB>(arrayList.size() + arrayList2.size() - 2);
        for (n2 = 0; n2 < arrayList.size() - 1; ++n2) {
            arrayList3.add((rB)arrayList.get(n2));
        }
        for (n2 = 0; n2 < arrayList2.size() - 1; ++n2) {
            arrayList3.add((rB)arrayList2.get(n2));
        }
        if (arrayList3.isEmpty() && !arrayList.isEmpty()) {
            arrayList3.add((rB)arrayList.get(0));
        }
        return arrayList3;
    }

    private void a(rB rB2, List<rB> list) {
        rB rB3;
        Object object = this;
        double d2 = super.a();
        if (list.size() == 1) {
            rB rB4;
            rB rB5 = list.get(0);
            rB3 = rB2;
            object = rB5;
            if (rB4.a((qM<rv_0>)rB3) < d2) {
                return;
            }
        }
        while (list.size() >= 2) {
            double d3;
            int n2;
            block8: {
                double d4;
                Object object2;
                rB rB6;
                rB rB7;
                block10: {
                    block9: {
                        rB rB8;
                        double d5;
                        n2 = list.size();
                        rB7 = list.get(n2 - 2);
                        rB6 = list.get(n2 - 1);
                        rB3 = rB2;
                        object = new rw_0(rB7, rB6, d2);
                        d3 = ((rw_0)object).a((qM<rv_0>)rB3);
                        if (!(BY.w(d5) < d2)) break block8;
                        object2 = rB7;
                        rB3 = rB2;
                        d4 = ((rB)object2).a((qM<rv_0>)rB3);
                        if (d4 < d2) break block9;
                        rB3 = rB2;
                        object2 = rB6;
                        if (!(rB8.a((qM<rv_0>)rB3) < d2)) break block10;
                    }
                    return;
                }
                rB3 = rB6;
                object2 = rB7;
                double d6 = ((rB)object2).a((qM<rv_0>)rB3);
                object2 = this;
                if (super.b()) {
                    int n3 = d4 < d6 ? n2 - 1 : n2;
                    list.add(n3, rB2);
                    return;
                }
                if (d4 > d6) {
                    list.remove(n2 - 1);
                    list.add(rB2);
                }
                return;
            }
            if (!(d3 > 0.0)) break;
            list.remove(n2 - 1);
        }
        list.add(rB2);
    }
}

