/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_7179$class_7182
 *  org.joml.Vector3f
 */
package backported.updates.foundation.client.animator;

import java.util.function.Function;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_7179;
import org.joml.Vector3f;

@Environment(value=EnvType.CLIENT)
public class AnimatedPoint {
    private final class_7179.class_7182 target;
    private final Function<Float, Float> x;
    private final Function<Float, Float> y;
    private final Function<Float, Float> z;

    public AnimatedPoint(class_7179.class_7182 target, Function<Float, Float> x, Function<Float, Float> y, Function<Float, Float> z) {
        this.target = target;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public AnimatedPoint(class_7179.class_7182 target, Function<Float, Vector3f> vector) {
        this(target, ticks -> Float.valueOf(((Vector3f)vector.apply((Float)ticks)).x()), ticks -> Float.valueOf(((Vector3f)vector.apply((Float)ticks)).y()), ticks -> Float.valueOf(((Vector3f)vector.apply((Float)ticks)).z()));
    }

    public class_7179.class_7182 target() {
        return this.target;
    }

    public float getX(float ticks) {
        return this.x.apply(Float.valueOf(ticks)).floatValue();
    }

    public float getY(float ticks) {
        return this.y.apply(Float.valueOf(ticks)).floatValue();
    }

    public float getZ(float ticks) {
        return this.z.apply(Float.valueOf(ticks)).floatValue();
    }
}

