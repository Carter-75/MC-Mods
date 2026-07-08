/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider
 *  net.minecraft.class_173
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2048$class_2049
 *  net.minecraft.class_2105
 *  net.minecraft.class_215
 *  net.minecraft.class_2487
 *  net.minecraft.class_2960
 *  net.minecraft.class_44
 *  net.minecraft.class_47$class_50
 *  net.minecraft.class_52
 *  net.minecraft.class_52$class_53
 *  net.minecraft.class_5321
 *  net.minecraft.class_55
 *  net.minecraft.class_5658
 *  net.minecraft.class_65
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_77
 *  net.minecraft.class_79$class_80
 */
package backported.updates.content.data.server.loot;

import backported.updates.content.common.level.entities.animal.ChickenVariants;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.registries.ModBuiltInLootTables;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.class_173;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2048;
import net.minecraft.class_2105;
import net.minecraft.class_215;
import net.minecraft.class_2487;
import net.minecraft.class_2960;
import net.minecraft.class_44;
import net.minecraft.class_47;
import net.minecraft.class_52;
import net.minecraft.class_5321;
import net.minecraft.class_55;
import net.minecraft.class_5658;
import net.minecraft.class_65;
import net.minecraft.class_7225;
import net.minecraft.class_77;
import net.minecraft.class_79;

public class GiftLootGenerator
extends SimpleFabricLootTableProvider {
    public GiftLootGenerator(FabricDataOutput output, CompletableFuture<class_7225.class_7874> lookup) {
        super(output, lookup, class_173.field_16235);
    }

    private static class_2105 variantNbt(class_2960 variantId) {
        class_2487 tag = new class_2487();
        tag.method_10582("variant", variantId.toString());
        return new class_2105(tag);
    }

    public void method_10399(BiConsumer<class_5321<class_52>, class_52.class_53> output) {
        output.accept(ModBuiltInLootTables.CHICKEN_LAY, class_52.method_324().method_336(class_55.method_347().method_352((class_5658)class_44.method_32448((float)1.0f)).method_351((class_79.class_80)class_65.method_386((class_79.class_80[])new class_79.class_80[]{class_77.method_411((class_1935)class_1802.field_8803).method_421(class_215.method_917((class_47.class_50)class_47.class_50.field_935, (class_2048.class_2049)class_2048.class_2049.method_8916().method_8915(GiftLootGenerator.variantNbt(ChickenVariants.TEMPERATE.method_29177())))), class_77.method_411((class_1935)((class_1935)ModItems.BROWN_EGG.get())).method_421(class_215.method_917((class_47.class_50)class_47.class_50.field_935, (class_2048.class_2049)class_2048.class_2049.method_8916().method_8915(GiftLootGenerator.variantNbt(ChickenVariants.WARM.method_29177())))), class_77.method_411((class_1935)((class_1935)ModItems.BLUE_EGG.get())).method_421(class_215.method_917((class_47.class_50)class_47.class_50.field_935, (class_2048.class_2049)class_2048.class_2049.method_8916().method_8915(GiftLootGenerator.variantNbt(ChickenVariants.COLD.method_29177()))))}))));
    }
}

