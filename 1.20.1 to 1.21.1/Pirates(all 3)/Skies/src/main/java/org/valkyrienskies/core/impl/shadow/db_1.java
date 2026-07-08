/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.dx_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dB
 */
public final class db_1
implements dx_2 {
    public static final Set<String> a = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("http", "https", "ftp", "file", "jar")));

    @Override
    public final URI a(String string) {
        try {
            return URI.create(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Unable to create URI.", illegalArgumentException);
        }
    }

    @Override
    public final URI a(URI uRI, String string) {
        try {
            return new URL(uRI.toURL(), string).toURI();
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException("Unable to create URI.", malformedURLException);
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IllegalArgumentException("Unable to create URI.", uRISyntaxException);
        }
    }
}

