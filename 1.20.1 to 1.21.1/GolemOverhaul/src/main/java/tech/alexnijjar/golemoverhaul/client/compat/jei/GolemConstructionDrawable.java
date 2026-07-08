/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.gui.drawable.IDrawable
 *  net.minecraft.class_332
 */
package tech.alexnijjar.golemoverhaul.client.compat.jei;

import mezz.jei.api.gui.drawable.IDrawable;
import net.minecraft.class_332;
import tech.alexnijjar.golemoverhaul.client.compat.GolemConstructionRenderer;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;

public class GolemConstructionDrawable
implements IDrawable {
    private final double mouseX;
    private final double mouseY;
    private final GolemConstructionRenderer renderer;

    public GolemConstructionDrawable(double mouseX, double mouseY, GolemConstructionRecipe recipe, int x, int y) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.renderer = new GolemConstructionRenderer(recipe, x, y);
    }

    public int getWidth() {
        return this.renderer.getWidth();
    }

    public int getHeight() {
        return this.renderer.getHeight();
    }

    public void draw(class_332 graphics, int xOffset, int yOffset) {
        this.renderer.render(graphics, (int)this.mouseX, (int)this.mouseY);
    }
}

