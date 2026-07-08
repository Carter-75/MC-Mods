/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.registry.RegistryEntry
 *  net.minecraft.class_1299
 *  net.minecraft.class_1439$class_4621
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  software.bernie.geckolib.constant.DataTickets
 *  software.bernie.geckolib.core.animatable.model.CoreGeoBone
 *  software.bernie.geckolib.core.animation.AnimationState
 *  software.bernie.geckolib.model.DefaultedEntityGeoModel
 *  software.bernie.geckolib.model.data.EntityModelData
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import java.util.Optional;
import net.minecraft.class_1299;
import net.minecraft.class_1439;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;

public class BaseGolemModel<T extends BaseGolem>
extends DefaultedEntityGeoModel<T> {
    private final boolean turnsHead;
    private final int maxHeadRotation;
    private final class_2960 textureDamaged;
    private final class_2960 textureVeryDamaged;

    public BaseGolemModel(RegistryEntry<class_1299<T>> golem, boolean turnsHead, int maxHeadRotation) {
        this(BaseGolemRenderer.name(golem), BaseGolemRenderer.texture(golem), BaseGolemRenderer.name(golem), turnsHead, maxHeadRotation);
    }

    public BaseGolemModel(class_2960 model, class_2960 texture, class_2960 animation, boolean turnsHead, int maxHeadRotation) {
        this(model, new class_2960(texture.method_12836(), "%s_1".formatted(texture.method_12832())), new class_2960(texture.method_12836(), "textures/entity/%s_2.png".formatted(texture.method_12832())), new class_2960(texture.method_12836(), "textures/entity/%s_3.png".formatted(texture.method_12832())), animation, turnsHead, maxHeadRotation);
    }

    public BaseGolemModel(class_2960 model, class_2960 texture, class_2960 textureDamaged, class_2960 textureVeryDamaged, class_2960 animation, boolean turnsHead, int maxHeadRotation) {
        super(model, turnsHead);
        this.withAltTexture(texture);
        this.withAltAnimations(animation);
        this.turnsHead = turnsHead;
        this.textureDamaged = textureDamaged;
        this.textureVeryDamaged = textureVeryDamaged;
        this.maxHeadRotation = maxHeadRotation;
    }

    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> animationState) {
        if (!this.turnsHead) {
            return;
        }
        CoreGeoBone head = this.getAnimationProcessor().getBone("head_rotation");
        if (head == null) {
            return;
        }
        if (head.getChildBones().isEmpty()) {
            return;
        }
        Optional headRotation = head.getChildBones().stream().findFirst();
        if (headRotation.isEmpty()) {
            return;
        }
        EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        ((CoreGeoBone)headRotation.get()).setRotX(class_3532.method_15363((float)entityData.headPitch(), (float)(-this.maxHeadRotation), (float)this.maxHeadRotation) * ((float)Math.PI / 180));
        ((CoreGeoBone)headRotation.get()).setRotY(class_3532.method_15363((float)entityData.netHeadYaw(), (float)(-this.maxHeadRotation), (float)this.maxHeadRotation) * ((float)Math.PI / 180));
    }

    public class_2960 getTextureResource(T golem) {
        return switch (((BaseGolem)((Object)golem)).getCrackiness()) {
            default -> throw new IncompatibleClassChangeError();
            case class_1439.class_4621.field_21081, class_1439.class_4621.field_21082 -> super.getTextureResource(golem);
            case class_1439.class_4621.field_21083 -> this.textureDamaged;
            case class_1439.class_4621.field_21084 -> this.textureVeryDamaged;
        };
    }
}

