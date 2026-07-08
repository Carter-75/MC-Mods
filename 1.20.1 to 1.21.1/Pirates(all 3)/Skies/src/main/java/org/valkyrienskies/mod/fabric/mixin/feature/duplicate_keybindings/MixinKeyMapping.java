/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.minecraft.class_304
 *  net.minecraft.class_3675$class_306
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.fabric.mixin.feature.duplicate_keybindings;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.class_304;
import net.minecraft.class_3675;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.config.VSKeyBindings;
import org.valkyrienskies.mod.fabric.mixin.feature.duplicate_keybindings.KeyMappingAccessor;

@Mixin(value={class_304.class})
public class MixinKeyMapping {
    @Unique
    private static final Map<class_3675.class_306, class_304> VS2_KEYMAP = Maps.newHashMap();
    @Shadow
    @Final
    private static Map<class_3675.class_306, class_304> field_1658;
    @Shadow
    @Final
    private static Map<String, class_304> field_1657;
    @Shadow
    private class_3675.class_306 field_1655;

    @Inject(method={"click"}, at={@At(value="HEAD")})
    private static void preClick(class_3675.class_306 key, CallbackInfo callbackInfo) {
        class_304 originalKeyMapping = field_1658.get(key);
        class_304 vs2KeyMapping = VS2_KEYMAP.get(key);
        if (vs2KeyMapping != null && originalKeyMapping != vs2KeyMapping) {
            KeyMappingAccessor keyMappingAccessor = (KeyMappingAccessor)vs2KeyMapping;
            keyMappingAccessor.setClickCount(keyMappingAccessor.getClickCount() + 1);
        }
    }

    @Inject(method={"set"}, at={@At(value="HEAD")})
    private static void preSet(class_3675.class_306 key, boolean bl, CallbackInfo callbackInfo) {
        class_304 originalKeyMapping = field_1658.get(key);
        class_304 vs2KeyMapping = VS2_KEYMAP.get(key);
        if (vs2KeyMapping != null && originalKeyMapping != vs2KeyMapping) {
            vs2KeyMapping.method_23481(bl);
        }
    }

    @Inject(method={"resetMapping"}, at={@At(value="HEAD")})
    private static void preResetMapping(CallbackInfo callbackInfo) {
        VS2_KEYMAP.clear();
        for (class_304 keyMapping : field_1657.values()) {
            if (!VSKeyBindings.INSTANCE.isKeyMappingFromVS2(keyMapping)) continue;
            KeyMappingAccessor keyMappingAccessor = (KeyMappingAccessor)keyMapping;
            VS2_KEYMAP.put(keyMappingAccessor.getKey(), keyMapping);
        }
    }

    @Inject(method={"<init>"}, at={@At(value="RETURN")}, remap=false)
    private void postInit(CallbackInfo callbackInfo) {
        class_304 thisAsKeyMapping = (class_304)class_304.class.cast(this);
        if (VSKeyBindings.INSTANCE.isKeyMappingFromVS2(thisAsKeyMapping)) {
            VS2_KEYMAP.put(this.field_1655, thisAsKeyMapping);
        }
    }
}

