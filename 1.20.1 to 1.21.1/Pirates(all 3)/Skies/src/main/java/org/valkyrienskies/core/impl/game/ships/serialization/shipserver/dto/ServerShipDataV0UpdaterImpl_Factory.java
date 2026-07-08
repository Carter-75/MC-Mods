/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto;

import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0UpdaterImpl;
import org.valkyrienskies.core.impl.shadow.ek_2;

public final class ServerShipDataV0UpdaterImpl_Factory
implements ek_2<ServerShipDataV0UpdaterImpl> {
    @Override
    public final ServerShipDataV0UpdaterImpl get() {
        return ServerShipDataV0UpdaterImpl_Factory.newInstance();
    }

    public static ServerShipDataV0UpdaterImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ServerShipDataV0UpdaterImpl newInstance() {
        return new ServerShipDataV0UpdaterImpl();
    }

    static final class InstanceHolder {
        static final ServerShipDataV0UpdaterImpl_Factory INSTANCE = new ServerShipDataV0UpdaterImpl_Factory();

        private InstanceHolder() {
        }
    }
}

