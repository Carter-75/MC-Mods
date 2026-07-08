/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.ShipInertiaConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.ServerShipDataConverter;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ServerShipDataV4;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.ShipTransformConverter;
import org.valkyrienskies.core.impl.shadow.cy_0;
import org.valkyrienskies.core.impl.shadow.dy_1;

@dy_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverterImpl;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/ServerShipDataConverter;", "Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "model", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV4;", "convertToDto", "(Lorg/valkyrienskies/core/impl/game/ships/ShipData;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV4;", "dto", "convertToModel", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV4;)Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "Lorg/valkyrienskies/core/impl/shadow/Cy;", "attachmentHolderFactory", "Lorg/valkyrienskies/core/impl/shadow/Cy;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/ShipInertiaConverter;", "inertiaConverter", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/ShipInertiaConverter;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverter;", "transformConverter", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverter;", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsFactory;", "transformVelocityFactory", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsFactory;", "<init>", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/ShipInertiaConverter;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/ShipTransformConverter;Lorg/valkyrienskies/core/impl/shadow/Cy;)V"})
public final class ServerShipDataConverterImpl
implements ServerShipDataConverter {
    private final ShipInertiaConverter inertiaConverter;
    private final ShipTransformConverter transformConverter;
    private final cy_0 attachmentHolderFactory;
    private final BodyKinematicsFactory transformVelocityFactory;

    /*
     * WARNING - void declaration
     */
    @Inject
    public ServerShipDataConverterImpl(ShipInertiaConverter inertiaConverter, ShipTransformConverter transformConverter, cy_0 attachmentHolderFactory) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)inertiaConverter, (String)"");
        Intrinsics.checkNotNullParameter((Object)transformConverter, (String)"");
        Intrinsics.checkNotNullParameter((Object)attachmentHolderFactory, (String)"");
        this.inertiaConverter = var1_1;
        this.transformConverter = var2_2;
        this.attachmentHolderFactory = var3_3;
        this.transformVelocityFactory = BodyKinematicsFactory.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ServerShipDataV4 convertToDto(ShipData model) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)model, (String)"");
        long l2 = model.getId();
        String string = model.getSlug();
        if (string == null) {
            string = "";
        }
        return new ServerShipDataV4(l2, string, model.getChunkClaim(), model.getChunkClaimDimension(), model.getKinematics().getVelocity(), model.getKinematics().getAngularVelocity(), this.inertiaConverter.convertToDto(model.getInertiaData()), this.transformConverter.convertToDto(model.getTransform()), this.transformConverter.convertToDto(model.getPrevTickTransform()), model.getWorldAABB(), model.getShipAABB(), model.getActiveChunksSet(), model.isStatic(), model.getAttachmentHolder().a(), var1_1.getPortalCoolDown$impl());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ShipData convertToModel(ServerShipDataV4 dto) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dto, (String)"");
        return new ShipData(dto.getId(), Intrinsics.areEqual((Object)dto.getName(), (Object)"") ? null : dto.getName(), dto.getChunkClaim(), dto.getChunkClaimDimension(), this.inertiaConverter.convertToModel(dto.getInertiaData()), this.transformVelocityFactory.create(dto.getVelocity(), dto.getOmega(), this.transformConverter.convertToModel(dto.getTransform())), dto.getWorldAABB(), dto.getShipAABB(), dto.getActiveChunks(), dto.isStatic(), null, this.attachmentHolderFactory.a(dto.getPersistentAttachedData()), var1_1.getPortalCoolDown(), 1024, null);
    }
}

