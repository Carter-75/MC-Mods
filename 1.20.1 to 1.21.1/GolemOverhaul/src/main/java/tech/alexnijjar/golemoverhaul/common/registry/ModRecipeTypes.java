/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.registry.RegistryEntry
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry
 *  net.minecraft.class_2378
 *  net.minecraft.class_3956
 *  net.minecraft.class_7923
 */
package tech.alexnijjar.golemoverhaul.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.class_2378;
import net.minecraft.class_3956;
import net.minecraft.class_7923;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;

public class ModRecipeTypes {
    public static final ResourcefulRegistry<class_3956<?>> RECIPE_TYPES = ResourcefulRegistries.create((class_2378)class_7923.field_41188, (String)"golemoverhaul");
    public static final RegistryEntry<class_3956<GolemConstructionRecipe>> GOLEM_CONSTRUCTION = RECIPE_TYPES.register("golem_construction", () -> GolemConstructionRecipe.Type.INSTANCE);
}

