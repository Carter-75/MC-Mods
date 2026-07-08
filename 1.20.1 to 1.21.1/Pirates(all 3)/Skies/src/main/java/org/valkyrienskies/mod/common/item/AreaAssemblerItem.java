/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1269
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1838
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2561
 *  net.minecraft.class_3218
 *  net.minecraft.class_3499
 */
package org.valkyrienskies.mod.common.item;

import java.util.function.DoubleSupplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1269;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2561;
import net.minecraft.class_3218;
import net.minecraft.class_3499;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBi;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.assembly.ShipAssemblyKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0014"}, d2={"Lorg/valkyrienskies/mod/common/item/AreaAssemblerItem;", "Lnet/minecraft/class_1792;", "Lnet/minecraft/class_1799;", "stack", "", "isFoil", "(Lnet/minecraft/class_1799;)Z", "Lnet/minecraft/class_1838;", "ctx", "Lnet/minecraft/class_1269;", "useOn", "(Lnet/minecraft/class_1838;)Lnet/minecraft/class_1269;", "Ljava/util/function/DoubleSupplier;", "scale", "Ljava/util/function/DoubleSupplier;", "minScaling", "Lnet/minecraft/class_1792$class_1793;", "properties", "<init>", "(Lnet/minecraft/class_1792$class_1793;Ljava/util/function/DoubleSupplier;Ljava/util/function/DoubleSupplier;)V", "valkyrienskies-120"})
public final class AreaAssemblerItem
extends class_1792 {
    @NotNull
    private final DoubleSupplier scale;
    @NotNull
    private final DoubleSupplier minScaling;

    public AreaAssemblerItem(@NotNull class_1792.class_1793 properties, @NotNull DoubleSupplier scale, @NotNull DoubleSupplier minScaling) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        Intrinsics.checkNotNullParameter((Object)scale, (String)"scale");
        Intrinsics.checkNotNullParameter((Object)minScaling, (String)"minScaling");
        super(properties);
        this.scale = scale;
        this.minScaling = minScaling;
    }

    public boolean method_7886(@NotNull class_1799 stack) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        return true;
    }

    /*
     * Unable to fully structure code
     */
    @NotNull
    public class_1269 method_7884(@NotNull class_1838 ctx) {
        block12: {
            Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
            var4_2 = ctx.method_8045();
            v0 = var4_2 instanceof class_3218 != false ? (class_3218)var4_2 : null;
            if (v0 == null) {
                v1 = super.method_7884(ctx);
                Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"useOn(...)");
                return v1;
            }
            level = v0;
            blockPos = ctx.method_8037();
            v2 = level.method_8320(blockPos);
            Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"getBlockState(...)");
            blockState = v2;
            item = ctx.method_8041();
            if (!(item.method_7909() instanceof AreaAssemblerItem)) {
                return class_1269.field_5814;
            }
            if (level.field_9236 || blockState.method_26215()) break block12;
            dimensionId = VSGameUtilsKt.getDimensionId((class_1937)level);
            if (item.method_7969() == null) ** GOTO lbl-1000
            v3 = item.method_7969();
            Intrinsics.checkNotNull((Object)v3);
            if (v3.method_10545("firstPosX")) {
                v4 = item.method_7969();
                Intrinsics.checkNotNull((Object)v4);
                firstPosX = v4.method_10550("firstPosX");
                v5 = item.method_7969();
                Intrinsics.checkNotNull((Object)v5);
                firstPosY = v5.method_10550("firstPosY");
                v6 = item.method_7969();
                Intrinsics.checkNotNull((Object)v6);
                firstPosZ = v6.method_10550("firstPosZ");
                if (VSGameUtilsKt.getShipObjectWorld(level).isBlockInShipyard(blockPos.method_10263(), blockPos.method_10264(), blockPos.method_10260(), dimensionId) != VSGameUtilsKt.getShipObjectWorld(level).isBlockInShipyard(firstPosX, firstPosY, firstPosZ, dimensionId)) {
                    v7 = ctx.method_8036();
                    if (v7 != null) {
                        v7.method_43496((class_2561)class_2561.method_43470((String)"Cannot assemble between ship and world!"));
                    }
                } else {
                    Intrinsics.checkNotNull((Object)blockPos);
                    if (!Intrinsics.areEqual((Object)VSGameUtilsKt.getLoadedShipManagingPos(level, (class_2382)blockPos), (Object)VSGameUtilsKt.getLoadedShipManagingPos(level, new class_2382(firstPosX, firstPosY, firstPosZ)))) {
                        v8 = ctx.method_8036();
                        if (v8 != null) {
                            v8.method_43496((class_2561)class_2561.method_43470((String)"Cannot assemble something between two ships!"));
                        }
                    } else {
                        blockAABB = new AABBi(VectorConversionsMCKt.toJOML((class_2382)blockPos), VectorConversionsMCKt.toJOML(new class_2382(firstPosX, firstPosY, firstPosZ)));
                        blockAABB.correctBounds();
                        lowerCorner = new class_2338(blockAABB.minX, blockAABB.minY, blockAABB.minZ);
                        upperCorner = new class_2338(blockAABB.maxX, blockAABB.maxY, blockAABB.maxZ);
                        structure = new class_3499();
                        structure.method_15174((class_1937)level, lowerCorner, (class_2382)upperCorner.method_10069(1, 1, 1).method_10059((class_2382)lowerCorner), true, class_2246.field_10369);
                        v9 = ctx.method_8036();
                        if (v9 != null) {
                            v9.method_43496((class_2561)class_2561.method_43470((String)("Assembling (" + blockPos.method_10263() + ", " + blockPos.method_10264() + ", " + blockPos.method_10260() + ") to (" + firstPosX + ", " + firstPosY + ", " + firstPosZ + ")!")));
                        }
                        ShipAssemblyKt.createNewShipWithStructure(lowerCorner, upperCorner, structure, level);
                    }
                }
                v10 = item.method_7969();
                Intrinsics.checkNotNull((Object)v10);
                v10.method_10551("firstPosX");
                v11 = item.method_7969();
                Intrinsics.checkNotNull((Object)v11);
                v11.method_10551("firstPosY");
                v12 = item.method_7969();
                Intrinsics.checkNotNull((Object)v12);
                v12.method_10551("firstPosZ");
            } else lbl-1000:
            // 2 sources

            {
                firstPosY = var7_8 = item.method_7948();
                var14_17 = item;
                $i$a$-apply-AreaAssemblerItem$useOn$1 = false;
                $this$useOn_u24lambda_u240.method_10569("firstPosX", blockPos.method_10263());
                $this$useOn_u24lambda_u240.method_10569("firstPosY", blockPos.method_10264());
                $this$useOn_u24lambda_u240.method_10569("firstPosZ", blockPos.method_10260());
                var14_17.method_7980(var7_8);
                v13 = ctx.method_8036();
                if (v13 != null) {
                    v13.method_43496((class_2561)class_2561.method_43470((String)("First block selected: (" + blockPos.method_10263() + ", " + blockPos.method_10264() + ", " + blockPos.method_10260() + ")")));
                }
            }
        }
        v14 = super.method_7884(ctx);
        Intrinsics.checkNotNullExpressionValue((Object)v14, (String)"useOn(...)");
        return v14;
    }
}

