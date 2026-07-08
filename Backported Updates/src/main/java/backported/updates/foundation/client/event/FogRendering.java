/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.render.Camera
 *  net.minecraft.block.enums.CameraSubmersionType
 *  net.minecraft.client.render.FogShape
 *  net.minecraft.client.render.BackgroundRenderer$FogType
 */
package backported.updates.foundation.client.event;

import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.Camera;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.render.FogShape;
import net.minecraft.client.render.BackgroundRenderer;

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
        public float setDensity(Camera var1, float var2);
    }

    public static interface FogColor {
        public void setColor(ColorData var1, float var2);
    }

    public static interface FogRender {
        public CancellableResult onFogRender(BackgroundRenderer.FogType var1, CameraSubmersionType var2, Camera var3, float var4, float var5, float var6, float var7, FogShape var8, FogData var9);
    }

    public static class ColorData {
        private final Camera camera;
        private float red;
        private float green;
        private float blue;

        public ColorData(Camera camera, float red, float green, float blue) {
            this.camera = camera;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public Camera getCamera() {
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
        private FogShape shape;

        public FogData(float nearPlaneDistance, float farPlaneDistance, FogShape shape) {
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

        public FogShape getShape() {
            return this.shape;
        }

        public void setFarPlaneDistance(float farPlaneDistance) {
            this.farPlaneDistance = farPlaneDistance;
        }

        public void setNearPlaneDistance(float nearPlaneDistance) {
            this.nearPlaneDistance = nearPlaneDistance;
        }

        public void setShape(FogShape shape) {
            this.shape = shape;
        }
    }
}

