package com.itemuncrafting.recipe;

import com.itemuncrafting.ItemUncrafting;
import com.itemuncrafting.component.UncraftedItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import java.lang.reflect.Field;
import java.util.*;

public class UncraftingRecipe extends CustomRecipe {
    public static final MapCodec<UncraftingRecipe> CODEC = MapCodec.unit(UncraftingRecipe::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, UncraftingRecipe> STREAM_CODEC = StreamCodec.unit(new UncraftingRecipe());

    private static final ThreadLocal<UncraftingInfo> CURRENT_UNCRAFTING = new ThreadLocal<>();

    private static class UncraftingInfo {
        final List<ItemStack> materials;
        final int uncraftedAmount;

        UncraftingInfo(List<ItemStack> materials, int uncraftedAmount) {
            this.materials = materials;
            this.uncraftedAmount = uncraftedAmount;
        }
    }

    public UncraftingRecipe() {
        super();
    }

    @Override
    public CraftingBookCategory category() {
        return CraftingBookCategory.MISC;
    }

    @Override
    public boolean matches(CraftingInput input, Level world) {
        ItemStack target = getTargetItem(input);
        if (target.isEmpty()) {
            CURRENT_UNCRAFTING.remove();
            return false;
        }

        RecipeHolder<?> recipe = findCraftingRecipe(target.getItem(), world);
        if (recipe == null) {
            CURRENT_UNCRAFTING.remove();
            return false;
        }

        int outputCount = getRecipeOutputCount(recipe.value());
        if (outputCount <= 0) {
            CURRENT_UNCRAFTING.remove();
            return false;
        }

        List<Ingredient> ingredients = getRecipeIngredients(recipe.value());
        int ingredientsSize = ingredients.size();
        if (ingredientsSize <= 0) {
            CURRENT_UNCRAFTING.remove();
            return false;
        }

        int targetCount = target.getCount();
        int returnedCount = (targetCount * ingredientsSize) / outputCount;
        
        // Apply durability degradation for damageable items (durability applies to single items only)
        double durabilityPct = 1.0;
        if (target.isDamageableItem()) {
            durabilityPct = (double) (target.getMaxDamage() - target.getDamageValue()) / target.getMaxDamage();
            returnedCount = (int) Math.floor(returnedCount * durabilityPct);
        }

        if (returnedCount <= 0) {
            CURRENT_UNCRAFTING.remove();
            return false;
        }

        // Calculate consumed count
        int consumedAmount = (returnedCount * outputCount + ingredientsSize - 1) / ingredientsSize;
        if (consumedAmount > targetCount) {
            // Safety cap
            consumedAmount = targetCount;
        }

        List<ItemStack> rawIngredients = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < returnedCount; i++) {
            Ingredient ing = ingredients.get(i % ingredientsSize);
            if (!ing.isEmpty()) {
                List<net.minecraft.core.Holder<Item>> matching = ing.items().toList();
                if (!matching.isEmpty()) {
                    int randomIndex = random.nextInt(matching.size());
                    rawIngredients.add(new ItemStack(matching.get(randomIndex).value()));
                }
            }
        }

        Collections.shuffle(rawIngredients);

        CURRENT_UNCRAFTING.set(new UncraftingInfo(rawIngredients, consumedAmount));
        return true;
    }

