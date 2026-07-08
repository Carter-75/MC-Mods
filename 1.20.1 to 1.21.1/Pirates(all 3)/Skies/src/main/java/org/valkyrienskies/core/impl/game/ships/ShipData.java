/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.properties.ObservableProperty
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.game.ships;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.ServerShipTransformProvider;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;
import org.valkyrienskies.core.impl.chunk_tracking.ShipActiveChunksSet;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.game.ships.ShipInertiaDataImpl;
import org.valkyrienskies.core.impl.shadow.CA;
import org.valkyrienskies.core.impl.shadow.GF;
import org.valkyrienskies.core.impl.shadow.cy_0;
import org.valkyrienskies.core.impl.shadow.dt_0;
import org.valkyrienskies.core.impl.shadow.dv_0;
import org.valkyrienskies.core.impl.shadow.eh_0;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001`B\u0083\u0001\u0012\n\u0010P\u001a\u00060Nj\u0002`O\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\u0006\u0010T\u001a\u00020S\u0012\n\u0010V\u001a\u00060Qj\u0002`U\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010Z\u001a\u00020Y\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u0012\u0006\u0010]\u001a\u000207\u0012\b\b\u0002\u0010-\u001a\u00020\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000100\u0012\u0006\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010>\u001a\u00020\b\u00a2\u0006\u0004\b^\u0010_J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0001H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\f\u0010\rJG\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0018\u0010\rJ\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020 8\u0007\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020%8\u0017X\u0097\u0004\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R+\u0010-\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00038W@WX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010/R/\u00106\u001a\u0004\u0018\u0001002\b\u0010*\u001a\u0004\u0018\u0001008W@WX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00108\u001a\u0002078\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0005\"\u0004\b=\u0010/R\"\u0010>\u001a\u00020\b8\u0001@\u0001X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR$\u0010H\u001a\u0004\u0018\u00010G8\u0017@\u0017X\u0097\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "Lorg/valkyrienskies/core/impl/api/ServerShipInternal;", "", "areVoxelsFullyLoaded", "()Z", "asShipDataCommon", "()Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "", "chunkX", "chunkZ", "", "onLoadChunk", "(II)V", "posX", "posY", "posZ", "newBlockIsAir", "", "oldBlockMass", "newBlockMass", "isRunningOnServer", "onSetBlock", "(IIIZDDZ)V", "onUnloadChunk", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "unsafeSetTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V", "set", "updateShipAABBGenerator", "(IIIZ)V", "Lorg/valkyrienskies/core/impl/shadow/CA;", "attachmentHolder", "Lorg/valkyrienskies/core/impl/shadow/CA;", "getAttachmentHolder", "()Lorg/valkyrienskies/core/impl/shadow/CA;", "Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;", "inertiaData", "Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;", "getInertiaData", "()Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;", "<set-?>", "isStatic$delegate", "Lkotlin/properties/ReadWriteProperty;", "isStatic", "setStatic", "(Z)V", "Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "kinematicTarget$delegate", "getKinematicTarget", "()Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "setKinematicTarget", "(Lorg/valkyrienskies/core/api/ships/properties/PhysPose;)V", "kinematicTarget", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "missingLoadedChunks", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "needsUpdating", "Z", "getNeedsUpdating", "setNeedsUpdating", "portalCoolDown", "I", "getPortalCoolDown$impl", "()I", "setPortalCoolDown$impl", "(I)V", "Lorg/valkyrienskies/core/impl/shadow/Dv;", "shipAABBGenerator", "Lorg/valkyrienskies/core/impl/shadow/Dv;", "Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;", "transformProvider", "Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;", "getTransformProvider", "()Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;", "setTransformProvider", "(Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;)V", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "", "slug", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "chunkClaimDimension", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "kinematics", "Lorg/joml/primitives/AABBdc;", "shipAABB", "Lorg/joml/primitives/AABBic;", "shipVoxelAABB", "shipActiveChunksSet", "<init>", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;ZLorg/valkyrienskies/core/api/ships/properties/PhysPose;Lorg/valkyrienskies/core/impl/shadow/CA;I)V", "Factory"})
public final class ShipData
extends ShipDataCommon
implements ServerShipInternal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @GF
    private final ShipInertiaDataImpl inertiaData;
    private final CA attachmentHolder;
    private int portalCoolDown;
    private final ReadWriteProperty isStatic$delegate;
    private final ReadWriteProperty kinematicTarget$delegate;
    @JsonIgnore
    private final IShipActiveChunksSet missingLoadedChunks;
    @JsonIgnore
    private final dv_0 shipAABBGenerator;
    @JsonIgnore
    private ServerShipTransformProvider transformProvider;
    @JsonIgnore
    private boolean needsUpdating;

    /*
     * WARNING - void declaration
     */
    public ShipData(long id, String slug, ChunkClaim chunkClaim, String chunkClaimDimension, ShipInertiaDataImpl inertiaData, BodyKinematics kinematics, AABBdc shipAABB, AABBic shipVoxelAABB, IShipActiveChunksSet shipActiveChunksSet, boolean isStatic, PhysPose kinematicTarget, CA attachmentHolder, int portalCoolDown) {
        void var3_3;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaimDimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)inertiaData, (String)"");
        Intrinsics.checkNotNullParameter((Object)kinematics, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipAABB, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipActiveChunksSet, (String)"");
        Intrinsics.checkNotNullParameter((Object)attachmentHolder, (String)"");
        super((long)var1_1, (String)var3_3, chunkClaim, chunkClaimDimension, kinematics, shipAABB, shipVoxelAABB, shipActiveChunksSet);
        this.inertiaData = inertiaData;
        this.attachmentHolder = attachmentHolder;
        this.portalCoolDown = portalCoolDown;
        Boolean bl = isStatic;
        this.isStatic$delegate = (ReadWriteProperty)new ObservableProperty<Boolean>((Object)bl, this){
            final /* synthetic */ ShipData this$0;
            {
                void var1_1;
                this.this$0 = shipData;
                super((Object)var1_1);
            }

            /*
             * Ignored method signature, as it can't be verified against descriptor
             * WARNING - void declaration
             */
            public final void afterChange(KProperty property, Object oldValue, Object newValue) {
                void var2_3;
                void var3_5;
                Intrinsics.checkNotNullParameter((Object)property, (String)"");
                boolean bl = (Boolean)var3_5;
                boolean bl2 = (Boolean)var2_3;
                if (bl != bl2) {
                    this.this$0.setNeedsUpdating(true);
                }
            }
        };
        this.kinematicTarget$delegate = (ReadWriteProperty)new ObservableProperty<PhysPose>((Object)kinematicTarget, this){
            final /* synthetic */ ShipData this$0;
            {
                void var1_1;
                this.this$0 = shipData;
                super((Object)var1_1);
            }

            /*
             * Ignored method signature, as it can't be verified against descriptor
             * WARNING - void declaration
             */
            public final void afterChange(KProperty property, Object oldValue, Object newValue) {
                PhysPose physPose;
                void var3_3;
                Intrinsics.checkNotNullParameter((Object)property, (String)"");
                PhysPose physPose2 = (PhysPose)var3_3;
                physPose = physPose;
                if (!Intrinsics.areEqual((Object)physPose2, (Object)physPose)) {
                    this.this$0.setNeedsUpdating(true);
                }
            }
        };
        this.missingLoadedChunks = ShipActiveChunksSet.Companion.create();
        this.shipAABBGenerator = new dt_0(null, 1, null);
        shipActiveChunksSet.forEach((arg_0, arg_1) -> ShipData._init_$lambda$2(this, arg_0, arg_1));
    }

    public /* synthetic */ ShipData(long l2, String string, ChunkClaim chunkClaim, String string2, ShipInertiaDataImpl shipInertiaDataImpl, BodyKinematics bodyKinematics, AABBdc aABBdc, AABBic aABBic, IShipActiveChunksSet iShipActiveChunksSet, boolean bl, PhysPose physPose, CA cA, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 0x200) != 0) {
            bl = false;
        }
        if ((n3 & 0x400) != 0) {
            physPose = null;
        }
        if ((n3 & 0x1000) != 0) {
            n2 = 0;
        }
        this(l2, string, chunkClaim, string2, shipInertiaDataImpl, bodyKinematics, aABBdc, aABBic, iShipActiveChunksSet, bl, physPose, cA, n2);
    }

    @Override
    @JvmName(name="getInertiaData")
    public final ShipInertiaDataImpl getInertiaData() {
        return this.inertiaData;
    }

    @JvmName(name="getAttachmentHolder")
    public final CA getAttachmentHolder() {
        return this.attachmentHolder;
    }

    @JvmName(name="getPortalCoolDown$impl")
    public final int getPortalCoolDown$impl() {
        return this.portalCoolDown;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setPortalCoolDown$impl")
    public final void setPortalCoolDown$impl(int n2) {
        void var1_1;
        this.portalCoolDown = var1_1;
    }

    @Override
    @JvmName(name="isStatic")
    public final boolean isStatic() {
        return (Boolean)this.isStatic$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setStatic")
    public final void setStatic(boolean bl) {
        void var1_1;
        this.isStatic$delegate.setValue((Object)this, $$delegatedProperties[0], (Object)((boolean)var1_1));
    }

    @Override
    @JvmName(name="getKinematicTarget")
    public final PhysPose getKinematicTarget() {
        return (PhysPose)this.kinematicTarget$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setKinematicTarget")
    public final void setKinematicTarget(PhysPose physPose) {
        void var1_1;
        this.kinematicTarget$delegate.setValue((Object)this, $$delegatedProperties[1], (Object)var1_1);
    }

    @Override
    @JvmName(name="getTransformProvider")
    public final ServerShipTransformProvider getTransformProvider() {
        return this.transformProvider;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setTransformProvider")
    public final void setTransformProvider(ServerShipTransformProvider serverShipTransformProvider) {
        void var1_1;
        this.transformProvider = var1_1;
    }

    @JvmName(name="getNeedsUpdating")
    public final boolean getNeedsUpdating() {
        return this.needsUpdating;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setNeedsUpdating")
    public final void setNeedsUpdating(boolean bl) {
        void var1_1;
        this.needsUpdating = var1_1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onSetBlock(int posX, int posY, int posZ, boolean newBlockIsAir, double oldBlockMass, double newBlockMass, boolean isRunningOnServer) {
        super.onSetBlock(posX, posY, posZ, newBlockIsAir, oldBlockMass, newBlockMass, isRunningOnServer);
        this.getInertiaData().onSetBlockUseSphereMOI(posX, posY, posZ, oldBlockMass, newBlockMass);
        if (isRunningOnServer) {
            void var3_5;
            void var2_3;
            void var1_1;
            this.updateShipAABBGenerator((int)var1_1, (int)var2_3, (int)var3_5, !newBlockIsAir);
            eh_0 eh_02 = this.attachmentHolder.getAttachment(eh_0.class);
            if (eh_02 != null) {
                AABBic aABBic = this.getShipAABB();
                eh_0 eh_03 = eh_02;
                eh_02.b = aABBic;
            }
        }
        this.needsUpdating = true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateShipAABBGenerator(int posX, int posY, int posZ, boolean set) {
        if (set) {
            this.shipAABBGenerator.add(posX, posY, posZ);
        } else {
            void var3_4;
            void var2_3;
            void var1_1;
            this.shipAABBGenerator.remove((int)var1_1, (int)var2_3, (int)var3_4);
        }
        AABBi aABBi = this.shipAABBGenerator.a();
        if (aABBi != null) {
            ++aABBi.maxX;
            ++aABBi.maxY;
            ++aABBi.maxZ;
        }
        this.setShipAABB(aABBi);
        this.needsUpdating = true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onLoadChunk(int chunkX, int chunkZ) {
        if (this.getChunkClaim().contains(chunkX, chunkZ)) {
            void var2_2;
            void var1_1;
            this.missingLoadedChunks.remove((int)var1_1, (int)var2_2);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onUnloadChunk(int chunkX, int chunkZ) {
        if (this.getChunkClaim().contains(chunkX, chunkZ) && this.getActiveChunksSet().contains(chunkX, chunkZ)) {
            void var2_2;
            void var1_1;
            this.missingLoadedChunks.add((int)var1_1, (int)var2_2);
        }
    }

    @Override
    public final boolean areVoxelsFullyLoaded() {
        return this.missingLoadedChunks.getSize() == 0;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void unsafeSetTransform(BodyTransform transform2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        ShipData shipData = this;
        shipData.setKinematics(shipData.getKinematics().withTransform((BodyTransform)var1_1));
        this.needsUpdating = true;
    }

    @Override
    public final ShipDataCommon asShipDataCommon() {
        return this;
    }

    /*
     * WARNING - void declaration
     */
    private static final void _init_$lambda$2(ShipData this$0, int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        this$0.missingLoadedChunks.add((int)var1_1, (int)var2_2);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[2];
        KProperty[] kPropertyArray2 = kPropertyArray;
        kPropertyArray[0] = Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ShipData.class, "isStatic", "isStatic()Z", 0)));
        kPropertyArray2[1] = Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ShipData.class, "kinematicTarget", "getKinematicTarget()Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", 0)));
        $$delegatedProperties = kPropertyArray2;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019JY\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\n\u0010\n\u001a\u00060\u0002j\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipData$Factory;", "", "", "slug", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "shipId", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "chunkClaimDimension", "Lorg/joml/Vector3dc;", "shipCenterInWorldCoordinates", "shipCenterInShipCoordinates", "", "scaling", "", "isStatic", "Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "createEmpty", "(Ljava/lang/String;JLorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;DZ)Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "Lorg/valkyrienskies/core/impl/shadow/Cy;", "attachmentHolderFactory", "Lorg/valkyrienskies/core/impl/shadow/Cy;", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/Cy;)V"})
    public static final class Factory {
        private final cy_0 attachmentHolderFactory;

        /*
         * WARNING - void declaration
         */
        @Inject
        public Factory(cy_0 attachmentHolderFactory) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)attachmentHolderFactory, (String)"");
            this.attachmentHolderFactory = var1_1;
        }

        /*
         * WARNING - void declaration
         */
        public final ShipData createEmpty(String slug, long shipId, ChunkClaim chunkClaim, String chunkClaimDimension, Vector3dc shipCenterInWorldCoordinates, Vector3dc shipCenterInShipCoordinates, double scaling, boolean isStatic) {
            void var1_1;
            void var2_2;
            Intrinsics.checkNotNullParameter((Object)slug, (String)"");
            Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
            Intrinsics.checkNotNullParameter((Object)chunkClaimDimension, (String)"");
            Intrinsics.checkNotNullParameter((Object)shipCenterInWorldCoordinates, (String)"");
            Intrinsics.checkNotNullParameter((Object)shipCenterInShipCoordinates, (String)"");
            Object object = this.attachmentHolderFactory;
            CA cA = ((cy_0)object).a.get();
            Intrinsics.checkNotNullExpressionValue((Object)cA, (String)"");
            object = cA;
            Vector3dc vector3dc = new Vector3d();
            Vector3dc vector3dc2 = new Vector3d();
            Quaterniond quaterniond = new Quaterniond().fromAxisAngleDeg(0.0, 1.0, 0.0, 0.0);
            Intrinsics.checkNotNullExpressionValue((Object)quaterniond, (String)"");
            BodyKinematics bodyKinematics = BodyKinematicsFactory.INSTANCE.create(vector3dc, vector3dc2, shipCenterInWorldCoordinates, quaterniond, new Vector3d(scaling), shipCenterInShipCoordinates);
            ShipInertiaDataImpl shipInertiaDataImpl = ShipInertiaDataImpl.Companion.newEmptyShipInertiaData();
            BodyKinematics bodyKinematics2 = bodyKinematics;
            BodyTransform bodyTransform = bodyKinematics2.getTransform();
            Intrinsics.checkNotNull((Object)bodyTransform);
            return new ShipData((long)var2_2, (String)var1_1, chunkClaim, chunkClaimDimension, shipInertiaDataImpl, bodyKinematics2, ((ShipTransform)bodyTransform).createEmptyAABB(), null, ShipActiveChunksSet.Companion.create(), isStatic, null, (CA)object, 0, 5120, null);
        }

        public static /* synthetic */ ShipData createEmpty$default(Factory factory, String string, long l2, ChunkClaim chunkClaim, String string2, Vector3dc vector3dc, Vector3dc vector3dc2, double d2, boolean bl, int n2, Object object) {
            if ((n2 & 0x40) != 0) {
                d2 = 1.0;
            }
            if ((n2 & 0x80) != 0) {
                bl = false;
            }
            return factory.createEmpty(string, l2, chunkClaim, string2, vector3dc, vector3dc2, d2, bl);
        }
    }
}

