/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_156
 *  net.minecraft.class_1792
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2754
 *  net.minecraft.class_2769
 *  net.minecraft.class_2960
 *  net.minecraft.class_4778
 *  net.minecraft.class_4910
 *  net.minecraft.class_4910$class_4913
 *  net.minecraft.class_4917
 *  net.minecraft.class_4918
 *  net.minecraft.class_4918$class_4921
 *  net.minecraft.class_4922
 *  net.minecraft.class_4925
 *  net.minecraft.class_4926
 *  net.minecraft.class_4926$class_4928
 *  net.minecraft.class_4935
 *  net.minecraft.class_4936
 *  net.minecraft.class_4936$class_4937
 *  net.minecraft.class_4941
 *  net.minecraft.class_4944
 *  net.minecraft.class_4945
 *  net.minecraft.class_4946
 *  net.minecraft.class_4946$class_4947
 */
package backported.updates.content.data.client.model.provider;

import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.DriedGhastBlock;
import backported.updates.content.common.level.blocks.HangingMossBlock;
import backported.updates.content.common.level.blocks.MossyCarpetBlock;
import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.data.client.model.ModelTemplates;
import backported.updates.content.data.client.model.TextureMappings;
import backported.updates.content.data.client.model.TexturedModels;
import com.google.gson.JsonElement;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.class_156;
import net.minecraft.class_1792;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_2960;
import net.minecraft.class_4778;
import net.minecraft.class_4910;
import net.minecraft.class_4917;
import net.minecraft.class_4918;
import net.minecraft.class_4922;
import net.minecraft.class_4925;
import net.minecraft.class_4926;
import net.minecraft.class_4935;
import net.minecraft.class_4936;
import net.minecraft.class_4941;
import net.minecraft.class_4944;
import net.minecraft.class_4945;
import net.minecraft.class_4946;

