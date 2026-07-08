package mod.universalmobwar.client;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.universalmobwar.entity.MobWarlordEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.monster.witch.WitchModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.WitchRenderState;
import net.minecraft.resources.Identifier;

/**
 * Custom renderer for the Mob Warlord that uses the witch model.
 * This renders the boss as a giant witch without the particle crashes.
 *
 * <p>Ported to MC 26.2: entity renderers now use the render-state pattern.
 * We reuse vanilla {@link WitchRenderState} because {@link WitchModel} is
 * parameterized on it. The warlord's render state is populated by the
 * inherited {@code extractRenderState} chain (LivingEntityRenderer -> MobRenderer),
 * which is sufficient for a witch-shaped boss.
 */
public class MobWarlordRenderer extends MobRenderer<MobWarlordEntity, WitchRenderState, WitchModel> {

    private static final Identifier TEXTURE = Identifier.withDefaultNamespace("textures/entity/witch.png");

    public MobWarlordRenderer(EntityRendererProvider.Context context) {
        super(context, new WitchModel(context.bakeLayer(ModelLayers.WITCH)), 0.5f * 2.0f); // Shadow radius 2x
    }

    @Override
    public WitchRenderState createRenderState() {
        return new WitchRenderState();
    }

    @Override
    public Identifier getTextureLocation(WitchRenderState state) {
        return TEXTURE;
    }

    @Override
    protected void scale(WitchRenderState state, PoseStack poseStack) {
        // Scale the model to 2x size
        poseStack.scale(2.0f, 2.0f, 2.0f);
        super.scale(state, poseStack);
    }
}
