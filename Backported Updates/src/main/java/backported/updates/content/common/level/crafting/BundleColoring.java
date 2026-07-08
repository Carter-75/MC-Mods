/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.DyeItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.recipe.SpecialCraftingRecipe
 *  net.minecraft.recipe.RecipeSerializer
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.world.World
 *  net.minecraft.item.BundleItem
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.recipe.book.CraftingRecipeCategory
 *  net.minecraft.recipe.input.CraftingRecipeInput
 */
package backported.updates.content.common.level.crafting;

import backported.updates.content.common.api.bundle.BundleFeatures;
import backported.updates.content.common.registries.ModRecipeSerializers;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.item.ItemConvertible;
import net.minecraft.world.World;
import net.minecraft.item.BundleItem;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;

public class BundleColoring
extends SpecialCraftingRecipe {
    public BundleColoring(CraftingRecipeCategory category) {
        super(category);
    }

    public boolean matches(CraftingRecipeInput input, World level) {
        int bundles = 0;
        int dyes = 0;
        for (int slot = 0; slot < input.getSize(); ++slot) {
            ItemStack stack = input.getStackInSlot(slot);
            if (stack.isEmpty()) continue;
            if (stack.getItem() instanceof BundleItem) {
                ++bundles;
            } else if (stack.getItem() instanceof DyeItem) {
                ++dyes;
            } else {
                return false;
            }
            if (dyes <= 1 && bundles <= 1) continue;
            return false;
        }
        return bundles == 1 && dyes == 1;
    }

    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        ItemStack bundle = ItemStack.EMPTY;
        DyeItem dye = (DyeItem)Items.WHITE_DYE;
        for (int slot = 0; slot < input.getSize(); ++slot) {
            ItemStack stack = input.getStackInSlot(slot);
            if (stack.isEmpty()) continue;
            Item item = stack.getItem();
            if (item instanceof BundleItem) {
                bundle = stack;
                continue;
            }
            if (!(item instanceof DyeItem)) continue;
            dye = (DyeItem)item;
        }
        Item result = BundleFeatures.getByColor(dye.getColor());
        return bundle.copyComponentsToNewStack((ItemConvertible)result, 1);
    }

    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.BUNDLE_COLORING.get();
    }
}

