/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_3302
 */
package backported.updates.content.client;

import backported.updates.content.client.CreativeTabIntegration;
import backported.updates.content.client.ItemPropertyRegistrar;
import backported.updates.content.client.Rendering;
import backported.updates.content.client.api.bundle.BundleMouseActions;
import backported.updates.content.client.api.tabs.BundledTabSelector;
import backported.updates.content.client.resources.DryFoliageColorReloadListener;
import backported.updates.content.client.resources.LeafColorReloadListener;
import backported.updates.content.common.registries.ModWoodTypes;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.client.GameRendering;
import backported.updates.foundation.client.event.LocalPlayerEvents;
import backported.updates.foundation.common.block.WoodTypeRegistry;
import backported.updates.foundation.core.ParallelDispatch;
import backported.updates.foundation.core.events.ResourcePackManager;
import backported.updates.foundation.core.events.ResourceReloadManager;
import net.minecraft.class_2960;
import net.minecraft.class_3302;

public class ClientSetup {
    public static void setup() {
        ResourcePackManager.registerBuiltResourcePack(VanillaBackport.resource("freshly_animated"), "vanillabackport", "Freshly Animated");
        ResourcePackManager.registerBuiltResourcePack(VanillaBackport.resource("freshly_animated_legacy"), "vanillabackport", "Freshly Animated Legacy");
        ResourceReloadManager.registerClient(event -> {
            event.register(class_2960.method_60656((String)"dry_foliage"), (class_3302)DryFoliageColorReloadListener.INSTANCE);
            event.register(class_2960.method_60656((String)"leaf_colors"), (class_3302)LeafColorReloadListener.INSTANCE);
        });
        GameRendering.registerParticleFactories(Rendering::particleFactories);
        GameRendering.registerModelLayers(Rendering::modelLayers);
        GameRendering.registerEntityRenderers(Rendering::entityRendering);
        GameRendering.registerBlockColors(Rendering::blockColors);
        GameRendering.registerItemColors(Rendering::itemColors);
        GameRendering.registerSpecialModels(Rendering::specialModels);
    }

    public static void asyncSetup(ParallelDispatch dispatch) {
        dispatch.enqueueWork(() -> LocalPlayerEvents.ON_LOGIN.register(player -> BundledTabSelector.bootstrap()));
        BundleMouseActions.bootstrap();
        GameRendering.registerBlockRenderers(Rendering::blockRendering);
        WoodTypeRegistry.registerWoodType(ModWoodTypes.PALE_OAK);
        CreativeTabIntegration.bootstrap();
        ItemPropertyRegistrar.bootstrap();
    }
}

