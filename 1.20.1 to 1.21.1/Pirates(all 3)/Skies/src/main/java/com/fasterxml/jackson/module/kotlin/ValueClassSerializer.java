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
import com.fasterxml.jackson.module.kotlin.ValueClassUnboxSerializer;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \b*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\b\tB\u0017\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\n\u00a8\u0006\u000b"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer;", "", "T", "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "Ljava/lang/Class;", "t", "<init>", "(Ljava/lang/Class;)V", "Companion", "StaticJsonValue", "Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer$StaticJsonValue;", "jackson-module-kotlin"})
public abstract class ValueClassSerializer<T>
extends StdSerializer<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    private ValueClassSerializer(Class<T> t) {
        super(t);
    }

    public /* synthetic */ ValueClassSerializer(Class t, DefaultConstructorMarker $constructor_marker) {
        this(t);
    }

    @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u001d\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0014"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer$StaticJsonValue;", "", "T", "Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer;", "value", "Lcom/fasterxml/jackson/core/JsonGenerator;", "gen", "Lcom/fasterxml/jackson/databind/SerializerProvider;", "provider", "", "serialize", "(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V", "Ljava/lang/reflect/Method;", "staticJsonValueGetter", "Ljava/lang/reflect/Method;", "unboxMethod", "Ljava/lang/Class;", "t", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Method;)V", "jackson-module-kotlin"})
    public static final class StaticJsonValue<T>
    extends ValueClassSerializer<T> {
        @NotNull
        private final Method staticJsonValueGetter;
        @NotNull
        private final Method unboxMethod;

        public StaticJsonValue(@NotNull Class<T> t, @NotNull Method staticJsonValueGetter) {
            Intrinsics.checkNotNullParameter(t, (String)"t");
            Intrinsics.checkNotNullParameter((Object)staticJsonValueGetter, (String)"staticJsonValueGetter");
            super(t, null);
            this.staticJsonValueGetter = staticJsonValueGetter;
            Method method = t.getMethod("unbox-impl", new Class[0]);
            Intrinsics.checkNotNullExpressionValue((Object)method, (String)"t.getMethod(\"unbox-impl\")");
            this.unboxMethod = method;
        }

        @Override
        public void serialize(@NotNull T value, @NotNull JsonGenerator gen, @NotNull SerializerProvider provider) {
            block2: {
                Object[] objectArray;
                Object jsonValue;
                Intrinsics.checkNotNullParameter(value, (String)"value");
                Intrinsics.checkNotNullParameter((Object)gen, (String)"gen");
                Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
                Object unboxed = this.unboxMethod.invoke(value, new Object[0]);
                Object[] objectArray2 = new Object[]{unboxed};
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
    }

    @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer$Companion;", "", "Ljava/lang/Class;", "t", "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "from", "(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "<init>", "()V", "jackson-module-kotlin"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final StdSerializer<?> from(@NotNull Class<?> t) {
            StaticJsonValue staticJsonValue;
            Intrinsics.checkNotNullParameter(t, (String)"t");
            Method method = KotlinSerializersKt.access$getStaticJsonValueGetter(t);
            if (method == null) {
                staticJsonValue = null;
            } else {
                Method method2 = method;
                boolean bl = false;
                boolean bl2 = false;
                Method it = method2;
                boolean bl3 = false;
                staticJsonValue = new StaticJsonValue(t, it);
            }
            StaticJsonValue staticJsonValue2 = staticJsonValue;
            return staticJsonValue2 == null ? (StdSerializer)ValueClassUnboxSerializer.INSTANCE : (StdSerializer)staticJsonValue2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

