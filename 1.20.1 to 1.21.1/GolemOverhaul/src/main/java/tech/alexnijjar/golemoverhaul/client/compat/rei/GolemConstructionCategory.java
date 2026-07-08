/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.shedaniel.math.Point
 *  me.shedaniel.math.Rectangle
 *  me.shedaniel.rei.api.client.gui.Renderer
 *  me.shedaniel.rei.api.client.gui.widgets.Widget
 *  me.shedaniel.rei.api.client.gui.widgets.Widgets
 *  me.shedaniel.rei.api.client.registry.display.DisplayCategory
 *  me.shedaniel.rei.api.common.category.CategoryIdentifier
 *  me.shedaniel.rei.api.common.util.EntryStacks
 *  net.minecraft.class_1935
 *  net.minecraft.class_2561
 */
package tech.alexnijjar.golemoverhaul.client.compat.rei;

import java.util.ArrayList;
import java.util.List;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.class_1935;
import net.minecraft.class_2561;
import tech.alexnijjar.golemoverhaul.client.compat.rei.GolemConstructionDisplay;
import tech.alexnijjar.golemoverhaul.client.compat.rei.GolemConstructionWidget;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantComponents;
import tech.alexnijjar.golemoverhaul.common.registry.ModBlocks;

public class GolemConstructionCategory
implements DisplayCategory<GolemConstructionDisplay> {
    public static final CategoryIdentifier<GolemConstructionDisplay> ID = CategoryIdentifier.of((String)"golemoverhaul", (String)"golem_construction");

    public CategoryIdentifier<? extends GolemConstructionDisplay> getCategoryIdentifier() {
        return ID;
    }

    public class_2561 getTitle() {
        return ConstantComponents.GOLEM_CONSTRUCTION_CATEGORY;
    }

    public Renderer getIcon() {
        return EntryStacks.of((class_1935)((class_1935)ModBlocks.CLAY_GOLEM_STATUE.get()));
    }

    public int getDisplayWidth(GolemConstructionDisplay display) {
        return 180;
    }

    public int getDisplayHeight() {
        return 76;
    }

    public List<Widget> setupDisplay(GolemConstructionDisplay display, Rectangle bounds) {
        ArrayList<Widget> widgets = new ArrayList<Widget>();
        widgets.add(new GolemConstructionWidget(display.recipe(), bounds.x + 47, bounds.y + 58));
        widgets.add((Widget)Widgets.createArrow((Point)new Point(bounds.x + 78, bounds.y + 30)));
        return widgets;
    }
}

