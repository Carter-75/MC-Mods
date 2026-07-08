/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.db_1;
import org.valkyrienskies.core.impl.shadow.dy_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dC
 */
public final class dc_1
implements dy_2 {
    public static final Set<String> a = Collections.unmodifiableSet(db_1.a);

    @Override
    public final InputStream a(URI object) {
        object = ((URI)object).toURL().openConnection();
        return this.a((URLConnection)object);
    }

    private InputStream a(URLConnection object) {
        InputStream inputStream;
        boolean bl;
        int n2 = 0;
        do {
            HttpURLConnection httpURLConnection;
            int n3;
            if (object instanceof HttpURLConnection) {
                ((HttpURLConnection)object).setInstanceFollowRedirects(false);
            }
            inputStream = ((URLConnection)object).getInputStream();
            bl = false;
            if (!(object instanceof HttpURLConnection) || (n3 = (httpURLConnection = (HttpURLConnection)object).getResponseCode()) < 300 || n3 > 307 || n3 == 306 || n3 == 304) continue;
            object = httpURLConnection.getURL();
            String string = httpURLConnection.getHeaderField("Location");
            URL uRL = null;
            if (string != null) {
                uRL = new URL((URL)object, string);
            }
            httpURLConnection.disconnect();
            if (uRL == null || !uRL.getProtocol().equals("http") && !uRL.getProtocol().equals("https") || n2 >= 5) {
                throw new SecurityException("illegal URL redirect");
            }
            bl = true;
            object = uRL.openConnection();
            ++n2;
        } while (bl);
        return inputStream;
    }
}

