/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2527
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 */
package backported.updates.copper.block;

import backported.updates.copper.registry.ModParticles;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2527;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class CopperTorchBlock
extends class_2527 {
    public CopperTorchBlock(class_4970.class_2251 properties) {
        super(class_2398.field_11240, properties);
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        double x = (double)pos.method_10263() + 0.5;
        double y = (double)pos.method_10264() + 0.7;
        double z = (double)pos.method_10260() + 0.5;
        level.method_8406((class_2394)class_2398.field_11251, x, y, z, 0.0, 0.0, 0.0);
        level.method_8406((class_2394)ModParticles.COPPER_FIRE_FLAME.get(), x, y, z, 0.0, 0.0, 0.0);
    }
}

