/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.valkyrienskies.core.impl.shadow.aa_1;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ai_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.az
 */
@Deprecated
public interface az_2<M extends ab_1<?, ?>>
extends aa_1<M> {
    public void overrideInstanceAttributes(ObjectNode var1, M var2);

    /*
     * WARNING - void declaration
     */
    @Override
    default public void overrideInstanceAttributes(ObjectNode jsonSchemaAttributesNode, M member, ai_1 context) {
        void var2_2;
        void var1_1;
        this.overrideInstanceAttributes((ObjectNode)var1_1, var2_2);
    }
}

