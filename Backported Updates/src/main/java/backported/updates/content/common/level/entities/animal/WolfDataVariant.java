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

public record WolfDataVariant(AssetInfo assetInfo, SpawnPrioritySelectors spawnConditions) implements PriorityProvider<SpawnContext, SpawnCondition>
{
    public static final Codec<WolfDataVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group(AssetInfo.CODEC.fieldOf("assets").forGetter(WolfDataVariant::assetInfo), SpawnPrioritySelectors.CODEC.fieldOf("spawn_conditions").forGetter(WolfDataVariant::spawnConditions)).apply(instance, WolfDataVariant::new));

    @Override
    public List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors() {
        return this.spawnConditions.selectors();
    }

    public record AssetInfo(ClientAsset wild, ClientAsset tame, ClientAsset angry) {
        public static final Codec<AssetInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group(ClientAsset.CODEC.fieldOf("wild").forGetter(AssetInfo::wild), ClientAsset.CODEC.fieldOf("tame").forGetter(AssetInfo::tame), ClientAsset.CODEC.fieldOf("angry").forGetter(AssetInfo::angry)).apply(instance, AssetInfo::new));
    }
}

