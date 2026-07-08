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
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 */
package backported.updates.copper.item.armor;

import backported.updates.copper.Constants;
import backported.updates.copper.ModSounds;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_156;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1802;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_6880;
import net.minecraft.class_7923;

public class CopperArmorMaterial {
    private static final EnumMap<class_1738.class_8051, Integer> DEFENSE = (EnumMap)class_156.method_654(new EnumMap(class_1738.class_8051.class), map -> {
        map.put(class_1738.class_8051.field_41937, 1);
        map.put(class_1738.class_8051.field_41936, 3);
        map.put(class_1738.class_8051.field_41935, 4);
        map.put(class_1738.class_8051.field_41934, 2);
        map.put(class_1738.class_8051.field_48838, 4);
    });
    public static Supplier<class_6880<class_1741>> COPPER;

    private static class_6880<class_1741> createCopper() {
        class_2960 location = class_2960.method_60656((String)"copper");
        List<class_1741.class_9196> layers = List.of(new class_1741.class_9196(location));
        EnumMap<class_1738.class_8051, Integer> enummap = new EnumMap<class_1738.class_8051, Integer>(class_1738.class_8051.class);
        for (class_1738.class_8051 type : class_1738.class_8051.values()) {
            enummap.put(type, DEFENSE.get(type));
        }
        class_6880 equipSound = class_6880.method_40223((Object)ModSounds.ARMOR_EQUIP_COPPER.get());
        return class_2378.method_47985((class_2378)class_7923.field_48976, (class_2960)location, (Object)new class_1741(enummap, 8, equipSound, () -> class_1856.method_8091((class_1935[])new class_1935[]{class_1802.field_27022}), layers, 0.0f, 0.0f));
    }

    public static void init() {
        Constants.LOG.info("Registering Copper Armor Material for {}", (Object)"Copper-Age-Backport");
        COPPER = () -> CopperArmorMaterial.createCopper();
    }
}

