/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  net.minecraft.class_1792
 *  net.minecraft.class_2960
 *  net.minecraft.class_4915
 *  net.minecraft.class_4943
 */
package backported.updates.content.data.client.model.provider;

import com.google.gson.JsonElement;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import net.minecraft.class_4915;
import net.minecraft.class_4943;

public class VanillaItemModels
extends class_4915 {
    public VanillaItemModels(BiConsumer<class_2960, Supplier<JsonElement>> output) {
        super(output);
    }

    public void createFlatItem(class_1792 item) {
        this.method_25733(item, class_4943.field_22938);
    }

    public void createHandheldItem(class_1792 item) {
        this.method_25733(item, class_4943.field_22939);
    }

    public void createMusicDisc(class_1792 item) {
        this.method_25733(item, class_4943.field_44581);
    }
}

