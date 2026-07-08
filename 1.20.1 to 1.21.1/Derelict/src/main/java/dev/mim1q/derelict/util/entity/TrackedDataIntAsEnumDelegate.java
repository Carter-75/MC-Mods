/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_2940
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util.entity;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_2940;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B#\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015\u00a8\u0006\u0016"}, d2={"Ldev/mim1q/derelict/util/entity/TrackedDataIntAsEnumDelegate;", "", "T", "", "Lnet/minecraft/class_2940;", "", "data", "", "values", "<init>", "(Lnet/minecraft/class_2940;[Ljava/lang/Enum;)V", "Lnet/minecraft/class_1297;", "entity", "property", "getValue", "(Lnet/minecraft/class_1297;Ljava/lang/Object;)Ljava/lang/Enum;", "value", "", "setValue", "(Lnet/minecraft/class_1297;Ljava/lang/Object;Ljava/lang/Enum;)V", "Lnet/minecraft/class_2940;", "[Ljava/lang/Enum;", "derelict"})
@SourceDebugExtension(value={"SMAP\nEntityUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityUtil.kt\ndev/mim1q/derelict/util/entity/TrackedDataIntAsEnumDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,28:1\n1#2:29\n*E\n"})
public final class TrackedDataIntAsEnumDelegate<T extends Enum<T>> {
    @NotNull
    private final class_2940<Integer> data;
    @NotNull
    private final T[] values;

    public TrackedDataIntAsEnumDelegate(@NotNull class_2940<Integer> data, @NotNull T[] values) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        Intrinsics.checkNotNullParameter(values, (String)"values");
        this.data = data;
        this.values = values;
    }

    @NotNull
    public final T getValue(@NotNull class_1297 entity, @NotNull Object property) {
        T t;
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)property, (String)"property");
        T[] TArray = this.values;
        Object object = entity.method_5841().method_12789(this.data);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        int n = ((Number)object).intValue();
        boolean bl = 0 <= n ? n < TArray.length : false;
        if (bl) {
            t = TArray[n];
        } else {
            int it = n;
            boolean bl2 = false;
            t = this.values[0];
        }
        return t;
    }

    public final void setValue(@NotNull class_1297 entity, @NotNull Object property, @NotNull T value) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)property, (String)"property");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        entity.method_5841().method_12778(this.data, (Object)ArraysKt.indexOf((Object[])this.values, value));
    }
}

