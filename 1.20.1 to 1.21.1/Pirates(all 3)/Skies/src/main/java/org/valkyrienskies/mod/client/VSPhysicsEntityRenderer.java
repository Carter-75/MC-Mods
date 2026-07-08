/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1308
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  net.minecraft.class_927
 */
package org.valkyrienskies.mod.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1308;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_630;
import net.minecraft.class_927;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.mod.client.VSPhysicsEntityModel;
import org.valkyrienskies.mod.common.IShipObjectWorldClientProvider;
import org.valkyrienskies.mod.common.entity.VSPhysicsEntity;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J?\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2={"Lorg/valkyrienskies/mod/client/VSPhysicsEntityRenderer;", "Lorg/valkyrienskies/mod/common/entity/VSPhysicsEntity;", "T", "Lnet/minecraft/class_927;", "Lorg/valkyrienskies/mod/client/VSPhysicsEntityModel;", "mob", "", "f", "g", "Lnet/minecraft/class_4587;", "poseStack", "Lnet/minecraft/class_4597;", "multiBufferSource", "", "i", "", "render", "(Lorg/valkyrienskies/mod/common/entity/VSPhysicsEntity;FFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "entity", "Lnet/minecraft/class_2960;", "getTextureLocation", "(Lorg/valkyrienskies/mod/common/entity/VSPhysicsEntity;)Lnet/minecraft/class_2960;", "Lnet/minecraft/class_5617$class_5618;", "context", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "valkyrienskies-120"})
public final class VSPhysicsEntityRenderer<T extends VSPhysicsEntity>
extends class_927<T, VSPhysicsEntityModel<T>> {
    public VSPhysicsEntityRenderer(@NotNull class_5617.class_5618 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_630 class_6302 = context.method_32167(VSPhysicsEntityModel.Companion.getLAYER_LOCATION());
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"bakeLayer(...)");
        super(context, (class_583)new VSPhysicsEntityModel(class_6302), 0.0f);
    }

    public void render(@NotNull T mob, float f2, float g2, @NotNull class_4587 poseStack, @NotNull class_4597 multiBufferSource, int i2) {
        Intrinsics.checkNotNullParameter(mob, (String)"mob");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)multiBufferSource, (String)"multiBufferSource");
        class_310 class_3102 = class_310.method_1551();
        Intrinsics.checkNotNull((Object)class_3102, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.common.IShipObjectWorldClientProvider");
        VsiClientShipWorld vsiClientShipWorld = ((IShipObjectWorldClientProvider)class_3102).getShipObjectWorld();
        Intrinsics.checkNotNull((Object)vsiClientShipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.internal.world.VsiClientShipWorld");
        ShipTransform shipTransform = ((VSPhysicsEntity)((Object)mob)).getRenderTransform(vsiClientShipWorld);
        if (shipTransform == null) {
            return;
        }
        ShipTransform renderTransform = shipTransform;
        poseStack.method_22907(new Quaternionf(renderTransform.getShipToWorldRotation()));
        poseStack.method_22904(0.0, -0.5, 0.0);
        super.method_4072((class_1308)mob, f2, g2, poseStack, multiBufferSource, i2);
    }

    @NotNull
    public class_2960 getTextureLocation(@NotNull T entity) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        return new class_2960("valkyrienskies", "textures/test_sphere.png");
    }
}

