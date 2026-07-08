/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_2940
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.util.entity;

import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_2940;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0001H\u0086\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0012"}, d2={"Ldev/mim1q/derelict/util/entity/OptionalTrackedDataDelegate;", "", "T", "Lnet/minecraft/class_2940;", "Ljava/util/Optional;", "data", "<init>", "(Lnet/minecraft/class_2940;)V", "Lnet/minecraft/class_1297;", "entity", "property", "getValue", "(Lnet/minecraft/class_1297;Ljava/lang/Object;)Ljava/lang/Object;", "value", "", "setValue", "(Lnet/minecraft/class_1297;Ljava/lang/Object;Ljava/lang/Object;)V", "Lnet/minecraft/class_2940;", "derelict"})
public final class OptionalTrackedDataDelegate<T> {
    @NotNull
    private final class_2940<Optional<T>> data;

    public OptionalTrackedDataDelegate(@NotNull class_2940<Optional<T>> data) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        this.data = data;
    }

    @Nullable
    public final T getValue(@NotNull class_1297 entity, @NotNull Object property) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)property, (String)"property");
        return ((Optional)entity.method_5841().method_12789(this.data)).orElse(null);
    }

    public final void setValue(@NotNull class_1297 entity, @NotNull Object property, @Nullable T value) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)property, (String)"property");
        entity.method_5841().method_12778(this.data, Optional.ofNullable(value));
    }
}

