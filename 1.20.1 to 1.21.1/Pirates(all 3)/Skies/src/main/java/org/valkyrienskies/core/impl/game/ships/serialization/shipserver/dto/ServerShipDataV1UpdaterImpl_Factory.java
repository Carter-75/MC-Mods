/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto;

import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV1UpdaterImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class ServerShipDataV1UpdaterImpl_Factory
implements ek_2<ServerShipDataV1UpdaterImpl> {
    @Override
    public final ServerShipDataV1UpdaterImpl get() {
        return ServerShipDataV1UpdaterImpl_Factory.newInstance();
    }

    public static ServerShipDataV1UpdaterImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ServerShipDataV1UpdaterImpl newInstance() {
        return new ServerShipDataV1UpdaterImpl();
    }

    static final class InstanceHolder {
        static final ServerShipDataV1UpdaterImpl_Factory INSTANCE = new ServerShipDataV1UpdaterImpl_Factory();

        private InstanceHolder() {
        }
    }
}

