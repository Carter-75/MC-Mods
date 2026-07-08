/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.IModPlugin
 *  mezz.jei.api.JeiPlugin
 *  mezz.jei.api.helpers.IGuiHelper
 *  mezz.jei.api.recipe.category.IRecipeCategory
 *  mezz.jei.api.registration.IRecipeCategoryRegistration
 *  mezz.jei.api.registration.IRecipeRegistration
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3956
 *  net.minecraft.class_638
 *  org.jetbrains.annotations.NotNull
 */
package tech.alexnijjar.golemoverhaul.client.compat.jei;

import java.util.Objects;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3956;
import net.minecraft.class_638;
import org.jetbrains.annotations.NotNull;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.compat.jei.GolemConstructionCategory;
import tech.alexnijjar.golemoverhaul.common.registry.ModRecipeTypes;

@JeiPlugin
public class GolemOverhaulJeiPlugin
implements IModPlugin {
    @NotNull
    public class_2960 getPluginUid() {
        return GolemOverhaul.asResource("jei");
    }

    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new IRecipeCategory[]{new GolemConstructionCategory(guiHelper)});
    }

    public void registerRecipes(IRecipeRegistration registration) {
        class_638 level = Objects.requireNonNull(class_310.method_1551().field_1687);
        registration.addRecipes(GolemConstructionCategory.RECIPE, level.method_8433().method_30027((class_3956)ModRecipeTypes.GOLEM_CONSTRUCTION.get()));
    }
}

