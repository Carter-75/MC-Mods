/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2464
 *  net.minecraft.class_2465
 *  net.minecraft.class_2470
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2754
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3419
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.blockentities.CreakingHeartBlockEntity;
import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import backported.updates.content.common.registries.ModBlockEntities;
import backported.updates.content.common.registries.ModBlockStateProperties;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.core.util.LevelUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2464;
import net.minecraft.class_2465;
import net.minecraft.class_2470;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3419;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import net.minecraft.class_5819;
import org.jetbrains.annotations.Nullable;

public class CreakingHeartBlock
extends class_2237 {
    public static final MapCodec<CreakingHeartBlock> CODEC = CreakingHeartBlock.method_54094(CreakingHeartBlock::new);
    public static final class_2754<class_2350.class_2351> AXIS = class_2741.field_12496;
    public static final class_2754<CreakingHeartState> STATE = ModBlockStateProperties.CREAKING_HEART_STATE;
    public static final class_2746 NATURAL = ModBlockStateProperties.NATURAL;

    protected MapCodec<? extends class_2237> method_53969() {
        return CODEC;
    }

    public CreakingHeartBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)((class_2680)((class_2680)this.method_9564().method_11657(AXIS, (Comparable)class_2350.class_2351.field_11052)).method_11657(STATE, (Comparable)((Object)CreakingHeartState.UPROOTED))).method_11657((class_2769)NATURAL, (Comparable)Boolean.valueOf(false)));
    }

    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new CreakingHeartBlockEntity(pos, state);
    }

    @Nullable
    public <T extends class_2586> class_5558<T> method_31645(class_1937 level, class_2680 state, class_2591<T> blockEntityType) {
        if (level.method_8608()) {
            return null;
        }
        return state.method_11654(STATE) != CreakingHeartState.UPROOTED ? CreakingHeartBlock.method_31618(blockEntityType, ModBlockEntities.CREAKING_HEART.get(), CreakingHeartBlockEntity::serverTick) : null;
    }

    public static boolean isNaturalNight(class_1937 level) {
        return LevelUtils.isMoonVisible(level);
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        if (CreakingHeartBlock.isNaturalNight(level) && state.method_11654(STATE) != CreakingHeartState.UPROOTED && random.method_43048(16) == 0 && CreakingHeartBlock.isSurroundedByLogs((class_1936)level, pos)) {
            level.method_8486((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), ModSoundEvents.CREAKING_HEART_IDLE.get(), class_3419.field_15245, 1.0f, 1.0f, false);
        }
    }

    public class_2464 method_9604(class_2680 state) {
        return class_2464.field_11458;
    }

    public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 level, class_2338 pos, class_2338 neighborPos) {
        level.method_39279(pos, (class_2248)this, 1);
        return super.method_9559(state, direction, neighborState, level, pos, neighborPos);
    }

    public void method_9588(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        class_2680 updatedState = CreakingHeartBlock.updateState(state, (class_1937)level, pos);
        if (updatedState != state) {
            level.method_8652(pos, updatedState, 3);
        }
    }

    private static class_2680 updateState(class_2680 state, class_1937 level, class_2338 pos) {
        boolean isUprooted;
        boolean hasRequiredLogs = CreakingHeartBlock.hasRequiredLogs(state, (class_4538)level, pos);
        boolean bl = isUprooted = state.method_11654(STATE) == CreakingHeartState.UPROOTED;
        return hasRequiredLogs && isUprooted ? (class_2680)state.method_11657(STATE, (Comparable)((Object)(CreakingHeartBlock.isNaturalNight(level) ? CreakingHeartState.AWAKE : CreakingHeartState.DORMANT))) : state;
    }

    public static boolean hasRequiredLogs(class_2680 state, class_4538 level, class_2338 pos) {
        class_2350.class_2351 axis = (class_2350.class_2351)state.method_11654(AXIS);
        for (class_2350 direction : CreakingHeartBlock.directions(axis)) {
            class_2338 neighborPos = pos.method_10093(direction);
            class_2680 neighborState = level.method_8320(neighborPos);
            if (!neighborState.method_26164(ModBlockTags.CREAKING_HEART_HOLDERS)) {
                return false;
            }
            if (!neighborState.method_28498(AXIS) || neighborState.method_11654(AXIS) == axis) continue;
            return false;
        }
        return true;
    }

    private static class_2350[] directions(class_2350.class_2351 axis) {
        class_2350[] class_2350Array;
        switch (axis) {
            default: {
                throw new MatchException(null, null);
            }
            case field_11048: {
                class_2350[] class_2350Array2 = new class_2350[2];
                class_2350Array2[0] = class_2350.field_11043;
                class_2350Array = class_2350Array2;
                class_2350Array2[1] = class_2350.field_11035;
                break;
            }
            case field_11052: {
                class_2350[] class_2350Array3 = new class_2350[2];
                class_2350Array3[0] = class_2350.field_11036;
                class_2350Array = class_2350Array3;
                class_2350Array3[1] = class_2350.field_11033;
                break;
            }
            case field_11051: {
                class_2350[] class_2350Array4 = new class_2350[2];
                class_2350Array4[0] = class_2350.field_11034;
                class_2350Array = class_2350Array4;
                class_2350Array4[1] = class_2350.field_11039;
            }
        }
        return class_2350Array;
    }

    private static boolean isSurroundedByLogs(class_1936 level, class_2338 pos) {
        for (class_2350 direction : class_2350.values()) {
            class_2338 neighborPos = pos.method_10093(direction);
            class_2680 neighborState = level.method_8320(neighborPos);
            if (neighborState.method_26164(ModBlockTags.CREAKING_HEART_HOLDERS)) continue;
            return false;
        }
        return true;
    }

    @Nullable
    public class_2680 method_9605(class_1750 context) {
        return CreakingHeartBlock.updateState((class_2680)this.method_9564().method_11657(AXIS, (Comparable)context.method_8038().method_10166()), context.method_8045(), context.method_8037());
    }

    public class_2680 method_9598(class_2680 state, class_2470 rotation) {
        return class_2465.method_36377((class_2680)state, (class_2470)rotation);
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{AXIS, STATE, NATURAL});
    }

    public class_2680 method_9576(class_1937 level, class_2338 pos, class_2680 state, class_1657 player) {
        class_2586 class_25862 = level.method_8321(pos);
        if (class_25862 instanceof CreakingHeartBlockEntity) {
            CreakingHeartBlockEntity heart = (CreakingHeartBlockEntity)class_25862;
            heart.removeProtector(player.method_48923().method_48802(player));
            this.tryAwardExperience(player, state, level, pos);
        }
        return super.method_9576(level, pos, state, player);
    }

    private void tryAwardExperience(class_1657 player, class_2680 state, class_1937 level, class_2338 pos) {
        if (!player.method_31549().field_7477 && !player.method_7325() && ((Boolean)state.method_11654((class_2769)NATURAL)).booleanValue() && level instanceof class_3218) {
            class_3218 server = (class_3218)level;
            this.method_9583(server, pos, level.field_9229.method_39332(20, 24));
        }
    }

    public boolean method_9498(class_2680 state) {
        return true;
    }

    public int method_9572(class_2680 state, class_1937 level, class_2338 pos) {
        int n;
        if (state.method_11654(STATE) == CreakingHeartState.UPROOTED) {
            return 0;
        }
        class_2586 class_25862 = level.method_8321(pos);
        if (class_25862 instanceof CreakingHeartBlockEntity) {
            CreakingHeartBlockEntity heart = (CreakingHeartBlockEntity)class_25862;
            n = heart.getAnalogOutputSignal();
        } else {
            n = 0;
        }
        return n;
    }
}

