/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinVersion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KClassifier
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KMutableProperty
 *  kotlin.reflect.KMutableProperty1
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KProperty
 *  kotlin.reflect.KProperty1
 *  kotlin.reflect.KType
 *  kotlin.reflect.full.KClasses
 *  kotlin.reflect.full.KClassifiers
 *  kotlin.reflect.jvm.ReflectJvmMapping
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.fasterxml.jackson.module.kotlin.KotlinModuleKt;
import com.fasterxml.jackson.module.kotlin.ReflectionCache;
import com.fasterxml.jackson.module.kotlin.ValueClassBoxSerializer;
import com.fasterxml.jackson.module.kotlin.ValueClassStaticJsonValueSerializer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.ReflectJvmMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 D2\u00020\u0001:\u0001DB/\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010@\u001a\u00020\u0014\u0012\u0006\u0010A\u001a\u00020\u0014\u0012\u0006\u0010>\u001a\u00020\u0014\u00a2\u0006\u0004\bB\u0010CJ%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0014*\u00020\u001bH\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0014*\u00020\u001eH\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020!H\u0002\u00a2\u0006\u0004\b\u0015\u0010\"J\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020\u001eH\u0002\u00a2\u0006\u0004\b\u0015\u0010 J\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020#H\u0002\u00a2\u0006\u0004\b\u0015\u0010$J\u001f\u0010(\u001a\u00020\u0014*\u0006\u0012\u0002\b\u00030%2\u0006\u0010'\u001a\u00020&H\u0002\u00a2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u0014*\u0006\u0012\u0002\b\u00030%H\u0002\u00a2\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020\u0014*\u0006\u0012\u0002\b\u00030%2\u0006\u0010'\u001a\u00020&H\u0002\u00a2\u0006\u0004\b,\u0010)J\u001f\u0010-\u001a\u00020\u0014*\u0006\u0012\u0002\b\u00030%2\u0006\u0010'\u001a\u00020&H\u0002\u00a2\u0006\u0004\b-\u0010)J\u0013\u0010/\u001a\u00020\u0014*\u00020.H\u0002\u00a2\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u0004\u0018\u00010\u0014*\u000201H\u0002\u00a2\u0006\u0004\b2\u00103J\u0015\u00102\u001a\u0004\u0018\u00010\u0014*\u00020\u001bH\u0002\u00a2\u0006\u0004\b2\u0010\u001dJ\u001b\u00105\u001a\u00020\u0014*\n\u0012\u0002\b\u0003\u0012\u0002\b\u000304H\u0002\u00a2\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u0014*\u0006\u0012\u0002\b\u00030%H\u0002\u00a2\u0006\u0004\b7\u0010+R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010?R\u0014\u0010A\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010?\u00a8\u0006E"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinAnnotationIntrospector;", "Lcom/fasterxml/jackson/databind/introspect/NopAnnotationIntrospector;", "Lcom/fasterxml/jackson/databind/cfg/MapperConfig;", "config", "Lcom/fasterxml/jackson/databind/introspect/Annotated;", "a", "Lcom/fasterxml/jackson/annotation/JsonCreator$Mode;", "findCreatorAnnotation", "(Lcom/fasterxml/jackson/databind/cfg/MapperConfig;Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/annotation/JsonCreator$Mode;", "am", "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "findNullSerializer", "(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "findSerializer", "", "Lcom/fasterxml/jackson/databind/jsontype/NamedType;", "findSubtypes", "(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Ljava/util/List;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;", "m", "", "hasRequiredMarker", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Boolean;", "byAnnotation", "byNullability", "requiredAnnotationOrNullability", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "Ljava/lang/reflect/Method;", "getRequiredMarkerFromAccessorLikeMethod", "(Ljava/lang/reflect/Method;)Ljava/lang/Boolean;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;", "getRequiredMarkerFromCorrespondingAccessor", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;)Ljava/lang/Boolean;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;)Ljava/lang/Boolean;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;)Ljava/lang/Boolean;", "Lkotlin/reflect/KFunction;", "", "index", "isConstructorParameterRequired", "(Lkotlin/reflect/KFunction;I)Z", "isGetterLike", "(Lkotlin/reflect/KFunction;)Z", "isMethodParameterRequired", "isParameterRequired", "Lkotlin/reflect/KType;", "isRequired", "(Lkotlin/reflect/KType;)Z", "Ljava/lang/reflect/AccessibleObject;", "isRequiredByAnnotation", "(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/Boolean;", "Lkotlin/reflect/KProperty1;", "isRequiredByNullability", "(Lkotlin/reflect/KProperty1;)Z", "isSetterLike", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "cache", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "Lcom/fasterxml/jackson/databind/Module$SetupContext;", "context", "Lcom/fasterxml/jackson/databind/Module$SetupContext;", "nullIsSameAsDefault", "Z", "nullToEmptyCollection", "nullToEmptyMap", "<init>", "(Lcom/fasterxml/jackson/databind/Module$SetupContext;Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;ZZZ)V", "Companion", "jackson-module-kotlin"})
public final class KotlinAnnotationIntrospector
extends NopAnnotationIntrospector {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Module.SetupContext context;
    @NotNull
    private final ReflectionCache cache;
    private final boolean nullToEmptyCollection;
    private final boolean nullToEmptyMap;
    private final boolean nullIsSameAsDefault;
    @NotNull
    private static final KType UNIT_TYPE = KClassifiers.createType$default((KClassifier)((KClassifier)Reflection.getOrCreateKotlinClass(Unit.class)), null, (boolean)false, null, (int)7, null);

    public KotlinAnnotationIntrospector(@NotNull Module.SetupContext context, @NotNull ReflectionCache cache2, boolean nullToEmptyCollection, boolean nullToEmptyMap, boolean nullIsSameAsDefault) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)cache2, (String)"cache");
        this.context = context;
        this.cache = cache2;
        this.nullToEmptyCollection = nullToEmptyCollection;
        this.nullToEmptyMap = nullToEmptyMap;
        this.nullIsSameAsDefault = nullIsSameAsDefault;
    }

    @Override
    @Nullable
    public Boolean hasRequiredMarker(@NotNull AnnotatedMember m2) {
        Intrinsics.checkNotNullParameter((Object)m2, (String)"m");
        Boolean hasRequired2 = this.cache.javaMemberIsRequired(m2, (Function1<? super AnnotatedMember, Boolean>)((Function1)new Function1<AnnotatedMember, Boolean>(this, m2){
            final /* synthetic */ KotlinAnnotationIntrospector this$0;
            final /* synthetic */ AnnotatedMember $m;
            {
                this.this$0 = $receiver;
                this.$m = $m;
                super(1);
            }

            @Nullable
            public final Boolean invoke(@NotNull AnnotatedMember it) {
                Serializable serializable;
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                try {
                    Boolean bl;
                    if (KotlinAnnotationIntrospector.access$getNullToEmptyCollection$p(this.this$0) && this.$m.getType().isCollectionLikeType()) {
                        bl = false;
                    } else if (KotlinAnnotationIntrospector.access$getNullToEmptyMap$p(this.this$0) && this.$m.getType().isMapLikeType()) {
                        bl = false;
                    } else {
                        serializable = this.$m.getMember().getDeclaringClass();
                        Intrinsics.checkNotNullExpressionValue((Object)serializable, (String)"m.member.declaringClass");
                        bl = KotlinModuleKt.isKotlinClass(serializable) ? ((serializable = this.$m) instanceof AnnotatedField ? KotlinAnnotationIntrospector.access$hasRequiredMarker(this.this$0, (AnnotatedField)this.$m) : (serializable instanceof AnnotatedMethod ? KotlinAnnotationIntrospector.access$hasRequiredMarker(this.this$0, (AnnotatedMethod)this.$m) : (serializable instanceof AnnotatedParameter ? KotlinAnnotationIntrospector.access$hasRequiredMarker(this.this$0, (AnnotatedParameter)this.$m) : null))) : null;
                    }
                    serializable = bl;
                }
                catch (UnsupportedOperationException ex) {
                    serializable = null;
                }
                return serializable;
            }
        }));
        return hasRequired2;
    }

    @Override
    @Nullable
    public JsonCreator.Mode findCreatorAnnotation(@NotNull MapperConfig<?> config, @NotNull Annotated a2) {
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Intrinsics.checkNotNullParameter((Object)a2, (String)"a");
        return super.findCreatorAnnotation(config, a2);
    }

    @Override
    @Nullable
    public StdSerializer<?> findSerializer(@NotNull Annotated am) {
        StdSerializer stdSerializer;
        Intrinsics.checkNotNullParameter((Object)am, (String)"am");
        Annotated annotated = am;
        if (annotated instanceof AnnotatedMethod) {
            boolean bl = KotlinVersion.CURRENT.isAtLeast(1, 5);
            if (bl) {
                KType kType;
                KProperty1 kotlinProperty;
                KProperty1 kProperty1;
                Collection<Object> collection;
                Method method = ((AnnotatedMethod)am).getMember();
                boolean bl2 = false;
                boolean bl3 = false;
                Method $this$findSerializer_u24lambda_u2d0 = method;
                boolean bl4 = false;
                Class<?> clazz = $this$findSerializer_u24lambda_u2d0.getReturnType();
                Intrinsics.checkNotNullExpressionValue(clazz, (String)"this.returnType");
                if (ExtensionsKt.isUnboxableValueClass(clazz)) {
                    return null;
                }
                Method getter = method;
                Object object = getter.getDeclaringClass();
                Intrinsics.checkNotNullExpressionValue(object, (String)"getter\n                        .declaringClass");
                object = JvmClassMappingKt.getKotlinClass(object);
                boolean bl5 = false;
                boolean bl6 = false;
                KClass it = object;
                boolean bl72 = false;
                try {
                    collection = KClasses.getMemberProperties((KClass)it);
                }
                catch (Error e2) {
                    collection = null;
                }
                Collection collection2 = collection;
                if (collection2 == null) {
                    kProperty1 = null;
                } else {
                    Collection<Object> collection3;
                    block16: {
                        object = collection2;
                        bl5 = false;
                        Object object2 = object;
                        boolean bl8 = false;
                        Iterator bl72 = object2.iterator();
                        while (bl72.hasNext()) {
                            collection = bl72.next();
                            KProperty1 it2 = (KProperty1)collection;
                            boolean bl9 = false;
                            if (!Intrinsics.areEqual((Object)ReflectJvmMapping.getJavaGetter((KProperty)((KProperty)it2)), (Object)getter)) continue;
                            collection3 = collection;
                            break block16;
                        }
                        collection3 = null;
                    }
                    kProperty1 = (KProperty1)collection3;
                }
                Object object3 = kotlinProperty = kProperty1;
                object = object3 == null ? null : ((kType = object3.getReturnType()) == null ? null : kType.getClassifier());
                Object object4 = collection2 = object instanceof KClass ? (KClass)object : null;
                if (collection2 == null) {
                    stdSerializer = null;
                } else {
                    object3 = collection2;
                    boolean bl10 = false;
                    boolean bl11 = false;
                    Object it3 = object3;
                    boolean bl12 = false;
                    Object object5 = object = it3.isValue() ? object3 : null;
                    if (object == null) {
                        stdSerializer = null;
                    } else {
                        object3 = JvmClassMappingKt.getJavaClass((KClass)object);
                        if (object3 == null) {
                            stdSerializer = null;
                        } else {
                            Object object6 = object3;
                            bl11 = false;
                            boolean bl13 = false;
                            Object outerClazz = object6;
                            boolean bl14 = false;
                            Class<?> innerClazz = getter.getReturnType();
                            Intrinsics.checkNotNullExpressionValue(innerClazz, (String)"innerClazz");
                            ValueClassStaticJsonValueSerializer<?> valueClassStaticJsonValueSerializer = ValueClassStaticJsonValueSerializer.Companion.createdOrNull((Class<? extends Object>)outerClazz, innerClazz);
                            stdSerializer = valueClassStaticJsonValueSerializer == null ? (StdSerializer)new ValueClassBoxSerializer((Class<? extends Object>)outerClazz, innerClazz) : (StdSerializer)valueClassStaticJsonValueSerializer;
                        }
                    }
                }
            } else {
                stdSerializer = null;
            }
        } else {
            stdSerializer = null;
        }
        return stdSerializer;
    }

    @Override
    @Nullable
    public StdSerializer<?> findNullSerializer(@NotNull Annotated am) {
        Intrinsics.checkNotNullParameter((Object)am, (String)"am");
        return this.findSerializer(am);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public List<NamedType> findSubtypes(@NotNull Annotated a2) {
        List list;
        Class<?> clazz;
        Intrinsics.checkNotNullParameter((Object)a2, (String)"a");
        Class<?> clazz2 = a2.getRawType();
        boolean bl = false;
        boolean bl2 = false;
        Class<?> it = clazz2;
        boolean bl3 = false;
        Intrinsics.checkNotNullExpressionValue(it, (String)"it");
        Class<Object> clazz3 = clazz = KotlinModuleKt.isKotlinClass(it) ? clazz2 : null;
        if (clazz == null) {
            list = null;
        } else {
            Iterable iterable;
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            clazz2 = clazz;
            bl = false;
            bl2 = false;
            Class<?> rawType = clazz2;
            boolean bl4 = false;
            Iterable iterable2 = JvmClassMappingKt.getKotlinClass(rawType).getSealedSubclasses();
            boolean $i$f$map = false;
            void var10_10 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                KClass kClass = (KClass)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl5 = false;
                NamedType namedType = new NamedType(JvmClassMappingKt.getJavaClass((KClass)it2));
                collection.add(namedType);
            }
            iterable2 = CollectionsKt.toMutableList((Collection)((List)destination$iv$iv));
            boolean bl6 = false;
            if (iterable2.isEmpty()) {
                boolean bl7 = false;
                iterable = null;
            } else {
                iterable = iterable2;
            }
            list = (List)iterable;
        }
        return list;
    }

    private final Boolean hasRequiredMarker(AnnotatedField $this$hasRequiredMarker) {
        Member member = $this$hasRequiredMarker.getMember();
        if (member == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Field");
        }
        Boolean byAnnotation = this.isRequiredByAnnotation((Field)member);
        Member member2 = $this$hasRequiredMarker.getMember();
        if (member2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Field");
        }
        KProperty kProperty = ReflectJvmMapping.getKotlinProperty((Field)((Field)member2));
        Boolean byNullability = kProperty == null ? null : ((member2 = kProperty.getReturnType()) == null ? null : Boolean.valueOf(this.isRequired((KType)member2)));
        return this.requiredAnnotationOrNullability(byAnnotation, byNullability);
    }

    /*
     * WARNING - void declaration
     */
    private final Boolean isRequiredByAnnotation(AccessibleObject $this$isRequiredByAnnotation) {
        Boolean bl;
        Annotation[] annotationArray = $this$isRequiredByAnnotation.getAnnotations();
        if (annotationArray == null) {
            bl = null;
        } else {
            Object var3_15;
            int n2;
            Object object;
            block5: {
                Object v1;
                void $this$firstOrNull$iv;
                object = annotationArray;
                boolean $i$f$firstOrNull = false;
                void var6_6 = $this$firstOrNull$iv;
                n2 = ((void)var6_6).length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    void element$iv;
                    void it = element$iv = var6_6[i2];
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)JvmClassMappingKt.getAnnotationClass((Annotation)it), (Object)Reflection.getOrCreateKotlinClass(JsonProperty.class))) continue;
                    v1 = element$iv;
                    break block5;
                }
                v1 = var3_15 = null;
            }
            if (var3_15 == null) {
                bl = null;
            } else {
                Object var5_5 = var3_15;
                boolean bl3 = false;
                n2 = 0;
                Object it = var5_5;
                boolean bl4 = false;
                object = it;
                bl = object.required();
            }
        }
        return bl;
    }

    private final Boolean requiredAnnotationOrNullability(Boolean byAnnotation, Boolean byNullability) {
        if (byAnnotation != null && byNullability != null) {
            return byAnnotation != false || byNullability != false;
        }
        if (byNullability != null) {
            return byNullability;
        }
        return byAnnotation;
    }

    private final Boolean isRequiredByAnnotation(Method $this$isRequiredByAnnotation) {
        Object object;
        block1: {
            Annotation[] annotationArray = $this$isRequiredByAnnotation.getAnnotations();
            Intrinsics.checkNotNullExpressionValue((Object)annotationArray, (String)"this.annotations");
            Object[] $this$firstOrNull$iv = annotationArray;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                Annotation it = (Annotation)element$iv;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)JvmClassMappingKt.getJavaClass((KClass)JvmClassMappingKt.getAnnotationClass((Annotation)it)), JsonProperty.class)) continue;
                object = element$iv;
                break block1;
            }
            object = null;
        }
        Object object2 = object;
        JsonProperty jsonProperty = object2 instanceof JsonProperty ? (JsonProperty)object2 : null;
        return jsonProperty == null ? null : Boolean.valueOf(jsonProperty.required());
    }

    private final boolean isRequiredByNullability(KProperty1<?, ?> $this$isRequiredByNullability) {
        return this.isRequired($this$isRequiredByNullability.getReturnType());
    }

    private final Boolean hasRequiredMarker(AnnotatedMethod $this$hasRequiredMarker) {
        Boolean bl;
        Boolean bl2 = this.getRequiredMarkerFromCorrespondingAccessor($this$hasRequiredMarker);
        if (bl2 == null) {
            Method method = $this$hasRequiredMarker.getMember();
            Intrinsics.checkNotNullExpressionValue((Object)method, (String)"this.member");
            bl = this.getRequiredMarkerFromAccessorLikeMethod(method);
        } else {
            bl = bl2;
        }
        return bl;
    }

    private final Boolean getRequiredMarkerFromCorrespondingAccessor(AnnotatedMethod $this$getRequiredMarkerFromCorrespondingAccessor) {
        Class<?> clazz = $this$getRequiredMarkerFromCorrespondingAccessor.getMember().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(clazz, (String)"member.declaringClass");
        Iterable $this$forEach$iv = KClasses.getDeclaredMemberProperties((KClass)JvmClassMappingKt.getKotlinClass(clazz));
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KMutableProperty1 kMutableProperty1;
            KProperty1 kProperty = (KProperty1)element$iv;
            boolean bl = false;
            if (!Intrinsics.areEqual((Object)ReflectJvmMapping.getJavaGetter((KProperty)((KProperty)kProperty)), (Object)$this$getRequiredMarkerFromCorrespondingAccessor.getMember()) && !Intrinsics.areEqual((Object)((kMutableProperty1 = kProperty instanceof KMutableProperty1 ? (KMutableProperty1)kProperty : null) == null ? null : ReflectJvmMapping.getJavaSetter((KMutableProperty)((KMutableProperty)kMutableProperty1))), (Object)$this$getRequiredMarkerFromCorrespondingAccessor.getMember())) continue;
            Method method = $this$getRequiredMarkerFromCorrespondingAccessor.getMember();
            Intrinsics.checkNotNullExpressionValue((Object)method, (String)"this.member");
            Boolean byAnnotation = this.isRequiredByAnnotation(method);
            boolean byNullability = this.isRequiredByNullability(kProperty);
            return this.requiredAnnotationOrNullability(byAnnotation, byNullability);
        }
        return null;
    }

    private final Boolean getRequiredMarkerFromAccessorLikeMethod(Method $this$getRequiredMarkerFromAccessorLikeMethod) {
        KFunction kFunction = ReflectJvmMapping.getKotlinFunction((Method)$this$getRequiredMarkerFromAccessorLikeMethod);
        if (kFunction != null) {
            KFunction kFunction2 = kFunction;
            boolean bl = false;
            boolean bl2 = false;
            KFunction method = kFunction2;
            boolean bl3 = false;
            Boolean byAnnotation = this.isRequiredByAnnotation($this$getRequiredMarkerFromAccessorLikeMethod);
            return this.isGetterLike(method) ? this.requiredAnnotationOrNullability(byAnnotation, this.isRequired(method.getReturnType())) : (this.isSetterLike(method) ? this.requiredAnnotationOrNullability(byAnnotation, this.isMethodParameterRequired(method, 0)) : null);
        }
        return null;
    }

    private final boolean isGetterLike(KFunction<?> $this$isGetterLike) {
        return $this$isGetterLike.getParameters().size() == 1;
    }

    private final boolean isSetterLike(KFunction<?> $this$isSetterLike) {
        return $this$isSetterLike.getParameters().size() == 2 && Intrinsics.areEqual((Object)$this$isSetterLike.getReturnType(), (Object)UNIT_TYPE);
    }

    private final Boolean hasRequiredMarker(AnnotatedParameter $this$hasRequiredMarker) {
        Boolean bl;
        KFunction kFunction;
        Member member = $this$hasRequiredMarker.getMember();
        JsonProperty jsonProperty = $this$hasRequiredMarker.getAnnotation(JsonProperty.class);
        Boolean byAnnotation = jsonProperty == null ? null : Boolean.valueOf(jsonProperty.required());
        Member member2 = member;
        if (member2 instanceof Constructor) {
            Intrinsics.checkNotNullExpressionValue((Object)member, (String)"member");
            kFunction = ReflectJvmMapping.getKotlinFunction((Constructor)((Constructor)member));
            bl = kFunction == null ? null : Boolean.valueOf(this.isConstructorParameterRequired(kFunction, $this$hasRequiredMarker.getIndex()));
        } else if (member2 instanceof Method) {
            Intrinsics.checkNotNullExpressionValue((Object)member, (String)"member");
            kFunction = ReflectJvmMapping.getKotlinFunction((Method)((Method)member));
            bl = kFunction == null ? null : Boolean.valueOf(this.isMethodParameterRequired(kFunction, $this$hasRequiredMarker.getIndex()));
        } else {
            bl = null;
        }
        Boolean byNullability = bl;
        return this.requiredAnnotationOrNullability(byAnnotation, byNullability);
    }

    private final boolean isConstructorParameterRequired(KFunction<?> $this$isConstructorParameterRequired, int index) {
        return this.isParameterRequired($this$isConstructorParameterRequired, index);
    }

    private final boolean isMethodParameterRequired(KFunction<?> $this$isMethodParameterRequired, int index) {
        return this.isParameterRequired($this$isMethodParameterRequired, index + 1);
    }

    private final boolean isParameterRequired(KFunction<?> $this$isParameterRequired, int index) {
        KParameter param = (KParameter)$this$isParameterRequired.getParameters().get(index);
        KType paramType = param.getType();
        Type javaType = ReflectJvmMapping.getJavaType((KType)paramType);
        Type type = javaType;
        boolean isPrimitive = type instanceof Class ? ((Class)javaType).isPrimitive() : false;
        return !paramType.isMarkedNullable() && !param.isOptional() && (!isPrimitive || this.context.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES));
    }

    private final boolean isRequired(KType $this$isRequired) {
        return !$this$isRequired.isMarkedNullable();
    }

    public static final /* synthetic */ boolean access$getNullToEmptyCollection$p(KotlinAnnotationIntrospector $this) {
        return $this.nullToEmptyCollection;
    }

    public static final /* synthetic */ boolean access$getNullToEmptyMap$p(KotlinAnnotationIntrospector $this) {
        return $this.nullToEmptyMap;
    }

    public static final /* synthetic */ Boolean access$hasRequiredMarker(KotlinAnnotationIntrospector $this, AnnotatedField $receiver) {
        return $this.hasRequiredMarker($receiver);
    }

    public static final /* synthetic */ Boolean access$hasRequiredMarker(KotlinAnnotationIntrospector $this, AnnotatedMethod $receiver) {
        return $this.hasRequiredMarker($receiver);
    }

    public static final /* synthetic */ Boolean access$hasRequiredMarker(KotlinAnnotationIntrospector $this, AnnotatedParameter $receiver) {
        return $this.hasRequiredMarker($receiver);
    }

    @Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinAnnotationIntrospector$Companion;", "", "Lkotlin/reflect/KType;", "UNIT_TYPE", "Lkotlin/reflect/KType;", "getUNIT_TYPE", "()Lkotlin/reflect/KType;", "<init>", "()V", "jackson-module-kotlin"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KType getUNIT_TYPE() {
            return UNIT_TYPE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

