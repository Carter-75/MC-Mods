/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  net.minecraft.class_7947
 *  net.minecraft.class_7948
 *  net.minecraft.class_8066
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
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import net.minecraft.class_7947;
import net.minecraft.class_7948;
import net.minecraft.class_8066;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_7947.class})
public abstract class SpriteSourceListMixin {
    @Shadow
    @Final
    private static Logger field_41386;

    @Inject(method={"load"}, at={@At(value="RETURN")})
    private static void vb$handleArmorTrims(class_3300 manager, class_2960 location, CallbackInfoReturnable<class_7947> cir) {
        if (location.equals((Object)class_2960.method_60656((String)"armor_trims"))) {
            for (class_7948 source : ((SpriteSourceListMixin)cir.getReturnValue()).getSources()) {
                PalettedPermutationsAccessor permutations;
                if (!(source instanceof PalettedPermutationsAccessor) || !(permutations = (PalettedPermutationsAccessor)source).getPaletteKey().equals((Object)class_2960.method_60656((String)"trims/color_palettes/trim_palette"))) continue;
                class_2960 resin = class_2960.method_60656((String)"trims/color_palettes/resin");
                if (manager.method_14486(class_2960.method_60655((String)resin.method_12836(), (String)("textures/" + resin.method_12832() + ".png"))).isPresent()) {
                    HashMap<String, class_2960> map = new HashMap<String, class_2960>(permutations.getPermutations());
                    map.put("resin", resin);
                    permutations.setPermutations(map);
                    continue;
                }
                field_41386.warn("Resin palette texture not found at: {}", (Object)resin);
            }
        }
    }

    @Accessor(value="sources")
    abstract List<class_7948> getSources();

    @Mixin(value={class_8066.class})
    private static interface PalettedPermutationsAccessor {
        @Accessor
        public List<class_2960> getTextures();

        @Accessor(value="textures")
        @Mutable
        public void setTextures(List<class_2960> var1);

        @Accessor
        public Map<String, class_2960> getPermutations();

        @Accessor(value="permutations")
        @Mutable
        public void setPermutations(Map<String, class_2960> var1);

        @Accessor
        public class_2960 getPaletteKey();
    }
}

