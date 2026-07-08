/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.api.ShipInternal;
import org.valkyrienskies.core.impl.shadow.GF;
import org.valkyrienskies.core.impl.shadow.gx_0;
import org.valkyrienskies.core.util.AABBdUtilKt;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001BU\u0012\n\u00103\u001a\u000601j\u0002`2\u0012\b\u0010H\u001a\u0004\u0018\u00010)\u0012\u0006\u0010%\u001a\u00020$\u0012\n\u0010+\u001a\u00060)j\u0002`*\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010L\u001a\u00020K\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\bP\u0010QJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tJG\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020$8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R&\u0010+\u001a\u00060)j\u0002`*8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00103\u001a\u000601j\u0002`28\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R*\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00198\u0017@WX\u0097\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010\u001cR$\u0010=\u001a\u00020;2\u0006\u0010<\u001a\u00020;8\u0007@BX\u0087\u000e\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010)8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010,\u001a\u0004\bI\u0010.\"\u0004\bJ\u00100R$\u0010L\u001a\u00020K2\u0006\u0010<\u001a\u00020K8\u0007@BX\u0087\u000e\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "Lorg/valkyrienskies/core/impl/api/ShipInternal;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "posX", "posY", "posZ", "newBlockIsAir", "", "oldBlockMass", "newBlockMass", "isRunningOnServer", "", "onSetBlock", "(IIIZDDZ)V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "setFromTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "kinematics", "unsafeSetKinematics", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;)V", "updatePrevTickShipTransform", "()V", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "activeChunksSet", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getActiveChunksSet", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "chunkClaimDimension", "Ljava/lang/String;", "getChunkClaimDimension", "()Ljava/lang/String;", "setChunkClaimDimension", "(Ljava/lang/String;)V", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "J", "getId", "()J", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "getKinematics", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "setKinematics", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "p0", "prevTickTransform", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPrevTickTransform", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/joml/primitives/AABBic;", "shipAABB", "Lorg/joml/primitives/AABBic;", "getShipAABB", "()Lorg/joml/primitives/AABBic;", "setShipAABB", "(Lorg/joml/primitives/AABBic;)V", "slug", "getSlug", "setSlug", "Lorg/joml/primitives/AABBdc;", "worldAABB", "Lorg/joml/primitives/AABBdc;", "getWorldAABB", "()Lorg/joml/primitives/AABBdc;", "<init>", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;)V"})
public class ShipDataCommon
implements ShipInternal {
    private final long id;
    private String slug;
    private final ChunkClaim chunkClaim;
    private String chunkClaimDimension;
    private AABBic shipAABB;
    private final IShipActiveChunksSet activeChunksSet;
    @gx_0
    private BodyKinematics kinematics;
    @GF
    private ShipTransform prevTickTransform;
    @gx_0
    private AABBdc worldAABB;

    /*
     * WARNING - void declaration
     */
    public ShipDataCommon(long id, String slug, ChunkClaim chunkClaim, String chunkClaimDimension, BodyKinematics kinematics, AABBdc worldAABB, AABBic shipAABB, IShipActiveChunksSet activeChunksSet) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaimDimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)kinematics, (String)"");
        Intrinsics.checkNotNullParameter((Object)worldAABB, (String)"");
        Intrinsics.checkNotNullParameter((Object)activeChunksSet, (String)"");
        this.id = var1_1;
        this.slug = var3_2;
        this.chunkClaim = chunkClaim;
        this.chunkClaimDimension = chunkClaimDimension;
        this.shipAABB = shipAABB;
        this.activeChunksSet = activeChunksSet;
        this.kinematics = kinematics;
        BodyTransform bodyTransform = kinematics.getTransform();
        Intrinsics.checkNotNull((Object)bodyTransform);
        this.prevTickTransform = (ShipTransform)bodyTransform;
        this.worldAABB = worldAABB;
    }

    public /* synthetic */ ShipDataCommon(long l2, String string, ChunkClaim chunkClaim, String string2, BodyKinematics bodyKinematics, AABBdc aABBdc, AABBic aABBic, IShipActiveChunksSet iShipActiveChunksSet, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x20) != 0) {
            BodyTransform bodyTransform = bodyKinematics.getTransform();
            Intrinsics.checkNotNull((Object)bodyTransform);
            aABBdc = ((ShipTransform)bodyTransform).createEmptyAABB();
        }
        this(l2, string, chunkClaim, string2, bodyKinematics, aABBdc, aABBic, iShipActiveChunksSet);
    }

    @Override
    @JvmName(name="getId")
    public long getId() {
        return this.id;
    }

    @Override
    @JvmName(name="getSlug")
    public String getSlug() {
        return this.slug;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setSlug")
    public void setSlug(String string) {
        void var1_1;
        this.slug = var1_1;
    }

    @Override
    @JvmName(name="getChunkClaim")
    public ChunkClaim getChunkClaim() {
        return this.chunkClaim;
    }

    @Override
    @JvmName(name="getChunkClaimDimension")
    public String getChunkClaimDimension() {
        return this.chunkClaimDimension;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setChunkClaimDimension")
    public void setChunkClaimDimension(String string) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.chunkClaimDimension = var1_1;
    }

    @Override
    @JvmName(name="getShipAABB")
    public AABBic getShipAABB() {
        return this.shipAABB;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setShipAABB")
    public void setShipAABB(AABBic aABBic) {
        void var1_1;
        this.shipAABB = var1_1;
    }

    @Override
    @JvmName(name="getActiveChunksSet")
    public IShipActiveChunksSet getActiveChunksSet() {
        return this.activeChunksSet;
    }

    @Override
    @JvmName(name="getKinematics")
    public BodyKinematics getKinematics() {
        return this.kinematics;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setKinematics")
    public void setKinematics(BodyKinematics kinematics) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)kinematics, (String)"");
        this.kinematics = kinematics;
        Object object = this.getShipAABB();
        AABBd aABBd = object != null && (object = AABBdUtilKt.toAABBd((AABBic)object, new AABBd())) != null ? ((AABBd)object).transform(kinematics.getToWorld(), new AABBd()) : null;
        this.worldAABB = aABBd == null ? (AABBdc)new AABBd(kinematics.getPosition(), var1_1.getPosition()) : (AABBdc)aABBd;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void setFromTransform(BodyTransform transform2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        ShipDataCommon shipDataCommon = this;
        shipDataCommon.setKinematics(shipDataCommon.getKinematics().withTransform((BodyTransform)var1_1));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void unsafeSetKinematics(BodyKinematics kinematics) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)kinematics, (String)"");
        this.setKinematics((BodyKinematics)var1_1);
    }

    @Override
    @JvmName(name="getPrevTickTransform")
    public final ShipTransform getPrevTickTransform() {
        return this.prevTickTransform;
    }

    @Override
    @JvmName(name="getWorldAABB")
    public final AABBdc getWorldAABB() {
        return this.worldAABB;
    }

    public final void updatePrevTickShipTransform() {
        this.prevTickTransform = this.getTransform();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onSetBlock(int posX2, int posY, int posZ, boolean newBlockIsAir, double oldBlockMass, double newBlockMass, boolean isRunningOnServer) {
        if (!this.getChunkClaim().contains(posX2 >> 4, posZ >> 4)) {
            void var2_3;
            String posX2 = "Block at <" + posX2 + ", " + (int)var2_3 + ", " + posZ + "> is not in the chunk claim belonging to " + this;
            throw new IllegalArgumentException(posX2.toString());
        }
        if (!newBlockIsAir) {
            void var3_4;
            void var1_1;
            int posX2;
            this.getActiveChunksSet().add(posX2 >> 4, posZ >> 4);
            this.getActiveChunksSet().add((posX2 >> 4) - 1, posZ >> 4);
            this.getActiveChunksSet().add((posX2 >> 4) + 1, posZ >> 4);
            this.getActiveChunksSet().add(posX2 >> 4, (posZ >> 4) - 1);
            this.getActiveChunksSet().add((int)(var1_1 >> 4), (int)((var3_4 >> 4) + true));
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean equals(Object other) {
        void var1_1;
        if (this == other) {
            return true;
        }
        Object object = other;
        if (!Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull((Object)other);
        ShipDataCommon cfr_ignored_0 = (ShipDataCommon)other;
        return this.getId() == ((ShipDataCommon)var1_1).getId();
    }

    public int hashCode() {
        return Long.hashCode(this.getId());
    }
}

