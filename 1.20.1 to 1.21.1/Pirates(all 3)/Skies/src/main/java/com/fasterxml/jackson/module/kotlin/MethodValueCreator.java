/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.full.KCallables
 *  kotlin.reflect.jvm.KCallablesJvm
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.module.kotlin.TypesKt;
import com.fasterxml.jackson.module.kotlin.ValueCreator;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.jvm.KCallablesJvm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0019B'\b\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u00038\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2={"Lcom/fasterxml/jackson/module/kotlin/MethodValueCreator;", "T", "Lcom/fasterxml/jackson/module/kotlin/ValueCreator;", "", "accessible", "Z", "getAccessible", "()Z", "Lkotlin/reflect/KFunction;", "callable", "Lkotlin/reflect/KFunction;", "getCallable", "()Lkotlin/reflect/KFunction;", "", "companionObjectInstance", "Ljava/lang/Object;", "getCompanionObjectInstance", "()Ljava/lang/Object;", "Lkotlin/reflect/KParameter;", "instanceParameter", "Lkotlin/reflect/KParameter;", "getInstanceParameter", "()Lkotlin/reflect/KParameter;", "<init>", "(Lkotlin/reflect/KFunction;ZLjava/lang/Object;)V", "Companion", "jackson-module-kotlin"})
public final class MethodValueCreator<T>
extends ValueCreator<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final KFunction<T> callable;
    private final boolean accessible;
    @NotNull
    private final Object companionObjectInstance;
    @NotNull
    private final KParameter instanceParameter;

    private MethodValueCreator(KFunction<? extends T> callable, boolean accessible, Object companionObjectInstance) {
        super(null);
        this.callable = callable;
        this.accessible = accessible;
        this.companionObjectInstance = companionObjectInstance;
        KParameter kParameter = KCallables.getInstanceParameter((KCallable)((KCallable)this.getCallable()));
        Intrinsics.checkNotNull((Object)kParameter);
        this.instanceParameter = kParameter;
    }

    @Override
    @NotNull
    protected KFunction<T> getCallable() {
        return this.callable;
    }

    @Override
    protected boolean getAccessible() {
        return this.accessible;
    }

    @NotNull
    public final Object getCompanionObjectInstance() {
        return this.companionObjectInstance;
    }

    @NotNull
    public final KParameter getInstanceParameter() {
        return this.instanceParameter;
    }

    public /* synthetic */ MethodValueCreator(KFunction callable, boolean accessible, Object companionObjectInstance, DefaultConstructorMarker $constructor_marker) {
        this(callable, accessible, companionObjectInstance);
    }

    @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lcom/fasterxml/jackson/module/kotlin/MethodValueCreator$Companion;", "", "T", "Lkotlin/reflect/KFunction;", "callable", "Lcom/fasterxml/jackson/module/kotlin/MethodValueCreator;", "of", "(Lkotlin/reflect/KFunction;)Lcom/fasterxml/jackson/module/kotlin/MethodValueCreator;", "<init>", "()V", "jackson-module-kotlin"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @Nullable
        public final <T> MethodValueCreator<T> of(@NotNull KFunction<? extends T> callable) {
            Object instance;
            Intrinsics.checkNotNullParameter(callable, (String)"callable");
            if (KCallables.getExtensionReceiverParameter((KCallable)((KCallable)callable)) != null) {
                return null;
            }
            KParameter kParameter = KCallables.getInstanceParameter((KCallable)((KCallable)callable));
            Intrinsics.checkNotNull((Object)kParameter);
            KClass possibleCompanion = JvmClassMappingKt.getKotlinClass(TypesKt.erasedType(kParameter.getType()));
            if (!possibleCompanion.isCompanion()) {
                return null;
            }
            boolean initialCallableAccessible = KCallablesJvm.isAccessible((KCallable)((KCallable)callable));
            if (!initialCallableAccessible) {
                KCallablesJvm.setAccessible((KCallable)((KCallable)callable), (boolean)true);
            }
            try {
                Object object = possibleCompanion.getObjectInstance();
                Intrinsics.checkNotNull((Object)object);
                instance = object;
                instance = TuplesKt.to((Object)instance, (Object)initialCallableAccessible);
            }
            catch (IllegalAccessException ex) {
                Pair pair;
                Object v2;
                Object object;
                block9: {
                    void $this$firstOrNull$iv;
                    object = JvmClassMappingKt.getJavaClass((KClass)possibleCompanion).getEnclosingClass().getDeclaredFields();
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"possibleCompanion.java.e\u2026osingClass.declaredFields");
                    object = (Object[])object;
                    boolean $i$f$firstOrNull = false;
                    for (void element$iv : $this$firstOrNull$iv) {
                        Field it = (Field)element$iv;
                        boolean bl = false;
                        Class<?> clazz = it.getType();
                        Intrinsics.checkNotNullExpressionValue(clazz, (String)"it.type");
                        if (!JvmClassMappingKt.getKotlinClass(clazz).isCompanion()) continue;
                        v2 = element$iv;
                        break block9;
                    }
                    v2 = null;
                }
                Field field = v2;
                if (field == null) {
                    pair = null;
                } else {
                    object = field;
                    boolean bl = false;
                    boolean bl2 = false;
                    Object it = object;
                    boolean bl3 = false;
                    ((Field)it).setAccessible(true);
                    pair = TuplesKt.to((Object)((Field)it).get(null), (Object)false);
                }
                Pair pair2 = pair;
                if (pair2 == null) {
                    throw ex;
                }
                instance = pair2;
            }
            Object object = instance;
            Object companionObjectInstance = object.component1();
            boolean accessible = (Boolean)object.component2();
            return new MethodValueCreator(callable, accessible, companionObjectInstance, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

