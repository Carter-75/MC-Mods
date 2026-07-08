/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1741
 *  net.minecraft.class_1741$class_9196
 *  net.minecraft.class_1802
 *  net.minecraft.class_1856
 *  net.minecraft.class_1935
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 */
package backported.updates.content.common.registries;

import backported.updates.content.core.FeatureFlag;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.class_156;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1802;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_6880;
import net.minecraft.class_7923;

public class ModArmorMaterials {
    public static final Optional<class_6880<class_1741>> COPPER = ModArmorMaterials.register("copper", (EnumMap)class_156.method_654(new EnumMap(class_1738.class_8051.class), attributes -> {
        attributes.put(class_1738.class_8051.field_41937, 1);
        attributes.put(class_1738.class_8051.field_41936, 3);
        attributes.put(class_1738.class_8051.field_41935, 4);
        attributes.put(class_1738.class_8051.field_41934, 2);
        attributes.put(class_1738.class_8051.field_48838, 4);
    }), 8, (class_6880<class_3414>)class_3417.field_14862, 0.0f, 0.0f, () -> class_1856.method_8091((class_1935[])new class_1935[]{class_1802.field_27022}), FeatureFlag.COPPER_AGE);

    public static Optional<class_6880<class_1741>> register(String name, EnumMap<class_1738.class_8051, Integer> defense, int enchantmentValue, class_6880<class_3414> equipSound, float toughness, float knockbackResistance, Supplier<class_1856> repairIngredient, FeatureFlag flag) {
        if (flag.isEnabled()) {
            List<class_1741.class_9196> layers = List.of(new class_1741.class_9196(class_2960.method_60656((String)name)));
            return ModArmorMaterials.register(name, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, layers, flag);
        }
        return Optional.empty();
    }

    private static Optional<class_6880<class_1741>> register(String name, EnumMap<class_1738.class_8051, Integer> defense, int enchantmentValue, class_6880<class_3414> equipSound, float toughness, float knockbackResistance, Supplier<class_1856> repairIngredient, List<class_1741.class_9196> layers, FeatureFlag flag) {
        if (flag.isEnabled()) {
            return Optional.of(class_2378.method_47985((class_2378)class_7923.field_48976, (class_2960)class_2960.method_60656((String)name), (Object)new class_1741(defense, enchantmentValue, equipSound, repairIngredient, layers, toughness, knockbackResistance)));
        }
        return Optional.empty();
    }
}

