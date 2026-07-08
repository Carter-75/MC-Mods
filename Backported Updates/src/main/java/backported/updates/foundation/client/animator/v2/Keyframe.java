/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  org.joml.Vector3f
 */
package backported.updates.foundation.client.animator.v2;

import backported.updates.foundation.client.animator.v2.AnimationChannel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Vector3f;

@Environment(value=EnvType.CLIENT)
public record Keyframe(float timestamp, AnimationChannel.Value target, AnimationChannel.Interpolation interpolation) {
    public Keyframe(AnimationChannel.Value target) {
        this(0.0f, target, AnimationChannel.Interpolations.LINEAR);
    }

    public Keyframe(float timestamp, Vector3f target, AnimationChannel.Interpolation interpolation) {
        this(timestamp, (AnimationChannel.Query query) -> target, interpolation);
    }

    public Keyframe(Vector3f target) {
        this(0.0f, target, AnimationChannel.Interpolations.LINEAR);
    }
}

