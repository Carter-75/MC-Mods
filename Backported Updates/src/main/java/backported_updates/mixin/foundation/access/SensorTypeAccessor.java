/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.ai.brain.sensor.Sensor
 *  net.minecraft.entity.ai.brain.sensor.SensorType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.access;

import java.util.function.Supplier;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={SensorType.class})
public interface SensorTypeAccessor {
    @Invoker(value="<init>")
    public static <T extends Sensor<?>> SensorType<T> createSensorType(Supplier<T> supplier) {
        throw new AssertionError();
    }
}

