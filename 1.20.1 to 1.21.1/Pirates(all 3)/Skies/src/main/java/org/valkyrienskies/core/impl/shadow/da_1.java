/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.dy_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dA
 */
public class da_1
implements dy_2 {
    private final Map<String, dy_2> a;

    public da_1(Map<String, dy_2> map2) {
        if (map2 == null) {
            throw new IllegalArgumentException("URIFetcher map must not be null");
        }
        this.a = map2;
    }

    public Map<String, dy_2> a() {
        return this.a;
    }

    @Override
    public InputStream a(URI uRI) {
        dy_2 dy_22 = this.a.get(uRI.getScheme());
        if (dy_22 == null) {
            throw new IllegalArgumentException(String.format("Unsupported URI scheme encountered: %s", uRI.getScheme()));
        }
        return dy_22.a(uRI);
    }
}