public class VanillaBlockModels
extends class_4910 {
    private static final class_2960 TEMPLATE_SPAWN_EGG = class_4941.method_25845((String)"template_spawn_egg");
    private static final List<Pair<class_2350, Function<class_2960, class_4935>>> MULTIFACE_GENERATOR = List.of(Pair.of((Object)class_2350.field_11043, path -> class_4935.method_25824().method_25828(class_4936.field_22887, path)), Pair.of((Object)class_2350.field_11034, path -> class_4935.method_25824().method_25828(class_4936.field_22887, path).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22891).method_25828(class_4936.field_22888, (Object)true)), Pair.of((Object)class_2350.field_11035, path -> class_4935.method_25824().method_25828(class_4936.field_22887, path).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22892).method_25828(class_4936.field_22888, (Object)true)), Pair.of((Object)class_2350.field_11039, path -> class_4935.method_25824().method_25828(class_4936.field_22887, path).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22893).method_25828(class_4936.field_22888, (Object)true)), Pair.of((Object)class_2350.field_11036, path -> class_4935.method_25824().method_25828(class_4936.field_22887, path).method_25828(class_4936.field_22885, (Object)class_4936.class_4937.field_22893).method_25828(class_4936.field_22888, (Object)true)), Pair.of((Object)class_2350.field_11033, path -> class_4935.method_25824().method_25828(class_4936.field_22887, path).method_25828(class_4936.field_22885, (Object)class_4936.class_4937.field_22891).method_25828(class_4936.field_22888, (Object)true)));

    public VanillaBlockModels(Consumer<class_4917> blockStateOutput, BiConsumer<class_2960, Supplier<JsonElement>> modelOutput, Consumer<class_1792> skippedAutoModelsOutput) {
        super(blockStateOutput, modelOutput, skippedAutoModelsOutput);
    }

    public void createSpawnEgg(class_1935 item) {
        this.method_25538(item.method_8389(), TEMPLATE_SPAWN_EGG);
    }

    public void createMossyCarpet(class_2248 block) {
        class_2960 baseModel = class_4946.field_23044.method_25923(block, this.field_22831);
        class_2960 tallSideModel = TexturedModels.MOSSY_CARPET_SIDE.get(block).method_25917(mapping -> mapping.method_25868(class_4945.field_23018, class_4944.method_25866((class_2248)block, (String)"_side_tall"))).method_25915(block, "_side_tall", this.field_22831);
        class_2960 shortSideModel = TexturedModels.MOSSY_CARPET_SIDE.get(block).method_25917(mapping -> mapping.method_25868(class_4945.field_23018, class_4944.method_25866((class_2248)block, (String)"_side_small"))).method_25915(block, "_side_small", this.field_22831);
        class_4922 generator = class_4922.method_25758((class_2248)block);
        class_4918.class_4921 terminal = class_4918.method_25744().method_25751((class_2769)MossyCarpetBlock.BASE, (Comparable)Boolean.valueOf(false));
        generator.method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)MossyCarpetBlock.BASE, (Comparable)Boolean.valueOf(true)), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)baseModel));
        generator.method_25760((class_4918)terminal, class_4935.method_25824().method_25828(class_4936.field_22887, (Object)baseModel));
        MULTIFACE_GENERATOR.stream().map(Pair::getFirst).forEach(direction -> {
            class_2754<class_4778> property = MossyCarpetBlock.getPropertyForFace(direction);
            if (property != null && block.method_9564().method_28498(property)) {
                terminal.method_25751(property, (Comparable)class_4778.field_22178);
            }
        });
        for (Pair<class_2350, Function<class_2960, class_4935>> pair : MULTIFACE_GENERATOR) {
            class_2350 direction2 = (class_2350)pair.getFirst();
            class_2754<class_4778> property = MossyCarpetBlock.getPropertyForFace(direction2);
            if (property == null) continue;
            Function function = (Function)pair.getSecond();
            generator.method_25760((class_4918)class_4918.method_25744().method_25751(property, (Comparable)class_4778.field_22180), (class_4935)function.apply(tallSideModel));
            generator.method_25760((class_4918)class_4918.method_25744().method_25751(property, (Comparable)class_4778.field_22179), (class_4935)function.apply(shortSideModel));
            generator.method_25760((class_4918)terminal, (class_4935)function.apply(tallSideModel));
        }
        this.field_22830.accept(generator);
    }

    public void createHangingMoss(class_2248 block) {
        class_4926 dispatch = class_4926.method_25783((class_2769)HangingMossBlock.TIP).method_25795(value -> {
            String suffix = value != false ? "_tip" : "";
            class_4944 textureMapping = class_4944.method_25880((class_2960)class_4944.method_25866((class_2248)block, (String)suffix));
            class_2960 path = class_4910.class_4913.field_22840.method_25726().method_25847(block, suffix, textureMapping, this.field_22831);
            return class_4935.method_25824().method_25828(class_4936.field_22887, (Object)path);
        });
        this.method_25600(block);
        this.field_22830.accept(class_4925.method_25769((class_2248)block).method_25775(dispatch));
    }

    public void createCreakingHeart(class_2248 block) {
        class_2960 base = class_4946.field_23055.method_25923(block, this.field_22831);
        class_2960 baseSide = class_4946.field_23056.method_25923(block, this.field_22831);
        class_2960 awake = this.createCreakingHeartModel(class_4946.field_23055, block, "_awake");
        class_2960 awakeSide = this.createCreakingHeartModel(class_4946.field_23056, block, "_awake");
        class_2960 dormant = this.createCreakingHeartModel(class_4946.field_23055, block, "_dormant");
        class_2960 dormantSide = this.createCreakingHeartModel(class_4946.field_23056, block, "_dormant");
        class_4926.class_4928 state = class_4926.method_25784((class_2769)class_2741.field_12496, CreakingHeartBlock.STATE).method_25797((Comparable)class_2350.class_2351.field_11052, (Comparable)((Object)CreakingHeartState.UPROOTED), this.createVariant(base, class_4936.class_4937.field_22890, class_4936.class_4937.field_22890)).method_25797((Comparable)class_2350.class_2351.field_11051, (Comparable)((Object)CreakingHeartState.UPROOTED), this.createVariant(baseSide, class_4936.class_4937.field_22891, class_4936.class_4937.field_22890)).method_25797((Comparable)class_2350.class_2351.field_11048, (Comparable)((Object)CreakingHeartState.UPROOTED), this.createVariant(baseSide, class_4936.class_4937.field_22891, class_4936.class_4937.field_22891)).method_25797((Comparable)class_2350.class_2351.field_11052, (Comparable)((Object)CreakingHeartState.DORMANT), this.createVariant(dormant, class_4936.class_4937.field_22890, class_4936.class_4937.field_22890)).method_25797((Comparable)class_2350.class_2351.field_11051, (Comparable)((Object)CreakingHeartState.DORMANT), this.createVariant(dormantSide, class_4936.class_4937.field_22891, class_4936.class_4937.field_22890)).method_25797((Comparable)class_2350.class_2351.field_11048, (Comparable)((Object)CreakingHeartState.DORMANT), this.createVariant(dormantSide, class_4936.class_4937.field_22891, class_4936.class_4937.field_22891)).method_25797((Comparable)class_2350.class_2351.field_11052, (Comparable)((Object)CreakingHeartState.AWAKE), this.createVariant(awake, class_4936.class_4937.field_22890, class_4936.class_4937.field_22890)).method_25797((Comparable)class_2350.class_2351.field_11051, (Comparable)((Object)CreakingHeartState.AWAKE), this.createVariant(awakeSide, class_4936.class_4937.field_22891, class_4936.class_4937.field_22890)).method_25797((Comparable)class_2350.class_2351.field_11048, (Comparable)((Object)CreakingHeartState.AWAKE), this.createVariant(awakeSide, class_4936.class_4937.field_22891, class_4936.class_4937.field_22891));
        this.field_22830.accept(class_4925.method_25769((class_2248)block).method_25775((class_4926)state));
    }

    private class_4935 createVariant(class_2960 model, class_4936.class_4937 xRot, class_4936.class_4937 yRot) {
        class_4935 variant = class_4935.method_25824().method_25828(class_4936.field_22887, (Object)model);
        if (xRot != class_4936.class_4937.field_22890) {
            variant = variant.method_25828(class_4936.field_22885, (Object)xRot);
        }
        if (yRot != class_4936.class_4937.field_22890) {
            variant = variant.method_25828(class_4936.field_22886, (Object)yRot);
        }
        return variant;
    }

    private class_2960 createCreakingHeartModel(class_4946.class_4947 provider, class_2248 block, String suffix) {
        return provider.method_35912(mapping -> mapping.method_25868(class_4945.field_23018, class_4944.method_25866((class_2248)block, (String)suffix)).method_25868(class_4945.field_23013, class_4944.method_25866((class_2248)block, (String)("_top" + suffix)))).method_25922(block, suffix, this.field_22831);
    }

    public void createMultiface(class_2248 block, class_1792 item) {
        this.method_25537(item);
        class_2960 model = class_4941.method_25842((class_2248)block);
        class_4922 generator = class_4922.method_25758((class_2248)block);
        class_4918.class_4921 terminalCondition = (class_4918.class_4921)class_156.method_654((Object)class_4918.method_25744(), condition -> class_4910.field_28548.stream().map(Pair::getFirst).forEach(facingDirection -> {
            if (block.method_9564().method_28498((class_2769)facingDirection)) {
                condition.method_25751((class_2769)facingDirection, (Comparable)Boolean.valueOf(false));
            }
        }));
        for (Pair pair : class_4910.field_28548) {
            class_2746 booleanProperty = (class_2746)pair.getFirst();
            Function function = (Function)pair.getSecond();
            if (!block.method_9564().method_28498((class_2769)booleanProperty)) continue;
            generator.method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)booleanProperty, (Comparable)Boolean.valueOf(true)), (class_4935)function.apply(model));
            generator.method_25760((class_4918)terminalCondition, (class_4935)function.apply(model));
        }
        this.field_22830.accept(generator);
    }

    public void createDriedGhastBlock() {
        class_2960 model = class_4941.method_25843((class_2248)ModBlocks.DRIED_GHAST.get(), (String)"_hydration_0");
        this.method_25623(ModBlocks.DRIED_GHAST.get(), model);
        Function<Integer, class_2960> hydrationModel = level -> {
            String suffix = switch (level) {
                case 1 -> "_hydration_1";
                case 2 -> "_hydration_2";
                case 3 -> "_hydration_3";
                default -> "_hydration_0";
            };
            class_4944 mapping = TextureMappings.driedGhast(suffix);
            return ModelTemplates.DRIED_GHAST.method_25847(ModBlocks.DRIED_GHAST.get(), suffix, mapping, this.field_22831);
        };
        this.field_22830.accept(class_4925.method_25769((class_2248)ModBlocks.DRIED_GHAST.get()).method_25775(class_4926.method_25783((class_2769)DriedGhastBlock.HYDRATION_LEVEL).method_25795(level -> class_4935.method_25824().method_25828(class_4936.field_22887, (Object)((class_2960)hydrationModel.apply((Integer)level))))).method_25775(class_4910.method_25599()));
    }

    public void createLeafLitter(class_2248 block) {
        class_2960 resourceLocation = TexturedModels.LEAF_LITTER_1.method_25923(block, this.field_22831);
        class_2960 resourceLocation2 = TexturedModels.LEAF_LITTER_2.method_25923(block, this.field_22831);
        class_2960 resourceLocation3 = TexturedModels.LEAF_LITTER_3.method_25923(block, this.field_22831);
        class_2960 resourceLocation4 = TexturedModels.LEAF_LITTER_4.method_25923(block, this.field_22831);
        this.method_25537(block.method_8389());
        this.field_22830.accept(class_4922.method_25758((class_2248)block).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(1)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11043), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(1)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11034), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22891)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(1)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11035), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22892)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(1)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11039), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22893)).method_25760((class_4918)class_4918.method_25744().method_25752((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(2), (Comparable[])new Integer[]{3}).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11043), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation2)).method_25760((class_4918)class_4918.method_25744().method_25752((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(2), (Comparable[])new Integer[]{3}).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11034), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation2).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22891)).method_25760((class_4918)class_4918.method_25744().method_25752((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(2), (Comparable[])new Integer[]{3}).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11035), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation2).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22892)).method_25760((class_4918)class_4918.method_25744().method_25752((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(2), (Comparable[])new Integer[]{3}).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11039), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation2).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22893)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(3)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11043), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation3)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(3)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11034), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation3).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22891)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(3)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11035), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation3).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22892)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(3)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11039), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation3).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22893)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(4)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11043), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation4)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(4)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11034), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation4).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22891)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(4)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11035), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation4).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22892)).method_25760((class_4918)class_4918.method_25744().method_25751((class_2769)class_2741.field_42835, (Comparable)Integer.valueOf(4)).method_25751((class_2769)class_2741.field_12481, (Comparable)class_2350.field_11039), class_4935.method_25824().method_25828(class_4936.field_22887, (Object)resourceLocation4).method_25828(class_4936.field_22886, (Object)class_4936.class_4937.field_22893)));
    }
}

