/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qE;
import org.valkyrienskies.core.impl.shadow.qm_0;
import org.valkyrienskies.core.impl.shadow.qp_0;
import org.valkyrienskies.core.impl.shadow.qx_0;
import org.valkyrienskies.core.impl.shadow.qy_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class qG<T>
extends qm_0<Double>
implements qE<T> {
    private final List<Double> b;
    private final List<Integer> c;

    private qG(List<Double> list) {
        super(list);
        list = new ArrayList(this.a());
        Collections.sort(list);
        this.b = Collections.unmodifiableList(list);
        int n2 = this.b();
        ArrayList<Integer> arrayList = new ArrayList<Integer>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(i2);
        }
        this.c = Collections.unmodifiableList(qG.a(arrayList, this.a(), this.b));
    }

    private qG(Double[] doubleArray) {
        this(Arrays.asList(doubleArray));
    }

    @Override
    public final List<T> b(List<T> list) {
        return qG.a(list, this.a(), this.b);
    }

    private static <S> List<S> a(List<S> list, List<Double> list2, List<Double> list3) {
        int n2 = list.size();
        if (list2.size() != n2) {
            throw new oS(list2.size(), n2);
        }
        if (list3.size() != n2) {
            throw new oS(list3.size(), n2);
        }
        list2 = new ArrayList<Double>(list2);
        ArrayList<S> arrayList = new ArrayList<S>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = list2.indexOf(list3.get(i2));
            arrayList.add(list.get(n3));
            list2.set(n3, null);
        }
        return arrayList;
    }

    @Override
    protected final boolean a(qp_0 object) {
        if (!(object instanceof qG)) {
            return false;
        }
        object = (qG)object;
        if (this.b() != ((qm_0)object).b()) {
            return false;
        }
        List<Integer> list = this.c;
        object = ((qG)object).c;
        for (int i2 = 0; i2 < this.b(); ++i2) {
            if (list.get(i2) == object.get(i2)) continue;
            return false;
        }
        return true;
    }

    @Override
    protected final void a(List<Double> object) {
        object = object.iterator();
        while (object.hasNext()) {
            double d2 = (Double)object.next();
            if (!(d2 < 0.0) && !(d2 > 1.0)) continue;
            throw new qy_0(px_0.OUT_OF_RANGE_SIMPLE, d2, 0, 1);
        }
    }

    private static List<Double> a(int n2) {
        ArrayList<Double> arrayList = new ArrayList<Double>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(qx_0.a().nextDouble());
        }
        return arrayList;
    }

    private static List<Double> b(int n2) {
        ArrayList<Double> arrayList = new ArrayList<Double>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add((double)i2 / (double)n2);
        }
        return arrayList;
    }

    private static <S> List<Double> a(List<S> list, Comparator<S> object) {
        ArrayList<S> arrayList = new ArrayList<S>(list);
        Collections.sort(arrayList, object);
        object = arrayList;
        if (list.size() != object.size()) {
            throw new oS(object.size(), list.size());
        }
        int n2 = list.size();
        list = new ArrayList<S>(list);
        Double[] doubleArray = new Double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = list.indexOf(object.get(i2));
            if (n3 == -1) {
                throw new oV(px_0.DIFFERENT_ORIG_AND_PERMUTED_DATA, new Object[0]);
            }
            doubleArray[n3] = (double)i2 / (double)n2;
            list.set(n3, null);
        }
        return Arrays.asList(doubleArray);
    }

    private static <S> List<Double> a(List<S> list, List<S> list2) {
        if (list.size() != list2.size()) {
            throw new oS(list2.size(), list.size());
        }
        int n2 = list.size();
        list = new ArrayList<S>(list);
        Double[] doubleArray = new Double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = list.indexOf(list2.get(i2));
            if (n3 == -1) {
                throw new oV(px_0.DIFFERENT_ORIG_AND_PERMUTED_DATA, new Object[0]);
            }
            doubleArray[n3] = (double)i2 / (double)n2;
            list.set(n3, null);
        }
        return Arrays.asList(doubleArray);
    }

    @Override
    public String toString() {
        return String.format("(f=%s pi=(%s))", this.d(), this.c);
    }

    private static List<Integer> c(int n2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(i2);
        }
        return arrayList;
    }
}

