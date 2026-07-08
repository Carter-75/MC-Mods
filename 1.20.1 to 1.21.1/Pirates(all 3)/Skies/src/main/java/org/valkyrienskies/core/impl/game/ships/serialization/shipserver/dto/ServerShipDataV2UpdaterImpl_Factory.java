/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto;

import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2UpdaterImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class ServerShipDataV2UpdaterImpl_Factory
implements ek_2<ServerShipDataV2UpdaterImpl> {
    @Override
    public final ServerShipDataV2UpdaterImpl get() {
        return ServerShipDataV2UpdaterImpl_Factory.newInstance();
    }

    public static ServerShipDataV2UpdaterImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ServerShipDataV2UpdaterImpl newInstance() {
        return new ServerShipDataV2UpdaterImpl();
    }

    static final class InstanceHolder {
        static final ServerShipDataV2UpdaterImpl_Factory INSTANCE = new ServerShipDataV2UpdaterImpl_Factory();

        private InstanceHolder() {
        }
    }
}

