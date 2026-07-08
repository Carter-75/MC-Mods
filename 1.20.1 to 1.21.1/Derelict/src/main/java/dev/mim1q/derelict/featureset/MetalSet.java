/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.item.v1.FabricItemSettings
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry
 *  net.minecraft.class_2248
 *  net.minecraft.class_2389
 *  net.minecraft.class_2399
 *  net.minecraft.class_2465
 *  net.minecraft.class_2482
 *  net.minecraft.class_2510
 *  net.minecraft.class_2533
 *  net.minecraft.class_2960
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5172
 *  net.minecraft.class_5812
 *  net.minecraft.class_5813
 *  net.minecraft.class_5814
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_8177
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.featureset;

import dev.mim1q.derelict.block.RotatableCoverBlock;
import dev.mim1q.derelict.block.metal.BarbedWireBlock;
import dev.mim1q.derelict.block.metal.BeamBlock;
import dev.mim1q.derelict.block.metal.GrateBlock;
import dev.mim1q.derelict.block.metal.MetalLadderBlock;
import dev.mim1q.derelict.block.metal.oxidizable.OxidizableBarbedWireBlock;
import dev.mim1q.derelict.block.metal.oxidizable.OxidizableBeamBlock;
import dev.mim1q.derelict.block.metal.oxidizable.OxidizableChainBlock;
import dev.mim1q.derelict.block.metal.oxidizable.OxidizableGrateBlock;
import dev.mim1q.derelict.block.metal.oxidizable.OxidizableMetalLadderBlock;
import dev.mim1q.derelict.block.metal.oxidizable.OxidizablePaneBlock;
import dev.mim1q.derelict.block.metal.oxidizable.OxidizablePillarBlock;
import dev.mim1q.derelict.block.metal.oxidizable.OxidizableTrapdoorBlock;
import dev.mim1q.derelict.featureset.FeatureSet;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.init.ModBlocksAndItemsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.class_2248;
import net.minecraft.class_2389;
import net.minecraft.class_2399;
import net.minecraft.class_2465;
import net.minecraft.class_2482;
import net.minecraft.class_2510;
import net.minecraft.class_2533;
import net.minecraft.class_2960;
import net.minecraft.class_4970;
import net.minecraft.class_5172;
import net.minecraft.class_5812;
import net.minecraft.class_5813;
import net.minecraft.class_5814;
import net.minecraft.class_5955;
import net.minecraft.class_8177;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003CDEB!\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00106\u001a\u0002038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u0082\u0001\u0002FG\u00a8\u0006H"}, d2={"Ldev/mim1q/derelict/featureset/MetalSet;", "Ldev/mim1q/derelict/featureset/FeatureSet;", "Lnet/minecraft/class_2960;", "id", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "defaultItemSettings", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "defaultBlockSettings", "<init>", "(Lnet/minecraft/class_2960;Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "", "Lnet/minecraft/class_2248;", "getCutoutBlocks", "()[Lnet/minecraft/class_2248;", "getBlock", "()Lnet/minecraft/class_2248;", "block", "getCut", "cut", "Lnet/minecraft/class_2465;", "getPillar", "()Lnet/minecraft/class_2465;", "pillar", "Lnet/minecraft/class_2510;", "getStairs", "()Lnet/minecraft/class_2510;", "stairs", "Lnet/minecraft/class_2482;", "getSlab", "()Lnet/minecraft/class_2482;", "slab", "Lnet/minecraft/class_2533;", "getTrapdoor", "()Lnet/minecraft/class_2533;", "trapdoor", "Lnet/minecraft/class_5172;", "getChain", "()Lnet/minecraft/class_5172;", "chain", "Ldev/mim1q/derelict/block/metal/GrateBlock;", "getGrate", "()Ldev/mim1q/derelict/block/metal/GrateBlock;", "grate", "Ldev/mim1q/derelict/block/metal/BeamBlock;", "getBeam", "()Ldev/mim1q/derelict/block/metal/BeamBlock;", "beam", "Lnet/minecraft/class_2399;", "getLadder", "()Lnet/minecraft/class_2399;", "ladder", "Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "getPatch", "()Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "patch", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "getSheet", "()Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "sheet", "Lnet/minecraft/class_2389;", "getChainLinkFence", "()Lnet/minecraft/class_2389;", "chainLinkFence", "Ldev/mim1q/derelict/block/metal/BarbedWireBlock;", "getBarbedWire", "()Ldev/mim1q/derelict/block/metal/BarbedWireBlock;", "barbedWire", "Regular", "Oxidized", "ThreeLevelOxidizable", "Ldev/mim1q/derelict/featureset/MetalSet$Oxidized;", "Ldev/mim1q/derelict/featureset/MetalSet$Regular;", "derelict"})
public abstract class MetalSet
extends FeatureSet {
    private MetalSet(class_2960 id, FabricItemSettings defaultItemSettings, FabricBlockSettings defaultBlockSettings) {
        super(id, defaultItemSettings, defaultBlockSettings);
    }

    @NotNull
    public abstract class_2248 getBlock();

    @NotNull
    public abstract class_2248 getCut();

    @NotNull
    public abstract class_2465 getPillar();

    @NotNull
    public abstract class_2510 getStairs();

    @NotNull
    public abstract class_2482 getSlab();

    @NotNull
    public abstract class_2533 getTrapdoor();

    @NotNull
    public abstract class_5172 getChain();

    @NotNull
    public abstract GrateBlock getGrate();

    @NotNull
    public abstract BeamBlock getBeam();

    @NotNull
    public abstract class_2399 getLadder();

    @NotNull
    public abstract RotatableCoverBlock.SquarePatch getPatch();

    @NotNull
    public abstract RotatableCoverBlock.Normal getSheet();

    @NotNull
    public abstract class_2389 getChainLinkFence();

    @NotNull
    public abstract BarbedWireBlock getBarbedWire();

    @NotNull
    public final class_2248[] getCutoutBlocks() {
        class_2248[] class_2248Array = new class_2248[]{this.getChain(), this.getGrate(), this.getLadder(), this.getChainLinkFence(), this.getBarbedWire(), this.getTrapdoor()};
        return class_2248Array;
    }

    public /* synthetic */ MetalSet(class_2960 id, FabricItemSettings defaultItemSettings, FabricBlockSettings defaultBlockSettings, DefaultConstructorMarker $constructor_marker) {
        this(id, defaultItemSettings, defaultBlockSettings);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020$8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020)8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010/\u001a\u00020.8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00104\u001a\u0002038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u00109\u001a\u0002088\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020=8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020B8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010H\u001a\u00020G8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010M\u001a\u00020L8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001a\u0010R\u001a\u00020Q8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001a\u0010W\u001a\u00020V8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\u00a8\u0006["}, d2={"Ldev/mim1q/derelict/featureset/MetalSet$Oxidized;", "Ldev/mim1q/derelict/featureset/MetalSet;", "Lnet/minecraft/class_2960;", "id", "", "prefix", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "defaultItemSettings", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "defaultBlockSettings", "Lnet/minecraft/class_5955$class_5811;", "level", "<init>", "(Lnet/minecraft/class_2960;Ljava/lang/String;Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;Lnet/minecraft/class_5955$class_5811;)V", "Lnet/minecraft/class_2248;", "base", "moreOxidized", "waxed", "", "registerOxidizable", "(Lnet/minecraft/class_2248;Lnet/minecraft/class_2248;Lnet/minecraft/class_2248;)V", "moreOxidizedSet", "waxedSet", "register", "(Ldev/mim1q/derelict/featureset/MetalSet;Ldev/mim1q/derelict/featureset/MetalSet;)Ldev/mim1q/derelict/featureset/MetalSet$Oxidized;", "block", "Lnet/minecraft/class_2248;", "getBlock", "()Lnet/minecraft/class_2248;", "cut", "getCut", "Lnet/minecraft/class_2465;", "pillar", "Lnet/minecraft/class_2465;", "getPillar", "()Lnet/minecraft/class_2465;", "Lnet/minecraft/class_2510;", "stairs", "Lnet/minecraft/class_2510;", "getStairs", "()Lnet/minecraft/class_2510;", "Lnet/minecraft/class_2482;", "slab", "Lnet/minecraft/class_2482;", "getSlab", "()Lnet/minecraft/class_2482;", "Lnet/minecraft/class_2533;", "trapdoor", "Lnet/minecraft/class_2533;", "getTrapdoor", "()Lnet/minecraft/class_2533;", "Lnet/minecraft/class_5172;", "chain", "Lnet/minecraft/class_5172;", "getChain", "()Lnet/minecraft/class_5172;", "Ldev/mim1q/derelict/block/metal/oxidizable/OxidizableGrateBlock;", "grate", "Ldev/mim1q/derelict/block/metal/oxidizable/OxidizableGrateBlock;", "getGrate", "()Ldev/mim1q/derelict/block/metal/oxidizable/OxidizableGrateBlock;", "Ldev/mim1q/derelict/block/metal/BeamBlock;", "beam", "Ldev/mim1q/derelict/block/metal/BeamBlock;", "getBeam", "()Ldev/mim1q/derelict/block/metal/BeamBlock;", "Lnet/minecraft/class_2399;", "ladder", "Lnet/minecraft/class_2399;", "getLadder", "()Lnet/minecraft/class_2399;", "Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "patch", "Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "getPatch", "()Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "sheet", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "getSheet", "()Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "Lnet/minecraft/class_2389;", "chainLinkFence", "Lnet/minecraft/class_2389;", "getChainLinkFence", "()Lnet/minecraft/class_2389;", "Ldev/mim1q/derelict/block/metal/BarbedWireBlock;", "barbedWire", "Ldev/mim1q/derelict/block/metal/BarbedWireBlock;", "getBarbedWire", "()Ldev/mim1q/derelict/block/metal/BarbedWireBlock;", "derelict"})
    public static final class Oxidized
    extends MetalSet {
        @NotNull
        private final class_2248 block;
        @NotNull
        private final class_2248 cut;
        @NotNull
        private final class_2465 pillar;
        @NotNull
        private final class_2510 stairs;
        @NotNull
        private final class_2482 slab;
        @NotNull
        private final class_2533 trapdoor;
        @NotNull
        private final class_5172 chain;
        @NotNull
        private final OxidizableGrateBlock grate;
        @NotNull
        private final BeamBlock beam;
        @NotNull
        private final class_2399 ladder;
        @NotNull
        private final RotatableCoverBlock.SquarePatch patch;
        @NotNull
        private final RotatableCoverBlock.Normal sheet;
        @NotNull
        private final class_2389 chainLinkFence;
        @NotNull
        private final BarbedWireBlock barbedWire;

        public Oxidized(@NotNull class_2960 id, @NotNull String prefix, @NotNull FabricItemSettings defaultItemSettings, @NotNull FabricBlockSettings defaultBlockSettings, @NotNull class_5955.class_5811 level) {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
            Intrinsics.checkNotNullParameter((Object)defaultItemSettings, (String)"defaultItemSettings");
            Intrinsics.checkNotNullParameter((Object)defaultBlockSettings, (String)"defaultBlockSettings");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            super(id, defaultItemSettings, defaultBlockSettings, null);
            this.block = this.registerBlockWithItem(prefix + this.getName() + "_block", (class_2248)new class_5812(level, (class_4970.class_2251)this.defaultBlockSettings()), ModBlocksAndItems.ItemCategory.METAL_BLOCKS);
            this.cut = this.registerBlockWithItem(prefix + "cut_" + this.getName(), (class_2248)new class_5812(level, (class_4970.class_2251)this.defaultBlockSettings()), ModBlocksAndItems.ItemCategory.METAL_BLOCKS);
            this.pillar = (class_2465)this.registerBlockWithItem(prefix + this.getName() + "_pillar", (class_2248)new OxidizablePillarBlock(level, (class_4970.class_2251)this.defaultBlockSettings()), ModBlocksAndItems.ItemCategory.METAL_BLOCKS);
            this.stairs = (class_2510)this.registerBlockWithItem(prefix + "cut_" + this.getName() + "_stairs", (class_2248)new class_5814(level, this.getBlock().method_9564(), (class_4970.class_2251)this.defaultBlockSettings().nonOpaque()), ModBlocksAndItems.ItemCategory.METAL_BLOCKS);
            this.slab = (class_2482)this.registerBlockWithItem(prefix + "cut_" + this.getName() + "_slab", (class_2248)new class_5813(level, (class_4970.class_2251)this.defaultBlockSettings().nonOpaque()), ModBlocksAndItems.ItemCategory.METAL_BLOCKS);
            String string = prefix + this.getName() + "_trapdoor";
            FabricBlockSettings fabricBlockSettings = this.defaultBlockSettings().nonOpaque();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings, (String)"nonOpaque(...)");
            class_4970.class_2251 class_22512 = (class_4970.class_2251)fabricBlockSettings;
            class_8177 class_81772 = class_8177.field_42819;
            Intrinsics.checkNotNullExpressionValue((Object)class_81772, (String)"IRON");
            this.trapdoor = (class_2533)this.registerBlockWithItem(string, (class_2248)new OxidizableTrapdoorBlock(level, class_22512, class_81772), ModBlocksAndItems.ItemCategory.METAL_DECORATION);
            String string2 = prefix + this.getName() + "_chain";
            FabricBlockSettings fabricBlockSettings2 = this.defaultBlockSettings().nonOpaque();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings2, (String)"nonOpaque(...)");
            this.chain = (class_5172)this.registerBlockWithItem(string2, (class_2248)new OxidizableChainBlock(level, (class_4970.class_2251)fabricBlockSettings2), ModBlocksAndItems.ItemCategory.METAL_DECORATION);
            String string3 = prefix + this.getName() + "_grate";
            FabricBlockSettings fabricBlockSettings3 = this.defaultBlockSettings().nonOpaque();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings3, (String)"nonOpaque(...)");
            this.grate = (OxidizableGrateBlock)this.registerBlockWithItem(string3, (class_2248)new OxidizableGrateBlock(level, (class_4970.class_2251)fabricBlockSettings3), ModBlocksAndItems.ItemCategory.METAL_DECORATION);
            String string4 = prefix + this.getName() + "_beam";
            FabricBlockSettings fabricBlockSettings4 = this.defaultBlockSettings().nonOpaque();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings4, (String)"nonOpaque(...)");
            this.beam = (BeamBlock)this.registerBlockWithItem(string4, (class_2248)new OxidizableBeamBlock(level, (class_4970.class_2251)fabricBlockSettings4), ModBlocksAndItems.ItemCategory.METAL_DECORATION);
            String string5 = prefix + this.getName() + "_ladder";
            FabricBlockSettings fabricBlockSettings5 = this.defaultBlockSettings().nonOpaque();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings5, (String)"nonOpaque(...)");
            this.ladder = (class_2399)this.registerBlockWithItem(string5, (class_2248)new OxidizableMetalLadderBlock(level, (class_4970.class_2251)fabricBlockSettings5), ModBlocksAndItems.ItemCategory.METAL_DECORATION);
            String string6 = prefix + this.getName() + "_patch";
            class_4970.class_2251 class_22513 = ModBlocksAndItemsKt.noZFighting((class_4970.class_2251)this.defaultBlockSettings().nonOpaque());
            Intrinsics.checkNotNullExpressionValue((Object)class_22513, (String)"noZFighting(...)");
            this.patch = (RotatableCoverBlock.SquarePatch)this.registerBlockWithItem(string6, (class_2248)new RotatableCoverBlock.SquarePatch.OxidizableSquarePatch(level, (FabricBlockSettings)class_22513), ModBlocksAndItems.ItemCategory.METAL_DECORATION);
            String string7 = prefix + this.getName() + "_sheet";
            class_4970.class_2251 class_22514 = ModBlocksAndItemsKt.noZFighting((class_4970.class_2251)this.defaultBlockSettings().nonOpaque());
            Intrinsics.checkNotNullExpressionValue((Object)class_22514, (String)"noZFighting(...)");
            this.sheet = (RotatableCoverBlock.Normal)this.registerBlockWithItem(string7, (class_2248)new RotatableCoverBlock.Normal.OxidizableNormal(level, (FabricBlockSettings)class_22514), ModBlocksAndItems.ItemCategory.METAL_DECORATION);
            String string8 = prefix + this.getName() + "_chain_link_fence";
            FabricBlockSettings fabricBlockSettings6 = this.defaultBlockSettings().nonOpaque();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings6, (String)"nonOpaque(...)");
            this.chainLinkFence = (class_2389)this.registerBlockWithItem(string8, (class_2248)new OxidizablePaneBlock(level, fabricBlockSettings6), ModBlocksAndItems.ItemCategory.METAL_DECORATION);
            String string9 = prefix + this.getName() + "_barbed_wire";
            FabricBlockSettings fabricBlockSettings7 = this.defaultBlockSettings().nonOpaque().noCollision();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings7, (String)"noCollision(...)");
            this.barbedWire = (BarbedWireBlock)this.registerBlockWithItem(string9, (class_2248)new OxidizableBarbedWireBlock(level, fabricBlockSettings7), ModBlocksAndItems.ItemCategory.METAL_DECORATION);
        }

        @Override
        @NotNull
        public class_2248 getBlock() {
            return this.block;
        }

        @Override
        @NotNull
        public class_2248 getCut() {
            return this.cut;
        }

        @Override
        @NotNull
        public class_2465 getPillar() {
            return this.pillar;
        }

        @Override
        @NotNull
        public class_2510 getStairs() {
            return this.stairs;
        }

        @Override
        @NotNull
        public class_2482 getSlab() {
            return this.slab;
        }

        @Override
        @NotNull
        public class_2533 getTrapdoor() {
            return this.trapdoor;
        }

        @Override
        @NotNull
        public class_5172 getChain() {
            return this.chain;
        }

        @Override
        @NotNull
        public OxidizableGrateBlock getGrate() {
            return this.grate;
        }

        @Override
        @NotNull
        public BeamBlock getBeam() {
            return this.beam;
        }

        @Override
        @NotNull
        public class_2399 getLadder() {
            return this.ladder;
        }

        @Override
        @NotNull
        public RotatableCoverBlock.SquarePatch getPatch() {
            return this.patch;
        }

        @Override
        @NotNull
        public RotatableCoverBlock.Normal getSheet() {
            return this.sheet;
        }

        @Override
        @NotNull
        public class_2389 getChainLinkFence() {
            return this.chainLinkFence;
        }

        @Override
        @NotNull
        public BarbedWireBlock getBarbedWire() {
            return this.barbedWire;
        }

        private final void registerOxidizable(class_2248 base, class_2248 moreOxidized, class_2248 waxed) {
            if (moreOxidized != null) {
                OxidizableBlocksRegistry.registerOxidizableBlockPair((class_2248)base, (class_2248)moreOxidized);
            }
            OxidizableBlocksRegistry.registerWaxableBlockPair((class_2248)base, (class_2248)waxed);
        }

        @NotNull
        public final Oxidized register(@Nullable MetalSet moreOxidizedSet, @NotNull MetalSet waxedSet) {
            Intrinsics.checkNotNullParameter((Object)waxedSet, (String)"waxedSet");
            MetalSet metalSet = moreOxidizedSet;
            this.registerOxidizable(this.getBlock(), (class_2248)(metalSet != null ? metalSet.getBlock() : null), waxedSet.getBlock());
            MetalSet metalSet2 = moreOxidizedSet;
            this.registerOxidizable(this.getCut(), (class_2248)(metalSet2 != null ? metalSet2.getCut() : null), waxedSet.getCut());
            MetalSet metalSet3 = moreOxidizedSet;
            this.registerOxidizable((class_2248)this.getPillar(), (class_2248)(metalSet3 != null ? metalSet3.getPillar() : null), (class_2248)waxedSet.getPillar());
            MetalSet metalSet4 = moreOxidizedSet;
            this.registerOxidizable((class_2248)this.getStairs(), (class_2248)(metalSet4 != null ? metalSet4.getStairs() : null), (class_2248)waxedSet.getStairs());
            MetalSet metalSet5 = moreOxidizedSet;
            this.registerOxidizable((class_2248)this.getSlab(), (class_2248)(metalSet5 != null ? metalSet5.getSlab() : null), (class_2248)waxedSet.getSlab());
            MetalSet metalSet6 = moreOxidizedSet;
            this.registerOxidizable((class_2248)this.getTrapdoor(), (class_2248)(metalSet6 != null ? metalSet6.getTrapdoor() : null), (class_2248)waxedSet.getTrapdoor());
            MetalSet metalSet7 = moreOxidizedSet;
            this.registerOxidizable((class_2248)this.getChain(), (class_2248)(metalSet7 != null ? metalSet7.getChain() : null), (class_2248)waxedSet.getChain());
            MetalSet metalSet8 = moreOxidizedSet;
            this.registerOxidizable((class_2248)this.getGrate(), (class_2248)(metalSet8 != null ? metalSet8.getGrate() : null), (class_2248)waxedSet.getGrate());
            MetalSet metalSet9 = moreOxidizedSet;
            this.registerOxidizable(this.getBeam(), metalSet9 != null ? metalSet9.getBeam() : null, waxedSet.getBeam());
            MetalSet metalSet10 = moreOxidizedSet;
            this.registerOxidizable((class_2248)this.getLadder(), (class_2248)(metalSet10 != null ? metalSet10.getLadder() : null), (class_2248)waxedSet.getLadder());
            MetalSet metalSet11 = moreOxidizedSet;
            this.registerOxidizable(this.getPatch(), metalSet11 != null ? metalSet11.getPatch() : null, waxedSet.getPatch());
            MetalSet metalSet12 = moreOxidizedSet;
            this.registerOxidizable(this.getSheet(), metalSet12 != null ? metalSet12.getSheet() : null, waxedSet.getSheet());
            MetalSet metalSet13 = moreOxidizedSet;
            this.registerOxidizable((class_2248)this.getChainLinkFence(), (class_2248)(metalSet13 != null ? metalSet13.getChainLinkFence() : null), (class_2248)waxedSet.getChainLinkFence());
            MetalSet metalSet14 = moreOxidizedSet;
            this.registerOxidizable(this.getBarbedWire(), metalSet14 != null ? metalSet14.getBarbedWire() : null, waxedSet.getBarbedWire());
            return this;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\"8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020'8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020,8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00102\u001a\u0002018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u00107\u001a\u0002068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010<\u001a\u00020;8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010A\u001a\u00020@8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010F\u001a\u00020E8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001a\u0010K\u001a\u00020J8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\u00a8\u0006O"}, d2={"Ldev/mim1q/derelict/featureset/MetalSet$Regular;", "Ldev/mim1q/derelict/featureset/MetalSet;", "Lnet/minecraft/class_2960;", "id", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "defaultItemSettings", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "defaultBlockSettings", "", "prefix", "<init>", "(Lnet/minecraft/class_2960;Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;Ljava/lang/String;)V", "Lnet/minecraft/class_2248;", "block", "Lnet/minecraft/class_2248;", "getBlock", "()Lnet/minecraft/class_2248;", "cut", "getCut", "Lnet/minecraft/class_2465;", "pillar", "Lnet/minecraft/class_2465;", "getPillar", "()Lnet/minecraft/class_2465;", "Lnet/minecraft/class_2510;", "stairs", "Lnet/minecraft/class_2510;", "getStairs", "()Lnet/minecraft/class_2510;", "Lnet/minecraft/class_2482;", "slab", "Lnet/minecraft/class_2482;", "getSlab", "()Lnet/minecraft/class_2482;", "Lnet/minecraft/class_2533;", "trapdoor", "Lnet/minecraft/class_2533;", "getTrapdoor", "()Lnet/minecraft/class_2533;", "Lnet/minecraft/class_5172;", "chain", "Lnet/minecraft/class_5172;", "getChain", "()Lnet/minecraft/class_5172;", "Ldev/mim1q/derelict/block/metal/GrateBlock;", "grate", "Ldev/mim1q/derelict/block/metal/GrateBlock;", "getGrate", "()Ldev/mim1q/derelict/block/metal/GrateBlock;", "Ldev/mim1q/derelict/block/metal/BeamBlock;", "beam", "Ldev/mim1q/derelict/block/metal/BeamBlock;", "getBeam", "()Ldev/mim1q/derelict/block/metal/BeamBlock;", "Lnet/minecraft/class_2399;", "ladder", "Lnet/minecraft/class_2399;", "getLadder", "()Lnet/minecraft/class_2399;", "Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "patch", "Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "getPatch", "()Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "sheet", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "getSheet", "()Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "Lnet/minecraft/class_2389;", "chainLinkFence", "Lnet/minecraft/class_2389;", "getChainLinkFence", "()Lnet/minecraft/class_2389;", "Ldev/mim1q/derelict/block/metal/BarbedWireBlock;", "barbedWire", "Ldev/mim1q/derelict/block/metal/BarbedWireBlock;", "getBarbedWire", "()Ldev/mim1q/derelict/block/metal/BarbedWireBlock;", "derelict"})
    public static final class Regular
    extends MetalSet {
        @NotNull
        private final class_2248 block;
        @NotNull
        private final class_2248 cut;
        @NotNull
        private final class_2465 pillar;
        @NotNull
        private final class_2510 stairs;
        @NotNull
        private final class_2482 slab;
        @NotNull
        private final class_2533 trapdoor;
        @NotNull
        private final class_5172 chain;
        @NotNull
        private final GrateBlock grate;
        @NotNull
        private final BeamBlock beam;
        @NotNull
        private final class_2399 ladder;
        @NotNull
        private final RotatableCoverBlock.SquarePatch patch;
        @NotNull
        private final RotatableCoverBlock.Normal sheet;
        @NotNull
        private final class_2389 chainLinkFence;
        @NotNull
        private final BarbedWireBlock barbedWire;

        public Regular(@NotNull class_2960 id, @NotNull FabricItemSettings defaultItemSettings, @NotNull FabricBlockSettings defaultBlockSettings, @NotNull String prefix) {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            Intrinsics.checkNotNullParameter((Object)defaultItemSettings, (String)"defaultItemSettings");
            Intrinsics.checkNotNullParameter((Object)defaultBlockSettings, (String)"defaultBlockSettings");
            Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
            super(id, defaultItemSettings, defaultBlockSettings, null);
            this.block = this.registerBlockWithItem(prefix + this.getName() + "_block", new class_2248((class_4970.class_2251)this.defaultBlockSettings()), ModBlocksAndItems.ItemCategory.WAXED_METAL_BLOCKS);
            this.cut = this.registerBlockWithItem(prefix + "cut_" + this.getName(), new class_2248((class_4970.class_2251)this.defaultBlockSettings()), ModBlocksAndItems.ItemCategory.WAXED_METAL_BLOCKS);
            this.pillar = (class_2465)this.registerBlockWithItem(prefix + this.getName() + "_pillar", (class_2248)new class_2465((class_4970.class_2251)this.defaultBlockSettings()), ModBlocksAndItems.ItemCategory.WAXED_METAL_BLOCKS);
            this.stairs = (class_2510)this.registerBlockWithItem(prefix + "cut_" + this.getName() + "_stairs", (class_2248)new class_2510(this.getBlock().method_9564(), (class_4970.class_2251)this.defaultBlockSettings().nonOpaque()), ModBlocksAndItems.ItemCategory.WAXED_METAL_BLOCKS);
            this.slab = (class_2482)this.registerBlockWithItem(prefix + "cut_" + this.getName() + "_slab", (class_2248)new class_2482((class_4970.class_2251)this.defaultBlockSettings().nonOpaque()), ModBlocksAndItems.ItemCategory.WAXED_METAL_BLOCKS);
            this.trapdoor = (class_2533)this.registerBlockWithItem(prefix + this.getName() + "_trapdoor", (class_2248)new class_2533((class_4970.class_2251)this.defaultBlockSettings().nonOpaque(), class_8177.field_42819), ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION);
            this.chain = (class_5172)this.registerBlockWithItem(prefix + this.getName() + "_chain", (class_2248)new class_5172((class_4970.class_2251)this.defaultBlockSettings().nonOpaque()), ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION);
            String string = prefix + this.getName() + "_grate";
            FabricBlockSettings fabricBlockSettings = this.defaultBlockSettings().nonOpaque();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings, (String)"nonOpaque(...)");
            this.grate = (GrateBlock)this.registerBlockWithItem(string, (class_2248)new GrateBlock((class_4970.class_2251)fabricBlockSettings), ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION);
            String string2 = prefix + this.getName() + "_beam";
            FabricBlockSettings fabricBlockSettings2 = this.defaultBlockSettings().nonOpaque();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings2, (String)"nonOpaque(...)");
            this.beam = (BeamBlock)this.registerBlockWithItem(string2, (class_2248)new BeamBlock((class_4970.class_2251)fabricBlockSettings2), ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION);
            String string3 = prefix + this.getName() + "_ladder";
            FabricBlockSettings fabricBlockSettings3 = this.defaultBlockSettings().nonOpaque();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings3, (String)"nonOpaque(...)");
            this.ladder = (class_2399)this.registerBlockWithItem(string3, (class_2248)new MetalLadderBlock((class_4970.class_2251)fabricBlockSettings3), ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION);
            String string4 = prefix + this.getName() + "_patch";
            class_4970.class_2251 class_22512 = ModBlocksAndItemsKt.noZFighting((class_4970.class_2251)this.defaultBlockSettings().nonOpaque());
            Intrinsics.checkNotNullExpressionValue((Object)class_22512, (String)"noZFighting(...)");
            this.patch = (RotatableCoverBlock.SquarePatch)this.registerBlockWithItem(string4, (class_2248)new RotatableCoverBlock.SquarePatch((FabricBlockSettings)class_22512), ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION);
            String string5 = prefix + this.getName() + "_sheet";
            class_4970.class_2251 class_22513 = ModBlocksAndItemsKt.noZFighting((class_4970.class_2251)this.defaultBlockSettings().nonOpaque());
            Intrinsics.checkNotNullExpressionValue((Object)class_22513, (String)"noZFighting(...)");
            this.sheet = (RotatableCoverBlock.Normal)this.registerBlockWithItem(string5, (class_2248)new RotatableCoverBlock.Normal((FabricBlockSettings)class_22513), ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION);
            this.chainLinkFence = (class_2389)this.registerBlockWithItem(prefix + this.getName() + "_chain_link_fence", (class_2248)new class_2389((class_4970.class_2251)this.defaultBlockSettings().nonOpaque()), ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION);
            String string6 = prefix + this.getName() + "_barbed_wire";
            FabricBlockSettings fabricBlockSettings4 = this.defaultBlockSettings().nonOpaque().noCollision();
            Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings4, (String)"noCollision(...)");
            this.barbedWire = (BarbedWireBlock)this.registerBlockWithItem(string6, (class_2248)new BarbedWireBlock(fabricBlockSettings4), ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION);
        }

        public /* synthetic */ Regular(class_2960 class_29602, FabricItemSettings fabricItemSettings, FabricBlockSettings fabricBlockSettings, String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 8) != 0) {
                string = "";
            }
            this(class_29602, fabricItemSettings, fabricBlockSettings, string);
        }

        @Override
        @NotNull
        public class_2248 getBlock() {
            return this.block;
        }

        @Override
        @NotNull
        public class_2248 getCut() {
            return this.cut;
        }

        @Override
        @NotNull
        public class_2465 getPillar() {
            return this.pillar;
        }

        @Override
        @NotNull
        public class_2510 getStairs() {
            return this.stairs;
        }

        @Override
        @NotNull
        public class_2482 getSlab() {
            return this.slab;
        }

        @Override
        @NotNull
        public class_2533 getTrapdoor() {
            return this.trapdoor;
        }

        @Override
        @NotNull
        public class_5172 getChain() {
            return this.chain;
        }

        @Override
        @NotNull
        public GrateBlock getGrate() {
            return this.grate;
        }

        @Override
        @NotNull
        public BeamBlock getBeam() {
            return this.beam;
        }

        @Override
        @NotNull
        public class_2399 getLadder() {
            return this.ladder;
        }

        @Override
        @NotNull
        public RotatableCoverBlock.SquarePatch getPatch() {
            return this.patch;
        }

        @Override
        @NotNull
        public RotatableCoverBlock.Normal getSheet() {
            return this.sheet;
        }

        @Override
        @NotNull
        public class_2389 getChainLinkFence() {
            return this.chainLinkFence;
        }

        @Override
        @NotNull
        public BarbedWireBlock getBarbedWire() {
            return this.barbedWire;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010 \u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\u00a8\u0006\""}, d2={"Ldev/mim1q/derelict/featureset/MetalSet$ThreeLevelOxidizable;", "Ldev/mim1q/derelict/featureset/FeatureSet;", "Lnet/minecraft/class_2960;", "id", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "defaultItemSettings", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "defaultBlockSettings", "<init>", "(Lnet/minecraft/class_2960;Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "", "Lnet/minecraft/class_2248;", "getCutoutBlocks", "()[Lnet/minecraft/class_2248;", "register", "()Ldev/mim1q/derelict/featureset/MetalSet$ThreeLevelOxidizable;", "Ldev/mim1q/derelict/featureset/MetalSet$Regular;", "waxedUnaffected", "Ldev/mim1q/derelict/featureset/MetalSet$Regular;", "getWaxedUnaffected", "()Ldev/mim1q/derelict/featureset/MetalSet$Regular;", "waxedWeathered", "getWaxedWeathered", "waxedOxidized", "getWaxedOxidized", "Ldev/mim1q/derelict/featureset/MetalSet$Oxidized;", "unaffected", "Ldev/mim1q/derelict/featureset/MetalSet$Oxidized;", "getUnaffected", "()Ldev/mim1q/derelict/featureset/MetalSet$Oxidized;", "weathered", "getWeathered", "oxidized", "getOxidized", "derelict"})
    public static final class ThreeLevelOxidizable
    extends FeatureSet {
        @NotNull
        private final Regular waxedUnaffected;
        @NotNull
        private final Regular waxedWeathered;
        @NotNull
        private final Regular waxedOxidized;
        @NotNull
        private final Oxidized unaffected;
        @NotNull
        private final Oxidized weathered;
        @NotNull
        private final Oxidized oxidized;

        public ThreeLevelOxidizable(@NotNull class_2960 id, @NotNull FabricItemSettings defaultItemSettings, @NotNull FabricBlockSettings defaultBlockSettings) {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            Intrinsics.checkNotNullParameter((Object)defaultItemSettings, (String)"defaultItemSettings");
            Intrinsics.checkNotNullParameter((Object)defaultBlockSettings, (String)"defaultBlockSettings");
            super(id, defaultItemSettings, defaultBlockSettings);
            this.waxedUnaffected = new Regular(id, defaultItemSettings, defaultBlockSettings, "waxed_");
            this.waxedWeathered = new Regular(id, defaultItemSettings, defaultBlockSettings, "waxed_weathered_");
            this.waxedOxidized = new Regular(id, defaultItemSettings, defaultBlockSettings, "waxed_oxidized_");
            this.unaffected = new Oxidized(id, "", defaultItemSettings, defaultBlockSettings, class_5955.class_5811.field_28704);
            this.weathered = new Oxidized(id, "weathered_", defaultItemSettings, defaultBlockSettings, class_5955.class_5811.field_28706);
            this.oxidized = new Oxidized(id, "oxidized_", defaultItemSettings, defaultBlockSettings, class_5955.class_5811.field_28707);
        }

        @NotNull
        public final Regular getWaxedUnaffected() {
            return this.waxedUnaffected;
        }

        @NotNull
        public final Regular getWaxedWeathered() {
            return this.waxedWeathered;
        }

        @NotNull
        public final Regular getWaxedOxidized() {
            return this.waxedOxidized;
        }

        @NotNull
        public final Oxidized getUnaffected() {
            return this.unaffected;
        }

        @NotNull
        public final Oxidized getWeathered() {
            return this.weathered;
        }

        @NotNull
        public final Oxidized getOxidized() {
            return this.oxidized;
        }

        @NotNull
        public final class_2248[] getCutoutBlocks() {
            return (class_2248[])ArraysKt.plus((Object[])ArraysKt.plus((Object[])ArraysKt.plus((Object[])ArraysKt.plus((Object[])ArraysKt.plus((Object[])this.unaffected.getCutoutBlocks(), (Object[])this.waxedUnaffected.getCutoutBlocks()), (Object[])this.weathered.getCutoutBlocks()), (Object[])this.waxedWeathered.getCutoutBlocks()), (Object[])this.oxidized.getCutoutBlocks()), (Object[])this.waxedOxidized.getCutoutBlocks());
        }

        @Override
        @NotNull
        public ThreeLevelOxidizable register() {
            this.unaffected.register(this.weathered, this.waxedUnaffected);
            this.weathered.register(this.oxidized, this.waxedWeathered);
            this.oxidized.register(null, this.waxedOxidized);
            return this;
        }
    }
}

