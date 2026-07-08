/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fa_1;
import org.valkyrienskies.core.impl.shadow.jM;

public final class jO<K, V>
extends jM<K, V>
implements Serializable {
    private static final long b = 20151118L;
    private static final int c = 16;
    private static final int d = 3;
    private final int e;

    public jO() {
        this(16, 3);
    }

    private jO(int n2) {
        this(16, n2);
    }

    private jO(int n2, int n3) {
        super(new HashMap(n2));
        this.e = n3;
    }

    private jO(fa_1<? extends K, ? extends V> fa_12) {
        this(fa_12.a(), 3);
        super.a(fa_12);
    }

    private jO(Map<? extends K, ? extends V> map2) {
        this(map2.size(), 3);
        super.a(map2);
    }

    private HashSet<V> m() {
        return new HashSet(this.e);
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.a(objectOutputStream);
    }

    private void b(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.b(new HashMap());
        this.a(objectInputStream);
    }

    @Override
    protected final /* synthetic */ Set k() {
        return this.m();
    }

    @Override
    protected final /* synthetic */ Collection l() {
        return this.m();
    }
}

