/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1661
 *  net.minecraft.class_1928
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_3222
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net._void.civilizations.mixin;

import net._void.civilizations.block.ModBlocks;
import net._void.civilizations.block.entity.TombstoneBlockEntity;
import net.minecraft.class_1282;
import net.minecraft.class_1661;
import net.minecraft.class_1928;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3222;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_3222.class})
public abstract class TombstoneMixin {
    @Inject(at={@At(value="HEAD")}, method={"onDeath"})
    private void onPlayerDeath(class_1282 source, CallbackInfo info) {
        class_3222 player = (class_3222)this;
        class_1661 inv = player.method_31548();
        class_2338 pos = player.method_24515();
        class_1937 world = player.method_37908();
        if (!world.method_8450().method_8355(class_1928.field_19389)) {
            class_2680 stateInBlock = world.method_8320(pos);
            class_2680 state = stateInBlock.method_27852(ModBlocks.TOMBSTONE) ? stateInBlock : ModBlocks.TOMBSTONE.method_9564();
            world.method_8501(pos, state);
            class_2586 blockEntity = world.method_8321(pos);
            if (blockEntity instanceof TombstoneBlockEntity) {
                TombstoneBlockEntity tombstoneBlockEntity = (TombstoneBlockEntity)blockEntity;
                for (int i = 0; i < inv.method_5439(); ++i) {
                    tombstoneBlockEntity.method_5447(i, inv.method_5438(i));
                }
                player.method_31548().method_5448();
            }
        }
    }
}

