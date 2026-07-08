/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.fasterxml.jackson.module.kotlin.ValueClassUnboxKeySerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ-\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinKeySerializers;", "Lcom/fasterxml/jackson/databind/ser/Serializers$Base;", "Lcom/fasterxml/jackson/databind/SerializationConfig;", "config", "Lcom/fasterxml/jackson/databind/JavaType;", "type", "Lcom/fasterxml/jackson/databind/BeanDescription;", "beanDesc", "Lcom/fasterxml/jackson/databind/JsonSerializer;", "findSerializer", "(Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonSerializer;", "<init>", "()V", "jackson-module-kotlin"})
public final class KotlinKeySerializers
extends Serializers.Base {
    @Override
    @Nullable
    public JsonSerializer<?> findSerializer(@NotNull SerializationConfig config, @NotNull JavaType type, @NotNull BeanDescription beanDesc) {
        Intrinsics.checkNotNullParameter((Object)config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)beanDesc, (String)"beanDesc");
        Class<?> clazz = type.getRawClass();
        Intrinsics.checkNotNullExpressionValue(clazz, (String)"type.rawClass");
        return ExtensionsKt.isUnboxableValueClass(clazz) ? (JsonSerializer)ValueClassUnboxKeySerializer.INSTANCE : null;
    }
}

