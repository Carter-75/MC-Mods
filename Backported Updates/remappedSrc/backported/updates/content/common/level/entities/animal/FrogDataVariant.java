/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.common.api.variant.ClientAsset;
import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;

public record FrogDataVariant(ClientAsset assetInfo, SpawnPrioritySelectors spawnConditions) implements PriorityProvider<SpawnContext, SpawnCondition>
{
    public static final Codec<FrogDataVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)ClientAsset.DEFAULT_FIELD_CODEC.forGetter(FrogDataVariant::assetInfo), (App)SpawnPrioritySelectors.CODEC.fieldOf("spawn_conditions").forGetter(FrogDataVariant::spawnConditions)).apply((Applicative)instance, FrogDataVariant::new));

    private FrogDataVariant(ClientAsset clientAsset) {
        this(clientAsset, SpawnPrioritySelectors.EMPTY);
    }

    @Override
    public List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors() {
        return this.spawnConditions.selectors();
    }
}

