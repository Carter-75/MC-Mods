/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.item.v1.FabricItemSettings
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder
 *  net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder
 *  net.fabricmc.fabric.api.registry.StrippableBlockRegistry
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1822
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2269
 *  net.minecraft.class_2323
 *  net.minecraft.class_2349
 *  net.minecraft.class_2354
 *  net.minecraft.class_2440
 *  net.minecraft.class_2440$class_2441
 *  net.minecraft.class_2465
 *  net.minecraft.class_2482
 *  net.minecraft.class_2508
 *  net.minecraft.class_2510
 *  net.minecraft.class_2533
 *  net.minecraft.class_2551
 *  net.minecraft.class_2960
 *  net.minecraft.class_4719
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
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.class_1792;
import net.minecraft.class_1822;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2323;
import net.minecraft.class_2349;
import net.minecraft.class_2354;
import net.minecraft.class_2440;
import net.minecraft.class_2465;
import net.minecraft.class_2482;
import net.minecraft.class_2508;
import net.minecraft.class_2510;
import net.minecraft.class_2533;
import net.minecraft.class_2551;
import net.minecraft.class_2960;
import net.minecraft.class_4719;
import net.minecraft.class_4970;
import net.minecraft.class_8177;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u001f\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\u00100\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010!\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0017\u0010#\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u0017\u0010&\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00100\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00105\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010:\u001a\u0002098\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010?\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010D\u001a\u00020C8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0017\u0010I\u001a\u00020H8\u0006\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010N\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0017\u0010S\u001a\u00020R8\u0006\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\u00a8\u0006W"}, d2={"Ldev/mim1q/derelict/featureset/WoodSet;", "Ldev/mim1q/derelict/featureset/FeatureSet;", "Lnet/minecraft/class_2960;", "id", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "defaultItemSettings", "<init>", "(Lnet/minecraft/class_2960;Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;)V", "register", "()Ldev/mim1q/derelict/featureset/WoodSet;", "Lnet/minecraft/class_8177;", "kotlin.jvm.PlatformType", "blockSetType", "Lnet/minecraft/class_8177;", "getBlockSetType", "()Lnet/minecraft/class_8177;", "Lnet/minecraft/class_4719;", "woodType", "Lnet/minecraft/class_4719;", "getWoodType", "()Lnet/minecraft/class_4719;", "Lnet/minecraft/class_2248;", "planks", "Lnet/minecraft/class_2248;", "getPlanks", "()Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2465;", "log", "Lnet/minecraft/class_2465;", "getLog", "()Lnet/minecraft/class_2465;", "strippedLog", "getStrippedLog", "wood", "getWood", "strippedWood", "getStrippedWood", "Lnet/minecraft/class_2510;", "stairs", "Lnet/minecraft/class_2510;", "getStairs", "()Lnet/minecraft/class_2510;", "Lnet/minecraft/class_2482;", "slab", "Lnet/minecraft/class_2482;", "getSlab", "()Lnet/minecraft/class_2482;", "Lnet/minecraft/class_2323;", "door", "Lnet/minecraft/class_2323;", "getDoor", "()Lnet/minecraft/class_2323;", "Lnet/minecraft/class_2533;", "trapdoor", "Lnet/minecraft/class_2533;", "getTrapdoor", "()Lnet/minecraft/class_2533;", "Lnet/minecraft/class_2354;", "fence", "Lnet/minecraft/class_2354;", "getFence", "()Lnet/minecraft/class_2354;", "Lnet/minecraft/class_2349;", "fenceGate", "Lnet/minecraft/class_2349;", "getFenceGate", "()Lnet/minecraft/class_2349;", "Lnet/minecraft/class_2269;", "button", "Lnet/minecraft/class_2269;", "getButton", "()Lnet/minecraft/class_2269;", "Lnet/minecraft/class_2440;", "pressurePlate", "Lnet/minecraft/class_2440;", "getPressurePlate", "()Lnet/minecraft/class_2440;", "Lnet/minecraft/class_2508;", "sign", "Lnet/minecraft/class_2508;", "getSign", "()Lnet/minecraft/class_2508;", "Lnet/minecraft/class_2551;", "wallSign", "Lnet/minecraft/class_2551;", "getWallSign", "()Lnet/minecraft/class_2551;", "derelict"})
public final class WoodSet
extends FeatureSet {
    private final class_8177 blockSetType;
    private final class_4719 woodType;
    @NotNull
    private final class_2248 planks;
    @NotNull
    private final class_2465 log;
    @NotNull
    private final class_2465 strippedLog;
    @NotNull
    private final class_2465 wood;
    @NotNull
    private final class_2465 strippedWood;
    @NotNull
    private final class_2510 stairs;
    @NotNull
    private final class_2482 slab;
    @NotNull
    private final class_2323 door;
    @NotNull
    private final class_2533 trapdoor;
    @NotNull
    private final class_2354 fence;
    @NotNull
    private final class_2349 fenceGate;
    @NotNull
    private final class_2269 button;
    @NotNull
    private final class_2440 pressurePlate;
    @NotNull
    private final class_2508 sign;
    @NotNull
    private final class_2551 wallSign;

    public WoodSet(@NotNull class_2960 id, @NotNull FabricItemSettings defaultItemSettings) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)defaultItemSettings, (String)"defaultItemSettings");
        FabricBlockSettings fabricBlockSettings = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10126));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings, (String)"copyOf(...)");
        super(id, defaultItemSettings, fabricBlockSettings);
        this.blockSetType = BlockSetTypeBuilder.copyOf((class_8177)class_8177.field_42823).register(id);
        this.woodType = WoodTypeBuilder.copyOf((class_4719)class_4719.field_21676).register(id, this.blockSetType);
        this.planks = new class_2248((class_4970.class_2251)this.defaultBlockSettings());
        this.log = new class_2465((class_4970.class_2251)this.defaultBlockSettings());
        this.strippedLog = new class_2465((class_4970.class_2251)this.defaultBlockSettings());
        this.wood = new class_2465((class_4970.class_2251)this.defaultBlockSettings());
        this.strippedWood = new class_2465((class_4970.class_2251)this.defaultBlockSettings());
        this.stairs = new class_2510(this.planks.method_9564(), (class_4970.class_2251)this.defaultBlockSettings());
        this.slab = new class_2482((class_4970.class_2251)this.defaultBlockSettings());
        this.door = new class_2323((class_4970.class_2251)this.defaultBlockSettings().nonOpaque(), this.blockSetType);
        this.trapdoor = new class_2533((class_4970.class_2251)this.defaultBlockSettings().nonOpaque(), this.blockSetType);
        this.fence = new class_2354((class_4970.class_2251)this.defaultBlockSettings());
        this.fenceGate = new class_2349((class_4970.class_2251)this.defaultBlockSettings(), this.woodType);
        this.button = new class_2269((class_4970.class_2251)this.defaultBlockSettings(), this.blockSetType, 20, true);
        this.pressurePlate = new class_2440(class_2440.class_2441.field_11361, (class_4970.class_2251)this.defaultBlockSettings(), this.blockSetType);
        this.sign = new class_2508((class_4970.class_2251)this.defaultBlockSettings().noCollision(), this.woodType);
        this.wallSign = new class_2551((class_4970.class_2251)this.defaultBlockSettings().noCollision(), this.woodType);
    }

    public /* synthetic */ WoodSet(class_2960 class_29602, FabricItemSettings fabricItemSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            fabricItemSettings = new FabricItemSettings();
        }
        this(class_29602, fabricItemSettings);
    }

    public final class_8177 getBlockSetType() {
        return this.blockSetType;
    }

    public final class_4719 getWoodType() {
        return this.woodType;
    }

    @NotNull
    public final class_2248 getPlanks() {
        return this.planks;
    }

    @NotNull
    public final class_2465 getLog() {
        return this.log;
    }

    @NotNull
    public final class_2465 getStrippedLog() {
        return this.strippedLog;
    }

    @NotNull
    public final class_2465 getWood() {
        return this.wood;
    }

    @NotNull
    public final class_2465 getStrippedWood() {
        return this.strippedWood;
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
    public final class_2323 getDoor() {
        return this.door;
    }

    @NotNull
    public final class_2533 getTrapdoor() {
        return this.trapdoor;
    }

    @NotNull
    public final class_2354 getFence() {
        return this.fence;
    }

    @NotNull
    public final class_2349 getFenceGate() {
        return this.fenceGate;
    }

    @NotNull
    public final class_2269 getButton() {
        return this.button;
    }

    @NotNull
    public final class_2440 getPressurePlate() {
        return this.pressurePlate;
    }

    @NotNull
    public final class_2508 getSign() {
        return this.sign;
    }

    @NotNull
    public final class_2551 getWallSign() {
        return this.wallSign;
    }

    @Override
    @NotNull
    public WoodSet register() {
        WoodSet woodSet;
        WoodSet $this$register_u24lambda_u240 = woodSet = this;
        boolean bl = false;
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_planks", $this$register_u24lambda_u240.planks, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_log", (class_2248)$this$register_u24lambda_u240.log, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, "stripped_" + $this$register_u24lambda_u240.getName() + "_log", (class_2248)$this$register_u24lambda_u240.strippedLog, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_wood", (class_2248)$this$register_u24lambda_u240.wood, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, "stripped_" + $this$register_u24lambda_u240.getName() + "_wood", (class_2248)$this$register_u24lambda_u240.strippedWood, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_stairs", (class_2248)$this$register_u24lambda_u240.stairs, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_slab", (class_2248)$this$register_u24lambda_u240.slab, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_door", (class_2248)$this$register_u24lambda_u240.door, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_trapdoor", (class_2248)$this$register_u24lambda_u240.trapdoor, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_fence", (class_2248)$this$register_u24lambda_u240.fence, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_fence_gate", (class_2248)$this$register_u24lambda_u240.fenceGate, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_button", (class_2248)$this$register_u24lambda_u240.button, null, 4, null);
        FeatureSet.registerBlockWithItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_pressure_plate", (class_2248)$this$register_u24lambda_u240.pressurePlate, null, 4, null);
        $this$register_u24lambda_u240.registerBlock($this$register_u24lambda_u240.getName() + "_sign", (class_2248)$this$register_u24lambda_u240.sign);
        $this$register_u24lambda_u240.registerBlock($this$register_u24lambda_u240.getName() + "_wall_sign", (class_2248)$this$register_u24lambda_u240.wallSign);
        FeatureSet.registerItem$default($this$register_u24lambda_u240, $this$register_u24lambda_u240.getName() + "_sign", (class_1792)new class_1822((class_1792.class_1793)$this$register_u24lambda_u240.getDefaultItemSettings().maxCount(16), (class_2248)$this$register_u24lambda_u240.sign, (class_2248)$this$register_u24lambda_u240.wallSign), null, 4, null);
        StrippableBlockRegistry.register((class_2248)((class_2248)$this$register_u24lambda_u240.log), (class_2248)((class_2248)$this$register_u24lambda_u240.strippedLog));
        StrippableBlockRegistry.register((class_2248)((class_2248)$this$register_u24lambda_u240.wood), (class_2248)((class_2248)$this$register_u24lambda_u240.strippedWood));
        return woodSet;
    }
}

