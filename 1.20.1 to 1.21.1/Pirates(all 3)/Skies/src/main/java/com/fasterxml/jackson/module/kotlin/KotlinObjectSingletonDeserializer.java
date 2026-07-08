/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.module.kotlin.KotlinObjectSingletonDeserializerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u001b\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinObjectSingletonDeserializer;", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "", "Lcom/fasterxml/jackson/databind/deser/ContextualDeserializer;", "Lcom/fasterxml/jackson/databind/deser/ResolvableDeserializer;", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "Lcom/fasterxml/jackson/databind/BeanProperty;", "property", "createContextual", "(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonDeserializer;", "Lcom/fasterxml/jackson/core/JsonParser;", "p", "deserialize", "(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;", "", "resolve", "(Lcom/fasterxml/jackson/databind/DeserializationContext;)V", "defaultDeserializer", "Lcom/fasterxml/jackson/databind/JsonDeserializer;", "singletonInstance", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JsonDeserializer;)V", "jackson-module-kotlin"})
public final class KotlinObjectSingletonDeserializer
extends JsonDeserializer<Object>
implements ContextualDeserializer,
ResolvableDeserializer {
    @NotNull
    private final Object singletonInstance;
    @NotNull
    private final JsonDeserializer<?> defaultDeserializer;

    public KotlinObjectSingletonDeserializer(@NotNull Object singletonInstance, @NotNull JsonDeserializer<?> defaultDeserializer) {
        Intrinsics.checkNotNullParameter((Object)singletonInstance, (String)"singletonInstance");
        Intrinsics.checkNotNullParameter(defaultDeserializer, (String)"defaultDeserializer");
        this.singletonInstance = singletonInstance;
        this.defaultDeserializer = defaultDeserializer;
    }

    @Override
    public void resolve(@Nullable DeserializationContext ctxt) {
        if (this.defaultDeserializer instanceof ResolvableDeserializer) {
            ((ResolvableDeserializer)((Object)this.defaultDeserializer)).resolve(ctxt);
        }
    }

    @Override
    @NotNull
    public JsonDeserializer<?> createContextual(@Nullable DeserializationContext ctxt, @Nullable BeanProperty property) {
        JsonDeserializer jsonDeserializer;
        if (this.defaultDeserializer instanceof ContextualDeserializer) {
            JsonDeserializer<?> jsonDeserializer2 = ((ContextualDeserializer)((Object)this.defaultDeserializer)).createContextual(ctxt, property);
            Intrinsics.checkNotNullExpressionValue(jsonDeserializer2, (String)"defaultDeserializer.crea\u2026ontextual(ctxt, property)");
            jsonDeserializer = KotlinObjectSingletonDeserializerKt.asSingletonDeserializer(jsonDeserializer2, this.singletonInstance);
        } else {
            jsonDeserializer = this;
        }
        return jsonDeserializer;
    }

    @Override
    @NotNull
    public Object deserialize(@NotNull JsonParser p, @NotNull DeserializationContext ctxt) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        this.defaultDeserializer.deserialize(p, ctxt);
        return this.singletonInstance;
    }
}

