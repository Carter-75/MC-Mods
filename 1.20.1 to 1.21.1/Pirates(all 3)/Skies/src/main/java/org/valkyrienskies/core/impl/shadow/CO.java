/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.CN;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class CO
implements ek_2<CN> {
    private final Provider<ObjectMapper> a;

    private CO(Provider<ObjectMapper> provider) {
        this.a = provider;
    }

    private CN a() {
        ObjectMapper objectMapper = this.a.get();
        return new CN(objectMapper);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static CO a(ew_2 ew_22) {
        return new CO(ew_22);
    }

    private static CN a(ObjectMapper objectMapper) {
        return new CN(objectMapper);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        object = ((CO)object).a.get();
        return new CN((ObjectMapper)object);
    }
}

