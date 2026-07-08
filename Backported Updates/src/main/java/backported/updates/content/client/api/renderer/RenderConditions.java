/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 */
package backported.updates.content.client.api.renderer;

import backported.updates.content.core.ModChecker;
import backported.updates.content.core.VanillaBackport;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@FunctionalInterface
@Environment(value=EnvType.CLIENT)
public interface RenderConditions {
    public static final RenderConditions DEFAULT = () -> true;
    public static final RenderConditions FARM_ANIMALS = () -> VanillaBackport.COMMON_CONFIG.hasFarmAnimalVariants.get() != false && !ModChecker.MIXED_LITTER_LOADED;
    public static final RenderConditions SHEEP_UNDERCOAT = () -> VanillaBackport.CLIENT_CONFIG.useSheepWoolUndercoat.get() != false && !ModChecker.MIXED_LITTER_LOADED;

    public boolean apply();
}

