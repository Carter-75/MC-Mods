/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  com.fasterxml.classmate.ResolvedTypeWithMembers
 *  com.fasterxml.classmate.members.ResolvedMember
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.ResolvedTypeWithMembers;
import com.fasterxml.classmate.members.ResolvedMember;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.Optional;
import org.valkyrienskies.core.impl.shadow.au_1;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.ay_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aB
 */
public abstract class ab_1<M extends ResolvedMember<T>, T extends Member>
extends av_1 {
    public final M a;
    private final ResolvedType f;
    private final String g;
    public final ResolvedTypeWithMembers b;
    public boolean c;
    private final au_1 h;
    private final ay_1<String> i = new ay_1<String>(this::a);

    protected ab_1(M m2, ResolvedType resolvedType, String string, ResolvedTypeWithMembers resolvedTypeWithMembers, boolean bl, au_1 au_12) {
        super(Optional.ofNullable(resolvedType).orElseGet(() -> m2.getType()), au_12);
        this.a = m2;
        this.f = resolvedType;
        this.g = string;
        this.b = resolvedTypeWithMembers;
        this.c = bl;
        this.h = au_12;
    }

    private void b() {
        this.c = true;
    }

    public abstract ab_1<M, T> b(ResolvedType var1);

    public ab_1<M, T> e() {
        ab_1<M, T> ab_12;
        if (!this.v()) {
            ab_1 ab_13 = this;
            return ab_13.b(ab_13.f);
        }
        ab_1 ab_14 = this;
        ab_1<M, T> ab_15 = ab_12 = ab_14.b(ab_14.w());
        ab_12.c = true;
        return ab_12;
    }

    public abstract ab_1<M, T> b(String var1);

    public final M f() {
        return this.a;
    }

    public final ResolvedTypeWithMembers g() {
        return this.b;
    }

    public final ResolvedType h() {
        return this.a.getType();
    }

    public final ResolvedType i() {
        return this.f;
    }

    public final boolean j() {
        return this.c;
    }

    public String k() {
        return this.a.getName();
    }

    public final String l() {
        return this.g;
    }

    public final String m() {
        ab_1 ab_12 = this;
        return Optional.ofNullable(ab_12.g).orElseGet(this::k);
    }

    public final ResolvedType n() {
        return this.a.getDeclaringType();
    }

    public final T o() {
        return (T)this.a.getRawMember();
    }

    public final boolean p() {
        return this.a.isStatic();
    }

    public final boolean q() {
        return this.a.isFinal();
    }

    private boolean c() {
        return this.a.isPrivate();
    }

    private boolean d() {
        return this.a.isProtected();
    }

    public final boolean r() {
        return this.a.isPublic();
    }

    public <A extends Annotation> A d(Class<A> clazz) {
        return (A)this.a.get(clazz);
    }

    public abstract <A extends Annotation> A a(Class<A> var1);

    public abstract <A extends Annotation> A b(Class<A> var1);

    public final <A extends Annotation> A e(Class<A> clazz) {
        ab_1 ab_12 = this;
        if (ab_12.c) {
            return null;
        }
        return this.b(clazz);
    }

    public abstract <A extends Annotation> A c(Class<A> var1);

    private <A extends Annotation> A f(Class<A> clazz) {
        ab_1 ab_12 = this;
        if (ab_12.c) {
            return this.c(clazz);
        }
        ab_12 = this;
        if (ab_12.f != null) {
            ab_12 = this;
            if (ab_12.a.getType().getErasedType() == Optional.class) {
                ab_1 ab_13 = this;
                ab_12 = ab_13;
                ab_12 = this;
                if (ab_13.f.getErasedType() == ((ResolvedType)ab_12.a.getType().getTypeParameters().get(0)).getErasedType()) {
                    return this.c(clazz);
                }
            }
        }
        return null;
    }

    public String s() {
        return this.i.a();
    }

    protected abstract String a();

    @Override
    public String toString() {
        return this.x() + " " + this.s();
    }
}

