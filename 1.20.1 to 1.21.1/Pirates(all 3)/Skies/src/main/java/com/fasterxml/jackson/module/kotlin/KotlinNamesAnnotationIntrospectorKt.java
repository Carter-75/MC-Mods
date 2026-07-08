/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KAnnotatedElement
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KType
 *  kotlin.reflect.full.KClasses
 *  kotlin.reflect.jvm.ReflectJvmMapping
 *  kotlin.text.StringsKt
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.module.kotlin.KotlinModuleKt;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.StringsKt;

@Metadata(mv={1, 5, 1}, k=2, xi=48, d1={"\u00000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0003\u00a2\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u00020\b*\u00020\u000bH\u0002\u00a2\u0006\u0004\b\f\u0010\r\u001a%\u0010\u000e\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0012\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"", "Lkotlin/reflect/KFunction;", "", "", "propertyNames", "filterOutSingleStringCallables", "(Ljava/util/Collection;Ljava/util/Set;)Ljava/util/Collection;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;", "", "isInlineClass", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Z", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;", "isKotlinConstructorWithParameters", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;)Z", "isPossibleSingleString", "(Lkotlin/reflect/KFunction;Ljava/util/Set;)Z", "Lkotlin/reflect/KClass;", "kConstructor", "isPrimaryConstructor", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KFunction;)Z", "jackson-module-kotlin"})
public final class KotlinNamesAnnotationIntrospectorKt {
    @Deprecated(message="To be removed in 2.14", replaceWith=@ReplaceWith(expression="with(receiver) { declaringClass.declaredMethods.any { it.name.contains('-') } }", imports={}))
    private static final boolean isInlineClass(AnnotatedMethod $this$isInlineClass) {
        boolean bl;
        block1: {
            Method[] methodArray = $this$isInlineClass.getDeclaringClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue((Object)methodArray, (String)"declaringClass.declaredMethods");
            Object[] $this$any$iv = methodArray;
            boolean $i$f$any = false;
            for (Object element$iv : $this$any$iv) {
                Method it = (Method)element$iv;
                boolean bl2 = false;
                String string = it.getName();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"it.name");
                if (!StringsKt.contains$default((CharSequence)string, (char)'-', (boolean)false, (int)2, null)) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean isKotlinConstructorWithParameters(AnnotatedConstructor $this$isKotlinConstructorWithParameters) {
        if ($this$isKotlinConstructorWithParameters.getParameterCount() <= 0) return false;
        Class<?> clazz = $this$isKotlinConstructorWithParameters.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(clazz, (String)"declaringClass");
        if (!KotlinModuleKt.isKotlinClass(clazz)) return false;
        if ($this$isKotlinConstructorWithParameters.getDeclaringClass().isEnum()) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean isPossibleSingleString(KFunction<?> $this$isPossibleSingleString, Set<String> propertyNames) {
        Object v0;
        block1: {
            if ($this$isPossibleSingleString.getParameters().size() != 1) return false;
            if (CollectionsKt.contains((Iterable)propertyNames, (Object)((KParameter)$this$isPossibleSingleString.getParameters().get(0)).getName())) return false;
            if (!Intrinsics.areEqual((Object)ReflectJvmMapping.getJavaType((KType)((KParameter)$this$isPossibleSingleString.getParameters().get(0)).getType()), String.class)) return false;
            KAnnotatedElement $this$hasAnnotation$iv = (KAnnotatedElement)$this$isPossibleSingleString.getParameters().get(0);
            boolean $i$f$hasAnnotation = false;
            KAnnotatedElement $this$findAnnotation$iv$iv = $this$hasAnnotation$iv;
            boolean $i$f$findAnnotation = false;
            Iterable $this$firstOrNull$iv$iv$iv = $this$findAnnotation$iv$iv.getAnnotations();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv$iv$iv : $this$firstOrNull$iv$iv$iv) {
                Annotation it$iv$iv = (Annotation)element$iv$iv$iv;
                boolean bl = false;
                if (!(it$iv$iv instanceof JsonProperty)) continue;
                v0 = element$iv$iv$iv;
                break block1;
            }
            v0 = null;
        }
        if ((Annotation)v0 == null) return true;
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private static final Collection<KFunction<?>> filterOutSingleStringCallables(Collection<? extends KFunction<?>> $this$filterOutSingleStringCallables, Set<String> propertyNames) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = $this$filterOutSingleStringCallables;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KFunction it = (KFunction)element$iv$iv;
            boolean bl = false;
            if (!(!KotlinNamesAnnotationIntrospectorKt.isPossibleSingleString(it, propertyNames))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private static final boolean isPrimaryConstructor(KClass<?> $this$isPrimaryConstructor, KFunction<?> kConstructor) {
        KFunction kFunction = KClasses.getPrimaryConstructor($this$isPrimaryConstructor);
        boolean bl = false;
        boolean bl2 = false;
        KFunction it = kFunction;
        boolean bl3 = false;
        return Intrinsics.areEqual((Object)it, kConstructor) || it == null && $this$isPrimaryConstructor.getConstructors().size() == 1;
    }

    public static final /* synthetic */ boolean access$isPossibleSingleString(KFunction $receiver, Set propertyNames) {
        return KotlinNamesAnnotationIntrospectorKt.isPossibleSingleString($receiver, propertyNames);
    }

    public static final /* synthetic */ boolean access$isPrimaryConstructor(KClass $receiver, KFunction kConstructor) {
        return KotlinNamesAnnotationIntrospectorKt.isPrimaryConstructor($receiver, kConstructor);
    }

    public static final /* synthetic */ Collection access$filterOutSingleStringCallables(Collection $receiver, Set propertyNames) {
        return KotlinNamesAnnotationIntrospectorKt.filterOutSingleStringCallables($receiver, propertyNames);
    }

    public static final /* synthetic */ boolean access$isKotlinConstructorWithParameters(AnnotatedConstructor $receiver) {
        return KotlinNamesAnnotationIntrospectorKt.isKotlinConstructorWithParameters($receiver);
    }
}

