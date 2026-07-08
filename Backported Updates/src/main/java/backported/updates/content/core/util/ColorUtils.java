/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.DyeColor
 *  net.minecraft.item.DyeItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.world.World
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.recipe.CraftingRecipe
 *  net.minecraft.recipe.RecipeType
 *  net.minecraft.util.math.ColorHelper$Argb
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.recipe.input.CraftingRecipeInput
 *  net.minecraft.recipe.input.RecipeInput
 */
package backported.updates.content.core.util;

import java.util.List;
import net.minecraft.util.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.recipe.input.CraftingRecipeInput;

public class ColorUtils {
    public static int scaleRGB(int color, float red, float green, float blue) {
        return ColorHelper.Argb.getArgb((int)ColorHelper.Argb.getAlpha((int)color), (int)MathHelper.clamp((int)((int)((float)ColorHelper.Argb.getRed((int)color) * red)), (int)0, (int)255), (int)MathHelper.clamp((int)((int)((float)ColorHelper.Argb.getGreen((int)color) * green)), (int)0, (int)255), (int)MathHelper.clamp((int)((int)((float)ColorHelper.Argb.getBlue((int)color) * blue)), (int)0, (int)255));
    }

    public static int colorFromFloat(float alpha, float red, float green, float blue) {
        return ColorHelper.Argb.getArgb((int)((int)(alpha * 255.0f)), (int)((int)(red * 255.0f)), (int)((int)(green * 255.0f)), (int)((int)(blue * 255.0f)));
    }

    public static DyeColor getMixedColor(ServerWorld level, DyeColor colorA, DyeColor colorB) {
        CraftingRecipeInput container = ColorUtils.makeCraftColorInput(colorA, colorB);
        return level.getRecipeManager().getFirstMatch(RecipeType.CRAFTING, container, (World)level).map(recipe -> ((CraftingRecipe)recipe.value()).craft(container, (RegistryWrapper.WrapperLookup)level.getRegistryManager())).map(ItemStack::getItem).filter(DyeItem.class::isInstance).map(DyeItem.class::cast).map(DyeItem::getColor).orElseGet(() -> level.random.nextBoolean() ? colorA : colorB);
    }

    private static CraftingRecipeInput makeCraftColorInput(DyeColor colorA, DyeColor colorB) {
        return CraftingRecipeInput.create((int)2, (int)1, List.of(new ItemStack((ItemConvertible)DyeItem.byColor((DyeColor)colorA)), new ItemStack((ItemConvertible)DyeItem.byColor((DyeColor)colorB))));
    }
}

