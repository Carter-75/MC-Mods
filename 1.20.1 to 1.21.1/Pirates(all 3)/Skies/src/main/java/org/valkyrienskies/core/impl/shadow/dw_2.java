/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.dw$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.dw;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dw
 */
class dw_2
extends URLStreamHandler {
    public static final Set<String> a = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("classpath", "resource")));

    dw_2() {
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected URLConnection openConnection(URL pURL) {
        void var1_1;
        return new dw.a(this, (URL)var1_1);
    }
}

