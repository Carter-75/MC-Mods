/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.rubydesic.jacksonktdsl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.rubydesic.jacksonktdsl.ArrayNodeFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 7, 1}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2={"Lcom/rubydesic/jacksonktdsl/ArrayNodeFactoryImpl;", "Lcom/rubydesic/jacksonktdsl/ArrayNodeFactory;", "", "", "elements", "Lcom/fasterxml/jackson/databind/node/ArrayNode;", "get", "([Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/node/ArrayNode;", "", "Lcom/fasterxml/jackson/databind/JsonNode;", "(Ljava/util/List;)Lcom/fasterxml/jackson/databind/node/ArrayNode;", "Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;", "nodeFactory", "Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;", "<init>", "(Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)V", "jackson-kotlin-dsl"})
public final class ArrayNodeFactoryImpl
implements ArrayNodeFactory {
    @NotNull
    private final JsonNodeFactory nodeFactory;

    public ArrayNodeFactoryImpl(@NotNull JsonNodeFactory nodeFactory) {
        Intrinsics.checkNotNullParameter((Object)nodeFactory, (String)"nodeFactory");
        this.nodeFactory = nodeFactory;
    }

    @Override
    @NotNull
    public ArrayNode get(Object ... elements) {
        Intrinsics.checkNotNullParameter((Object)elements, (String)"elements");
        ArrayNode arr = this.nodeFactory.arrayNode(elements.length);
        Object[] $this$forEach$iv = elements;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object element$iv;
            Object p0 = element$iv = $this$forEach$iv[i2];
            boolean bl = false;
            arr.addPOJO(p0);
        }
        Intrinsics.checkNotNullExpressionValue((Object)arr, (String)"arr");
        return arr;
    }

    @Override
    @NotNull
    public ArrayNode get(@NotNull List<? extends JsonNode> elements) {
        Intrinsics.checkNotNullParameter(elements, (String)"elements");
        return new ArrayNode(this.nodeFactory, elements);
    }

    @Override
    @NotNull
    public ArrayNode get(JsonNode ... elements) {
        return ArrayNodeFactory.DefaultImpls.get((ArrayNodeFactory)this, elements);
    }

    @Override
    @NotNull
    public ArrayNode get(@NotNull Iterable<? extends JsonNode> elements) {
        return ArrayNodeFactory.DefaultImpls.get((ArrayNodeFactory)this, elements);
    }
}

