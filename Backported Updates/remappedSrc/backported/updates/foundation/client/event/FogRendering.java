/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_4184
 *  net.minecraft.class_5636
 *  net.minecraft.class_6854
 *  net.minecraft.class_758$class_4596
 */
package backported.updates.foundation.client.event;

import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import net.minecraft.class_6854;
import net.minecraft.class_758;

@Environment(value=EnvType.CLIENT)
public interface FogRendering {
    public static final Event<FogDensity> FOG_DENSITY = Event.create(FogDensity.class, densities -> (camera, density) -> {
        int n = 0;
        FogDensity[] fogDensityArray = densities;
        int n2 = fogDensityArray.length;
        if (n < n2) {
            FogDensity callback = fogDensityArray[n];
            return callback.setDensity(camera, density);
        }
        return density;
    });
    public static final Event<FogColor> FOG_COLOR = Event.create(FogColor.class);
    public static final Event<FogRender> FOG_RENDER = Event.cancellable(FogRender.class);

    public static interface FogDensity {
        public float setDensity(class_4184 var1, float var2);
    }

    public static interface FogColor {
        public void setColor(ColorData var1, float var2);
    }

    public static interface FogRender {
        public CancellableResult onFogRender(class_758.class_4596 var1, class_5636 var2, class_4184 var3, float var4, float var5, float var6, float var7, class_6854 var8, FogData var9);
    }

    public static class ColorData {
        private final class_4184 camera;
        private float red;
        private float green;
        private float blue;

        public ColorData(class_4184 camera, float red, float green, float blue) {
            this.camera = camera;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public class_4184 getCamera() {
            return this.camera;
        }

        public float getRed() {
            return this.red;
        }

        public float getGreen() {
            return this.green;
        }

        public float getBlue() {
            return this.blue;
        }

        public void setRed(float red) {
            this.red = red;
        }

        public void setGreen(float green) {
            this.green = green;
        }

        public void setBlue(float blue) {
            this.blue = blue;
        }
    }

    public static class FogData {
        private float farPlaneDistance;
        private float nearPlaneDistance;
        private class_6854 shape;

        public FogData(float nearPlaneDistance, float farPlaneDistance, class_6854 shape) {
            this.farPlaneDistance = farPlaneDistance;
            this.nearPlaneDistance = nearPlaneDistance;
            this.shape = shape;
        }

        public float getFarPlaneDistance() {
            return this.farPlaneDistance;
        }

        public float getNearPlaneDistance() {
            return this.nearPlaneDistance;
        }

        public class_6854 getShape() {
            return this.shape;
        }

        public void setFarPlaneDistance(float farPlaneDistance) {
            this.farPlaneDistance = farPlaneDistance;
        }

        public void setNearPlaneDistance(float nearPlaneDistance) {
            this.nearPlaneDistance = nearPlaneDistance;
        }

        public void setShape(class_6854 shape) {
            this.shape = shape;
        }
    }
}

