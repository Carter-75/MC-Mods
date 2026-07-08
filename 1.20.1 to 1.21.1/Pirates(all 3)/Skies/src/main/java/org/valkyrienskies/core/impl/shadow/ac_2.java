/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.EnumSet;
import org.valkyrienskies.core.impl.shadow.aa_2;
import org.valkyrienskies.core.impl.shadow.af_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ac
 */
final class ac_2
extends af_2 {
    private ac_2(JsonNode jsonNode) {
        this(jsonNode, aa_2.a());
    }

    ac_2(JsonNode jsonNode, EnumSet<aa_2> enumSet) {
        super((JsonNode)jsonNode.deepCopy(), enumSet);
    }
}

