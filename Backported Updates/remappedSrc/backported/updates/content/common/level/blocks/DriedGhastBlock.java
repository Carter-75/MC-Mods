/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_10
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1750
 *  net.minecraft.class_1799
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2383
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2758
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3419
 *  net.minecraft.class_3486
 *  net.minecraft.class_3610
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3726
 *  net.minecraft.class_3737
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5712
 *  net.minecraft.class_5712$class_7397
 *  net.minecraft.class_5819
 *  net.minecraft.class_6880
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import backported.updates.content.common.registries.ModBlockStateProperties;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.core.data.tags.ModBlockTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_10;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2383;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3419;
import net.minecraft.class_3486;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5712;
import net.minecraft.class_5819;
import net.minecraft.class_6880;
import org.jetbrains.annotations.Nullable;

public class DriedGhastBlock
extends class_2383
implements class_3737 {
    public static final MapCodec<DriedGhastBlock> CODEC = DriedGhastBlock.method_54094(DriedGhastBlock::new);
    public static final int MAX_HYDRATION_LEVEL = 3;
    public static final class_2758 HYDRATION_LEVEL = ModBlockStateProperties.HYDRATION_LEVEL;
    public static final class_2746 WATERLOGGED = class_2741.field_12508;
    public static final int HYDRATION_TICK_DELAY = 5000;
    private static final class_265 SHAPE = class_2248.method_9541((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)10.0, (double)13.0);

    public MapCodec<DriedGhastBlock> method_53969() {
        return CODEC;
    }

    public DriedGhastBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)((class_2680)((class_2680)((class_2680)this.method_9595().method_11664()).method_11657((class_2769)field_11177, (Comparable)class_2350.field_11043)).method_11657((class_2769)HYDRATION_LEVEL, (Comparable)Integer.valueOf(0))).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{field_11177, HYDRATION_LEVEL, WATERLOGGED});
    }

    public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 level, class_2338 pos, class_2338 neighborPos) {
        if (((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue()) {
            level.method_39281(pos, (class_3611)class_3612.field_15910, class_3612.field_15910.method_15789((class_4538)level));
        }
        return super.method_9559(state, direction, neighborState, level, pos, neighborPos);
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return SHAPE;
    }

    public int getHydrationLevel(class_2680 state) {
        return (Integer)state.method_11654((class_2769)HYDRATION_LEVEL);
    }

    private boolean isReadyToSpawn(class_2680 state) {
        return this.getHydrationLevel(state) == 3;
    }

    public void method_9588(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        if (((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue()) {
            this.tickWaterlogged(state, level, pos, random);
        } else {
            int hydrationLevel = this.getHydrationLevel(state);
            if (hydrationLevel > 0) {
                level.method_8652(pos, (class_2680)state.method_11657((class_2769)HYDRATION_LEVEL, (Comparable)Integer.valueOf(hydrationLevel - 1)), 2);
                level.method_43276((class_6880)class_5712.field_28733, pos, class_5712.class_7397.method_43287((class_2680)state));
            }
        }
    }

    private void tickWaterlogged(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        if (!this.isReadyToSpawn(state)) {
            level.method_8396(null, pos, ModSoundEvents.DRIED_GHAST_TRANSITION.get(), class_3419.field_15245, 1.0f, 1.0f);
            level.method_8652(pos, (class_2680)state.method_11657((class_2769)HYDRATION_LEVEL, (Comparable)Integer.valueOf(this.getHydrationLevel(state) + 1)), 2);
            level.method_43276((class_6880)class_5712.field_28733, pos, class_5712.class_7397.method_43287((class_2680)state));
        } else {
            this.spawnGhastling(level, pos, state);
        }
    }

    private void spawnGhastling(class_3218 level, class_2338 pos, class_2680 state) {
        level.method_8650(pos, false);
        HappyGhast ghast = (HappyGhast)ModEntities.HAPPY_GHAST.get().method_5883((class_1937)level);
        if (ghast != null) {
            class_243 center = class_243.method_24955((class_2382)pos);
            ghast.method_7217(true);
            float yRot = DriedGhastBlock.getYRot((class_2350)state.method_11654((class_2769)field_11177));
            ghast.method_5847(yRot);
            ghast.method_23327(center.method_10216(), center.method_10214(), center.method_10215());
            ghast.method_36456(yRot);
            ghast.method_36457(0.0f);
            ghast.method_22862();
            ghast.method_5814(ghast.method_19538().method_10216(), ghast.method_19538().method_10214(), ghast.method_19538().method_10215());
            level.method_8649((class_1297)ghast);
            level.method_43129(null, (class_1297)ghast, ModSoundEvents.GHASTLING_SPAWN.get(), class_3419.field_15245, 1.0f, 1.0f);
        }
    }

    public static float getYRot(class_2350 direction) {
        return switch (direction) {
            case class_2350.field_11043 -> 180.0f;
            case class_2350.field_11035 -> 0.0f;
            case class_2350.field_11039 -> 90.0f;
            case class_2350.field_11034 -> -90.0f;
            default -> throw new IllegalStateException("No y-Rot for vertical axis: " + String.valueOf(direction));
        };
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        double x = (double)pos.method_10263() + 0.5;
        double y = (double)pos.method_10264() + 0.5;
        double z = (double)pos.method_10260() + 0.5;
        if (!((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue()) {
            if (random.method_43048(40) == 0 && level.method_8320(pos.method_10074()).method_26164(ModBlockTags.TRIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS)) {
                level.method_8486(x, y, z, ModSoundEvents.DRIED_GHAST_AMBIENT.get(), class_3419.field_15256, 1.0f, 1.0f, false);
            }
            if (random.method_43048(6) == 0) {
                level.method_8406((class_2394)class_2398.field_11251, x, y, z, 0.0, 0.02, 0.0);
            }
        } else {
            if (random.method_43048(40) == 0) {
                level.method_8486(x, y, z, ModSoundEvents.DRIED_GHAST_AMBIENT_WATER.get(), class_3419.field_15256, 1.0f, 1.0f, false);
            }
            if (random.method_43048(6) == 0) {
                level.method_8406((class_2394)class_2398.field_11211, x + (double)((random.method_43057() * 2.0f - 1.0f) / 3.0f), y + 0.4, z + (double)((random.method_43057() * 2.0f - 1.0f) / 3.0f), 0.0, (double)random.method_43057(), 0.0);
            }
        }
    }

    public void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        if ((((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue() || (Integer)state.method_11654((class_2769)HYDRATION_LEVEL) > 0) && !level.method_14196().method_8674(pos, (Object)this)) {
            level.method_39279(pos, (class_2248)this, 5000);
        }
    }

    @Nullable
    public class_2680 method_9605(class_1750 context) {
        class_3610 state = context.method_8045().method_8316(context.method_8037());
        boolean isWaterlogged = state.method_15767(class_3486.field_15517) && state.method_15761() == 8;
        return (class_2680)((class_2680)super.method_9605(context).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(isWaterlogged))).method_11657((class_2769)field_11177, (Comparable)context.method_8042().method_10153());
    }

    public class_3610 method_9545(class_2680 state) {
        return (Boolean)state.method_11654((class_2769)WATERLOGGED) != false ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
    }

    public boolean method_10311(class_1936 level, class_2338 pos, class_2680 state, class_3610 fluidState) {
        if (((Boolean)state.method_11654((class_2769)class_2741.field_12508)).booleanValue() || fluidState.method_15772() != class_3612.field_15910) {
            return false;
        }
        if (!level.method_8608()) {
            level.method_8652(pos, (class_2680)state.method_11657((class_2769)class_2741.field_12508, (Comparable)Boolean.valueOf(true)), 3);
            level.method_39281(pos, fluidState.method_15772(), fluidState.method_15772().method_15789((class_4538)level));
            level.method_8396(null, pos, ModSoundEvents.DRIED_GHAST_PLACE_IN_WATER.get(), class_3419.field_15245, 1.0f, 1.0f);
        }
        return true;
    }

    public void method_9567(class_1937 level, class_2338 pos, class_2680 state, @Nullable class_1309 placer, class_1799 stack) {
        super.method_9567(level, pos, state, placer, stack);
        level.method_8396(null, pos, (Boolean)state.method_11654((class_2769)WATERLOGGED) != false ? ModSoundEvents.DRIED_GHAST_PLACE_IN_WATER.get() : ModSoundEvents.DRIED_GHAST_PLACE.get(), class_3419.field_15245, 1.0f, 1.0f);
    }

    protected boolean method_9516(class_2680 state, class_10 pathComputationType) {
        return false;
    }
}

