/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1799
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_583
 */
package backported.updates.content.client.level.entities.layer;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_583;

@Environment(value=EnvType.CLIENT)
public class SimpleEquipmentLayer<T extends class_1309, M extends class_583<T>>
extends class_3887<T, M> {
    private final Map<class_1799, class_2960> textureByItem;
    private final BiPredicate<class_1799, T> itemGetter;
    private final Predicate<T> shouldRender;
    private final class_583<T> model;
    private final class_583<T> babyModel;

    public SimpleEquipmentLayer(class_3883<T, M> renderer, Map<class_1799, class_2960> textureByItem, BiPredicate<class_1799, T> itemGetter, Predicate<T> shouldRender, class_583<T> model, class_583<T> babyModel) {
        super(renderer);
        this.textureByItem = textureByItem;
        this.itemGetter = itemGetter;
        this.shouldRender = shouldRender;
        this.model = model;
        this.babyModel = babyModel;
    }

    public SimpleEquipmentLayer(class_3883<T, M> renderer, Map<class_1799, class_2960> textureByItem, class_1304 slot, Predicate<T> shouldRender, class_583<T> model, class_583<T> babyModel) {
        this(renderer, textureByItem, (class_1799 stack, T entity) -> entity.method_6118(slot).method_31574(stack.method_7909()), shouldRender, model, babyModel);
    }

    public void render(class_4587 pose, class_4597 buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        Optional<class_2960> texture = this.textureByItem.entrySet().stream().filter(entry -> this.itemGetter.test((class_1799)entry.getKey(), (class_1799)entity)).map(Map.Entry::getValue).findFirst();
        if (this.shouldRender.test(entity) && texture.isPresent() && (!entity.method_6109() || this.babyModel != null)) {
            class_583<T> model = entity.method_6109() ? this.babyModel : this.model;
            this.method_17165().method_17081(model);
            model.method_2816(entity, limbSwing, limbSwingAmount, partialTick);
            model.method_2819(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            class_4588 vertices = buffer.getBuffer(class_1921.method_23578((class_2960)texture.get()));
            model.method_60879(pose, vertices, packedLight, class_4608.field_21444);
        }
    }
}

