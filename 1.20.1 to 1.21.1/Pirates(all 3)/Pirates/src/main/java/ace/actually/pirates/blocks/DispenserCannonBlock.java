/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_156
 *  net.minecraft.class_1676
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1922
 *  net.minecraft.class_1935
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2315
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2357
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_2601
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_3857
 *  net.minecraft.class_4970$class_2251
 */
package ace.actually.pirates.blocks;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.entities.shot.ShotEntity;
import ace.actually.pirates.util.CannonDispenserBehavior;
import net.minecraft.class_1299;
import net.minecraft.class_156;
import net.minecraft.class_1676;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_1935;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2315;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2357;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2601;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3857;
import net.minecraft.class_4970;

public class DispenserCannonBlock
extends class_2315 {
    public DispenserCannonBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    protected class_2357 method_10011(class_1799 stack) {
        if (stack.method_7909() == Pirates.CANNONBALL.get()) {
            return new CannonDispenserBehavior(){

                @Override
                protected class_1676 createProjectile(class_1937 world, class_2374 position, class_1799 stack) {
                    ShotEntity qentity = (ShotEntity)((Object)class_156.method_654((Object)((Object)new ShotEntity((class_1299<? extends class_3857>)((class_1299)Pirates.SHOT_ENTITY_TYPE.get()), world, null, (class_1792)Pirates.CANNONBALL_ENT.get(), 6.0f, "")), entity -> {}));
                    qentity.method_33574(new class_243(position.method_10216(), position.method_10214(), position.method_10215()));
                    return qentity;
                }
            };
        }
        if (stack.method_7909() == Pirates.FIRE_CANNONBALL.get()) {
            return new CannonDispenserBehavior(){

                @Override
                protected class_1676 createProjectile(class_1937 world, class_2374 position, class_1799 stack) {
                    ShotEntity qentity = (ShotEntity)((Object)class_156.method_654((Object)((Object)new ShotEntity((class_1299<? extends class_3857>)((class_1299)Pirates.SHOT_ENTITY_TYPE.get()), world, null, (class_1792)Pirates.CANNONBALL_ENT.get(), 3.0f, "fire")), entity -> {}));
                    qentity.method_33574(new class_243(position.method_10216(), position.method_10214(), position.method_10215()));
                    return qentity;
                }
            };
        }
        if (stack.method_7909() == Pirates.WEIGHTED_CANNONBALL.get()) {
            return new CannonDispenserBehavior(){

                @Override
                protected class_1676 createProjectile(class_1937 world, class_2374 position, class_1799 stack) {
                    ShotEntity qentity = (ShotEntity)((Object)class_156.method_654((Object)((Object)new ShotEntity((class_1299<? extends class_3857>)((class_1299)Pirates.SHOT_ENTITY_TYPE.get()), world, null, (class_1792)Pirates.CANNONBALL_ENT.get(), 3.0f, "heavy")), entity -> {}));
                    qentity.method_33574(new class_243(position.method_10216(), position.method_10214(), position.method_10215()));
                    return qentity;
                }
            };
        }
        return super.method_10011(stack);
    }

    public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
        if (!world.method_8320(pos.method_10081(((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10153().method_10163())).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get()) || world.method_8320(pos.method_10081(((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10153().method_10163())).method_11654((class_2769)class_2741.field_12525) != state.method_11654((class_2769)class_2741.field_12525)) {
            world.method_8652(pos, (class_2680)class_2246.field_10200.method_9564().method_11657((class_2769)class_2741.field_12525, (Comparable)((class_2350)state.method_11654((class_2769)field_10918))), 3);
        }
        return super.method_9559(state, direction, neighborState, world, pos, neighborPos);
    }

    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        class_2601 entity = new class_2601(pos, state);
        entity.method_17488(class_2561.method_30163((String)"Cannon"));
        return entity;
    }

    public void method_9612(class_2680 state, class_1937 world, class_2338 pos, class_2248 sourceBlock, class_2338 sourcePos, boolean notify) {
    }

    public class_1799 method_9574(class_1922 world, class_2338 pos, class_2680 state) {
        return new class_1799((class_1935)class_1802.field_8357);
    }
}

