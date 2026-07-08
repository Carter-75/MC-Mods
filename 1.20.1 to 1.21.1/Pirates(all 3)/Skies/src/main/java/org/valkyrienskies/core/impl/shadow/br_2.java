/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  com.fasterxml.classmate.members.ResolvedMethod
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.members.ResolvedMethod;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.ap_1;
import org.valkyrienskies.core.impl.shadow.at_2;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.aw_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.br
 */
public final class br_2
implements av_2 {
    private final boolean a;
    private final boolean b;

    public br_2(boolean bl, boolean bl2) {
        this.a = bl;
        this.b = bl2;
    }

    @Override
    public final at_2 a(ResolvedType object, ai_1 ai_12) {
        Object object2 = object.getErasedType().getEnumConstants();
        if (object2 == null || ((T[])object2).length == 0) {
            return null;
        }
        List<Object> list = null;
        if (this.a) {
            list = this.a((ResolvedType)object, (Object[])object2, ai_12);
        }
        if (list == null && this.b) {
            list = br_2.a(object, object2);
        }
        if (list == null) {
            return null;
        }
        object = ai_12.a().o().put(ai_12.a(ap_1.TAG_TYPE), ai_12.a(ap_1.TAG_TYPE_STRING));
        object2 = new aw_1(ai_12.a().n());
        object2.a((ObjectNode)object, list, ai_12);
        return new at_2((ObjectNode)object);
    }

    private List<Object> a(ResolvedType object, Object[] objectArray, ai_1 object2) {
        object = object2.b().a((ResolvedType)object).getMemberMethods();
        if ((object = (object = Stream.of(object).filter(resolvedMethod -> resolvedMethod.getArgumentCount() == 0).filter(resolvedMethod -> Optional.ofNullable((JsonValue)resolvedMethod.getAnnotations().get(JsonValue.class)).map(JsonValue::value).orElse(Boolean.FALSE)).collect(Collectors.toSet())).size() == 1 ? (ResolvedMethod)object.iterator().next() : null) == null) {
            return null;
        }
        try {
            object2 = new ArrayList(objectArray.length);
            for (Object object3 : objectArray) {
                object2.add(((Method)object.getRawMember()).invoke(object3, new Object[0]));
            }
            return object2;
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            return null;
        }
    }

    private static ResolvedMethod b(ResolvedType object, ai_1 ai_12) {
        object = ai_12.b().a((ResolvedType)object).getMemberMethods();
        if ((object = Stream.of(object).filter(resolvedMethod -> resolvedMethod.getArgumentCount() == 0).filter(resolvedMethod -> Optional.ofNullable((JsonValue)resolvedMethod.getAnnotations().get(JsonValue.class)).map(JsonValue::value).orElse(Boolean.FALSE)).collect(Collectors.toSet())).size() == 1) {
            return (ResolvedMethod)object.iterator().next();
        }
        return null;
    }

    private static List<String> a(ResolvedType resolvedType, Object[] objectArray) {
        try {
            ArrayList<String> arrayList = new ArrayList<String>(objectArray.length);
            for (Object object : objectArray) {
                object = ((Enum)object).name();
                JsonProperty jsonProperty = resolvedType.getErasedType().getDeclaredField((String)object).getAnnotation(JsonProperty.class);
                if (jsonProperty == null) {
                    return null;
                }
                arrayList.add((String)("".equals(jsonProperty.value()) ? object : jsonProperty.value()));
            }
            return arrayList;
        }
        catch (NoSuchFieldException | SecurityException exception) {
            return null;
        }
    }
}

