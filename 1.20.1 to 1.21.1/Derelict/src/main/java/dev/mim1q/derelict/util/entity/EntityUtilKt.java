/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2940
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util.entity;

import dev.mim1q.derelict.util.entity.OptionalTrackedDataDelegate;
import dev.mim1q.derelict.util.entity.TrackedDataDelegate;
import dev.mim1q.derelict.util.entity.TrackedDataIntAsEnumDelegate;
import java.util.Collection;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2940;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0000*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0001\u00a2\u0006\u0004\b\t\u0010\n\u001aD\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0010\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\f0\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086\b\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"T", "Lnet/minecraft/class_2940;", "data", "Ldev/mim1q/derelict/util/entity/TrackedDataDelegate;", "tracked", "(Lnet/minecraft/class_2940;)Ldev/mim1q/derelict/util/entity/TrackedDataDelegate;", "", "Ljava/util/Optional;", "Ldev/mim1q/derelict/util/entity/OptionalTrackedDataDelegate;", "nullableTracked", "(Lnet/minecraft/class_2940;)Ldev/mim1q/derelict/util/entity/OptionalTrackedDataDelegate;", "", "", "Lkotlin/enums/EnumEntries;", "values", "Ldev/mim1q/derelict/util/entity/TrackedDataIntAsEnumDelegate;", "trackedEnum", "(Lnet/minecraft/class_2940;Lkotlin/enums/EnumEntries;)Ldev/mim1q/derelict/util/entity/TrackedDataIntAsEnumDelegate;", "derelict"})
@SourceDebugExtension(value={"SMAP\nEntityUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityUtil.kt\ndev/mim1q/derelict/util/entity/EntityUtilKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,28:1\n37#2,2:29\n*S KotlinDebug\n*F\n+ 1 EntityUtil.kt\ndev/mim1q/derelict/util/entity/EntityUtilKt\n*L\n28#1:29,2\n*E\n"})
public final class EntityUtilKt {
    @NotNull
    public static final <T> TrackedDataDelegate<T> tracked(@NotNull class_2940<T> data) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        return new TrackedDataDelegate<T>(data);
    }

    @NotNull
    public static final <T> OptionalTrackedDataDelegate<T> nullableTracked(@NotNull class_2940<Optional<T>> data) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        return new OptionalTrackedDataDelegate<T>(data);
    }

    public static final /* synthetic */ <T extends Enum<T>> TrackedDataIntAsEnumDelegate<T> trackedEnum(class_2940<Integer> data, EnumEntries<T> values) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        Intrinsics.checkNotNullParameter(values, (String)"values");
        boolean $i$f$trackedEnum = false;
        Collection $this$toTypedArray$iv = (Collection)values;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
        return new TrackedDataIntAsEnumDelegate(data, (Enum[])thisCollection$iv.toArray(new Object[0]));
    }
}

