/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 */
package org.valkyrienskies.core.internal.config;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.internal.config.VsiConfigNode;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0014\u0010\u0005\u001a\u00028\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00018\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u0004\u0018\u00018\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\bR \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0019\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/config/VsiConfigModelEntry;", "T", "Lorg/valkyrienskies/core/internal/config/VsiConfigNode;", "getDefault", "()Ljava/lang/Object;", "default", "", "getDescription", "()Ljava/lang/String;", "description", "Lkotlin/Function0;", "getGetValue", "()Lkotlin/jvm/functions/Function0;", "getValue", "getMax", "max", "getMin", "min", "getName", "name", "Lkotlin/Function1;", "", "getSetValue", "()Lkotlin/jvm/functions/Function1;", "setValue", "internal"})
public interface VsiConfigModelEntry<T>
extends VsiConfigNode {
    @NotNull
    public Function0<T> getGetValue();

    @NotNull
    public Function1<T, Unit> getSetValue();

    @Nullable
    public T getMin();

    @Nullable
    public T getMax();

    @NotNull
    public String getName();

    @Nullable
    public String getDescription();

    public T getDefault();
}

