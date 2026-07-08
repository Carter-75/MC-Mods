/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2945
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2945;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.util.EntityDataDelegate;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a>\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00018\u00018\u00010\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\b\u00a2\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/minecraft/class_1297;", "T", "R", "Lnet/minecraft/class_2941;", "serializer", "Lorg/valkyrienskies/mod/util/EntityDataDelegate;", "kotlin.jvm.PlatformType", "defineSynced", "(Lnet/minecraft/class_2941;)Lorg/valkyrienskies/mod/util/EntityDataDelegate;", "property", "default", "", "registerSynced", "(Lnet/minecraft/class_1297;Lorg/valkyrienskies/mod/util/EntityDataDelegate;Ljava/lang/Object;)V", "valkyrienskies-120"})
public final class EntityDataKt {
    public static final /* synthetic */ <T extends class_1297, R> EntityDataDelegate<R> defineSynced(class_2941<R> serializer) {
        Intrinsics.checkNotNullParameter(serializer, (String)"serializer");
        boolean $i$f$defineSynced = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        class_2940 class_29402 = class_2945.method_12791(class_1297.class, serializer);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"defineId(...)");
        return new EntityDataDelegate(class_29402);
    }

    public static final <T> void registerSynced(@NotNull class_1297 $this$registerSynced, @NotNull EntityDataDelegate<T> property, T t) {
        Intrinsics.checkNotNullParameter((Object)$this$registerSynced, (String)"<this>");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        $this$registerSynced.method_5841().method_12784(property.getData(), t);
    }
}

