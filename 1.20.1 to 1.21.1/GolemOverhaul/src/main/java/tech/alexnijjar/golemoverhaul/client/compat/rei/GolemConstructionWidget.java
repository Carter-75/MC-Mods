/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.shedaniel.rei.api.client.gui.widgets.Widget
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  org.jetbrains.annotations.Nullable
 */
package tech.alexnijjar.golemoverhaul.client.compat.rei;

import java.util.List;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import net.minecraft.class_332;
import net.minecraft.class_364;
import org.jetbrains.annotations.Nullable;
import tech.alexnijjar.golemoverhaul.client.compat.GolemConstructionRenderer;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;

public class GolemConstructionWidget
extends Widget {
    private final GolemConstructionRenderer renderer;

    public GolemConstructionWidget(GolemConstructionRecipe recipe, int x, int y) {
        this.renderer = new GolemConstructionRenderer(recipe, x, y);
    }

    public void method_25394(class_332 graphics, int mouseX, int mouseY, float partialTick) {
        this.renderer.render(graphics, mouseX, mouseY);
    }

    public List<? extends class_364> method_25396() {
        return List.of();
    }

    public boolean method_25397() {
        return false;
    }

    public void method_25398(boolean isDragging) {
    }

    @Nullable
    public class_364 method_25399() {
        return null;
    }

    public void method_25395(@Nullable class_364 focused) {
    }
}

