/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  org.valkyrienskies.core.impl.shadow.at
 *  org.valkyrienskies.core.impl.shadow.at$a
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.ap_1;
import org.valkyrienskies.core.impl.shadow.ar_1;
import org.valkyrienskies.core.impl.shadow.at;
import org.valkyrienskies.core.impl.shadow.at_2;
import org.valkyrienskies.core.impl.shadow.au_1;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.aw_1;
import org.valkyrienskies.core.impl.shadow.aw_2;
import org.valkyrienskies.core.impl.shadow.ay_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bv
 */
public final class bv_2
implements ar_1,
av_2 {
    @Override
    public final List<ResolvedType> b(ResolvedType resolvedType, ai_1 ai_12) {
        JsonSubTypes jsonSubTypes = resolvedType.getErasedType().getAnnotation(JsonSubTypes.class);
        return this.a(resolvedType, jsonSubTypes, ai_12.b());
    }

    public final List<ResolvedType> a(ab_1<?, ?> ab_12) {
        ab_1<?, ?> ab_13 = ab_12;
        if (ab_13.d == null) {
            return null;
        }
        JsonSubTypes jsonSubTypes = ab_12.b(JsonSubTypes.class);
        ab_1<?, ?> ab_14 = ab_12;
        ab_13 = ab_14;
        ab_13 = ab_12;
        return this.a(ab_14.d, jsonSubTypes, ab_13.e);
    }

    private List<ResolvedType> a(ResolvedType resolvedType, JsonSubTypes jsonSubTypes, au_1 au_12) {
        if (jsonSubTypes == null) {
            return null;
        }
        return Stream.of(jsonSubTypes.value()).map(type -> bv_2.a(resolvedType, type, au_12)).collect(Collectors.toList());
    }

    private static ResolvedType a(ResolvedType object, JsonSubTypes.Type type, au_1 au_12) {
        try {
            Class<?> clazz = type.value();
            ResolvedType resolvedType = object;
            object = au_12;
            return object.a.resolveSubtype(resolvedType, clazz);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return au_12.a(type.value(), new Type[0]);
        }
    }

    @Override
    public final at_2 a(ResolvedType object, ai_1 ai_12) {
        Object object2;
        Object object3;
        Object object4;
        block5: {
            object4 = object.getErasedType();
            do {
                if (((Class)object4).getAnnotation(JsonTypeInfo.class) != null) {
                    object3 = object4;
                } else {
                    object2 = Stream.of(((Class)object4).getInterfaces()).filter(clazz -> clazz.getAnnotation(JsonTypeInfo.class) != null).findFirst();
                    if (!((Optional)object2).isPresent()) continue;
                    object3 = ((Optional)object2).get();
                }
                break block5;
            } while ((object4 = ((Class)object4).getSuperclass()) != null);
            object3 = object4 = null;
        }
        if (object3 == null || object.getErasedType().getAnnotation(JsonSubTypes.class) != null) {
            return null;
        }
        object2 = ((Class)object4).getAnnotation(JsonTypeInfo.class);
        if ((object = this.a((ResolvedType)object, (JsonTypeInfo)object2, (JsonSubTypes)(object4 = ((Class)object4).getAnnotation(JsonSubTypes.class)), null, ai_12)) == null) {
            return null;
        }
        return new at((ObjectNode)object, at_2.b.STANDARD, at.a.NO);
    }

    public final aw_2 a(ab_1<?, ?> object, ai_1 ai_12) {
        ab_1<?, ?> ab_12;
        block7: {
            block6: {
                ab_12 = object;
                if (ab_12.d == null) break block6;
                ab_12 = object;
                if (ab_12.d.getErasedType().getDeclaredAnnotation(JsonSubTypes.class) == null) break block7;
            }
            return null;
        }
        JsonTypeInfo jsonTypeInfo = ((ab_1)object).b(JsonTypeInfo.class);
        if (jsonTypeInfo == null) {
            return null;
        }
        if (jsonTypeInfo.use() == JsonTypeInfo.Id.NONE) {
            ObjectNode objectNode = ai_12.a().o();
            ab_12 = object;
            objectNode.withArray(ai_12.a(ap_1.TAG_ALLOF)).add(ai_12.a(ab_12.d, this));
            return new aw_2(objectNode, at.a.YES);
        }
        ObjectNode objectNode = object instanceof ay_2 ? aw_1.a((ay_2)object, ai_12) : (object instanceof ac_1 ? aw_1.a((ac_1)object, ai_12) : null);
        JsonSubTypes jsonSubTypes = ((ab_1)object).b(JsonSubTypes.class);
        ab_12 = object;
        object = this.a(ab_12.d, jsonTypeInfo, jsonSubTypes, objectNode, ai_12);
        if (object == null) {
            return null;
        }
        return new aw_2((ObjectNode)object, at.a.NO);
    }

    private static Class<?> a(Class<?> clazz2) {
        do {
            if (clazz2.getAnnotation(JsonTypeInfo.class) != null) {
                return clazz2;
            }
            Optional<Class> optional = Stream.of(clazz2.getInterfaces()).filter(clazz -> clazz.getAnnotation(JsonTypeInfo.class) != null).findFirst();
            if (!optional.isPresent()) continue;
            return optional.get();
        } while ((clazz2 = clazz2.getSuperclass()) != null);
        return null;
    }

    private static String a(ResolvedType object, JsonTypeInfo object2, JsonSubTypes jsonSubTypes) {
        object = object.getErasedType();
        switch (object2.use()) {
            case NAME: {
                object2 = object;
                object = (jsonSubTypes == null ? Optional.empty() : Stream.of(jsonSubTypes.value()).filter(arg_0 -> bv_2.a((Class)object2, arg_0)).findFirst().map(type -> type.name()).filter(string -> !string.isEmpty())).orElseGet(() -> bv_2.d((Class)object));
                break;
            }
            case CLASS: {
                object = ((Class)object).getName();
                break;
            }
            default: {
                object = null;
            }
        }
        return object;
    }

    private static Optional<String> a(Class<?> clazz, JsonSubTypes jsonSubTypes) {
        if (jsonSubTypes == null) {
            return Optional.empty();
        }
        return Stream.of(jsonSubTypes.value()).filter(type -> clazz.equals(type.value())).findFirst().map(type -> type.name()).filter(string -> !string.isEmpty());
    }

    private static Optional<String> b(Class<?> clazz) {
        return Optional.ofNullable(clazz.getAnnotation(JsonTypeName.class)).map(JsonTypeName::value).filter(string -> !string.isEmpty());
    }

    private static String c(Class<?> clazz) {
        Class<?> clazz2 = clazz.getDeclaringClass();
        if (clazz2 == null) {
            return clazz.getSimpleName();
        }
        return bv_2.c(clazz2) + '$' + clazz.getSimpleName();
    }

    private ObjectNode a(ResolvedType object, JsonTypeInfo object2, JsonSubTypes object3, ObjectNode objectNode, ai_1 ai_12) {
        if ((object3 = bv_2.a((ResolvedType)object, (JsonTypeInfo)object2, (JsonSubTypes)object3)) == null) {
            return null;
        }
        ObjectNode objectNode2 = ai_12.a().o();
        switch (object2.include()) {
            case WRAPPER_ARRAY: {
                objectNode2.put(ai_12.a(ap_1.TAG_TYPE), ai_12.a(ap_1.TAG_TYPE_ARRAY));
                object2 = objectNode2.withArray(ai_12.a(ap_1.TAG_ITEMS));
                ((ArrayNode)object2).addObject().put(ai_12.a(ap_1.TAG_TYPE), ai_12.a(ap_1.TAG_TYPE_STRING)).put(ai_12.a(ap_1.TAG_CONST), (String)object3);
                if (objectNode == null || ((JsonNode)objectNode).isEmpty()) {
                    ((ArrayNode)object2).add(ai_12.a((ResolvedType)object, this));
                    break;
                }
                ((ArrayNode)object2).addObject().withArray(ai_12.a(ap_1.TAG_ALLOF)).add(ai_12.a((ResolvedType)object, this)).add(objectNode);
                break;
            }
            case WRAPPER_OBJECT: {
                objectNode2.put(ai_12.a(ap_1.TAG_TYPE), ai_12.a(ap_1.TAG_TYPE_OBJECT));
                object2 = objectNode2.with(ai_12.a(ap_1.TAG_PROPERTIES));
                if (objectNode == null || ((JsonNode)objectNode).isEmpty()) {
                    ((ObjectNode)object2).set((String)object3, ai_12.a((ResolvedType)object, this));
                } else {
                    ((ObjectNode)object2).with((String)object3).withArray(ai_12.a(ap_1.TAG_ALLOF)).add(ai_12.a((ResolvedType)object, this)).add(objectNode);
                }
                objectNode2.withArray(ai_12.a(ap_1.TAG_REQUIRED)).add((String)object3);
                break;
            }
            case PROPERTY: 
            case EXISTING_PROPERTY: {
                object2 = Optional.ofNullable(object2.property()).filter(string -> !string.isEmpty()).orElseGet(() -> bv_2.a((JsonTypeInfo)object2));
                object = objectNode2.withArray(ai_12.a(ap_1.TAG_ALLOF)).add(ai_12.a((ResolvedType)object, this)).addObject();
                if (objectNode != null && !((JsonNode)objectNode).isEmpty()) {
                    ((ObjectNode)object).setAll(objectNode);
                }
                ((ObjectNode)object).put(ai_12.a(ap_1.TAG_TYPE), ai_12.a(ap_1.TAG_TYPE_OBJECT)).with(ai_12.a(ap_1.TAG_PROPERTIES)).with((String)object2).put(ai_12.a(ap_1.TAG_CONST), (String)object3);
                ((ObjectNode)object).withArray(ai_12.a(ap_1.TAG_REQUIRED)).add((String)object2);
                break;
            }
            default: {
                return null;
            }
        }
        return objectNode2;
    }

    private static /* synthetic */ String a(JsonTypeInfo jsonTypeInfo) {
        return jsonTypeInfo.use().getDefaultPropertyName();
    }

    private static /* synthetic */ String d(Class clazz) {
        Class clazz2 = clazz;
        return Optional.ofNullable(clazz2.getAnnotation(JsonTypeName.class)).map(JsonTypeName::value).filter(string -> !string.isEmpty()).orElseGet(() -> bv_2.c(clazz));
    }
}

