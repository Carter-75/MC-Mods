/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.util.Util
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.BooleanProperty
 *  net.minecraft.state.property.EnumProperty
 *  net.minecraft.Property
 *  net.minecraft.util.Identifier
 *  net.minecraft.block.enums.WallShape
 *  net.minecraft.data.client.BlockStateModelGenerator
 *  net.minecraft.data.client.BlockStateModelGenerator$TintType
 *  net.minecraft.data.client.BlockStateSupplier
 *  net.minecraft.data.client.When
 *  net.minecraft.data.client.When$PropertyCondition
 *  net.minecraft.data.client.MultipartBlockStateSupplier
 *  net.minecraft.data.client.VariantsBlockStateSupplier
 *  net.minecraft.data.client.BlockStateVariantMap
 *  net.minecraft.data.client.BlockStateVariantMap$DoubleProperty
 *  net.minecraft.data.client.BlockStateVariant
 *  net.minecraft.data.client.VariantSettings
 *  net.minecraft.data.client.VariantSettings$Rotation
 *  net.minecraft.data.client.ModelIds
 *  net.minecraft.data.client.TextureMap
 *  net.minecraft.data.client.TextureKey
 *  net.minecraft.data.client.TexturedModel
 *  net.minecraft.data.client.TexturedModel$Factory
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
import net.minecraft.util.Util;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.block.enums.WallShape;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateSupplier;
import net.minecraft.data.client.When;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.data.client.BlockStateVariantMap;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TexturedModel;

