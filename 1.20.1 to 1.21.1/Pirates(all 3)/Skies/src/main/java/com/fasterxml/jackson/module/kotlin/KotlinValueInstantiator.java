/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KType
 *  kotlin.reflect.KTypeProjection
 *  kotlin.reflect.jvm.ReflectJvmMapping
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.module.kotlin.ConstructorValueCreator;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.fasterxml.jackson.module.kotlin.MethodValueCreator;
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException;
import com.fasterxml.jackson.module.kotlin.ReflectionCache;
import com.fasterxml.jackson.module.kotlin.ValueCreator;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.ReflectJvmMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u001a\u001a\u00020\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\f*\u00020\u0005H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\f*\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016\u00a8\u0006\u001d"}, d2={"Lcom/fasterxml/jackson/module/kotlin/KotlinValueInstantiator;", "Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "", "Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;", "props", "Lcom/fasterxml/jackson/databind/deser/impl/PropertyValueBuffer;", "buffer", "", "createFromObjectWith", "(Lcom/fasterxml/jackson/databind/DeserializationContext;[Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;Lcom/fasterxml/jackson/databind/deser/impl/PropertyValueBuffer;)Ljava/lang/Object;", "", "hasInjectableValueId", "(Lcom/fasterxml/jackson/databind/deser/SettableBeanProperty;)Z", "Lkotlin/reflect/KParameter;", "isPrimitive", "(Lkotlin/reflect/KParameter;)Z", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "cache", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "nullIsSameAsDefault", "Z", "nullToEmptyCollection", "nullToEmptyMap", "strictNullChecks", "src", "<init>", "(Lcom/fasterxml/jackson/databind/deser/std/StdValueInstantiator;Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;ZZZZ)V", "jackson-module-kotlin"})
public final class KotlinValueInstantiator
extends StdValueInstantiator {
    @NotNull
    private final ReflectionCache cache;
    private final boolean nullToEmptyCollection;
    private final boolean nullToEmptyMap;
    private final boolean nullIsSameAsDefault;
    private final boolean strictNullChecks;

    public KotlinValueInstantiator(@NotNull StdValueInstantiator src, @NotNull ReflectionCache cache2, boolean nullToEmptyCollection, boolean nullToEmptyMap, boolean nullIsSameAsDefault, boolean strictNullChecks) {
        Intrinsics.checkNotNullParameter((Object)src, (String)"src");
        Intrinsics.checkNotNullParameter((Object)cache2, (String)"cache");
        super(src);
        this.cache = cache2;
        this.nullToEmptyCollection = nullToEmptyCollection;
        this.nullToEmptyMap = nullToEmptyMap;
        this.nullIsSameAsDefault = nullIsSameAsDefault;
        this.strictNullChecks = strictNullChecks;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object createFromObjectWith(@NotNull DeserializationContext ctxt, @NotNull SettableBeanProperty[] props, @NotNull PropertyValueBuffer buffer) {
        Object object;
        int n2;
        Object object2;
        Object[] $this$createFromObjectWith_u24lambda_u2d1;
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        AnnotatedWithParams annotatedWithParams = this._withArgsCreator;
        Intrinsics.checkNotNullExpressionValue((Object)annotatedWithParams, (String)"_withArgsCreator");
        ValueCreator<?> valueCreator = this.cache.valueCreatorFromJava(annotatedWithParams);
        if (valueCreator == null) {
            return super.createFromObjectWith(ctxt, props, buffer);
        }
        ValueCreator<?> valueCreator2 = valueCreator;
        int propCount = 0;
        int numCallableParameters = 0;
        KParameter[] callableParameters = null;
        Object[] jsonParamValueList = null;
        if (valueCreator2 instanceof MethodValueCreator) {
            propCount = props.length + 1;
            numCallableParameters = 1;
            Object[] objectArray = new KParameter[propCount];
            boolean bl = false;
            boolean bl2 = false;
            KParameter[] $this$createFromObjectWith_u24lambda_u2d0 = objectArray;
            boolean bl3 = false;
            $this$createFromObjectWith_u24lambda_u2d0[0] = ((MethodValueCreator)valueCreator2).getInstanceParameter();
            callableParameters = objectArray;
            objectArray = new Object[propCount];
            bl = false;
            bl2 = false;
            $this$createFromObjectWith_u24lambda_u2d1 = objectArray;
            boolean bl4 = false;
            $this$createFromObjectWith_u24lambda_u2d1[0] = ((MethodValueCreator)valueCreator2).getCompanionObjectInstance();
            jsonParamValueList = objectArray;
        } else {
            propCount = props.length;
            numCallableParameters = 0;
            callableParameters = new KParameter[propCount];
            jsonParamValueList = new Object[propCount];
        }
        Iterable $this$forEachIndexed$iv = valueCreator2.getValueParameters();
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            boolean isMissingAndRequired;
            Object paramVal;
            Object object3;
            JsonDeserializer<Object> tempParamVal;
            void paramDef;
            boolean isMissing;
            int n3 = index$iv++;
            boolean bl = false;
            if (n3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KParameter kParameter = (KParameter)item$iv;
            int idx = n3;
            boolean bl5 = false;
            SettableBeanProperty jsonProp = props[idx];
            boolean bl6 = isMissing = !buffer.hasParameter(jsonProp);
            if (isMissing && paramDef.isOptional()) continue;
            if (!isMissing || this.isPrimitive((KParameter)paramDef) || this.hasInjectableValueId(jsonProp)) {
                tempParamVal = buffer.getParameter(jsonProp);
                if (this.nullIsSameAsDefault && tempParamVal == null && paramDef.isOptional()) continue;
                object3 = tempParamVal;
            } else {
                object3 = paramDef.getType().isMarkedNullable() ? null : (paramVal = (tempParamVal = jsonProp.getValueDeserializer()) == null ? null : tempParamVal.getAbsentValue(ctxt));
            }
            if (paramVal == null && (this.nullToEmptyCollection && jsonProp.getType().isCollectionLikeType() || this.nullToEmptyMap && jsonProp.getType().isMapLikeType())) {
                paramVal = new NullsAsEmptyProvider(jsonProp.getValueDeserializer()).getNullValue(ctxt);
            }
            boolean isGenericTypeVar = ReflectJvmMapping.getJavaType((KType)paramDef.getType()) instanceof TypeVariable;
            boolean bl7 = isMissingAndRequired = paramVal == null && isMissing && jsonProp.isRequired();
            if (isMissingAndRequired || !isGenericTypeVar && paramVal == null && !paramDef.getType().isMarkedNullable()) {
                JsonMappingException jsonMappingException = new MissingKotlinParameterException((KParameter)paramDef, ctxt.getParser(), "Instantiation of " + this.getValueTypeDesc() + " value failed for JSON property " + jsonProp.getName() + " due to missing (therefore NULL) value for creator parameter " + paramDef.getName() + " which is a non-nullable type");
                Class<?> clazz = this.getValueClass();
                object2 = jsonProp.getName();
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"jsonProp.name");
                JsonMappingException jsonMappingException2 = ExtensionsKt.wrapWithPath(jsonMappingException, clazz, (String)object2);
                Intrinsics.checkNotNullExpressionValue((Object)jsonMappingException2, (String)"MissingKotlinParameterEx\u2026alueClass, jsonProp.name)");
                throw (Throwable)jsonMappingException2;
            }
            if (this.strictNullChecks && paramVal != null) {
                KType $i$f$any3;
                Object it;
                KType $i$f$any22;
                Object object4;
                Object $this$any$iv;
                KType kType;
                Object object5;
                String paramType = null;
                KType itemType = null;
                if (jsonProp.getType().isCollectionLikeType() && ((object5 = (KTypeProjection)CollectionsKt.getOrNull((List)paramDef.getType().getArguments(), (int)0)) == null ? false : ((kType = object5.getType()) == null ? false : !kType.isMarkedNullable()))) {
                    boolean bl8;
                    block28: {
                        object5 = paramVal;
                        $this$any$iv = (Collection)object5;
                        boolean $i$f$any22 = false;
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                            bl8 = false;
                        } else {
                            object4 = $this$any$iv.iterator();
                            while (object4.hasNext()) {
                                Object element$iv;
                                Object it2 = element$iv = object4.next();
                                boolean bl9 = false;
                                if (!(it2 == null)) continue;
                                bl8 = true;
                                break block28;
                            }
                            bl8 = false;
                        }
                    }
                    if (bl8) {
                        paramType = "collection";
                        itemType = ((KTypeProjection)paramDef.getType().getArguments().get(0)).getType();
                    }
                }
                if (jsonProp.getType().isMapLikeType() && (($this$any$iv = (KTypeProjection)CollectionsKt.getOrNull((List)paramDef.getType().getArguments(), (int)1)) == null ? false : (($i$f$any22 = $this$any$iv.getType()) == null ? false : !$i$f$any22.isMarkedNullable()))) {
                    boolean bl10;
                    block29: {
                        $this$any$iv = paramVal;
                        $this$any$iv = (Map)$this$any$iv;
                        boolean $i$f$any3 = false;
                        if ($this$any$iv.isEmpty()) {
                            bl10 = false;
                        } else {
                            object4 = $this$any$iv;
                            boolean bl11 = false;
                            for (Map.Entry element$iv : object4.entrySet()) {
                                it = element$iv;
                                boolean bl12 = false;
                                if (!(it.getValue() == null)) continue;
                                bl10 = true;
                                break block29;
                            }
                            bl10 = false;
                        }
                    }
                    if (bl10) {
                        paramType = "map";
                        itemType = ((KTypeProjection)paramDef.getType().getArguments().get(1)).getType();
                    }
                }
                if (jsonProp.getType().isArrayType() && (($this$any$iv = (KTypeProjection)CollectionsKt.getOrNull((List)paramDef.getType().getArguments(), (int)0)) == null ? false : (($i$f$any3 = $this$any$iv.getType()) == null ? false : !$i$f$any3.isMarkedNullable()))) {
                    boolean bl13;
                    block30: {
                        $this$any$iv = paramVal;
                        $this$any$iv = (Object[])$this$any$iv;
                        boolean $i$f$any4 = false;
                        object4 = $this$any$iv;
                        int n4 = ((Object)object4).length;
                        for (int i2 = 0; i2 < n4; ++i2) {
                            Object element$iv;
                            it = element$iv = object4[i2];
                            boolean bl14 = false;
                            if (!(it == null)) continue;
                            bl13 = true;
                            break block30;
                        }
                        bl13 = false;
                    }
                    if (bl13) {
                        paramType = "array";
                        itemType = ((KTypeProjection)paramDef.getType().getArguments().get(0)).getType();
                    }
                }
                if (paramType != null && itemType != null) {
                    JsonMappingException jsonMappingException = new MissingKotlinParameterException((KParameter)paramDef, ctxt.getParser(), "Instantiation of " + itemType + ' ' + paramType + " failed for JSON property " + jsonProp.getName() + " due to null value in a " + paramType + " that does not allow null values");
                    Class<?> clazz = this.getValueClass();
                    String string = jsonProp.getName();
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"jsonProp.name");
                    object5 = ExtensionsKt.wrapWithPath(jsonMappingException, clazz, string);
                    Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"MissingKotlinParameterEx\u2026alueClass, jsonProp.name)");
                    throw (Throwable)object5;
                }
            }
            jsonParamValueList[numCallableParameters] = paramVal;
            callableParameters[numCallableParameters] = paramDef;
            n2 = numCallableParameters;
            numCallableParameters = n2 + 1;
        }
        if (numCallableParameters == jsonParamValueList.length && valueCreator2 instanceof ConstructorValueCreator) {
            object = super.createFromObjectWith(ctxt, jsonParamValueList);
        } else {
            void $this$mapIndexedTo$iv$iv;
            valueCreator2.checkAccessibility(ctxt);
            $i$f$forEachIndexed = false;
            LinkedHashMap callableParametersByName = new LinkedHashMap();
            KParameter[] $this$mapIndexed$iv = callableParameters;
            boolean $i$f$mapIndexed = false;
            $this$createFromObjectWith_u24lambda_u2d1 = $this$mapIndexed$iv;
            Collection destination$iv$iv = new ArrayList($this$mapIndexed$iv.length);
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (KParameter item$iv$iv : $this$mapIndexedTo$iv$iv) {
                void paramDef;
                int n5 = index$iv$iv++;
                KParameter isMissing = item$iv$iv;
                int isGenericTypeVar = n5;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                if (paramDef != null) {
                    void idx;
                    Map map2 = callableParametersByName;
                    object2 = jsonParamValueList[idx];
                    n2 = 0;
                    map2.put(paramDef, object2);
                }
                Unit unit = Unit.INSTANCE;
                collection.add(unit);
            }
            List cfr_ignored_0 = (List)destination$iv$iv;
            object = valueCreator2.callBy(callableParametersByName);
        }
        return object;
    }

    private final boolean isPrimitive(KParameter $this$isPrimitive) {
        Type javaType = ReflectJvmMapping.getJavaType((KType)$this$isPrimitive.getType());
        return javaType instanceof Class ? ((Class)javaType).isPrimitive() : false;
    }

    private final boolean hasInjectableValueId(SettableBeanProperty $this$hasInjectableValueId) {
        return $this$hasInjectableValueId.getInjectableValueId() != null;
    }
}

