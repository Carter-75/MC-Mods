/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import org.valkyrienskies.core.impl.shadow.ig_2;

public final class jY
extends Properties {
    private static final long a = 1L;

    @Override
    public final synchronized Enumeration<Object> keys() {
        Object object = this.keySet();
        ArrayList<String> arrayList = new ArrayList<String>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            arrayList.add(e2.toString());
        }
        Collections.sort(arrayList);
        return new ig_2<Object>(arrayList.iterator());
    }
}

