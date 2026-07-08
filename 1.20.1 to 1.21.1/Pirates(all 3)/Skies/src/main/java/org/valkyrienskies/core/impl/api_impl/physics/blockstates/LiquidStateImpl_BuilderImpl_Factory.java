/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.api_impl.physics.blockstates;

import org.valkyrienskies.core.impl.api_impl.physics.blockstates.LiquidStateImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class LiquidStateImpl_BuilderImpl_Factory
implements ek_2<LiquidStateImpl.BuilderImpl> {
    @Override
    public final LiquidStateImpl.BuilderImpl get() {
        return LiquidStateImpl_BuilderImpl_Factory.newInstance();
    }

    public static LiquidStateImpl_BuilderImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LiquidStateImpl.BuilderImpl newInstance() {
        return new LiquidStateImpl.BuilderImpl();
    }

    static final class InstanceHolder {
        static final LiquidStateImpl_BuilderImpl_Factory INSTANCE = new LiquidStateImpl_BuilderImpl_Factory();

        private InstanceHolder() {
        }
    }
}

