/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.resource.ResourceManager
 *  net.minecraft.client.texture.atlas.AtlasLoader
 *  net.minecraft.client.texture.atlas.AtlasSource
 *  net.minecraft.client.texture.atlas.PalettedPermutationsAtlasSource
 *  org.slf4j.Logger
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.client.texture.atlas.AtlasLoader;
import net.minecraft.client.texture.atlas.AtlasSource;
import net.minecraft.client.texture.atlas.PalettedPermutationsAtlasSource;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={AtlasLoader.class})
public abstract class SpriteSourceListMixin {
    @Shadow
    @Final
    private static Logger LOGGER;

    @Inject(method={"of"}, at={@At(value="RETURN")})
    private static void vb$handleArmorTrims(ResourceManager manager, Identifier location, CallbackInfoReturnable<AtlasLoader> cir) {
        if (location.equals(Identifier.ofVanilla((String)"armor_trims"))) {
            for (AtlasSource source : ((SpriteSourceListMixin)(Object)cir.getReturnValue()).getSources()) {
                PalettedPermutationsAccessor permutations;
                if (!(source instanceof PalettedPermutationsAccessor) || !(permutations = (PalettedPermutationsAccessor)source).getPaletteKey().equals(Identifier.ofVanilla((String)"trims/color_palettes/trim_palette"))) continue;
                Identifier resin = Identifier.ofVanilla((String)"trims/color_palettes/resin");
                if (manager.getResource(Identifier.of((String)resin.getNamespace(), (String)("textures/" + resin.getPath() + ".png"))).isPresent()) {
                    HashMap<String, Identifier> map = new HashMap<String, Identifier>(permutations.getPermutations());
                    map.put("resin", resin);
                    permutations.setPermutations(map);
                    continue;
                }
                LOGGER.warn("Resin palette texture not found at: {}", resin);
            }
        }
    }

    @Accessor(value="sources")
    abstract List<AtlasSource> getSources();

    @Mixin(value={PalettedPermutationsAtlasSource.class})
    private static interface PalettedPermutationsAccessor {
        @Accessor
        public List<Identifier> getTextures();

        @Accessor(value="textures")
        @Mutable
        public void setTextures(List<Identifier> var1);

        @Accessor
        public Map<String, Identifier> getPermutations();

        @Accessor(value="permutations")
        @Mutable
        public void setPermutations(Map<String, Identifier> var1);

        @Accessor
        public Identifier getPaletteKey();
    }
}

