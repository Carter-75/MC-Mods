/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KParameter
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.io.Closeable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2={"Lcom/fasterxml/jackson/module/kotlin/MissingKotlinParameterException;", "Lcom/fasterxml/jackson/databind/exc/MismatchedInputException;", "Lkotlin/reflect/KParameter;", "parameter", "Lkotlin/reflect/KParameter;", "getParameter", "()Lkotlin/reflect/KParameter;", "Ljava/io/Closeable;", "processor", "", "msg", "<init>", "(Lkotlin/reflect/KParameter;Ljava/io/Closeable;Ljava/lang/String;)V", "Lcom/fasterxml/jackson/core/JsonParser;", "(Lkotlin/reflect/KParameter;Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/String;)V", "jackson-module-kotlin"})
public final class MissingKotlinParameterException
extends MismatchedInputException {
    @NotNull
    private final KParameter parameter;

    public MissingKotlinParameterException(@NotNull KParameter parameter, @Nullable JsonParser processor, @NotNull String msg) {
        Intrinsics.checkNotNullParameter((Object)parameter, (String)"parameter");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        super(processor, msg);
        this.parameter = parameter;
    }

    public /* synthetic */ MissingKotlinParameterException(KParameter kParameter, JsonParser jsonParser, String string, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            jsonParser = null;
        }
        this(kParameter, jsonParser, string);
    }

    @NotNull
    public final KParameter getParameter() {
        return this.parameter;
    }

    @Deprecated(message="Use main constructor", replaceWith=@ReplaceWith(expression="MissingKotlinParameterException(KParameter, JsonParser?, String)", imports={}))
    public MissingKotlinParameterException(@NotNull KParameter parameter, @Nullable Closeable processor, @NotNull String msg) {
        Intrinsics.checkNotNullParameter((Object)parameter, (String)"parameter");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        if (processor == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.fasterxml.jackson.core.JsonParser");
        }
        this(parameter, (JsonParser)processor, msg);
    }

    public /* synthetic */ MissingKotlinParameterException(KParameter kParameter, Closeable closeable, String string, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            closeable = null;
        }
        this(kParameter, closeable, string);
    }
}

