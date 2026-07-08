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
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.module.kotlin.UByteKeyDeserializer;
import com.fasterxml.jackson.module.kotlin.UIntKeyDeserializer;
import com.fasterxml.jackson.module.kotlin.ULongKeyDeserializer;
import com.fasterxml.jackson.module.kotlin.UShortKeyDeserializer;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinKeyDeserializers;", "Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializers;", "Lcom/fasterxml/jackson/databind/JavaType;", "type", "Lcom/fasterxml/jackson/databind/DeserializationConfig;", "config", "Lcom/fasterxml/jackson/databind/BeanDescription;", "beanDesc", "Lcom/fasterxml/jackson/databind/KeyDeserializer;", "findKeyDeserializer", "(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;)Lcom/fasterxml/jackson/databind/KeyDeserializer;", "<init>", "()V", "jackson-module-kotlin"})
public final class KotlinKeyDeserializers
extends StdKeyDeserializers {
    @NotNull
    public static final KotlinKeyDeserializers INSTANCE = new KotlinKeyDeserializers();

    private KotlinKeyDeserializers() {
    }

    @Override
    @Nullable
    public KeyDeserializer findKeyDeserializer(@NotNull JavaType type, @Nullable DeserializationConfig config, @Nullable BeanDescription beanDesc) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Class<?> clazz = type.getRawClass();
        return Intrinsics.areEqual(clazz, UByte.class) ? (KeyDeserializer)UByteKeyDeserializer.INSTANCE : (Intrinsics.areEqual(clazz, UShort.class) ? (KeyDeserializer)UShortKeyDeserializer.INSTANCE : (Intrinsics.areEqual(clazz, UInt.class) ? (KeyDeserializer)UIntKeyDeserializer.INSTANCE : (Intrinsics.areEqual(clazz, ULong.class) ? (KeyDeserializer)ULongKeyDeserializer.INSTANCE : null)));
    }
}

