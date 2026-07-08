/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.world.connectivity.DoubleAugmentation;
import org.valkyrienskies.core.api.world.connectivity.DoubleComponentAugmentation;
import org.valkyrienskies.core.impl.shadow.eb_0;
import org.valkyrienskies.core.impl.shadow.ed_0;
import org.valkyrienskies.core.impl.shadow.ee_0;

public final class DZ {
    public final Map<String, DoubleAugmentation> a = new LinkedHashMap();

    @Inject
    public DZ() {
    }

    public final DoubleAugmentation a(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        if (this.a.containsKey(string)) {
            DoubleAugmentation doubleAugmentation = this.a.get(string);
            Intrinsics.checkNotNull((Object)doubleAugmentation);
            return doubleAugmentation;
        }
        ed_0 ed_02 = new ed_0(string);
        this.a.put(string, ed_02);
        return ed_02;
    }

    private DoubleAugmentation c(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        if (this.a.containsKey(string)) {
            DoubleAugmentation doubleAugmentation = this.a.get(string);
            Intrinsics.checkNotNull((Object)doubleAugmentation);
            return doubleAugmentation;
        }
        eb_0 eb_02 = new eb_0(string);
        this.a.put(string, eb_02);
        return eb_02;
    }

    public final DoubleComponentAugmentation b(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        if (this.a.containsKey(string)) {
            DoubleAugmentation doubleAugmentation = this.a.get(string);
            Intrinsics.checkNotNull((Object)doubleAugmentation);
            return (DoubleComponentAugmentation)doubleAugmentation;
        }
        ee_0 ee_02 = new ee_0(string);
        this.a.put(string, ee_02);
        return ee_02;
    }
}

