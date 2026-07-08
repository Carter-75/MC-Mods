/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package com.rubydesic.jacksonktdsl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rubydesic.jacksonktdsl.ObjectNodeBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 7, 1}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u0007\u001a\u00020\u00062\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\b\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\f\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\f\u001a\u00020\u0003*\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0096\u0004\u00a2\u0006\u0004\b\f\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2={"Lcom/rubydesic/jacksonktdsl/ObjectNodeBuilderImpl;", "Lcom/rubydesic/jacksonktdsl/ObjectNodeBuilder;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "build", "(Lkotlin/jvm/functions/Function1;)Lcom/fasterxml/jackson/databind/node/ObjectNode;", "", "Lcom/fasterxml/jackson/databind/JsonNode;", "other", "to", "(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)V", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;", "nodeFactory", "Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;", "getNodeFactory", "()Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;", "obj", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "getObj", "()Lcom/fasterxml/jackson/databind/node/ObjectNode;", "<init>", "(Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;Lcom/fasterxml/jackson/databind/node/ObjectNode;)V", "jackson-kotlin-dsl"})
public final class ObjectNodeBuilderImpl
implements ObjectNodeBuilder {
    @NotNull
    private final JsonNodeFactory nodeFactory;
    @NotNull
    private final ObjectNode obj;

    public ObjectNodeBuilderImpl(@NotNull JsonNodeFactory nodeFactory, @NotNull ObjectNode obj) {
        Intrinsics.checkNotNullParameter((Object)nodeFactory, (String)"nodeFactory");
        Intrinsics.checkNotNullParameter((Object)obj, (String)"obj");
        this.nodeFactory = nodeFactory;
        this.obj = obj;
    }

    public /* synthetic */ ObjectNodeBuilderImpl(JsonNodeFactory jsonNodeFactory, ObjectNode objectNode, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            ObjectNode objectNode2 = jsonNodeFactory.objectNode();
            Intrinsics.checkNotNullExpressionValue((Object)objectNode2, (String)"nodeFactory.objectNode()");
            objectNode = objectNode2;
        }
        this(jsonNodeFactory, objectNode);
    }

    @NotNull
    public final JsonNodeFactory getNodeFactory() {
        return this.nodeFactory;
    }

    @NotNull
    public final ObjectNode getObj() {
        return this.obj;
    }

    @Override
    public void to(@NotNull String $this$to, @Nullable Object other) {
        Intrinsics.checkNotNullParameter((Object)$this$to, (String)"<this>");
        this.obj.replace($this$to, this.nodeFactory.pojoNode(other));
    }

    @Override
    public void to(@NotNull String $this$to, @NotNull JsonNode other) {
        Intrinsics.checkNotNullParameter((Object)$this$to, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        this.obj.replace($this$to, other);
    }

    @NotNull
    public final ObjectNode build(@NotNull Function1<? super ObjectNodeBuilder, Unit> block) {
        ObjectNode objectNode;
        Intrinsics.checkNotNullParameter(block, (String)"block");
        ObjectNode it = objectNode = this.obj;
        boolean bl = false;
        block.invoke((Object)this);
        return objectNode;
    }

    @Override
    public void to(@NotNull String $this$to, @NotNull Function1<? super ObjectNodeBuilder, Unit> other) {
        ObjectNodeBuilder.DefaultImpls.to(this, $this$to, other);
    }

    @Override
    public void invoke(@NotNull String $this$invoke, @NotNull JsonNode other) {
        ObjectNodeBuilder.DefaultImpls.invoke(this, $this$invoke, other);
    }
}

