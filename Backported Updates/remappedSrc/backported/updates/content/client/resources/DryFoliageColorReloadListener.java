/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  net.minecraft.class_3685
 *  net.minecraft.class_3695
 *  net.minecraft.class_4080
 */
package backported.updates.content.client.resources;

import backported.updates.content.client.api.color.DryFoliageColor;
import java.io.IOException;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import net.minecraft.class_3685;
import net.minecraft.class_3695;
import net.minecraft.class_4080;

@Environment(value=EnvType.CLIENT)
public class DryFoliageColorReloadListener
extends class_4080<int[]> {
    private static final class_2960 LOCATION = class_2960.method_60656((String)"textures/colormap/dry_foliage.png");
    public static final DryFoliageColorReloadListener INSTANCE = new DryFoliageColorReloadListener();

    protected int[] prepare(class_3300 resourceManager, class_3695 profiler) {
        try {
            return class_3685.method_16049((class_3300)resourceManager, (class_2960)LOCATION);
        }
        catch (IOException exception) {
            throw new IllegalStateException("Failed to load dry foliage color texture", exception);
        }
    }

    protected void apply(int[] object, class_3300 resourceManager, class_3695 profiler) {
        DryFoliageColor.init(object);
    }
}

