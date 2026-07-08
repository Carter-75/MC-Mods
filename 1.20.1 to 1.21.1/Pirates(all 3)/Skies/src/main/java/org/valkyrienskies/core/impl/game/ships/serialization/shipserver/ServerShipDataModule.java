/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver;

import kotlin.Metadata;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV0UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV1Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV1UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV2UpdaterImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV3Updater;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV3UpdaterImpl;
import org.valkyrienskies.core.impl.shadow.dp_1;
import org.valkyrienskies.core.impl.shadow.dw_1;

@dw_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataModule;", "", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverterImpl;", "impl", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverter;", "converter", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverter;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0UpdaterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0Updater;", "v0", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0UpdaterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0Updater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV1UpdaterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV1Updater;", "v1", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV1UpdaterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV1Updater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2UpdaterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2Updater;", "v2", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2UpdaterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2Updater;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV3UpdaterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV3Updater;", "v3", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV3UpdaterImpl;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV3Updater;"})
public interface ServerShipDataModule {
    @dp_1
    public ServerShipDataConverter converter(ServerShipDataConverterImpl var1);

    @dp_1
    public ServerShipDataV0Updater v0(ServerShipDataV0UpdaterImpl var1);

    @dp_1
    public ServerShipDataV1Updater v1(ServerShipDataV1UpdaterImpl var1);

    @dp_1
    public ServerShipDataV2Updater v2(ServerShipDataV2UpdaterImpl var1);

    @dp_1
    public ServerShipDataV3Updater v3(ServerShipDataV3UpdaterImpl var1);
}

