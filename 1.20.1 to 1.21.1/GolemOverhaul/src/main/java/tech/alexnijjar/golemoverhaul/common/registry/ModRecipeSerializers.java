/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.registry.RegistryEntry
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry
 *  net.minecraft.class_1865
 *  net.minecraft.class_2378
 *  net.minecraft.class_7923
 */
package tech.alexnijjar.golemoverhaul.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.class_1865;
import net.minecraft.class_2378;
import net.minecraft.class_7923;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;

public class ModRecipeSerializers {
    public static final ResourcefulRegistry<class_1865<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create((class_2378)class_7923.field_41189, (String)"golemoverhaul");
    public static final RegistryEntry<class_1865<GolemConstructionRecipe>> GOLEM_CONSTRUCTION = RECIPE_SERIALIZERS.register("golem_construction", () -> GolemConstructionRecipe.Serializer.INSTANCE);
}

