/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1959
 *  net.minecraft.class_1959$class_1960
 *  net.minecraft.class_2893$class_2895
 *  net.minecraft.class_2922
 *  net.minecraft.class_3864
 *  net.minecraft.class_4763$class_4764
 *  net.minecraft.class_4968
 *  net.minecraft.class_5483$class_5496
 *  net.minecraft.class_5485$class_5495
 *  net.minecraft.class_6796
 *  net.minecraft.class_7871
 */
package backported.updates.content.common.worldgen.biomes;

import backported.updates.content.common.worldgen.placements.TheGardenAwakensPlacements;
import backported_updates.mixin.access.OverworldBiomesAccessor;
import net.minecraft.class_1959;
import net.minecraft.class_2893;
import net.minecraft.class_2922;
import net.minecraft.class_3864;
import net.minecraft.class_4763;
import net.minecraft.class_4968;
import net.minecraft.class_5483;
import net.minecraft.class_5485;
import net.minecraft.class_6796;
import net.minecraft.class_7871;

public class TheGardenAwakensBiomes {
    public static class_1959 paleGarden(class_7871<class_6796> features, class_7871<class_2922<?>> carvers) {
        class_5483.class_5496 spawns = new class_5483.class_5496();
        class_3864.method_30581((class_5483.class_5496)spawns);
        class_5485.class_5495 generation = new class_5485.class_5495(features, carvers);
        OverworldBiomesAccessor.callGlobalOverworldGeneration(generation);
        generation.method_30992(class_2893.class_2895.field_13178, TheGardenAwakensPlacements.PALE_GARDEN_VEGETATION);
        generation.method_30992(class_2893.class_2895.field_13178, TheGardenAwakensPlacements.PALE_MOSS_PATCH);
        generation.method_30992(class_2893.class_2895.field_13178, TheGardenAwakensPlacements.PALE_GARDEN_FLOWERS);
        class_3864.method_38568((class_5485.class_5495)generation);
        class_3864.method_17010((class_5485.class_5495)generation);
        generation.method_30992(class_2893.class_2895.field_13178, TheGardenAwakensPlacements.FLOWER_PALE_GARDEN);
        class_3864.method_16971((class_5485.class_5495)generation);
        class_3864.method_16984((class_5485.class_5495)generation);
        return new class_1959.class_1960().method_48164(true).method_8747(0.7f).method_8727(0.8f).method_24379(new class_4763.class_4764().method_24395(7768221).method_24397(5597568).method_24392(8484720).method_30820(0xB9B9B9).method_30822(0x778272).method_30821(8883574).method_24943(class_4968.field_23146).method_24391()).method_30974(spawns.method_31007()).method_30973(generation.method_46671()).method_30972();
    }
}

