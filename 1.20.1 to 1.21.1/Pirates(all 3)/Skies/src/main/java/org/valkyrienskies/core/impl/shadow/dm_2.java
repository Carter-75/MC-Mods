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
 * Renamed from org.valkyrienskies.core.impl.shadow.dm
 */
public class dm_2
extends ct_2 {
    String d = "https://json-schema.org/draft-04/schema";
    String e = "id";

    @Override
    co_2 a() {
        return new co_2.a(this.d).a(this.e).b(c).a(dj_2.a(cu_1.a.V4)).a(Arrays.asList(new cg_1("$schema"), new cg_1("id"), new cg_1("title"), new cg_1("description"), new cg_1("default"), new cg_1("definitions"), new cg_1("exampleSetFlag"))).a();
    }
}

