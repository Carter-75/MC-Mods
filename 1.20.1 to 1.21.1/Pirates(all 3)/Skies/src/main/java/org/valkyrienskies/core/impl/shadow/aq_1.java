/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aQ
 */
public enum aq_1 {
    DRAFT_6("http://json-schema.org/draft-06/schema#"),
    DRAFT_7("http://json-schema.org/draft-07/schema#"),
    DRAFT_2019_09("https://json-schema.org/draft/2019-09/schema"),
    DRAFT_2020_12("https://json-schema.org/draft/2020-12/schema");

    private final String identifier;

    private aq_1(String string2) {
        this.identifier = string2;
    }

    public final String a() {
        return this.identifier;
    }
}

