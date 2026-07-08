/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1309
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_5253$class_5254
 *  net.minecraft.class_5597
 *  net.minecraft.class_922
 */
package backported.updates.content.client.level.entities.layer;

import java.util.function.Function;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1309;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5253;
import net.minecraft.class_5597;
import net.minecraft.class_922;

@Environment(value=EnvType.CLIENT)
public class LivingEntityEmissiveLayer<T extends class_1309, M extends class_5597<T>>
extends class_3887<T, M> {
    private final Function<T, class_2960> textureProvider;
    private final AlphaFunction<T> alphaFunction;
    private final M model;
    private final Function<class_2960, class_1921> bufferProvider;
    private final boolean alwaysVisible;

    public LivingEntityEmissiveLayer(class_3883<T, M> renderer, Function<T, class_2960> textureProvider, AlphaFunction<T> alphaFunction, M model, Function<class_2960, class_1921> bufferProvider, boolean alwaysVisible) {
        super(renderer);
        this.textureProvider = textureProvider;
        this.alphaFunction = alphaFunction;
        this.model = model;
        this.bufferProvider = bufferProvider;
        this.alwaysVisible = alwaysVisible;
    }

    public void render(class_4587 poseStack, class_4597 buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        float alpha;
        if ((!entity.method_5767() || this.alwaysVisible) && (alpha = this.alphaFunction.apply(entity, ageInTicks)) > 1.0E-5f) {
            class_1921 renderType = this.bufferProvider.apply(this.textureProvider.apply(entity));
            int color = class_5253.class_5254.method_27764((int)class_3532.method_15375((float)(alpha * 255.0f)), (int)255, (int)255, (int)255);
            this.model.method_2816(entity, limbSwing, limbSwingAmount, partialTick);
            this.model.method_2819(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            this.model.method_2828(poseStack, buffer.getBuffer(renderType), packedLight, class_922.method_23622(entity, (float)0.0f), color);
            ((class_5597)this.method_17165()).method_17081(this.model);
        }
    }

    @Environment(value=EnvType.CLIENT)
    public static interface AlphaFunction<T extends class_1309> {
        public float apply(T var1, float var2);
    }
}

