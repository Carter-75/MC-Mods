/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap
 *  net.minecraft.class_2498
 *  net.minecraft.class_3414
 *  net.minecraft.class_8177
 *  net.minecraft.class_8177$class_2441
 */
package backported.updates.garden;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.util.Map;
import net.minecraft.class_2498;
import net.minecraft.class_3414;
import net.minecraft.class_8177;

public record ModBlockSetType(String name, boolean canOpenByHand, boolean canOpenByWindCharge, boolean canButtonBeActivatedByArrows, class_8177.class_2441 pressurePlateSensitivity, class_2498 soundType, class_3414 doorClose, class_3414 doorOpen, class_3414 trapdoorClose, class_3414 trapdoorOpen, class_3414 pressurePlateClickOff, class_3414 pressurePlateClickOn, class_3414 buttonClickOff, class_3414 buttonClickOn) {
    public static final class_8177 PALE;
    private static final Map<String, ModBlockSetType> VALUES;

    private static class_8177 register(class_8177 blockSetType) {
        ModBlockSetType modBlockSetType = new ModBlockSetType(blockSetType.comp_1289(), blockSetType.comp_1471(), blockSetType.comp_2112(), blockSetType.comp_1972(), blockSetType.comp_1973(), blockSetType.comp_1290(), blockSetType.comp_1291(), blockSetType.comp_1292(), blockSetType.comp_1293(), blockSetType.comp_1294(), blockSetType.comp_1295(), blockSetType.comp_1296(), blockSetType.comp_1297(), blockSetType.comp_1298());
        VALUES.put(blockSetType.comp_1289(), modBlockSetType);
        return blockSetType;
    }

    static {
        VALUES = new Object2ObjectArrayMap();
        PALE = ModBlockSetType.register(new class_8177("pale_oak"));
    }
}

