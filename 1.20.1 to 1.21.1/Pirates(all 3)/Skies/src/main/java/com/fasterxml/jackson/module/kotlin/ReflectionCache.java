/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.jvm.ReflectJvmMapping
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.module.kotlin.ConstructorValueCreator;
import com.fasterxml.jackson.module.kotlin.MethodValueCreator;
import com.fasterxml.jackson.module.kotlin.ValueCreator;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.ReflectJvmMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J)\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ)\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ-\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\f2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013\u00a2\u0006\u0004\b\u0011\u0010\u0015J\u001b\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0017J\u001b\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001b\u0010\u001cR,\u0010\u001e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00100\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR,\u0010!\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR*\u0010#\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\"\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010$0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001fR$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001fR$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001fR \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001f\u00a8\u0006."}, d2={"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;", "key", "Lkotlin/Function1;", "", "calc", "checkConstructorIsCreatorAnnotated", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;Lkotlin/jvm/functions/Function1;)Z", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;", "isKotlinGeneratedMethod", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;Lkotlin/jvm/functions/Function1;)Z", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;", "javaMemberIsRequired", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "Ljava/lang/Class;", "Lkotlin/reflect/KClass;", "kotlinFromJava", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;", "_withArgsCreator", "Lcom/fasterxml/jackson/module/kotlin/ValueCreator;", "valueCreatorFromJava", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;)Lcom/fasterxml/jackson/module/kotlin/ValueCreator;", "Lcom/fasterxml/jackson/databind/util/LRUMap;", "javaClassToKotlin", "Lcom/fasterxml/jackson/databind/util/LRUMap;", "javaConstructorIsCreatorAnnotated", "javaConstructorToKotlin", "Lcom/fasterxml/jackson/module/kotlin/ConstructorValueCreator;", "javaConstructorToValueCreator", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "javaMethodToKotlin", "Lcom/fasterxml/jackson/module/kotlin/MethodValueCreator;", "javaMethodToValueCreator", "kotlinGeneratedMethod", "", "reflectionCacheSize", "<init>", "(I)V", "BooleanTriState", "jackson-module-kotlin"})
public final class ReflectionCache {
    @NotNull
    private final LRUMap<Class<Object>, KClass<Object>> javaClassToKotlin;
    @NotNull
    private final LRUMap<Constructor<Object>, KFunction<Object>> javaConstructorToKotlin;
    @NotNull
    private final LRUMap<Method, KFunction<?>> javaMethodToKotlin;
    @NotNull
    private final LRUMap<Constructor<Object>, ConstructorValueCreator<?>> javaConstructorToValueCreator;
    @NotNull
    private final LRUMap<Method, MethodValueCreator<?>> javaMethodToValueCreator;
    @NotNull
    private final LRUMap<AnnotatedConstructor, Boolean> javaConstructorIsCreatorAnnotated;
    @NotNull
    private final LRUMap<AnnotatedMember, BooleanTriState> javaMemberIsRequired;
    @NotNull
    private final LRUMap<AnnotatedMethod, Boolean> kotlinGeneratedMethod;

    public ReflectionCache(int reflectionCacheSize) {
        this.javaClassToKotlin = new LRUMap(reflectionCacheSize, reflectionCacheSize);
        this.javaConstructorToKotlin = new LRUMap(reflectionCacheSize, reflectionCacheSize);
        this.javaMethodToKotlin = new LRUMap(reflectionCacheSize, reflectionCacheSize);
        this.javaConstructorToValueCreator = new LRUMap(reflectionCacheSize, reflectionCacheSize);
        this.javaMethodToValueCreator = new LRUMap(reflectionCacheSize, reflectionCacheSize);
        this.javaConstructorIsCreatorAnnotated = new LRUMap(reflectionCacheSize, reflectionCacheSize);
        this.javaMemberIsRequired = new LRUMap(reflectionCacheSize, reflectionCacheSize);
        this.kotlinGeneratedMethod = new LRUMap(reflectionCacheSize, reflectionCacheSize);
    }

    @NotNull
    public final KClass<Object> kotlinFromJava(@NotNull Class<Object> key) {
        KClass<Object> kClass;
        Intrinsics.checkNotNullParameter(key, (String)"key");
        KClass<Object> kClass2 = this.javaClassToKotlin.get(key);
        if (kClass2 == null) {
            KClass<Object> kClass3 = JvmClassMappingKt.getKotlinClass(key);
            boolean bl = false;
            boolean bl2 = false;
            KClass<Object> it = kClass3;
            boolean bl3 = false;
            KClass<Object> kClass4 = this.javaClassToKotlin.putIfAbsent(key, it);
            kClass = kClass4 == null ? it : kClass4;
        } else {
            kClass = kClass2;
        }
        return kClass;
    }

