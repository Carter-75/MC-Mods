/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.jc
 *  org.valkyrienskies.core.impl.shadow.jc$c
 *  org.valkyrienskies.core.impl.shadow.js$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.iz_0;
import org.valkyrienskies.core.impl.shadow.jc;
import org.valkyrienskies.core.impl.shadow.jc_0;
import org.valkyrienskies.core.impl.shadow.js;

/*
 * Signature claims super is org.valkyrienskies.core.impl.shadow.jc_0<K, V>, not org.valkyrienskies.core.impl.shadow.jc - discarding signature.
 * Renamed from org.valkyrienskies.core.impl.shadow.js
 */
public final class js_0
extends jc
implements Serializable,
Cloneable {
    private static final long k = 9077234323521161066L;

    public js_0() {
        super(16, 0.75f, 12);
    }

    public js_0(int n2) {
        super(n2);
    }

    private js_0(int n2, float f2) {
        super(n2, f2);
    }

    private js_0(Map<? extends K, ? extends V> map2) {
        super(map2);
    }

    private js_0<K, V> a() {
        return (js_0)((Object)super.i());
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.a(objectOutputStream);
    }

    private void b(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a(objectInputStream);
    }

    public final K b(int n2) {
        return this.a(n2).getKey();
    }

    private V c(int n2) {
        return this.a(n2).getValue();
    }

    public final int g(Object object) {
        object = this.a(object);
        int n2 = 0;
        jc_0.c_0 c_02 = ((jc.c)this.j).f;
        while (c_02 != this.j) {
            if (this.a(object, c_02.c)) {
                return n2;
            }
            c_02 = ((jc.c)c_02).f;
            ++n2;
        }
        return -1;
    }

    private V d(int n2) {
        js_0 js_02 = this;
        return ((iz_0)((Object)js_02)).remove(js_02.b(n2));
    }

    private List<K> b() {
        return new js.a(this);
    }

    public final /* synthetic */ Object clone() {
        js_0 js_02 = this;
        return (js_0)((Object)super.i());
    }
}

