/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.chassis.StickerBlock
 *  com.simibubi.create.content.contraptions.chassis.StickerBlockEntity
 *  com.simibubi.create.foundation.block.IBE
 *  com.simibubi.create.foundation.block.WrenchableDirectionalBlock
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_2251
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.block;

import com.simibubi.create.content.contraptions.chassis.StickerBlock;
import com.simibubi.create.content.contraptions.chassis.StickerBlockEntity;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.WrenchableDirectionalBlock;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.IMixinStickerTileEntity;

@Mixin(value={StickerBlock.class})
public abstract class MixinStickerBlock
extends WrenchableDirectionalBlock
implements IBE<StickerBlockEntity> {
    public MixinStickerBlock(class_4970.class_2251 properties) {
        super(properties);
    }

    public void method_9536(@NotNull class_2680 state, @NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_2680 newState, boolean isMoving) {
        IBE.onRemove((class_2680)state, (class_1937)world, (class_2338)pos, (class_2680)newState);
    }

    @Inject(method={"neighborChanged"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/block/state/BlockState;getValue(Lnet/minecraft/world/level/block/state/properties/Property;)Ljava/lang/Comparable;", ordinal=0)}, cancellable=true)
    private void injectNeighbourChanged(class_2680 state, class_1937 worldIn, class_2338 pos, class_2248 blockIn, class_2338 fromPos, boolean isMoving, CallbackInfo ci) {
        IMixinStickerTileEntity iMixinStickerTileEntity;
        StickerBlockEntity ste = (StickerBlockEntity)this.getBlockEntity((class_1922)worldIn, pos);
        if (ste instanceof IMixinStickerTileEntity && (iMixinStickerTileEntity = (IMixinStickerTileEntity)ste).isAlreadyPowered(false)) {
            if (!worldIn.method_49803(pos)) {
                ci.cancel();
            } else {
                iMixinStickerTileEntity.isAlreadyPowered(true);
            }
        }
    }
}

