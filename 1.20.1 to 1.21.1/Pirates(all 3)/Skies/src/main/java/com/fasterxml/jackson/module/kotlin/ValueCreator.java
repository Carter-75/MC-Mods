/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.full.KCallables
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.MapperFeature;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KCallables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u0006\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0082\u0001\u0002\u001d\u001e\u00a8\u0006\u001f"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ValueCreator;", "T", "", "", "Lkotlin/reflect/KParameter;", "args", "callBy", "(Ljava/util/Map;)Ljava/lang/Object;", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "", "checkAccessibility", "(Lcom/fasterxml/jackson/databind/DeserializationContext;)V", "", "getAccessible", "()Z", "accessible", "Lkotlin/reflect/KFunction;", "getCallable", "()Lkotlin/reflect/KFunction;", "callable", "", "valueParameters$delegate", "Lkotlin/Lazy;", "getValueParameters", "()Ljava/util/List;", "valueParameters", "<init>", "()V", "Lcom/fasterxml/jackson/module/kotlin/ConstructorValueCreator;", "Lcom/fasterxml/jackson/module/kotlin/MethodValueCreator;", "jackson-module-kotlin"})
public abstract class ValueCreator<T> {
    @NotNull
    private final Lazy valueParameters$delegate = LazyKt.lazy((Function0)((Function0)new Function0<List<? extends KParameter>>(this){
        final /* synthetic */ ValueCreator<T> this$0;
        {
            this.this$0 = $receiver;
            super(0);
        }

        @NotNull
        public final List<KParameter> invoke() {
            return KCallables.getValueParameters((KCallable)((KCallable)this.this$0.getCallable()));
        }
    }));

    private ValueCreator() {
    }

    @NotNull
    protected abstract KFunction<T> getCallable();

    protected abstract boolean getAccessible();

    @NotNull
    public final List<KParameter> getValueParameters() {
        Lazy lazy = this.valueParameters$delegate;
        Object var2_2 = null;
        boolean bl = false;
        return (List)lazy.getValue();
    }

    public final void checkAccessibility(@NotNull DeserializationContext ctxt) {
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        if (!this.getAccessible() && ctxt.getConfig().isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS) || this.getAccessible() && ctxt.getConfig().isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS)) {
            return;
        }
        throw new IllegalAccessException(Intrinsics.stringPlus((String)"Cannot access to function or companion object instance, target: ", this.getCallable()));
    }

    public final T callBy(@NotNull Map<KParameter, ? extends Object> args) {
        Intrinsics.checkNotNullParameter(args, (String)"args");
        return (T)this.getCallable().callBy(args);
    }

    public /* synthetic */ ValueCreator(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

