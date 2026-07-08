/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2394
 *  net.minecraft.class_2397
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_5945
 */
package backported.updates.content.common.level.blocks;

import java.util.function.Supplier;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_2397;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_5945;

public class ParticleLeavesBlock
extends class_2397 {
    private final Supplier<? extends class_2394> particle;
    private final int chance;

    public ParticleLeavesBlock(int chance, Supplier<? extends class_2394> particle, class_4970.class_2251 properties) {
        super(properties);
        this.chance = chance;
        this.particle = particle;
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        class_2338 below;
        class_2680 belowState;
        super.method_9496(state, level, pos, random);
        if (random.method_43048(this.chance) == 0 && !ParticleLeavesBlock.method_9501((class_265)(belowState = level.method_8320(below = pos.method_10074())).method_26220((class_1922)level, below), (class_2350)class_2350.field_11036)) {
            class_5945.method_49099((class_1937)level, (class_2338)pos, (class_5819)random, (class_2394)this.particle.get());
        }
    }
}

