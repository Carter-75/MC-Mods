/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.bu_1;
import org.valkyrienskies.core.impl.shadow.cw_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bV
 */
public class bv_1 {
    static final String a = "com.networknt.schema.CollectorKey";
    private Map<String, Object> b = new HashMap<String, Object>();
    private Map<String, Object> c = new HashMap<String, Object>();

    public static bv_1 a() {
        return (bv_1)cw_1.a(a);
    }

    public <E> void a(String string, bu_1<E> bu_12) {
        this.b.put(string, bu_12);
    }

    public <E> void a(String string, Object object) {
        this.b.put(string, object);
    }

    public Object a(String string) {
        Object object = this.b.get(string);
        if (object instanceof bu_1 && this.c.get(string) != null) {
            return this.c.get(string);
        }
        return this.b.get(string);
    }

    public Map<String, Object> b() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.putAll(this.b);
        hashMap.putAll(this.c);
        return hashMap;
    }

    public void b(String object, Object object2) {
        if ((object = this.b.get(object)) instanceof bu_1) {
            object = (bu_1)object;
            object.a(object2);
        }
    }

    public void c() {
        this.b = new HashMap<String, Object>();
        this.c = new HashMap<String, Object>();
    }

    void d() {
        Object object = this.b.entrySet();
        object = object.iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            if (!(entry.getValue() instanceof bu_1)) continue;
            bu_1 bu_12 = (bu_1)entry.getValue();
            this.c.put((String)entry.getKey(), bu_12.a());
        }
    }
}

