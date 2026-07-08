/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.item.v1.FabricItemSettings
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2320
 *  net.minecraft.class_2526
 *  net.minecraft.class_2960
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.featureset;

import dev.mim1q.derelict.featureset.FeatureSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2320;
import net.minecraft.class_2526;
import net.minecraft.class_2960;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0001H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"Ldev/mim1q/derelict/featureset/GrassSet;", "Ldev/mim1q/derelict/featureset/FeatureSet;", "Lnet/minecraft/class_2960;", "id", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "defaultItemSettings", "<init>", "(Lnet/minecraft/class_2960;Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;)V", "register", "()Ldev/mim1q/derelict/featureset/FeatureSet;", "Lnet/minecraft/class_2248;", "grassBlock", "Lnet/minecraft/class_2248;", "getGrassBlock", "()Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2526;", "grass", "Lnet/minecraft/class_2526;", "getGrass", "()Lnet/minecraft/class_2526;", "Lnet/minecraft/class_2320;", "tallGrass", "Lnet/minecraft/class_2320;", "getTallGrass", "()Lnet/minecraft/class_2320;", "derelict"})
public final class GrassSet
extends FeatureSet {
    @NotNull
    private final class_2248 grassBlock;
    @NotNull
    private final class_2526 grass;
    @NotNull
    private final class_2320 tallGrass;

    public GrassSet(@NotNull class_2960 id, @NotNull FabricItemSettings defaultItemSettings) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)defaultItemSettings, (String)"defaultItemSettings");
        super(id, defaultItemSettings, null, 4, null);
        this.grassBlock = FeatureSet.registerBlockWithItem$default(this, this.getName() + "_grass_block", new class_2248((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10219))), null, 4, null);
        this.grass = (class_2526)FeatureSet.registerBlockWithItem$default(this, this.getName() + "_grass", (class_2248)new class_2526((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10479))), null, 4, null);
        this.tallGrass = (class_2320)FeatureSet.registerBlockWithItem$default(this, "tall_" + this.getName() + "_grass", (class_2248)new class_2320((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10479))), null, 4, null);
    }

    @NotNull
    public final class_2248 getGrassBlock() {
        return this.grassBlock;
    }

    @NotNull
    public final class_2526 getGrass() {
        return this.grass;
    }

    @NotNull
    public final class_2320 getTallGrass() {
        return this.tallGrass;
    }

    @Override
    @NotNull
    public FeatureSet register() {
        return this;
    }
}

