/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufInputStream
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public final class GM {
    private static /* synthetic */ <T> T a(ObjectMapper objectMapper, ByteBuf object) {
        Intrinsics.checkNotNullParameter((Object)objectMapper, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = (InputStream)new ByteBufInputStream(object);
        Intrinsics.needClassReification();
        return objectMapper.readValue((InputStream)object, new TypeReference<T>(){});
    }

    public static final <T> T a(ObjectMapper objectMapper, ByteBuf byteBuf, Class<T> clazz) {
        Intrinsics.checkNotNullParameter((Object)objectMapper, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        return objectMapper.readValue((InputStream)new ByteBufInputStream(byteBuf), clazz);
    }

    private static ObjectNode a(ObjectNode object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        ObjectNode objectNode = ((ContainerNode)object).objectNode();
        Iterator<Map.Entry<String, JsonNode>> iterator2 = ((JsonNode)object).fields();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"");
        object = iterator2;
        while (object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
            String string = (String)object2.getKey();
            object2 = (JsonNode)object2.getValue();
            objectNode.replace(string, (JsonNode)object2);
        }
        Intrinsics.checkNotNullExpressionValue((Object)objectNode, (String)"");
        return objectNode;
    }

    private static ObjectNode a(ObjectNode objectNode, String string, JsonNode jsonNode) {
        Intrinsics.checkNotNullParameter((Object)objectNode, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)jsonNode, (String)"");
        ObjectNode objectNode2 = objectNode = GM.a(objectNode);
        objectNode.replace(string, jsonNode);
        return objectNode;
    }

    private static /* synthetic */ <A, B extends A> SimpleModule a(SimpleModule simpleModule) {
        Intrinsics.checkNotNullParameter((Object)simpleModule, (String)"");
        Intrinsics.reifiedOperationMarker((int)4, (String)"A");
        Intrinsics.reifiedOperationMarker((int)4, (String)"B");
        SimpleModule simpleModule2 = simpleModule.addAbstractTypeMapping(Object.class, Object.class);
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule2, (String)"");
        return simpleModule2;
    }

    private static /* synthetic */ <A, B> SimpleModule b(SimpleModule simpleModule) {
        Intrinsics.checkNotNullParameter((Object)simpleModule, (String)"");
        Intrinsics.reifiedOperationMarker((int)4, (String)"A");
        Intrinsics.reifiedOperationMarker((int)4, (String)"B");
        SimpleModule simpleModule2 = simpleModule.setMixInAnnotation(Object.class, Object.class);
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule2, (String)"");
        return simpleModule2;
    }

    public static final void a(ObjectMapper objectMapper, AnnotationIntrospector annotationIntrospector) {
        Intrinsics.checkNotNullParameter((Object)objectMapper, (String)"");
        Intrinsics.checkNotNullParameter((Object)annotationIntrospector, (String)"");
        objectMapper.registerModule(new SimpleModule(annotationIntrospector){
            private /* synthetic */ AnnotationIntrospector a;
            {
                this.a = annotationIntrospector;
            }

            /*
             * WARNING - void declaration
             */
            @Override
            public final void setupModule(Module.SetupContext context) {
                void var1_1;
                Intrinsics.checkNotNullParameter((Object)context, (String)"");
                context.insertAnnotationIntrospector(this.a);
                super.setupModule((Module.SetupContext)var1_1);
            }
        });
    }

    private static ObjectNode a(ObjectNode objectNode, ObjectNode object) {
        Intrinsics.checkNotNullParameter((Object)objectNode, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        objectNode = GM.a(objectNode);
        Iterator<Map.Entry<String, JsonNode>> iterator2 = ((JsonNode)object).fields();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"");
        object = iterator2;
        while (object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
            String string = (String)object2.getKey();
            object2 = (JsonNode)object2.getValue();
            if (((JsonNode)object2).isObject() && objectNode.has(string) && ((JsonNode)objectNode).get(string).isObject()) {
                JsonNode jsonNode = ((JsonNode)objectNode).get(string);
                Intrinsics.checkNotNull((Object)jsonNode);
                ObjectNode objectNode2 = (ObjectNode)jsonNode;
                Intrinsics.checkNotNull((Object)object2);
                objectNode.replace(string, GM.a(objectNode2, (ObjectNode)object2));
                continue;
            }
            objectNode.replace(string, (JsonNode)((JsonNode)object2).deepCopy());
        }
        return objectNode;
    }

    private static void b(ObjectMapper objectMapper, AnnotationIntrospector annotationIntrospector) {
        Intrinsics.checkNotNullParameter((Object)objectMapper, (String)"");
        Intrinsics.checkNotNullParameter((Object)annotationIntrospector, (String)"");
        objectMapper.registerModule(new SimpleModule(annotationIntrospector){
            private /* synthetic */ AnnotationIntrospector a;
            {
                this.a = annotationIntrospector;
            }

            /*
             * WARNING - void declaration
             */
            @Override
            public final void setupModule(Module.SetupContext context) {
                void var1_1;
                Intrinsics.checkNotNullParameter((Object)context, (String)"");
                context.appendAnnotationIntrospector(this.a);
                super.setupModule((Module.SetupContext)var1_1);
            }
        });
    }
}

