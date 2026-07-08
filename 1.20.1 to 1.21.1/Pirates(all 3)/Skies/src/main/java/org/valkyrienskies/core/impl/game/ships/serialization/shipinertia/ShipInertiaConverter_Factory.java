/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipinertia;

import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.ShipInertiaConverter;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class ShipInertiaConverter_Factory
implements ek_2<ShipInertiaConverter> {
    @Override
    public final ShipInertiaConverter get() {
        return ShipInertiaConverter_Factory.newInstance();
    }

    public static ShipInertiaConverter_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ShipInertiaConverter newInstance() {
        return new ShipInertiaConverter();
    }

    static final class InstanceHolder {
        static final ShipInertiaConverter_Factory INSTANCE = new ShipInertiaConverter_Factory();

        private InstanceHolder() {
        }
    }
}

