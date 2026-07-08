/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.client.CloseablePoseStack
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2561
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_490
 *  net.minecraft.class_5250
 *  net.minecraft.class_5321
 *  net.minecraft.class_7833
 *  net.minecraft.class_7919
 *  net.minecraft.class_7923
 *  net.minecraft.class_8001
 *  org.joml.Quaternionf
 */
package tech.alexnijjar.golemoverhaul.client.compat;

import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_490;
import net.minecraft.class_5250;
import net.minecraft.class_5321;
import net.minecraft.class_7833;
import net.minecraft.class_7919;
import net.minecraft.class_7923;
import net.minecraft.class_8001;
import org.joml.Quaternionf;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.compat.FakeLevel;
import tech.alexnijjar.golemoverhaul.common.recipes.GolemConstructionRecipe;

public class GolemConstructionRenderer {
    public static final class_2960 TEXTURE = GolemOverhaul.asResource("textures/gui/container/golem_construction.png");
    private final FakeLevel fakeLevel;
    private final class_1297 entity;
    private final int x;
    private final int y;
    private final float blockScale;
    private final float entityScale;
    private final boolean single;
    private final class_5250 blockTooltip = class_2561.method_43473();

    public GolemConstructionRenderer(GolemConstructionRecipe recipe, int x, int y) {
        this.x = x;
        this.y = y;
        this.blockScale = recipe.getBlockScale();
        this.entityScale = recipe.getEntityScale();
        HashMap<class_2338, class_2680> blocks = new HashMap<class_2338, class_2680>();
        this.fakeLevel = new FakeLevel(blocks);
        Optional firstPatternRow = recipe.getPattern().stream().findFirst();
        if (firstPatternRow.isEmpty()) {
            throw new RuntimeException("Recipe contains empty pattern row");
        }
        int width = ((String)firstPatternRow.get()).length();
        int height = recipe.getPattern().size();
        this.single = width == 1 && height == 1;
        for (int i = 0; i < height; ++i) {
            String row = recipe.getPattern().get(i);
            for (int j = 0; j < width; ++j) {
                char c = row.charAt(j);
                class_5321<class_2248> key = recipe.getKey().get(String.valueOf(c));
                if (key == null) {
                    throw new IllegalStateException("Invalid key: " + c);
                }
                if (key.method_29177().equals((Object)class_7923.field_41175.method_10221((Object)class_2246.field_10124))) continue;
                class_2680 state = ((class_2248)class_7923.field_41175.method_31140(key)).method_9564();
                blocks.put(class_2338.method_49637((double)(width - j - 1), (double)(height - i - 1), (double)0.0), state);
                this.blockTooltip.method_10852((class_2561)state.method_26204().method_9518());
                if (i == height - 1) continue;
                this.blockTooltip.method_27693("\n");
            }
        }
        class_1299 type = (class_1299)class_7923.field_41177.method_29107(recipe.getEntity());
        if (type == null) {
            throw new IllegalStateException("Invalid entity: " + String.valueOf(recipe.getEntity()));
        }
        this.entity = type.method_5883((class_1937)Objects.requireNonNull(class_310.method_1551().field_1687));
    }

    public void render(class_332 graphics, int mouseX, int mouseY) {
        this.entity.method_5847(0.0f);
        graphics.method_25290(TEXTURE, this.x - 47, this.y - 58, 0.0f, 0.0f, 180, 76, 180, 76);
        try (CloseablePoseStack pose = new CloseablePoseStack(graphics);){
            pose.method_46416((float)this.x, (float)this.y, 100.0f);
            pose.method_46416(10.0f, -5.0f, 0.0f);
            pose.method_22905(-20.0f, -20.0f, -20.0f);
            pose.method_22905(this.blockScale, this.blockScale, this.blockScale);
            if (this.single) {
                pose.method_22904(0.1, 0.2, 0.0);
            }
            pose.method_22904(0.5, 0.5, 0.5);
            pose.method_22907(class_7833.field_40714.rotationDegrees(-30.0f));
            pose.method_22907(class_7833.field_40716.rotationDegrees(45.0f));
            pose.method_22904(-0.5, -0.5, -0.5);
            this.fakeLevel.renderBlocks(graphics.method_51448());
        }
        pose = new CloseablePoseStack(graphics);
        try {
            pose.method_46416(95.0f, -7.0f, 0.0f);
            Quaternionf ARMOR_STAND_ANGLE = new Quaternionf().rotationXYZ((float)Math.toRadians(30.0), (float)Math.toRadians(135.0), (float)Math.PI);
            class_490.method_48472((class_332)graphics, (int)this.x, (int)this.y, (int)((int)(32.0f * this.entityScale)), (Quaternionf)ARMOR_STAND_ANGLE, null, (class_1309)((class_1309)this.entity));
        }
        finally {
            pose.close();
        }
        class_437 screen = class_310.method_1551().field_1755;
        if (screen == null) {
            return;
        }
        if (mouseX >= this.x + 68 && mouseX < this.x + 120 && mouseY >= this.y - 48 && mouseY < this.y + 8) {
            screen.method_47412(class_7919.method_47407((class_2561)this.entity.method_5477()), class_8001.field_41687, true);
        } else if (mouseX >= this.x - 34 && mouseX < this.x + 18 && mouseY >= this.y - 48 && mouseY < this.y + 8) {
            screen.method_47412(class_7919.method_47407((class_2561)this.blockTooltip), class_8001.field_41687, true);
        }
    }

    public int getWidth() {
        return 180;
    }

    public int getHeight() {
        return 76;
    }
}

