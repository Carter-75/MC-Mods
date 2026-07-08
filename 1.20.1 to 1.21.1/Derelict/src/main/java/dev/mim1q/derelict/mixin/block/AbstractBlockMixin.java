/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3726
 *  net.minecraft.class_3727
 *  net.minecraft.class_4970
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package dev.mim1q.derelict.mixin.block;

import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.interfaces.AbstractBlockAccessor;
import dev.mim1q.derelict.tag.ModBlockTags;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_3727;
import net.minecraft.class_4970;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_4970.class})
public abstract class AbstractBlockMixin
implements AbstractBlockAccessor {
    @Unique
    private boolean waxable = false;
    @Unique
    private boolean ageable = false;

    @Override
    public boolean isWaxable() {
        return this.waxable;
    }

    @Override
    public void setWaxable(boolean value) {
        this.waxable = value;
    }

    @Override
    public boolean isAgeable() {
        return this.ageable;
    }

    @Override
    public void setAgeable(boolean value) {
        this.ageable = value;
    }

    @Inject(method={"getCollisionShape"}, at={@At(value="HEAD")}, cancellable=true)
    private void derelict$getCollisionShape(class_2680 state, class_1922 world, class_2338 pos, class_3726 context, CallbackInfoReturnable<class_265> cir) {
        if (state.method_26164(ModBlockTags.INSTANCE.getFULL_COBWEBS()) && AbstractBlockMixin.derelict$shouldBeSolid(pos, context)) {
            cir.setReturnValue((Object)class_259.method_1077());
        }
    }

    @Unique
    private static boolean derelict$shouldBeSolid(class_2338 pos, class_3726 ctx) {
        class_3727 entityCtx;
        class_1297 class_12972;
        if (ctx instanceof class_3727 && (class_12972 = (entityCtx = (class_3727)ctx).method_32480()) instanceof class_1657) {
            class_1657 player = (class_1657)class_12972;
            return ctx.method_16192(class_259.method_1077(), pos, false) && player.method_6118(class_1304.field_6172).method_31574((class_1792)ModBlocksAndItems.INSTANCE.getNETWALKERS()) && !player.method_5715();
        }
        return false;
    }
}

