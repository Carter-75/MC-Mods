/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1308
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_922
 *  net.minecraft.class_927
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.client.entities.renderer;

import net.minecraft.class_1308;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_922;
import net.minecraft.class_927;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_927.class})
public abstract class MobRendererMixin<T extends class_1308, M extends class_583<T>>
extends class_922<T, M> {
    @Unique
    protected M defaultModel;
    @Unique
    protected class_5617.class_5618 context;

    public MobRendererMixin(class_5617.class_5618 context, M model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void vb$init(class_5617.class_5618 context, M model, float shadowRadius, CallbackInfo ci) {
        this.context = context;
        this.defaultModel = model;
    }
}

