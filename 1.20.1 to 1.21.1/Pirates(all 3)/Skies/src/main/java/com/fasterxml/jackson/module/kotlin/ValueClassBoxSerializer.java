/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ValueClassBoxSerializer;", "", "T", "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "value", "Lcom/fasterxml/jackson/core/JsonGenerator;", "gen", "Lcom/fasterxml/jackson/databind/SerializerProvider;", "provider", "", "serialize", "(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "boxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "outerClazz", "Ljava/lang/Class;", "innerClazz", "<init>", "(Ljava/lang/Class;Ljava/lang/Class;)V", "jackson-module-kotlin"})
public final class ValueClassBoxSerializer<T>
extends StdSerializer<T> {
    @NotNull
    private final Class<? extends Object> outerClazz;
    private final Method boxMethod;

    public ValueClassBoxSerializer(@NotNull Class<? extends Object> outerClazz, @NotNull Class<T> innerClazz) {
        Intrinsics.checkNotNullParameter(outerClazz, (String)"outerClazz");
        Intrinsics.checkNotNullParameter(innerClazz, (String)"innerClazz");
        super(innerClazz);
        this.outerClazz = outerClazz;
        Class[] classArray = new Class[]{innerClazz};
        this.boxMethod = this.outerClazz.getMethod("box-impl", classArray);
    }

    @Override
    public void serialize(@Nullable T value, @NotNull JsonGenerator gen, @NotNull SerializerProvider provider) {
        Intrinsics.checkNotNullParameter((Object)gen, (String)"gen");
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        Object[] objectArray = new Object[]{value};
        Object boxed = this.boxMethod.invoke(null, objectArray);
        provider.findValueSerializer(this.outerClazz).serialize(boxed, gen, provider);
    }
}

