/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.api_impl.physics.blockstates;

import javax.inject.Provider;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.SolidStateImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class SolidStateImpl_BuilderImpl_Factory
implements ek_2<SolidStateImpl.BuilderImpl> {
    private final Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilderProvider;

    /*
     * WARNING - void declaration
     */
    public SolidStateImpl_BuilderImpl_Factory(Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilderProvider) {
        void var1_1;
        this.newBoxesBlockShapeBuilderProvider = var1_1;
    }

    @Override
    public final SolidStateImpl.BuilderImpl get() {
        return SolidStateImpl_BuilderImpl_Factory.newInstance(this.newBoxesBlockShapeBuilderProvider);
    }

    public static SolidStateImpl_BuilderImpl_Factory create(Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilderProvider) {
        Provider<BoxesBlockShape.Builder> provider;
        return new SolidStateImpl_BuilderImpl_Factory(provider);
    }

    public static SolidStateImpl.BuilderImpl newInstance(Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilder) {
        Provider<BoxesBlockShape.Builder> provider;
        return new SolidStateImpl.BuilderImpl(provider);
    }
}

