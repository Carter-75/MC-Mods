/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  net.minecraft.class_1802
 *  net.minecraft.class_1832
 *  net.minecraft.class_1856
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_6862
 */
package backported.updates.content.common.registries;

import backported.updates.content.core.data.tags.ModBlockTags;
import com.google.common.base.Suppliers;
import java.util.function.Supplier;
import net.minecraft.class_1802;
import net.minecraft.class_1832;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_6862;

public enum ToolMaterials implements class_1832
{
    COPPER(ModBlockTags.INCORRECT_FOR_COPPER_TOOL, 190, 5.0f, 1.0f, 13, () -> class_1856.method_8091((class_1935[])new class_1935[]{class_1802.field_27022}));

    private final class_6862<class_2248> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<class_1856> repairIngredient;

    private ToolMaterials(class_6862<class_2248> incorrectBlocksForDrops, int uses, float speed, float damage, int enchantmentValue, Supplier<class_1856> repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int method_8025() {
        return this.uses;
    }

    public float method_8027() {
        return this.speed;
    }

    public float method_8028() {
        return this.damage;
    }

    public class_6862<class_2248> method_58419() {
        return this.incorrectBlocksForDrops;
    }

    public int method_8026() {
        return this.enchantmentValue;
    }

    public class_1856 method_8023() {
        return this.repairIngredient.get();
    }
}

