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
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Type;
import org.valkyrienskies.core.impl.shadow.ag_1;
import org.valkyrienskies.core.impl.shadow.ak_1;
import org.valkyrienskies.core.impl.shadow.au_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aJ
 */
public final class aj_1 {
    private final ak_1 a;
    private final au_1 b;

    private aj_1(ak_1 ak_12) {
        ak_1 ak_13 = ak_12;
        ak_1 ak_14 = ak_12 = ak_13;
        ak_12 = AnnotationInclusion.INCLUDE_AND_INHERIT_IF_INHERITED;
        ak_12 = new AnnotationConfiguration.StdConfiguration((AnnotationInclusion)ak_12);
        this(ak_13, new au_1((AnnotationConfiguration)ak_12, ak_14));
    }

    private aj_1(ak_1 ak_12, au_1 au_12) {
        this.a = ak_12;
        this.b = au_12;
    }

    private ObjectNode a(Type type, Type ... typeArray) {
        return ag_1.a(this.a, this.b, type, typeArray);
    }

    private ag_1 a() {
        au_1 au_12 = this.b;
        ak_1 ak_12 = this.a;
        return new ag_1(ak_12, au_12);
    }
}

