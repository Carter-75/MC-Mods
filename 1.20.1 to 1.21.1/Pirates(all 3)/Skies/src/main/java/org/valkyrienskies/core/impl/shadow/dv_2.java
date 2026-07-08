/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.du_2;
import org.valkyrienskies.core.impl.shadow.dy_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dv
 */
public final class dv_2
implements dy_2 {
    public static final Set<String> a = Collections.unmodifiableSet(du_2.b);

    @Override
    public final InputStream a(URI uRI) {
        return du_2.a(uRI).openStream();
    }
}

