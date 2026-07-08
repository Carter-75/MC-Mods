/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class zZ
implements Serializable {
    private static final long a = -3845586908418844111L;
    private final SortedMap<Comparable<?>, Long> b;

    public zZ() {
        this.b = new TreeMap();
    }

    private zZ(Comparator<?> comparator) {
        this.b = new TreeMap(comparator);
    }

    public final String toString() {
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value \t Freq. \t Pct. \t Cum Pct. \n");
        for (Comparable<?> comparable : this.b.keySet()) {
            stringBuilder.append(comparable);
            stringBuilder.append('\t');
            stringBuilder.append(this.b(comparable));
            stringBuilder.append('\t');
            stringBuilder.append(numberFormat.format(this.c(comparable)));
            stringBuilder.append('\t');
            stringBuilder.append(numberFormat.format(this.e(comparable)));
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public final void a(Comparable<?> comparable) {
        this.a(comparable, 1L);
    }

    private void a(int n2) {
        Long l2 = n2;
        zZ zZ2 = this;
        zZ2.a(l2, 1L);
    }

    private void a(long l2) {
        Long l3 = l2;
        zZ zZ2 = this;
        zZ2.a(l3, 1L);
    }

    private void a(char c2) {
        Character c3 = Character.valueOf(c2);
        zZ zZ2 = this;
        zZ2.a(c3, 1L);
    }

    public final void a(Comparable<?> l2, long l3) {
        Long l4 = l2;
        if (l2 instanceof Integer) {
            l4 = ((Integer)((Object)l2)).longValue();
        }
        try {
            Long l5 = (Long)this.b.get(l4);
            if (l5 != null) {
                this.b.put(l4, l5 + l3);
                return;
            }
            this.b.put(l4, l3);
        }
        catch (ClassCastException classCastException) {
            throw new oV(px_0.INSTANCES_NOT_COMPARABLE_TO_EXISTING_VALUES, l2.getClass().getName());
        }
    }

    private void a(int n2, long l2) {
        this.a(Long.valueOf(n2), l2);
    }

    private void a(long l2, long l3) {
        this.a(Long.valueOf(l2), l3);
    }

    private void a(char c2, long l2) {
        this.a(Character.valueOf(c2), l2);
    }

    private void b() {
        this.b.clear();
    }

    private Iterator<Comparable<?>> c() {
        return this.b.keySet().iterator();
    }

    private Iterator<Map.Entry<Comparable<?>, Long>> d() {
        return this.b.entrySet().iterator();
    }

    private long e() {
        long l2 = 0L;
        Iterator<Long> iterator2 = this.b.values().iterator();
        while (iterator2.hasNext()) {
            l2 += iterator2.next().longValue();
        }
        return l2;
    }

    private long b(Comparable<?> object) {
        while (object instanceof Integer) {
            zZ zZ2 = zZ3;
            long l2 = ((Integer)object).longValue();
            object = zZ2;
            object = l2;
            zZ zZ3 = zZ2;
        }
        long l3 = 0L;
        try {
            object = (Long)zZ3.b.get(object);
            if (object != null) {
                l3 = (Long)object;
            }
        }
        catch (ClassCastException classCastException) {}
        return l3;
    }

    private long b(int n2) {
        return this.b(Long.valueOf(n2));
    }

    private long b(long l2) {
        return this.b(Long.valueOf(l2));
    }

    private long b(char c2) {
        return this.b(Character.valueOf(c2));
    }

    private int f() {
        return this.b.keySet().size();
    }

    private double c(Comparable<?> comparable) {
        long l2 = this.e();
        if (l2 == 0L) {
            return Double.NaN;
        }
        return (double)this.b(comparable) / (double)l2;
    }

    private double c(int n2) {
        return this.c(Long.valueOf(n2));
    }

    private double c(long l2) {
        return this.c(Long.valueOf(l2));
    }

    private double c(char c2) {
        return this.c(Character.valueOf(c2));
    }

    private long d(Comparable<?> l2) {
        Object object;
        zZ zZ2;
        while (true) {
            if (zZ2.e() == 0L) {
                return 0L;
            }
            if (!(l2 instanceof Integer)) break;
            long l3 = ((Integer)((Object)l2)).longValue();
            object = zZ2;
            l2 = l3;
            zZ2 = object;
        }
        Comparator<Comparable<?>> comparator = zZ2.b.comparator();
        if (comparator == null) {
            comparator = new a(0);
        }
        long l4 = 0L;
        try {
            object = (Long)zZ2.b.get(l2);
            if (object != null) {
                l4 = (Long)object;
            }
        }
        catch (ClassCastException classCastException) {
            return 0L;
        }
        if (comparator.compare(l2, zZ2.b.firstKey()) < 0) {
            return 0L;
        }
        if (comparator.compare(l2, zZ2.b.lastKey()) >= 0) {
            return zZ2.e();
        }
        object = zZ2;
        for (Comparable comparable : ((zZ)object).b.keySet()) {
            if (comparator.compare(l2, comparable) > 0) {
                l4 += zZ2.b(comparable);
                continue;
            }
            return l4;
        }
        return l4;
    }

    private long d(int n2) {
        return this.d(Long.valueOf(n2));
    }

    private long d(long l2) {
        return this.d(Long.valueOf(l2));
    }

    private long d(char c2) {
        return this.d(Character.valueOf(c2));
    }

    private double e(Comparable<?> comparable) {
        long l2 = this.e();
        if (l2 == 0L) {
            return Double.NaN;
        }
        return (double)this.d(comparable) / (double)l2;
    }

    private double e(int n2) {
        return this.e(Long.valueOf(n2));
    }

    private double e(long l2) {
        return this.e(Long.valueOf(l2));
    }

    private double e(char c2) {
        return this.e(Character.valueOf(c2));
    }

    public final List<Comparable<?>> a() {
        long l2 = 0L;
        for (Long object : this.b.values()) {
            long entry = object;
            if (entry <= l2) continue;
            l2 = entry;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Comparable<?>, Long> entry : this.b.entrySet()) {
            long l3 = entry.getValue();
            if (l3 != l2) continue;
            arrayList.add(entry.getKey());
        }
        return arrayList;
    }

    private void a(zZ object) {
        ci_0.a(object, px_0.NULL_NOT_ALLOWED, new Object[0]);
        for (Map.Entry<Comparable<?>, Long> entry : ((zZ)((Object)object)).b.entrySet()) {
            this.a(entry.getKey(), (long)entry.getValue());
        }
    }

    private void a(Collection<zZ> object) {
        ci_0.a(object, px_0.NULL_NOT_ALLOWED, new Object[0]);
        object = object.iterator();
        while (object.hasNext()) {
            zZ zZ2 = (zZ)object.next();
            zZ zZ3 = zZ2;
            zZ2 = this;
            ci_0.a(zZ3, px_0.NULL_NOT_ALLOWED, new Object[0]);
            for (Map.Entry entry : zZ3.b.entrySet()) {
                zZ2.a((Comparable)entry.getKey(), (long)((Long)entry.getValue()));
            }
        }
    }

    public final int hashCode() {
        int n2 = 31 + (this.b == null ? 0 : this.b.hashCode());
        return n2;
    }

    public final boolean equals(Object obj) {
        zZ zZ2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zZ)) {
            return false;
        }
        zZ2 = zZ2;
        return !(this.b == null ? zZ2.b != null : !this.b.equals(zZ2.b));
    }

    static final class 1 {
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a<T extends Comparable<T>>
    implements Serializable,
    Comparator<Comparable<T>> {
        private static final long a = -3852193713161395148L;

        private a() {
        }

        private static int a(Comparable<T> comparable, Comparable<T> comparable2) {
            return comparable.compareTo(comparable2);
        }

        @Override
        public final /* synthetic */ int compare(Object object, Object object2) {
            object2 = (Comparable)object2;
            object = (Comparable)object;
            return object.compareTo(object2);
        }

        /* synthetic */ a(byte by) {
            this();
        }
    }
}

