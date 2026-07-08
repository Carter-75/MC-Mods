/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.data.DataProvider
 *  net.minecraft.util.Identifier
 *  net.minecraft.data.DataWriter
 *  net.minecraft.data.DataOutput$PathResolver
 *  net.minecraft.data.DataOutput$OutputType
 *  net.minecraft.registry.Registries
 */
package backported.updates.content.data.client.colors;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataProvider;
import net.minecraft.util.Identifier;
import net.minecraft.data.DataWriter;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.Registries;

public class LeafColorGenerator
implements DataProvider {
    private final Map<Identifier, Supplier<JsonElement>> leafColors = new HashMap<Identifier, Supplier<JsonElement>>();
    private final DataOutput.PathResolver pathProvider;

    public LeafColorGenerator(FabricDataOutput output) {
        this.pathProvider = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "leaf_colors");
    }

    private void addLeafColors() {
        this.add(Blocks.AZALEA_LEAVES, -9399763);
        this.add(Blocks.FLOWERING_AZALEA_LEAVES, -9399763);
    }

    private void add(Block block, int color) {
        Identifier registry = Registries.BLOCK.getId(block);
        Identifier name = Identifier.ofVanilla((String)registry.getPath());
        this.addElement(name, registry.toString(), color);
    }

    private void add(String block, int color) {
        this.addElement(Identifier.ofVanilla((String)block), block, color);
    }

    public CompletableFuture<?> run(DataWriter cachedOutput) {
        this.addLeafColors();
        return CompletableFuture.allOf((CompletableFuture[])this.leafColors.entrySet().stream().map(entry -> {
            Path path = this.pathProvider.resolveJson(entry.getKey());
            JsonElement jsonElement = (JsonElement)((Supplier)entry.getValue()).get();
            return DataProvider.writeToPath((DataWriter)cachedOutput, (JsonElement)jsonElement, (Path)path);
        }).toArray(CompletableFuture[]::new));
    }

    public void addElement(Identifier name, String block, int color) {
        this.addElement(name, block, color, 0);
    }

    public void addElement(Identifier name, String block, int color, int priority) {
        JsonObject json = new JsonObject();
        json.addProperty("block", block);
        JsonObject properties = new JsonObject();
        properties.addProperty("color", (Number)color);
        properties.addProperty("priority", (Number)priority);
        json.add("properties", (JsonElement)properties);
        if (this.leafColors.put(name, () -> json) != null) {
            throw new IllegalStateException("Duplicate leaf color " + String.valueOf(name));
        }
    }

    public String getName() {
        return "Leaf Color Definitions";
    }
}

