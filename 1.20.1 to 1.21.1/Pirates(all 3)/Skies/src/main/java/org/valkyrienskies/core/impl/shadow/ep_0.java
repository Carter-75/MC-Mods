/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Eo
 *  org.valkyrienskies.core.impl.shadow.Eo$a
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4dc;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.ClientShipTransformProvider;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.api.ClientShipInternal;
import org.valkyrienskies.core.impl.api.ShipInternal;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.shadow.Eo;
import org.valkyrienskies.core.impl.shadow.eg_0;
import org.valkyrienskies.core.impl.shadow.fo_0;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;
import org.valkyrienskies.core.util.AABBdUtilKt;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ep
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 r2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001rB\u0019\u0012\u0006\u0010\u0005\u001a\u00020o\u0012\b\b\u0002\u0010\u0006\u001a\u00020R\u00a2\u0006\u0004\bp\u0010qJH\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0096\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0011H\u0096\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0016H\u0096\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\n\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0019\u001a\u00020\u001b8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001e8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R \u0010,\u001a\u00060&j\u0002`'8\u0017@\u0017X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010\u0014\u001a\u00060-j\u0002`.8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u00168\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\"\u00107\u001a\u00020\u00048\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b%\u00105\"\u0004\b\u0019\u00106R\"\u00109\u001a\u00020\u00168\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u00108\u001a\u0004\b7\u00102\"\u0004\b!\u0010\u0018R\"\u0010:\u001a\u00020\u00168\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u00108\u001a\u0004\b3\u00102\"\u0004\b\u0019\u0010\u0018R\u0014\u0010<\u001a\u00020\u001e8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b;\u0010 R\u0014\u0010@\u001a\u00020=8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020=8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bA\u0010?R$\u0010G\u001a\u00020C2\u0006\u0010\u0005\u001a\u00020C8\u0017@RX\u0096.\u00a2\u0006\f\n\u0004\b,\u0010D\u001a\u0004\bE\u0010FR$\u0010J\u001a\u00020=2\u0006\u0010\u0005\u001a\u00020=8\u0017@RX\u0096.\u00a2\u0006\f\n\u0004\b%\u0010H\u001a\u0004\bI\u0010?R\u0016\u0010N\u001a\u0004\u0018\u00010K8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020\u001b8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bO\u0010\u001dR\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020R0Q8\u0007\u00a2\u0006\f\n\u0004\b7\u0010S\u001a\u0004\b,\u0010TR\u0014\u0010Y\u001a\u00020V8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010[\u001a\u00020=8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bZ\u0010?R\u0016\u0010]\u001a\u0004\u0018\u00010K8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\\\u0010MR\u0016\u0010_\u001a\u0004\u0018\u00010&8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b^\u0010)R\u0014\u0010a\u001a\u00020=8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b`\u0010?R$\u0010h\u001a\u0004\u0018\u00010b8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020\u001e8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bi\u0010 R\u0014\u0010l\u001a\u00020C8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bk\u0010FR\u0014\u0010n\u001a\u00020V8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bm\u0010X"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ep;", "Lorg/valkyrienskies/core/impl/shadow/Eo;", "Lorg/valkyrienskies/core/impl/api/ClientShipInternal;", "Lorg/valkyrienskies/core/impl/api/ShipInternal;", "", "p0", "p1", "p2", "", "p3", "", "p4", "p5", "p6", "", "onSetBlock", "(IIIZDDZ)V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "setFromTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V", "e", "()V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "unsafeSetKinematics", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;)V", "a", "(D)V", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getActiveChunksSet", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "Lorg/joml/Vector3dc;", "getAngularVelocity", "()Lorg/joml/Vector3dc;", "b", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "c", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getChunkClaimDimension", "()Ljava/lang/String;", "setChunkClaimDimension", "(Ljava/lang/String;)V", "d", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getId", "()J", "getKinematics", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "f", "I", "()I", "(I)V", "g", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "h", "i", "getOmega", "j", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPrevTickShipTransform", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "k", "getPrevTickTransform", "l", "Lorg/joml/primitives/AABBdc;", "Lorg/joml/primitives/AABBdc;", "getRenderAABB", "()Lorg/joml/primitives/AABBdc;", "m", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getRenderTransform", "n", "Lorg/joml/primitives/AABBic;", "getShipAABB", "()Lorg/joml/primitives/AABBic;", "o", "getShipActiveChunksSet", "p", "Lorg/valkyrienskies/core/impl/shadow/Fo;", "Lcom/fasterxml/jackson/databind/JsonNode;", "Lorg/valkyrienskies/core/impl/shadow/Fo;", "()Lorg/valkyrienskies/core/impl/shadow/Fo;", "q", "Lorg/joml/Matrix4dc;", "getShipToWorld", "()Lorg/joml/Matrix4dc;", "r", "getShipTransform", "s", "getShipVoxelAABB", "t", "getSlug", "u", "getTransform", "v", "Lorg/valkyrienskies/core/api/ships/ClientShipTransformProvider;", "Lorg/valkyrienskies/core/api/ships/ClientShipTransformProvider;", "getTransformProvider", "()Lorg/valkyrienskies/core/api/ships/ClientShipTransformProvider;", "setTransformProvider", "(Lorg/valkyrienskies/core/api/ships/ClientShipTransformProvider;)V", "w", "getVelocity", "x", "getWorldAABB", "y", "getWorldToShip", "z", "Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "<init>", "(Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;Lcom/fasterxml/jackson/databind/JsonNode;)V", "a_"})
public final class ep_0
extends Eo
implements ClientShipInternal,
ShipInternal {
    public static final a_ a_ = new a_(null);
    private final /* synthetic */ ShipDataCommon h;
    public BodyKinematics b;
    public ShipTransform c;
    public AABBdc d;
    private ClientShipTransformProvider i;
    public BodyKinematics e;
    public int f;
    public final fo_0<JsonNode> g;
    private static double j = 0.7;

    private ep_0(ShipDataCommon shipDataCommon, JsonNode jsonNode) {
        Intrinsics.checkNotNullParameter((Object)shipDataCommon, (String)"");
        Intrinsics.checkNotNullParameter((Object)jsonNode, (String)"");
        super(shipDataCommon);
        this.h = shipDataCommon;
        this.e = shipDataCommon.getKinematics();
        this.f = Integer.MIN_VALUE;
        this.g = new fo_0<JsonNode>(Eo.a.a(), jsonNode);
        this.b = shipDataCommon.getKinematics();
        this.c = shipDataCommon.getTransform();
        this.d = shipDataCommon.getTransform().createEmptyAABB();
    }

    public /* synthetic */ ep_0(ShipDataCommon shipDataCommon, JsonNode jsonNode, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            Object t = VSJacksonUtil.INSTANCE.getDefaultMapper().valueToTree(shipDataCommon);
            Intrinsics.checkNotNullExpressionValue(t, (String)"");
            jsonNode = t;
        }
        this(shipDataCommon, jsonNode);
    }

    @Override
    @JvmName(name="getActiveChunksSet")
    public final IShipActiveChunksSet getActiveChunksSet() {
        return this.h.getActiveChunksSet();
    }

    @Override
    @JvmName(name="getAngularVelocity")
    public final Vector3dc getAngularVelocity() {
        return this.h.getAngularVelocity();
    }

    @Override
    @JvmName(name="getChunkClaim")
    public final ChunkClaim getChunkClaim() {
        return this.h.getChunkClaim();
    }

    @Override
    @JvmName(name="getChunkClaimDimension")
    public final String getChunkClaimDimension() {
        return this.h.getChunkClaimDimension();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setChunkClaimDimension")
    public final void setChunkClaimDimension(String string) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.h.setChunkClaimDimension((String)var1_1);
    }

    @Override
    @JvmName(name="getId")
    public final long getId() {
        return this.h.getId();
    }

    @Override
    @JvmName(name="getKinematics")
    public final BodyKinematics getKinematics() {
        return this.h.getKinematics();
    }

    @Override
    @JvmName(name="getOmega")
    public final Vector3dc getOmega() {
        return this.h.getOmega();
    }

    @Override
    @JvmName(name="getPrevTickShipTransform")
    public final ShipTransform getPrevTickShipTransform() {
        return this.h.getPrevTickShipTransform();
    }

    @Override
    @JvmName(name="getPrevTickTransform")
    public final ShipTransform getPrevTickTransform() {
        return this.h.getPrevTickTransform();
    }

    @Override
    @JvmName(name="getShipAABB")
    public final AABBic getShipAABB() {
        return this.h.getShipAABB();
    }

    @Override
    @JvmName(name="getShipActiveChunksSet")
    public final IShipActiveChunksSet getShipActiveChunksSet() {
        return this.h.getShipActiveChunksSet();
    }

    @Override
    @JvmName(name="getShipToWorld")
    public final Matrix4dc getShipToWorld() {
        return this.h.getShipToWorld();
    }

    @Override
    @JvmName(name="getShipTransform")
    public final ShipTransform getShipTransform() {
        return this.h.getShipTransform();
    }

    @Override
    @JvmName(name="getShipVoxelAABB")
    public final AABBic getShipVoxelAABB() {
        return this.h.getShipVoxelAABB();
    }

    @Override
    @JvmName(name="getSlug")
    public final String getSlug() {
        return this.h.getSlug();
    }

    @Override
    @JvmName(name="getTransform")
    public final ShipTransform getTransform() {
        return this.h.getTransform();
    }

    @Override
    @JvmName(name="getVelocity")
    public final Vector3dc getVelocity() {
        return this.h.getVelocity();
    }

    @Override
    @JvmName(name="getWorldAABB")
    public final AABBdc getWorldAABB() {
        return this.h.getWorldAABB();
    }

    @Override
    @JvmName(name="getWorldToShip")
    public final Matrix4dc getWorldToShip() {
        return this.h.getWorldToShip();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onSetBlock(int posX, int posY, int posZ, boolean newBlockIsAir, double oldBlockMass, double newBlockMass, boolean isRunningOnServer) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.h.onSetBlock((int)var1_1, (int)var2_2, (int)var3_3, newBlockIsAir, oldBlockMass, newBlockMass, isRunningOnServer);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setFromTransform(BodyTransform transform2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        this.h.setFromTransform((BodyTransform)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void unsafeSetKinematics(BodyKinematics kinematics) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)kinematics, (String)"");
        this.h.unsafeSetKinematics((BodyKinematics)var1_1);
    }

    @JvmName(name="f")
    private BodyKinematics f() {
        return this.b;
    }

    @JvmName(name="a")
    public final void a(BodyKinematics bodyKinematics) {
        Intrinsics.checkNotNullParameter((Object)bodyKinematics, (String)"");
        this.b = bodyKinematics;
    }

    @Override
    @JvmName(name="getRenderTransform")
    public final ShipTransform getRenderTransform() {
        ShipTransform shipTransform = this.c;
        if (shipTransform != null) {
            return shipTransform;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @Override
    @JvmName(name="getRenderAABB")
    public final AABBdc getRenderAABB() {
        AABBdc aABBdc = this.d;
        if (aABBdc != null) {
            return aABBdc;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @Override
    @JvmName(name="getTransformProvider")
    public final ClientShipTransformProvider getTransformProvider() {
        return this.i;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setTransformProvider")
    public final void setTransformProvider(ClientShipTransformProvider clientShipTransformProvider) {
        void var1_1;
        this.i = var1_1;
    }

    @JvmName(name="g")
    private BodyKinematics g() {
        return this.e;
    }

    @JvmName(name="b")
    public final void b(BodyKinematics bodyKinematics) {
        Intrinsics.checkNotNullParameter((Object)bodyKinematics, (String)"");
        this.e = bodyKinematics;
    }

    @JvmName(name="c")
    public final int c() {
        return this.f;
    }

    @JvmName(name="a")
    public final void a(int n2) {
        this.f = n2;
    }

    @JvmName(name="d")
    public final fo_0<JsonNode> d() {
        return this.g;
    }

    public final void e() {
        BodyTransform bodyTransform;
        this.b = this.e;
        ClientShipTransformProvider clientShipTransformProvider = this.getTransformProvider();
        if (clientShipTransformProvider != null) {
            ShipTransform shipTransform = this.getPrevTickTransform();
            ShipTransform shipTransform2 = this.a().getTransform();
            BodyTransform bodyTransform2 = this.b.getTransform();
            Intrinsics.checkNotNull((Object)bodyTransform2);
            bodyTransform = clientShipTransformProvider.provideNextTransform(shipTransform, shipTransform2, (ShipTransform)bodyTransform2);
        } else {
            bodyTransform = null;
        }
        BodyTransform bodyTransform3 = bodyTransform;
        BodyTransform bodyTransform4 = bodyTransform;
        if (bodyTransform == null) {
            ShipTransform shipTransform = this.getPrevTickTransform();
            ShipTransform shipTransform3 = this.a().getTransform();
            BodyTransform bodyTransform5 = this.b.getTransform();
            Intrinsics.checkNotNull((Object)bodyTransform5);
            bodyTransform4 = eg_0.a(shipTransform, shipTransform3, (ShipTransform)bodyTransform5);
        }
        bodyTransform3 = bodyTransform4;
        this.a().updatePrevTickShipTransform();
        this.a().setKinematics(this.e.withTransform(bodyTransform3));
    }

    public final void a(double d2) {
        ClientShipTransformProvider clientShipTransformProvider = this.getTransformProvider();
        BodyTransform bodyTransform = clientShipTransformProvider != null ? clientShipTransformProvider.provideNextRenderTransform(this.a().getPrevTickTransform(), this.a().getTransform(), d2) : null;
        BodyTransform bodyTransform2 = bodyTransform;
        if (bodyTransform2 == null) {
            bodyTransform2 = eg_0.a(this.a().getPrevTickTransform(), this.a().getTransform(), d2);
        }
        Intrinsics.checkNotNull((Object)bodyTransform2);
        this.c = (ShipTransform)bodyTransform2;
        Object object = this.a().getShipAABB();
        AABBd aABBd = object != null && (object = AABBdUtilKt.toAABBd((AABBic)object, new AABBd())) != null ? ((AABBd)object).transform(this.getRenderTransform().getShipToWorld(), new AABBd()) : null;
        this.d = aABBd == null ? this.getRenderTransform().createEmptyAABB() : (AABBdc)aABBd;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ep$a_;", "", "", "j", "D", "a", "<init>", "()V"})
    public static final class a_ {
        private a_() {
        }

        public /* synthetic */ a_(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

