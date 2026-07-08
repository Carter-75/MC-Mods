/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmClassMappingKt
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.module.kotlin.KotlinModuleKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;

@Metadata(mv={1, 5, 1}, k=2, xi=48, d1={"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Ljava/lang/Class;", "beanClass", "", "objectSingletonInstance", "(Ljava/lang/Class;)Ljava/lang/Object;", "jackson-module-kotlin"})
public final class KotlinBeanDeserializerModifierKt {
    private static final Object objectSingletonInstance(Class<?> beanClass) {
        return !KotlinModuleKt.isKotlinClass(beanClass) ? null : JvmClassMappingKt.getKotlinClass(beanClass).getObjectInstance();
    }

    public static final /* synthetic */ Object access$objectSingletonInstance(Class beanClass) {
        return KotlinBeanDeserializerModifierKt.objectSingletonInstance(beanClass);
    }
}

