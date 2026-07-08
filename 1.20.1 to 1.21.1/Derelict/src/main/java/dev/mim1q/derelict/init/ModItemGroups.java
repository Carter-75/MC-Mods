/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.itemgroup.Icon
 *  io.wispforest.owo.itemgroup.OwoItemGroup
 *  io.wispforest.owo.itemgroup.gui.ItemGroupTab
 *  io.wispforest.owo.itemgroup.gui.ItemGroupTab$ContentSupplier
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1761$class_7704
 *  net.minecraft.class_1761$class_8128
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupTab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1761;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u001a\u0010\u000f\u001a\u00020\u000e8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2={"Ldev/mim1q/derelict/init/ModItemGroups;", "", "<init>", "()V", "", "Ldev/mim1q/derelict/init/ModBlocksAndItems$ItemCategory;", "categories", "Lio/wispforest/owo/itemgroup/gui/ItemGroupTab$ContentSupplier;", "supplyCategories", "([Ldev/mim1q/derelict/init/ModBlocksAndItems$ItemCategory;)Lio/wispforest/owo/itemgroup/gui/ItemGroupTab$ContentSupplier;", "Lnet/minecraft/class_2960;", "ITEM_GROUP_TEXTURE", "Lnet/minecraft/class_2960;", "TAB_TEXTURE", "Lio/wispforest/owo/itemgroup/OwoItemGroup;", "ITEM_GROUP", "Lio/wispforest/owo/itemgroup/OwoItemGroup;", "getITEM_GROUP$derelict", "()Lio/wispforest/owo/itemgroup/OwoItemGroup;", "derelict"})
@SourceDebugExtension(value={"SMAP\nModItemGroups.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModItemGroups.kt\ndev/mim1q/derelict/init/ModItemGroups\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n11102#2:47\n11437#2,2:48\n11439#2:54\n1557#3:50\n1628#3,3:51\n*S KotlinDebug\n*F\n+ 1 ModItemGroups.kt\ndev/mim1q/derelict/init/ModItemGroups\n*L\n41#1:47\n41#1:48,2\n41#1:54\n41#1:50\n41#1:51,3\n*E\n"})
public final class ModItemGroups {
    @NotNull
    public static final ModItemGroups INSTANCE;
    @NotNull
    private static final class_2960 ITEM_GROUP_TEXTURE;
    @NotNull
    private static final class_2960 TAB_TEXTURE;
    @NotNull
    private static final OwoItemGroup ITEM_GROUP;

    private ModItemGroups() {
    }

    @NotNull
    public final OwoItemGroup getITEM_GROUP$derelict() {
        return ITEM_GROUP;
    }

    private final ItemGroupTab.ContentSupplier supplyCategories(ModBlocksAndItems.ItemCategory ... categories) {
        return (arg_0, arg_1) -> ModItemGroups.supplyCategories$lambda$4(categories, arg_0, arg_1);
    }

    private static final Icon ITEM_GROUP$lambda$0() {
        return Icon.of((class_1799)ModBlocksAndItems.INSTANCE.getFLICKERING_REDSTONE_LAMP().method_8389().method_7854());
    }

    /*
     * WARNING - void declaration
     */
    private static final void supplyCategories$lambda$4(ModBlocksAndItems.ItemCategory[] $categories, class_1761.class_8128 class_81282, class_1761.class_7704 entries) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter((Object)$categories, (String)"$categories");
        ModBlocksAndItems.ItemCategory[] itemCategoryArray = $categories;
        class_1761.class_7704 class_77042 = entries;
        boolean $i$f$map = false;
        void var5_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(((void)$this$map$iv).length);
        boolean $i$f$mapTo = false;
        int n = ((void)$this$mapTo$iv$iv).length;
        for (int i = 0; i < n; ++i) {
            void $this$mapTo$iv$iv2;
            void category;
            void item$iv$iv;
            void var11_12 = item$iv$iv = $this$mapTo$iv$iv[i];
            Collection collection = destination$iv$iv;
            boolean bl = false;
            Iterable $this$map$iv2 = category.getItems();
            boolean $i$f$map2 = false;
            Iterable iterable = $this$map$iv2;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv2, (int)10));
            boolean $i$f$mapTo2 = false;
            for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                void item;
                class_1792 class_17922 = (class_1792)item$iv$iv2;
                Collection collection2 = destination$iv$iv2;
                boolean bl2 = false;
                collection2.add(item.method_7854());
            }
            collection.add((List)destination$iv$iv2);
        }
        class_77042.method_45423((Collection)CollectionsKt.flatten((Iterable)((List)destination$iv$iv)));
    }

    static {
        OwoItemGroup owoItemGroup;
        INSTANCE = new ModItemGroups();
        ITEM_GROUP_TEXTURE = Derelict.INSTANCE.id("textures/gui/item_group_background.png");
        TAB_TEXTURE = Derelict.INSTANCE.id("textures/gui/tabs.png");
        OwoItemGroup $this$ITEM_GROUP_u24lambda_u241 = owoItemGroup = OwoItemGroup.builder((class_2960)Derelict.INSTANCE.id("derelict"), ModItemGroups::ITEM_GROUP$lambda$0).customTexture(ITEM_GROUP_TEXTURE).build();
        boolean bl = false;
        ModBlocksAndItems.ItemCategory[] itemCategoryArray = new ModBlocksAndItems.ItemCategory[]{ModBlocksAndItems.ItemCategory.GENERAL, ModBlocksAndItems.ItemCategory.SPAWN_EGGS, ModBlocksAndItems.ItemCategory.METAL_BLOCKS, ModBlocksAndItems.ItemCategory.METAL_DECORATION, ModBlocksAndItems.ItemCategory.WAXED_METAL_BLOCKS, ModBlocksAndItems.ItemCategory.WAXED_METAL_DECORATION};
        $this$ITEM_GROUP_u24lambda_u241.tabs.add(0, new ItemGroupTab(Icon.of((class_1935)((class_1935)ModBlocksAndItems.INSTANCE.getFLICKERING_LANTERN())), (class_2561)class_2561.method_43471((String)"itemGroup.derelict.derelict.tab.general"), INSTANCE.supplyCategories(itemCategoryArray), TAB_TEXTURE, true));
        $this$ITEM_GROUP_u24lambda_u241.initialize();
        OwoItemGroup owoItemGroup2 = owoItemGroup;
        Intrinsics.checkNotNullExpressionValue((Object)owoItemGroup2, (String)"apply(...)");
        ITEM_GROUP = owoItemGroup2;
    }
}

