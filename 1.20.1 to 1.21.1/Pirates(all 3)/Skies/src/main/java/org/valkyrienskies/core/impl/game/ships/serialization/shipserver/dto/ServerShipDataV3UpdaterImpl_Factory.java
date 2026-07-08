/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto;

import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV3UpdaterImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class ServerShipDataV3UpdaterImpl_Factory
implements ek_2<ServerShipDataV3UpdaterImpl> {
    @Override
    public final ServerShipDataV3UpdaterImpl get() {
        return ServerShipDataV3UpdaterImpl_Factory.newInstance();
    }

    public static ServerShipDataV3UpdaterImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ServerShipDataV3UpdaterImpl newInstance() {
        return new ServerShipDataV3UpdaterImpl();
    }

    static final class InstanceHolder {
        static final ServerShipDataV3UpdaterImpl_Factory INSTANCE = new ServerShipDataV3UpdaterImpl_Factory();

        private InstanceHolder() {
        }
    }
}

