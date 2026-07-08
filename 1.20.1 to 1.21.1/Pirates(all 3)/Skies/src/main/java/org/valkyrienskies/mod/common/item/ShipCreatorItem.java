/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1838
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2470
 *  net.minecraft.class_2561
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 */
package org.valkyrienskies.mod.common.item;

import java.util.function.DoubleSupplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2470;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.ships.VsiServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.util.RelocationUtilKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0014"}, d2={"Lorg/valkyrienskies/mod/common/item/ShipCreatorItem;", "Lnet/minecraft/class_1792;", "Lnet/minecraft/class_1799;", "stack", "", "isFoil", "(Lnet/minecraft/class_1799;)Z", "Lnet/minecraft/class_1838;", "ctx", "Lnet/minecraft/class_1269;", "useOn", "(Lnet/minecraft/class_1838;)Lnet/minecraft/class_1269;", "Ljava/util/function/DoubleSupplier;", "scale", "Ljava/util/function/DoubleSupplier;", "minScaling", "Lnet/minecraft/class_1792$class_1793;", "properties", "<init>", "(Lnet/minecraft/class_1792$class_1793;Ljava/util/function/DoubleSupplier;Ljava/util/function/DoubleSupplier;)V", "valkyrienskies-120"})
public final class ShipCreatorItem
extends class_1792 {
    @NotNull
    private final DoubleSupplier scale;
    @NotNull
    private final DoubleSupplier minScaling;

    public ShipCreatorItem(@NotNull class_1792.class_1793 properties, @NotNull DoubleSupplier scale, @NotNull DoubleSupplier minScaling) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        Intrinsics.checkNotNullParameter((Object)scale, (String)"scale");
        Intrinsics.checkNotNullParameter((Object)minScaling, (String)"minScaling");
        super(properties);
        this.scale = scale;
        this.minScaling = minScaling;
    }

    public boolean method_7886(@NotNull class_1799 stack) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        return true;
    }

    @NotNull
    public class_1269 method_7884(@NotNull class_1838 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        class_1937 class_19372 = ctx.method_8045();
        class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
        if (class_32182 == null) {
            class_1269 class_12692 = super.method_7884(ctx);
            Intrinsics.checkNotNullExpressionValue((Object)class_12692, (String)"useOn(...)");
            return class_12692;
        }
        class_3218 level = class_32182;
        class_2338 blockPos = ctx.method_8037();
        class_2680 class_26802 = level.method_8320(blockPos);
        Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getBlockState(...)");
        class_2680 blockState = class_26802;
        if (!level.field_9236) {
            class_1937 class_19373 = ctx.method_8045();
            Intrinsics.checkNotNull((Object)blockPos);
            Ship parentShip = VSGameUtilsKt.getShipManagingPos(class_19373, blockPos);
            if (!blockState.method_26215()) {
                String dimensionId = VSGameUtilsKt.getDimensionId((class_1937)level);
                double scale = this.scale.getAsDouble();
                double minScaling = this.minScaling.getAsDouble();
                ServerShip serverShip = VSGameUtilsKt.getShipObjectWorld(level).createNewShipAtBlock(VectorConversionsMCKt.toJOML((class_2382)blockPos), false, scale, dimensionId);
                class_2338 centerPos = VectorConversionsMCKt.toBlockPos(ChunkClaim.getCenterBlockCoordinates$default(serverShip.getChunkClaim(), VSGameUtilsKt.getYRange((class_1937)level), null, 2, null));
                RelocationUtilKt.relocateBlock((class_1937)level, blockPos, centerPos, true, serverShip, class_2470.field_11467);
                class_1657 class_16572 = ctx.method_8036();
                if (class_16572 != null) {
                    class_16572.method_43496((class_2561)class_2561.method_43470((String)"SHIPIFIED!"));
                }
                if (parentShip != null) {
                    Vector3d newShipPosInWorld = parentShip.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOMLD((class_2382)blockPos).add(0.5, 0.5, 0.5));
                    Vector3d newShipPosInShipyard = VectorConversionsMCKt.toJOMLD((class_2382)blockPos).add(0.5, 0.5, 0.5);
                    Quaterniondc newShipRotation = parentShip.getTransform().getShipToWorldRotation();
                    Vector3d newShipScaling = parentShip.getTransform().getShipToWorldScaling().mul(scale, new Vector3d());
                    if (newShipScaling.x() < minScaling) {
                        newShipScaling = new Vector3d(minScaling, minScaling, minScaling);
                    }
                    VsiCore vsiCore = VSGameUtilsKt.getVsCore();
                    Intrinsics.checkNotNull((Object)newShipPosInWorld);
                    Vector3dc vector3dc = newShipPosInWorld;
                    Vector3d vector3d = newShipScaling;
                    Intrinsics.checkNotNull((Object)vector3d);
                    Vector3dc vector3dc2 = vector3d;
                    Intrinsics.checkNotNull((Object)newShipPosInShipyard);
                    BodyTransform newTransform = vsiCore.newBodyTransform(vector3dc, newShipRotation, vector3dc2, newShipPosInShipyard);
                    Intrinsics.checkNotNull((Object)serverShip, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.ships.VsiServerShip");
                    ((VsiServerShip)serverShip).unsafeSetTransform(newTransform);
                }
            }
        }
        class_1269 class_12693 = super.method_7884(ctx);
        Intrinsics.checkNotNullExpressionValue((Object)class_12693, (String)"useOn(...)");
        return class_12693;
    }
}

