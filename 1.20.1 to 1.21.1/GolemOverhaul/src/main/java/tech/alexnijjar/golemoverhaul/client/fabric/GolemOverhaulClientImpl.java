/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
 *  net.minecraft.class_1921
 *  net.minecraft.class_2248
 */
package tech.alexnijjar.golemoverhaul.client.fabric;

import java.util.function.Supplier;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.class_1921;
import net.minecraft.class_2248;

public class GolemOverhaulClientImpl {
    public static void registerBlockRenderType(Supplier<class_2248> block, class_1921 type) {
        BlockRenderLayerMap.INSTANCE.putBlock(block.get(), class_1921.method_23581());
    }
}

