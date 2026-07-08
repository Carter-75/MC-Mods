/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
 *  net.minecraft.class_114
 *  net.minecraft.class_116
 *  net.minecraft.class_117$class_118
 *  net.minecraft.class_141
 *  net.minecraft.class_1893
 *  net.minecraft.class_1935
 *  net.minecraft.class_212
 *  net.minecraft.class_2248
 *  net.minecraft.class_2350
 *  net.minecraft.class_2769
 *  net.minecraft.class_42
 *  net.minecraft.class_44
 *  net.minecraft.class_4559$class_4560
 *  net.minecraft.class_52
 *  net.minecraft.class_52$class_53
 *  net.minecraft.class_5341$class_210
 *  net.minecraft.class_55
 *  net.minecraft.class_5658
 *  net.minecraft.class_5662
 *  net.minecraft.class_5778
 *  net.minecraft.class_6880
 *  net.minecraft.class_7225$class_7226
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_77
 *  net.minecraft.class_79$class_80
 *  net.minecraft.class_7924
 *  net.minecraft.class_85$class_86
 *  net.minecraft.class_94
 */
package backported.updates.content.data.server.loot;

import backported.updates.content.common.level.blocks.MossyCarpetBlock;
import backported.updates.content.common.registries.ModBlocks;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.class_114;
import net.minecraft.class_116;
import net.minecraft.class_117;
import net.minecraft.class_141;
import net.minecraft.class_1893;
import net.minecraft.class_1935;
import net.minecraft.class_212;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_2769;
import net.minecraft.class_42;
import net.minecraft.class_44;
import net.minecraft.class_4559;
import net.minecraft.class_52;
import net.minecraft.class_5341;
import net.minecraft.class_55;
import net.minecraft.class_5658;
import net.minecraft.class_5662;
import net.minecraft.class_5778;
import net.minecraft.class_6880;
import net.minecraft.class_7225;
import net.minecraft.class_77;
import net.minecraft.class_79;
import net.minecraft.class_7924;
import net.minecraft.class_85;
import net.minecraft.class_94;

