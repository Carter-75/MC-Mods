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

import com.fasterxml.jackson.databind.JsonNode;
import com.rubydesic.jacksonktdsl.JacksonKotlinDslKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 7, 1}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6\u0004\u00a2\u0006\u0004\b\b\u0010\u0007J-\u0010\b\u001a\u00020\u0005*\u00020\u00022\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\t\u00a2\u0006\u0002\b\nH\u0096\u0004\u00a2\u0006\u0004\b\b\u0010\u000bJ\u001e\u0010\b\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u00a6\u0004\u00a2\u0006\u0004\b\b\u0010\f\u00a8\u0006\r"}, d2={"Lcom/rubydesic/jacksonktdsl/ObjectNodeBuilder;", "", "", "Lcom/fasterxml/jackson/databind/JsonNode;", "other", "", "invoke", "(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)V", "to", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/String;Ljava/lang/Object;)V", "jackson-kotlin-dsl"})
public interface ObjectNodeBuilder {
    public void to(@NotNull String var1, @Nullable Object var2);

    public void to(@NotNull String var1, @NotNull JsonNode var2);

    public void to(@NotNull String var1, @NotNull Function1<? super ObjectNodeBuilder, Unit> var2);

    public void invoke(@NotNull String var1, @NotNull JsonNode var2);

    @Metadata(mv={1, 7, 1}, k=3, xi=48)
    public static final class DefaultImpls {
        public static void to(@NotNull ObjectNodeBuilder $this, @NotNull String $receiver, @NotNull Function1<? super ObjectNodeBuilder, Unit> other) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter(other, (String)"other");
            $this.to($receiver, JacksonKotlinDslKt.obj(other));
        }

        public static void invoke(@NotNull ObjectNodeBuilder $this, @NotNull String $receiver, @NotNull JsonNode other) {
            Intrinsics.checkNotNullParameter((Object)$receiver, (String)"$receiver");
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            $this.to($receiver, other);
        }
    }
}

