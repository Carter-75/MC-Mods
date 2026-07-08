/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 */
package backported.updates.content.common.api.variant.spawn;

import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.core.registries.ModRegistries;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

public interface SpawnCondition
extends PriorityProvider.SelectorCondition<SpawnContext> {
    public static final Codec<SpawnCondition> CODEC = ModRegistries.SPAWN_CONDITION_TYPE.get().getCodec().dispatch(SpawnCondition::codec, codec -> codec);

    public MapCodec<? extends SpawnCondition> codec();
}

