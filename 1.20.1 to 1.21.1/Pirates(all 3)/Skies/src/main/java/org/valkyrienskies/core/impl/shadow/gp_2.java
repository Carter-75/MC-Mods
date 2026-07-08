/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.gl_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gp
 */
public final class gp_2<K, V>
extends gl_2<K, V>
implements Serializable {
    private static final long d = 721969328361810L;

    public gp_2() {
        super(new LinkedHashMap(), new LinkedHashMap());
    }

    private gp_2(Map<? extends K, ? extends V> map2) {
        super(new LinkedHashMap(), new LinkedHashMap());
        this.putAll(map2);
    }

    private gp_2(Map<K, V> map2, Map<V, K> map3, ey_1<V, K> ey_12) {
        super(map2, map3, ey_12);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    protected final gl_2 a(Map map2, Map map3, gl_2 gl_22) {
        return new gp_2<K, V>(map2, map3, gl_22);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
    }

    private void a(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        object = (Map)((ObjectInputStream)object).readObject();
        this.putAll(object);
    }
}

