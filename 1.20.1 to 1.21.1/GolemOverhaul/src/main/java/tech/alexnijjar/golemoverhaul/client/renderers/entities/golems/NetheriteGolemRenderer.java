/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_5617$class_5618
 *  software.bernie.geckolib.renderer.GeoRenderer
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems;

import net.minecraft.class_1297;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_5617;
import software.bernie.geckolib.renderer.GeoRenderer;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemModel;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.layers.NetheriteGolemFireLayer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.layers.NetheriteGolemGoldLayer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.NetheriteGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class NetheriteGolemRenderer
extends BaseGolemRenderer<NetheriteGolem> {
    public static final class_2960 GOLD_OVERLAY = GolemOverhaul.asResource("textures/entity/netherite/netherite_golem_gold_overlay.png");
    public static final class_2960 CHARGED_OVERLAY = GolemOverhaul.asResource("textures/entity/netherite/netherite_golem_charged_glow.png");
    public static final class_2960 CHARGED_OVERLAY_OPEN = GolemOverhaul.asResource("textures/entity/netherite/netherite_golem_charged_glow_open.png");

    public NetheriteGolemRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, new BaseGolemModel<NetheriteGolem>(ModEntityTypes.NETHERITE_GOLEM, true, 10));
        this.withScale(1.2f);
        this.addRenderLayer(new NetheriteGolemGoldLayer((GeoRenderer<NetheriteGolem>)this));
        this.addRenderLayer(new NetheriteGolemFireLayer((GeoRenderer<NetheriteGolem>)this));
    }

    protected void applyRotations(NetheriteGolem golem, class_4587 poseStack, float ageInTicks, float rotationYaw, float partialTick) {
        int deathTime = golem.field_6213;
        golem.field_6213 = 0;
        super.applyRotations((class_1297)golem, poseStack, ageInTicks, rotationYaw, partialTick);
        golem.field_6213 = deathTime;
    }
}

