/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager$class_4534
 *  com.mojang.blaze3d.platform.GlStateManager$class_4535
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_156
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_290
 *  net.minecraft.class_293
 *  net.minecraft.class_293$class_5596
 *  net.minecraft.class_2960
 *  net.minecraft.class_4668$class_4671
 *  net.minecraft.class_4668$class_4683
 *  net.minecraft.class_4668$class_4685
 *  net.minecraft.class_4668$class_4686
 *  net.minecraft.class_4668$class_5939
 *  net.minecraft.class_4668$class_5942
 *  net.minecraft.class_757
 */
package tech.alexnijjar.golemoverhaul.client.utils;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Function;
import net.minecraft.class_156;
import net.minecraft.class_1921;
import net.minecraft.class_290;
import net.minecraft.class_293;
import net.minecraft.class_2960;
import net.minecraft.class_4668;
import net.minecraft.class_757;

public class ModRenderTypes {
    private static final class_4668.class_5942 RENDERTYPE_EYES_SHADER = new class_4668.class_5942(class_757::method_34515);
    private static final class_4668.class_4685 ADDITIVE_TRANSPARENCY = new class_4668.class_4685("additive_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFunc((GlStateManager.class_4535)GlStateManager.class_4535.ONE, (GlStateManager.class_4534)GlStateManager.class_4534.ONE);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });
    private static final class_4668.class_4686 COLOR_WRITE = new class_4668.class_4686(true, false);
    private static final class_4668.class_4671 NO_CULL = new class_4668.class_4671(false);
    private static final Function<class_2960, class_1921> EYES_NO_CULL = class_156.method_34866(texture -> {
        class_4668.class_4683 textureState = new class_4668.class_4683(texture, false, false);
        return class_1921.method_24049((String)"eyes_no_cull", (class_293)class_290.field_1580, (class_293.class_5596)class_293.class_5596.field_27382, (int)256, (boolean)false, (boolean)true, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34578(RENDERTYPE_EYES_SHADER).method_34577((class_4668.class_5939)textureState).method_23615(ADDITIVE_TRANSPARENCY).method_23616(COLOR_WRITE).method_23603(NO_CULL).method_23617(false));
    });

    public static class_1921 eyesNoCull(class_2960 texture) {
        return EYES_NO_CULL.apply(texture);
    }
}

