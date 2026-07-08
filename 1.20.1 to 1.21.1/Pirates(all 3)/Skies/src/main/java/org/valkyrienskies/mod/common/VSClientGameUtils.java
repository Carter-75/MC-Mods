/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_638
 */
package org.valkyrienskies.mod.common;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_638;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Matrix4f;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ/\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ)\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010JO\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017JO\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u0016\u0010\u001aJ?\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\u0016\u0010\u001d\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/mod/common/VSClientGameUtils;", "", "Lnet/minecraft/class_4587;", "poseStack", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "ship", "", "multiplyWithShipToWorld", "(Lnet/minecraft/class_4587;Lorg/valkyrienskies/core/api/ships/ClientShip;)V", "", "offsetX", "offsetY", "offsetZ", "transformRenderIfInShipyard", "(Lnet/minecraft/class_4587;DDD)V", "getClientShip", "(DDD)Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "renderTransform", "camX", "camY", "camZ", "transformRenderWithShip", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lnet/minecraft/class_4587;DDDDDD)V", "Lorg/joml/Matrix4f;", "matrix", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/joml/Matrix4f;DDDDDD)V", "Lnet/minecraft/class_2338;", "blockPos", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lnet/minecraft/class_4587;Lnet/minecraft/class_2338;DDD)V", "<init>", "()V", "valkyrienskies-120"})
public final class VSClientGameUtils {
    @NotNull
    public static final VSClientGameUtils INSTANCE = new VSClientGameUtils();

    private VSClientGameUtils() {
    }

    @JvmStatic
    public static final void multiplyWithShipToWorld(@NotNull class_4587 poseStack, @NotNull ClientShip ship) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        VectorConversionsMCKt.multiply(poseStack, ship.getRenderTransform().getShipToWorld(), ship.getRenderTransform().getShipToWorldRotation());
    }

    @JvmStatic
    public static final void transformRenderIfInShipyard(@NotNull class_4587 poseStack, double offsetX, double offsetY, double offsetZ) {
        ClientShip ship;
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        class_638 class_6382 = class_310.method_1551().field_1687;
        ClientShip clientShip = ship = class_6382 != null ? VSGameUtilsKt.getLoadedShipManagingPos(class_6382, offsetX, offsetY, offsetZ) : null;
        if (ship != null) {
            ShipTransform transform2 = ship.getRenderTransform();
            Matrix4d renderMatrix = new Matrix4d().mul(transform2.getShipToWorld()).translate(offsetX, offsetY, offsetZ);
            Intrinsics.checkNotNull((Object)renderMatrix);
            VectorConversionsMCKt.multiply(poseStack, renderMatrix);
        } else {
            poseStack.method_22904(offsetX, offsetY, offsetZ);
        }
    }

    @JvmStatic
    @Nullable
    public static final ClientShip getClientShip(double offsetX, double offsetY, double offsetZ) {
        class_638 class_6382 = class_310.method_1551().field_1687;
        return class_6382 != null ? VSGameUtilsKt.getLoadedShipManagingPos(class_6382, offsetX, offsetY, offsetZ) : null;
    }

    @JvmStatic
    public static final void transformRenderWithShip(@NotNull ShipTransform renderTransform, @NotNull class_4587 poseStack, double offsetX, double offsetY, double offsetZ, double camX, double camY, double camZ) {
        Intrinsics.checkNotNullParameter((Object)renderTransform, (String)"renderTransform");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Matrix4dc shipToWorldMatrix = renderTransform.getShipToWorld();
        Matrix4d renderMatrix = new Matrix4d();
        renderMatrix.translate(-camX, -camY, -camZ);
        renderMatrix.mul(shipToWorldMatrix);
        renderMatrix.translate(offsetX, offsetY, offsetZ);
        VectorConversionsMCKt.multiply(poseStack, renderMatrix, renderTransform.getShipToWorldRotation());
    }

    @JvmStatic
    public static final void transformRenderWithShip(@NotNull ShipTransform renderTransform, @NotNull Matrix4f matrix, double offsetX, double offsetY, double offsetZ, double camX, double camY, double camZ) {
        Intrinsics.checkNotNullParameter((Object)renderTransform, (String)"renderTransform");
        Intrinsics.checkNotNullParameter((Object)matrix, (String)"matrix");
        Matrix4dc shipToWorldMatrix = renderTransform.getShipToWorld();
        Matrix4d renderMatrix = new Matrix4d();
        renderMatrix.translate(-camX, -camY, -camZ);
        renderMatrix.mul(shipToWorldMatrix);
        renderMatrix.translate(offsetX, offsetY, offsetZ);
        matrix.mul(new Matrix4f(renderMatrix));
    }

    @JvmStatic
    public static final void transformRenderWithShip(@NotNull ShipTransform renderTransform, @NotNull class_4587 matrix, @NotNull class_2338 blockPos, double camX, double camY, double camZ) {
        Intrinsics.checkNotNullParameter((Object)renderTransform, (String)"renderTransform");
        Intrinsics.checkNotNullParameter((Object)matrix, (String)"matrix");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        VSClientGameUtils.transformRenderWithShip(renderTransform, matrix, (double)blockPos.method_10263(), (double)blockPos.method_10264(), (double)blockPos.method_10260(), camX, camY, camZ);
    }
}

