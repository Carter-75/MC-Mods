/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonParser
 *  com.fasterxml.jackson.core.TreeNode
 *  com.fasterxml.jackson.databind.DeserializationContext
 *  com.fasterxml.jackson.databind.JsonDeserializer
 *  com.fasterxml.jackson.databind.JsonNode
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package g_mungus.vlib.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lg_mungus/vlib/data/FolderListDeserializer;", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "", "", "Lcom/fasterxml/jackson/core/JsonParser;", "p", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "deserialize", "(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/util/List;", "<init>", "()V", "vlib"})
@SourceDebugExtension(value={"SMAP\nStructureSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StructureSettings.kt\ng_mungus/vlib/data/FolderListDeserializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n1557#2:57\n1628#2,3:58\n*S KotlinDebug\n*F\n+ 1 StructureSettings.kt\ng_mungus/vlib/data/FolderListDeserializer\n*L\n22#1:57\n22#1:58,3\n*E\n"})
public final class FolderListDeserializer
extends JsonDeserializer<List<? extends String>> {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<String> deserialize(@NotNull JsonParser p, @NotNull DeserializationContext ctxt) {
        List list;
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        TreeNode treeNode = p.getCodec().readTree(p);
        Intrinsics.checkNotNullExpressionValue((Object)treeNode, (String)"readTree(...)");
        JsonNode node = (JsonNode)treeNode;
        if (node.isTextual()) {
            list = CollectionsKt.listOf((Object)node.asText());
        } else if (node.isArray()) {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = (Iterable)node;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                JsonNode jsonNode = (JsonNode)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(it.asText());
            }
            list = (List)destination$iv$iv;
        } else {
            list = CollectionsKt.emptyList();
        }
        return list;
    }
}

