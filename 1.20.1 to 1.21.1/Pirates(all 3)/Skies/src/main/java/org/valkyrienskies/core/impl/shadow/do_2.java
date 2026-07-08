/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.cg_1;
import org.valkyrienskies.core.impl.shadow.co_2;
import org.valkyrienskies.core.impl.shadow.ct_2;
import org.valkyrienskies.core.impl.shadow.cu_1;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.do
 */
public class do_2
extends ct_2 {
    private static String d = "https://json-schema.org/draft-07/schema";
    private static final String e = "$id";

    @Override
    co_2 a() {
        return new co_2.a(d).a(e).b(c).a(dj_2.a(cu_1.a.V7)).a(Arrays.asList(new cg_1("$schema"), new cg_1(e), new cg_1("title"), new cg_1("description"), new cg_1("default"), new cg_1("definitions"), new cg_1("$comment"), new cg_1("contentMediaType"), new cg_1("contentEncoding"), new cg_1("examples"), new cg_1("message"))).a();
    }
}

