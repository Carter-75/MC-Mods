/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2394
 *  net.minecraft.class_2396
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_5819
 *  net.minecraft.class_5945
 *  net.minecraft.class_9381
 */
package backported.updates.content.common.api;

import backported.updates.content.client.api.color.LeafColors;
import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBlockTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_5819;
import net.minecraft.class_5945;
import net.minecraft.class_9381;

@Environment(value=EnvType.CLIENT)
public class FallingLeavesModule {
    public void makeFallingLeavesParticles(class_1937 level, class_2338 pos, class_5819 random, class_2680 state, class_2338 offset) {
        if ((double)random.method_43057() < VanillaBackport.CLIENT_CONFIG.fallingLeavesFrequency.get() && !class_2248.method_9501((class_265)state.method_26220((class_1922)level, offset), (class_2350)class_2350.field_11036)) {
            this.spawnFallingLeavesParticle(level, pos, random);
        }
    }

    private void spawnFallingLeavesParticle(class_1937 level, class_2338 pos, class_5819 random) {
        class_2680 state = level.method_8320(pos);
        if (VanillaBackport.CLIENT_CONFIG.hasFallingLeaves.get().booleanValue()) {
            class_2396<class_9381> particle = null;
            if (state.method_26164(ModBlockTags.SPAWN_FALLING_LEAVES)) {
                particle = ModParticles.TINTED_LEAVES.get();
            } else if (state.method_26164(ModBlockTags.SPAWN_FALLING_NEEDLES)) {
                particle = ModParticles.TINTED_NEEDLES.get();
            }
            if (particle != null) {
                class_9381 option = class_9381.method_58256(particle, (int)LeafColors.getClientLeafTintColor(pos));
                class_5945.method_49099((class_1937)level, (class_2338)pos, (class_5819)random, (class_2394)option);
            }
        }
    }
}

