/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2405
 *  net.minecraft.class_2960
 *  net.minecraft.class_7403
 *  net.minecraft.class_7784$class_7489
 *  net.minecraft.class_7784$class_7490
 *  net.minecraft.class_7923
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
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2405;
import net.minecraft.class_2960;
import net.minecraft.class_7403;
import net.minecraft.class_7784;
import net.minecraft.class_7923;

public class LeafColorGenerator
implements class_2405 {
    private final Map<class_2960, Supplier<JsonElement>> leafColors = new HashMap<class_2960, Supplier<JsonElement>>();
    private final class_7784.class_7489 pathProvider;

    public LeafColorGenerator(FabricDataOutput output) {
        this.pathProvider = output.method_45973(class_7784.class_7490.field_39368, "leaf_colors");
    }

    private void addLeafColors() {
        this.add(class_2246.field_28673, -9399763);
        this.add(class_2246.field_28674, -9399763);
    }

    private void add(class_2248 block, int color) {
        class_2960 registry = class_7923.field_41175.method_10221((Object)block);
        class_2960 name = class_2960.method_60656((String)registry.method_12832());
        this.addElement(name, registry.toString(), color);
    }

    private void add(String block, int color) {
        this.addElement(class_2960.method_60656((String)block), block, color);
    }

    public CompletableFuture<?> method_10319(class_7403 cachedOutput) {
        this.addLeafColors();
        return CompletableFuture.allOf((CompletableFuture[])this.leafColors.entrySet().stream().map(entry -> {
            Path path = this.pathProvider.method_44107((class_2960)entry.getKey());
            JsonElement jsonElement = (JsonElement)((Supplier)entry.getValue()).get();
            return class_2405.method_10320((class_7403)cachedOutput, (JsonElement)jsonElement, (Path)path);
        }).toArray(CompletableFuture[]::new));
    }

    public void addElement(class_2960 name, String block, int color) {
        this.addElement(name, block, color, 0);
    }

    public void addElement(class_2960 name, String block, int color, int priority) {
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

    public String method_10321() {
        return "Leaf Color Definitions";
    }
}

