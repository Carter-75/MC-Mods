/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_3499
 *  net.minecraft.class_3499$class_3501
 *  net.minecraft.class_3499$class_3502
 *  net.minecraft.class_3499$class_5162
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3ic
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.valkyrienskies.mod.common.util.VectorConversionsMCKt
 */
package g_mungus.vlib.mixin.v2.shipAssembly;

import com.google.common.collect.Lists;
import g_mungus.vlib.mixin.v2.shipAssembly.PaletteInvoker;
import g_mungus.vlib.v2.internal.assembly.BoundedVoxelSet;
import g_mungus.vlib.v2.internal.injected.CanFillFromVoxelSet;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3499;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3ic;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_3499.class})
public abstract class StructureTemplateMixin
implements CanFillFromVoxelSet {
    @Shadow
    private class_2382 field_15587;
    @Final
    @Shadow
    private List<class_3499.class_5162> field_15586;
    @Final
    @Shadow
    private List<class_3499.class_3502> field_15589;

    @Shadow
    private static List<class_3499.class_3501> method_28055(List<class_3499.class_3501> basicBlocks, List<class_3499.class_3501> blocksWithEntities, List<class_3499.class_3501> specialBlocks) {
        return null;
    }

    @Shadow
    private static void method_28054(class_3499.class_3501 blockInfo, List<class_3499.class_3501> basicBlocks, List<class_3499.class_3501> blocksWithEntities, List<class_3499.class_3501> specialBlocks) {
    }

    @Override
    @Unique
    public void vlib$fillFromVoxelSet(@NotNull class_1937 level, @NotNull BoundedVoxelSet voxels) {
        class_2338 minCorner = VectorConversionsMCKt.toBlockPos((Vector3ic)voxels.getMin());
        class_2338 maxCorner = VectorConversionsMCKt.toBlockPos((Vector3ic)voxels.getMax());
        ArrayList basicBlocks = Lists.newArrayList();
        ArrayList blocksWithEntities = Lists.newArrayList();
        ArrayList specialBlocks = Lists.newArrayList();
        this.field_15587 = new class_2382(maxCorner.method_10263() - minCorner.method_10263() + 1, maxCorner.method_10264() - minCorner.method_10264() + 1, maxCorner.method_10260() - minCorner.method_10260() + 1);
        for (class_2338 currentWorldPos : voxels.getVoxels()) {
            class_2338 relativePos = currentWorldPos.method_10059((class_2382)minCorner);
            class_2680 blockState = level.method_8320(currentWorldPos);
            class_2586 blockEntity = level.method_8321(currentWorldPos);
            class_3499.class_3501 blockInfo = blockEntity != null ? new class_3499.class_3501(relativePos, blockState, blockEntity.method_38243()) : new class_3499.class_3501(relativePos, blockState, null);
            StructureTemplateMixin.method_28054(blockInfo, basicBlocks, blocksWithEntities, specialBlocks);
        }
        List<class_3499.class_3501> finalBlockList = StructureTemplateMixin.method_28055(basicBlocks, blocksWithEntities, specialBlocks);
        this.field_15589.clear();
        this.field_15586.clear();
        this.field_15586.add(PaletteInvoker.invokeInit(finalBlockList));
    }
}

