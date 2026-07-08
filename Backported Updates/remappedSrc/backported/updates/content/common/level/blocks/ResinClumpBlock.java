/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_3610
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3737
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5778
 *  net.minecraft.class_7118
 *  net.minecraft.class_7118$class_7120
 *  net.minecraft.class_7118$class_7121
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3737;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5778;
import net.minecraft.class_7118;
import org.jetbrains.annotations.Nullable;

public class ResinClumpBlock
extends class_5778
implements class_3737 {
    public static final MapCodec<ResinClumpBlock> CODEC = ResinClumpBlock.method_54094(ResinClumpBlock::new);
    private static final class_2746 WATERLOGGED = class_2741.field_12508;

    protected MapCodec<? extends class_5778> method_53969() {
        return CODEC;
    }

    public ResinClumpBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)this.method_9564().method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        super.method_9515(builder);
        builder.method_11667(new class_2769[]{WATERLOGGED});
    }

    public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 level, class_2338 pos, class_2338 neighborPos) {
        if (((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue()) {
            level.method_39281(pos, (class_3611)class_3612.field_15910, class_3612.field_15910.method_15789((class_4538)level));
        }
        return super.method_9559(state, direction, neighborState, level, pos, neighborPos);
    }

    public class_3610 method_9545(class_2680 state) {
        return (Boolean)state.method_11654((class_2769)WATERLOGGED) != false ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
    }

    public class_7118 method_41432() {
        return new class_7118((class_7118.class_7120)new NoOpSpreadConfig());
    }

    private static class NoOpSpreadConfig
    implements class_7118.class_7120 {
        private NoOpSpreadConfig() {
        }

        @Nullable
        public class_2680 method_41459(class_2680 currentState, class_1922 level, class_2338 pos, class_2350 lookingDirection) {
            return null;
        }

        public boolean method_41457(class_1922 level, class_2338 pos, class_7118.class_7121 spreadPos) {
            return false;
        }
    }
}

