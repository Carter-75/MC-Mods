/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.shedaniel.rei.api.client.plugins.REIClientPlugin
 *  me.shedaniel.rei.api.client.registry.category.CategoryRegistry
 *  me.shedaniel.rei.api.client.registry.display.DisplayCategory
 *  me.shedaniel.rei.api.client.registry.display.DisplayRegistry
 *  me.shedaniel.rei.forge.REIPluginClient
 *  net.minecraft.class_3956
 */
package tech.alexnijjar.golemoverhaul.client.compat.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.forge.REIPluginClient;
import net.minecraft.class_3956;
import tech.alexnijjar.golemoverhaul.client.compat.rei.GolemConstructionCategory;
import tech.alexnijjar.golemoverhaul.client.compat.rei.GolemConstructionDisplay;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;
import tech.alexnijjar.golemoverhaul.common.registry.ModRecipeTypes;

@REIPluginClient
public class GolemOverhaulReiPlugin
implements REIClientPlugin {
    public void registerCategories(CategoryRegistry registry) {
        registry.add((DisplayCategory)new GolemConstructionCategory());
    }

    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(GolemConstructionRecipe.class, (class_3956)ModRecipeTypes.GOLEM_CONSTRUCTION.get(), GolemConstructionDisplay::new);
    }
}

