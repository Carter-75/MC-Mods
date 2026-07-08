/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  com.fasterxml.classmate.ResolvedTypeWithMembers
 *  com.fasterxml.classmate.members.ResolvedField
 *  com.fasterxml.classmate.members.ResolvedMember
 *  com.fasterxml.classmate.members.ResolvedMethod
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.ResolvedTypeWithMembers;
import com.fasterxml.classmate.members.ResolvedField;
import com.fasterxml.classmate.members.ResolvedMember;
import com.fasterxml.classmate.members.ResolvedMethod;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedParameterizedType;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.au_1;
import org.valkyrienskies.core.impl.shadow.ay_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ay
 */
public final class ay_2
extends ab_1<ResolvedField, Field> {
    private final ay_1<ac_1> f = new ay_1<ac_1>(this::z);

    protected ay_2(ResolvedField resolvedField, ResolvedTypeWithMembers resolvedTypeWithMembers, au_1 au_12) {
        this(resolvedField, (ResolvedType)null, (String)null, resolvedTypeWithMembers, false, au_12);
    }

    private ay_2(ResolvedField resolvedField, ResolvedType resolvedType, String string, ResolvedTypeWithMembers resolvedTypeWithMembers, boolean bl, au_1 au_12) {
        super(resolvedField, resolvedType, string, resolvedTypeWithMembers, bl, au_12);
    }

    public final ay_2 a(ResolvedType resolvedType) {
        return new ay_2((ResolvedField)this.f(), resolvedType, this.l(), this.g(), this.j(), this.t());
    }

    public final ay_2 a(String string) {
        return new ay_2((ResolvedField)this.f(), this.i(), string, this.g(), this.j(), this.t());
    }

    private ay_2 y() {
        return (ay_2)super.e();
    }

    @Override
    protected final String a() {
        return this.m();
    }

    public final boolean b() {
        return ((ResolvedField)this.f()).isTransient();
    }

    public final ac_1 c() {
        return this.f.a();
    }

    private ac_1 z() {
        String string = this.k().substring(0, 1).toUpperCase() + this.k().substring(1);
        String string2 = "get" + string;
        string = "is" + string;
        ResolvedMethod[] resolvedMethodArray = this.g().getMemberMethods();
        return Stream.of(resolvedMethodArray).filter(resolvedMethod -> ((Method)resolvedMethod.getRawMember()).getParameterCount() == 0).filter(ResolvedMember::isPublic).filter(resolvedMethod -> resolvedMethod.getName().equals(string2) || resolvedMethod.getName().equals(string)).findFirst().map(resolvedMethod -> this.t().a((ResolvedMethod)resolvedMethod, this.g())).orElse(null);
    }

    public final boolean d() {
        return this.c() != null;
    }

    @Override
    public final <A extends Annotation> A a(Class<A> clazz) {
        AnnotatedType[] annotatedTypeArray = ((Field)this.o()).getAnnotatedType();
        if (annotatedTypeArray instanceof AnnotatedParameterizedType && (annotatedTypeArray = ((AnnotatedParameterizedType)annotatedTypeArray).getAnnotatedActualTypeArguments()).length == 1) {
            return annotatedTypeArray[0].getAnnotation(clazz);
        }
        return null;
    }

    @Override
    public final <A extends Annotation> A b(Class<A> clazz) {
        Object object = this.d(clazz);
        if (object == null) {
            object = this.c();
            object = object == null ? null : ((ab_1)object).d(clazz);
        }
        return object;
    }

    @Override
    public final <A extends Annotation> A c(Class<A> clazz) {
        Object object = ((ab_1)this).a(clazz);
        if (object == null) {
            object = this.c();
            object = object == null ? null : ((ab_1)object).a(clazz);
        }
        return object;
    }

    @Override
    public final /* synthetic */ ab_1 b(String string) {
        return this.a(string);
    }

    @Override
    public final /* synthetic */ ab_1 b(ResolvedType resolvedType) {
        return this.a(resolvedType);
    }
}

