/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.uY;
import org.valkyrienskies.core.impl.shadow.ve_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class uB
implements uY {
    private final Collection<String> a = new ArrayList<String>();

    private uB(String ... stringArray) {
        for (String string : stringArray) {
            this.a.add(string);
        }
    }

    private uB(Collection<String> collection) {
        this.a.addAll(collection);
    }

    @Override
    public final Collection<String> a() {
        return this.a;
    }

    @Override
    public final boolean a(String string) {
        for (String string2 : this.a) {
            if (!string2.equals(string)) continue;
            return true;
        }
        return false;
    }

    private void b(String string) {
        if (!this.a(string)) {
            throw new ve_0(string);
        }
    }
}

