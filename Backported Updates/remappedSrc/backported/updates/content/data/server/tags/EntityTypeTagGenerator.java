/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider$EntityTypeTagProvider
 *  net.minecraft.class_1299
 *  net.minecraft.class_3483
 *  net.minecraft.class_7225$class_7874
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.core.data.tags.ModEntityTypeTags;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_1299;
import net.minecraft.class_3483;
import net.minecraft.class_7225;

public class EntityTypeTagGenerator
extends FabricTagProvider.EntityTypeTagProvider {
    public EntityTypeTagGenerator(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void method_10514(class_7225.class_7874 provider) {
        this.getOrCreateTagBuilder(class_3483.field_42971).add(ModEntities.HAPPY_GHAST.get());
        this.getOrCreateTagBuilder(class_3483.field_43096).add(ModEntities.HAPPY_GHAST.get());
        this.getOrCreateTagBuilder(ModEntityTypeTags.FOLLOWABLE_FRIENDLY_MOBS).add((Object[])new class_1299[]{class_1299.field_20346, class_1299.field_40116, class_1299.field_16281, class_1299.field_6132, class_1299.field_6085, class_1299.field_6067, class_1299.field_17943, class_1299.field_30052, ModEntities.HAPPY_GHAST.get(), class_1299.field_6139, class_1299.field_6075, class_1299.field_6074, class_1299.field_6057, class_1299.field_6081, class_1299.field_6146, class_1299.field_6104, class_1299.field_6093, class_1299.field_6042, class_1299.field_6140, class_1299.field_6115, class_1299.field_42622, class_1299.field_23214, class_1299.field_6077, class_1299.field_6055});
    }
}

