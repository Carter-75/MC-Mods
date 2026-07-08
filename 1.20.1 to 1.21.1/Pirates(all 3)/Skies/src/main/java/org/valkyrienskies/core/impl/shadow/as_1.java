/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.valkyrienskies.core.impl.shadow.at_1;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.bb_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aS
 */
@Deprecated
public interface as_1
extends at_1 {
    public void a();

    @Override
    default public void a(ObjectNode objectNode, av_1 av_12, bb_2 bb_22) {
        bb_22.a();
    }
}

