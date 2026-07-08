/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KType
 *  kotlin.reflect.jvm.KTypesJvm
 */
package com.fasterxml.jackson.module.kotlin;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.KTypesJvm;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=2, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001*\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ljava/lang/reflect/Type;", "Ljava/lang/Class;", "", "erasedType", "(Ljava/lang/reflect/Type;)Ljava/lang/Class;", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Ljava/lang/Class;", "jackson-module-kotlin"})
public final class TypesKt {
    @NotNull
    public static final Class<Object> erasedType(@NotNull Type $this$erasedType) {
        Class<Object> clazz;
        Intrinsics.checkNotNullParameter((Object)$this$erasedType, (String)"<this>");
        Type type = $this$erasedType;
        if (type instanceof Class) {
            clazz = (Class<Object>)$this$erasedType;
        } else if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType)$this$erasedType).getRawType();
            Intrinsics.checkNotNullExpressionValue((Object)type2, (String)"this.getRawType()");
            clazz = TypesKt.erasedType(type2);
        } else if (type instanceof GenericArrayType) {
            Type type3 = ((GenericArrayType)$this$erasedType).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue((Object)type3, (String)"this.getGenericComponentType()");
            Class<Object> elementType = TypesKt.erasedType(type3);
            Object testArray = Array.newInstance(elementType, 0);
            Intrinsics.checkNotNullExpressionValue((Object)testArray, (String)"testArray");
            clazz = testArray.getClass();
        } else {
            if (type instanceof TypeVariable) {
                throw new IllegalStateException("Not sure what to do here yet");
            }
            if (type instanceof WildcardType) {
                Type type4 = ((WildcardType)$this$erasedType).getUpperBounds()[0];
                Intrinsics.checkNotNullExpressionValue((Object)type4, (String)"this.getUpperBounds()[0]");
                clazz = TypesKt.erasedType(type4);
            } else {
                throw new IllegalStateException("Should not get here.");
            }
        }
        return clazz;
    }

    @NotNull
    public static final Class<? extends Object> erasedType(@NotNull KType $this$erasedType) {
        Intrinsics.checkNotNullParameter((Object)$this$erasedType, (String)"<this>");
        return JvmClassMappingKt.getJavaClass((KClass)KTypesJvm.getJvmErasure((KType)$this$erasedType));
    }
}

