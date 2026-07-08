/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$EntityTypeTagProvider
 *  net.minecraft.entity.EntityType
 *  net.minecraft.registry.tag.EntityTypeTags
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.core.data.tags.ModEntityTypeTags;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.RegistryWrapper;

public class EntityTypeTagGenerator
extends FabricTagProvider.EntityTypeTagProvider {
    public EntityTypeTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider) {
        this.getOrCreateTagBuilder(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(ModEntities.HAPPY_GHAST.get());
        this.getOrCreateTagBuilder(EntityTypeTags.DISMOUNTS_UNDERWATER).add(ModEntities.HAPPY_GHAST.get());
        this.getOrCreateTagBuilder(ModEntityTypeTags.FOLLOWABLE_FRIENDLY_MOBS).add(new EntityType[]{EntityType.BEE, EntityType.CAMEL, EntityType.CAT, EntityType.CHICKEN, EntityType.COW, EntityType.DONKEY, EntityType.FOX, EntityType.GOAT, ModEntities.HAPPY_GHAST.get(), EntityType.HORSE, EntityType.SKELETON_HORSE, EntityType.LLAMA, EntityType.MULE, EntityType.OCELOT, EntityType.PANDA, EntityType.PARROT, EntityType.PIG, EntityType.POLAR_BEAR, EntityType.RABBIT, EntityType.SHEEP, EntityType.SNIFFER, EntityType.STRIDER, EntityType.VILLAGER, EntityType.WOLF});
    }
}

