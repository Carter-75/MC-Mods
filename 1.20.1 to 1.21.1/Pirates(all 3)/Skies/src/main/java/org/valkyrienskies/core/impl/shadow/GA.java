/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;

public final class GA
extends JacksonAnnotationIntrospector {
    private final Class<? extends Annotation>[] a;

    public GA(Class<? extends Annotation> ... classArray) {
        Intrinsics.checkNotNullParameter(classArray, (String)"");
        this.a = classArray;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean hasIgnoreMarker(AnnotatedMember m2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)m2, (String)"");
        return ((Annotated)m2).hasOneOf(this.a) || super.hasIgnoreMarker((AnnotatedMember)var1_1);
    }
}

