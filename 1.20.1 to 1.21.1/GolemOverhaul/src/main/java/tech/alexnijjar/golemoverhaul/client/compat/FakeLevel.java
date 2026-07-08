/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1920
 *  net.minecraft.class_1921
 *  net.minecraft.class_1944
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_308
 *  net.minecraft.class_310
 *  net.minecraft.class_3568
 *  net.minecraft.class_3610
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4696
 *  net.minecraft.class_6539
 *  net.minecraft.class_776
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 */
package tech.alexnijjar.golemoverhaul.client.compat;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Map;
import java.util.Objects;
import net.minecraft.class_1920;
import net.minecraft.class_1921;
import net.minecraft.class_1944;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_308;
import net.minecraft.class_310;
import net.minecraft.class_3568;
import net.minecraft.class_3610;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4696;
import net.minecraft.class_6539;
import net.minecraft.class_776;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class FakeLevel
implements class_1920 {
    private final Map<class_2338, class_2680> blocks;
    public static final Vector3f SCENE_LIGHT_1 = new Vector3f(1.0f, 0.0f, 1.0f);
    public static final Vector3f SCENE_LIGHT_2 = new Vector3f(-1.0f, 1.0f, -1.0f);

    public FakeLevel(Map<class_2338, class_2680> blocks) {
        this.blocks = blocks;
    }

    public float method_24852(class_2350 direction, boolean shade) {
        return 1.0f;
    }

    public class_3568 method_22336() {
        throw new UnsupportedOperationException();
    }

    public int method_23752(class_2338 blockPos, class_6539 colorResolver) {
        return Objects.requireNonNull(class_310.method_1551().field_1687).method_23752(blockPos, colorResolver);
    }

    public int method_8314(class_1944 lightType, class_2338 blockPos) {
        return 15;
    }

    public int method_22335(class_2338 blockPos, int amount) {
        return 15;
    }

    @Nullable
    public class_2586 method_8321(class_2338 pos) {
        return null;
    }

    public class_2680 method_8320(class_2338 pos) {
        return this.blocks.getOrDefault(pos, class_2246.field_10124.method_9564());
    }

    public class_3610 method_8316(class_2338 pos) {
        return class_2246.field_10124.method_9564().method_26227();
    }

    public int method_31605() {
        return 0;
    }

    public int method_31607() {
        return 0;
    }

    public void renderBlocks(class_4587 poseStack) {
        class_310 mc = class_310.method_1551();
        class_776 dispatcher = mc.method_1541();
        class_4597.class_4598 bufferSource = mc.method_22940().method_23000();
        RenderSystem.setupGui3DDiffuseLighting((Vector3f)SCENE_LIGHT_1, (Vector3f)SCENE_LIGHT_2);
        this.blocks.forEach((pos, state) -> {
            class_1921 renderType = class_4696.method_23683((class_2680)state, (boolean)false);
            class_4588 consumer = bufferSource.getBuffer(renderType);
            poseStack.method_22903();
            poseStack.method_46416((float)pos.method_10263(), (float)pos.method_10264(), (float)pos.method_10260());
            dispatcher.method_3355(state, pos, (class_1920)this, poseStack, consumer, true, Objects.requireNonNull(mc.field_1687).field_9229);
            poseStack.method_22909();
        });
        bufferSource.method_22993();
        class_308.method_24211();
    }
}

