/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ah_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aq
 */
public enum aq_2 {
    ADD("add"),
    REMOVE("remove"),
    REPLACE("replace"),
    MOVE("move"),
    COPY("copy"),
    TEST("test");

    private static final Map<String, aq_2> OPS;
    public String rfcName;

    private static Map<String, aq_2> b() {
        HashMap<String, aq_2> hashMap = new HashMap<String, aq_2>();
        hashMap.put(aq_2.ADD.rfcName, ADD);
        hashMap.put(aq_2.REMOVE.rfcName, REMOVE);
        hashMap.put(aq_2.REPLACE.rfcName, REPLACE);
        hashMap.put(aq_2.MOVE.rfcName, MOVE);
        hashMap.put(aq_2.COPY.rfcName, COPY);
        hashMap.put(aq_2.TEST.rfcName, TEST);
        return Collections.unmodifiableMap(hashMap);
    }

    private aq_2(String string2) {
        this.rfcName = string2;
    }

    public static aq_2 a(String string) {
        if (string == null) {
            throw new ah_2("rfcName cannot be null");
        }
        aq_2 aq_22 = OPS.get(string.toLowerCase());
        if (aq_22 == null) {
            throw new ah_2("unknown / unsupported operation " + string);
        }
        return aq_22;
    }

    public final String a() {
        return this.rfcName;
    }

    static {
        HashMap<String, aq_2> hashMap = new HashMap<String, aq_2>();
        hashMap.put(aq_2.ADD.rfcName, ADD);
        hashMap.put(aq_2.REMOVE.rfcName, REMOVE);
        hashMap.put(aq_2.REPLACE.rfcName, REPLACE);
        hashMap.put(aq_2.MOVE.rfcName, MOVE);
        hashMap.put(aq_2.COPY.rfcName, COPY);
        hashMap.put(aq_2.TEST.rfcName, TEST);
        OPS = Collections.unmodifiableMap(hashMap);
    }
}

