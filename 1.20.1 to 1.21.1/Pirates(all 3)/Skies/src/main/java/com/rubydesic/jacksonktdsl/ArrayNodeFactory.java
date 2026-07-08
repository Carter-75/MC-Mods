/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package com.rubydesic.jacksonktdsl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 7, 1}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002\"\u00020\u0001H\u00a6\u0002\u00a2\u0006\u0004\b\u0006\u0010\bJ\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\nJ\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u00a6\u0002\u00a2\u0006\u0004\b\u0006\u0010\f\u00a8\u0006\r"}, d2={"Lcom/rubydesic/jacksonktdsl/ArrayNodeFactory;", "", "", "Lcom/fasterxml/jackson/databind/JsonNode;", "elements", "Lcom/fasterxml/jackson/databind/node/ArrayNode;", "get", "([Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/node/ArrayNode;", "([Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/node/ArrayNode;", "", "(Ljava/lang/Iterable;)Lcom/fasterxml/jackson/databind/node/ArrayNode;", "", "(Ljava/util/List;)Lcom/fasterxml/jackson/databind/node/ArrayNode;", "jackson-kotlin-dsl"})
public interface ArrayNodeFactory {
    @NotNull
    public ArrayNode get(Object ... var1);

    @NotNull
    public ArrayNode get(@NotNull List<? extends JsonNode> var1);

    @NotNull
    public ArrayNode get(JsonNode ... var1);

    @NotNull
    public ArrayNode get(@NotNull Iterable<? extends JsonNode> var1);

    @Metadata(mv={1, 7, 1}, k=3, xi=48)
    public static final class DefaultImpls {
        @NotNull
        public static ArrayNode get(@NotNull ArrayNodeFactory $this, JsonNode ... elements) {
            Intrinsics.checkNotNullParameter((Object)elements, (String)"elements");
            return $this.get(ArraysKt.asList((Object[])elements));
        }

        @NotNull
        public static ArrayNode get(@NotNull ArrayNodeFactory $this, @NotNull Iterable<? extends JsonNode> elements) {
            Intrinsics.checkNotNullParameter(elements, (String)"elements");
            return $this.get(CollectionsKt.toList(elements));
        }
    }
}

