/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Eo$a
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4dc;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.api.LoadedShipInternal;
import org.valkyrienskies.core.impl.api.ShipInternal;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.shadow.Eo;
import org.valkyrienskies.core.impl.shadow.eo_2;
import org.valkyrienskies.core.impl.shadow.fq_0;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Eo
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020?\u00a2\u0006\u0004\bX\u0010YJH\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0010H\u0096\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0013H\u0096\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R \u0010(\u001a\u00060\"j\u0002`#8\u0017@\u0017X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010-\u001a\u00060)j\u0002`*8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u00138\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u001a8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b1\u0010\u001cR\u0014\u00106\u001a\u0002038WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u0002038\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b7\u00105R\u0016\u0010<\u001a\u0004\u0018\u0001098\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020\u00168WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b=\u0010\u0018R \u0010C\u001a\u00020?8\u0017X\u0096\u0004\u00a2\u0006\u0012\n\u0004\b!\u0010@\u0012\u0004\b!\u0010B\u001a\u0004\b\u0019\u0010AR\u0014\u0010G\u001a\u00020D8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u0002038WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bH\u00105R\u0016\u0010K\u001a\u0004\u0018\u0001098WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bJ\u0010;R\u0016\u0010M\u001a\u0004\u0018\u00010\"8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bL\u0010%R\u0014\u0010O\u001a\u0002038WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bN\u00105R\u0014\u0010Q\u001a\u00020\u001a8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bP\u0010\u001cR\u0014\u0010U\u001a\u00020R8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020D8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bV\u0010F"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Eo;", "Lorg/valkyrienskies/core/impl/api/LoadedShipInternal;", "Lorg/valkyrienskies/core/impl/api/ShipInternal;", "", "p0", "p1", "p2", "", "p3", "", "p4", "p5", "p6", "", "onSetBlock", "(IIIZDDZ)V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "setFromTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "unsafeSetKinematics", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;)V", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getActiveChunksSet", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "a", "Lorg/joml/Vector3dc;", "getAngularVelocity", "()Lorg/joml/Vector3dc;", "b", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "c", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getChunkClaimDimension", "()Ljava/lang/String;", "setChunkClaimDimension", "(Ljava/lang/String;)V", "d", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getId", "()J", "e", "getKinematics", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "f", "getOmega", "g", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPrevTickShipTransform", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "h", "getPrevTickTransform", "i", "Lorg/joml/primitives/AABBic;", "getShipAABB", "()Lorg/joml/primitives/AABBic;", "j", "getShipActiveChunksSet", "k", "Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "()Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "()V", "l", "Lorg/joml/Matrix4dc;", "getShipToWorld", "()Lorg/joml/Matrix4dc;", "m", "getShipTransform", "n", "getShipVoxelAABB", "o", "getSlug", "p", "getTransform", "q", "getVelocity", "r", "Lorg/joml/primitives/AABBdc;", "getWorldAABB", "()Lorg/joml/primitives/AABBdc;", "s", "getWorldToShip", "t", "<init>", "(Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;)V"})
public class eo_0
implements LoadedShipInternal,
ShipInternal {
    public static final eo_2.a_0 a = new Eo.a(null);
    private final /* synthetic */ ShipDataCommon b;
    private final ShipDataCommon c;
    private static final fq_0 d = new fq_0(VSJacksonUtil.INSTANCE.getDeltaMapper());

    public eo_0(ShipDataCommon shipDataCommon) {
        Intrinsics.checkNotNullParameter((Object)shipDataCommon, (String)"");
        this.b = shipDataCommon;
        this.c = shipDataCommon;
    }

    @Override
    @JvmName(name="getActiveChunksSet")
    public IShipActiveChunksSet getActiveChunksSet() {
        return this.b.getActiveChunksSet();
    }

    @Override
    @JvmName(name="getAngularVelocity")
    public Vector3dc getAngularVelocity() {
        return this.b.getAngularVelocity();
    }

    @Override
    @JvmName(name="getChunkClaim")
    public ChunkClaim getChunkClaim() {
        return this.b.getChunkClaim();
    }

    @Override
    @JvmName(name="getChunkClaimDimension")
    public String getChunkClaimDimension() {
        return this.b.getChunkClaimDimension();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setChunkClaimDimension")
    public void setChunkClaimDimension(String string) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.b.setChunkClaimDimension((String)var1_1);
    }

    @Override
    @JvmName(name="getId")
    public long getId() {
        return this.b.getId();
    }

    @Override
    @JvmName(name="getKinematics")
    public BodyKinematics getKinematics() {
        return this.b.getKinematics();
    }

    @Override
    @JvmName(name="getOmega")
    public Vector3dc getOmega() {
        return this.b.getOmega();
    }

    @Override
    @JvmName(name="getPrevTickShipTransform")
    public ShipTransform getPrevTickShipTransform() {
        return this.b.getPrevTickShipTransform();
    }

    @Override
    @JvmName(name="getPrevTickTransform")
    public ShipTransform getPrevTickTransform() {
        return this.b.getPrevTickTransform();
    }

    @Override
    @JvmName(name="getShipAABB")
    public AABBic getShipAABB() {
        return this.b.getShipAABB();
    }

    @Override
    @JvmName(name="getShipActiveChunksSet")
    public IShipActiveChunksSet getShipActiveChunksSet() {
        return this.b.getShipActiveChunksSet();
    }

    @Override
    @JvmName(name="getShipToWorld")
    public Matrix4dc getShipToWorld() {
        return this.b.getShipToWorld();
    }

    @Override
    @JvmName(name="getShipTransform")
    public ShipTransform getShipTransform() {
        return this.b.getShipTransform();
    }

    @Override
    @JvmName(name="getShipVoxelAABB")
    public AABBic getShipVoxelAABB() {
        return this.b.getShipVoxelAABB();
    }

    @Override
    @JvmName(name="getSlug")
    public String getSlug() {
        return this.b.getSlug();
    }

    @Override
    @JvmName(name="getTransform")
    public ShipTransform getTransform() {
        return this.b.getTransform();
    }

    @Override
    @JvmName(name="getVelocity")
    public Vector3dc getVelocity() {
        return this.b.getVelocity();
    }

    @Override
    @JvmName(name="getWorldAABB")
    public AABBdc getWorldAABB() {
        return this.b.getWorldAABB();
    }

    @Override
    @JvmName(name="getWorldToShip")
    public Matrix4dc getWorldToShip() {
        return this.b.getWorldToShip();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onSetBlock(int posX, int posY, int posZ, boolean newBlockIsAir, double oldBlockMass, double newBlockMass, boolean isRunningOnServer) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.b.onSetBlock((int)var1_1, (int)var2_2, (int)var3_3, newBlockIsAir, oldBlockMass, newBlockMass, isRunningOnServer);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void setFromTransform(BodyTransform transform2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        this.b.setFromTransform((BodyTransform)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void unsafeSetKinematics(BodyKinematics kinematics) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)kinematics, (String)"");
        this.b.unsafeSetKinematics((BodyKinematics)var1_1);
    }

    @JvmName(name="a")
    public ShipDataCommon a() {
        return this.c;
    }

    private static /* synthetic */ void c() {
    }

    private static fq_0 d() {
        return Eo.a.a();
    }

    public static final /* synthetic */ fq_0 b() {
        return d;
    }
}

