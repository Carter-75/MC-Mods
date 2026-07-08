/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_4049
 *  net.minecraft.class_1311
 *  net.minecraft.class_4048
 */
package tech.alexnijjar.golemoverhaul.common.registry.fabric;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_4048;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class ModEntityTypesImpl {
    public static <T extends class_1297> ModEntityTypes.PlatformEntityBuilder<T> createEntityBuilder(class_1299.class_4049<T> factory, class_1311 category) {
        return new FabricEntityBuilder(FabricEntityTypeBuilder.create((class_1311)category, factory));
    }

    private record FabricEntityBuilder<T extends class_1297>(FabricEntityTypeBuilder<T> builder) implements ModEntityTypes.PlatformEntityBuilder<T>
    {
        @Override
        public ModEntityTypes.PlatformEntityBuilder<T> sized(float width, float height) {
            this.builder.dimensions(class_4048.method_18384((float)width, (float)height));
            return this;
        }

        @Override
        public ModEntityTypes.PlatformEntityBuilder<T> clientTrackingRange(int range) {
            this.builder.trackRangeChunks(range);
            return this;
        }

        @Override
        public ModEntityTypes.PlatformEntityBuilder<T> updateInterval(int interval) {
            this.builder.trackedUpdateRate(interval);
            return this;
        }

        @Override
        public ModEntityTypes.PlatformEntityBuilder<T> fireImmune() {
            this.builder.fireImmune();
            return this;
        }

        @Override
        public class_1299<T> build(String id) {
            return this.builder.build();
        }
    }
}