public class BlockLootGenerator
extends FabricBlockLootTableProvider {
    public BlockLootGenerator(FabricDataOutput dataOutput, CompletableFuture<class_7225.class_7874> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void method_10379() {
        class_7225.class_7226 enchantments = this.field_51845.method_46762(class_7924.field_41265);
        this.method_46025(ModBlocks.PALE_OAK_PLANKS.get());
        this.method_46025(ModBlocks.PALE_OAK_SAPLING.get());
        this.method_46025(ModBlocks.PALE_OAK_LOG.get());
        this.method_46025(ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        this.method_46025(ModBlocks.PALE_OAK_WOOD.get());
        this.method_46025(ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        this.method_46025((class_2248)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get());
        this.method_46025((class_2248)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get());
        this.method_46025(ModBlocks.PALE_OAK_PRESSURE_PLATE.get());
        this.method_46025(ModBlocks.PALE_OAK_TRAPDOOR.get());
        this.method_46025(ModBlocks.PALE_OAK_BUTTON.get());
        this.method_46025(ModBlocks.PALE_OAK_STAIRS.get());
        this.method_46025(ModBlocks.PALE_OAK_FENCE_GATE.get());
        this.method_46025(ModBlocks.PALE_OAK_FENCE.get());
        this.method_45994(ModBlocks.PALE_OAK_SLAB.get(), arg_0 -> ((BlockLootGenerator)this).method_45980(arg_0));
        this.method_45994(ModBlocks.PALE_OAK_DOOR.get(), arg_0 -> ((BlockLootGenerator)this).method_46022(arg_0));
        this.method_45994(ModBlocks.PALE_OAK_LEAVES.get(), block -> this.method_45986((class_2248)block, ModBlocks.PALE_OAK_SAPLING.get(), field_40605));
        this.method_46025(ModBlocks.OPEN_EYEBLOSSOM.get());
        this.method_46025(ModBlocks.CLOSED_EYEBLOSSOM.get());
        this.method_45994(ModBlocks.PALE_MOSS_CARPET.get(), this::createMossyCarpetBlockDrops);
        this.method_45994(ModBlocks.PALE_HANGING_MOSS.get(), this::createShearsOrSilkTouchOnlyDrop);
        this.method_46025(ModBlocks.PALE_MOSS_BLOCK.get());
        this.method_46023(ModBlocks.POTTED_PALE_OAK_SAPLING.get());
        this.method_46023(ModBlocks.POTTED_OPEN_EYEBLOSSOM.get());
        this.method_46023(ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get());
        this.method_46025(ModBlocks.RESIN_BLOCK.get());
        this.method_46025(ModBlocks.RESIN_BRICKS.get());
        this.method_46025(ModBlocks.RESIN_BRICK_WALL.get());
        this.method_46025(ModBlocks.RESIN_BRICK_STAIRS.get());
        this.method_46025(ModBlocks.CHISELED_RESIN_BRICKS.get());
        this.method_45994(ModBlocks.RESIN_BRICK_SLAB.get(), arg_0 -> ((BlockLootGenerator)this).method_45980(arg_0));
        this.method_45994(ModBlocks.RESIN_CLUMP.get(), this::createMultifaceBlockDrops);
        this.method_45994(ModBlocks.CREAKING_HEART.get(), block -> this.method_45989((class_2248)block, (class_79.class_80)this.method_45977((class_1935)block, (class_116)class_77.method_411((class_1935)((class_1935)ModBlocks.RESIN_CLUMP.get())).method_438((class_117.class_118)class_141.method_621((class_5658)class_5662.method_32462((float)1.0f, (float)3.0f))).method_438((class_117.class_118)class_94.method_456((class_6880)enchantments.method_46747(class_1893.field_9130))).method_438((class_117.class_118)class_114.method_506((class_42)class_42.method_277((int)9))))));
        this.method_46025(ModBlocks.DRIED_GHAST.get());
        this.method_46025(ModBlocks.FIREFLY_BUSH.get());
        this.method_45994(ModBlocks.BUSH.get(), this::createShearsOrSilkTouchOnlyDrop);
        this.method_45988(ModBlocks.WILDFLOWERS.get(), this.method_49358(ModBlocks.WILDFLOWERS.get()));
        this.method_45988(ModBlocks.LEAF_LITTER.get(), this.method_49358(ModBlocks.LEAF_LITTER.get()));
        this.method_46025(ModBlocks.CACTUS_FLOWER.get());
        this.method_45994(ModBlocks.SHORT_DRY_GRASS.get(), this::createShearsOrSilkTouchOnlyDrop);
        this.method_45994(ModBlocks.TALL_DRY_GRASS.get(), this::createShearsOrSilkTouchOnlyDrop);
    }

    protected class_52.class_53 createMultifaceBlockDrops(class_2248 block) {
        return class_52.method_324().method_336(class_55.method_347().method_351((class_79.class_80)this.method_45977((class_1935)block, (class_116)((class_85.class_86)class_77.method_411((class_1935)block).method_43740((Object[])class_2350.values(), direction -> class_141.method_35540((class_5658)class_44.method_32448((float)1.0f), (boolean)true).method_524((class_5341.class_210)class_212.method_900((class_2248)block).method_22584(class_4559.class_4560.method_22523().method_22527((class_2769)class_5778.method_33374((class_2350)direction), true))))).method_438((class_117.class_118)class_141.method_35540((class_5658)class_44.method_32448((float)-1.0f), (boolean)true)))));
    }

    protected class_52.class_53 createMossyCarpetBlockDrops(class_2248 block) {
        return class_52.method_324().method_336(class_55.method_347().method_351((class_79.class_80)this.method_45977((class_1935)block, (class_116)class_77.method_411((class_1935)block).method_421((class_5341.class_210)class_212.method_900((class_2248)block).method_22584(class_4559.class_4560.method_22523().method_22527((class_2769)MossyCarpetBlock.BASE, true))))));
    }

    protected class_52.class_53 createShearsOrSilkTouchOnlyDrop(class_1935 itemLike) {
        return class_52.method_324().method_336(class_55.method_347().method_352((class_5658)class_44.method_32448((float)1.0f)).method_356(this.method_60392()).method_351((class_79.class_80)class_77.method_411((class_1935)itemLike)));
    }
}

