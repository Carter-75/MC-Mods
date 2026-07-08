/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\nH'\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00028\u00008\u0007\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0010\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004\u00a8\u0006\u0014"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ClosedRangeMixin;", "T", "", "getEnd", "()Ljava/lang/Object;", "getEndExclusive", "getFirst", "getIncrement", "getLast", "getStep", "", "isEmpty", "()Z", "endInclusive", "Ljava/lang/Object;", "getEndInclusive", "start", "getStart", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "jackson-module-kotlin"})
public abstract class ClosedRangeMixin<T> {
    private final T start;
    private final T endInclusive;

    @JsonCreator
    public ClosedRangeMixin(T start, T endInclusive) {
        this.start = start;
        this.endInclusive = endInclusive;
    }

    public final T getStart() {
        return this.start;
    }

    @JsonProperty(value="end")
    public final T getEndInclusive() {
        return this.endInclusive;
    }

    @JsonIgnore
    public abstract T getEnd();

    @JsonIgnore
    public abstract T getFirst();

    @JsonIgnore
    public abstract T getLast();

    @JsonIgnore
    public abstract T getIncrement();

    @JsonIgnore
    public abstract boolean isEmpty();

    @JsonIgnore
    public abstract T getStep();

    @JsonIgnore
    public abstract T getEndExclusive();
}

