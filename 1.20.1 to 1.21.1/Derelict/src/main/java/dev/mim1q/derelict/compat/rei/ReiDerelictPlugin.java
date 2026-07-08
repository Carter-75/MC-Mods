/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  me.shedaniel.math.Point
 *  me.shedaniel.math.Rectangle
 *  me.shedaniel.rei.api.client.gui.widgets.Widget
 *  me.shedaniel.rei.api.client.gui.widgets.Widgets
 *  me.shedaniel.rei.api.client.plugins.REIClientPlugin
 *  me.shedaniel.rei.api.client.registry.category.CategoryRegistry
 *  me.shedaniel.rei.api.client.registry.display.DisplayCategory
 *  me.shedaniel.rei.api.client.registry.display.DisplayRegistry
 *  me.shedaniel.rei.api.common.category.CategoryIdentifier
 *  me.shedaniel.rei.api.common.display.Display
 *  me.shedaniel.rei.api.common.display.basic.BasicDisplay
 *  me.shedaniel.rei.api.common.entry.EntryIngredient
 *  me.shedaniel.rei.api.common.entry.EntryStack
 *  me.shedaniel.rei.api.common.util.EntryStacks
 *  me.shedaniel.rei.plugin.client.DefaultClientPlugin
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_5250
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.compat.rei;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.item.StaffItemKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.client.DefaultClientPlugin;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_5250;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2={"Ldev/mim1q/derelict/compat/rei/ReiDerelictPlugin;", "Lme/shedaniel/rei/api/client/plugins/REIClientPlugin;", "<init>", "()V", "Lme/shedaniel/rei/api/client/registry/category/CategoryRegistry;", "registry", "", "registerCategories", "(Lme/shedaniel/rei/api/client/registry/category/CategoryRegistry;)V", "Lme/shedaniel/rei/api/client/registry/display/DisplayRegistry;", "registerDisplays", "(Lme/shedaniel/rei/api/client/registry/display/DisplayRegistry;)V", "Lme/shedaniel/rei/api/common/category/CategoryIdentifier;", "Ldev/mim1q/derelict/compat/rei/ReiDerelictPlugin$DefaultAgingDisplay;", "AGING_CATEGORY_ID", "Lme/shedaniel/rei/api/common/category/CategoryIdentifier;", "getAGING_CATEGORY_ID", "()Lme/shedaniel/rei/api/common/category/CategoryIdentifier;", "DefaultAgingDisplay", "AgingCategory", "derelict"})
@SourceDebugExtension(value={"SMAP\nReiDerelictPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReiDerelictPlugin.kt\ndev/mim1q/derelict/compat/rei/ReiDerelictPlugin\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,78:1\n216#2,2:79\n*S KotlinDebug\n*F\n+ 1 ReiDerelictPlugin.kt\ndev/mim1q/derelict/compat/rei/ReiDerelictPlugin\n*L\n36#1:79,2\n*E\n"})
public final class ReiDerelictPlugin
implements REIClientPlugin {
    @NotNull
    public static final ReiDerelictPlugin INSTANCE = new ReiDerelictPlugin();
    @NotNull
    private static final CategoryIdentifier<DefaultAgingDisplay> AGING_CATEGORY_ID;

    private ReiDerelictPlugin() {
    }

    @NotNull
    public final CategoryIdentifier<DefaultAgingDisplay> getAGING_CATEGORY_ID() {
        return AGING_CATEGORY_ID;
    }

    public void registerCategories(@NotNull CategoryRegistry registry) {
        Intrinsics.checkNotNullParameter((Object)registry, (String)"registry");
        registry.add((DisplayCategory)AgingCategory.INSTANCE);
        EntryStack[] entryStackArray = new EntryStack[]{EntryStacks.of((class_1935)((class_1935)ModBlocksAndItems.INSTANCE.getAGING_STAFF()))};
        registry.addWorkstations(AGING_CATEGORY_ID, entryStackArray);
        entryStackArray = new EntryStack[]{EntryStacks.of((class_1935)((class_1935)ModBlocksAndItems.INSTANCE.getWAXING_STAFF()))};
        registry.addWorkstations(DefaultClientPlugin.WAXING, entryStackArray);
    }

    public void registerDisplays(@NotNull DisplayRegistry registry) {
        Intrinsics.checkNotNullParameter((Object)registry, (String)"registry");
        Map<class_2248, class_2248> $this$forEach$iv = StaffItemKt.getFullAgingMap();
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<class_2248, class_2248>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<class_2248, class_2248> element$iv;
            Map.Entry<class_2248, class_2248> it = element$iv = iterator.next();
            boolean bl = false;
            registry.add((Display)new DefaultAgingDisplay((class_1935)it.getKey(), (class_1935)it.getValue()));
        }
    }

    static {
        CategoryIdentifier categoryIdentifier = CategoryIdentifier.of((class_2960)Derelict.INSTANCE.id("aging"));
        Intrinsics.checkNotNullExpressionValue((Object)categoryIdentifier, (String)"of(...)");
        AGING_CATEGORY_ID = categoryIdentifier;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"Ldev/mim1q/derelict/compat/rei/ReiDerelictPlugin$AgingCategory;", "Lme/shedaniel/rei/api/client/registry/display/DisplayCategory;", "Ldev/mim1q/derelict/compat/rei/ReiDerelictPlugin$DefaultAgingDisplay;", "<init>", "()V", "Lme/shedaniel/rei/api/common/category/CategoryIdentifier;", "getCategoryIdentifier", "()Lme/shedaniel/rei/api/common/category/CategoryIdentifier;", "Lme/shedaniel/rei/api/common/entry/EntryStack;", "Lnet/minecraft/class_1799;", "getIcon", "()Lme/shedaniel/rei/api/common/entry/EntryStack;", "Lnet/minecraft/class_2561;", "getTitle", "()Lnet/minecraft/class_2561;", "display", "Lme/shedaniel/math/Rectangle;", "bounds", "", "Lme/shedaniel/rei/api/client/gui/widgets/Widget;", "setupDisplay", "(Ldev/mim1q/derelict/compat/rei/ReiDerelictPlugin$DefaultAgingDisplay;Lme/shedaniel/math/Rectangle;)Ljava/util/List;", "", "getDisplayHeight", "()I", "derelict"})
    public static final class AgingCategory
    implements DisplayCategory<DefaultAgingDisplay> {
        @NotNull
        public static final AgingCategory INSTANCE = new AgingCategory();

        private AgingCategory() {
        }

        @NotNull
        public CategoryIdentifier<DefaultAgingDisplay> getCategoryIdentifier() {
            return INSTANCE.getAGING_CATEGORY_ID();
        }

        @NotNull
        public EntryStack<class_1799> getIcon() {
            EntryStack entryStack = EntryStacks.of((class_1935)((class_1935)ModBlocksAndItems.INSTANCE.getAGING_STAFF()));
            Intrinsics.checkNotNullExpressionValue((Object)entryStack, (String)"of(...)");
            return entryStack;
        }

        @NotNull
        public class_2561 getTitle() {
            class_5250 class_52502 = class_2561.method_43471((String)"category.derelict.aging");
            Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"translatable(...)");
            return (class_2561)class_52502;
        }

        @NotNull
        public List<Widget> setupDisplay(@NotNull DefaultAgingDisplay display, @NotNull Rectangle bounds) {
            Intrinsics.checkNotNullParameter((Object)((Object)display), (String)"display");
            Intrinsics.checkNotNullParameter((Object)bounds, (String)"bounds");
            Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
            Object[] objectArray = new Widget[]{Widgets.createRecipeBase((Rectangle)bounds), Widgets.createArrow((Point)new Point(startPoint.x + 27, startPoint.y + 4)), Widgets.createResultSlotBackground((Point)new Point(startPoint.x + 61, startPoint.y + 5)), Widgets.createSlot((Point)new Point(startPoint.x + 4, startPoint.y + 5)).entries((Collection)display.getInputEntries().get(0)).markInput(), Widgets.createSlot((Point)new Point(startPoint.x + 61, startPoint.y + 5)).entries((Collection)display.getOutputEntries().get(0)).disableBackground().markOutput()};
            return CollectionsKt.listOf((Object[])objectArray);
        }

        public int getDisplayHeight() {
            return 36;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u0006\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Ldev/mim1q/derelict/compat/rei/ReiDerelictPlugin$DefaultAgingDisplay;", "Lme/shedaniel/rei/api/common/display/basic/BasicDisplay;", "", "Lme/shedaniel/rei/api/common/entry/EntryIngredient;", "inputs", "outputs", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Lnet/minecraft/class_1935;", "input", "output", "(Lnet/minecraft/class_1935;Lnet/minecraft/class_1935;)V", "Lme/shedaniel/rei/api/common/category/CategoryIdentifier;", "getCategoryIdentifier", "()Lme/shedaniel/rei/api/common/category/CategoryIdentifier;", "derelict"})
    public static final class DefaultAgingDisplay
    extends BasicDisplay {
        private DefaultAgingDisplay(List<? extends EntryIngredient> inputs, List<? extends EntryIngredient> outputs) {
            super(inputs, outputs);
        }

        public DefaultAgingDisplay(@NotNull class_1935 input, @NotNull class_1935 output) {
            Intrinsics.checkNotNullParameter((Object)input, (String)"input");
            Intrinsics.checkNotNullParameter((Object)output, (String)"output");
            this(CollectionsKt.listOf((Object)EntryIngredient.of((EntryStack)EntryStacks.of((class_1935)input))), CollectionsKt.listOf((Object)EntryIngredient.of((EntryStack)EntryStacks.of((class_1935)output))));
        }

        @NotNull
        public CategoryIdentifier<DefaultAgingDisplay> getCategoryIdentifier() {
            return INSTANCE.getAGING_CATEGORY_ID();
        }
    }
}

