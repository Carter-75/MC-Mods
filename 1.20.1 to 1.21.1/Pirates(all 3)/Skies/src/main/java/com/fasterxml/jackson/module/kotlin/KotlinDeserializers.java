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
 *  kotlin.text.Regex
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.module.kotlin.RegexDeserializer;
import com.fasterxml.jackson.module.kotlin.SequenceDeserializer;
import com.fasterxml.jackson.module.kotlin.UByteDeserializer;
import com.fasterxml.jackson.module.kotlin.UIntDeserializer;
import com.fasterxml.jackson.module.kotlin.ULongDeserializer;
import com.fasterxml.jackson.module.kotlin.UShortDeserializer;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ1\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinDeserializers;", "Lcom/fasterxml/jackson/databind/deser/Deserializers$Base;", "Lcom/fasterxml/jackson/databind/JavaType;", "type", "Lcom/fasterxml/jackson/databind/DeserializationConfig;", "config", "Lcom/fasterxml/jackson/databind/BeanDescription;", "beanDesc", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "findBeanDeserializer", "(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/JsonDeserializer;", "<init>", "()V", "jackson-module-kotlin"})
public final class KotlinDeserializers
extends Deserializers.Base {
    @Override
    @Nullable
    public JsonDeserializer<?> findBeanDeserializer(@NotNull JavaType type, @Nullable DeserializationConfig config, @Nullable BeanDescription beanDesc) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return type.isInterface() && Intrinsics.areEqual(type.getRawClass(), Sequence.class) ? (JsonDeserializer)SequenceDeserializer.INSTANCE : (Intrinsics.areEqual(type.getRawClass(), Regex.class) ? (JsonDeserializer)RegexDeserializer.INSTANCE : (Intrinsics.areEqual(type.getRawClass(), UByte.class) ? (JsonDeserializer)UByteDeserializer.INSTANCE : (Intrinsics.areEqual(type.getRawClass(), UShort.class) ? (JsonDeserializer)UShortDeserializer.INSTANCE : (Intrinsics.areEqual(type.getRawClass(), UInt.class) ? (JsonDeserializer)UIntDeserializer.INSTANCE : (Intrinsics.areEqual(type.getRawClass(), ULong.class) ? (JsonDeserializer)ULongDeserializer.INSTANCE : null)))));
    }
}

