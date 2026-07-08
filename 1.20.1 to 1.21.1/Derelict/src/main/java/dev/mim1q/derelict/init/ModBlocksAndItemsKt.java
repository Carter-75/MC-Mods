/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.mixin.object.builder.AbstractBlockSettingsAccessor
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init;

import dev.mim1q.derelict.init.NoZFightingOffsetter;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.mixin.object.builder.AbstractBlockSettingsAccessor;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0002\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/minecraft/class_4970$class_2251;", "T", "noZFighting", "(Lnet/minecraft/class_4970$class_2251;)Lnet/minecraft/class_4970$class_2251;", "derelict"})
public final class ModBlocksAndItemsKt {
    @NotNull
    public static final <T extends class_4970.class_2251> T noZFighting(@NotNull T $this$noZFighting) {
        Intrinsics.checkNotNullParameter($this$noZFighting, (String)"<this>");
        ((AbstractBlockSettingsAccessor)$this$noZFighting).setOffsetter(Optional.of(NoZFightingOffsetter.INSTANCE));
        ((AbstractBlockSettingsAccessor)$this$noZFighting).setDynamicBounds(true);
        return $this$noZFighting;
    }
}

