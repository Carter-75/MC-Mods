/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_5597
 *  net.minecraft.class_630
 *  org.joml.Vector3f
 */
package backported.updates.foundation.client.animator;

import backported.updates.foundation.client.animator.AnimatedChannel;
import backported.updates.foundation.client.animator.AnimatedModel;
import backported.updates.foundation.client.animator.AnimatedPoint;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_5597;
import net.minecraft.class_630;
import org.joml.Vector3f;

@Environment(value=EnvType.CLIENT)
public record MathAnimator(Map<String, List<AnimatedChannel>> animationsByBone) {
    public static void animate(class_5597<?> model, float animationProgress, MathAnimator builder) {
        float animTime = animationProgress / 20.0f;
        Vector3f vector = new Vector3f();
        for (Map.Entry<String, List<AnimatedChannel>> animation : builder.animationsByBone().entrySet()) {
            Optional entry = model.method_41909(animation.getKey());
            if (entry.isEmpty()) continue;
            class_630 part = (class_630)entry.get();
            List<AnimatedChannel> channels = animation.getValue();
            for (AnimatedChannel channel : channels) {
                for (AnimatedPoint point : channel.targets()) {
                    vector.set(point.getX(animTime), point.getY(animTime), point.getZ(animTime));
                    point.target().apply(part, vector);
                }
            }
        }
    }

    public static void animate(AnimatedModel model, float animationProgress, MathAnimator builder) {
        float animTime = animationProgress / 20.0f;
        Vector3f vector = new Vector3f();
        for (Map.Entry<String, List<AnimatedChannel>> animation : builder.animationsByBone().entrySet()) {
            Optional<class_630> entry = model.getAnyDescendantWithName(animation.getKey());
            if (entry.isEmpty()) continue;
            class_630 part = entry.get();
            List<AnimatedChannel> channels = animation.getValue();
            for (AnimatedChannel channel : channels) {
                for (AnimatedPoint point : channel.targets()) {
                    vector.set(point.getX(animTime), point.getY(animTime), point.getZ(animTime));
                    point.target().apply(part, vector);
                }
            }
        }
    }

    public static class Builder {
        private final Map<String, List<AnimatedChannel>> animationByBone = Maps.newHashMap();

        public Builder addAnimation(String bone, AnimatedChannel animation) {
            this.animationByBone.computeIfAbsent(bone, key -> new ArrayList()).add(animation);
            return this;
        }

        public MathAnimator build() {
            HashMap map = new HashMap();
            this.animationByBone.forEach((key, channels) -> map.put(key, List.copyOf(channels)));
            return new MathAnimator(Map.copyOf(map));
        }
    }
}

