/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_4148
 *  net.minecraft.class_4149
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.foundation.access;

import java.util.function.Supplier;
import net.minecraft.class_4148;
import net.minecraft.class_4149;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={class_4149.class})
public interface SensorTypeAccessor {
    @Invoker(value="<init>")
    public static <T extends class_4148<?>> class_4149<T> createSensorType(Supplier<T> supplier) {
        throw new AssertionError();
    }
}

