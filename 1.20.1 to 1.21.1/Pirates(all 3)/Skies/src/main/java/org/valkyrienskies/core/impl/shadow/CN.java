/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.CK;

public final class CN
implements CK {
    private final ObjectMapper a;

    @Inject
    public CN(ObjectMapper objectMapper) {
        Intrinsics.checkNotNullParameter((Object)objectMapper, (String)"");
        this.a = objectMapper;
    }

    @Override
    public final JsonNode a(Object object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Object t = this.a.valueToTree(object);
        Intrinsics.checkNotNullExpressionValue(t, (String)"");
        return t;
    }

    @Override
    public final Object a(JsonNode jsonNode, Class<?> clazz) {
        Intrinsics.checkNotNullParameter((Object)jsonNode, (String)"");
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Object obj = ((ObjectCodec)this.a).treeToValue(jsonNode, clazz);
        Intrinsics.checkNotNullExpressionValue(obj, (String)"");
        return obj;
    }
}

