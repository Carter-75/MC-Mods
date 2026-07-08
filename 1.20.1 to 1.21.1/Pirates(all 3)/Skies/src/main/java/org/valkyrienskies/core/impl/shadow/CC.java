/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.CA;
import org.valkyrienskies.core.impl.shadow.CH;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class CC
implements ek_2<CA> {
    private final Provider<CH> a;
    private final Provider<ObjectMapper> b;

    private CC(Provider<CH> provider, Provider<ObjectMapper> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    private CA a() {
        ObjectMapper objectMapper = this.b.get();
        CH cH = this.a.get();
        return new CA(cH, objectMapper);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static CC a(ew_2 ew_22, ew_2 ew_23) {
        return new CC(ew_22, ew_23);
    }

    private static CA a(CH cH, ObjectMapper objectMapper) {
        return new CA(cH, objectMapper);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        ObjectMapper objectMapper = ((CC)object).b.get();
        object = ((CC)object).a.get();
        return new CA((CH)object, objectMapper);
    }
}

