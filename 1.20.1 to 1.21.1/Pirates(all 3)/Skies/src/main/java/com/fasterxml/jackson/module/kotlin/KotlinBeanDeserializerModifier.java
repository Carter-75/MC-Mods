/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.module.kotlin.KotlinBeanDeserializerModifierKt;
import com.fasterxml.jackson.module.kotlin.KotlinObjectSingletonDeserializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ3\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinBeanDeserializerModifier;", "Lcom/fasterxml/jackson/databind/deser/BeanDeserializerModifier;", "Lcom/fasterxml/jackson/databind/DeserializationConfig;", "config", "Lcom/fasterxml/jackson/databind/BeanDescription;", "beanDesc", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "deserializer", "", "modifyDeserializer", "(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Lcom/fasterxml/jackson/databind/JsonDeserializer;", "<init>", "()V", "jackson-module-kotlin"})
public final class KotlinBeanDeserializerModifier
extends BeanDeserializerModifier {
    @NotNull
    public static final KotlinBeanDeserializerModifier INSTANCE = new KotlinBeanDeserializerModifier();

    private KotlinBeanDeserializerModifier() {
    }

    @NotNull
    public JsonDeserializer<? extends Object> modifyDeserializer(@NotNull DeserializationConfig config, @NotNull BeanDescription beanDesc, @NotNull JsonDeserializer<?> deserializer) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)beanDesc, (String)"beanDesc");
        Intrinsics.checkNotNullParameter(deserializer, (String)"deserializer");
        JsonDeserializer<?> modifiedFromParent = super.modifyDeserializer(config, beanDesc, deserializer);
        Object object2 = beanDesc.getBeanClass();
        Intrinsics.checkNotNullExpressionValue(object2, (String)"beanDesc.beanClass");
        Object objectSingletonInstance = KotlinBeanDeserializerModifierKt.access$objectSingletonInstance(object2);
        if (objectSingletonInstance != null) {
            Intrinsics.checkNotNullExpressionValue(modifiedFromParent, (String)"modifiedFromParent");
            object = new KotlinObjectSingletonDeserializer(objectSingletonInstance, modifiedFromParent);
        } else {
            object2 = modifiedFromParent;
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"{\n            modifiedFromParent\n        }");
            object = object2;
        }
        return object;
    }
}

