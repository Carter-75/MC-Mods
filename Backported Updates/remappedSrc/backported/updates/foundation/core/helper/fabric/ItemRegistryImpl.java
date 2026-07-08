/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1826
 */
package backported.updates.foundation.core.helper.fabric;

import java.util.function.Supplier;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1792;
import net.minecraft.class_1826;

public class ItemRegistryImpl {
    public static <T extends class_1308> class_1792 createSpawnEgg(Supplier<class_1299<T>> entity, int primaryColor, int secondaryColor, class_1792.class_1793 properties) {
        return new class_1826(entity.get(), primaryColor, secondaryColor, properties);
    }
}

