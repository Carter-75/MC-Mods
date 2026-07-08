/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.api_impl.physics.blockstates;

import org.valkyrienskies.core.impl.api_impl.physics.blockstates.BoxesBlockShapeImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class BoxesBlockShapeImpl_BuilderImpl_Factory
implements ek_2<BoxesBlockShapeImpl.BuilderImpl> {
    @Override
    public final BoxesBlockShapeImpl.BuilderImpl get() {
        return BoxesBlockShapeImpl_BuilderImpl_Factory.newInstance();
    }

    public static BoxesBlockShapeImpl_BuilderImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BoxesBlockShapeImpl.BuilderImpl newInstance() {
        return new BoxesBlockShapeImpl.BuilderImpl();
    }

    static final class InstanceHolder {
        static final BoxesBlockShapeImpl_BuilderImpl_Factory INSTANCE = new BoxesBlockShapeImpl_BuilderImpl_Factory();

        private InstanceHolder() {
        }
    }
}