    @Nullable
    public final KFunction<Object> kotlinFromJava(@NotNull Constructor<Object> key) {
        KFunction<Object> kFunction;
        Intrinsics.checkNotNullParameter(key, (String)"key");
        KFunction<Object> kFunction2 = this.javaConstructorToKotlin.get(key);
        if (kFunction2 == null) {
            KFunction<Object> kFunction3 = ReflectJvmMapping.getKotlinFunction(key);
            if (kFunction3 == null) {
                kFunction = null;
            } else {
                KFunction<Object> kFunction4 = kFunction3;
                boolean bl = false;
                boolean bl2 = false;
                KFunction<Object> it = kFunction4;
                boolean bl3 = false;
                KFunction<Object> kFunction5 = this.javaConstructorToKotlin.putIfAbsent(key, it);
                kFunction = kFunction5 == null ? it : kFunction5;
            }
        } else {
            kFunction = kFunction2;
        }
        return kFunction;
    }

    @Nullable
    public final KFunction<?> kotlinFromJava(@NotNull Method key) {
        KFunction kFunction;
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        KFunction kFunction2 = this.javaMethodToKotlin.get(key);
        if (kFunction2 == null) {
            KFunction kFunction3 = ReflectJvmMapping.getKotlinFunction((Method)key);
            if (kFunction3 == null) {
                kFunction = null;
            } else {
                KFunction kFunction4 = kFunction3;
                boolean bl = false;
                boolean bl2 = false;
                KFunction it = kFunction4;
                boolean bl3 = false;
                KFunction kFunction5 = this.javaMethodToKotlin.putIfAbsent(key, it);
                kFunction = kFunction5 == null ? it : kFunction5;
            }
        } else {
            kFunction = kFunction2;
        }
        return kFunction;
    }

