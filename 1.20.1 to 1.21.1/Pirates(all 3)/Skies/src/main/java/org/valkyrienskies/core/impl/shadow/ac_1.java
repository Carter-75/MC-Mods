/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  com.fasterxml.classmate.ResolvedTypeWithMembers
 *  com.fasterxml.classmate.members.ResolvedField
 *  com.fasterxml.classmate.members.ResolvedMethod
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.ResolvedTypeWithMembers;
import com.fasterxml.classmate.members.ResolvedField;
import com.fasterxml.classmate.members.ResolvedMethod;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedParameterizedType;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.au_1;
import org.valkyrienskies.core.impl.shadow.ay_1;
import org.valkyrienskies.core.impl.shadow.ay_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aC
 */
public final class ac_1
extends ab_1<ResolvedMethod, Method> {
    private final ay_1<ay_2> f = new ay_1<ay_2>(this::B);

    protected ac_1(ResolvedMethod resolvedMethod, ResolvedTypeWithMembers resolvedTypeWithMembers, au_1 au_12) {
        this(resolvedMethod, (ResolvedType)null, (String)null, resolvedTypeWithMembers, false, au_12);
    }

    private ac_1(ResolvedMethod resolvedMethod, ResolvedType resolvedType, String string, ResolvedTypeWithMembers resolvedTypeWithMembers, boolean bl, au_1 au_12) {
        super(resolvedMethod, resolvedType, string, resolvedTypeWithMembers, bl, au_12);
    }

    public final ac_1 a(ResolvedType resolvedType) {
        return new ac_1((ResolvedMethod)this.f(), resolvedType, this.l(), this.g(), this.j(), this.t());
    }

    public final ac_1 a(String string) {
        return new ac_1((ResolvedMethod)this.f(), this.i(), string, this.g(), this.j(), this.t());
    }

    private ac_1 y() {
        return (ac_1)super.e();
    }

    public final boolean b() {
        return this.u() == null;
    }

    private int z() {
        return ((ResolvedMethod)this.f()).getArgumentCount();
    }

    private List<ResolvedType> A() {
        return IntStream.range(0, this.z()).mapToObj(arg_0 -> ((ResolvedMethod)((ResolvedMethod)this.f())).getArgumentType(arg_0)).collect(Collectors.toList());
    }

    public final ay_2 c() {
        return this.f.a();
    }

    private ay_2 B() {
        if (this.u() == null || !this.r() || this.z() > 0) {
            return null;
        }
        String string = this.k();
        string = string.startsWith("get") && string.length() > 3 && Character.isUpperCase(string.charAt(3)) ? string.substring(3, 4).toLowerCase() + string.substring(4) : (string.startsWith("is") && string.length() > 2 && Character.isUpperCase(string.charAt(2)) ? string.substring(2, 3).toLowerCase() + string.substring(3) : null);
        if (string == null) {
            return null;
        }
        return Stream.of(this.g().getMemberFields()).filter(resolvedField -> resolvedField.getName().equals(string)).findFirst().map(resolvedField -> this.t().a((ResolvedField)resolvedField, this.g())).orElse(null);
    }

    public final boolean d() {
        return this.c() != null;
    }

    @Override
    public final <A extends Annotation> A d(Class<A> clazz) {
        A a2 = super.d(clazz);
        if (a2 == null) {
            a2 = ((Method)this.o()).getAnnotatedReturnType().getAnnotation(clazz);
        }
        return a2;
    }

    @Override
    public final <A extends Annotation> A a(Class<A> clazz) {
        AnnotatedType[] annotatedTypeArray = ((Method)this.o()).getAnnotatedReturnType();
        if (annotatedTypeArray instanceof AnnotatedParameterizedType && (annotatedTypeArray = ((AnnotatedParameterizedType)annotatedTypeArray).getAnnotatedActualTypeArguments()).length == 1) {
            return annotatedTypeArray[0].getAnnotation(clazz);
        }
        return null;
    }

    @Override
    public final <A extends Annotation> A b(Class<A> clazz) {
        Object object = ((ab_1)this).d(clazz);
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
    protected final String a() {
        String string = this.m();
        Object object = this.t();
        if (((au_1)object).b && this.z() == 0) {
            if (this.l() == null) {
                string = string.startsWith("get") && string.length() > 3 ? Character.toLowerCase(string.charAt(3)) + string.substring(4) : (string.startsWith("is") && string.length() > 2 ? Character.toLowerCase(string.charAt(2)) + string.substring(3) : string + "()");
            }
        } else {
            object = this;
            string = string + IntStream.range(0, ((ac_1)object).z()).mapToObj(arg_0 -> ((ResolvedMethod)((ResolvedMethod)((ab_1)object).f())).getArgumentType(arg_0)).collect(Collectors.toList()).stream().map(this.t()::g).collect(Collectors.joining(", ", "(", ")"));
        }
        return string;
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

