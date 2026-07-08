/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  net.minecraft.item.Items
 *  net.minecraft.item.ToolMaterial
 *  net.minecraft.recipe.Ingredient
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Block
 *  net.minecraft.registry.tag.TagKey
 */
package backported.updates.content.common.registries;

import backported.updates.content.core.data.tags.ModBlockTags;
import com.google.common.base.Suppliers;
import java.util.function.Supplier;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.TagKey;

public enum ToolMaterials implements ToolMaterial
{
    COPPER(ModBlockTags.INCORRECT_FOR_COPPER_TOOL, 190, 5.0f, 1.0f, 13, () -> Ingredient.ofItems((ItemConvertible[])new ItemConvertible[]{Items.COPPER_INGOT}));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    private ToolMaterials(TagKey<Block> incorrectBlocksForDrops, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getDurability() {
        return this.uses;
    }

    public float getMiningSpeedMultiplier() {
        return this.speed;
    }

    public float getAttackDamage() {
        return this.damage;
    }

    public TagKey<Block> getInverseTag() {
        return this.incorrectBlocksForDrops;
    }

    public int getEnchantability() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

