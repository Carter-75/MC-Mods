/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.cU
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.HashSet;
import org.valkyrienskies.core.impl.shadow.cU;
import org.valkyrienskies.core.impl.shadow.cu_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dp
 */
enum dp_2 {
    AllVersions(new cu_1.a[]{cu_1.a.V4, cu_1.a.V6, cu_1.a.V7, cu_1.a.V201909, cu_1.a.V202012}),
    MinV6(new cu_1.a[]{cu_1.a.V6, cu_1.a.V7, cu_1.a.V201909, cu_1.a.V202012}),
    MinV7(new cu_1.a[]{cu_1.a.V7, cu_1.a.V201909, cu_1.a.V202012}),
    MaxV201909(new cu_1.a[]{cu_1.a.V4, cu_1.a.V6, cu_1.a.V7, cu_1.a.V201909}),
    MinV201909(new cu_1.a[]{cu_1.a.V201909, cu_1.a.V202012}),
    MinV202012(new cu_1.a[]{cu_1.a.V202012});

    private static final cu_1 specVersion;
    private final cu_1.a[] versionFlags;

    private dp_2(cu_1.a[] aArray) {
        this.versionFlags = aArray;
    }

    final long a() {
        return specVersion.a(new HashSet<cu_1.a>(Arrays.asList(this.versionFlags)));
    }

    static {
        specVersion = new cU();
    }
}

