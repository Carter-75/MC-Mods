/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.render.entity.model.SinglePartEntityModel
 *  net.minecraft.client.model.ModelPart
 *  org.joml.Vector3f
 */
package backported.updates.foundation.client.animator.v2;

import backported.updates.foundation.client.animator.v2.AnimationChannel;
import backported.updates.foundation.client.animator.v2.AnimationDefinition;
import backported.updates.foundation.client.animator.v2.Keyframe;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.model.ModelPart;
import org.joml.Vector3f;

@Environment(value=EnvType.CLIENT)
public class KeyframeAnimations {
    public static void animate(SinglePartEntityModel<?> model, AnimationDefinition animationDefinition, float ageInTicks, long accumulatedTime, float scale, Vector3f animationVecCache) {
        float elapsedSeconds = KeyframeAnimations.getElapsedSeconds(animationDefinition, accumulatedTime);
        AnimationChannel.Query query = () -> ageInTicks * 0.001f;
        for (Map.Entry<String, List<AnimationChannel>> animation : animationDefinition.boneAnimations().entrySet()) {
            Optional entry = model.getChild(animation.getKey());
            List<AnimationChannel> channels = animation.getValue();
            entry.ifPresent(modelPart -> channels.forEach(channel -> {
                Keyframe[] keyframes = channel.keyframes();
                int currentKeyframeIndex = Math.max(0, MathHelper.binarySearch((int)0, (int)keyframes.length, ix -> elapsedSeconds <= keyframes[ix].timestamp()) - 1);
                int nextKeyframeIndex = Math.min(keyframes.length - 1, currentKeyframeIndex + 1);
                Keyframe currentKeyframe = keyframes[currentKeyframeIndex];
                Keyframe nextKeyframe = keyframes[nextKeyframeIndex];
                float timeSinceCurrentKeyframe = elapsedSeconds - currentKeyframe.timestamp();
                float interpolationFactor = 0.0f;
                if (nextKeyframeIndex != currentKeyframeIndex) {
                    interpolationFactor = MathHelper.clamp((float)(timeSinceCurrentKeyframe / (nextKeyframe.timestamp() - currentKeyframe.timestamp())), (float)0.0f, (float)1.0f);
                }
                nextKeyframe.interpolation().apply(animationVecCache, query, interpolationFactor, keyframes, currentKeyframeIndex, nextKeyframeIndex, scale);
                channel.target().apply((ModelPart)modelPart, animationVecCache);
            }));
        }
    }

    private static float getElapsedSeconds(AnimationDefinition animationDefinition, long accumulatedTime) {
        float timeInSeconds = (float)accumulatedTime / 1000.0f;
        return animationDefinition.looping() ? timeInSeconds % animationDefinition.lengthInSeconds() : timeInSeconds;
    }

    public static Vector3f posVec(float x, float y, float z) {
        return new Vector3f(x, -y, z);
    }

    public static Vector3f degreeVec(float xDegrees, float yDegrees, float zDegrees) {
        return new Vector3f(xDegrees * ((float)Math.PI / 180), yDegrees * ((float)Math.PI / 180), zDegrees * ((float)Math.PI / 180));
    }

    public static Vector3f scaleVec(double xScale, double yScale, double zScale) {
        return new Vector3f((float)(xScale - 1.0), (float)(yScale - 1.0), (float)(zScale - 1.0));
    }
}

