/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 */
package com.fasterxml.jackson.module.kotlin;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=2, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ljava/lang/Class;", "", "isKotlinClass", "(Ljava/lang/Class;)Z", "", "metadataFqName", "Ljava/lang/String;", "jackson-module-kotlin"})
public final class KotlinModuleKt {
    @NotNull
    private static final String metadataFqName = "kotlin.Metadata";

    public static final boolean isKotlinClass(@NotNull Class<?> $this$isKotlinClass) {
        boolean bl;
        block1: {
            Intrinsics.checkNotNullParameter($this$isKotlinClass, (String)"<this>");
            Annotation[] annotationArray = $this$isKotlinClass.getDeclaredAnnotations();
            Intrinsics.checkNotNullExpressionValue((Object)annotationArray, (String)"declaredAnnotations");
            Object[] $this$any$iv = annotationArray;
            boolean $i$f$any = false;
            for (Object element$iv : $this$any$iv) {
                Annotation it = (Annotation)element$iv;
                boolean bl2 = false;
                if (!Intrinsics.areEqual((Object)JvmClassMappingKt.getJavaClass((KClass)JvmClassMappingKt.getAnnotationClass((Annotation)it)).getName(), (Object)metadataFqName)) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }
}

