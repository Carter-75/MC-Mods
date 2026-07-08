/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  net.minecraft.item.Item
 *  net.minecraft.util.Identifier
 *  net.minecraft.ItemModelGenerator
 *  net.minecraft.data.client.Models
 */
package backported.updates.content.data.client.model.provider;

import com.google.gson.JsonElement;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class VanillaItemModels
extends ItemModelGenerator {
    public VanillaItemModels(BiConsumer<Identifier, Supplier<JsonElement>> output) {
        super(output);
    }

    public void createFlatItem(Item item) {
        this.register(item, Models.GENERATED);
    }

    public void createHandheldItem(Item item) {
        this.register(item, Models.HANDHELD);
    }

    public void createMusicDisc(Item item) {
        this.register(item, Models.TEMPLATE_MUSIC_DISC);
    }
}

