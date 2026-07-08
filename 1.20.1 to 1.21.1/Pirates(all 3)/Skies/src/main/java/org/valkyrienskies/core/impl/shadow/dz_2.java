/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.net.URI;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.valkyrienskies.core.impl.shadow.dx_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dz
 */
public class dz_2
implements dx_2 {
    private static final Pattern a = Pattern.compile("^([a-z][a-z0-9+\\.\\-\\\\]*):");
    private final Map<String, dx_2> b;

    public dz_2(Map<String, dx_2> map2) {
        if (map2 == null) {
            throw new IllegalArgumentException("URIFactory map must not be null");
        }
        this.b = map2;
    }

    public Map<String, dx_2> a() {
        return this.b;
    }

    private String b(String object) {
        if (((Matcher)(object = a.matcher((CharSequence)object))).find()) {
            return ((Matcher)object).group(1);
        }
        return null;
    }

    private dx_2 c(String string) {
        dx_2 dx_22 = this.b.get(string);
        if (dx_22 == null) {
            throw new IllegalArgumentException(String.format("Unsupported URI scheme encountered: %s", string));
        }
        return dx_22;
    }

    @Override
    public URI a(String string) {
        Object object = this.b(string);
        if (object == null) {
            throw new IllegalArgumentException(String.format("Couldn't find URI scheme: %s", string));
        }
        object = this.c((String)object);
        return object.a(string);
    }

    @Override
    public URI a(URI uRI, String string) {
        if (uRI == null) {
            return this.a(string);
        }
        Object object = this.b(string);
        if (object == null) {
            object = uRI.getScheme();
            object = this.c((String)object);
            return object.a(uRI, string);
        }
        object = this.c((String)object);
        return object.a(string);
    }
}

