/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2596
 *  net.minecraft.class_2602
 *  net.minecraft.class_2604
 *  net.minecraft.class_310
 *  net.minecraft.class_315
 */
package org.valkyrienskies.mod.common.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2604;
import net.minecraft.class_310;
import net.minecraft.class_315;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.valkyrienskies.core.api.attachment.AttachmentHolder;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.mod.api.SeatedControllingPlayer;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSKeyBindings;
import org.valkyrienskies.mod.common.networking.PacketPlayerDriving;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00000!\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a2\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0004J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2={"Lorg/valkyrienskies/mod/common/entity/ShipMountingEntity;", "Lnet/minecraft/class_1297;", "", "tick", "()V", "Lnet/minecraft/class_1309;", "livingEntity", "Lnet/minecraft/class_243;", "getDismountLocationForPassenger", "(Lnet/minecraft/class_1309;)Lnet/minecraft/class_243;", "Lnet/minecraft/class_2487;", "compound", "readAdditionalSaveData", "(Lnet/minecraft/class_2487;)V", "addAdditionalSaveData", "defineSynchedData", "Lnet/minecraft/class_1297$class_5529;", "removalReason", "remove", "(Lnet/minecraft/class_1297$class_5529;)V", "sendDrivingPacket", "getControllingPassenger", "()Lnet/minecraft/class_1309;", "Lnet/minecraft/class_2596;", "Lnet/minecraft/class_2602;", "getAddEntityPacket", "()Lnet/minecraft/class_2596;", "", "isController", "Z", "()Z", "setController", "(Z)V", "Lnet/minecraft/class_1299;", "type", "Lnet/minecraft/class_1937;", "level", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nShipMountingEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipMountingEntity.kt\norg/valkyrienskies/mod/common/entity/ShipMountingEntity\n+ 2 LoadedServerShip.kt\norg/valkyrienskies/core/api/ships/LoadedServerShipKt\n+ 3 AttachmentHolder.kt\norg/valkyrienskies/core/api/attachment/AttachmentHolderKt\n*L\n1#1,120:1\n46#2:121\n80#3:122\n*S KotlinDebug\n*F\n+ 1 ShipMountingEntity.kt\norg/valkyrienskies/mod/common/entity/ShipMountingEntity\n*L\n81#1:121\n81#1:122\n*E\n"})
public class ShipMountingEntity
extends class_1297 {
    private boolean isController;

    public ShipMountingEntity(@NotNull class_1299<ShipMountingEntity> type, @NotNull class_1937 level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.field_23807 = false;
        this.field_5960 = true;
    }

    public final boolean isController() {
        return this.isController;
    }

    public final void setController(boolean bl) {
        this.isController = bl;
    }

    public void method_5773() {
        super.method_5773();
        if (!this.method_37908().field_9236 && this.method_5685().isEmpty()) {
            this.method_5768();
            return;
        }
        class_1937 class_19372 = this.method_37908();
        class_2338 class_23382 = this.method_24515();
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"blockPosition(...)");
        if (VSGameUtilsKt.getLoadedShipManagingPos(class_19372, (class_2382)class_23382) != null) {
            this.sendDrivingPacket();
        }
    }

    @NotNull
    public class_243 method_24829(@NotNull class_1309 livingEntity) {
        Intrinsics.checkNotNullParameter((Object)livingEntity, (String)"livingEntity");
        class_1937 class_19372 = this.method_37908();
        Intrinsics.checkNotNullExpressionValue((Object)class_19372, (String)"level(...)");
        class_243 class_2432 = this.method_19538();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"position(...)");
        if (VSGameUtilsKt.isBlockInShipyard(class_19372, class_2432)) {
            class_1937 class_19373 = this.method_37908();
            class_243 class_2433 = this.method_19538();
            Intrinsics.checkNotNullExpressionValue((Object)class_2433, (String)"position(...)");
            if (VSGameUtilsKt.getShipManagingPos(class_19373, (class_2374)class_2433) == null) {
                class_243 class_2434 = livingEntity.method_19538();
                Intrinsics.checkNotNullExpressionValue((Object)class_2434, (String)"position(...)");
                return class_2434;
            }
        }
        class_243 class_2435 = super.method_24829(livingEntity);
        Intrinsics.checkNotNullExpressionValue((Object)class_2435, (String)"getDismountLocationForPassenger(...)");
        return class_2435;
    }

    protected void method_5749(@NotNull class_2487 compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
    }

    protected void method_5652(@NotNull class_2487 compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
    }

    protected void method_5693() {
    }

    /*
     * WARNING - void declaration
     */
    public void method_5650(@NotNull class_1297.class_5529 removalReason) {
        Intrinsics.checkNotNullParameter((Object)removalReason, (String)"removalReason");
        if (this.isController && !this.method_37908().field_9236) {
            class_1937 class_19372 = this.method_37908();
            class_2338 class_23382 = this.method_24515();
            Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"blockPosition(...)");
            LoadedServerShip loadedServerShip = (LoadedServerShip)VSGameUtilsKt.getLoadedShipManagingPos(class_19372, (class_2382)class_23382);
            if (loadedServerShip != null) {
                void $this$setAttachment$iv;
                LoadedServerShip loadedServerShip2 = loadedServerShip;
                Object value$iv = null;
                boolean $i$f$setAttachment = false;
                AttachmentHolder $this$removeAttachment$iv$iv = (AttachmentHolder)$this$setAttachment$iv;
                boolean $i$f$removeAttachment = false;
                $this$removeAttachment$iv$iv.removeAttachment(SeatedControllingPlayer.class);
            }
        }
        super.method_5650(removalReason);
    }

    private final void sendDrivingPacket() {
        if (!this.method_37908().field_9236) {
            return;
        }
        class_315 opts = class_310.method_1551().field_1690;
        boolean forward = opts.field_1894.method_1434();
        boolean backward = opts.field_1881.method_1434();
        boolean left = opts.field_1913.method_1434();
        boolean right = opts.field_1849.method_1434();
        boolean up = opts.field_1903.method_1434();
        class_1309 class_13092 = this.method_5642();
        boolean sprint = class_13092 != null ? class_13092.method_5624() : false;
        boolean down = VSKeyBindings.INSTANCE.getShipDown().get().method_1434();
        boolean cruise = VSKeyBindings.INSTANCE.getShipCruise().get().method_1434();
        Vector3f impulse = new Vector3f();
        float f2 = forward == backward ? 0.0f : (impulse.z = forward ? 1.0f : -1.0f);
        float f3 = left == right ? 0.0f : (impulse.x = left ? 1.0f : -1.0f);
        impulse.y = up == down ? 0.0f : (up ? 1.0f : -1.0f);
        SimplePacketNetworking $this$sendDrivingPacket_u24lambda_u240 = VSGameUtilsKt.getVsCore().getSimplePacketNetworking();
        boolean bl = false;
        $this$sendDrivingPacket_u24lambda_u240.sendToServer1(new PacketPlayerDriving(impulse, sprint, cruise));
    }

    @Nullable
    public class_1309 method_5642() {
        class_1309 class_13092;
        if (this.isController) {
            List list = this.method_5685();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getPassengers(...)");
            Object object = CollectionsKt.getOrNull((List)list, (int)0);
            class_13092 = object instanceof class_1309 ? (class_1309)object : null;
        } else {
            class_13092 = null;
        }
        return class_13092;
    }

    @NotNull
    public class_2596<class_2602> method_18002() {
        return (class_2596)new class_2604((class_1297)this);
    }
}

