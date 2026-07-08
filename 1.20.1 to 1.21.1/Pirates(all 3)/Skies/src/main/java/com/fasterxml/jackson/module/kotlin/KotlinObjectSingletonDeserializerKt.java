/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.module.kotlin.KotlinObjectSingletonDeserializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=2, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lcom/fasterxml/jackson/databind/JsonDeserializer;", "", "singleton", "Lcom/fasterxml/jackson/module/kotlin/KotlinObjectSingletonDeserializer;", "asSingletonDeserializer", "(Lcom/fasterxml/jackson/databind/JsonDeserializer;Ljava/lang/Object;)Lcom/fasterxml/jackson/module/kotlin/KotlinObjectSingletonDeserializer;", "jackson-module-kotlin"})
public final class KotlinObjectSingletonDeserializerKt {
    @NotNull
    public static final KotlinObjectSingletonDeserializer asSingletonDeserializer(@NotNull JsonDeserializer<?> $this$asSingletonDeserializer, @NotNull Object singleton) {
        Intrinsics.checkNotNullParameter($this$asSingletonDeserializer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)singleton, (String)"singleton");
        return new KotlinObjectSingletonDeserializer(singleton, $this$asSingletonDeserializer);
    }
}

