/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1920
 *  net.minecraft.class_1959
 *  net.minecraft.class_1959$class_5482
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4700
 *  net.minecraft.class_638
 *  net.minecraft.class_6539
 *  net.minecraft.class_6880
 */
package backported.updates.content.client.api.color;

import backported.updates.content.client.api.color.DryFoliageColor;
import backported.updates.content.client.resources.LeafColorReloadListener;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported_updates.mixin.access.BiomeAccessor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1920;
import net.minecraft.class_1959;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4700;
import net.minecraft.class_638;
import net.minecraft.class_6539;
import net.minecraft.class_6880;

@Environment(value=EnvType.CLIENT)
public class LeafColors {
    private static final Map<Predicate<class_6880<class_1959>>, Integer> COLOR_MAP = new ConcurrentHashMap<Predicate<class_6880<class_1959>>, Integer>();
    public static final class_6539 DRY_FOLIAGE_COLOR_RESOLVER = (biome, d, e) -> {
        class_1959.class_5482 settings = ((BiomeAccessor)biome).getClimateSettings();
        double temperature = class_3532.method_15363((float)settings.comp_844(), (float)0.0f, (float)1.0f);
        double humidity = class_3532.method_15363((float)settings.comp_846(), (float)0.0f, (float)1.0f);
        return DryFoliageColor.get(temperature, humidity);
    };

    public static int getAverageDryFoliageColor(class_2338 pos) {
        class_638 level = class_310.method_1551().field_1687;
        if (level != null) {
            class_6880 biome = level.method_23753(pos);
            return COLOR_MAP.entrySet().stream().filter(entry -> ((Predicate)entry.getKey()).test(biome)).findFirst().map(Map.Entry::getValue).orElseGet(() -> new class_4700(value -> level.method_23780(value, DRY_FOLIAGE_COLOR_RESOLVER)).method_23770(pos));
        }
        return -10732494;
    }

    public static int getClientLeafTintColor(class_2338 pos) {
        class_638 level = class_310.method_1551().field_1687;
        if (level == null) {
            return 0;
        }
        class_2680 state = level.method_8320(pos);
        class_2248 block = state.method_26204();
        if (LeafColorReloadListener.hasCustomColor(block)) {
            return LeafColorReloadListener.getCustomColor(block);
        }
        return class_310.method_1551().method_1505().method_1697(state, (class_1920)level, pos, 0);
    }

    static {
        COLOR_MAP.put(holder -> holder.method_40220(ModBiomeTags.HAS_PALE_LEAF_LITTER), 10528412);
        COLOR_MAP.put(holder -> holder.method_40220(ModBiomeTags.HAS_DARK_LEAF_LITTER), 8082228);
    }
}

