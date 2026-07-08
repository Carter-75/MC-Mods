/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1799
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2464
 *  net.minecraft.class_2586
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2753
 *  net.minecraft.class_2754
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3542
 *  net.minecraft.class_3610
 *  net.minecraft.class_3612
 *  net.minecraft.class_3726
 *  net.minecraft.class_3737
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5712
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_6880
 *  net.minecraft.class_9062
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block;

import backported.updates.copper.ModSounds;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.entity.CopperGolemEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2464;
import net.minecraft.class_2586;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2753;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3542;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5712;
import net.minecraft.class_5955;
import net.minecraft.class_6880;
import net.minecraft.class_9062;
import org.jetbrains.annotations.Nullable;

public class CopperGolemStatueBlock
extends class_2237
implements class_3737 {
    public static final class_2753 FACING = class_2741.field_12481;
    public static final class_2754<Pose> POSE = class_2754.method_11850((String)"pose", Pose.class);
    public static final class_2746 WATERLOGGED = class_2741.field_12508;
    private static final class_265 SHAPE = class_2248.method_9541((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)14.0, (double)13.0);
    private final class_5955.class_5811 weatheringState;

    public CopperGolemStatueBlock(class_5955.class_5811 weatheringState, class_4970.class_2251 properties) {
        super(properties);
        this.weatheringState = weatheringState;
        this.method_9590((class_2680)((class_2680)((class_2680)this.method_9564().method_11657((class_2769)FACING, (Comparable)class_2350.field_11043)).method_11657(POSE, (Comparable)((Object)Pose.STANDING))).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    public class_5955.class_5811 getWeatheringState() {
        return this.weatheringState;
    }

    protected MapCodec<? extends class_2237> method_53969() {
        return CopperGolemStatueBlock.method_54094(props -> new CopperGolemStatueBlock(this.weatheringState, (class_4970.class_2251)props));
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{FACING, POSE, WATERLOGGED});
    }

    public class_2680 method_9605(class_1750 context) {
        class_3610 fluidstate = context.method_8045().method_8316(context.method_8037());
        return (class_2680)((class_2680)this.method_9564().method_11657((class_2769)FACING, (Comparable)context.method_8042().method_10153())).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(fluidstate.method_15772() == class_3612.field_15910));
    }

    protected class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return SHAPE;
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        if (stack.method_7960()) {
            if (!level.method_8608()) {
                Pose currentPose = (Pose)((Object)state.method_11654(POSE));
                Pose nextPose = currentPose.getNextPose();
                level.method_8652(pos, (class_2680)state.method_11657(POSE, (Comparable)((Object)nextPose)), 3);
                level.method_8396(null, pos, ModSounds.COPPER_STATUE_HIT.get(), class_3419.field_15245, 1.0f, 1.0f);
                level.method_33596((class_1297)player, (class_6880)class_5712.field_28733, pos);
                level.method_8455(pos, (class_2248)this);
            }
            return class_9062.field_47728;
        }
        if (stack.method_31573(class_3489.field_42612) && !level.method_8608()) {
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
        return class_9062.field_47731;
    }

    protected class_2464 method_9604(class_2680 state) {
        return class_2464.field_11458;
    }

    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new CopperGolemStatueBlockEntity(pos, state);
    }

    protected class_3610 method_9545(class_2680 state) {
        return (Boolean)state.method_11654((class_2769)WATERLOGGED) != false ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
    }

    protected boolean method_9498(class_2680 state) {
        return true;
    }

    protected int method_9572(class_2680 state, class_1937 level, class_2338 pos) {
        return ((Pose)((Object)state.method_11654(POSE))).ordinal() + 1;
    }

    public static enum Pose implements class_3542
    {
        STANDING("standing"),
        RUNNING("running"),
        SITTING("sitting"),
        STAR("star");

        private final String name;

        private Pose(String name) {
            this.name = name;
        }

        public String method_15434() {
            return this.name;
        }

        public Pose getNextPose() {
            Pose[] poses = Pose.values();
            return poses[(this.ordinal() + 1) % poses.length];
        }
    }
}

