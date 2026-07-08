/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.module.kotlin.KotlinSerializersKt;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0012B\u001f\b\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ValueClassStaticJsonValueSerializer;", "T", "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "value", "Lcom/fasterxml/jackson/core/JsonGenerator;", "gen", "Lcom/fasterxml/jackson/databind/SerializerProvider;", "provider", "", "serialize", "(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V", "Ljava/lang/reflect/Method;", "staticJsonValueGetter", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "innerClazz", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Method;)V", "Companion", "jackson-module-kotlin"})
public final class ValueClassStaticJsonValueSerializer<T>
extends StdSerializer<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Method staticJsonValueGetter;

    private ValueClassStaticJsonValueSerializer(Class<T> innerClazz, Method staticJsonValueGetter) {
        super(innerClazz);
        this.staticJsonValueGetter = staticJsonValueGetter;
    }

    @Override
    public void serialize(@Nullable T value, @NotNull JsonGenerator gen, @NotNull SerializerProvider provider) {
        block2: {
            Object[] objectArray;
            Object jsonValue;
            Intrinsics.checkNotNullParameter((Object)gen, (String)"gen");
            Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
            Object[] objectArray2 = new Object[]{value};
            Object object = jsonValue = this.staticJsonValueGetter.invoke(null, objectArray2);
            if (object == null) {
                objectArray = null;
            } else {
                Object object2 = object;
                boolean bl = false;
                boolean bl2 = false;
                Object it = object2;
                boolean bl3 = false;
                provider.findValueSerializer(it.getClass()).serialize(it, gen, provider);
                objectArray = objectArray2 = Unit.INSTANCE;
            }
            if (objectArray2 != null) break block2;
            provider.findNullValueSerializer(null).serialize(null, gen, provider);
        }
    }

    public /* synthetic */ ValueClassStaticJsonValueSerializer(Class innerClazz, Method staticJsonValueGetter, DefaultConstructorMarker $constructor_marker) {
        this(innerClazz, staticJsonValueGetter);
    }

    @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ9\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0001\u0010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ValueClassStaticJsonValueSerializer$Companion;", "", "T", "Ljava/lang/Class;", "outerClazz", "innerClazz", "Lcom/fasterxml/jackson/module/kotlin/ValueClassStaticJsonValueSerializer;", "createdOrNull", "(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/module/kotlin/ValueClassStaticJsonValueSerializer;", "<init>", "()V", "jackson-module-kotlin"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final <T> ValueClassStaticJsonValueSerializer<T> createdOrNull(@NotNull Class<? extends Object> outerClazz, @NotNull Class<T> innerClazz) {
            ValueClassStaticJsonValueSerializer valueClassStaticJsonValueSerializer;
            Intrinsics.checkNotNullParameter(outerClazz, (String)"outerClazz");
            Intrinsics.checkNotNullParameter(innerClazz, (String)"innerClazz");
            Method method = KotlinSerializersKt.access$getStaticJsonValueGetter(outerClazz);
            if (method == null) {
                valueClassStaticJsonValueSerializer = null;
            } else {
                Method method2 = method;
                boolean bl = false;
                boolean bl2 = false;
                Method it = method2;
                boolean bl3 = false;
                valueClassStaticJsonValueSerializer = new ValueClassStaticJsonValueSerializer(innerClazz, it, null);
            }
            return valueClassStaticJsonValueSerializer;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

