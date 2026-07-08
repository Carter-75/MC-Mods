/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1264
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2343
 *  net.minecraft.class_2464
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3726
 *  net.minecraft.class_3908
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.block.custom;

import net._void.civilizations.block.entity.ModBlockEntities;
import net._void.civilizations.block.entity.TradingStationBlockEntity;
import net.minecraft.class_1263;
import net.minecraft.class_1264;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2464;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_3908;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import org.jetbrains.annotations.Nullable;

public class TradingStationBlock
extends class_2237
implements class_2343 {
    private static final class_265 SHAPE = class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)12.0, (double)16.0);

    public TradingStationBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
        return SHAPE;
    }

    public class_2464 method_9604(class_2680 state) {
        return class_2464.field_11458;
    }

    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new TradingStationBlockEntity(pos, state);
    }

    public void method_9536(class_2680 state, class_1937 world, class_2338 pos, class_2680 newState, boolean moved) {
        if (state.method_26204() != newState.method_26204()) {
            class_2586 blockEntity = world.method_8321(pos);
            if (blockEntity instanceof TradingStationBlockEntity) {
                class_1264.method_5451((class_1937)world, (class_2338)pos, (class_1263)((TradingStationBlockEntity)blockEntity));
                world.method_8455(pos, (class_2248)this);
            }
            super.method_9536(state, world, pos, newState, moved);
        }
    }

    public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
        TradingStationBlockEntity screenHandlerFactory;
        if (!world.field_9236 && (screenHandlerFactory = (TradingStationBlockEntity)world.method_8321(pos)) != null) {
            player.method_17355((class_3908)screenHandlerFactory);
        }
        return class_1269.field_5812;
    }

    @Nullable
    public <T extends class_2586> class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
        return TradingStationBlock.method_31618(type, ModBlockEntities.TRADING_STATION_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}

