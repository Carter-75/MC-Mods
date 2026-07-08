/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  dev.engine_room.flywheel.api.visualization.BlockEntityVisualizer
 *  dev.engine_room.flywheel.api.visualization.EntityVisualizer
 *  dev.engine_room.flywheel.api.visualization.VisualizerRegistry
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.mod_compat.flywheel;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import dev.engine_room.flywheel.api.visualization.BlockEntityVisualizer;
import dev.engine_room.flywheel.api.visualization.EntityVisualizer;
import dev.engine_room.flywheel.api.visualization.VisualizerRegistry;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.mod.compat.flywheel.BlockEntityVisualizerDecorator;
import org.valkyrienskies.mod.compat.flywheel.EntityVisualizerDecorator;

@Mixin(value={VisualizerRegistry.class})
public abstract class MixinVisualizerRegistry {
    @WrapMethod(method={"setVisualizer(Lnet/minecraft/world/entity/EntityType;Ldev/engine_room/flywheel/api/visualization/EntityVisualizer;)V"})
    private static <T extends class_1297> void decorateEntityVisualizer(class_1299<T> type, @Nullable EntityVisualizer<? super T> visualizer, Operation<Void> original) {
        if (visualizer != null) {
            original.call(new Object[]{type, new EntityVisualizerDecorator<T>(visualizer)});
        } else {
            original.call(new Object[]{type, visualizer});
        }
    }

    @WrapMethod(method={"setVisualizer(Lnet/minecraft/world/level/block/entity/BlockEntityType;Ldev/engine_room/flywheel/api/visualization/BlockEntityVisualizer;)V"})
    private static <T extends class_2586> void decorateBlockEntityVisualizer(class_2591<T> type, @Nullable BlockEntityVisualizer<? super T> visualizer, Operation<Void> original) {
        if (visualizer != null) {
            original.call(new Object[]{type, new BlockEntityVisualizerDecorator<T>(visualizer)});
        } else {
            original.call(new Object[]{type, visualizer});
        }
    }
}

