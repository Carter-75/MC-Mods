/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2555
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 */
package backported.updates.copper.block;

import backported.updates.copper.registry.ModParticles;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2555;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class CopperWallTorchBlock
extends class_2555 {
    public CopperWallTorchBlock(class_4970.class_2251 properties) {
        super(class_2398.field_11240, properties);
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        class_2350 direction = (class_2350)state.method_11654((class_2769)field_11731);
        double x = (double)pos.method_10263() + 0.5;
        double y = (double)pos.method_10264() + 0.7;
        double z = (double)pos.method_10260() + 0.5;
        double offsetX = 0.27;
        double offsetY = 0.22;
        class_2350 direction1 = direction.method_10153();
        level.method_8406((class_2394)class_2398.field_11251, x + offsetX * (double)direction1.method_10148(), y + offsetY, z + offsetX * (double)direction1.method_10165(), 0.0, 0.0, 0.0);
        level.method_8406((class_2394)ModParticles.COPPER_FIRE_FLAME.get(), x + offsetX * (double)direction1.method_10148(), y + offsetY, z + offsetX * (double)direction1.method_10165(), 0.0, 0.0, 0.0);
    }
}

