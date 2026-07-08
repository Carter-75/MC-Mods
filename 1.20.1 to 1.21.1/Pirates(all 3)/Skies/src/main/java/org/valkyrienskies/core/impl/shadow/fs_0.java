/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.ej_2;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.fr_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fs
 */
public final class fs_0
implements ek_2<fr_0> {
    private final Provider<EY> a;

    private fs_0(Provider<EY> provider) {
        this.a = provider;
    }

    private fr_0 a() {
        dt_1<EY> dt_12 = ej_2.a(this.a);
        return new fr_0(dt_12);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static fs_0 a(ew_2 ew_22) {
        return new fs_0(ew_22);
    }

    private static fr_0 a(dt_1<EY> dt_12) {
        return new fr_0(dt_12);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        object = ej_2.a(((fs_0)object).a);
        return new fr_0((dt_1<EY>)object);
    }
}

