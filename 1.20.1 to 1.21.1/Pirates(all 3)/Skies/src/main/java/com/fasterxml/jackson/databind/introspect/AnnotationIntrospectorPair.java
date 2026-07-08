/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnnotationIntrospectorPair
extends AnnotationIntrospector
implements Serializable {
    private static final long serialVersionUID = 1L;
    protected final AnnotationIntrospector _primary;
    protected final AnnotationIntrospector _secondary;

    public AnnotationIntrospectorPair(AnnotationIntrospector p, AnnotationIntrospector s) {
        this._primary = p;
        this._secondary = s;
    }

    @Override
    public Version version() {
        return this._primary.version();
    }

    public static AnnotationIntrospector create(AnnotationIntrospector primary, AnnotationIntrospector secondary) {
        if (primary == null) {
            return secondary;
        }
        if (secondary == null) {
            return primary;
        }
        return new AnnotationIntrospectorPair(primary, secondary);
    }

    @Override
    public Collection<AnnotationIntrospector> allIntrospectors() {
        return this.allIntrospectors(new ArrayList<AnnotationIntrospector>());
    }

    @Override
    public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> result2) {
        this._primary.allIntrospectors(result2);
        this._secondary.allIntrospectors(result2);
        return result2;
    }

    @Override
    public boolean isAnnotationBundle(Annotation ann) {
        return this._primary.isAnnotationBundle(ann) || this._secondary.isAnnotationBundle(ann);
    }

    @Override
    public PropertyName findRootName(AnnotatedClass ac) {
        PropertyName name1 = this._primary.findRootName(ac);
        if (name1 == null) {
            return this._secondary.findRootName(ac);
        }
        if (name1.hasSimpleName()) {
            return name1;
        }
        PropertyName name2 = this._secondary.findRootName(ac);
        return name2 == null ? name1 : name2;
    }

    @Override
    public JsonIgnoreProperties.Value findPropertyIgnoralByName(MapperConfig<?> config, Annotated ann) {
        JsonIgnoreProperties.Value v2 = this._secondary.findPropertyIgnoralByName(config, ann);
        JsonIgnoreProperties.Value v1 = this._primary.findPropertyIgnoralByName(config, ann);
        return v2 == null ? v1 : v2.withOverrides(v1);
    }

    @Override
    public JsonIncludeProperties.Value findPropertyInclusionByName(MapperConfig<?> config, Annotated a2) {
        JsonIncludeProperties.Value v2 = this._secondary.findPropertyInclusionByName(config, a2);
        JsonIncludeProperties.Value v1 = this._primary.findPropertyInclusionByName(config, a2);
        return v2 == null ? v1 : v2.withOverrides(v1);
    }

    @Override
    public Boolean isIgnorableType(AnnotatedClass ac) {
        Boolean result2 = this._primary.isIgnorableType(ac);
        if (result2 == null) {
            result2 = this._secondary.isIgnorableType(ac);
        }
        return result2;
    }

    @Override
    public Object findFilterId(Annotated ann) {
        Object id = this._primary.findFilterId(ann);
        if (id == null) {
            id = this._secondary.findFilterId(ann);
        }
        return id;
    }

    @Override
    public Object findNamingStrategy(AnnotatedClass ac) {
        Object str = this._primary.findNamingStrategy(ac);
        if (str == null) {
            str = this._secondary.findNamingStrategy(ac);
        }
        return str;
    }

    @Override
    public String findClassDescription(AnnotatedClass ac) {
        String str = this._primary.findClassDescription(ac);
        if (str == null || str.isEmpty()) {
            str = this._secondary.findClassDescription(ac);
        }
        return str;
    }

    @Override
    @Deprecated
    public String[] findPropertiesToIgnore(Annotated ac, boolean forSerialization) {
        String[] result2 = this._primary.findPropertiesToIgnore(ac, forSerialization);
        if (result2 == null) {
            result2 = this._secondary.findPropertiesToIgnore(ac, forSerialization);
        }
        return result2;
    }

    @Override
    @Deprecated
    public Boolean findIgnoreUnknownProperties(AnnotatedClass ac) {
        Boolean result2 = this._primary.findIgnoreUnknownProperties(ac);
        if (result2 == null) {
            result2 = this._secondary.findIgnoreUnknownProperties(ac);
        }
        return result2;
    }

    @Override
    @Deprecated
    public JsonIgnoreProperties.Value findPropertyIgnorals(Annotated a2) {
        JsonIgnoreProperties.Value v2 = this._secondary.findPropertyIgnorals(a2);
        JsonIgnoreProperties.Value v1 = this._primary.findPropertyIgnorals(a2);
        return v2 == null ? v1 : v2.withOverrides(v1);
    }

    @Override
    public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass ac, VisibilityChecker<?> checker) {
        checker = this._secondary.findAutoDetectVisibility(ac, checker);
        return this._primary.findAutoDetectVisibility(ac, checker);
    }

    @Override
    public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> config, AnnotatedClass ac, JavaType baseType) {
        TypeResolverBuilder<?> b2 = this._primary.findTypeResolver(config, ac, baseType);
        if (b2 == null) {
            b2 = this._secondary.findTypeResolver(config, ac, baseType);
        }
        return b2;
    }

    @Override
    public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> config, AnnotatedMember am, JavaType baseType) {
        TypeResolverBuilder<?> b2 = this._primary.findPropertyTypeResolver(config, am, baseType);
        if (b2 == null) {
            b2 = this._secondary.findPropertyTypeResolver(config, am, baseType);
        }
        return b2;
    }

    @Override
    public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> config, AnnotatedMember am, JavaType baseType) {
        TypeResolverBuilder<?> b2 = this._primary.findPropertyContentTypeResolver(config, am, baseType);
        if (b2 == null) {
            b2 = this._secondary.findPropertyContentTypeResolver(config, am, baseType);
        }
        return b2;
    }

    @Override
    public List<NamedType> findSubtypes(Annotated a2) {
        List<NamedType> types1 = this._primary.findSubtypes(a2);
        List<NamedType> types2 = this._secondary.findSubtypes(a2);
        if (types1 == null || types1.isEmpty()) {
            return types2;
        }
        if (types2 == null || types2.isEmpty()) {
            return types1;
        }
        ArrayList<NamedType> result2 = new ArrayList<NamedType>(types1.size() + types2.size());
        result2.addAll(types1);
        result2.addAll(types2);
        return result2;
    }

    @Override
    public String findTypeName(AnnotatedClass ac) {
        String name = this._primary.findTypeName(ac);
        if (name == null || name.isEmpty()) {
            name = this._secondary.findTypeName(ac);
        }
        return name;
    }

    @Override
    public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember member) {
        AnnotationIntrospector.ReferenceProperty r = this._primary.findReferenceType(member);
        return r == null ? this._secondary.findReferenceType(member) : r;
    }

    @Override
    public NameTransformer findUnwrappingNameTransformer(AnnotatedMember member) {
        NameTransformer r = this._primary.findUnwrappingNameTransformer(member);
        return r == null ? this._secondary.findUnwrappingNameTransformer(member) : r;
    }

    @Override
    public JacksonInject.Value findInjectableValue(AnnotatedMember m2) {
        JacksonInject.Value secondary;
        JacksonInject.Value r = this._primary.findInjectableValue(m2);
        if ((r == null || r.getUseInput() == null) && (secondary = this._secondary.findInjectableValue(m2)) != null) {
            r = r == null ? secondary : r.withUseInput(secondary.getUseInput());
        }
        return r;
    }

    @Override
    public boolean hasIgnoreMarker(AnnotatedMember m2) {
        return this._primary.hasIgnoreMarker(m2) || this._secondary.hasIgnoreMarker(m2);
    }

    @Override
    public Boolean hasRequiredMarker(AnnotatedMember m2) {
        Boolean r = this._primary.hasRequiredMarker(m2);
        return r == null ? this._secondary.hasRequiredMarker(m2) : r;
    }

    @Override
    @Deprecated
    public Object findInjectableValueId(AnnotatedMember m2) {
        Object r = this._primary.findInjectableValueId(m2);
        return r == null ? this._secondary.findInjectableValueId(m2) : r;
    }

    @Override
    public Object findSerializer(Annotated am) {
        Object r = this._primary.findSerializer(am);
        if (this._isExplicitClassOrOb(r, JsonSerializer.None.class)) {
            return r;
        }
        return this._explicitClassOrOb(this._secondary.findSerializer(am), JsonSerializer.None.class);
    }

    @Override
    public Object findKeySerializer(Annotated a2) {
        Object r = this._primary.findKeySerializer(a2);
        if (this._isExplicitClassOrOb(r, JsonSerializer.None.class)) {
            return r;
        }
        return this._explicitClassOrOb(this._secondary.findKeySerializer(a2), JsonSerializer.None.class);
    }

    @Override
    public Object findContentSerializer(Annotated a2) {
        Object r = this._primary.findContentSerializer(a2);
        if (this._isExplicitClassOrOb(r, JsonSerializer.None.class)) {
            return r;
        }
        return this._explicitClassOrOb(this._secondary.findContentSerializer(a2), JsonSerializer.None.class);
    }

    @Override
    public Object findNullSerializer(Annotated a2) {
        Object r = this._primary.findNullSerializer(a2);
        if (this._isExplicitClassOrOb(r, JsonSerializer.None.class)) {
            return r;
        }
        return this._explicitClassOrOb(this._secondary.findNullSerializer(a2), JsonSerializer.None.class);
    }

    @Override
    @Deprecated
    public JsonInclude.Include findSerializationInclusion(Annotated a2, JsonInclude.Include defValue) {
        defValue = this._secondary.findSerializationInclusion(a2, defValue);
        defValue = this._primary.findSerializationInclusion(a2, defValue);
        return defValue;
    }

    @Override
    @Deprecated
    public JsonInclude.Include findSerializationInclusionForContent(Annotated a2, JsonInclude.Include defValue) {
        defValue = this._secondary.findSerializationInclusionForContent(a2, defValue);
        defValue = this._primary.findSerializationInclusionForContent(a2, defValue);
        return defValue;
    }

    @Override
    public JsonInclude.Value findPropertyInclusion(Annotated a2) {
        JsonInclude.Value v2 = this._secondary.findPropertyInclusion(a2);
        JsonInclude.Value v1 = this._primary.findPropertyInclusion(a2);
        if (v2 == null) {
            return v1;
        }
        return v2.withOverrides(v1);
    }

    @Override
    public JsonSerialize.Typing findSerializationTyping(Annotated a2) {
        JsonSerialize.Typing r = this._primary.findSerializationTyping(a2);
        return r == null ? this._secondary.findSerializationTyping(a2) : r;
    }

    @Override
    public Object findSerializationConverter(Annotated a2) {
        Object r = this._primary.findSerializationConverter(a2);
        return r == null ? this._secondary.findSerializationConverter(a2) : r;
    }

    @Override
    public Object findSerializationContentConverter(AnnotatedMember a2) {
        Object r = this._primary.findSerializationContentConverter(a2);
        return r == null ? this._secondary.findSerializationContentConverter(a2) : r;
    }

    @Override
    public Class<?>[] findViews(Annotated a2) {
        Class<?>[] result2 = this._primary.findViews(a2);
        if (result2 == null) {
            result2 = this._secondary.findViews(a2);
        }
        return result2;
    }

    @Override
    public Boolean isTypeId(AnnotatedMember member) {
        Boolean b2 = this._primary.isTypeId(member);
        return b2 == null ? this._secondary.isTypeId(member) : b2;
    }

    @Override
    public ObjectIdInfo findObjectIdInfo(Annotated ann) {
        ObjectIdInfo r = this._primary.findObjectIdInfo(ann);
        return r == null ? this._secondary.findObjectIdInfo(ann) : r;
    }

    @Override
    public ObjectIdInfo findObjectReferenceInfo(Annotated ann, ObjectIdInfo objectIdInfo) {
        objectIdInfo = this._secondary.findObjectReferenceInfo(ann, objectIdInfo);
        objectIdInfo = this._primary.findObjectReferenceInfo(ann, objectIdInfo);
        return objectIdInfo;
    }

    @Override
    public JsonFormat.Value findFormat(Annotated ann) {
        JsonFormat.Value v1 = this._primary.findFormat(ann);
        JsonFormat.Value v2 = this._secondary.findFormat(ann);
        if (v2 == null) {
            return v1;
        }
        return v2.withOverrides(v1);
    }

    @Override
    public PropertyName findWrapperName(Annotated ann) {
        PropertyName name2;
        PropertyName name = this._primary.findWrapperName(ann);
        if (name == null) {
            name = this._secondary.findWrapperName(ann);
        } else if (name == PropertyName.USE_DEFAULT && (name2 = this._secondary.findWrapperName(ann)) != null) {
            name = name2;
        }
        return name;
    }

    @Override
    public String findPropertyDefaultValue(Annotated ann) {
        String str = this._primary.findPropertyDefaultValue(ann);
        return str == null || str.isEmpty() ? this._secondary.findPropertyDefaultValue(ann) : str;
    }

    @Override
    public String findPropertyDescription(Annotated ann) {
        String r = this._primary.findPropertyDescription(ann);
        return r == null ? this._secondary.findPropertyDescription(ann) : r;
    }

    @Override
    public Integer findPropertyIndex(Annotated ann) {
        Integer r = this._primary.findPropertyIndex(ann);
        return r == null ? this._secondary.findPropertyIndex(ann) : r;
    }

    @Override
    public String findImplicitPropertyName(AnnotatedMember ann) {
        String r = this._primary.findImplicitPropertyName(ann);
        return r == null ? this._secondary.findImplicitPropertyName(ann) : r;
    }

    @Override
    public List<PropertyName> findPropertyAliases(Annotated ann) {
        List<PropertyName> r = this._primary.findPropertyAliases(ann);
        return r == null ? this._secondary.findPropertyAliases(ann) : r;
    }

    @Override
    public JsonProperty.Access findPropertyAccess(Annotated ann) {
        JsonProperty.Access acc = this._primary.findPropertyAccess(ann);
        if (acc != null && acc != JsonProperty.Access.AUTO) {
            return acc;
        }
        acc = this._secondary.findPropertyAccess(ann);
        if (acc != null) {
            return acc;
        }
        return JsonProperty.Access.AUTO;
    }

    @Override
    public AnnotatedMethod resolveSetterConflict(MapperConfig<?> config, AnnotatedMethod setter1, AnnotatedMethod setter2) {
        AnnotatedMethod res = this._primary.resolveSetterConflict(config, setter1, setter2);
        if (res == null) {
            res = this._secondary.resolveSetterConflict(config, setter1, setter2);
        }
        return res;
    }

    @Override
    public PropertyName findRenameByField(MapperConfig<?> config, AnnotatedField f2, PropertyName implName) {
        PropertyName n2 = this._secondary.findRenameByField(config, f2, implName);
        if (n2 == null) {
            n2 = this._primary.findRenameByField(config, f2, implName);
        }
        return n2;
    }

    @Override
    public JavaType refineSerializationType(MapperConfig<?> config, Annotated a2, JavaType baseType) throws JsonMappingException {
        JavaType t = this._secondary.refineSerializationType(config, a2, baseType);
        return this._primary.refineSerializationType(config, a2, t);
    }

    @Override
    @Deprecated
    public Class<?> findSerializationType(Annotated a2) {
        Class<?> r = this._primary.findSerializationType(a2);
        return r == null ? this._secondary.findSerializationType(a2) : r;
    }

    @Override
    @Deprecated
    public Class<?> findSerializationKeyType(Annotated am, JavaType baseType) {
        Class<?> r = this._primary.findSerializationKeyType(am, baseType);
        return r == null ? this._secondary.findSerializationKeyType(am, baseType) : r;
    }

    @Override
    @Deprecated
    public Class<?> findSerializationContentType(Annotated am, JavaType baseType) {
        Class<?> r = this._primary.findSerializationContentType(am, baseType);
        return r == null ? this._secondary.findSerializationContentType(am, baseType) : r;
    }

    @Override
    public String[] findSerializationPropertyOrder(AnnotatedClass ac) {
        String[] r = this._primary.findSerializationPropertyOrder(ac);
        return r == null ? this._secondary.findSerializationPropertyOrder(ac) : r;
    }

    @Override
    public Boolean findSerializationSortAlphabetically(Annotated ann) {
        Boolean r = this._primary.findSerializationSortAlphabetically(ann);
        return r == null ? this._secondary.findSerializationSortAlphabetically(ann) : r;
    }

    @Override
    public void findAndAddVirtualProperties(MapperConfig<?> config, AnnotatedClass ac, List<BeanPropertyWriter> properties) {
        this._primary.findAndAddVirtualProperties(config, ac, properties);
        this._secondary.findAndAddVirtualProperties(config, ac, properties);
    }

    @Override
    public PropertyName findNameForSerialization(Annotated a2) {
        PropertyName n2;
        PropertyName n3 = this._primary.findNameForSerialization(a2);
        if (n3 == null) {
            n3 = this._secondary.findNameForSerialization(a2);
        } else if (n3 == PropertyName.USE_DEFAULT && (n2 = this._secondary.findNameForSerialization(a2)) != null) {
            n3 = n2;
        }
        return n3;
    }

    @Override
    public Boolean hasAsKey(MapperConfig<?> config, Annotated a2) {
        Boolean b2 = this._primary.hasAsKey(config, a2);
        if (b2 == null) {
            b2 = this._secondary.hasAsKey(config, a2);
        }
        return b2;
    }

    @Override
    public Boolean hasAsValue(Annotated a2) {
        Boolean b2 = this._primary.hasAsValue(a2);
        if (b2 == null) {
            b2 = this._secondary.hasAsValue(a2);
        }
        return b2;
    }

    @Override
    public Boolean hasAnyGetter(Annotated a2) {
        Boolean b2 = this._primary.hasAnyGetter(a2);
        if (b2 == null) {
            b2 = this._secondary.hasAnyGetter(a2);
        }
        return b2;
    }

    @Override
    public String[] findEnumValues(Class<?> enumType, Enum<?>[] enumValues, String[] names) {
        names = this._secondary.findEnumValues(enumType, enumValues, names);
        names = this._primary.findEnumValues(enumType, enumValues, names);
        return names;
    }

    @Override
    public void findEnumAliases(Class<?> enumType, Enum<?>[] enumValues, String[][] aliases) {
        this._secondary.findEnumAliases(enumType, enumValues, aliases);
        this._primary.findEnumAliases(enumType, enumValues, aliases);
    }

    @Override
    public Enum<?> findDefaultEnumValue(Class<Enum<?>> enumCls) {
        Enum<?> en = this._primary.findDefaultEnumValue(enumCls);
        return en == null ? this._secondary.findDefaultEnumValue(enumCls) : en;
    }

    @Override
    @Deprecated
    public String findEnumValue(Enum<?> value) {
        String r = this._primary.findEnumValue(value);
        return r == null ? this._secondary.findEnumValue(value) : r;
    }

    @Override
    @Deprecated
    public boolean hasAsValueAnnotation(AnnotatedMethod am) {
        return this._primary.hasAsValueAnnotation(am) || this._secondary.hasAsValueAnnotation(am);
    }

    @Override
    @Deprecated
    public boolean hasAnyGetterAnnotation(AnnotatedMethod am) {
        return this._primary.hasAnyGetterAnnotation(am) || this._secondary.hasAnyGetterAnnotation(am);
    }

    @Override
    public Object findDeserializer(Annotated a2) {
        Object r = this._primary.findDeserializer(a2);
        if (this._isExplicitClassOrOb(r, JsonDeserializer.None.class)) {
            return r;
        }
        return this._explicitClassOrOb(this._secondary.findDeserializer(a2), JsonDeserializer.None.class);
    }

    @Override
    public Object findKeyDeserializer(Annotated a2) {
        Object r = this._primary.findKeyDeserializer(a2);
        if (this._isExplicitClassOrOb(r, KeyDeserializer.None.class)) {
            return r;
        }
        return this._explicitClassOrOb(this._secondary.findKeyDeserializer(a2), KeyDeserializer.None.class);
    }

    @Override
    public Object findContentDeserializer(Annotated am) {
        Object r = this._primary.findContentDeserializer(am);
        if (this._isExplicitClassOrOb(r, JsonDeserializer.None.class)) {
            return r;
        }
        return this._explicitClassOrOb(this._secondary.findContentDeserializer(am), JsonDeserializer.None.class);
    }

    @Override
    public Object findDeserializationConverter(Annotated a2) {
        Object ob = this._primary.findDeserializationConverter(a2);
        return ob == null ? this._secondary.findDeserializationConverter(a2) : ob;
    }

    @Override
    public Object findDeserializationContentConverter(AnnotatedMember a2) {
        Object ob = this._primary.findDeserializationContentConverter(a2);
        return ob == null ? this._secondary.findDeserializationContentConverter(a2) : ob;
    }

    @Override
    public JavaType refineDeserializationType(MapperConfig<?> config, Annotated a2, JavaType baseType) throws JsonMappingException {
        JavaType t = this._secondary.refineDeserializationType(config, a2, baseType);
        return this._primary.refineDeserializationType(config, a2, t);
    }

    @Override
    @Deprecated
    public Class<?> findDeserializationType(Annotated am, JavaType baseType) {
        Class<?> r = this._primary.findDeserializationType(am, baseType);
        return r != null ? r : this._secondary.findDeserializationType(am, baseType);
    }

    @Override
    @Deprecated
    public Class<?> findDeserializationKeyType(Annotated am, JavaType baseKeyType) {
        Class<?> result2 = this._primary.findDeserializationKeyType(am, baseKeyType);
        return result2 == null ? this._secondary.findDeserializationKeyType(am, baseKeyType) : result2;
    }

    @Override
    @Deprecated
    public Class<?> findDeserializationContentType(Annotated am, JavaType baseContentType) {
        Class<?> result2 = this._primary.findDeserializationContentType(am, baseContentType);
        return result2 == null ? this._secondary.findDeserializationContentType(am, baseContentType) : result2;
    }

    @Override
    public Object findValueInstantiator(AnnotatedClass ac) {
        Object result2 = this._primary.findValueInstantiator(ac);
        return result2 == null ? this._secondary.findValueInstantiator(ac) : result2;
    }

    @Override
    public Class<?> findPOJOBuilder(AnnotatedClass ac) {
        Class<?> result2 = this._primary.findPOJOBuilder(ac);
        return result2 == null ? this._secondary.findPOJOBuilder(ac) : result2;
    }

    @Override
    public JsonPOJOBuilder.Value findPOJOBuilderConfig(AnnotatedClass ac) {
        JsonPOJOBuilder.Value result2 = this._primary.findPOJOBuilderConfig(ac);
        return result2 == null ? this._secondary.findPOJOBuilderConfig(ac) : result2;
    }

    @Override
    public PropertyName findNameForDeserialization(Annotated a2) {
        PropertyName n2;
        PropertyName n3 = this._primary.findNameForDeserialization(a2);
        if (n3 == null) {
            n3 = this._secondary.findNameForDeserialization(a2);
        } else if (n3 == PropertyName.USE_DEFAULT && (n2 = this._secondary.findNameForDeserialization(a2)) != null) {
            n3 = n2;
        }
        return n3;
    }

    @Override
    public Boolean hasAnySetter(Annotated a2) {
        Boolean b2 = this._primary.hasAnySetter(a2);
        if (b2 == null) {
            b2 = this._secondary.hasAnySetter(a2);
        }
        return b2;
    }

    @Override
    public JsonSetter.Value findSetterInfo(Annotated a2) {
        JsonSetter.Value v2 = this._secondary.findSetterInfo(a2);
        JsonSetter.Value v1 = this._primary.findSetterInfo(a2);
        return v2 == null ? v1 : v2.withOverrides(v1);
    }

    @Override
    public Boolean findMergeInfo(Annotated a2) {
        Boolean b2 = this._primary.findMergeInfo(a2);
        if (b2 == null) {
            b2 = this._secondary.findMergeInfo(a2);
        }
        return b2;
    }

    @Override
    @Deprecated
    public boolean hasCreatorAnnotation(Annotated a2) {
        return this._primary.hasCreatorAnnotation(a2) || this._secondary.hasCreatorAnnotation(a2);
    }

    @Override
    @Deprecated
    public JsonCreator.Mode findCreatorBinding(Annotated a2) {
        JsonCreator.Mode mode = this._primary.findCreatorBinding(a2);
        if (mode != null) {
            return mode;
        }
        return this._secondary.findCreatorBinding(a2);
    }

    @Override
    public JsonCreator.Mode findCreatorAnnotation(MapperConfig<?> config, Annotated a2) {
        JsonCreator.Mode mode = this._primary.findCreatorAnnotation(config, a2);
        return mode == null ? this._secondary.findCreatorAnnotation(config, a2) : mode;
    }

    @Override
    @Deprecated
    public boolean hasAnySetterAnnotation(AnnotatedMethod am) {
        return this._primary.hasAnySetterAnnotation(am) || this._secondary.hasAnySetterAnnotation(am);
    }

    protected boolean _isExplicitClassOrOb(Object maybeCls, Class<?> implicit) {
        if (maybeCls == null || maybeCls == implicit) {
            return false;
        }
        if (maybeCls instanceof Class) {
            return !ClassUtil.isBogusClass((Class)maybeCls);
        }
        return true;
    }

    protected Object _explicitClassOrOb(Object maybeCls, Class<?> implicit) {
        if (maybeCls == null || maybeCls == implicit) {
            return null;
        }
        if (maybeCls instanceof Class && ClassUtil.isBogusClass((Class)maybeCls)) {
            return null;
        }
        return maybeCls;
    }
}

