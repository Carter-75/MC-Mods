/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.google.common.collect.Sets
 *  com.google.gson.JsonElement
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.minecraft.item.Item
 *  net.minecraft.block.Block
 *  net.minecraft.data.DataProvider
 *  net.minecraft.util.Identifier
 *  net.minecraft.data.client.BlockStateSupplier
 *  net.minecraft.data.client.SimpleModelSupplier
 *  net.minecraft.data.client.ModelIds
 *  net.minecraft.data.DataWriter
 *  net.minecraft.data.DataOutput$PathResolver
 *  net.minecraft.data.DataOutput$OutputType
 *  net.minecraft.registry.Registries
 */
package backported.updates.content.data.client.model.provider;

import backported.updates.content.data.client.model.provider.VanillaBlockModels;
import backported.updates.content.data.client.model.provider.VanillaItemModels;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.data.DataProvider;
import net.minecraft.util.Identifier;
import net.minecraft.data.client.BlockStateSupplier;
import net.minecraft.data.client.SimpleModelSupplier;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.DataWriter;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.Registries;

public abstract class VanillaModelGenerator
implements DataProvider {
    private final DataOutput.PathResolver blockStateProvider;
    private final DataOutput.PathResolver modelProvider;
    private final FabricDataOutput output;

    public VanillaModelGenerator(FabricDataOutput output) {
        this.output = output;
        this.blockStateProvider = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "blockstates");
        this.modelProvider = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "models");
    }

    public CompletableFuture<?> run(DataWriter output) {
        HashMap<Block, BlockStateSupplier> blockStateGenerators = Maps.newHashMap();
        HashMap<Identifier, Supplier<JsonElement>> modelSuppliers = Maps.newHashMap();
        HashSet<Item> generatedItems = Sets.newHashSet();
        Consumer<BlockStateSupplier> blockStateOutput = generator -> {
            Block block = generator.getBlock();
            BlockStateSupplier definition = blockStateGenerators.put(block, generator);
            if (definition != null) {
                throw new IllegalStateException("Duplicate blockstate definition for " + String.valueOf(block));
            }
        };
        BiConsumer<Identifier, Supplier<JsonElement>> modelOutput = (location, supplier) -> {
            Supplier<JsonElement> definition = modelSuppliers.put(location, supplier);
            if (definition != null) {
                throw new IllegalStateException("Duplicate model definition for " + String.valueOf(location));
            }
        };
        Consumer<Item> skippedAutoModelsOutput = generatedItems::add;
        this.generateBlockStateModels(new VanillaBlockModels(blockStateOutput, modelOutput, skippedAutoModelsOutput));
        this.generateItemModels(new VanillaItemModels(modelOutput));
        List<Block> missingBlockstates = Registries.BLOCK.getEntrySet().stream().filter(entry -> this.output.isStrictValidationEnabled()).map(Map.Entry::getValue).filter(block -> !blockStateGenerators.containsKey(block)).toList();
        if (!missingBlockstates.isEmpty()) {
            throw new IllegalStateException("Missing blockstate definitions for: " + String.valueOf(missingBlockstates));
        }
        Registries.BLOCK.forEach(block -> {
            Item item = (Item)Item.BLOCK_ITEMS.get(block);
            if (item == null || generatedItems.contains(item)) {
                return;
            }
            Identifier model = ModelIds.getItemModelId((Item)item);
            if (blockStateGenerators.containsKey(block) && !modelSuppliers.containsKey(model)) {
                modelSuppliers.put(model, new SimpleModelSupplier(ModelIds.getBlockModelId((Block)block)));
            }
        });
        CompletableFuture<?> blockStatesProvider = this.saveCollection(output, blockStateGenerators, block -> this.blockStateProvider.resolveJson(block.getRegistryEntry().registryKey().getValue()));
        CompletableFuture<?> modelsProvider = this.saveCollection(output, modelSuppliers, this.modelProvider::resolveJson);
        return CompletableFuture.allOf(blockStatesProvider, modelsProvider);
    }

    private <T> CompletableFuture<?> saveCollection(DataWriter output, Map<T, ? extends Supplier<JsonElement>> objectToJsonMap, Function<T, Path> resolveObjectPath) {
        return CompletableFuture.allOf((CompletableFuture[])objectToJsonMap.entrySet().stream().map(entry -> {
            Path path = (Path)resolveObjectPath.apply(entry.getKey());
            JsonElement jsonElement = ((Supplier<JsonElement>)entry.getValue()).get();
            return DataProvider.writeToPath((DataWriter)output, (JsonElement)jsonElement, (Path)path);
        }).toArray(CompletableFuture[]::new));
    }

    public abstract void generateBlockStateModels(VanillaBlockModels var1);

    public abstract void generateItemModels(VanillaItemModels var1);

    public String getName() {
        return "Vanilla Model Definitions";
    }
}

