/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.AnnotationConfiguration
 *  com.fasterxml.classmate.MemberResolver
 *  com.fasterxml.classmate.ResolvedType
 *  com.fasterxml.classmate.ResolvedTypeWithMembers
 *  com.fasterxml.classmate.TypeResolver
 *  com.fasterxml.classmate.members.ResolvedField
 *  com.fasterxml.classmate.members.ResolvedMethod
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.MemberResolver;
import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.ResolvedTypeWithMembers;
import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.classmate.members.ResolvedField;
import com.fasterxml.classmate.members.ResolvedMethod;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.stream.Collectors;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ak_1;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.ay_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aU
 */
public final class au_1 {
    public final TypeResolver a = new TypeResolver();
    private final MemberResolver c = new MemberResolver(this.a);
    private final AnnotationConfiguration d;
    final boolean b;

    public au_1(AnnotationConfiguration annotationConfiguration) {
        this(annotationConfiguration, false);
    }

    public au_1(AnnotationConfiguration annotationConfiguration, ak_1 ak_12) {
        this(annotationConfiguration, ak_12.k());
    }

    private au_1(AnnotationConfiguration annotationConfiguration, boolean bl) {
        this.d = annotationConfiguration;
        this.b = bl;
    }

    public final boolean a() {
        return this.b;
    }

    public final ResolvedType a(Type type, Type ... typeArray) {
        return this.a.resolve(type, typeArray);
    }

    public final ResolvedType a(ResolvedType resolvedType, Class<?> clazz) {
        return this.a.resolveSubtype(resolvedType, clazz);
    }

    public final ResolvedTypeWithMembers a(ResolvedType resolvedType) {
        return this.c.resolve(resolvedType, this.d, null);
    }

    public final ay_2 a(ResolvedField resolvedField, ResolvedTypeWithMembers resolvedTypeWithMembers) {
        return new ay_2(resolvedField, resolvedTypeWithMembers, this);
    }

    public final ac_1 a(ResolvedMethod resolvedMethod, ResolvedTypeWithMembers resolvedTypeWithMembers) {
        return new ac_1(resolvedMethod, resolvedTypeWithMembers, this);
    }

    public final av_1 b(ResolvedType resolvedType) {
        return new av_1(resolvedType, this);
    }

    public final ResolvedType a(ResolvedType object, Class<?> clazz, int n2) {
        if ((object = object.typeParametersFor(clazz)) == null || !object.isEmpty() && object.size() <= n2 || object.isEmpty() && clazz.getTypeParameters().length <= n2) {
            return null;
        }
        if (object.isEmpty()) {
            return this.a((Type)((Object)Object.class), new Type[0]);
        }
        return (ResolvedType)object.get(n2);
    }

    public static boolean c(ResolvedType resolvedType) {
        return resolvedType.isArray() || resolvedType.isInstanceOf(Collection.class);
    }

    public final ResolvedType d(ResolvedType resolvedType) {
        ResolvedType resolvedType2 = resolvedType.getArrayElementType();
        if (resolvedType2 == null && au_1.c(resolvedType)) {
            resolvedType2 = this.a(resolvedType, Iterable.class, 0);
        }
        return resolvedType2;
    }

    public final String e(ResolvedType resolvedType) {
        return this.a(resolvedType, true);
    }

    public final String f(ResolvedType resolvedType) {
        return this.a(resolvedType, false);
    }

    private String a(ResolvedType object, boolean bl) {
        Object object2 = object.getErasedType();
        object2 = bl ? ((Class)object2).getSimpleName() : ((Class)object2).getTypeName();
        if (!(object = object.getTypeParameters()).isEmpty()) {
            object2 = (String)object2 + object.stream().map(resolvedType -> this.a((ResolvedType)resolvedType, bl)).collect(Collectors.joining(", ", "<", ">"));
        }
        return object2;
    }

    public final String g(ResolvedType object) {
        ResolvedType resolvedType = object;
        object = this;
        return object.a(resolvedType, true);
    }
}

