/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2353
 *  net.minecraft.class_2465
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_2944
 *  net.minecraft.class_3031
 *  net.minecraft.class_3746
 *  net.minecraft.class_4662
 *  net.minecraft.class_4662$class_7402
 *  net.minecraft.class_5281
 *  net.minecraft.class_5819
 *  net.minecraft.class_5821
 */
package backported.updates.content.common.level.features;

import backported.updates.content.common.level.features.FallenTreeConfiguration;
import com.mojang.serialization.Codec;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2465;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2944;
import net.minecraft.class_3031;
import net.minecraft.class_3746;
import net.minecraft.class_4662;
import net.minecraft.class_5281;
import net.minecraft.class_5819;
import net.minecraft.class_5821;

public class FallenTreeFeature
extends class_3031<FallenTreeConfiguration> {
    public FallenTreeFeature(Codec<FallenTreeConfiguration> codec) {
        super(codec);
    }

    public boolean method_13151(class_5821<FallenTreeConfiguration> context) {
        this.placeFallenTree((FallenTreeConfiguration)context.method_33656(), context.method_33655(), context.method_33652(), context.method_33654());
        return true;
    }

    private void placeFallenTree(FallenTreeConfiguration config, class_2338 pos, class_5281 level, class_5819 random) {
        this.placeStump(config, level, random, pos.method_25503());
        class_2350 direction = class_2350.class_2353.field_11062.method_10183(random);
        int length = config.logLength.method_35008(random) - 2;
        class_2338.class_2339 mutable = pos.method_10079(direction, 2 + random.method_43048(2)).method_25503();
        this.setGroundHeightForFallenLogStartPos(level, mutable);
        if (this.canPlaceEntireFallenLog(level, length, mutable, direction)) {
            this.placeFallenLog(config, level, random, length, mutable, direction);
        }
    }

    private void setGroundHeightForFallenLogStartPos(class_5281 level, class_2338.class_2339 mutable) {
        mutable.method_10104(class_2350.field_11036, 1);
        for (int i = 0; i < 6; ++i) {
            if (this.mayPlaceOn((class_1936)level, (class_2338)mutable)) {
                return;
            }
            mutable.method_10098(class_2350.field_11033);
        }
    }

    private void placeStump(FallenTreeConfiguration config, class_5281 level, class_5819 random, class_2338.class_2339 mutable) {
        class_2338 origin = this.placeLogBlock(config, level, random, mutable, Function.identity());
        this.decorateLogs(level, random, Set.of(origin), config.stumpDecorators);
    }

    private boolean canPlaceEntireFallenLog(class_5281 level, int length, class_2338.class_2339 mutable, class_2350 direction) {
        int gaps = 0;
        for (int k = 0; k < length; ++k) {
            if (!class_2944.method_27371((class_3746)level, (class_2338)mutable)) {
                return false;
            }
            if (!this.isOverSolidGround((class_1936)level, (class_2338)mutable)) {
                if (gaps++ > 2) {
                    return false;
                }
            } else {
                gaps = 0;
            }
            mutable.method_10098(direction);
        }
        mutable.method_10104(direction.method_10153(), length);
        return true;
    }

    private void placeFallenLog(FallenTreeConfiguration config, class_5281 level, class_5819 random, int length, class_2338.class_2339 mutable, class_2350 direction) {
        HashSet<class_2338> positions = new HashSet<class_2338>();
        for (int i = 0; i < length; ++i) {
            positions.add(this.placeLogBlock(config, level, random, mutable, FallenTreeFeature.getSidewaysStateModifier(direction)));
            mutable.method_10098(direction);
        }
        this.decorateLogs(level, random, positions, config.logDecorators);
    }

    private boolean mayPlaceOn(class_1936 level, class_2338 pos) {
        return class_2944.method_27371((class_3746)level, (class_2338)pos) && this.isOverSolidGround(level, pos);
    }

    private boolean isOverSolidGround(class_1936 level, class_2338 pos) {
        return level.method_8320(pos.method_10074()).method_26206((class_1922)level, pos, class_2350.field_11036);
    }

    private class_2338 placeLogBlock(FallenTreeConfiguration config, class_5281 level, class_5819 random, class_2338.class_2339 mutable, Function<class_2680, class_2680> factory) {
        level.method_8652((class_2338)mutable, factory.apply(config.trunkProvider.method_23455(random, (class_2338)mutable)), 3);
        this.method_37256(level, (class_2338)mutable);
        return mutable.method_10062();
    }

    private void decorateLogs(class_5281 level, class_5819 random, Set<class_2338> positions, List<class_4662> decorators) {
        if (!decorators.isEmpty()) {
            class_4662.class_7402 context = new class_4662.class_7402((class_3746)level, this.getDecorationSetter(level), random, positions, Set.of(), Set.of());
            decorators.forEach(decorator -> decorator.method_23469(context));
        }
    }

    private BiConsumer<class_2338, class_2680> getDecorationSetter(class_5281 level) {
        return (pos, state) -> level.method_8652(pos, state, 19);
    }

    private static Function<class_2680, class_2680> getSidewaysStateModifier(class_2350 direction) {
        return state -> (class_2680)state.method_47968((class_2769)class_2465.field_11459, (Comparable)direction.method_10166());
    }
}

