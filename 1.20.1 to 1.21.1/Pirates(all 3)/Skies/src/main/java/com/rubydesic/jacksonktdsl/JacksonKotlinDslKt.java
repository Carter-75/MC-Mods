/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package com.rubydesic.jacksonktdsl;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rubydesic.jacksonktdsl.ArrayNodeFactory;
import com.rubydesic.jacksonktdsl.ArrayNodeFactoryImpl;
import com.rubydesic.jacksonktdsl.ObjectNodeBuilder;
import com.rubydesic.jacksonktdsl.ObjectNodeBuilderImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 7, 1}, k=2, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a&\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u00a2\u0006\u0002\b\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0006\u001a\u00020\u0005*\u00020\b2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u00a2\u0006\u0002\b\u0003\u00a2\u0006\u0004\b\u0006\u0010\t\"\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u001c\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u000b\u001a\u00020\n*\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lkotlin/Function1;", "Lcom/rubydesic/jacksonktdsl/ObjectNodeBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "obj", "(Lkotlin/jvm/functions/Function1;)Lcom/fasterxml/jackson/databind/node/ObjectNode;", "Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;", "(Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;Lkotlin/jvm/functions/Function1;)Lcom/fasterxml/jackson/databind/node/ObjectNode;", "Lcom/rubydesic/jacksonktdsl/ArrayNodeFactory;", "arr", "Lcom/rubydesic/jacksonktdsl/ArrayNodeFactory;", "getArr", "()Lcom/rubydesic/jacksonktdsl/ArrayNodeFactory;", "kotlin.jvm.PlatformType", "defaultNodeFactory", "Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;", "(Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/rubydesic/jacksonktdsl/ArrayNodeFactory;", "jackson-kotlin-dsl"})
public final class JacksonKotlinDslKt {
    private static final JsonNodeFactory defaultNodeFactory;
    @NotNull
    private static final ArrayNodeFactory arr;

    @NotNull
    public static final ObjectNode obj(@NotNull Function1<? super ObjectNodeBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        JsonNodeFactory jsonNodeFactory = defaultNodeFactory;
        Intrinsics.checkNotNullExpressionValue((Object)jsonNodeFactory, (String)"defaultNodeFactory");
        return JacksonKotlinDslKt.obj(jsonNodeFactory, block);
    }

    @NotNull
    public static final ObjectNode obj(@NotNull JsonNodeFactory $this$obj, @NotNull Function1<? super ObjectNodeBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$obj, (String)"<this>");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return new ObjectNodeBuilderImpl($this$obj, null, 2, null).build(block);
    }

    @NotNull
    public static final ArrayNodeFactory getArr() {
        return arr;
    }

    @NotNull
    public static final ArrayNodeFactory getArr(@NotNull JsonNodeFactory $this$arr) {
        Intrinsics.checkNotNullParameter((Object)$this$arr, (String)"<this>");
        return new ArrayNodeFactoryImpl($this$arr);
    }

    static {
        JsonNodeFactory jsonNodeFactory = defaultNodeFactory = JsonNodeFactory.instance;
        Intrinsics.checkNotNullExpressionValue((Object)jsonNodeFactory, (String)"defaultNodeFactory");
        arr = JacksonKotlinDslKt.getArr(jsonNodeFactory);
    }
}

