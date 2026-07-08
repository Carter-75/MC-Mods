/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.item.v1.FabricItemSettings
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.minecraft.class_2246
 *  net.minecraft.class_2960
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.featureset;

import dev.mim1q.derelict.block.RotatableCoverBlock;
import dev.mim1q.derelict.featureset.FeatureSet;
import dev.mim1q.derelict.init.ModBlocksAndItemsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_2246;
import net.minecraft.class_2960;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2={"Ldev/mim1q/derelict/featureset/CoverBoardsSet;", "Ldev/mim1q/derelict/featureset/FeatureSet;", "Lnet/minecraft/class_2960;", "id", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "defaultItemSettings", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "defaultBlockSettings", "<init>", "(Lnet/minecraft/class_2960;Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "register", "()Ldev/mim1q/derelict/featureset/CoverBoardsSet;", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "single", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "getSingle", "()Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "double", "getDouble", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Crossed;", "crossed", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Crossed;", "getCrossed", "()Ldev/mim1q/derelict/block/RotatableCoverBlock$Crossed;", "derelict"})
public final class CoverBoardsSet
extends FeatureSet {
    @NotNull
    private final RotatableCoverBlock.Normal single;
    @NotNull
    private final RotatableCoverBlock.Normal double;
    @NotNull
    private final RotatableCoverBlock.Crossed crossed;

    public CoverBoardsSet(@NotNull class_2960 id, @NotNull FabricItemSettings defaultItemSettings, @NotNull FabricBlockSettings defaultBlockSettings) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)defaultItemSettings, (String)"defaultItemSettings");
        Intrinsics.checkNotNullParameter((Object)defaultBlockSettings, (String)"defaultBlockSettings");
        super(id, defaultItemSettings, defaultBlockSettings);
        this.single = (RotatableCoverBlock.Normal)FeatureSet.registerBlockWithItem$default(this, this.getName() + "_cover_board", new RotatableCoverBlock.Normal(defaultBlockSettings), null, 4, null);
        this.double = (RotatableCoverBlock.Normal)FeatureSet.registerBlockWithItem$default(this, "double_" + this.getName() + "_cover_boards", new RotatableCoverBlock.Normal(defaultBlockSettings), null, 4, null);
        this.crossed = (RotatableCoverBlock.Crossed)FeatureSet.registerBlockWithItem$default(this, "crossed_" + this.getName() + "_cover_boards", new RotatableCoverBlock.Crossed(defaultBlockSettings), null, 4, null);
    }

    public /* synthetic */ CoverBoardsSet(class_2960 class_29602, FabricItemSettings fabricItemSettings, FabricBlockSettings fabricBlockSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            fabricBlockSettings = (FabricBlockSettings)ModBlocksAndItemsKt.noZFighting((class_4970.class_2251)FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10161)));
        }
        this(class_29602, fabricItemSettings, fabricBlockSettings);
    }

    @NotNull
    public final RotatableCoverBlock.Normal getSingle() {
        return this.single;
    }

    @NotNull
    public final RotatableCoverBlock.Normal getDouble() {
        return this.double;
    }

    @NotNull
    public final RotatableCoverBlock.Crossed getCrossed() {
        return this.crossed;
    }

    @Override
    @NotNull
    public CoverBoardsSet register() {
        return this;
    }
}

