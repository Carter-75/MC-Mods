/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5712
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_6880
 *  net.minecraft.class_9062
 */
package backported.updates.copper.block;

import backported.updates.copper.ModSounds;
import backported.updates.copper.block.CopperGolemStatueBlock;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.registry.ModBlocks;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5712;
import net.minecraft.class_5955;
import net.minecraft.class_6880;
import net.minecraft.class_9062;

public class WaxedCopperGolemStatueBlock
extends CopperGolemStatueBlock {
    public static final MapCodec<WaxedCopperGolemStatueBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)class_5955.class_5811.field_46493.fieldOf("weathering_state").forGetter(CopperGolemStatueBlock::getWeatheringState), (App)WaxedCopperGolemStatueBlock.method_54096()).apply((Applicative)instance, WaxedCopperGolemStatueBlock::new));

    public WaxedCopperGolemStatueBlock(class_5955.class_5811 weatheringState, class_4970.class_2251 properties) {
        super(weatheringState, properties);
    }

    protected MapCodec<? extends WaxedCopperGolemStatueBlock> method_53969() {
        return CODEC;
    }

    public static Optional<class_2248> getUnwaxedBlock(class_2248 block) {
        if (block == ModBlocks.WAXED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((class_2248)ModBlocks.COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.WAXED_EXPOSED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.WAXED_WEATHERED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get());
        }
        if (block == ModBlocks.WAXED_OXIDIZED_COPPER_GOLEM_STATUE.get()) {
            return Optional.of((class_2248)ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get());
        }
        return Optional.empty();
    }

    @Override
    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        if (stack.method_7960()) {
            if (!level.method_8608()) {
                CopperGolemStatueBlock.Pose currentPose = (CopperGolemStatueBlock.Pose)((Object)state.method_11654((class_2769)POSE));
                CopperGolemStatueBlock.Pose nextPose = currentPose.getNextPose();
                level.method_8652(pos, (class_2680)state.method_11657((class_2769)POSE, (Comparable)((Object)nextPose)), 3);
                level.method_8396(null, pos, ModSounds.COPPER_STATUE_HIT.get(), class_3419.field_15245, 1.0f, 1.0f);
                level.method_33596((class_1297)player, (class_6880)class_5712.field_28733, pos);
            }
            return class_9062.field_47728;
        }
        if (stack.method_31573(class_3489.field_42612)) {
            Optional<class_2248> unwaxedBlock = WaxedCopperGolemStatueBlock.getUnwaxedBlock(state.method_26204());
            if (unwaxedBlock.isPresent()) {
                level.method_8396(player, pos, class_3417.field_29542, class_3419.field_15245, 1.0f, 1.0f);
                level.method_8444(player, 3004, pos, 0);
                if (!level.field_9236) {
                    class_2680 newState = (class_2680)((class_2680)((class_2680)unwaxedBlock.get().method_9564().method_11657((class_2769)FACING, (Comparable)((class_2350)state.method_11654((class_2769)FACING)))).method_11657((class_2769)POSE, (Comparable)((Object)((CopperGolemStatueBlock.Pose)((Object)state.method_11654((class_2769)POSE)))))).method_11657((class_2769)WATERLOGGED, (Comparable)((Boolean)state.method_11654((class_2769)WATERLOGGED)));
                    level.method_8652(pos, newState, 3);
                    if (!player.method_7337()) {
                        stack.method_7970(1, (class_1309)player, player.method_32326(stack));
                    }
                }
                return class_9062.field_47728;
            }
            if (!level.method_8608()) {
                CopperGolemStatueBlockEntity statueEntity;
                CopperGolemEntity golem;
                class_3218 serverLevel = (class_3218)level;
                class_2586 class_25862 = level.method_8321(pos);
                if (class_25862 instanceof CopperGolemStatueBlockEntity && (golem = (statueEntity = (CopperGolemStatueBlockEntity)class_25862).removeStatue(state, serverLevel)) != null) {
                    level.method_8650(pos, false);
                    serverLevel.method_8649((class_1297)golem);
                    level.method_8396(null, pos, ModSounds.COPPER_STATUE_BREAK.get(), class_3419.field_15245, 1.0f, 1.0f);
                    level.method_8444(null, 3005, pos, 0);
                    level.method_33596((class_1297)player, (class_6880)class_5712.field_28165, pos);
                    stack.method_7970(1, (class_1309)player, player.method_32326(stack));
                    return class_9062.field_47728;
                }
            }
        }
        return class_9062.field_47731;
    }

    protected boolean method_9542(class_2680 state) {
        return false;
    }
}

