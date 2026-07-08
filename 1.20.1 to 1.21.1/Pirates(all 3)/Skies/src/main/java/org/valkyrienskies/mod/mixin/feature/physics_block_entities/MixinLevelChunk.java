/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2818
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.feature.physics_block_entities;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.Map;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2818;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.api.BlockEntityPhysicsListener;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.util.PhysicsBlockEntityUtil;

@Mixin(value={class_2818.class})
public abstract class MixinLevelChunk {
    @Shadow
    @Final
    class_1937 field_12858;

    @Inject(method={"updateBlockEntityTicker"}, at={@At(value="HEAD")})
    private <T extends class_2586> void beforeUpdateBlockEntityTicker(T blockEntity, CallbackInfo ci) {
        String dimensionId = ValkyrienSkies.getDimensionId(this.field_12858);
        if (blockEntity instanceof BlockEntityPhysicsListener) {
            BlockEntityPhysicsListener listener = (BlockEntityPhysicsListener)blockEntity;
            listener.setDimension(dimensionId);
            PhysicsBlockEntityUtil.onLoad(listener, blockEntity.method_11016(), this.field_12858, "[ADDED] updateBlockEntityTicker");
        } else {
            PhysicsBlockEntityUtil.onRemove(blockEntity.method_11016(), this.field_12858, "[REMOVED] updateBlockEntityTicker");
        }
    }

    @WrapOperation(method={"clearAllBlockEntities"}, at={@At(value="INVOKE", target="Ljava/util/Map;clear()V")})
    private void beforeClearAllBlockEntities(Map<class_2338, class_2586> blockEntities, Operation<Void> original) {
        blockEntities.forEach((blockPos, blockEntity) -> {
            if (blockEntity instanceof BlockEntityPhysicsListener) {
                BlockEntityPhysicsListener listener = (BlockEntityPhysicsListener)blockEntity;
                PhysicsBlockEntityUtil.onRemove(blockPos, this.field_12858, "clearAllBlockEntities");
            }
        });
        original.call(new Object[]{blockEntities});
    }

    @Inject(method={"removeBlockEntity"}, at={@At(value="TAIL")})
    private void afterRemoveBlockEntity(class_2338 blockPos, CallbackInfo ci) {
        PhysicsBlockEntityUtil.onRemove(blockPos, this.field_12858, "removeBlockEntity");
    }
}

