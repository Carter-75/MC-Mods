/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.shedaniel.rei.api.common.category.CategoryIdentifier
 *  me.shedaniel.rei.api.common.display.Display
 *  me.shedaniel.rei.api.common.entry.EntryIngredient
 *  me.shedaniel.rei.api.common.util.EntryIngredients
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_7922
 *  net.minecraft.class_7923
 */
package tech.alexnijjar.golemoverhaul.client.compat.rei;

import java.util.List;
import java.util.Objects;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_7922;
import net.minecraft.class_7923;
import tech.alexnijjar.golemoverhaul.client.compat.rei.GolemConstructionCategory;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;

public record GolemConstructionDisplay(GolemConstructionRecipe recipe) implements Display
{
    public List<EntryIngredient> getInputEntries() {
        return this.recipe.getKey().values().stream().map(arg_0 -> ((class_7922)class_7923.field_41175).method_29107(arg_0)).filter(Objects::nonNull).map(class_2248::method_8389).filter(item -> item != class_1802.field_8162).map(EntryIngredients::of).toList();
    }

    public List<EntryIngredient> getOutputEntries() {
        return List.of(EntryIngredients.of((class_1935)((class_1935)Objects.requireNonNull((class_1792)class_7923.field_41178.method_29107(this.recipe.getItem())))));
    }

    public CategoryIdentifier<?> getCategoryIdentifier() {
        return GolemConstructionCategory.ID;
    }
}

