/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty
 *  net.minecraft.class_1297
 *  net.minecraft.class_2940
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import net.minecraft.class_1297;
import net.minecraft.class_2940;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\nJ(\u0010\r\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0086\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\u000f\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/mod/util/EntityDataDelegate;", "T", "", "Lnet/minecraft/class_1297;", "thisRef", "get", "(Lnet/minecraft/class_1297;)Ljava/lang/Object;", "value", "", "set", "(Lnet/minecraft/class_1297;Ljava/lang/Object;)V", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Lnet/minecraft/class_1297;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Lnet/minecraft/class_1297;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Lnet/minecraft/class_2940;", "data", "Lnet/minecraft/class_2940;", "getData", "()Lnet/minecraft/class_2940;", "<init>", "(Lnet/minecraft/class_2940;)V", "valkyrienskies-120"})
public final class EntityDataDelegate<T> {
    @NotNull
    private final class_2940<T> data;

    public EntityDataDelegate(@NotNull class_2940<T> data) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        this.data = data;
    }

    @NotNull
    public final class_2940<T> getData() {
        return this.data;
    }

    @Nullable
    public final T get(@Nullable class_1297 thisRef) {
        class_1297 class_12972 = thisRef;
        return (T)(class_12972 != null && (class_12972 = class_12972.method_5841()) != null ? class_12972.method_12789(this.data) : null);
    }

    public final void set(@Nullable class_1297 thisRef, T value) {
        block0: {
            class_1297 class_12972 = thisRef;
            if (class_12972 == null || (class_12972 = class_12972.method_5841()) == null) break block0;
            class_12972.method_12778(this.data, value);
        }
    }

    @Nullable
    public final T getValue(@Nullable class_1297 thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, (String)"property");
        class_1297 class_12972 = thisRef;
        return (T)(class_12972 != null && (class_12972 = class_12972.method_5841()) != null ? class_12972.method_12789(this.data) : null);
    }

    public final void setValue(@Nullable class_1297 thisRef, @NotNull KProperty<?> property, T value) {
        block0: {
            Intrinsics.checkNotNullParameter(property, (String)"property");
            class_1297 class_12972 = thisRef;
            if (class_12972 == null || (class_12972 = class_12972.method_5841()) == null) break block0;
            class_12972.method_12778(this.data, value);
        }
    }
}

