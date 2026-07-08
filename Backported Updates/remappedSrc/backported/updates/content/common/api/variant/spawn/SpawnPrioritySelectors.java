/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.class_9135
 *  net.minecraft.class_9139
 */
package backported.updates.content.common.api.variant.spawn;

import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.List;
import net.minecraft.class_9135;
import net.minecraft.class_9139;

public record SpawnPrioritySelectors(List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors) {
    public static final SpawnPrioritySelectors EMPTY = new SpawnPrioritySelectors(List.of());
    public static final Codec<SpawnPrioritySelectors> CODEC = PriorityProvider.Selector.codec(SpawnCondition.CODEC).listOf().xmap(SpawnPrioritySelectors::new, SpawnPrioritySelectors::selectors);
    public static final class_9139<ByteBuf, SpawnPrioritySelectors> STREAM_CODEC = class_9135.method_56368(CODEC);

    public static SpawnPrioritySelectors single(SpawnCondition condition, int priority) {
        return new SpawnPrioritySelectors(PriorityProvider.single(condition, priority));
    }

    public static SpawnPrioritySelectors fallback(int priority) {
        return new SpawnPrioritySelectors(PriorityProvider.alwaysTrue(priority));
    }
}

