/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fa_1;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.fj_2;
import org.valkyrienskies.core.impl.shadow.fp_2;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.jL;
import org.valkyrienskies.core.impl.shadow.jN;

public final class jP<K, V>
extends jL<K, V> {
    private static final long a = 20150612L;
    private final fq_1<? super K, ? extends K> b;
    private final fq_1<? super V, ? extends V> c;

    public static <K, V> jP<K, V> a(fa_1<K, V> fa_12, fq_1<? super K, ? extends K> fq_12, fq_1<? super V, ? extends V> fq_13) {
        return new jP<K, V>(fa_12, fq_12, fq_13);
    }

    private static <K, V> jP<K, V> b(fa_1<K, V> fa_12, fq_1<? super K, ? extends K> object, fq_1<? super V, ? extends V> fq_12) {
        object = new jP<K, V>(fa_12, object, fq_12);
        if (!fa_12.b()) {
            fa_12 = new jN<K, V>(fa_12);
            ((jL)object).c();
            ((jL)object).a(fa_12);
        }
        return object;
    }

    private jP(fa_1<K, V> fa_12, fq_1<? super K, ? extends K> fq_12, fq_1<? super V, ? extends V> fq_13) {
        super(fa_12);
        this.b = fq_12;
        this.c = fq_13;
    }

    private K a(K k2) {
        if (this.b == null) {
            return k2;
        }
        return this.b.a(k2);
    }

    private V b(V v) {
        if (this.c == null) {
            return v;
        }
        return this.c.a(v);
    }

    @Override
    public final boolean b(K object, V v) {
        K k2 = this.a(object);
        object = this;
        return this.j().b(k2, ((jP)object).c == null ? v : ((jP)object).c.a(v));
    }

    @Override
    public final boolean a(K k2, Iterable<? extends V> object) {
        if (object == null) {
            throw new NullPointerException("Values must not be null.");
        }
        fq_1<? super V, ? extends V> fq_12 = this.c;
        object = fj_2.a(object);
        object = fj_2.a(fp_2.a(((fj_2)object).a, fq_12));
        return (object = object.iterator()).hasNext() && fd_2.a(this.j().e(this.a(k2)), object);
    }

    @Override
    public final boolean a(Map<? extends K, ? extends V> object) {
        if (object == null) {
            throw new NullPointerException("Map must not be null.");
        }
        boolean bl = false;
        for (Map.Entry entry : object.entrySet()) {
            bl |= ((jL)this).b(entry.getKey(), entry.getValue());
        }
        return bl;
    }

    @Override
    public final boolean a(fa_1<? extends K, ? extends V> object) {
        if (object == null) {
            throw new NullPointerException("Map must not be null.");
        }
        boolean bl = false;
        for (Map.Entry entry : object.d()) {
            bl |= ((jL)this).b(entry.getKey(), entry.getValue());
        }
        return bl;
    }
}

