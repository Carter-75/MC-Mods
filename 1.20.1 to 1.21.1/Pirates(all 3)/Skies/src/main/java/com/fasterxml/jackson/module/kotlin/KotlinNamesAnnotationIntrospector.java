/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KAnnotatedElement
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KParameter$Kind
 *  kotlin.reflect.KProperty1
 *  kotlin.reflect.full.KClasses
 *  kotlin.reflect.jvm.ReflectJvmMapping
 *  kotlin.reflect.jvm.internal.KotlinReflectionInternalError
 *  kotlin.text.CharsKt
 *  kotlin.text.StringsKt
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.fasterxml.jackson.module.kotlin.KotlinModuleKt;
import com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospectorKt;
import com.fasterxml.jackson.module.kotlin.ReflectionCache;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0010\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001e\u00a2\u0006\u0004\b)\u0010*J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ-\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0017H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001e8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010%\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006+"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinNamesAnnotationIntrospector;", "Lcom/fasterxml/jackson/databind/introspect/NopAnnotationIntrospector;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;", "member", "", "findImplicitPropertyName", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/String;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;", "param", "findKotlinParameterName", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;)Ljava/lang/String;", "Lcom/fasterxml/jackson/databind/cfg/MapperConfig;", "config", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;", "field", "Lcom/fasterxml/jackson/databind/PropertyName;", "implName", "findRenameByField", "(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;Lcom/fasterxml/jackson/databind/PropertyName;)Lcom/fasterxml/jackson/databind/PropertyName;", "Lcom/fasterxml/jackson/databind/introspect/Annotated;", "", "hasCreatorAnnotation", "(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Z", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;)Z", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "cache", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "getCache", "()Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "", "Lkotlin/reflect/KClass;", "ignoredClassesForImplyingJsonCreator", "Ljava/util/Set;", "getIgnoredClassesForImplyingJsonCreator", "()Ljava/util/Set;", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "module", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "getModule", "()Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "<init>", "(Lcom/fasterxml/jackson/module/kotlin/KotlinModule;Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;Ljava/util/Set;)V", "jackson-module-kotlin"})
public final class KotlinNamesAnnotationIntrospector
extends NopAnnotationIntrospector {
    @NotNull
    private final KotlinModule module;
    @NotNull
    private final ReflectionCache cache;
    @NotNull
    private final Set<KClass<?>> ignoredClassesForImplyingJsonCreator;

    public KotlinNamesAnnotationIntrospector(@NotNull KotlinModule module, @NotNull ReflectionCache cache2, @NotNull Set<? extends KClass<?>> ignoredClassesForImplyingJsonCreator) {
        Intrinsics.checkNotNullParameter((Object)module, (String)"module");
        Intrinsics.checkNotNullParameter((Object)cache2, (String)"cache");
        Intrinsics.checkNotNullParameter(ignoredClassesForImplyingJsonCreator, (String)"ignoredClassesForImplyingJsonCreator");
        this.module = module;
        this.cache = cache2;
        this.ignoredClassesForImplyingJsonCreator = ignoredClassesForImplyingJsonCreator;
    }

    @NotNull
    public final KotlinModule getModule() {
        return this.module;
    }

    @NotNull
    public final ReflectionCache getCache() {
        return this.cache;
    }

    @NotNull
    public final Set<KClass<?>> getIgnoredClassesForImplyingJsonCreator() {
        return this.ignoredClassesForImplyingJsonCreator;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public String findImplicitPropertyName(@NotNull AnnotatedMember member) {
        String string;
        Intrinsics.checkNotNullParameter((Object)member, (String)"member");
        AnnotatedMember annotatedMember = member;
        if (annotatedMember instanceof AnnotatedMethod) {
            String string2 = ((AnnotatedMethod)member).getName();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"member.name");
            if (StringsKt.contains$default((CharSequence)string2, (char)'-', (boolean)false, (int)2, null) && ((AnnotatedMethod)member).getParameterCount() == 0) {
                String string3;
                String string4 = ((AnnotatedMethod)member).getName();
                Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"member.name");
                if (StringsKt.startsWith$default((String)string4, (String)"get", (boolean)false, (int)2, null)) {
                    string4 = ((AnnotatedMethod)member).getName();
                    Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"member.name");
                    string3 = StringsKt.substringAfter$default((String)string4, (String)"get", null, (int)2, null);
                } else {
                    string4 = ((AnnotatedMethod)member).getName();
                    Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"member.name");
                    if (StringsKt.startsWith$default((String)string4, (String)"is", (boolean)false, (int)2, null)) {
                        string4 = ((AnnotatedMethod)member).getName();
                        Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"member.name");
                        string3 = StringsKt.substringAfter$default((String)string4, (String)"is", null, (int)2, null);
                    } else {
                        string3 = string2 = null;
                    }
                }
                if (string2 == null) {
                    string = null;
                } else {
                    String string5;
                    String string6 = string2;
                    boolean bl = false;
                    CharSequence charSequence = string6;
                    int n2 = 0;
                    if (charSequence.length() > 0) {
                        void it;
                        char c2 = string6.charAt(0);
                        StringBuilder stringBuilder = new StringBuilder();
                        boolean bl2 = false;
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault()");
                        String string7 = CharsKt.lowercase((char)it, (Locale)locale);
                        StringBuilder stringBuilder2 = stringBuilder.append(string7.toString());
                        charSequence = string6;
                        n2 = 1;
                        c2 = '\u0000';
                        String string8 = ((String)charSequence).substring(n2);
                        Intrinsics.checkNotNullExpressionValue((Object)string8, (String)"(this as java.lang.String).substring(startIndex)");
                        string5 = stringBuilder2.append(string8).toString();
                    } else {
                        string5 = string4 = string6;
                    }
                    string = string4 == null ? null : StringsKt.substringBefore$default((String)string4, (char)'-', null, (int)2, null);
                }
            } else {
                string = null;
            }
        } else {
            string = annotatedMember instanceof AnnotatedParameter ? this.findKotlinParameterName((AnnotatedParameter)member) : null;
        }
        return string;
    }

    @Override
    @Nullable
    public PropertyName findRenameByField(@NotNull MapperConfig<?> config, @NotNull AnnotatedField field, @NotNull PropertyName implName) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        Intrinsics.checkNotNullParameter((Object)implName, (String)"implName");
        String origSimple = implName.getSimpleName();
        Class<?> clazz = field.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(clazz, (String)"field.declaringClass");
        if (KotlinModuleKt.isKotlinClass(clazz)) {
            String mangledName;
            Intrinsics.checkNotNullExpressionValue((Object)origSimple, (String)"origSimple");
            if (StringsKt.startsWith$default((String)origSimple, (String)"is", (boolean)false, (int)2, null) && (mangledName = BeanUtil.stdManglePropertyName(origSimple, 2)) != null && !mangledName.equals(origSimple)) {
                return PropertyName.construct(mangledName);
            }
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    private final boolean hasCreatorAnnotation(AnnotatedConstructor member) {
        block24: {
            block28: {
                block22: {
                    block30: {
                        block29: {
                            block27: {
                                block19: {
                                    block26: {
                                        block25: {
                                            block17: {
                                                block23: {
                                                    var3_2 = member.getDeclaringClass();
                                                    if (var3_2 == null) {
                                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
                                                    }
                                                    var3_2 = this.cache.kotlinFromJava(var3_2);
                                                    var4_3 = false;
                                                    var5_5 = false;
                                                    $this$hasCreatorAnnotation_u24lambda_u2d1 = var3_2;
                                                    $i$a$-apply-KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$kClass$1 = false;
                                                    if (this.getIgnoredClassesForImplyingJsonCreator().contains($this$hasCreatorAnnotation_u24lambda_u2d1)) {
                                                        return false;
                                                    }
                                                    kClass = var3_2;
                                                    var5_6 = member.getAnnotated();
                                                    if (var5_6 == null) {
                                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<kotlin.Any>");
                                                    }
                                                    var4_4 = this.cache.kotlinFromJava((Constructor<Object>)var5_6);
                                                    if (var4_4 == null) {
                                                        return false;
                                                    }
                                                    kConstructor = var4_4;
                                                    $this$map$iv = KClasses.getMemberProperties(kClass);
                                                    $i$f$map = false;
                                                    $i$a$-apply-KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$kClass$1 = $this$map$iv;
                                                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                                                    $i$f$mapTo = false;
                                                    var10_22 = $this$mapTo$iv$iv.iterator();
                                                    while (var10_22.hasNext()) {
                                                        item$iv$iv = var10_22.next();
                                                        var12_28 = (KProperty1)item$iv$iv;
                                                        var27_32 = destination$iv$iv;
                                                        $i$a$-map-KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$propertyNames$1 = false;
                                                        var28_33 = it.getName();
                                                        var27_32.add(var28_33);
                                                    }
                                                    propertyNames = CollectionsKt.toSet((Iterable)((List)destination$iv$iv));
                                                    if (!KotlinNamesAnnotationIntrospectorKt.access$isPossibleSingleString(kConstructor, propertyNames)) break block23;
                                                    v0 = false;
                                                    break block24;
                                                }
                                                $this$any$iv = kConstructor.getParameters();
                                                $i$f$any = false;
                                                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                                    v1 = false;
                                                } else {
                                                    for (T element$iv : $this$any$iv) {
                                                        it = (KParameter)element$iv;
                                                        $i$a$-any-KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$1 = false;
                                                        if (!(it.getName() == null)) continue;
                                                        v1 = true;
                                                        break block17;
                                                    }
                                                    v1 = false;
                                                }
                                            }
                                            if (!v1) break block25;
                                            v0 = false;
                                            break block24;
                                        }
                                        if (KotlinNamesAnnotationIntrospectorKt.access$isPrimaryConstructor(kClass, kConstructor)) break block26;
                                        v0 = false;
                                        break block24;
                                    }
                                    $i$f$any = KotlinNamesAnnotationIntrospectorKt.access$filterOutSingleStringCallables(kClass.getConstructors(), propertyNames);
                                    $i$f$any = false;
                                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                        v2 = false;
                                    } else {
                                        for (T element$iv : $this$any$iv) {
                                            block18: {
                                                it = (KFunction)element$iv;
                                                $i$a$-any-KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$anyConstructorHasJsonCreator$1 = false;
                                                $this$hasAnnotation$iv = (KAnnotatedElement)it;
                                                $i$f$hasAnnotation = false;
                                                $this$findAnnotation$iv$iv = $this$hasAnnotation$iv;
                                                $i$f$findAnnotation = false;
                                                $this$firstOrNull$iv$iv$iv = $this$findAnnotation$iv$iv.getAnnotations();
                                                $i$f$firstOrNull = false;
                                                for (T element$iv$iv$iv : $this$firstOrNull$iv$iv$iv) {
                                                    it$iv$iv = (Annotation)element$iv$iv$iv;
                                                    $i$a$-firstOrNull-KAnnotatedElements$findAnnotation$1$iv$iv = false;
                                                    if (!(it$iv$iv instanceof JsonCreator)) continue;
                                                    v3 = element$iv$iv$iv;
                                                    break block18;
                                                }
                                                v3 = null;
                                            }
                                            v4 = (Annotation)v3 != null;
                                            if (!v4) continue;
                                            v2 = true;
                                            break block19;
                                        }
                                        v2 = false;
                                    }
                                }
                                anyConstructorHasJsonCreator = v2;
                                var8_17 = member.getType().getRawClass();
                                Intrinsics.checkNotNullExpressionValue((Object)var8_17, (String)"member.type.rawClass");
                                var7_15 = KClasses.getCompanionObject((KClass)JvmClassMappingKt.getKotlinClass((Class)var8_17));
                                if (var7_15 != null) break block27;
                                v5 = false;
                                break block28;
                            }
                            var8_17 = KClasses.getDeclaredFunctions((KClass)var7_15);
                            if (var8_17 != null) break block29;
                            v5 = false;
                            break block28;
                        }
                        var9_21 = KotlinNamesAnnotationIntrospectorKt.access$filterOutSingleStringCallables((Collection)var8_17, propertyNames);
                        $i$a$-any-KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$anyConstructorHasJsonCreator$1 = var9_21;
                        $i$f$any = false;
                        if (!($this$any$iv instanceof Collection) || !((Collection)$this$any$iv).isEmpty()) break block30;
                        v6 = false;
                        break block22;
                    }
                    for (T element$iv : $this$any$iv) {
                        block21: {
                            block20: {
                                it = (KFunction)element$iv;
                                $i$a$-any-KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$anyCompanionMethodIsJsonCreator$1 = false;
                                $this$hasAnnotation$iv = (KAnnotatedElement)it;
                                $i$f$hasAnnotation = false;
                                $this$findAnnotation$iv$iv = $this$hasAnnotation$iv;
                                $i$f$findAnnotation = false;
                                $this$firstOrNull$iv$iv$iv = $this$findAnnotation$iv$iv.getAnnotations();
                                $i$f$firstOrNull = false;
                                for (T element$iv$iv$iv : $this$firstOrNull$iv$iv$iv) {
                                    it$iv$iv = (Annotation)element$iv$iv$iv;
                                    $i$a$-firstOrNull-KAnnotatedElements$findAnnotation$1$iv$iv = false;
                                    if (!(it$iv$iv instanceof JsonCreator)) continue;
                                    v7 = element$iv$iv$iv;
                                    break block20;
                                }
                                v7 = null;
                            }
                            v8 = (Annotation)v7 != null;
                            if (!v8) ** GOTO lbl-1000
                            $this$hasAnnotation$iv = (KAnnotatedElement)it;
                            $i$f$hasAnnotation = false;
                            $this$findAnnotation$iv$iv = $this$hasAnnotation$iv;
                            $i$f$findAnnotation = false;
                            $this$firstOrNull$iv$iv$iv = $this$findAnnotation$iv$iv.getAnnotations();
                            $i$f$firstOrNull = false;
                            for (T element$iv$iv$iv : $this$firstOrNull$iv$iv$iv) {
                                it$iv$iv = (Annotation)element$iv$iv$iv;
                                $i$a$-firstOrNull-KAnnotatedElements$findAnnotation$1$iv$iv = false;
                                if (!(it$iv$iv instanceof JvmStatic)) continue;
                                v9 = element$iv$iv$iv;
                                break block21;
                            }
                            v9 = null;
                        }
                        v10 = (Annotation)((JvmStatic)v9) != null;
                        if (v10) {
                            v11 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v11 = false;
                        }
                        if (!v11) continue;
                        v6 = true;
                        break block22;
                    }
                    v6 = false;
                }
                v5 = var10_24 = v6;
            }
            anyCompanionMethodIsJsonCreator = v5;
            v0 = anyConstructorHasJsonCreator == false && anyCompanionMethodIsJsonCreator == false;
        }
        return v0;
    }

    @Override
    public boolean hasCreatorAnnotation(@NotNull Annotated member) {
        Intrinsics.checkNotNullParameter((Object)member, (String)"member");
        return member instanceof AnnotatedConstructor && KotlinNamesAnnotationIntrospectorKt.access$isKotlinConstructorWithParameters((AnnotatedConstructor)member) ? this.cache.checkConstructorIsCreatorAnnotated((AnnotatedConstructor)member, (Function1<? super AnnotatedConstructor, Boolean>)((Function1)new Function1<AnnotatedConstructor, Boolean>(this){
            final /* synthetic */ KotlinNamesAnnotationIntrospector this$0;
            {
                this.this$0 = $receiver;
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull AnnotatedConstructor it) {
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                return KotlinNamesAnnotationIntrospector.access$hasCreatorAnnotation(this.this$0, it);
            }
        })) : false;
    }

    private final String findKotlinParameterName(AnnotatedParameter param) {
        Object object;
        Class<?> clazz = param.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(clazz, (String)"param.declaringClass");
        if (KotlinModuleKt.isKotlinClass(clazz)) {
            Member member = param.getOwner().getMember();
            if (member instanceof Constructor) {
                KParameter kParameter;
                KFunction kFunction;
                int n2;
                List list;
                Constructor ctor = (Constructor)member;
                int ctorParmCount = ctor.getParameterTypes().length;
                try {
                    int n3;
                    KFunction kFunction2 = ReflectJvmMapping.getKotlinFunction((Constructor)ctor);
                    n2 = kFunction2 == null ? 0 : ((list = kFunction2.getParameters()) == null ? 0 : (n3 = list.size()));
                }
                catch (KotlinReflectionInternalError ex) {
                    n2 = 0;
                }
                catch (UnsupportedOperationException ex) {
                    n2 = 0;
                }
                int ktorParmCount = n2;
                object = ktorParmCount > 0 && ktorParmCount == ctorParmCount ? ((kFunction = ReflectJvmMapping.getKotlinFunction((Constructor)ctor)) == null ? null : ((list = kFunction.getParameters()) == null ? null : ((kParameter = (KParameter)list.get(param.getIndex())) == null ? null : kParameter.getName()))) : (String)null;
            } else if (member instanceof Method) {
                String string;
                try {
                    KParameter kParameter;
                    int n4;
                    List list;
                    int parmCount;
                    KParameter kParameter2;
                    List list2;
                    KFunction temp;
                    KFunction ktorParmCount = temp = ReflectJvmMapping.getKotlinFunction((Method)((Method)member));
                    KParameter.Kind firstParamKind = ktorParmCount == null ? null : ((list2 = ktorParmCount.getParameters()) == null ? null : ((kParameter2 = (KParameter)CollectionsKt.firstOrNull((List)list2)) == null ? null : kParameter2.getKind()));
                    int idx = firstParamKind != KParameter.Kind.VALUE ? param.getIndex() + 1 : param.getIndex();
                    kParameter2 = temp;
                    int n5 = kParameter2 == null ? 0 : (parmCount = (list = kParameter2.getParameters()) == null ? 0 : (n4 = list.size()));
                    string = parmCount > idx ? ((kParameter2 = temp) == null ? null : ((list = kParameter2.getParameters()) == null ? null : ((kParameter = (KParameter)list.get(idx)) == null ? null : kParameter.getName()))) : (String)null;
                }
                catch (KotlinReflectionInternalError ex) {
                    string = null;
                }
                object = string;
            } else {
                object = null;
            }
        } else {
            object = null;
        }
        return object;
    }

    public static final /* synthetic */ boolean access$hasCreatorAnnotation(KotlinNamesAnnotationIntrospector $this, AnnotatedConstructor member) {
        return $this.hasCreatorAnnotation(member);
    }
}

