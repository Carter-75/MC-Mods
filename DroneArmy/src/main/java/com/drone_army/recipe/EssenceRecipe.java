package com.drone_army.recipe;

import com.drone_army.item.EssenceItem;
import com.drone_army.registry.ModRecipes;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;

public class EssenceRecipe extends SpecialCraftingRecipe {
    public EssenceRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(net.minecraft.recipe.input.CraftingRecipeInput input, World world) {
        boolean hasEssence = false;
        int count = 0;
        for (int i = 0; i < input.getSize(); ++i) {
            ItemStack stack = input.getStackInSlot(i);
            if (!stack.isEmpty()) {
                count++;
                if (stack.getItem() instanceof EssenceItem) {
                    hasEssence = true;
                }
            }
        }
        return count == 1 && hasEssence;
    }

    @Override
    public ItemStack craft(net.minecraft.recipe.input.CraftingRecipeInput input,
            net.minecraft.registry.RegistryWrapper.WrapperLookup lookup) {
        for (int i = 0; i < input.getSize(); ++i) {
            ItemStack stack = input.getStackInSlot(i);
            if (!stack.isEmpty() && stack.getItem() instanceof EssenceItem) {
                // Extract Entity Type from Essence
                NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
                if (nbt.contains(EssenceItem.ESSENCE_KEY)) {
                    NbtCompound essenceData = nbt.getCompound(EssenceItem.ESSENCE_KEY);
                    if (essenceData.contains(EssenceItem.ENTITY_ID_KEY)) {
                        String entityId = essenceData.getString(EssenceItem.ENTITY_ID_KEY);
                        Identifier id = Identifier.tryParse(entityId);
                        if (id != null) {
                            net.minecraft.entity.EntityType<?> type = Registries.ENTITY_TYPE.get(id);
                            if (type != null) {
                                SpawnEggItem egg = SpawnEggItem.forEntity(type);
                                if (egg != null) {
                                    ItemStack result = new ItemStack(egg);
                                    // Transfer Entity Data
                                    if (essenceData.contains("EntityTag")) {
                                        NbtCompound resultNbt = result
                                                .getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT)
                                                .copyNbt();
                                        resultNbt.put("EntityTag", essenceData.getCompound("EntityTag"));
                                        result.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(resultNbt));
                                    }
                                    return result;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 1;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ESSENCE_RECIPE_SERIALIZER;
    }
}
