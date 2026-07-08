/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.Collections;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.dw_2;
import org.valkyrienskies.core.impl.shadow.dx_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.du
 */
public final class du_2
implements dx_2 {
    static final URLStreamHandler a = new dw_2();
    public static final Set<String> b = Collections.unmodifiableSet(dw_2.a);

    public static URL a(URI uRI) {
        return new URL(null, uRI.toString(), a);
    }

    @Override
    public final URI a(String string) {
        try {
            return new URL(null, string, a).toURI();
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException("Unable to create URI.", malformedURLException);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IllegalArgumentException("Unable to create URI.", uRISyntaxException);
        }
    }

    @Override
    public final URI a(URI uRI, String string) {
        try {
            return new URL(du_2.a(uRI), string, a).toURI();
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException("Unable to create URI.", malformedURLException);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IllegalArgumentException("Unable to create URI.", uRISyntaxException);
        }
    }
}

