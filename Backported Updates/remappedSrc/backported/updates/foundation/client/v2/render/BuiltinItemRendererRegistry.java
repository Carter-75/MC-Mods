/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_811
 */
package backported.updates.foundation.client.v2.render;

import backported.updates.foundation.client.v2.render.fabric.BuiltinItemRendererRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_811;

public abstract class BuiltinItemRendererRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static BuiltinItemRendererRegistry getInstance() {
        return BuiltinItemRendererRegistryImpl.getInstance();
    }

    public abstract void register(class_1935 var1, DynamicItemRenderer var2);

    public abstract DynamicItemRenderer get(class_1935 var1);

    @FunctionalInterface
    public static interface DynamicItemRenderer {
        public void render(class_1799 var1, class_811 var2, class_4587 var3, class_4597 var4, int var5, int var6);
    }
}

