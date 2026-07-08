/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.BoxesBlockShapeImpl_BuilderImpl_Factory;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.LiquidStateImpl_BuilderImpl_Factory;
import org.valkyrienskies.core.impl.shadow.CP;
import org.valkyrienskies.core.impl.shadow.CQ;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class DO
implements ek_2<DN> {
    private final Provider<CP> a;
    private final Provider<LiquidState.Builder> b;
    private final Provider<SolidState.Builder> c;
    private final Provider<BoxesBlockShape.Builder> d;

    private DO(Provider<CP> provider, Provider<LiquidState.Builder> provider2, Provider<SolidState.Builder> provider3, Provider<BoxesBlockShape.Builder> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    private DN a() {
        Provider<BoxesBlockShape.Builder> provider = this.d;
        Provider<SolidState.Builder> provider2 = this.c;
        Provider<LiquidState.Builder> provider3 = this.b;
        CP cP = this.a.get();
        return new DN(cP, provider3, provider2, provider);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static DO a(CQ cQ, LiquidStateImpl_BuilderImpl_Factory liquidStateImpl_BuilderImpl_Factory, ew_2 ew_22, BoxesBlockShapeImpl_BuilderImpl_Factory boxesBlockShapeImpl_BuilderImpl_Factory) {
        return new DO(cQ, liquidStateImpl_BuilderImpl_Factory, ew_22, boxesBlockShapeImpl_BuilderImpl_Factory);
    }

    private static DN a(CP cP, Provider<LiquidState.Builder> provider, Provider<SolidState.Builder> provider2, Provider<BoxesBlockShape.Builder> provider3) {
        return new DN(cP, provider, provider2, provider3);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        Provider<BoxesBlockShape.Builder> provider = ((DO)object).d;
        Provider<SolidState.Builder> provider2 = ((DO)object).c;
        Provider<LiquidState.Builder> provider3 = ((DO)object).b;
        object = ((DO)object).a.get();
        return new DN((CP)object, provider3, provider2, provider);
    }
}

