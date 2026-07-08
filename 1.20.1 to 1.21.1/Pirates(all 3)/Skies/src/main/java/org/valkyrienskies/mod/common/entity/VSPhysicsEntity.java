/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1937
 *  net.minecraft.class_2379
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2596
 *  net.minecraft.class_2602
 *  net.minecraft.class_2604
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5569
 */
package org.valkyrienskies.mod.common.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1937;
import net.minecraft.class_2379;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2604;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5569;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3d;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.physics.PhysicsEntityData;
import org.valkyrienskies.core.internal.physics.PhysicsEntityServer;
import org.valkyrienskies.core.internal.physics.VSSphereCollisionShapeData;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.internal.world.VsiShipWorld;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.api.VsApi;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixin.accessors.entity.EntityAccessor;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 N2\u00020\u0001:\u0001NB\u001d\u0012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00000H\u0012\u0006\u0010K\u001a\u00020J\u00a2\u0006\u0004\bL\u0010MJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJG\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0014\u00a2\u0006\u0004\b\u001c\u0010\bJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016\u00a2\u0006\u0004\b%\u0010$J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016\u00a2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016\u00a2\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0002\u00a2\u0006\u0004\b,\u0010$J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016\u00a2\u0006\u0004\b-\u0010$J\u0017\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0016\u00a2\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b2\u00103J7\u00104\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016\u00a2\u0006\u0004\b8\u00109R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010:\u001a\u0004\u0018\u00010\u00028\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010;\u001a\u0004\b<\u0010=R(\u0010?\u001a\u0004\u0018\u00010>2\b\u0010:\u001a\u0004\u0018\u00010>8\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006O"}, d2={"Lorg/valkyrienskies/mod/common/entity/VSPhysicsEntity;", "Lnet/minecraft/class_1308;", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "physicsEntityData", "", "setPhysicsEntityData", "(Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;)V", "tick", "()V", "", "d", "e", "f", "", "g", "h", "", "i", "", "bl", "lerpTo", "(DDDFFIZ)V", "tickLerp", "Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "shipObjectClientWorld", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getRenderTransform", "(Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "defineSynchedData", "Lnet/minecraft/class_243;", "movementInput", "travel", "(Lnet/minecraft/class_243;)V", "Lnet/minecraft/class_2487;", "compoundTag", "readAdditionalSaveData", "(Lnet/minecraft/class_2487;)V", "addAdditionalSaveData", "Lnet/minecraft/class_2596;", "Lnet/minecraft/class_2602;", "getAddEntityPacket", "()Lnet/minecraft/class_2596;", "saveWithoutId", "(Lnet/minecraft/class_2487;)Lnet/minecraft/class_2487;", "loadForTeleport", "load", "Lnet/minecraft/class_5569;", "callback", "setLevelCallback", "(Lnet/minecraft/class_5569;)V", "shouldRenderAtSqrDistance", "(D)Z", "moveTo", "(DDDFF)V", "Lnet/minecraft/class_1297;", "entity", "restoreFrom", "(Lnet/minecraft/class_1297;)V", "value", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "getPhysicsEntityData", "()Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "physicsEntityServer", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "getPhysicsEntityServer", "()Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "Lorg/joml/Vector3dc;", "lerpPos", "Lorg/joml/Vector3dc;", "lerpSteps", "I", "Lnet/minecraft/class_1299;", "type", "Lnet/minecraft/class_1937;", "level", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "Companion", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVSPhysicsEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSPhysicsEntity.kt\norg/valkyrienskies/mod/common/entity/VSPhysicsEntity\n+ 2 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,265:1\n53#2:266\n43#2:267\n53#2:268\n43#2:269\n*S KotlinDebug\n*F\n+ 1 VSPhysicsEntity.kt\norg/valkyrienskies/mod/common/entity/VSPhysicsEntity\n*L\n149#1:266\n149#1:267\n162#1:268\n162#1:269\n*E\n"})
public class VSPhysicsEntity
extends class_1308 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private PhysicsEntityData physicsEntityData;
    @Nullable
    private PhysicsEntityServer physicsEntityServer;
    @Nullable
    private Vector3dc lerpPos;
    private int lerpSteps;
    @NotNull
    private static final String PHYS_DATA_NBT_KEY = "phys_entity_data";
    private static final int CLIENT_INTERP_STEPS = 3;
    @NotNull
    private static final class_2940<String> SHIP_ID_DATA;

    public VSPhysicsEntity(@NotNull class_1299<VSPhysicsEntity> type, @NotNull class_1937 level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
    }

    @Nullable
    protected final PhysicsEntityData getPhysicsEntityData() {
        return this.physicsEntityData;
    }

    @Nullable
    protected final PhysicsEntityServer getPhysicsEntityServer() {
        return this.physicsEntityServer;
    }

    public final void setPhysicsEntityData(@NotNull PhysicsEntityData physicsEntityData) {
        Intrinsics.checkNotNullParameter((Object)physicsEntityData, (String)"physicsEntityData");
        if (this.physicsEntityData != null) {
            throw new IllegalStateException("Cannot define physicsEntityData, its already defined!");
        }
        this.physicsEntityData = physicsEntityData;
        if (!this.method_37908().field_9236) {
            class_2379 defaultRot = new class_2379(0.0f, 0.0f, 0.0f);
            if (!this.method_37908().field_9236) {
                Vector3d eulerAngles = physicsEntityData.getTransform().getShipToWorldRotation().getEulerAnglesXYZ(new Vector3d());
                defaultRot = new class_2379((float)eulerAngles.x, (float)eulerAngles.y, (float)eulerAngles.z);
            }
            this.field_6011.method_12778(SHIP_ID_DATA, (Object)String.valueOf(physicsEntityData.getShipId()));
        }
    }

    public void method_5773() {
        if (this.lerpPos == null) {
            class_243 class_2432 = this.method_19538();
            Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"position(...)");
            this.lerpPos = VectorConversionsMCKt.toJOML(class_2432);
        }
        if (!this.method_37908().field_9236) {
            PhysicsEntityServer physicsEntityServerCopy = this.physicsEntityServer;
            if (physicsEntityServerCopy != null) {
                ShipTransform transform2 = physicsEntityServerCopy.getShipTransform();
                this.method_33574(VectorConversionsMCKt.toMinecraft(transform2.getPositionInWorld()));
                Vector3d eulerAngles = transform2.getShipToWorldRotation().getEulerAnglesXYZ(new Vector3d());
                PhysicsEntityData physicsEntityData = this.physicsEntityData;
                Intrinsics.checkNotNull((Object)physicsEntityData);
                physicsEntityData.setTransform(transform2);
            }
            this.method_36974();
        } else {
            this.tickLerp();
        }
        super.method_5773();
    }

    public void method_5759(double d2, double e2, double f2, float g2, float h2, int i2, boolean bl) {
        this.lerpPos = new Vector3d(d2, e2, f2);
        this.lerpSteps = 3;
    }

    private final void tickLerp() {
        if (this.lerpSteps <= 0) {
            return;
        }
        if (this.lerpSteps == 1) {
            Vector3dc vector3dc = this.lerpPos;
            Intrinsics.checkNotNull((Object)vector3dc);
            double d2 = vector3dc.x();
            Vector3dc vector3dc2 = this.lerpPos;
            Intrinsics.checkNotNull((Object)vector3dc2);
            double d3 = vector3dc2.y();
            Vector3dc vector3dc3 = this.lerpPos;
            Intrinsics.checkNotNull((Object)vector3dc3);
            this.method_5814(d2, d3, vector3dc3.z());
            this.lerpSteps = 0;
            return;
        }
        double d4 = this.method_23317();
        Vector3dc vector3dc = this.lerpPos;
        Intrinsics.checkNotNull((Object)vector3dc);
        double d5 = d4 + (vector3dc.x() - this.method_23317()) / (double)this.lerpSteps;
        double d6 = this.method_23318();
        Vector3dc vector3dc4 = this.lerpPos;
        Intrinsics.checkNotNull((Object)vector3dc4);
        double e2 = d6 + (vector3dc4.y() - this.method_23318()) / (double)this.lerpSteps;
        double d7 = this.method_23321();
        Vector3dc vector3dc5 = this.lerpPos;
        Intrinsics.checkNotNull((Object)vector3dc5);
        double f2 = d7 + (vector3dc5.z() - this.method_23321()) / (double)this.lerpSteps;
        this.lerpSteps += -1;
        this.method_5814(d5, e2, f2);
    }

    @Nullable
    public final ShipTransform getRenderTransform(@NotNull VsiClientShipWorld shipObjectClientWorld) {
        Intrinsics.checkNotNullParameter((Object)shipObjectClientWorld, (String)"shipObjectClientWorld");
        String shipIdString = (String)this.field_6011.method_12789(SHIP_ID_DATA);
        if (Intrinsics.areEqual((Object)shipIdString, (Object)"")) {
            return null;
        }
        Intrinsics.checkNotNull((Object)shipIdString);
        long shipIdLong = Long.parseLong(shipIdString);
        return shipObjectClientWorld.getPhysEntityClientRenderTransform(shipIdLong);
    }

    protected void method_5693() {
        this.field_6011.method_12784(SHIP_ID_DATA, (Object)"");
        super.method_5693();
    }

    public void method_6091(@NotNull class_243 movementInput) {
        Intrinsics.checkNotNullParameter((Object)movementInput, (String)"movementInput");
    }

    public void method_5749(@NotNull class_2487 compoundTag) {
        Intrinsics.checkNotNullParameter((Object)compoundTag, (String)"compoundTag");
    }

    public void method_5652(@NotNull class_2487 compoundTag) {
        Intrinsics.checkNotNullParameter((Object)compoundTag, (String)"compoundTag");
    }

    @NotNull
    public class_2596<class_2602> method_18002() {
        return (class_2596)new class_2604((class_1297)this);
    }

    @NotNull
    public class_2487 method_5647(@NotNull class_2487 compoundTag) {
        Intrinsics.checkNotNullParameter((Object)compoundTag, (String)"compoundTag");
        byte[] physicsEntityDataAsBytes = VSPhysicsEntity.Companion.getMapper().writeValueAsBytes(this.physicsEntityData);
        compoundTag.method_10570(PHYS_DATA_NBT_KEY, physicsEntityDataAsBytes);
        class_2487 class_24872 = super.method_5647(compoundTag);
        Intrinsics.checkNotNullExpressionValue((Object)class_24872, (String)"saveWithoutId(...)");
        return class_24872;
    }

    private final void loadForTeleport(class_2487 compoundTag) {
        if (!this.method_37908().field_9236 && this.physicsEntityData != null) {
            throw new IllegalStateException("This entity is already loaded!");
        }
        byte[] byArray = compoundTag.method_10547(PHYS_DATA_NBT_KEY);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getByteArray(...)");
        byte[] physicsEntityDataAsBytes = byArray;
        ObjectMapper $this$readValue$iv = VSPhysicsEntity.Companion.getMapper();
        boolean $i$f$readValue = false;
        boolean $i$f$jacksonTypeRef = false;
        PhysicsEntityData oldPhysicsEntityData = (PhysicsEntityData)$this$readValue$iv.readValue(physicsEntityDataAsBytes, (TypeReference)new TypeReference<PhysicsEntityData>(){});
        VsiShipWorld vsiShipWorld = VSGameUtilsKt.getShipObjectWorld(this.method_37908());
        Intrinsics.checkNotNull((Object)vsiShipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.world.VsiServerShipWorld");
        VsiServerShipWorld vsiServerShipWorld = (VsiServerShipWorld)vsiShipWorld;
        class_1937 class_19372 = this.method_37908();
        Intrinsics.checkNotNullExpressionValue((Object)class_19372, (String)"level(...)");
        long newShipId = vsiServerShipWorld.allocateShipId(VSGameUtilsKt.getDimensionId(class_19372));
        PhysicsEntityData newPhysicsEntityData = oldPhysicsEntityData.copyPhysicsEntityDataWithNewId(newShipId);
        this.setPhysicsEntityData(newPhysicsEntityData);
        super.method_5651(compoundTag);
    }

    public void method_5651(@NotNull class_2487 compoundTag) {
        Intrinsics.checkNotNullParameter((Object)compoundTag, (String)"compoundTag");
        if (!this.method_37908().field_9236 && this.physicsEntityData != null) {
            throw new IllegalStateException("This entity is already loaded!");
        }
        byte[] byArray = compoundTag.method_10547(PHYS_DATA_NBT_KEY);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getByteArray(...)");
        byte[] physicsEntityDataAsBytes = byArray;
        ObjectMapper $this$readValue$iv = VSPhysicsEntity.Companion.getMapper();
        boolean $i$f$readValue = false;
        boolean $i$f$jacksonTypeRef = false;
        PhysicsEntityData physicsEntityData = (PhysicsEntityData)$this$readValue$iv.readValue(physicsEntityDataAsBytes, (TypeReference)new TypeReference<PhysicsEntityData>(){});
        this.setPhysicsEntityData(physicsEntityData);
        super.method_5651(compoundTag);
    }

    public void method_31744(@NotNull class_5569 callback) {
        Intrinsics.checkNotNullParameter((Object)callback, (String)"callback");
        super.method_31744(callback);
        if (!this.method_37908().field_9236) {
            boolean isNull = Intrinsics.areEqual((Object)callback, (Object)class_5569.field_27243);
            if (!isNull) {
                if (this.physicsEntityServer != null) {
                    throw new IllegalStateException("Rigid body is already in the world!");
                }
                VsiShipWorld vsiShipWorld = VSGameUtilsKt.getShipObjectWorld(this.method_37908());
                Intrinsics.checkNotNull((Object)vsiShipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.world.VsiServerShipWorld");
                VsiServerShipWorld vsiServerShipWorld = (VsiServerShipWorld)vsiShipWorld;
                PhysicsEntityData physicsEntityData = this.physicsEntityData;
                Intrinsics.checkNotNull((Object)physicsEntityData);
                class_1937 class_19372 = this.method_37908();
                Intrinsics.checkNotNullExpressionValue((Object)class_19372, (String)"level(...)");
                this.physicsEntityServer = vsiServerShipWorld.createPhysicsEntity(physicsEntityData, VSGameUtilsKt.getDimensionId(class_19372));
            } else {
                if (this.physicsEntityServer == null) {
                    return;
                }
                VsiShipWorld vsiShipWorld = VSGameUtilsKt.getShipObjectWorld(this.method_37908());
                Intrinsics.checkNotNull((Object)vsiShipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.world.VsiServerShipWorld");
                VsiServerShipWorld vsiServerShipWorld = (VsiServerShipWorld)vsiShipWorld;
                PhysicsEntityData physicsEntityData = this.physicsEntityData;
                Intrinsics.checkNotNull((Object)physicsEntityData);
                vsiServerShipWorld.deletePhysicsEntity(physicsEntityData.getShipId());
                this.physicsEntityServer = null;
            }
        }
    }

    public boolean method_5640(double d2) {
        double e2 = this.method_5829().method_995();
        if (Double.isNaN(e2)) {
            e2 = 1.0;
        }
        return d2 < (e2 *= 1024.0) * e2;
    }

    public void method_5808(double d2, double e2, double f2, float g2, float h2) {
        super.method_5808(d2, e2, f2, g2, h2);
        if (!this.method_37908().field_9236) {
            PhysicsEntityServer physicsEntityServerCopy = this.physicsEntityServer;
            if (physicsEntityServerCopy != null) {
                Vector3d newPos = new Vector3d(d2, e2, f2);
                ShipTeleportData teleportData = VsiCore.newShipTeleportData$default(VSGameUtilsKt.getVsCore(), newPos, null, null, null, null, null, null, 126, null);
                VsiShipWorld vsiShipWorld = VSGameUtilsKt.getShipObjectWorld(this.method_37908());
                Intrinsics.checkNotNull((Object)vsiShipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.world.VsiServerShipWorld");
                VsiServerShipWorld vsiServerShipWorld = (VsiServerShipWorld)vsiShipWorld;
                PhysicsEntityServer physicsEntityServer = this.physicsEntityServer;
                Intrinsics.checkNotNull((Object)physicsEntityServer);
                vsiServerShipWorld.teleportPhysicsEntity(physicsEntityServer, teleportData);
            } else {
                PhysicsEntityData physicsEntityData = this.physicsEntityData;
                Intrinsics.checkNotNull((Object)physicsEntityData);
                VsApi vsApi = ValkyrienSkies.api();
                Vector3dc vector3dc = new Vector3d(d2, e2, f2);
                PhysicsEntityData physicsEntityData2 = this.physicsEntityData;
                Intrinsics.checkNotNull((Object)physicsEntityData2);
                BodyTransform bodyTransform = vsApi.newBodyTransform(vector3dc, physicsEntityData2.getTransform().getShipToWorldRotation(), new Vector3d(1.0), new Vector3d());
                Intrinsics.checkNotNull((Object)bodyTransform, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.ships.properties.ShipTransform");
                physicsEntityData.setTransform((ShipTransform)bodyTransform);
            }
        }
    }

    public void method_5878(@NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        class_2487 compoundTag = entity.method_5647(new class_2487());
        compoundTag.method_10551("Dimension");
        Intrinsics.checkNotNull((Object)compoundTag);
        this.loadForTeleport(compoundTag);
        Intrinsics.checkNotNull((Object)((Object)this), (String)"null cannot be cast to non-null type org.valkyrienskies.mod.mixin.accessors.entity.EntityAccessor");
        ((EntityAccessor)((Object)this)).setPortalCooldown(((EntityAccessor)entity).getPortalCooldown());
        this.field_5991 = ((EntityAccessor)entity).getPortalEntrancePos();
    }

    static {
        class_2940 class_29402 = class_2945.method_12791(VSPhysicsEntity.class, (class_2941)class_2943.field_13326);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"defineId(...)");
        SHIP_ID_DATA = class_29402;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u0011\u001a\u00020\u00102\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/mod/common/entity/VSPhysicsEntity$Companion;", "", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "Lnet/minecraft/class_5132$class_5133;", "createAttributes", "()Lnet/minecraft/class_5132$class_5133;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "shipId", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "transform", "", "radius", "mass", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "createBasicSphereData", "(JLorg/valkyrienskies/core/api/ships/properties/ShipTransform;DD)Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "", "PHYS_DATA_NBT_KEY", "Ljava/lang/String;", "", "CLIENT_INTERP_STEPS", "I", "Lnet/minecraft/class_2940;", "SHIP_ID_DATA", "Lnet/minecraft/class_2940;", "getSHIP_ID_DATA", "()Lnet/minecraft/class_2940;", "<init>", "()V", "valkyrienskies-120"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2940<String> getSHIP_ID_DATA() {
            return SHIP_ID_DATA;
        }

        private final ObjectMapper getMapper() {
            return VSGameUtilsKt.getVsCore().getDefaultMapper();
        }

        @NotNull
        public final class_5132.class_5133 createAttributes() {
            class_5132.class_5133 class_51332 = class_1308.method_26828().method_26868(class_5134.field_23716, 1.0).method_26868(class_5134.field_23719, 0.25);
            Intrinsics.checkNotNullExpressionValue((Object)class_51332, (String)"add(...)");
            return class_51332;
        }

        @NotNull
        public final PhysicsEntityData createBasicSphereData(long shipId, @NotNull ShipTransform transform2, double radius, double mass) {
            Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
            double inertia = 0.4 * mass * radius * radius;
            VsiCore vsiCore = VSGameUtilsKt.getVsCore();
            Vector3dc vector3dc = new Vector3d();
            Matrix3d matrix3d = new Matrix3d().scale(inertia);
            Intrinsics.checkNotNullExpressionValue((Object)matrix3d, (String)"scale(...)");
            ShipInertiaData inertiaData = vsiCore.newShipInertiaData(vector3dc, mass, matrix3d);
            VSSphereCollisionShapeData collisionShapeData = new VSSphereCollisionShapeData(radius);
            return new PhysicsEntityData(shipId, transform2, inertiaData, new Vector3d(), new Vector3d(), collisionShapeData, 0, 0.0, 0.0, 0.0, false, 960, null);
        }

        public static /* synthetic */ PhysicsEntityData createBasicSphereData$default(Companion companion, long l2, ShipTransform shipTransform, double d2, double d3, int n2, Object object) {
            if ((n2 & 4) != 0) {
                d2 = 0.5;
            }
            if ((n2 & 8) != 0) {
                d3 = 10000.0;
            }
            return companion.createBasicSphereData(l2, shipTransform, d2, d3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