public class VanillaBlockModels
extends BlockStateModelGenerator {
    private static final Identifier TEMPLATE_SPAWN_EGG = ModelIds.getMinecraftNamespacedItem((String)"template_spawn_egg");
    private static final List<Pair<Direction, Function<Identifier, BlockStateVariant>>> MULTIFACE_GENERATOR = List.of(Pair.of(Direction.NORTH, path -> BlockStateVariant.create().put(VariantSettings.MODEL, path)), Pair.of(Direction.EAST, path -> BlockStateVariant.create().put(VariantSettings.MODEL, path).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true)), Pair.of(Direction.SOUTH, path -> BlockStateVariant.create().put(VariantSettings.MODEL, path).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, true)), Pair.of(Direction.WEST, path -> BlockStateVariant.create().put(VariantSettings.MODEL, path).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true)), Pair.of(Direction.UP, path -> BlockStateVariant.create().put(VariantSettings.MODEL, path).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true)), Pair.of(Direction.DOWN, path -> BlockStateVariant.create().put(VariantSettings.MODEL, path).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true)));

    public VanillaBlockModels(Consumer<BlockStateSupplier> blockStateOutput, BiConsumer<Identifier, Supplier<JsonElement>> modelOutput, Consumer<Item> skippedAutoModelsOutput) {
        super(blockStateOutput, modelOutput, skippedAutoModelsOutput);
    }

    public void createSpawnEgg(ItemConvertible item) {
        this.registerParentedItemModel(item.asItem(), TEMPLATE_SPAWN_EGG);
    }

    public void createMossyCarpet(Block block) {
        Identifier baseModel = TexturedModel.CARPET.upload(block, this.modelCollector);
        Identifier tallSideModel = TexturedModels.MOSSY_CARPET_SIDE.get(block).textures(mapping -> mapping.put(TextureKey.SIDE, TextureMap.getSubId((Block)block, (String)"_side_tall"))).upload(block, "_side_tall", this.modelCollector);
        Identifier shortSideModel = TexturedModels.MOSSY_CARPET_SIDE.get(block).textures(mapping -> mapping.put(TextureKey.SIDE, TextureMap.getSubId((Block)block, (String)"_side_small"))).upload(block, "_side_small", this.modelCollector);
        MultipartBlockStateSupplier generator = MultipartBlockStateSupplier.create((Block)block);
        When.PropertyCondition terminal = When.create().set(MossyCarpetBlock.BASE, Boolean.valueOf(false));
        generator.with((When)When.create().set(MossyCarpetBlock.BASE, Boolean.valueOf(true)), BlockStateVariant.create().put(VariantSettings.MODEL, baseModel));
        generator.with((When)terminal, BlockStateVariant.create().put(VariantSettings.MODEL, baseModel));
        MULTIFACE_GENERATOR.stream().map(Pair::getFirst).forEach(direction -> {
            EnumProperty<WallShape> property = MossyCarpetBlock.getPropertyForFace(direction);
            if (property != null && block.getDefaultState().contains(property)) {
                terminal.set(property, WallShape.NONE);
            }
        });
        for (Pair<Direction, Function<Identifier, BlockStateVariant>> pair : MULTIFACE_GENERATOR) {
            Direction direction2 = (Direction)pair.getFirst();
            EnumProperty<WallShape> property = MossyCarpetBlock.getPropertyForFace(direction2);
            if (property == null) continue;
            Function function = (Function)pair.getSecond();
            generator.with((When)When.create().set(property, WallShape.TALL), (BlockStateVariant)function.apply(tallSideModel));
            generator.with((When)When.create().set(property, WallShape.LOW), (BlockStateVariant)function.apply(shortSideModel));
            generator.with((When)terminal, (BlockStateVariant)function.apply(tallSideModel));
        }
        this.blockStateCollector.accept(generator);
    }

    public void createHangingMoss(Block block) {
        BlockStateVariantMap dispatch = BlockStateVariantMap.create(HangingMossBlock.TIP).register(value -> {
            String suffix = value != false ? "_tip" : "";
            TextureMap textureMapping = TextureMap.cross(TextureMap.getSubId((Block)block, (String)suffix));
            Identifier path = BlockStateModelGenerator.TintType.NOT_TINTED.getCrossModel().upload(block, suffix, textureMapping, this.modelCollector);
            return BlockStateVariant.create().put(VariantSettings.MODEL, path);
        });
        this.registerItemModel(block);
        this.blockStateCollector.accept(VariantsBlockStateSupplier.create((Block)block).coordinate(dispatch));
    }

    public void createCreakingHeart(Block block) {
        Identifier base = TexturedModel.END_FOR_TOP_CUBE_COLUMN.upload(block, this.modelCollector);
        Identifier baseSide = TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL.upload(block, this.modelCollector);
        Identifier awake = this.createCreakingHeartModel(TexturedModel.END_FOR_TOP_CUBE_COLUMN, block, "_awake");
        Identifier awakeSide = this.createCreakingHeartModel(TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL, block, "_awake");
        Identifier dormant = this.createCreakingHeartModel(TexturedModel.END_FOR_TOP_CUBE_COLUMN, block, "_dormant");
        Identifier dormantSide = this.createCreakingHeartModel(TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL, block, "_dormant");
        BlockStateVariantMap.DoubleProperty state = BlockStateVariantMap.create(Properties.AXIS, CreakingHeartBlock.STATE).register(Direction.Axis.Y, (CreakingHeartState.UPROOTED), this.createVariant(base, VariantSettings.Rotation.R0, VariantSettings.Rotation.R0)).register(Direction.Axis.Z, (CreakingHeartState.UPROOTED), this.createVariant(baseSide, VariantSettings.Rotation.R90, VariantSettings.Rotation.R0)).register(Direction.Axis.X, (CreakingHeartState.UPROOTED), this.createVariant(baseSide, VariantSettings.Rotation.R90, VariantSettings.Rotation.R90)).register(Direction.Axis.Y, (CreakingHeartState.DORMANT), this.createVariant(dormant, VariantSettings.Rotation.R0, VariantSettings.Rotation.R0)).register(Direction.Axis.Z, (CreakingHeartState.DORMANT), this.createVariant(dormantSide, VariantSettings.Rotation.R90, VariantSettings.Rotation.R0)).register(Direction.Axis.X, (CreakingHeartState.DORMANT), this.createVariant(dormantSide, VariantSettings.Rotation.R90, VariantSettings.Rotation.R90)).register(Direction.Axis.Y, (CreakingHeartState.AWAKE), this.createVariant(awake, VariantSettings.Rotation.R0, VariantSettings.Rotation.R0)).register(Direction.Axis.Z, (CreakingHeartState.AWAKE), this.createVariant(awakeSide, VariantSettings.Rotation.R90, VariantSettings.Rotation.R0)).register(Direction.Axis.X, (CreakingHeartState.AWAKE), this.createVariant(awakeSide, VariantSettings.Rotation.R90, VariantSettings.Rotation.R90));
        this.blockStateCollector.accept(VariantsBlockStateSupplier.create((Block)block).coordinate((BlockStateVariantMap)state));
    }

    private BlockStateVariant createVariant(Identifier model, VariantSettings.Rotation xRot, VariantSettings.Rotation yRot) {
        BlockStateVariant variant = BlockStateVariant.create().put(VariantSettings.MODEL, model);
        if (xRot != VariantSettings.Rotation.R0) {
            variant = variant.put(VariantSettings.X, xRot);
        }
        if (yRot != VariantSettings.Rotation.R0) {
            variant = variant.put(VariantSettings.Y, yRot);
        }
        return variant;
    }

    private Identifier createCreakingHeartModel(TexturedModel.Factory provider, Block block, String suffix) {
        return provider.andThen(mapping -> mapping.put(TextureKey.SIDE, TextureMap.getSubId((Block)block, (String)suffix)).put(TextureKey.END, TextureMap.getSubId((Block)block, (String)("_top" + suffix)))).upload(block, suffix, this.modelCollector);
    }

    public void createMultiface(Block block, Item item) {
        this.registerItemModel(item);
        Identifier model = ModelIds.getBlockModelId((Block)block);
        MultipartBlockStateSupplier generator = MultipartBlockStateSupplier.create((Block)block);
        When.PropertyCondition terminalCondition = (When.PropertyCondition)Util.make(When.create(), condition -> BlockStateModelGenerator.CONNECTION_VARIANT_FUNCTIONS.stream().map(Pair::getFirst).forEach(facingDirection -> {
            if (block.getDefaultState().contains(facingDirection)) {
                condition.set(facingDirection, Boolean.valueOf(false));
            }
        }));
        for (Pair pair : BlockStateModelGenerator.CONNECTION_VARIANT_FUNCTIONS) {
            BooleanProperty booleanProperty = (BooleanProperty)pair.getFirst();
            Function function = (Function)pair.getSecond();
            if (!block.getDefaultState().contains(booleanProperty)) continue;
            generator.with((When)When.create().set(booleanProperty, Boolean.valueOf(true)), (BlockStateVariant)function.apply(model));
            generator.with((When)terminalCondition, (BlockStateVariant)function.apply(model));
        }
        this.blockStateCollector.accept(generator);
    }

    public void createDriedGhastBlock() {
        Identifier model = ModelIds.getBlockSubModelId((Block)ModBlocks.DRIED_GHAST.get(), (String)"_hydration_0");
        this.registerParentedItemModel(ModBlocks.DRIED_GHAST.get(), model);
        Function<Integer, Identifier> hydrationModel = level -> {
            String suffix = switch (level) {
                case 1 -> "_hydration_1";
                case 2 -> "_hydration_2";
                case 3 -> "_hydration_3";
                default -> "_hydration_0";
            };
            TextureMap mapping = TextureMappings.driedGhast(suffix);
            return ModelTemplates.DRIED_GHAST.upload(ModBlocks.DRIED_GHAST.get(), suffix, mapping, this.modelCollector);
        };
        this.blockStateCollector.accept(VariantsBlockStateSupplier.create((Block)ModBlocks.DRIED_GHAST.get()).coordinate(BlockStateVariantMap.create(DriedGhastBlock.HYDRATION_LEVEL).register(level -> BlockStateVariant.create().put(VariantSettings.MODEL, (hydrationModel.apply((Integer)level))))).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    public void createLeafLitter(Block block) {
        Identifier resourceLocation = TexturedModels.LEAF_LITTER_1.upload(block, this.modelCollector);
        Identifier resourceLocation2 = TexturedModels.LEAF_LITTER_2.upload(block, this.modelCollector);
        Identifier resourceLocation3 = TexturedModels.LEAF_LITTER_3.upload(block, this.modelCollector);
        Identifier resourceLocation4 = TexturedModels.LEAF_LITTER_4.upload(block, this.modelCollector);
        this.registerItemModel(block.asItem());
        this.blockStateCollector.accept(MultipartBlockStateSupplier.create((Block)block).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(1)).set(Properties.HORIZONTAL_FACING, Direction.NORTH), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(1)).set(Properties.HORIZONTAL_FACING, Direction.EAST), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(1)).set(Properties.HORIZONTAL_FACING, Direction.SOUTH), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation).put(VariantSettings.Y, VariantSettings.Rotation.R180)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(1)).set(Properties.HORIZONTAL_FACING, Direction.WEST), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation).put(VariantSettings.Y, VariantSettings.Rotation.R270)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(2)).set(Properties.HORIZONTAL_FACING, Direction.NORTH), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation2)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(2)).set(Properties.HORIZONTAL_FACING, Direction.EAST), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation2).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(2)).set(Properties.HORIZONTAL_FACING, Direction.SOUTH), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation2).put(VariantSettings.Y, VariantSettings.Rotation.R180)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(2)).set(Properties.HORIZONTAL_FACING, Direction.WEST), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation2).put(VariantSettings.Y, VariantSettings.Rotation.R270)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(3)).set(Properties.HORIZONTAL_FACING, Direction.NORTH), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation3)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(3)).set(Properties.HORIZONTAL_FACING, Direction.EAST), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation3).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(3)).set(Properties.HORIZONTAL_FACING, Direction.SOUTH), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation3).put(VariantSettings.Y, VariantSettings.Rotation.R180)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(3)).set(Properties.HORIZONTAL_FACING, Direction.WEST), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation3).put(VariantSettings.Y, VariantSettings.Rotation.R270)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(4)).set(Properties.HORIZONTAL_FACING, Direction.NORTH), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation4)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(4)).set(Properties.HORIZONTAL_FACING, Direction.EAST), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation4).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(4)).set(Properties.HORIZONTAL_FACING, Direction.SOUTH), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation4).put(VariantSettings.Y, VariantSettings.Rotation.R180)).with((When)When.create().set(Properties.FLOWER_AMOUNT, Integer.valueOf(4)).set(Properties.HORIZONTAL_FACING, Direction.WEST), BlockStateVariant.create().put(VariantSettings.MODEL, resourceLocation4).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
    }
}

