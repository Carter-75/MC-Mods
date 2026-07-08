/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_2940
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_2940;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0086\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010\u00a8\u0006\u0011"}, d2={"Ldev/mim1q/derelict/util/entity/TrackedDataDelegate;", "T", "", "Lnet/minecraft/class_2940;", "data", "<init>", "(Lnet/minecraft/class_2940;)V", "Lnet/minecraft/class_1297;", "entity", "property", "getValue", "(Lnet/minecraft/class_1297;Ljava/lang/Object;)Ljava/lang/Object;", "value", "", "setValue", "(Lnet/minecraft/class_1297;Ljava/lang/Object;Ljava/lang/Object;)V", "Lnet/minecraft/class_2940;", "derelict"})
public final class TrackedDataDelegate<T> {
    @NotNull
    private final class_2940<T> data;

    public TrackedDataDelegate(@NotNull class_2940<T> data) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        this.data = data;
    }

    public final T getValue(@NotNull class_1297 entity, @NotNull Object property) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)property, (String)"property");
        return (T)entity.method_5841().method_12789(this.data);
    }

    public final void setValue(@NotNull class_1297 entity, @NotNull Object property, T value) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)property, (String)"property");
        entity.method_5841().method_12778(this.data, value);
    }
}

