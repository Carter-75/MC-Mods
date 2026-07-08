/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1535
 *  net.minecraft.class_2474
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_7406
 *  net.minecraft.class_7784
 *  net.minecraft.class_7924
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModPaintingVariants;
import java.util.concurrent.CompletableFuture;
import net.minecraft.class_1535;
import net.minecraft.class_2474;
import net.minecraft.class_7225;
import net.minecraft.class_7406;
import net.minecraft.class_7784;
import net.minecraft.class_7924;

public class PaintingVariantTagGenerator
extends class_2474<class_1535> {
    public PaintingVariantTagGenerator(class_7784 output, CompletableFuture<class_7225.class_7874> lookupProvider) {
        super(output, class_7924.field_41209, lookupProvider);
    }

    protected void method_10514(class_7225.class_7874 provider) {
        this.method_10512(class_7406.field_38929).method_46835(ModPaintingVariants.DENNIS);
    }
}

