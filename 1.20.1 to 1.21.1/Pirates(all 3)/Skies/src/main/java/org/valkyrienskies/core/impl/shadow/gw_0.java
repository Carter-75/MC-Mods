/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.valkyrienskies.core.impl.shadow.gv_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gw
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0003\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Gw;", "Lorg/valkyrienskies/core/impl/shadow/Gv;", "", "a", "()Ljava/lang/String;", "", "p0", "(I)Ljava/lang/String;", "c", "I", "b", "", "d", "Ljava/util/List;", "<init>", "()V"})
public final class gw_0
implements gv_0 {
    public static final gw_0 INSTANCE = new gw_0();
    private static final int b = 6801;
    private static final int c = 3;
    private static final List<String> d;

    private gw_0() {
    }

    @Override
    public final String a() {
        return gw_0.a(3);
    }

    private static String a(int n2) {
        String string = ThreadLocalRandom.current().ints(3L, 0, d.size()).mapToObj(gw_0::b).collect(Collectors.joining("-"));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"");
        return string;
    }

    private static final String b(int n2) {
        return d.get(n2);
    }

    static {
        ClassLoader classLoader = INSTANCE.getClass().getClassLoader();
        Intrinsics.checkNotNull((Object)classLoader);
        InputStream inputStream = classLoader.getResourceAsStream("nounlist.txt");
        Intrinsics.checkNotNull((Object)inputStream);
        Closeable closeable = inputStream;
        Charset charset = Charsets.UTF_8;
        closeable = new InputStreamReader((InputStream)closeable, charset);
        List list = new BufferedReader((Reader)closeable, 8192).lines().collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(list, (String)"");
        d = list;
    }
}

