/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.AnnotationConfiguration
 *  com.fasterxml.classmate.AnnotationConfiguration$StdConfiguration
 *  com.fasterxml.classmate.AnnotationInclusion
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;
import org.valkyrienskies.core.impl.shadow.ak_1;
import org.valkyrienskies.core.impl.shadow.au_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bd
 */
public final class bd_2 {
    private static au_1 a() {
        AnnotationInclusion annotationInclusion = AnnotationInclusion.INCLUDE_AND_INHERIT_IF_INHERITED;
        annotationInclusion = new AnnotationConfiguration.StdConfiguration(annotationInclusion);
        return new au_1((AnnotationConfiguration)annotationInclusion);
    }

    public static au_1 a(ak_1 ak_12) {
        return bd_2.a(AnnotationInclusion.INCLUDE_AND_INHERIT_IF_INHERITED, ak_12);
    }

    private static au_1 a(AnnotationInclusion annotationInclusion) {
        return bd_2.a((AnnotationConfiguration)new AnnotationConfiguration.StdConfiguration(annotationInclusion));
    }

    private static au_1 a(AnnotationInclusion annotationInclusion, ak_1 ak_12) {
        return bd_2.a((AnnotationConfiguration)new AnnotationConfiguration.StdConfiguration(annotationInclusion), ak_12);
    }

    private static au_1 a(AnnotationConfiguration annotationConfiguration) {
        return new au_1(annotationConfiguration);
    }

    private static au_1 a(AnnotationConfiguration annotationConfiguration, ak_1 ak_12) {
        return new au_1(annotationConfiguration, ak_12);
    }
}

