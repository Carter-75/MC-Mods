/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.network.codec.PacketCodecs
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.content.common.api.variant.spawn;

import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.List;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.codec.PacketCodec;

public record SpawnPrioritySelectors(List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors) {
    public static final SpawnPrioritySelectors EMPTY = new SpawnPrioritySelectors(List.of());
    public static final Codec<SpawnPrioritySelectors> CODEC = PriorityProvider.Selector.codec(SpawnCondition.CODEC).listOf().xmap(SpawnPrioritySelectors::new, SpawnPrioritySelectors::selectors);
    public static final PacketCodec<ByteBuf, SpawnPrioritySelectors> STREAM_CODEC = PacketCodecs.codec(CODEC);

    public static SpawnPrioritySelectors single(SpawnCondition condition, int priority) {
        return new SpawnPrioritySelectors(PriorityProvider.single(condition, priority));
    }

    public static SpawnPrioritySelectors fallback(int priority) {
        return new SpawnPrioritySelectors(PriorityProvider.alwaysTrue(priority));
    }
}

