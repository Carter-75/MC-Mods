/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shiptransform;

import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.ShipTransformConverterImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class ShipTransformConverterImpl_Factory
implements ek_2<ShipTransformConverterImpl> {
    @Override
    public final ShipTransformConverterImpl get() {
        return ShipTransformConverterImpl_Factory.newInstance();
    }

    public static ShipTransformConverterImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ShipTransformConverterImpl newInstance() {
        return new ShipTransformConverterImpl();
    }

    static final class InstanceHolder {
        static final ShipTransformConverterImpl_Factory INSTANCE = new ShipTransformConverterImpl_Factory();

        private InstanceHolder() {
        }
    }
}

