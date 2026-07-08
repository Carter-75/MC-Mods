/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4184
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 */
package org.valkyrienskies.mod.mixin.client;

import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.primitives.AABBi;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.client.IVSCamera;
import org.valkyrienskies.mod.common.world.RaycastUtilsKt;

@Mixin(value={class_4184.class})
public abstract class MixinCamera
implements IVSCamera {
    @Shadow
    private boolean field_18709;
    @Shadow
    private class_1922 field_18710;
    @Shadow
    private class_1297 field_18711;
    @Shadow
    @Final
    private Vector3f field_18714;
    @Shadow
    @Final
    private Vector3f field_18715;
    @Shadow
    @Final
    private Vector3f field_18716;
    @Shadow
    private float field_18717;
    @Shadow
    private float field_18718;
    @Shadow
    @Final
    private Quaternionf field_21518;
    @Shadow
    private boolean field_18719;
    @Shadow
    private float field_18721;
    @Shadow
    private float field_18722;
    @Shadow
    private class_243 field_18712;

    @Shadow
    protected abstract double method_19318(double var1);

    @Shadow
    protected abstract void method_19324(double var1, double var3, double var5);

    @Shadow
    protected abstract void method_19327(double var1, double var3, double var5);

    @Override
    public void setupWithShipMounted(@NotNull class_1922 level, @NotNull class_1297 renderViewEntity, boolean thirdPerson, boolean thirdPersonReverse, float partialTicks, @NotNull ClientShip shipMountedTo, @NotNull Vector3dc inShipPlayerPosition) {
        ShipTransform renderTransform = shipMountedTo.getRenderTransform();
        Vector3d playerBasePos = renderTransform.getShipToWorldMatrix().transformPosition(inShipPlayerPosition, new Vector3d());
        Vector3d playerEyePos = renderTransform.getShipCoordinatesToWorldCoordinatesRotation().transform(new Vector3d(0.0, class_3532.method_16439((float)partialTicks, (float)this.field_18722, (float)this.field_18721), 0.0)).add(playerBasePos);
        this.field_18709 = true;
        this.field_18710 = level;
        this.field_18711 = renderViewEntity;
        this.field_18719 = thirdPerson;
        this.setRotationWithShipTransform(renderViewEntity.method_5705(partialTicks), renderViewEntity.method_5695(partialTicks), renderTransform);
        this.method_19327(playerEyePos.x(), playerEyePos.y(), playerEyePos.z());
        if (thirdPerson) {
            AABBi boundingBox;
            double dist;
            if (thirdPersonReverse) {
                this.setRotationWithShipTransform(this.field_18718 + 180.0f, -this.field_18717, renderTransform);
            }
            double d2 = dist = (dist = (double)((boundingBox = (AABBi)shipMountedTo.getShipVoxelAABB()).lengthX() + boundingBox.lengthY() + boundingBox.lengthZ()) / 3.0 * 1.5) > 4.0 ? dist : 4.0;
            if (this.field_18710 instanceof class_1937) {
                this.method_19324(-this.getMaxZoomIgnoringMountedShip((class_1937)this.field_18710, 4.0 * (dist / 4.0), shipMountedTo), 0.0, 0.0);
            } else {
                this.method_19324(-this.method_19318(4.0 * (dist / 4.0)), 0.0, 0.0);
            }
        }
    }

    @Unique
    private void setRotationWithShipTransform(float yaw, float pitch, ShipTransform renderTransform) {
        Quaterniond originalRotation = new Quaterniond().rotateY(Math.toRadians(-yaw)).rotateX(Math.toRadians(pitch)).normalize();
        Quaterniond newRotation = renderTransform.getShipCoordinatesToWorldCoordinatesRotation().mul(originalRotation, new Quaterniond());
        this.field_18717 = pitch;
        this.field_18718 = yaw;
        this.field_21518.set(newRotation);
        this.field_18714.set(0.0f, 0.0f, 1.0f);
        this.field_21518.transform(this.field_18714);
        this.field_18715.set(0.0f, 1.0f, 0.0f);
        this.field_21518.transform(this.field_18715);
        this.field_18716.set(1.0f, 0.0f, 0.0f);
        this.field_21518.transform(this.field_18716);
    }

    @Unique
    private double getMaxZoomIgnoringMountedShip(class_1937 level, double maxZoom, @NotNull ClientShip toIgnore) {
        for (int i2 = 0; i2 < 8; ++i2) {
            double e2;
            class_243 vec32;
            class_3965 hitResult;
            float f2 = (i2 & 1) * 2 - 1;
            float g2 = (i2 >> 1 & 1) * 2 - 1;
            float h2 = (i2 >> 2 & 1) * 2 - 1;
            class_243 vec3 = this.field_18712.method_1031((double)(f2 *= 0.1f), (double)(g2 *= 0.1f), (double)(h2 *= 0.1f));
            if ((hitResult = RaycastUtilsKt.clipIncludeShips(level, new class_3959(vec3, vec32 = new class_243(this.field_18712.field_1352 - (double)this.field_18714.x() * maxZoom + (double)f2 + (double)h2, this.field_18712.field_1351 - (double)this.field_18714.y() * maxZoom + (double)g2, this.field_18712.field_1350 - (double)this.field_18714.z() * maxZoom + (double)h2), class_3959.class_3960.field_23142, class_3959.class_242.field_1348, this.field_18711), true, toIgnore.getId())).method_17783() == class_239.class_240.field_1333 || !((e2 = hitResult.method_17784().method_1022(this.field_18712)) < maxZoom)) continue;
            maxZoom = e2;
        }
        return maxZoom;
    }
}

