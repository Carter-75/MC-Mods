/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.module.kotlin.KotlinModuleKt;
import com.fasterxml.jackson.module.kotlin.KotlinValueInstantiator;
import com.fasterxml.jackson.module.kotlin.ReflectionCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J'\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0015"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinInstantiators;", "Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;", "Lcom/fasterxml/jackson/databind/DeserializationConfig;", "deserConfig", "Lcom/fasterxml/jackson/databind/BeanDescription;", "beanDescriptor", "Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;", "defaultInstantiator", "findValueInstantiator", "(Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/BeanDescription;Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;)Lcom/fasterxml/jackson/databind/deser/ValueInstantiator;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "cache", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "", "nullIsSameAsDefault", "Z", "nullToEmptyCollection", "nullToEmptyMap", "strictNullChecks", "<init>", "(Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;ZZZZ)V", "jackson-module-kotlin"})
public final class KotlinInstantiators
implements ValueInstantiators {
    @NotNull
    private final ReflectionCache cache;
    private final boolean nullToEmptyCollection;
    private final boolean nullToEmptyMap;
    private final boolean nullIsSameAsDefault;
    private final boolean strictNullChecks;

    public KotlinInstantiators(@NotNull ReflectionCache cache2, boolean nullToEmptyCollection, boolean nullToEmptyMap, boolean nullIsSameAsDefault, boolean strictNullChecks) {
        Intrinsics.checkNotNullParameter((Object)cache2, (String)"cache");
        this.cache = cache2;
        this.nullToEmptyCollection = nullToEmptyCollection;
        this.nullToEmptyMap = nullToEmptyMap;
        this.nullIsSameAsDefault = nullIsSameAsDefault;
        this.strictNullChecks = strictNullChecks;
    }

    @Override
    @NotNull
    public ValueInstantiator findValueInstantiator(@NotNull DeserializationConfig deserConfig, @NotNull BeanDescription beanDescriptor, @NotNull ValueInstantiator defaultInstantiator) {
        ValueInstantiator valueInstantiator;
        Intrinsics.checkNotNullParameter((Object)deserConfig, (String)"deserConfig");
        Intrinsics.checkNotNullParameter((Object)beanDescriptor, (String)"beanDescriptor");
        Intrinsics.checkNotNullParameter((Object)defaultInstantiator, (String)"defaultInstantiator");
        Class<?> clazz = beanDescriptor.getBeanClass();
        Intrinsics.checkNotNullExpressionValue(clazz, (String)"beanDescriptor.beanClass");
        if (KotlinModuleKt.isKotlinClass(clazz)) {
            if (!Intrinsics.areEqual((Object)Reflection.getOrCreateKotlinClass(defaultInstantiator.getClass()), (Object)Reflection.getOrCreateKotlinClass(StdValueInstantiator.class))) {
                throw new IllegalStateException("KotlinValueInstantiator requires that the default ValueInstantiator is StdValueInstantiator");
            }
            valueInstantiator = new KotlinValueInstantiator((StdValueInstantiator)defaultInstantiator, this.cache, this.nullToEmptyCollection, this.nullToEmptyMap, this.nullIsSameAsDefault, this.strictNullChecks);
        } else {
            valueInstantiator = defaultInstantiator;
        }
        return valueInstantiator;
    }
}

