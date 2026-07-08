/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.util.Identifier
 *  net.minecraft.resource.ResourceManager
 *  net.minecraft.client.util.RawTextureDataLoader
 *  net.minecraft.util.profiler.Profiler
 *  net.minecraft.resource.SinglePreparationResourceReloader
 */
package backported.updates.content.client.resources;

import backported.updates.content.client.api.color.DryFoliageColor;
import java.io.IOException;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.client.util.RawTextureDataLoader;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.resource.SinglePreparationResourceReloader;

@Environment(value=EnvType.CLIENT)
public class DryFoliageColorReloadListener
extends SinglePreparationResourceReloader<int[]> {
    private static final Identifier LOCATION = Identifier.ofVanilla((String)"textures/colormap/dry_foliage.png");
    public static final DryFoliageColorReloadListener INSTANCE = new DryFoliageColorReloadListener();

    protected int[] prepare(ResourceManager resourceManager, Profiler profiler) {
        try {
            return RawTextureDataLoader.loadRawTextureData((ResourceManager)resourceManager, LOCATION);
        }
        catch (IOException exception) {
            throw new IllegalStateException("Failed to load dry foliage color texture", exception);
        }
    }

    protected void apply(int[] object, ResourceManager resourceManager, Profiler profiler) {
        DryFoliageColor.init(object);
    }
}

