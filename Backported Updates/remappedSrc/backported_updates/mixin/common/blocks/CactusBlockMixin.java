/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2266
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_2758
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.blocks;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.VanillaBackport;
import net.minecraft.class_2248;
import net.minecraft.class_2266;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2266.class})
public abstract class CactusBlockMixin
extends class_2248 {
    @Shadow
    @Final
    public static class_2758 field_10709;

    @Shadow
    protected abstract boolean method_9558(class_2680 var1, class_4538 var2, class_2338 var3);

    public CactusBlockMixin(class_4970.class_2251 properties) {
        super(properties);
    }

    @Inject(method={"randomTick"}, at={@At(value="HEAD")})
    private void vb$growCactusFlower(class_2680 state, class_3218 level, class_2338 pos, class_5819 random, CallbackInfo ci) {
        class_2338 above = pos.method_10084();
        if (VanillaBackport.COMMON_CONFIG.hasCactusFlowers.get().booleanValue() && level.method_22347(above)) {
            int height = 1;
            int age = (Integer)state.method_11654((class_2769)field_10709);
            while (level.method_8320(pos.method_10087(height)).method_27852((class_2248)class_2266.class.cast((Object)this))) {
                if (height++ != 3 || age != 15) continue;
                return;
            }
            if (age == 8 && this.method_9558(this.method_9564(), (class_4538)level, above)) {
                double flowerChance;
                double d = flowerChance = height >= 3 ? 0.25 : 0.1;
                if (random.method_43058() <= flowerChance) {
                    level.method_8501(above, ModBlocks.CACTUS_FLOWER.get().method_9564());
                }
            }
        }
    }
}

