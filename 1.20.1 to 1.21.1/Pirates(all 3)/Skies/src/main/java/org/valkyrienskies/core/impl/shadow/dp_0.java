/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.do_0;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.ej_2;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.internal.VsiCore;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dp
 */
public final class dp_0
implements ek_2<do_0> {
    private final Provider<VsiCore> a;

    private dp_0(Provider<VsiCore> provider) {
        this.a = provider;
    }

    private do_0 a() {
        dt_1<VsiCore> dt_12 = ej_2.a(this.a);
        return new do_0(dt_12);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static dp_0 a(ew_2 ew_22) {
        return new dp_0(ew_22);
    }

    private static do_0 a(dt_1<VsiCore> dt_12) {
        return new do_0(dt_12);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        object = ej_2.a(((dp_0)object).a);
        return new do_0((dt_1<VsiCore>)object);
    }
}

