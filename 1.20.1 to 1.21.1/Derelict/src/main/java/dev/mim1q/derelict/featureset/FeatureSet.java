/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.item.v1.FabricItemSettings
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.minecraft.class_1792
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.featureset;

import dev.mim1q.derelict.init.ModBlocksAndItems;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_1792;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0004\u00a2\u0006\u0004\b\u0003\u0010\fJ\u000f\u0010\r\u001a\u00020\u0000H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\u0010*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00028\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0019\u001a\u00028\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00028\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0004\u00a2\u0006\u0004\b\u0007\u0010\u001dR\u001a\u0010\u0005\u001a\u00020\u00048\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!R\"\u0010\u000b\u001a\n \"*\u0004\u0018\u00010\n0\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010%R\"\u0010&\u001a\n \"*\u0004\u0018\u00010\n0\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%\u00a8\u0006("}, d2={"Ldev/mim1q/derelict/featureset/FeatureSet;", "", "Lnet/minecraft/class_2960;", "id", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "defaultItemSettings", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "defaultBlockSettings", "<init>", "(Lnet/minecraft/class_2960;Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "", "name", "(Ljava/lang/String;)Lnet/minecraft/class_2960;", "register", "()Ldev/mim1q/derelict/featureset/FeatureSet;", "Lnet/minecraft/class_1792;", "I", "item", "Ldev/mim1q/derelict/init/ModBlocksAndItems$ItemCategory;", "category", "registerItem", "(Ljava/lang/String;Lnet/minecraft/class_1792;Ldev/mim1q/derelict/init/ModBlocksAndItems$ItemCategory;)Lnet/minecraft/class_1792;", "Lnet/minecraft/class_2248;", "B", "block", "registerBlock", "(Ljava/lang/String;Lnet/minecraft/class_2248;)Lnet/minecraft/class_2248;", "registerBlockWithItem", "(Ljava/lang/String;Lnet/minecraft/class_2248;Ldev/mim1q/derelict/init/ModBlocksAndItems$ItemCategory;)Lnet/minecraft/class_2248;", "()Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "getDefaultItemSettings", "()Lnet/fabricmc/fabric/api/item/v1/FabricItemSettings;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "namespace", "getNamespace", "derelict"})
public abstract class FeatureSet {
    @NotNull
    private final FabricItemSettings defaultItemSettings;
    @NotNull
    private final FabricBlockSettings defaultBlockSettings;
    private final String name;
    private final String namespace;

    public FeatureSet(@NotNull class_2960 id, @NotNull FabricItemSettings defaultItemSettings, @NotNull FabricBlockSettings defaultBlockSettings) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)defaultItemSettings, (String)"defaultItemSettings");
        Intrinsics.checkNotNullParameter((Object)defaultBlockSettings, (String)"defaultBlockSettings");
        this.defaultItemSettings = defaultItemSettings;
        this.defaultBlockSettings = defaultBlockSettings;
        this.name = id.method_12832();
        this.namespace = id.method_12836();
    }

    public /* synthetic */ FeatureSet(class_2960 class_29602, FabricItemSettings fabricItemSettings, FabricBlockSettings fabricBlockSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            fabricItemSettings = new FabricItemSettings();
        }
        if ((n & 4) != 0) {
            fabricBlockSettings = FabricBlockSettings.copyOf((class_4970)((class_4970)class_2246.field_10340));
        }
        this(class_29602, fabricItemSettings, fabricBlockSettings);
    }

    @NotNull
    protected final FabricItemSettings getDefaultItemSettings() {
        return this.defaultItemSettings;
    }

    protected final String getName() {
        return this.name;
    }

    protected final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    protected final class_2960 id(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return new class_2960(this.namespace, name);
    }

    @NotNull
    public FeatureSet register() {
        return this;
    }

    @NotNull
    protected final <I extends class_1792> I registerItem(@NotNull String name, @NotNull I item, @NotNull ModBlocksAndItems.ItemCategory category) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(item, (String)"item");
        Intrinsics.checkNotNullParameter((Object)((Object)category), (String)"category");
        return ModBlocksAndItems.INSTANCE.registerItem$derelict(name, item, category);
    }

    public static /* synthetic */ class_1792 registerItem$default(FeatureSet featureSet, String string, class_1792 class_17922, ModBlocksAndItems.ItemCategory itemCategory, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerItem");
        }
        if ((n & 4) != 0) {
            itemCategory = ModBlocksAndItems.ItemCategory.GENERAL;
        }
        return featureSet.registerItem(string, class_17922, itemCategory);
    }

    @NotNull
    protected final <B extends class_2248> B registerBlock(@NotNull String name, @NotNull B block) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        return ModBlocksAndItems.INSTANCE.registerBlock$derelict(name, block);
    }

    @NotNull
    protected final <B extends class_2248> B registerBlockWithItem(@NotNull String name, @NotNull B block, @NotNull ModBlocksAndItems.ItemCategory category) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Intrinsics.checkNotNullParameter((Object)((Object)category), (String)"category");
        return ModBlocksAndItems.INSTANCE.register$derelict(name, block, category);
    }

    public static /* synthetic */ class_2248 registerBlockWithItem$default(FeatureSet featureSet, String string, class_2248 class_22482, ModBlocksAndItems.ItemCategory itemCategory, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerBlockWithItem");
        }
        if ((n & 4) != 0) {
            itemCategory = ModBlocksAndItems.ItemCategory.GENERAL;
        }
        return featureSet.registerBlockWithItem(string, class_22482, itemCategory);
    }

    @NotNull
    protected final FabricBlockSettings defaultBlockSettings() {
        FabricBlockSettings fabricBlockSettings = FabricBlockSettings.copyOf((class_4970.class_2251)((class_4970.class_2251)this.defaultBlockSettings));
        Intrinsics.checkNotNullExpressionValue((Object)fabricBlockSettings, (String)"copyOf(...)");
        return fabricBlockSettings;
    }
}

