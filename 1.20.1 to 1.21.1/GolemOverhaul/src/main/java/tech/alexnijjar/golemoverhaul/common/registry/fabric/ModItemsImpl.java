/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1826
 */
package tech.alexnijjar.golemoverhaul.common.registry.fabric;

import java.util.function.Supplier;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1792;
import net.minecraft.class_1826;

public class ModItemsImpl {
    public static class_1826 createSpawnEgg(Supplier<? extends class_1299<? extends class_1308>> type, int backgroundColor, int highlightColor, class_1792.class_1793 properties) {
        return new class_1826(type.get(), backgroundColor, highlightColor, properties);
    }
}

