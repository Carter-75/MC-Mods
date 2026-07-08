/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2269
 *  net.minecraft.class_2440
 *  net.minecraft.class_2440$class_2441
 *  net.minecraft.class_2482
 *  net.minecraft.class_2510
 *  net.minecraft.class_2544
 *  net.minecraft.class_2960
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_8177
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.featureset;

import dev.mim1q.derelict.featureset.FeatureSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2440;
import net.minecraft.class_2482;
import net.minecraft.class_2510;
import net.minecraft.class_2544;
import net.minecraft.class_2960;
import net.minecraft.class_4970;
import net.minecraft.class_8177;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u001f\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010%\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010*\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u0006."}, d2={"Ldev/mim1q/derelict/featureset/StoneSet;", "Ldev/mim1q/derelict/featureset/FeatureSet;", "Lnet/minecraft/class_2960;", "id", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "defaultBlockSettings", "<init>", "(Lnet/minecraft/class_2960;Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "register", "()Ldev/mim1q/derelict/featureset/StoneSet;", "Lnet/minecraft/class_8177;", "kotlin.jvm.PlatformType", "blockSetType", "Lnet/minecraft/class_8177;", "getBlockSetType", "()Lnet/minecraft/class_8177;", "Lnet/minecraft/class_2248;", "block", "Lnet/minecraft/class_2248;", "getBlock", "()Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2510;", "stairs", "Lnet/minecraft/class_2510;", "getStairs", "()Lnet/minecraft/class_2510;", "Lnet/minecraft/class_2482;", "slab", "Lnet/minecraft/class_2482;", "getSlab", "()Lnet/minecraft/class_2482;", "Lnet/minecraft/class_2544;", "wall", "Lnet/minecraft/class_2544;", "getWall", "()Lnet/minecraft/class_2544;", "Lnet/minecraft/class_2440;", "pressurePlate", "Lnet/minecraft/class_2440;", "getPressurePlate", "()Lnet/minecraft/class_2440;", "Lnet/minecraft/class_2269;", "button", "Lnet/minecraft/class_2269;", "getButton", "()Lnet/minecraft/class_2269;", "derelict"})
public final class StoneSet
extends FeatureSet {
    private final class_8177 blockSetType;
    @NotNull
    private final class_2248 block;
    @NotNull
    private final class_2510 stairs;
    @NotNull
    private final class_2482 slab;
    @NotNull
    private final class_2544 wall;
    @NotNull
    private final class_2440 pressurePlate;
    @NotNull
    private final class_2269 button;

    public StoneSet(@NotNull class_2960 id, @NotNull FabricBlockSettings defaultBlockSettings) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)defaultBlockSettings, (String)"defaultBlockSettings");
        super(id, null, defaultBlockSettings, 2, null);
        this.blockSetType = BlockSetTypeBuilder.copyOf((class_8177)class_8177.field_42821).build(id);
        this.block = new class_2248((class_4970.class_2251)defaultBlockSettings);
        this.stairs = new class_2510(this.block.method_9564(), (class_4970.class_2251)defaultBlockSettings);
        this.slab = new class_2482((class_4970.class_2251)defaultBlockSettings);
        this.wall = new class_2544((class_4970.class_2251)defaultBlockSettings);
        this.pressurePlate = new class_2440(class_2440.class_2441.field_11362, (class_4970.class_2251)defaultBlockSettings, this.blockSetType);
        this.button = new class_2269((class_4970.class_2251)defaultBlockSettings, this.blockSetType, 5, false);
    }

    public /* synthetic */ StoneSet(class_2960 class_29602, FabricBlockSettings fabricBlockSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            fabricBlockSettings = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10340));
        }
        this(class_29602, fabricBlockSettings);
    }

    public final class_8177 getBlockSetType() {
        return this.blockSetType;
    }

    @NotNull
    public final class_2248 getBlock() {
        return this.block;
    }

    @NotNull
    public final class_2510 getStairs() {
        return this.stairs;
    }

    @NotNull
    public final class_2482 getSlab() {
        return this.slab;
    }

    @NotNull
    public final class_2544 getWall() {
        return this.wall;
    }

    @NotNull
    public final class_2440 getPressurePlate() {
        return this.pressurePlate;
    }

    @NotNull
    public final class_2269 getButton() {
        return this.button;
    }

    @Override
    @NotNull
    public StoneSet register() {
        StoneSet stoneSet;
        StoneSet $this$register_u24lambda_u240 = stoneSet = this;
        boolean bl = false;
        FeatureSet featureSet = $this$register_u24lambda_u240;
        String string = $this$register_u24lambda_u240.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"<get-name>(...)");
        FeatureSet.registerBlockWithItem$default(featureSet, string, $this$register_u24lambda_u240.block, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_stairs", (class_2248)$this$register_u24lambda_u240.stairs, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_slab", (class_2248)$this$register_u24lambda_u240.slab, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_wall", (class_2248)$this$register_u24lambda_u240.wall, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_pressure_plate", (class_2248)$this$register_u24lambda_u240.pressurePlate, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_button", (class_2248)$this$register_u24lambda_u240.button, null, 4, null);
        return stoneSet;
    }
}

