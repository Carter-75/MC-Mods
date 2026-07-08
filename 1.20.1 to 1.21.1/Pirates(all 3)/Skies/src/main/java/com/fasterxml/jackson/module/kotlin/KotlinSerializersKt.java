/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv={1, 5, 1}, k=2, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "getStaticJsonValueGetter", "(Ljava/lang/Class;)Ljava/lang/reflect/Method;", "jackson-module-kotlin"})
public final class KotlinSerializersKt {
    /*
     * Unable to fully structure code
     */
    private static final Method getStaticJsonValueGetter(Class<?> $this$getStaticJsonValueGetter) {
        block5: {
            var1_1 = $this$getStaticJsonValueGetter.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue((Object)var1_1, (String)"this.declaredMethods");
            var1_1 = var1_1;
            var2_2 = false;
            var3_3 = var1_1;
            var4_4 = false;
            for (Object var8_8 : var3_3) {
                block4: {
                    method = (Method)var8_8;
                    $i$a$-find-KotlinSerializersKt$getStaticJsonValueGetter$1 = false;
                    if (!Modifier.isStatic(method.getModifiers())) ** GOTO lbl-1000
                    var11_11 = method.getAnnotations();
                    Intrinsics.checkNotNullExpressionValue((Object)var11_11, (String)"method.annotations");
                    $this$any$iv = var11_11;
                    $i$f$any = false;
                    for (Object element$iv : $this$any$iv) {
                        it = (Annotation)element$iv;
                        $i$a$-any-KotlinSerializersKt$getStaticJsonValueGetter$1$1 = false;
                        if (!(it instanceof JsonValue)) continue;
                        v0 = true;
                        break block4;
                    }
                    v0 = false;
                }
                if (v0) {
                    v1 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v1 = false;
                }
                if (!v1) continue;
                v2 = var8_8;
                break block5;
            }
            v2 = null;
        }
        return (Method)v2;
    }

    public static final /* synthetic */ Method access$getStaticJsonValueGetter(Class $receiver) {
        return KotlinSerializersKt.getStaticJsonValueGetter($receiver);
    }
}

