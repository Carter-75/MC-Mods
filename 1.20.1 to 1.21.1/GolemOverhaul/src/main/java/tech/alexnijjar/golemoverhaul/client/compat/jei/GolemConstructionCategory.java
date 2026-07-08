/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.gui.builder.IRecipeLayoutBuilder
 *  mezz.jei.api.gui.drawable.IDrawable
 *  mezz.jei.api.gui.drawable.IDrawableStatic
 *  mezz.jei.api.gui.ingredient.IRecipeSlotsView
 *  mezz.jei.api.helpers.IGuiHelper
 *  mezz.jei.api.recipe.IFocusGroup
 *  mezz.jei.api.recipe.RecipeIngredientRole
 *  mezz.jei.api.recipe.RecipeType
 *  mezz.jei.api.recipe.category.IRecipeCategory
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1856
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_332
 *  net.minecraft.class_7922
 *  net.minecraft.class_7923
 */
package tech.alexnijjar.golemoverhaul.client.compat.jei;

import java.util.Objects;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_7922;
import net.minecraft.class_7923;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.compat.jei.GolemConstructionDrawable;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantComponents;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;
import tech.alexnijjar.golemoverhaul.common.registry.ModItems;

public record GolemConstructionCategory(IGuiHelper guiHelper) implements IRecipeCategory<GolemConstructionRecipe>
{
    public static final class_2960 ID = GolemOverhaul.asResource("golem_construction");
    public static final RecipeType<GolemConstructionRecipe> RECIPE = new RecipeType(ID, GolemConstructionRecipe.class);

    public RecipeType<GolemConstructionRecipe> getRecipeType() {
        return RECIPE;
    }

    public class_2561 getTitle() {
        return ConstantComponents.GOLEM_CONSTRUCTION_CATEGORY;
    }

    public IDrawable getIcon() {
        return this.guiHelper.createDrawableItemStack(((class_1792)ModItems.CLAY_GOLEM_STATUE.get()).method_7854());
    }

    public int getWidth() {
        return 180;
    }

    public int getHeight() {
        return 76;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, GolemConstructionRecipe recipe, IFocusGroup group) {
        recipe.getKey().values().stream().map(arg_0 -> ((class_7922)class_7923.field_41175).method_29107(arg_0)).filter(Objects::nonNull).map(class_2248::method_8389).filter(item -> item != class_1802.field_8162).forEach(item -> builder.addInvisibleIngredients(RecipeIngredientRole.INPUT).addIngredients(class_1856.method_8091((class_1935[])new class_1935[]{item})));
        builder.addInvisibleIngredients(RecipeIngredientRole.OUTPUT).addIngredients(class_1856.method_8091((class_1935[])new class_1935[]{(class_1935)Objects.requireNonNull((class_1792)class_7923.field_41178.method_29107(recipe.getItem()))}));
    }

    public void draw(GolemConstructionRecipe recipe, IRecipeSlotsView recipeSlotsView, class_332 guiGraphics, double mouseX, double mouseY) {
        new GolemConstructionDrawable(mouseX, mouseY, recipe, 47, 58).draw(guiGraphics);
        IDrawableStatic recipeArrow = this.guiHelper.getRecipeArrow();
        recipeArrow.draw(guiGraphics, 78, 30);
    }
}

