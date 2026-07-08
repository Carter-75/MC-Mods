/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_241
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.api.leash;

import backported_updates.mixin.access.EntityAccessor;
import net.minecraft.class_1297;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.jetbrains.annotations.Nullable;

public class InterpolationHandler {
    private final class_1297 entity;
    private final int interpolationSteps;
    private final InterpolationData data = new InterpolationData(0, class_243.field_1353, 0.0f, 0.0f);
    @Nullable
    private class_243 previousTickPosition;
    @Nullable
    private class_241 previousTickRot;

    public InterpolationHandler(class_1297 entity, int steps) {
        this.interpolationSteps = steps;
        this.entity = entity;
    }

    public void interpolateTo(class_243 position, float y, float x) {
        if (this.interpolationSteps == 0) {
            this.entity.method_23327(position.field_1352, position.field_1351, position.field_1350);
            this.entity.method_36456(y);
            this.entity.method_36457(x);
            this.entity.method_22862();
            ((EntityAccessor)this.entity).callReapplyPosition();
            this.cancel();
        } else {
            this.data.steps = this.interpolationSteps;
            this.data.position = position;
            this.data.yRot = y;
            this.data.xRot = x;
            this.previousTickPosition = this.entity.method_19538();
            this.previousTickRot = new class_241(this.entity.method_36455(), this.entity.method_36454());
        }
    }

    public boolean hasActiveInterpolation() {
        return this.data.steps > 0;
    }

    public void interpolate() {
        if (!this.hasActiveInterpolation()) {
            this.cancel();
        } else {
            double progress = 1.0 / (double)this.data.steps;
            if (this.previousTickPosition != null) {
                class_243 movement = this.entity.method_19538().method_1020(this.previousTickPosition);
                if (this.entity.method_37908().method_8587(this.entity, ((EntityAccessor)this.entity).getDimensions().method_30757(this.data.position.method_1019(movement)))) {
                    this.data.addDelta(movement);
                }
            }
            if (this.previousTickRot != null) {
                float yRot = this.entity.method_36454() - this.previousTickRot.field_1342;
                float xRot = this.entity.method_36455() - this.previousTickRot.field_1343;
                this.data.addRotation(yRot, xRot);
            }
            double x = class_3532.method_16436((double)progress, (double)this.entity.method_23317(), (double)this.data.position.field_1352);
            double y = class_3532.method_16436((double)progress, (double)this.entity.method_23318(), (double)this.data.position.field_1351);
            double z = class_3532.method_16436((double)progress, (double)this.entity.method_23321(), (double)this.data.position.field_1350);
            class_243 position = new class_243(x, y, z);
            float yRot = class_3532.method_17821((float)((float)progress), (float)this.entity.method_36454(), (float)this.data.yRot);
            float xRot = (float)class_3532.method_16436((double)progress, (double)this.entity.method_36455(), (double)this.data.xRot);
            this.entity.method_33574(position);
            ((EntityAccessor)this.entity).callSetRot(yRot, xRot);
            this.data.decrease();
            this.previousTickPosition = position;
            this.previousTickRot = new class_241(this.entity.method_36455(), this.entity.method_36454());
        }
    }

    public void cancel() {
        this.data.steps = 0;
        this.previousTickPosition = null;
        this.previousTickRot = null;
    }

    static class InterpolationData {
        protected int steps;
        class_243 position;
        float yRot;
        float xRot;

        InterpolationData(int steps, class_243 position, float yRot, float xRot) {
            this.steps = steps;
            this.position = position;
            this.yRot = yRot;
            this.xRot = xRot;
        }

        public void decrease() {
            --this.steps;
        }

        public void addDelta(class_243 vec3) {
            this.position = this.position.method_1019(vec3);
        }

        public void addRotation(float yRot, float xRot) {
            this.yRot += yRot;
            this.xRot += xRot;
        }
    }
}

