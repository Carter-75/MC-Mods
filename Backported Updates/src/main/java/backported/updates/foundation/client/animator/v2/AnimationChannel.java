/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.model.ModelPart
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package backported.updates.foundation.client.animator.v2;

import backported.updates.foundation.client.animator.v2.Keyframe;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.model.ModelPart;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Environment(value=EnvType.CLIENT)
public record AnimationChannel(Target target, Keyframe[] keyframes) {

    @Environment(value=EnvType.CLIENT)
    public static interface Target {
        public void apply(ModelPart var1, Vector3f var2);
    }

    @Environment(value=EnvType.CLIENT)
    public static interface Query {
        public float animTime();
    }

    @Environment(value=EnvType.CLIENT)
    public static interface Value {
        public Vector3f resolve(Query var1);
    }

    @Environment(value=EnvType.CLIENT)
    public static class Targets {
        public static final Target POSITION = ModelPart::translate;
        public static final Target ROTATION = ModelPart::rotate;
        public static final Target SCALE = ModelPart::scale;
    }

    @Environment(value=EnvType.CLIENT)
    public static class Interpolations {
        public static final Interpolation LINEAR = (result, query, progress, keyframes, startIndex, endIndex, scale) -> {
            Vector3f startTarget = keyframes[startIndex].target().resolve(query);
            Vector3f endTarget = keyframes[endIndex].target().resolve(query);
            return startTarget.lerp((Vector3fc)endTarget, progress, result).mul(scale);
        };
        public static final Interpolation CATMULLROM = (result, query, progress, keyframes, startIndex, endIndex, scale) -> {
            Vector3f beforeStart = keyframes[Math.max(0, startIndex - 1)].target().resolve(query);
            Vector3f start = keyframes[startIndex].target().resolve(query);
            Vector3f end = keyframes[endIndex].target().resolve(query);
            Vector3f afterEnd = keyframes[Math.min(keyframes.length - 1, endIndex + 1)].target().resolve(query);
            result.set(MathHelper.catmullRom((float)progress, (float)beforeStart.x(), (float)start.x(), (float)end.x(), (float)afterEnd.x()) * scale, MathHelper.catmullRom((float)progress, (float)beforeStart.y(), (float)start.y(), (float)end.y(), (float)afterEnd.y()) * scale, MathHelper.catmullRom((float)progress, (float)beforeStart.z(), (float)start.z(), (float)end.z(), (float)afterEnd.z()) * scale);
            return result;
        };
    }

    @Environment(value=EnvType.CLIENT)
    public static interface Interpolation {
        public Vector3f apply(Vector3f var1, Query var2, float var3, Keyframe[] var4, int var5, int var6, float var7);
    }
}

