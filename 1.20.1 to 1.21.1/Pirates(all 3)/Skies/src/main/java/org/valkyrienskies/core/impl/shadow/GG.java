/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Named;
import kotlin.Metadata;
import org.valkyrienskies.core.impl.shadow.dw_1;
import org.valkyrienskies.core.impl.shadow.dx_1;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;

@dw_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\b\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/GG;", "", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "c", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "a", "d", "b", "e", "<init>", "()V"})
public final class GG {
    @dx_1
    public static ObjectMapper a() {
        return VSJacksonUtil.INSTANCE.getDefaultMapper();
    }

    @dx_1
    @Named(value="dto")
    public static ObjectMapper b() {
        return VSJacksonUtil.INSTANCE.getDtoMapper();
    }

    @dx_1
    @Named(value="config")
    public static ObjectMapper c() {
        return VSJacksonUtil.INSTANCE.getConfigMapper();
    }

    @dx_1
    @Named(value="delta")
    public static ObjectMapper d() {
        return VSJacksonUtil.INSTANCE.getDeltaMapper();
    }

    @dx_1
    @Named(value="packet")
    public static ObjectMapper e() {
        return VSJacksonUtil.INSTANCE.getPacketMapper();
    }
}

