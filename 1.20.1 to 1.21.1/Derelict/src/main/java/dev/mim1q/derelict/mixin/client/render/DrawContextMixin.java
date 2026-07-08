/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function6
 *  net.minecraft.class_1309
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2960
 *  net.minecraft.class_332
 *  net.minecraft.class_4587
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package dev.mim1q.derelict.mixin.client.render;

import dev.mim1q.derelict.config.DerelictConfigs;
import dev.mim1q.derelict.tag.ModItemTags;
import dev.mim1q.derelict.util.BlockMarkerUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_332.class})
public abstract class DrawContextMixin {
    @Shadow
    @Final
    private class_4587 field_44657;

    @Shadow
    abstract void method_48466(class_2960 var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14);

    @Inject(method={"drawItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;IIII)V"}, at={@At(value="TAIL")})
    void derelict$injectDrawItem(class_1309 entity, class_1937 world, class_1799 stack, int x, int y, int seed, int z, CallbackInfo ci) {
        if (stack.method_31573(ModItemTags.INSTANCE.getWAXED()) && DerelictConfigs.CLIENT_CONFIG.waxedIndicatorOpacity() > 0.0f) {
            BlockMarkerUtils.INSTANCE.renderWaxedIndicator((Function6<? super class_2960, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Float, Unit>)((Function6)this::derelict$drawTexture), x, y);
        }
    }

    @Unique
    public Unit derelict$drawTexture(class_2960 texture, int x, int y, int z, int size, float alpha) {
        this.field_44657.method_22903();
        this.field_44657.method_46416(0.0f, 0.0f, (float)z);
        this.method_48466(texture, x, x + size, y, y + size, 0, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, alpha);
        this.field_44657.method_22909();
        return Unit.INSTANCE;
    }
}

