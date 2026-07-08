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
    public static final Codec<WolfDataVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)AssetInfo.CODEC.fieldOf("assets").forGetter(WolfDataVariant::assetInfo), (App)SpawnPrioritySelectors.CODEC.fieldOf("spawn_conditions").forGetter(WolfDataVariant::spawnConditions)).apply((Applicative)instance, WolfDataVariant::new));

    @Override
    public List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors() {
        return this.spawnConditions.selectors();
    }

    public record AssetInfo(ClientAsset wild, ClientAsset tame, ClientAsset angry) {
        public static final Codec<AssetInfo> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)ClientAsset.CODEC.fieldOf("wild").forGetter(AssetInfo::wild), (App)ClientAsset.CODEC.fieldOf("tame").forGetter(AssetInfo::tame), (App)ClientAsset.CODEC.fieldOf("angry").forGetter(AssetInfo::angry)).apply((Applicative)instance, AssetInfo::new));
    }
}

