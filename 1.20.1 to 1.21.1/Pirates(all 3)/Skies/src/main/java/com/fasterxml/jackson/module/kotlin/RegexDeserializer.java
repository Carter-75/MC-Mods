/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.Regex
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.module.kotlin.RegexDeserializer;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lcom/fasterxml/jackson/module/kotlin/RegexDeserializer;", "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;", "Lkotlin/text/Regex;", "Lcom/fasterxml/jackson/core/JsonParser;", "p", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "deserialize", "(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lkotlin/text/Regex;", "<init>", "()V", "jackson-module-kotlin"})
public final class RegexDeserializer
extends StdDeserializer<Regex> {
    @NotNull
    public static final RegexDeserializer INSTANCE = new RegexDeserializer();

    private RegexDeserializer() {
        super(Regex.class);
    }

    @Override
    @NotNull
    public Regex deserialize(@NotNull JsonParser p, @NotNull DeserializationContext ctxt) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        JsonNode node = ctxt.readTree(p);
        if (node.isTextual()) {
            String string = node.asText();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"node.asText()");
            return new Regex(string);
        }
        if (node.isObject()) {
            Set set;
            String pattern = node.get("pattern").asText();
            if (node.has("options")) {
                JsonNode optionsNode = node.get("options");
                if (!optionsNode.isArray()) {
                    throw new IllegalStateException(Intrinsics.stringPlus((String)"Expected an array of strings for RegexOptions, but type was ", (Object)((Object)node.getNodeType())));
                }
                Iterator<JsonNode> iterator2 = optionsNode.elements();
                Intrinsics.checkNotNullExpressionValue(iterator2, (String)"optionsNode.elements()");
                set = SequencesKt.toSet((Sequence)SequencesKt.map((Sequence)SequencesKt.asSequence(iterator2), (Function1)deserialize.options.1.INSTANCE));
            } else {
                set = SetsKt.emptySet();
            }
            Set options2 = set;
            Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"pattern");
            return new Regex(pattern, options2);
        }
        throw new IllegalStateException(Intrinsics.stringPlus((String)"Expected a string or an object to deserialize a Regex, but type was ", (Object)((Object)node.getNodeType())));
    }
}

