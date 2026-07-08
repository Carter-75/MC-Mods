/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1309
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2464
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import backported.updates.garden.entity.CreakingBlockEntityTypes;
import backported.updates.garden.entity.CreakingHeartBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2464;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import org.jetbrains.annotations.Nullable;

public class CreakingHeartBlock
extends class_2237 {
    public static class_2746 ACTIVATED = class_2746.method_11825((String)"activated");

    public CreakingHeartBlock(class_4970.class_2251 settings) {
        super(settings);
        this.method_9590((class_2680)((class_2680)this.field_10647.method_11664()).method_11657((class_2769)ACTIVATED, (Comparable)Boolean.valueOf(true)));
    }

    protected MapCodec<? extends class_2237> method_53969() {
        return CreakingHeartBlock.method_54094(CreakingHeartBlock::new);
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{ACTIVATED});
    }

    protected class_2464 method_9604(class_2680 state) {
        return class_2464.field_11458;
    }

    public void method_9615(class_2680 state, class_1937 world, class_2338 pos, class_2680 oldState, boolean notify) {
        super.method_9615(state, world, pos, oldState, notify);
        this.updateActivationState(world, pos, state);
    }

    public void method_9612(class_2680 state, class_1937 world, class_2338 pos, class_2248 block, class_2338 fromPos, boolean notify) {
        super.method_9612(state, world, pos, block, fromPos, notify);
        this.updateActivationState(world, pos, state);
    }

    private void updateActivationState(class_1937 world, class_2338 pos, class_2680 state) {
        boolean isActivated = world.method_8320(pos.method_10084()).method_27852(Init.PALE_OAK_LOG) && world.method_8320(pos.method_10074()).method_27852(Init.PALE_OAK_LOG);
        world.method_8652(pos, (class_2680)state.method_11657((class_2769)ACTIVATED, (Comparable)Boolean.valueOf(isActivated)), 3);
    }

    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new CreakingHeartBlockEntity(CreakingBlockEntityTypes.CREAKING_HEART_BLOCK, pos, state);
    }

    public void method_9567(class_1937 world, class_2338 pos, class_2680 state, @Nullable class_1309 placer, class_1799 itemStack) {
        this.method_9612(state, world, pos, this.method_26160(), pos, true);
    }

    protected boolean method_9498(class_2680 state) {
        return true;
    }

    protected int method_9572(class_2680 state, class_1937 world, class_2338 pos) {
        class_2586 blockEntity = world.method_8321(pos);
        if (blockEntity != null) {
            CreakingHeartBlockEntity creakingHeartBlock = (CreakingHeartBlockEntity)blockEntity;
            if (creakingHeartBlock.creakingEntity != null) {
                class_2338 pos1 = creakingHeartBlock.creakingEntity.method_24515();
                class_2338 pos2 = pos;
                int distance = (int)Math.sqrt(Math.pow(pos1.method_10263() - pos2.method_10263(), 2.0) + Math.pow(pos1.method_10264() - pos2.method_10264(), 2.0) + Math.pow(pos1.method_10260() - pos2.method_10260(), 2.0));
                int powerResult = 15 - distance;
                return powerResult < 0 ? 0 : powerResult;
            }
        }
        return 0;
    }

    public <T extends class_2586> class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
        return CreakingHeartBlock.method_31618(type, CreakingBlockEntityTypes.CREAKING_HEART_BLOCK, CreakingHeartBlockEntity::tick);
    }
}

