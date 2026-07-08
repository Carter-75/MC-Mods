/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.recipe.RecipeSerializer
 *  net.minecraft.recipe.SpecialRecipeSerializer
 *  net.minecraft.registry.Registries
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.crafting.BundleColoring;
import backported.updates.foundation.core.CoreRegistry;
import java.util.function.Supplier;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;

public class ModRecipeSerializers {
    public static final CoreRegistry<RecipeSerializer<?>> SERIALIZERS = CoreRegistry.create(Registries.RECIPE_SERIALIZER, "minecraft");
    public static final Supplier<RecipeSerializer<BundleColoring>> BUNDLE_COLORING = SERIALIZERS.register("crafting_special_bundlecoloring", () -> new SpecialRecipeSerializer(BundleColoring::new));
}