    @Override
    public ItemStack assemble(CraftingInput input) {
        UncraftingInfo info = CURRENT_UNCRAFTING.get();
        if (info == null) {
            return ItemStack.EMPTY;
        }

        ItemStack crate = new ItemStack(ItemUncrafting.UNCRAFTED_CRATE_ITEM);
        crate.set(ItemUncrafting.UNCRAFTED_ITEMS, new UncraftedItems(info.materials));
        return crate;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        NonNullList<ItemStack> remaining = NonNullList.withSize(input.size(), ItemStack.EMPTY);
        UncraftingInfo info = CURRENT_UNCRAFTING.get();

        int targetSlot = -1;
        for (int i = 0; i < input.size(); i++) {
            if (!input.getItem(i).isEmpty()) {
                targetSlot = i;
                break;
            }
        }

        if (targetSlot != -1) {
            ItemStack target = input.getItem(targetSlot);
            int leftover = target.getCount();
            if (info != null) {
                leftover -= info.uncraftedAmount;
            }
            if (leftover > 0) {
                ItemStack remainingStack = target.copy();
                remainingStack.setCount(leftover);
                remaining.set(targetSlot, remainingStack);
            }
        }

        CURRENT_UNCRAFTING.remove();
        return remaining;
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return ItemUncrafting.UNCRAFTING_RECIPE_SERIALIZER;
    }

    private ItemStack getTargetItem(CraftingInput input) {
        ItemStack target = ItemStack.EMPTY;
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (!stack.isEmpty()) {
                target = stack;
                count++;
            }
        }
        return count == 1 ? target : ItemStack.EMPTY;
    }

    @SuppressWarnings("unchecked")
    private Collection<RecipeHolder<?>> getRecipesClientSafe(Level world) {
        if (!world.isClientSide()) {
            if (world instanceof net.minecraft.server.level.ServerLevel serverLevel) {
                return serverLevel.getServer().getRecipeManager().getRecipes();
            }
        } else {
            try {
                Class<?> minecraftClass = Class.forName("net.minecraft.client.Minecraft");
                Object minecraft = minecraftClass.getMethod("getInstance").invoke(null);
                Object connection = minecraftClass.getMethod("getConnection").invoke(minecraft);
                Object recipeManager = connection.getClass().getMethod("getRecipeManager").invoke(connection);
                return (Collection<RecipeHolder<?>>) recipeManager.getClass().getMethod("getRecipes").invoke(recipeManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    private RecipeHolder<?> findCraftingRecipe(Item item, Level world) {
        for (RecipeHolder<?> holder : getRecipesClientSafe(world)) {
            if (holder.value().getType() == RecipeType.CRAFTING) {
                Item output = getRecipeOutputItem(holder.value());
                if (output == item) {
                    return holder;
                }
            }
        }
        return null;
    }

    private Item getRecipeOutputItem(Recipe<?> recipe) {
        try {
            if (recipe instanceof ShapedRecipe shaped) {
                Field f = ShapedRecipe.class.getDeclaredField("result");
                f.setAccessible(true);
                ItemStackTemplate template = (ItemStackTemplate) f.get(shaped);
                return template.item().value();
            } else if (recipe instanceof ShapelessRecipe shapeless) {
                Field f = ShapelessRecipe.class.getDeclaredField("result");
                f.setAccessible(true);
                ItemStackTemplate template = (ItemStackTemplate) f.get(shapeless);
                return template.item().value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int getRecipeOutputCount(Recipe<?> recipe) {
        try {
            if (recipe instanceof ShapedRecipe shaped) {
                Field f = ShapedRecipe.class.getDeclaredField("result");
                f.setAccessible(true);
                ItemStackTemplate template = (ItemStackTemplate) f.get(shaped);
                return template.count();
            } else if (recipe instanceof ShapelessRecipe shapeless) {
                Field f = ShapelessRecipe.class.getDeclaredField("result");
                f.setAccessible(true);
                ItemStackTemplate template = (ItemStackTemplate) f.get(shapeless);
                return template.count();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    private List<Ingredient> getRecipeIngredients(Recipe<?> recipe) {
        try {
            if (recipe instanceof ShapedRecipe shaped) {
                List<Ingredient> ingredients = new ArrayList<>();
                for (Optional<Ingredient> opt : shaped.getIngredients()) {
                    opt.ifPresent(ingredients::add);
                }
                return ingredients;
            } else if (recipe instanceof ShapelessRecipe shapeless) {
                Field f = ShapelessRecipe.class.getDeclaredField("ingredients");
                f.setAccessible(true);
                return (List<Ingredient>) f.get(shapeless);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