    @Nullable
    public final ValueCreator<?> valueCreatorFromJava(@NotNull AnnotatedWithParams _withArgsCreator) {
        ValueCreator valueCreator;
        Intrinsics.checkNotNullParameter((Object)_withArgsCreator, (String)"_withArgsCreator");
        AnnotatedWithParams annotatedWithParams = _withArgsCreator;
        if (annotatedWithParams instanceof AnnotatedConstructor) {
            ConstructorValueCreator<Object> constructorValueCreator;
            Object object = ((AnnotatedConstructor)_withArgsCreator).getAnnotated();
            if (object == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<kotlin.Any>");
            }
            Object constructor = object;
            if ((object = this.javaConstructorToValueCreator.get(constructor)) == null) {
                KFunction<Object> kFunction = this.kotlinFromJava((Constructor<Object>)constructor);
                if (kFunction == null) {
                    constructorValueCreator = null;
                } else {
                    KFunction<Object> kFunction2 = kFunction;
                    boolean bl = false;
                    boolean bl2 = false;
                    KFunction<Object> it = kFunction2;
                    boolean bl3 = false;
                    ConstructorValueCreator<Object> value = new ConstructorValueCreator<Object>(it);
                    ConstructorValueCreator<Object> constructorValueCreator2 = this.javaConstructorToValueCreator.putIfAbsent((Constructor<Object>)constructor, value);
                    constructorValueCreator = constructorValueCreator2 == null ? value : constructorValueCreator2;
                }
            } else {
                constructorValueCreator = object;
            }
            valueCreator = constructorValueCreator;
        } else if (annotatedWithParams instanceof AnnotatedMethod) {
            MethodValueCreator<?> methodValueCreator;
            Object object = ((AnnotatedMethod)_withArgsCreator).getAnnotated();
            if (object == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Method");
            }
            Object method = object;
            if ((object = this.javaMethodToValueCreator.get(method)) == null) {
                KFunction<?> kFunction = this.kotlinFromJava((Method)method);
                if (kFunction == null) {
                    methodValueCreator = null;
                } else {
                    KFunction<?> kFunction3 = kFunction;
                    boolean bl = false;
                    boolean bl4 = false;
                    KFunction<?> it = kFunction3;
                    boolean bl5 = false;
                    MethodValueCreator<?> value = MethodValueCreator.Companion.of(it);
                    MethodValueCreator<?> methodValueCreator2 = this.javaMethodToValueCreator.putIfAbsent((Method)method, value);
                    methodValueCreator = methodValueCreator2 == null ? value : methodValueCreator2;
                }
            } else {
                methodValueCreator = object;
            }
            valueCreator = methodValueCreator;
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus((String)"Expected a constructor or method to create a Kotlin object, instead found ", (Object)_withArgsCreator.getAnnotated().getClass().getName()));
        }
        return valueCreator;
    }

    public final boolean checkConstructorIsCreatorAnnotated(@NotNull AnnotatedConstructor key, @NotNull Function1<? super AnnotatedConstructor, Boolean> calc) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter(calc, (String)"calc");
        Boolean bl2 = this.javaConstructorIsCreatorAnnotated.get(key);
        if (bl2 == null) {
            Object object = calc.invoke((Object)key);
            boolean bl3 = false;
            boolean bl4 = false;
            boolean it = (Boolean)object;
            boolean bl5 = false;
            Boolean bl6 = this.javaConstructorIsCreatorAnnotated.putIfAbsent(key, it);
            bl = bl6 == null ? it : bl6;
        } else {
            bl = bl2;
        }
        return bl;
    }

    @Nullable
    public final Boolean javaMemberIsRequired(@NotNull AnnotatedMember key, @NotNull Function1<? super AnnotatedMember, Boolean> calc) {
        Boolean bl;
        Boolean bl2;
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter(calc, (String)"calc");
        Object object = this.javaMemberIsRequired.get(key);
        Boolean bl3 = bl2 = object == null ? null : ((BooleanTriState)object).getValue();
        if (bl2 == null) {
            Boolean bl4;
            object = calc.invoke((Object)key);
            boolean bl5 = false;
            boolean bl6 = false;
            Boolean it = (Boolean)object;
            boolean bl7 = false;
            BooleanTriState booleanTriState = this.javaMemberIsRequired.putIfAbsent(key, BooleanTriState.Companion.fromBoolean(it));
            bl = booleanTriState == null ? it : ((bl4 = booleanTriState.getValue()) == null ? it : bl4);
        } else {
            bl = bl2;
        }
        return bl;
    }

    public final boolean isKotlinGeneratedMethod(@NotNull AnnotatedMethod key, @NotNull Function1<? super AnnotatedMethod, Boolean> calc) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter(calc, (String)"calc");
        Boolean bl2 = this.kotlinGeneratedMethod.get(key);
        if (bl2 == null) {
            Object object = calc.invoke((Object)key);
            boolean bl3 = false;
            boolean bl4 = false;
            boolean it = (Boolean)object;
            boolean bl5 = false;
            Boolean bl6 = this.kotlinGeneratedMethod.putIfAbsent(key, it);
            bl = bl6 == null ? it : bl6;
        } else {
            bl = bl2;
        }
        return bl;
    }

    @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0004\t\n\u000b\fB\u0013\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\r\u000e\u000f\u00a8\u0006\u0010"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "", "", "value", "Ljava/lang/Boolean;", "getValue", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/Boolean;)V", "Companion", "Empty", "False", "True", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "jackson-module-kotlin"})
    public static abstract class BooleanTriState {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        private final Boolean value;
        @NotNull
        private static final True TRUE = new True();
        @NotNull
        private static final False FALSE = new False();
        @NotNull
        private static final Empty EMPTY = new Empty();

        private BooleanTriState(Boolean value) {
            this.value = value;
        }

        @Nullable
        public final Boolean getValue() {
            return this.value;
        }

        public /* synthetic */ BooleanTriState(Boolean value, DefaultConstructorMarker $constructor_marker) {
            this(value);
        }

        @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "<init>", "()V", "jackson-module-kotlin"})
        public static final class True
        extends BooleanTriState {
            public True() {
                super(true, null);
            }
        }

        @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "<init>", "()V", "jackson-module-kotlin"})
        public static final class False
        extends BooleanTriState {
            public False() {
                super(false, null);
            }
        }

        @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "<init>", "()V", "jackson-module-kotlin"})
        public static final class Empty
        extends BooleanTriState {
            public Empty() {
                super(null, null);
            }
        }

        @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Companion;", "", "", "value", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "fromBoolean", "(Ljava/lang/Boolean;)Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "EMPTY", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "FALSE", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "TRUE", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "<init>", "()V", "jackson-module-kotlin"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final BooleanTriState fromBoolean(@Nullable Boolean value) {
                BooleanTriState booleanTriState;
                Boolean bl = value;
                if (bl == null) {
                    booleanTriState = EMPTY;
                } else if (Intrinsics.areEqual((Object)bl, (Object)true)) {
                    booleanTriState = TRUE;
                } else if (Intrinsics.areEqual((Object)bl, (Object)false)) {
                    booleanTriState = FALSE;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return booleanTriState;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

