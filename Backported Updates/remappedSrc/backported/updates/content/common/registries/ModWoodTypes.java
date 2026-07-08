/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_4719
 *  net.minecraft.class_8177
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.registries.ModBlockSetTypes;
import backported.updates.foundation.common.block.WoodTypeRegistry;
import net.minecraft.class_2960;
import net.minecraft.class_4719;
import net.minecraft.class_8177;

public class ModWoodTypes {
    public static final class_4719 PALE_OAK = ModWoodTypes.register("pale_oak", ModBlockSetTypes.PALE_OAK);

    private static class_4719 register(String name, class_8177 set) {
        return WoodTypeRegistry.create(class_2960.method_60656((String)name), set);
    }
}

