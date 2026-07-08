/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.google.common.collect.Sets
 *  com.google.gson.JsonElement
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.minecraft.class_1792
 *  net.minecraft.class_2248
 *  net.minecraft.class_2405
 *  net.minecraft.class_2960
 *  net.minecraft.class_4917
 *  net.minecraft.class_4940
 *  net.minecraft.class_4941
 *  net.minecraft.class_7403
 *  net.minecraft.class_7784$class_7489
 *  net.minecraft.class_7784$class_7490
 *  net.minecraft.class_7923
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
import net.minecraft.class_1792;
import net.minecraft.class_2248;
import net.minecraft.class_2405;
import net.minecraft.class_2960;
import net.minecraft.class_4917;
import net.minecraft.class_4940;
import net.minecraft.class_4941;
import net.minecraft.class_7403;
import net.minecraft.class_7784;
import net.minecraft.class_7923;

public abstract class VanillaModelGenerator
implements class_2405 {
    private final class_7784.class_7489 blockStateProvider;
    private final class_7784.class_7489 modelProvider;
    private final FabricDataOutput output;

    public VanillaModelGenerator(FabricDataOutput output) {
        this.output = output;
        this.blockStateProvider = output.method_45973(class_7784.class_7490.field_39368, "blockstates");
        this.modelProvider = output.method_45973(class_7784.class_7490.field_39368, "models");
    }

    public CompletableFuture<?> method_10319(class_7403 output) {
        HashMap blockStateGenerators = Maps.newHashMap();
        HashMap modelSuppliers = Maps.newHashMap();
        HashSet generatedItems = Sets.newHashSet();
        Consumer<class_4917> blockStateOutput = generator -> {
            class_2248 block = generator.method_25743();
            class_4917 definition = blockStateGenerators.put(block, generator);
            if (definition != null) {
                throw new IllegalStateException("Duplicate blockstate definition for " + String.valueOf(block));
            }
        };
        BiConsumer<class_2960, Supplier<JsonElement>> modelOutput = (location, supplier) -> {
            Supplier definition = modelSuppliers.put(location, supplier);
            if (definition != null) {
                throw new IllegalStateException("Duplicate model definition for " + String.valueOf(location));
            }
        };
        Consumer<class_1792> skippedAutoModelsOutput = generatedItems::add;
        this.generateBlockStateModels(new VanillaBlockModels(blockStateOutput, modelOutput, skippedAutoModelsOutput));
        this.generateItemModels(new VanillaItemModels(modelOutput));
        List<class_2248> missingBlockstates = class_7923.field_41175.method_29722().stream().filter(entry -> this.output.isStrictValidationEnabled()).map(Map.Entry::getValue).filter(block -> !blockStateGenerators.containsKey(block)).toList();
        if (!missingBlockstates.isEmpty()) {
            throw new IllegalStateException("Missing blockstate definitions for: " + String.valueOf(missingBlockstates));
        }
        class_7923.field_41175.forEach(block -> {
            class_1792 item = (class_1792)class_1792.field_8003.get(block);
            if (item == null || generatedItems.contains(item)) {
                return;
            }
            class_2960 model = class_4941.method_25840((class_1792)item);
            if (blockStateGenerators.containsKey(block) && !modelSuppliers.containsKey(model)) {
                modelSuppliers.put(model, new class_4940(class_4941.method_25842((class_2248)block)));
            }
        });
        CompletableFuture<?> blockStatesProvider = this.saveCollection(output, blockStateGenerators, block -> this.blockStateProvider.method_44107(block.method_40142().method_40237().method_29177()));
        CompletableFuture<?> modelsProvider = this.saveCollection(output, modelSuppliers, arg_0 -> ((class_7784.class_7489)this.modelProvider).method_44107(arg_0));
        return CompletableFuture.allOf(blockStatesProvider, modelsProvider);
    }

    private <T> CompletableFuture<?> saveCollection(class_7403 output, Map<T, ? extends Supplier<JsonElement>> objectToJsonMap, Function<T, Path> resolveObjectPath) {
        return CompletableFuture.allOf((CompletableFuture[])objectToJsonMap.entrySet().stream().map(entry -> {
            Path path = (Path)resolveObjectPath.apply(entry.getKey());
            JsonElement jsonElement = (JsonElement)((Supplier)entry.getValue()).get();
            return class_2405.method_10320((class_7403)output, (JsonElement)jsonElement, (Path)path);
        }).toArray(CompletableFuture[]::new));
    }

    public abstract void generateBlockStateModels(VanillaBlockModels var1);

    public abstract void generateItemModels(VanillaItemModels var1);

    public String method_10321() {
        return "Vanilla Model Definitions";
    }
}

