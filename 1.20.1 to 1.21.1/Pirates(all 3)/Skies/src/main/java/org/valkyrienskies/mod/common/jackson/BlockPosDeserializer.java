/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 */
package org.valkyrienskies.mod.common.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.LongNode;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lorg/valkyrienskies/mod/common/jackson/BlockPosDeserializer;", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "Lnet/minecraft/class_2338;", "Lcom/fasterxml/jackson/core/JsonParser;", "p", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "deserialize", "(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lnet/minecraft/class_2338;", "<init>", "()V", "valkyrienskies-120"})
public final class BlockPosDeserializer
extends JsonDeserializer<class_2338> {
    @Override
    @NotNull
    public class_2338 deserialize(@NotNull JsonParser p, @NotNull DeserializationContext ctxt) throws IOException {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        Object node = p.getCodec().readTree(p);
        TreeNode treeNode = node.get("long");
        Intrinsics.checkNotNull((Object)treeNode, (String)"null cannot be cast to non-null type com.fasterxml.jackson.databind.node.LongNode");
        Number number = ((LongNode)treeNode).numberValue();
        Intrinsics.checkNotNull((Object)number, (String)"null cannot be cast to non-null type kotlin.Long");
        long l2 = (Long)number;
        class_2338 class_23382 = class_2338.method_10092((long)l2);
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"of(...)");
        return class_23382;
    }
}

