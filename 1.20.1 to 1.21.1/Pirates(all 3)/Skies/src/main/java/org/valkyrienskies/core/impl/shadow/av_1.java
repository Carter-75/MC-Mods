/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import org.valkyrienskies.core.impl.shadow.au_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aV
 */
public class av_1 {
    public final ResolvedType d;
    public final au_1 e;

    protected av_1(ResolvedType resolvedType, au_1 au_12) {
        this.d = resolvedType;
        this.e = au_12;
    }

    public final au_1 t() {
        return this.e;
    }

    public final ResolvedType u() {
        return this.d;
    }

    public final ResolvedType a(Class<?> clazz, int n2) {
        return this.e.a(this.d, clazz, n2);
    }

    public final boolean v() {
        av_1 av_12 = this;
        ResolvedType resolvedType = av_12.d;
        if (resolvedType != null) {
            av_12 = this;
            au_1 cfr_ignored_0 = av_12.e;
            if (au_1.c(resolvedType)) {
                return true;
            }
        }
        return false;
    }

    public final ResolvedType w() {
        av_1 av_12 = this;
        ResolvedType resolvedType = av_12.d;
        if (resolvedType == null) {
            return null;
        }
        av_12 = this;
        return av_12.e.d(resolvedType);
    }

    public final String x() {
        av_1 av_12 = this;
        ResolvedType resolvedType = av_12.d;
        if (resolvedType == null) {
            return "void";
        }
        av_12 = this;
        return av_12.e.e(resolvedType);
    }

    private String a() {
        av_1 av_12 = this;
        ResolvedType resolvedType = av_12.d;
        if (resolvedType == null) {
            return "void";
        }
        av_12 = this;
        return av_12.e.f(resolvedType);
    }

    public String toString() {
        return this.x();
    }
}

