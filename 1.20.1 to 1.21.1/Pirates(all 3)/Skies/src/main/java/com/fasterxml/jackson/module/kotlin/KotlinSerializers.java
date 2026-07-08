/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UInt
 *  kotlin.ULong
 *  kotlin.UShort
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.fasterxml.jackson.module.kotlin.SequenceSerializer;
import com.fasterxml.jackson.module.kotlin.UByteSerializer;
import com.fasterxml.jackson.module.kotlin.UIntSerializer;
import com.fasterxml.jackson.module.kotlin.ULongSerializer;
import com.fasterxml.jackson.module.kotlin.UShortSerializer;
import com.fasterxml.jackson.module.kotlin.ValueClassSerializer;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ1\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinSerializers;", "Lcom/fasterxml/jackson/databind/ser/Serializers$Base;", "Lcom/fasterxml/jackson/databind/SerializationConfig;", "config", "Lcom/fasterxml/jackson/databind/JavaType;", "type", "Lcom/fasterxml/jackson/databind/BeanDescription;", "beanDesc", "Lcom/fasterxml/jackson/databind/JsonSerializer;", "findSerializer", "(Lcom/fasterxml/jackson/databind/SerializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonSerializer;", "<init>", "()V", "jackson-module-kotlin"})
public final class KotlinSerializers
extends Serializers.Base {
    @Override
    @Nullable
    public JsonSerializer<?> findSerializer(@Nullable SerializationConfig config, @NotNull JavaType type, @Nullable BeanDescription beanDesc) {
        JsonSerializer jsonSerializer;
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Class<?> rawClass = type.getRawClass();
        if (Sequence.class.isAssignableFrom(rawClass)) {
            jsonSerializer = SequenceSerializer.INSTANCE;
        } else if (UByte.class.isAssignableFrom(rawClass)) {
            jsonSerializer = UByteSerializer.INSTANCE;
        } else if (UShort.class.isAssignableFrom(rawClass)) {
            jsonSerializer = UShortSerializer.INSTANCE;
        } else if (UInt.class.isAssignableFrom(rawClass)) {
            jsonSerializer = UIntSerializer.INSTANCE;
        } else if (ULong.class.isAssignableFrom(rawClass)) {
            jsonSerializer = ULongSerializer.INSTANCE;
        } else {
            Intrinsics.checkNotNullExpressionValue(rawClass, (String)"rawClass");
            jsonSerializer = ExtensionsKt.isUnboxableValueClass(rawClass) ? (JsonSerializer)ValueClassSerializer.Companion.from(rawClass) : null;
        }
        return jsonSerializer;
    }
}

