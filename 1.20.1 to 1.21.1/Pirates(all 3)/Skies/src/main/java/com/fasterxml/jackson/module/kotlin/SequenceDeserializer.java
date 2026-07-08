/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lcom/fasterxml/jackson/module/kotlin/SequenceDeserializer;", "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;", "Lkotlin/sequences/Sequence;", "Lcom/fasterxml/jackson/core/JsonParser;", "p", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "deserialize", "(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lkotlin/sequences/Sequence;", "<init>", "()V", "jackson-module-kotlin"})
public final class SequenceDeserializer
extends StdDeserializer<Sequence<?>> {
    @NotNull
    public static final SequenceDeserializer INSTANCE = new SequenceDeserializer();

    private SequenceDeserializer() {
        super(Sequence.class);
    }

    @Override
    @NotNull
    public Sequence<?> deserialize(@NotNull JsonParser p, @NotNull DeserializationContext ctxt) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        List list = ctxt.readValue(p, List.class);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"ctxt.readValue(p, List::class.java)");
        return CollectionsKt.asSequence((Iterable)list);
    }
}

