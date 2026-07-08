/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.am_2;
import org.valkyrienskies.core.impl.shadow.aq_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ak
 */
public class ak_2
extends RuntimeException {
    private aq_2 a;
    private am_2 b;

    public ak_2(String string, aq_2 aq_22, am_2 am_22) {
        super(string);
        this.a = aq_22;
        this.b = am_22;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.a != null) {
            stringBuilder.append('[').append((Object)this.a).append(" Operation] ");
        }
        stringBuilder.append(this.getMessage());
        if (this.b != null) {
            stringBuilder.append(" at ").append(this.b.a() ? "root" : this.b);
        }
        return stringBuilder.toString();
    }
}

