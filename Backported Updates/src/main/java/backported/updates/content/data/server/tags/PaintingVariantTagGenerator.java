/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.decoration.painting.PaintingVariant
 *  net.minecraft.data.server.tag.TagProvider
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.registry.tag.PaintingVariantTags
 *  net.minecraft.data.DataOutput
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModPaintingVariants;
import java.util.concurrent.CompletableFuture;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PaintingVariantTags;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryKeys;

public class PaintingVariantTagGenerator
extends TagProvider<PaintingVariant> {
    public PaintingVariantTagGenerator(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookupProvider) {
        super(output, RegistryKeys.PAINTING_VARIANT, lookupProvider);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider) {
        this.getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE).add(ModPaintingVariants.DENNIS);
    }
}

