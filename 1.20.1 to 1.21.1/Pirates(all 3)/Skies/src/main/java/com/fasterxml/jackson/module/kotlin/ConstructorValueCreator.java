/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.jvm.KCallablesJvm
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.module.kotlin.ValueCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.KCallablesJvm;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ConstructorValueCreator;", "T", "Lcom/fasterxml/jackson/module/kotlin/ValueCreator;", "", "accessible", "Z", "getAccessible", "()Z", "Lkotlin/reflect/KFunction;", "callable", "Lkotlin/reflect/KFunction;", "getCallable", "()Lkotlin/reflect/KFunction;", "<init>", "(Lkotlin/reflect/KFunction;)V", "jackson-module-kotlin"})
public final class ConstructorValueCreator<T>
extends ValueCreator<T> {
    @NotNull
    private final KFunction<T> callable;
    private final boolean accessible;

    public ConstructorValueCreator(@NotNull KFunction<? extends T> callable) {
        Intrinsics.checkNotNullParameter(callable, (String)"callable");
        super(null);
        this.callable = callable;
        this.accessible = KCallablesJvm.isAccessible((KCallable)((KCallable)this.getCallable()));
        if (!this.getAccessible()) {
            KCallablesJvm.setAccessible((KCallable)((KCallable)this.getCallable()), (boolean)true);
        }
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
}

